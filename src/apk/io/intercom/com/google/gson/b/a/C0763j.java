package io.intercom.com.google.gson.b.a;

import io.intercom.android.sdk.metrics.MetricTracker.Action;
import io.intercom.com.google.gson.q;
import io.intercom.com.google.gson.stream.d;
import io.intercom.com.google.gson.t;
import io.intercom.com.google.gson.u;
import io.intercom.com.google.gson.v;
import io.intercom.com.google.gson.w;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* renamed from: io.intercom.com.google.gson.b.a.j reason: case insensitive filesystem */
/* compiled from: JsonTreeWriter */
public final class C0763j extends d {

    /* renamed from: l reason: collision with root package name */
    private static final Writer f10052l = new C0762i();
    private static final w m = new w(Action.CLOSED);
    private final List<t> n = new ArrayList();
    private String o;
    private t p = u.f10224a;

    public C0763j() {
        super(f10052l);
    }

    private t D() {
        List<t> list = this.n;
        return (t) list.get(list.size() - 1);
    }

    private void a(t tVar) {
        if (this.o != null) {
            if (!tVar.i() || e()) {
                ((v) D()).a(this.o, tVar);
            }
            this.o = null;
        } else if (this.n.isEmpty()) {
            this.p = tVar;
        } else {
            t D = D();
            if (D instanceof q) {
                ((q) D).a(tVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public d b() throws IOException {
        v vVar = new v();
        a((t) vVar);
        this.n.add(vVar);
        return this;
    }

    public d c() throws IOException {
        if (this.n.isEmpty() || this.o != null) {
            throw new IllegalStateException();
        } else if (D() instanceof q) {
            List<t> list = this.n;
            list.remove(list.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public void close() throws IOException {
        if (this.n.isEmpty()) {
            this.n.add(m);
            return;
        }
        throw new IOException("Incomplete document");
    }

    public d d() throws IOException {
        if (this.n.isEmpty() || this.o != null) {
            throw new IllegalStateException();
        } else if (D() instanceof v) {
            List<t> list = this.n;
            list.remove(list.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public void flush() throws IOException {
    }

    public d h() throws IOException {
        a((t) u.f10224a);
        return this;
    }

    public t i() {
        if (this.n.isEmpty()) {
            return this.p;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected one JSON element but was ");
        sb.append(this.n);
        throw new IllegalStateException(sb.toString());
    }

    public d h(long j2) throws IOException {
        a((t) new w((Number) Long.valueOf(j2)));
        return this;
    }

    public d b(String str) throws IOException {
        if (this.n.isEmpty() || this.o != null) {
            throw new IllegalStateException();
        } else if (D() instanceof v) {
            this.o = str;
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public d d(String str) throws IOException {
        if (str == null) {
            h();
            return this;
        }
        a((t) new w(str));
        return this;
    }

    public d d(boolean z) throws IOException {
        a((t) new w(Boolean.valueOf(z)));
        return this;
    }

    public d a() throws IOException {
        q qVar = new q();
        a((t) qVar);
        this.n.add(qVar);
        return this;
    }

    public d a(Boolean bool) throws IOException {
        if (bool == null) {
            h();
            return this;
        }
        a((t) new w(bool));
        return this;
    }

    public d a(Number number) throws IOException {
        if (number == null) {
            h();
            return this;
        }
        if (!g()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                StringBuilder sb = new StringBuilder();
                sb.append("JSON forbids NaN and infinities: ");
                sb.append(number);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        a((t) new w(number));
        return this;
    }
}
