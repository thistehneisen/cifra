package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.a.b.i;
import io.fabric.sdk.android.a.c.g;
import io.fabric.sdk.android.a.c.j;
import io.fabric.sdk.android.a.e.b;
import io.fabric.sdk.android.f;
import io.fabric.sdk.android.l;
import io.fabric.sdk.android.o;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

class EnabledSessionAnalyticsManagerStrategy implements SessionAnalyticsManagerStrategy {
    static final int UNDEFINED_ROLLOVER_INTERVAL_SECONDS = -1;
    i apiKey = new i();
    private final Context context;
    boolean customEventsEnabled = true;
    EventFilter eventFilter = new KeepAllEventFilter();
    private final ScheduledExecutorService executorService;
    private final SessionAnalyticsFilesManager filesManager;
    g filesSender;
    private final FirebaseAnalyticsApiAdapter firebaseAnalyticsApiAdapter;
    boolean forwardToFirebaseAnalyticsEnabled = false;
    private final io.fabric.sdk.android.services.network.g httpRequestFactory;
    boolean includePurchaseEventsInForwardedEvents = false;
    private final l kit;
    final SessionEventMetadata metadata;
    boolean predefinedEventsEnabled = true;
    private final AtomicReference<ScheduledFuture<?>> rolloverFutureRef = new AtomicReference<>();
    volatile int rolloverIntervalSeconds = -1;

    public EnabledSessionAnalyticsManagerStrategy(l lVar, Context context2, ScheduledExecutorService scheduledExecutorService, SessionAnalyticsFilesManager sessionAnalyticsFilesManager, io.fabric.sdk.android.services.network.g gVar, SessionEventMetadata sessionEventMetadata, FirebaseAnalyticsApiAdapter firebaseAnalyticsApiAdapter2) {
        this.kit = lVar;
        this.context = context2;
        this.executorService = scheduledExecutorService;
        this.filesManager = sessionAnalyticsFilesManager;
        this.httpRequestFactory = gVar;
        this.metadata = sessionEventMetadata;
        this.firebaseAnalyticsApiAdapter = firebaseAnalyticsApiAdapter2;
    }

    public void cancelTimeBasedFileRollOver() {
        if (this.rolloverFutureRef.get() != null) {
            io.fabric.sdk.android.a.b.l.c(this.context, "Cancelling time-based rollover because no events are currently being generated.");
            ((ScheduledFuture) this.rolloverFutureRef.get()).cancel(false);
            this.rolloverFutureRef.set(null);
        }
    }

    public void deleteAllEvents() {
        this.filesManager.deleteAllEventsFiles();
    }

    public void processEvent(Builder builder) {
        SessionEvent build = builder.build(this.metadata);
        boolean z = this.customEventsEnabled;
        String str = Answers.TAG;
        if (!z && Type.CUSTOM.equals(build.type)) {
            o e2 = f.e();
            StringBuilder sb = new StringBuilder();
            sb.append("Custom events tracking disabled - skipping event: ");
            sb.append(build);
            e2.d(str, sb.toString());
        } else if (!this.predefinedEventsEnabled && Type.PREDEFINED.equals(build.type)) {
            o e3 = f.e();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Predefined events tracking disabled - skipping event: ");
            sb2.append(build);
            e3.d(str, sb2.toString());
        } else if (this.eventFilter.skipEvent(build)) {
            o e4 = f.e();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Skipping filtered event: ");
            sb3.append(build);
            e4.d(str, sb3.toString());
        } else {
            try {
                this.filesManager.writeEvent(build);
            } catch (IOException e5) {
                o e6 = f.e();
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Failed to write event: ");
                sb4.append(build);
                e6.b(str, sb4.toString(), e5);
            }
            scheduleTimeBasedRollOverIfNeeded();
            boolean z2 = Type.CUSTOM.equals(build.type) || Type.PREDEFINED.equals(build.type);
            boolean equals = "purchase".equals(build.predefinedType);
            if (this.forwardToFirebaseAnalyticsEnabled && z2 && (!equals || this.includePurchaseEventsInForwardedEvents)) {
                try {
                    this.firebaseAnalyticsApiAdapter.processEvent(build);
                } catch (Exception e7) {
                    o e8 = f.e();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Failed to map event to Firebase: ");
                    sb5.append(build);
                    e8.b(str, sb5.toString(), e7);
                }
            }
        }
    }

