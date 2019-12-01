package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;
import b.a.a.a.a;
import b.a.h;
import b.g.d.a.b;
import b.g.i.C0241b;
import b.g.i.C0241b.C0029b;

/* compiled from: MenuItemImpl */
public final class p implements b {
    private View A;
    private C0241b B;
    private OnActionExpandListener C;
    private boolean D = false;
    private ContextMenuInfo E;

    /* renamed from: a reason: collision with root package name */
    private final int f664a;

    /* renamed from: b reason: collision with root package name */
    private final int f665b;

    /* renamed from: c reason: collision with root package name */
    private final int f666c;

    /* renamed from: d reason: collision with root package name */
    private final int f667d;

    /* renamed from: e reason: collision with root package name */
    private CharSequence f668e;

    /* renamed from: f reason: collision with root package name */
    private CharSequence f669f;

    /* renamed from: g reason: collision with root package name */
    private Intent f670g;

    /* renamed from: h reason: collision with root package name */
    private char f671h;

    /* renamed from: i reason: collision with root package name */
    private int f672i = CodedOutputStream.DEFAULT_BUFFER_SIZE;

    /* renamed from: j reason: collision with root package name */
    private char f673j;

    /* renamed from: k reason: collision with root package name */
    private int f674k = CodedOutputStream.DEFAULT_BUFFER_SIZE;

    /* renamed from: l reason: collision with root package name */
    private Drawable f675l;
    private int m = 0;
    l n;
    private D o;
    private Runnable p;
    private OnMenuItemClickListener q;
    private CharSequence r;
    private CharSequence s;
    private ColorStateList t = null;
    private Mode u = null;
    private boolean v = false;
    private boolean w = false;
    private boolean x = false;
    private int y = 16;
    private int z = 0;

    p(l lVar, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        this.n = lVar;
        this.f664a = i3;
        this.f665b = i2;
        this.f666c = i4;
        this.f667d = i5;
        this.f668e = charSequence;
        this.z = i6;
    }

    private static void a(StringBuilder sb, int i2, int i3, String str) {
        if ((i2 & i3) == i3) {
            sb.append(str);
        }
    }

    /* access modifiers changed from: 0000 */
    public void b(boolean z2) {
        int i2 = this.y;
        this.y = (z2 ? 2 : 0) | (i2 & -3);
        if (i2 != this.y) {
            this.n.b(false);
        }
    }

    public int c() {
        return this.f667d;
    }

    public boolean collapseActionView() {
        if ((this.z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.n.a(this);
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public char d() {
        return this.n.p() ? this.f673j : this.f671h;
    }

    /* access modifiers changed from: 0000 */
    public String e() {
        char d2 = d();
        if (d2 == 0) {
            return "";
        }
        Resources resources = this.n.e().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.n.e()).hasPermanentMenuKey()) {
            sb.append(resources.getString(h.abc_prepend_shortcut_label));
        }
        int i2 = this.n.p() ? this.f674k : this.f672i;
        a(sb, i2, 65536, resources.getString(h.abc_menu_meta_shortcut_label));
        a(sb, i2, CodedOutputStream.DEFAULT_BUFFER_SIZE, resources.getString(h.abc_menu_ctrl_shortcut_label));
        a(sb, i2, 2, resources.getString(h.abc_menu_alt_shortcut_label));
        a(sb, i2, 1, resources.getString(h.abc_menu_shift_shortcut_label));
        a(sb, i2, 4, resources.getString(h.abc_menu_sym_shortcut_label));
        a(sb, i2, 8, resources.getString(h.abc_menu_function_shortcut_label));
        if (d2 == 8) {
            sb.append(resources.getString(h.abc_menu_delete_shortcut_label));
        } else if (d2 == 10) {
            sb.append(resources.getString(h.abc_menu_enter_shortcut_label));
        } else if (d2 != ' ') {
            sb.append(d2);
        } else {
            sb.append(resources.getString(h.abc_menu_space_shortcut_label));
        }
        return sb.toString();
    }

    public boolean expandActionView() {
        if (!f()) {
            return false;
        }
        OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.n.b(this);
        }
        return false;
    }

