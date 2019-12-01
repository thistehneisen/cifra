package c.b.a.c.h;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import b.g.a.a.h;
import b.g.a.a.h.a;
import c.b.a.c.k;

/* compiled from: TextAppearance */
public class c {

    /* renamed from: a reason: collision with root package name */
    public final float f3150a;

    /* renamed from: b reason: collision with root package name */
    public final ColorStateList f3151b;

    /* renamed from: c reason: collision with root package name */
    public final ColorStateList f3152c;

    /* renamed from: d reason: collision with root package name */
    public final ColorStateList f3153d;

    /* renamed from: e reason: collision with root package name */
    public final int f3154e;

    /* renamed from: f reason: collision with root package name */
    public final int f3155f;

    /* renamed from: g reason: collision with root package name */
    public final String f3156g;

    /* renamed from: h reason: collision with root package name */
    public final boolean f3157h;

    /* renamed from: i reason: collision with root package name */
    public final ColorStateList f3158i;

    /* renamed from: j reason: collision with root package name */
    public final float f3159j;

    /* renamed from: k reason: collision with root package name */
    public final float f3160k;

    /* renamed from: l reason: collision with root package name */
    public final float f3161l;
    private final int m;
    /* access modifiers changed from: private */
    public boolean n = false;
    /* access modifiers changed from: private */
    public Typeface o;

    public c(Context context, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, k.TextAppearance);
        this.f3150a = obtainStyledAttributes.getDimension(k.TextAppearance_android_textSize, 0.0f);
        this.f3151b = a.a(context, obtainStyledAttributes, k.TextAppearance_android_textColor);
        this.f3152c = a.a(context, obtainStyledAttributes, k.TextAppearance_android_textColorHint);
        this.f3153d = a.a(context, obtainStyledAttributes, k.TextAppearance_android_textColorLink);
        this.f3154e = obtainStyledAttributes.getInt(k.TextAppearance_android_textStyle, 0);
        this.f3155f = obtainStyledAttributes.getInt(k.TextAppearance_android_typeface, 1);
        int a2 = a.a(obtainStyledAttributes, k.TextAppearance_fontFamily, k.TextAppearance_android_fontFamily);
        this.m = obtainStyledAttributes.getResourceId(a2, 0);
        this.f3156g = obtainStyledAttributes.getString(a2);
        this.f3157h = obtainStyledAttributes.getBoolean(k.TextAppearance_textAllCaps, false);
        this.f3158i = a.a(context, obtainStyledAttributes, k.TextAppearance_android_shadowColor);
        this.f3159j = obtainStyledAttributes.getFloat(k.TextAppearance_android_shadowDx, 0.0f);
        this.f3160k = obtainStyledAttributes.getFloat(k.TextAppearance_android_shadowDy, 0.0f);
        this.f3161l = obtainStyledAttributes.getFloat(k.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
    }

    public void b(Context context, TextPaint textPaint, a aVar) {
        c(context, textPaint, aVar);
        ColorStateList colorStateList = this.f3151b;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f2 = this.f3161l;
        float f3 = this.f3159j;
        float f4 = this.f3160k;
        ColorStateList colorStateList2 = this.f3158i;
        textPaint.setShadowLayer(f2, f3, f4, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void c(Context context, TextPaint textPaint, a aVar) {
        if (d.a()) {
            a(textPaint, a(context));
            return;
        }
        a(context, textPaint, aVar);
        if (!this.n) {
            a(textPaint, this.o);
        }
    }

    public Typeface a(Context context) {
        if (this.n) {
            return this.o;
        }
        if (!context.isRestricted()) {
            try {
                this.o = h.a(context, this.m);
                if (this.o != null) {
                    this.o = Typeface.create(this.o, this.f3154e);
                }
            } catch (NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Error loading font ");
                sb.append(this.f3156g);
                Log.d("TextAppearance", sb.toString(), e2);
            }
        }
        a();
        this.n = true;
        return this.o;
    }

    public void a(Context context, TextPaint textPaint, a aVar) {
        if (this.n) {
            a(textPaint, this.o);
            return;
        }
        a();
        if (context.isRestricted()) {
            this.n = true;
            a(textPaint, this.o);
            return;
        }
        try {
            h.a(context, this.m, new b(this, textPaint, aVar), null);
        } catch (NotFoundException | UnsupportedOperationException unused) {
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error loading font ");
            sb.append(this.f3156g);
            Log.d("TextAppearance", sb.toString(), e2);
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        if (this.o == null) {
            this.o = Typeface.create(this.f3156g, this.f3154e);
        }
        if (this.o == null) {
            int i2 = this.f3155f;
            if (i2 == 1) {
                this.o = Typeface.SANS_SERIF;
            } else if (i2 == 2) {
                this.o = Typeface.SERIF;
            } else if (i2 != 3) {
                this.o = Typeface.DEFAULT;
            } else {
                this.o = Typeface.MONOSPACE;
            }
            Typeface typeface = this.o;
            if (typeface != null) {
                this.o = Typeface.create(typeface, this.f3154e);
            }
        }
    }

    public void a(TextPaint textPaint, Typeface typeface) {
        textPaint.setTypeface(typeface);
        int i2 = (~typeface.getStyle()) & this.f3154e;
        textPaint.setFakeBoldText((i2 & 1) != 0);
        textPaint.setTextSkewX((i2 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f3150a);
    }
}
