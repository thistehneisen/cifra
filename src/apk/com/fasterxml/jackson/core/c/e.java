package com.fasterxml.jackson.core.c;

import com.appsflyer.share.Constants;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.f;

/* compiled from: JsonWriteContext */
public class e extends f {

    /* renamed from: c reason: collision with root package name */
    protected final e f4286c;

    /* renamed from: d reason: collision with root package name */
    protected b f4287d;

    /* renamed from: e reason: collision with root package name */
    protected e f4288e = null;

    /* renamed from: f reason: collision with root package name */
    protected String f4289f;

    /* renamed from: g reason: collision with root package name */
    protected Object f4290g;

    /* renamed from: h reason: collision with root package name */
    protected boolean f4291h;

    protected e(int i2, e eVar, b bVar) {
        this.f4390a = i2;
        this.f4286c = eVar;
        this.f4287d = bVar;
        this.f4391b = -1;
    }

    /* access modifiers changed from: protected */
    public e a(int i2) {
        this.f4390a = i2;
        this.f4391b = -1;
        this.f4289f = null;
        this.f4291h = false;
        this.f4290g = null;
        b bVar = this.f4287d;
        if (bVar != null) {
            bVar.c();
        }
        return this;
    }

    public e g() {
        e eVar = this.f4288e;
        if (eVar == null) {
            b bVar = this.f4287d;
            e eVar2 = new e(1, this, bVar == null ? null : bVar.a());
            this.f4288e = eVar2;
            return eVar2;
        }
        eVar.a(1);
        return eVar;
    }

    public e h() {
        e eVar = this.f4288e;
        if (eVar == null) {
            b bVar = this.f4287d;
            e eVar2 = new e(2, this, bVar == null ? null : bVar.a());
            this.f4288e = eVar2;
            return eVar2;
        }
        eVar.a(2);
        return eVar;
    }

    public final e i() {
        return this.f4286c;
    }

    public int j() {
        int i2 = this.f4390a;
        int i3 = 0;
        if (i2 == 2) {
            this.f4291h = false;
            this.f4391b++;
            return 2;
        } else if (i2 == 1) {
            int i4 = this.f4391b;
            this.f4391b = i4 + 1;
            if (i4 >= 0) {
                i3 = 1;
            }
            return i3;
        } else {
            this.f4391b++;
            if (this.f4391b != 0) {
                i3 = 3;
            }
            return i3;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        a(sb);
        return sb.toString();
    }

    public static e a(b bVar) {
        return new e(0, null, bVar);
    }

    public int a(String str) throws JsonProcessingException {
        if (this.f4291h) {
            return 4;
        }
        int i2 = 1;
        this.f4291h = true;
        this.f4289f = str;
        b bVar = this.f4287d;
        if (bVar != null) {
            a(bVar, str);
        }
        if (this.f4391b < 0) {
            i2 = 0;
        }
        return i2;
    }

    private final void a(b bVar, String str) throws JsonProcessingException {
        if (bVar.a(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Duplicate field '");
            sb.append(str);
            sb.append("'");
            throw new JsonGenerationException(sb.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void a(StringBuilder sb) {
        int i2 = this.f4390a;
        if (i2 == 2) {
            sb.append('{');
            if (this.f4289f != null) {
                sb.append('\"');
                sb.append(this.f4289f);
                sb.append('\"');
            } else {
                sb.append('?');
            }
            sb.append('}');
        } else if (i2 == 1) {
            sb.append('[');
            sb.append(a());
            sb.append(']');
        } else {
            sb.append(Constants.URL_PATH_DELIMITER);
        }
    }
}
