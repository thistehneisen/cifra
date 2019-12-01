package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.C0149b;
import androidx.appcompat.view.menu.D;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.u;
import androidx.appcompat.view.menu.w;
import androidx.appcompat.view.menu.z;
import b.a.g;
import b.g.i.C0241b;
import java.util.ArrayList;

/* renamed from: androidx.appcompat.widget.g reason: case insensitive filesystem */
/* compiled from: ActionMenuPresenter */
class C0165g extends C0149b implements b.g.i.C0241b.a {
    a A;
    c B;
    private b C;
    final f D = new f();
    int E;

    /* renamed from: k reason: collision with root package name */
    d f961k;

    /* renamed from: l reason: collision with root package name */
    private Drawable f962l;
    private boolean m;
    private boolean n;
    private boolean o;
    private int p;
    private int q;
    private int r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private int w;
    private final SparseBooleanArray x = new SparseBooleanArray();
    private View y;
    e z;

    /* renamed from: androidx.appcompat.widget.g$a */
    /* compiled from: ActionMenuPresenter */
    private class a extends u {
        public a(Context context, D d2, View view) {
            super(context, d2, view, false, b.a.a.actionOverflowMenuStyle);
            if (!((p) d2.getItem()).h()) {
                View view2 = C0165g.this.f961k;
                if (view2 == null) {
                    view2 = (View) C0165g.this.f603i;
                }
                a(view2);
            }
            a((androidx.appcompat.view.menu.v.a) C0165g.this.D);
        }

        /* access modifiers changed from: protected */
        public void d() {
            C0165g gVar = C0165g.this;
            gVar.A = null;
            gVar.E = 0;
            super.d();
        }
    }

    /* renamed from: androidx.appcompat.widget.g$b */
    /* compiled from: ActionMenuPresenter */
    private class b extends androidx.appcompat.view.menu.ActionMenuItemView.b {
        b() {
        }

        public z a() {
            a aVar = C0165g.this.A;
            if (aVar != null) {
                return aVar.b();
            }
            return null;
        }
    }

    /* renamed from: androidx.appcompat.widget.g$c */
    /* compiled from: ActionMenuPresenter */
    private class c implements Runnable {

        /* renamed from: a reason: collision with root package name */
        private e f964a;

        public c(e eVar) {
            this.f964a = eVar;
        }

        public void run() {
            if (C0165g.this.f597c != null) {
                C0165g.this.f597c.a();
            }
            View view = (View) C0165g.this.f603i;
            if (!(view == null || view.getWindowToken() == null || !this.f964a.f())) {
                C0165g.this.z = this.f964a;
            }
            C0165g.this.B = null;
        }
    }

    /* renamed from: androidx.appcompat.widget.g$d */
    /* compiled from: ActionMenuPresenter */
    private class d extends AppCompatImageView implements androidx.appcompat.widget.ActionMenuView.a {

        /* renamed from: a reason: collision with root package name */
        private final float[] f966a = new float[2];

        public d(Context context) {
            super(context, null, b.a.a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            Aa.a(this, getContentDescription());
            setOnTouchListener(new C0167h(this, this, C0165g.this));
        }

        public boolean b() {
            return false;
        }

        public boolean c() {
            return false;
        }

        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            C0165g.this.i();
            return true;
        }

