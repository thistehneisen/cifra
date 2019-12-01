package androidx.appcompat.widget;

import android.graphics.Typeface;
import b.g.a.a.h.a;
import java.lang.ref.WeakReference;

/* compiled from: AppCompatTextHelper */
class F extends a {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ WeakReference f781a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ G f782b;

    F(G g2, WeakReference weakReference) {
        this.f782b = g2;
        this.f781a = weakReference;
    }

    public void a(int i2) {
    }

    public void a(Typeface typeface) {
        this.f782b.a(this.f781a, typeface);
    }
}
