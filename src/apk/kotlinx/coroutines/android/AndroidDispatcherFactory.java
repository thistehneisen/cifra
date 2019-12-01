package kotlinx.coroutines.android;

import android.os.Looper;
import androidx.annotation.Keep;
import java.util.List;
import kotlin.e.b.h;
import kotlinx.coroutines.internal.MainDispatcherFactory;

@Keep
/* compiled from: HandlerDispatcher.kt */
public final class AndroidDispatcherFactory implements MainDispatcherFactory {
    public int getLoadPriority() {
        return 1073741823;
    }

    public String hintOnError() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    public b createDispatcher(List<? extends MainDispatcherFactory> list) {
        h.b(list, "allFactories");
        Looper mainLooper = Looper.getMainLooper();
        h.a((Object) mainLooper, "Looper.getMainLooper()");
        return new b(d.a(mainLooper, true), "Main");
    }
}
