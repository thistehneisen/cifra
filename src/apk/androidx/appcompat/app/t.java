package androidx.appcompat.app;

import android.graphics.Rect;
import androidx.appcompat.widget.M.a;

/* compiled from: AppCompatDelegateImpl */
class t implements a {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ y f502a;

    t(y yVar) {
        this.f502a = yVar;
    }

    public void a(Rect rect) {
        rect.top = this.f502a.i(rect.top);
    }
}
