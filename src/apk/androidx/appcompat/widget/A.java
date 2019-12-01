package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.view.menu.z;

/* compiled from: AppCompatSpinner */
class A extends N {

    /* renamed from: j reason: collision with root package name */
    final /* synthetic */ b f698j;

    /* renamed from: k reason: collision with root package name */
    final /* synthetic */ B f699k;

    A(B b2, View view, b bVar) {
        this.f699k = b2;
        this.f698j = bVar;
        super(view);
    }

    public z a() {
        return this.f698j;
    }

    public boolean b() {
        if (!this.f699k.f740g.c()) {
            this.f699k.f740g.b();
        }
        return true;
    }
}
