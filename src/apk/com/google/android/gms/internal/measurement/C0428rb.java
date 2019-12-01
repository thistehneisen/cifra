package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.Eb.e;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.rb reason: case insensitive filesystem */
public class C0428rb {

    /* renamed from: a reason: collision with root package name */
    private static final Class<?> f5349a = d();

    /* renamed from: b reason: collision with root package name */
    private static volatile C0428rb f5350b;

    /* renamed from: c reason: collision with root package name */
    private static volatile C0428rb f5351c;

    /* renamed from: d reason: collision with root package name */
    static final C0428rb f5352d = new C0428rb(true);

    /* renamed from: e reason: collision with root package name */
    private final Map<a, e<?, ?>> f5353e;

    /* renamed from: com.google.android.gms.internal.measurement.rb$a */
    static final class a {

        /* renamed from: a reason: collision with root package name */
        private final Object f5354a;

        /* renamed from: b reason: collision with root package name */
        private final int f5355b;

        a(Object obj, int i2) {
            this.f5354a = obj;
            this.f5355b = i2;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f5354a == aVar.f5354a && this.f5355b == aVar.f5355b) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f5354a) * 65535) + this.f5355b;
        }
    }

    C0428rb() {
        this.f5353e = new HashMap();
    }

    static C0428rb a() {
        return Db.a(C0428rb.class);
    }

    public static C0428rb b() {
        C0428rb rbVar = f5350b;
        if (rbVar == null) {
            synchronized (C0428rb.class) {
                rbVar = f5350b;
                if (rbVar == null) {
                    rbVar = C0417pb.a();
                    f5350b = rbVar;
                }
            }
        }
        return rbVar;
    }

    public static C0428rb c() {
        C0428rb rbVar = f5351c;
        if (rbVar == null) {
            synchronized (C0428rb.class) {
                rbVar = f5351c;
                if (rbVar == null) {
                    rbVar = C0417pb.b();
                    f5351c = rbVar;
                }
            }
        }
        return rbVar;
    }

    private static Class<?> d() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public final <ContainingType extends C0400mc> e<ContainingType, ?> a(ContainingType containingtype, int i2) {
        return (e) this.f5353e.get(new a(containingtype, i2));
    }

    private C0428rb(boolean z) {
        this.f5353e = Collections.emptyMap();
    }
}
