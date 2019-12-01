package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.measurement.da reason: case insensitive filesystem */
public final class C0344da extends C0436sd<C0344da> {

    /* renamed from: c reason: collision with root package name */
    public Long f5154c = null;

    /* renamed from: d reason: collision with root package name */
    public String f5155d = null;

    /* renamed from: e reason: collision with root package name */
    private Integer f5156e = null;

    /* renamed from: f reason: collision with root package name */
    public M[] f5157f = new M[0];

    /* renamed from: g reason: collision with root package name */
    public C0350ea[] f5158g = C0350ea.d();

    /* renamed from: h reason: collision with root package name */
    public C0337ca[] f5159h = C0337ca.d();

    /* renamed from: i reason: collision with root package name */
    private String f5160i = null;

    /* renamed from: j reason: collision with root package name */
    public Boolean f5161j = null;

    public final void a(C0425qd qdVar) throws IOException {
        Long l2 = this.f5154c;
        int i2 = 0;
        if (l2 != null) {
            long longValue = l2.longValue();
            qdVar.a(1, 0);
            qdVar.a(longValue);
        }
        String str = this.f5155d;
        if (str != null) {
            qdVar.a(2, str);
        }
        Integer num = this.f5156e;
        if (num != null) {
            qdVar.b(3, num.intValue());
        }
        M[] mArr = this.f5157f;
        if (mArr != null && mArr.length > 0) {
            int i3 = 0;
            while (true) {
                M[] mArr2 = this.f5157f;
                if (i3 >= mArr2.length) {
                    break;
                }
                M m = mArr2[i3];
                if (m != null) {
                    qdVar.a(4, (C0400mc) m);
                }
                i3++;
            }
        }
        C0350ea[] eaVarArr = this.f5158g;
        if (eaVarArr != null && eaVarArr.length > 0) {
            int i4 = 0;
            while (true) {
                C0350ea[] eaVarArr2 = this.f5158g;
                if (i4 >= eaVarArr2.length) {
                    break;
                }
                C0350ea eaVar = eaVarArr2[i4];
                if (eaVar != null) {
                    qdVar.a(5, (C0466xd) eaVar);
                }
                i4++;
            }
        }
        C0337ca[] caVarArr = this.f5159h;
        if (caVarArr != null && caVarArr.length > 0) {
            while (true) {
                C0337ca[] caVarArr2 = this.f5159h;
                if (i2 >= caVarArr2.length) {
                    break;
                }
                C0337ca caVar = caVarArr2[i2];
                if (caVar != null) {
                    qdVar.a(6, (C0466xd) caVar);
                }
                i2++;
            }
        }
        String str2 = this.f5160i;
        if (str2 != null) {
            qdVar.a(7, str2);
        }
        Boolean bool = this.f5161j;
        if (bool != null) {
            qdVar.a(8, bool.booleanValue());
        }
        super.a(qdVar);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0344da)) {
            return false;
        }
        C0344da daVar = (C0344da) obj;
        Long l2 = this.f5154c;
        if (l2 == null) {
            if (daVar.f5154c != null) {
                return false;
            }
        } else if (!l2.equals(daVar.f5154c)) {
            return false;
        }
        String str = this.f5155d;
        if (str == null) {
            if (daVar.f5155d != null) {
                return false;
            }
        } else if (!str.equals(daVar.f5155d)) {
            return false;
        }
        Integer num = this.f5156e;
        if (num == null) {
            if (daVar.f5156e != null) {
                return false;
            }
        } else if (!num.equals(daVar.f5156e)) {
            return false;
        }
        if (!C0454vd.a((Object[]) this.f5157f, (Object[]) daVar.f5157f) || !C0454vd.a((Object[]) this.f5158g, (Object[]) daVar.f5158g) || !C0454vd.a((Object[]) this.f5159h, (Object[]) daVar.f5159h)) {
            return false;
        }
        String str2 = this.f5160i;
        if (str2 == null) {
            if (daVar.f5160i != null) {
                return false;
            }
        } else if (!str2.equals(daVar.f5160i)) {
            return false;
        }
        Boolean bool = this.f5161j;
        if (bool == null) {
            if (daVar.f5161j != null) {
                return false;
            }
        } else if (!bool.equals(daVar.f5161j)) {
            return false;
        }
        C0448ud udVar = this.f5365b;
        if (udVar != null && !udVar.a()) {
            return this.f5365b.equals(daVar.f5365b);
        }
        C0448ud udVar2 = daVar.f5365b;
        return udVar2 == null || udVar2.a();
    }

    public final int hashCode() {
        int hashCode = (C0344da.class.getName().hashCode() + 527) * 31;
        Long l2 = this.f5154c;
        int i2 = 0;
        int hashCode2 = (hashCode + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str = this.f5155d;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.f5156e;
        int hashCode4 = (((((((hashCode3 + (num == null ? 0 : num.hashCode())) * 31) + C0454vd.a(this.f5157f)) * 31) + C0454vd.a(this.f5158g)) * 31) + C0454vd.a(this.f5159h)) * 31;
        String str2 = this.f5160i;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.f5161j;
        int hashCode6 = (hashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        C0448ud udVar = this.f5365b;
        if (udVar != null && !udVar.a()) {
            i2 = this.f5365b.hashCode();
        }
        return hashCode6 + i2;
    }

    /* access modifiers changed from: protected */
    public final int a() {
        int a2 = super.a();
        Long l2 = this.f5154c;
        if (l2 != null) {
            long longValue = l2.longValue();
            int a3 = C0425qd.a(1);
            int i2 = (-128 & longValue) == 0 ? 1 : (-16384 & longValue) == 0 ? 2 : (-2097152 & longValue) == 0 ? 3 : (-268435456 & longValue) == 0 ? 4 : (-34359738368L & longValue) == 0 ? 5 : (-4398046511104L & longValue) == 0 ? 6 : (-562949953421312L & longValue) == 0 ? 7 : (-72057594037927936L & longValue) == 0 ? 8 : (longValue & Long.MIN_VALUE) == 0 ? 9 : 10;
            a2 += a3 + i2;
        }
        String str = this.f5155d;
        if (str != null) {
            a2 += C0425qd.b(2, str);
        }
        Integer num = this.f5156e;
        if (num != null) {
            a2 += C0425qd.c(3, num.intValue());
        }
        M[] mArr = this.f5157f;
        int i3 = 0;
        if (mArr != null && mArr.length > 0) {
            int i4 = a2;
            int i5 = 0;
            while (true) {
                M[] mArr2 = this.f5157f;
                if (i5 >= mArr2.length) {
                    break;
                }
                M m = mArr2[i5];
                if (m != null) {
                    i4 += zzee.c(4, (C0400mc) m);
                }
                i5++;
            }
            a2 = i4;
        }
        C0350ea[] eaVarArr = this.f5158g;
        if (eaVarArr != null && eaVarArr.length > 0) {
            int i6 = a2;
            int i7 = 0;
            while (true) {
                C0350ea[] eaVarArr2 = this.f5158g;
                if (i7 >= eaVarArr2.length) {
                    break;
                }
                C0350ea eaVar = eaVarArr2[i7];
                if (eaVar != null) {
                    i6 += C0425qd.b(5, (C0466xd) eaVar);
                }
                i7++;
            }
            a2 = i6;
        }
        C0337ca[] caVarArr = this.f5159h;
        if (caVarArr != null && caVarArr.length > 0) {
            while (true) {
                C0337ca[] caVarArr2 = this.f5159h;
                if (i3 >= caVarArr2.length) {
                    break;
                }
                C0337ca caVar = caVarArr2[i3];
                if (caVar != null) {
                    a2 += C0425qd.b(6, (C0466xd) caVar);
                }
                i3++;
            }
        }
        String str2 = this.f5160i;
        if (str2 != null) {
            a2 += C0425qd.b(7, str2);
        }
        Boolean bool = this.f5161j;
        if (bool == null) {
            return a2;
        }
        bool.booleanValue();
        return a2 + C0425qd.a(8) + 1;
    }

    public final /* synthetic */ C0466xd a(C0413od odVar) throws IOException {
        while (true) {
            int c2 = odVar.c();
            if (c2 == 0) {
                return this;
            }
            if (c2 == 8) {
                this.f5154c = Long.valueOf(odVar.f());
            } else if (c2 == 18) {
                this.f5155d = odVar.b();
            } else if (c2 == 24) {
                this.f5156e = Integer.valueOf(odVar.e());
            } else if (c2 == 34) {
                int a2 = C0472yd.a(odVar, 34);
                M[] mArr = this.f5157f;
                int length = mArr == null ? 0 : mArr.length;
                M[] mArr2 = new M[(a2 + length)];
                if (length != 0) {
                    System.arraycopy(this.f5157f, 0, mArr2, 0, length);
                }
                while (length < mArr2.length - 1) {
                    mArr2[length] = (M) odVar.a(M.q());
                    odVar.c();
                    length++;
                }
                mArr2[length] = (M) odVar.a(M.q());
                this.f5157f = mArr2;
            } else if (c2 == 42) {
                int a3 = C0472yd.a(odVar, 42);
                C0350ea[] eaVarArr = this.f5158g;
                int length2 = eaVarArr == null ? 0 : eaVarArr.length;
                C0350ea[] eaVarArr2 = new C0350ea[(a3 + length2)];
                if (length2 != 0) {
                    System.arraycopy(this.f5158g, 0, eaVarArr2, 0, length2);
                }
                while (length2 < eaVarArr2.length - 1) {
                    eaVarArr2[length2] = new C0350ea();
                    odVar.a((C0466xd) eaVarArr2[length2]);
                    odVar.c();
                    length2++;
                }
                eaVarArr2[length2] = new C0350ea();
                odVar.a((C0466xd) eaVarArr2[length2]);
                this.f5158g = eaVarArr2;
            } else if (c2 == 50) {
                int a4 = C0472yd.a(odVar, 50);
                C0337ca[] caVarArr = this.f5159h;
                int length3 = caVarArr == null ? 0 : caVarArr.length;
                C0337ca[] caVarArr2 = new C0337ca[(a4 + length3)];
                if (length3 != 0) {
                    System.arraycopy(this.f5159h, 0, caVarArr2, 0, length3);
                }
                while (length3 < caVarArr2.length - 1) {
                    caVarArr2[length3] = new C0337ca();
                    odVar.a((C0466xd) caVarArr2[length3]);
                    odVar.c();
                    length3++;
                }
                caVarArr2[length3] = new C0337ca();
                odVar.a((C0466xd) caVarArr2[length3]);
                this.f5159h = caVarArr2;
            } else if (c2 == 58) {
                this.f5160i = odVar.b();
            } else if (c2 == 64) {
                this.f5161j = Boolean.valueOf(odVar.d());
            } else if (!super.a(odVar, c2)) {
                return this;
            }
        }
    }
}
