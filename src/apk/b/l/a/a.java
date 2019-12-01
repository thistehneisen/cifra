package b.l.a;

import androidx.lifecycle.G;
import androidx.lifecycle.l;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: LoaderManager */
public abstract class a {
    public static <T extends l & G> a a(T t) {
        return new b(t, ((G) t).getViewModelStore());
    }

    public abstract void a();

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);
}
