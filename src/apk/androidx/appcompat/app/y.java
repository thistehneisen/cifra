package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.v;
import androidx.appcompat.view.menu.w;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.C0175o;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Fa;
import androidx.appcompat.widget.Ga;
import androidx.appcompat.widget.I;
import androidx.appcompat.widget.M;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.sa;
import b.a.d.j;
import b.a.i;
import b.g.i.B;
import b.g.i.C0244e;
import b.g.i.C0245f;
import b.g.i.K;
import b.g.i.L;
import b.g.i.r;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: AppCompatDelegateImpl */
class y extends p implements androidx.appcompat.view.menu.l.a, Factory2 {

    /* renamed from: b reason: collision with root package name */
    private static final boolean f507b = (VERSION.SDK_INT < 21);

    /* renamed from: c reason: collision with root package name */
    private static final int[] f508c = {16842836};

    /* renamed from: d reason: collision with root package name */
    private static boolean f509d = true;
    private boolean A;
    boolean B;
    boolean C;
    boolean D;
    boolean E;
    boolean F;
    private boolean G;
    private g[] H;
    private g I;
    private boolean J;
    boolean K;
    private int L = -100;
    private boolean M;
    private e N;
    boolean O;
    int P;
    private final Runnable Q = new r(this);
    private boolean R;
    private Rect S;
    private Rect T;
    private AppCompatViewInflater U;

    /* renamed from: e reason: collision with root package name */
    final Context f510e;

    /* renamed from: f reason: collision with root package name */
    final Window f511f;

    /* renamed from: g reason: collision with root package name */
    final Callback f512g;

    /* renamed from: h reason: collision with root package name */
    final Callback f513h;

    /* renamed from: i reason: collision with root package name */
    final o f514i;

    /* renamed from: j reason: collision with root package name */
    C0134a f515j;

    /* renamed from: k reason: collision with root package name */
    MenuInflater f516k;

    /* renamed from: l reason: collision with root package name */
    private CharSequence f517l;
    private I m;
    private b n;
    private h o;
    b.a.d.b p;
    ActionBarContextView q;
    PopupWindow r;
    Runnable s;
    K t = null;
    private boolean u = true;
    private boolean v;
    private ViewGroup w;
    private TextView x;
    private View y;
    private boolean z;

    /* compiled from: AppCompatDelegateImpl */
    private class a implements C0135b {
        a() {
        }
    }

    /* compiled from: AppCompatDelegateImpl */
    private final class b implements androidx.appcompat.view.menu.v.a {
        b() {
        }

        public boolean a(l lVar) {
            Callback p = y.this.p();
            if (p != null) {
                p.onMenuOpened(108, lVar);
            }
            return true;
        }

        public void a(l lVar, boolean z) {
            y.this.b(lVar);
        }
    }

    /* compiled from: AppCompatDelegateImpl */
    class c implements b.a.d.b.a {

        /* renamed from: a reason: collision with root package name */
        private b.a.d.b.a f520a;

        public c(b.a.d.b.a aVar) {
            this.f520a = aVar;
        }

        public boolean a(b.a.d.b bVar, Menu menu) {
            return this.f520a.a(bVar, menu);
        }

        public boolean b(b.a.d.b bVar, Menu menu) {
            return this.f520a.b(bVar, menu);
        }

        public boolean a(b.a.d.b bVar, MenuItem menuItem) {
            return this.f520a.a(bVar, menuItem);
        }

        public void a(b.a.d.b bVar) {
            this.f520a.a(bVar);
            y yVar = y.this;
            if (yVar.r != null) {
                yVar.f511f.getDecorView().removeCallbacks(y.this.s);
            }
            y yVar2 = y.this;
            if (yVar2.q != null) {
                yVar2.m();
                y yVar3 = y.this;
                K a2 = B.a(yVar3.q);
                a2.a(0.0f);
                yVar3.t = a2;
                y.this.t.a((L) new z(this));
            }
            y yVar4 = y.this;
            o oVar = yVar4.f514i;
            if (oVar != null) {
                oVar.onSupportActionModeFinished(yVar4.p);
            }
            y.this.p = null;
        }
    }

    /* compiled from: AppCompatDelegateImpl */
    class d extends j {
        d(Callback callback) {
            super(callback);
        }

        /* access modifiers changed from: 0000 */
        public final ActionMode a(ActionMode.Callback callback) {
            b.a.d.f.a aVar = new b.a.d.f.a(y.this.f510e, callback);
            b.a.d.b a2 = y.this.a((b.a.d.b.a) aVar);
            if (a2 != null) {
                return aVar.b(a2);
            }
            return null;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return y.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || y.this.b(keyEvent.getKeyCode(), keyEvent);
        }

        public void onContentChanged() {
        }

        public boolean onCreatePanelMenu(int i2, Menu menu) {
            if (i2 != 0 || (menu instanceof l)) {
                return super.onCreatePanelMenu(i2, menu);
            }
            return false;
        }

        public boolean onMenuOpened(int i2, Menu menu) {
            super.onMenuOpened(i2, menu);
            y.this.g(i2);
            return true;
        }

        public void onPanelClosed(int i2, Menu menu) {
            super.onPanelClosed(i2, menu);
            y.this.h(i2);
        }

        public boolean onPreparePanel(int i2, View view, Menu menu) {
            l lVar = menu instanceof l ? (l) menu : null;
            if (i2 == 0 && lVar == null) {
                return false;
            }
            if (lVar != null) {
                lVar.c(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i2, view, menu);
            if (lVar != null) {
                lVar.c(false);
            }
            return onPreparePanel;
        }

        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i2) {
            g a2 = y.this.a(0, true);
            if (a2 != null) {
                l lVar = a2.f538j;
                if (lVar != null) {
                    super.onProvideKeyboardShortcuts(list, lVar, i2);
                    return;
                }
            }
            super.onProvideKeyboardShortcuts(list, menu, i2);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (VERSION.SDK_INT >= 23) {
                return null;
            }
            if (y.this.q()) {
                return a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
            if (!y.this.q() || i2 != 0) {
                return super.onWindowStartingActionMode(callback, i2);
            }
            return a(callback);
        }
    }

