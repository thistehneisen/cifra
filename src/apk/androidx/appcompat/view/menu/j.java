package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.IBinder;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import b.a.g;
import java.util.ArrayList;

/* compiled from: ListMenuPresenter */
public class j implements v, OnItemClickListener {

    /* renamed from: a reason: collision with root package name */
    Context f630a;

    /* renamed from: b reason: collision with root package name */
    LayoutInflater f631b;

    /* renamed from: c reason: collision with root package name */
    l f632c;

    /* renamed from: d reason: collision with root package name */
    ExpandedMenuView f633d;

    /* renamed from: e reason: collision with root package name */
    int f634e;

    /* renamed from: f reason: collision with root package name */
    int f635f;

    /* renamed from: g reason: collision with root package name */
    int f636g;

    /* renamed from: h reason: collision with root package name */
    private androidx.appcompat.view.menu.v.a f637h;

    /* renamed from: i reason: collision with root package name */
    a f638i;

    /* compiled from: ListMenuPresenter */
    private class a extends BaseAdapter {

        /* renamed from: a reason: collision with root package name */
        private int f639a = -1;

        public a() {
            a();
        }

        /* access modifiers changed from: 0000 */
        public void a() {
            p f2 = j.this.f632c.f();
            if (f2 != null) {
                ArrayList j2 = j.this.f632c.j();
                int size = j2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (((p) j2.get(i2)) == f2) {
                        this.f639a = i2;
                        return;
                    }
                }
            }
            this.f639a = -1;
        }

        public int getCount() {
            int size = j.this.f632c.j().size() - j.this.f634e;
            return this.f639a < 0 ? size : size - 1;
        }

        public long getItemId(int i2) {
            return (long) i2;
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                j jVar = j.this;
                view = jVar.f631b.inflate(jVar.f636g, viewGroup, false);
            }
            ((androidx.appcompat.view.menu.w.a) view).a(getItem(i2), 0);
            return view;
        }

        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }

        public p getItem(int i2) {
            ArrayList j2 = j.this.f632c.j();
            int i3 = i2 + j.this.f634e;
            int i4 = this.f639a;
            if (i4 >= 0 && i3 >= i4) {
                i3++;
            }
            return (p) j2.get(i3);
        }
    }

    public j(Context context, int i2) {
        this(i2, 0);
        this.f630a = context;
        this.f631b = LayoutInflater.from(this.f630a);
    }

    public void a(Context context, l lVar) {
        int i2 = this.f635f;
        if (i2 != 0) {
            this.f630a = new ContextThemeWrapper(context, i2);
            this.f631b = LayoutInflater.from(this.f630a);
        } else if (this.f630a != null) {
            this.f630a = context;
            if (this.f631b == null) {
                this.f631b = LayoutInflater.from(this.f630a);
            }
        }
        this.f632c = lVar;
        a aVar = this.f638i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public boolean a() {
        return false;
    }

    public boolean a(l lVar, p pVar) {
        return false;
    }

    public ListAdapter b() {
        if (this.f638i == null) {
            this.f638i = new a();
        }
        return this.f638i;
    }

    public boolean b(l lVar, p pVar) {
        return false;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.f632c.a((MenuItem) this.f638i.getItem(i2), (v) this, 0);
    }

    public j(int i2, int i3) {
        this.f636g = i2;
        this.f635f = i3;
    }

    public w a(ViewGroup viewGroup) {
        if (this.f633d == null) {
            this.f633d = (ExpandedMenuView) this.f631b.inflate(g.abc_expanded_menu_layout, viewGroup, false);
            if (this.f638i == null) {
                this.f638i = new a();
            }
            this.f633d.setAdapter(this.f638i);
            this.f633d.setOnItemClickListener(this);
        }
        return this.f633d;
    }

    public void a(boolean z) {
        a aVar = this.f638i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public void a(androidx.appcompat.view.menu.v.a aVar) {
        this.f637h = aVar;
    }

    public boolean a(D d2) {
        if (!d2.hasVisibleItems()) {
            return false;
        }
        new m(d2).a((IBinder) null);
        androidx.appcompat.view.menu.v.a aVar = this.f637h;
        if (aVar != null) {
            aVar.a(d2);
        }
        return true;
    }

    public void a(l lVar, boolean z) {
        androidx.appcompat.view.menu.v.a aVar = this.f637h;
        if (aVar != null) {
            aVar.a(lVar, z);
        }
    }
}
