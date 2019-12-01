package kotlin.i;

import kotlin.e.a.c;
import kotlin.e.b.h;
import kotlin.e.b.i;
import kotlin.g;
import kotlin.k;

/* compiled from: Strings.kt */
final class o extends i implements c<CharSequence, Integer, g<? extends Integer, ? extends Integer>> {
    final /* synthetic */ char[] $delimiters;
    final /* synthetic */ boolean $ignoreCase;

    o(char[] cArr, boolean z) {
        this.$delimiters = cArr;
        this.$ignoreCase = z;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object a(Object obj, Object obj2) {
        return a((CharSequence) obj, ((Number) obj2).intValue());
    }

    public final g<Integer, Integer> a(CharSequence charSequence, int i2) {
        h.b(charSequence, "$receiver");
        int a2 = s.a(charSequence, this.$delimiters, i2, this.$ignoreCase);
        if (a2 < 0) {
            return null;
        }
        return k.a(Integer.valueOf(a2), Integer.valueOf(1));
    }
}
