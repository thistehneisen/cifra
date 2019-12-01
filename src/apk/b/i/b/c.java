package b.i.b;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import b.d.j;
import b.g.i.B;
import b.g.i.C0240a;
import b.g.i.H;
import b.g.i.a.d;
import b.g.i.a.e;
import b.g.i.a.f;
import b.i.b.d.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ExploreByTouchHelper */
public abstract class c extends C0240a {

    /* renamed from: d reason: collision with root package name */
    private static final Rect f2744d = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* renamed from: e reason: collision with root package name */
    private static final b.i.b.d.a<d> f2745e = new a();

    /* renamed from: f reason: collision with root package name */
    private static final b<j<d>, d> f2746f = new b();

    /* renamed from: g reason: collision with root package name */
    private final Rect f2747g = new Rect();

    /* renamed from: h reason: collision with root package name */
    private final Rect f2748h = new Rect();

    /* renamed from: i reason: collision with root package name */
    private final Rect f2749i = new Rect();

    /* renamed from: j reason: collision with root package name */
    private final int[] f2750j = new int[2];

    /* renamed from: k reason: collision with root package name */
    private final AccessibilityManager f2751k;

    /* renamed from: l reason: collision with root package name */
    private final View f2752l;
    private a m;
    int n = Integer.MIN_VALUE;
    int o = Integer.MIN_VALUE;
    private int p = Integer.MIN_VALUE;

    /* compiled from: ExploreByTouchHelper */
    private class a extends e {
        a() {
        }

        public d a(int i2) {
            return d.a(c.this.b(i2));
        }

        public d b(int i2) {
            int i3 = i2 == 2 ? c.this.n : c.this.o;
            if (i3 == Integer.MIN_VALUE) {
                return null;
            }
            return a(i3);
        }

        public boolean a(int i2, int i3, Bundle bundle) {
            return c.this.b(i2, i3, bundle);
        }
    }

