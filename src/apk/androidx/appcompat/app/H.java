package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window.Callback;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.J;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.za;
import b.a.d.j;
import b.g.i.B;
import java.util.ArrayList;

/* compiled from: ToolbarActionBar */
class H extends C0134a {

    /* renamed from: a reason: collision with root package name */
    J f425a;

    /* renamed from: b reason: collision with root package name */
    boolean f426b;

    /* renamed from: c reason: collision with root package name */
    Callback f427c;

    /* renamed from: d reason: collision with root package name */
    private boolean f428d;

    /* renamed from: e reason: collision with root package name */
    private boolean f429e;

    /* renamed from: f reason: collision with root package name */
    private ArrayList<androidx.appcompat.app.C0134a.b> f430f = new ArrayList<>();

    /* renamed from: g reason: collision with root package name */
    private final Runnable f431g = new F(this);

    /* renamed from: h reason: collision with root package name */
    private final androidx.appcompat.widget.Toolbar.c f432h = new G(this);

    /* compiled from: ToolbarActionBar */
    private final class a implements androidx.appcompat.view.menu.v.a {

        /* renamed from: a reason: collision with root package name */
        private boolean f433a;

        a() {
        }

        public boolean a(l lVar) {
            Callback callback = H.this.f427c;
            if (callback == null) {
                return false;
            }
            callback.onMenuOpened(108, lVar);
            return true;
        }

        public void a(l lVar, boolean z) {
            if (!this.f433a) {
                this.f433a = true;
                H.this.f425a.h();
                Callback callback = H.this.f427c;
                if (callback != null) {
                    callback.onPanelClosed(108, lVar);
                }
                this.f433a = false;
            }
        }
    }

    /* compiled from: ToolbarActionBar */
    private final class b implements androidx.appcompat.view.menu.l.a {
        b() {
        }

        public void a(l lVar) {
            H h2 = H.this;
            if (h2.f427c == null) {
                return;
            }
            if (h2.f425a.b()) {
                H.this.f427c.onPanelClosed(108, lVar);
            } else if (H.this.f427c.onPreparePanel(0, null, lVar)) {
                H.this.f427c.onMenuOpened(108, lVar);
            }
        }

        public boolean a(l lVar, MenuItem menuItem) {
            return false;
        }
    }

    /* compiled from: ToolbarActionBar */
    private class c extends j {
        public c(Callback callback) {
            super(callback);
        }

        public View onCreatePanelView(int i2) {
            if (i2 == 0) {
                return new View(H.this.f425a.a());
            }
            return super.onCreatePanelView(i2);
        }

        public boolean onPreparePanel(int i2, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i2, view, menu);
            if (onPreparePanel) {
                H h2 = H.this;
                if (!h2.f426b) {
                    h2.f425a.c();
                    H.this.f426b = true;
                }
            }
            return onPreparePanel;
        }
    }

    H(Toolbar toolbar, CharSequence charSequence, Callback callback) {
        this.f425a = new za(toolbar, false);
        this.f427c = new c(callback);
        this.f425a.setWindowCallback(this.f427c);
        toolbar.setOnMenuItemClickListener(this.f432h);
        this.f425a.setWindowTitle(charSequence);
    }

    private Menu n() {
        if (!this.f428d) {
            this.f425a.a((androidx.appcompat.view.menu.v.a) new a(), (androidx.appcompat.view.menu.l.a) new b());
            this.f428d = true;
        }
        return this.f425a.j();
    }

    public void a(Configuration configuration) {
        super.a(configuration);
    }

    public void b(int i2) {
        this.f425a.c(i2);
    }

    public void c(CharSequence charSequence) {
        this.f425a.setWindowTitle(charSequence);
    }

    public void c(boolean z) {
    }

    public void d(boolean z) {
        a(z ? 4 : 0, 4);
    }

    public void e(boolean z) {
        a(z ? 2 : 0, 2);
    }

    public void f(boolean z) {
        a(z ? 8 : 0, 8);
    }

    public int g() {
        return this.f425a.m();
    }

    public void g(boolean z) {
    }

    public Context h() {
        return this.f425a.a();
    }

    public boolean i() {
        this.f425a.l().removeCallbacks(this.f431g);
        B.a((View) this.f425a.l(), this.f431g);
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void j() {
        this.f425a.l().removeCallbacks(this.f431g);
    }

    public boolean k() {
        return this.f425a.g();
    }

    public Callback l() {
        return this.f427c;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: 0000 */
    public void m() {
        Menu n = n();
        l lVar = n instanceof l ? (l) n : null;
        if (lVar != null) {
            lVar.s();
        }
        try {
            n.clear();
            if (!this.f427c.onCreatePanelMenu(0, n) || !this.f427c.onPreparePanel(0, null, n)) {
                n.clear();
            }
            if (lVar != null) {
                lVar.r();
            }
        } catch (Throwable th) {
            if (lVar != null) {
                lVar.r();
            }
            throw th;
        }
    }

    public void a(CharSequence charSequence) {
        this.f425a.a(charSequence);
    }

    public void b(CharSequence charSequence) {
        this.f425a.setTitle(charSequence);
    }

    public boolean e() {
        return this.f425a.f();
    }

    public boolean f() {
        if (!this.f425a.i()) {
            return false;
        }
        this.f425a.collapseActionView();
        return true;
    }

    public void a(int i2, int i3) {
        this.f425a.a((i2 & i3) | ((~i3) & this.f425a.m()));
    }

    public void b(boolean z) {
        if (z != this.f429e) {
            this.f429e = z;
            int size = this.f430f.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((androidx.appcompat.app.C0134a.b) this.f430f.get(i2)).onMenuVisibilityChanged(z);
            }
        }
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            k();
        }
        return true;
    }

    public boolean a(int i2, KeyEvent keyEvent) {
        Menu n = n();
        if (n == null) {
            return false;
        }
        boolean z = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z = false;
        }
        n.setQwertyMode(z);
        return n.performShortcut(i2, keyEvent, 0);
    }
}
