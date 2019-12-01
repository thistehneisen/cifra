package com.fasterxml.jackson.core.b;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* compiled from: SerializedString */
public class j implements com.fasterxml.jackson.core.j, Serializable {
    protected char[] _quotedChars;
    protected byte[] _quotedUTF8Ref;
    protected byte[] _unquotedUTF8Ref;
    protected final String _value;

    /* renamed from: a reason: collision with root package name */
    protected transient String f4231a;

    public j(String str) {
        if (str != null) {
            this._value = str;
            return;
        }
        throw new IllegalStateException("Null String illegal for SerializedString");
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        this.f4231a = objectInputStream.readUTF();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this._value);
    }

    public final byte[] a() {
        byte[] bArr = this._unquotedUTF8Ref;
        if (bArr != null) {
            return bArr;
        }
        byte[] a2 = e.a().a(this._value);
        this._unquotedUTF8Ref = a2;
        return a2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != j.class) {
            return false;
        }
        return this._value.equals(((j) obj)._value);
    }

    public final String getValue() {
        return this._value;
    }

    public final int hashCode() {
        return this._value.hashCode();
    }

    /* access modifiers changed from: protected */
    public Object readResolve() {
        return new j(this.f4231a);
    }

    public final String toString() {
        return this._value;
    }
}
