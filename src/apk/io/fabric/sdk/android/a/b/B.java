package io.fabric.sdk.android.a.b;

import io.fabric.sdk.android.a.b.C.c;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: QueueFile */
class B implements c {

    /* renamed from: a reason: collision with root package name */
    boolean f8786a = true;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ StringBuilder f8787b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ C f8788c;

    B(C c2, StringBuilder sb) {
        this.f8788c = c2;
        this.f8787b = sb;
    }

    public void read(InputStream inputStream, int i2) throws IOException {
        if (this.f8786a) {
            this.f8786a = false;
        } else {
            this.f8787b.append(", ");
        }
        this.f8787b.append(i2);
    }
}
