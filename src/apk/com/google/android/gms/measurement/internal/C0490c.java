package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.measurement.internal.c reason: case insensitive filesystem */
public final class C0490c {
    private static Set<String> a(SQLiteDatabase sQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22);
        sb.append("SELECT * FROM ");
        sb.append(str);
        sb.append(" LIMIT 0");
        Cursor rawQuery = sQLiteDatabase.rawQuery(sb.toString(), null);
        try {
            Collections.addAll(hashSet, rawQuery.getColumnNames());
            return hashSet;
        } finally {
            rawQuery.close();
        }
    }

    static void a(C0532kb kbVar, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) throws SQLiteException {
        String str4 = "Monitor must not be null";
        if (kbVar != null) {
            if (!a(kbVar, sQLiteDatabase, str)) {
                sQLiteDatabase.execSQL(str2);
            }
            if (kbVar != null) {
                try {
                    Set a2 = a(sQLiteDatabase, str);
                    String[] split = str3.split(",");
                    int length = split.length;
                    int i2 = 0;
                    while (i2 < length) {
                        String str5 = split[i2];
                        if (a2.remove(str5)) {
                            i2++;
                        } else {
                            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 35 + String.valueOf(str5).length());
                            sb.append("Table ");
                            sb.append(str);
                            sb.append(" is missing required column: ");
                            sb.append(str5);
                            throw new SQLiteException(sb.toString());
                        }
                    }
                    if (strArr != null) {
                        for (int i3 = 0; i3 < strArr.length; i3 += 2) {
                            if (!a2.remove(strArr[i3])) {
                                sQLiteDatabase.execSQL(strArr[i3 + 1]);
                            }
                        }
                    }
                    if (!a2.isEmpty()) {
                        kbVar.w().a("Table has extra columns. table, columns", str, TextUtils.join(", ", a2));
                    }
                } catch (SQLiteException e2) {
                    kbVar.t().a("Failed to verify columns on table that was just created", str);
                    throw e2;
                }
            } else {
                throw new IllegalArgumentException(str4);
            }
        } else {
            throw new IllegalArgumentException(str4);
        }
    }

    private static boolean a(C0532kb kbVar, SQLiteDatabase sQLiteDatabase, String str) {
        if (kbVar != null) {
            Cursor cursor = null;
            try {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                Cursor query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                boolean moveToFirst = query.moveToFirst();
                if (query != null) {
                    query.close();
                }
                return moveToFirst;
            } catch (SQLiteException e2) {
                kbVar.w().a("Error querying for table", str, e2);
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } else {
            throw new IllegalArgumentException("Monitor must not be null");
        }
    }

    static void a(C0532kb kbVar, SQLiteDatabase sQLiteDatabase) {
        if (kbVar != null) {
            File file = new File(sQLiteDatabase.getPath());
            if (!file.setReadable(false, false)) {
                kbVar.w().a("Failed to turn off database read permission");
            }
            if (!file.setWritable(false, false)) {
                kbVar.w().a("Failed to turn off database write permission");
            }
            if (!file.setReadable(true, true)) {
                kbVar.w().a("Failed to turn on database read permission for owner");
            }
            if (!file.setWritable(true, true)) {
                kbVar.w().a("Failed to turn on database write permission for owner");
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Monitor must not be null");
    }
}
