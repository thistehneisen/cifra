package com.google.android.gms.internal.measurement;

import java.io.Serializable;

final class La<T> implements Ja<T>, Serializable {

    /* renamed from: a reason: collision with root package name */
    private volatile transient boolean f4985a;

    /* renamed from: b reason: collision with root package name */
    private transient T f4986b;
    private final Ja<T> zzabs;

    La(Ja<T> ja) {
        Ga.a(ja);
        this.zzabs = ja;
    }

    public final T get() {
        if (!this.f4985a) {
            synchronized (this) {
                if (!this.f4985a) {
                    T t = this.zzabs.get();
                    this.f4986b = t;
                    this.f4985a = true;
                    return t;
                }
            }
        }
        return this.f4986b;
    }

    public final String toString() {
        Object obj;
        if (this.f4985a) {
            String valueOf = String.valueOf(this.f4986b);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 25);
            sb.append("<supplier that returned ");
            sb.append(valueOf);
            sb.append(">");
            obj = sb.toString();
        } else {
            obj = this.zzabs;
        }
        String valueOf2 = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(valueOf2);
        sb2.append(")");
        return sb2.toString();
    }
}
