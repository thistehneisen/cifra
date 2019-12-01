package com.touchin.vtb.h.a;

import com.touchin.vtb.api.PaymentInfo;
import java.util.Comparator;

/* compiled from: Comparisons.kt */
public final class o<T> implements Comparator<T> {
    public final int compare(T t, T t2) {
        return b.a(((PaymentInfo) t2).d(), ((PaymentInfo) t).d());
    }
}
