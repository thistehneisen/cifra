package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import b.a.d.b.a;
import b.a.j;

/* renamed from: androidx.appcompat.app.a reason: case insensitive filesystem */
/* compiled from: ActionBar */
public abstract class C0134a {

    /* renamed from: androidx.appcompat.app.a$a reason: collision with other inner class name */
    /* compiled from: ActionBar */
    public static class C0006a extends MarginLayoutParams {

        /* renamed from: a reason: collision with root package name */
        public int f471a;

        public C0006a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f471a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ActionBarLayout);
            this.f471a = obtainStyledAttributes.getInt(j.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public C0006a(int i2, int i3) {
            super(i2, i3);
            this.f471a = 0;
            this.f471a = 8388627;
        }

        public C0006a(C0006a aVar) {
            super(aVar);
            this.f471a = 0;
            this.f471a = aVar.f471a;
        }

        public C0006a(LayoutParams layoutParams) {
            super(layoutParams);
            this.f471a = 0;
        }
    }

    /* renamed from: androidx.appcompat.app.a$b */
    /* compiled from: ActionBar */
    public interface b {
        void onMenuVisibilityChanged(boolean z);
    }

    @Deprecated
    /* renamed from: androidx.appcompat.app.a$c */
    /* compiled from: ActionBar */
    public static abstract class c {
        public abstract CharSequence a();

        public abstract View b();

        public abstract Drawable c();

        public abstract CharSequence d();

        public abstract void e();
    }

    public b.a.d.b a(a aVar) {
        return null;
    }

    public void a(Configuration configuration) {
    }

    public abstract void a(CharSequence charSequence);

    public abstract boolean a(int i2, KeyEvent keyEvent);

    public boolean a(KeyEvent keyEvent) {
        return false;
    }

    public abstract void b(int i2);

    public abstract void b(CharSequence charSequence);

    public abstract void b(boolean z);

    public abstract void c(CharSequence charSequence);

    public abstract void c(boolean z);

    public abstract void d(boolean z);

    public abstract void e(boolean z);

    public boolean e() {
        return false;
    }

    public abstract void f(boolean z);

    public abstract boolean f();

    public abstract int g();

    public abstract void g(boolean z);

    public abstract Context h();

    public boolean i() {
        return false;
    }

    /* access modifiers changed from: 0000 */
    public void j() {
    }

    public boolean k() {
        return false;
    }
}
