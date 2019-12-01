package com.fasterxml.jackson.core;

/* compiled from: JsonEncoding */
public enum a {
    UTF8("UTF-8", false, 8),
    UTF16_BE("UTF-16BE", true, 16),
    UTF16_LE("UTF-16LE", false, 16),
    UTF32_BE("UTF-32BE", true, 32),
    UTF32_LE("UTF-32LE", false, 32);
    
    protected final boolean _bigEndian;
    protected final int _bits;
    protected final String _javaName;

    private a(String str, boolean z, int i2) {
        this._javaName = str;
        this._bigEndian = z;
        this._bits = i2;
    }

    public int a() {
        return this._bits;
    }

    public String b() {
        return this._javaName;
    }

    public boolean c() {
        return this._bigEndian;
    }
}
