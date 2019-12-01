package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.google.android.gms.common.internal.p reason: case insensitive filesystem */
public final class C0321p {

    /* renamed from: com.google.android.gms.common.internal.p$a */
    public static final class a {

        /* renamed from: a reason: collision with root package name */
        private final List<String> f4756a;

        /* renamed from: b reason: collision with root package name */
        private final Object f4757b;

        private a(Object obj) {
            q.a(obj);
            this.f4757b = obj;
            this.f4756a = new ArrayList();
        }

        public final a a(String str, Object obj) {
            List<String> list = this.f4756a;
            q.a(str);
            String str2 = str;
            String valueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(valueOf).length());
            sb.append(str2);
            sb.append("=");
            sb.append(valueOf);
            list.add(sb.toString());
            return this;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.f4757b.getClass().getSimpleName());
            sb.append('{');
            int size = this.f4756a.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append((String) this.f4756a.get(i2));
                if (i2 < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a a(Object obj) {
        return new a(obj);
    }
}
