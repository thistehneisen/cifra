package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.measurement.ca reason: case insensitive filesystem */
public final class C0337ca extends C0436sd<C0337ca> {

    /* renamed from: c reason: collision with root package name */
    private static volatile C0337ca[] f5134c;

    /* renamed from: d reason: collision with root package name */
    public Integer f5135d = null;

    /* renamed from: e reason: collision with root package name */
    public F[] f5136e = new F[0];

    /* renamed from: f reason: collision with root package name */
    public C[] f5137f = new C[0];

    /* renamed from: g reason: collision with root package name */
    private Boolean f5138g = null;

    /* renamed from: h reason: collision with root package name */
    private Boolean f5139h = null;

    public static C0337ca[] d() {
        if (f5134c == null) {
            synchronized (C0454vd.f5409c) {
                if (f5134c == null) {
                    f5134c = new C0337ca[0];
                }
            }
        }
        return f5134c;
    }

    public final void a(C0425qd qdVar) throws IOException {
        Integer num = this.f5135d;
        if (num != null) {
            qdVar.b(1, num.intValue());
        }
        F[] fArr = this.f5136e;
        int i2 = 0;
        if (fArr != null && fArr.length > 0) {
            int i3 = 0;
            while (true) {
                F[] fArr2 = this.f5136e;
                if (i3 >= fArr2.length) {
                    break;
                }
                F f2 = fArr2[i3];
                if (f2 != null) {
                    qdVar.a(2, (C0400mc) f2);
                }
                i3++;
            }
        }
        C[] cArr = this.f5137f;
        if (cArr != null && cArr.length > 0) {
            while (true) {
                C[] cArr2 = this.f5137f;
                if (i2 >= cArr2.length) {
                    break;
                }
                C c2 = cArr2[i2];
                if (c2 != null) {
                    qdVar.a(3, (C0400mc) c2);
                }
                i2++;
            }
        }
        Boolean bool = this.f5138g;
        if (bool != null) {
            qdVar.a(4, bool.booleanValue());
        }
        Boolean bool2 = this.f5139h;
        if (bool2 != null) {
            qdVar.a(5, bool2.booleanValue());
        }
        super.a(qdVar);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0337ca)) {
            return false;
        }
        C0337ca caVar = (C0337ca) obj;
        Integer num = this.f5135d;
        if (num == null) {
            if (caVar.f5135d != null) {
                return false;
            }
        } else if (!num.equals(caVar.f5135d)) {
            return false;
        }
        if (!C0454vd.a((Object[]) this.f5136e, (Object[]) caVar.f5136e) || !C0454vd.a((Object[]) this.f5137f, (Object[]) caVar.f5137f)) {
            return false;
        }
        Boolean bool = this.f5138g;
        if (bool == null) {
            if (caVar.f5138g != null) {
                return false;
            }
        } else if (!bool.equals(caVar.f5138g)) {
            return false;
        }
        Boolean bool2 = this.f5139h;
        if (bool2 == null) {
            if (caVar.f5139h != null) {
                return false;
            }
        } else if (!bool2.equals(caVar.f5139h)) {
            return false;
        }
        C0448ud udVar = this.f5365b;
        if (udVar != null && !udVar.a()) {
            return this.f5365b.equals(caVar.f5365b);
        }
        C0448ud udVar2 = caVar.f5365b;
        return udVar2 == null || udVar2.a();
    }

    public final int hashCode() {
        int hashCode = (C0337ca.class.getName().hashCode() + 527) * 31;
        Integer num = this.f5135d;
        int i2 = 0;
        int hashCode2 = (((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + C0454vd.a(this.f5136e)) * 31) + C0454vd.a(this.f5137f)) * 31;
        Boolean bool = this.f5138g;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.f5139h;
        int hashCode4 = (hashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        C0448ud udVar = this.f5365b;
        if (udVar != null && !udVar.a()) {
            i2 = this.f5365b.hashCode();
        }
        return hashCode4 + i2;
    }

    /* access modifiers changed from: protected */
    public final int a() {
        int a2 = super.a();
        Integer num = this.f5135d;
        if (num != null) {
            a2 += C0425qd.c(1, num.intValue());
        }
        F[] fArr = this.f5136e;
        int i2 = 0;
        if (fArr != null && fArr.length > 0) {
            int i3 = a2;
            int i4 = 0;
            while (true) {
                F[] fArr2 = this.f5136e;
                if (i4 >= fArr2.length) {
                    break;
                }
                F f2 = fArr2[i4];
                if (f2 != null) {
                    i3 += zzee.c(2, (C0400mc) f2);
                }
                i4++;
            }
            a2 = i3;
        }
        C[] cArr = this.f5137f;
        if (cArr != null && cArr.length > 0) {
            while (true) {
                C[] cArr2 = this.f5137f;
                if (i2 >= cArr2.length) {
                    break;
                }
                C c2 = cArr2[i2];
                if (c2 != null) {
                    a2 += zzee.c(3, (C0400mc) c2);
                }
                i2++;
            }
        }
        Boolean bool = this.f5138g;
        if (bool != null) {
            bool.booleanValue();
            a2 += C0425qd.a(4) + 1;
        }
        Boolean bool2 = this.f5139h;
        if (bool2 == null) {
            return a2;
        }
        bool2.booleanValue();
        return a2 + C0425qd.a(5) + 1;
    }

    public final /* synthetic */ C0466xd a(C0413od odVar) throws IOException {
        while (true) {
            int c2 = odVar.c();
            if (c2 == 0) {
                return this;
            }
            if (c2 == 8) {
                this.f5135d = Integer.valueOf(odVar.e());
            } else if (c2 == 18) {
                int a2 = C0472yd.a(odVar, 18);
                F[] fArr = this.f5136e;
                int length = fArr == null ? 0 : fArr.length;
                F[] fArr2 = new F[(a2 + length)];
                if (length != 0) {
                    System.arraycopy(this.f5136e, 0, fArr2, 0, length);
                }
                while (length < fArr2.length - 1) {
                    fArr2[length] = (F) odVar.a(F.v());
                    odVar.c();
                    length++;
                }
                fArr2[length] = (F) odVar.a(F.v());
                this.f5136e = fArr2;
            } else if (c2 == 26) {
                int a3 = C0472yd.a(odVar, 26);
                C[] cArr = this.f5137f;
                int length2 = cArr == null ? 0 : cArr.length;
                C[] cArr2 = new C[(a3 + length2)];
                if (length2 != 0) {
                    System.arraycopy(this.f5137f, 0, cArr2, 0, length2);
                }
                while (length2 < cArr2.length - 1) {
                    cArr2[length2] = (C) odVar.a(C.C());
                    odVar.c();
                    length2++;
                }
                cArr2[length2] = (C) odVar.a(C.C());
                this.f5137f = cArr2;
            } else if (c2 == 32) {
                this.f5138g = Boolean.valueOf(odVar.d());
            } else if (c2 == 40) {
                this.f5139h = Boolean.valueOf(odVar.d());
            } else if (!super.a(odVar, c2)) {
                return this;
            }
        }
    }
}
