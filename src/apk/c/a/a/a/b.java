package c.a.a.a;

import android.content.Context;
import android.os.RemoteException;

/* compiled from: InstallReferrerClient */
public abstract class b {

    /* compiled from: InstallReferrerClient */
    public static final class a {

        /* renamed from: a reason: collision with root package name */
        private final Context f3033a;

        public b a() {
            Context context = this.f3033a;
            if (context != null) {
                return new d(context);
            }
            throw new IllegalArgumentException("Please provide a valid Context.");
        }

        private a(Context context) {
            this.f3033a = context;
        }
    }

    public static a a(Context context) {
        return new a(context);
    }

    public abstract void a();

    public abstract void a(e eVar);

    public abstract f b() throws RemoteException;

    public abstract boolean c();
}
