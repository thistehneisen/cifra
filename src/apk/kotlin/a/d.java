package kotlin.a;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import kotlin.e.b.h;

/* compiled from: _ArraysJvm.kt */
class d extends c {
    public static <T> List<T> a(T[] tArr) {
        h.b(tArr, "$this$asList");
        List<T> a2 = f.a(tArr);
        h.a((Object) a2, "ArraysUtilJVM.asList(this)");
        return a2;
    }

    public static final <T> void a(T[] tArr, Comparator<? super T> comparator) {
        h.b(tArr, "$this$sortWith");
        h.b(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }
}
