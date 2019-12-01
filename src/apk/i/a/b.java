package i.a;

import java.util.concurrent.ThreadFactory;

/* compiled from: lambda */
public final /* synthetic */ class b implements ThreadFactory {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ String f8575a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ boolean f8576b;

    public /* synthetic */ b(String str, boolean z) {
        this.f8575a = str;
        this.f8576b = z;
    }

    public final Thread newThread(Runnable runnable) {
        return e.a(this.f8575a, this.f8576b, runnable);
    }
}
