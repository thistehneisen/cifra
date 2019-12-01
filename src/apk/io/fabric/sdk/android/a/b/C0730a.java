package io.fabric.sdk.android.a.b;

import io.fabric.sdk.android.l;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.d;
import io.fabric.sdk.android.services.network.g;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;

/* renamed from: io.fabric.sdk.android.a.b.a reason: case insensitive filesystem */
/* compiled from: AbstractSpiCall */
public abstract class C0730a {
    public static final String ACCEPT_JSON_VALUE = "application/json";
    public static final String ANDROID_CLIENT_TYPE = "android";
    public static final String CLS_ANDROID_SDK_DEVELOPER_TOKEN = "470fa2b4ae81cd56ecbcda9735803434cec591fa";
    public static final String CRASHLYTICS_USER_AGENT = "Crashlytics Android SDK/";
    public static final int DEFAULT_TIMEOUT = 10000;
    public static final String HEADER_ACCEPT = "Accept";
    public static final String HEADER_API_KEY = "X-CRASHLYTICS-API-KEY";
    public static final String HEADER_CLIENT_TYPE = "X-CRASHLYTICS-API-CLIENT-TYPE";
    public static final String HEADER_CLIENT_VERSION = "X-CRASHLYTICS-API-CLIENT-VERSION";
    public static final String HEADER_DEVELOPER_TOKEN = "X-CRASHLYTICS-DEVELOPER-TOKEN";
    public static final String HEADER_REQUEST_ID = "X-REQUEST-ID";
    public static final String HEADER_USER_AGENT = "User-Agent";
    private static final Pattern PROTOCOL_AND_HOST_PATTERN = Pattern.compile("http(s?)://[^\\/]+", 2);
    protected final l kit;
    private final d method;
    private final String protocolAndHostOverride;
    private final g requestFactory;
    private final String url;

    public C0730a(l lVar, String str, String str2, g gVar, d dVar) {
        if (str2 == null) {
            throw new IllegalArgumentException("url must not be null.");
        } else if (gVar != null) {
            this.kit = lVar;
            this.protocolAndHostOverride = str;
            this.url = overrideProtocolAndHost(str2);
            this.requestFactory = gVar;
            this.method = dVar;
        } else {
            throw new IllegalArgumentException("requestFactory must not be null.");
        }
    }

    private String overrideProtocolAndHost(String str) {
        return !l.b(this.protocolAndHostOverride) ? PROTOCOL_AND_HOST_PATTERN.matcher(str).replaceFirst(this.protocolAndHostOverride) : str;
    }

    /* access modifiers changed from: protected */
    public HttpRequest getHttpRequest() {
        return getHttpRequest(Collections.emptyMap());
    }

    /* access modifiers changed from: protected */
    public String getUrl() {
        return this.url;
    }

    /* access modifiers changed from: protected */
    public HttpRequest getHttpRequest(Map<String, String> map) {
        HttpRequest a2 = this.requestFactory.a(this.method, getUrl(), map);
        a2.a(false);
        a2.a((int) DEFAULT_TIMEOUT);
        StringBuilder sb = new StringBuilder();
        sb.append(CRASHLYTICS_USER_AGENT);
        sb.append(this.kit.getVersion());
        a2.c(HEADER_USER_AGENT, sb.toString());
        a2.c(HEADER_DEVELOPER_TOKEN, CLS_ANDROID_SDK_DEVELOPER_TOKEN);
        return a2;
    }
}
