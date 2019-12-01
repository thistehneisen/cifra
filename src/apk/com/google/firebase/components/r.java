package com.google.firebase.components;

import com.google.firebase.a.a;
import com.google.firebase.a.b;
import java.util.Map.Entry;

/* compiled from: com.google.firebase:firebase-common@@17.0.0 */
final /* synthetic */ class r implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final Entry f6715a;

    /* renamed from: b reason: collision with root package name */
    private final a f6716b;

    private r(Entry entry, a aVar) {
        this.f6715a = entry;
        this.f6716b = aVar;
    }

    public static Runnable a(Entry entry, a aVar) {
        return new r(entry, aVar);
    }

    public void run() {
        ((b) this.f6715a.getKey()).a(this.f6716b);
    }
}
