package com.fasterxml.jackson.core;

import java.io.Serializable;

/* compiled from: JsonLocation */
public class d implements Serializable {

    /* renamed from: a reason: collision with root package name */
    public static final d f4292a;
    private static final long serialVersionUID = 1;
    final int _columnNr;
    final int _lineNr;
    final long _totalBytes;
    final long _totalChars;

    /* renamed from: b reason: collision with root package name */
    final transient Object f4293b;

    static {
        d dVar = new d("N/A", -1, -1, -1, -1);
        f4292a = dVar;
    }

    public d(Object obj, long j2, int i2, int i3) {
        this(obj, -1, j2, i2, i3);
    }

    public long a() {
        return this._totalBytes;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        Object obj2 = this.f4293b;
        if (obj2 == null) {
            if (dVar.f4293b != null) {
                return false;
            }
        } else if (!obj2.equals(dVar.f4293b)) {
            return false;
        }
        if (!(this._lineNr == dVar._lineNr && this._columnNr == dVar._columnNr && this._totalChars == dVar._totalChars && a() == dVar.a())) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        Object obj = this.f4293b;
        return ((((obj == null ? 1 : obj.hashCode()) ^ this._lineNr) + this._columnNr) ^ ((int) this._totalChars)) + ((int) this._totalBytes);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(80);
        sb.append("[Source: ");
        Object obj = this.f4293b;
        if (obj == null) {
            sb.append("UNKNOWN");
        } else {
            sb.append(obj.toString());
        }
        sb.append("; line: ");
        sb.append(this._lineNr);
        sb.append(", column: ");
        sb.append(this._columnNr);
        sb.append(']');
        return sb.toString();
    }

    public d(Object obj, long j2, long j3, int i2, int i3) {
        this.f4293b = obj;
        this._totalBytes = j2;
        this._totalChars = j3;
        this._lineNr = i2;
        this._columnNr = i3;
    }
}
