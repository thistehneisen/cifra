package com.touchin.vtb.e;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.s;
import e.b.a;
import e.b.k;
import kotlin.e.b.h;

/* compiled from: Observable.kt */
public final class e {
    public static final <T> LiveData<T> a(k<T> kVar) {
        h.b(kVar, "$this$toLiveData");
        LiveData<T> a2 = s.a(kVar.a(a.LATEST));
        h.a((Object) a2, "LiveDataReactiveStreams.…pressureStrategy.LATEST))");
        return a2;
    }
}
