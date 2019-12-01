package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.g;
import com.google.android.gms.tasks.j;
import com.google.firebase.iid.C0617f;
import com.google.firebase.iid.C0635y;
import com.google.firebase.iid.E;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FirebaseMessagingService extends E {
    private static final Queue<String> zzec = new ArrayDeque(10);

    public void onDeletedMessages() {
    }

    public void onMessageReceived(c cVar) {
    }

    public void onMessageSent(String str) {
    }

    public void onNewToken(String str) {
    }

    public void onSendError(String str, Exception exc) {
    }

    /* access modifiers changed from: protected */
    public final Intent zzb(Intent intent) {
        return C0635y.a().b();
    }

    public final boolean zzc(Intent intent) {
        if (!"com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            return false;
        }
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (CanceledException unused) {
                Log.e("FirebaseMessaging", "Notification pending intent canceled");
            }
        }
        if (b.e(intent)) {
            b.c(intent);
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f3, code lost:
        if (r1.equals(r5) != false) goto L_0x0101;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c7  */
    public final void zzd(Intent intent) {
        g gVar;
        boolean z;
        String action = intent.getAction();
        String str = "FirebaseMessaging";
        if ("com.google.android.c2dm.intent.RECEIVE".equals(action) || "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(action)) {
            String str2 = "google.message_id";
            String stringExtra = intent.getStringExtra(str2);
            if (TextUtils.isEmpty(stringExtra)) {
                gVar = j.a(null);
            } else {
                Bundle bundle = new Bundle();
                bundle.putString(str2, stringExtra);
                gVar = C0617f.a((Context) this).a(2, bundle);
            }
            char c2 = 0;
            if (!TextUtils.isEmpty(stringExtra)) {
                if (zzec.contains(stringExtra)) {
                    if (Log.isLoggable(str, 3)) {
                        String str3 = "Received duplicate message: ";
                        String valueOf = String.valueOf(stringExtra);
                        Log.d(str, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                    }
                    z = true;
                    if (!z) {
                        String stringExtra2 = intent.getStringExtra("message_type");
                        String str4 = "gcm";
                        if (stringExtra2 == null) {
                            stringExtra2 = str4;
                        }
                        switch (stringExtra2.hashCode()) {
                            case -2062414158:
                                if (stringExtra2.equals("deleted_messages")) {
                                    c2 = 1;
                                    break;
                                }
                            case 102161:
                                break;
                            case 814694033:
                                if (stringExtra2.equals("send_error")) {
                                    c2 = 3;
                                    break;
                                }
                            case 814800675:
                                if (stringExtra2.equals("send_event")) {
                                    c2 = 2;
                                    break;
                                }
                            default:
                                c2 = 65535;
                                break;
                        }
                        if (c2 == 0) {
                            if (b.e(intent)) {
                                b.d(intent);
                            }
                            Bundle extras = intent.getExtras();
                            if (extras == null) {
                                extras = new Bundle();
                            }
                            extras.remove("androidx.contentpager.content.wakelockid");
                            if (e.b(extras)) {
                                ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
                                try {
                                    if (!new f(this, extras, newSingleThreadExecutor).a()) {
                                        newSingleThreadExecutor.shutdown();
                                        if (b.e(intent)) {
                                            b.b(intent);
                                        }
                                    }
                                } finally {
                                    newSingleThreadExecutor.shutdown();
                                }
                            }
                            onMessageReceived(new c(extras));
                        } else if (c2 == 1) {
                            onDeletedMessages();
                        } else if (c2 == 2) {
                            onMessageSent(intent.getStringExtra(str2));
                        } else if (c2 != 3) {
                            String str5 = "Received message with unknown type: ";
                            String valueOf2 = String.valueOf(stringExtra2);
                            Log.w(str, valueOf2.length() != 0 ? str5.concat(valueOf2) : new String(str5));
                        } else {
                            String stringExtra3 = intent.getStringExtra(str2);
                            if (stringExtra3 == null) {
                                stringExtra3 = intent.getStringExtra("message_id");
                            }
                            onSendError(stringExtra3, new SendException(intent.getStringExtra("error")));
                        }
                    }
                    j.a(gVar, 1, TimeUnit.SECONDS);
                }
                if (zzec.size() >= 10) {
                    zzec.remove();
                }
                zzec.add(stringExtra);
            }
            z = false;
            if (!z) {
            }
            try {
                j.a(gVar, 1, TimeUnit.SECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException e2) {
                String valueOf3 = String.valueOf(e2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf3).length() + 20);
                sb.append("Message ack failed: ");
                sb.append(valueOf3);
                Log.w(str, sb.toString());
            }
        } else {
            if ("com.google.firebase.messaging.NOTIFICATION_DISMISS".equals(action)) {
                if (b.e(intent)) {
                    b.a(intent);
                }
            } else if ("com.google.firebase.messaging.NEW_TOKEN".equals(action)) {
                onNewToken(intent.getStringExtra("token"));
            } else {
                String str6 = "Unknown intent action: ";
                String valueOf4 = String.valueOf(intent.getAction());
                Log.d(str, valueOf4.length() != 0 ? str6.concat(valueOf4) : new String(str6));
            }
        }
    }
}
