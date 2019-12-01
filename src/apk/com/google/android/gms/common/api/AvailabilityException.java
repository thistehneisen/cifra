package com.google.android.gms.common.api;

import android.text.TextUtils;
import b.d.b;
import com.google.android.gms.common.api.internal.D;
import java.util.ArrayList;

public class AvailabilityException extends Exception {
    private final b<D<?>, com.google.android.gms.common.b> zaay;

    public AvailabilityException(b<D<?>, com.google.android.gms.common.b> bVar) {
        this.zaay = bVar;
    }

    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (D d2 : this.zaay.keySet()) {
            com.google.android.gms.common.b bVar = (com.google.android.gms.common.b) this.zaay.get(d2);
            if (bVar.j()) {
                z = false;
            }
            String a2 = d2.a();
            String valueOf = String.valueOf(bVar);
            StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 2 + String.valueOf(valueOf).length());
            sb.append(a2);
            sb.append(": ");
            sb.append(valueOf);
            arrayList.add(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        if (z) {
            sb2.append("None of the queried APIs are available. ");
        } else {
            sb2.append("Some of the queried APIs are unavailable. ");
        }
        sb2.append(TextUtils.join("; ", arrayList));
        return sb2.toString();
    }
}
