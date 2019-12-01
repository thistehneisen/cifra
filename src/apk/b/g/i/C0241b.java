package b.g.i;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: b.g.i.b reason: case insensitive filesystem */
/* compiled from: ActionProvider */
public abstract class C0241b {

    /* renamed from: a reason: collision with root package name */
    private final Context f2692a;

    /* renamed from: b reason: collision with root package name */
    private a f2693b;

    /* renamed from: c reason: collision with root package name */
    private C0029b f2694c;

    /* renamed from: b.g.i.b$a */
    /* compiled from: ActionProvider */
    public interface a {
    }

    /* renamed from: b.g.i.b$b reason: collision with other inner class name */
    /* compiled from: ActionProvider */
    public interface C0029b {
        void onActionProviderVisibilityChanged(boolean z);
    }

    public C0241b(Context context) {
        this.f2692a = context;
    }

    public View a(MenuItem menuItem) {
        return c();
    }

    public void a(SubMenu subMenu) {
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return true;
    }

    public abstract View c();

    public boolean d() {
        return false;
    }

    public boolean e() {
        return false;
    }

    public void f() {
        this.f2694c = null;
        this.f2693b = null;
    }

    public void a(a aVar) {
        this.f2693b = aVar;
    }

    public void a(C0029b bVar) {
        if (!(this.f2694c == null || bVar == null)) {
            StringBuilder sb = new StringBuilder();
            sb.append("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ");
            sb.append(getClass().getSimpleName());
            sb.append(" instance while it is still in use somewhere else?");
            Log.w("ActionProvider(support)", sb.toString());
        }
        this.f2694c = bVar;
    }
}
