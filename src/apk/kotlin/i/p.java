package kotlin.i;

import java.util.List;
import kotlin.e.a.c;
import kotlin.e.b.h;
import kotlin.e.b.i;
import kotlin.g;
import kotlin.k;

/* compiled from: Strings.kt */
final class p extends i implements c<CharSequence, Integer, g<? extends Integer, ? extends Integer>> {
    final /* synthetic */ List $delimitersList;
    final /* synthetic */ boolean $ignoreCase;

    p(List list, boolean z) {
        this.$delimitersList = list;
        this.$ignoreCase = z;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object a(Object obj, Object obj2) {
        return a((CharSequence) obj, ((Number) obj2).intValue());
    }

    public final g<Integer, Integer> a(CharSequence charSequence, int i2) {
        h.b(charSequence, "$receiver");
        g a2 = s.b(charSequence, this.$delimitersList, i2, this.$ignoreCase, false);
        if (a2 != null) {
            return k.a(a2.c(), Integer.valueOf(((String) a2.d()).length()));
        }
        return null;
    }
}
