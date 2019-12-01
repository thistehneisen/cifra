package com.google.android.gms.measurement.module;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.internal.measurement.Af;
import com.google.android.gms.measurement.internal.Ob;

public class Analytics {

    /* renamed from: a reason: collision with root package name */
    private static volatile Analytics f6185a;

    /* renamed from: b reason: collision with root package name */
    private final Ob f6186b;

    private Analytics(Ob ob) {
        q.a(ob);
        this.f6186b = ob;
    }

    @Keep
    public static Analytics getInstance(Context context) {
        if (f6185a == null) {
            synchronized (Analytics.class) {
                if (f6185a == null) {
                    f6185a = new Analytics(Ob.a(context, (Af) null));
                }
            }
        }
        return f6185a;
    }
}
