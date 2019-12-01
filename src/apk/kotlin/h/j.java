package kotlin.h;

import kotlin.e.a.b;
import kotlin.e.b.h;

/* compiled from: _Sequences.kt */
class j extends i {
    public static final <T> c<T> a(c<? extends T> cVar, b<? super T, Boolean> bVar) {
        h.b(cVar, "$this$filter");
        h.b(bVar, "predicate");
        return new b(cVar, true, bVar);
    }

    public static <T, R> c<R> b(c<? extends T> cVar, b<? super T, ? extends R> bVar) {
        h.b(cVar, "$this$map");
        h.b(bVar, "transform");
        return new l(cVar, bVar);
    }

    public static final <T, A extends Appendable> A a(c<? extends T> cVar, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, b<? super T, ? extends CharSequence> bVar) {
        h.b(cVar, "$this$joinTo");
        h.b(a2, "buffer");
        h.b(charSequence, "separator");
        h.b(charSequence2, "prefix");
        h.b(charSequence3, "postfix");
        h.b(charSequence4, "truncated");
        a2.append(charSequence2);
        int i3 = 0;
        for (Object next : cVar) {
            i3++;
            if (i3 > 1) {
                a2.append(charSequence);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            k.a(a2, next, bVar);
        }
        if (i2 >= 0 && i3 > i2) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static /* synthetic */ String a(c cVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, b bVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i3 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i3 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        int i4 = (i3 & 8) != 0 ? -1 : i2;
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i3 & 32) != 0) {
            bVar = null;
        }
        return a(cVar, charSequence, charSequence6, charSequence5, i4, charSequence7, bVar);
    }

    public static final <T> String a(c<? extends T> cVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, b<? super T, ? extends CharSequence> bVar) {
        h.b(cVar, "$this$joinToString");
        h.b(charSequence, "separator");
        h.b(charSequence2, "prefix");
        h.b(charSequence3, "postfix");
        h.b(charSequence4, "truncated");
        StringBuilder sb = new StringBuilder();
        a(cVar, sb, charSequence, charSequence2, charSequence3, i2, charSequence4, bVar);
        String sb2 = sb.toString();
        h.a((Object) sb2, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb2;
    }
}
