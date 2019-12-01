package io.intercom.android.sdk.api;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Base64;
import io.intercom.android.sdk.commons.utilities.DeviceUtils;
import io.intercom.android.sdk.identity.AppIdentity;
import io.intercom.okhttp3.Interceptor;
import io.intercom.okhttp3.Interceptor.Chain;
import io.intercom.okhttp3.Request.Builder;
import io.intercom.okhttp3.Response;
import java.io.IOException;
import java.util.Locale;
import java.util.Random;

class HeaderInterceptor implements Interceptor {
    private static final String ACCEPT_LANGUAGE = "Accept-Language";
    private static final String ANDROID_HEADER = "intercom-android-sdk/";
    private static final String AUTHORIZATION = "Authorization";
    private static final String CONTENT_TYPE_KEY = "Content-Type";
    private static final String CONTENT_TYPE_VALUE = "application/json";
    private static final String CORDOVA_HEADER = "intercom-sdk-cordova/";
    private static final String CORDOVA_PREFS = "intercomsdk_cordova_prefs";
    private static final String CORDOVA_VERSION = "cordova_version";
    private static final String HOST_APP_VERSION_KEY = "X-INTERCOM-HOST-APP-VERSION";
    private static final String IDEMPOTENCY_KEY = "Idempotency-Key";
    private static final String INTERCOM_AGENT = "X-INTERCOM-AGENT";
    private static final String INTERCOM_AGENT_WRAPPER = "X-INTERCOM-AGENT-WRAPPER";
    private static final String SUPPORTED_LANGUAGES_KEY = "X-INTERCOM-SUPPORTED-LANGUAGES";
    private static final String SUPPORTED_LANGUAGE_LIST = "ar,bg,bs,ca,cs,da,de,de-form,el,es,et,fi,fr,he,hr,hu,id,it,ja,ko,lt,lv,mn,nb,nl,pl,pt-PT,pt-BR,ro,ru,sl,sr,sv,tr,vi,zh-Hant,zh-Hans";
    private final AppIdentity appIdentity;
    private final String appVersion;
    private final String cordovaVersion;
    private final Random random;
    private final Locale userLocale;
    private final String versionName;

    HeaderInterceptor(String str, String str2, AppIdentity appIdentity2, Locale locale, String str3, Random random2) {
        this.cordovaVersion = str;
        this.versionName = str2;
        this.appIdentity = appIdentity2;
        this.userLocale = locale;
        this.appVersion = str3;
        this.random = random2;
    }

    public static HeaderInterceptor create(Context context, AppIdentity appIdentity2) {
        HeaderInterceptor headerInterceptor = new HeaderInterceptor(context.getSharedPreferences(CORDOVA_PREFS, 0).getString(CORDOVA_VERSION, ""), "5.3.2", appIdentity2, context.getResources().getConfiguration().locale, DeviceUtils.getAppVersion(context), new Random());
        return headerInterceptor;
    }

    private String getBasicAuth() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.appIdentity.appId());
        sb.append(":");
        sb.append(this.appIdentity.apiKey());
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Basic ");
        sb3.append(Base64.encodeToString(sb2.getBytes(), 2));
        return sb3.toString();
    }

    @SuppressLint({"CommitPrefEdits"})
    public static void setCordovaVersion(Context context, String str) {
        context.getSharedPreferences(CORDOVA_PREFS, 0).edit().putString(CORDOVA_VERSION, str).apply();
    }

    public Response intercept(Chain chain) throws IOException {
        Builder header = chain.request().newBuilder().header(CONTENT_TYPE_KEY, "application/json").header(AUTHORIZATION, getBasicAuth()).header(IDEMPOTENCY_KEY, Long.toHexString(this.random.nextLong()));
        StringBuilder sb = new StringBuilder();
        sb.append(ANDROID_HEADER);
        sb.append(this.versionName);
        Builder header2 = header.header(INTERCOM_AGENT, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.userLocale.getLanguage());
        sb2.append("-");
        sb2.append(this.userLocale.getCountry());
        Builder header3 = header2.header(ACCEPT_LANGUAGE, sb2.toString()).header(SUPPORTED_LANGUAGES_KEY, SUPPORTED_LANGUAGE_LIST).header(HOST_APP_VERSION_KEY, this.appVersion);
        if (!this.cordovaVersion.isEmpty()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(CORDOVA_HEADER);
            sb3.append(this.cordovaVersion);
            header3.header(INTERCOM_AGENT_WRAPPER, sb3.toString());
        }
        return chain.proceed(header3.build());
    }
}
