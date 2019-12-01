package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import b.d.i;
import com.google.android.gms.tasks.h;
import com.google.android.gms.tasks.j;
import com.google.firebase.iid.O.a;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.google.firebase.iid.w reason: case insensitive filesystem */
final class C0633w {

    /* renamed from: a reason: collision with root package name */
    private static int f6841a;

    /* renamed from: b reason: collision with root package name */
    private static PendingIntent f6842b;

    /* renamed from: c reason: collision with root package name */
    private final i<String, h<Bundle>> f6843c = new i<>();

    /* renamed from: d reason: collision with root package name */
    private final Context f6844d;

    /* renamed from: e reason: collision with root package name */
    private final C0627p f6845e;

    /* renamed from: f reason: collision with root package name */
    private Messenger f6846f;

    /* renamed from: g reason: collision with root package name */
    private Messenger f6847g;

    /* renamed from: h reason: collision with root package name */
    private O f6848h;

    public C0633w(Context context, C0627p pVar) {
        this.f6844d = context;
        this.f6845e = pVar;
        this.f6846f = new Messenger(new C0632v(this, Looper.getMainLooper()));
    }

    /* access modifiers changed from: private */
    public final void a(Message message) {
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                intent.setExtrasClassLoader(new a());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof O) {
                        this.f6848h = (O) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        this.f6847g = (Messenger) parcelableExtra;
                    }
                }
                Intent intent2 = (Intent) message.obj;
                String action = intent2.getAction();
                if (!"com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
                    if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        String str = "Unexpected response action: ";
                        String valueOf = String.valueOf(action);
                        Log.d("FirebaseInstanceId", valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                    }
                    return;
                }
                String stringExtra = intent2.getStringExtra("registration_id");
                if (stringExtra == null) {
                    stringExtra = intent2.getStringExtra("unregistered");
                }
                if (stringExtra == null) {
                    String stringExtra2 = intent2.getStringExtra("error");
                    if (stringExtra2 == null) {
                        String valueOf2 = String.valueOf(intent2.getExtras());
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 49);
                        sb.append("Unexpected response, no error or registration id ");
                        sb.append(valueOf2);
                        Log.w("FirebaseInstanceId", sb.toString());
                    } else {
                        if (Log.isLoggable("FirebaseInstanceId", 3)) {
                            String str2 = "Received InstanceID error ";
                            String valueOf3 = String.valueOf(stringExtra2);
                            Log.d("FirebaseInstanceId", valueOf3.length() != 0 ? str2.concat(valueOf3) : new String(str2));
                        }
                        if (stringExtra2.startsWith("|")) {
                            String[] split = stringExtra2.split("\\|");
                            if (split.length > 2) {
                                if ("ID".equals(split[1])) {
                                    String str3 = split[2];
                                    String str4 = split[3];
                                    if (str4.startsWith(":")) {
                                        str4 = str4.substring(1);
                                    }
                                    a(str3, intent2.putExtra("error", str4).getExtras());
                                }
                            }
                            String str5 = "Unexpected structured response ";
                            String valueOf4 = String.valueOf(stringExtra2);
                            Log.w("FirebaseInstanceId", valueOf4.length() != 0 ? str5.concat(valueOf4) : new String(str5));
                        } else {
                            synchronized (this.f6843c) {
                                for (int i2 = 0; i2 < this.f6843c.size(); i2++) {
                                    a((String) this.f6843c.b(i2), intent2.getExtras());
                                }
                            }
                        }
                    }
                }
                Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
                if (!matcher.matches()) {
                    if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        String str6 = "Unexpected response string: ";
                        String valueOf5 = String.valueOf(stringExtra);
                        Log.d("FirebaseInstanceId", valueOf5.length() != 0 ? str6.concat(valueOf5) : new String(str6));
                    }
                    return;
                }
                String group = matcher.group(1);
                String group2 = matcher.group(2);
                Bundle extras = intent2.getExtras();
                extras.putString("registration_id", group2);
                a(group, extras);
                return;
            }
        }
        Log.w("FirebaseInstanceId", "Dropping invalid message");
    }

    private final Bundle b(Bundle bundle) throws IOException {
        Bundle c2 = c(bundle);
        if (c2 == null) {
            return c2;
        }
        String str = "google.messenger";
        if (!c2.containsKey(str)) {
            return c2;
        }
        Bundle c3 = c(bundle);
        if (c3 == null || !c3.containsKey(str)) {
            return c3;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ef A[SYNTHETIC] */
    private final Bundle c(Bundle bundle) throws IOException {
        String a2 = a();
        h hVar = new h();
        synchronized (this.f6843c) {
            this.f6843c.put(a2, hVar);
        }
        if (this.f6845e.a() != 0) {
            Intent intent = new Intent();
            intent.setPackage("com.google.android.gms");
            if (this.f6845e.a() == 2) {
                intent.setAction("com.google.iid.TOKEN_REQUEST");
            } else {
                intent.setAction("com.google.android.c2dm.intent.REGISTER");
            }
            intent.putExtras(bundle);
            a(this.f6844d, intent);
            StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 5);
            sb.append("|ID|");
            sb.append(a2);
            sb.append("|");
            intent.putExtra("kid", sb.toString());
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(intent.getExtras());
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 8);
                sb2.append("Sending ");
                sb2.append(valueOf);
                Log.d("FirebaseInstanceId", sb2.toString());
            }
            intent.putExtra("google.messenger", this.f6846f);
            if (!(this.f6847g == null && this.f6848h == null)) {
                Message obtain = Message.obtain();
                obtain.obj = intent;
                try {
                    if (this.f6847g != null) {
                        this.f6847g.send(obtain);
                    } else {
                        this.f6848h.a(obtain);
                    }
                } catch (RemoteException unused) {
                    if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        Log.d("FirebaseInstanceId", "Messenger failed, fallback to startService");
                    }
                }
                Bundle bundle2 = (Bundle) j.a(hVar.a(), 30000, TimeUnit.MILLISECONDS);
                synchronized (this.f6843c) {
                    this.f6843c.remove(a2);
                }
                return bundle2;
            }
            if (this.f6845e.a() == 2) {
                this.f6844d.sendBroadcast(intent);
            } else {
                this.f6844d.startService(intent);
            }
            try {
                Bundle bundle22 = (Bundle) j.a(hVar.a(), 30000, TimeUnit.MILLISECONDS);
                synchronized (this.f6843c) {
                }
                return bundle22;
            } catch (InterruptedException | TimeoutException unused2) {
                Log.w("FirebaseInstanceId", "No response");
                throw new IOException("TIMEOUT");
            } catch (ExecutionException e2) {
                throw new IOException(e2);
            } catch (Throwable th) {
                synchronized (this.f6843c) {
                    this.f6843c.remove(a2);
                    throw th;
                }
            }
        } else {
            throw new IOException("MISSING_INSTANCEID_SERVICE");
        }
    }

    private static synchronized void a(Context context, Intent intent) {
        synchronized (C0633w.class) {
            if (f6842b == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                f6842b = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra("app", f6842b);
        }
    }

    private final void a(String str, Bundle bundle) {
        synchronized (this.f6843c) {
            h hVar = (h) this.f6843c.remove(str);
            if (hVar == null) {
                String str2 = "FirebaseInstanceId";
                String str3 = "Missing callback for ";
                String valueOf = String.valueOf(str);
                Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                return;
            }
            hVar.a(bundle);
        }
    }

    /* access modifiers changed from: 0000 */
    public final Bundle a(Bundle bundle) throws IOException {
        if (this.f6845e.d() < 12000000) {
            return b(bundle);
        }
        try {
            return (Bundle) j.a(C0617f.a(this.f6844d).b(1, bundle));
        } catch (InterruptedException | ExecutionException e2) {
            String str = "FirebaseInstanceId";
            if (Log.isLoggable(str, 3)) {
                String valueOf = String.valueOf(e2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
                sb.append("Error making request: ");
                sb.append(valueOf);
                Log.d(str, sb.toString());
            }
            if (!(e2.getCause() instanceof zzam) || ((zzam) e2.getCause()).a() != 4) {
                return null;
            }
            return b(bundle);
        }
    }

    private static synchronized String a() {
        String num;
        synchronized (C0633w.class) {
            int i2 = f6841a;
            f6841a = i2 + 1;
            num = Integer.toString(i2);
        }
        return num;
    }
}
