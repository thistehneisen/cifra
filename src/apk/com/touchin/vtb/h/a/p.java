package com.touchin.vtb.h.a;

import com.touchin.vtb.api.TaxesYearInfo;
import java.util.Comparator;

/* compiled from: Comparisons.kt */
public final class p<T> implements Comparator<T> {
    public final int compare(T t, T t2) {
        return b.a(Integer.valueOf(((TaxesYearInfo) t).d()), Integer.valueOf(((TaxesYearInfo) t2).d()));
    }
}