    public c(View view) {
        if (view != null) {
            this.f2752l = view;
            this.f2751k = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            if (B.k(view) == 0) {
                B.e(view, 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    private boolean b(int i2, Rect rect) {
        d dVar;
        d dVar2;
        j d2 = d();
        int i3 = this.o;
        int i4 = Integer.MIN_VALUE;
        if (i3 == Integer.MIN_VALUE) {
            dVar = null;
        } else {
            dVar = (d) d2.a(i3);
        }
        Object obj = dVar;
        if (i2 == 1 || i2 == 2) {
            dVar2 = (d) d.a(d2, f2746f, f2745e, obj, i2, B.m(this.f2752l) == 1, false);
        } else if (i2 == 17 || i2 == 33 || i2 == 66 || i2 == 130) {
            Rect rect2 = new Rect();
            int i5 = this.o;
            if (i5 != Integer.MIN_VALUE) {
                a(i5, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                a(this.f2752l, i2, rect2);
            }
            dVar2 = (d) d.a(d2, f2746f, f2745e, obj, rect2, i2);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        if (dVar2 != null) {
            i4 = d2.c(d2.a(dVar2));
        }
        return c(i4);
    }

    private AccessibilityEvent c(int i2, int i3) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i3);
        d b2 = b(i2);
        obtain.getText().add(b2.g());
        obtain.setContentDescription(b2.d());
        obtain.setScrollable(b2.q());
        obtain.setPassword(b2.p());
        obtain.setEnabled(b2.l());
        obtain.setChecked(b2.j());
        a(i2, obtain);
        if (!obtain.getText().isEmpty() || obtain.getContentDescription() != null) {
            obtain.setClassName(b2.c());
            f.a(obtain, this.f2752l, i2);
            obtain.setPackageName(this.f2752l.getContext().getPackageName());
            return obtain;
        }
        throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }

    private j<d> d() {
        ArrayList arrayList = new ArrayList();
        a((List<Integer>) arrayList);
        j<d> jVar = new j<>();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            jVar.c(i2, f(i2));
        }
        return jVar;
    }

    private AccessibilityEvent e(int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        this.f2752l.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    private d f(int i2) {
        d s = d.s();
        s.e(true);
        s.f(true);
        s.b((CharSequence) "android.view.View");
        s.c(f2744d);
        s.d(f2744d);
        s.b(this.f2752l);
        a(i2, s);
        if (s.g() == null && s.d() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        s.a(this.f2748h);
        if (!this.f2748h.equals(f2744d)) {
            int a2 = s.a();
            if ((a2 & 64) != 0) {
                throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            } else if ((a2 & 128) == 0) {
                s.d((CharSequence) this.f2752l.getContext().getPackageName());
                s.c(this.f2752l, i2);
                if (this.n == i2) {
                    s.a(true);
                    s.a(128);
                } else {
                    s.a(false);
                    s.a(64);
                }
                boolean z = this.o == i2;
                if (z) {
                    s.a(2);
                } else if (s.m()) {
                    s.a(1);
                }
                s.g(z);
                this.f2752l.getLocationOnScreen(this.f2750j);
                s.b(this.f2747g);
                if (this.f2747g.equals(f2744d)) {
                    s.a(this.f2747g);
                    if (s.f2672c != -1) {
                        d s2 = d.s();
                        for (int i3 = s.f2672c; i3 != -1; i3 = s2.f2672c) {
                            s2.b(this.f2752l, -1);
                            s2.c(f2744d);
                            a(i3, s2);
                            s2.a(this.f2748h);
                            Rect rect = this.f2747g;
                            Rect rect2 = this.f2748h;
                            rect.offset(rect2.left, rect2.top);
                        }
                        s2.t();
                    }
                    this.f2747g.offset(this.f2750j[0] - this.f2752l.getScrollX(), this.f2750j[1] - this.f2752l.getScrollY());
                }
                if (this.f2752l.getLocalVisibleRect(this.f2749i)) {
                    this.f2749i.offset(this.f2750j[0] - this.f2752l.getScrollX(), this.f2750j[1] - this.f2752l.getScrollY());
                    if (this.f2747g.intersect(this.f2749i)) {
                        s.d(this.f2747g);
                        if (a(this.f2747g)) {
                            s.k(true);
                        }
                    }
                }
                return s;
            } else {
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
        } else {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
    }

    private static int g(int i2) {
        if (i2 == 19) {
            return 33;
        }
        if (i2 != 21) {
            return i2 != 22 ? 130 : 66;
        }
        return 17;
    }

    private boolean h(int i2) {
        if (this.f2751k.isEnabled() && this.f2751k.isTouchExplorationEnabled()) {
            int i3 = this.n;
            if (i3 != i2) {
                if (i3 != Integer.MIN_VALUE) {
                    d(i3);
                }
                this.n = i2;
                this.f2752l.invalidate();
                a(i2, 32768);
                return true;
            }
        }
        return false;
    }

    private void i(int i2) {
        int i3 = this.p;
        if (i3 != i2) {
            this.p = i2;
            a(i2, 128);
            a(i3, 256);
        }
    }

    /* access modifiers changed from: protected */
    public abstract int a(float f2, float f3);

    public e a(View view) {
        if (this.m == null) {
            this.m = new a();
        }
        return this.m;
    }

    /* access modifiers changed from: protected */
    public void a(int i2, AccessibilityEvent accessibilityEvent) {
    }

    /* access modifiers changed from: protected */
    public abstract void a(int i2, d dVar);

    /* access modifiers changed from: protected */
    public void a(int i2, boolean z) {
    }

    /* access modifiers changed from: protected */
    public void a(AccessibilityEvent accessibilityEvent) {
    }

    /* access modifiers changed from: protected */
    public void a(d dVar) {
    }

    /* access modifiers changed from: protected */
    public abstract void a(List<Integer> list);

    /* access modifiers changed from: protected */
    public abstract boolean a(int i2, int i3, Bundle bundle);

    public final boolean a(MotionEvent motionEvent) {
        boolean z = false;
        if (this.f2751k.isEnabled() && this.f2751k.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action == 7 || action == 9) {
                int a2 = a(motionEvent.getX(), motionEvent.getY());
                i(a2);
                if (a2 != Integer.MIN_VALUE) {
                    z = true;
                }
            } else if (action != 10 || this.p == Integer.MIN_VALUE) {
                return false;
            } else {
                i(Integer.MIN_VALUE);
                return true;
            }
        }
        return z;
    }

    private boolean d(int i2) {
        if (this.n != i2) {
            return false;
        }
        this.n = Integer.MIN_VALUE;
        this.f2752l.invalidate();
        a(i2, 65536);
        return true;
    }

    public final boolean a(KeyEvent keyEvent) {
        int i2 = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 61) {
            if (keyCode != 66) {
                switch (keyCode) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                        if (!keyEvent.hasNoModifiers()) {
                            return false;
                        }
                        int g2 = g(keyCode);
                        int repeatCount = keyEvent.getRepeatCount() + 1;
                        boolean z = false;
                        while (i2 < repeatCount && b(g2, (Rect) null)) {
                            i2++;
                            z = true;
                        }
                        return z;
                    case 23:
                        break;
                    default:
                        return false;
                }
            }
            if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
                return false;
            }
            b();
            return true;
        } else if (keyEvent.hasNoModifiers()) {
            return b(2, (Rect) null);
        } else {
            if (keyEvent.hasModifiers(1)) {
                return b(1, (Rect) null);
            }
            return false;
        }
    }

    private d c() {
        d a2 = d.a(this.f2752l);
        B.a(this.f2752l, a2);
        ArrayList arrayList = new ArrayList();
        a((List<Integer>) arrayList);
        if (a2.b() <= 0 || arrayList.size() <= 0) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                a2.a(this.f2752l, ((Integer) arrayList.get(i2)).intValue());
            }
            return a2;
        }
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    private boolean b() {
        int i2 = this.o;
        return i2 != Integer.MIN_VALUE && a(i2, 16, (Bundle) null);
    }

    private AccessibilityEvent b(int i2, int i3) {
        if (i2 != -1) {
            return c(i2, i3);
        }
        return e(i3);
    }

    public void b(View view, AccessibilityEvent accessibilityEvent) {
        super.b(view, accessibilityEvent);
        a(accessibilityEvent);
    }

    /* access modifiers changed from: 0000 */
    public d b(int i2) {
        if (i2 == -1) {
            return c();
        }
        return f(i2);
    }

    public final void a(boolean z, int i2, Rect rect) {
        int i3 = this.o;
        if (i3 != Integer.MIN_VALUE) {
            a(i3);
        }
        if (z) {
            b(i2, rect);
        }
    }

    private boolean c(int i2, int i3, Bundle bundle) {
        if (i3 == 1) {
            return c(i2);
        }
        if (i3 == 2) {
            return a(i2);
        }
        if (i3 == 64) {
            return h(i2);
        }
        if (i3 != 128) {
            return a(i2, i3, bundle);
        }
        return d(i2);
    }

    /* access modifiers changed from: 0000 */
    public boolean b(int i2, int i3, Bundle bundle) {
        if (i2 != -1) {
            return c(i2, i3, bundle);
        }
        return a(i3, bundle);
    }

    private void a(int i2, Rect rect) {
        b(i2).a(rect);
    }

    private static Rect a(View view, int i2, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i2 == 17) {
            rect.set(width, 0, width, height);
        } else if (i2 == 33) {
            rect.set(0, height, width, height);
        } else if (i2 == 66) {
            rect.set(-1, 0, -1, height);
        } else if (i2 == 130) {
            rect.set(0, -1, width, -1);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return rect;
    }

    public final boolean c(int i2) {
        if (!this.f2752l.isFocused() && !this.f2752l.requestFocus()) {
            return false;
        }
        int i3 = this.o;
        if (i3 == i2) {
            return false;
        }
        if (i3 != Integer.MIN_VALUE) {
            a(i3);
        }
        this.o = i2;
        a(i2, true);
        a(i2, 8);
        return true;
    }

    public final boolean a(int i2, int i3) {
        if (i2 == Integer.MIN_VALUE || !this.f2751k.isEnabled()) {
            return false;
        }
        ViewParent parent = this.f2752l.getParent();
        if (parent == null) {
            return false;
        }
        return H.a(parent, this.f2752l, b(i2, i3));
    }

    public void a(View view, d dVar) {
        super.a(view, dVar);
        a(dVar);
    }

    private boolean a(int i2, Bundle bundle) {
        return B.a(this.f2752l, i2, bundle);
    }

    private boolean a(Rect rect) {
        boolean z = false;
        if (rect != null && !rect.isEmpty()) {
            if (this.f2752l.getWindowVisibility() != 0) {
                return false;
            }
            ViewParent parent = this.f2752l.getParent();
            while (parent instanceof View) {
                View view = (View) parent;
                if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                    return false;
                }
                parent = view.getParent();
            }
            if (parent != null) {
                z = true;
            }
        }
        return z;
    }

    public final boolean a(int i2) {
        if (this.o != i2) {
            return false;
        }
        this.o = Integer.MIN_VALUE;
        a(i2, false);
        a(i2, 8);
        return true;
    }
}
