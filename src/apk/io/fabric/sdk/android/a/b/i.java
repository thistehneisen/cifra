package io.fabric.sdk.android.a.b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import io.fabric.sdk.android.f;
import io.fabric.sdk.android.o;

/* compiled from: ApiKey */
public class i {
    /* access modifiers changed from: protected */
    public String a() {
        return "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>";
    }

    /* access modifiers changed from: protected */
    public String a(Context context) {
        return new x().a(context);
    }

    /* access modifiers changed from: protected */
    public String b(Context context) {
        String str = "Fabric";
        String str2 = null;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null) {
                return null;
            }
            String string = bundle.getString("io.fabric.ApiKey");
            try {
                if ("@string/twitter_consumer_secret".equals(string)) {
                    f.e().d(str, "Ignoring bad default value for Fabric ApiKey set by FirebaseUI-Auth");
                } else {
                    str2 = string;
                }
                if (str2 != null) {
                    return str2;
                }
                f.e().d(str, "Falling back to Crashlytics key lookup from Manifest");
                return bundle.getString("com.crashlytics.ApiKey");
            } catch (Exception e2) {
                e = e2;
                str2 = string;
                o e3 = f.e();
                StringBuilder sb = new StringBuilder();
                sb.append("Caught non-fatal exception while retrieving apiKey: ");
                sb.append(e);
                e3.d(str, sb.toString());
                return str2;
            }
        } catch (Exception e4) {
            e = e4;
            o e32 = f.e();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Caught non-fatal exception while retrieving apiKey: ");
            sb2.append(e);
            e32.d(str, sb2.toString());
            return str2;
        }
    }

    /* access modifiers changed from: protected */
    public String c(Context context) {
        String str = "string";
        int a2 = l.a(context, "io.fabric.ApiKey", str);
        if (a2 == 0) {
            f.e().d("Fabric", "Falling back to Crashlytics key lookup from Strings");
            a2 = l.a(context, "com.crashlytics.ApiKey", str);
        }
        if (a2 != 0) {
            return context.getResources().getString(a2);
        }
        return null;
    }

    public String d(Context context) {
        String b2 = b(context);
        if (TextUtils.isEmpty(b2)) {
            b2 = c(context);
        }
        if (TextUtils.isEmpty(b2)) {
            b2 = a(context);
        }
        if (TextUtils.isEmpty(b2)) {
            e(context);
        }
        return b2;
    }

    /* access modifiers changed from: protected */
    public void e(Context context) {
        if (f.g() || l.j(context)) {
            throw new IllegalArgumentException(a());
        }
        f.e().b("Fabric", a());
    }
}
