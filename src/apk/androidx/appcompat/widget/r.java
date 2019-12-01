package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.core.widget.l;
import b.a.a;
import b.g.i.v;

/* compiled from: AppCompatImageButton */
public class r extends ImageButton implements v, l {

    /* renamed from: a reason: collision with root package name */
    private final C0170j f1034a;

    /* renamed from: b reason: collision with root package name */
    private final C0178s f1035b;

    public r(Context context) {
        this(context, null);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0170j jVar = this.f1034a;
        if (jVar != null) {
            jVar.a();
        }
        C0178s sVar = this.f1035b;
        if (sVar != null) {
            sVar.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0170j jVar = this.f1034a;
        if (jVar != null) {
            return jVar.b();
        }
        return null;
    }

    public Mode getSupportBackgroundTintMode() {
        C0170j jVar = this.f1034a;
        if (jVar != null) {
            return jVar.c();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        C0178s sVar = this.f1035b;
        if (sVar != null) {
            return sVar.b();
        }
        return null;
    }

    public Mode getSupportImageTintMode() {
        C0178s sVar = this.f1035b;
        if (sVar != null) {
            return sVar.c();
        }
        return null;
    }

    public boolean hasOverlappingRendering() {
        return this.f1035b.d() && super.hasOverlappingRendering();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0170j jVar = this.f1034a;
        if (jVar != null) {
            jVar.a(drawable);
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0170j jVar = this.f1034a;
        if (jVar != null) {
            jVar.a(i2);
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        C0178s sVar = this.f1035b;
        if (sVar != null) {
            sVar.a();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        C0178s sVar = this.f1035b;
        if (sVar != null) {
            sVar.a();
        }
    }

    public void setImageResource(int i2) {
        this.f1035b.a(i2);
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        C0178s sVar = this.f1035b;
        if (sVar != null) {
            sVar.a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0170j jVar = this.f1034a;
        if (jVar != null) {
            jVar.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        C0170j jVar = this.f1034a;
        if (jVar != null) {
            jVar.a(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        C0178s sVar = this.f1035b;
        if (sVar != null) {
            sVar.a(colorStateList);
        }
    }

    public void setSupportImageTintMode(Mode mode) {
        C0178s sVar = this.f1035b;
        if (sVar != null) {
            sVar.a(mode);
        }
    }

    public r(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.imageButtonStyle);
    }

    public r(Context context, AttributeSet attributeSet, int i2) {
        super(pa.a(context), attributeSet, i2);
        this.f1034a = new C0170j(this);
        this.f1034a.a(attributeSet, i2);
        this.f1035b = new C0178s(this);
        this.f1035b.a(attributeSet, i2);
    }
}
