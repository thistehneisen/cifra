package kotlin.a;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.e.b.a.a;
import kotlin.e.b.d;
import kotlin.e.b.h;

/* compiled from: Collections.kt */
public final class s implements List, Serializable, RandomAccess, a {

    /* renamed from: a reason: collision with root package name */
    public static final s f10294a = new s();
    private static final long serialVersionUID = -7390468764508069838L;

    private s() {
    }

    private final Object readResolve() {
        return f10294a;
    }

    public boolean a(Void voidR) {
        h.b(voidR, "element");
        return false;
    }

    public /* synthetic */ void add(int i2, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int i2, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public int b(Void voidR) {
        h.b(voidR, "element");
        return -1;
    }

    public int c(Void voidR) {
        h.b(voidR, "element");
        return -1;
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Void) {
            return a((Void) obj);
        }
        return false;
    }

    public boolean containsAll(Collection collection) {
        h.b(collection, "elements");
        return collection.isEmpty();
    }

    public int e() {
        return 0;
    }

    public boolean equals(Object obj) {
        return (obj instanceof List) && ((List) obj).isEmpty();
    }

    public int hashCode() {
        return 1;
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Void) {
            return b((Void) obj);
        }
        return -1;
    }

    public boolean isEmpty() {
        return true;
    }

    public Iterator iterator() {
        return r.f10293a;
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Void) {
            return c((Void) obj);
        }
        return -1;
    }

    public ListIterator listIterator() {
        return r.f10293a;
    }

    public /* synthetic */ Object remove(int i2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* synthetic */ Object set(int i2, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return e();
    }

    public List subList(int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return this;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("fromIndex: ");
        sb.append(i2);
        sb.append(", toIndex: ");
        sb.append(i3);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public Object[] toArray() {
        return d.a(this);
    }

    public <T> T[] toArray(T[] tArr) {
        return d.a(this, tArr);
    }

    public String toString() {
        return "[]";
    }

    public Void get(int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty list doesn't contain element at index ");
        sb.append(i2);
        sb.append('.');
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public ListIterator listIterator(int i2) {
        if (i2 == 0) {
            return r.f10293a;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Index: ");
        sb.append(i2);
        throw new IndexOutOfBoundsException(sb.toString());
    }
}
