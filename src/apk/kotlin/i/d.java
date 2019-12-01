package kotlin.i;

import io.intercom.android.sdk.metrics.MetricTracker.Object;
import java.util.Iterator;
import kotlin.e.b.h;
import kotlin.g;
import kotlin.h.c;

/* compiled from: Strings.kt */
final class d implements c<kotlin.f.d> {
    /* access modifiers changed from: private */

    /* renamed from: a reason: collision with root package name */
    public final CharSequence f10339a;
    /* access modifiers changed from: private */

    /* renamed from: b reason: collision with root package name */
    public final int f10340b;
    /* access modifiers changed from: private */

    /* renamed from: c reason: collision with root package name */
    public final int f10341c;
    /* access modifiers changed from: private */

    /* renamed from: d reason: collision with root package name */
    public final kotlin.e.a.c<CharSequence, Integer, g<Integer, Integer>> f10342d;

    public d(CharSequence charSequence, int i2, int i3, kotlin.e.a.c<? super CharSequence, ? super Integer, g<Integer, Integer>> cVar) {
        h.b(charSequence, Object.INPUT);
        h.b(cVar, "getNextMatch");
        this.f10339a = charSequence;
        this.f10340b = i2;
        this.f10341c = i3;
        this.f10342d = cVar;
    }

    public Iterator<kotlin.f.d> iterator() {
        return new c(this);
    }
}
