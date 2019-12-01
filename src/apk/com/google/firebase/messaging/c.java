package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import b.d.b;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.Map;

public final class c extends a {
    public static final Creator<c> CREATOR = new i();

    /* renamed from: a reason: collision with root package name */
    Bundle f6863a;

    /* renamed from: b reason: collision with root package name */
    private Map<String, String> f6864b;

    public c(Bundle bundle) {
        this.f6863a = bundle;
    }

    public final Map<String, String> f() {
        if (this.f6864b == null) {
            Bundle bundle = this.f6863a;
            b bVar = new b();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals("from") && !str.equals("message_type") && !str.equals("collapse_key")) {
                        bVar.put(str, str2);
                    }
                }
            }
            this.f6864b = bVar;
        }
        return this.f6864b;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, this.f6863a, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, a2);
    }
}
