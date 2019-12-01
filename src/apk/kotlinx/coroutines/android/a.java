package kotlinx.coroutines.android;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.e.b.h;

/* compiled from: AndroidExceptionPreHandler.kt */
public final class a {
    /* access modifiers changed from: private */

    /* renamed from: a reason: collision with root package name */
    public static final Method f10349a;

    static {
        Method method = null;
        boolean z = false;
        try {
            Method declaredMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);
            h.a((Object) declaredMethod, "it");
            if (Modifier.isPublic(declaredMethod.getModifiers()) && Modifier.isStatic(declaredMethod.getModifiers())) {
                z = true;
            }
            if (z) {
                method = declaredMethod;
            }
        } catch (Throwable unused) {
        }
        f10349a = method;
    }
}
