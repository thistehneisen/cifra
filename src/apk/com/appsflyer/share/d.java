package com.appsflyer.share;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

final class d {

    /* renamed from: ˏ reason: contains not printable characters */
    private String f264;

    d() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˏ reason: contains not printable characters */
    public final void m214(String str) {
        this.f264 = str;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ॱ reason: contains not printable characters */
    public final void m215(Context context) {
        String str = this.f264;
        if (str != null) {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)).setFlags(268435456));
        }
    }
}
