package com.touchin.vtb.h.a;

import com.touchin.vtb.api.OperationInfo;
import java.util.Comparator;

/* compiled from: Comparisons.kt */
public final class h<T> implements Comparator<T> {
    public final int compare(T t, T t2) {
        return b.a(((OperationInfo) t2).d(), ((OperationInfo) t).d());
    }
}
