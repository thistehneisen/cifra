package kotlinx.coroutines.android;

import androidx.annotation.Keep;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.reflect.Method;
import kotlin.c.a;
import kotlin.c.f;
import kotlin.e.b.h;
import kotlinx.coroutines.CoroutineExceptionHandler;

@Keep
/* compiled from: AndroidExceptionPreHandler.kt */
public final class AndroidExceptionPreHandler extends a implements CoroutineExceptionHandler {
    public AndroidExceptionPreHandler() {
        super(CoroutineExceptionHandler.f10347c);
    }

    public void handleException(f fVar, Throwable th) {
        h.b(fVar, "context");
        h.b(th, "exception");
        Method a2 = a.f10349a;
        Object invoke = a2 != null ? a2.invoke(null, new Object[0]) : null;
        if (!(invoke instanceof UncaughtExceptionHandler)) {
            invoke = null;
        }
        UncaughtExceptionHandler uncaughtExceptionHandler = (UncaughtExceptionHandler) invoke;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
        }
    }
}
