package e.b.b;

import e.b.d.b.b;
import e.b.d.j.f;
import e.b.d.j.i;
import io.reactivex.exceptions.CompositeException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CompositeDisposable */
public final class a implements b, e.b.d.a.a {

    /* renamed from: a reason: collision with root package name */
    i<b> f7947a;

    /* renamed from: b reason: collision with root package name */
    volatile boolean f7948b;

    public boolean a() {
        return this.f7948b;
    }

    public void b() {
        if (!this.f7948b) {
            synchronized (this) {
                if (!this.f7948b) {
                    this.f7948b = true;
                    i<b> iVar = this.f7947a;
                    this.f7947a = null;
                    a(iVar);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0021, code lost:
        return false;
     */
    public boolean c(b bVar) {
        b.a(bVar, "Disposable item is null");
        if (this.f7948b) {
            return false;
        }
        synchronized (this) {
            if (this.f7948b) {
                return false;
            }
            i<b> iVar = this.f7947a;
            if (iVar != null) {
                if (iVar.b(bVar)) {
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
    public void a(i<b> iVar) {
        Object[] a2;
        if (iVar != null) {
            List list = null;
            for (Object obj : iVar.a()) {
                if (obj instanceof b) {
                    try {
                        ((b) obj).b();
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        if (list == null) {
                            list = new ArrayList();
                        }
                        list.add(th);
                    }
                }
            }
            if (list == null) {
                return;
            }
            if (list.size() == 1) {
                throw f.a((Throwable) list.get(0));
            }
            throw new CompositeException((Iterable<? extends Throwable>) list);
        }
    }

    public boolean b(b bVar) {
        b.a(bVar, "d is null");
        if (!this.f7948b) {
            synchronized (this) {
                if (!this.f7948b) {
                    i<b> iVar = this.f7947a;
                    if (iVar == null) {
                        iVar = new i<>();
                        this.f7947a = iVar;
                    }
                    iVar.a(bVar);
                    return true;
                }
            }
        }
        bVar.b();
        return false;
    }
}
