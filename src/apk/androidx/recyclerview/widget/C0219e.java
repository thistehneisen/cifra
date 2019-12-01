package androidx.recyclerview.widget;

import java.util.List;

/* renamed from: androidx.recyclerview.widget.e reason: case insensitive filesystem */
/* compiled from: AsyncListDiffer */
class C0219e implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ List f1900a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ List f1901b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ int f1902c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ C0220f f1903d;

    C0219e(C0220f fVar, List list, List list2, int i2) {
        this.f1903d = fVar;
        this.f1900a = list;
        this.f1901b = list2;
        this.f1902c = i2;
    }

    public void run() {
        this.f1903d.f1913d.execute(new C0218d(this, C0232s.a(new C0217c(this))));
    }
}
