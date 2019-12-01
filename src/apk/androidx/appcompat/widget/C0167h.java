package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.view.menu.z;

/* renamed from: androidx.appcompat.widget.h reason: case insensitive filesystem */
/* compiled from: ActionMenuPresenter */
class C0167h extends N {

    /* renamed from: j reason: collision with root package name */
    final /* synthetic */ C0165g f970j;

    /* renamed from: k reason: collision with root package name */
    final /* synthetic */ d f971k;

    C0167h(d dVar, View view, C0165g gVar) {
        this.f971k = dVar;
        this.f970j = gVar;
        super(view);
    }

    public z a() {
        e eVar = C0165g.this.z;
        if (eVar == null) {
            return null;
        }
        return eVar.b();
    }

    public boolean b() {
        C0165g.this.i();
        return true;
    }

    public boolean c() {
        C0165g gVar = C0165g.this;
        if (gVar.B != null) {
            return false;
        }
        gVar.e();
        return true;
    }
}
