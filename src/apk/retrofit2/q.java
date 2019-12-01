package retrofit2;

import java.io.IOException;
import java.lang.reflect.Array;

/* compiled from: ParameterHandler */
class q extends r<Object> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ r f11021a;

    q(r rVar) {
        this.f11021a = rVar;
    }

    /* access modifiers changed from: 0000 */
    public void a(t tVar, Object obj) throws IOException {
        if (obj != null) {
            int length = Array.getLength(obj);
            for (int i2 = 0; i2 < length; i2++) {
                this.f11021a.a(tVar, Array.get(obj, i2));
            }
        }
    }
}
