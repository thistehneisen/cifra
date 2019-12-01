package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.util.d;
import com.google.android.gms.internal.measurement.C;
import com.google.android.gms.internal.measurement.D;
import com.google.android.gms.internal.measurement.E;
import com.google.android.gms.internal.measurement.F;
import com.google.android.gms.internal.measurement.G;
import com.google.android.gms.internal.measurement.O;
import com.google.android.gms.internal.measurement.P;
import com.google.android.gms.internal.measurement.Q;
import com.google.android.gms.internal.measurement.T;
import com.google.android.gms.internal.measurement.U;
import com.google.android.gms.internal.measurement.V;
import com.google.android.gms.internal.measurement.X;
import com.google.android.gms.internal.measurement.Y;
import com.google.android.gms.internal.measurement.Z;
import com.google.android.gms.internal.measurement.Z.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class Sd extends Ld {
    Sd(Kd kd) {
        super(kd);
    }

    static Object b(Q q, String str) {
        T a2 = a(q, str);
        if (a2 != null) {
            if (a2.p()) {
                return a2.q();
            }
            if (a2.r()) {
                return Long.valueOf(a2.s());
            }
            if (a2.t()) {
                return Double.valueOf(a2.u());
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public final void a(a aVar, Object obj) {
        q.a(obj);
        aVar.j();
        aVar.k();
        aVar.l();
        if (obj instanceof String) {
            aVar.b((String) obj);
        } else if (obj instanceof Long) {
            aVar.b(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            aVar.a(((Double) obj).doubleValue());
        } else {
            e().t().a("Ignoring invalid (type) user attribute value", obj);
        }
    }

    /* access modifiers changed from: 0000 */
    public final byte[] c(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            e().t().a("Failed to gzip content", e2);
            throw e2;
        }
    }

    public final /* bridge */ /* synthetic */ Ib d() {
        return super.d();
    }

    public final /* bridge */ /* synthetic */ C0532kb e() {
        return super.e();
    }

    public final /* bridge */ /* synthetic */ C0576tb f() {
        return super.f();
    }

    public final /* bridge */ /* synthetic */ fe g() {
        return super.g();
    }

    public final /* bridge */ /* synthetic */ void j() {
        super.j();
    }

    public final /* bridge */ /* synthetic */ C0495d k() {
        return super.k();
    }

    public final /* bridge */ /* synthetic */ C0522ib l() {
        return super.l();
    }

    public final /* bridge */ /* synthetic */ Wd m() {
        return super.m();
    }

    public final /* bridge */ /* synthetic */ Sd n() {
        return super.n();
    }

    public final /* bridge */ /* synthetic */ ce o() {
        return super.o();
    }

    public final /* bridge */ /* synthetic */ ke p() {
        return super.p();
    }

    public final /* bridge */ /* synthetic */ Jb q() {
        return super.q();
    }

    /* access modifiers changed from: protected */
    public final boolean u() {
        return false;
    }

    /* access modifiers changed from: 0000 */
    public final List<Integer> v() {
        Map a2 = C0535l.a(this.f5601b.a());
        if (a2 == null || a2.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int intValue = ((Integer) C0535l.X.a(null)).intValue();
        Iterator it = a2.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Entry entry = (Entry) it.next();
            if (((String) entry.getKey()).startsWith("measurement.id.")) {
                try {
                    int parseInt = Integer.parseInt((String) entry.getValue());
                    if (parseInt != 0) {
                        arrayList.add(Integer.valueOf(parseInt));
                        if (arrayList.size() >= intValue) {
                            e().w().a("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                            break;
                        }
                    } else {
                        continue;
                    }
                } catch (NumberFormatException e2) {
                    e().w().a("Experiment ID NumberFormatException", e2);
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    /* access modifiers changed from: 0000 */
    public final byte[] b(byte[] bArr) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e2) {
            e().t().a("Failed to ungzip content", e2);
            throw e2;
        }
    }

    public final /* bridge */ /* synthetic */ d c() {
        return super.c();
    }

    /* access modifiers changed from: 0000 */
    public final void a(T.a aVar, Object obj) {
        q.a(obj);
        aVar.j();
        aVar.k();
        aVar.l();
        if (obj instanceof String) {
            aVar.b((String) obj);
        } else if (obj instanceof Long) {
            aVar.a(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            aVar.a(((Double) obj).doubleValue());
        } else {
            e().t().a("Ignoring invalid (type) event param value", obj);
        }
    }

    static T a(Q q, String str) {
        for (T t : q.r()) {
            if (t.o().equals(str)) {
                return t;
            }
        }
        return null;
    }

    public final /* bridge */ /* synthetic */ ee b() {
        return super.b();
    }

    static void a(Q.a aVar, String str, Object obj) {
        List l2 = aVar.l();
        int i2 = 0;
        while (true) {
            if (i2 >= l2.size()) {
                i2 = -1;
                break;
            } else if (str.equals(((T) l2.get(i2)).o())) {
                break;
            } else {
                i2++;
            }
        }
        T.a v = T.v();
        v.a(str);
        if (obj instanceof Long) {
            v.a(((Long) obj).longValue());
        } else if (obj instanceof String) {
            v.b((String) obj);
        } else if (obj instanceof Double) {
            v.a(((Double) obj).doubleValue());
        }
        if (i2 >= 0) {
            aVar.a(i2, v);
        } else {
            aVar.a(v);
        }
    }

    /* access modifiers changed from: 0000 */
    public final String a(U u) {
        if (u == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        Iterator it = u.o().iterator();
        while (true) {
            String str = "}\n";
            if (it.hasNext()) {
                V v = (V) it.next();
                if (v != null) {
                    a(sb, 1);
                    sb.append("bundle {\n");
                    if (v.J()) {
                        a(sb, 1, "protocol_version", (Object) Integer.valueOf(v.K()));
                    }
                    a(sb, 1, "platform", (Object) v.T());
                    if (v.X()) {
                        a(sb, 1, "gmp_version", (Object) Long.valueOf(v.v()));
                    }
                    if (v.Y()) {
                        a(sb, 1, "uploading_gmp_version", (Object) Long.valueOf(v.Z()));
                    }
                    if (v.ua()) {
                        a(sb, 1, "dynamite_version", (Object) Long.valueOf(v.x()));
                    }
                    if (v.na()) {
                        a(sb, 1, "config_version", (Object) Long.valueOf(v.oa()));
                    }
                    a(sb, 1, "gmp_app_id", (Object) v.q());
                    a(sb, 1, "admob_app_id", (Object) v.ta());
                    a(sb, 1, "app_id", (Object) v.s());
                    a(sb, 1, "app_version", (Object) v.t());
                    if (v.ka()) {
                        a(sb, 1, "app_version_major", (Object) Integer.valueOf(v.la()));
                    }
                    a(sb, 1, "firebase_instance_id", (Object) v.p());
                    if (v.da()) {
                        a(sb, 1, "dev_cert_hash", (Object) Long.valueOf(v.w()));
                    }
                    a(sb, 1, "app_store", (Object) v.u());
                    if (v.L()) {
                        a(sb, 1, "upload_timestamp_millis", (Object) Long.valueOf(v.M()));
                    }
                    if (v.N()) {
                        a(sb, 1, "start_timestamp_millis", (Object) Long.valueOf(v.H()));
                    }
                    if (v.O()) {
                        a(sb, 1, "end_timestamp_millis", (Object) Long.valueOf(v.I()));
                    }
                    if (v.P()) {
                        a(sb, 1, "previous_bundle_start_timestamp_millis", (Object) Long.valueOf(v.Q()));
                    }
                    if (v.R()) {
                        a(sb, 1, "previous_bundle_end_timestamp_millis", (Object) Long.valueOf(v.S()));
                    }
                    a(sb, 1, "app_instance_id", (Object) v.o());
                    a(sb, 1, "resettable_device_id", (Object) v.aa());
                    a(sb, 1, "device_id", (Object) v.ma());
                    a(sb, 1, "ds_id", (Object) v.qa());
                    if (v.ba()) {
                        a(sb, 1, "limited_ad_tracking", (Object) Boolean.valueOf(v.ca()));
                    }
                    a(sb, 1, "os_version", (Object) v.r());
                    a(sb, 1, "device_model", (Object) v.U());
                    a(sb, 1, "user_default_language", (Object) v.C());
                    if (v.V()) {
                        a(sb, 1, "time_zone_offset_minutes", (Object) Integer.valueOf(v.W()));
                    }
                    if (v.ea()) {
                        a(sb, 1, "bundle_sequential_index", (Object) Integer.valueOf(v.fa()));
                    }
                    if (v.ha()) {
                        a(sb, 1, "service_upload", (Object) Boolean.valueOf(v.ia()));
                    }
                    a(sb, 1, "health_monitor", (Object) v.ga());
                    if (v.pa() && v.B() != 0) {
                        a(sb, 1, "android_id", (Object) Long.valueOf(v.B()));
                    }
                    if (v.ra()) {
                        a(sb, 1, "retry_counter", (Object) Integer.valueOf(v.sa()));
                    }
                    List<Z> F = v.F();
                    String str2 = "double_value";
                    String str3 = "int_value";
                    String str4 = "string_value";
                    String str5 = "name";
                    int i2 = 2;
                    if (F != null) {
                        for (Z z : F) {
                            if (z != null) {
                                a(sb, 2);
                                sb.append("user_property {\n");
                                a(sb, 2, "set_timestamp_millis", (Object) z.v() ? Long.valueOf(z.w()) : null);
                                a(sb, 2, str5, (Object) l().c(z.o()));
                                a(sb, 2, str4, (Object) z.q());
                                a(sb, 2, str3, (Object) z.r() ? Long.valueOf(z.s()) : null);
                                a(sb, 2, str2, (Object) z.t() ? Double.valueOf(z.u()) : null);
                                a(sb, 2);
                                sb.append(str);
                            }
                        }
                    }
                    List<O> ja = v.ja();
                    String s = v.s();
                    if (ja != null) {
                        for (O o : ja) {
                            if (o != null) {
                                a(sb, i2);
                                sb.append("audience_membership {\n");
                                if (o.r()) {
                                    a(sb, i2, "audience_id", (Object) Integer.valueOf(o.s()));
                                }
                                if (o.t()) {
                                    a(sb, i2, "new_audience", (Object) Boolean.valueOf(o.u()));
                                }
                                StringBuilder sb2 = sb;
                                String str6 = s;
                                a(sb2, 2, "current_data", o.o(), str6);
                                a(sb2, 2, "previous_data", o.q(), str6);
                                a(sb, 2);
                                sb.append(str);
                                i2 = 2;
                            }
                        }
                    }
                    List<Q> D = v.D();
                    if (D != null) {
                        for (Q q : D) {
                            if (q != null) {
                                a(sb, 2);
                                sb.append("event {\n");
                                a(sb, 2, str5, (Object) l().a(q.p()));
                                if (q.t()) {
                                    a(sb, 2, "timestamp_millis", (Object) Long.valueOf(q.q()));
                                }
                                if (q.v()) {
                                    a(sb, 2, "previous_timestamp_millis", (Object) Long.valueOf(q.u()));
                                }
                                if (q.w()) {
                                    a(sb, 2, "count", (Object) Integer.valueOf(q.o()));
                                }
                                if (q.s() != 0) {
                                    List<T> r = q.r();
                                    if (r != null) {
                                        for (T t : r) {
                                            if (t != null) {
                                                a(sb, 3);
                                                sb.append("param {\n");
                                                a(sb, 3, str5, (Object) l().b(t.o()));
                                                a(sb, 3, str4, (Object) t.q());
                                                a(sb, 3, str3, (Object) t.r() ? Long.valueOf(t.s()) : null);
                                                a(sb, 3, str2, (Object) t.t() ? Double.valueOf(t.u()) : null);
                                                a(sb, 3);
                                                sb.append(str);
                                            }
                                        }
                                    }
                                }
                                a(sb, 2);
                                sb.append(str);
                            }
                        }
                    }
                    a(sb, 1);
                    sb.append(str);
                }
            } else {
                sb.append(str);
                return sb.toString();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final String a(C c2) {
        if (c2 == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        if (c2.r()) {
            a(sb, 0, "filter_id", (Object) Integer.valueOf(c2.o()));
        }
        a(sb, 0, "event_name", (Object) l().a(c2.p()));
        String a2 = a(c2.v(), c2.w(), c2.B());
        if (!a2.isEmpty()) {
            a(sb, 0, "filter_type", (Object) a2);
        }
        a(sb, 1, "event_count_filter", c2.u());
        sb.append("  filters {\n");
        for (D a3 : c2.s()) {
            a(sb, 2, a3);
        }
        a(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    public final String a(F f2) {
        if (f2 == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        if (f2.q()) {
            a(sb, 0, "filter_id", (Object) Integer.valueOf(f2.o()));
        }
        a(sb, 0, "property_name", (Object) l().c(f2.p()));
        String a2 = a(f2.r(), f2.s(), f2.u());
        if (!a2.isEmpty()) {
            a(sb, 0, "filter_type", (Object) a2);
        }
        a(sb, 1, f2.w());
        sb.append("}\n");
        return sb.toString();
    }

    private static String a(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("Dynamic ");
        }
        if (z2) {
            sb.append("Sequence ");
        }
        if (z3) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    private final void a(StringBuilder sb, int i2, String str, X x, String str2) {
        if (x != null) {
            a(sb, 3);
            sb.append(str);
            sb.append(" {\n");
            String str3 = ", ";
            if (x.r() != 0) {
                a(sb, 4);
                sb.append("results: ");
                int i3 = 0;
                for (Long l2 : x.q()) {
                    int i4 = i3 + 1;
                    if (i3 != 0) {
                        sb.append(str3);
                    }
                    sb.append(l2);
                    i3 = i4;
                }
                sb.append(10);
            }
            if (x.p() != 0) {
                a(sb, 4);
                sb.append("status: ");
                int i5 = 0;
                for (Long l3 : x.o()) {
                    int i6 = i5 + 1;
                    if (i5 != 0) {
                        sb.append(str3);
                    }
                    sb.append(l3);
                    i5 = i6;
                }
                sb.append(10);
            }
            boolean i7 = g().i(str2);
            String str4 = "}\n";
            if (i7) {
                if (x.t() != 0) {
                    a(sb, 4);
                    sb.append("dynamic_filter_timestamps: {");
                    int i8 = 0;
                    for (P p : x.s()) {
                        int i9 = i8 + 1;
                        if (i8 != 0) {
                            sb.append(str3);
                        }
                        sb.append(p.p() ? Integer.valueOf(p.o()) : null);
                        sb.append(":");
                        sb.append(p.q() ? Long.valueOf(p.r()) : null);
                        i8 = i9;
                    }
                    sb.append(str4);
                }
                if (x.v() != 0) {
                    a(sb, 4);
                    sb.append("sequence_filter_timestamps: {");
                    int i10 = 0;
                    for (Y y : x.u()) {
                        int i11 = i10 + 1;
                        if (i10 != 0) {
                            sb.append(str3);
                        }
                        sb.append(y.p() ? Integer.valueOf(y.o()) : null);
                        sb.append(": [");
                        int i12 = 0;
                        for (Long longValue : y.q()) {
                            long longValue2 = longValue.longValue();
                            int i13 = i12 + 1;
                            if (i12 != 0) {
                                sb.append(str3);
                            }
                            sb.append(longValue2);
                            i12 = i13;
                        }
                        sb.append("]");
                        i10 = i11;
                    }
                    sb.append(str4);
                }
            }
            a(sb, 3);
            sb.append(str4);
        }
    }

    private final void a(StringBuilder sb, int i2, String str, E e2) {
        if (e2 != null) {
            a(sb, i2);
            sb.append(str);
            sb.append(" {\n");
            if (e2.o()) {
                a(sb, i2, "comparison_type", (Object) e2.p().name());
            }
            if (e2.q()) {
                a(sb, i2, "match_as_float", (Object) Boolean.valueOf(e2.r()));
            }
            a(sb, i2, "comparison_value", (Object) e2.t());
            a(sb, i2, "min_comparison_value", (Object) e2.v());
            a(sb, i2, "max_comparison_value", (Object) e2.x());
            a(sb, i2);
            sb.append("}\n");
        }
    }

    private final void a(StringBuilder sb, int i2, D d2) {
        if (d2 != null) {
            a(sb, i2);
            sb.append("filter {\n");
            if (d2.s()) {
                a(sb, i2, "complement", (Object) Boolean.valueOf(d2.t()));
            }
            a(sb, i2, "param_name", (Object) l().b(d2.u()));
            int i3 = i2 + 1;
            G p = d2.p();
            String str = "}\n";
            if (p != null) {
                a(sb, i3);
                sb.append("string_filter");
                sb.append(" {\n");
                if (p.o()) {
                    a(sb, i3, "match_type", (Object) p.p().name());
                }
                a(sb, i3, "expression", (Object) p.r());
                if (p.s()) {
                    a(sb, i3, "case_sensitive", (Object) Boolean.valueOf(p.t()));
                }
                if (p.v() > 0) {
                    a(sb, i3 + 1);
                    sb.append("expression_list {\n");
                    for (String str2 : p.u()) {
                        a(sb, i3 + 2);
                        sb.append(str2);
                        sb.append("\n");
                    }
                    sb.append(str);
                }
                a(sb, i3);
                sb.append(str);
            }
            a(sb, i3, "number_filter", d2.r());
            a(sb, i2);
            sb.append(str);
        }
    }

    private static void a(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append("  ");
        }
    }

    private static void a(StringBuilder sb, int i2, String str, Object obj) {
        if (obj != null) {
            a(sb, i2 + 1);
            sb.append(str);
            sb.append(": ");
            sb.append(obj);
            sb.append(10);
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        e().t().a("Failed to load parcelable from buffer");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        r1.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001c */
    public final <T extends Parcelable> T a(byte[] bArr, Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        T t = (Parcelable) creator.createFromParcel(obtain);
        obtain.recycle();
        return t;
    }

    /* access modifiers changed from: 0000 */
    public final boolean a(C0525j jVar, ae aeVar) {
        q.a(jVar);
        q.a(aeVar);
        if (!TextUtils.isEmpty(aeVar.f5820b) || !TextUtils.isEmpty(aeVar.r)) {
            return true;
        }
        b();
        return false;
    }

    static boolean a(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    static boolean a(List<Long> list, int i2) {
        if (i2 < (list.size() << 6)) {
            if (((1 << (i2 % 64)) & ((Long) list.get(i2 / 64)).longValue()) != 0) {
                return true;
            }
        }
        return false;
    }

    static List<Long> a(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            long j2 = 0;
            for (int i3 = 0; i3 < 64; i3++) {
                int i4 = (i2 << 6) + i3;
                if (i4 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i4)) {
                    j2 |= 1 << i3;
                }
            }
            arrayList.add(Long.valueOf(j2));
        }
        return arrayList;
    }

    /* access modifiers changed from: 0000 */
    public final List<Long> a(List<Long> list, List<Integer> list2) {
        int i2;
        ArrayList arrayList = new ArrayList(list);
        for (Integer num : list2) {
            if (num.intValue() < 0) {
                e().w().a("Ignoring negative bit index to be cleared", num);
            } else {
                int intValue = num.intValue() / 64;
                if (intValue >= arrayList.size()) {
                    e().w().a("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(intValue, Long.valueOf(((Long) arrayList.get(intValue)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i3 = size2;
            i2 = size;
            size = i3;
            if (size >= 0 && ((Long) arrayList.get(size)).longValue() == 0) {
                size2 = size - 1;
            }
        }
        return arrayList.subList(0, i2);
    }

    /* access modifiers changed from: 0000 */
    public final boolean a(long j2, long j3) {
        return j2 == 0 || j3 <= 0 || Math.abs(c().currentTimeMillis() - j2) > j3;
    }

    /* access modifiers changed from: 0000 */
    public final long a(byte[] bArr) {
        q.a(bArr);
        m().j();
        MessageDigest t = Wd.t();
        if (t != null) {
            return Wd.a(t.digest(bArr));
        }
        e().t().a("Failed to get MD5");
        return 0;
    }

    public final /* bridge */ /* synthetic */ Context a() {
        return super.a();
    }
}
