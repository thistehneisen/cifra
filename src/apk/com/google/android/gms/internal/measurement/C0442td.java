package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.td reason: case insensitive filesystem */
final class C0442td implements Cloneable {

    /* renamed from: a reason: collision with root package name */
    private C0430rd<?, ?> f5382a;

    /* renamed from: b reason: collision with root package name */
    private Object f5383b;

    /* renamed from: c reason: collision with root package name */
    private List<C0478zd> f5384c = new ArrayList();

    C0442td() {
    }

    private final byte[] b() throws IOException {
        byte[] bArr = new byte[a()];
        a(C0425qd.a(bArr));
        return bArr;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final C0442td clone() {
        C0442td tdVar = new C0442td();
        try {
            tdVar.f5382a = this.f5382a;
            if (this.f5384c == null) {
                tdVar.f5384c = null;
            } else {
                tdVar.f5384c.addAll(this.f5384c);
            }
            if (this.f5383b != null) {
                if (this.f5383b instanceof C0466xd) {
                    tdVar.f5383b = (C0466xd) ((C0466xd) this.f5383b).clone();
                } else if (this.f5383b instanceof byte[]) {
                    tdVar.f5383b = ((byte[]) this.f5383b).clone();
                } else {
                    int i2 = 0;
                    if (this.f5383b instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.f5383b;
                        byte[][] bArr2 = new byte[bArr.length][];
                        tdVar.f5383b = bArr2;
                        while (i2 < bArr.length) {
                            bArr2[i2] = (byte[]) bArr[i2].clone();
                            i2++;
                        }
                    } else if (this.f5383b instanceof boolean[]) {
                        tdVar.f5383b = ((boolean[]) this.f5383b).clone();
                    } else if (this.f5383b instanceof int[]) {
                        tdVar.f5383b = ((int[]) this.f5383b).clone();
                    } else if (this.f5383b instanceof long[]) {
                        tdVar.f5383b = ((long[]) this.f5383b).clone();
                    } else if (this.f5383b instanceof float[]) {
                        tdVar.f5383b = ((float[]) this.f5383b).clone();
                    } else if (this.f5383b instanceof double[]) {
                        tdVar.f5383b = ((double[]) this.f5383b).clone();
                    } else if (this.f5383b instanceof C0466xd[]) {
                        C0466xd[] xdVarArr = (C0466xd[]) this.f5383b;
                        C0466xd[] xdVarArr2 = new C0466xd[xdVarArr.length];
                        tdVar.f5383b = xdVarArr2;
                        while (i2 < xdVarArr.length) {
                            xdVarArr2[i2] = (C0466xd) xdVarArr[i2].clone();
                            i2++;
                        }
                    }
                }
            }
            return tdVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void a(C0478zd zdVar) throws IOException {
        List<C0478zd> list = this.f5384c;
        if (list != null) {
            list.add(zdVar);
            return;
        }
        Object obj = this.f5383b;
        if (obj instanceof C0466xd) {
            byte[] bArr = zdVar.f5464b;
            C0413od a2 = C0413od.a(bArr, 0, bArr.length);
            int e2 = a2.e();
            if (e2 == bArr.length - C0425qd.b(e2)) {
                C0466xd a3 = ((C0466xd) this.f5383b).a(a2);
                this.f5382a = this.f5382a;
                this.f5383b = a3;
                this.f5384c = null;
                return;
            }
            throw zzit.a();
        } else if (obj instanceof C0466xd[]) {
            Collections.singletonList(zdVar);
            throw new NoSuchMethodError();
        } else if (obj instanceof C0400mc) {
            Collections.singletonList(zdVar);
            throw new NoSuchMethodError();
        } else if (obj instanceof C0400mc[]) {
            Collections.singletonList(zdVar);
            throw new NoSuchMethodError();
        } else {
            Collections.singletonList(zdVar);
            throw new NoSuchMethodError();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0442td)) {
            return false;
        }
        C0442td tdVar = (C0442td) obj;
        if (this.f5383b == null || tdVar.f5383b == null) {
            List<C0478zd> list = this.f5384c;
            if (list != null) {
                List<C0478zd> list2 = tdVar.f5384c;
                if (list2 != null) {
                    return list.equals(list2);
                }
            }
            try {
                return Arrays.equals(b(), tdVar.b());
            } catch (IOException e2) {
                throw new IllegalStateException(e2);
            }
        } else {
            C0430rd<?, ?> rdVar = this.f5382a;
            if (rdVar != tdVar.f5382a) {
                return false;
            }
            if (!rdVar.f5360a.isArray()) {
                return this.f5383b.equals(tdVar.f5383b);
            }
            Object obj2 = this.f5383b;
            if (obj2 instanceof byte[]) {
                return Arrays.equals((byte[]) obj2, (byte[]) tdVar.f5383b);
            }
            if (obj2 instanceof int[]) {
                return Arrays.equals((int[]) obj2, (int[]) tdVar.f5383b);
            }
            if (obj2 instanceof long[]) {
                return Arrays.equals((long[]) obj2, (long[]) tdVar.f5383b);
            }
            if (obj2 instanceof float[]) {
                return Arrays.equals((float[]) obj2, (float[]) tdVar.f5383b);
            }
            if (obj2 instanceof double[]) {
                return Arrays.equals((double[]) obj2, (double[]) tdVar.f5383b);
            }
            if (obj2 instanceof boolean[]) {
                return Arrays.equals((boolean[]) obj2, (boolean[]) tdVar.f5383b);
            }
            return Arrays.deepEquals((Object[]) obj2, (Object[]) tdVar.f5383b);
        }
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(b()) + 527;
        } catch (IOException e2) {
            throw new IllegalStateException(e2);
        }
    }

    /* access modifiers changed from: 0000 */
    public final int a() {
        if (this.f5383b == null) {
            int i2 = 0;
            for (C0478zd zdVar : this.f5384c) {
                i2 += C0425qd.c(zdVar.f5463a) + 0 + zdVar.f5464b.length;
            }
            return i2;
        }
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: 0000 */
    public final void a(C0425qd qdVar) throws IOException {
        if (this.f5383b == null) {
            for (C0478zd zdVar : this.f5384c) {
                qdVar.d(zdVar.f5463a);
                qdVar.b(zdVar.f5464b);
            }
            return;
        }
        throw new NoSuchMethodError();
    }
}