    /* compiled from: AppCompatDelegateImpl */
    final class e {

        /* renamed from: a reason: collision with root package name */
        private J f523a;

        /* renamed from: b reason: collision with root package name */
        private boolean f524b;

        /* renamed from: c reason: collision with root package name */
        private BroadcastReceiver f525c;

        /* renamed from: d reason: collision with root package name */
        private IntentFilter f526d;

        e(J j2) {
            this.f523a = j2;
            this.f524b = j2.a();
        }

        /* access modifiers changed from: 0000 */
        public void a() {
            BroadcastReceiver broadcastReceiver = this.f525c;
            if (broadcastReceiver != null) {
                y.this.f510e.unregisterReceiver(broadcastReceiver);
                this.f525c = null;
            }
        }

        /* access modifiers changed from: 0000 */
        public void b() {
            boolean a2 = this.f523a.a();
            if (a2 != this.f524b) {
                this.f524b = a2;
                y.this.a();
            }
        }

        /* access modifiers changed from: 0000 */
        public int c() {
            this.f524b = this.f523a.a();
            return this.f524b ? 2 : 1;
        }

        /* access modifiers changed from: 0000 */
        public void d() {
            a();
            if (this.f525c == null) {
                this.f525c = new A(this);
            }
            if (this.f526d == null) {
                this.f526d = new IntentFilter();
                this.f526d.addAction("android.intent.action.TIME_SET");
                this.f526d.addAction("android.intent.action.TIMEZONE_CHANGED");
                this.f526d.addAction("android.intent.action.TIME_TICK");
            }
            y.this.f510e.registerReceiver(this.f525c, this.f526d);
        }
    }

    /* compiled from: AppCompatDelegateImpl */
    private class f extends ContentFrameLayout {
        public f(Context context) {
            super(context);
        }

        private boolean a(int i2, int i3) {
            return i2 < -5 || i3 < -5 || i2 > getWidth() + 5 || i3 > getHeight() + 5;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return y.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            y.this.d(0);
            return true;
        }

        public void setBackgroundResource(int i2) {
            setBackgroundDrawable(b.a.a.a.a.b(getContext(), i2));
        }
    }

    /* compiled from: AppCompatDelegateImpl */
    protected static final class g {

        /* renamed from: a reason: collision with root package name */
        int f529a;

        /* renamed from: b reason: collision with root package name */
        int f530b;

        /* renamed from: c reason: collision with root package name */
        int f531c;

        /* renamed from: d reason: collision with root package name */
        int f532d;

        /* renamed from: e reason: collision with root package name */
        int f533e;

        /* renamed from: f reason: collision with root package name */
        int f534f;

        /* renamed from: g reason: collision with root package name */
        ViewGroup f535g;

        /* renamed from: h reason: collision with root package name */
        View f536h;

        /* renamed from: i reason: collision with root package name */
        View f537i;

        /* renamed from: j reason: collision with root package name */
        l f538j;

        /* renamed from: k reason: collision with root package name */
        androidx.appcompat.view.menu.j f539k;

        /* renamed from: l reason: collision with root package name */
        Context f540l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;
        boolean q = false;
        boolean r;
        Bundle s;

        g(int i2) {
            this.f529a = i2;
        }

        public boolean a() {
            boolean z = false;
            if (this.f536h == null) {
                return false;
            }
            if (this.f537i != null) {
                return true;
            }
            if (this.f539k.b().getCount() > 0) {
                z = true;
            }
            return z;
        }

