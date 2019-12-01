package io.fabric.sdk.android.services.network;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: HttpRequest */
class e extends a<HttpRequest> {

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ InputStream f9111c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ OutputStream f9112d;

    /* renamed from: e reason: collision with root package name */
    final /* synthetic */ HttpRequest f9113e;

    e(HttpRequest httpRequest, Closeable closeable, boolean z, InputStream inputStream, OutputStream outputStream) {
        this.f9113e = httpRequest;
        this.f9111c = inputStream;
        this.f9112d = outputStream;
        super(closeable, z);
    }

    public HttpRequest b() throws IOException {
        byte[] bArr = new byte[this.f9113e.f9094j];
        while (true) {
            int read = this.f9111c.read(bArr);
            if (read == -1) {
                return this.f9113e;
            }
            this.f9112d.write(bArr, 0, read);
        }
    }
}
