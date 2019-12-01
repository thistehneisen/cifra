package b.p;

import android.view.View;
import android.view.WindowId;

/* compiled from: WindowIdApi18 */
class ja implements ka {

    /* renamed from: a reason: collision with root package name */
    private final WindowId f2900a;

    ja(View view) {
        this.f2900a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof ja) && ((ja) obj).f2900a.equals(this.f2900a);
    }

    public int hashCode() {
        return this.f2900a.hashCode();
    }
}
