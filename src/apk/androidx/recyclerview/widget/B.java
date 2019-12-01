package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.p;
import androidx.recyclerview.widget.RecyclerView.u;

/* compiled from: LayoutState */
class B {

    /* renamed from: a reason: collision with root package name */
    boolean f1681a = true;

    /* renamed from: b reason: collision with root package name */
    int f1682b;

    /* renamed from: c reason: collision with root package name */
    int f1683c;

    /* renamed from: d reason: collision with root package name */
    int f1684d;

    /* renamed from: e reason: collision with root package name */
    int f1685e;

    /* renamed from: f reason: collision with root package name */
    int f1686f = 0;

    /* renamed from: g reason: collision with root package name */
    int f1687g = 0;

    /* renamed from: h reason: collision with root package name */
    boolean f1688h;

    /* renamed from: i reason: collision with root package name */
    boolean f1689i;

    B() {
    }

    /* access modifiers changed from: 0000 */
    public boolean a(u uVar) {
        int i2 = this.f1683c;
        return i2 >= 0 && i2 < uVar.a();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LayoutState{mAvailable=");
        sb.append(this.f1682b);
        sb.append(", mCurrentPosition=");
        sb.append(this.f1683c);
        sb.append(", mItemDirection=");
        sb.append(this.f1684d);
        sb.append(", mLayoutDirection=");
        sb.append(this.f1685e);
        sb.append(", mStartLine=");
        sb.append(this.f1686f);
        sb.append(", mEndLine=");
        sb.append(this.f1687g);
        sb.append('}');
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    public View a(p pVar) {
        View d2 = pVar.d(this.f1683c);
        this.f1683c += this.f1684d;
        return d2;
    }
}
