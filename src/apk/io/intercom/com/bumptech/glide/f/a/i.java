package io.intercom.com.bumptech.glide.f.a;

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
import io.intercom.com.bumptech.glide.f.c;
import io.intercom.com.bumptech.glide.h.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ViewTarget */
public abstract class i<T extends View, Z> extends a<Z> {

    /* renamed from: a reason: collision with root package name */
    private static boolean f9302a = false;

    /* renamed from: b reason: collision with root package name */
    private static Integer f9303b;

    /* renamed from: c reason: collision with root package name */
    protected final T f9304c;

    /* renamed from: d reason: collision with root package name */
    private final a f9305d;

    /* renamed from: e reason: collision with root package name */
    private OnAttachStateChangeListener f9306e;

    /* renamed from: f reason: collision with root package name */
    private boolean f9307f;

    /* renamed from: g reason: collision with root package name */
    private boolean f9308g;

    /* compiled from: ViewTarget */
    static final class a {

        /* renamed from: a reason: collision with root package name */
        static Integer f9309a;

        /* renamed from: b reason: collision with root package name */
        private final View f9310b;

        /* renamed from: c reason: collision with root package name */
        private final List<g> f9311c = new ArrayList();

        /* renamed from: d reason: collision with root package name */
        private boolean f9312d;

        /* renamed from: e reason: collision with root package name */
        private C0102a f9313e;

        /* renamed from: io.intercom.com.bumptech.glide.f.a.i$a$a reason: collision with other inner class name */
        /* compiled from: ViewTarget */
        private static final class C0102a implements OnPreDrawListener {

            /* renamed from: a reason: collision with root package name */
            private final WeakReference<a> f9314a;

            C0102a(a aVar) {
                this.f9314a = new WeakReference<>(aVar);
            }

            public boolean onPreDraw() {
                String str = "ViewTarget";
                if (Log.isLoggable(str, 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("OnGlobalLayoutListener called attachStateListener=");
                    sb.append(this);
                    Log.v(str, sb.toString());
                }
                a aVar = (a) this.f9314a.get();
                if (aVar != null) {
                    aVar.a();
                }
                return true;
            }
        }

        a(View view) {
            this.f9310b = view;
        }

        private static int a(Context context) {
            if (f9309a == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                h.a(windowManager);
                Display defaultDisplay = windowManager.getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f9309a = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f9309a.intValue();
        }

        private boolean a(int i2) {
            return i2 > 0 || i2 == Integer.MIN_VALUE;
        }

        private void b(int i2, int i3) {
            Iterator it = new ArrayList(this.f9311c).iterator();
            while (it.hasNext()) {
                ((g) it.next()).a(i2, i3);
            }
        }

        private int c() {
            int paddingTop = this.f9310b.getPaddingTop() + this.f9310b.getPaddingBottom();
            LayoutParams layoutParams = this.f9310b.getLayoutParams();
            return a(this.f9310b.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int d() {
            int paddingLeft = this.f9310b.getPaddingLeft() + this.f9310b.getPaddingRight();
            LayoutParams layoutParams = this.f9310b.getLayoutParams();
            return a(this.f9310b.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        /* access modifiers changed from: 0000 */
        public void b(g gVar) {
            this.f9311c.remove(gVar);
        }

        /* access modifiers changed from: 0000 */
        public void b() {
            ViewTreeObserver viewTreeObserver = this.f9310b.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f9313e);
            }
            this.f9313e = null;
            this.f9311c.clear();
        }

        /* access modifiers changed from: 0000 */
        public void a() {
            if (!this.f9311c.isEmpty()) {
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
            if (!this.f9311c.contains(gVar)) {
                this.f9311c.add(gVar);
            }
            if (this.f9313e == null) {
                ViewTreeObserver viewTreeObserver = this.f9310b.getViewTreeObserver();
                this.f9313e = new C0102a(this);
                viewTreeObserver.addOnPreDrawListener(this.f9313e);
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
            if (this.f9312d && this.f9310b.isLayoutRequested()) {
                return 0;
            }
            int i6 = i2 - i4;
            if (i6 > 0) {
                return i6;
            }
            if (this.f9310b.isLayoutRequested() || i3 != -2) {
                return 0;
            }
            String str = "ViewTarget";
            if (Log.isLoggable(str, 4)) {
                Log.i(str, "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return a(this.f9310b.getContext());
        }
    }

    public i(T t) {
        h.a(t);
        this.f9304c = (View) t;
        this.f9305d = new a(t);
    }

    private void a(Object obj) {
        Integer num = f9303b;
        if (num == null) {
            f9302a = true;
            this.f9304c.setTag(obj);
            return;
        }
        this.f9304c.setTag(num.intValue(), obj);
    }

    private Object b() {
        Integer num = f9303b;
        if (num == null) {
            return this.f9304c.getTag();
        }
        return this.f9304c.getTag(num.intValue());
    }

    private void c() {
        OnAttachStateChangeListener onAttachStateChangeListener = this.f9306e;
        if (onAttachStateChangeListener != null && !this.f9308g) {
            this.f9304c.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f9308g = true;
        }
    }

    private void d() {
        OnAttachStateChangeListener onAttachStateChangeListener = this.f9306e;
        if (onAttachStateChangeListener != null && this.f9308g) {
            this.f9304c.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f9308g = false;
        }
    }

    public c getRequest() {
        Object b2 = b();
        if (b2 == null) {
            return null;
        }
        if (b2 instanceof c) {
            return (c) b2;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    public void getSize(g gVar) {
        this.f9305d.a(gVar);
    }

    public void onLoadCleared(Drawable drawable) {
        super.onLoadCleared(drawable);
        this.f9305d.b();
        if (!this.f9307f) {
            d();
        }
    }

    public void onLoadStarted(Drawable drawable) {
        super.onLoadStarted(drawable);
        c();
    }

    public void removeCallback(g gVar) {
        this.f9305d.b(gVar);
    }

    public void setRequest(c cVar) {
        a(cVar);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Target for: ");
        sb.append(this.f9304c);
        return sb.toString();
    }
}
