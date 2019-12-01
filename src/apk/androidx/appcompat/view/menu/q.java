package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import b.g.i.C0241b;
import java.lang.reflect.Method;

/* compiled from: MenuItemWrapperICS */
public class q extends C0150c<b.g.d.a.b> implements MenuItem {

    /* renamed from: e reason: collision with root package name */
    private Method f676e;

    /* compiled from: MenuItemWrapperICS */
    class a extends C0241b {

        /* renamed from: d reason: collision with root package name */
        final ActionProvider f677d;

        public a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f677d = actionProvider;
        }

        public boolean a() {
            return this.f677d.hasSubMenu();
        }

        public View c() {
            return this.f677d.onCreateActionView();
        }

        public boolean d() {
            return this.f677d.onPerformDefaultAction();
        }

        public void a(SubMenu subMenu) {
            this.f677d.onPrepareSubMenu(q.this.a(subMenu));
        }
    }

    /* compiled from: MenuItemWrapperICS */
    static class b extends FrameLayout implements b.a.d.c {

        /* renamed from: a reason: collision with root package name */
        final CollapsibleActionView f679a;

        b(View view) {
            super(view.getContext());
            this.f679a = (CollapsibleActionView) view;
            addView(view);
        }

        /* access modifiers changed from: 0000 */
        public View a() {
            return (View) this.f679a;
        }

        public void onActionViewCollapsed() {
            this.f679a.onActionViewCollapsed();
        }

        public void onActionViewExpanded() {
            this.f679a.onActionViewExpanded();
        }
    }

    /* compiled from: MenuItemWrapperICS */
    private class c extends C0151d<OnActionExpandListener> implements OnActionExpandListener {
        c(OnActionExpandListener onActionExpandListener) {
            super(onActionExpandListener);
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return ((OnActionExpandListener) this.f608a).onMenuItemActionCollapse(q.this.a(menuItem));
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return ((OnActionExpandListener) this.f608a).onMenuItemActionExpand(q.this.a(menuItem));
        }
    }

    /* compiled from: MenuItemWrapperICS */
    private class d extends C0151d<OnMenuItemClickListener> implements OnMenuItemClickListener {
        d(OnMenuItemClickListener onMenuItemClickListener) {
            super(onMenuItemClickListener);
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return ((OnMenuItemClickListener) this.f608a).onMenuItemClick(q.this.a(menuItem));
        }
    }

    q(Context context, b.g.d.a.b bVar) {
        super(context, bVar);
    }

    public void a(boolean z) {
        try {
            if (this.f676e == null) {
                this.f676e = ((b.g.d.a.b) this.f608a).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.f676e.invoke(this.f608a, new Object[]{Boolean.valueOf(z)});
        } catch (Exception e2) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e2);
        }
    }

    public boolean collapseActionView() {
        return ((b.g.d.a.b) this.f608a).collapseActionView();
    }

    public boolean expandActionView() {
        return ((b.g.d.a.b) this.f608a).expandActionView();
    }

    public ActionProvider getActionProvider() {
        C0241b a2 = ((b.g.d.a.b) this.f608a).a();
        if (a2 instanceof a) {
            return ((a) a2).f677d;
        }
        return null;
    }

    public View getActionView() {
        View actionView = ((b.g.d.a.b) this.f608a).getActionView();
        return actionView instanceof b ? ((b) actionView).a() : actionView;
    }

    public int getAlphabeticModifiers() {
        return ((b.g.d.a.b) this.f608a).getAlphabeticModifiers();
    }

    public char getAlphabeticShortcut() {
        return ((b.g.d.a.b) this.f608a).getAlphabeticShortcut();
    }

    public CharSequence getContentDescription() {
        return ((b.g.d.a.b) this.f608a).getContentDescription();
    }

    public int getGroupId() {
        return ((b.g.d.a.b) this.f608a).getGroupId();
    }

    public Drawable getIcon() {
        return ((b.g.d.a.b) this.f608a).getIcon();
    }

    public ColorStateList getIconTintList() {
        return ((b.g.d.a.b) this.f608a).getIconTintList();
    }

    public Mode getIconTintMode() {
        return ((b.g.d.a.b) this.f608a).getIconTintMode();
    }

    public Intent getIntent() {
        return ((b.g.d.a.b) this.f608a).getIntent();
    }

    public int getItemId() {
        return ((b.g.d.a.b) this.f608a).getItemId();
    }

    public ContextMenuInfo getMenuInfo() {
        return ((b.g.d.a.b) this.f608a).getMenuInfo();
    }

    public int getNumericModifiers() {
        return ((b.g.d.a.b) this.f608a).getNumericModifiers();
    }

    public char getNumericShortcut() {
        return ((b.g.d.a.b) this.f608a).getNumericShortcut();
    }

    public int getOrder() {
        return ((b.g.d.a.b) this.f608a).getOrder();
    }

    public SubMenu getSubMenu() {
        return a(((b.g.d.a.b) this.f608a).getSubMenu());
    }

    public CharSequence getTitle() {
        return ((b.g.d.a.b) this.f608a).getTitle();
    }

    public CharSequence getTitleCondensed() {
        return ((b.g.d.a.b) this.f608a).getTitleCondensed();
    }

    public CharSequence getTooltipText() {
        return ((b.g.d.a.b) this.f608a).getTooltipText();
    }

    public boolean hasSubMenu() {
        return ((b.g.d.a.b) this.f608a).hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return ((b.g.d.a.b) this.f608a).isActionViewExpanded();
    }

    public boolean isCheckable() {
        return ((b.g.d.a.b) this.f608a).isCheckable();
    }

    public boolean isChecked() {
        return ((b.g.d.a.b) this.f608a).isChecked();
    }

    public boolean isEnabled() {
        return ((b.g.d.a.b) this.f608a).isEnabled();
    }

    public boolean isVisible() {
        return ((b.g.d.a.b) this.f608a).isVisible();
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((b.g.d.a.b) this.f608a).a(actionProvider != null ? a(actionProvider) : null);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new b(view);
        }
        ((b.g.d.a.b) this.f608a).setActionView(view);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        ((b.g.d.a.b) this.f608a).setAlphabeticShortcut(c2);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        ((b.g.d.a.b) this.f608a).setCheckable(z);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        ((b.g.d.a.b) this.f608a).setChecked(z);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        ((b.g.d.a.b) this.f608a).setContentDescription(charSequence);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        ((b.g.d.a.b) this.f608a).setEnabled(z);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        ((b.g.d.a.b) this.f608a).setIcon(drawable);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        ((b.g.d.a.b) this.f608a).setIconTintList(colorStateList);
        return this;
    }

    public MenuItem setIconTintMode(Mode mode) {
        ((b.g.d.a.b) this.f608a).setIconTintMode(mode);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        ((b.g.d.a.b) this.f608a).setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        ((b.g.d.a.b) this.f608a).setNumericShortcut(c2);
        return this;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        ((b.g.d.a.b) this.f608a).setOnActionExpandListener(onActionExpandListener != null ? new c(onActionExpandListener) : null);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        ((b.g.d.a.b) this.f608a).setOnMenuItemClickListener(onMenuItemClickListener != null ? new d(onMenuItemClickListener) : null);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        ((b.g.d.a.b) this.f608a).setShortcut(c2, c3);
        return this;
    }

    public void setShowAsAction(int i2) {
        ((b.g.d.a.b) this.f608a).setShowAsAction(i2);
    }

    public MenuItem setShowAsActionFlags(int i2) {
        ((b.g.d.a.b) this.f608a).setShowAsActionFlags(i2);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((b.g.d.a.b) this.f608a).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((b.g.d.a.b) this.f608a).setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        ((b.g.d.a.b) this.f608a).setTooltipText(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        return ((b.g.d.a.b) this.f608a).setVisible(z);
    }

    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        ((b.g.d.a.b) this.f608a).setAlphabeticShortcut(c2, i2);
        return this;
    }

    public MenuItem setIcon(int i2) {
        ((b.g.d.a.b) this.f608a).setIcon(i2);
        return this;
    }

    public MenuItem setNumericShortcut(char c2, int i2) {
        ((b.g.d.a.b) this.f608a).setNumericShortcut(c2, i2);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        ((b.g.d.a.b) this.f608a).setShortcut(c2, c3, i2, i3);
        return this;
    }

    public MenuItem setTitle(int i2) {
        ((b.g.d.a.b) this.f608a).setTitle(i2);
        return this;
    }

    public MenuItem setActionView(int i2) {
        ((b.g.d.a.b) this.f608a).setActionView(i2);
        View actionView = ((b.g.d.a.b) this.f608a).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((b.g.d.a.b) this.f608a).setActionView((View) new b(actionView));
        }
        return this;
    }

    /* access modifiers changed from: 0000 */
    public a a(ActionProvider actionProvider) {
        return new a(this.f605b, actionProvider);
    }
}
