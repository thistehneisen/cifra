package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.w.a;
import java.util.ArrayList;

/* compiled from: MenuAdapter */
public class k extends BaseAdapter {

    /* renamed from: a reason: collision with root package name */
    l f641a;

    /* renamed from: b reason: collision with root package name */
    private int f642b = -1;

    /* renamed from: c reason: collision with root package name */
    private boolean f643c;

    /* renamed from: d reason: collision with root package name */
    private final boolean f644d;

    /* renamed from: e reason: collision with root package name */
    private final LayoutInflater f645e;

    /* renamed from: f reason: collision with root package name */
    private final int f646f;

    public k(l lVar, LayoutInflater layoutInflater, boolean z, int i2) {
        this.f644d = z;
        this.f645e = layoutInflater;
        this.f641a = lVar;
        this.f646f = i2;
        a();
    }

    public void a(boolean z) {
        this.f643c = z;
    }

    public l b() {
        return this.f641a;
    }

    public int getCount() {
        ArrayList j2 = this.f644d ? this.f641a.j() : this.f641a.n();
        if (this.f642b < 0) {
            return j2.size();
        }
        return j2.size() - 1;
    }

    public long getItemId(int i2) {
        return (long) i2;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f645e.inflate(this.f646f, viewGroup, false);
        }
        int groupId = getItem(i2).getGroupId();
        int i3 = i2 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f641a.o() && groupId != (i3 >= 0 ? getItem(i3).getGroupId() : groupId));
        a aVar = (a) view;
        if (this.f643c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.a(getItem(i2), 0);
        return view;
    }

    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }

    /* access modifiers changed from: 0000 */
    public void a() {
        p f2 = this.f641a.f();
        if (f2 != null) {
            ArrayList j2 = this.f641a.j();
            int size = j2.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (((p) j2.get(i2)) == f2) {
                    this.f642b = i2;
                    return;
                }
            }
        }
        this.f642b = -1;
    }

    public p getItem(int i2) {
        ArrayList j2 = this.f644d ? this.f641a.j() : this.f641a.n();
        int i3 = this.f642b;
        if (i3 >= 0 && i2 >= i3) {
            i2++;
        }
        return (p) j2.get(i2);
    }
}
