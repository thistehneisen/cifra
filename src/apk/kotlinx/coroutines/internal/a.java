package kotlinx.coroutines.internal;

import kotlin.e.b.h;

/* compiled from: SystemProps.kt */
public final class a {

    /* renamed from: a reason: collision with root package name */
    private static final int f10361a = Runtime.getRuntime().availableProcessors();

    public static final String a(String str) {
        h.b(str, "propertyName");
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static final boolean a(String str, boolean z) {
        h.b(str, "propertyName");
        try {
            String property = System.getProperty(str);
            return property != null ? Boolean.parseBoolean(property) : z;
        } catch (SecurityException unused) {
            return z;
        }
    }
}
