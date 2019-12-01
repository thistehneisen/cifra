package androidx.recyclerview.widget;

import androidx.recyclerview.widget.C0232s.a;

/* renamed from: androidx.recyclerview.widget.c reason: case insensitive filesystem */
/* compiled from: AsyncListDiffer */
class C0217c extends a {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ C0219e f1890a;

    C0217c(C0219e eVar) {
        this.f1890a = eVar;
    }

    public int a() {
        return this.f1890a.f1901b.size();
    }

    public int b() {
        return this.f1890a.f1900a.size();
    }

    public Object c(int i2, int i3) {
        Object obj = this.f1890a.f1900a.get(i2);
        Object obj2 = this.f1890a.f1901b.get(i3);
        if (obj != null && obj2 != null) {
            return this.f1890a.f1903d.f1912c.b().c(obj, obj2);
        }
        throw new AssertionError();
    }

    public boolean a(int i2, int i3) {
        Object obj = this.f1890a.f1900a.get(i2);
        Object obj2 = this.f1890a.f1901b.get(i3);
        if (obj != null && obj2 != null) {
            return this.f1890a.f1903d.f1912c.b().a(obj, obj2);
        }
        if (obj == null && obj2 == null) {
            return true;
        }
        throw new AssertionError();
    }

    public boolean b(int i2, int i3) {
        Object obj = this.f1890a.f1900a.get(i2);
        Object obj2 = this.f1890a.f1901b.get(i3);
        if (obj != null && obj2 != null) {
            return this.f1890a.f1903d.f1912c.b().b(obj, obj2);
        }
        return obj == null && obj2 == null;
    }
}
