package io.intercom.android.sdk.api;

import android.content.Context;
import e.a.a.a.a.d;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.api.RetryInterceptor.Sleeper;
import io.intercom.android.sdk.commons.utilities.TimeProvider;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.identity.AppIdentity;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Store;
import io.intercom.com.google.gson.o;
import io.intercom.okhttp3.Cache;
import io.intercom.okhttp3.CertificatePinner;
import io.intercom.okhttp3.OkHttpClient;
import io.intercom.okhttp3.OkHttpClient.Builder;
import io.intercom.retrofit2.Retrofit;
import io.intercom.retrofit2.converter.gson.GsonConverterFactory;
import java.io.File;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;

public class ApiFactory {
    private static final String CACHE_NAME = "Intercom_SDK/HttpCache";
    private static final int CACHE_SIZE = 10485760;
    private static final String ENDPOINT = "/messenger/mobile/";
    private static final int INTERCOM_TRAFFIC_TAG = 46837266;
    private static final int MAX_DNS_SEGMENT_SIZE = 63;
    private static final String PARTIAL_HOSTNAME = ".mobile-sdk-api.intercom.io";
    private static final String PROTOCOL = "https://";

    static String convertHostnameToUrl(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(PROTOCOL);
        sb.append(str);
        sb.append(ENDPOINT);
        return sb.toString();
    }

    public static Api create(Context context, AppIdentity appIdentity, UserIdentity userIdentity, d dVar, Store<State> store, String str, Provider<AppConfig> provider, o oVar) {
        return createWithNetworkClient(context, appIdentity, userIdentity, dVar, createConfigurableHttpClient(context, appIdentity, userIdentity).build(), store, str, provider, oVar);
    }

    public static Builder createConfigurableHttpClient(Context context, AppIdentity appIdentity, UserIdentity userIdentity) {
        Builder addNetworkInterceptor = new Builder().readTimeout(2, TimeUnit.MINUTES).connectTimeout(2, TimeUnit.MINUTES).writeTimeout(2, TimeUnit.MINUTES).socketFactory(new TaggingSocketFactory(SocketFactory.getDefault(), INTERCOM_TRAFFIC_TAG)).addInterceptor(new UserIdentityInterceptor(userIdentity)).addInterceptor(new RetryInterceptor(new Sleeper())).addInterceptor(new ShutdownInterceptor(new ShutdownState(context, appIdentity, TimeProvider.SYSTEM))).addNetworkInterceptor(HeaderInterceptor.create(context, appIdentity));
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            addNetworkInterceptor.cache(new Cache(new File(cacheDir.getAbsolutePath(), CACHE_NAME), 10485760));
        }
        addNetworkInterceptor.certificatePinner(new CertificatePinner.Builder().add(getFullHostname(appIdentity.appId()), "sha1/BiCgk94N+oILO/VULX+wYS6gWKU=").build());
        return addNetworkInterceptor;
    }

    private static MessengerApi createRetrofitClient(OkHttpClient okHttpClient, String str, o oVar) {
        return (MessengerApi) new Retrofit.Builder().baseUrl(str).client(okHttpClient).addConverterFactory(GsonConverterFactory.create(oVar)).build().create(MessengerApi.class);
    }

    static String createUniqueIdentifier(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(removeInvalidCharacters(str));
        sb.append("-android");
        String sb2 = sb.toString();
        if (sb2.length() <= 63) {
            return sb2;
        }
        int i2 = 62;
        if (sb2.charAt(62) != '-') {
            i2 = 63;
        }
        return sb2.substring(0, i2);
    }

    public static Api createWithNetworkClient(Context context, AppIdentity appIdentity, UserIdentity userIdentity, d dVar, OkHttpClient okHttpClient, Store<State> store, String str, Provider<AppConfig> provider, o oVar) {
        OkHttpClient okHttpClient2 = okHttpClient;
        Store<State> store2 = store;
        Context context2 = context;
        AppIdentity appIdentity2 = appIdentity;
        UserIdentity userIdentity2 = userIdentity;
        Api api = new Api(context2, appIdentity2, userIdentity2, dVar, okHttpClient2, createRetrofitClient(okHttpClient2, str, oVar), new CallbackHolder(dVar, store2), new RateLimiter((AppConfig) provider.get()), store2, provider);
        return api;
    }

    static String getFullHostname(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(createUniqueIdentifier(str));
        sb.append(PARTIAL_HOSTNAME);
        return sb.toString();
    }

    public static String getHostname(AppIdentity appIdentity) {
        return convertHostnameToUrl(getFullHostname(appIdentity.appId()));
    }

    public static String removeInvalidCharacters(String str) {
        return str.replaceAll("[^A-Za-z0-9\\-$]", "");
    }
}
