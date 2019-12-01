package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import b.d.b;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.internal.measurement.C;
import com.google.android.gms.internal.measurement.C0337ca;
import com.google.android.gms.internal.measurement.C0428rb;
import com.google.android.gms.internal.measurement.Eb;
import com.google.android.gms.internal.measurement.F;
import com.google.android.gms.internal.measurement.Q;
import com.google.android.gms.internal.measurement.T;
import com.google.android.gms.internal.measurement.V;
import com.google.android.gms.internal.measurement.V.a;
import com.google.android.gms.internal.measurement.X;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class ke extends Ld {
    /* access modifiers changed from: private */

    /* renamed from: d reason: collision with root package name */
    public static final String[] f5994d = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    /* access modifiers changed from: private */

    /* renamed from: e reason: collision with root package name */
    public static final String[] f5995e = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    /* access modifiers changed from: private */

    /* renamed from: f reason: collision with root package name */
    public static final String[] f5996f = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;"};
    /* access modifiers changed from: private */

    /* renamed from: g reason: collision with root package name */
    public static final String[] f5997g = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    /* access modifiers changed from: private */

    /* renamed from: h reason: collision with root package name */
    public static final String[] f5998h = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    /* access modifiers changed from: private */

    /* renamed from: i reason: collision with root package name */
    public static final String[] f5999i;
    /* access modifiers changed from: private */

    /* renamed from: j reason: collision with root package name */
    public static final String[] f6000j;
    /* access modifiers changed from: private */

    /* renamed from: k reason: collision with root package name */
    public static final String[] f6001k = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};

    /* renamed from: l reason: collision with root package name */
    private final le f6002l = new le(this, a(), "google_app_measurement.db");
    /* access modifiers changed from: private */
    public final Hd m = new Hd(c());

    static {
        String str = "session_scoped";
        f5999i = new String[]{str, "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
        f6000j = new String[]{str, "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    }

    ke(Kd kd) {
        super(kd);
    }

    private final boolean P() {
        return a().getDatabasePath("google_app_measurement.db").exists();
    }

    private final long a(String str, String[] strArr, long j2) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = x().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j3 = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j3;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return j2;
        } catch (SQLiteException e2) {
            e().t().a("Database error", str, e2);
            throw e2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private final long b(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = x().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j2 = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j2;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e2) {
            e().t().a("Database error", str, e2);
            throw e2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final boolean A() {
        return b("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    /* access modifiers changed from: 0000 */
    public final void B() {
        j();
        t();
        if (P()) {
            long a2 = f().f6106i.a();
            long a3 = c().a();
            if (Math.abs(a3 - a2) > ((Long) C0535l.J.a(null)).longValue()) {
                f().f6106i.a(a3);
                j();
                t();
                if (P()) {
                    int delete = x().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(c().currentTimeMillis()), String.valueOf(fe.t())});
                    if (delete > 0) {
                        e().B().a("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                    }
                }
            }
        }
    }

    public final long C() {
        return a("select max(bundle_end_timestamp) from queue", (String[]) null, 0);
    }

    public final long D() {
        return a("select max(timestamp) from raw_events", (String[]) null, 0);
    }

    public final boolean E() {
        return b("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean F() {
        return b("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }

    public final long G() {
        Cursor cursor = null;
        try {
            cursor = x().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
            if (!cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return -1;
            }
            long j2 = cursor.getLong(0);
            if (cursor != null) {
                cursor.close();
            }
            return j2;
        } catch (SQLiteException e2) {
            e().t().a("Error querying raw events", e2);
            if (cursor != null) {
                cursor.close();
            }
            return -1;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void c(String str, String str2) {
        q.b(str);
        q.b(str2);
        j();
        t();
        try {
            e().B().a("Deleted user attribute rows", Integer.valueOf(x().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e2) {
            e().t().a("Error deleting user attribute. appId", C0532kb.a(str), l().c(str2), e2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a9  */
    public final Td d(String str, String str2) {
        Cursor cursor;
        String str3 = str2;
        q.b(str);
        q.b(str2);
        j();
        t();
        try {
            cursor = x().query("user_attributes", new String[]{"set_timestamp", "value", "origin"}, "app_id=? and name=?", new String[]{str, str3}, null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                long j2 = cursor.getLong(0);
                try {
                    String str4 = str;
                    Td td = new Td(str4, cursor.getString(2), str2, j2, a(cursor, 1));
                    if (cursor.moveToNext()) {
                        e().t().a("Got multiple records for user property, expected one. appId", C0532kb.a(str));
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return td;
                } catch (SQLiteException e2) {
                    e = e2;
                    try {
                        e().t().a("Error querying user property. appId", C0532kb.a(str), l().c(str3), e);
                        if (cursor != null) {
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                        }
                        throw th;
                    }
                }
            } catch (SQLiteException e3) {
                e = e3;
                e().t().a("Error querying user property. appId", C0532kb.a(str), l().c(str3), e);
                if (cursor != null) {
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            e().t().a("Error querying user property. appId", C0532kb.a(str), l().c(str3), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0125  */
    public final de e(String str, String str2) {
        Cursor cursor;
        String str3 = str2;
        q.b(str);
        q.b(str2);
        j();
        t();
        try {
            cursor = x().query("conditional_properties", new String[]{"origin", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, "app_id=? and name=?", new String[]{str, str3}, null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                String string = cursor.getString(0);
                try {
                    Object a2 = a(cursor, 1);
                    boolean z = cursor.getInt(2) != 0;
                    String string2 = cursor.getString(3);
                    long j2 = cursor.getLong(4);
                    C0525j jVar = (C0525j) n().a(cursor.getBlob(5), C0525j.CREATOR);
                    long j3 = cursor.getLong(6);
                    C0525j jVar2 = (C0525j) n().a(cursor.getBlob(7), C0525j.CREATOR);
                    long j4 = cursor.getLong(8);
                    long j5 = cursor.getLong(9);
                    C0525j jVar3 = (C0525j) n().a(cursor.getBlob(10), C0525j.CREATOR);
                    Rd rd = new Rd(str2, j4, a2, string);
                    de deVar = new de(str, string, rd, j3, z, string2, jVar, j2, jVar2, j5, jVar3);
                    if (cursor.moveToNext()) {
                        e().t().a("Got multiple records for conditional property, expected one", C0532kb.a(str), l().c(str3));
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return deVar;
                } catch (SQLiteException e2) {
                    e = e2;
                    try {
                        e().t().a("Error querying conditional property", C0532kb.a(str), l().c(str3), e);
                        if (cursor != null) {
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            } catch (SQLiteException e3) {
                e = e3;
                e().t().a("Error querying conditional property", C0532kb.a(str), l().c(str3), e);
                if (cursor != null) {
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            e().t().a("Error querying conditional property", C0532kb.a(str), l().c(str3), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            if (cursor != null) {
            }
            throw th;
        }
    }

    public final int f(String str, String str2) {
        q.b(str);
        q.b(str2);
        j();
        t();
        try {
            return x().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e2) {
            e().t().a("Error deleting conditional property", C0532kb.a(str), l().c(str2), e2);
            return 0;
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ad  */
    public final Map<Integer, List<C>> g(String str, String str2) {
        Cursor cursor;
        t();
        j();
        q.b(str);
        q.b(str2);
        b bVar = new b();
        try {
            cursor = x().query("event_filters", new String[]{"audience_id", "data"}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    Map<Integer, List<C>> emptyMap = Collections.emptyMap();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return emptyMap;
                }
                do {
                    try {
                        C a2 = C.a(cursor.getBlob(1), C0428rb.c());
                        int i2 = cursor.getInt(0);
                        List list = (List) bVar.get(Integer.valueOf(i2));
                        if (list == null) {
                            list = new ArrayList();
                            bVar.put(Integer.valueOf(i2), list);
                        }
                        list.add(a2);
                    } catch (IOException e2) {
                        e().t().a("Failed to merge filter. appId", C0532kb.a(str), e2);
                    }
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                return bVar;
            } catch (SQLiteException e3) {
                e = e3;
                try {
                    e().t().a("Database error querying filters. appId", C0532kb.a(str), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            e().t().a("Database error querying filters. appId", C0532kb.a(str), e);
            if (cursor != null) {
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ad  */
    public final Map<Integer, List<F>> h(String str, String str2) {
        Cursor cursor;
        t();
        j();
        q.b(str);
        q.b(str2);
        b bVar = new b();
        try {
            cursor = x().query("property_filters", new String[]{"audience_id", "data"}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    Map<Integer, List<F>> emptyMap = Collections.emptyMap();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return emptyMap;
                }
                do {
                    try {
                        F a2 = F.a(cursor.getBlob(1), C0428rb.c());
                        int i2 = cursor.getInt(0);
                        List list = (List) bVar.get(Integer.valueOf(i2));
                        if (list == null) {
                            list = new ArrayList();
                            bVar.put(Integer.valueOf(i2), list);
                        }
                        list.add(a2);
                    } catch (IOException e2) {
                        e().t().a("Failed to merge filter", C0532kb.a(str), e2);
                    }
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                return bVar;
            } catch (SQLiteException e3) {
                e = e3;
                try {
                    e().t().a("Database error querying filters. appId", C0532kb.a(str), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            e().t().a("Database error querying filters. appId", C0532kb.a(str), e);
            if (cursor != null) {
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public final long i(String str, String str2) {
        long j2;
        String str3;
        String str4;
        String str5 = str;
        String str6 = str2;
        q.b(str);
        q.b(str2);
        j();
        t();
        SQLiteDatabase x = x();
        x.beginTransaction();
        try {
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 32);
            sb.append("select ");
            sb.append(str6);
            sb.append(" from app2 where app_id=?");
            try {
                j2 = a(sb.toString(), new String[]{str5}, -1);
                str3 = "app2";
                str4 = "app_id";
                if (j2 == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(str4, str5);
                    contentValues.put("first_open_count", Integer.valueOf(0));
                    contentValues.put("previous_install_count", Integer.valueOf(0));
                    if (x.insertWithOnConflict(str3, null, contentValues, 5) == -1) {
                        e().t().a("Failed to insert column (got -1). appId", C0532kb.a(str), str6);
                        x.endTransaction();
                        return -1;
                    }
                    j2 = 0;
                }
            } catch (SQLiteException e2) {
                e = e2;
                j2 = 0;
                try {
                    e().t().a("Error inserting column. appId", C0532kb.a(str), str6, e);
                    x.endTransaction();
                    return j2;
                } catch (Throwable th) {
                    th = th;
                    x.endTransaction();
                    throw th;
                }
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put(str4, str5);
                contentValues2.put(str6, Long.valueOf(1 + j2));
                if (((long) x.update(str3, contentValues2, "app_id = ?", new String[]{str5})) == 0) {
                    e().t().a("Failed to update column (got 0). appId", C0532kb.a(str), str6);
                    x.endTransaction();
                    return -1;
                }
                x.setTransactionSuccessful();
                x.endTransaction();
                return j2;
            } catch (SQLiteException e3) {
                e = e3;
                e().t().a("Error inserting column. appId", C0532kb.a(str), str6, e);
                x.endTransaction();
                return j2;
            }
        } catch (SQLiteException e4) {
            e = e4;
            j2 = 0;
            e().t().a("Error inserting column. appId", C0532kb.a(str), str6, e);
            x.endTransaction();
            return j2;
        } catch (Throwable th2) {
            th = th2;
            x.endTransaction();
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean u() {
        return false;
    }

    public final void v() {
        t();
        x().beginTransaction();
    }

    public final void w() {
        t();
        x().endTransaction();
    }

    /* access modifiers changed from: 0000 */
    public final SQLiteDatabase x() {
        j();
        try {
            return this.f6002l.getWritableDatabase();
        } catch (SQLiteException e2) {
            e().w().a("Error opening database", e2);
            throw e2;
        }
    }

    public final void y() {
        t();
        x().setTransactionSuccessful();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0041  */
    public final String z() {
        Cursor cursor;
        try {
            cursor = x().rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
            try {
                if (cursor.moveToFirst()) {
                    String string = cursor.getString(0);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return string;
                }
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    e().t().a("Database error getting next bundle app id", e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            e().t().a("Database error getting next bundle app id", e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void a(C0505f fVar) {
        q.a(fVar);
        j();
        t();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", fVar.f5898a);
        contentValues.put("name", fVar.f5899b);
        contentValues.put("lifetime_count", Long.valueOf(fVar.f5900c));
        contentValues.put("current_bundle_count", Long.valueOf(fVar.f5901d));
        contentValues.put("last_fire_timestamp", Long.valueOf(fVar.f5903f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(fVar.f5904g));
        contentValues.put("last_bundled_day", fVar.f5905h);
        contentValues.put("last_sampled_complex_event_id", fVar.f5906i);
        contentValues.put("last_sampling_rate", fVar.f5907j);
        if (g().e(fVar.f5898a, C0535l.Fa)) {
            contentValues.put("current_session_count", Long.valueOf(fVar.f5902e));
        }
        Boolean bool = fVar.f5908k;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : Long.valueOf(1));
        try {
            if (x().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                e().t().a("Failed to insert/update event aggregates (got -1). appId", C0532kb.a(fVar.f5898a));
            }
        } catch (SQLiteException e2) {
            e().t().a("Error storing event aggregates. appId", C0532kb.a(fVar.f5898a), e2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x015b  */
    public final C0505f b(String str, String str2) {
        Cursor cursor;
        Boolean bool;
        String str3 = str;
        String str4 = str2;
        q.b(str);
        q.b(str2);
        j();
        t();
        boolean e2 = g().e(str3, C0535l.Fa);
        ArrayList arrayList = new ArrayList(Arrays.asList(new String[]{"lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_bundled_day", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling"}));
        if (e2) {
            arrayList.add("current_session_count");
        }
        try {
            boolean z = false;
            Cursor query = x().query("events", (String[]) arrayList.toArray(new String[0]), "app_id=? and name=?", new String[]{str3, str4}, null, null, null);
            try {
                if (!query.moveToFirst()) {
                    if (query != null) {
                        query.close();
                    }
                    return null;
                }
                long j2 = query.getLong(0);
                long j3 = query.getLong(1);
                long j4 = query.getLong(2);
                long j5 = 0;
                long j6 = query.isNull(3) ? 0 : query.getLong(3);
                Long valueOf = query.isNull(4) ? null : Long.valueOf(query.getLong(4));
                Long valueOf2 = query.isNull(5) ? null : Long.valueOf(query.getLong(5));
                Long valueOf3 = query.isNull(6) ? null : Long.valueOf(query.getLong(6));
                if (!query.isNull(7)) {
                    if (query.getLong(7) == 1) {
                        z = true;
                    }
                    bool = Boolean.valueOf(z);
                } else {
                    bool = null;
                }
                if (e2 && !query.isNull(8)) {
                    j5 = query.getLong(8);
                }
                r1 = r1;
                cursor = query;
                try {
                    C0505f fVar = new C0505f(str, str2, j2, j3, j5, j4, j6, valueOf, valueOf2, valueOf3, bool);
                    if (cursor.moveToNext()) {
                        e().t().a("Got multiple records for event aggregates, expected one. appId", C0532kb.a(str));
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return fVar;
                } catch (SQLiteException e3) {
                    e = e3;
                    try {
                        e().t().a("Error querying events. appId", C0532kb.a(str), l().a(str2), e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                        }
                        throw th;
                    }
                }
            } catch (SQLiteException e4) {
                e = e4;
                cursor = query;
                e().t().a("Error querying events. appId", C0532kb.a(str), l().a(str2), e);
                if (cursor != null) {
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                cursor = query;
                if (cursor != null) {
                }
                throw th;
            }
        } catch (SQLiteException e5) {
            e = e5;
            cursor = null;
            e().t().a("Error querying events. appId", C0532kb.a(str), l().a(str2), e);
            if (cursor != null) {
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0093  */
    public final Map<Integer, X> f(String str) {
        Cursor cursor;
        t();
        j();
        q.b(str);
        try {
            cursor = x().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                b bVar = new b();
                do {
                    int i2 = cursor.getInt(0);
                    try {
                        bVar.put(Integer.valueOf(i2), X.a(cursor.getBlob(1), C0428rb.c()));
                    } catch (IOException e2) {
                        e().t().a("Failed to merge filter results. appId, audienceId, error", C0532kb.a(str), Integer.valueOf(i2), e2);
                    }
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                return bVar;
            } catch (SQLiteException e3) {
                e = e3;
                try {
                    e().t().a("Database error querying filter results. appId", C0532kb.a(str), e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            e().t().a("Database error querying filter results. appId", C0532kb.a(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
            }
            throw th;
        }
    }

    public final long c(String str) {
        q.b(str);
        j();
        t();
        try {
            return (long) x().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, g().b(str, C0535l.A))))});
        } catch (SQLiteException e2) {
            e().t().a("Error deleting over the limit events. appId", C0532kb.a(str), e2);
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0073  */
    public final byte[] d(String str) {
        Cursor cursor;
        q.b(str);
        j();
        t();
        try {
            cursor = x().query("apps", new String[]{"remote_config"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                byte[] blob = cursor.getBlob(0);
                if (cursor.moveToNext()) {
                    e().t().a("Got multiple records for app config, expected one. appId", C0532kb.a(str));
                }
                if (cursor != null) {
                    cursor.close();
                }
                return blob;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    e().t().a("Error querying remote config. appId", C0532kb.a(str), e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            e().t().a("Error querying remote config. appId", C0532kb.a(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
            }
            throw th;
        }
    }

    public final long g(String str) {
        q.b(str);
        return a("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0086  */
    public final Map<Integer, List<Integer>> e(String str) {
        Cursor cursor;
        t();
        j();
        q.b(str);
        b bVar = new b();
        try {
            cursor = x().rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str, str});
            try {
                if (!cursor.moveToFirst()) {
                    Map<Integer, List<Integer>> emptyMap = Collections.emptyMap();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return emptyMap;
                }
                do {
                    int i2 = cursor.getInt(0);
                    List list = (List) bVar.get(Integer.valueOf(i2));
                    if (list == null) {
                        list = new ArrayList();
                        bVar.put(Integer.valueOf(i2), list);
                    }
                    list.add(Integer.valueOf(cursor.getInt(1)));
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                return bVar;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    e().t().a("Database error querying scoped filters. appId", C0532kb.a(str), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            e().t().a("Database error querying scoped filters. appId", C0532kb.a(str), e);
            if (cursor != null) {
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
            }
            throw th;
        }
    }

    public final boolean a(Td td) {
        q.a(td);
        j();
        t();
        if (d(td.f5721a, td.f5723c) == null) {
            if (Wd.a(td.f5723c)) {
                if (b("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{td.f5721a}) >= 25) {
                    return false;
                }
            } else {
                String str = "select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'";
                if (g().e(td.f5721a, C0535l.pa)) {
                    if (!"_npa".equals(td.f5723c)) {
                        if (b(str, new String[]{td.f5721a, td.f5722b}) >= 25) {
                            return false;
                        }
                    }
                } else {
                    if (b(str, new String[]{td.f5721a, td.f5722b}) >= 25) {
                        return false;
                    }
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", td.f5721a);
        contentValues.put("origin", td.f5722b);
        contentValues.put("name", td.f5723c);
        contentValues.put("set_timestamp", Long.valueOf(td.f5724d));
        a(contentValues, "value", td.f5725e);
        try {
            if (x().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                e().t().a("Failed to insert/update user property (got -1). appId", C0532kb.a(td.f5721a));
            }
        } catch (SQLiteException e2) {
            e().t().a("Error storing user property. appId", C0532kb.a(td.f5721a), e2);
        }
        return true;
    }

    public final List<de> b(String str, String str2, String str3) {
        q.b(str);
        j();
        t();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return a(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0119 A[Catch:{ SQLiteException -> 0x01d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x011d A[Catch:{ SQLiteException -> 0x01d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0153 A[Catch:{ SQLiteException -> 0x01d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0155 A[Catch:{ SQLiteException -> 0x01d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0164 A[Catch:{ SQLiteException -> 0x01d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0179 A[Catch:{ SQLiteException -> 0x01d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0195 A[Catch:{ SQLiteException -> 0x01d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0196 A[Catch:{ SQLiteException -> 0x01d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01a5 A[Catch:{ SQLiteException -> 0x01d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01c0 A[Catch:{ SQLiteException -> 0x01d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01fd  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0204  */
    public final Fb b(String str) {
        Cursor cursor;
        boolean z;
        boolean z2;
        String str2 = str;
        q.b(str);
        j();
        t();
        try {
            boolean z3 = true;
            cursor = x().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count", "daily_realtime_events_count", "health_monitor_sample", "android_id", "adid_reporting_enabled", "ssaid_reporting_enabled", "admob_app_id", "dynamite_version", "safelisted_events"}, "app_id=?", new String[]{str2}, null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                try {
                    Fb fb = new Fb(this.f5601b.r(), str2);
                    fb.a(cursor.getString(0));
                    fb.b(cursor.getString(1));
                    fb.d(cursor.getString(2));
                    fb.g(cursor.getLong(3));
                    fb.a(cursor.getLong(4));
                    fb.b(cursor.getLong(5));
                    fb.f(cursor.getString(6));
                    fb.g(cursor.getString(7));
                    fb.d(cursor.getLong(8));
                    fb.e(cursor.getLong(9));
                    if (!cursor.isNull(10)) {
                        if (cursor.getInt(10) == 0) {
                            z = false;
                            fb.a(z);
                            fb.j(cursor.getLong(11));
                            fb.k(cursor.getLong(12));
                            fb.l(cursor.getLong(13));
                            fb.m(cursor.getLong(14));
                            fb.h(cursor.getLong(15));
                            fb.i(cursor.getLong(16));
                            fb.c(!cursor.isNull(17) ? -2147483648L : (long) cursor.getInt(17));
                            fb.e(cursor.getString(18));
                            fb.o(cursor.getLong(19));
                            fb.n(cursor.getLong(20));
                            fb.h(cursor.getString(21));
                            long j2 = 0;
                            fb.p(!cursor.isNull(22) ? 0 : cursor.getLong(22));
                            if (!cursor.isNull(23)) {
                                if (cursor.getInt(23) == 0) {
                                    z2 = false;
                                    fb.b(z2);
                                    if (!cursor.isNull(24)) {
                                        if (cursor.getInt(24) == 0) {
                                            z3 = false;
                                        }
                                    }
                                    fb.c(z3);
                                    fb.c(cursor.getString(25));
                                    if (!cursor.isNull(26)) {
                                        j2 = cursor.getLong(26);
                                    }
                                    fb.f(j2);
                                    if (!cursor.isNull(27)) {
                                        fb.a(Arrays.asList(cursor.getString(27).split(",", -1)));
                                    }
                                    fb.e();
                                    if (cursor.moveToNext()) {
                                        e().t().a("Got multiple records for app, expected one. appId", C0532kb.a(str));
                                    }
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    return fb;
                                }
                            }
                            z2 = true;
                            fb.b(z2);
                            if (!cursor.isNull(24)) {
                            }
                            fb.c(z3);
                            fb.c(cursor.getString(25));
                            if (!cursor.isNull(26)) {
                            }
                            fb.f(j2);
                            if (!cursor.isNull(27)) {
                            }
                            fb.e();
                            if (cursor.moveToNext()) {
                            }
                            if (cursor != null) {
                            }
                            return fb;
                        }
                    }
                    z = true;
                    fb.a(z);
                    fb.j(cursor.getLong(11));
                    fb.k(cursor.getLong(12));
                    fb.l(cursor.getLong(13));
                    fb.m(cursor.getLong(14));
                    fb.h(cursor.getLong(15));
                    fb.i(cursor.getLong(16));
                    fb.c(!cursor.isNull(17) ? -2147483648L : (long) cursor.getInt(17));
                    fb.e(cursor.getString(18));
                    fb.o(cursor.getLong(19));
                    fb.n(cursor.getLong(20));
                    fb.h(cursor.getString(21));
                    long j22 = 0;
                    fb.p(!cursor.isNull(22) ? 0 : cursor.getLong(22));
                    if (!cursor.isNull(23)) {
                    }
                    z2 = true;
                    fb.b(z2);
                    if (!cursor.isNull(24)) {
                    }
                    fb.c(z3);
                    fb.c(cursor.getString(25));
                    if (!cursor.isNull(26)) {
                    }
                    fb.f(j22);
                    if (!cursor.isNull(27)) {
                    }
                    fb.e();
                    if (cursor.moveToNext()) {
                    }
                    if (cursor != null) {
                    }
                    return fb;
                } catch (SQLiteException e2) {
                    e = e2;
                    try {
                        e().t().a("Error querying app. appId", C0532kb.a(str), e);
                        if (cursor != null) {
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            } catch (SQLiteException e3) {
                e = e3;
                e().t().a("Error querying app. appId", C0532kb.a(str), e);
                if (cursor != null) {
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            e().t().a("Error querying app. appId", C0532kb.a(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            if (cursor != null) {
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a1  */
    public final List<Td> a(String str) {
        Cursor cursor;
        q.b(str);
        j();
        t();
        ArrayList arrayList = new ArrayList();
        try {
            cursor = x().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                }
                do {
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(1);
                    if (string2 == null) {
                        string2 = "";
                    }
                    String str2 = string2;
                    long j2 = cursor.getLong(2);
                    Object a2 = a(cursor, 3);
                    if (a2 == null) {
                        e().t().a("Read invalid user property value, ignoring it. appId", C0532kb.a(str));
                    } else {
                        Td td = new Td(str, str2, string, j2, a2);
                        arrayList.add(td);
                    }
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    e().t().a("Error querying user properties. appId", C0532kb.a(str), e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            e().t().a("Error querying user properties. appId", C0532kb.a(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f8, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f9, code lost:
        r12 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0100, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0101, code lost:
        r12 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0104, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0105, code lost:
        r12 = r21;
        r11 = r22;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0100 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x000f] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0127  */
    public final List<Td> a(String str, String str2, String str3) {
        Cursor cursor;
        String str4;
        q.b(str);
        j();
        t();
        ArrayList arrayList = new ArrayList();
        Cursor cursor2 = null;
        try {
            ArrayList arrayList2 = new ArrayList(3);
            arrayList2.add(str);
            StringBuilder sb = new StringBuilder("app_id=?");
            if (!TextUtils.isEmpty(str2)) {
                str4 = str2;
                arrayList2.add(str4);
                sb.append(" and origin=?");
            } else {
                str4 = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                arrayList2.add(String.valueOf(str3).concat("*"));
                sb.append(" and name glob ?");
            }
            cursor = x().query("user_attributes", new String[]{"name", "set_timestamp", "value", "origin"}, sb.toString(), (String[]) arrayList2.toArray(new String[arrayList2.size()]), null, null, "rowid", "1001");
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                }
                while (true) {
                    if (arrayList.size() >= 1000) {
                        e().t().a("Read more than the max allowed user properties, ignoring excess", Integer.valueOf(1000));
                        break;
                    }
                    String string = cursor.getString(0);
                    long j2 = cursor.getLong(1);
                    try {
                        Object a2 = a(cursor, 2);
                        String string2 = cursor.getString(3);
                        if (a2 == null) {
                            try {
                                e().t().a("(2)Read invalid user property value, ignoring it", C0532kb.a(str), string2, str3);
                            } catch (SQLiteException e2) {
                                e = e2;
                                str4 = string2;
                                try {
                                    e().t().a("(2)Error querying user properties", C0532kb.a(str), str4, e);
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    return null;
                                } catch (Throwable th) {
                                    th = th;
                                    cursor2 = cursor;
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    throw th;
                                }
                            }
                        } else {
                            String str5 = str3;
                            Td td = new Td(str, string2, string, j2, a2);
                            arrayList.add(td);
                        }
                        if (!cursor.moveToNext()) {
                            break;
                        }
                        str4 = string2;
                    } catch (SQLiteException e3) {
                        e = e3;
                        e().t().a("(2)Error querying user properties", C0532kb.a(str), str4, e);
                        if (cursor != null) {
                        }
                        return null;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (SQLiteException e4) {
                e = e4;
                e().t().a("(2)Error querying user properties", C0532kb.a(str), str4, e);
                if (cursor != null) {
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                cursor2 = cursor;
                if (cursor2 != null) {
                }
                throw th;
            }
        } catch (SQLiteException e5) {
            e = e5;
            str4 = str2;
            cursor = null;
            e().t().a("(2)Error querying user properties", C0532kb.a(str), str4, e);
            if (cursor != null) {
            }
            return null;
        } catch (Throwable th3) {
        }
    }

    public final boolean a(de deVar) {
        q.a(deVar);
        j();
        t();
        if (d(deVar.f5877a, deVar.f5879c.f5706b) == null) {
            if (b("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{deVar.f5877a}) >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", deVar.f5877a);
        contentValues.put("origin", deVar.f5878b);
        contentValues.put("name", deVar.f5879c.f5706b);
        a(contentValues, "value", deVar.f5879c.f());
        contentValues.put("active", Boolean.valueOf(deVar.f5881e));
        contentValues.put("trigger_event_name", deVar.f5882f);
        contentValues.put("trigger_timeout", Long.valueOf(deVar.f5884h));
        m();
        contentValues.put("timed_out_event", Wd.a((Parcelable) deVar.f5883g));
        contentValues.put("creation_timestamp", Long.valueOf(deVar.f5880d));
        m();
        contentValues.put("triggered_event", Wd.a((Parcelable) deVar.f5885i));
        contentValues.put("triggered_timestamp", Long.valueOf(deVar.f5879c.f5707c));
        contentValues.put("time_to_live", Long.valueOf(deVar.f5886j));
        m();
        contentValues.put("expired_event", Wd.a((Parcelable) deVar.f5887k));
        try {
            if (x().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                e().t().a("Failed to insert/update conditional user property (got -1)", C0532kb.a(deVar.f5877a));
            }
        } catch (SQLiteException e2) {
            e().t().a("Error storing conditional user property", C0532kb.a(deVar.f5877a), e2);
        }
        return true;
    }

    public final List<de> a(String str, String[] strArr) {
        j();
        t();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = x().query("conditional_properties", new String[]{"app_id", "origin", "name", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, str, strArr, null, null, "rowid", "1001");
            if (!cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            while (true) {
                if (arrayList.size() < 1000) {
                    boolean z = false;
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(1);
                    String string3 = cursor.getString(2);
                    Object a2 = a(cursor, 3);
                    if (cursor.getInt(4) != 0) {
                        z = true;
                    }
                    String string4 = cursor.getString(5);
                    long j2 = cursor.getLong(6);
                    C0525j jVar = (C0525j) n().a(cursor.getBlob(7), C0525j.CREATOR);
                    long j3 = cursor.getLong(8);
                    C0525j jVar2 = (C0525j) n().a(cursor.getBlob(9), C0525j.CREATOR);
                    long j4 = cursor.getLong(10);
                    long j5 = cursor.getLong(11);
                    C0525j jVar3 = (C0525j) n().a(cursor.getBlob(12), C0525j.CREATOR);
                    Rd rd = new Rd(string3, j4, a2, string2);
                    boolean z2 = z;
                    de deVar = r3;
                    de deVar2 = new de(string, string2, rd, j3, z2, string4, jVar, j2, jVar2, j5, jVar3);
                    arrayList.add(deVar);
                    if (!cursor.moveToNext()) {
                        break;
                    }
                } else {
                    e().t().a("Read more than the max allowed conditional properties, ignoring extra", Integer.valueOf(1000));
                    break;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (SQLiteException e2) {
            e().t().a("Error querying conditional user property value", e2);
            List<de> emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void a(Fb fb) {
        String str = "apps";
        q.a(fb);
        j();
        t();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", fb.f());
        contentValues.put("app_instance_id", fb.a());
        contentValues.put("gmp_app_id", fb.c());
        contentValues.put("resettable_device_id_hash", fb.h());
        contentValues.put("last_bundle_index", Long.valueOf(fb.q()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(fb.i()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(fb.j()));
        contentValues.put("app_version", fb.k());
        contentValues.put("app_store", fb.m());
        contentValues.put("gmp_version", Long.valueOf(fb.n()));
        contentValues.put("dev_cert_hash", Long.valueOf(fb.o()));
        contentValues.put("measurement_enabled", Boolean.valueOf(fb.d()));
        contentValues.put("day", Long.valueOf(fb.u()));
        contentValues.put("daily_public_events_count", Long.valueOf(fb.v()));
        contentValues.put("daily_events_count", Long.valueOf(fb.w()));
        contentValues.put("daily_conversions_count", Long.valueOf(fb.x()));
        contentValues.put("config_fetched_time", Long.valueOf(fb.r()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(fb.s()));
        contentValues.put("app_version_int", Long.valueOf(fb.l()));
        contentValues.put("firebase_instance_id", fb.b());
        contentValues.put("daily_error_events_count", Long.valueOf(fb.z()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(fb.y()));
        contentValues.put("health_monitor_sample", fb.A());
        contentValues.put("android_id", Long.valueOf(fb.C()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(fb.D()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(fb.E()));
        contentValues.put("admob_app_id", fb.g());
        contentValues.put("dynamite_version", Long.valueOf(fb.p()));
        if (fb.G() != null) {
            if (fb.G().size() == 0) {
                e().w().a("Safelisted events should not be an empty list. appId", fb.f());
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", fb.G()));
            }
        }
        try {
            SQLiteDatabase x = x();
            if (((long) x.update(str, contentValues, "app_id = ?", new String[]{fb.f()})) == 0 && x.insertWithOnConflict(str, null, contentValues, 5) == -1) {
                e().t().a("Failed to insert/update app (got -1). appId", C0532kb.a(fb.f()));
            }
        } catch (SQLiteException e2) {
            e().t().a("Error storing app. appId", C0532kb.a(fb.f()), e2);
        }
    }

    public final je a(long j2, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        q.b(str);
        j();
        t();
        String[] strArr = {str};
        je jeVar = new je();
        Cursor cursor = null;
        try {
            SQLiteDatabase x = x();
            SQLiteDatabase sQLiteDatabase = x;
            cursor = sQLiteDatabase.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
            if (!cursor.moveToFirst()) {
                e().w().a("Not updating daily counts, app is not known. appId", C0532kb.a(str));
                if (cursor != null) {
                    cursor.close();
                }
                return jeVar;
            }
            if (cursor.getLong(0) == j2) {
                jeVar.f5972b = cursor.getLong(1);
                jeVar.f5971a = cursor.getLong(2);
                jeVar.f5973c = cursor.getLong(3);
                jeVar.f5974d = cursor.getLong(4);
                jeVar.f5975e = cursor.getLong(5);
            }
            if (z) {
                jeVar.f5972b++;
            }
            if (z2) {
                jeVar.f5971a++;
            }
            if (z3) {
                jeVar.f5973c++;
            }
            if (z4) {
                jeVar.f5974d++;
            }
            if (z5) {
                jeVar.f5975e++;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("day", Long.valueOf(j2));
            contentValues.put("daily_public_events_count", Long.valueOf(jeVar.f5971a));
            contentValues.put("daily_events_count", Long.valueOf(jeVar.f5972b));
            contentValues.put("daily_conversions_count", Long.valueOf(jeVar.f5973c));
            contentValues.put("daily_error_events_count", Long.valueOf(jeVar.f5974d));
            contentValues.put("daily_realtime_events_count", Long.valueOf(jeVar.f5975e));
            x.update("apps", contentValues, "app_id=?", strArr);
            if (cursor != null) {
                cursor.close();
            }
            return jeVar;
        } catch (SQLiteException e2) {
            e().t().a("Error updating daily counts. appId", C0532kb.a(str), e2);
            if (cursor != null) {
                cursor.close();
            }
            return jeVar;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final boolean a(V v, boolean z) {
        j();
        t();
        q.a(v);
        q.b(v.s());
        q.b(v.O());
        B();
        long currentTimeMillis = c().currentTimeMillis();
        if (v.I() < currentTimeMillis - fe.t() || v.I() > fe.t() + currentTimeMillis) {
            e().w().a("Storing bundle outside of the max uploading time span. appId, now, timestamp", C0532kb.a(v.s()), Long.valueOf(currentTimeMillis), Long.valueOf(v.I()));
        }
        try {
            byte[] c2 = n().c(v.g());
            e().B().a("Saving bundle, size", Integer.valueOf(c2.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", v.s());
            contentValues.put("bundle_end_timestamp", Long.valueOf(v.I()));
            contentValues.put("data", c2);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (v.ra()) {
                contentValues.put("retry_count", Integer.valueOf(v.sa()));
            }
            try {
                if (x().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                e().t().a("Failed to insert bundle (got -1). appId", C0532kb.a(v.s()));
                return false;
            } catch (SQLiteException e2) {
                e().t().a("Error storing bundle. appId", C0532kb.a(v.s()), e2);
                return false;
            }
        } catch (IOException e3) {
            e().t().a("Data loss. Failed to serialize bundle. appId", C0532kb.a(v.s()), e3);
            return false;
        }
    }

    public final List<Pair<V, Long>> a(String str, int i2, int i3) {
        j();
        t();
        q.a(i2 > 0);
        q.a(i3 > 0);
        q.b(str);
        Cursor cursor = null;
        try {
            cursor = x().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i2));
            if (!cursor.moveToFirst()) {
                List<Pair<V, Long>> emptyList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyList;
            }
            ArrayList arrayList = new ArrayList();
            int i4 = 0;
            do {
                long j2 = cursor.getLong(0);
                try {
                    byte[] b2 = n().b(cursor.getBlob(1));
                    if (!arrayList.isEmpty() && b2.length + i4 > i3) {
                        break;
                    }
                    try {
                        a va = V.va();
                        va.a(b2, C0428rb.c());
                        a aVar = va;
                        if (!cursor.isNull(2)) {
                            aVar.h(cursor.getInt(2));
                        }
                        i4 += b2.length;
                        arrayList.add(Pair.create((V) ((Eb) aVar.A()), Long.valueOf(j2)));
                    } catch (IOException e2) {
                        e().t().a("Failed to merge queued bundle. appId", C0532kb.a(str), e2);
                    }
                    if (!cursor.moveToNext()) {
                        break;
                    }
                } catch (IOException e3) {
                    e().t().a("Failed to unzip queued bundle. appId", C0532kb.a(str), e3);
                }
            } while (i4 <= i3);
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (SQLiteException e4) {
            e().t().a("Error querying bundles. appId", C0532kb.a(str), e4);
            List<Pair<V, Long>> emptyList2 = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: 0000 */
    public final void a(List<Long> list) {
        j();
        t();
        q.a(list);
        q.a(list.size());
        if (P()) {
            String join = TextUtils.join(",", list);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 80);
            sb3.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb3.append(sb2);
            sb3.append(" AND retry_count =  2147483647 LIMIT 1");
            if (b(sb3.toString(), (String[]) null) > 0) {
                e().w().a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase x = x();
                StringBuilder sb4 = new StringBuilder(String.valueOf(sb2).length() + 127);
                sb4.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb4.append(sb2);
                sb4.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                x.execSQL(sb4.toString());
            } catch (SQLiteException e2) {
                e().t().a("Error incrementing retry count. error", e2);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final void a(String str, C0337ca[] caVarArr) {
        boolean z;
        String str2 = str;
        C0337ca[] caVarArr2 = caVarArr;
        String str3 = "app_id=? and audience_id=?";
        String str4 = "event_filters";
        String str5 = "app_id=?";
        String str6 = "property_filters";
        t();
        j();
        q.b(str);
        q.a(caVarArr);
        SQLiteDatabase x = x();
        x.beginTransaction();
        try {
            t();
            j();
            q.b(str);
            SQLiteDatabase x2 = x();
            x2.delete(str6, str5, new String[]{str2});
            x2.delete(str4, str5, new String[]{str2});
            for (C0337ca caVar : caVarArr2) {
                t();
                j();
                q.b(str);
                q.a(caVar);
                q.a(caVar.f5137f);
                q.a(caVar.f5136e);
                if (caVar.f5135d == null) {
                    e().w().a("Audience with no ID. appId", C0532kb.a(str));
                } else {
                    int intValue = caVar.f5135d.intValue();
                    C[] cArr = caVar.f5137f;
                    int length = cArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            F[] fArr = caVar.f5136e;
                            int length2 = fArr.length;
                            int i3 = 0;
                            while (true) {
                                if (i3 >= length2) {
                                    C[] cArr2 = caVar.f5137f;
                                    int length3 = cArr2.length;
                                    int i4 = 0;
                                    while (true) {
                                        if (i4 >= length3) {
                                            z = true;
                                            break;
                                        } else if (!a(str2, intValue, cArr2[i4])) {
                                            z = false;
                                            break;
                                        } else {
                                            i4++;
                                        }
                                    }
                                    if (z) {
                                        F[] fArr2 = caVar.f5136e;
                                        int length4 = fArr2.length;
                                        int i5 = 0;
                                        while (true) {
                                            if (i5 >= length4) {
                                                break;
                                            } else if (!a(str2, intValue, fArr2[i5])) {
                                                z = false;
                                                break;
                                            } else {
                                                i5++;
                                            }
                                        }
                                    }
                                    if (!z) {
                                        t();
                                        j();
                                        q.b(str);
                                        SQLiteDatabase x3 = x();
                                        x3.delete(str6, str3, new String[]{str2, String.valueOf(intValue)});
                                        x3.delete(str4, str3, new String[]{str2, String.valueOf(intValue)});
                                    }
                                } else if (!fArr[i3].q()) {
                                    e().w().a("Property filter with no ID. Audience definition ignored. appId, audienceId", C0532kb.a(str), caVar.f5135d);
                                    break;
                                } else {
                                    i3++;
                                }
                            }
                        } else if (!cArr[i2].r()) {
                            e().w().a("Event filter with no ID. Audience definition ignored. appId, audienceId", C0532kb.a(str), caVar.f5135d);
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (C0337ca caVar2 : caVarArr2) {
                arrayList.add(caVar2.f5135d);
            }
            a(str2, (List<Integer>) arrayList);
            x.setTransactionSuccessful();
        } finally {
            x.endTransaction();
        }
    }

    private final boolean a(String str, int i2, C c2) {
        t();
        j();
        q.b(str);
        q.a(c2);
        Integer num = null;
        if (TextUtils.isEmpty(c2.p())) {
            C0542mb w = e().w();
            Object a2 = C0532kb.a(str);
            Integer valueOf = Integer.valueOf(i2);
            if (c2.r()) {
                num = Integer.valueOf(c2.o());
            }
            w.a("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", a2, valueOf, String.valueOf(num));
            return false;
        }
        byte[] g2 = c2.g();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i2));
        contentValues.put("filter_id", c2.r() ? Integer.valueOf(c2.o()) : null);
        contentValues.put("event_name", c2.p());
        if (g().e(str, C0535l.Ea)) {
            contentValues.put("session_scoped", c2.x() ? Boolean.valueOf(c2.B()) : null);
        }
        contentValues.put("data", g2);
        try {
            if (x().insertWithOnConflict("event_filters", null, contentValues, 5) == -1) {
                e().t().a("Failed to insert event filter (got -1). appId", C0532kb.a(str));
            }
            return true;
        } catch (SQLiteException e2) {
            e().t().a("Error storing event filter. appId", C0532kb.a(str), e2);
            return false;
        }
    }

    private final boolean a(String str, int i2, F f2) {
        t();
        j();
        q.b(str);
        q.a(f2);
        Integer num = null;
        if (TextUtils.isEmpty(f2.p())) {
            C0542mb w = e().w();
            Object a2 = C0532kb.a(str);
            Integer valueOf = Integer.valueOf(i2);
            if (f2.q()) {
                num = Integer.valueOf(f2.o());
            }
            w.a("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", a2, valueOf, String.valueOf(num));
            return false;
        }
        byte[] g2 = f2.g();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i2));
        contentValues.put("filter_id", f2.q() ? Integer.valueOf(f2.o()) : null);
        contentValues.put("property_name", f2.p());
        if (g().e(str, C0535l.Ea)) {
            contentValues.put("session_scoped", f2.t() ? Boolean.valueOf(f2.u()) : null);
        }
        contentValues.put("data", g2);
        try {
            if (x().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                return true;
            }
            e().t().a("Failed to insert property filter (got -1). appId", C0532kb.a(str));
            return false;
        } catch (SQLiteException e2) {
            e().t().a("Error storing property filter. appId", C0532kb.a(str), e2);
            return false;
        }
    }

    private final boolean a(String str, List<Integer> list) {
        q.b(str);
        t();
        j();
        SQLiteDatabase x = x();
        try {
            long b2 = b("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min(2000, g().b(str, C0535l.Q)));
            if (b2 <= ((long) max)) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                Integer num = (Integer) list.get(i2);
                if (num == null || !(num instanceof Integer)) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String join = TextUtils.join(",", arrayList);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 140);
            sb3.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            sb3.append(sb2);
            sb3.append(" order by rowid desc limit -1 offset ?)");
            return x.delete("audience_filter_values", sb3.toString(), new String[]{str, Integer.toString(max)}) > 0;
        } catch (SQLiteException e2) {
            e().t().a("Database error querying filters. appId", C0532kb.a(str), e2);
            return false;
        }
    }

    private static void a(ContentValues contentValues, String str, Object obj) {
        q.b(str);
        q.a(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    private final Object a(Cursor cursor, int i2) {
        int type = cursor.getType(i2);
        if (type == 0) {
            e().t().a("Loaded invalid null value from database");
            return null;
        } else if (type == 1) {
            return Long.valueOf(cursor.getLong(i2));
        } else {
            if (type == 2) {
                return Double.valueOf(cursor.getDouble(i2));
            }
            if (type == 3) {
                return cursor.getString(i2);
            }
            if (type != 4) {
                e().t().a("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
            }
            e().t().a("Loaded invalid blob type value, ignoring it");
            return null;
        }
    }

    public final long a(V v) throws IOException {
        j();
        t();
        q.a(v);
        q.b(v.s());
        byte[] g2 = v.g();
        long a2 = n().a(g2);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", v.s());
        contentValues.put("metadata_fingerprint", Long.valueOf(a2));
        contentValues.put("metadata", g2);
        try {
            x().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return a2;
        } catch (SQLiteException e2) {
            e().t().a("Error storing raw event metadata. appId", C0532kb.a(v.s()), e2);
            throw e2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005b  */
    public final String a(long j2) {
        Cursor cursor;
        j();
        t();
        try {
            cursor = x().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(j2)});
            try {
                if (!cursor.moveToFirst()) {
                    e().B().a("No expired configs for apps with pending events");
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                String string = cursor.getString(0);
                if (cursor != null) {
                    cursor.close();
                }
                return string;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    e().t().a("Error selecting expired configs", e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            e().t().a("Error selecting expired configs", e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008a  */
    public final Pair<Q, Long> a(String str, Long l2) {
        Cursor cursor;
        j();
        t();
        try {
            cursor = x().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, String.valueOf(l2)});
            try {
                if (!cursor.moveToFirst()) {
                    e().B().a("Main event not found");
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                byte[] blob = cursor.getBlob(0);
                try {
                    Pair<Q, Long> create = Pair.create(Q.a(blob, C0428rb.c()), Long.valueOf(cursor.getLong(1)));
                    if (cursor != null) {
                        cursor.close();
                    }
                    return create;
                } catch (IOException e2) {
                    e().t().a("Failed to merge main event. appId, eventId", C0532kb.a(str), l2, e2);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (SQLiteException e3) {
                e = e3;
                try {
                    e().t().a("Error selecting main event", e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            e().t().a("Error selecting main event", e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final boolean a(String str, Long l2, long j2, Q q) {
        j();
        t();
        q.a(q);
        q.b(str);
        q.a(l2);
        byte[] g2 = q.g();
        e().B().a("Saving complex main event, appId, data size", l().a(str), Integer.valueOf(g2.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l2);
        contentValues.put("children_to_process", Long.valueOf(j2));
        contentValues.put("main_event", g2);
        try {
            if (x().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            e().t().a("Failed to insert complex main event (got -1). appId", C0532kb.a(str));
            return false;
        } catch (SQLiteException e2) {
            e().t().a("Error storing complex main event. appId", C0532kb.a(str), e2);
            return false;
        }
    }

    public final boolean a(C0510g gVar, long j2, boolean z) {
        j();
        t();
        q.a(gVar);
        q.b(gVar.f5920a);
        Q.a x = Q.x();
        x.b(gVar.f5924e);
        Iterator it = gVar.f5925f.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            T.a v = T.v();
            v.a(str);
            n().a(v, gVar.f5925f.a(str));
            x.a(v);
        }
        byte[] g2 = ((Q) x.A()).g();
        e().B().a("Saving event, name, data size", l().a(gVar.f5921b), Integer.valueOf(g2.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", gVar.f5920a);
        contentValues.put("name", gVar.f5921b);
        contentValues.put("timestamp", Long.valueOf(gVar.f5923d));
        contentValues.put("metadata_fingerprint", Long.valueOf(j2));
        contentValues.put("data", g2);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            if (x().insert("raw_events", null, contentValues) != -1) {
                return true;
            }
            e().t().a("Failed to insert raw event (got -1). appId", C0532kb.a(gVar.f5920a));
            return false;
        } catch (SQLiteException e2) {
            e().t().a("Error storing raw event. appId", C0532kb.a(gVar.f5920a), e2);
            return false;
        }
    }
}
