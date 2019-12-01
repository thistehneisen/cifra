package androidx.appcompat.app;

import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: androidx.appcompat.app.d reason: case insensitive filesystem */
/* compiled from: AlertController */
class C0137d implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ AlertController f472a;

    C0137d(AlertController alertController) {
        this.f472a = alertController;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0030  */
    public void onClick(View view) {
        Message message;
        AlertController alertController = this.f472a;
        if (view == alertController.o) {
            Message message2 = alertController.q;
            if (message2 != null) {
                message = Message.obtain(message2);
                if (message != null) {
                    message.sendToTarget();
                }
                AlertController alertController2 = this.f472a;
                alertController2.R.obtainMessage(1, alertController2.f382b).sendToTarget();
            }
        }
        AlertController alertController3 = this.f472a;
        if (view == alertController3.s) {
            Message message3 = alertController3.u;
            if (message3 != null) {
                message = Message.obtain(message3);
                if (message != null) {
                }
                AlertController alertController22 = this.f472a;
                alertController22.R.obtainMessage(1, alertController22.f382b).sendToTarget();
            }
        }
        AlertController alertController4 = this.f472a;
        if (view == alertController4.w) {
            Message message4 = alertController4.y;
            if (message4 != null) {
                message = Message.obtain(message4);
                if (message != null) {
                }
                AlertController alertController222 = this.f472a;
                alertController222.R.obtainMessage(1, alertController222.f382b).sendToTarget();
            }
        }
        message = null;
        if (message != null) {
        }
        AlertController alertController2222 = this.f472a;
        alertController2222.R.obtainMessage(1, alertController2222.f382b).sendToTarget();
    }
}
