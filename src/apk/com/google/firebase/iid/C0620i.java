package com.google.firebase.iid;

import java.util.concurrent.TimeUnit;

/* renamed from: com.google.firebase.iid.i reason: case insensitive filesystem */
final /* synthetic */ class C0620i implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final C0619h f6819a;

    C0620i(C0619h hVar) {
        this.f6819a = hVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        if (android.util.Log.isLoggable("MessengerIpcClient", 3) == false) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
        r3 = java.lang.String.valueOf(r1);
        r5 = new java.lang.StringBuilder(java.lang.String.valueOf(r3).length() + 8);
        r5.append("Sending ");
        r5.append(r3);
        android.util.Log.d("MessengerIpcClient", r5.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0066, code lost:
        r3 = r0.f6818f.f6808b;
        r4 = r0.f6814b;
        r5 = android.os.Message.obtain();
        r5.what = r1.f6827c;
        r5.arg1 = r1.f6825a;
        r5.replyTo = r4;
        r4 = new android.os.Bundle();
        r4.putBoolean("oneWay", r1.a());
        r4.putString("pkg", r3.getPackageName());
        r4.putBundle("data", r1.f6828d);
        r5.setData(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r0.f6815c.a(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00a4, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a5, code lost:
        r0.a(2, r1.getMessage());
     */
    public final void run() {
        C0619h hVar = this.f6819a;
        while (true) {
            synchronized (hVar) {
                if (hVar.f6813a == 2) {
                    if (hVar.f6816d.isEmpty()) {
                        hVar.b();
                        return;
                    }
                    C0624m mVar = (C0624m) hVar.f6816d.poll();
                    hVar.f6817e.put(mVar.f6825a, mVar);
                    hVar.f6818f.f6809c.schedule(new C0623l(hVar, mVar), 30, TimeUnit.SECONDS);
                } else {
                    return;
                }
            }
        }
        while (true) {
        }
    }
}
