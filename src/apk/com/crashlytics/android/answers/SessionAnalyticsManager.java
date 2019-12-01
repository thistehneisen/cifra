package com.crashlytics.android.answers;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.crashlytics.android.answers.BackgroundManager.Listener;
import io.fabric.sdk.android.a.b.u;
import io.fabric.sdk.android.a.b.y;
import io.fabric.sdk.android.b;
import io.fabric.sdk.android.f;
import io.fabric.sdk.android.l;
import io.fabric.sdk.android.o;
import io.fabric.sdk.android.services.network.c;
import java.util.concurrent.ScheduledExecutorService;

class SessionAnalyticsManager implements Listener {
    static final String EXECUTOR_SERVICE = "Answers Events Handler";
    static final String ON_CRASH_ERROR_MSG = "onCrash called from main thread!!!";
    final BackgroundManager backgroundManager;
    final AnswersEventsHandler eventsHandler;
    private final long installedAt;
    final b lifecycleManager;
    final AnswersPreferenceManager preferenceManager;

    SessionAnalyticsManager(AnswersEventsHandler answersEventsHandler, b bVar, BackgroundManager backgroundManager2, AnswersPreferenceManager answersPreferenceManager, long j2) {
        this.eventsHandler = answersEventsHandler;
        this.lifecycleManager = bVar;
        this.backgroundManager = backgroundManager2;
        this.preferenceManager = answersPreferenceManager;
        this.installedAt = j2;
    }

    public static SessionAnalyticsManager build(l lVar, Context context, y yVar, String str, String str2, long j2) {
        Context context2 = context;
        y yVar2 = yVar;
        SessionMetadataCollector sessionMetadataCollector = new SessionMetadataCollector(context, yVar, str, str2);
        l lVar2 = lVar;
        AnswersFilesManagerProvider answersFilesManagerProvider = new AnswersFilesManagerProvider(context, new io.fabric.sdk.android.a.d.b(lVar));
        c cVar = new c(f.e());
        b bVar = new b(context);
        ScheduledExecutorService b2 = u.b(EXECUTOR_SERVICE);
        BackgroundManager backgroundManager2 = new BackgroundManager(b2);
        AnswersEventsHandler answersEventsHandler = new AnswersEventsHandler(lVar2, context, answersFilesManagerProvider, sessionMetadataCollector, cVar, b2, new FirebaseAnalyticsApiAdapter(context));
        SessionAnalyticsManager sessionAnalyticsManager = new SessionAnalyticsManager(answersEventsHandler, bVar, backgroundManager2, AnswersPreferenceManager.build(context), j2);
        return sessionAnalyticsManager;
    }

    public void disable() {
        this.lifecycleManager.a();
        this.eventsHandler.disable();
    }

    public void enable() {
        this.eventsHandler.enable();
        this.lifecycleManager.a(new AnswersLifecycleCallbacks(this, this.backgroundManager));
        this.backgroundManager.registerListener(this);
        if (isFirstLaunch()) {
            onInstall(this.installedAt);
            this.preferenceManager.setAnalyticsLaunched();
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean isFirstLaunch() {
        return !this.preferenceManager.hasAnalyticsLaunched();
    }

    public void onBackground() {
        f.e().d(Answers.TAG, "Flush events when app is backgrounded");
        this.eventsHandler.flushEvents();
    }

    public void onCrash(String str, String str2) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            f.e().d(Answers.TAG, "Logged crash");
            this.eventsHandler.processEventSync(SessionEvent.crashEventBuilder(str, str2));
            return;
        }
        throw new IllegalStateException(ON_CRASH_ERROR_MSG);
    }

    public void onCustom(CustomEvent customEvent) {
        o e2 = f.e();
        StringBuilder sb = new StringBuilder();
        sb.append("Logged custom event: ");
        sb.append(customEvent);
        e2.d(Answers.TAG, sb.toString());
        this.eventsHandler.processEventAsync(SessionEvent.customEventBuilder(customEvent));
    }

    public void onError(String str) {
    }

    public void onInstall(long j2) {
        f.e().d(Answers.TAG, "Logged install");
        this.eventsHandler.processEventAsyncAndFlush(SessionEvent.installEventBuilder(j2));
    }

    public void onLifecycle(Activity activity, Type type) {
        o e2 = f.e();
        StringBuilder sb = new StringBuilder();
        sb.append("Logged lifecycle event: ");
        sb.append(type.name());
        e2.d(Answers.TAG, sb.toString());
        this.eventsHandler.processEventAsync(SessionEvent.lifecycleEventBuilder(type, activity));
    }

    public void onPredefined(PredefinedEvent predefinedEvent) {
        o e2 = f.e();
        StringBuilder sb = new StringBuilder();
        sb.append("Logged predefined event: ");
        sb.append(predefinedEvent);
        e2.d(Answers.TAG, sb.toString());
        this.eventsHandler.processEventAsync(SessionEvent.predefinedEventBuilder(predefinedEvent));
    }

    public void setAnalyticsSettingsData(io.fabric.sdk.android.a.e.b bVar, String str) {
        this.backgroundManager.setFlushOnBackground(bVar.f8905j);
        this.eventsHandler.setAnalyticsSettingsData(bVar, str);
    }
}
