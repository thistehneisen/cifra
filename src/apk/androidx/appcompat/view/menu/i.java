package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import androidx.appcompat.widget.T;
import androidx.appcompat.widget.U;
import b.a.d;
import b.a.g;
import b.g.i.B;
import b.g.i.C0243d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CascadingMenuPopup */
final class i extends s implements v, OnKeyListener, OnDismissListener {

    /* renamed from: b reason: collision with root package name */
    private static final int f616b = g.abc_cascading_menu_item_layout;
    private OnDismissListener A;
    boolean B;

    /* renamed from: c reason: collision with root package name */
    private final Context f617c;

    /* renamed from: d reason: collision with root package name */
    private final int f618d;

    /* renamed from: e reason: collision with root package name */
    private final int f619e;

    /* renamed from: f reason: collision with root package name */
    private final int f620f;

    /* renamed from: g reason: collision with root package name */
    private final boolean f621g;

    /* renamed from: h reason: collision with root package name */
    final Handler f622h;

    /* renamed from: i reason: collision with root package name */
    private final List<l> f623i = new ArrayList();

    /* renamed from: j reason: collision with root package name */
    final List<a> f624j = new ArrayList();

    /* renamed from: k reason: collision with root package name */
    final OnGlobalLayoutListener f625k = new C0152e(this);

    /* renamed from: l reason: collision with root package name */
    private final OnAttachStateChangeListener f626l = new f(this);
    private final T m = new h(this);
    private int n = 0;
    private int o = 0;
    private View p;
    View q;
    private int r;
    private boolean s;
    private boolean t;
    private int u;
    private int v;
    private boolean w;
    private boolean x;
    private androidx.appcompat.view.menu.v.a y;
    ViewTreeObserver z;

    /* compiled from: CascadingMenuPopup */
    private static class a {

        /* renamed from: a reason: collision with root package name */
        public final U f627a;

        /* renamed from: b reason: collision with root package name */
        public final l f628b;

        /* renamed from: c reason: collision with root package name */
        public final int f629c;

        public a(U u, l lVar, int i2) {
            this.f627a = u;
            this.f628b = lVar;
            this.f629c = i2;
        }

        public ListView a() {
            return this.f627a.d();
        }
    }

