package b.g.i;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.e.b.h;
import kotlin.h.c;

/* compiled from: ViewGroup.kt */
public final class G {
    public static final c<View> a(ViewGroup viewGroup) {
        h.b(viewGroup, "$receiver");
        return new E(viewGroup);
    }

    public static final Iterator<View> b(ViewGroup viewGroup) {
        h.b(viewGroup, "$receiver");
        return new F(viewGroup);
    }
}
