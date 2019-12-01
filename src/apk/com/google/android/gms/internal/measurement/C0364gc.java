package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.measurement.gc reason: case insensitive filesystem */
public final class C0364gc<K, V> extends LinkedHashMap<K, V> {

    /* renamed from: a reason: collision with root package name */
    private static final C0364gc f5201a;
    private boolean zzacz = true;

    static {
        C0364gc gcVar = new C0364gc();
        f5201a = gcVar;
        gcVar.zzacz = false;
    }

    private C0364gc() {
    }

    public static <K, V> C0364gc<K, V> c() {
        return f5201a;
    }

    private final void e() {
        if (!this.zzacz) {
            throw new UnsupportedOperationException();
        }
    }

    public final void a(C0364gc<K, V> gcVar) {
        e();
        if (!gcVar.isEmpty()) {
            putAll(gcVar);
        }
    }

    public final void b() {
        this.zzacz = false;
    }

    public final void clear() {
        e();
        super.clear();
    }

    public final C0364gc<K, V> d() {
        return isEmpty() ? new C0364gc<>() : new C0364gc<>(this);
    }

    public final Set<Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005c A[RETURN] */
    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this != map) {
                if (size() == map.size()) {
                    Iterator it = entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Entry entry = (Entry) it.next();
                        if (map.containsKey(entry.getKey())) {
                            Object value = entry.getValue();
                            Object obj2 = map.get(entry.getKey());
                            if (!(value instanceof byte[]) || !(obj2 instanceof byte[])) {
                                z2 = value.equals(obj2);
                                continue;
                            } else {
                                z2 = Arrays.equals((byte[]) value, (byte[]) obj2);
                                continue;
                            }
                            if (!z2) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    return true;
                }
            }
            z = true;
            if (!z) {
                return false;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = 0;
        for (Entry entry : entrySet()) {
            i2 += a(entry.getValue()) ^ a(entry.getKey());
        }
        return i2;
    }

    public final V put(K k2, V v) {
        e();
        Fb.a(k2);
        Fb.a(v);
        return super.put(k2, v);
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        e();
        for (Object next : map.keySet()) {
            Fb.a(next);
            Fb.a(map.get(next));
        }
        super.putAll(map);
    }

    public final V remove(Object obj) {
        e();
        return super.remove(obj);
    }

    private C0364gc(Map<K, V> map) {
        super(map);
    }

    private static int a(Object obj) {
        if (obj instanceof byte[]) {
            return Fb.a((byte[]) obj);
        }
        if (!(obj instanceof Jb)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    public final boolean a() {
        return this.zzacz;
    }
}
