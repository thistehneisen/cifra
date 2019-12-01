package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.C0458wb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.measurement.ub reason: case insensitive filesystem */
final class C0446ub<FieldDescriptorType extends C0458wb<FieldDescriptorType>> {

    /* renamed from: a reason: collision with root package name */
    private static final C0446ub f5388a = new C0446ub(true);

    /* renamed from: b reason: collision with root package name */
    final Gc<FieldDescriptorType, Object> f5389b = Gc.a(16);

    /* renamed from: c reason: collision with root package name */
    private boolean f5390c;

    /* renamed from: d reason: collision with root package name */
    private boolean f5391d = false;

    private C0446ub() {
    }

    public static <T extends C0458wb<T>> C0446ub<T> f() {
        return f5388a;
    }

    /* access modifiers changed from: 0000 */
    public final Iterator<Entry<FieldDescriptorType, Object>> a() {
        if (this.f5391d) {
            return new Tb(this.f5389b.e().iterator());
        }
        return this.f5389b.e().iterator();
    }

    public final boolean b() {
        return this.f5390c;
    }

    public final boolean c() {
        for (int i2 = 0; i2 < this.f5389b.c(); i2++) {
            if (!a(this.f5389b.b(i2))) {
                return false;
            }
        }
        for (Entry a2 : this.f5389b.d()) {
            if (!a(a2)) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        C0446ub ubVar = new C0446ub();
        for (int i2 = 0; i2 < this.f5389b.c(); i2++) {
            Entry b2 = this.f5389b.b(i2);
            ubVar.b((FieldDescriptorType) (C0458wb) b2.getKey(), b2.getValue());
        }
        for (Entry entry : this.f5389b.d()) {
            ubVar.b((FieldDescriptorType) (C0458wb) entry.getKey(), entry.getValue());
        }
        ubVar.f5391d = this.f5391d;
        return ubVar;
    }

    public final Iterator<Entry<FieldDescriptorType, Object>> d() {
        if (this.f5391d) {
            return new Tb(this.f5389b.entrySet().iterator());
        }
        return this.f5389b.entrySet().iterator();
    }

    public final void e() {
        if (!this.f5390c) {
            this.f5389b.b();
            this.f5390c = true;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0446ub)) {
            return false;
        }
        return this.f5389b.equals(((C0446ub) obj).f5389b);
    }

