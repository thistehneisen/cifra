package com.fasterxml.jackson.core;

/* compiled from: JsonToken */
public enum g {
    NOT_AVAILABLE(null, -1),
    START_OBJECT("{", 1),
    END_OBJECT("}", 2),
    START_ARRAY("[", 3),
    END_ARRAY("]", 4),
    FIELD_NAME(null, 5),
    VALUE_EMBEDDED_OBJECT(null, 12),
    VALUE_STRING(null, 6),
    VALUE_NUMBER_INT(null, 7),
    VALUE_NUMBER_FLOAT(null, 8),
    VALUE_TRUE("true", 9),
    VALUE_FALSE("false", 10),
    VALUE_NULL("null", 11);
    
    final int _id;
    final boolean _isBoolean;
    final boolean _isNumber;
    final boolean _isScalar;
    final boolean _isStructEnd;
    final boolean _isStructStart;
    final String _serialized;
    final byte[] _serializedBytes;
    final char[] _serializedChars;

    private g(String str, int i2) {
        boolean z = false;
        if (str == null) {
            this._serialized = null;
            this._serializedChars = null;
            this._serializedBytes = null;
        } else {
            this._serialized = str;
            this._serializedChars = str.toCharArray();
            int length = this._serializedChars.length;
            this._serializedBytes = new byte[length];
            for (int i3 = 0; i3 < length; i3++) {
                this._serializedBytes[i3] = (byte) this._serializedChars[i3];
            }
        }
        this._id = i2;
        this._isBoolean = i2 == 10 || i2 == 9;
        this._isNumber = i2 == 7 || i2 == 8;
        this._isStructStart = i2 == 1 || i2 == 3;
        this._isStructEnd = i2 == 2 || i2 == 4;
        if (!this._isStructStart && !this._isStructEnd && i2 != 5 && i2 != -1) {
            z = true;
        }
        this._isScalar = z;
    }

    public final String a() {
        return this._serialized;
    }

    public final int b() {
        return this._id;
    }

    public final boolean c() {
        return this._isScalar;
    }

    public final boolean d() {
        return this._isStructEnd;
    }

    public final boolean e() {
        return this._isStructStart;
    }
}
