package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.C0436sd;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.measurement.sd reason: case insensitive filesystem */
public abstract class C0436sd<M extends C0436sd<M>> extends C0466xd {

    /* renamed from: b reason: collision with root package name */
    protected C0448ud f5365b = null;

    /* access modifiers changed from: protected */
    public int a() {
        if (this.f5365b == null) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f5365b.b(); i3++) {
            i2 += this.f5365b.b(i3).a();
        }
        return i2;
    }

    public final /* synthetic */ C0466xd c() throws CloneNotSupportedException {
        return (C0436sd) clone();
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        C0436sd sdVar = (C0436sd) super.clone();
        C0454vd.a(this, sdVar);
        return sdVar;
    }

    public void a(C0425qd qdVar) throws IOException {
        if (this.f5365b != null) {
            for (int i2 = 0; i2 < this.f5365b.b(); i2++) {
                this.f5365b.b(i2).a(qdVar);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean a(C0413od odVar, int i2) throws IOException {
        int a2 = odVar.a();
        if (!odVar.a(i2)) {
            return false;
        }
        int i3 = i2 >>> 3;
        C0478zd zdVar = new C0478zd(i2, odVar.a(a2, odVar.a() - a2));
        C0442td tdVar = null;
        C0448ud udVar = this.f5365b;
        if (udVar == null) {
            this.f5365b = new C0448ud();
        } else {
            tdVar = udVar.a(i3);
        }
        if (tdVar == null) {
            tdVar = new C0442td();
            this.f5365b.a(i3, tdVar);
        }
        tdVar.a(zdVar);
        return true;
    }
}
