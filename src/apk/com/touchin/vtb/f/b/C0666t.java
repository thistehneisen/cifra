package com.touchin.vtb.f.b;

import com.touchin.vtb.api.ApiError;
import com.touchin.vtb.api.exceptions.ServerException;
import e.b.c.g;
import e.b.e;
import java.util.concurrent.TimeUnit;
import k.a.b;
import kotlin.e.b.h;

/* renamed from: com.touchin.vtb.f.b.t reason: case insensitive filesystem */
/* compiled from: BankRepository.kt */
final class C0666t<T, R> implements g<T, b<? extends R>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ C0648a f7374a;

    C0666t(C0648a aVar) {
        this.f7374a = aVar;
    }

    /* renamed from: a */
    public final e<Long> apply(Throwable th) {
        h.b(th, "throwable");
        if (th instanceof ServerException) {
            if (((ServerException) th).a() != ApiError.TICKET_EXPIRED) {
                return e.b(th);
            }
            this.f7374a.f7310c.a(new ru.touchin.roboswag.core.utils.b(null));
            this.f7374a.f7311d.a(new ru.touchin.roboswag.core.utils.b(null));
            return e.a(1, TimeUnit.SECONDS);
        } else if (th instanceof b) {
            return e.a(5, TimeUnit.SECONDS);
        } else {
            return e.b(th);
        }
    }
}
