package kotlin.e.b;

import kotlin.g.e;

/* compiled from: PropertyReference1Impl */
public class l extends k {
    private final String name;
    private final e owner;
    private final String signature;

    public l(e eVar, String str, String str2) {
        this.owner = eVar;
        this.name = str;
        this.signature = str2;
    }

    public String f() {
        return this.name;
    }

    public e g() {
        return this.owner;
    }

    public Object get(Object obj) {
        return a().a(obj);
    }

    public String i() {
        return this.signature;
    }
}
