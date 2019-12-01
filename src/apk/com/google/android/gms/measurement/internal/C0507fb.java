package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;

/* renamed from: com.google.android.gms.measurement.internal.fb reason: case insensitive filesystem */
final class C0507fb extends SQLiteOpenHelper {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ C0512gb f5910a;

    C0507fb(C0512gb gbVar, Context context, String str) {
        this.f5910a = gbVar;
        super(context, str, null, 1);
    }

    public final SQLiteDatabase getWritableDatabase() throws SQLiteException {
        try {
            return super.getWritableDatabase();
        } catch (SQLiteDatabaseLockedException e2) {
            throw e2;
        } catch (SQLiteException unused) {
            this.f5910a.e().t().a("Opening the local database failed, dropping and recreating it");
            String str = "google_app_measurement_local.db";
            if (!this.f5910a.a().getDatabasePath(str).delete()) {
                this.f5910a.e().t().a("Failed to delete corrupted local db file", str);
            }
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e3) {
                this.f5910a.e().t().a("Failed to open local database. Events will bypass local storage", e3);
                return null;
            }
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        C0490c.a(this.f5910a.e(), sQLiteDatabase);
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        ? r0;
        if (VERSION.SDK_INT < 15) {
            String[] strArr = 0;
            try {
                r0 = strArr;
                Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", strArr);
                rawQuery.moveToFirst();
                r0 = rawQuery;
            } finally {
                if (r0 != 0) {
                    r0.close();
                }
            }
        }
        C0490c.a(this.f5910a.e(), sQLiteDatabase, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", null);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
