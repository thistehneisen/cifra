package retrofit2;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;

/* compiled from: Platform */
class s {

    /* renamed from: a reason: collision with root package name */
    private static final s f11045a = c();

    /* compiled from: Platform */
    static class a extends s {

        /* renamed from: retrofit2.s$a$a reason: collision with other inner class name */
        /* compiled from: Platform */
        static class C0130a implements Executor {

            /* renamed from: a reason: collision with root package name */
            private final Handler f11046a = new Handler(Looper.getMainLooper());

            C0130a() {
            }

            public void execute(Runnable runnable) {
                this.f11046a.post(runnable);
            }
        }

        a() {
        }

        public Executor a() {
            return new C0130a();
        }

        /* access modifiers changed from: 0000 */
        public retrofit2.c.a a(Executor executor) {
            if (executor != null) {
                return new l(executor);
            }
            throw new AssertionError();
        }
    }

    /* compiled from: Platform */
    static class b extends s {
        b() {
        }

        /* access modifiers changed from: 0000 */
        public boolean a(Method method) {
            return method.isDefault();
        }

        /* access modifiers changed from: 0000 */
        public Object a(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
            Constructor declaredConstructor = Lookup.class.getDeclaredConstructor(new Class[]{Class.class, Integer.TYPE});
            declaredConstructor.setAccessible(true);
            return ((Lookup) declaredConstructor.newInstance(new Object[]{cls, Integer.valueOf(-1)})).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
        }
    }

    s() {
    }

    static s b() {
        return f11045a;
    }

    private static s c() {
        try {
            Class.forName("android.os.Build");
            if (VERSION.SDK_INT != 0) {
                return new a();
            }
        } catch (ClassNotFoundException unused) {
        }
        try {
            Class.forName("java.util.Optional");
            return new b();
        } catch (ClassNotFoundException unused2) {
            return new s();
        }
    }

    /* access modifiers changed from: 0000 */
    public Executor a() {
        return null;
    }

    /* access modifiers changed from: 0000 */
    public retrofit2.c.a a(Executor executor) {
        if (executor != null) {
            return new l(executor);
        }
        return g.f10995a;
    }

    /* access modifiers changed from: 0000 */
    public boolean a(Method method) {
        return false;
    }

    /* access modifiers changed from: 0000 */
    public Object a(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
        throw new UnsupportedOperationException();
    }
}
