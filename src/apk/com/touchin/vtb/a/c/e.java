package com.touchin.vtb.a.c;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.x;
import c.c.a.a;
import kotlin.e.b.h;

/* compiled from: SwipeableViewHolder.kt */
public abstract class e extends x implements a {

    /* renamed from: a reason: collision with root package name */
    private final View f6916a;

    /* renamed from: b reason: collision with root package name */
    private final View f6917b;

    public e(View view) {
        h.b(view, "itemView");
        super(view);
    }

    public float a() {
        int i2;
        if (b().getTranslationX() > ((float) 0)) {
            View d2 = d();
            if (d2 == null) {
                return 0.0f;
            }
            i2 = d2.getWidth();
        } else {
            View c2 = c();
            if (c2 == null) {
                return 0.0f;
            }
            i2 = c2.getWidth();
        }
        return (float) i2;
    }

    /* access modifiers changed from: protected */
    public abstract View b();

    /* access modifiers changed from: protected */
    public View c() {
        return this.f6916a;
    }

    /* access modifiers changed from: protected */
    public View d() {
        return this.f6917b;
    }

    public final boolean e() {
        return b().getTranslationX() != 0.0f;
    }

    public void a(float f2) {
        View b2 = b();
        float f3 = 0.0f;
        if (f2 > ((float) 0)) {
            View d2 = d();
            if (d2 != null) {
                f3 = Math.min(f2, (float) d2.getWidth());
            }
        } else {
            View c2 = c();
            if (c2 != null) {
                f3 = Math.max(f2, -((float) c2.getWidth()));
            }
        }
        b2.setTranslationX(f3);
    }
}
