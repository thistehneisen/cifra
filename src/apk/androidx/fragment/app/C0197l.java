package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.lifecycle.G;
import b.g.h.g;

/* renamed from: androidx.fragment.app.l reason: case insensitive filesystem */
/* compiled from: FragmentController */
public class C0197l {

    /* renamed from: a reason: collision with root package name */
    private final C0199n<?> f1537a;

    private C0197l(C0199n<?> nVar) {
        this.f1537a = nVar;
    }

    public static C0197l a(C0199n<?> nVar) {
        g.a(nVar, "callbacks == null");
        return new C0197l(nVar);
    }

    public void b() {
        this.f1537a.f1543e.k();
    }

    public void c() {
        this.f1537a.f1543e.l();
    }

    public void d() {
        this.f1537a.f1543e.n();
    }

    public void e() {
        this.f1537a.f1543e.o();
    }

    public void f() {
        this.f1537a.f1543e.q();
    }

    public void g() {
        this.f1537a.f1543e.r();
    }

    public void h() {
        this.f1537a.f1543e.s();
    }

    public boolean i() {
        return this.f1537a.f1543e.u();
    }

    public C0200o j() {
        return this.f1537a.f1543e;
    }

    public void k() {
        this.f1537a.f1543e.y();
    }

    public Parcelable l() {
        return this.f1537a.f1543e.A();
    }

    public Fragment a(String str) {
        return this.f1537a.f1543e.b(str);
    }

    public void b(boolean z) {
        this.f1537a.f1543e.b(z);
    }

    public void a(Fragment fragment) {
        C0199n<?> nVar = this.f1537a;
        nVar.f1543e.a((C0199n) nVar, (C0196k) nVar, fragment);
    }

    public boolean b(Menu menu) {
        return this.f1537a.f1543e.b(menu);
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f1537a.f1543e.onCreateView(view, str, context, attributeSet);
    }

    public boolean b(MenuItem menuItem) {
        return this.f1537a.f1543e.b(menuItem);
    }

    public void a(Parcelable parcelable) {
        C0199n<?> nVar = this.f1537a;
        if (nVar instanceof G) {
            nVar.f1543e.a(parcelable);
            return;
        }
        throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
    }

    public void a() {
        this.f1537a.f1543e.j();
    }

    public void a(boolean z) {
        this.f1537a.f1543e.a(z);
    }

    public void a(Configuration configuration) {
        this.f1537a.f1543e.a(configuration);
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        return this.f1537a.f1543e.a(menu, menuInflater);
    }

    public boolean a(MenuItem menuItem) {
        return this.f1537a.f1543e.a(menuItem);
    }

    public void a(Menu menu) {
        this.f1537a.f1543e.a(menu);
    }
}
