package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: OnBackPressedCallback */
public abstract class d {

    /* renamed from: a reason: collision with root package name */
    private boolean f378a;

    /* renamed from: b reason: collision with root package name */
    private CopyOnWriteArrayList<a> f379b = new CopyOnWriteArrayList<>();

    public d(boolean z) {
        this.f378a = z;
    }

    public abstract void a();

    public final void a(boolean z) {
        this.f378a = z;
    }

    public final boolean b() {
        return this.f378a;
    }

    public final void c() {
        Iterator it = this.f379b.iterator();
        while (it.hasNext()) {
            ((a) it.next()).cancel();
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(a aVar) {
        this.f379b.add(aVar);
    }

    /* access modifiers changed from: 0000 */
    public void b(a aVar) {
        this.f379b.remove(aVar);
    }
}
