package com.crashlytics.android.core;

import com.crashlytics.android.core.Report.Type;

class CompositeCreateReportSpiCall implements CreateReportSpiCall {
    private final DefaultCreateReportSpiCall javaReportSpiCall;
    private final NativeCreateReportSpiCall nativeReportSpiCall;

    /* renamed from: com.crashlytics.android.core.CompositeCreateReportSpiCall$1 reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$crashlytics$android$core$Report$Type = new int[Type.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            $SwitchMap$com$crashlytics$android$core$Report$Type[Type.JAVA.ordinal()] = 1;
            $SwitchMap$com$crashlytics$android$core$Report$Type[Type.NATIVE.ordinal()] = 2;
        }
    }

    public CompositeCreateReportSpiCall(DefaultCreateReportSpiCall defaultCreateReportSpiCall, NativeCreateReportSpiCall nativeCreateReportSpiCall) {
        this.javaReportSpiCall = defaultCreateReportSpiCall;
        this.nativeReportSpiCall = nativeCreateReportSpiCall;
    }

    public boolean invoke(CreateReportRequest createReportRequest) {
        int i2 = AnonymousClass1.$SwitchMap$com$crashlytics$android$core$Report$Type[createReportRequest.report.getType().ordinal()];
        if (i2 == 1) {
            this.javaReportSpiCall.invoke(createReportRequest);
            return true;
        } else if (i2 != 2) {
            return false;
        } else {
            this.nativeReportSpiCall.invoke(createReportRequest);
            return true;
        }
    }
}
