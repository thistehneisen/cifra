package ru.touchin.roboswag.core.utils;

/* compiled from: ObjectUtils */
public final class a {
    public static boolean a(Class cls) {
        return cls.isPrimitive() || cls.getSuperclass() == Number.class || cls.isEnum() || cls == Boolean.class || cls == String.class || cls == Object.class;
    }
}
