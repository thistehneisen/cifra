package b.a.d;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.l.a;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* compiled from: StandaloneActionMode */
public class e extends b implements a {

    /* renamed from: c reason: collision with root package name */
    private Context f2193c;

    /* renamed from: d reason: collision with root package name */
    private ActionBarContextView f2194d;

    /* renamed from: e reason: collision with root package name */
    private b.a f2195e;

    /* renamed from: f reason: collision with root package name */
    private WeakReference<View> f2196f;

    /* renamed from: g reason: collision with root package name */
    private boolean f2197g;

    /* renamed from: h reason: collision with root package name */
    private boolean f2198h;

    /* renamed from: i reason: collision with root package name */
    private l f2199i;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z) {
        this.f2193c = context;
        this.f2194d = actionBarContextView;
        this.f2195e = aVar;
        l lVar = new l(actionBarContextView.getContext());
        lVar.c(1);
        this.f2199i = lVar;
        this.f2199i.a((a) this);
        this.f2198h = z;
    }

    public void a(CharSequence charSequence) {
        this.f2194d.setSubtitle(charSequence);
    }

    public void b(CharSequence charSequence) {
        this.f2194d.setTitle(charSequence);
    }

    public Menu c() {
        return this.f2199i;
    }

    public MenuInflater d() {
        return new g(this.f2194d.getContext());
    }

    public CharSequence e() {
        return this.f2194d.getSubtitle();
    }

    public CharSequence g() {
        return this.f2194d.getTitle();
    }

    public void i() {
        this.f2195e.b(this, this.f2199i);
    }

    public boolean j() {
        return this.f2194d.b();
    }

    public void a(int i2) {
        a((CharSequence) this.f2193c.getString(i2));
    }

    public void b(int i2) {
        b((CharSequence) this.f2193c.getString(i2));
    }

    public void a(boolean z) {
        super.a(z);
        this.f2194d.setTitleOptional(z);
    }

    public View b() {
        WeakReference<View> weakReference = this.f2196f;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    public void a(View view) {
        this.f2194d.setCustomView(view);
        this.f2196f = view != null ? new WeakReference<>(view) : null;
    }

    public void a() {
        if (!this.f2197g) {
            this.f2197g = true;
            this.f2194d.sendAccessibilityEvent(32);
            this.f2195e.a(this);
        }
    }

    public boolean a(l lVar, MenuItem menuItem) {
        return this.f2195e.a((b) this, menuItem);
    }

    public void a(l lVar) {
        i();
        this.f2194d.d();
    }
}
