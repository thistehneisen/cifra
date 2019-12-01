package io.intercom.com.google.gson;

import io.intercom.com.google.gson.b.C0753a;
import io.intercom.com.google.gson.b.u;
import java.math.BigInteger;

/* compiled from: JsonPrimitive */
public final class w extends t {

    /* renamed from: a reason: collision with root package name */
    private static final Class<?>[] f10226a = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};

    /* renamed from: b reason: collision with root package name */
    private Object f10227b;

    public w(Boolean bool) {
        a((Object) bool);
    }

    private static boolean b(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class cls = obj.getClass();
        for (Class<?> isAssignableFrom : f10226a) {
            if (isAssignableFrom.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public void a(Object obj) {
        if (obj instanceof Character) {
            this.f10227b = String.valueOf(((Character) obj).charValue());
            return;
        }
        C0753a.a((obj instanceof Number) || b(obj));
        this.f10227b = obj;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || w.class != obj.getClass()) {
            return false;
        }
        w wVar = (w) obj;
        if (this.f10227b == null) {
            if (wVar.f10227b != null) {
                z = false;
            }
            return z;
        } else if (a(this) && a(wVar)) {
            if (q().longValue() != wVar.q().longValue()) {
                z = false;
            }
            return z;
        } else if (!(this.f10227b instanceof Number) || !(wVar.f10227b instanceof Number)) {
            return this.f10227b.equals(wVar.f10227b);
        } else {
            double doubleValue = q().doubleValue();
            double doubleValue2 = wVar.q().doubleValue();
            if (doubleValue != doubleValue2 && (!Double.isNaN(doubleValue) || !Double.isNaN(doubleValue2))) {
                z = false;
            }
            return z;
        }
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.f10227b == null) {
            return 31;
        }
        if (a(this)) {
            doubleToLongBits = q().longValue();
        } else {
            Object obj = this.f10227b;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(q().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public boolean l() {
        if (s()) {
            return m().booleanValue();
        }
        return Boolean.parseBoolean(r());
    }

    /* access modifiers changed from: 0000 */
    public Boolean m() {
        return (Boolean) this.f10227b;
    }

    public double n() {
        return t() ? q().doubleValue() : Double.parseDouble(r());
    }

    public int o() {
        return t() ? q().intValue() : Integer.parseInt(r());
    }

    public long p() {
        return t() ? q().longValue() : Long.parseLong(r());
    }

    public Number q() {
        Object obj = this.f10227b;
        return obj instanceof String ? new u((String) obj) : (Number) obj;
    }

    public String r() {
        if (t()) {
            return q().toString();
        }
        if (s()) {
            return m().toString();
        }
        return (String) this.f10227b;
    }

    public boolean s() {
        return this.f10227b instanceof Boolean;
    }

    public boolean t() {
        return this.f10227b instanceof Number;
    }

    public boolean u() {
        return this.f10227b instanceof String;
    }

    public w(Number number) {
        a((Object) number);
    }

    public w(String str) {
        a((Object) str);
    }

    private static boolean a(w wVar) {
        Object obj = wVar.f10227b;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        if ((number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return true;
        }
        return false;
    }
}
