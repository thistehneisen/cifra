package retrofit2.adapter.rxjava2;

import retrofit2.u;

/* compiled from: Result */
public final class d<T> {

    /* renamed from: a reason: collision with root package name */
    private final u<T> f10978a;

    /* renamed from: b reason: collision with root package name */
    private final Throwable f10979b;

    private d(u<T> uVar, Throwable th) {
        this.f10978a = uVar;
        this.f10979b = th;
    }

    public static <T> d<T> a(Throwable th) {
        if (th != null) {
            return new d<>(null, th);
        }
        throw new NullPointerException("error == null");
    }

    public static <T> d<T> a(u<T> uVar) {
        if (uVar != null) {
            return new d<>(uVar, null);
        }
        throw new NullPointerException("response == null");
    }
}
