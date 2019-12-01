package l.a.b;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.e.a.a;

/* compiled from: View.kt */
final class e implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ View f10370a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ a f10371b;

    e(View view, a aVar) {
        this.f10370a = view;
        this.f10371b = aVar;
    }

    public final void onClick(View view) {
        this.f10370a.postDelayed(new d(this), 150);
    }
}
