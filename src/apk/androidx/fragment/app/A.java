package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.C;
import androidx.lifecycle.D;
import androidx.lifecycle.D.b;
import androidx.lifecycle.F;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: FragmentManagerViewModel */
class A extends C {

    /* renamed from: c reason: collision with root package name */
    private static final b f1386c = new z();

    /* renamed from: d reason: collision with root package name */
    private final HashSet<Fragment> f1387d = new HashSet<>();

    /* renamed from: e reason: collision with root package name */
    private final HashMap<String, A> f1388e = new HashMap<>();

    /* renamed from: f reason: collision with root package name */
    private final HashMap<String, F> f1389f = new HashMap<>();

    /* renamed from: g reason: collision with root package name */
    private final boolean f1390g;

    /* renamed from: h reason: collision with root package name */
    private boolean f1391h = false;

    /* renamed from: i reason: collision with root package name */
    private boolean f1392i = false;

    A(boolean z) {
        this.f1390g = z;
    }

    static A a(F f2) {
        return (A) new D(f2, f1386c).a(A.class);
    }

    /* access modifiers changed from: protected */
    public void b() {
        if (C0207w.f1561c) {
            StringBuilder sb = new StringBuilder();
            sb.append("onCleared called for ");
            sb.append(this);
            Log.d("FragmentManager", sb.toString());
        }
        this.f1391h = true;
    }

    /* access modifiers changed from: 0000 */
    public Collection<Fragment> c() {
        return this.f1387d;
    }

    /* access modifiers changed from: 0000 */
    public boolean d() {
        return this.f1391h;
    }

    /* access modifiers changed from: 0000 */
    public boolean e(Fragment fragment) {
        return this.f1387d.remove(fragment);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || A.class != obj.getClass()) {
            return false;
        }
        A a2 = (A) obj;
        if (!this.f1387d.equals(a2.f1387d) || !this.f1388e.equals(a2.f1388e) || !this.f1389f.equals(a2.f1389f)) {
            z = false;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    public boolean f(Fragment fragment) {
        if (!this.f1387d.contains(fragment)) {
            return true;
        }
        if (this.f1390g) {
            return this.f1391h;
        }
        return !this.f1392i;
    }

    public int hashCode() {
        return (((this.f1387d.hashCode() * 31) + this.f1388e.hashCode()) * 31) + this.f1389f.hashCode();
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.f1387d.iterator();
        while (true) {
            str = ", ";
            if (!it.hasNext()) {
                break;
            }
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(str);
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.f1388e.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(str);
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.f1389f.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(str);
            }
        }
        sb.append(')');
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    public A c(Fragment fragment) {
        A a2 = (A) this.f1388e.get(fragment.mWho);
        if (a2 != null) {
            return a2;
        }
        A a3 = new A(this.f1390g);
        this.f1388e.put(fragment.mWho, a3);
        return a3;
    }

    /* access modifiers changed from: 0000 */
    public F d(Fragment fragment) {
        F f2 = (F) this.f1389f.get(fragment.mWho);
        if (f2 != null) {
            return f2;
        }
        F f3 = new F();
        this.f1389f.put(fragment.mWho, f3);
        return f3;
    }

    /* access modifiers changed from: 0000 */
    public boolean a(Fragment fragment) {
        return this.f1387d.add(fragment);
    }

    /* access modifiers changed from: 0000 */
    public void b(Fragment fragment) {
        if (C0207w.f1561c) {
            StringBuilder sb = new StringBuilder();
            sb.append("Clearing non-config state for ");
            sb.append(fragment);
            Log.d("FragmentManager", sb.toString());
        }
        A a2 = (A) this.f1388e.get(fragment.mWho);
        if (a2 != null) {
            a2.b();
            this.f1388e.remove(fragment.mWho);
        }
        F f2 = (F) this.f1389f.get(fragment.mWho);
        if (f2 != null) {
            f2.a();
            this.f1389f.remove(fragment.mWho);
        }
    }
}
