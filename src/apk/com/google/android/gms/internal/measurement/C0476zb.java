package com.google.android.gms.internal.measurement;

import java.lang.reflect.Type;

/* renamed from: com.google.android.gms.internal.measurement.zb reason: case insensitive filesystem */
public enum C0476zb {
    DOUBLE(0, Bb.SCALAR, Pb.DOUBLE),
    FLOAT(1, Bb.SCALAR, Pb.FLOAT),
    INT64(2, Bb.SCALAR, Pb.LONG),
    UINT64(3, Bb.SCALAR, Pb.LONG),
    INT32(4, Bb.SCALAR, Pb.INT),
    FIXED64(5, Bb.SCALAR, Pb.LONG),
    FIXED32(6, Bb.SCALAR, Pb.INT),
    BOOL(7, Bb.SCALAR, Pb.BOOLEAN),
    STRING(8, Bb.SCALAR, Pb.STRING),
    MESSAGE(9, Bb.SCALAR, Pb.MESSAGE),
    BYTES(10, Bb.SCALAR, Pb.BYTE_STRING),
    UINT32(11, Bb.SCALAR, Pb.INT),
    ENUM(12, Bb.SCALAR, Pb.ENUM),
    SFIXED32(13, Bb.SCALAR, Pb.INT),
    SFIXED64(14, Bb.SCALAR, Pb.LONG),
    SINT32(15, Bb.SCALAR, Pb.INT),
    SINT64(16, Bb.SCALAR, Pb.LONG),
    GROUP(17, Bb.SCALAR, Pb.MESSAGE),
    DOUBLE_LIST(18, Bb.VECTOR, Pb.DOUBLE),
    FLOAT_LIST(19, Bb.VECTOR, Pb.FLOAT),
    INT64_LIST(20, Bb.VECTOR, Pb.LONG),
    UINT64_LIST(21, Bb.VECTOR, Pb.LONG),
    INT32_LIST(22, Bb.VECTOR, Pb.INT),
    FIXED64_LIST(23, Bb.VECTOR, Pb.LONG),
    FIXED32_LIST(24, Bb.VECTOR, Pb.INT),
    BOOL_LIST(25, Bb.VECTOR, Pb.BOOLEAN),
    STRING_LIST(26, Bb.VECTOR, Pb.STRING),
    MESSAGE_LIST(27, Bb.VECTOR, Pb.MESSAGE),
    BYTES_LIST(28, Bb.VECTOR, Pb.BYTE_STRING),
    UINT32_LIST(29, Bb.VECTOR, Pb.INT),
    ENUM_LIST(30, Bb.VECTOR, Pb.ENUM),
    SFIXED32_LIST(31, Bb.VECTOR, Pb.INT),
    SFIXED64_LIST(32, Bb.VECTOR, Pb.LONG),
    SINT32_LIST(33, Bb.VECTOR, Pb.INT),
    SINT64_LIST(34, Bb.VECTOR, Pb.LONG),
    DOUBLE_LIST_PACKED(35, Bb.PACKED_VECTOR, Pb.DOUBLE),
    FLOAT_LIST_PACKED(36, Bb.PACKED_VECTOR, Pb.FLOAT),
    INT64_LIST_PACKED(37, Bb.PACKED_VECTOR, Pb.LONG),
    UINT64_LIST_PACKED(38, Bb.PACKED_VECTOR, Pb.LONG),
    INT32_LIST_PACKED(39, Bb.PACKED_VECTOR, Pb.INT),
    FIXED64_LIST_PACKED(40, Bb.PACKED_VECTOR, Pb.LONG),
    FIXED32_LIST_PACKED(41, Bb.PACKED_VECTOR, Pb.INT),
    BOOL_LIST_PACKED(42, Bb.PACKED_VECTOR, Pb.BOOLEAN),
    UINT32_LIST_PACKED(43, Bb.PACKED_VECTOR, Pb.INT),
    ENUM_LIST_PACKED(44, Bb.PACKED_VECTOR, Pb.ENUM),
    SFIXED32_LIST_PACKED(45, Bb.PACKED_VECTOR, Pb.INT),
    SFIXED64_LIST_PACKED(46, Bb.PACKED_VECTOR, Pb.LONG),
    SINT32_LIST_PACKED(47, Bb.PACKED_VECTOR, Pb.INT),
    SINT64_LIST_PACKED(48, Bb.PACKED_VECTOR, Pb.LONG),
    GROUP_LIST(49, Bb.VECTOR, Pb.MESSAGE),
    MAP(50, Bb.MAP, Pb.VOID);
    
    private static final C0476zb[] Z = null;
    private static final Type[] aa = null;
    private final int id;
    private final Pb zzahf;
    private final Bb zzahg;
    private final Class<?> zzahh;
    private final boolean zzahi;

    static {
        int i2;
        aa = new Type[0];
        C0476zb[] values = values();
        Z = new C0476zb[values.length];
        for (C0476zb zbVar : values) {
            Z[zbVar.id] = zbVar;
        }
    }

    private C0476zb(int i2, Bb bb, Pb pb) {
        this.id = i2;
        this.zzahg = bb;
        this.zzahf = pb;
        int i3 = C0470yb.f5425a[bb.ordinal()];
        if (i3 == 1) {
            this.zzahh = pb.a();
        } else if (i3 != 2) {
            this.zzahh = null;
        } else {
            this.zzahh = pb.a();
        }
        boolean z = false;
        if (bb == Bb.SCALAR) {
            int i4 = C0470yb.f5426b[pb.ordinal()];
            if (!(i4 == 1 || i4 == 2 || i4 == 3)) {
                z = true;
            }
        }
        this.zzahi = z;
    }

    public final int a() {
        return this.id;
    }
}
