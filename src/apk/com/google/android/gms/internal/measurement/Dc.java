package com.google.android.gms.internal.measurement;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public final class Dc extends Handler {
    public Dc(Looper looper) {
        super(looper);
    }

    public final void dispatchMessage(Message message) {
        super.dispatchMessage(message);
    }
}
