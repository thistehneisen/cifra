package com.google.android.gms.internal.measurement;

import java.io.IOException;

final class Uc extends Tc<Vc, Vc> {
    Uc() {
    }

    private static void a(Object obj, Vc vc) {
        ((Eb) obj).zzahz = vc;
    }

    /* access modifiers changed from: 0000 */
    public final boolean a(Bc bc) {
        return false;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void b(Object obj, C0419pd pdVar) throws IOException {
        ((Vc) obj).a(pdVar);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ int c(Object obj) {
        return ((Vc) obj).b();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Object d(Object obj) {
        return ((Eb) obj).zzahz;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Object e(Object obj) {
        Vc vc = ((Eb) obj).zzahz;
        if (vc != Vc.c()) {
            return vc;
        }
        Vc d2 = Vc.d();
        a(obj, d2);
        return d2;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ int f(Object obj) {
        return ((Vc) obj).e();
    }

    /* access modifiers changed from: 0000 */
    public final void a(Object obj) {
        ((Eb) obj).zzahz.a();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void b(Object obj, Object obj2) {
        a(obj, (Vc) obj2);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Object c(Object obj, Object obj2) {
        Vc vc = (Vc) obj;
        Vc vc2 = (Vc) obj2;
        if (vc2.equals(Vc.c())) {
            return vc;
        }
        return Vc.a(vc, vc2);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void a(Object obj, C0419pd pdVar) throws IOException {
        ((Vc) obj).b(pdVar);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Object b(Object obj) {
        Vc vc = (Vc) obj;
        vc.a();
        return vc;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void a(Object obj, Object obj2) {
        a(obj, (Vc) obj2);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Object a() {
        return Vc.d();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void b(Object obj, int i2, long j2) {
        ((Vc) obj).a((i2 << 3) | 1, (Object) Long.valueOf(j2));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void a(Object obj, int i2, Object obj2) {
        ((Vc) obj).a((i2 << 3) | 3, (Object) (Vc) obj2);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void a(Object obj, int i2, Xa xa) {
        ((Vc) obj).a((i2 << 3) | 2, (Object) xa);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void a(Object obj, int i2, int i3) {
        ((Vc) obj).a((i2 << 3) | 5, (Object) Integer.valueOf(i3));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void a(Object obj, int i2, long j2) {
        ((Vc) obj).a(i2 << 3, (Object) Long.valueOf(j2));
    }
}
