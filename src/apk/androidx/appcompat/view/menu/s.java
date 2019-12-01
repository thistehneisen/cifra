package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;

/* compiled from: MenuPopup */
abstract class s implements z, v, OnItemClickListener {

    /* renamed from: a reason: collision with root package name */
    private Rect f684a;

    s() {
    }

    protected static boolean b(l lVar) {
        int size = lVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = lVar.getItem(i2);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    public abstract void a(int i2);

    public void a(Context context, l lVar) {
    }

    public void a(Rect rect) {
        this.f684a = rect;
    }

    public abstract void a(View view);

    public abstract void a(OnDismissListener onDismissListener);

    public abstract void a(l lVar);

    public boolean a(l lVar, p pVar) {
        return false;
    }

    public abstract void b(int i2);

    public abstract void b(boolean z);

    public boolean b(l lVar, p pVar) {
        return false;
    }

    public abstract void c(int i2);

    public abstract void c(boolean z);

    /* access modifiers changed from: protected */
    public boolean e() {
        return true;
    }

    public Rect f() {
        return this.f684a;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        a(listAdapter).f641a.a((MenuItem) listAdapter.getItem(i2), (v) this, e() ? 0 : 4);
    }

    protected static int a(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        ViewGroup viewGroup2 = viewGroup;
        View view = null;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < count; i5++) {
            int itemViewType = listAdapter.getItemViewType(i5);
            if (itemViewType != i4) {
                view = null;
                i4 = itemViewType;
            }
            if (viewGroup2 == null) {
                viewGroup2 = new FrameLayout(context);
            }
            view = listAdapter.getView(i5, view, viewGroup2);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i2) {
                return i2;
            }
            if (measuredWidth > i3) {
                i3 = measuredWidth;
            }
        }
        return i3;
    }

    protected static k a(ListAdapter listAdapter) {
        if (listAdapter instanceof HeaderViewListAdapter) {
            return (k) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        }
        return (k) listAdapter;
    }
}
