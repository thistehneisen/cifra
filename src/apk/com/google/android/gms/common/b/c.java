package com.google.android.gms.common.b;

import android.content.Context;

public class c {

    /* renamed from: a reason: collision with root package name */
    private static c f4647a = new c();

    /* renamed from: b reason: collision with root package name */
    private b f4648b = null;

    public static b a(Context context) {
        return f4647a.b(context);
    }

    private final synchronized b b(Context context) {
        if (this.f4648b == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f4648b = new b(context);
        }
        return this.f4648b;
    }
}
