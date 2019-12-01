package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.measurement.internal.C0572sc;

/* renamed from: com.google.android.gms.internal.measurement.o reason: case insensitive filesystem */
final class C0409o extends a {

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ C0572sc f5297e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ Cf f5298f;

    C0409o(Cf cf, C0572sc scVar) {
        this.f5298f = cf;
        this.f5297e = scVar;
        super(cf);
    }

    /* access modifiers changed from: 0000 */
    public final void a() throws RemoteException {
        for (int i2 = 0; i2 < this.f5298f.f4894l.size(); i2++) {
            if (this.f5297e.equals(((Pair) this.f5298f.f4894l.get(i2)).first)) {
                Log.w(this.f5298f.f4890h, "OnEventListener already registered.");
                return;
            }
        }
        c cVar = new c(this.f5297e);
        this.f5298f.f4894l.add(new Pair(this.f5297e, cVar));
        this.f5298f.p.registerOnMeasurementEventListener(cVar);
    }
}
