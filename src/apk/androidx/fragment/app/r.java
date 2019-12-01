package androidx.fragment.app;

/* compiled from: FragmentManagerImpl */
class r implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ C0203s f1548a;

    r(C0203s sVar) {
        this.f1548a = sVar;
    }

    public void run() {
        if (this.f1548a.f1550b.getAnimatingAway() != null) {
            this.f1548a.f1550b.setAnimatingAway(null);
            C0203s sVar = this.f1548a;
            C0207w wVar = sVar.f1551c;
            Fragment fragment = sVar.f1550b;
            wVar.a(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
        }
    }
}
