package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import androidx.core.graphics.drawable.a;
import b.g.d.a.b;
import b.g.i.C0241b;

/* renamed from: androidx.appcompat.view.menu.a reason: case insensitive filesystem */
/* compiled from: ActionMenuItem */
public class C0148a implements b {

    /* renamed from: a reason: collision with root package name */
    private final int f583a;

    /* renamed from: b reason: collision with root package name */
    private final int f584b;

    /* renamed from: c reason: collision with root package name */
    private final int f585c;

    /* renamed from: d reason: collision with root package name */
    private final int f586d;

    /* renamed from: e reason: collision with root package name */
    private CharSequence f587e;

    /* renamed from: f reason: collision with root package name */
    private CharSequence f588f;

    /* renamed from: g reason: collision with root package name */
    private Intent f589g;

    /* renamed from: h reason: collision with root package name */
    private char f590h;

    /* renamed from: i reason: collision with root package name */
    private int f591i = CodedOutputStream.DEFAULT_BUFFER_SIZE;

    /* renamed from: j reason: collision with root package name */
    private char f592j;

    /* renamed from: k reason: collision with root package name */
    private int f593k = CodedOutputStream.DEFAULT_BUFFER_SIZE;

    /* renamed from: l reason: collision with root package name */
    private Drawable f594l;
    private int m = 0;
    private Context n;
    private OnMenuItemClickListener o;
    private CharSequence p;
    private CharSequence q;
    private ColorStateList r = null;
    private Mode s = null;
    private boolean t = false;
    private boolean u = false;
    private int v = 16;

    public C0148a(Context context, int i2, int i3, int i4, int i5, CharSequence charSequence) {
        this.n = context;
        this.f583a = i3;
        this.f584b = i2;
        this.f585c = i4;
        this.f586d = i5;
        this.f587e = charSequence;
    }

    private void b() {
        if (this.f594l == null) {
            return;
        }
        if (this.t || this.u) {
            this.f594l = a.i(this.f594l);
            this.f594l = this.f594l.mutate();
            if (this.t) {
                a.a(this.f594l, this.r);
            }
            if (this.u) {
                a.a(this.f594l, this.s);
            }
        }
    }

    public b a(C0241b bVar) {
        throw new UnsupportedOperationException();
    }

    public C0241b a() {
        return null;
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean expandActionView() {
        return false;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public int getAlphabeticModifiers() {
        return this.f593k;
    }

    public char getAlphabeticShortcut() {
        return this.f592j;
    }

    public CharSequence getContentDescription() {
        return this.p;
    }

    public int getGroupId() {
        return this.f584b;
    }

    public Drawable getIcon() {
        return this.f594l;
    }

    public ColorStateList getIconTintList() {
        return this.r;
    }

    public Mode getIconTintMode() {
        return this.s;
    }

    public Intent getIntent() {
        return this.f589g;
    }

    public int getItemId() {
        return this.f583a;
    }

    public ContextMenuInfo getMenuInfo() {
        return null;
    }

    public int getNumericModifiers() {
        return this.f591i;
    }

    public char getNumericShortcut() {
        return this.f590h;
    }

    public int getOrder() {
        return this.f586d;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f587e;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f588f;
        return charSequence != null ? charSequence : this.f587e;
    }

    public CharSequence getTooltipText() {
        return this.q;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        return (this.v & 1) != 0;
    }

    public boolean isChecked() {
        return (this.v & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.v & 16) != 0;
    }

    public boolean isVisible() {
        return (this.v & 8) == 0;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        this.f592j = Character.toLowerCase(c2);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.v = z | (this.v & true) ? 1 : 0;
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.v = (z ? 2 : 0) | (this.v & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.v = (z ? 16 : 0) | (this.v & -17);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f594l = drawable;
        this.m = 0;
        b();
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.r = colorStateList;
        this.t = true;
        b();
        return this;
    }

    public MenuItem setIconTintMode(Mode mode) {
        this.s = mode;
        this.u = true;
        b();
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f589g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        this.f590h = c2;
        return this;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.o = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.f590h = c2;
        this.f592j = Character.toLowerCase(c3);
        return this;
    }

    public void setShowAsAction(int i2) {
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f587e = charSequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f588f = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        int i2 = 8;
        int i3 = this.v & 8;
        if (z) {
            i2 = 0;
        }
        this.v = i3 | i2;
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        this.f592j = Character.toLowerCase(c2);
        this.f593k = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    public b setContentDescription(CharSequence charSequence) {
        this.p = charSequence;
        return this;
    }

    public MenuItem setNumericShortcut(char c2, int i2) {
        this.f590h = c2;
        this.f591i = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    public b setShowAsActionFlags(int i2) {
        setShowAsAction(i2);
        return this;
    }

    public MenuItem setTitle(int i2) {
        this.f587e = this.n.getResources().getString(i2);
        return this;
    }

    public b setTooltipText(CharSequence charSequence) {
        this.q = charSequence;
        return this;
    }

    public b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.f590h = c2;
        this.f591i = KeyEvent.normalizeMetaState(i2);
        this.f592j = Character.toLowerCase(c3);
        this.f593k = KeyEvent.normalizeMetaState(i3);
        return this;
    }

    public b setActionView(int i2) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setIcon(int i2) {
        this.m = i2;
        this.f594l = b.g.a.a.c(this.n, i2);
        b();
        return this;
    }
}
