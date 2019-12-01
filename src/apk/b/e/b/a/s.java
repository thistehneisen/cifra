package b.e.b.a;

import java.util.HashSet;
import java.util.Iterator;

/* compiled from: ResolutionNode */
public class s {

    /* renamed from: a reason: collision with root package name */
    HashSet<s> f2411a = new HashSet<>(2);

    /* renamed from: b reason: collision with root package name */
    int f2412b = 0;

    public void a(s sVar) {
        this.f2411a.add(sVar);
    }

    public void b() {
        this.f2412b = 0;
        Iterator it = this.f2411a.iterator();
        while (it.hasNext()) {
            ((s) it.next()).b();
        }
    }

    public boolean c() {
        return this.f2412b == 1;
    }

    public void d() {
        this.f2412b = 0;
        this.f2411a.clear();
    }

    public void e() {
    }

    public void a() {
        this.f2412b = 1;
        Iterator it = this.f2411a.iterator();
        while (it.hasNext()) {
            ((s) it.next()).e();
        }
    }
}
