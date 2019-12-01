package com.google.android.material.snackbar;

import android.os.Handler.Callback;
import android.os.Message;

/* compiled from: BaseTransientBottomBar */
class c implements Callback {
    c() {
    }

    public boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 0) {
            ((BaseTransientBottomBar) message.obj).m();
            return true;
        } else if (i2 != 1) {
            return false;
        } else {
            ((BaseTransientBottomBar) message.obj).b(message.arg1);
            return true;
        }
    }
}
