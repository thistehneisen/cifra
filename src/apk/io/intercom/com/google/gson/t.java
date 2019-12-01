package io.intercom.com.google.gson;

import io.intercom.com.google.gson.b.B;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;
import java.io.StringWriter;

/* compiled from: JsonElement */
public abstract class t {
    public q e() {
        if (h()) {
            return (q) this;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Not a JSON Array: ");
        sb.append(this);
        throw new IllegalStateException(sb.toString());
    }

    public v f() {
        if (j()) {
            return (v) this;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Not a JSON Object: ");
        sb.append(this);
        throw new IllegalStateException(sb.toString());
    }

    public w g() {
        if (k()) {
            return (w) this;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Not a JSON Primitive: ");
        sb.append(this);
        throw new IllegalStateException(sb.toString());
    }

    public boolean h() {
        return this instanceof q;
    }

    public boolean i() {
        return this instanceof u;
    }

    public boolean j() {
        return this instanceof v;
    }

    public boolean k() {
        return this instanceof w;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            d dVar = new d(stringWriter);
            dVar.b(true);
            B.a(this, dVar);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