        /* access modifiers changed from: 0000 */
        public void a(Context context) {
            TypedValue typedValue = new TypedValue();
            Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(b.a.a.actionBarPopupTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                newTheme.applyStyle(i2, true);
            }
            newTheme.resolveAttribute(b.a.a.panelMenuListTheme, typedValue, true);
            int i3 = typedValue.resourceId;
            if (i3 != 0) {
                newTheme.applyStyle(i3, true);
            } else {
                newTheme.applyStyle(i.Theme_AppCompat_CompactMenu, true);
            }
            b.a.d.d dVar = new b.a.d.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.f540l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(b.a.j.AppCompatTheme);
            this.f530b = obtainStyledAttributes.getResourceId(b.a.j.AppCompatTheme_panelBackground, 0);
            this.f534f = obtainStyledAttributes.getResourceId(b.a.j.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: 0000 */
        public void a(l lVar) {
            l lVar2 = this.f538j;
            if (lVar != lVar2) {
                if (lVar2 != null) {
                    lVar2.b((v) this.f539k);
                }
                this.f538j = lVar;
                if (lVar != null) {
                    androidx.appcompat.view.menu.j jVar = this.f539k;
                    if (jVar != null) {
                        lVar.a((v) jVar);
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public w a(androidx.appcompat.view.menu.v.a aVar) {
            if (this.f538j == null) {
                return null;
            }
            if (this.f539k == null) {
                this.f539k = new androidx.appcompat.view.menu.j(this.f540l, b.a.g.abc_list_menu_item_layout);
                this.f539k.a(aVar);
                this.f538j.a((v) this.f539k);
            }
            return this.f539k.a(this.f535g);
        }
    }

    /* compiled from: AppCompatDelegateImpl */
    private final class h implements androidx.appcompat.view.menu.v.a {
        h() {
        }

        public void a(l lVar, boolean z) {
            l m = lVar.m();
            boolean z2 = m != lVar;
            y yVar = y.this;
            if (z2) {
                lVar = m;
            }
            g a2 = yVar.a((Menu) lVar);
            if (a2 == null) {
                return;
            }
            if (z2) {
                y.this.a(a2.f529a, a2, m);
                y.this.a(a2, true);
                return;
            }
            y.this.a(a2, z);
        }

        public boolean a(l lVar) {
            if (lVar == null) {
                y yVar = y.this;
                if (yVar.B) {
                    Callback p = yVar.p();
                    if (p != null && !y.this.K) {
                        p.onMenuOpened(108, lVar);
                    }
                }
            }
            return true;
        }
    }

    static {
        if (f507b && !f509d) {
            Thread.setDefaultUncaughtExceptionHandler(new q(Thread.getDefaultUncaughtExceptionHandler()));
        }
    }

    y(Context context, Window window, o oVar) {
        this.f510e = context;
        this.f511f = window;
        this.f514i = oVar;
        this.f512g = this.f511f.getCallback();
        Callback callback = this.f512g;
        if (!(callback instanceof d)) {
            this.f513h = new d(callback);
            this.f511f.setCallback(this.f513h);
            sa a2 = sa.a(context, (AttributeSet) null, f508c);
            Drawable c2 = a2.c(0);
            if (c2 != null) {
                this.f511f.setBackgroundDrawable(c2);
            }
            a2.a();
            return;
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    private boolean A() {
        boolean z2 = false;
        if (this.M) {
            Context context = this.f510e;
            if (context instanceof Activity) {
                try {
                    if ((context.getPackageManager().getActivityInfo(new ComponentName(this.f510e, this.f510e.getClass()), 0).configChanges & 512) == 0) {
                        z2 = true;
                    }
                    return z2;
                } catch (NameNotFoundException e2) {
                    Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e2);
                    return true;
                }
            }
        }
        return false;
    }

    private void B() {
        if (this.v) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private void u() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.w.findViewById(16908290);
        View decorView = this.f511f.getDecorView();
        contentFrameLayout.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f510e.obtainStyledAttributes(b.a.j.AppCompatTheme);
        obtainStyledAttributes.getValue(b.a.j.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(b.a.j.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(b.a.j.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(b.a.j.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(b.a.j.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(b.a.j.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(b.a.j.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(b.a.j.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(b.a.j.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(b.a.j.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private ViewGroup v() {
        ViewGroup viewGroup;
        Context context;
        TypedArray obtainStyledAttributes = this.f510e.obtainStyledAttributes(b.a.j.AppCompatTheme);
        if (obtainStyledAttributes.hasValue(b.a.j.AppCompatTheme_windowActionBar)) {
            if (obtainStyledAttributes.getBoolean(b.a.j.AppCompatTheme_windowNoTitle, false)) {
                b(1);
            } else if (obtainStyledAttributes.getBoolean(b.a.j.AppCompatTheme_windowActionBar, false)) {
                b(108);
            }
            if (obtainStyledAttributes.getBoolean(b.a.j.AppCompatTheme_windowActionBarOverlay, false)) {
                b(109);
            }
            if (obtainStyledAttributes.getBoolean(b.a.j.AppCompatTheme_windowActionModeOverlay, false)) {
                b(10);
            }
            this.E = obtainStyledAttributes.getBoolean(b.a.j.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            this.f511f.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.f510e);
            if (this.F) {
                if (this.D) {
                    viewGroup = (ViewGroup) from.inflate(b.a.g.abc_screen_simple_overlay_action_mode, null);
                } else {
                    viewGroup = (ViewGroup) from.inflate(b.a.g.abc_screen_simple, null);
                }
                if (VERSION.SDK_INT >= 21) {
                    B.a((View) viewGroup, (r) new s(this));
                } else {
                    ((M) viewGroup).setOnFitSystemWindowsListener(new t(this));
                }
            } else if (this.E) {
                viewGroup = (ViewGroup) from.inflate(b.a.g.abc_dialog_title_material, null);
                this.C = false;
                this.B = false;
            } else if (this.B) {
                TypedValue typedValue = new TypedValue();
                this.f510e.getTheme().resolveAttribute(b.a.a.actionBarTheme, typedValue, true);
                int i2 = typedValue.resourceId;
                if (i2 != 0) {
                    context = new b.a.d.d(this.f510e, i2);
                } else {
                    context = this.f510e;
                }
                viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(b.a.g.abc_screen_toolbar, null);
                this.m = (I) viewGroup.findViewById(b.a.f.decor_content_parent);
                this.m.setWindowCallback(p());
                if (this.C) {
                    this.m.a(109);
                }
                if (this.z) {
                    this.m.a(2);
                }
                if (this.A) {
                    this.m.a(5);
                }
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                if (this.m == null) {
                    this.x = (TextView) viewGroup.findViewById(b.a.f.title);
                }
                Ga.b(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(b.a.f.action_bar_activity_content);
                ViewGroup viewGroup2 = (ViewGroup) this.f511f.findViewById(16908290);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground(null);
                    }
                }
                this.f511f.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new u(this));
                return viewGroup;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("AppCompat does not support the current theme features: { windowActionBar: ");
            sb.append(this.B);
            sb.append(", windowActionBarOverlay: ");
            sb.append(this.C);
            sb.append(", android:windowIsFloating: ");
            sb.append(this.E);
            sb.append(", windowActionModeOverlay: ");
            sb.append(this.D);
            sb.append(", windowNoTitle: ");
            sb.append(this.F);
            sb.append(" }");
            throw new IllegalArgumentException(sb.toString());
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    private void w() {
        if (this.N == null) {
            this.N = new e(J.a(this.f510e));
        }
    }

    private void x() {
        if (!this.v) {
            this.w = v();
            CharSequence o2 = o();
            if (!TextUtils.isEmpty(o2)) {
                I i2 = this.m;
                if (i2 != null) {
                    i2.setWindowTitle(o2);
                } else if (s() != null) {
                    s().c(o2);
                } else {
                    TextView textView = this.x;
                    if (textView != null) {
                        textView.setText(o2);
                    }
                }
            }
            u();
            a(this.w);
            this.v = true;
            g a2 = a(0, false);
            if (this.K) {
                return;
            }
            if (a2 == null || a2.f538j == null) {
                j(108);
            }
        }
    }

    private int y() {
        int i2 = this.L;
        return i2 != -100 ? i2 : p.b();
    }

    private void z() {
        x();
        if (this.B && this.f515j == null) {
            Callback callback = this.f512g;
            if (callback instanceof Activity) {
                this.f515j = new N((Activity) callback, this.C);
            } else if (callback instanceof Dialog) {
                this.f515j = new N((Dialog) callback);
            }
            C0134a aVar = this.f515j;
            if (aVar != null) {
                aVar.c(this.R);
            }
        }
    }

    public void a(Bundle bundle) {
        Callback callback = this.f512g;
        if (callback instanceof Activity) {
            String str = null;
            try {
                str = androidx.core.app.h.b((Activity) callback);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                C0134a s2 = s();
                if (s2 == null) {
                    this.R = true;
                } else {
                    s2.c(true);
                }
            }
        }
        if (bundle != null && this.L == -100) {
            this.L = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(ViewGroup viewGroup) {
    }

    public void b(Bundle bundle) {
        x();
    }

    public void c(int i2) {
        x();
        ViewGroup viewGroup = (ViewGroup) this.w.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f510e).inflate(i2, viewGroup);
        this.f512g.onContentChanged();
    }

    public MenuInflater d() {
        if (this.f516k == null) {
            z();
            C0134a aVar = this.f515j;
            this.f516k = new b.a.d.g(aVar != null ? aVar.h() : this.f510e);
        }
        return this.f516k;
    }

    public C0134a e() {
        z();
        return this.f515j;
    }

    public void f() {
        LayoutInflater from = LayoutInflater.from(this.f510e);
        if (from.getFactory() == null) {
            C0245f.a(from, this);
        } else if (!(from.getFactory2() instanceof y)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    /* access modifiers changed from: 0000 */
    public void g(int i2) {
        if (i2 == 108) {
            C0134a e2 = e();
            if (e2 != null) {
                e2.b(true);
            }
        }
    }

    public void h() {
        if (this.O) {
            this.f511f.getDecorView().removeCallbacks(this.Q);
        }
        this.K = true;
        C0134a aVar = this.f515j;
        if (aVar != null) {
            aVar.j();
        }
        e eVar = this.N;
        if (eVar != null) {
            eVar.a();
        }
    }

    public void i() {
        C0134a e2 = e();
        if (e2 != null) {
            e2.g(true);
        }
    }

    public void j() {
        a();
    }

    public void k() {
        C0134a e2 = e();
        if (e2 != null) {
            e2.g(false);
        }
        e eVar = this.N;
        if (eVar != null) {
            eVar.a();
        }
    }

    /* access modifiers changed from: 0000 */
    public void l() {
        I i2 = this.m;
        if (i2 != null) {
            i2.h();
        }
        if (this.r != null) {
            this.f511f.getDecorView().removeCallbacks(this.s);
            if (this.r.isShowing()) {
                try {
                    this.r.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.r = null;
        }
        m();
        g a2 = a(0, false);
        if (a2 != null) {
            l lVar = a2.f538j;
            if (lVar != null) {
                lVar.close();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void m() {
        K k2 = this.t;
        if (k2 != null) {
            k2.a();
        }
    }

    /* access modifiers changed from: 0000 */
    public final Context n() {
        C0134a e2 = e();
        Context h2 = e2 != null ? e2.h() : null;
        return h2 == null ? this.f510e : h2;
    }

    /* access modifiers changed from: 0000 */
    public final CharSequence o() {
        Callback callback = this.f512g;
        if (callback instanceof Activity) {
            return ((Activity) callback).getTitle();
        }
        return this.f517l;
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return a(view, str, context, attributeSet);
    }

    /* access modifiers changed from: 0000 */
    public final Callback p() {
        return this.f511f.getCallback();
    }

    public boolean q() {
        return this.u;
    }

    /* access modifiers changed from: 0000 */
    public boolean r() {
        b.a.d.b bVar = this.p;
        if (bVar != null) {
            bVar.a();
            return true;
        }
        C0134a e2 = e();
        if (e2 == null || !e2.f()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    public final C0134a s() {
        return this.f515j;
    }

    /* access modifiers changed from: 0000 */
    public final boolean t() {
        if (this.v) {
            ViewGroup viewGroup = this.w;
            if (viewGroup != null && B.C(viewGroup)) {
                return true;
            }
        }
        return false;
    }

    private void j(int i2) {
        this.P = (1 << i2) | this.P;
        if (!this.O) {
            B.a(this.f511f.getDecorView(), this.Q);
            this.O = true;
        }
    }

    public void b(View view, LayoutParams layoutParams) {
        x();
        ViewGroup viewGroup = (ViewGroup) this.w.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f512g.onContentChanged();
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x006c  */
    private boolean e(int i2, KeyEvent keyEvent) {
        boolean z2;
        boolean z3;
        if (this.p != null) {
            return false;
        }
        g a2 = a(i2, true);
        if (i2 == 0) {
            I i3 = this.m;
            if (i3 != null && i3.d() && !ViewConfiguration.get(this.f510e).hasPermanentMenuKey()) {
                if (!this.m.b()) {
                    if (!this.K && b(a2, keyEvent)) {
                        z2 = this.m.g();
                    }
                    z2 = false;
                } else {
                    z2 = this.m.f();
                }
                if (z2) {
                    AudioManager audioManager = (AudioManager) this.f510e.getSystemService("audio");
                    if (audioManager != null) {
                        audioManager.playSoundEffect(0);
                    } else {
                        Log.w("AppCompatDelegate", "Couldn't get audio manager");
                    }
                }
                return z2;
            }
        }
        if (a2.o || a2.n) {
            z2 = a2.o;
            a(a2, true);
            if (z2) {
            }
            return z2;
        }
        if (a2.m) {
            if (a2.r) {
                a2.m = false;
                z3 = b(a2, keyEvent);
            } else {
                z3 = true;
            }
            if (z3) {
                a(a2, keyEvent);
                z2 = true;
                if (z2) {
                }
                return z2;
            }
        }
        z2 = false;
        if (z2) {
        }
        return z2;
    }

    public void g() {
        C0134a e2 = e();
        if (e2 == null || !e2.i()) {
            j(0);
        }
    }

    /* access modifiers changed from: 0000 */
    public int i(int i2) {
        boolean z2;
        boolean z3;
        boolean z4;
        ActionBarContextView actionBarContextView = this.q;
        int i3 = 0;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof MarginLayoutParams)) {
            z2 = false;
        } else {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.q.getLayoutParams();
            z2 = true;
            if (this.q.isShown()) {
                if (this.S == null) {
                    this.S = new Rect();
                    this.T = new Rect();
                }
                Rect rect = this.S;
                Rect rect2 = this.T;
                rect.set(0, i2, 0, 0);
                Ga.a(this.w, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i2 : 0)) {
                    marginLayoutParams.topMargin = i2;
                    View view = this.y;
                    if (view == null) {
                        this.y = new View(this.f510e);
                        this.y.setBackgroundColor(this.f510e.getResources().getColor(b.a.c.abc_input_method_navigation_guard));
                        this.w.addView(this.y, -1, new LayoutParams(-1, i2));
                    } else {
                        LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams.height != i2) {
                            layoutParams.height = i2;
                            this.y.setLayoutParams(layoutParams);
                        }
                    }
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (this.y == null) {
                    z2 = false;
                }
                if (!this.D && z2) {
                    i2 = 0;
                }
            } else {
                if (marginLayoutParams.topMargin != 0) {
                    marginLayoutParams.topMargin = 0;
                    z4 = true;
                } else {
                    z4 = false;
                }
                z2 = false;
            }
            if (z3) {
                this.q.setLayoutParams(marginLayoutParams);
            }
        }
        View view2 = this.y;
        if (view2 != null) {
            if (!z2) {
                i3 = 8;
            }
            view2.setVisibility(i3);
        }
        return i2;
    }

    private int k(int i2) {
        String str = "AppCompatDelegate";
        if (i2 == 8) {
            Log.i(str, "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i2 == 9) {
            Log.i(str, "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i2 = 109;
        }
        return i2;
    }

    public void c(Bundle bundle) {
        int i2 = this.L;
        if (i2 != -100) {
            bundle.putInt("appcompat:local_night_mode", i2);
        }
    }

    /* access modifiers changed from: 0000 */
    public void d(int i2) {
        a(a(i2, true), true);
    }

    /* access modifiers changed from: 0000 */
    public int f(int i2) {
        if (i2 == -100) {
            return -1;
        }
        if (i2 != 0) {
            return i2;
        }
        if (VERSION.SDK_INT >= 23 && ((UiModeManager) this.f510e.getSystemService(UiModeManager.class)).getNightMode() == 0) {
            return -1;
        }
        w();
        return this.N.c();
    }

    private boolean d(int i2, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            g a2 = a(i2, true);
            if (!a2.o) {
                return b(a2, keyEvent);
            }
        }
        return false;
    }

    public boolean b(int i2) {
        int k2 = k(i2);
        if (this.F && k2 == 108) {
            return false;
        }
        if (this.B && k2 == 1) {
            this.B = false;
        }
        if (k2 == 1) {
            B();
            this.F = true;
            return true;
        } else if (k2 == 2) {
            B();
            this.z = true;
            return true;
        } else if (k2 == 5) {
            B();
            this.A = true;
            return true;
        } else if (k2 == 10) {
            B();
            this.D = true;
            return true;
        } else if (k2 == 108) {
            B();
            this.B = true;
            return true;
        } else if (k2 != 109) {
            return this.f511f.requestFeature(k2);
        } else {
            B();
            this.C = true;
            return true;
        }
    }

    public void a(Toolbar toolbar) {
        if (this.f512g instanceof Activity) {
            C0134a e2 = e();
            if (!(e2 instanceof N)) {
                this.f516k = null;
                if (e2 != null) {
                    e2.j();
                }
                if (toolbar != null) {
                    H h2 = new H(toolbar, ((Activity) this.f512g).getTitle(), this.f513h);
                    this.f515j = h2;
                    this.f511f.setCallback(h2.l());
                } else {
                    this.f515j = null;
                    this.f511f.setCallback(this.f513h);
                }
                g();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean c(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            boolean z2 = this.J;
            this.J = false;
            g a2 = a(0, false);
            if (a2 != null && a2.o) {
                if (!z2) {
                    a(a2, true);
                }
                return true;
            } else if (r()) {
                return true;
            }
        } else if (i2 == 82) {
            e(0, keyEvent);
            return true;
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public void h(int i2) {
        if (i2 == 108) {
            C0134a e2 = e();
            if (e2 != null) {
                e2.b(false);
            }
        } else if (i2 == 0) {
            g a2 = a(i2, true);
            if (a2.o) {
                a(a2, false);
            }
        }
    }

    private boolean l(int i2) {
        Resources resources = this.f510e.getResources();
        Configuration configuration = resources.getConfiguration();
        int i3 = configuration.uiMode & 48;
        int i4 = i2 == 2 ? 32 : 16;
        if (i3 == i4) {
            return false;
        }
        if (A()) {
            ((Activity) this.f510e).recreate();
        } else {
            Configuration configuration2 = new Configuration(configuration);
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            configuration2.uiMode = i4 | (configuration2.uiMode & -49);
            resources.updateConfiguration(configuration2, displayMetrics);
            if (VERSION.SDK_INT < 26) {
                E.a(resources);
            }
        }
        return true;
    }

    private boolean c(g gVar) {
        Context context = this.f510e;
        int i2 = gVar.f529a;
        if ((i2 == 0 || i2 == 108) && this.m != null) {
            TypedValue typedValue = new TypedValue();
            Theme theme = context.getTheme();
            theme.resolveAttribute(b.a.a.actionBarTheme, typedValue, true);
            Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(b.a.a.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(b.a.a.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                b.a.d.d dVar = new b.a.d.d(context, 0);
                dVar.getTheme().setTo(theme2);
                context = dVar;
            }
        }
        l lVar = new l(context);
        lVar.a((androidx.appcompat.view.menu.l.a) this);
        gVar.a(lVar);
        return true;
    }

    public <T extends View> T a(int i2) {
        x();
        return this.f511f.findViewById(i2);
    }

    public void a(Configuration configuration) {
        if (this.B && this.v) {
            C0134a e2 = e();
            if (e2 != null) {
                e2.a(configuration);
            }
        }
        C0175o.a().a(this.f510e);
        a();
    }

    /* access modifiers changed from: 0000 */
    public void e(int i2) {
        g a2 = a(i2, true);
        if (a2.f538j != null) {
            Bundle bundle = new Bundle();
            a2.f538j.b(bundle);
            if (bundle.size() > 0) {
                a2.s = bundle;
            }
            a2.f538j.s();
            a2.f538j.clear();
        }
        a2.r = true;
        a2.q = true;
        if ((i2 == 108 || i2 == 0) && this.m != null) {
            g a3 = a(0, false);
            if (a3 != null) {
                a3.m = false;
                b(a3, (KeyEvent) null);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0169  */
    public b.a.d.b b(b.a.d.b.a aVar) {
        b.a.d.b bVar;
        b.a.d.b bVar2;
        Context context;
        m();
        b.a.d.b bVar3 = this.p;
        if (bVar3 != null) {
            bVar3.a();
        }
        if (!(aVar instanceof c)) {
            aVar = new c(aVar);
        }
        o oVar = this.f514i;
        if (oVar != null && !this.K) {
            try {
                bVar = oVar.onWindowStartingSupportActionMode(aVar);
            } catch (AbstractMethodError unused) {
            }
            if (bVar == null) {
                this.p = bVar;
            } else {
                boolean z2 = true;
                if (this.q == null) {
                    if (this.E) {
                        TypedValue typedValue = new TypedValue();
                        Theme theme = this.f510e.getTheme();
                        theme.resolveAttribute(b.a.a.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            Theme newTheme = this.f510e.getResources().newTheme();
                            newTheme.setTo(theme);
                            newTheme.applyStyle(typedValue.resourceId, true);
                            b.a.d.d dVar = new b.a.d.d(this.f510e, 0);
                            dVar.getTheme().setTo(newTheme);
                            context = dVar;
                        } else {
                            context = this.f510e;
                        }
                        this.q = new ActionBarContextView(context);
                        this.r = new PopupWindow(context, null, b.a.a.actionModePopupWindowStyle);
                        androidx.core.widget.i.a(this.r, 2);
                        this.r.setContentView(this.q);
                        this.r.setWidth(-1);
                        context.getTheme().resolveAttribute(b.a.a.actionBarSize, typedValue, true);
                        this.q.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()));
                        this.r.setHeight(-2);
                        this.s = new w(this);
                    } else {
                        ViewStubCompat viewStubCompat = (ViewStubCompat) this.w.findViewById(b.a.f.action_mode_bar_stub);
                        if (viewStubCompat != null) {
                            viewStubCompat.setLayoutInflater(LayoutInflater.from(n()));
                            this.q = (ActionBarContextView) viewStubCompat.a();
                        }
                    }
                }
                if (this.q != null) {
                    m();
                    this.q.c();
                    Context context2 = this.q.getContext();
                    ActionBarContextView actionBarContextView = this.q;
                    if (this.r != null) {
                        z2 = false;
                    }
                    b.a.d.e eVar = new b.a.d.e(context2, actionBarContextView, aVar, z2);
                    if (aVar.a((b.a.d.b) eVar, eVar.c())) {
                        eVar.i();
                        this.q.a(eVar);
                        this.p = eVar;
                        if (t()) {
                            this.q.setAlpha(0.0f);
                            K a2 = B.a(this.q);
                            a2.a(1.0f);
                            this.t = a2;
                            this.t.a((L) new x(this));
                        } else {
                            this.q.setAlpha(1.0f);
                            this.q.setVisibility(0);
                            this.q.sendAccessibilityEvent(32);
                            if (this.q.getParent() instanceof View) {
                                B.H((View) this.q.getParent());
                            }
                        }
                        if (this.r != null) {
                            this.f511f.getDecorView().post(this.s);
                        }
                    } else {
                        this.p = null;
                    }
                }
            }
            bVar2 = this.p;
            if (bVar2 != null) {
                o oVar2 = this.f514i;
                if (oVar2 != null) {
                    oVar2.onSupportActionModeStarted(bVar2);
                }
            }
            return this.p;
        }
        bVar = null;
        if (bVar == null) {
        }
        bVar2 = this.p;
        if (bVar2 != null) {
        }
        return this.p;
    }

    public void a(View view) {
        x();
        ViewGroup viewGroup = (ViewGroup) this.w.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f512g.onContentChanged();
    }

    public void a(View view, LayoutParams layoutParams) {
        x();
        ((ViewGroup) this.w.findViewById(16908290)).addView(view, layoutParams);
        this.f512g.onContentChanged();
    }

    public final C0135b c() {
        return new a();
    }

    public final void a(CharSequence charSequence) {
        this.f517l = charSequence;
        I i2 = this.m;
        if (i2 != null) {
            i2.setWindowTitle(charSequence);
        } else if (s() != null) {
            s().c(charSequence);
        } else {
            TextView textView = this.x;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    public boolean a(l lVar, MenuItem menuItem) {
        Callback p2 = p();
        if (p2 != null && !this.K) {
            g a2 = a((Menu) lVar.m());
            if (a2 != null) {
                return p2.onMenuItemSelected(a2.f529a, menuItem);
            }
        }
        return false;
    }

    public void a(l lVar) {
        a(lVar, true);
    }

    public b.a.d.b a(b.a.d.b.a aVar) {
        if (aVar != null) {
            b.a.d.b bVar = this.p;
            if (bVar != null) {
                bVar.a();
            }
            c cVar = new c(aVar);
            C0134a e2 = e();
            if (e2 != null) {
                this.p = e2.a((b.a.d.b.a) cVar);
                b.a.d.b bVar2 = this.p;
                if (bVar2 != null) {
                    o oVar = this.f514i;
                    if (oVar != null) {
                        oVar.onSupportActionModeStarted(bVar2);
                    }
                }
            }
            if (this.p == null) {
                this.p = b((b.a.d.b.a) cVar);
            }
            return this.p;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    /* access modifiers changed from: 0000 */
    public boolean a(KeyEvent keyEvent) {
        Callback callback = this.f512g;
        boolean z2 = true;
        if ((callback instanceof b.g.i.C0244e.a) || (callback instanceof C)) {
            View decorView = this.f511f.getDecorView();
            if (decorView != null && C0244e.a(decorView, keyEvent)) {
                return true;
            }
        }
        if (keyEvent.getKeyCode() == 82 && this.f512g.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z2 = false;
        }
        return z2 ? a(keyCode, keyEvent) : c(keyCode, keyEvent);
    }

    /* access modifiers changed from: 0000 */
    public boolean a(int i2, KeyEvent keyEvent) {
        boolean z2 = true;
        if (i2 == 4) {
            if ((keyEvent.getFlags() & 128) == 0) {
                z2 = false;
            }
            this.J = z2;
        } else if (i2 == 82) {
            d(0, keyEvent);
            return true;
        }
        return false;
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z2;
        boolean z3 = false;
        if (this.U == null) {
            String string = this.f510e.obtainStyledAttributes(b.a.j.AppCompatTheme).getString(b.a.j.AppCompatTheme_viewInflaterClass);
            if (string == null || AppCompatViewInflater.class.getName().equals(string)) {
                this.U = new AppCompatViewInflater();
            } else {
                try {
                    this.U = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to instantiate custom view inflater ");
                    sb.append(string);
                    sb.append(". Falling back to default.");
                    Log.i("AppCompatDelegate", sb.toString(), th);
                    this.U = new AppCompatViewInflater();
                }
            }
        }
        if (f507b) {
            if (!(attributeSet instanceof XmlPullParser)) {
                z3 = a((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                z3 = true;
            }
            z2 = z3;
        } else {
            z2 = false;
        }
        return this.U.createView(view, str, context, attributeSet, z2, f507b, true, Fa.b());
    }

    /* access modifiers changed from: 0000 */
    public boolean b(int i2, KeyEvent keyEvent) {
        C0134a e2 = e();
        if (e2 != null && e2.a(i2, keyEvent)) {
            return true;
        }
        g gVar = this.I;
        if (gVar == null || !a(gVar, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.I == null) {
                g a2 = a(0, true);
                b(a2, keyEvent);
                boolean a3 = a(a2, keyEvent.getKeyCode(), keyEvent, 1);
                a2.m = false;
                if (a3) {
                    return true;
                }
            }
            return false;
        }
        g gVar2 = this.I;
        if (gVar2 != null) {
            gVar2.n = true;
        }
        return true;
    }

    private boolean a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f511f.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || B.B((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private void a(g gVar, KeyEvent keyEvent) {
        int i2;
        if (!gVar.o && !this.K) {
            if (gVar.f529a == 0) {
                if ((this.f510e.getResources().getConfiguration().screenLayout & 15) == 4) {
                    return;
                }
            }
            Callback p2 = p();
            if (p2 == null || p2.onMenuOpened(gVar.f529a, gVar.f538j)) {
                WindowManager windowManager = (WindowManager) this.f510e.getSystemService("window");
                if (windowManager != null && b(gVar, keyEvent)) {
                    if (gVar.f535g == null || gVar.q) {
                        ViewGroup viewGroup = gVar.f535g;
                        if (viewGroup == null) {
                            if (!b(gVar) || gVar.f535g == null) {
                                return;
                            }
                        } else if (gVar.q && viewGroup.getChildCount() > 0) {
                            gVar.f535g.removeAllViews();
                        }
                        if (a(gVar) && gVar.a()) {
                            LayoutParams layoutParams = gVar.f536h.getLayoutParams();
                            if (layoutParams == null) {
                                layoutParams = new LayoutParams(-2, -2);
                            }
                            gVar.f535g.setBackgroundResource(gVar.f530b);
                            ViewParent parent = gVar.f536h.getParent();
                            if (parent != null && (parent instanceof ViewGroup)) {
                                ((ViewGroup) parent).removeView(gVar.f536h);
                            }
                            gVar.f535g.addView(gVar.f536h, layoutParams);
                            if (!gVar.f536h.hasFocus()) {
                                gVar.f536h.requestFocus();
                            }
                        }
                    } else {
                        View view = gVar.f537i;
                        if (view != null) {
                            LayoutParams layoutParams2 = view.getLayoutParams();
                            if (layoutParams2 != null && layoutParams2.width == -1) {
                                i2 = -1;
                                gVar.n = false;
                                WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i2, -2, gVar.f532d, gVar.f533e, 1002, 8519680, -3);
                                layoutParams3.gravity = gVar.f531c;
                                layoutParams3.windowAnimations = gVar.f534f;
                                windowManager.addView(gVar.f535g, layoutParams3);
                                gVar.o = true;
                            }
                        }
                    }
                    i2 = -2;
                    gVar.n = false;
                    WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i2, -2, gVar.f532d, gVar.f533e, 1002, 8519680, -3);
                    layoutParams32.gravity = gVar.f531c;
                    layoutParams32.windowAnimations = gVar.f534f;
                    windowManager.addView(gVar.f535g, layoutParams32);
                    gVar.o = true;
                }
            } else {
                a(gVar, true);
            }
        }
    }

    private boolean b(g gVar) {
        gVar.a(n());
        gVar.f535g = new f(gVar.f540l);
        gVar.f531c = 81;
        return true;
    }

    private boolean b(g gVar, KeyEvent keyEvent) {
        if (this.K) {
            return false;
        }
        if (gVar.m) {
            return true;
        }
        g gVar2 = this.I;
        if (!(gVar2 == null || gVar2 == gVar)) {
            a(gVar2, false);
        }
        Callback p2 = p();
        if (p2 != null) {
            gVar.f537i = p2.onCreatePanelView(gVar.f529a);
        }
        int i2 = gVar.f529a;
        boolean z2 = i2 == 0 || i2 == 108;
        if (z2) {
            I i3 = this.m;
            if (i3 != null) {
                i3.c();
            }
        }
        if (gVar.f537i == null && (!z2 || !(s() instanceof H))) {
            if (gVar.f538j == null || gVar.r) {
                if (gVar.f538j == null && (!c(gVar) || gVar.f538j == null)) {
                    return false;
                }
                if (z2 && this.m != null) {
                    if (this.n == null) {
                        this.n = new b();
                    }
                    this.m.a(gVar.f538j, this.n);
                }
                gVar.f538j.s();
                if (!p2.onCreatePanelMenu(gVar.f529a, gVar.f538j)) {
                    gVar.a((l) null);
                    if (z2) {
                        I i4 = this.m;
                        if (i4 != null) {
                            i4.a(null, this.n);
                        }
                    }
                    return false;
                }
                gVar.r = false;
            }
            gVar.f538j.s();
            Bundle bundle = gVar.s;
            if (bundle != null) {
                gVar.f538j.a(bundle);
                gVar.s = null;
            }
            if (!p2.onPreparePanel(0, gVar.f537i, gVar.f538j)) {
                if (z2) {
                    I i5 = this.m;
                    if (i5 != null) {
                        i5.a(null, this.n);
                    }
                }
                gVar.f538j.r();
                return false;
            }
            gVar.p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            gVar.f538j.setQwertyMode(gVar.p);
            gVar.f538j.r();
        }
        gVar.m = true;
        gVar.n = false;
        this.I = gVar;
        return true;
    }

    private void a(l lVar, boolean z2) {
        I i2 = this.m;
        if (i2 == null || !i2.d() || (ViewConfiguration.get(this.f510e).hasPermanentMenuKey() && !this.m.e())) {
            g a2 = a(0, true);
            a2.q = true;
            a(a2, false);
            a(a2, (KeyEvent) null);
            return;
        }
        Callback p2 = p();
        if (this.m.b() && z2) {
            this.m.f();
            if (!this.K) {
                p2.onPanelClosed(108, a(0, true).f538j);
            }
        } else if (p2 != null && !this.K) {
            if (this.O && (this.P & 1) != 0) {
                this.f511f.getDecorView().removeCallbacks(this.Q);
                this.Q.run();
            }
            g a3 = a(0, true);
            l lVar2 = a3.f538j;
            if (lVar2 != null && !a3.r && p2.onPreparePanel(0, a3.f537i, lVar2)) {
                p2.onMenuOpened(108, a3.f538j);
                this.m.g();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void b(l lVar) {
        if (!this.G) {
            this.G = true;
            this.m.h();
            Callback p2 = p();
            if (p2 != null && !this.K) {
                p2.onPanelClosed(108, lVar);
            }
            this.G = false;
        }
    }

    private boolean a(g gVar) {
        View view = gVar.f537i;
        boolean z2 = true;
        if (view != null) {
            gVar.f536h = view;
            return true;
        } else if (gVar.f538j == null) {
            return false;
        } else {
            if (this.o == null) {
                this.o = new h();
            }
            gVar.f536h = (View) gVar.a((androidx.appcompat.view.menu.v.a) this.o);
            if (gVar.f536h == null) {
                z2 = false;
            }
            return z2;
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(g gVar, boolean z2) {
        if (z2 && gVar.f529a == 0) {
            I i2 = this.m;
            if (i2 != null && i2.b()) {
                b(gVar.f538j);
                return;
            }
        }
        WindowManager windowManager = (WindowManager) this.f510e.getSystemService("window");
        if (windowManager != null && gVar.o) {
            ViewGroup viewGroup = gVar.f535g;
            if (viewGroup != null) {
                windowManager.removeView(viewGroup);
                if (z2) {
                    a(gVar.f529a, gVar, null);
                }
            }
        }
        gVar.m = false;
        gVar.n = false;
        gVar.o = false;
        gVar.f536h = null;
        gVar.q = true;
        if (this.I == gVar) {
            this.I = null;
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(int i2, g gVar, Menu menu) {
        if (menu == null) {
            if (gVar == null && i2 >= 0) {
                g[] gVarArr = this.H;
                if (i2 < gVarArr.length) {
                    gVar = gVarArr[i2];
                }
            }
            if (gVar != null) {
                menu = gVar.f538j;
            }
        }
        if ((gVar == null || gVar.o) && !this.K) {
            this.f512g.onPanelClosed(i2, menu);
        }
    }

    /* access modifiers changed from: 0000 */
    public g a(Menu menu) {
        g[] gVarArr = this.H;
        int length = gVarArr != null ? gVarArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            g gVar = gVarArr[i2];
            if (gVar != null && gVar.f538j == menu) {
                return gVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public g a(int i2, boolean z2) {
        g[] gVarArr = this.H;
        if (gVarArr == null || gVarArr.length <= i2) {
            g[] gVarArr2 = new g[(i2 + 1)];
            if (gVarArr != null) {
                System.arraycopy(gVarArr, 0, gVarArr2, 0, gVarArr.length);
            }
            this.H = gVarArr2;
            gVarArr = gVarArr2;
        }
        g gVar = gVarArr[i2];
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g(i2);
        gVarArr[i2] = gVar2;
        return gVar2;
    }

    private boolean a(g gVar, int i2, KeyEvent keyEvent, int i3) {
        boolean z2 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if (gVar.m || b(gVar, keyEvent)) {
            l lVar = gVar.f538j;
            if (lVar != null) {
                z2 = lVar.performShortcut(i2, keyEvent, i3);
            }
        }
        if (z2 && (i3 & 1) == 0 && this.m == null) {
            a(gVar, true);
        }
        return z2;
    }

    public boolean a() {
        int y2 = y();
        int f2 = f(y2);
        boolean l2 = f2 != -1 ? l(f2) : false;
        if (y2 == 0) {
            w();
            this.N.d();
        }
        this.M = true;
        return l2;
    }
}
