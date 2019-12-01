package kotlin.a;

import java.util.Collection;
import kotlin.e.b.h;

/* compiled from: Iterables.kt */
class j extends i {
    public static <T> int a(Iterable<? extends T> iterable, int i2) {
        h.b(iterable, "$this$collectionSizeOrDefault");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i2;
    }
}
