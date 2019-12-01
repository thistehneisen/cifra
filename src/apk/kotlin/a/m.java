package kotlin.a;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.e.b.h;

/* compiled from: MutableCollectionsJVM.kt */
class m extends l {
    public static final <T> void a(List<T> list, Comparator<? super T> comparator) {
        h.b(list, "$this$sortWith");
        h.b(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
