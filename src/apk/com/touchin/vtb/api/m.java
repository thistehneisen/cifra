package com.touchin.vtb.api;

import android.content.Context;
import com.bluelinelabs.logansquare.LoganSquare;
import com.bluelinelabs.logansquare.ParameterizedType;
import com.touchin.vtb.api.exceptions.ServerException;
import com.touchin.vtb.b.f;
import com.touchin.vtb.b.i;
import i.C;
import i.C.a;
import i.M;
import i.O;
import java.io.IOException;
import kotlin.e.b.h;
import ru.touchin.templates.b;

/* compiled from: ExceptionsInterceptor.kt */
public final class m implements C {

    /* renamed from: a reason: collision with root package name */
    private final i f7122a;

    /* renamed from: b reason: collision with root package name */
    private final Context f7123b;

    public m(i iVar, Context context) {
        h.b(iVar, "vtbAnalytics");
        h.b(context, "context");
        this.f7122a = iVar;
        this.f7123b = context;
    }

    public M a(a aVar) {
        h.b(aVar, "chain");
        if (!b.b(this.f7123b)) {
            this.f7122a.a(f.NO_NETWORK);
        }
        M a2 = aVar.a(aVar.request());
        h.a((Object) a2, "response");
        IOException a3 = a(a2);
        if (a3 == null) {
            h.a((Object) a2, "chain\n                .p…on -> throw exception } }");
            return a2;
        }
        throw a3;
    }

    private final IOException a(M m) {
        O a2 = m.a();
        if (a2 == null) {
            return null;
        }
        String a3 = com.touchin.vtb.e.i.a(a2);
        if (a3 == null) {
            return null;
        }
        try {
            return m.c() != 200 ? new ServerException(a(a3)) : null;
        } catch (Exception unused) {
            return null;
        }
    }

    private final BaseResponse<?> a(String str) {
        Object parse = LoganSquare.parse(str, (ParameterizedType<E>) new l<E>());
        h.a(parse, "LoganSquare.parse(jsonBo…pe<BaseResponse<*>>() {})");
        return (BaseResponse) parse;
    }
}
