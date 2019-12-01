package l.a.c.b;

import androidx.lifecycle.l;
import androidx.lifecycle.u;
import androidx.lifecycle.v;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.e.b.h;

/* compiled from: SingleLiveEvent.kt */
public class c<T> extends u<T> {
    /* access modifiers changed from: private */

    /* renamed from: k reason: collision with root package name */
    public final AtomicBoolean f10384k = new AtomicBoolean(false);

    public void b(T t) {
        this.f10384k.set(true);
        super.b(t);
    }

    public void a(l lVar, v<? super T> vVar) {
        h.b(lVar, "owner");
        h.b(vVar, "observer");
        super.a(lVar, new b(this, vVar));
    }
}
