package kotlin.a;

import java.util.List;
import kotlin.e.b.h;

/* compiled from: Collections.kt */
class i extends h {
    public static <T> List<T> a() {
        return s.f10294a;
    }

    public static final <T> List<T> b(List<? extends T> list) {
        h.b(list, "$this$optimizeReadOnlyList");
        int size = list.size();
        if (size == 0) {
            return a();
        }
        if (size != 1) {
            return list;
        }
        return h.a(list.get(0));
    }

    public static final <T> int a(List<? extends T> list) {
        h.b(list, "$this$lastIndex");
        return list.size() - 1;
    }
}
