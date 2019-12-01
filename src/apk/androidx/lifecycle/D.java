package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

/* compiled from: ViewModelProvider */
public class D {

    /* renamed from: a reason: collision with root package name */
    private final b f1606a;

    /* renamed from: b reason: collision with root package name */
    private final F f1607b;

    /* compiled from: ViewModelProvider */
    public static class a extends d {

        /* renamed from: a reason: collision with root package name */
        private static a f1608a;

        /* renamed from: b reason: collision with root package name */
        private Application f1609b;

        public a(Application application) {
            this.f1609b = application;
        }

        public static a a(Application application) {
            if (f1608a == null) {
                f1608a = new a(application);
            }
            return f1608a;
        }

        public <T extends C> T a(Class<T> cls) {
            String str = "Cannot create an instance of ";
            if (!C0208a.class.isAssignableFrom(cls)) {
                return super.a(cls);
            }
            try {
                return (C) cls.getConstructor(new Class[]{Application.class}).newInstance(new Object[]{this.f1609b});
            } catch (NoSuchMethodException e2) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(cls);
                throw new RuntimeException(sb.toString(), e2);
            } catch (IllegalAccessException e3) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(cls);
                throw new RuntimeException(sb2.toString(), e3);
            } catch (InstantiationException e4) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(cls);
                throw new RuntimeException(sb3.toString(), e4);
            } catch (InvocationTargetException e5) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str);
                sb4.append(cls);
                throw new RuntimeException(sb4.toString(), e5);
            }
        }
    }

    /* compiled from: ViewModelProvider */
    public interface b {
        <T extends C> T a(Class<T> cls);
    }

    /* compiled from: ViewModelProvider */
    static abstract class c implements b {
        c() {
        }

        public <T extends C> T a(Class<T> cls) {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }

        public abstract <T extends C> T a(String str, Class<T> cls);
    }

    /* compiled from: ViewModelProvider */
    public static class d implements b {
        public <T extends C> T a(Class<T> cls) {
            String str = "Cannot create an instance of ";
            try {
                return (C) cls.newInstance();
            } catch (InstantiationException e2) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(cls);
                throw new RuntimeException(sb.toString(), e2);
            } catch (IllegalAccessException e3) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(cls);
                throw new RuntimeException(sb2.toString(), e3);
            }
        }
    }

    public D(F f2, b bVar) {
        this.f1606a = bVar;
        this.f1607b = f2;
    }

    public <T extends C> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("androidx.lifecycle.ViewModelProvider.DefaultKey:");
            sb.append(canonicalName);
            return a(sb.toString(), cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public <T extends C> T a(String str, Class<T> cls) {
        T t;
        T a2 = this.f1607b.a(str);
        if (cls.isInstance(a2)) {
            return a2;
        }
        b bVar = this.f1606a;
        if (bVar instanceof c) {
            t = ((c) bVar).a(str, cls);
        } else {
            t = bVar.a(cls);
        }
        this.f1607b.a(str, t);
        return t;
    }
}
