package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.J;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Y;
import b.a.d.b;
import b.a.d.g;
import b.a.d.i;
import b.a.f;
import b.a.j;
import b.g.i.B;
import b.g.i.K;
import b.g.i.L;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: WindowDecorActionBar */
public class N extends C0134a implements androidx.appcompat.widget.ActionBarOverlayLayout.a {

    /* renamed from: a reason: collision with root package name */
    private static final Interpolator f454a = new AccelerateInterpolator();

    /* renamed from: b reason: collision with root package name */
    private static final Interpolator f455b = new DecelerateInterpolator();
    private boolean A = true;
    i B;
    private boolean C;
    boolean D;
    final L E = new K(this);
    final L F = new L(this);
    final b.g.i.N G = new M(this);

    /* renamed from: c reason: collision with root package name */
    Context f456c;

    /* renamed from: d reason: collision with root package name */
    private Context f457d;

    /* renamed from: e reason: collision with root package name */
    private Activity f458e;

    /* renamed from: f reason: collision with root package name */
    private Dialog f459f;

    /* renamed from: g reason: collision with root package name */
    ActionBarOverlayLayout f460g;

    /* renamed from: h reason: collision with root package name */
    ActionBarContainer f461h;

    /* renamed from: i reason: collision with root package name */
    J f462i;

    /* renamed from: j reason: collision with root package name */
    ActionBarContextView f463j;

    /* renamed from: k reason: collision with root package name */
    View f464k;

    /* renamed from: l reason: collision with root package name */
    Y f465l;
    private ArrayList<Object> m = new ArrayList<>();
    private int n = -1;
    private boolean o;
    a p;
    b q;
    b.a.d.b.a r;
    private boolean s;
    private ArrayList<C0134a.b> t = new ArrayList<>();
    private boolean u;
    private int v = 0;
    boolean w = true;
    boolean x;
    boolean y;
    private boolean z;

    /* compiled from: WindowDecorActionBar */
    public class a extends b implements androidx.appcompat.view.menu.l.a {

        /* renamed from: c reason: collision with root package name */
        private final Context f466c;

        /* renamed from: d reason: collision with root package name */
        private final l f467d;

        /* renamed from: e reason: collision with root package name */
        private b.a.d.b.a f468e;

        /* renamed from: f reason: collision with root package name */
        private WeakReference<View> f469f;

        public a(Context context, b.a.d.b.a aVar) {
            this.f466c = context;
            this.f468e = aVar;
            l lVar = new l(context);
            lVar.c(1);
            this.f467d = lVar;
            this.f467d.a((androidx.appcompat.view.menu.l.a) this);
        }

        public void a() {
            N n = N.this;
            if (n.p == this) {
                if (!N.a(n.x, n.y, false)) {
                    N n2 = N.this;
                    n2.q = this;
                    n2.r = this.f468e;
                } else {
                    this.f468e.a(this);
                }
                this.f468e = null;
                N.this.h(false);
                N.this.f463j.a();
                N.this.f462i.l().sendAccessibilityEvent(32);
                N n3 = N.this;
                n3.f460g.setHideOnContentScrollEnabled(n3.D);
                N.this.p = null;
            }
        }

        public void b(CharSequence charSequence) {
            N.this.f463j.setTitle(charSequence);
        }

        public Menu c() {
            return this.f467d;
        }

        public MenuInflater d() {
            return new g(this.f466c);
        }

        public CharSequence e() {
            return N.this.f463j.getSubtitle();
        }

        public CharSequence g() {
            return N.this.f463j.getTitle();
        }

        public void i() {
            if (N.this.p == this) {
                this.f467d.s();
                try {
                    this.f468e.b(this, this.f467d);
                } finally {
                    this.f467d.r();
                }
            }
        }

        public boolean j() {
            return N.this.f463j.b();
        }

        public boolean k() {
            this.f467d.s();
            try {
                return this.f468e.a((b) this, (Menu) this.f467d);
            } finally {
                this.f467d.r();
            }
        }

        public void b(int i2) {
            b((CharSequence) N.this.f456c.getResources().getString(i2));
        }

        public View b() {
            WeakReference<View> weakReference = this.f469f;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
            return null;
        }

        public void a(View view) {
            N.this.f463j.setCustomView(view);
            this.f469f = new WeakReference<>(view);
        }

        public void a(CharSequence charSequence) {
            N.this.f463j.setSubtitle(charSequence);
        }

        public void a(int i2) {
            a((CharSequence) N.this.f456c.getResources().getString(i2));
        }

        public void a(boolean z) {
            super.a(z);
            N.this.f463j.setTitleOptional(z);
        }

        public boolean a(l lVar, MenuItem menuItem) {
            b.a.d.b.a aVar = this.f468e;
            if (aVar != null) {
                return aVar.a((b) this, menuItem);
            }
            return false;
        }

        public void a(l lVar) {
            if (this.f468e != null) {
                i();
                N.this.f463j.d();
            }
        }
    }