    public boolean rollFileOver() {
        try {
            return this.filesManager.rollFileOver();
        } catch (IOException e2) {
            io.fabric.sdk.android.a.b.l.a(this.context, "Failed to roll file over.", (Throwable) e2);
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    public void scheduleTimeBasedFileRollOver(long j2, long j3) {
        if (this.rolloverFutureRef.get() == null) {
            j jVar = new j(this.context, this);
            Context context2 = this.context;
            StringBuilder sb = new StringBuilder();
            sb.append("Scheduling time based file roll over every ");
            sb.append(j3);
            sb.append(" seconds");
            io.fabric.sdk.android.a.b.l.c(context2, sb.toString());
            try {
                this.rolloverFutureRef.set(this.executorService.scheduleAtFixedRate(jVar, j2, j3, TimeUnit.SECONDS));
            } catch (RejectedExecutionException e2) {
                io.fabric.sdk.android.a.b.l.a(this.context, "Failed to schedule time based file roll over", (Throwable) e2);
            }
        }
    }

    public void scheduleTimeBasedRollOverIfNeeded() {
        if (this.rolloverIntervalSeconds != -1) {
            scheduleTimeBasedFileRollOver((long) this.rolloverIntervalSeconds, (long) this.rolloverIntervalSeconds);
        }
    }

    public void sendEvents() {
        if (this.filesSender == null) {
            io.fabric.sdk.android.a.b.l.c(this.context, "skipping files send because we don't yet know the target endpoint");
            return;
        }
        io.fabric.sdk.android.a.b.l.c(this.context, "Sending all files");
        List batchOfFilesToSend = this.filesManager.getBatchOfFilesToSend();
        int i2 = 0;
        while (true) {
            try {
                if (batchOfFilesToSend.size() <= 0) {
                    break;
                }
                io.fabric.sdk.android.a.b.l.c(this.context, String.format(Locale.US, "attempt to send batch of %d files", new Object[]{Integer.valueOf(batchOfFilesToSend.size())}));
                boolean send = this.filesSender.send(batchOfFilesToSend);
                if (send) {
                    i2 += batchOfFilesToSend.size();
                    this.filesManager.deleteSentFiles(batchOfFilesToSend);
                }
                if (!send) {
                    break;
                }
                batchOfFilesToSend = this.filesManager.getBatchOfFilesToSend();
            } catch (Exception e2) {
                Context context2 = this.context;
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to send batch of analytics files to server: ");
                sb.append(e2.getMessage());
                io.fabric.sdk.android.a.b.l.a(context2, sb.toString(), (Throwable) e2);
            }
        }
        if (i2 == 0) {
            this.filesManager.deleteOldestInRollOverIfOverMax();
        }
    }

    public void setAnalyticsSettingsData(b bVar, String str) {
        SessionAnalyticsFilesSender sessionAnalyticsFilesSender = new SessionAnalyticsFilesSender(this.kit, str, bVar.f8896a, this.httpRequestFactory, this.apiKey.d(this.context));
        this.filesSender = AnswersRetryFilesSender.build(sessionAnalyticsFilesSender);
        this.filesManager.setAnalyticsSettingsData(bVar);
        this.forwardToFirebaseAnalyticsEnabled = bVar.f8901f;
        this.includePurchaseEventsInForwardedEvents = bVar.f8902g;
        o e2 = f.e();
        StringBuilder sb = new StringBuilder();
        sb.append("Firebase analytics forwarding ");
        String str2 = "enabled";
        String str3 = "disabled";
        sb.append(this.forwardToFirebaseAnalyticsEnabled ? str2 : str3);
        String sb2 = sb.toString();
        String str4 = Answers.TAG;
        e2.d(str4, sb2);
        o e3 = f.e();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Firebase analytics including purchase events ");
        sb3.append(this.includePurchaseEventsInForwardedEvents ? str2 : str3);
        e3.d(str4, sb3.toString());
        this.customEventsEnabled = bVar.f8903h;
        o e4 = f.e();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Custom event tracking ");
        sb4.append(this.customEventsEnabled ? str2 : str3);
        e4.d(str4, sb4.toString());
        this.predefinedEventsEnabled = bVar.f8904i;
        o e5 = f.e();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Predefined event tracking ");
        if (!this.predefinedEventsEnabled) {
            str2 = str3;
        }
        sb5.append(str2);
        e5.d(str4, sb5.toString());
        if (bVar.f8906k > 1) {
            f.e().d(str4, "Event sampling enabled");
            this.eventFilter = new SamplingEventFilter(bVar.f8906k);
        }
        this.rolloverIntervalSeconds = bVar.f8897b;
        scheduleTimeBasedFileRollOver(0, (long) this.rolloverIntervalSeconds);
    }
}
