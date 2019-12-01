package b.e.b;

import b.e.b.i.a;

/* compiled from: ArrayRow */
public class b implements a {

    /* renamed from: a reason: collision with root package name */
    i f2423a = null;

    /* renamed from: b reason: collision with root package name */
    float f2424b = 0.0f;

    /* renamed from: c reason: collision with root package name */
    boolean f2425c = false;

    /* renamed from: d reason: collision with root package name */
    public final a f2426d;

    /* renamed from: e reason: collision with root package name */
    boolean f2427e = false;

    public b(c cVar) {
        this.f2426d = new a(this, cVar);
    }

    public b a(i iVar, i iVar2, int i2) {
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            this.f2424b = (float) i2;
        }
        if (!z) {
            this.f2426d.a(iVar, -1.0f);
            this.f2426d.a(iVar2, 1.0f);
        } else {
            this.f2426d.a(iVar, 1.0f);
            this.f2426d.a(iVar2, -1.0f);
        }
        return this;
    }

    /* access modifiers changed from: 0000 */
    public boolean b() {
        i iVar = this.f2423a;
        return iVar != null && (iVar.f2464h == a.UNRESTRICTED || this.f2424b >= 0.0f);
    }

    public b c(i iVar, int i2) {
        if (i2 < 0) {
            this.f2424b = (float) (i2 * -1);
            this.f2426d.a(iVar, 1.0f);
        } else {
            this.f2424b = (float) i2;
            this.f2426d.a(iVar, -1.0f);
        }
        return this;
    }

    public void clear() {
        this.f2426d.a();
        this.f2423a = null;
        this.f2424b = 0.0f;
    }

    public void d() {
        this.f2423a = null;
        this.f2426d.a();
        this.f2424b = 0.0f;
        this.f2427e = false;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ce  */
    public String e() {
        String str;
        boolean z;
        String str2;
        String sb;
        String str3 = "";
        if (this.f2423a == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append("0");
            str = sb2.toString();
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str3);
            sb3.append(this.f2423a);
            str = sb3.toString();
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append(str);
        sb4.append(" = ");
        String sb5 = sb4.toString();
        if (this.f2424b != 0.0f) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(sb5);
            sb6.append(this.f2424b);
            sb5 = sb6.toString();
            z = true;
        } else {
            z = false;
        }
        int i2 = this.f2426d.f2320a;
        for (int i3 = 0; i3 < i2; i3++) {
            i a2 = this.f2426d.a(i3);
            if (a2 != null) {
                float b2 = this.f2426d.b(i3);
                int i4 = (b2 > 0.0f ? 1 : (b2 == 0.0f ? 0 : -1));
                if (i4 != 0) {
                    String iVar = a2.toString();
                    if (!z) {
                        if (b2 < 0.0f) {
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append(str2);
                            sb7.append("- ");
                            str2 = sb7.toString();
                        }
                        if (b2 == 1.0f) {
                            StringBuilder sb8 = new StringBuilder();
                            sb8.append(str2);
                            sb8.append(iVar);
                            sb = sb8.toString();
                        } else {
                            StringBuilder sb9 = new StringBuilder();
                            sb9.append(str2);
                            sb9.append(b2);
                            sb9.append(" ");
                            sb9.append(iVar);
                            sb = sb9.toString();
                        }
                        z = true;
                    } else if (i4 > 0) {
                        StringBuilder sb10 = new StringBuilder();
                        sb10.append(str2);
                        sb10.append(" + ");
                        str2 = sb10.toString();
                        if (b2 == 1.0f) {
                        }
                        z = true;
                    } else {
                        StringBuilder sb11 = new StringBuilder();
                        sb11.append(str2);
                        sb11.append(" - ");
                        str2 = sb11.toString();
                    }
                    b2 *= -1.0f;
                    if (b2 == 1.0f) {
                    }
                    z = true;
                }
            }
        }
        if (z) {
            return str2;
        }
        StringBuilder sb12 = new StringBuilder();
        sb12.append(str2);
        sb12.append("0.0");
        return sb12.toString();
    }

    public i getKey() {
        return this.f2423a;
    }

    public String toString() {
        return e();
    }

    /* access modifiers changed from: 0000 */
    public boolean b(i iVar) {
        return this.f2426d.a(iVar);
    }

    /* access modifiers changed from: 0000 */
    public b b(i iVar, int i2) {
        this.f2423a = iVar;
        float f2 = (float) i2;
        iVar.f2462f = f2;
        this.f2424b = f2;
        this.f2427e = true;
        return this;
    }

    /* access modifiers changed from: 0000 */
    public i c(i iVar) {
        return this.f2426d.a((boolean[]) null, iVar);
    }

    /* access modifiers changed from: 0000 */
    public void d(i iVar) {
        i iVar2 = this.f2423a;
        if (iVar2 != null) {
            this.f2426d.a(iVar2, -1.0f);
            this.f2423a = null;
        }
        float a2 = this.f2426d.a(iVar, true) * -1.0f;
        this.f2423a = iVar;
        if (a2 != 1.0f) {
            this.f2424b /= a2;
            this.f2426d.a(a2);
        }
    }

    /* access modifiers changed from: 0000 */
    public b a(i iVar, int i2) {
        this.f2426d.a(iVar, (float) i2);
        return this;
    }

    public boolean c() {
        return this.f2423a == null && this.f2424b == 0.0f && this.f2426d.f2320a == 0;
    }

    public b a(i iVar, i iVar2, i iVar3, int i2) {
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            this.f2424b = (float) i2;
        }
        if (!z) {
            this.f2426d.a(iVar, -1.0f);
            this.f2426d.a(iVar2, 1.0f);
            this.f2426d.a(iVar3, 1.0f);
        } else {
            this.f2426d.a(iVar, 1.0f);
            this.f2426d.a(iVar2, -1.0f);
            this.f2426d.a(iVar3, -1.0f);
        }
        return this;
    }

    public b b(i iVar, i iVar2, i iVar3, int i2) {
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            this.f2424b = (float) i2;
        }
        if (!z) {
            this.f2426d.a(iVar, -1.0f);
            this.f2426d.a(iVar2, 1.0f);
            this.f2426d.a(iVar3, -1.0f);
        } else {
            this.f2426d.a(iVar, 1.0f);
            this.f2426d.a(iVar2, -1.0f);
            this.f2426d.a(iVar3, 1.0f);
        }
        return this;
    }

    public b a(float f2, float f3, float f4, i iVar, i iVar2, i iVar3, i iVar4) {
        this.f2424b = 0.0f;
        if (f3 == 0.0f || f2 == f4) {
            this.f2426d.a(iVar, 1.0f);
            this.f2426d.a(iVar2, -1.0f);
            this.f2426d.a(iVar4, 1.0f);
            this.f2426d.a(iVar3, -1.0f);
        } else if (f2 == 0.0f) {
            this.f2426d.a(iVar, 1.0f);
            this.f2426d.a(iVar2, -1.0f);
        } else if (f4 == 0.0f) {
            this.f2426d.a(iVar3, 1.0f);
            this.f2426d.a(iVar4, -1.0f);
        } else {
            float f5 = (f2 / f3) / (f4 / f3);
            this.f2426d.a(iVar, 1.0f);
            this.f2426d.a(iVar2, -1.0f);
            this.f2426d.a(iVar4, f5);
            this.f2426d.a(iVar3, -f5);
        }
        return this;
    }

    public b b(i iVar, i iVar2, i iVar3, i iVar4, float f2) {
        this.f2426d.a(iVar3, 0.5f);
        this.f2426d.a(iVar4, 0.5f);
        this.f2426d.a(iVar, -0.5f);
        this.f2426d.a(iVar2, -0.5f);
        this.f2424b = -f2;
        return this;
    }

    /* access modifiers changed from: 0000 */
    public b a(i iVar, i iVar2, int i2, float f2, i iVar3, i iVar4, int i3) {
        if (iVar2 == iVar3) {
            this.f2426d.a(iVar, 1.0f);
            this.f2426d.a(iVar4, 1.0f);
            this.f2426d.a(iVar2, -2.0f);
            return this;
        }
        if (f2 == 0.5f) {
            this.f2426d.a(iVar, 1.0f);
            this.f2426d.a(iVar2, -1.0f);
            this.f2426d.a(iVar3, -1.0f);
            this.f2426d.a(iVar4, 1.0f);
            if (i2 > 0 || i3 > 0) {
                this.f2424b = (float) ((-i2) + i3);
            }
        } else if (f2 <= 0.0f) {
            this.f2426d.a(iVar, -1.0f);
            this.f2426d.a(iVar2, 1.0f);
            this.f2424b = (float) i2;
        } else if (f2 >= 1.0f) {
            this.f2426d.a(iVar3, -1.0f);
            this.f2426d.a(iVar4, 1.0f);
            this.f2424b = (float) i3;
        } else {
            float f3 = 1.0f - f2;
            this.f2426d.a(iVar, f3 * 1.0f);
            this.f2426d.a(iVar2, f3 * -1.0f);
            this.f2426d.a(iVar3, -1.0f * f2);
            this.f2426d.a(iVar4, 1.0f * f2);
            if (i2 > 0 || i3 > 0) {
                this.f2424b = (((float) (-i2)) * f3) + (((float) i3) * f2);
            }
        }
        return this;
    }

    public b a(e eVar, int i2) {
        this.f2426d.a(eVar.a(i2, "ep"), 1.0f);
        this.f2426d.a(eVar.a(i2, "em"), -1.0f);
        return this;
    }

    /* access modifiers changed from: 0000 */
    public b a(i iVar, i iVar2, i iVar3, float f2) {
        this.f2426d.a(iVar, -1.0f);
        this.f2426d.a(iVar2, 1.0f - f2);
        this.f2426d.a(iVar3, f2);
        return this;
    }

    public b a(i iVar, i iVar2, i iVar3, i iVar4, float f2) {
        this.f2426d.a(iVar, -1.0f);
        this.f2426d.a(iVar2, 1.0f);
        this.f2426d.a(iVar3, f2);
        this.f2426d.a(iVar4, -f2);
        return this;
    }

    /* access modifiers changed from: 0000 */
    public void a() {
        float f2 = this.f2424b;
        if (f2 < 0.0f) {
            this.f2424b = f2 * -1.0f;
            this.f2426d.b();
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean a(e eVar) {
        boolean z;
        i a2 = this.f2426d.a(eVar);
        if (a2 == null) {
            z = true;
        } else {
            d(a2);
            z = false;
        }
        if (this.f2426d.f2320a == 0) {
            this.f2427e = true;
        }
        return z;
    }

    public i a(e eVar, boolean[] zArr) {
        return this.f2426d.a(zArr, (i) null);
    }

    public void a(a aVar) {
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            this.f2423a = null;
            this.f2426d.a();
            int i2 = 0;
            while (true) {
                a aVar2 = bVar.f2426d;
                if (i2 < aVar2.f2320a) {
                    this.f2426d.a(aVar2.a(i2), bVar.f2426d.b(i2), true);
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public void a(i iVar) {
        int i2 = iVar.f2461e;
        float f2 = 1.0f;
        if (i2 != 1) {
            if (i2 == 2) {
                f2 = 1000.0f;
            } else if (i2 == 3) {
                f2 = 1000000.0f;
            } else if (i2 == 4) {
                f2 = 1.0E9f;
            } else if (i2 == 5) {
                f2 = 1.0E12f;
            }
        }
        this.f2426d.a(iVar, f2);
    }
}
