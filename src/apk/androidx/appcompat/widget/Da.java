package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnHoverListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import b.g.i.B;
import b.g.i.C;

/* compiled from: TooltipCompatHandler */
class Da implements OnLongClickListener, OnHoverListener, OnAttachStateChangeListener {

    /* renamed from: a reason: collision with root package name */
    private static Da f761a;

    /* renamed from: b reason: collision with root package name */
    private static Da f762b;

    /* renamed from: c reason: collision with root package name */
    private final View f763c;

    /* renamed from: d reason: collision with root package name */
    private final CharSequence f764d;

    /* renamed from: e reason: collision with root package name */
    private final int f765e;

    /* renamed from: f reason: collision with root package name */
    private final Runnable f766f = new Ba(this);

    /* renamed from: g reason: collision with root package name */
    private final Runnable f767g = new Ca(this);

    /* renamed from: h reason: collision with root package name */
    private int f768h;

    /* renamed from: i reason: collision with root package name */
    private int f769i;

    /* renamed from: j reason: collision with root package name */
    private Ea f770j;

    /* renamed from: k reason: collision with root package name */
    private boolean f771k;

    private Da(View view, CharSequence charSequence) {
        this.f763c = view;
        this.f764d = charSequence;
        this.f765e = C.a(ViewConfiguration.get(this.f763c.getContext()));
        c();
        this.f763c.setOnLongClickListener(this);
        this.f763c.setOnHoverListener(this);
    }

    public static void a(View view, CharSequence charSequence) {
        Da da = f761a;
        if (da != null && da.f763c == view) {
            a((Da) null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            Da da2 = f762b;
            if (da2 != null && da2.f763c == view) {
                da2.a();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new Da(view, charSequence);
    }

    private void b() {
        this.f763c.removeCallbacks(this.f766f);
    }

    private void c() {
        this.f768h = Integer.MAX_VALUE;
        this.f769i = Integer.MAX_VALUE;
    }

    private void d() {
        this.f763c.postDelayed(this.f766f, (long) ViewConfiguration.getLongPressTimeout());
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f770j != null && this.f771k) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f763c.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                c();
                a();
            }
        } else if (this.f763c.isEnabled() && this.f770j == null && a(motionEvent)) {
            a(this);
        }
        return false;
    }

    public boolean onLongClick(View view) {
        this.f768h = view.getWidth() / 2;
        this.f769i = view.getHeight() / 2;
        a(true);
        return true;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        a();
    }

    /* access modifiers changed from: 0000 */
    public void a(boolean z) {
        long j2;
        int i2;
        long j3;
        if (B.B(this.f763c)) {
            a((Da) null);
            Da da = f762b;
            if (da != null) {
                da.a();
            }
            f762b = this;
            this.f771k = z;
            this.f770j = new Ea(this.f763c.getContext());
            this.f770j.a(this.f763c, this.f768h, this.f769i, this.f771k, this.f764d);
            this.f763c.addOnAttachStateChangeListener(this);
            if (this.f771k) {
                j2 = 2500;
            } else {
                if ((B.u(this.f763c) & 1) == 1) {
                    j3 = 3000;
                    i2 = ViewConfiguration.getLongPressTimeout();
                } else {
                    j3 = 15000;
                    i2 = ViewConfiguration.getLongPressTimeout();
                }
                j2 = j3 - ((long) i2);
            }
            this.f763c.removeCallbacks(this.f767g);
            this.f763c.postDelayed(this.f767g, j2);
        }
    }

    /* access modifiers changed from: 0000 */
    public void a() {
        if (f762b == this) {
            f762b = null;
            Ea ea = this.f770j;
            if (ea != null) {
                ea.a();
                this.f770j = null;
                c();
                this.f763c.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f761a == this) {
            a((Da) null);
        }
        this.f763c.removeCallbacks(this.f767g);
    }

    private static void a(Da da) {
        Da da2 = f761a;
        if (da2 != null) {
            da2.b();
        }
        f761a = da;
        Da da3 = f761a;
        if (da3 != null) {
            da3.d();
        }
    }

    private boolean a(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (Math.abs(x - this.f768h) <= this.f765e && Math.abs(y - this.f769i) <= this.f765e) {
            return false;
        }
        this.f768h = x;
        this.f769i = y;
        return true;
    }
}
