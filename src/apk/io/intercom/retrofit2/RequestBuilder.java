package io.intercom.retrofit2;

import e.a.b.g;
import e.a.b.h;
import io.intercom.okhttp3.FormBody.Builder;
import io.intercom.okhttp3.Headers;
import io.intercom.okhttp3.HttpUrl;
import io.intercom.okhttp3.MediaType;
import io.intercom.okhttp3.MultipartBody;
import io.intercom.okhttp3.MultipartBody.Part;
import io.intercom.okhttp3.Request;
import io.intercom.okhttp3.RequestBody;
import java.io.IOException;

final class RequestBuilder {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final String PATH_SEGMENT_ALWAYS_ENCODE_SET = " \"<>^`{}|\\?#";
    private final HttpUrl baseUrl;
    private RequestBody body;
    private MediaType contentType;
    private Builder formBuilder;
    private final boolean hasBody;
    private final String method;
    private MultipartBody.Builder multipartBuilder;
    private String relativeUrl;
    private final Request.Builder requestBuilder = new Request.Builder();
    private HttpUrl.Builder urlBuilder;

    private static class ContentTypeOverridingRequestBody extends RequestBody {
        private final MediaType contentType;
        private final RequestBody delegate;

        ContentTypeOverridingRequestBody(RequestBody requestBody, MediaType mediaType) {
            this.delegate = requestBody;
            this.contentType = mediaType;
        }

        public long contentLength() throws IOException {
            return this.delegate.contentLength();
        }

        public MediaType contentType() {
            return this.contentType;
        }

        public void writeTo(h hVar) throws IOException {
            this.delegate.writeTo(hVar);
        }
    }

    RequestBuilder(String str, HttpUrl httpUrl, String str2, Headers headers, MediaType mediaType, boolean z, boolean z2, boolean z3) {
        this.method = str;
        this.baseUrl = httpUrl;
        this.relativeUrl = str2;
        this.contentType = mediaType;
        this.hasBody = z;
        if (headers != null) {
            this.requestBuilder.headers(headers);
        }
        if (z2) {
            this.formBuilder = new Builder();
        } else if (z3) {
            this.multipartBuilder = new MultipartBody.Builder();
            this.multipartBuilder.setType(MultipartBody.FORM);
        }
    }

    private static String canonicalizeForPath(String str, boolean z) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int codePointAt = str.codePointAt(i2);
            if (codePointAt < 32 || codePointAt >= 127 || PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(codePointAt) != -1 || (!z && (codePointAt == 47 || codePointAt == 37))) {
                g gVar = new g();
                gVar.a(str, 0, i2);
                canonicalizeForPath(gVar, str, i2, length, z);
                return gVar.e();
            }
            i2 += Character.charCount(codePointAt);
        }
        return str;
    }

    /* access modifiers changed from: 0000 */
    public void addFormField(String str, String str2, boolean z) {
        if (z) {
            this.formBuilder.addEncoded(str, str2);
        } else {
            this.formBuilder.add(str, str2);
        }
    }

    /* access modifiers changed from: 0000 */
    public void addHeader(String str, String str2) {
        if ("Content-Type".equalsIgnoreCase(str)) {
            MediaType parse = MediaType.parse(str2);
            if (parse != null) {
                this.contentType = parse;
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Malformed content type: ");
            sb.append(str2);
            throw new IllegalArgumentException(sb.toString());
        }
        this.requestBuilder.addHeader(str, str2);
    }

    /* access modifiers changed from: 0000 */
    public void addPart(Headers headers, RequestBody requestBody) {
        this.multipartBuilder.addPart(headers, requestBody);
    }

    /* access modifiers changed from: 0000 */
    public void addPathParam(String str, String str2, boolean z) {
        String str3 = this.relativeUrl;
        if (str3 != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            sb.append(str);
            sb.append("}");
            this.relativeUrl = str3.replace(sb.toString(), canonicalizeForPath(str2, z));
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: 0000 */
    public void addQueryParam(String str, String str2, boolean z) {
        String str3 = this.relativeUrl;
        if (str3 != null) {
            this.urlBuilder = this.baseUrl.newBuilder(str3);
            if (this.urlBuilder != null) {
                this.relativeUrl = null;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Malformed URL. Base: ");
                sb.append(this.baseUrl);
                sb.append(", Relative: ");
                sb.append(this.relativeUrl);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        if (z) {
            this.urlBuilder.addEncodedQueryParameter(str, str2);
        } else {
            this.urlBuilder.addQueryParameter(str, str2);
        }
    }

    /* access modifiers changed from: 0000 */
    public Request build() {
        HttpUrl httpUrl;
        HttpUrl.Builder builder = this.urlBuilder;
        if (builder != null) {
            httpUrl = builder.build();
        } else {
            httpUrl = this.baseUrl.resolve(this.relativeUrl);
            if (httpUrl == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Malformed URL. Base: ");
                sb.append(this.baseUrl);
                sb.append(", Relative: ");
                sb.append(this.relativeUrl);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        RequestBody requestBody = this.body;
        if (requestBody == null) {
            Builder builder2 = this.formBuilder;
            if (builder2 != null) {
                requestBody = builder2.build();
            } else {
                MultipartBody.Builder builder3 = this.multipartBuilder;
                if (builder3 != null) {
                    requestBody = builder3.build();
                } else if (this.hasBody) {
                    requestBody = RequestBody.create((MediaType) null, new byte[0]);
                }
            }
        }
        MediaType mediaType = this.contentType;
        if (mediaType != null) {
            if (requestBody != null) {
                requestBody = new ContentTypeOverridingRequestBody(requestBody, mediaType);
            } else {
                this.requestBuilder.addHeader("Content-Type", mediaType.toString());
            }
        }
        return this.requestBuilder.url(httpUrl).method(this.method, requestBody).build();
    }

    /* access modifiers changed from: 0000 */
    public void setBody(RequestBody requestBody) {
        this.body = requestBody;
    }

    /* access modifiers changed from: 0000 */
    public void setRelativeUrl(Object obj) {
        this.relativeUrl = obj.toString();
    }

    /* access modifiers changed from: 0000 */
    public void addPart(Part part) {
        this.multipartBuilder.addPart(part);
    }

    private static void canonicalizeForPath(g gVar, String str, int i2, int i3, boolean z) {
        g gVar2 = null;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (!z || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (codePointAt < 32 || codePointAt >= 127 || PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(codePointAt) != -1 || (!z && (codePointAt == 47 || codePointAt == 37))) {
                    if (gVar2 == null) {
                        gVar2 = new g();
                    }
                    gVar2.c(codePointAt);
                    while (!gVar2.o()) {
                        byte readByte = gVar2.readByte() & 255;
                        gVar.writeByte(37);
                        gVar.writeByte((int) HEX_DIGITS[(readByte >> 4) & 15]);
                        gVar.writeByte((int) HEX_DIGITS[readByte & 15]);
                    }
                } else {
                    gVar.c(codePointAt);
                }
            }
            i2 += Character.charCount(codePointAt);
        }
    }
}
