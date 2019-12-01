package kotlin.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.TypeCastException;
import kotlin.e.b.h;

/* compiled from: _Collections.kt */
class q extends p {
    public static <T> T a(List<? extends T> list, int i2) {
        h.b(list, "$this$getOrNull");
        if (i2 < 0 || i2 > i.a(list)) {
            return null;
        }
        return list.get(i2);
    }

    public static <T> T b(Iterable<? extends T> iterable) {
        h.b(iterable, "$this$single");
        if (iterable instanceof List) {
            return e((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            if (!it.hasNext()) {
                return next;
            }
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> List<T> c(Iterable<? extends T> iterable) {
        List<T> list;
        h.b(iterable, "$this$toList");
        if (!(iterable instanceof Collection)) {
            return i.b(d(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            list = i.a();
        } else if (size != 1) {
            list = a(collection);
        } else {
            list = h.a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
        }
        return list;
    }

    public static <T> T d(List<? extends T> list) {
        h.b(list, "$this$first");
        if (!list.isEmpty()) {
            return list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static final <T> T e(List<? extends T> list) {
        h.b(list, "$this$single");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        } else if (size == 1) {
            return list.get(0);
        } else {
            throw new IllegalArgumentException("List has more than one element.");
        }
    }

    public static <T> List<T> a(Iterable<? extends T> iterable) {
        h.b(iterable, "$this$reversed");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return c(iterable);
        }
        List<T> d2 = d(iterable);
        p.c(d2);
        return d2;
    }

    public static final <T> List<T> d(Iterable<? extends T> iterable) {
        h.b(iterable, "$this$toMutableList");
        if (iterable instanceof Collection) {
            return a((Collection) iterable);
        }
        ArrayList arrayList = new ArrayList();
        a(iterable, (C) arrayList);
        return arrayList;
    }

    public static <T> List<T> a(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        h.b(iterable, "$this$sortedWith");
        h.b(comparator, "comparator");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return c(iterable);
            }
            Object[] array = collection.toArray(new Object[0]);
            String str = "null cannot be cast to non-null type kotlin.Array<T>";
            if (array == null) {
                throw new TypeCastException(str);
            } else if (array != null) {
                d.a(array, comparator);
                return d.a(array);
            } else {
                throw new TypeCastException(str);
            }
        } else {
            List<T> d2 = d(iterable);
            m.a(d2, comparator);
            return d2;
        }
    }

    public static final <T, C extends Collection<? super T>> C a(Iterable<? extends T> iterable, C c2) {
        h.b(iterable, "$this$toCollection");
        h.b(c2, "destination");
        for (Object add : iterable) {
            c2.add(add);
        }
        return c2;
    }

    public static <T> List<T> a(Collection<? extends T> collection) {
        h.b(collection, "$this$toMutableList");
        return new ArrayList(collection);
    }
}
