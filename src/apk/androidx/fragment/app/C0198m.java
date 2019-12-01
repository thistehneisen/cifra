package androidx.fragment.app;

import androidx.fragment.app.Fragment.InstantiationException;
import b.d.i;
import java.lang.reflect.InvocationTargetException;

/* renamed from: androidx.fragment.app.m reason: case insensitive filesystem */
/* compiled from: FragmentFactory */
public class C0198m {

    /* renamed from: a reason: collision with root package name */
    private static final i<String, Class<?>> f1538a = new i<>();

    static boolean b(ClassLoader classLoader, String str) {
        try {
            return Fragment.class.isAssignableFrom(d(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static Class<? extends Fragment> c(ClassLoader classLoader, String str) {
        String str2 = "Unable to instantiate fragment ";
        try {
            return d(classLoader, str);
        } catch (ClassNotFoundException e2) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(str);
            sb.append(": make sure class name exists");
            throw new InstantiationException(sb.toString(), e2);
        } catch (ClassCastException e3) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(str);
            sb2.append(": make sure class is a valid subclass of Fragment");
            throw new InstantiationException(sb2.toString(), e3);
        }
    }

    private static Class<?> d(ClassLoader classLoader, String str) throws ClassNotFoundException {
        Class<?> cls = (Class) f1538a.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        f1538a.put(str, cls2);
        return cls2;
    }

    public Fragment a(ClassLoader classLoader, String str) {
        String str2 = ": make sure class name exists, is public, and has an empty constructor that is public";
        String str3 = "Unable to instantiate fragment ";
        try {
            return (Fragment) c(classLoader, str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (InstantiationException e2) {
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append(str);
            sb.append(str2);
            throw new InstantiationException(sb.toString(), e2);
        } catch (IllegalAccessException e3) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append(str);
            sb2.append(str2);
            throw new InstantiationException(sb2.toString(), e3);
        } catch (NoSuchMethodException e4) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str3);
            sb3.append(str);
            sb3.append(": could not find Fragment constructor");
            throw new InstantiationException(sb3.toString(), e4);
        } catch (InvocationTargetException e5) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str3);
            sb4.append(str);
            sb4.append(": calling Fragment constructor caused an exception");
            throw new InstantiationException(sb4.toString(), e5);
        }
    }
}
