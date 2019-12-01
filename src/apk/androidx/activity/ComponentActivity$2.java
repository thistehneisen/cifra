package androidx.activity;

import android.view.View;
import android.view.Window;
import androidx.lifecycle.h.a;
import androidx.lifecycle.j;
import androidx.lifecycle.l;

class ComponentActivity$2 implements j {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ c f360a;

    ComponentActivity$2(c cVar) {
        this.f360a = cVar;
    }

    public void a(l lVar, a aVar) {
        if (aVar == a.ON_STOP) {
            Window window = this.f360a.getWindow();
            View peekDecorView = window != null ? window.peekDecorView() : null;
            if (peekDecorView != null) {
                peekDecorView.cancelPendingInputEvents();
            }
        }
    }
}
