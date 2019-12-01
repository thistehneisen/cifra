package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.h;
import java.util.Map.Entry;

@SuppressLint({"RestrictedApi"})
/* compiled from: SavedStateRegistry */
public final class a {

    /* renamed from: a reason: collision with root package name */
    private b.b.a.b.b<String, b> f2056a = new b.b.a.b.b<>();

    /* renamed from: b reason: collision with root package name */
    private Bundle f2057b;

    /* renamed from: c reason: collision with root package name */
    private boolean f2058c;

    /* renamed from: d reason: collision with root package name */
    boolean f2059d = true;

    /* renamed from: androidx.savedstate.a$a reason: collision with other inner class name */
    /* compiled from: SavedStateRegistry */
    public interface C0016a {
        void a(c cVar);
    }

    /* compiled from: SavedStateRegistry */
    public interface b {
        Bundle a();
    }

    a() {
    }

    public Bundle a(String str) {
        if (this.f2058c) {
            Bundle bundle = this.f2057b;
            if (bundle == null) {
                return null;
            }
            Bundle bundle2 = bundle.getBundle(str);
            this.f2057b.remove(str);
            if (this.f2057b.isEmpty()) {
                this.f2057b = null;
            }
            return bundle2;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    /* access modifiers changed from: 0000 */
    public void a(h hVar, Bundle bundle) {
        if (!this.f2058c) {
            if (bundle != null) {
                this.f2057b = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
            }
            hVar.a(new SavedStateRegistry$1(this));
            this.f2058c = true;
            return;
        }
        throw new IllegalStateException("SavedStateRegistry was already restored.");
    }

    /* access modifiers changed from: 0000 */
    public void a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f2057b;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        d f2 = this.f2056a.f();
        while (f2.hasNext()) {
            Entry entry = (Entry) f2.next();
            bundle2.putBundle((String) entry.getKey(), ((b) entry.getValue()).a());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }
}
