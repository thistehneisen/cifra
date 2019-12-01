package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.internal.C0299b;
import com.google.android.gms.common.b;
import com.google.android.gms.common.e;

@KeepName
public class GoogleApiActivity extends Activity implements OnCancelListener {

    /* renamed from: a reason: collision with root package name */
    private int f4516a = 0;

    public static PendingIntent a(Context context, PendingIntent pendingIntent, int i2) {
        return PendingIntent.getActivity(context, 0, a(context, pendingIntent, i2, true), 134217728);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.f4516a = 0;
            setResult(i3, intent);
            if (booleanExtra) {
                C0299b a2 = C0299b.a((Context) this);
                if (i3 == -1) {
                    a2.c();
                } else if (i3 == 0) {
                    a2.a(new b(13, null), getIntent().getIntExtra("failing_client_id", -1));
                }
            }
        } else if (i2 == 2) {
            this.f4516a = 0;
            setResult(i3, intent);
        }
        finish();
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.f4516a = 0;
        setResult(0);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f4516a = bundle.getInt("resolution");
        }
        if (this.f4516a != 1) {
            Bundle extras = getIntent().getExtras();
            String str = "GoogleApiActivity";
            if (extras == null) {
                Log.e(str, "Activity started without extras");
                finish();
                return;
            }
            PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
            Integer num = (Integer) extras.get("error_code");
            if (pendingIntent == null && num == null) {
                Log.e(str, "Activity started without resolution");
                finish();
            } else if (pendingIntent != null) {
                try {
                    startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                    this.f4516a = 1;
                } catch (SendIntentException e2) {
                    Log.e(str, "Failed to launch pendingIntent", e2);
                    finish();
                }
            } else {
                e.a().b(this, num.intValue(), 2, this);
                this.f4516a = 1;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.f4516a);
        super.onSaveInstanceState(bundle);
    }

    public static Intent a(Context context, PendingIntent pendingIntent, int i2, boolean z) {
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i2);
        intent.putExtra("notify_manager", z);
        return intent;
    }
}
