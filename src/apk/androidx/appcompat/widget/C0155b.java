package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* renamed from: androidx.appcompat.widget.b reason: case insensitive filesystem */
/* compiled from: ActionBarBackgroundDrawable */
class C0155b extends Drawable {

    /* renamed from: a reason: collision with root package name */
    final ActionBarContainer f950a;

    public C0155b(ActionBarContainer actionBarContainer) {
        this.f950a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f950a;
        if (actionBarContainer.f707h) {
            Drawable drawable = actionBarContainer.f706g;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f704e;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        ActionBarContainer actionBarContainer2 = this.f950a;
        Drawable drawable3 = actionBarContainer2.f705f;
        if (drawable3 != null && actionBarContainer2.f708i) {
            drawable3.draw(canvas);
        }
    }

    public int getOpacity() {
        return 0;
    }

    public void getOutline(Outline outline) {
        ActionBarContainer actionBarContainer = this.f950a;
        if (actionBarContainer.f707h) {
            Drawable drawable = actionBarContainer.f706g;
            if (drawable != null) {
                drawable.getOutline(outline);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f704e;
        if (drawable2 != null) {
            drawable2.getOutline(outline);
        }
    }

    public void setAlpha(int i2) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
