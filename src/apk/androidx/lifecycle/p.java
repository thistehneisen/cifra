package androidx.lifecycle;

import io.fabric.sdk.android.a.c.c;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Lifecycling */
public class p {

    /* renamed from: a reason: collision with root package name */
    private static Map<Class, Integer> f1661a = new HashMap();

    /* renamed from: b reason: collision with root package name */
    private static Map<Class, List<Constructor<? extends C0213f>>> f1662b = new HashMap();

    static j a(Object obj) {
        boolean z = obj instanceof j;
        boolean z2 = obj instanceof C0211d;
        if (z && z2) {
            return new FullLifecycleObserverAdapter((C0211d) obj, (j) obj);
        }
        if (z2) {
            return new FullLifecycleObserverAdapter((C0211d) obj, null);
        }
        if (z) {
            return (j) obj;
        }
        Class cls = obj.getClass();
        if (b(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List list = (List) f1662b.get(cls);
        if (list.size() == 1) {
            return new SingleGeneratedAdapterObserver(a((Constructor) list.get(0), obj));
        }
        C0213f[] fVarArr = new C0213f[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            fVarArr[i2] = a((Constructor) list.get(i2), obj);
        }
        return new CompositeGeneratedAdaptersObserver(fVarArr);
    }

    private static int b(Class<?> cls) {
        Integer num = (Integer) f1661a.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int d2 = d(cls);
        f1661a.put(cls, Integer.valueOf(d2));
        return d2;
    }

    private static boolean c(Class<?> cls) {
        return cls != null && k.class.isAssignableFrom(cls);
    }

    private static int d(Class<?> cls) {
        Class[] interfaces;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor a2 = a(cls);
        if (a2 != null) {
            f1662b.put(cls, Collections.singletonList(a2));
            return 2;
        } else if (C0209b.f1634a.b(cls)) {
            return 1;
        } else {
            Class superclass = cls.getSuperclass();
            ArrayList arrayList = null;
            if (c(superclass)) {
                if (b(superclass) == 1) {
                    return 1;
                }
                arrayList = new ArrayList((Collection) f1662b.get(superclass));
            }
            for (Class cls2 : cls.getInterfaces()) {
                if (c(cls2)) {
                    if (b(cls2) == 1) {
                        return 1;
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.addAll((Collection) f1662b.get(cls2));
                }
            }
            if (arrayList == null) {
                return 1;
            }
            f1662b.put(cls, arrayList);
            return 2;
        }
    }

    private static C0213f a(Constructor<? extends C0213f> constructor, Object obj) {
        try {
            return (C0213f) constructor.newInstance(new Object[]{obj});
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }

    private static Constructor<? extends C0213f> a(Class<?> cls) {
        try {
            Package packageR = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = packageR != null ? packageR.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String a2 = a(canonicalName);
            if (!name.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                sb.append(name);
                sb.append(".");
                sb.append(a2);
                a2 = sb.toString();
            }
            Constructor<? extends C0213f> declaredConstructor = Class.forName(a2).getDeclaredConstructor(new Class[]{cls});
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.replace(".", c.ROLL_OVER_FILE_NAME_SEPARATOR));
        sb.append("_LifecycleAdapter");
        return sb.toString();
    }
}
