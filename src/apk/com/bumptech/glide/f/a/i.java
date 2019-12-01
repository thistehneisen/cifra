package com.bumptech.glide.f.a;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.WindowManager;
import com.bumptech.glide.f.c;
import com.bumptech.glide.h.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
/* compiled from: ViewTarget */
public abstract class i<T extends View, Z> extends a<Z> {

    /* renamed from: b reason: collision with root package name */
    private static boolean f3446b;

    /* renamed from: c reason: collision with root package name */
    private static Integer f3447c;

    /* renamed from: d reason: collision with root package name */
    protected final T f3448d;

    /* renamed from: e reason: collision with root package name */
    private final a f3449e;

    /* renamed from: f reason: collision with root package name */
    private OnAttachStateChangeListener f3450f;

    /* renamed from: g reason: collision with root package name */
    private boolean f3451g;

    /* renamed from: h reason: collision with root package name */
    private boolean f3452h;

    /* compiled from: ViewTarget */
    static final class a {

        /* renamed from: a reason: collision with root package name */
        static Integer f3453a;

        /* renamed from: b reason: collision with root package name */
        private final View f3454b;

        /* renamed from: c reason: collision with root package name */
        private final List<g> f3455c = new ArrayList();

        /* renamed from: d reason: collision with root package name */
        boolean f3456d;

        /* renamed from: e reason: collision with root package name */
        private C0046a f3457e;

        /* renamed from: com.bumptech.glide.f.a.i$a$a reason: collision with other inner class name */
        /* compiled from: ViewTarget */
        private static final class C0046a implements OnPreDrawListener {

            /* renamed from: a reason: collision with root package name */
            private final WeakReference<a> f3458a;

            C0046a(a aVar) {
                this.f3458a = new WeakReference<>(aVar);
            }

            public boolean onPreDraw() {
                String str = "ViewTarget";
                if (Log.isLoggable(str, 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("OnGlobalLayoutListener called attachStateListener=");
                    sb.append(this);
                    Log.v(str, sb.toString());
                }
                a aVar = (a) this.f3458a.get();
                if (aVar != null) {
                    aVar.a();
                }
                return true;
            }
        }

        a(View view) {
            this.f3454b = view;
        }

        private static int a(Context context) {
            if (f3453a == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                l.a(windowManager);
                Display defaultDisplay = windowManager.getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f3453a = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f3453a.intValue();
        }

        private boolean a(int i2) {
            return i2 > 0 || i2 == Integer.MIN_VALUE;
        }

        private void b(int i2, int i3) {
            Iterator it = new ArrayList(this.f3455c).iterator();
            while (it.hasNext()) {
                ((g) it.next()).a(i2, i3);
            }
        }

        private int c() {
            int paddingTop = this.f3454b.getPaddingTop() + this.f3454b.getPaddingBottom();
            LayoutParams layoutParams = this.f3454b.getLayoutParams();
            return a(this.f3454b.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int d() {
            int paddingLeft = this.f3454b.getPaddingLeft() + this.f3454b.getPaddingRight();
            LayoutParams layoutParams = this.f3454b.getLayoutParams();
            return a(this.f3454b.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        /* access modifiers changed from: 0000 */
        public void b(g gVar) {
            this.f3455c.remove(gVar);
        }

        /* access modifiers changed from: 0000 */
        public void b() {
            ViewTreeObserver viewTreeObserver = this.f3454b.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f3457e);
            }
            this.f3457e = null;
            this.f3455c.clear();
        }

        /* access modifiers changed from: 0000 */
        public void a() {
            if (!this.f3455c.isEmpty()) {
                int d2 = d();
                int c2 = c();
                if (a(d2, c2)) {
                    b(d2, c2);
                    b();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void a(g gVar) {
            int d2 = d();
            int c2 = c();
            if (a(d2, c2)) {
                gVar.a(d2, c2);
                return;
            }
            if (!this.f3455c.contains(gVar)) {
                this.f3455c.add(gVar);
            }
            if (this.f3457e == null) {
                ViewTreeObserver viewTreeObserver = this.f3454b.getViewTreeObserver();
                this.f3457e = new C0046a(this);
                viewTreeObserver.addOnPreDrawListener(this.f3457e);
            }
        }

        private boolean a(int i2, int i3) {
            return a(i2) && a(i3);
        }

        private int a(int i2, int i3, int i4) {
            int i5 = i3 - i4;
            if (i5 > 0) {
                return i5;
            }
            if (this.f3456d && this.f3454b.isLayoutRequested()) {
                return 0;
            }
            int i6 = i2 - i4;
            if (i6 > 0) {
                return i6;
            }
            if (this.f3454b.isLayoutRequested() || i3 != -2) {
                return 0;
            }
            String str = "ViewTarget";
            if (Log.isLoggable(str, 4)) {
                Log.i(str, "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return a(this.f3454b.getContext());
        }
    }

    public i(T t) {
        l.a(t);
        this.f3448d = (View) t;
        this.f3449e = new a(t);
    }

    private void b() {
        OnAttachStateChangeListener onAttachStateChangeListener = this.f3450f;
        if (onAttachStateChangeListener != null && !this.f3452h) {
            this.f3448d.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f3452h = true;
        }
    }

    private void c() {
        OnAttachStateChangeListener onAttachStateChangeListener = this.f3450f;
        if (onAttachStateChangeListener != null && this.f3452h) {
            this.f3448d.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f3452h = false;
        }
    }

    public void a(g gVar) {
        this.f3449e.b(gVar);
    }

    public c getRequest() {
        Object a2 = a();
        if (a2 == null) {
            return null;
        }
        if (a2 instanceof c) {
            return (c) a2;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    public void onLoadCleared(Drawable drawable) {
        super.onLoadCleared(drawable);
        this.f3449e.b();
        if (!this.f3451g) {
            c();
        }
    }

    public void onLoadStarted(Drawable drawable) {
        super.onLoadStarted(drawable);
        b();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Target for: ");
        sb.append(this.f3448d);
        return sb.toString();
    }

    public void a(c cVar) {
        a((Object) cVar);
    }

    private void a(Object obj) {
        Integer num = f3447c;
        if (num == null) {
            f3446b = true;
            this.f3448d.setTag(obj);
            return;
        }
        this.f3448d.setTag(num.intValue(), obj);
    }

    public void b(g gVar) {
        this.f3449e.a(gVar);
    }

    private Object a() {
        Integer num = f3447c;
        if (num == null) {
            return this.f3448d.getTag();
        }
        return this.f3448d.getTag(num.intValue());
    }
}
