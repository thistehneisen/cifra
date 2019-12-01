package b.g.i;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.h.c;

/* compiled from: ViewGroup.kt */
public final class E implements c<View> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ ViewGroup f2646a;

    E(ViewGroup viewGroup) {
        this.f2646a = viewGroup;
    }

    public Iterator<View> iterator() {
        return G.b(this.f2646a);
    }
}
