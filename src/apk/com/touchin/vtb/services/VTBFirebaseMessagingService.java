package com.touchin.vtb.services;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build.VERSION;
import androidx.core.app.j.d;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.c;
import com.touchin.vtb.R;
import com.touchin.vtb.VTBAccountingApplication;
import com.touchin.vtb.activities.ChatActivity;
import com.touchin.vtb.activities.MainActivity;
import com.touchin.vtb.activities.StartupActivity;
import com.touchin.vtb.api.NotificationType;
import com.touchin.vtb.f.f;
import kotlin.TypeCastException;
import kotlin.e.b.h;

/* compiled from: VTBFirebaseMessagingService.kt */
public final class VTBFirebaseMessagingService extends FirebaseMessagingService {

    /* renamed from: a reason: collision with root package name */
    public static final a f7604a = new a(null);

    /* compiled from: VTBFirebaseMessagingService.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    private final f a(c cVar) {
        String str = (String) cVar.f().get("notification_title");
        String str2 = "";
        String str3 = str != null ? str : str2;
        String str4 = (String) cVar.f().get("notification_body");
        f fVar = new f(str3, str4 != null ? str4 : str2, b(cVar), null, 8, null);
        String str5 = (String) cVar.f().get("notification_task_id");
        if (str5 != null) {
            fVar.a(str5);
        }
        return fVar;
    }

    private final NotificationType b(c cVar) {
        String str = "notification_type";
        if (h.a((Object) "quarterEnd", (Object) (String) cVar.f().get(str))) {
            return NotificationType.QUARTER_END;
        }
        String str2 = (String) cVar.f().get(str);
        if (str2 == null) {
            str2 = "";
        }
        if (str2 != null) {
            String upperCase = str2.toUpperCase();
            h.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
            return NotificationType.valueOf(upperCase);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public void onMessageReceived(c cVar) {
        h.b(cVar, "messsage");
        super.onMessageReceived(cVar);
        f a2 = a(cVar);
        Object systemService = getSystemService("notification");
        if (systemService != null) {
            NotificationManager notificationManager = (NotificationManager) systemService;
            a(notificationManager);
            PendingIntent a3 = a(a2.d(), a2.b());
            d dVar = new d(this, "COMMON_NOTIFICATIONS");
            dVar.a(true);
            dVar.c((CharSequence) a2.c());
            dVar.b((CharSequence) a2.a());
            dVar.d((int) R.drawable.intercom_push_icon);
            dVar.a(a3);
            notificationManager.notify(0, dVar.a());
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.NotificationManager");
    }

    private final PendingIntent a(NotificationType notificationType, String str) {
        Intent intent;
        boolean z = true;
        if (!VTBAccountingApplication.f6881b.a()) {
            com.touchin.vtb.activities.MainActivity.a aVar = MainActivity.f6990g;
            int a2 = a(notificationType);
            if (notificationType != NotificationType.DEADLINE) {
                z = false;
            }
            intent = aVar.a(this, str, Boolean.valueOf(z), a2);
        } else if (a.f7605a[notificationType.ordinal()] != 1) {
            com.touchin.vtb.activities.StartupActivity.a aVar2 = StartupActivity.f6994g;
            int a3 = a(notificationType);
            if (notificationType != NotificationType.DEADLINE) {
                z = false;
            }
            intent = com.touchin.vtb.activities.StartupActivity.a.a(aVar2, this, false, str, Boolean.valueOf(z), null, a3, 18, null);
        } else {
            intent = ChatActivity.f6989g.a(this);
        }
        PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 1073741824);
        h.a((Object) activity, "PendingIntent.getActivit…t.FLAG_ONE_SHOT\n        )");
        return activity;
    }

    private final int a(NotificationType notificationType) {
        int i2 = a.f7606b[notificationType.ordinal()];
        if (i2 == 1) {
            return R.id.main_navigation_bank;
        }
        if (i2 != 2) {
            return i2 != 3 ? R.id.main_navigation_tasks : R.id.main_navigation_tasks;
        }
        return R.id.main_navigation_chat;
    }

    private final void a(NotificationManager notificationManager) {
        if (VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("COMMON_NOTIFICATIONS", getString(R.string.common_more_notifications), 4);
            notificationChannel.setDescription(getString(R.string.common_more_notifications));
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(-65536);
            notificationChannel.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}
