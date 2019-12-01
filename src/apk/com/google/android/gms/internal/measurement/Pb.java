package com.google.android.gms.internal.measurement;

public enum Pb {
    VOID(Void.class, Void.class, null),
    INT(Integer.TYPE, Integer.class, Integer.valueOf(0)),
    LONG(Long.TYPE, Long.class, Long.valueOf(0)),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, Boolean.valueOf(false)),
    STRING(String.class, String.class, ""),
    BYTE_STRING(Xa.class, Xa.class, Xa.f5082a),
    ENUM(Integer.TYPE, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);
    
    private final Class<?> zzajh;
    private final Class<?> zzaji;
    private final Object zzajj;

    private Pb(Class<?> cls, Class<?> cls2, Object obj) {
        this.zzajh = cls;
        this.zzaji = cls2;
        this.zzajj = obj;
    }

    public final Class<?> a() {
        return this.zzaji;
    }
}