        /* access modifiers changed from: protected */
        public boolean setFrame(int i2, int i3, int i4, int i5) {
            boolean frame = super.setFrame(i2, i3, i4, i5);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                androidx.core.graphics.drawable.a.a(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* renamed from: androidx.appcompat.widget.g$e */
    /* compiled from: ActionMenuPresenter */
    private class e extends u {
        public e(Context context, l lVar, View view, boolean z) {
            super(context, lVar, view, z, b.a.a.actionOverflowMenuStyle);
            a(8388613);
            a((androidx.appcompat.view.menu.v.a) C0165g.this.D);
        }

        /* access modifiers changed from: protected */
        public void d() {
            if (C0165g.this.f597c != null) {
                C0165g.this.f597c.close();
            }
            C0165g.this.z = null;
            super.d();
        }
    }

    /* renamed from: androidx.appcompat.widget.g$f */
    /* compiled from: ActionMenuPresenter */
    private class f implements androidx.appcompat.view.menu.v.a {
        f() {
        }

        public boolean a(l lVar) {
            boolean z = false;
            if (lVar == null) {
                return false;
            }
            C0165g.this.E = ((D) lVar).getItem().getItemId();
            androidx.appcompat.view.menu.v.a b2 = C0165g.this.b();
            if (b2 != null) {
                z = b2.a(lVar);
            }
            return z;
        }

        public void a(l lVar, boolean z) {
            if (lVar instanceof D) {
                lVar.m().a(false);
            }
            androidx.appcompat.view.menu.v.a b2 = C0165g.this.b();
            if (b2 != null) {
                b2.a(lVar, z);
            }
        }
    }

    public C0165g(Context context) {
        super(context, g.abc_action_menu_layout, g.abc_action_menu_item_layout);
    }

    public boolean g() {
        return this.B != null || h();
    }

    public boolean h() {
        e eVar = this.z;
        return eVar != null && eVar.c();
    }

    public boolean i() {
        if (this.n && !h()) {
            l lVar = this.f597c;
            if (lVar != null && this.f603i != null && this.B == null && !lVar.j().isEmpty()) {
                e eVar = new e(this.f596b, this.f597c, this.f961k, true);
                this.B = new c(eVar);
                ((View) this.f603i).post(this.B);
                super.a((D) null);
                return true;
            }
        }
        return false;
    }

    public void a(Context context, l lVar) {
        super.a(context, lVar);
        Resources resources = context.getResources();
        b.a.d.a a2 = b.a.d.a.a(context);
        if (!this.o) {
            this.n = a2.g();
        }
        if (!this.u) {
            this.p = a2.b();
        }
        if (!this.s) {
            this.r = a2.c();
        }
        int i2 = this.p;
        if (this.n) {
            if (this.f961k == null) {
                this.f961k = new d(this.f595a);
                if (this.m) {
                    this.f961k.setImageDrawable(this.f962l);
                    this.f962l = null;
                    this.m = false;
                }
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.f961k.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i2 -= this.f961k.getMeasuredWidth();
        } else {
            this.f961k = null;
        }
        this.q = i2;
        this.w = (int) (resources.getDisplayMetrics().density * 56.0f);
        this.y = null;
    }

    public void b(boolean z2) {
        this.v = z2;
    }

    public void c(boolean z2) {
        this.n = z2;
        this.o = true;
    }

    public Drawable d() {
        d dVar = this.f961k;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.m) {
            return this.f962l;
        }
        return null;
    }

    public boolean e() {
        c cVar = this.B;
        if (cVar != null) {
            w wVar = this.f603i;
            if (wVar != null) {
                ((View) wVar).removeCallbacks(cVar);
                this.B = null;
                return true;
            }
        }
        e eVar = this.z;
        if (eVar == null) {
            return false;
        }
        eVar.a();
        return true;
    }

    public boolean f() {
        a aVar = this.A;
        if (aVar == null) {
            return false;
        }
        aVar.a();
        return true;
    }

    public w b(ViewGroup viewGroup) {
        w wVar = this.f603i;
        w b2 = super.b(viewGroup);
        if (wVar != b2) {
            ((ActionMenuView) b2).setPresenter(this);
        }
        return b2;
    }

    public boolean c() {
        return e() | f();
    }

    public void a(Configuration configuration) {
        if (!this.s) {
            this.r = b.a.d.a.a(this.f596b).c();
        }
        l lVar = this.f597c;
        if (lVar != null) {
            lVar.b(true);
        }
    }

    public void a(Drawable drawable) {
        d dVar = this.f961k;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
            return;
        }
        this.m = true;
        this.f962l = drawable;
    }

    public View a(p pVar, View view, ViewGroup viewGroup) {
        View actionView = pVar.getActionView();
        if (actionView == null || pVar.f()) {
            actionView = super.a(pVar, view, viewGroup);
        }
        actionView.setVisibility(pVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    public void a(p pVar, androidx.appcompat.view.menu.w.a aVar) {
        aVar.a(pVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f603i);
        if (this.C == null) {
            this.C = new b();
        }
        actionMenuItemView.setPopupCallback(this.C);
    }

    public boolean a(int i2, p pVar) {
        return pVar.h();
    }

    public void a(boolean z2) {
        super.a(z2);
        ((View) this.f603i).requestLayout();
        l lVar = this.f597c;
        boolean z3 = false;
        if (lVar != null) {
            ArrayList c2 = lVar.c();
            int size = c2.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0241b a2 = ((p) c2.get(i2)).a();
                if (a2 != null) {
                    a2.a((b.g.i.C0241b.a) this);
                }
            }
        }
        l lVar2 = this.f597c;
        ArrayList j2 = lVar2 != null ? lVar2.j() : null;
        if (this.n && j2 != null) {
            int size2 = j2.size();
            if (size2 == 1) {
                z3 = !((p) j2.get(0)).isActionViewExpanded();
            } else if (size2 > 0) {
                z3 = true;
            }
        }
        if (z3) {
            if (this.f961k == null) {
                this.f961k = new d(this.f595a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f961k.getParent();
            if (viewGroup != this.f603i) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f961k);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f603i;
                actionMenuView.addView(this.f961k, actionMenuView.c());
            }
        } else {
            d dVar = this.f961k;
            if (dVar != null) {
                ViewParent parent = dVar.getParent();
                w wVar = this.f603i;
                if (parent == wVar) {
                    ((ViewGroup) wVar).removeView(this.f961k);
                }
            }
        }
        ((ActionMenuView) this.f603i).setOverflowReserved(this.n);
    }

    public boolean a(ViewGroup viewGroup, int i2) {
        if (viewGroup.getChildAt(i2) == this.f961k) {
            return false;
        }
        return super.a(viewGroup, i2);
    }

    public boolean a(D d2) {
        boolean z2 = false;
        if (!d2.hasVisibleItems()) {
            return false;
        }
        D d3 = d2;
        while (d3.t() != this.f597c) {
            d3 = (D) d3.t();
        }
        View a2 = a(d3.getItem());
        if (a2 == null) {
            return false;
        }
        this.E = d2.getItem().getItemId();
        int size = d2.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            MenuItem item = d2.getItem(i2);
            if (item.isVisible() && item.getIcon() != null) {
                z2 = true;
                break;
            }
            i2++;
        }
        this.A = new a(this.f596b, d2, a2);
        this.A.a(z2);
        this.A.e();
        super.a(d2);
        return true;
    }

    private View a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f603i;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof androidx.appcompat.view.menu.w.a) && ((androidx.appcompat.view.menu.w.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean a() {
        int i2;
        ArrayList arrayList;
        int i3;
        int i4;
        int i5;
        boolean z2;
        C0165g gVar = this;
        l lVar = gVar.f597c;
        int i6 = 0;
        if (lVar != null) {
            arrayList = lVar.n();
            i2 = arrayList.size();
        } else {
            arrayList = null;
            i2 = 0;
        }
        int i7 = gVar.r;
        int i8 = gVar.q;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) gVar.f603i;
        int i9 = i7;
        boolean z3 = false;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < i2; i12++) {
            p pVar = (p) arrayList.get(i12);
            if (pVar.k()) {
                i10++;
            } else if (pVar.j()) {
                i11++;
            } else {
                z3 = true;
            }
            if (gVar.v && pVar.isActionViewExpanded()) {
                i9 = 0;
            }
        }
        if (gVar.n && (z3 || i11 + i10 > i9)) {
            i9--;
        }
        int i13 = i9 - i10;
        SparseBooleanArray sparseBooleanArray = gVar.x;
        sparseBooleanArray.clear();
        if (gVar.t) {
            int i14 = gVar.w;
            i3 = i8 / i14;
            i4 = i14 + ((i8 % i14) / i3);
        } else {
            i4 = 0;
            i3 = 0;
        }
        int i15 = i8;
        int i16 = 0;
        int i17 = 0;
        while (i16 < i2) {
            p pVar2 = (p) arrayList.get(i16);
            if (pVar2.k()) {
                View a2 = gVar.a(pVar2, gVar.y, viewGroup);
                if (gVar.y == null) {
                    gVar.y = a2;
                }
                if (gVar.t) {
                    i3 -= ActionMenuView.a(a2, i4, i3, makeMeasureSpec, i6);
                } else {
                    a2.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = a2.getMeasuredWidth();
                i15 -= measuredWidth;
                if (i17 != 0) {
                    measuredWidth = i17;
                }
                int groupId = pVar2.getGroupId();
                if (groupId != 0) {
                    z2 = true;
                    sparseBooleanArray.put(groupId, true);
                } else {
                    z2 = true;
                }
                pVar2.d(z2);
                i5 = i2;
                i17 = measuredWidth;
            } else if (pVar2.j()) {
                int groupId2 = pVar2.getGroupId();
                boolean z4 = sparseBooleanArray.get(groupId2);
                boolean z5 = (i13 > 0 || z4) && i15 > 0 && (!gVar.t || i3 > 0);
                if (z5) {
                    boolean z6 = z5;
                    View a3 = gVar.a(pVar2, gVar.y, viewGroup);
                    i5 = i2;
                    if (gVar.y == null) {
                        gVar.y = a3;
                    }
                    if (gVar.t) {
                        int a4 = ActionMenuView.a(a3, i4, i3, makeMeasureSpec, 0);
                        i3 -= a4;
                        if (a4 == 0) {
                            z6 = false;
                        }
                    } else {
                        a3.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    int measuredWidth2 = a3.getMeasuredWidth();
                    i15 -= measuredWidth2;
                    if (i17 == 0) {
                        i17 = measuredWidth2;
                    }
                    z5 = z6 & (!gVar.t ? i15 + i17 > 0 : i15 >= 0);
                } else {
                    boolean z7 = z5;
                    i5 = i2;
                }
                if (z5 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z4) {
                    sparseBooleanArray.put(groupId2, false);
                    int i18 = 0;
                    while (i18 < i16) {
                        p pVar3 = (p) arrayList.get(i18);
                        if (pVar3.getGroupId() == groupId2) {
                            if (pVar3.h()) {
                                i13++;
                            }
                            pVar3.d(false);
                        }
                        i18++;
                    }
                }
                if (z5) {
                    i13--;
                }
                pVar2.d(z5);
            } else {
                i5 = i2;
                pVar2.d(false);
                i16++;
                i6 = 0;
                gVar = this;
                i2 = i5;
            }
            i16++;
            i6 = 0;
            gVar = this;
            i2 = i5;
        }
        return true;
    }

    public void a(l lVar, boolean z2) {
        c();
        super.a(lVar, z2);
    }

    public void a(ActionMenuView actionMenuView) {
        this.f603i = actionMenuView;
        actionMenuView.a(this.f597c);
    }
}
