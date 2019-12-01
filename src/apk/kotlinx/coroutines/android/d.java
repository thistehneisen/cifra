package kotlinx.coroutines.android;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import java.lang.reflect.Constructor;
import kotlin.TypeCastException;
import kotlin.h;
import kotlin.h.a;
import kotlin.i;

/* compiled from: HandlerDispatcher.kt */
public final class d {

    /* renamed from: a reason: collision with root package name */
    public static final c f10354a;

    static {
        Object obj;
        try {
            a aVar = h.f10321a;
            Looper mainLooper = Looper.getMainLooper();
            kotlin.e.b.h.a((Object) mainLooper, "Looper.getMainLooper()");
            obj = new b(a(mainLooper, true), "Main");
            h.a(obj);
        } catch (Throwable th) {
            a aVar2 = h.f10321a;
            obj = i.a(th);
            h.a(obj);
        }
        if (h.c(obj)) {
            obj = null;
        }
        f10354a = (c) obj;
    }

    public static final Handler a(Looper looper, boolean z) {
        kotlin.e.b.h.b(looper, "receiver$0");
        if (z) {
            int i2 = VERSION.SDK_INT;
            if (i2 >= 16) {
                if (i2 >= 28) {
                    Object invoke = Handler.class.getDeclaredMethod("createAsync", new Class[]{Looper.class}).invoke(null, new Object[]{looper});
                    if (invoke != null) {
                        return (Handler) invoke;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type android.os.Handler");
                }
                try {
                    Constructor declaredConstructor = Handler.class.getDeclaredConstructor(new Class[]{Looper.class, Callback.class, Boolean.TYPE});
                    kotlin.e.b.h.a((Object) declaredConstructor, "Handler::class.java.getD…:class.javaPrimitiveType)");
                    Object newInstance = declaredConstructor.newInstance(new Object[]{looper, null, Boolean.valueOf(true)});
                    kotlin.e.b.h.a(newInstance, "constructor.newInstance(this, null, true)");
                    return (Handler) newInstance;
                } catch (NoSuchMethodException unused) {
                    return new Handler(looper);
                }
            }
        }
        return new Handler(looper);
    }
}
