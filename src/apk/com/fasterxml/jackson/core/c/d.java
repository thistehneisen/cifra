package com.fasterxml.jackson.core.c;

import com.appsflyer.share.Constants;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.b.a;
import com.fasterxml.jackson.core.f;

/* compiled from: JsonReadContext */
public final class d extends f {

    /* renamed from: c reason: collision with root package name */
    protected final d f4279c;

    /* renamed from: d reason: collision with root package name */
    protected b f4280d;

    /* renamed from: e reason: collision with root package name */
    protected d f4281e = null;

    /* renamed from: f reason: collision with root package name */
    protected String f4282f;

    /* renamed from: g reason: collision with root package name */
    protected Object f4283g;

    /* renamed from: h reason: collision with root package name */
    protected int f4284h;

    /* renamed from: i reason: collision with root package name */
    protected int f4285i;

    public d(d dVar, b bVar, int i2, int i3, int i4) {
        this.f4279c = dVar;
        this.f4280d = bVar;
        this.f4390a = i2;
        this.f4284h = i3;
        this.f4285i = i4;
        this.f4391b = -1;
    }

    /* access modifiers changed from: protected */
    public void a(int i2, int i3, int i4) {
        this.f4390a = i2;
        this.f4391b = -1;
        this.f4284h = i3;
        this.f4285i = i4;
        this.f4282f = null;
        this.f4283g = null;
        b bVar = this.f4280d;
        if (bVar != null) {
            bVar.c();
        }
    }

    public d b(int i2, int i3) {
        d dVar = this.f4281e;
        if (dVar == null) {
            b bVar = this.f4280d;
            d dVar2 = new d(this, bVar == null ? null : bVar.a(), 2, i2, i3);
            this.f4281e = dVar2;
            return dVar2;
        }
        dVar.a(2, i2, i3);
        return dVar;
    }

    public boolean g() {
        int i2 = this.f4391b + 1;
        this.f4391b = i2;
        if (this.f4390a == 0 || i2 <= 0) {
            return false;
        }
        return true;
    }

    public String h() {
        return this.f4282f;
    }

    public d i() {
        return this.f4279c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        int i2 = this.f4390a;
        if (i2 == 0) {
            sb.append(Constants.URL_PATH_DELIMITER);
        } else if (i2 == 1) {
            sb.append('[');
            sb.append(a());
            sb.append(']');
        } else if (i2 == 2) {
            sb.append('{');
            if (this.f4282f != null) {
                sb.append('\"');
                a.a(sb, this.f4282f);
                sb.append('\"');
            } else {
                sb.append('?');
            }
            sb.append('}');
        }
        return sb.toString();
    }

    public static d a(b bVar) {
        d dVar = new d(null, bVar, 0, 1, 0);
        return dVar;
    }

    public d a(int i2, int i3) {
        d dVar = this.f4281e;
        if (dVar == null) {
            b bVar = this.f4280d;
            dVar = new d(this, bVar == null ? null : bVar.a(), 1, i2, i3);
            this.f4281e = dVar;
        } else {
            dVar.a(1, i2, i3);
        }
        return dVar;
    }

    public com.fasterxml.jackson.core.d a(Object obj) {
        com.fasterxml.jackson.core.d dVar = new com.fasterxml.jackson.core.d(obj, -1, this.f4284h, this.f4285i);
        return dVar;
    }

    public void a(String str) throws JsonProcessingException {
        this.f4282f = str;
        b bVar = this.f4280d;
        if (bVar != null) {
            a(bVar, str);
        }
    }

    private void a(b bVar, String str) throws JsonProcessingException {
        if (bVar.a(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Duplicate field '");
            sb.append(str);
            sb.append("'");
            throw new JsonParseException(sb.toString(), bVar.b());
        }
    }
}
