package com.crashlytics.android.core;

import io.fabric.sdk.android.a.e.v;
import io.fabric.sdk.android.f;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.atomic.AtomicBoolean;

class CrashlyticsUncaughtExceptionHandler implements UncaughtExceptionHandler {
    private final CrashListener crashListener;
    private final UncaughtExceptionHandler defaultHandler;
    private final boolean firebaseCrashlyticsClientFlag;
    private final AtomicBoolean isHandlingException = new AtomicBoolean(false);
    private final SettingsDataProvider settingsDataProvider;

    interface CrashListener {
        void onUncaughtException(SettingsDataProvider settingsDataProvider, Thread thread, Throwable th, boolean z);
    }

    interface SettingsDataProvider {
        v getSettingsData();
    }

    public CrashlyticsUncaughtExceptionHandler(CrashListener crashListener2, SettingsDataProvider settingsDataProvider2, boolean z, UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.crashListener = crashListener2;
        this.settingsDataProvider = settingsDataProvider2;
        this.firebaseCrashlyticsClientFlag = z;
        this.defaultHandler = uncaughtExceptionHandler;
    }

    /* access modifiers changed from: 0000 */
    public boolean isHandlingException() {
        return this.isHandlingException.get();
    }

    public void uncaughtException(Thread thread, Throwable th) {
        String str = "Crashlytics completed exception processing. Invoking default exception handler.";
        String str2 = CrashlyticsCore.TAG;
        this.isHandlingException.set(true);
        try {
            this.crashListener.onUncaughtException(this.settingsDataProvider, thread, th, this.firebaseCrashlyticsClientFlag);
        } catch (Exception e2) {
            f.e().b(str2, "An error occurred in the uncaught exception handler", e2);
        } catch (Throwable th2) {
            f.e().d(str2, str);
            this.defaultHandler.uncaughtException(thread, th);
            this.isHandlingException.set(false);
            throw th2;
        }
        f.e().d(str2, str);
        this.defaultHandler.uncaughtException(thread, th);
        this.isHandlingException.set(false);
    }
}