    public boolean f() {
        if ((this.z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            C0241b bVar = this.B;
            if (bVar != null) {
                this.A = bVar.a((MenuItem) this);
            }
        }
        if (this.A != null) {
            return true;
        }
        return false;
    }

    public boolean g() {
        OnMenuItemClickListener onMenuItemClickListener = this.q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        l lVar = this.n;
        if (lVar.a(lVar, (MenuItem) this)) {
            return true;
        }
        Runnable runnable = this.p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f670g != null) {
            try {
                this.n.e().startActivity(this.f670g);
                return true;
            } catch (ActivityNotFoundException e2) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e2);
            }
        }
        C0241b bVar = this.B;
        if (bVar == null || !bVar.d()) {
            return false;
        }
        return true;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public View getActionView() {
        View view = this.A;
        if (view != null) {
            return view;
        }
        C0241b bVar = this.B;
        if (bVar == null) {
            return null;
        }
        this.A = bVar.a((MenuItem) this);
        return this.A;
    }

    public int getAlphabeticModifiers() {
        return this.f674k;
    }

    public char getAlphabeticShortcut() {
        return this.f673j;
    }

    public CharSequence getContentDescription() {
        return this.r;
    }

    public int getGroupId() {
        return this.f665b;
    }

    public Drawable getIcon() {
        Drawable drawable = this.f675l;
        if (drawable != null) {
            return a(drawable);
        }
        if (this.m == 0) {
            return null;
        }
        Drawable b2 = a.b(this.n.e(), this.m);
        this.m = 0;
        this.f675l = b2;
        return a(b2);
    }

    public ColorStateList getIconTintList() {
        return this.t;
    }

    public Mode getIconTintMode() {
        return this.u;
    }

    public Intent getIntent() {
        return this.f670g;
    }

    @CapturedViewProperty
    public int getItemId() {
        return this.f664a;
    }

    public ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    public int getNumericModifiers() {
        return this.f672i;
    }

    public char getNumericShortcut() {
        return this.f671h;
    }

    public int getOrder() {
        return this.f666c;
    }

    public SubMenu getSubMenu() {
        return this.o;
    }

    @CapturedViewProperty
    public CharSequence getTitle() {
        return this.f668e;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f669f;
        if (charSequence == null) {
            charSequence = this.f668e;
        }
        return (VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    public CharSequence getTooltipText() {
        return this.s;
    }

    public boolean h() {
        return (this.y & 32) == 32;
    }

    public boolean hasSubMenu() {
        return this.o != null;
    }

    public boolean i() {
        return (this.y & 4) != 0;
    }

    public boolean isActionViewExpanded() {
        return this.D;
    }

    public boolean isCheckable() {
        return (this.y & 1) == 1;
    }

    public boolean isChecked() {
        return (this.y & 2) == 2;
    }

    public boolean isEnabled() {
        return (this.y & 16) != 0;
    }

    public boolean isVisible() {
        C0241b bVar = this.B;
        boolean z2 = true;
        if (bVar == null || !bVar.e()) {
            if ((this.y & 8) != 0) {
                z2 = false;
            }
            return z2;
        }
        if ((this.y & 8) != 0 || !this.B.b()) {
            z2 = false;
        }
        return z2;
    }

    public boolean j() {
        return (this.z & 1) == 1;
    }

    public boolean k() {
        return (this.z & 2) == 2;
    }

    public boolean l() {
        return this.n.k();
    }

    /* access modifiers changed from: 0000 */
    public boolean m() {
        return this.n.q() && d() != 0;
    }

    public boolean n() {
        return (this.z & 4) == 4;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        if (this.f673j == c2) {
            return this;
        }
        this.f673j = Character.toLowerCase(c2);
        this.n.b(false);
        return this;
    }

    public MenuItem setCheckable(boolean z2) {
        int i2 = this.y;
        this.y = z2 | (i2 & true) ? 1 : 0;
        if (i2 != this.y) {
            this.n.b(false);
        }
        return this;
    }

    public MenuItem setChecked(boolean z2) {
        if ((this.y & 4) != 0) {
            this.n.a((MenuItem) this);
        } else {
            b(z2);
        }
        return this;
    }

    public MenuItem setEnabled(boolean z2) {
        if (z2) {
            this.y |= 16;
        } else {
            this.y &= -17;
        }
        this.n.b(false);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.m = 0;
        this.f675l = drawable;
        this.x = true;
        this.n.b(false);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.t = colorStateList;
        this.v = true;
        this.x = true;
        this.n.b(false);
        return this;
    }

    public MenuItem setIconTintMode(Mode mode) {
        this.u = mode;
        this.w = true;
        this.x = true;
        this.n.b(false);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f670g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        if (this.f671h == c2) {
            return this;
        }
        this.f671h = c2;
        this.n.b(false);
        return this;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        this.C = onActionExpandListener;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.q = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.f671h = c2;
        this.f673j = Character.toLowerCase(c3);
        this.n.b(false);
        return this;
    }

    public void setShowAsAction(int i2) {
        int i3 = i2 & 3;
        if (i3 == 0 || i3 == 1 || i3 == 2) {
            this.z = i2;
            this.n.c(this);
            return;
        }
        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f668e = charSequence;
        this.n.b(false);
        D d2 = this.o;
        if (d2 != null) {
            d2.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f669f = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.f668e;
        }
        this.n.b(false);
        return this;
    }

    public MenuItem setVisible(boolean z2) {
        if (e(z2)) {
            this.n.d(this);
        }
        return this;
    }

    public String toString() {
        CharSequence charSequence = this.f668e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void a(D d2) {
        this.o = d2;
        d2.setHeaderTitle(getTitle());
    }

    public void c(boolean z2) {
        this.y = (z2 ? 4 : 0) | (this.y & -5);
    }

    public void d(boolean z2) {
        if (z2) {
            this.y |= 32;
        } else {
            this.y &= -33;
        }
    }

    public b setContentDescription(CharSequence charSequence) {
        this.r = charSequence;
        this.n.b(false);
        return this;
    }

    public b setShowAsActionFlags(int i2) {
        setShowAsAction(i2);
        return this;
    }

    public b setTooltipText(CharSequence charSequence) {
        this.s = charSequence;
        this.n.b(false);
        return this;
    }

    public b setActionView(View view) {
        this.A = view;
        this.B = null;
        if (view != null && view.getId() == -1) {
            int i2 = this.f664a;
            if (i2 > 0) {
                view.setId(i2);
            }
        }
        this.n.c(this);
        return this;
    }

    /* access modifiers changed from: 0000 */
    public CharSequence a(w.a aVar) {
        if (aVar == null || !aVar.a()) {
            return getTitle();
        }
        return getTitleCondensed();
    }

    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        if (this.f673j == c2 && this.f674k == i2) {
            return this;
        }
        this.f673j = Character.toLowerCase(c2);
        this.f674k = KeyEvent.normalizeMetaState(i2);
        this.n.b(false);
        return this;
    }

    public MenuItem setNumericShortcut(char c2, int i2) {
        if (this.f671h == c2 && this.f672i == i2) {
            return this;
        }
        this.f671h = c2;
        this.f672i = KeyEvent.normalizeMetaState(i2);
        this.n.b(false);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.f671h = c2;
        this.f672i = KeyEvent.normalizeMetaState(i2);
        this.f673j = Character.toLowerCase(c3);
        this.f674k = KeyEvent.normalizeMetaState(i3);
        this.n.b(false);
        return this;
    }

    public void b() {
        this.n.c(this);
    }

    public MenuItem setIcon(int i2) {
        this.f675l = null;
        this.m = i2;
        this.x = true;
        this.n.b(false);
        return this;
    }

    public MenuItem setTitle(int i2) {
        setTitle((CharSequence) this.n.e().getString(i2));
        return this;
    }

    private Drawable a(Drawable drawable) {
        if (drawable != null && this.x && (this.v || this.w)) {
            drawable = androidx.core.graphics.drawable.a.i(drawable).mutate();
            if (this.v) {
                androidx.core.graphics.drawable.a.a(drawable, this.t);
            }
            if (this.w) {
                androidx.core.graphics.drawable.a.a(drawable, this.u);
            }
            this.x = false;
        }
        return drawable;
    }

    public b setActionView(int i2) {
        Context e2 = this.n.e();
        setActionView(LayoutInflater.from(e2).inflate(i2, new LinearLayout(e2), false));
        return this;
    }

    /* access modifiers changed from: 0000 */
    public void a(ContextMenuInfo contextMenuInfo) {
        this.E = contextMenuInfo;
    }

    public C0241b a() {
        return this.B;
    }

    public b a(C0241b bVar) {
        C0241b bVar2 = this.B;
        if (bVar2 != null) {
            bVar2.f();
        }
        this.A = null;
        this.B = bVar;
        this.n.b(true);
        C0241b bVar3 = this.B;
        if (bVar3 != null) {
            bVar3.a((C0029b) new o(this));
        }
        return this;
    }

    public void a(boolean z2) {
        this.D = z2;
        this.n.b(false);
    }

    /* access modifiers changed from: 0000 */
    public boolean e(boolean z2) {
        int i2 = this.y;
        this.y = (z2 ? 0 : 8) | (i2 & -9);
        if (i2 != this.y) {
            return true;
        }
        return false;
    }
}
