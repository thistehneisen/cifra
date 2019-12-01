package b.g.i;

import android.os.Build.VERSION;
import android.view.ViewGroup;
import b.g.c;

/* compiled from: ViewGroupCompat */
public final class D {
    public static boolean a(ViewGroup viewGroup) {
        if (VERSION.SDK_INT >= 21) {
            return viewGroup.isTransitionGroup();
        }
        Boolean bool = (Boolean) viewGroup.getTag(c.tag_transition_group);
        return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && B.r(viewGroup) == null) ? false : true;
    }
}
