package e.b.d.a;

import e.b.b.b;
import e.b.d.j.f;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* compiled from: ListCompositeDisposable */
public final class d implements b, a {

    /* renamed from: a reason: collision with root package name */
    List<b> f7954a;

    /* renamed from: b reason: collision with root package name */
    volatile boolean f7955b;

    public boolean a() {
        return this.f7955b;
    }

    public void b() {
        if (!this.f7955b) {
            synchronized (this) {
                if (!this.f7955b) {
                    this.f7955b = true;
                    List<b> list = this.f7954a;
                    this.f7954a = null;
                    a(list);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0021, code lost:
        return false;
     */
    public boolean c(b bVar) {
        e.b.d.b.b.a(bVar, "Disposable item is null");
        if (this.f7955b) {
            return false;
        }
        synchronized (this) {
            if (this.f7955b) {
                return false;
            }
            List<b> list = this.f7954a;
            if (list != null) {
                if (list.remove(bVar)) {
                    return true;
                }
            }
        }
    }

    public boolean a(b bVar) {
        if (!c(bVar)) {
            return false;
        }
        bVar.b();
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void a(List<b> list) {
        if (list != null) {
            ArrayList arrayList = null;
            for (b b2 : list) {
                try {
                    b2.b();
                } catch (Throwable th) {
                    a.b(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
            if (arrayList == null) {
                return;
            }
            if (arrayList.size() == 1) {
                throw f.a((Throwable) arrayList.get(0));
            }
            throw new CompositeException((Iterable<? extends Throwable>) arrayList);
        }
    }

    public boolean b(b bVar) {
        e.b.d.b.b.a(bVar, "d is null");
        if (!this.f7955b) {
            synchronized (this) {
                if (!this.f7955b) {
                    List list = this.f7954a;
                    if (list == null) {
                        list = new LinkedList();
                        this.f7954a = list;
                    }
                    list.add(bVar);
                    return true;
                }
            }
        }
        bVar.b();
        return false;
    }
}
