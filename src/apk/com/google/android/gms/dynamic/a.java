package com.google.android.gms.dynamic;

import android.os.IBinder;
import android.os.IInterface;
import c.b.a.b.b.c.b;

public interface a extends IInterface {

    /* renamed from: com.google.android.gms.dynamic.a$a reason: collision with other inner class name */
    public static abstract class C0066a extends b implements a {

        /* renamed from: com.google.android.gms.dynamic.a$a$a reason: collision with other inner class name */
        public static class C0067a extends c.b.a.b.b.c.a implements a {
            C0067a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamic.IObjectWrapper");
            }
        }

        public C0066a() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            if (queryLocalInterface instanceof a) {
                return (a) queryLocalInterface;
            }
            return new C0067a(iBinder);
        }
    }
}