    public i(Context context, View view, int i2, int i3, boolean z2) {
        this.f617c = context;
        this.p = view;
        this.f619e = i2;
        this.f620f = i3;
        this.f621g = z2;
        this.w = false;
        this.r = h();
        Resources resources = context.getResources();
        this.f618d = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(d.abc_config_prefDialogWidth));
        this.f622h = new Handler();
    }

    private int d(int i2) {
        List<a> list = this.f624j;
        ListView a2 = ((a) list.get(list.size() - 1)).a();
        int[] iArr = new int[2];
        a2.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.q.getWindowVisibleDisplayFrame(rect);
        if (this.r == 1) {
            if (iArr[0] + a2.getWidth() + i2 > rect.right) {
                return 0;
            }
            return 1;
        } else if (iArr[0] - i2 < 0) {
            return 1;
        } else {
            return 0;
        }
    }

    private U g() {
        U u2 = new U(this.f617c, null, this.f619e, this.f620f);
        u2.a(this.m);
        u2.a((OnItemClickListener) this);
        u2.a((OnDismissListener) this);
        u2.a(this.p);
        u2.c(this.o);
        u2.a(true);
        u2.e(2);
        return u2;
    }

    private int h() {
        return B.m(this.p) == 1 ? 0 : 1;
    }

    public void a(l lVar) {
        lVar.a((v) this, this.f617c);
        if (c()) {
            d(lVar);
        } else {
            this.f623i.add(lVar);
        }
    }

    public boolean a() {
        return false;
    }

    public void b(boolean z2) {
        this.w = z2;
    }

    public boolean c() {
        return this.f624j.size() > 0 && ((a) this.f624j.get(0)).f627a.c();
    }

    public void dismiss() {
        int size = this.f624j.size();
        if (size > 0) {
            a[] aVarArr = (a[]) this.f624j.toArray(new a[size]);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                a aVar = aVarArr[i2];
                if (aVar.f627a.c()) {
                    aVar.f627a.dismiss();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean e() {
        return false;
    }

    public void onDismiss() {
        a aVar;
        int size = this.f624j.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                aVar = null;
                break;
            }
            aVar = (a) this.f624j.get(i2);
            if (!aVar.f627a.c()) {
                break;
            }
            i2++;
        }
        if (aVar != null) {
            aVar.f628b.a(false);
        }
    }

    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    private int c(l lVar) {
        int size = this.f624j.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (lVar == ((a) this.f624j.get(i2)).f628b) {
                return i2;
            }
        }
        return -1;
    }

    public void b() {
        if (!c()) {
            for (l d2 : this.f623i) {
                d(d2);
            }
            this.f623i.clear();
            this.q = this.p;
            if (this.q != null) {
                boolean z2 = this.z == null;
                this.z = this.q.getViewTreeObserver();
                if (z2) {
                    this.z.addOnGlobalLayoutListener(this.f625k);
                }
                this.q.addOnAttachStateChangeListener(this.f626l);
            }
        }
    }

    private MenuItem a(l lVar, l lVar2) {
        int size = lVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = lVar.getItem(i2);
            if (item.hasSubMenu() && lVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    public void c(int i2) {
        this.t = true;
        this.v = i2;
    }

    public void c(boolean z2) {
        this.x = z2;
    }

    private View a(a aVar, l lVar) {
        int i2;
        k kVar;
        MenuItem a2 = a(aVar.f628b, lVar);
        if (a2 == null) {
            return null;
        }
        ListView a3 = aVar.a();
        ListAdapter adapter = a3.getAdapter();
        int i3 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i2 = headerViewListAdapter.getHeadersCount();
            kVar = (k) headerViewListAdapter.getWrappedAdapter();
        } else {
            kVar = (k) adapter;
            i2 = 0;
        }
        int count = kVar.getCount();
        while (true) {
            if (i3 >= count) {
                i3 = -1;
                break;
            } else if (a2 == kVar.getItem(i3)) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 == -1) {
            return null;
        }
        int firstVisiblePosition = (i3 + i2) - a3.getFirstVisiblePosition();
        if (firstVisiblePosition < 0 || firstVisiblePosition >= a3.getChildCount()) {
            return null;
        }
        return a3.getChildAt(firstVisiblePosition);
    }

    private void d(l lVar) {
        View view;
        a aVar;
        int i2;
        int i3;
        int i4;
        LayoutInflater from = LayoutInflater.from(this.f617c);
        k kVar = new k(lVar, from, this.f621g, f616b);
        if (!c() && this.w) {
            kVar.a(true);
        } else if (c()) {
            kVar.a(s.b(lVar));
        }
        int a2 = s.a(kVar, null, this.f617c, this.f618d);
        U g2 = g();
        g2.a((ListAdapter) kVar);
        g2.b(a2);
        g2.c(this.o);
        if (this.f624j.size() > 0) {
            List<a> list = this.f624j;
            aVar = (a) list.get(list.size() - 1);
            view = a(aVar, lVar);
        } else {
            aVar = null;
            view = null;
        }
        if (view != null) {
            g2.c(false);
            g2.a((Object) null);
            int d2 = d(a2);
            boolean z2 = d2 == 1;
            this.r = d2;
            if (VERSION.SDK_INT >= 26) {
                g2.a(view);
                i3 = 0;
                i2 = 0;
            } else {
                int[] iArr = new int[2];
                this.p.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.o & 7) == 5) {
                    iArr[0] = iArr[0] + this.p.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i2 = iArr2[0] - iArr[0];
                i3 = iArr2[1] - iArr[1];
            }
            if ((this.o & 5) != 5) {
                if (z2) {
                    a2 = view.getWidth();
                }
                i4 = i2 - a2;
                g2.d(i4);
                g2.b(true);
                g2.h(i3);
            } else if (!z2) {
                a2 = view.getWidth();
                i4 = i2 - a2;
                g2.d(i4);
                g2.b(true);
                g2.h(i3);
            }
            i4 = i2 + a2;
            g2.d(i4);
            g2.b(true);
            g2.h(i3);
        } else {
            if (this.s) {
                g2.d(this.u);
            }
            if (this.t) {
                g2.h(this.v);
            }
            g2.a(f());
        }
        this.f624j.add(new a(g2, lVar, this.r));
        g2.b();
        ListView d3 = g2.d();
        d3.setOnKeyListener(this);
        if (aVar == null && this.x && lVar.h() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(g.abc_popup_menu_header_item_layout, d3, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            frameLayout.setEnabled(false);
            textView.setText(lVar.h());
            d3.addHeaderView(frameLayout, null, false);
            g2.b();
        }
    }

    public void b(int i2) {
        this.s = true;
        this.u = i2;
    }

    public void a(boolean z2) {
        for (a a2 : this.f624j) {
            s.a(a2.a().getAdapter()).notifyDataSetChanged();
        }
    }

    public void a(androidx.appcompat.view.menu.v.a aVar) {
        this.y = aVar;
    }

    public boolean a(D d2) {
        for (a aVar : this.f624j) {
            if (d2 == aVar.f628b) {
                aVar.a().requestFocus();
                return true;
            }
        }
        if (!d2.hasVisibleItems()) {
            return false;
        }
        a((l) d2);
        androidx.appcompat.view.menu.v.a aVar2 = this.y;
        if (aVar2 != null) {
            aVar2.a(d2);
        }
        return true;
    }

    public void a(l lVar, boolean z2) {
        int c2 = c(lVar);
        if (c2 >= 0) {
            int i2 = c2 + 1;
            if (i2 < this.f624j.size()) {
                ((a) this.f624j.get(i2)).f628b.a(false);
            }
            a aVar = (a) this.f624j.remove(c2);
            aVar.f628b.b((v) this);
            if (this.B) {
                aVar.f627a.b(null);
                aVar.f627a.a(0);
            }
            aVar.f627a.dismiss();
            int size = this.f624j.size();
            if (size > 0) {
                this.r = ((a) this.f624j.get(size - 1)).f629c;
            } else {
                this.r = h();
            }
            if (size == 0) {
                dismiss();
                androidx.appcompat.view.menu.v.a aVar2 = this.y;
                if (aVar2 != null) {
                    aVar2.a(lVar, true);
                }
                ViewTreeObserver viewTreeObserver = this.z;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.z.removeGlobalOnLayoutListener(this.f625k);
                    }
                    this.z = null;
                }
                this.q.removeOnAttachStateChangeListener(this.f626l);
                this.A.onDismiss();
            } else if (z2) {
                ((a) this.f624j.get(0)).f628b.a(false);
            }
        }
    }

    public void a(int i2) {
        if (this.n != i2) {
            this.n = i2;
            this.o = C0243d.a(i2, B.m(this.p));
        }
    }

    public void a(View view) {
        if (this.p != view) {
            this.p = view;
            this.o = C0243d.a(this.n, B.m(this.p));
        }
    }

    public ListView d() {
        if (this.f624j.isEmpty()) {
            return null;
        }
        List<a> list = this.f624j;
        return ((a) list.get(list.size() - 1)).a();
    }

    public void a(OnDismissListener onDismissListener) {
        this.A = onDismissListener;
    }
}
