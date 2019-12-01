package com.touchin.vtb.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import io.intercom.android.sdk.Intercom;
import kotlin.e.b.h;

/* compiled from: ChatActivity.kt */
public final class ChatActivity extends c {

    /* renamed from: g reason: collision with root package name */
    public static final a f6989g = new a(null);

    /* compiled from: ChatActivity.kt */
    public static final class a {
        private a() {
        }

        public final Intent a(Context context) {
            h.b(context, "context");
            return new Intent(context, ChatActivity.class);
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intercom.client().displayMessenger();
        finish();
    }
}
