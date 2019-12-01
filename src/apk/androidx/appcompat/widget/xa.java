package androidx.appcompat.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window.Callback;
import androidx.appcompat.view.menu.C0148a;

/* compiled from: ToolbarWidgetWrapper */
class xa implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    final C0148a f1058a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ za f1059b;

    xa(za zaVar) {
        this.f1059b = zaVar;
        C0148a aVar = new C0148a(this.f1059b.f1070a.getContext(), 0, 16908332, 0, 0, this.f1059b.f1078i);
        this.f1058a = aVar;
    }

    public void onClick(View view) {
        za zaVar = this.f1059b;
        Callback callback = zaVar.f1081l;
        if (callback != null && zaVar.m) {
            callback.onMenuItemSelected(0, this.f1058a);
        }
    }
}
