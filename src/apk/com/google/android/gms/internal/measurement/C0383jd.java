package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.jd reason: case insensitive filesystem */
public enum C0383jd {
    DOUBLE(C0401md.DOUBLE, 1),
    FLOAT(C0401md.FLOAT, 5),
    INT64(C0401md.LONG, 0),
    UINT64(C0401md.LONG, 0),
    INT32(C0401md.INT, 0),
    FIXED64(C0401md.LONG, 1),
    FIXED32(C0401md.INT, 5),
    BOOL(C0401md.BOOLEAN, 0),
    STRING(C0401md.STRING, 2),
    GROUP(C0401md.MESSAGE, 3),
    MESSAGE(C0401md.MESSAGE, 2),
    BYTES(C0401md.BYTE_STRING, 2),
    UINT32(C0401md.INT, 0),
    ENUM(C0401md.ENUM, 0),
    SFIXED32(C0401md.INT, 5),
    SFIXED64(C0401md.LONG, 1),
    SINT32(C0401md.INT, 0),
    SINT64(C0401md.LONG, 0);
    
    private final C0401md zzant;
    private final int zzanu;

    private C0383jd(C0401md mdVar, int i2) {
        this.zzant = mdVar;
        this.zzanu = i2;
    }

    public final C0401md a() {
        return this.zzant;
    }
}
