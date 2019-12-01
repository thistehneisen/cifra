package b.p;

import android.os.IBinder;

/* compiled from: WindowIdApi14 */
class ia implements ka {

    /* renamed from: a reason: collision with root package name */
    private final IBinder f2897a;

    ia(IBinder iBinder) {
        this.f2897a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ia) && ((ia) obj).f2897a.equals(this.f2897a);
    }

    public int hashCode() {
        return this.f2897a.hashCode();
    }
}
