package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

/* compiled from: ResourcesFlusher */
class E {

    /* renamed from: a reason: collision with root package name */
    private static Field f415a;

    /* renamed from: b reason: collision with root package name */
    private static boolean f416b;

    /* renamed from: c reason: collision with root package name */
    private static Class f417c;

    /* renamed from: d reason: collision with root package name */
    private static boolean f418d;

    /* renamed from: e reason: collision with root package name */
    private static Field f419e;

    /* renamed from: f reason: collision with root package name */
    private static boolean f420f;

    /* renamed from: g reason: collision with root package name */
    private static Field f421g;

    /* renamed from: h reason: collision with root package name */
    private static boolean f422h;

    static void a(Resources resources) {
        int i2 = VERSION.SDK_INT;
        if (i2 < 28) {
            if (i2 >= 24) {
                d(resources);
            } else if (i2 >= 23) {
                c(resources);
            } else if (i2 >= 21) {
                b(resources);
            }
        }
    }

    private static void b(Resources resources) {
        Map map;
        String str = "ResourcesFlusher";
        if (!f416b) {
            try {
                f415a = Resources.class.getDeclaredField("mDrawableCache");
                f415a.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e(str, "Could not retrieve Resources#mDrawableCache field", e2);
            }
            f416b = true;
        }
        Field field = f415a;
        if (field != null) {
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException e3) {
                Log.e(str, "Could not retrieve value from Resources#mDrawableCache", e3);
                map = null;
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    private static void c(Resources resources) {
        String str = "ResourcesFlusher";
        if (!f416b) {
            try {
                f415a = Resources.class.getDeclaredField("mDrawableCache");
                f415a.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e(str, "Could not retrieve Resources#mDrawableCache field", e2);
            }
            f416b = true;
        }
        Object obj = null;
        Field field = f415a;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e3) {
                Log.e(str, "Could not retrieve value from Resources#mDrawableCache", e3);
            }
        }
        if (obj != null) {
            a(obj);
        }
    }

    private static void d(Resources resources) {
        Object obj;
        String str = "ResourcesFlusher";
        if (!f422h) {
            try {
                f421g = Resources.class.getDeclaredField("mResourcesImpl");
                f421g.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e(str, "Could not retrieve Resources#mResourcesImpl field", e2);
            }
            f422h = true;
        }
        Field field = f421g;
        if (field != null) {
            Object obj2 = null;
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e3) {
                Log.e(str, "Could not retrieve value from Resources#mResourcesImpl", e3);
                obj = null;
            }
            if (obj != null) {
                if (!f416b) {
                    try {
                        f415a = obj.getClass().getDeclaredField("mDrawableCache");
                        f415a.setAccessible(true);
                    } catch (NoSuchFieldException e4) {
                        Log.e(str, "Could not retrieve ResourcesImpl#mDrawableCache field", e4);
                    }
                    f416b = true;
                }
                Field field2 = f415a;
                if (field2 != null) {
                    try {
                        obj2 = field2.get(obj);
                    } catch (IllegalAccessException e5) {
                        Log.e(str, "Could not retrieve value from ResourcesImpl#mDrawableCache", e5);
                    }
                }
                if (obj2 != null) {
                    a(obj2);
                }
            }
        }
    }

    private static void a(Object obj) {
        LongSparseArray longSparseArray;
        String str = "ResourcesFlusher";
        if (!f418d) {
            try {
                f417c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e2) {
                Log.e(str, "Could not find ThemedResourceCache class", e2);
            }
            f418d = true;
        }
        Class cls = f417c;
        if (cls != null) {
            if (!f420f) {
                try {
                    f419e = cls.getDeclaredField("mUnthemedEntries");
                    f419e.setAccessible(true);
                } catch (NoSuchFieldException e3) {
                    Log.e(str, "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e3);
                }
                f420f = true;
            }
            Field field = f419e;
            if (field != null) {
                try {
                    longSparseArray = (LongSparseArray) field.get(obj);
                } catch (IllegalAccessException e4) {
                    Log.e(str, "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e4);
                    longSparseArray = null;
                }
                if (longSparseArray != null) {
                    longSparseArray.clear();
                }
            }
        }
    }
}
