package io.intercom.okhttp3.internal.cache;

import io.intercom.okhttp3.CacheControl;
import io.intercom.okhttp3.Headers;
import io.intercom.okhttp3.Request;
import io.intercom.okhttp3.Response;
import io.intercom.okhttp3.Response.Builder;
import io.intercom.okhttp3.internal.Internal;
import io.intercom.okhttp3.internal.http.HttpDate;
import io.intercom.okhttp3.internal.http.HttpHeaders;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public final class CacheStrategy {
    public final Response cacheResponse;
    public final Request networkRequest;

    public static class Factory {
        private int ageSeconds = -1;
        final Response cacheResponse;
        private String etag;
        private Date expires;
        private Date lastModified;
        private String lastModifiedString;
        final long nowMillis;
        private long receivedResponseMillis;
        final Request request;
        private long sentRequestMillis;
        private Date servedDate;
        private String servedDateString;

        public Factory(long j2, Request request2, Response response) {
            this.nowMillis = j2;
            this.request = request2;
            this.cacheResponse = response;
            if (response != null) {
                this.sentRequestMillis = response.sentRequestAtMillis();
                this.receivedResponseMillis = response.receivedResponseAtMillis();
                Headers headers = response.headers();
                int size = headers.size();
                for (int i2 = 0; i2 < size; i2++) {
                    String name = headers.name(i2);
                    String value = headers.value(i2);
                    if ("Date".equalsIgnoreCase(name)) {
                        this.servedDate = HttpDate.parse(value);
                        this.servedDateString = value;
                    } else if ("Expires".equalsIgnoreCase(name)) {
                        this.expires = HttpDate.parse(value);
                    } else if ("Last-Modified".equalsIgnoreCase(name)) {
                        this.lastModified = HttpDate.parse(value);
                        this.lastModifiedString = value;
                    } else if ("ETag".equalsIgnoreCase(name)) {
                        this.etag = value;
                    } else if ("Age".equalsIgnoreCase(name)) {
                        this.ageSeconds = HttpHeaders.parseSeconds(value, -1);
                    }
                }
            }
        }

        private long cacheResponseAge() {
            Date date = this.servedDate;
            long j2 = 0;
            if (date != null) {
                j2 = Math.max(0, this.receivedResponseMillis - date.getTime());
            }
            int i2 = this.ageSeconds;
            if (i2 != -1) {
                j2 = Math.max(j2, TimeUnit.SECONDS.toMillis((long) i2));
            }
            long j3 = this.receivedResponseMillis;
            return j2 + (j3 - this.sentRequestMillis) + (this.nowMillis - j3);
        }

        private long computeFreshnessLifetime() {
            long j2;
            long j3;
            CacheControl cacheControl = this.cacheResponse.cacheControl();
            if (cacheControl.maxAgeSeconds() != -1) {
                return TimeUnit.SECONDS.toMillis((long) cacheControl.maxAgeSeconds());
            }
            long j4 = 0;
            if (this.expires != null) {
                Date date = this.servedDate;
                if (date != null) {
                    j3 = date.getTime();
                } else {
                    j3 = this.receivedResponseMillis;
                }
                long time = this.expires.getTime() - j3;
                if (time > 0) {
                    j4 = time;
                }
                return j4;
            }
            if (this.lastModified != null && this.cacheResponse.request().url().query() == null) {
                Date date2 = this.servedDate;
                if (date2 != null) {
                    j2 = date2.getTime();
                } else {
                    j2 = this.sentRequestMillis;
                }
                long time2 = j2 - this.lastModified.getTime();
                if (time2 > 0) {
                    j4 = time2 / 10;
                }
            }
            return j4;
        }

        private CacheStrategy getCandidate() {
            if (this.cacheResponse == null) {
                return new CacheStrategy(this.request, null);
            }
            if (this.request.isHttps() && this.cacheResponse.handshake() == null) {
                return new CacheStrategy(this.request, null);
            }
            if (!CacheStrategy.isCacheable(this.cacheResponse, this.request)) {
                return new CacheStrategy(this.request, null);
            }
            CacheControl cacheControl = this.request.cacheControl();
            if (cacheControl.noCache() || hasConditions(this.request)) {
                return new CacheStrategy(this.request, null);
            }
            CacheControl cacheControl2 = this.cacheResponse.cacheControl();
            if (cacheControl2.immutable()) {
                return new CacheStrategy(null, this.cacheResponse);
            }
            long cacheResponseAge = cacheResponseAge();
            long computeFreshnessLifetime = computeFreshnessLifetime();
            if (cacheControl.maxAgeSeconds() != -1) {
                computeFreshnessLifetime = Math.min(computeFreshnessLifetime, TimeUnit.SECONDS.toMillis((long) cacheControl.maxAgeSeconds()));
            }
            long j2 = 0;
            long millis = cacheControl.minFreshSeconds() != -1 ? TimeUnit.SECONDS.toMillis((long) cacheControl.minFreshSeconds()) : 0;
            if (!cacheControl2.mustRevalidate() && cacheControl.maxStaleSeconds() != -1) {
                j2 = TimeUnit.SECONDS.toMillis((long) cacheControl.maxStaleSeconds());
            }
            if (!cacheControl2.noCache()) {
                long j3 = millis + cacheResponseAge;
                if (j3 < j2 + computeFreshnessLifetime) {
                    Builder newBuilder = this.cacheResponse.newBuilder();
                    String str = "Warning";
                    if (j3 >= computeFreshnessLifetime) {
                        newBuilder.addHeader(str, "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (cacheResponseAge > 86400000 && isFreshnessLifetimeHeuristic()) {
                        newBuilder.addHeader(str, "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new CacheStrategy(null, newBuilder.build());
                }
            }
            String str2 = this.etag;
            String str3 = "If-Modified-Since";
            if (str2 != null) {
                str3 = "If-None-Match";
            } else if (this.lastModified != null) {
                str2 = this.lastModifiedString;
            } else if (this.servedDate == null) {
                return new CacheStrategy(this.request, null);
            } else {
                str2 = this.servedDateString;
            }
            Headers.Builder newBuilder2 = this.request.headers().newBuilder();
            Internal.instance.addLenient(newBuilder2, str3, str2);
            return new CacheStrategy(this.request.newBuilder().headers(newBuilder2.build()).build(), this.cacheResponse);
        }

        private static boolean hasConditions(Request request2) {
            return (request2.header("If-Modified-Since") == null && request2.header("If-None-Match") == null) ? false : true;
        }

        private boolean isFreshnessLifetimeHeuristic() {
            return this.cacheResponse.cacheControl().maxAgeSeconds() == -1 && this.expires == null;
        }

        public CacheStrategy get() {
            CacheStrategy candidate = getCandidate();
            return (candidate.networkRequest == null || !this.request.cacheControl().onlyIfCached()) ? candidate : new CacheStrategy(null, null);
        }
    }

    CacheStrategy(Request request, Response response) {
        this.networkRequest = request;
        this.cacheResponse = response;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0056, code lost:
        if (r3.cacheControl().isPrivate() == false) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0059, code lost:
        return false;
     */
    public static boolean isCacheable(Response response, Request request) {
        int code = response.code();
        boolean z = false;
        if (!(code == 200 || code == 410 || code == 414 || code == 501 || code == 203 || code == 204)) {
            if (code != 307) {
                if (!(code == 308 || code == 404 || code == 405)) {
                    switch (code) {
                        case 300:
                        case 301:
                            break;
                        case 302:
                            break;
                    }
                }
            }
            if (response.header("Expires") == null) {
                if (response.cacheControl().maxAgeSeconds() == -1) {
                    if (!response.cacheControl().isPublic()) {
                    }
                }
            }
        }
        if (!response.cacheControl().noStore() && !request.cacheControl().noStore()) {
            z = true;
        }
        return z;
    }
}
