package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.widget.i;
import b.a.j;

/* renamed from: androidx.appcompat.widget.u reason: case insensitive filesystem */
/* compiled from: AppCompatPopupWindow */
class C0180u extends PopupWindow {

    /* renamed from: a reason: collision with root package name */
    private static final boolean f1048a = (VERSION.SDK_INT < 21);

    /* renamed from: b reason: collision with root package name */
    private boolean f1049b;

    public C0180u(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(context, attributeSet, i2, i3);
    }

    private void a(Context context, AttributeSet attributeSet, int i2, int i3) {
        sa a2 = sa.a(context, attributeSet, j.PopupWindow, i2, i3);
        if (a2.g(j.PopupWindow_overlapAnchor)) {
            a(a2.a(j.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(a2.b(j.PopupWindow_android_popupBackground));
        a2.a();
    }

    public void showAsDropDown(View view, int i2, int i3) {
        if (f1048a && this.f1049b) {
            i3 -= view.getHeight();
        }
        super.showAsDropDown(view, i2, i3);
    }

    public void update(View view, int i2, int i3, int i4, int i5) {
        if (f1048a && this.f1049b) {
            i3 -= view.getHeight();
        }
        super.update(view, i2, i3, i4, i5);
    }

    public void showAsDropDown(View view, int i2, int i3, int i4) {
        if (f1048a && this.f1049b) {
            i3 -= view.getHeight();
        }
        super.showAsDropDown(view, i2, i3, i4);
    }

    private void a(boolean z) {
        if (f1048a) {
            this.f1049b = z;
        } else {
            i.a((PopupWindow) this, z);
        }
    }
}
