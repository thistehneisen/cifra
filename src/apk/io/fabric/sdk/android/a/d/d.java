package io.fabric.sdk.android.a.d;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import io.fabric.sdk.android.l;

/* compiled from: PreferenceStoreImpl */
public class d implements c {

    /* renamed from: a reason: collision with root package name */
    private final SharedPreferences f8893a;

    /* renamed from: b reason: collision with root package name */
    private final String f8894b;

    /* renamed from: c reason: collision with root package name */
    private final Context f8895c;

    public d(Context context, String str) {
        if (context != null) {
            this.f8895c = context;
            this.f8894b = str;
            this.f8893a = this.f8895c.getSharedPreferences(this.f8894b, 0);
            return;
        }
        throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
    }

    @TargetApi(9)
    public boolean a(Editor editor) {
        if (VERSION.SDK_INT < 9) {
            return editor.commit();
        }
        editor.apply();
        return true;
    }

    public Editor edit() {
        return this.f8893a.edit();
    }

    public SharedPreferences get() {
        return this.f8893a;
    }

    @Deprecated
    public d(l lVar) {
        this(lVar.getContext(), lVar.getClass().getName());
    }
}
