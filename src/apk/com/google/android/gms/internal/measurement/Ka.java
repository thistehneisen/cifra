package com.google.android.gms.internal.measurement;

final class Ka<T> implements Ja<T> {

    /* renamed from: a reason: collision with root package name */
    private volatile Ja<T> f4974a;

    /* renamed from: b reason: collision with root package name */
    private volatile boolean f4975b;

    /* renamed from: c reason: collision with root package name */
    private T f4976c;

    Ka(Ja<T> ja) {
        Ga.a(ja);
        this.f4974a = ja;
    }

    public final T get() {
        if (!this.f4975b) {
            synchronized (this) {
                if (!this.f4975b) {
                    T t = this.f4974a.get();
                    this.f4976c = t;
                    this.f4975b = true;
                    this.f4974a = null;
                    return t;
                }
            }
        }
        return this.f4976c;
    }

    public final String toString() {
        Object obj = this.f4974a;
        if (obj == null) {
            String valueOf = String.valueOf(this.f4976c);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 25);
            sb.append("<supplier that returned ");
            sb.append(valueOf);
            sb.append(">");
            obj = sb.toString();
        }
        String valueOf2 = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(valueOf2);
        sb2.append(")");
        return sb2.toString();
    }
}
