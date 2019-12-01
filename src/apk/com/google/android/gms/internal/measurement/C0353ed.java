package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.ed reason: case insensitive filesystem */
final class C0353ed extends IllegalArgumentException {
    C0353ed(int i2, int i3) {
        StringBuilder sb = new StringBuilder(54);
        sb.append("Unpaired surrogate at index ");
        sb.append(i2);
        sb.append(" of ");
        sb.append(i3);
        super(sb.toString());
    }
}
