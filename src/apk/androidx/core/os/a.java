package androidx.core.os;

import android.os.Build.VERSION;
import android.os.CancellationSignal;

/* compiled from: CancellationSignal */
public final class a {

    /* renamed from: a reason: collision with root package name */
    private boolean f1328a;

    /* renamed from: b reason: collision with root package name */
    private C0010a f1329b;

    /* renamed from: c reason: collision with root package name */
    private Object f1330c;

    /* renamed from: d reason: collision with root package name */
    private boolean f1331d;

    /* renamed from: androidx.core.os.a$a reason: collision with other inner class name */
    /* compiled from: CancellationSignal */
    public interface C0010a {
        void onCancel();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r0.onCancel();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001a, code lost:
        if (r1 == null) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0020, code lost:
        if (android.os.Build.VERSION.SDK_INT < 16) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0022, code lost:
        ((android.os.CancellationSignal) r1).cancel();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0028, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r4.f1331d = false;
        notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002f, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0033, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r4.f1331d = false;
        notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0039, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x003a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        if (r0 == null) goto L_0x001a;
     */
    public void a() {
        synchronized (this) {
            if (!this.f1328a) {
                this.f1328a = true;
                this.f1331d = true;
                C0010a aVar = this.f1329b;
                Object obj = this.f1330c;
            }
        }
    }

    public Object b() {
        Object obj;
        if (VERSION.SDK_INT < 16) {
            return null;
        }
        synchronized (this) {
            if (this.f1330c == null) {
                this.f1330c = new CancellationSignal();
                if (this.f1328a) {
                    ((CancellationSignal) this.f1330c).cancel();
                }
            }
            obj = this.f1330c;
        }
        return obj;
    }
}
