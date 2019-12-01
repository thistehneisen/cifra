package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window.Callback;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.v;
import androidx.appcompat.widget.Toolbar.b;
import b.a.a.a.a;
import b.a.e;
import b.a.f;
import b.a.h;
import b.a.j;
import b.g.i.B;
import b.g.i.K;
import b.g.i.L;

/* compiled from: ToolbarWidgetWrapper */
public class za implements J {

    /* renamed from: a reason: collision with root package name */
    Toolbar f1070a;

    /* renamed from: b reason: collision with root package name */
    private int f1071b;

    /* renamed from: c reason: collision with root package name */
    private View f1072c;

    /* renamed from: d reason: collision with root package name */
    private View f1073d;

    /* renamed from: e reason: collision with root package name */
    private Drawable f1074e;

    /* renamed from: f reason: collision with root package name */
    private Drawable f1075f;

    /* renamed from: g reason: collision with root package name */
    private Drawable f1076g;

    /* renamed from: h reason: collision with root package name */
    private boolean f1077h;

    /* renamed from: i reason: collision with root package name */
    CharSequence f1078i;

    /* renamed from: j reason: collision with root package name */
    private CharSequence f1079j;

    /* renamed from: k reason: collision with root package name */
    private CharSequence f1080k;

    /* renamed from: l reason: collision with root package name */
    Callback f1081l;
    boolean m;
    private C0165g n;
    private int o;
    private int p;
    private Drawable q;

    public za(Toolbar toolbar, boolean z) {
        this(toolbar, z, h.abc_action_bar_up_description, e.abc_ic_ab_back_material);
    }

    private void c(CharSequence charSequence) {
        this.f1078i = charSequence;
        if ((this.f1071b & 8) != 0) {
            this.f1070a.setTitle(charSequence);
        }
    }

    private int p() {
        if (this.f1070a.getNavigationIcon() == null) {
            return 11;
        }
        this.q = this.f1070a.getNavigationIcon();
        return 15;
    }

    private void q() {
        if ((this.f1071b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.f1080k)) {
            this.f1070a.setNavigationContentDescription(this.p);
        } else {
            this.f1070a.setNavigationContentDescription(this.f1080k);
        }
    }

