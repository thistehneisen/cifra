package b.g.f;

import android.content.Context;
import android.graphics.Typeface;
import java.util.concurrent.Callable;

/* compiled from: FontsContractCompat */
class b implements Callable<c> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Context f2532a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ a f2533b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ int f2534c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ String f2535d;

    b(Context context, a aVar, int i2, String str) {
        this.f2532a = context;
        this.f2533b = aVar;
        this.f2534c = i2;
        this.f2535d = str;
    }

    public c call() throws Exception {
        c a2 = f.a(this.f2532a, this.f2533b, this.f2534c);
        Typeface typeface = a2.f2551a;
        if (typeface != null) {
            f.f2539a.a(this.f2535d, typeface);
        }
        return a2;
    }
}
