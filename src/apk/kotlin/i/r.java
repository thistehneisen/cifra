package kotlin.i;

import kotlin.e.a.b;
import kotlin.e.b.h;
import kotlin.e.b.i;
import kotlin.f.d;

/* compiled from: Strings.kt */
final class r extends i implements b<d, String> {
    final /* synthetic */ CharSequence $this_splitToSequence;

    r(CharSequence charSequence) {
        this.$this_splitToSequence = charSequence;
        super(1);
    }

    public final String a(d dVar) {
        h.b(dVar, "it");
        return s.a(this.$this_splitToSequence, dVar);
    }
}
