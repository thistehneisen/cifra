package b.g.i;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

/* compiled from: ViewCompat */
class x implements OnApplyWindowInsetsListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ r f2727a;

    x(r rVar) {
        this.f2727a = rVar;
    }

    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return (WindowInsets) O.a(this.f2727a.a(view, O.a((Object) windowInsets)));
    }
}
