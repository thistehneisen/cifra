package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

/* renamed from: com.google.firebase.iid.k reason: case insensitive filesystem */
final class C0622k {

    /* renamed from: a reason: collision with root package name */
    private final Messenger f6821a;

    /* renamed from: b reason: collision with root package name */
    private final O f6822b;

    C0622k(IBinder iBinder) throws RemoteException {
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if ("android.os.IMessenger".equals(interfaceDescriptor)) {
            this.f6821a = new Messenger(iBinder);
            this.f6822b = null;
        } else if ("com.google.android.gms.iid.IMessengerCompat".equals(interfaceDescriptor)) {
            this.f6822b = new O(iBinder);
            this.f6821a = null;
        } else {
            String str = "Invalid interface descriptor: ";
            String valueOf = String.valueOf(interfaceDescriptor);
            Log.w("MessengerIpcClient", valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    /* access modifiers changed from: 0000 */
    public final void a(Message message) throws RemoteException {
        Messenger messenger = this.f6821a;
        if (messenger != null) {
            messenger.send(message);
            return;
        }
        O o = this.f6822b;
        if (o != null) {
            o.a(message);
            return;
        }
        throw new IllegalStateException("Both messengers are null");
    }
}
