package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.B;
import androidx.lifecycle.h;
import androidx.lifecycle.h.b;
import androidx.lifecycle.l;
import androidx.lifecycle.n;
import b.d.i;
import b.g.i.C0244e;

/* compiled from: ComponentActivity */
public class g extends Activity implements l, b.g.i.C0244e.a {
    private i<Class<? extends a>, a> mExtraDataMap = new i<>();
    private n mLifecycleRegistry = new n(this);

    /* compiled from: ComponentActivity */
    public static class a {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !C0244e.a(decorView, keyEvent)) {
            return C0244e.a(this, decorView, this, keyEvent);
        }
        return true;
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !C0244e.a(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    public <T extends a> T getExtraData(Class<T> cls) {
        return (a) this.mExtraDataMap.get(cls);
    }

    public h getLifecycle() {
        throw null;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"RestrictedApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        B.b((Activity) this);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        this.mLifecycleRegistry.a(b.CREATED);
        super.onSaveInstanceState(bundle);
    }

    public void putExtraData(a aVar) {
        this.mExtraDataMap.put(aVar.getClass(), aVar);
    }

    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
}
