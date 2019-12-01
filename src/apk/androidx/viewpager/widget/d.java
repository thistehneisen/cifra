package androidx.viewpager.widget;

/* compiled from: ViewPager */
class d implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ ViewPager f2142a;

    d(ViewPager viewPager) {
        this.f2142a = viewPager;
    }

    public void run() {
        this.f2142a.setScrollState(0);
        this.f2142a.populate();
    }
}
