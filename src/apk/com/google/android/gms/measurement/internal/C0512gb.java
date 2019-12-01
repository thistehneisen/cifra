package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.util.d;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.measurement.internal.gb reason: case insensitive filesystem */
public final class C0512gb extends C0503ec {

    /* renamed from: c reason: collision with root package name */
    private final C0507fb f5927c = new C0507fb(this, a(), "google_app_measurement_local.db");

    /* renamed from: d reason: collision with root package name */
    private boolean f5928d;

    C0512gb(Ob ob) {
        super(ob);
    }

    private final SQLiteDatabase E() throws SQLiteException {
        if (this.f5928d) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.f5927c.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.f5928d = true;
        return null;
    }

    private final boolean F() {
        return a().getDatabasePath("google_app_measurement_local.db").exists();
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r13v0, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r10v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: type inference failed for: r10v1 */
    /* JADX WARNING: type inference failed for: r8v1 */
    /* JADX WARNING: type inference failed for: r13v1 */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r10v2, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: type inference failed for: r8v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r10v3 */
    /* JADX WARNING: type inference failed for: r10v4, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: type inference failed for: r8v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r10v5 */
    /* JADX WARNING: type inference failed for: r13v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r8v4, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: type inference failed for: r10v6 */
    /* JADX WARNING: type inference failed for: r13v3 */
    /* JADX WARNING: type inference failed for: r10v7 */
    /* JADX WARNING: type inference failed for: r13v4 */
    /* JADX WARNING: type inference failed for: r10v8, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: type inference failed for: r8v5 */
    /* JADX WARNING: type inference failed for: r13v5 */
    /* JADX WARNING: type inference failed for: r8v6 */
    /* JADX WARNING: type inference failed for: r13v6 */
    /* JADX WARNING: type inference failed for: r13v7 */
    /* JADX WARNING: type inference failed for: r13v8, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r8v7 */
    /* JADX WARNING: type inference failed for: r8v11 */
    /* JADX WARNING: type inference failed for: r13v9 */
    /* JADX WARNING: type inference failed for: r3v20 */
    /* JADX WARNING: type inference failed for: r8v12 */
    /* JADX WARNING: type inference failed for: r8v13 */
    /* JADX WARNING: type inference failed for: r8v14 */
    /* JADX WARNING: type inference failed for: r8v15 */
    /* JADX WARNING: type inference failed for: r8v16 */
    /* JADX WARNING: type inference failed for: r10v9 */
    /* JADX WARNING: type inference failed for: r3v21 */
    /* JADX WARNING: type inference failed for: r10v10 */
    /* JADX WARNING: type inference failed for: r10v11 */
    /* JADX WARNING: type inference failed for: r8v17 */
    /* JADX WARNING: type inference failed for: r8v18 */
    /* JADX WARNING: type inference failed for: r10v12 */
    /* JADX WARNING: type inference failed for: r10v13 */
    /* JADX WARNING: type inference failed for: r8v19 */
    /* JADX WARNING: type inference failed for: r8v20 */
    /* JADX WARNING: type inference failed for: r13v10 */
    /* JADX WARNING: type inference failed for: r10v14 */
    /* JADX WARNING: type inference failed for: r10v15 */
    /* JADX WARNING: type inference failed for: r10v16 */
    /* JADX WARNING: type inference failed for: r10v17 */
    /* JADX WARNING: type inference failed for: r10v18 */
    /* JADX WARNING: type inference failed for: r10v19 */
    /* JADX WARNING: type inference failed for: r10v20 */
    /* JADX WARNING: type inference failed for: r13v11 */
    /* JADX WARNING: type inference failed for: r13v12 */
    /* JADX WARNING: type inference failed for: r13v13 */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003b, code lost:
        r13 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003e, code lost:
        r0 = e;
        r8 = r8;
        r10 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00cc, code lost:
        r8 = 0;
        r10 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00e1, code lost:
        if (r8.inTransaction() != false) goto L_0x00e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00e3, code lost:
        r8.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00f6, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00fb, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00ff, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0100, code lost:
        r10 = r8;
        r13 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x010c, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0111, code lost:
        r10.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v1, types: [boolean, int]
      assigns: []
      uses: [?[int, short, byte, char], int, boolean]
      mth insns count: 164
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0130 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0130 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0130 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[ExcHandler: SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException), SYNTHETIC, Splitter:B:9:0x0032] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00dd A[SYNTHETIC, Splitter:B:57:0x00dd] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x013f  */
    /* JADX WARNING: Unknown variable types count: 19 */
    private final boolean a(int i2, byte[] bArr) {
        ? r13;
        ? r10;
        ? r102;
        ? r8;
        ? r103;
        ? r82;
        ? r104;
        ? r83;
        ? r132;
        ? r84;
        ? r85;
        ? r133;
        ? r86;
        String str = "Error writing entry to local database";
        h();
        j();
        ? r3 = 0;
        if (this.f5928d) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", Integer.valueOf(i2));
        contentValues.put("entry", bArr);
        int i3 = 5;
        int i4 = 0;
        int i5 = 5;
        ? r32 = r3;
        while (i4 < i3) {
            ? r87 = 0;
            try {
                ? E = E();
                if (E == 0) {
                    try {
                        this.f5928d = true;
                        if (E != 0) {
                            E.close();
                        }
                        return r32;
                    } catch (SQLiteFullException e2) {
                        e = e2;
                        r86 = r87;
                        r103 = E;
                    } catch (SQLiteDatabaseLockedException unused) {
                    } catch (SQLiteException e3) {
                        e = e3;
                        r133 = 0;
                        r84 = E;
                        r132 = r133;
                        if (r84 != 0) {
                        }
                        e().t().a(str, e);
                        this.f5928d = true;
                        if (r132 != 0) {
                        }
                        if (r84 == 0) {
                        }
                        i4++;
                        i3 = 5;
                        r32 = 0;
                    } catch (Throwable th) {
                        th = th;
                        r13 = 0;
                        r10 = E;
                        if (r13 != 0) {
                        }
                        if (r10 != 0) {
                        }
                        throw th;
                    }
                } else {
                    E.beginTransaction();
                    long j2 = 0;
                    ? rawQuery = E.rawQuery("select count(1) from messages", null);
                    if (rawQuery != 0) {
                        try {
                            if (rawQuery.moveToFirst()) {
                                j2 = rawQuery.getLong(r32);
                            }
                        } catch (SQLiteFullException e4) {
                            e = e4;
                            r86 = rawQuery;
                            r103 = E;
                            r102 = r103;
                            r8 = r82;
                            e().t().a(str, e);
                            this.f5928d = true;
                            r102 = r103;
                            r8 = r82;
                            if (r82 != 0) {
                                r82.close();
                            }
                            if (r103 == 0) {
                                r103.close();
                            }
                            i4++;
                            i3 = 5;
                            r32 = 0;
                        } catch (SQLiteDatabaseLockedException unused2) {
                            r85 = rawQuery;
                            r104 = E;
                            try {
                                r102 = r104;
                                r8 = r83;
                                SystemClock.sleep((long) i5);
                                r102 = r104;
                                r8 = r83;
                                i5 += 20;
                                if (r83 != 0) {
                                }
                                if (r104 != 0) {
                                }
                                i4++;
                                i3 = 5;
                                r32 = 0;
                            } catch (Throwable th2) {
                                th = th2;
                                r13 = r8;
                                r10 = r102;
                                if (r13 != 0) {
                                }
                                if (r10 != 0) {
                                }
                                throw th;
                            }
                        } catch (SQLiteException e5) {
                            e = e5;
                            r133 = rawQuery;
                            r84 = E;
                            r132 = r133;
                            if (r84 != 0) {
                            }
                            e().t().a(str, e);
                            this.f5928d = true;
                            if (r132 != 0) {
                            }
                            if (r84 == 0) {
                            }
                            i4++;
                            i3 = 5;
                            r32 = 0;
                        } catch (Throwable th3) {
                            th = th3;
                            r10 = E;
                            r13 = rawQuery;
                            if (r13 != 0) {
                                r13.close();
                            }
                            if (r10 != 0) {
                                r10.close();
                            }
                            throw th;
                        }
                    }
                    String str2 = "messages";
                    if (j2 >= 100000) {
                        e().t().a("Data loss, local db full");
                        long j3 = (100000 - j2) + 1;
                        String[] strArr = new String[1];
                        strArr[r32] = Long.toString(j3);
                        long delete = (long) E.delete(str2, "rowid in (select rowid from messages order by rowid asc limit ?)", strArr);
                        if (delete != j3) {
                            e().t().a("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j3), Long.valueOf(delete), Long.valueOf(j3 - delete));
                        }
                    }
                    E.insertOrThrow(str2, null, contentValues);
                    E.setTransactionSuccessful();
                    E.endTransaction();
                    if (rawQuery != 0) {
                        rawQuery.close();
                    }
                    if (E != 0) {
                        E.close();
                    }
                    return true;
                }
            } catch (SQLiteFullException e6) {
                e = e6;
                r103 = 0;
                r86 = r87;
                r102 = r103;
                r8 = r82;
                e().t().a(str, e);
                this.f5928d = true;
                r102 = r103;
                r8 = r82;
                if (r82 != 0) {
                }
                if (r103 == 0) {
                }
                i4++;
                i3 = 5;
                r32 = 0;
            } catch (SQLiteDatabaseLockedException unused3) {
                r104 = 0;
                r85 = r87;
                r102 = r104;
                r8 = r83;
                SystemClock.sleep((long) i5);
                r102 = r104;
                r8 = r83;
                i5 += 20;
                if (r83 != 0) {
                }
                if (r104 != 0) {
                }
                i4++;
                i3 = 5;
                r32 = 0;
            } catch (SQLiteException e7) {
                e = e7;
                r132 = 0;
                r84 = r87;
                if (r84 != 0) {
                }
                e().t().a(str, e);
                this.f5928d = true;
                if (r132 != 0) {
                }
                if (r84 == 0) {
                }
                i4++;
                i3 = 5;
                r32 = 0;
            } catch (Throwable th4) {
                th = th4;
                r10 = 0;
                r13 = 0;
                if (r13 != 0) {
                }
                if (r10 != 0) {
                }
                throw th;
            }
        }
        e().w().a("Failed to write entry to local database");
        return false;
    }

    public final void B() {
        h();
        j();
        try {
            int delete = E().delete("messages", null, null) + 0;
            if (delete > 0) {
                e().B().a("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e2) {
            e().t().a("Error resetting local analytics data. error", e2);
        }
    }

    public final boolean C() {
        return a(3, new byte[0]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0089, code lost:
        r3 = r3 + 1;
     */
    public final boolean D() {
        String str = "Error deleting app launch break from local database";
        j();
        h();
        if (this.f5928d || !F()) {
            return false;
        }
        int i2 = 0;
        int i3 = 5;
        while (i2 < 5) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = E();
                if (sQLiteDatabase == null) {
                    this.f5928d = true;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    return false;
                }
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                return true;
            } catch (SQLiteFullException e2) {
                e().t().a(str, e2);
                this.f5928d = true;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            } catch (SQLiteDatabaseLockedException unused) {
                SystemClock.sleep((long) i3);
                i3 += 20;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            } catch (SQLiteException e3) {
                if (sQLiteDatabase != null) {
                    if (sQLiteDatabase.inTransaction()) {
                        sQLiteDatabase.endTransaction();
                    }
                }
                e().t().a(str, e3);
                this.f5928d = true;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                throw th;
            }
        }
        e().w().a("Error deleting app launch break from local database in reasonable time");
        return false;
    }

    public final /* bridge */ /* synthetic */ ee b() {
        return super.b();
    }

    public final /* bridge */ /* synthetic */ d c() {
        return super.c();
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

    public final /* bridge */ /* synthetic */ void h() {
        super.h();
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

    /* access modifiers changed from: protected */
    public final boolean z() {
        return false;
    }

    public final boolean a(C0525j jVar) {
        Parcel obtain = Parcel.obtain();
        jVar.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return a(0, marshall);
        }
        e().w().a("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean a(Rd rd) {
        Parcel obtain = Parcel.obtain();
        rd.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return a(1, marshall);
        }
        e().w().a("User property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean a(de deVar) {
        m();
        byte[] a2 = Wd.a((Parcelable) deVar);
        if (a2.length <= 131072) {
            return a(2, a2);
        }
        e().w().a("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    /* JADX WARNING: type inference failed for: r24v0, types: [int] */
    /* JADX WARNING: type inference failed for: r24v1 */
    /* JADX WARNING: type inference failed for: r13v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: type inference failed for: r13v1 */
    /* JADX WARNING: type inference failed for: r24v2 */
    /* JADX WARNING: type inference failed for: r24v3 */
    /* JADX WARNING: type inference failed for: r13v2, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: type inference failed for: r13v3 */
    /* JADX WARNING: type inference failed for: r24v4 */
    /* JADX WARNING: type inference failed for: r13v4, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: type inference failed for: r13v5 */
    /* JADX WARNING: type inference failed for: r24v5 */
    /* JADX WARNING: type inference failed for: r13v6, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: type inference failed for: r13v7 */
    /* JADX WARNING: type inference failed for: r13v8 */
    /* JADX WARNING: type inference failed for: r15v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: type inference failed for: r24v6 */
    /* JADX WARNING: type inference failed for: r13v9 */
    /* JADX WARNING: type inference failed for: r13v10 */
    /* JADX WARNING: type inference failed for: r24v7 */
    /* JADX WARNING: type inference failed for: r13v11 */
    /* JADX WARNING: type inference failed for: r13v12 */
    /* JADX WARNING: type inference failed for: r24v8 */
    /* JADX WARNING: type inference failed for: r13v13 */
    /* JADX WARNING: type inference failed for: r13v14 */
    /* JADX WARNING: type inference failed for: r13v15 */
    /* JADX WARNING: type inference failed for: r13v16 */
    /* JADX WARNING: type inference failed for: r24v9 */
    /* JADX WARNING: type inference failed for: r13v18 */
    /* JADX WARNING: type inference failed for: r13v19 */
    /* JADX WARNING: type inference failed for: r13v20 */
    /* JADX WARNING: type inference failed for: r13v21 */
    /* JADX WARNING: type inference failed for: r13v23, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: type inference failed for: r24v10 */
    /* JADX WARNING: type inference failed for: r10v16, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: type inference failed for: r24v11 */
    /* JADX WARNING: type inference failed for: r13v26 */
    /* JADX WARNING: type inference failed for: r24v12 */
    /* JADX WARNING: type inference failed for: r24v13 */
    /* JADX WARNING: type inference failed for: r13v27 */
    /* JADX WARNING: type inference failed for: r24v14 */
    /* JADX WARNING: type inference failed for: r13v28 */
    /* JADX WARNING: type inference failed for: r24v15 */
    /* JADX WARNING: type inference failed for: r24v16 */
    /* JADX WARNING: type inference failed for: r13v29 */
    /* JADX WARNING: type inference failed for: r24v17 */
    /* JADX WARNING: type inference failed for: r24v18 */
    /* JADX WARNING: type inference failed for: r24v19 */
    /* JADX WARNING: type inference failed for: r24v20 */
    /* JADX WARNING: type inference failed for: r10v17, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: type inference failed for: r24v21 */
    /* JADX WARNING: type inference failed for: r13v31 */
    /* JADX WARNING: type inference failed for: r13v32 */
    /* JADX WARNING: type inference failed for: r13v33 */
    /* JADX WARNING: type inference failed for: r24v22 */
    /* JADX WARNING: type inference failed for: r24v23 */
    /* JADX WARNING: type inference failed for: r24v24 */
    /* JADX WARNING: type inference failed for: r24v25 */
    /* JADX WARNING: type inference failed for: r24v26 */
    /* JADX WARNING: type inference failed for: r24v27 */
    /* JADX WARNING: type inference failed for: r24v28 */
    /* JADX WARNING: type inference failed for: r24v29 */
    /* JADX WARNING: type inference failed for: r24v30 */
    /* JADX WARNING: type inference failed for: r24v31 */
    /* JADX WARNING: type inference failed for: r24v32 */
    /* JADX WARNING: type inference failed for: r24v33 */
    /* JADX WARNING: type inference failed for: r24v34 */
    /* JADX WARNING: type inference failed for: r13v34 */
    /* JADX WARNING: type inference failed for: r24v35 */
    /* JADX WARNING: type inference failed for: r24v36 */
    /* JADX WARNING: type inference failed for: r24v37 */
    /* JADX WARNING: type inference failed for: r13v35 */
    /* JADX WARNING: type inference failed for: r13v36 */
    /* JADX WARNING: type inference failed for: r24v38 */
    /* JADX WARNING: type inference failed for: r24v39 */
    /* JADX WARNING: type inference failed for: r13v37 */
    /* JADX WARNING: type inference failed for: r13v38 */
    /* JADX WARNING: type inference failed for: r24v40 */
    /* JADX WARNING: type inference failed for: r24v41 */
    /* JADX WARNING: type inference failed for: r13v39 */
    /* JADX WARNING: type inference failed for: r24v42 */
    /* JADX WARNING: type inference failed for: r13v40 */
    /* JADX WARNING: type inference failed for: r24v43 */
    /* JADX WARNING: type inference failed for: r13v41 */
    /* JADX WARNING: type inference failed for: r24v44 */
    /* JADX WARNING: type inference failed for: r13v42 */
    /* JADX WARNING: type inference failed for: r13v43 */
    /* JADX WARNING: type inference failed for: r24v45 */
    /* JADX WARNING: type inference failed for: r24v46 */
    /* JADX WARNING: type inference failed for: r24v47 */
    /* JADX WARNING: type inference failed for: r24v48 */
    /* JADX WARNING: type inference failed for: r24v49 */
    /* JADX WARNING: type inference failed for: r24v50 */
    /* JADX WARNING: type inference failed for: r13v44 */
    /* JADX WARNING: type inference failed for: r13v45 */
    /* JADX WARNING: type inference failed for: r13v46 */
    /* JADX WARNING: type inference failed for: r24v51 */
    /* JADX WARNING: type inference failed for: r24v52 */
    /* JADX WARNING: type inference failed for: r24v53 */
    /* JADX WARNING: type inference failed for: r24v54 */
    /* JADX WARNING: type inference failed for: r24v55 */
    /* JADX WARNING: type inference failed for: r24v56 */
    /* JADX WARNING: type inference failed for: r24v57 */
    /* JADX WARNING: type inference failed for: r24v58 */
    /* JADX WARNING: type inference failed for: r24v59 */
    /* JADX WARNING: type inference failed for: r24v60 */
    /* JADX WARNING: type inference failed for: r24v61 */
    /* JADX WARNING: type inference failed for: r24v62 */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:77|78|79|80) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:92|93|94|95) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:62|63|64|65|200) */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x01eb, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x01ec, code lost:
        r13 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x01f0, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x01f1, code lost:
        r13 = r15;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x01f4, code lost:
        r13 = r15;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x01f7, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x01f8, code lost:
        r13 = r15;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0091, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0092, code lost:
        r24 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0096, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0097, code lost:
        r24 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x009b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x009c, code lost:
        r24 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        e().t().a("Failed to load event from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        r11.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:?, code lost:
        e().t().a(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
        r11.recycle();
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:?, code lost:
        e().t().a(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:?, code lost:
        r11.recycle();
        r0 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=null, for r24v0, types: [int] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:62:0x00ee */
    /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x0120 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:92:0x0154 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r24v1
      assigns: []
      uses: []
      mth insns count: 313
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:141:? A[ExcHandler: SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException), SYNTHETIC, Splitter:B:12:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0204 A[SYNTHETIC, Splitter:B:151:0x0204] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0221  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x022f  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0234  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x024a  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x024f  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0259  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x0252 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0252 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x0252 A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 35 */
    public final List<a> a(int r24) {
        ? r13;
        Cursor cursor;
        ? r132;
        ? r133;
        ? r134;
        ? r135;
        ? r136;
        ? r137;
        ? r138;
        ? r139;
        Cursor cursor2;
        Parcel obtain;
        Parcel obtain2;
        Parcel obtain3;
        String[] strArr;
        String str;
        String str2 = "Error reading entries from local database";
        j();
        h();
        if (this.f5928d) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!F()) {
            return arrayList;
        }
        int i2 = 0;
        int i3 = 5;
        r24 = r24;
        while (i2 < 5) {
            try {
                ? E = E();
                if (E == 0) {
                    try {
                        this.f5928d = true;
                        if (E != 0) {
                            E.close();
                        }
                        return null;
                    } catch (SQLiteFullException e2) {
                        e = e2;
                        cursor = null;
                        r133 = E;
                        r24 = r24;
                    } catch (SQLiteDatabaseLockedException unused) {
                    } catch (SQLiteException e3) {
                        e = e3;
                        cursor = null;
                        r135 = E;
                        r24 = r24;
                        if (r135 != 0) {
                        }
                        e().t().a(str2, e);
                        this.f5928d = true;
                        if (cursor != null) {
                        }
                        if (r135 != 0) {
                        }
                        i2++;
                        r24 = r24;
                    } catch (Throwable th) {
                        th = th;
                        cursor = null;
                        r13 = E;
                        if (cursor != null) {
                        }
                        if (r13 != 0) {
                        }
                        throw th;
                    }
                } else {
                    E.beginTransaction();
                    String str3 = "entry";
                    String str4 = "type";
                    String str5 = "rowid";
                    long j2 = -1;
                    if (g().a(C0535l.Ja)) {
                        r24 = r24;
                        r24 = r24;
                        r24 = r24;
                        r24 = r24;
                        long a2 = a((SQLiteDatabase) E);
                        if (a2 != -1) {
                            str = "rowid<?";
                            strArr = new String[]{String.valueOf(a2)};
                        } else {
                            str = null;
                            strArr = null;
                        }
                        r24 = E;
                        try {
                            r24 = r24;
                            r24 = r24;
                            r24 = r24;
                            r24 = r24;
                            cursor2 = E.query("messages", new String[]{str5, str4, str3}, str, strArr, null, null, "rowid asc", Integer.toString(100));
                            r24 = r24;
                        } catch (SQLiteFullException e4) {
                            e = e4;
                            r24 = r24;
                            ? r1310 = r24;
                            r24 = r24;
                            cursor = null;
                            r24 = r24;
                            r133 = r137;
                            r132 = r133;
                            e().t().a(str2, e);
                            this.f5928d = true;
                            r132 = r133;
                            if (cursor != null) {
                            }
                            if (r133 != 0) {
                            }
                            i2++;
                            r24 = r24;
                        } catch (SQLiteDatabaseLockedException unused2) {
                            ? r1311 = r24;
                            r24 = r24;
                            cursor = null;
                            r24 = r24;
                            r134 = r136;
                            r132 = r134;
                            SystemClock.sleep((long) i3);
                            r132 = r134;
                            i3 += 20;
                            if (cursor != null) {
                            }
                            if (r134 != 0) {
                            }
                            i2++;
                            r24 = r24;
                        } catch (SQLiteException e5) {
                            e = e5;
                            r24 = r24;
                            r136 = r24;
                            r24 = r24;
                            cursor = null;
                            r24 = r24;
                            r135 = r138;
                            if (r135 != 0) {
                            }
                            e().t().a(str2, e);
                            this.f5928d = true;
                            if (cursor != null) {
                            }
                            if (r135 != 0) {
                            }
                            i2++;
                            r24 = r24;
                        } catch (Throwable th2) {
                            th = th2;
                            r24 = r24;
                            ? r1312 = r24;
                            cursor = null;
                            r13 = r139;
                            if (cursor != null) {
                            }
                            if (r13 != 0) {
                            }
                            throw th;
                        }
                    } else {
                        r24 = E;
                        cursor2 = r24.query("messages", new String[]{str5, str4, str3}, null, null, null, null, "rowid asc", Integer.toString(100));
                        r24 = r24;
                    }
                    cursor = cursor2;
                    while (cursor.moveToNext()) {
                        try {
                            j2 = cursor.getLong(0);
                            int i4 = cursor.getInt(1);
                            byte[] blob = cursor.getBlob(2);
                            if (i4 == 0) {
                                obtain3 = Parcel.obtain();
                                obtain3.unmarshall(blob, 0, blob.length);
                                obtain3.setDataPosition(0);
                                C0525j jVar = (C0525j) C0525j.CREATOR.createFromParcel(obtain3);
                                obtain3.recycle();
                                if (jVar != null) {
                                    arrayList.add(jVar);
                                }
                            } else {
                                String str6 = "Failed to load user property from local database";
                                if (i4 == 1) {
                                    obtain2 = Parcel.obtain();
                                    obtain2.unmarshall(blob, 0, blob.length);
                                    obtain2.setDataPosition(0);
                                    Object obj = (Rd) Rd.CREATOR.createFromParcel(obtain2);
                                    obtain2.recycle();
                                    if (obj != null) {
                                        arrayList.add(obj);
                                    }
                                } else if (i4 == 2) {
                                    obtain = Parcel.obtain();
                                    obtain.unmarshall(blob, 0, blob.length);
                                    obtain.setDataPosition(0);
                                    Object obj2 = (de) de.CREATOR.createFromParcel(obtain);
                                    obtain.recycle();
                                    if (obj2 != null) {
                                        arrayList.add(obj2);
                                    }
                                } else if (i4 == 3) {
                                    e().w().a("Skipping app launch break");
                                } else {
                                    e().t().a("Unknown record type in local database");
                                }
                            }
                        } catch (SQLiteFullException e6) {
                            e = e6;
                            r133 = r24;
                            r24 = r24;
                        } catch (SQLiteDatabaseLockedException unused3) {
                            r134 = r24;
                            r24 = r24;
                            r132 = r134;
                            SystemClock.sleep((long) i3);
                            r132 = r134;
                            i3 += 20;
                            if (cursor != null) {
                            }
                            if (r134 != 0) {
                            }
                            i2++;
                            r24 = r24;
                        } catch (SQLiteException e7) {
                            e = e7;
                            r135 = r24;
                            r24 = r24;
                            if (r135 != 0) {
                            }
                            e().t().a(str2, e);
                            this.f5928d = true;
                            if (cursor != null) {
                            }
                            if (r135 != 0) {
                            }
                            i2++;
                            r24 = r24;
                        } catch (Throwable th3) {
                            th = th3;
                            r13 = r24;
                            if (cursor != null) {
                            }
                            if (r13 != 0) {
                            }
                            throw th;
                        }
                    }
                    ? r1313 = r24;
                    try {
                        if (r1313.delete("messages", "rowid <= ?", new String[]{Long.toString(j2)}) < arrayList.size()) {
                            e().t().a("Fewer entries removed from local database than expected");
                        }
                        r1313.setTransactionSuccessful();
                        r1313.endTransaction();
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (r1313 != 0) {
                            r1313.close();
                        }
                        return arrayList;
                    } catch (SQLiteFullException e8) {
                        e = e8;
                        r24 = r24;
                        r133 = r1313;
                        r132 = r133;
                        e().t().a(str2, e);
                        this.f5928d = true;
                        r132 = r133;
                        if (cursor != null) {
                        }
                        if (r133 != 0) {
                        }
                        i2++;
                        r24 = r24;
                    } catch (SQLiteDatabaseLockedException unused4) {
                        r24 = r24;
                        r134 = r1313;
                        r132 = r134;
                        SystemClock.sleep((long) i3);
                        r132 = r134;
                        i3 += 20;
                        if (cursor != null) {
                        }
                        if (r134 != 0) {
                        }
                        i2++;
                        r24 = r24;
                    } catch (SQLiteException e9) {
                        e = e9;
                        r24 = r24;
                        r135 = r1313;
                        if (r135 != 0) {
                        }
                        e().t().a(str2, e);
                        this.f5928d = true;
                        if (cursor != null) {
                        }
                        if (r135 != 0) {
                        }
                        i2++;
                        r24 = r24;
                    }
                }
            } catch (SQLiteFullException e10) {
                e = e10;
                cursor = null;
                r133 = 0;
                r24 = r24;
                r132 = r133;
                e().t().a(str2, e);
                this.f5928d = true;
                r132 = r133;
                if (cursor != null) {
                    cursor.close();
                }
                if (r133 != 0) {
                    r133.close();
                    r24 = r24;
                } else {
                    r24 = r24;
                }
                i2++;
                r24 = r24;
            } catch (SQLiteDatabaseLockedException unused5) {
                cursor = null;
                r134 = 0;
                r24 = r24;
                r132 = r134;
                SystemClock.sleep((long) i3);
                r132 = r134;
                i3 += 20;
                if (cursor != null) {
                    cursor.close();
                }
                if (r134 != 0) {
                    r134.close();
                    r24 = r24;
                } else {
                    r24 = r24;
                }
                i2++;
                r24 = r24;
            } catch (SQLiteException e11) {
                e = e11;
                cursor = null;
                r135 = 0;
                r24 = r24;
                if (r135 != 0) {
                    try {
                        r132 = r135;
                        if (r135.inTransaction()) {
                            r135.endTransaction();
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        r13 = r132;
                        if (cursor != null) {
                        }
                        if (r13 != 0) {
                        }
                        throw th;
                    }
                }
                e().t().a(str2, e);
                this.f5928d = true;
                if (cursor != null) {
                    cursor.close();
                }
                if (r135 != 0) {
                    r135.close();
                    r24 = r24;
                } else {
                    r24 = r24;
                }
                i2++;
                r24 = r24;
            } catch (Throwable th5) {
                th = th5;
                cursor = null;
                r13 = 0;
                if (cursor != null) {
                    cursor.close();
                }
                if (r13 != 0) {
                    r13.close();
                }
                throw th;
            }
        }
        e().w().a("Failed to read events from database in reasonable time");
        return null;
    }

    /* JADX INFO: finally extract failed */
    private static long a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            Cursor query = sQLiteDatabase.query("messages", new String[]{"rowid"}, "type=?", new String[]{"3"}, null, null, "rowid desc", "1");
            if (query.moveToFirst()) {
                long j2 = query.getLong(0);
                if (query != null) {
                    query.close();
                }
                return j2;
            }
            if (query != null) {
                query.close();
            }
            return -1;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final /* bridge */ /* synthetic */ Context a() {
        return super.a();
    }
}
