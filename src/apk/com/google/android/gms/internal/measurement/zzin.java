package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzin extends IOException {
    zzin(int i2, int i3) {
        StringBuilder sb = new StringBuilder(108);
        sb.append("CodedOutputStream was writing to a flat byte array and ran out of space (pos ");
        sb.append(i2);
        sb.append(" limit ");
        sb.append(i3);
        sb.append(").");
        super(sb.toString());
    }
}
