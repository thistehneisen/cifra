package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import b.d.b;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.internal.measurement.C;
import com.google.android.gms.internal.measurement.D;
import com.google.android.gms.internal.measurement.E;
import com.google.android.gms.internal.measurement.F;
import com.google.android.gms.internal.measurement.G;
import com.google.android.gms.internal.measurement.O;
import com.google.android.gms.internal.measurement.O.a;
import com.google.android.gms.internal.measurement.P;
import com.google.android.gms.internal.measurement.Q;
import com.google.android.gms.internal.measurement.T;
import com.google.android.gms.internal.measurement.X;
import com.google.android.gms.internal.measurement.Y;
import com.google.android.gms.internal.measurement.Z;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

final class ce extends Ld {
    ce(Kd kd) {
        super(kd);
    }

    private static void b(Map<Integer, List<Long>> map, int i2, long j2) {
        List list = (List) map.get(Integer.valueOf(i2));
        if (list == null) {
            list = new ArrayList();
            map.put(Integer.valueOf(i2), list);
        }
        list.add(Long.valueOf(j2 / 1000));
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:415:0x0cf2, code lost:
        if (r0.q() == false) goto L_0x0cfd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:416:0x0cf4, code lost:
        r8 = java.lang.Integer.valueOf(r0.o());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:417:0x0cfd, code lost:
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:418:0x0cfe, code lost:
        r1.a("Invalid property filter ID. appId, id", r6, java.lang.String.valueOf(r8));
        r14.add(java.lang.Integer.valueOf(r5));
        r11 = r72;
        r1 = r73;
        r46 = r4;
        r47 = r7;
        r0 = r16;
        r3 = r17;
        r15 = r37;
        r68 = r43;
        r24 = r44;
        r69 = r48;
     */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0359  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x03a5  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0479  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0496  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x04b1  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x04e2  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x053d  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x05c0  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x064a  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x066b  */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x075b  */
    /* JADX WARNING: Removed duplicated region for block: B:304:0x09e1  */
    /* JADX WARNING: Removed duplicated region for block: B:425:0x0d60  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01da  */
    public final List<O> a(String str, List<Q> list, List<Z> list2) {
        Long l2;
        Map f2;
        Iterator it;
        b bVar;
        a aVar;
        Iterator it2;
        b bVar2;
        b bVar3;
        Collection collection;
        Iterable iterable;
        Iterator it3;
        b bVar4;
        Map map;
        b bVar5;
        Map map2;
        b bVar6;
        b bVar7;
        String str2;
        String str3;
        b bVar8;
        Map map3;
        b bVar9;
        b bVar10;
        Object obj;
        Object obj2;
        long j2;
        boolean z;
        List list3;
        b bVar11;
        Long l3;
        Q q;
        String str4;
        Q q2;
        String str5;
        C0505f b2;
        HashSet hashSet;
        String str6;
        b bVar12;
        b bVar13;
        b bVar14;
        b bVar15;
        Q q3;
        C0505f fVar;
        String str7;
        b bVar16;
        String str8;
        Map map4;
        Iterator it4;
        Map map5;
        long j3;
        BitSet bitSet;
        Map map6;
        b bVar17;
        b bVar18;
        Iterator it5;
        Map map7;
        BitSet bitSet2;
        BitSet bitSet3;
        HashSet hashSet2;
        long j4;
        BitSet bitSet4;
        b bVar19;
        String str9;
        b bVar20;
        String str10;
        String str11;
        b bVar21;
        b bVar22;
        b bVar23;
        b bVar24;
        C0505f fVar2;
        b bVar25;
        Map map8;
        String str12;
        String str13;
        Map map9;
        BitSet bitSet5;
        String str14;
        String str15;
        b bVar26;
        String str16;
        Object obj3;
        C0505f fVar3;
        C0505f fVar4;
        Q q4;
        String str17;
        String str18;
        b bVar27;
        String str19;
        Long l4;
        Q q5;
        long j5;
        Q q6;
        String str20;
        ArrayList arrayList;
        Map map10;
        Iterator it6;
        Iterator it7;
        Map map11;
        b bVar28;
        b bVar29;
        b bVar30;
        b bVar31;
        boolean z2;
        Iterator it8;
        Map map12;
        Object obj4;
        ce ceVar;
        Iterator it9;
        Map map13;
        ke p;
        String str21 = str;
        q.b(str);
        q.a(list);
        q.a(list2);
        HashSet hashSet3 = new HashSet();
        b bVar32 = new b();
        b bVar33 = new b();
        b bVar34 = new b();
        b bVar35 = new b();
        b bVar36 = new b();
        boolean i2 = g().i(str21);
        boolean d2 = g().d(str21, C0535l.wa);
        boolean d3 = g().d(str21, C0535l.Ea);
        boolean d4 = g().d(str21, C0535l.Fa);
        if (d3 || d4) {
            Iterator it10 = list.iterator();
            while (true) {
                if (!it10.hasNext()) {
                    break;
                }
                Q q7 = (Q) it10.next();
                if ("_s".equals(q7.p())) {
                    l2 = Long.valueOf(q7.q());
                    break;
                }
            }
            if (l2 != null && d4) {
                p = p();
                p.t();
                p.j();
                q.b(str);
                ContentValues contentValues = new ContentValues();
                contentValues.put("current_session_count", Integer.valueOf(0));
                p.x().update("events", contentValues, "app_id = ?", new String[]{str21});
            }
            f2 = p().f(str21);
            if (f2 != null && !f2.isEmpty()) {
                HashSet hashSet4 = new HashSet(f2.keySet());
                if (d3 || l2 == null) {
                    map10 = f2;
                } else {
                    ce o = o();
                    q.b(str);
                    q.a(f2);
                    map10 = new b();
                    if (!f2.isEmpty()) {
                        Map e2 = o.p().e(str21);
                        Iterator it11 = f2.keySet().iterator();
                        while (it11.hasNext()) {
                            int intValue = ((Integer) it11.next()).intValue();
                            X x = (X) f2.get(Integer.valueOf(intValue));
                            List list4 = (List) e2.get(Integer.valueOf(intValue));
                            if (list4 == null || list4.isEmpty()) {
                                ceVar = o;
                                map13 = e2;
                                it9 = it11;
                                map10.put(Integer.valueOf(intValue), x);
                            } else {
                                map13 = e2;
                                it9 = it11;
                                List a2 = o.n().a(x.q(), list4);
                                if (!a2.isEmpty()) {
                                    X.a aVar2 = (X.a) x.k();
                                    aVar2.k();
                                    aVar2.b((Iterable<? extends Long>) a2);
                                    ceVar = o;
                                    List a3 = o.n().a(x.o(), list4);
                                    aVar2.j();
                                    aVar2.a((Iterable<? extends Long>) a3);
                                    for (int i3 = 0; i3 < x.t(); i3++) {
                                        if (list4.contains(Integer.valueOf(x.b(i3).o()))) {
                                            aVar2.a(i3);
                                        }
                                    }
                                    for (int i4 = 0; i4 < x.v(); i4++) {
                                        if (list4.contains(Integer.valueOf(x.c(i4).o()))) {
                                            aVar2.b(i4);
                                        }
                                    }
                                    map10.put(Integer.valueOf(intValue), (X) aVar2.A());
                                } else {
                                    e2 = map13;
                                    it11 = it9;
                                }
                            }
                            e2 = map13;
                            it11 = it9;
                            o = ceVar;
                        }
                    }
                }
                it6 = hashSet4.iterator();
                while (it6.hasNext()) {
                    int intValue2 = ((Integer) it6.next()).intValue();
                    X x2 = (X) map10.get(Integer.valueOf(intValue2));
                    BitSet bitSet6 = (BitSet) bVar33.get(Integer.valueOf(intValue2));
                    BitSet bitSet7 = (BitSet) bVar34.get(Integer.valueOf(intValue2));
                    if (i2) {
                        bVar28 = new b();
                        if (!(x2 == null || x2.t() == 0)) {
                            for (P p2 : x2.s()) {
                                if (p2.p()) {
                                    it8 = it6;
                                    Integer valueOf = Integer.valueOf(p2.o());
                                    if (p2.q()) {
                                        Object valueOf2 = Long.valueOf(p2.r());
                                        map12 = map10;
                                        obj4 = valueOf2;
                                    } else {
                                        map12 = map10;
                                        obj4 = null;
                                    }
                                    bVar28.put(valueOf, obj4);
                                } else {
                                    it8 = it6;
                                    map12 = map10;
                                }
                                map10 = map12;
                                it6 = it8;
                            }
                        }
                        it7 = it6;
                        map11 = map10;
                        bVar35.put(Integer.valueOf(intValue2), bVar28);
                    } else {
                        it7 = it6;
                        map11 = map10;
                        bVar28 = null;
                    }
                    if (bitSet6 == null) {
                        bitSet6 = new BitSet();
                        bVar33.put(Integer.valueOf(intValue2), bitSet6);
                        bitSet7 = new BitSet();
                        bVar34.put(Integer.valueOf(intValue2), bitSet7);
                    }
                    if (x2 != null) {
                        int i5 = 0;
                        while (i5 < (x2.p() << 6)) {
                            if (Sd.a(x2.o(), i5)) {
                                bVar31 = bVar34;
                                bVar30 = bVar35;
                                bVar29 = bVar33;
                                e().B().a("Filter already evaluated. audience ID, filter ID", Integer.valueOf(intValue2), Integer.valueOf(i5));
                                bitSet7.set(i5);
                                if (Sd.a(x2.q(), i5)) {
                                    bitSet6.set(i5);
                                    z2 = true;
                                    if (bVar28 != null && !z2) {
                                        bVar28.remove(Integer.valueOf(i5));
                                    }
                                    i5++;
                                    bVar34 = bVar31;
                                    bVar35 = bVar30;
                                    bVar33 = bVar29;
                                }
                            } else {
                                bVar31 = bVar34;
                                bVar30 = bVar35;
                                bVar29 = bVar33;
                            }
                            z2 = false;
                            bVar28.remove(Integer.valueOf(i5));
                            i5++;
                            bVar34 = bVar31;
                            bVar35 = bVar30;
                            bVar33 = bVar29;
                        }
                    }
                    b bVar37 = bVar34;
                    b bVar38 = bVar35;
                    b bVar39 = bVar33;
                    a v = O.v();
                    v.a(false);
                    if (d3) {
                        v.a((X) f2.get(Integer.valueOf(intValue2)));
                    } else {
                        v.a(x2);
                    }
                    X.a w = X.w();
                    w.b((Iterable<? extends Long>) Sd.a(bitSet6));
                    w.a((Iterable<? extends Long>) Sd.a(bitSet7));
                    if (i2) {
                        w.c(a(bVar28));
                        bVar36.put(Integer.valueOf(intValue2), new b());
                    }
                    v.a(w);
                    bVar32.put(Integer.valueOf(intValue2), (O) v.A());
                    bVar34 = bVar37;
                    map10 = map11;
                    bVar35 = bVar38;
                    it6 = it7;
                    bVar33 = bVar39;
                }
            }
            b bVar40 = bVar34;
            b bVar41 = bVar35;
            b bVar42 = bVar33;
            String str22 = "Filter definition";
            String str23 = "Skipping failed audience ID";
            Object obj5 = "null";
            if (!list.isEmpty()) {
                b bVar43 = new b();
                long j6 = 0;
                Q q8 = null;
                Long l5 = null;
                for (Q q9 : list) {
                    String p3 = q9.p();
                    List<T> r = q9.r();
                    n();
                    String str24 = "_eid";
                    Long l6 = (Long) Sd.b(q9, str24);
                    boolean z3 = l6 != null;
                    if (z3) {
                        j2 = j6;
                        if (p3.equals("_ep")) {
                            z = true;
                            if (!z) {
                                n();
                                String str25 = (String) Sd.b(q9, "_en");
                                if (TextUtils.isEmpty(str25)) {
                                    e().t().a("Extra parameter without an event name. eventId", l6);
                                    bVar27 = bVar43;
                                    str19 = str23;
                                } else {
                                    if (q8 == null || l5 == null || l6.longValue() != l5.longValue()) {
                                        Pair a4 = p().a(str21, l6);
                                        if (a4 != null) {
                                            Object obj6 = a4.first;
                                            if (obj6 != null) {
                                                Q q10 = (Q) obj6;
                                                j5 = ((Long) a4.second).longValue();
                                                n();
                                                l4 = (Long) Sd.b(q10, str24);
                                                q5 = q10;
                                            }
                                        }
                                        bVar27 = bVar43;
                                        str19 = str23;
                                        e().t().a("Extra parameter without existing main event. eventName, eventId", str25, l6);
                                    } else {
                                        q5 = q8;
                                        l4 = l5;
                                        j5 = j2;
                                    }
                                    j2 = j5 - 1;
                                    if (j2 <= 0) {
                                        ke p4 = p();
                                        p4.j();
                                        p4.e().B().a("Clearing complex main event info. appId", str21);
                                        try {
                                            SQLiteDatabase x3 = p4.x();
                                            String str26 = "delete from main_event_params where app_id=?";
                                            try {
                                                String[] strArr = new String[1];
                                                try {
                                                    strArr[0] = str21;
                                                    x3.execSQL(str26, strArr);
                                                } catch (SQLiteException e3) {
                                                    e = e3;
                                                }
                                            } catch (SQLiteException e4) {
                                                e = e4;
                                                p4.e().t().a("Error clearing complex main event", e);
                                                q6 = q9;
                                                bVar11 = bVar43;
                                                str4 = str23;
                                                str20 = str25;
                                                arrayList = new ArrayList();
                                                for (T t : q5.r()) {
                                                }
                                                if (!arrayList.isEmpty()) {
                                                }
                                                l3 = l4;
                                                b2 = p().b(str21, q2.p());
                                                if (b2 != null) {
                                                }
                                                p().a(fVar);
                                                long j7 = fVar.f5900c;
                                                b bVar44 = bVar11;
                                                map4 = (Map) bVar44.get(str5);
                                                if (map4 == null) {
                                                }
                                                Map map14 = map4;
                                                it4 = map14.keySet().iterator();
                                                while (it4.hasNext()) {
                                                }
                                                str21 = str8;
                                                str23 = str7;
                                                bVar43 = bVar44;
                                                j6 = j2;
                                                q8 = q;
                                                l5 = l3;
                                                bVar40 = bVar15;
                                                bVar41 = bVar14;
                                                bVar32 = bVar13;
                                                bVar42 = bVar12;
                                                str22 = str6;
                                                hashSet3 = hashSet;
                                                bVar36 = bVar16;
                                            }
                                        } catch (SQLiteException e5) {
                                            e = e5;
                                            p4.e().t().a("Error clearing complex main event", e);
                                            q6 = q9;
                                            bVar11 = bVar43;
                                            str4 = str23;
                                            str20 = str25;
                                            arrayList = new ArrayList();
                                            for (T t2 : q5.r()) {
                                            }
                                            if (!arrayList.isEmpty()) {
                                            }
                                            l3 = l4;
                                            b2 = p().b(str21, q2.p());
                                            if (b2 != null) {
                                            }
                                            p().a(fVar);
                                            long j72 = fVar.f5900c;
                                            b bVar442 = bVar11;
                                            map4 = (Map) bVar442.get(str5);
                                            if (map4 == null) {
                                            }
                                            Map map142 = map4;
                                            it4 = map142.keySet().iterator();
                                            while (it4.hasNext()) {
                                            }
                                            str21 = str8;
                                            str23 = str7;
                                            bVar43 = bVar442;
                                            j6 = j2;
                                            q8 = q;
                                            l5 = l3;
                                            bVar40 = bVar15;
                                            bVar41 = bVar14;
                                            bVar32 = bVar13;
                                            bVar42 = bVar12;
                                            str22 = str6;
                                            hashSet3 = hashSet;
                                            bVar36 = bVar16;
                                        }
                                        q6 = q9;
                                        bVar11 = bVar43;
                                        str4 = str23;
                                        str20 = str25;
                                    } else {
                                        Long l7 = l6;
                                        q6 = q9;
                                        str4 = str23;
                                        str20 = str25;
                                        bVar11 = bVar43;
                                        p().a(str, l7, j2, q5);
                                    }
                                    arrayList = new ArrayList();
                                    for (T t22 : q5.r()) {
                                        n();
                                        if (Sd.a(q6, t22.o()) == null) {
                                            arrayList.add(t22);
                                        }
                                    }
                                    if (!arrayList.isEmpty()) {
                                        for (T add : r) {
                                            arrayList.add(add);
                                        }
                                        list3 = arrayList;
                                        str5 = str20;
                                        q = q5;
                                        q2 = q6;
                                    } else {
                                        e().w().a("No unique parameters in main event. eventName", str20);
                                        str5 = str20;
                                        q = q5;
                                        q2 = q6;
                                        list3 = r;
                                    }
                                    l3 = l4;
                                }
                                str23 = str19;
                                j6 = j2;
                                bVar43 = bVar27;
                            } else {
                                q2 = q9;
                                bVar11 = bVar43;
                                str4 = str23;
                                if (z3) {
                                    n();
                                    Object valueOf3 = Long.valueOf(0);
                                    Object b3 = Sd.b(q2, "_epc");
                                    if (b3 != null) {
                                        valueOf3 = b3;
                                    }
                                    j2 = valueOf3.longValue();
                                    if (j2 <= 0) {
                                        e().w().a("Complex event with zero extra param count. eventName", p3);
                                        str18 = p3;
                                    } else {
                                        str18 = p3;
                                        p().a(str, l6, j2, q2);
                                    }
                                    str17 = str18;
                                    q4 = q2;
                                    l3 = l6;
                                } else {
                                    q4 = q8;
                                    l3 = l5;
                                    str17 = p3;
                                }
                                list3 = r;
                            }
                            b2 = p().b(str21, q2.p());
                            if (b2 != null) {
                                e().w().a("Event aggregate wasn't created during raw event logging. appId, event", C0532kb.a(str), l().a(str5));
                                if (d4) {
                                    str7 = str4;
                                    bVar16 = bVar36;
                                    q3 = q2;
                                    bVar15 = bVar40;
                                    bVar14 = bVar41;
                                    bVar13 = bVar32;
                                    str6 = str22;
                                    bVar12 = bVar42;
                                    hashSet = hashSet3;
                                    str8 = str21;
                                    fVar4 = new C0505f(str, q2.p(), 1, 1, 1, q3.q(), 0, null, null, null, null);
                                } else {
                                    str8 = str21;
                                    bVar16 = bVar36;
                                    q3 = q2;
                                    bVar13 = bVar32;
                                    str6 = str22;
                                    hashSet = hashSet3;
                                    bVar15 = bVar40;
                                    str7 = str4;
                                    bVar14 = bVar41;
                                    bVar12 = bVar42;
                                    fVar4 = new C0505f(str, q3.p(), 1, 1, q3.q(), 0, null, null, null, null);
                                }
                                fVar = fVar4;
                            } else {
                                str8 = str21;
                                bVar16 = bVar36;
                                q3 = q2;
                                bVar13 = bVar32;
                                str6 = str22;
                                hashSet = hashSet3;
                                bVar15 = bVar40;
                                str7 = str4;
                                bVar14 = bVar41;
                                bVar12 = bVar42;
                                if (d4) {
                                    fVar3 = new C0505f(b2.f5898a, b2.f5899b, b2.f5900c + 1, b2.f5901d + 1, b2.f5902e + 1, b2.f5903f, b2.f5904g, b2.f5905h, b2.f5906i, b2.f5907j, b2.f5908k);
                                } else {
                                    fVar3 = new C0505f(b2.f5898a, b2.f5899b, b2.f5900c + 1, b2.f5901d + 1, b2.f5902e, b2.f5903f, b2.f5904g, b2.f5905h, b2.f5906i, b2.f5907j, b2.f5908k);
                                }
                                fVar = fVar3;
                            }
                            p().a(fVar);
                            long j722 = fVar.f5900c;
                            b bVar4422 = bVar11;
                            map4 = (Map) bVar4422.get(str5);
                            if (map4 == null) {
                                map4 = p().g(str8, str5);
                                if (map4 == null) {
                                    map4 = new b();
                                }
                                bVar4422.put(str5, map4);
                            }
                            Map map1422 = map4;
                            it4 = map1422.keySet().iterator();
                            while (it4.hasNext()) {
                                int intValue3 = ((Integer) it4.next()).intValue();
                                HashSet hashSet5 = hashSet;
                                if (hashSet5.contains(Integer.valueOf(intValue3))) {
                                    e().B().a(str7, Integer.valueOf(intValue3));
                                    hashSet2 = hashSet5;
                                } else {
                                    b bVar45 = bVar12;
                                    BitSet bitSet8 = (BitSet) bVar45.get(Integer.valueOf(intValue3));
                                    b bVar46 = bVar15;
                                    BitSet bitSet9 = (BitSet) bVar46.get(Integer.valueOf(intValue3));
                                    if (i2) {
                                        bitSet = bitSet8;
                                        j3 = j722;
                                        bVar17 = bVar14;
                                        map6 = (Map) bVar16.get(Integer.valueOf(intValue3));
                                        map5 = (Map) bVar17.get(Integer.valueOf(intValue3));
                                    } else {
                                        bitSet = bitSet8;
                                        j3 = j722;
                                        bVar17 = bVar14;
                                        map6 = null;
                                        map5 = null;
                                    }
                                    Map map15 = map6;
                                    b bVar47 = bVar13;
                                    if (((O) bVar47.get(Integer.valueOf(intValue3))) == null) {
                                        Integer valueOf4 = Integer.valueOf(intValue3);
                                        a v2 = O.v();
                                        bVar18 = bVar4422;
                                        v2.a(true);
                                        bVar47.put(valueOf4, (O) v2.A());
                                        BitSet bitSet10 = new BitSet();
                                        bVar45.put(Integer.valueOf(intValue3), bitSet10);
                                        bitSet9 = new BitSet();
                                        bVar46.put(Integer.valueOf(intValue3), bitSet9);
                                        if (i2) {
                                            b bVar48 = new b();
                                            BitSet bitSet11 = bitSet10;
                                            bVar17.put(Integer.valueOf(intValue3), bVar48);
                                            b bVar49 = new b();
                                            BitSet bitSet12 = bitSet9;
                                            bVar16.put(Integer.valueOf(intValue3), bVar49);
                                            map5 = bVar48;
                                            bitSet2 = bitSet11;
                                            bitSet9 = bitSet12;
                                            it5 = it4;
                                            map7 = bVar49;
                                            for (C c2 : (List) map1422.get(Integer.valueOf(intValue3))) {
                                                if (!d4 || !d3 || !c2.B()) {
                                                    bitSet4 = bitSet3;
                                                    j4 = j3;
                                                } else {
                                                    bitSet4 = bitSet3;
                                                    j4 = fVar.f5902e;
                                                }
                                                if (e().a(2)) {
                                                    C0542mb B = e().B();
                                                    Integer valueOf5 = Integer.valueOf(intValue3);
                                                    if (c2.r()) {
                                                        str9 = str7;
                                                        bVar20 = bVar16;
                                                        obj3 = Integer.valueOf(c2.o());
                                                    } else {
                                                        bVar20 = bVar16;
                                                        str9 = str7;
                                                        obj3 = null;
                                                    }
                                                    bVar19 = bVar46;
                                                    B.a("Evaluating filter. audience, filter, event", valueOf5, obj3, l().a(c2.p()));
                                                    str10 = str6;
                                                    e().B().a(str10, n().a(c2));
                                                } else {
                                                    bVar20 = bVar16;
                                                    str9 = str7;
                                                    bVar19 = bVar46;
                                                    str10 = str6;
                                                }
                                                if (!c2.r() || c2.o() > 256) {
                                                    str11 = str10;
                                                    fVar2 = fVar;
                                                    bVar24 = bVar47;
                                                    bVar23 = bVar45;
                                                    map9 = map5;
                                                    bitSet5 = bitSet4;
                                                    bVar22 = bVar20;
                                                    str12 = str9;
                                                    bVar21 = bVar19;
                                                    C c3 = c2;
                                                    bVar25 = bVar17;
                                                    map8 = map1422;
                                                    str13 = str;
                                                    e().w().a("Invalid event filter ID. appId, id", C0532kb.a(str), String.valueOf(c3.r() ? Integer.valueOf(c3.o()) : null));
                                                } else {
                                                    String str27 = "Event filter result";
                                                    if (i2) {
                                                        boolean v3 = c2.v();
                                                        boolean w2 = c2.w();
                                                        boolean z4 = v3 || w2 || (d3 && c2.B());
                                                        if (!bitSet2.get(c2.o()) || z4) {
                                                            Map map16 = map5;
                                                            C c4 = c2;
                                                            fVar2 = fVar;
                                                            bitSet5 = bitSet4;
                                                            bVar24 = bVar47;
                                                            map8 = map1422;
                                                            str13 = str;
                                                            map9 = map16;
                                                            bVar22 = bVar20;
                                                            bVar25 = bVar17;
                                                            String str28 = str27;
                                                            str11 = str10;
                                                            bVar23 = bVar45;
                                                            str12 = str9;
                                                            bVar21 = bVar19;
                                                            Boolean a5 = a(c4, str5, list3, j4);
                                                            e().B().a(str28, a5 == 0 ? obj5 : a5);
                                                            if (a5 == 0) {
                                                                hashSet5.add(Integer.valueOf(intValue3));
                                                            } else {
                                                                bitSet5.set(c4.o());
                                                                if (a5.booleanValue()) {
                                                                    bitSet2.set(c4.o());
                                                                    if (z4 && q3.t()) {
                                                                        if (w2) {
                                                                            b(map7, c4.o(), q3.q());
                                                                        } else {
                                                                            a(map9, c4.o(), q3.q());
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            e().B().a("Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(intValue3), c2.r() ? Integer.valueOf(c2.o()) : null);
                                                            str14 = str;
                                                            str16 = str10;
                                                            bitSet3 = bitSet4;
                                                            bVar26 = bVar20;
                                                            str15 = str9;
                                                            bVar46 = bVar19;
                                                        }
                                                    } else {
                                                        str11 = str10;
                                                        fVar2 = fVar;
                                                        bVar24 = bVar47;
                                                        bVar23 = bVar45;
                                                        map9 = map5;
                                                        bitSet5 = bitSet4;
                                                        bVar22 = bVar20;
                                                        str12 = str9;
                                                        bVar21 = bVar19;
                                                        C c5 = c2;
                                                        bVar25 = bVar17;
                                                        map8 = map1422;
                                                        str13 = str;
                                                        String str29 = str27;
                                                        if (bitSet2.get(c5.o())) {
                                                            e().B().a("Event filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue3), c5.r() ? Integer.valueOf(c5.o()) : null);
                                                        } else {
                                                            Boolean a6 = a(c5, str5, list3, j4);
                                                            e().B().a(str29, a6 == 0 ? obj5 : a6);
                                                            if (a6 == 0) {
                                                                hashSet5.add(Integer.valueOf(intValue3));
                                                            } else {
                                                                bitSet5.set(c5.o());
                                                                if (a6.booleanValue()) {
                                                                    bitSet2.set(c5.o());
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                bitSet3 = bitSet5;
                                                map5 = map9;
                                                str14 = str13;
                                                str15 = str12;
                                                map1422 = map8;
                                                bVar17 = bVar25;
                                                fVar = fVar2;
                                                bVar47 = bVar24;
                                                bVar45 = bVar23;
                                                bVar26 = bVar22;
                                                bVar46 = bVar21;
                                                str16 = str11;
                                            }
                                            bVar15 = bVar46;
                                            bVar14 = bVar17;
                                            bVar13 = bVar47;
                                            hashSet2 = hashSet5;
                                            bVar12 = bVar45;
                                            it4 = it5;
                                            j722 = j3;
                                            bVar4422 = bVar18;
                                        } else {
                                            bitSet = bitSet10;
                                            BitSet bitSet13 = bitSet9;
                                        }
                                    } else {
                                        bVar18 = bVar4422;
                                    }
                                    bitSet2 = bitSet;
                                    it5 = it4;
                                    map7 = map15;
                                    for (C c22 : (List) map1422.get(Integer.valueOf(intValue3))) {
                                    }
                                    bVar15 = bVar46;
                                    bVar14 = bVar17;
                                    bVar13 = bVar47;
                                    hashSet2 = hashSet5;
                                    bVar12 = bVar45;
                                    it4 = it5;
                                    j722 = j3;
                                    bVar4422 = bVar18;
                                }
                            }
                            str21 = str8;
                            str23 = str7;
                            bVar43 = bVar4422;
                            j6 = j2;
                            q8 = q;
                            l5 = l3;
                            bVar40 = bVar15;
                            bVar41 = bVar14;
                            bVar32 = bVar13;
                            bVar42 = bVar12;
                            str22 = str6;
                            hashSet3 = hashSet;
                            bVar36 = bVar16;
                        }
                    } else {
                        j2 = j6;
                    }
                    z = false;
                    if (!z) {
                    }
                    b2 = p().b(str21, q2.p());
                    if (b2 != null) {
                    }
                    p().a(fVar);
                    long j7222 = fVar.f5900c;
                    b bVar44222 = bVar11;
                    map4 = (Map) bVar44222.get(str5);
                    if (map4 == null) {
                    }
                    Map map14222 = map4;
                    it4 = map14222.keySet().iterator();
                    while (it4.hasNext()) {
                    }
                    str21 = str8;
                    str23 = str7;
                    bVar43 = bVar44222;
                    j6 = j2;
                    q8 = q;
                    l5 = l3;
                    bVar40 = bVar15;
                    bVar41 = bVar14;
                    bVar32 = bVar13;
                    bVar42 = bVar12;
                    str22 = str6;
                    hashSet3 = hashSet;
                    bVar36 = bVar16;
                }
            }
            String str30 = str21;
            b bVar50 = bVar36;
            b bVar51 = bVar32;
            String str31 = str22;
            HashSet hashSet6 = hashSet3;
            b bVar52 = bVar40;
            b bVar53 = bVar41;
            b bVar54 = bVar42;
            String str32 = str23;
            if (!list2.isEmpty()) {
                b bVar55 = new b();
                Iterator it12 = list2.iterator();
                while (it12.hasNext()) {
                    Z z5 = (Z) it12.next();
                    Map map17 = (Map) bVar55.get(z5.o());
                    if (map17 == null) {
                        map17 = p().h(str30, z5.o());
                        if (map17 == null) {
                            map17 = new b();
                        }
                        bVar55.put(z5.o(), map17);
                    }
                    Iterator it13 = map17.keySet().iterator();
                    while (it13.hasNext()) {
                        int intValue4 = ((Integer) it13.next()).intValue();
                        if (hashSet6.contains(Integer.valueOf(intValue4))) {
                            e().B().a(str32, Integer.valueOf(intValue4));
                        } else {
                            b bVar56 = bVar54;
                            BitSet bitSet14 = (BitSet) bVar56.get(Integer.valueOf(intValue4));
                            b bVar57 = bVar52;
                            BitSet bitSet15 = (BitSet) bVar57.get(Integer.valueOf(intValue4));
                            if (i2) {
                                bVar5 = bVar53;
                                map2 = (Map) bVar5.get(Integer.valueOf(intValue4));
                                it3 = it12;
                                bVar6 = bVar50;
                                map = (Map) bVar6.get(Integer.valueOf(intValue4));
                                bVar4 = bVar55;
                            } else {
                                it3 = it12;
                                bVar5 = bVar53;
                                bVar6 = bVar50;
                                bVar4 = bVar55;
                                map2 = null;
                                map = null;
                            }
                            Iterator it14 = it13;
                            b bVar58 = bVar51;
                            if (((O) bVar58.get(Integer.valueOf(intValue4))) == null) {
                                Integer valueOf6 = Integer.valueOf(intValue4);
                                a v4 = O.v();
                                v4.a(true);
                                bVar58.put(valueOf6, (O) v4.A());
                                bitSet14 = new BitSet();
                                bVar56.put(Integer.valueOf(intValue4), bitSet14);
                                bitSet15 = new BitSet();
                                bVar57.put(Integer.valueOf(intValue4), bitSet15);
                                if (i2) {
                                    map2 = new b();
                                    bVar5.put(Integer.valueOf(intValue4), map2);
                                    map = new b();
                                    bVar6.put(Integer.valueOf(intValue4), map);
                                }
                            }
                            Iterator it15 = ((List) map17.get(Integer.valueOf(intValue4))).iterator();
                            while (true) {
                                if (!it15.hasNext()) {
                                    Map map18 = map17;
                                    String str33 = str;
                                    bVar50 = bVar6;
                                    bVar51 = bVar58;
                                    bVar54 = bVar56;
                                    bVar52 = bVar57;
                                    bVar53 = bVar5;
                                    bVar55 = bVar4;
                                    Map map19 = map18;
                                    it12 = it3;
                                    break;
                                }
                                Iterator it16 = it15;
                                F f3 = (F) it15.next();
                                Map map20 = map17;
                                String str34 = str32;
                                if (e().a(2)) {
                                    C0542mb B2 = e().B();
                                    Integer valueOf7 = Integer.valueOf(intValue4);
                                    if (f3.q()) {
                                        bVar50 = bVar6;
                                        obj2 = Integer.valueOf(f3.o());
                                    } else {
                                        bVar50 = bVar6;
                                        obj2 = null;
                                    }
                                    bVar7 = bVar5;
                                    B2.a("Evaluating filter. audience, filter, property", valueOf7, obj2, l().c(f3.p()));
                                    str2 = str31;
                                    e().B().a(str2, n().a(f3));
                                } else {
                                    bVar50 = bVar6;
                                    bVar7 = bVar5;
                                    str2 = str31;
                                }
                                if (!f3.q() || f3.o() > 256) {
                                    b bVar59 = bVar57;
                                    String str35 = str2;
                                    C0542mb w3 = e().w();
                                    Object a7 = C0532kb.a(str);
                                } else {
                                    String str36 = "Property filter result";
                                    if (i2) {
                                        boolean r2 = f3.r();
                                        boolean s = f3.s();
                                        boolean z6 = d3 && f3.u();
                                        boolean z7 = r2 || s || z6;
                                        if (!bitSet14.get(f3.o()) || z7) {
                                            Boolean a8 = a(f3, z5);
                                            str3 = str2;
                                            C0542mb B3 = e().B();
                                            if (a8 == 0) {
                                                bVar8 = bVar57;
                                                obj = obj5;
                                            } else {
                                                bVar8 = bVar57;
                                                obj = a8;
                                            }
                                            B3.a(str36, obj);
                                            if (a8 == 0) {
                                                hashSet6.add(Integer.valueOf(intValue4));
                                            } else {
                                                bitSet15.set(f3.o());
                                                if (!d3 || !z6 || a8.booleanValue()) {
                                                    if (!d2) {
                                                        bitSet14.set(f3.o(), a8.booleanValue());
                                                    } else if (!bitSet14.get(f3.o()) || f3.r()) {
                                                        bitSet14.set(f3.o(), a8.booleanValue());
                                                    }
                                                    if (a8.booleanValue() && z7 && z5.v()) {
                                                        long w4 = z5.w();
                                                        if (d3 && z6 && l2 != null) {
                                                            w4 = l2.longValue();
                                                        }
                                                        if (s) {
                                                            b(map, f3.o(), w4);
                                                        } else {
                                                            a(map2, f3.o(), w4);
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            e().B().a("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(intValue4), f3.q() ? Integer.valueOf(f3.o()) : null);
                                            str31 = str2;
                                            map3 = map20;
                                            it15 = it16;
                                            str32 = str34;
                                            bVar9 = bVar7;
                                            bVar10 = bVar50;
                                            String str37 = str;
                                        }
                                    } else {
                                        bVar8 = bVar57;
                                        str3 = str2;
                                        if (bitSet14.get(f3.o())) {
                                            e().B().a("Property filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue4), f3.q() ? Integer.valueOf(f3.o()) : null);
                                        } else {
                                            Boolean a9 = a(f3, z5);
                                            e().B().a(str36, a9 == 0 ? obj5 : a9);
                                            if (a9 == 0) {
                                                hashSet6.add(Integer.valueOf(intValue4));
                                            } else {
                                                bitSet15.set(f3.o());
                                                if (a9.booleanValue()) {
                                                    bitSet14.set(f3.o());
                                                }
                                            }
                                        }
                                    }
                                    String str38 = str;
                                    map3 = map20;
                                    it15 = it16;
                                    str32 = str34;
                                    bVar57 = bVar8;
                                    bVar9 = bVar7;
                                    str31 = str3;
                                    bVar10 = bVar50;
                                }
                            }
                            it13 = it14;
                        }
                    }
                    str30 = str;
                }
            }
            b bVar60 = bVar53;
            b bVar61 = bVar51;
            b bVar62 = bVar54;
            b bVar63 = bVar52;
            ArrayList arrayList2 = new ArrayList();
            it = bVar62.keySet().iterator();
            while (it.hasNext()) {
                int intValue5 = ((Integer) it.next()).intValue();
                if (!hashSet6.contains(Integer.valueOf(intValue5))) {
                    O o2 = (O) bVar61.get(Integer.valueOf(intValue5));
                    if (o2 == null) {
                        aVar = O.v();
                    } else {
                        aVar = (a) o2.k();
                    }
                    aVar.a(intValue5);
                    X.a w5 = X.w();
                    w5.b((Iterable<? extends Long>) Sd.a((BitSet) bVar62.get(Integer.valueOf(intValue5))));
                    b bVar64 = bVar63;
                    w5.a((Iterable<? extends Long>) Sd.a((BitSet) bVar64.get(Integer.valueOf(intValue5))));
                    if (i2) {
                        bVar3 = bVar60;
                        w5.c(a((Map) bVar3.get(Integer.valueOf(intValue5))));
                        bVar2 = bVar50;
                        Map map21 = (Map) bVar2.get(Integer.valueOf(intValue5));
                        if (map21 == null) {
                            it2 = it;
                            bVar = bVar62;
                            collection = Collections.emptyList();
                        } else {
                            ArrayList arrayList3 = new ArrayList(map21.size());
                            for (Integer num : map21.keySet()) {
                                Iterator it17 = it;
                                Y.a s2 = Y.s();
                                s2.a(num.intValue());
                                List<Long> list5 = (List) map21.get(num);
                                if (list5 != null) {
                                    Collections.sort(list5);
                                    for (Long longValue : list5) {
                                        b bVar65 = bVar62;
                                        Map map22 = map21;
                                        s2.a(longValue.longValue());
                                        map21 = map22;
                                        bVar62 = bVar65;
                                    }
                                }
                                b bVar66 = bVar62;
                                Map map23 = map21;
                                arrayList3.add((Y) s2.A());
                                it = it17;
                                map21 = map23;
                                bVar62 = bVar66;
                            }
                            it2 = it;
                            bVar = bVar62;
                            collection = arrayList3;
                        }
                        if (d2 && aVar.k()) {
                            List<Y> u = aVar.l().u();
                            if (!u.isEmpty()) {
                                List arrayList4 = new ArrayList(collection);
                                b bVar67 = new b();
                                for (Y y : u) {
                                    if (y.p() && y.r() > 0) {
                                        bVar67.put(Integer.valueOf(y.o()), Long.valueOf(y.b(y.r() - 1)));
                                    }
                                }
                                for (int i6 = 0; i6 < arrayList4.size(); i6++) {
                                    Y y2 = (Y) arrayList4.get(i6);
                                    Long l8 = (Long) bVar67.remove(y2.p() ? Integer.valueOf(y2.o()) : null);
                                    if (l8 != null) {
                                        ArrayList arrayList5 = new ArrayList();
                                        if (l8.longValue() < y2.b(0)) {
                                            arrayList5.add(l8);
                                        }
                                        arrayList5.addAll(y2.q());
                                        Y.a aVar3 = (Y.a) y2.k();
                                        aVar3.j();
                                        aVar3.a((Iterable<? extends Long>) arrayList5);
                                        arrayList4.set(i6, (Y) aVar3.A());
                                    }
                                }
                                for (Integer num2 : bVar67.keySet()) {
                                    Y.a s3 = Y.s();
                                    s3.a(num2.intValue());
                                    b bVar68 = bVar67;
                                    s3.a(((Long) bVar67.get(num2)).longValue());
                                    arrayList4.add((Y) s3.A());
                                    bVar67 = bVar68;
                                }
                                iterable = arrayList4;
                                w5.d(iterable);
                            }
                        }
                        iterable = collection;
                        w5.d(iterable);
                    } else {
                        it2 = it;
                        bVar = bVar62;
                        bVar3 = bVar60;
                        bVar2 = bVar50;
                    }
                    aVar.a(w5);
                    bVar61.put(Integer.valueOf(intValue5), (O) aVar.A());
                    arrayList2.add((O) aVar.A());
                    ke p5 = p();
                    X j8 = aVar.j();
                    p5.t();
                    p5.j();
                    q.b(str);
                    q.a(j8);
                    byte[] g2 = j8.g();
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("app_id", str);
                    contentValues2.put("audience_id", Integer.valueOf(intValue5));
                    contentValues2.put("current_results", g2);
                    try {
                        try {
                            if (p5.x().insertWithOnConflict("audience_filter_values", null, contentValues2, 5) == -1) {
                                p5.e().t().a("Failed to insert filter results (got -1). appId", C0532kb.a(str));
                            }
                        } catch (SQLiteException e6) {
                            e = e6;
                            p5.e().t().a("Error storing filter results. appId", C0532kb.a(str), e);
                            it = it2;
                            bVar63 = bVar64;
                            bVar60 = bVar3;
                            bVar50 = bVar2;
                            bVar62 = bVar;
                        }
                    } catch (SQLiteException e7) {
                        e = e7;
                        p5.e().t().a("Error storing filter results. appId", C0532kb.a(str), e);
                        it = it2;
                        bVar63 = bVar64;
                        bVar60 = bVar3;
                        bVar50 = bVar2;
                        bVar62 = bVar;
                    }
                    it = it2;
                    bVar63 = bVar64;
                    bVar60 = bVar3;
                    bVar50 = bVar2;
                } else {
                    bVar = bVar62;
                    String str39 = str;
                }
                bVar62 = bVar;
            }
            return arrayList2;
        }
        l2 = null;
        p = p();
        p.t();
        p.j();
        q.b(str);
        ContentValues contentValues3 = new ContentValues();
        contentValues3.put("current_session_count", Integer.valueOf(0));
        try {
            p.x().update("events", contentValues3, "app_id = ?", new String[]{str21});
        } catch (SQLiteException e8) {
            p.e().t().a("Error resetting session-scoped event counts. appId", C0532kb.a(str), e8);
        }
        f2 = p().f(str21);
        HashSet hashSet42 = new HashSet(f2.keySet());
        if (d3) {
        }
        map10 = f2;
        it6 = hashSet42.iterator();
        while (it6.hasNext()) {
        }
        b bVar402 = bVar34;
        b bVar412 = bVar35;
        b bVar422 = bVar33;
        String str222 = "Filter definition";
        String str232 = "Skipping failed audience ID";
        Object obj52 = "null";
        if (!list.isEmpty()) {
        }
        String str302 = str21;
        b bVar502 = bVar36;
        b bVar512 = bVar32;
        String str312 = str222;
        HashSet hashSet62 = hashSet3;
        b bVar522 = bVar402;
        b bVar532 = bVar412;
        b bVar542 = bVar422;
        String str322 = str232;
        if (!list2.isEmpty()) {
        }
        b bVar602 = bVar532;
        b bVar612 = bVar512;
        b bVar622 = bVar542;
        b bVar632 = bVar522;
        ArrayList arrayList22 = new ArrayList();
        it = bVar622.keySet().iterator();
        while (it.hasNext()) {
        }
        return arrayList22;
    }

    /* access modifiers changed from: protected */
    public final boolean u() {
        return false;
    }

    private final Boolean a(C c2, String str, List<T> list, long j2) {
        Boolean bool;
        boolean t = c2.t();
        Boolean valueOf = Boolean.valueOf(false);
        if (t) {
            Boolean a2 = a(j2, c2.u());
            if (a2 == null) {
                return null;
            }
            if (!a2.booleanValue()) {
                return valueOf;
            }
        }
        HashSet hashSet = new HashSet();
        for (D d2 : c2.s()) {
            if (d2.u().isEmpty()) {
                e().w().a("null or empty param name in filter. event", l().a(str));
                return null;
            }
            hashSet.add(d2.u());
        }
        b bVar = new b();
        for (T t2 : list) {
            if (hashSet.contains(t2.o())) {
                if (t2.r()) {
                    bVar.put(t2.o(), t2.r() ? Long.valueOf(t2.s()) : null);
                } else if (t2.t()) {
                    bVar.put(t2.o(), t2.t() ? Double.valueOf(t2.u()) : null);
                } else if (t2.p()) {
                    bVar.put(t2.o(), t2.q());
                } else {
                    e().w().a("Unknown value for param. event, param", l().a(str), l().b(t2.o()));
                    return null;
                }
            }
        }
        Iterator it = c2.s().iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                return Boolean.valueOf(true);
            }
            D d3 = (D) it.next();
            if (!d3.s() || !d3.t()) {
                z = false;
            }
            String u = d3.u();
            if (u.isEmpty()) {
                e().w().a("Event has empty param name. event", l().a(str));
                return null;
            }
            Object obj = bVar.get(u);
            if (obj instanceof Long) {
                if (!d3.q()) {
                    e().w().a("No number filter for long param. event, param", l().a(str), l().b(u));
                    return null;
                }
                Boolean a3 = a(((Long) obj).longValue(), d3.r());
                if (a3 == null) {
                    return null;
                }
                if (a3.booleanValue() == z) {
                    return valueOf;
                }
            } else if (obj instanceof Double) {
                if (!d3.q()) {
                    e().w().a("No number filter for double param. event, param", l().a(str), l().b(u));
                    return null;
                }
                Boolean a4 = a(((Double) obj).doubleValue(), d3.r());
                if (a4 == null) {
                    return null;
                }
                if (a4.booleanValue() == z) {
                    return valueOf;
                }
            } else if (obj instanceof String) {
                if (d3.o()) {
                    bool = a((String) obj, d3.p());
                } else if (d3.q()) {
                    String str2 = (String) obj;
                    if (Sd.a(str2)) {
                        bool = a(str2, d3.r());
                    } else {
                        e().w().a("Invalid param value for number filter. event, param", l().a(str), l().b(u));
                        return null;
                    }
                } else {
                    e().w().a("No filter for String param. event, param", l().a(str), l().b(u));
                    return null;
                }
                if (bool == null) {
                    return null;
                }
                if (bool.booleanValue() == z) {
                    return valueOf;
                }
            } else if (obj == null) {
                e().B().a("Missing param for filter. event, param", l().a(str), l().b(u));
                return valueOf;
            } else {
                e().w().a("Unknown param type. event, param", l().a(str), l().b(u));
                return null;
            }
        }
    }

    private final Boolean a(F f2, Z z) {
        D w = f2.w();
        boolean t = w.t();
        if (z.r()) {
            if (w.q()) {
                return a(a(z.s(), w.r()), t);
            }
            e().w().a("No number filter for long property. property", l().c(z.o()));
            return null;
        } else if (z.t()) {
            if (w.q()) {
                return a(a(z.u(), w.r()), t);
            }
            e().w().a("No number filter for double property. property", l().c(z.o()));
            return null;
        } else if (!z.p()) {
            e().w().a("User property has no value, property", l().c(z.o()));
            return null;
        } else if (w.o()) {
            return a(a(z.q(), w.p()), t);
        } else {
            if (!w.q()) {
                e().w().a("No string or number filter defined. property", l().c(z.o()));
            } else if (Sd.a(z.q())) {
                return a(a(z.q(), w.r()), t);
            } else {
                e().w().a("Invalid user property value for Numeric number filter. property, value", l().c(z.o()), z.q());
            }
            return null;
        }
    }

    private static Boolean a(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    private final Boolean a(String str, G g2) {
        String str2;
        List list;
        q.a(g2);
        if (str == null || !g2.o() || g2.p() == G.a.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        if (g2.p() == G.a.IN_LIST) {
            if (g2.v() == 0) {
                return null;
            }
        } else if (!g2.q()) {
            return null;
        }
        G.a p = g2.p();
        boolean t = g2.t();
        if (t || p == G.a.REGEXP || p == G.a.IN_LIST) {
            str2 = g2.r();
        } else {
            str2 = g2.r().toUpperCase(Locale.ENGLISH);
        }
        String str3 = str2;
        if (g2.v() == 0) {
            list = null;
        } else {
            List<String> u = g2.u();
            if (!t) {
                ArrayList arrayList = new ArrayList(u.size());
                for (String upperCase : u) {
                    arrayList.add(upperCase.toUpperCase(Locale.ENGLISH));
                }
                u = Collections.unmodifiableList(arrayList);
            }
            list = u;
        }
        return a(str, p, t, str3, list, p == G.a.REGEXP ? str3 : null);
    }

    private final Boolean a(String str, G.a aVar, boolean z, String str2, List<String> list, String str3) {
        if (str == null) {
            return null;
        }
        if (aVar == G.a.IN_LIST) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && aVar != G.a.REGEXP) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (be.f5841a[aVar.ordinal()]) {
            case 1:
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    e().w().a("Invalid regular expression in REGEXP audience filter. expression", str3);
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    private final Boolean a(long j2, E e2) {
        try {
            return a(new BigDecimal(j2), e2, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private final Boolean a(double d2, E e2) {
        try {
            return a(new BigDecimal(d2), e2, Math.ulp(d2));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private final Boolean a(String str, E e2) {
        if (!Sd.a(str)) {
            return null;
        }
        try {
            return a(new BigDecimal(str), e2, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0085, code lost:
        if (r2 != null) goto L_0x0087;
     */
    private static Boolean a(BigDecimal bigDecimal, E e2, double d2) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        q.a(e2);
        if (e2.o() && e2.p() != E.b.UNKNOWN_COMPARISON_TYPE) {
            if (e2.p() == E.b.BETWEEN) {
                if (!e2.u() || !e2.w()) {
                    return null;
                }
            } else if (!e2.s()) {
                return null;
            }
            E.b p = e2.p();
            if (e2.p() == E.b.BETWEEN) {
                if (Sd.a(e2.v()) && Sd.a(e2.x())) {
                    try {
                        BigDecimal bigDecimal5 = new BigDecimal(e2.v());
                        bigDecimal3 = new BigDecimal(e2.x());
                        bigDecimal2 = bigDecimal5;
                        bigDecimal4 = null;
                    } catch (NumberFormatException unused) {
                    }
                }
                return null;
            } else if (!Sd.a(e2.t())) {
                return null;
            } else {
                try {
                    bigDecimal4 = new BigDecimal(e2.t());
                    bigDecimal2 = null;
                    bigDecimal3 = null;
                } catch (NumberFormatException unused2) {
                }
            }
            if (p == E.b.BETWEEN) {
                if (bigDecimal2 == null) {
                    return null;
                }
            }
            int i2 = be.f5842b[p.ordinal()];
            boolean z = false;
            if (i2 == 1) {
                if (bigDecimal.compareTo(bigDecimal4) == -1) {
                    z = true;
                }
                return Boolean.valueOf(z);
            } else if (i2 == 2) {
                if (bigDecimal.compareTo(bigDecimal4) == 1) {
                    z = true;
                }
                return Boolean.valueOf(z);
            } else if (i2 != 3) {
                if (i2 == 4) {
                    if (!(bigDecimal.compareTo(bigDecimal2) == -1 || bigDecimal.compareTo(bigDecimal3) == 1)) {
                        z = true;
                    }
                    return Boolean.valueOf(z);
                }
            } else if (d2 != 0.0d) {
                if (bigDecimal.compareTo(bigDecimal4.subtract(new BigDecimal(d2).multiply(new BigDecimal(2)))) == 1 && bigDecimal.compareTo(bigDecimal4.add(new BigDecimal(d2).multiply(new BigDecimal(2)))) == -1) {
                    z = true;
                }
                return Boolean.valueOf(z);
            } else {
                if (bigDecimal.compareTo(bigDecimal4) == 0) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        }
        return null;
    }

    private static List<P> a(Map<Integer, Long> map) {
        if (map == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Integer intValue : map.keySet()) {
            int intValue2 = intValue.intValue();
            P.a s = P.s();
            s.a(intValue2);
            s.a(((Long) map.get(Integer.valueOf(intValue2))).longValue());
            arrayList.add((P) s.A());
        }
        return arrayList;
    }

    private static void a(Map<Integer, Long> map, int i2, long j2) {
        Long l2 = (Long) map.get(Integer.valueOf(i2));
        long j3 = j2 / 1000;
        if (l2 == null || j3 > l2.longValue()) {
            map.put(Integer.valueOf(i2), Long.valueOf(j3));
        }
    }
}
