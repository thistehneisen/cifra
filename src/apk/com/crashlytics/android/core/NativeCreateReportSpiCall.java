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

class NativeCreateReportSpiCall extends C0730a implements CreateReportSpiCall {
    private static final String APP_META_FILE_MULTIPART_PARAM = "app_meta_file";
    private static final String BINARY_IMAGES_FILE_MULTIPART_PARAM = "binary_images_file";
    private static final String DEVICE_META_FILE_MULTIPART_PARAM = "device_meta_file";
    private static final String GZIP_FILE_CONTENT_TYPE = "application/octet-stream";
    private static final String KEYS_FILE_MULTIPART_PARAM = "keys_file";
    private static final String LOGS_FILE_MULTIPART_PARAM = "logs_file";
    private static final String METADATA_FILE_MULTIPART_PARAM = "crash_meta_file";
    private static final String MINIDUMP_FILE_MULTIPART_PARAM = "minidump_file";
    private static final String OS_META_FILE_MULTIPART_PARAM = "os_meta_file";
    private static final String REPORT_IDENTIFIER_PARAM = "report_id";
    private static final String SESSION_META_FILE_MULTIPART_PARAM = "session_meta_file";
    private static final String USER_META_FILE_MULTIPART_PARAM = "user_meta_file";

    public NativeCreateReportSpiCall(l lVar, String str, String str2, g gVar) {
        super(lVar, str, str2, gVar, d.POST);
    }

    private HttpRequest applyHeadersTo(HttpRequest httpRequest, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(C0730a.CRASHLYTICS_USER_AGENT);
        sb.append(this.kit.getVersion());
        httpRequest.c(C0730a.HEADER_USER_AGENT, sb.toString());
        httpRequest.c(C0730a.HEADER_CLIENT_TYPE, C0730a.ANDROID_CLIENT_TYPE);
        httpRequest.c(C0730a.HEADER_CLIENT_VERSION, this.kit.getVersion());
        httpRequest.c(C0730a.HEADER_API_KEY, str);
        return httpRequest;
    }

    private HttpRequest applyMultipartDataTo(HttpRequest httpRequest, Report report) {
        File[] files;
        httpRequest.e(REPORT_IDENTIFIER_PARAM, report.getIdentifier());
        for (File file : report.getFiles()) {
            boolean equals = file.getName().equals("minidump");
            String str = GZIP_FILE_CONTENT_TYPE;
            if (equals) {
                httpRequest.a(MINIDUMP_FILE_MULTIPART_PARAM, file.getName(), str, file);
            } else if (file.getName().equals("metadata")) {
                httpRequest.a(METADATA_FILE_MULTIPART_PARAM, file.getName(), str, file);
            } else if (file.getName().equals("binaryImages")) {
                httpRequest.a(BINARY_IMAGES_FILE_MULTIPART_PARAM, file.getName(), str, file);
            } else if (file.getName().equals("session")) {
                httpRequest.a(SESSION_META_FILE_MULTIPART_PARAM, file.getName(), str, file);
            } else if (file.getName().equals("app")) {
                httpRequest.a(APP_META_FILE_MULTIPART_PARAM, file.getName(), str, file);
            } else if (file.getName().equals("device")) {
                httpRequest.a(DEVICE_META_FILE_MULTIPART_PARAM, file.getName(), str, file);
            } else if (file.getName().equals("os")) {
                httpRequest.a(OS_META_FILE_MULTIPART_PARAM, file.getName(), str, file);
            } else if (file.getName().equals("user")) {
                httpRequest.a(USER_META_FILE_MULTIPART_PARAM, file.getName(), str, file);
            } else if (file.getName().equals("logs")) {
                httpRequest.a(LOGS_FILE_MULTIPART_PARAM, file.getName(), str, file);
            } else if (file.getName().equals("keys")) {
                httpRequest.a(KEYS_FILE_MULTIPART_PARAM, file.getName(), str, file);
            }
        }
        return httpRequest;
    }

    public boolean invoke(CreateReportRequest createReportRequest) {
        HttpRequest httpRequest = getHttpRequest();
        applyHeadersTo(httpRequest, createReportRequest.apiKey);
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
        sb3.append("Result was: ");
        sb3.append(g2);
        e3.d(str, sb3.toString());
        return D.a(g2) == 0;
    }
}
