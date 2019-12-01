package com.google.firebase.iid;

import android.os.Bundle;

/* renamed from: com.google.firebase.iid.n reason: case insensitive filesystem */
final class C0625n extends C0624m<Void> {
    C0625n(int i2, int i3, Bundle bundle) {
        super(i2, 2, bundle);
    }

    /* access modifiers changed from: 0000 */
    public final void a(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            a(null);
        } else {
            a(new zzam(4, "Invalid response to one way request"));
        }
    }

    /* access modifiers changed from: 0000 */
    public final boolean a() {
        return true;
    }
}
