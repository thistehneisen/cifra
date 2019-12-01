package b.a.d;

import android.content.Context;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.x;
import b.d.i;
import b.g.d.a.b;
import java.util.ArrayList;

/* compiled from: SupportActionModeWrapper */
public class f extends ActionMode {

    /* renamed from: a reason: collision with root package name */
    final Context f2200a;

    /* renamed from: b reason: collision with root package name */
    final b f2201b;

    /* compiled from: SupportActionModeWrapper */
    public static class a implements b.a.d.b.a {

        /* renamed from: a reason: collision with root package name */
        final Callback f2202a;

        /* renamed from: b reason: collision with root package name */
        final Context f2203b;

        /* renamed from: c reason: collision with root package name */
        final ArrayList<f> f2204c = new ArrayList<>();

        /* renamed from: d reason: collision with root package name */
        final i<Menu, Menu> f2205d = new i<>();

        public a(Context context, Callback callback) {
            this.f2203b = context;
            this.f2202a = callback;
        }

        public boolean a(b bVar, Menu menu) {
            return this.f2202a.onCreateActionMode(b(bVar), a(menu));
        }

        public boolean b(b bVar, Menu menu) {
            return this.f2202a.onPrepareActionMode(b(bVar), a(menu));
        }

        public boolean a(b bVar, MenuItem menuItem) {
            return this.f2202a.onActionItemClicked(b(bVar), x.a(this.f2203b, (b) menuItem));
        }

        public ActionMode b(b bVar) {
            int size = this.f2204c.size();
            for (int i2 = 0; i2 < size; i2++) {
                f fVar = (f) this.f2204c.get(i2);
                if (fVar != null && fVar.f2201b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f2203b, bVar);
            this.f2204c.add(fVar2);
            return fVar2;
        }

        public void a(b bVar) {
            this.f2202a.onDestroyActionMode(b(bVar));
        }

        private Menu a(Menu menu) {
            Menu menu2 = (Menu) this.f2205d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            Menu a2 = x.a(this.f2203b, (b.g.d.a.a) menu);
            this.f2205d.put(menu, a2);
            return a2;
        }
    }

    public f(Context context, b bVar) {
        this.f2200a = context;
        this.f2201b = bVar;
    }

    public void finish() {
        this.f2201b.a();
    }

    public View getCustomView() {
        return this.f2201b.b();
    }

    public Menu getMenu() {
        return x.a(this.f2200a, (b.g.d.a.a) this.f2201b.c());
    }

    public MenuInflater getMenuInflater() {
        return this.f2201b.d();
    }

    public CharSequence getSubtitle() {
        return this.f2201b.e();
    }

    public Object getTag() {
        return this.f2201b.f();
    }

    public CharSequence getTitle() {
        return this.f2201b.g();
    }

    public boolean getTitleOptionalHint() {
        return this.f2201b.h();
    }

    public void invalidate() {
        this.f2201b.i();
    }

    public boolean isTitleOptional() {
        return this.f2201b.j();
    }

    public void setCustomView(View view) {
        this.f2201b.a(view);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f2201b.a(charSequence);
    }

    public void setTag(Object obj) {
        this.f2201b.a(obj);
    }

    public void setTitle(CharSequence charSequence) {
        this.f2201b.b(charSequence);
    }

    public void setTitleOptionalHint(boolean z) {
        this.f2201b.a(z);
    }

    public void setSubtitle(int i2) {
        this.f2201b.a(i2);
    }

    public void setTitle(int i2) {
        this.f2201b.b(i2);
    }
}
