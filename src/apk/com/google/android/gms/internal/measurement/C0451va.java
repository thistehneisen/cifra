package com.google.android.gms.internal.measurement;

import android.util.Log;

/* renamed from: com.google.android.gms.internal.measurement.va reason: case insensitive filesystem */
final class C0451va extends C0439ta<Boolean> {
    C0451va(Aa aa, String str, Boolean bool) {
        super(aa, str, bool, null);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Object a(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (C0362ga.f5191c.matcher(str).matches()) {
                return Boolean.valueOf(true);
            }
            if (C0362ga.f5192d.matcher(str).matches()) {
                return Boolean.valueOf(false);
            }
        }
        String c2 = super.c();
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(c2).length() + 28 + String.valueOf(valueOf).length());
        sb.append("Invalid boolean value for ");
        sb.append(c2);
        sb.append(": ");
        sb.append(valueOf);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
