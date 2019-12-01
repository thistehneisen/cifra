package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import androidx.appcompat.view.menu.v.a;
import androidx.appcompat.widget.U;
import b.a.d;
import b.a.g;
import b.g.i.B;

/* compiled from: StandardMenuPopup */
final class C extends s implements OnDismissListener, OnItemClickListener, v, OnKeyListener {

    /* renamed from: b reason: collision with root package name */
    private static final int f557b = g.abc_popup_menu_item_layout;

    /* renamed from: c reason: collision with root package name */
    private final Context f558c;

    /* renamed from: d reason: collision with root package name */
    private final l f559d;

    /* renamed from: e reason: collision with root package name */
    private final k f560e;

    /* renamed from: f reason: collision with root package name */
    private final boolean f561f;

    /* renamed from: g reason: collision with root package name */
    private final int f562g;

    /* renamed from: h reason: collision with root package name */
    private final int f563h;

    /* renamed from: i reason: collision with root package name */
    private final int f564i;

    /* renamed from: j reason: collision with root package name */
    final U f565j;

    /* renamed from: k reason: collision with root package name */
    final OnGlobalLayoutListener f566k = new A(this);

    /* renamed from: l reason: collision with root package name */
    private final OnAttachStateChangeListener f567l = new B(this);
    private OnDismissListener m;
    private View n;
    View o;
    private a p;
    ViewTreeObserver q;
    private boolean r;
    private boolean s;
    private int t;
    private int u = 0;
    private boolean v;

    public C(Context context, l lVar, View view, int i2, int i3, boolean z) {
        this.f558c = context;
        this.f559d = lVar;
        this.f561f = z;
        this.f560e = new k(lVar, LayoutInflater.from(context), this.f561f, f557b);
        this.f563h = i2;
        this.f564i = i3;
        Resources resources = context.getResources();
        this.f562g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(d.abc_config_prefDialogWidth));
        this.n = view;
        this.f565j = new U(this.f558c, null, this.f563h, this.f564i);
        lVar.a((v) this, context);
    }

    private boolean g() {
        if (c()) {
            return true;
        }
        if (!this.r) {
            View view = this.n;
            if (view != null) {
                this.o = view;
                this.f565j.a((OnDismissListener) this);
                this.f565j.a((OnItemClickListener) this);
                this.f565j.a(true);
                View view2 = this.o;
                boolean z = this.q == null;
                this.q = view2.getViewTreeObserver();
                if (z) {
                    this.q.addOnGlobalLayoutListener(this.f566k);
                }
                view2.addOnAttachStateChangeListener(this.f567l);
                this.f565j.a(view2);
                this.f565j.c(this.u);
                if (!this.s) {
                    this.t = s.a(this.f560e, null, this.f558c, this.f562g);
                    this.s = true;
                }
                this.f565j.b(this.t);
                this.f565j.e(2);
                this.f565j.a(f());
                this.f565j.b();
                ListView d2 = this.f565j.d();
                d2.setOnKeyListener(this);
                if (this.v && this.f559d.h() != null) {
                    FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f558c).inflate(g.abc_popup_menu_header_item_layout, d2, false);
                    TextView textView = (TextView) frameLayout.findViewById(16908310);
                    if (textView != null) {
                        textView.setText(this.f559d.h());
                    }
                    frameLayout.setEnabled(false);
                    d2.addHeaderView(frameLayout, null, false);
                }
                this.f565j.a((ListAdapter) this.f560e);
                this.f565j.b();
                return true;
            }
        }
        return false;
    }

    public void a(int i2) {
        this.u = i2;
    }

    public void a(l lVar) {
    }

    public boolean a() {
        return false;
    }

    public void b(boolean z) {
        this.f560e.a(z);
    }

    public boolean c() {
        return !this.r && this.f565j.c();
    }

    public ListView d() {
        return this.f565j.d();
    }

    public void dismiss() {
        if (c()) {
            this.f565j.dismiss();
        }
    }

    public void onDismiss() {
        this.r = true;
        this.f559d.close();
        ViewTreeObserver viewTreeObserver = this.q;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.q = this.o.getViewTreeObserver();
            }
            this.q.removeGlobalOnLayoutListener(this.f566k);
            this.q = null;
        }
        this.o.removeOnAttachStateChangeListener(this.f567l);
        OnDismissListener onDismissListener = this.m;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void a(boolean z) {
        this.s = false;
        k kVar = this.f560e;
        if (kVar != null) {
            kVar.notifyDataSetChanged();
        }
    }

    public void b() {
        if (!g()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    public void c(int i2) {
        this.f565j.h(i2);
    }

    public void c(boolean z) {
        this.v = z;
    }

    public void b(int i2) {
        this.f565j.d(i2);
    }

    public void a(a aVar) {
        this.p = aVar;
    }

    public boolean a(D d2) {
        if (d2.hasVisibleItems()) {
            u uVar = new u(this.f558c, d2, this.o, this.f561f, this.f563h, this.f564i);
            uVar.a(this.p);
            uVar.a(s.b((l) d2));
            uVar.a(this.m);
            this.m = null;
            this.f559d.a(false);
            int g2 = this.f565j.g();
            int h2 = this.f565j.h();
            if ((Gravity.getAbsoluteGravity(this.u, B.m(this.n)) & 7) == 5) {
                g2 += this.n.getWidth();
            }
            if (uVar.a(g2, h2)) {
                a aVar = this.p;
                if (aVar != null) {
                    aVar.a(d2);
                }
                return true;
            }
        }
        return false;
    }

    public void a(l lVar, boolean z) {
        if (lVar == this.f559d) {
            dismiss();
            a aVar = this.p;
            if (aVar != null) {
                aVar.a(lVar, z);
            }
        }
    }

    public void a(View view) {
        this.n = view;
    }

    public void a(OnDismissListener onDismissListener) {
        this.m = onDismissListener;
    }
}
