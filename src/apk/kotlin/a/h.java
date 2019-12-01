package kotlin.a;

import java.util.Collections;
import java.util.List;

/* compiled from: CollectionsJVM.kt */
class h {
    public static <T> List<T> a(T t) {
        List<T> singletonList = Collections.singletonList(t);
        kotlin.e.b.h.a((Object) singletonList, "java.util.Collections.singletonList(element)");
        return singletonList;
    }
}