    public N(Activity activity, boolean z2) {
        this.f458e = activity;
        View decorView = activity.getWindow().getDecorView();
        b(decorView);
        if (!z2) {
            this.f464k = decorView.findViewById(16908290);
        }
    }

    private J a(View view) {
        if (view instanceof J) {
            return (J) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != null ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    static boolean a(boolean z2, boolean z3, boolean z4) {
        if (z4) {
            return true;
        }
        return !z2 && !z3;
    }

    private void b(View view) {
        this.f460g = (ActionBarOverlayLayout) view.findViewById(f.decor_content_parent);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f460g;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f462i = a(view.findViewById(f.action_bar));
        this.f463j = (ActionBarContextView) view.findViewById(f.action_context_bar);
        this.f461h = (ActionBarContainer) view.findViewById(f.action_bar_container);
        J j2 = this.f462i;
        if (j2 == null || this.f463j == null || this.f461h == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(N.class.getSimpleName());
            sb.append(" can only be used ");
            sb.append("with a compatible window decor layout");
            throw new IllegalStateException(sb.toString());
        }
        this.f456c = j2.a();
        boolean z2 = (this.f462i.m() & 4) != 0;
        if (z2) {
            this.o = true;
        }
        b.a.d.a a2 = b.a.d.a.a(this.f456c);
        l(a2.a() || z2);
        m(a2.f());
        TypedArray obtainStyledAttributes = this.f456c.obtainStyledAttributes(null, j.ActionBar, b.a.a.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(j.ActionBar_hideOnContentScroll, false)) {
            k(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(j.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            a((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private void m(boolean z2) {
        this.u = z2;
        if (!this.u) {
            this.f462i.a((Y) null);
            this.f461h.setTabContainer(this.f465l);
        } else {
            this.f461h.setTabContainer(null);
            this.f462i.a(this.f465l);
        }
        boolean z3 = true;
        boolean z4 = m() == 2;
        Y y2 = this.f465l;
        if (y2 != null) {
            if (z4) {
                y2.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f460g;
                if (actionBarOverlayLayout != null) {
                    B.H(actionBarOverlayLayout);
                }
            } else {
                y2.setVisibility(8);
            }
        }
        this.f462i.b(!this.u && z4);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.f460g;
        if (this.u || !z4) {
            z3 = false;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z3);
    }

    private void n() {
        if (this.z) {
            this.z = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f460g;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            n(false);
        }
    }

    private boolean o() {
        return B.C(this.f461h);
    }

    private void p() {
        if (!this.z) {
            this.z = true;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f460g;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(true);
            }
            n(false);
        }
    }

    public void b() {
    }

    public void c(CharSequence charSequence) {
        this.f462i.setWindowTitle(charSequence);
    }

    public void d(boolean z2) {
        a(z2 ? 4 : 0, 4);
    }

    public void e(boolean z2) {
        a(z2 ? 2 : 0, 2);
    }

    public void f(boolean z2) {
        a(z2 ? 8 : 0, 8);
    }

    public void g(boolean z2) {
        this.C = z2;
        if (!z2) {
            i iVar = this.B;
            if (iVar != null) {
                iVar.a();
            }
        }
    }

    public void h(boolean z2) {
        K k2;
        K k3;
        if (z2) {
            p();
        } else {
            n();
        }
        if (o()) {
            if (z2) {
                k2 = this.f462i.a(4, 100);
                k3 = this.f463j.a(0, 200);
            } else {
                k3 = this.f462i.a(0, 200);
                k2 = this.f463j.a(8, 100);
            }
            i iVar = new i();
            iVar.a(k2, k3);
            iVar.c();
        } else if (z2) {
            this.f462i.d(4);
            this.f463j.setVisibility(0);
        } else {
            this.f462i.d(0);
            this.f463j.setVisibility(8);
        }
    }

    public void i(boolean z2) {
        i iVar = this.B;
        if (iVar != null) {
            iVar.a();
        }
        if (this.v != 0 || (!this.C && !z2)) {
            this.E.b(null);
            return;
        }
        this.f461h.setAlpha(1.0f);
        this.f461h.setTransitioning(true);
        i iVar2 = new i();
        float f2 = (float) (-this.f461h.getHeight());
        if (z2) {
            int[] iArr = {0, 0};
            this.f461h.getLocationInWindow(iArr);
            f2 -= (float) iArr[1];
        }
        K a2 = B.a(this.f461h);
        a2.c(f2);
        a2.a(this.G);
        iVar2.a(a2);
        if (this.w) {
            View view = this.f464k;
            if (view != null) {
                K a3 = B.a(view);
                a3.c(f2);
                iVar2.a(a3);
            }
        }
        iVar2.a(f454a);
        iVar2.a(250);
        iVar2.a(this.E);
        this.B = iVar2;
        iVar2.c();
    }

    public void j(boolean z2) {
        i iVar = this.B;
        if (iVar != null) {
            iVar.a();
        }
        this.f461h.setVisibility(0);
        if (this.v != 0 || (!this.C && !z2)) {
            this.f461h.setAlpha(1.0f);
            this.f461h.setTranslationY(0.0f);
            if (this.w) {
                View view = this.f464k;
                if (view != null) {
                    view.setTranslationY(0.0f);
                }
            }
            this.F.b(null);
        } else {
            this.f461h.setTranslationY(0.0f);
            float f2 = (float) (-this.f461h.getHeight());
            if (z2) {
                int[] iArr = {0, 0};
                this.f461h.getLocationInWindow(iArr);
                f2 -= (float) iArr[1];
            }
            this.f461h.setTranslationY(f2);
            i iVar2 = new i();
            K a2 = B.a(this.f461h);
            a2.c(0.0f);
            a2.a(this.G);
            iVar2.a(a2);
            if (this.w) {
                View view2 = this.f464k;
                if (view2 != null) {
                    view2.setTranslationY(f2);
                    K a3 = B.a(this.f464k);
                    a3.c(0.0f);
                    iVar2.a(a3);
                }
            }
            iVar2.a(f455b);
            iVar2.a(250);
            iVar2.a(this.F);
            this.B = iVar2;
            iVar2.c();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f460g;
        if (actionBarOverlayLayout != null) {
            B.H(actionBarOverlayLayout);
        }
    }

    public void k(boolean z2) {
        if (!z2 || this.f460g.i()) {
            this.D = z2;
            this.f460g.setHideOnContentScrollEnabled(z2);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    /* access modifiers changed from: 0000 */
    public void l() {
        b.a.d.b.a aVar = this.r;
        if (aVar != null) {
            aVar.a(this.q);
            this.q = null;
            this.r = null;
        }
    }

    public void c() {
        if (!this.y) {
            this.y = true;
            n(true);
        }
    }

    public void d() {
        i iVar = this.B;
        if (iVar != null) {
            iVar.a();
            this.B = null;
        }
    }

    public boolean f() {
        J j2 = this.f462i;
        if (j2 == null || !j2.i()) {
            return false;
        }
        this.f462i.collapseActionView();
        return true;
    }

    public int g() {
        return this.f462i.m();
    }

    public void c(boolean z2) {
        if (!this.o) {
            d(z2);
        }
    }

    public void l(boolean z2) {
        this.f462i.a(z2);
    }

    private void n(boolean z2) {
        if (a(this.x, this.y, this.z)) {
            if (!this.A) {
                this.A = true;
                j(z2);
            }
        } else if (this.A) {
            this.A = false;
            i(z2);
        }
    }

    public void a(float f2) {
        B.b((View) this.f461h, f2);
    }

    public void a(Configuration configuration) {
        m(b.a.d.a.a(this.f456c).f());
    }

    public void a(int i2) {
        this.v = i2;
    }

    public void a(CharSequence charSequence) {
        this.f462i.a(charSequence);
    }

    public void a(int i2, int i3) {
        int m2 = this.f462i.m();
        if ((i3 & 4) != 0) {
            this.o = true;
        }
        this.f462i.a((i2 & i3) | ((~i3) & m2));
    }

    public b a(b.a.d.b.a aVar) {
        a aVar2 = this.p;
        if (aVar2 != null) {
            aVar2.a();
        }
        this.f460g.setHideOnContentScrollEnabled(false);
        this.f463j.c();
        a aVar3 = new a(this.f463j.getContext(), aVar);
        if (!aVar3.k()) {
            return null;
        }
        this.p = aVar3;
        aVar3.i();
        this.f463j.a(aVar3);
        h(true);
        this.f463j.sendAccessibilityEvent(32);
        return aVar3;
    }

    public Context h() {
        if (this.f457d == null) {
            TypedValue typedValue = new TypedValue();
            this.f456c.getTheme().resolveAttribute(b.a.a.actionBarWidgetTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                this.f457d = new ContextThemeWrapper(this.f456c, i2);
            } else {
                this.f457d = this.f456c;
            }
        }
        return this.f457d;
    }

    public int m() {
        return this.f462i.k();
    }

    public N(Dialog dialog) {
        this.f459f = dialog;
        b(dialog.getWindow().getDecorView());
    }

    public void b(boolean z2) {
        if (z2 != this.s) {
            this.s = z2;
            int size = this.t.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((C0134a.b) this.t.get(i2)).onMenuVisibilityChanged(z2);
            }
        }
    }

    public void a(boolean z2) {
        this.w = z2;
    }

    public void b(CharSequence charSequence) {
        this.f462i.setTitle(charSequence);
    }

    public void a() {
        if (this.y) {
            this.y = false;
            n(true);
        }
    }

    public void b(int i2) {
        this.f462i.c(i2);
    }

    public boolean a(int i2, KeyEvent keyEvent) {
        a aVar = this.p;
        if (aVar == null) {
            return false;
        }
        Menu c2 = aVar.c();
        if (c2 == null) {
            return false;
        }
        boolean z2 = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z2 = false;
        }
        c2.setQwertyMode(z2);
        return c2.performShortcut(i2, keyEvent, 0);
    }
}
