package c.b.a.b.b.c;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;

public class d extends Handler {
    public d(Looper looper) {
        super(looper);
    }

    public final void dispatchMessage(Message message) {
        super.dispatchMessage(message);
    }

    public d(Looper looper, Callback callback) {
        super(looper, callback);
    }
}
