package androidx.appcompat.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import androidx.appcompat.view.menu.l.b;
import androidx.appcompat.widget.sa;

public final class ExpandedMenuView extends ListView implements b, w, OnItemClickListener {

    /* renamed from: a reason: collision with root package name */
    private static final int[] f568a = {16842964, 16843049};

    /* renamed from: b reason: collision with root package name */
    private l f569b;

    /* renamed from: c reason: collision with root package name */
    private int f570c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public void a(l lVar) {
        this.f569b = lVar;
    }

    public int getWindowAnimations() {
        return this.f570c;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        a((p) getAdapter().getItem(i2));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        sa a2 = sa.a(context, attributeSet, f568a, i2, 0);
        if (a2.g(0)) {
            setBackgroundDrawable(a2.b(0));
        }
        if (a2.g(1)) {
            setDivider(a2.b(1));
        }
        a2.a();
    }

    public boolean a(p pVar) {
        return this.f569b.a((MenuItem) pVar, 0);
    }
}
