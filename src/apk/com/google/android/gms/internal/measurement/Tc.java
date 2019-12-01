package com.google.android.gms.internal.measurement;

import java.io.IOException;

abstract class Tc<T, B> {
    Tc() {
    }

    /* access modifiers changed from: 0000 */
    public abstract B a();

    /* access modifiers changed from: 0000 */
    public abstract void a(Object obj);

    /* access modifiers changed from: 0000 */
    public abstract void a(B b2, int i2, int i3);

    /* access modifiers changed from: 0000 */
    public abstract void a(B b2, int i2, long j2);

    /* access modifiers changed from: 0000 */
    public abstract void a(B b2, int i2, Xa xa);

    /* access modifiers changed from: 0000 */
    public abstract void a(B b2, int i2, T t);

    /* access modifiers changed from: 0000 */
    public abstract void a(T t, C0419pd pdVar) throws IOException;

    /* access modifiers changed from: 0000 */
    public abstract void a(Object obj, T t);

    /* access modifiers changed from: 0000 */
    public abstract boolean a(Bc bc);

    /* access modifiers changed from: 0000 */
    public final boolean a(B b2, Bc bc) throws IOException {
        int tag = bc.getTag();
        int i2 = tag >>> 3;
        int i3 = tag & 7;
        if (i3 == 0) {
            a(b2, i2, bc.k());
            return true;
        } else if (i3 == 1) {
            b(b2, i2, bc.f());
            return true;
        } else if (i3 == 2) {
            a(b2, i2, bc.o());
            return true;
        } else if (i3 == 3) {
            Object a2 = a();
            int i4 = 4 | (i2 << 3);
            while (bc.m() != Integer.MAX_VALUE) {
                if (!a((B) a2, bc)) {
                    break;
                }
            }
            if (i4 == bc.getTag()) {
                a(b2, i2, (T) b(a2));
                return true;
            }
            throw zzfi.e();
        } else if (i3 == 4) {
            return false;
        } else {
            if (i3 == 5) {
                a(b2, i2, bc.c());
                return true;
            }
            throw zzfi.f();
        }
    }

    /* access modifiers changed from: 0000 */
    public abstract T b(B b2);

    /* access modifiers changed from: 0000 */
    public abstract void b(B b2, int i2, long j2);

    /* access modifiers changed from: 0000 */
    public abstract void b(T t, C0419pd pdVar) throws IOException;

    /* access modifiers changed from: 0000 */
    public abstract void b(Object obj, B b2);

    /* access modifiers changed from: 0000 */
    public abstract int c(T t);

    /* access modifiers changed from: 0000 */
    public abstract T c(T t, T t2);

    /* access modifiers changed from: 0000 */
    public abstract T d(Object obj);

    /* access modifiers changed from: 0000 */
    public abstract B e(Object obj);

    /* access modifiers changed from: 0000 */
    public abstract int f(T t);
}
