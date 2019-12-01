package b.g.f;

/* compiled from: SelfDestructiveThread */
class h implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Object f2554a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ i f2555b;

    h(i iVar, Object obj) {
        this.f2555b = iVar;
        this.f2554a = obj;
    }

    public void run() {
        this.f2555b.f2558c.a(this.f2554a);
    }
}
