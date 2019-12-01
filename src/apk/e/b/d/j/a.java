package e.b.d.j;

import e.b.c.i;
import e.b.m;
import k.a.c;

/* compiled from: AppendOnlyLinkedArrayList */
public class a<T> {

    /* renamed from: a reason: collision with root package name */
    final int f8285a;

    /* renamed from: b reason: collision with root package name */
    final Object[] f8286b;

    /* renamed from: c reason: collision with root package name */
    Object[] f8287c = this.f8286b;

    /* renamed from: d reason: collision with root package name */
    int f8288d;

    /* renamed from: e.b.d.j.a$a reason: collision with other inner class name */
    /* compiled from: AppendOnlyLinkedArrayList */
    public interface C0092a<T> extends i<T> {
        boolean test(T t);
    }

    public a(int i2) {
        this.f8285a = i2;
        this.f8286b = new Object[(i2 + 1)];
    }

    public void a(T t) {
        int i2 = this.f8285a;
        int i3 = this.f8288d;
        if (i3 == i2) {
            Object[] objArr = new Object[(i2 + 1)];
            this.f8287c[i2] = objArr;
            this.f8287c = objArr;
            i3 = 0;
        }
        this.f8287c[i3] = t;
        this.f8288d = i3 + 1;
    }

    public void b(T t) {
        this.f8286b[0] = t;
    }

    public void a(C0092a<? super T> aVar) {
        int i2 = this.f8285a;
        for (Object[] objArr = this.f8286b; objArr != null; objArr = objArr[i2]) {
            int i3 = 0;
            while (i3 < i2) {
                Object[] objArr2 = objArr[i3];
                if (objArr2 == null) {
                    continue;
                    break;
                } else if (!aVar.test(objArr2)) {
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    public <U> boolean a(c<? super U> cVar) {
        Object[] objArr = this.f8286b;
        int i2 = this.f8285a;
        while (true) {
            int i3 = 0;
            if (objArr == null) {
                return false;
            }
            while (i3 < i2) {
                Object[] objArr2 = objArr[i3];
                if (objArr2 == null) {
                    continue;
                    break;
                } else if (h.a((Object) objArr2, cVar)) {
                    return true;
                } else {
                    i3++;
                }
            }
            objArr = objArr[i2];
        }
    }

    public <U> boolean a(m<? super U> mVar) {
        Object[] objArr = this.f8286b;
        int i2 = this.f8285a;
        while (true) {
            int i3 = 0;
            if (objArr == null) {
                return false;
            }
            while (i3 < i2) {
                Object[] objArr2 = objArr[i3];
                if (objArr2 == null) {
                    continue;
                    break;
                } else if (h.b(objArr2, mVar)) {
                    return true;
                } else {
                    i3++;
                }
            }
            objArr = objArr[i2];
        }
    }
}
