package com.appsflyer;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

final class c {

    /* renamed from: ˋ reason: contains not printable characters */
    private IntentFilter f122 = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    static final class a {

        /* renamed from: ˏ reason: contains not printable characters */
        static final c f123 = new c();
    }

    static final class d {

        /* renamed from: ˊ reason: contains not printable characters */
        private final float f124;

        /* renamed from: ˎ reason: contains not printable characters */
        private final String f125;

        d(float f2, String str) {
            this.f124 = f2;
            this.f125 = str;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: ˎ reason: contains not printable characters */
        public final String m121() {
            return this.f125;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: ˏ reason: contains not printable characters */
        public final float m122() {
            return this.f124;
        }

        d() {
        }
    }

    c() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˎ reason: contains not printable characters */
    public final d m120(Context context) {
        String str = null;
        float f2 = 0.0f;
        try {
            Intent registerReceiver = context.registerReceiver(null, this.f122);
            if (registerReceiver != null) {
                if (2 == registerReceiver.getIntExtra("status", -1)) {
                    int intExtra = registerReceiver.getIntExtra("plugged", -1);
                    str = intExtra != 1 ? intExtra != 2 ? intExtra != 4 ? "other" : "wireless" : "usb" : "ac";
                } else {
                    str = "no";
                }
                int intExtra2 = registerReceiver.getIntExtra("level", -1);
                int intExtra3 = registerReceiver.getIntExtra("scale", -1);
                if (!(-1 == intExtra2 || -1 == intExtra3)) {
                    f2 = (((float) intExtra2) * 100.0f) / ((float) intExtra3);
                }
            }
        } catch (Throwable unused) {
        }
        return new d(f2, str);
    }
}
