package androidx.coordinatorlayout.widget;

import b.d.i;
import b.g.h.d;
import b.g.h.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* compiled from: DirectedAcyclicGraph */
public final class c<T> {

    /* renamed from: a reason: collision with root package name */
    private final d<ArrayList<T>> f1236a = new e(10);

    /* renamed from: b reason: collision with root package name */
    private final i<T, ArrayList<T>> f1237b = new i<>();

    /* renamed from: c reason: collision with root package name */
    private final ArrayList<T> f1238c = new ArrayList<>();

    /* renamed from: d reason: collision with root package name */
    private final HashSet<T> f1239d = new HashSet<>();

    public void a(T t) {
        if (!this.f1237b.containsKey(t)) {
            this.f1237b.put(t, null);
        }
    }

    public boolean b(T t) {
        return this.f1237b.containsKey(t);
    }

    public List c(T t) {
        return (List) this.f1237b.get(t);
    }

    public List<T> d(T t) {
        int size = this.f1237b.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList arrayList2 = (ArrayList) this.f1237b.d(i2);
            if (arrayList2 != null && arrayList2.contains(t)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f1237b.b(i2));
            }
        }
        return arrayList;
    }

    public boolean e(T t) {
        int size = this.f1237b.size();
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList arrayList = (ArrayList) this.f1237b.d(i2);
            if (arrayList != null && arrayList.contains(t)) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<T> c() {
        ArrayList<T> arrayList = (ArrayList) this.f1236a.a();
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public ArrayList<T> b() {
        this.f1238c.clear();
        this.f1239d.clear();
        int size = this.f1237b.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(this.f1237b.b(i2), this.f1238c, this.f1239d);
        }
        return this.f1238c;
    }

    public void a(T t, T t2) {
        if (!this.f1237b.containsKey(t) || !this.f1237b.containsKey(t2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList arrayList = (ArrayList) this.f1237b.get(t);
        if (arrayList == null) {
            arrayList = c();
            this.f1237b.put(t, arrayList);
        }
        arrayList.add(t2);
    }

    public void a() {
        int size = this.f1237b.size();
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList arrayList = (ArrayList) this.f1237b.d(i2);
            if (arrayList != null) {
                a(arrayList);
            }
        }
        this.f1237b.clear();
    }

    private void a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t)) {
            if (!hashSet.contains(t)) {
                hashSet.add(t);
                ArrayList arrayList2 = (ArrayList) this.f1237b.get(t);
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        a(arrayList2.get(i2), arrayList, hashSet);
                    }
                }
                hashSet.remove(t);
                arrayList.add(t);
                return;
            }
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
    }

    private void a(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f1236a.a(arrayList);
    }
}
