package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.v.a;
import java.util.ArrayList;

/* renamed from: androidx.appcompat.view.menu.b reason: case insensitive filesystem */
/* compiled from: BaseMenuPresenter */
public abstract class C0149b implements v {

    /* renamed from: a reason: collision with root package name */
    protected Context f595a;

    /* renamed from: b reason: collision with root package name */
    protected Context f596b;

    /* renamed from: c reason: collision with root package name */
    protected l f597c;

    /* renamed from: d reason: collision with root package name */
    protected LayoutInflater f598d;

    /* renamed from: e reason: collision with root package name */
    protected LayoutInflater f599e;

    /* renamed from: f reason: collision with root package name */
    private a f600f;

    /* renamed from: g reason: collision with root package name */
    private int f601g;

    /* renamed from: h reason: collision with root package name */
    private int f602h;

    /* renamed from: i reason: collision with root package name */
    protected w f603i;

    /* renamed from: j reason: collision with root package name */
    private int f604j;

    public C0149b(Context context, int i2, int i3) {
        this.f595a = context;
        this.f598d = LayoutInflater.from(context);
        this.f601g = i2;
        this.f602h = i3;
    }

    public void a(Context context, l lVar) {
        this.f596b = context;
        this.f599e = LayoutInflater.from(this.f596b);
        this.f597c = lVar;
    }

    public abstract void a(p pVar, w.a aVar);

    public abstract boolean a(int i2, p pVar);

    public boolean a(l lVar, p pVar) {
        return false;
    }

    public w b(ViewGroup viewGroup) {
        if (this.f603i == null) {
            this.f603i = (w) this.f598d.inflate(this.f601g, viewGroup, false);
            this.f603i.a(this.f597c);
            a(true);
        }
        return this.f603i;
    }

    public boolean b(l lVar, p pVar) {
        return false;
    }

    public void a(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f603i;
        if (viewGroup != null) {
            l lVar = this.f597c;
            int i2 = 0;
            if (lVar != null) {
                lVar.b();
                ArrayList n = this.f597c.n();
                int size = n.size();
                int i3 = 0;
                for (int i4 = 0; i4 < size; i4++) {
                    p pVar = (p) n.get(i4);
                    if (a(i3, pVar)) {
                        View childAt = viewGroup.getChildAt(i3);
                        p itemData = childAt instanceof w.a ? ((w.a) childAt).getItemData() : null;
                        View a2 = a(pVar, childAt, viewGroup);
                        if (pVar != itemData) {
                            a2.setPressed(false);
                            a2.jumpDrawablesToCurrentState();
                        }
                        if (a2 != childAt) {
                            a(a2, i3);
                        }
                        i3++;
                    }
                }
                i2 = i3;
            }
            while (i2 < viewGroup.getChildCount()) {
                if (!a(viewGroup, i2)) {
                    i2++;
                }
            }
        }
    }

    public a b() {
        return this.f600f;
    }

    /* access modifiers changed from: protected */
    public void a(View view, int i2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f603i).addView(view, i2);
    }

    /* access modifiers changed from: protected */
    public boolean a(ViewGroup viewGroup, int i2) {
        viewGroup.removeViewAt(i2);
        return true;
    }

    public void a(a aVar) {
        this.f600f = aVar;
    }

    public w.a a(ViewGroup viewGroup) {
        return (w.a) this.f598d.inflate(this.f602h, viewGroup, false);
    }

    public View a(p pVar, View view, ViewGroup viewGroup) {
        w.a aVar;
        if (view instanceof w.a) {
            aVar = (w.a) view;
        } else {
            aVar = a(viewGroup);
        }
        a(pVar, aVar);
        return (View) aVar;
    }

    public void a(l lVar, boolean z) {
        a aVar = this.f600f;
        if (aVar != null) {
            aVar.a(lVar, z);
        }
    }

    public boolean a(D d2) {
        a aVar = this.f600f;
        if (aVar != null) {
            return aVar.a(d2);
        }
        return false;
    }

    public void a(int i2) {
        this.f604j = i2;
    }
}
