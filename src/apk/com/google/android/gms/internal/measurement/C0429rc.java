package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.Eb.b;
import com.google.android.gms.internal.measurement.Eb.e;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.measurement.rc reason: case insensitive filesystem */
final class C0429rc<T> implements Ac<T> {

    /* renamed from: a reason: collision with root package name */
    private final C0400mc f5356a;

    /* renamed from: b reason: collision with root package name */
    private final Tc<?, ?> f5357b;

    /* renamed from: c reason: collision with root package name */
    private final boolean f5358c;

    /* renamed from: d reason: collision with root package name */
    private final C0440tb<?> f5359d;

    private C0429rc(Tc<?, ?> tc, C0440tb<?> tbVar, C0400mc mcVar) {
        this.f5357b = tc;
        this.f5358c = tbVar.a(mcVar);
        this.f5359d = tbVar;
        this.f5356a = mcVar;
    }

    static <T> C0429rc<T> a(Tc<?, ?> tc, C0440tb<?> tbVar, C0400mc mcVar) {
        return new C0429rc<>(tc, tbVar, mcVar);
    }

    public final boolean b(T t, T t2) {
        if (!this.f5357b.d(t).equals(this.f5357b.d(t2))) {
            return false;
        }
        if (this.f5358c) {
            return this.f5359d.a((Object) t).equals(this.f5359d.a((Object) t2));
        }
        return true;
    }

    public final void c(T t) {
        this.f5357b.a((Object) t);
        this.f5359d.c(t);
    }

    public final int d(T t) {
        int hashCode = this.f5357b.d(t).hashCode();
        return this.f5358c ? (hashCode * 53) + this.f5359d.a((Object) t).hashCode() : hashCode;
    }

    public final T a() {
        return this.f5356a.e().z();
    }

    public final void a(T t, T t2) {
        Cc.a(this.f5357b, t, t2);
        if (this.f5358c) {
            Cc.a(this.f5359d, t, t2);
        }
    }

    public final void a(T t, C0419pd pdVar) throws IOException {
        Iterator d2 = this.f5359d.a((Object) t).d();
        while (d2.hasNext()) {
            Entry entry = (Entry) d2.next();
            C0458wb wbVar = (C0458wb) entry.getKey();
            if (wbVar.r() != C0401md.MESSAGE || wbVar.q() || wbVar.t()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (entry instanceof Qb) {
                pdVar.a(wbVar.o(), (Object) ((Qb) entry).a().a());
            } else {
                pdVar.a(wbVar.o(), entry.getValue());
            }
        }
        Tc<?, ?> tc = this.f5357b;
        tc.b(tc.d(t), pdVar);
    }

    public final int b(T t) {
        Tc<?, ?> tc = this.f5357b;
        int f2 = tc.f(tc.d(t)) + 0;
        return this.f5358c ? f2 + this.f5359d.a((Object) t).g() : f2;
    }

    public final void a(T t, byte[] bArr, int i2, int i3, Sa sa) throws IOException {
        Eb eb = (Eb) t;
        Vc vc = eb.zzahz;
        if (vc == Vc.c()) {
            vc = Vc.d();
            eb.zzahz = vc;
        }
        ((b) t).o();
        e eVar = null;
        while (i2 < i3) {
            int a2 = Ta.a(bArr, i2, sa);
            int i4 = sa.f5038a;
            if (i4 == 11) {
                int i5 = 0;
                Object obj = null;
                while (a2 < i3) {
                    a2 = Ta.a(bArr, a2, sa);
                    int i6 = sa.f5038a;
                    int i7 = i6 >>> 3;
                    int i8 = i6 & 7;
                    if (i7 != 2) {
                        if (i7 == 3) {
                            if (eVar != null) {
                                C0459wc.a();
                                throw new NoSuchMethodError();
                            } else if (i8 == 2) {
                                a2 = Ta.e(bArr, a2, sa);
                                obj = (Xa) sa.f5040c;
                            }
                        }
                    } else if (i8 == 0) {
                        a2 = Ta.a(bArr, a2, sa);
                        i5 = sa.f5038a;
                        eVar = (e) this.f5359d.a(sa.f5041d, this.f5356a, i5);
                    }
                    if (i6 == 12) {
                        break;
                    }
                    a2 = Ta.a(i6, bArr, a2, i3, sa);
                }
                if (obj != null) {
                    vc.a((i5 << 3) | 2, obj);
                }
                i2 = a2;
            } else if ((i4 & 7) == 2) {
                eVar = (e) this.f5359d.a(sa.f5041d, this.f5356a, i4 >>> 3);
                if (eVar == null) {
                    i2 = Ta.a(i4, bArr, a2, i3, vc, sa);
                } else {
                    C0459wc.a();
                    throw new NoSuchMethodError();
                }
            } else {
                i2 = Ta.a(i4, bArr, a2, i3, sa);
            }
        }
        if (i2 != i3) {
            throw zzfi.h();
        }
    }

    public final void a(T t, Bc bc, C0428rb rbVar) throws IOException {
        boolean z;
        Tc<?, ?> tc = this.f5357b;
        C0440tb<?> tbVar = this.f5359d;
        Object e2 = tc.e(t);
        C0446ub b2 = tbVar.b(t);
        do {
            try {
                if (bc.m() == Integer.MAX_VALUE) {
                    tc.b((Object) t, e2);
                    return;
                }
                int tag = bc.getTag();
                if (tag == 11) {
                    Object obj = null;
                    Xa xa = null;
                    int i2 = 0;
                    while (bc.m() != Integer.MAX_VALUE) {
                        int tag2 = bc.getTag();
                        if (tag2 == 16) {
                            i2 = bc.l();
                            obj = tbVar.a(rbVar, this.f5356a, i2);
                        } else if (tag2 == 26) {
                            if (obj == null) {
                                xa = bc.o();
                            } else {
                                tbVar.a(bc, obj, rbVar, b2);
                                throw null;
                            }
                        } else if (!bc.j()) {
                            break;
                        }
                    }
                    if (bc.getTag() == 12) {
                        if (xa != null) {
                            if (obj == null) {
                                tc.a(e2, i2, xa);
                            } else {
                                tbVar.a(xa, obj, rbVar, b2);
                                throw null;
                            }
                        }
                        z = true;
                        continue;
                    } else {
                        throw zzfi.e();
                    }
                } else if ((tag & 7) == 2) {
                    Object a2 = tbVar.a(rbVar, this.f5356a, tag >>> 3);
                    if (a2 == null) {
                        z = tc.a(e2, bc);
                        continue;
                    } else {
                        tbVar.a(bc, a2, rbVar, b2);
                        throw null;
                    }
                } else {
                    z = bc.j();
                    continue;
                }
            } finally {
                tc.b((Object) t, e2);
            }
        } while (z);
    }

    public final boolean a(T t) {
        return this.f5359d.a((Object) t).c();
    }
}