    private void r() {
        if ((this.f1071b & 4) != 0) {
            Toolbar toolbar = this.f1070a;
            Drawable drawable = this.f1076g;
            if (drawable == null) {
                drawable = this.q;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.f1070a.setNavigationIcon((Drawable) null);
    }

    private void s() {
        Drawable drawable;
        int i2 = this.f1071b;
        if ((i2 & 2) == 0) {
            drawable = null;
        } else if ((i2 & 1) != 0) {
            drawable = this.f1075f;
            if (drawable == null) {
                drawable = this.f1074e;
            }
        } else {
            drawable = this.f1074e;
        }
        this.f1070a.setLogo(drawable);
    }

    public Context a() {
        return this.f1070a.getContext();
    }

    public void a(boolean z) {
    }

    public void b(int i2) {
        a(i2 != 0 ? a.b(a(), i2) : null);
    }

    public void collapseActionView() {
        this.f1070a.collapseActionView();
    }

    public boolean d() {
        return this.f1070a.canShowOverflowMenu();
    }

    public void e(int i2) {
        if (i2 != this.p) {
            this.p = i2;
            if (TextUtils.isEmpty(this.f1070a.getNavigationContentDescription())) {
                f(this.p);
            }
        }
    }

    public boolean f() {
        return this.f1070a.hideOverflowMenu();
    }

    public boolean g() {
        return this.f1070a.showOverflowMenu();
    }

    public CharSequence getTitle() {
        return this.f1070a.getTitle();
    }

    public void h() {
        this.f1070a.dismissPopupMenus();
    }

    public boolean i() {
        return this.f1070a.hasExpandedActionView();
    }

    public Menu j() {
        return this.f1070a.getMenu();
    }

    public int k() {
        return this.o;
    }

    public ViewGroup l() {
        return this.f1070a;
    }

    public int m() {
        return this.f1071b;
    }

    public void n() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void o() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void setIcon(int i2) {
        setIcon(i2 != 0 ? a.b(a(), i2) : null);
    }

    public void setTitle(CharSequence charSequence) {
        this.f1077h = true;
        c(charSequence);
    }

    public void setWindowCallback(Callback callback) {
        this.f1081l = callback;
    }

    public void setWindowTitle(CharSequence charSequence) {
        if (!this.f1077h) {
            c(charSequence);
        }
    }

    public za(Toolbar toolbar, boolean z, int i2, int i3) {
        this.o = 0;
        this.p = 0;
        this.f1070a = toolbar;
        this.f1078i = toolbar.getTitle();
        this.f1079j = toolbar.getSubtitle();
        this.f1077h = this.f1078i != null;
        this.f1076g = toolbar.getNavigationIcon();
        sa a2 = sa.a(toolbar.getContext(), null, j.ActionBar, b.a.a.actionBarStyle, 0);
        this.q = a2.b(j.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence e2 = a2.e(j.ActionBar_title);
            if (!TextUtils.isEmpty(e2)) {
                setTitle(e2);
            }
            CharSequence e3 = a2.e(j.ActionBar_subtitle);
            if (!TextUtils.isEmpty(e3)) {
                a(e3);
            }
            Drawable b2 = a2.b(j.ActionBar_logo);
            if (b2 != null) {
                a(b2);
            }
            Drawable b3 = a2.b(j.ActionBar_icon);
            if (b3 != null) {
                setIcon(b3);
            }
            if (this.f1076g == null) {
                Drawable drawable = this.q;
                if (drawable != null) {
                    b(drawable);
                }
            }
            a(a2.d(j.ActionBar_displayOptions, 0));
            int g2 = a2.g(j.ActionBar_customNavigationLayout, 0);
            if (g2 != 0) {
                a(LayoutInflater.from(this.f1070a.getContext()).inflate(g2, this.f1070a, false));
                a(this.f1071b | 16);
            }
            int f2 = a2.f(j.ActionBar_height, 0);
            if (f2 > 0) {
                LayoutParams layoutParams = this.f1070a.getLayoutParams();
                layoutParams.height = f2;
                this.f1070a.setLayoutParams(layoutParams);
            }
            int b4 = a2.b(j.ActionBar_contentInsetStart, -1);
            int b5 = a2.b(j.ActionBar_contentInsetEnd, -1);
            if (b4 >= 0 || b5 >= 0) {
                this.f1070a.setContentInsetsRelative(Math.max(b4, 0), Math.max(b5, 0));
            }
            int g3 = a2.g(j.ActionBar_titleTextStyle, 0);
            if (g3 != 0) {
                Toolbar toolbar2 = this.f1070a;
                toolbar2.setTitleTextAppearance(toolbar2.getContext(), g3);
            }
            int g4 = a2.g(j.ActionBar_subtitleTextStyle, 0);
            if (g4 != 0) {
                Toolbar toolbar3 = this.f1070a;
                toolbar3.setSubtitleTextAppearance(toolbar3.getContext(), g4);
            }
            int g5 = a2.g(j.ActionBar_popupTheme, 0);
            if (g5 != 0) {
                this.f1070a.setPopupTheme(g5);
            }
        } else {
            this.f1071b = p();
        }
        a2.a();
        e(i2);
        this.f1080k = this.f1070a.getNavigationContentDescription();
        this.f1070a.setNavigationOnClickListener(new xa(this));
    }

    public void a(CharSequence charSequence) {
        this.f1079j = charSequence;
        if ((this.f1071b & 8) != 0) {
            this.f1070a.setSubtitle(charSequence);
        }
    }

    public boolean b() {
        return this.f1070a.isOverflowMenuShowing();
    }

    public void d(int i2) {
        this.f1070a.setVisibility(i2);
    }

    public void f(int i2) {
        b((CharSequence) i2 == 0 ? null : a().getString(i2));
    }

    public void setIcon(Drawable drawable) {
        this.f1074e = drawable;
        s();
    }

    public void b(boolean z) {
        this.f1070a.setCollapsible(z);
    }

    public void b(Drawable drawable) {
        this.f1076g = drawable;
        r();
    }

    public void c() {
        this.m = true;
    }

    public void a(Drawable drawable) {
        this.f1075f = drawable;
        s();
    }

    public void c(int i2) {
        b(i2 != 0 ? a.b(a(), i2) : null);
    }

    public boolean e() {
        return this.f1070a.isOverflowMenuShowPending();
    }

    public void b(CharSequence charSequence) {
        this.f1080k = charSequence;
        q();
    }

    public void a(Menu menu, v.a aVar) {
        if (this.n == null) {
            this.n = new C0165g(this.f1070a.getContext());
            this.n.a(f.action_menu_presenter);
        }
        this.n.a(aVar);
        this.f1070a.setMenu((l) menu, this.n);
    }

    public void a(int i2) {
        int i3 = this.f1071b ^ i2;
        this.f1071b = i2;
        if (i3 != 0) {
            if ((i3 & 4) != 0) {
                if ((i2 & 4) != 0) {
                    q();
                }
                r();
            }
            if ((i3 & 3) != 0) {
                s();
            }
            if ((i3 & 8) != 0) {
                if ((i2 & 8) != 0) {
                    this.f1070a.setTitle(this.f1078i);
                    this.f1070a.setSubtitle(this.f1079j);
                } else {
                    this.f1070a.setTitle((CharSequence) null);
                    this.f1070a.setSubtitle((CharSequence) null);
                }
            }
            if ((i3 & 16) != 0) {
                View view = this.f1073d;
                if (view == null) {
                    return;
                }
                if ((i2 & 16) != 0) {
                    this.f1070a.addView(view);
                } else {
                    this.f1070a.removeView(view);
                }
            }
        }
    }

    public void a(Y y) {
        View view = this.f1072c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f1070a;
            if (parent == toolbar) {
                toolbar.removeView(this.f1072c);
            }
        }
        this.f1072c = y;
        if (y != null && this.o == 2) {
            this.f1070a.addView(this.f1072c, 0);
            b bVar = (b) this.f1072c.getLayoutParams();
            bVar.width = -2;
            bVar.height = -2;
            bVar.f471a = 8388691;
            y.setAllowCollapse(true);
        }
    }

    public void a(View view) {
        View view2 = this.f1073d;
        if (!(view2 == null || (this.f1071b & 16) == 0)) {
            this.f1070a.removeView(view2);
        }
        this.f1073d = view;
        if (view != null && (this.f1071b & 16) != 0) {
            this.f1070a.addView(this.f1073d);
        }
    }

    public K a(int i2, long j2) {
        K a2 = B.a(this.f1070a);
        a2.a(i2 == 0 ? 1.0f : 0.0f);
        a2.a(j2);
        a2.a((L) new ya(this, i2));
        return a2;
    }

    public void a(v.a aVar, l.a aVar2) {
        this.f1070a.setMenuCallbacks(aVar, aVar2);
    }
}
