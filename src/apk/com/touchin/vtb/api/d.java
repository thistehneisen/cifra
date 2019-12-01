package com.touchin.vtb.api;

import com.touchin.vtb.api.exceptions.ServerException;
import com.touchin.vtb.b.f;
import com.touchin.vtb.b.i;
import i.O;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.e.b.h;
import retrofit2.e;
import retrofit2.w;
import ru.touchin.templates.a.c;

/* compiled from: ApiJsonFactory.kt */
public final class d extends c {

    /* renamed from: a reason: collision with root package name */
    private final i f7115a;

    /* compiled from: ApiJsonFactory.kt */
    public final class a<T> extends ru.touchin.templates.a.c.a<T> {

        /* renamed from: b reason: collision with root package name */
        final /* synthetic */ d f7116b;

        public a(d dVar, Type type) {
            h.b(type, "type");
            this.f7116b = dVar;
            super(type);
        }

        /* renamed from: a */
        public T convert(O o) {
            h.b(o, "value");
            T a2 = super.convert(o);
            if (a2 instanceof BaseResponse) {
                BaseResponse baseResponse = (BaseResponse) a2;
                if (baseResponse.c() != null) {
                    ServerException serverException = new ServerException(baseResponse);
                    a(serverException.a());
                    throw serverException;
                }
            }
            return a2;
        }

        private final void a(ApiError apiError) {
            f fVar;
            i a2 = this.f7116b.a();
            int i2 = c.f7114a[apiError.ordinal()];
            if (i2 == 1) {
                fVar = f.BANK_CONNECTION_FAILED;
            } else if (i2 != 2) {
                fVar = f.FAILED_TO_LOAD_DATA;
            } else {
                fVar = f.SESSION_EXPIRED;
            }
            a2.a(fVar);
        }
    }

    public d(i iVar) {
        h.b(iVar, "vtbAnalytics");
        this.f7115a = iVar;
    }

    public final i a() {
        return this.f7115a;
    }

    public e<O, ?> a(Type type, Annotation[] annotationArr, w wVar) {
        h.b(type, "type");
        h.b(annotationArr, "annotations");
        h.b(wVar, "retrofit");
        return new a(this, type);
    }
}
