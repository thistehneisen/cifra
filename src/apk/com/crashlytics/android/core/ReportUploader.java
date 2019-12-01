package com.crashlytics.android.core;

import io.fabric.sdk.android.a.b.j;
import io.fabric.sdk.android.f;
import io.fabric.sdk.android.o;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class ReportUploader {
    static final Map<String, String> HEADER_INVALID_CLS_FILE = Collections.singletonMap("X-CRASHLYTICS-INVALID-SESSION", "1");
    /* access modifiers changed from: private */
    public static final short[] RETRY_INTERVALS = {10, 20, 30, 60, 120, 300};
    private final String apiKey;
    private final CreateReportSpiCall createReportCall;
    private final Object fileAccessLock = new Object();
    /* access modifiers changed from: private */
    public final HandlingExceptionCheck handlingExceptionCheck;
    private final ReportFilesProvider reportFilesProvider;
    /* access modifiers changed from: private */
    public Thread uploadThread;

    static final class AlwaysSendCheck implements SendCheck {
        AlwaysSendCheck() {
        }

        public boolean canSendReports() {
            return true;
        }
    }

    interface HandlingExceptionCheck {
        boolean isHandlingException();
    }

    interface ReportFilesProvider {
        File[] getCompleteSessionFiles();

        File[] getInvalidSessionFiles();

        File[] getNativeReportFiles();
    }

    interface SendCheck {
        boolean canSendReports();
    }

    private class Worker extends j {
        private final float delay;
        private final SendCheck sendCheck;

        Worker(float f2, SendCheck sendCheck2) {
            this.delay = f2;
            this.sendCheck = sendCheck2;
        }

        private void attemptUploadWithRetry() {
            o e2 = f.e();
            StringBuilder sb = new StringBuilder();
            sb.append("Starting report processing in ");
            sb.append(this.delay);
            sb.append(" second(s)...");
            String sb2 = sb.toString();
            String str = CrashlyticsCore.TAG;
            e2.d(str, sb2);
            float f2 = this.delay;
            if (f2 > 0.0f) {
                try {
                    Thread.sleep((long) (f2 * 1000.0f));
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            List<Report> findReports = ReportUploader.this.findReports();
            if (!ReportUploader.this.handlingExceptionCheck.isHandlingException()) {
                if (findReports.isEmpty() || this.sendCheck.canSendReports()) {
                    int i2 = 0;
                    while (!findReports.isEmpty() && !ReportUploader.this.handlingExceptionCheck.isHandlingException()) {
                        o e3 = f.e();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Attempting to send ");
                        sb3.append(findReports.size());
                        sb3.append(" report(s)");
                        e3.d(str, sb3.toString());
                        for (Report forceUpload : findReports) {
                            ReportUploader.this.forceUpload(forceUpload);
                        }
                        findReports = ReportUploader.this.findReports();
                        if (!findReports.isEmpty()) {
                            int i3 = i2 + 1;
                            long j2 = (long) ReportUploader.RETRY_INTERVALS[Math.min(i2, ReportUploader.RETRY_INTERVALS.length - 1)];
                            o e4 = f.e();
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("Report submisson: scheduling delayed retry in ");
                            sb4.append(j2);
                            sb4.append(" seconds");
                            e4.d(str, sb4.toString());
                            try {
                                Thread.sleep(j2 * 1000);
                                i2 = i3;
                            } catch (InterruptedException unused2) {
                                Thread.currentThread().interrupt();
                                return;
                            }
                        }
                    }
                    return;
                }
                o e5 = f.e();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("User declined to send. Removing ");
                sb5.append(findReports.size());
                sb5.append(" Report(s).");
                e5.d(str, sb5.toString());
                for (Report remove : findReports) {
                    remove.remove();
                }
            }
        }

        public void onRun() {
            try {
                attemptUploadWithRetry();
            } catch (Exception e2) {
                f.e().b(CrashlyticsCore.TAG, "An unexpected error occurred while attempting to upload crash reports.", e2);
            }
            ReportUploader.this.uploadThread = null;
        }
    }

    public ReportUploader(String str, CreateReportSpiCall createReportSpiCall, ReportFilesProvider reportFilesProvider2, HandlingExceptionCheck handlingExceptionCheck2) {
        if (createReportSpiCall != null) {
            this.createReportCall = createReportSpiCall;
            this.apiKey = str;
            this.reportFilesProvider = reportFilesProvider2;
            this.handlingExceptionCheck = handlingExceptionCheck2;
            return;
        }
        throw new IllegalArgumentException("createReportCall must not be null.");
    }

    /* access modifiers changed from: 0000 */
    public List<Report> findReports() {
        File[] completeSessionFiles;
        File[] invalidSessionFiles;
        File[] nativeReportFiles;
        f.e().d(CrashlyticsCore.TAG, "Checking for crash reports...");
        synchronized (this.fileAccessLock) {
            completeSessionFiles = this.reportFilesProvider.getCompleteSessionFiles();
            invalidSessionFiles = this.reportFilesProvider.getInvalidSessionFiles();
            nativeReportFiles = this.reportFilesProvider.getNativeReportFiles();
        }
        LinkedList linkedList = new LinkedList();
        if (completeSessionFiles != null) {
            for (File file : completeSessionFiles) {
                o e2 = f.e();
                StringBuilder sb = new StringBuilder();
                sb.append("Found crash report ");
                sb.append(file.getPath());
                e2.d(CrashlyticsCore.TAG, sb.toString());
                linkedList.add(new SessionReport(file));
            }
        }
        HashMap hashMap = new HashMap();
        if (invalidSessionFiles != null) {
            for (File file2 : invalidSessionFiles) {
                String sessionIdFromSessionFile = CrashlyticsController.getSessionIdFromSessionFile(file2);
                if (!hashMap.containsKey(sessionIdFromSessionFile)) {
                    hashMap.put(sessionIdFromSessionFile, new LinkedList());
                }
                ((List) hashMap.get(sessionIdFromSessionFile)).add(file2);
            }
        }
        for (String str : hashMap.keySet()) {
            o e3 = f.e();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Found invalid session: ");
            sb2.append(str);
            e3.d(CrashlyticsCore.TAG, sb2.toString());
            List list = (List) hashMap.get(str);
            linkedList.add(new InvalidSessionReport(str, (File[]) list.toArray(new File[list.size()])));
        }
        if (nativeReportFiles != null) {
            for (File nativeSessionReport : nativeReportFiles) {
                linkedList.add(new NativeSessionReport(nativeSessionReport));
            }
        }
        if (linkedList.isEmpty()) {
            f.e().d(CrashlyticsCore.TAG, "No reports found.");
        }
        return linkedList;
    }

    /* access modifiers changed from: 0000 */
    public boolean forceUpload(Report report) {
        boolean z;
        synchronized (this.fileAccessLock) {
            z = false;
            try {
                boolean invoke = this.createReportCall.invoke(new CreateReportRequest(this.apiKey, report));
                o e2 = f.e();
                String str = CrashlyticsCore.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("Crashlytics report upload ");
                sb.append(invoke ? "complete: " : "FAILED: ");
                sb.append(report.getIdentifier());
                e2.e(str, sb.toString());
                if (invoke) {
                    report.remove();
                    z = true;
                }
            } catch (Exception e3) {
                o e4 = f.e();
                String str2 = CrashlyticsCore.TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error occurred sending report ");
                sb2.append(report);
                e4.b(str2, sb2.toString(), e3);
            }
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    public boolean isUploading() {
        return this.uploadThread != null;
    }

    public synchronized void uploadReports(float f2, SendCheck sendCheck) {
        if (this.uploadThread != null) {
            f.e().d(CrashlyticsCore.TAG, "Report upload has already been started.");
            return;
        }
        this.uploadThread = new Thread(new Worker(f2, sendCheck), "Crashlytics Report Uploader");
        this.uploadThread.start();
    }
}
