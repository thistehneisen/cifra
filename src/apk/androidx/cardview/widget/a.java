package androidx.cardview.widget;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

/* compiled from: CardView */
class a implements g {

    /* renamed from: a reason: collision with root package name */
    private Drawable f1091a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ CardView f1092b;

    a(CardView cardView) {
        this.f1092b = cardView;
    }

    public void a(Drawable drawable) {
        this.f1091a = drawable;
        this.f1092b.setBackgroundDrawable(drawable);
    }

    public boolean b() {
        return this.f1092b.getUseCompatPadding();
    }

    public Drawable c() {
        return this.f1091a;
    }

    public View d() {
        return this.f1092b;
    }

    public boolean a() {
        return this.f1092b.getPreventCornerOverlap();
    }

    public void a(int i2, int i3, int i4, int i5) {
        this.f1092b.f1089h.set(i2, i3, i4, i5);
        CardView cardView = this.f1092b;
        Rect rect = cardView.f1088g;
        a.super.setPadding(i2 + rect.left, i3 + rect.top, i4 + rect.right, i5 + rect.bottom);
    }

    public void a(int i2, int i3) {
        CardView cardView = this.f1092b;
        if (i2 > cardView.f1086e) {
            a.super.setMinimumWidth(i2);
        }
        CardView cardView2 = this.f1092b;
        if (i3 > cardView2.f1087f) {
            a.super.setMinimumHeight(i3);
        }
    }
}
