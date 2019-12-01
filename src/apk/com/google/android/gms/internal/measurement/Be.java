package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.atomic.AtomicReference;

public final class Be extends rf {

    /* renamed from: a reason: collision with root package name */
    private final AtomicReference<Bundle> f4868a = new AtomicReference<>();

    /* renamed from: b reason: collision with root package name */
    private boolean f4869b;

    public final String a(long j2) {
        return (String) a(b(j2), String.class);
    }

    public final Bundle b(long j2) {
        Bundle bundle;
        synchronized (this.f4868a) {
            if (!this.f4869b) {
                try {
                    this.f4868a.wait(j2);
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            bundle = (Bundle) this.f4868a.get();
        }
        return bundle;
    }

    public final void c(Bundle bundle) {
        synchronized (this.f4868a) {
            try {
                this.f4868a.set(bundle);
                this.f4869b = true;
                this.f4868a.notify();
            } catch (Throwable th) {
                this.f4868a.notify();
                throw th;
            }
        }
    }

    public static <T> T a(Bundle bundle, Class<T> cls) {
        if (bundle != null) {
            Object obj = bundle.get("r");
            if (obj != null) {
                try {
                    return cls.cast(obj);
                } catch (ClassCastException e2) {
                    String canonicalName = cls.getCanonicalName();
                    String canonicalName2 = obj.getClass().getCanonicalName();
                    Object[] objArr = {canonicalName, canonicalName2};
                    String str = "AM";
                    Log.w(str, String.format("Unexpected object type. Expected, Received".concat(": %s, %s"), objArr), e2);
                    throw e2;
                }
            }
        }
        return null;
    }
}
