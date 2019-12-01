package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.a.c.e;
import io.fabric.sdk.android.a.e.b;
import io.fabric.sdk.android.f;
import io.fabric.sdk.android.l;
import io.fabric.sdk.android.services.network.g;
import java.util.concurrent.ScheduledExecutorService;

class AnswersEventsHandler implements e {
    /* access modifiers changed from: private */
    public final Context context;
    final ScheduledExecutorService executor;
    /* access modifiers changed from: private */
    public final AnswersFilesManagerProvider filesManagerProvider;
    /* access modifiers changed from: private */
    public final FirebaseAnalyticsApiAdapter firebaseAnalyticsApiAdapter;
    /* access modifiers changed from: private */
    public final l kit;
    /* access modifiers changed from: private */
    public final SessionMetadataCollector metadataCollector;
    /* access modifiers changed from: private */
    public final g requestFactory;
    SessionAnalyticsManagerStrategy strategy = new DisabledSessionAnalyticsManagerStrategy();

    public AnswersEventsHandler(l lVar, Context context2, AnswersFilesManagerProvider answersFilesManagerProvider, SessionMetadataCollector sessionMetadataCollector, g gVar, ScheduledExecutorService scheduledExecutorService, FirebaseAnalyticsApiAdapter firebaseAnalyticsApiAdapter2) {
        this.kit = lVar;
        this.context = context2;
        this.filesManagerProvider = answersFilesManagerProvider;
        this.metadataCollector = sessionMetadataCollector;
        this.requestFactory = gVar;
        this.executor = scheduledExecutorService;
        this.firebaseAnalyticsApiAdapter = firebaseAnalyticsApiAdapter2;
    }

    private void executeAsync(Runnable runnable) {
        try {
            this.executor.submit(runnable);
        } catch (Exception e2) {
            f.e().b(Answers.TAG, "Failed to submit events task", e2);
        }
    }

    private void executeSync(Runnable runnable) {
        try {
            this.executor.submit(runnable).get();
        } catch (Exception e2) {
            f.e().b(Answers.TAG, "Failed to run events task", e2);
        }
    }

    public void disable() {
        executeAsync(new Runnable() {
            public void run() {
                try {
                    SessionAnalyticsManagerStrategy sessionAnalyticsManagerStrategy = AnswersEventsHandler.this.strategy;
                    AnswersEventsHandler.this.strategy = new DisabledSessionAnalyticsManagerStrategy();
                    sessionAnalyticsManagerStrategy.deleteAllEvents();
                } catch (Exception e2) {
                    f.e().b(Answers.TAG, "Failed to disable events", e2);
                }
            }
        });
    }

    public void enable() {
        executeAsync(new Runnable() {
            public void run() {
                try {
                    SessionEventMetadata metadata = AnswersEventsHandler.this.metadataCollector.getMetadata();
                    SessionAnalyticsFilesManager analyticsFilesManager = AnswersEventsHandler.this.filesManagerProvider.getAnalyticsFilesManager();
                    analyticsFilesManager.registerRollOverListener(AnswersEventsHandler.this);
                    AnswersEventsHandler answersEventsHandler = AnswersEventsHandler.this;
                    EnabledSessionAnalyticsManagerStrategy enabledSessionAnalyticsManagerStrategy = new EnabledSessionAnalyticsManagerStrategy(AnswersEventsHandler.this.kit, AnswersEventsHandler.this.context, AnswersEventsHandler.this.executor, analyticsFilesManager, AnswersEventsHandler.this.requestFactory, metadata, AnswersEventsHandler.this.firebaseAnalyticsApiAdapter);
                    answersEventsHandler.strategy = enabledSessionAnalyticsManagerStrategy;
                } catch (Exception e2) {
                    f.e().b(Answers.TAG, "Failed to enable events", e2);
                }
            }
        });
    }

    public void flushEvents() {
        executeAsync(new Runnable() {
            public void run() {
                try {
                    AnswersEventsHandler.this.strategy.rollFileOver();
                } catch (Exception e2) {
                    f.e().b(Answers.TAG, "Failed to flush events", e2);
                }
            }
        });
    }

    public void onRollOver(String str) {
        executeAsync(new Runnable() {
            public void run() {
                try {
                    AnswersEventsHandler.this.strategy.sendEvents();
                } catch (Exception e2) {
                    f.e().b(Answers.TAG, "Failed to send events files", e2);
                }
            }
        });
    }

    /* access modifiers changed from: 0000 */
    public void processEvent(final Builder builder, boolean z, final boolean z2) {
        AnonymousClass6 r0 = new Runnable() {
            public void run() {
                try {
                    AnswersEventsHandler.this.strategy.processEvent(builder);
                    if (z2) {
                        AnswersEventsHandler.this.strategy.rollFileOver();
                    }
                } catch (Exception e2) {
                    f.e().b(Answers.TAG, "Failed to process event", e2);
                }
            }
        };
        if (z) {
            executeSync(r0);
        } else {
            executeAsync(r0);
        }
    }

    public void processEventAsync(Builder builder) {
        processEvent(builder, false, false);
    }

    public void processEventAsyncAndFlush(Builder builder) {
        processEvent(builder, false, true);
    }

    public void processEventSync(Builder builder) {
        processEvent(builder, true, false);
    }

    public void setAnalyticsSettingsData(final b bVar, final String str) {
        executeAsync(new Runnable() {
            public void run() {
                try {
                    AnswersEventsHandler.this.strategy.setAnalyticsSettingsData(bVar, str);
                } catch (Exception e2) {
                    f.e().b(Answers.TAG, "Failed to set analytics settings data", e2);
                }
            }
        });
    }
}
