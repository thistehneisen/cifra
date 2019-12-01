package h.a.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import java.util.TimeZone;
import org.joda.time.g;

/* compiled from: TimeZoneChangedReceiver */
public class e extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String str = "\"";
        String str2 = "joda-time-android";
        String stringExtra = intent.getStringExtra("time-zone");
        try {
            g.a(g.a(TimeZone.getDefault()));
            StringBuilder sb = new StringBuilder();
            sb.append("TIMEZONE_CHANGED received, changed default timezone to \"");
            sb.append(stringExtra);
            sb.append(str);
            Log.d(str2, sb.toString());
        } catch (IllegalArgumentException e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Could not recognize timezone id \"");
            sb2.append(stringExtra);
            sb2.append(str);
            Log.e(str2, sb2.toString(), e2);
        }
    }
}
