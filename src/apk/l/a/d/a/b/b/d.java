package l.a.d.a.b.b;

import android.content.SharedPreferences;
import ru.touchin.roboswag.core.observables.storable.i;
import ru.touchin.roboswag.core.observables.storable.j;
import ru.touchin.roboswag.core.observables.storable.k;

/* compiled from: PreferenceUtils */
public final class d {
    public static i<String, String, String> a(String str, SharedPreferences sharedPreferences, String str2) {
        k kVar = new k(str, String.class, String.class, new c(sharedPreferences), new j());
        return kVar.b(str2).b();
    }

    public static i<String, Long, Long> a(String str, SharedPreferences sharedPreferences, long j2) {
        k kVar = new k(str, Long.class, Long.class, new c(sharedPreferences), new j());
        return kVar.b(Long.valueOf(j2)).b();
    }

    public static i<String, Boolean, Boolean> a(String str, SharedPreferences sharedPreferences, boolean z) {
        k kVar = new k(str, Boolean.class, Boolean.class, new c(sharedPreferences), new j());
        return kVar.b(Boolean.valueOf(z)).b();
    }
}
