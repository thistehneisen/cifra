package com.touchin.vtb.f.a;

import android.content.Context;
import androidx.core.os.a;
import b.g.c.a.b;
import e.b.c.e;
import e.b.d;
import e.b.o;
import kotlin.e.b.h;
import ru.touchin.roboswag.core.observables.storable.i;

/* compiled from: FingerprintInteractor.kt */
public final class c {
    /* access modifiers changed from: private */

    /* renamed from: a reason: collision with root package name */
    public boolean f7257a;

    /* renamed from: b reason: collision with root package name */
    private final b f7258b;

    /* renamed from: c reason: collision with root package name */
    private a f7259c;

    /* renamed from: d reason: collision with root package name */
    private final i<String, Boolean, Boolean> f7260d;

    public c(Context context, i<String, Boolean, Boolean> iVar) {
        h.b(context, "context");
        h.b(iVar, "isFingerprintEnableStorable");
        this.f7260d = iVar;
        b a2 = b.a(context);
        h.a((Object) a2, "FingerprintManagerCompat.from(context)");
        this.f7258b = a2;
        this.f7260d.c().a((e<? super T>) new a<Object>(this)).i();
    }

    public final boolean b() {
        return this.f7258b.b() && this.f7258b.a();
    }

    public final boolean c() {
        return b() && this.f7257a;
    }

    public final e.b.b a(boolean z) {
        e.b.b a2 = this.f7260d.a(Boolean.valueOf(z)).a((d) new b(this, z));
        h.a((Object) a2, "isFingerprintEnableStora…rintEnabled = isEnabled }");
        return a2;
    }

    public final o<Boolean> a() {
        o<Boolean> b2 = this.f7260d.b();
        h.a((Object) b2, "isFingerprintEnableStorable.get()");
        return b2;
    }

    public final void a(b.a aVar) {
        h.b(aVar, "callback");
        a aVar2 = this.f7259c;
        if (aVar2 != null) {
            aVar2.a();
        }
        this.f7259c = new a();
        this.f7258b.a(null, 0, this.f7259c, aVar, null);
    }
}
