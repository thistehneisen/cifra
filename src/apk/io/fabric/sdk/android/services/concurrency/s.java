package io.fabric.sdk.android.services.concurrency;

/* compiled from: Task */
public interface s {
    boolean isFinished();

    void setError(Throwable th);

    void setFinished(boolean z);
}
