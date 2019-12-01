package kotlin.i;

import kotlin.e.a.b;
import kotlin.e.b.h;

/* compiled from: StringBuilder.kt */
class k extends j {
    public static <T> void a(Appendable appendable, T t, b<? super T, ? extends CharSequence> bVar) {
        h.b(appendable, "$this$appendElement");
        if (bVar != null) {
            appendable.append((CharSequence) bVar.a(t));
            return;
        }
        if (t != null ? t instanceof CharSequence : true) {
            appendable.append((CharSequence) t);
        } else if (t instanceof Character) {
            appendable.append(((Character) t).charValue());
        } else {
            appendable.append(String.valueOf(t));
        }
    }
}
