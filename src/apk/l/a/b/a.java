package l.a.b;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import kotlin.e.b.h;

/* compiled from: Activity.kt */
public final class a {
    public static final void a(Activity activity, String str) {
        h.b(activity, "$this$openGooglePlay");
        h.b(str, "packageName");
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("market://details?id=");
            sb.append(str);
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(sb.toString())));
        } catch (ActivityNotFoundException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("https://play.google.com/store/apps/details?id=");
            sb2.append(str);
            b.b(activity, sb2.toString());
        }
    }
}
