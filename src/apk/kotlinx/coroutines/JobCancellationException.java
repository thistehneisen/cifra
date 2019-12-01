package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.e.b.h;

/* compiled from: Exceptions.kt */
public final class JobCancellationException extends CancellationException {
    public final e job;

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        if (kotlin.e.b.h.a((java.lang.Object) r3.getCause(), (java.lang.Object) getCause()) != false) goto L_0x0031;
     */
    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof JobCancellationException) {
                JobCancellationException jobCancellationException = (JobCancellationException) obj;
                if (h.a((Object) jobCancellationException.getMessage(), (Object) getMessage())) {
                    if (h.a((Object) jobCancellationException.job, (Object) this.job)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public Throwable fillInStackTrace() {
        if (!c.f10357a) {
            return this;
        }
        Throwable fillInStackTrace = super.fillInStackTrace();
        h.a((Object) fillInStackTrace, "super.fillInStackTrace()");
        return fillInStackTrace;
    }

    public int hashCode() {
        String message = getMessage();
        if (message != null) {
            int hashCode = ((message.hashCode() * 31) + this.job.hashCode()) * 31;
            Throwable cause = getCause();
            return hashCode + (cause != null ? cause.hashCode() : 0);
        }
        h.a();
        throw null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("; job=");
        sb.append(this.job);
        return sb.toString();
    }
}
