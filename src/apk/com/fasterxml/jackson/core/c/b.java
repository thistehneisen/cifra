package com.fasterxml.jackson.core.c;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.d;
import com.fasterxml.jackson.core.e;
import java.util.HashSet;

/* compiled from: DupDetector */
public class b {

    /* renamed from: a reason: collision with root package name */
    protected final Object f4270a;

    /* renamed from: b reason: collision with root package name */
    protected String f4271b;

    /* renamed from: c reason: collision with root package name */
    protected String f4272c;

    /* renamed from: d reason: collision with root package name */
    protected HashSet<String> f4273d;

    private b(Object obj) {
        this.f4270a = obj;
    }

    public static b a(e eVar) {
        return new b(eVar);
    }

    public d b() {
        Object obj = this.f4270a;
        if (obj instanceof e) {
            return ((e) obj).b();
        }
        return null;
    }

    public void c() {
        this.f4271b = null;
        this.f4272c = null;
        this.f4273d = null;
    }

    public static b a(c cVar) {
        return new b(cVar);
    }

    public b a() {
        return new b(this.f4270a);
    }

    public boolean a(String str) throws JsonParseException {
        String str2 = this.f4271b;
        if (str2 == null) {
            this.f4271b = str;
            return false;
        } else if (str.equals(str2)) {
            return true;
        } else {
            String str3 = this.f4272c;
            if (str3 == null) {
                this.f4272c = str;
                return false;
            } else if (str.equals(str3)) {
                return true;
            } else {
                if (this.f4273d == null) {
                    this.f4273d = new HashSet<>(16);
                    this.f4273d.add(this.f4271b);
                    this.f4273d.add(this.f4272c);
                }
                return !this.f4273d.add(str);
            }
        }
    }
}
