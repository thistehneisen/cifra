package l.a.b;

import android.os.Build.VERSION;
import android.view.View;
import kotlin.e.a.a;
import kotlin.e.b.h;
import kotlin.m;

/* compiled from: View.kt */
public final class g {
    public static final void a(View view, a<m> aVar) {
        h.b(view, "$this$setOnRippleClickListener");
        h.b(aVar, "listener");
        if (VERSION.SDK_INT >= 21) {
            view.setOnClickListener(new e(view, aVar));
        } else {
            view.setOnClickListener(new f(aVar));
        }
    }
}
