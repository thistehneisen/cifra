package androidx.savedstate;

import androidx.lifecycle.C0214g;
import androidx.lifecycle.h.a;
import androidx.lifecycle.l;

class SavedStateRegistry$1 implements C0214g {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ a f2055a;

    SavedStateRegistry$1(a aVar) {
        this.f2055a = aVar;
    }

    public void a(l lVar, a aVar) {
        if (aVar == a.ON_START) {
            this.f2055a.f2059d = true;
        } else if (aVar == a.ON_STOP) {
            this.f2055a.f2059d = false;
        }
    }
}
