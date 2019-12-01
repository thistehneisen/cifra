package b.p;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import b.g.i.B;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* compiled from: ViewOverlayApi14 */
class W implements Y {

    /* renamed from: a reason: collision with root package name */
    protected a f2854a;

    /* compiled from: ViewOverlayApi14 */
    static class a extends ViewGroup {

        /* renamed from: a reason: collision with root package name */
        static Method f2855a;

        /* renamed from: b reason: collision with root package name */
        ViewGroup f2856b;

        /* renamed from: c reason: collision with root package name */
        View f2857c;

        /* renamed from: d reason: collision with root package name */
        ArrayList<Drawable> f2858d = null;

        /* renamed from: e reason: collision with root package name */
        W f2859e;

        static {
            try {
                f2855a = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", new Class[]{Integer.TYPE, Integer.TYPE, Rect.class});
            } catch (NoSuchMethodException unused) {
            }
        }

        a(Context context, ViewGroup viewGroup, View view, W w) {
            super(context);
            this.f2856b = viewGroup;
            this.f2857c = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.f2859e = w;
        }

        public void a(Drawable drawable) {
            if (this.f2858d == null) {
                this.f2858d = new ArrayList<>();
            }
            if (!this.f2858d.contains(drawable)) {
                this.f2858d.add(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(this);
            }
        }

        public void b(Drawable drawable) {
            ArrayList<Drawable> arrayList = this.f2858d;
            if (arrayList != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(null);
            }
        }

        /* access modifiers changed from: protected */
        public void dispatchDraw(Canvas canvas) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.f2856b.getLocationOnScreen(iArr);
            this.f2857c.getLocationOnScreen(iArr2);
            canvas.translate((float) (iArr2[0] - iArr[0]), (float) (iArr2[1] - iArr[1]));
            canvas.clipRect(new Rect(0, 0, this.f2857c.getWidth(), this.f2857c.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.f2858d;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((Drawable) this.f2858d.get(i2)).draw(canvas);
            }
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.f2856b != null) {
                rect.offset(iArr[0], iArr[1]);
                if (this.f2856b instanceof ViewGroup) {
                    iArr[0] = 0;
                    iArr[1] = 0;
                    int[] iArr2 = new int[2];
                    a(iArr2);
                    rect.offset(iArr2[0], iArr2[1]);
                    return super.invalidateChildInParent(iArr, rect);
                }
                invalidate(rect);
            }
            return null;
        }

        public void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        }

        /* access modifiers changed from: protected */
        public boolean verifyDrawable(Drawable drawable) {
            if (!super.verifyDrawable(drawable)) {
                ArrayList<Drawable> arrayList = this.f2858d;
                if (arrayList == null || !arrayList.contains(drawable)) {
                    return false;
                }
            }
            return true;
        }

        public void b(View view) {
            super.removeView(view);
            if (a()) {
                this.f2856b.removeView(this);
            }
        }

        public void a(View view) {
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (!(viewGroup == this.f2856b || viewGroup.getParent() == null || !B.B(viewGroup))) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.f2856b.getLocationOnScreen(iArr2);
                    B.b(view, iArr[0] - iArr2[0]);
                    B.c(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view, getChildCount() - 1);
        }

        /* access modifiers changed from: 0000 */
        public boolean a() {
            if (getChildCount() == 0) {
                ArrayList<Drawable> arrayList = this.f2858d;
                if (arrayList == null || arrayList.size() == 0) {
                    return true;
                }
            }
            return false;
        }

        private void a(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.f2856b.getLocationOnScreen(iArr2);
            this.f2857c.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }
    }

    W(Context context, ViewGroup viewGroup, View view) {
        this.f2854a = new a(context, viewGroup, view, this);
    }

    static W c(View view) {
        ViewGroup d2 = d(view);
        if (d2 == null) {
            return null;
        }
        int childCount = d2.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = d2.getChildAt(i2);
            if (childAt instanceof a) {
                return ((a) childAt).f2859e;
            }
        }
        return new O(d2.getContext(), d2, view);
    }

    static ViewGroup d(View view) {
        while (view != null) {
            if (view.getId() == 16908290 && (view instanceof ViewGroup)) {
                return (ViewGroup) view;
            }
            if (view.getParent() instanceof ViewGroup) {
                view = (ViewGroup) view.getParent();
            }
        }
        return null;
    }

    public void a(Drawable drawable) {
        this.f2854a.a(drawable);
    }

    public void b(Drawable drawable) {
        this.f2854a.b(drawable);
    }
}
