package kotlin.c;

import kotlin.c.f.b;
import kotlin.e.b.h;
import kotlin.e.b.i;

/* compiled from: CoroutineContextImpl.kt */
final class c extends i implements kotlin.e.a.c<String, b, String> {

    /* renamed from: a reason: collision with root package name */
    public static final c f10296a = new c();

    c() {
        super(2);
    }

    public final String a(String str, b bVar) {
        h.b(str, "acc");
        h.b(bVar, "element");
        if (str.length() == 0) {
            return bVar.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(", ");
        sb.append(bVar);
        return sb.toString();
    }
}