    public final int g() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f5389b.c(); i3++) {
            i2 += c(this.f5389b.b(i3));
        }
        for (Entry c2 : this.f5389b.d()) {
            i2 += c(c2);
        }
        return i2;
    }

    public final int hashCode() {
        return this.f5389b.hashCode();
    }

    private final void b(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.q()) {
            a(fielddescriptortype.s(), obj);
            r6 = obj;
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj2 = arrayList.get(i2);
                i2++;
                a(fielddescriptortype.s(), obj2);
            }
            r6 = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (r6 instanceof Ob) {
            this.f5391d = true;
        }
        this.f5389b.put(fielddescriptortype, r6);
    }

    private C0446ub(boolean z) {
        e();
    }

    private final Object a(FieldDescriptorType fielddescriptortype) {
        Object obj = this.f5389b.get(fielddescriptortype);
        if (!(obj instanceof Ob)) {
            return obj;
        }
        Ob.c();
        throw null;
    }

    private static int c(Entry<FieldDescriptorType, Object> entry) {
        C0458wb wbVar = (C0458wb) entry.getKey();
        Object value = entry.getValue();
        if (wbVar.r() != C0401md.MESSAGE || wbVar.q() || wbVar.t()) {
            return a(wbVar, value);
        }
        if (value instanceof Ob) {
            return zzee.b(((C0458wb) entry.getKey()).o(), (Sb) (Ob) value);
        }
        return zzee.d(((C0458wb) entry.getKey()).o(), (C0400mc) value);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if ((r3 instanceof com.google.android.gms.internal.measurement.Ob) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        if ((r3 instanceof com.google.android.gms.internal.measurement.Jb) == false) goto L_0x0043;
     */
    private static void a(C0383jd jdVar, Object obj) {
        boolean z;
        Fb.a(obj);
        boolean z2 = false;
        switch (C0464xb.f5417a[jdVar.a().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                break;
            case 2:
                z = obj instanceof Long;
                break;
            case 3:
                z = obj instanceof Float;
                break;
            case 4:
                z = obj instanceof Double;
                break;
            case 5:
                z = obj instanceof Boolean;
                break;
            case 6:
                z = obj instanceof String;
                break;
            case 7:
                if (!(obj instanceof Xa)) {
                    break;
                }
            case 8:
                if (!(obj instanceof Integer)) {
                    break;
                }
            case 9:
                if (!(obj instanceof C0400mc)) {
                    break;
                }
        }
        z2 = z;
        if (!z2) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    private final void b(Entry<FieldDescriptorType, Object> entry) {
        Object obj;
        C0458wb wbVar = (C0458wb) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof Ob) {
            Ob.c();
            throw null;
        } else if (wbVar.q()) {
            Object a2 = a((FieldDescriptorType) wbVar);
            if (a2 == null) {
                a2 = new ArrayList();
            }
            for (Object a3 : (List) value) {
                ((List) a2).add(a(a3));
            }
            this.f5389b.put(wbVar, a2);
        } else if (wbVar.r() == C0401md.MESSAGE) {
            Object a4 = a((FieldDescriptorType) wbVar);
            if (a4 == null) {
                this.f5389b.put(wbVar, a(value));
                return;
            }
            if (a4 instanceof C0424qc) {
                obj = wbVar.a((C0424qc) a4, (C0424qc) value);
            } else {
                obj = wbVar.a(((C0400mc) a4).f(), (C0400mc) value).A();
            }
            this.f5389b.put(wbVar, obj);
        } else {
            this.f5389b.put(wbVar, a(value));
        }
    }

    private static boolean a(Entry<FieldDescriptorType, Object> entry) {
        C0458wb wbVar = (C0458wb) entry.getKey();
        if (wbVar.r() == C0401md.MESSAGE) {
            if (wbVar.q()) {
                for (C0400mc b2 : (List) entry.getValue()) {
                    if (!b2.b()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof C0400mc) {
                    if (!((C0400mc) value).b()) {
                        return false;
                    }
                } else if (value instanceof Ob) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void a(C0446ub<FieldDescriptorType> ubVar) {
        for (int i2 = 0; i2 < ubVar.f5389b.c(); i2++) {
            b(ubVar.f5389b.b(i2));
        }
        for (Entry b2 : ubVar.f5389b.d()) {
            b(b2);
        }
    }

    private static Object a(Object obj) {
        if (obj instanceof C0424qc) {
            return ((C0424qc) obj).y();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private static int b(C0383jd jdVar, Object obj) {
        switch (C0464xb.f5418b[jdVar.ordinal()]) {
            case 1:
                return zzee.b(((Double) obj).doubleValue());
            case 2:
                return zzee.b(((Float) obj).floatValue());
            case 3:
                return zzee.d(((Long) obj).longValue());
            case 4:
                return zzee.e(((Long) obj).longValue());
            case 5:
                return zzee.f(((Integer) obj).intValue());
            case 6:
                return zzee.g(((Long) obj).longValue());
            case 7:
                return zzee.i(((Integer) obj).intValue());
            case 8:
                return zzee.b(((Boolean) obj).booleanValue());
            case 9:
                return zzee.b((C0400mc) obj);
            case 10:
                if (obj instanceof Ob) {
                    return zzee.a((Sb) (Ob) obj);
                }
                return zzee.a((C0400mc) obj);
            case 11:
                if (obj instanceof Xa) {
                    return zzee.a((Xa) obj);
                }
                return zzee.a((String) obj);
            case 12:
                if (obj instanceof Xa) {
                    return zzee.a((Xa) obj);
                }
                return zzee.b((byte[]) obj);
            case 13:
                return zzee.g(((Integer) obj).intValue());
            case 14:
                return zzee.j(((Integer) obj).intValue());
            case 15:
                return zzee.h(((Long) obj).longValue());
            case 16:
                return zzee.h(((Integer) obj).intValue());
            case 17:
                return zzee.f(((Long) obj).longValue());
            case 18:
                if (obj instanceof Jb) {
                    return zzee.k(((Jb) obj).o());
                }
                return zzee.k(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    static int a(C0383jd jdVar, int i2, Object obj) {
        int e2 = zzee.e(i2);
        if (jdVar == C0383jd.GROUP) {
            Fb.a((C0400mc) obj);
            e2 <<= 1;
        }
        return e2 + b(jdVar, obj);
    }

    public static int a(C0458wb<?> wbVar, Object obj) {
        C0383jd s = wbVar.s();
        int o = wbVar.o();
        if (!wbVar.q()) {
            return a(s, o, obj);
        }
        int i2 = 0;
        if (wbVar.t()) {
            for (Object b2 : (List) obj) {
                i2 += b(s, b2);
            }
            return zzee.e(o) + i2 + zzee.l(i2);
        }
        for (Object a2 : (List) obj) {
            i2 += a(s, o, a2);
        }
        return i2;
    }
}
