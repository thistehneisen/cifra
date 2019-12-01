package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.measurement.ea reason: case insensitive filesystem */
public final class C0350ea extends C0436sd<C0350ea> {

    /* renamed from: c reason: collision with root package name */
    private static volatile C0350ea[] f5166c;

    /* renamed from: d reason: collision with root package name */
    public String f5167d = null;

    /* renamed from: e reason: collision with root package name */
    public Boolean f5168e = null;

    /* renamed from: f reason: collision with root package name */
    public Boolean f5169f = null;

    /* renamed from: g reason: collision with root package name */
    public Integer f5170g = null;

    public static C0350ea[] d() {
        if (f5166c == null) {
            synchronized (C0454vd.f5409c) {
                if (f5166c == null) {
                    f5166c = new C0350ea[0];
                }
            }
        }
        return f5166c;
    }

    public final void a(C0425qd qdVar) throws IOException {
        String str = this.f5167d;
        if (str != null) {
            qdVar.a(1, str);
        }
        Boolean bool = this.f5168e;
        if (bool != null) {
            qdVar.a(2, bool.booleanValue());
        }
        Boolean bool2 = this.f5169f;
        if (bool2 != null) {
            qdVar.a(3, bool2.booleanValue());
        }
        Integer num = this.f5170g;
        if (num != null) {
            qdVar.b(4, num.intValue());
        }
        super.a(qdVar);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0350ea)) {
            return false;
        }
        C0350ea eaVar = (C0350ea) obj;
        String str = this.f5167d;
        if (str == null) {
            if (eaVar.f5167d != null) {
                return false;
            }
        } else if (!str.equals(eaVar.f5167d)) {
            return false;
        }
        Boolean bool = this.f5168e;
        if (bool == null) {
            if (eaVar.f5168e != null) {
                return false;
            }
        } else if (!bool.equals(eaVar.f5168e)) {
            return false;
        }
        Boolean bool2 = this.f5169f;
        if (bool2 == null) {
            if (eaVar.f5169f != null) {
                return false;
            }
        } else if (!bool2.equals(eaVar.f5169f)) {
            return false;
        }
        Integer num = this.f5170g;
        if (num == null) {
            if (eaVar.f5170g != null) {
                return false;
            }
        } else if (!num.equals(eaVar.f5170g)) {
            return false;
        }
        C0448ud udVar = this.f5365b;
        if (udVar != null && !udVar.a()) {
            return this.f5365b.equals(eaVar.f5365b);
        }
        C0448ud udVar2 = eaVar.f5365b;
        return udVar2 == null || udVar2.a();
    }

    public final int hashCode() {
        int hashCode = (C0350ea.class.getName().hashCode() + 527) * 31;
        String str = this.f5167d;
        int i2 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.f5168e;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.f5169f;
        int hashCode4 = (hashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Integer num = this.f5170g;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        C0448ud udVar = this.f5365b;
        if (udVar != null && !udVar.a()) {
            i2 = this.f5365b.hashCode();
        }
        return hashCode5 + i2;
    }

    /* access modifiers changed from: protected */
    public final int a() {
        int a2 = super.a();
        String str = this.f5167d;
        if (str != null) {
            a2 += C0425qd.b(1, str);
        }
        Boolean bool = this.f5168e;
        if (bool != null) {
            bool.booleanValue();
            a2 += C0425qd.a(2) + 1;
        }
        Boolean bool2 = this.f5169f;
        if (bool2 != null) {
            bool2.booleanValue();
            a2 += C0425qd.a(3) + 1;
        }
        Integer num = this.f5170g;
        return num != null ? a2 + C0425qd.c(4, num.intValue()) : a2;
    }

    public final /* synthetic */ C0466xd a(C0413od odVar) throws IOException {
        while (true) {
            int c2 = odVar.c();
            if (c2 == 0) {
                return this;
            }
            if (c2 == 10) {
                this.f5167d = odVar.b();
            } else if (c2 == 16) {
                this.f5168e = Boolean.valueOf(odVar.d());
            } else if (c2 == 24) {
                this.f5169f = Boolean.valueOf(odVar.d());
            } else if (c2 == 32) {
                this.f5170g = Integer.valueOf(odVar.e());
            } else if (!super.a(odVar, c2)) {
                return this;
            }
        }
    }
}
