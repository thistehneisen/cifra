package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* compiled from: RoundRectDrawable */
class i extends Drawable {

    /* renamed from: a reason: collision with root package name */
    private float f1096a;

    /* renamed from: b reason: collision with root package name */
    private final Paint f1097b;

    /* renamed from: c reason: collision with root package name */
    private final RectF f1098c;

    /* renamed from: d reason: collision with root package name */
    private final Rect f1099d;

    /* renamed from: e reason: collision with root package name */
    private float f1100e;

    /* renamed from: f reason: collision with root package name */
    private boolean f1101f = false;

    /* renamed from: g reason: collision with root package name */
    private boolean f1102g = true;

    /* renamed from: h reason: collision with root package name */
    private ColorStateList f1103h;

    /* renamed from: i reason: collision with root package name */
    private PorterDuffColorFilter f1104i;

    /* renamed from: j reason: collision with root package name */
    private ColorStateList f1105j;

    /* renamed from: k reason: collision with root package name */
    private Mode f1106k = Mode.SRC_IN;

    i(ColorStateList colorStateList, float f2) {
        this.f1096a = f2;
        this.f1097b = new Paint(5);
        b(colorStateList);
        this.f1098c = new RectF();
        this.f1099d = new Rect();
    }

    private void b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f1103h = colorStateList;
        this.f1097b.setColor(this.f1103h.getColorForState(getState(), this.f1103h.getDefaultColor()));
    }

    /* access modifiers changed from: 0000 */
    public void a(float f2, boolean z, boolean z2) {
        if (f2 != this.f1100e || this.f1101f != z || this.f1102g != z2) {
            this.f1100e = f2;
            this.f1101f = z;
            this.f1102g = z2;
            a((Rect) null);
            invalidateSelf();
        }
    }

    public float c() {
        return this.f1096a;
    }

    public void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.f1097b;
        if (this.f1104i == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.f1104i);
            z = true;
        }
        RectF rectF = this.f1098c;
        float f2 = this.f1096a;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        if (z) {
            paint.setColorFilter(null);
        }
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f1099d, this.f1096a);
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.f1105j;
        if (colorStateList == null || !colorStateList.isStateful()) {
            ColorStateList colorStateList2 = this.f1103h;
            if ((colorStateList2 == null || !colorStateList2.isStateful()) && !super.isStateful()) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        a(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.f1103h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z = colorForState != this.f1097b.getColor();
        if (z) {
            this.f1097b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f1105j;
        if (colorStateList2 != null) {
            Mode mode = this.f1106k;
            if (mode != null) {
                this.f1104i = a(colorStateList2, mode);
                return true;
            }
        }
        return z;
    }

    public void setAlpha(int i2) {
        this.f1097b.setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1097b.setColorFilter(colorFilter);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f1105j = colorStateList;
        this.f1104i = a(this.f1105j, this.f1106k);
        invalidateSelf();
    }

    public void setTintMode(Mode mode) {
        this.f1106k = mode;
        this.f1104i = a(this.f1105j, this.f1106k);
        invalidateSelf();
    }

    /* access modifiers changed from: 0000 */
    public float b() {
        return this.f1100e;
    }

    private void a(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f1098c.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.f1099d.set(rect);
        if (this.f1101f) {
            float b2 = j.b(this.f1100e, this.f1096a, this.f1102g);
            this.f1099d.inset((int) Math.ceil((double) j.a(this.f1100e, this.f1096a, this.f1102g)), (int) Math.ceil((double) b2));
            this.f1098c.set(this.f1099d);
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(float f2) {
        if (f2 != this.f1096a) {
            this.f1096a = f2;
            a((Rect) null);
            invalidateSelf();
        }
    }

    public void a(ColorStateList colorStateList) {
        b(colorStateList);
        invalidateSelf();
    }

    public ColorStateList a() {
        return this.f1103h;
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }
}
