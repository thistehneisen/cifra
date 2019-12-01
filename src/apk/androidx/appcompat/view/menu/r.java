package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;
import b.g.d.a.b;
import b.g.i.C0241b.C0029b;

/* compiled from: MenuItemWrapperJB */
class r extends q {

    /* compiled from: MenuItemWrapperJB */
    class a extends a implements VisibilityListener {

        /* renamed from: f reason: collision with root package name */
        C0029b f682f;

        public a(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        public View a(MenuItem menuItem) {
            return this.f677d.onCreateActionView(menuItem);
        }

        public boolean b() {
            return this.f677d.isVisible();
        }

        public boolean e() {
            return this.f677d.overridesItemVisibility();
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            C0029b bVar = this.f682f;
            if (bVar != null) {
                bVar.onActionProviderVisibilityChanged(z);
            }
        }

        public void a(C0029b bVar) {
            this.f682f = bVar;
            this.f677d.setVisibilityListener(bVar != null ? this : null);
        }
    }

    r(Context context, b bVar) {
        super(context, bVar);
    }

    /* access modifiers changed from: 0000 */
    public a a(ActionProvider actionProvider) {
        return new a(this.f605b, actionProvider);
    }
}
