package androidx.activity;

import androidx.lifecycle.h.a;
import androidx.lifecycle.j;
import androidx.lifecycle.l;

class ComponentActivity$3 implements j {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ c f361a;

    ComponentActivity$3(c cVar) {
        this.f361a = cVar;
    }

    public void a(l lVar, a aVar) {
        if (aVar == a.ON_DESTROY && !this.f361a.isChangingConfigurations()) {
            this.f361a.getViewModelStore().a();
        }
    }
}
