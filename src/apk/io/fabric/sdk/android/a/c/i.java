package io.fabric.sdk.android.a.c;

import android.content.Context;
import io.fabric.sdk.android.a.b.C;
import io.fabric.sdk.android.a.b.l;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: QueueFileEventStorage */
public class i implements d {

    /* renamed from: a reason: collision with root package name */
    private final Context f8882a;

    /* renamed from: b reason: collision with root package name */
    private final File f8883b;

    /* renamed from: c reason: collision with root package name */
    private final String f8884c;

    /* renamed from: d reason: collision with root package name */
    private final File f8885d;

    /* renamed from: e reason: collision with root package name */
    private C f8886e = new C(this.f8885d);

    /* renamed from: f reason: collision with root package name */
    private File f8887f;

    public i(Context context, File file, String str, String str2) throws IOException {
        this.f8882a = context;
        this.f8883b = file;
        this.f8884c = str2;
        this.f8885d = new File(this.f8883b, str);
        e();
    }

    private void e() {
        this.f8887f = new File(this.f8883b, this.f8884c);
        if (!this.f8887f.exists()) {
            this.f8887f.mkdirs();
        }
    }

    public OutputStream a(File file) throws IOException {
        throw null;
    }

    public void a(byte[] bArr) throws IOException {
        this.f8886e.a(bArr);
    }

    public boolean b() {
        return this.f8886e.b();
    }

    public List<File> c() {
        return Arrays.asList(this.f8887f.listFiles());
    }

    public void d() {
        try {
            this.f8886e.close();
        } catch (IOException unused) {
        }
        this.f8885d.delete();
    }

    public int a() {
        return this.f8886e.d();
    }

    public void a(String str) throws IOException {
        this.f8886e.close();
        a(this.f8885d, new File(this.f8887f, str));
        this.f8886e = new C(this.f8885d);
    }

    private void a(File file, File file2) throws IOException {
        FileInputStream fileInputStream;
        String str = "Failed to close output stream";
        String str2 = "Failed to close file input stream";
        OutputStream outputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                outputStream = a(file2);
                l.a((InputStream) fileInputStream, outputStream, new byte[1024]);
                l.a((Closeable) fileInputStream, str2);
                l.a((Closeable) outputStream, str);
                file.delete();
            } catch (Throwable th) {
                th = th;
                l.a((Closeable) fileInputStream, str2);
                l.a((Closeable) outputStream, str);
                file.delete();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            l.a((Closeable) fileInputStream, str2);
            l.a((Closeable) outputStream, str);
            file.delete();
            throw th;
        }
    }

    public List<File> a(int i2) {
        ArrayList arrayList = new ArrayList();
        for (File add : this.f8887f.listFiles()) {
            arrayList.add(add);
            if (arrayList.size() >= i2) {
                break;
            }
        }
        return arrayList;
    }

    public void a(List<File> list) {
        for (File file : list) {
            l.c(this.f8882a, String.format("deleting sent analytics file %s", new Object[]{file.getName()}));
            file.delete();
        }
    }

    public boolean a(int i2, int i3) {
        return this.f8886e.a(i2, i3);
    }
}
