package com.appsflyer;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.google.android.gms.iid.InstanceIDListenerService;
import com.google.firebase.iid.FirebaseInstanceIdService;
import java.lang.ref.WeakReference;

final class y {

    static class a extends AsyncTask<Void, Void, String> {

        /* renamed from: ˊ reason: contains not printable characters */
        private String f268;

        /* renamed from: ˏ reason: contains not printable characters */
        private final WeakReference<Context> f269;

        a(WeakReference<Context> weakReference) {
            this.f269 = weakReference;
        }

        /* renamed from: ˋ reason: contains not printable characters */
        private String m230() {
            String str = null;
            try {
                if (this.f268 != null) {
                    str = y.m224(this.f269, this.f268);
                }
                return str;
            } catch (Throwable th) {
                AFLogger.afErrorLog("Error registering for uninstall feature", th);
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return m230();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            String str = (String) obj;
            if (!TextUtils.isEmpty(str)) {
                String string = AppsFlyerProperties.getInstance().getString("afUninstallToken");
                b bVar = new b(str);
                if (string == null) {
                    y.m228((Context) this.f269.get(), bVar);
                    return;
                }
                b r3 = b.m114(string);
                if (r3.m117(bVar)) {
                    y.m228((Context) this.f269.get(), r3);
                }
            }
        }

        /* access modifiers changed from: protected */
        public final void onPreExecute() {
            super.onPreExecute();
            this.f268 = AppsFlyerProperties.getInstance().getString("gcmProjectNumber");
        }
    }

    y() {
    }

    /* access modifiers changed from: private */
    /* renamed from: ˊ reason: contains not printable characters */
    public static String m224(WeakReference<Context> weakReference, String str) {
        try {
            Class cls = Class.forName("com.google.android.gms.iid.InstanceID");
            Class.forName("com.google.android.gms.gcm.GcmReceiver");
            Object invoke = cls.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke(cls, new Object[]{weakReference.get()});
            String str2 = (String) cls.getDeclaredMethod("getToken", new Class[]{String.class, String.class}).invoke(invoke, new Object[]{str, "GCM"});
            if (str2 != null) {
                return str2;
            }
            AFLogger.afWarnLog("Couldn't get token using reflection.");
            return null;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (Throwable th) {
            AFLogger.afErrorLog("Couldn't get token using GoogleCloudMessaging. ", th);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
        if ((r6.getPackageManager().queryIntentServices(r3, 0).size() > 0) != false) goto L_0x0049;
     */
    /* renamed from: ˎ reason: contains not printable characters */
    private static boolean m227(Context context) {
        String str = "com.google.android.gms.iid.InstanceID";
        if (AppsFlyerLib.getInstance().isTrackingStopped()) {
            return false;
        }
        try {
            Class.forName("com.google.android.gms.iid.InstanceIDListenerService");
            Intent intent = new Intent(str, null, context, GcmInstanceIdListener.class);
            Intent intent2 = new Intent(str, null, context, InstanceIDListenerService.class);
            if (!(context.getPackageManager().queryIntentServices(intent, 0).size() > 0)) {
            }
            if (context.getPackageManager().queryBroadcastReceivers(new Intent("com.google.android.c2dm.intent.RECEIVE", null, context, Class.forName("com.google.android.gms.gcm.GcmReceiver")), 0).size() > 0) {
                String packageName = context.getPackageName();
                StringBuilder sb = new StringBuilder();
                sb.append(packageName);
                sb.append(".permission.C2D_MESSAGE");
                if (AnonymousClass5.m5(context, sb.toString())) {
                    return true;
                }
                AFLogger.afWarnLog("Cannot verify existence of the app's \"permission.C2D_MESSAGE\" permission in the manifest. Please refer to documentation.");
            } else {
                AFLogger.afWarnLog("Cannot verify existence of GcmReceiver receiver in the manifest. Please refer to documentation.");
            }
        } catch (ClassNotFoundException e2) {
            AFLogger.afRDLog(e2.getMessage());
        } catch (Throwable th) {
            AFLogger.afErrorLog("An error occurred while trying to verify manifest declarations: ", th);
        }
        return false;
    }

    /* renamed from: ॱ reason: contains not printable characters */
    private static boolean m229(Context context) {
        String str = "com.google.firebase.INSTANCE_ID_EVENT";
        if (AppsFlyerLib.getInstance().isTrackingStopped()) {
            return false;
        }
        try {
            Class.forName("com.google.firebase.iid.FirebaseInstanceIdService");
            Intent intent = new Intent(str, null, context, FirebaseInstanceIdListener.class);
            Intent intent2 = new Intent(str, null, context, FirebaseInstanceIdService.class);
            if (!(context.getPackageManager().queryIntentServices(intent, 0).size() > 0)) {
                if (!(context.getPackageManager().queryIntentServices(intent2, 0).size() > 0)) {
                    AFLogger.afWarnLog("Cannot verify existence of our InstanceID Listener Service in the manifest. Please refer to documentation.");
                    return false;
                }
            }
            return true;
        } catch (ClassNotFoundException unused) {
        } catch (Throwable th) {
            AFLogger.afErrorLog("An error occurred while trying to verify manifest declarations: ", th);
        }
    }

    /* renamed from: ˋ reason: contains not printable characters */
    static boolean m226(Context context) {
        return m229(context) | m227(context);
    }

    /* renamed from: ॱ reason: contains not printable characters */
    static void m228(Context context, b bVar) {
        StringBuilder sb = new StringBuilder("updateServerUninstallToken called with: ");
        sb.append(bVar.toString());
        AFLogger.afInfoLog(sb.toString());
        String str = "afUninstallToken";
        b r0 = b.m114(AppsFlyerProperties.getInstance().getString(str));
        if (!AppsFlyerLib.m44(context).getBoolean("sentRegisterRequestToAF", false) || r0.m116() == null || !r0.m116().equals(bVar.m116())) {
            AppsFlyerProperties.getInstance().set(str, bVar.toString());
            AppsFlyerLib.getInstance().m75(context, bVar.m116());
        }
    }
}
