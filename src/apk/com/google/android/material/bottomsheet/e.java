package com.google.android.material.bottomsheet;

import android.os.Bundle;
import android.view.View;
import b.g.i.C0240a;
import b.g.i.a.d;

/* compiled from: BottomSheetDialog */
class e extends C0240a {

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ h f6361d;

    e(h hVar) {
        this.f6361d = hVar;
    }

    public void a(View view, d dVar) {
        super.a(view, dVar);
        if (this.f6361d.f6365d) {
            dVar.a(1048576);
            dVar.d(true);
            return;
        }
        dVar.d(false);
    }

    public boolean a(View view, int i2, Bundle bundle) {
        if (i2 == 1048576) {
            h hVar = this.f6361d;
            if (hVar.f6365d) {
                hVar.cancel();
                return true;
            }
        }
        return super.a(view, i2, bundle);
    }
}
