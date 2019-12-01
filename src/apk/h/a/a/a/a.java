package h.a.a.a;

import android.content.Context;
import android.content.IntentFilter;
import java.io.IOException;
import org.joda.time.f.f;
import org.joda.time.g;

/* compiled from: JodaTimeAndroid */
public final class a {

    /* renamed from: a reason: collision with root package name */
    private static boolean f8416a = false;

    public static void a(Context context) {
        if (!f8416a) {
            f8416a = true;
            try {
                g.a((f) new d(context));
                context.getApplicationContext().registerReceiver(new e(), new IntentFilter("android.intent.action.TIMEZONE_CHANGED"));
            } catch (IOException e2) {
                throw new RuntimeException("Could not read ZoneInfoMap. You are probably using Proguard wrong.", e2);
            }
        }
    }
}
