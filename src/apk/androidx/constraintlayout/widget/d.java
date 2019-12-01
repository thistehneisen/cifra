package androidx.constraintlayout.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: ConstraintLayout */
class d extends Handler {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ ConstraintLayout f1170a;

    d(ConstraintLayout constraintLayout, Looper looper) {
        this.f1170a = constraintLayout;
        super(looper);
    }

    public void handleMessage(Message message) {
        ConstraintLayout constraintLayout = this.f1170a;
        constraintLayout.a(constraintLayout.m, message.arg1, message.arg2);
    }
}
