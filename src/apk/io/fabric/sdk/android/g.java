package io.fabric.sdk.android;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import java.io.File;

/* compiled from: FabricContext */
class g extends ContextWrapper {

    /* renamed from: a reason: collision with root package name */
    private final String f9021a;

    /* renamed from: b reason: collision with root package name */
    private final String f9022b;

    public g(Context context, String str, String str2) {
        super(context);
        this.f9022b = str;
        this.f9021a = str2;
    }

    public File getCacheDir() {
        return new File(super.getCacheDir(), this.f9021a);
    }

    public File getDatabasePath(String str) {
        File file = new File(super.getDatabasePath(str).getParentFile(), this.f9021a);
        file.mkdirs();
        return new File(file, str);
    }

    @TargetApi(8)
    public File getExternalCacheDir() {
        return new File(super.getExternalCacheDir(), this.f9021a);
    }

    @TargetApi(8)
    public File getExternalFilesDir(String str) {
        return new File(super.getExternalFilesDir(str), this.f9021a);
    }

    public File getFilesDir() {
        return new File(super.getFilesDir(), this.f9021a);
    }

    public SharedPreferences getSharedPreferences(String str, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f9022b);
        sb.append(":");
        sb.append(str);
        return super.getSharedPreferences(sb.toString(), i2);
    }

    public SQLiteDatabase openOrCreateDatabase(String str, int i2, CursorFactory cursorFactory) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str), cursorFactory);
    }

    @TargetApi(11)
    public SQLiteDatabase openOrCreateDatabase(String str, int i2, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str).getPath(), cursorFactory, databaseErrorHandler);
    }
}
