package kotlin.i;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.TypeCastException;
import kotlin.e.b.a.a;
import kotlin.f.d;
import kotlin.g;

/* compiled from: Strings.kt */
public final class c implements Iterator<d>, a {

    /* renamed from: a reason: collision with root package name */
    private int f10333a = -1;

    /* renamed from: b reason: collision with root package name */
    private int f10334b;

    /* renamed from: c reason: collision with root package name */
    private int f10335c;

    /* renamed from: d reason: collision with root package name */
    private d f10336d;

    /* renamed from: e reason: collision with root package name */
    private int f10337e;

    /* renamed from: f reason: collision with root package name */
    final /* synthetic */ d f10338f;

    c(d dVar) {
        this.f10338f = dVar;
        this.f10334b = h.a(dVar.f10340b, 0, dVar.f10339a.length());
        this.f10335c = this.f10334b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
        if (r6.f10337e < r6.f10338f.f10341c) goto L_0x0025;
     */
    private final void a() {
        int i2 = 0;
        if (this.f10335c < 0) {
            this.f10333a = 0;
            this.f10336d = null;
            return;
        }
        if (this.f10338f.f10341c > 0) {
            this.f10337e++;
        }
        if (this.f10335c <= this.f10338f.f10339a.length()) {
            g gVar = (g) this.f10338f.f10342d.a(this.f10338f.f10339a, Integer.valueOf(this.f10335c));
            if (gVar == null) {
                this.f10336d = new d(this.f10334b, s.c(this.f10338f.f10339a));
                this.f10335c = -1;
            } else {
                int intValue = ((Number) gVar.a()).intValue();
                int intValue2 = ((Number) gVar.b()).intValue();
                this.f10336d = h.d(this.f10334b, intValue);
                this.f10334b = intValue + intValue2;
                int i3 = this.f10334b;
                if (intValue2 == 0) {
                    i2 = 1;
                }
                this.f10335c = i3 + i2;
            }
            this.f10333a = 1;
        }
        this.f10336d = new d(this.f10334b, s.c(this.f10338f.f10339a));
        this.f10335c = -1;
        this.f10333a = 1;
    }

    public boolean hasNext() {
        if (this.f10333a == -1) {
            a();
        }
        return this.f10333a == 1;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public d next() {
        if (this.f10333a == -1) {
            a();
        }
        if (this.f10333a != 0) {
            d dVar = this.f10336d;
            if (dVar != null) {
                this.f10336d = null;
                this.f10333a = -1;
                return dVar;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
        }
        throw new NoSuchElementException();
    }
}
