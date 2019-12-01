package io.intercom.com.google.gson.b;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Primitives */
public final class A {

    /* renamed from: a reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f10016a;

    /* renamed from: b reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f10017b;

    static {
        HashMap hashMap = new HashMap(16);
        HashMap hashMap2 = new HashMap(16);
        a(hashMap, hashMap2, Boolean.TYPE, Boolean.class);
        a(hashMap, hashMap2, Byte.TYPE, Byte.class);
        a(hashMap, hashMap2, Character.TYPE, Character.class);
        a(hashMap, hashMap2, Double.TYPE, Double.class);
        a(hashMap, hashMap2, Float.TYPE, Float.class);
        a(hashMap, hashMap2, Integer.TYPE, Integer.class);
        a(hashMap, hashMap2, Long.TYPE, Long.class);
        a(hashMap, hashMap2, Short.TYPE, Short.class);
        a(hashMap, hashMap2, Void.TYPE, Void.class);
        f10016a = Collections.unmodifiableMap(hashMap);
        f10017b = Collections.unmodifiableMap(hashMap2);
    }

    private static void a(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    public static boolean a(Type type) {
        return f10016a.containsKey(type);
    }

    public static <T> Class<T> a(Class<T> cls) {
        Map<Class<?>, Class<?>> map = f10016a;
        C0753a.a(cls);
        Class cls2 = (Class) map.get(cls);
        return cls2 == null ? cls : cls2;
    }
}
