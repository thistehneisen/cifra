package l.a.b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import kotlin.e.b.h;
import kotlin.m;

/* compiled from: Context.kt */
public final class b {
    public static /* synthetic */ boolean a(Context context, Intent intent, Bundle bundle, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bundle = null;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return a(context, intent, bundle, i2);
    }

    public static final boolean b(Context context, String str) {
        h.b(context, "$this$openBrowser");
        h.b(str, "url");
        Intent data = new Intent("android.intent.action.VIEW").setData(Uri.parse(str));
        h.a((Object) data, "intent");
        return a(context, data, null, 0, 6, null);
    }

    public static final boolean a(Context context, Intent intent, Bundle bundle, int i2) {
        m mVar;
        h.b(context, "$this$safeStartActivity");
        h.b(intent, "intent");
        if (context.getPackageManager().resolveActivity(intent, i2) != null) {
            context.startActivity(intent, bundle);
            mVar = m.f10346a;
        } else {
            mVar = null;
        }
        return mVar != null;
    }

    public static final boolean a(Context context, String str) {
        h.b(context, "$this$callToPhoneNumber");
        h.b(str, "phoneNumber");
        Intent intent = new Intent("android.intent.action.VIEW");
        StringBuilder sb = new StringBuilder();
        sb.append("tel:");
        sb.append(str);
        Intent data = intent.setData(Uri.parse(sb.toString()));
        h.a((Object) data, "intent");
        return a(context, data, null, 0, 6, null);
    }
}
