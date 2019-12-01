package com.crashlytics.android.answers;

import io.fabric.sdk.android.a.b.C0730a;
import io.fabric.sdk.android.a.b.D;
import io.fabric.sdk.android.a.c.g;
import io.fabric.sdk.android.f;
import io.fabric.sdk.android.l;
import io.fabric.sdk.android.o;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.d;
import java.io.File;
import java.util.List;

class SessionAnalyticsFilesSender extends C0730a implements g {
    static final String FILE_CONTENT_TYPE = "application/vnd.crashlytics.android.events";
    static final String FILE_PARAM_NAME = "session_analytics_file_";
    private final String apiKey;

    public SessionAnalyticsFilesSender(l lVar, String str, String str2, io.fabric.sdk.android.services.network.g gVar, String str3) {
        super(lVar, str, str2, gVar, d.POST);
        this.apiKey = str3;
    }

    public boolean send(List<File> list) {
        HttpRequest httpRequest = getHttpRequest();
        httpRequest.c(C0730a.HEADER_CLIENT_TYPE, C0730a.ANDROID_CLIENT_TYPE);
        httpRequest.c(C0730a.HEADER_CLIENT_VERSION, this.kit.getVersion());
        httpRequest.c(C0730a.HEADER_API_KEY, this.apiKey);
        int i2 = 0;
        for (File file : list) {
            StringBuilder sb = new StringBuilder();
            sb.append(FILE_PARAM_NAME);
            sb.append(i2);
            httpRequest.a(sb.toString(), file.getName(), FILE_CONTENT_TYPE, file);
            i2++;
        }
        o e2 = f.e();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Sending ");
        sb2.append(list.size());
        sb2.append(" analytics files to ");
        sb2.append(getUrl());
        String sb3 = sb2.toString();
        String str = Answers.TAG;
        e2.d(str, sb3);
        int g2 = httpRequest.g();
        o e3 = f.e();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Response code for analytics file send is ");
        sb4.append(g2);
        e3.d(str, sb4.toString());
        if (D.a(g2) == 0) {
            return true;
        }
        return false;
    }
}
