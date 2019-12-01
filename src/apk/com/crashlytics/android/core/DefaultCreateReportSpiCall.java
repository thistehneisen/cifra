package com.crashlytics.android.core;

import io.fabric.sdk.android.a.b.C0730a;
import io.fabric.sdk.android.a.b.D;
import io.fabric.sdk.android.f;
import io.fabric.sdk.android.l;
import io.fabric.sdk.android.o;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.d;
import io.fabric.sdk.android.services.network.g;
import java.io.File;
import java.util.Map.Entry;

class DefaultCreateReportSpiCall extends C0730a implements CreateReportSpiCall {
    static final String FILE_CONTENT_TYPE = "application/octet-stream";
    static final String FILE_PARAM = "report[file]";
    static final String IDENTIFIER_PARAM = "report[identifier]";
    static final String MULTI_FILE_PARAM = "report[file";

    public DefaultCreateReportSpiCall(l lVar, String str, String str2, g gVar) {
        super(lVar, str, str2, gVar, d.POST);
    }

    private HttpRequest applyHeadersTo(HttpRequest httpRequest, CreateReportRequest createReportRequest) {
        httpRequest.c(C0730a.HEADER_API_KEY, createReportRequest.apiKey);
        httpRequest.c(C0730a.HEADER_CLIENT_TYPE, C0730a.ANDROID_CLIENT_TYPE);
        httpRequest.c(C0730a.HEADER_CLIENT_VERSION, this.kit.getVersion());
        for (Entry a2 : createReportRequest.report.getCustomHeaders().entrySet()) {
            httpRequest.a(a2);
        }
        return httpRequest;
    }

    private HttpRequest applyMultipartDataTo(HttpRequest httpRequest, Report report) {
        File[] files;
        httpRequest.e(IDENTIFIER_PARAM, report.getIdentifier());
        int length = report.getFiles().length;
        String str = FILE_CONTENT_TYPE;
        String str2 = " to report ";
        String str3 = CrashlyticsCore.TAG;
        if (length == 1) {
            o e2 = f.e();
            StringBuilder sb = new StringBuilder();
            sb.append("Adding single file ");
            sb.append(report.getFileName());
            sb.append(str2);
            sb.append(report.getIdentifier());
            e2.d(str3, sb.toString());
            httpRequest.a(FILE_PARAM, report.getFileName(), str, report.getFile());
            return httpRequest;
        }
        int i2 = 0;
        for (File file : report.getFiles()) {
            o e3 = f.e();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Adding file ");
            sb2.append(file.getName());
            sb2.append(str2);
            sb2.append(report.getIdentifier());
            e3.d(str3, sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(MULTI_FILE_PARAM);
            sb3.append(i2);
            sb3.append("]");
            httpRequest.a(sb3.toString(), file.getName(), str, file);
            i2++;
        }
        return httpRequest;
    }

    public boolean invoke(CreateReportRequest createReportRequest) {
        HttpRequest httpRequest = getHttpRequest();
        applyHeadersTo(httpRequest, createReportRequest);
        applyMultipartDataTo(httpRequest, createReportRequest.report);
        o e2 = f.e();
        StringBuilder sb = new StringBuilder();
        sb.append("Sending report to: ");
        sb.append(getUrl());
        String sb2 = sb.toString();
        String str = CrashlyticsCore.TAG;
        e2.d(str, sb2);
        int g2 = httpRequest.g();
        o e3 = f.e();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Create report request ID: ");
        sb3.append(httpRequest.d(C0730a.HEADER_REQUEST_ID));
        e3.d(str, sb3.toString());
        o e4 = f.e();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Result was: ");
        sb4.append(g2);
        e4.d(str, sb4.toString());
        return D.a(g2) == 0;
    }

    DefaultCreateReportSpiCall(l lVar, String str, String str2, g gVar, d dVar) {
        super(lVar, str, str2, gVar, dVar);
    }
}
