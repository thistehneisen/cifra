package androidx.lifecycle;

import androidx.lifecycle.h.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: LifecycleRegistry */
public class n extends h {

    /* renamed from: b reason: collision with root package name */
    private b.b.a.b.a<k, a> f1652b = new b.b.a.b.a<>();

    /* renamed from: c reason: collision with root package name */
    private b f1653c;

    /* renamed from: d reason: collision with root package name */
    private final WeakReference<l> f1654d;

    /* renamed from: e reason: collision with root package name */
    private int f1655e = 0;

    /* renamed from: f reason: collision with root package name */
    private boolean f1656f = false;

    /* renamed from: g reason: collision with root package name */
    private boolean f1657g = false;

    /* renamed from: h reason: collision with root package name */
    private ArrayList<b> f1658h = new ArrayList<>();

    /* compiled from: LifecycleRegistry */
    static class a {

        /* renamed from: a reason: collision with root package name */
        b f1659a;

        /* renamed from: b reason: collision with root package name */
        j f1660b;

        a(k kVar, b bVar) {
            this.f1660b = p.a((Object) kVar);
            this.f1659a = bVar;
        }

        /* access modifiers changed from: 0000 */
        public void a(l lVar, androidx.lifecycle.h.a aVar) {
            b a2 = n.a(aVar);
            this.f1659a = n.a(this.f1659a, a2);
            this.f1660b.a(lVar, aVar);
            this.f1659a = a2;
        }
    }

    public n(l lVar) {
        this.f1654d = new WeakReference<>(lVar);
        this.f1653c = b.INITIALIZED;
    }

    private b c(k kVar) {
        Entry b2 = this.f1652b.b(kVar);
        b bVar = null;
        b bVar2 = b2 != null ? ((a) b2.getValue()).f1659a : null;
        if (!this.f1658h.isEmpty()) {
            ArrayList<b> arrayList = this.f1658h;
            bVar = (b) arrayList.get(arrayList.size() - 1);
        }
        return a(a(this.f1653c, bVar2), bVar);
    }

    private void d(b bVar) {
        if (this.f1653c != bVar) {
            this.f1653c = bVar;
            if (this.f1656f || this.f1655e != 0) {
                this.f1657g = true;
                return;
            }
            this.f1656f = true;
            d();
            this.f1656f = false;
        }
    }

    private void e(b bVar) {
        this.f1658h.add(bVar);
    }

    private static androidx.lifecycle.h.a f(b bVar) {
        int i2 = m.f1651b[bVar.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return androidx.lifecycle.h.a.ON_START;
            }
            if (i2 == 3) {
                return androidx.lifecycle.h.a.ON_RESUME;
            }
            if (i2 == 4) {
                throw new IllegalArgumentException();
            } else if (i2 != 5) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected state value ");
                sb.append(bVar);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        return androidx.lifecycle.h.a.ON_CREATE;
    }

    @Deprecated
    public void a(b bVar) {
        b(bVar);
    }

    public void b(b bVar) {
        d(bVar);
    }

    public void a(k kVar) {
        b bVar = this.f1653c;
        b bVar2 = b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = b.INITIALIZED;
        }
        a aVar = new a(kVar, bVar2);
        if (((a) this.f1652b.b(kVar, aVar)) == null) {
            l lVar = (l) this.f1654d.get();
            if (lVar != null) {
                boolean z = this.f1655e != 0 || this.f1656f;
                b c2 = c(kVar);
                this.f1655e++;
                while (aVar.f1659a.compareTo(c2) < 0 && this.f1652b.contains(kVar)) {
                    e(aVar.f1659a);
                    aVar.a(lVar, f(aVar.f1659a));
                    c();
                    c2 = c(kVar);
                }
                if (!z) {
                    d();
                }
                this.f1655e--;
            }
        }
    }

    public void b(androidx.lifecycle.h.a aVar) {
        d(a(aVar));
    }

    private boolean b() {
        boolean z = true;
        if (this.f1652b.size() == 0) {
            return true;
        }
        b bVar = ((a) this.f1652b.e().getValue()).f1659a;
        b bVar2 = ((a) this.f1652b.g().getValue()).f1659a;
        if (!(bVar == bVar2 && this.f1653c == bVar2)) {
            z = false;
        }
        return z;
    }

    private void c() {
        ArrayList<b> arrayList = this.f1658h;
        arrayList.remove(arrayList.size() - 1);
    }

    private static androidx.lifecycle.h.a c(b bVar) {
        int i2 = m.f1651b[bVar.ordinal()];
        if (i2 == 1) {
            throw new IllegalArgumentException();
        } else if (i2 == 2) {
            return androidx.lifecycle.h.a.ON_DESTROY;
        } else {
            if (i2 == 3) {
                return androidx.lifecycle.h.a.ON_STOP;
            }
            if (i2 == 4) {
                return androidx.lifecycle.h.a.ON_PAUSE;
            }
            if (i2 != 5) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected state value ");
                sb.append(bVar);
                throw new IllegalArgumentException(sb.toString());
            }
            throw new IllegalArgumentException();
        }
    }

    private void d() {
        l lVar = (l) this.f1654d.get();
        if (lVar != null) {
            while (!b()) {
                this.f1657g = false;
                if (this.f1653c.compareTo(((a) this.f1652b.e().getValue()).f1659a) < 0) {
                    a(lVar);
                }
                Entry g2 = this.f1652b.g();
                if (!this.f1657g && g2 != null && this.f1653c.compareTo(((a) g2.getValue()).f1659a) > 0) {
                    b(lVar);
                }
            }
            this.f1657g = false;
            return;
        }
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
    }

    public void b(k kVar) {
        this.f1652b.remove(kVar);
    }

    private void b(l lVar) {
        d f2 = this.f1652b.f();
        while (f2.hasNext() && !this.f1657g) {
            Entry entry = (Entry) f2.next();
            a aVar = (a) entry.getValue();
            while (aVar.f1659a.compareTo(this.f1653c) < 0 && !this.f1657g && this.f1652b.contains(entry.getKey())) {
                e(aVar.f1659a);
                aVar.a(lVar, f(aVar.f1659a));
                c();
            }
        }
    }

    public b a() {
        return this.f1653c;
    }

    static b a(androidx.lifecycle.h.a aVar) {
        switch (m.f1650a[aVar.ordinal()]) {
            case 1:
            case 2:
                return b.CREATED;
            case 3:
            case 4:
                return b.STARTED;
            case 5:
                return b.RESUMED;
            case 6:
                return b.DESTROYED;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected event value ");
                sb.append(aVar);
                throw new IllegalArgumentException(sb.toString());
        }
    }

    private void a(l lVar) {
        Iterator descendingIterator = this.f1652b.descendingIterator();
        while (descendingIterator.hasNext() && !this.f1657g) {
            Entry entry = (Entry) descendingIterator.next();
            a aVar = (a) entry.getValue();
            while (aVar.f1659a.compareTo(this.f1653c) > 0 && !this.f1657g && this.f1652b.contains(entry.getKey())) {
                androidx.lifecycle.h.a c2 = c(aVar.f1659a);
                e(a(c2));
                aVar.a(lVar, c2);
                c();
            }
        }
    }

    static b a(b bVar, b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }
}
