package io.intercom.com.bumptech.glide.load.b;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import io.intercom.com.bumptech.glide.h;
import io.intercom.com.bumptech.glide.load.j;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: FileLoader */
public class i<Data> implements u<File, Data> {

    /* renamed from: a reason: collision with root package name */
    private final d<Data> f9511a;

    /* compiled from: FileLoader */
    public static class a<Data> implements v<File, Data> {

        /* renamed from: a reason: collision with root package name */
        private final d<Data> f9512a;

        public a(d<Data> dVar) {
            this.f9512a = dVar;
        }

        public final u<File, Data> a(y yVar) {
            return new i(this.f9512a);
        }
    }

    /* compiled from: FileLoader */
    public static class b extends a<ParcelFileDescriptor> {
        public b() {
            super(new j());
        }
    }

    /* compiled from: FileLoader */
    private static class c<Data> implements io.intercom.com.bumptech.glide.load.a.b<Data> {

        /* renamed from: a reason: collision with root package name */
        private final File f9513a;

        /* renamed from: b reason: collision with root package name */
        private final d<Data> f9514b;

        /* renamed from: c reason: collision with root package name */
        private Data f9515c;

        c(File file, d<Data> dVar) {
            this.f9513a = file;
            this.f9514b = dVar;
        }

        public void a(h hVar, io.intercom.com.bumptech.glide.load.a.b.a<? super Data> aVar) {
            try {
                this.f9515c = this.f9514b.a(this.f9513a);
                aVar.a(this.f9515c);
            } catch (FileNotFoundException e2) {
                String str = "FileLoader";
                if (Log.isLoggable(str, 3)) {
                    Log.d(str, "Failed to open file", e2);
                }
                aVar.a((Exception) e2);
            }
        }

        public void b() {
            Data data = this.f9515c;
            if (data != null) {
                try {
                    this.f9514b.a(data);
                } catch (IOException unused) {
                }
            }
        }

        public io.intercom.com.bumptech.glide.load.a c() {
            return io.intercom.com.bumptech.glide.load.a.LOCAL;
        }

        public void cancel() {
        }

        public Class<Data> a() {
            return this.f9514b.a();
        }
    }

    /* compiled from: FileLoader */
    public interface d<Data> {
        Class<Data> a();

        Data a(File file) throws FileNotFoundException;

        void a(Data data) throws IOException;
    }

    /* compiled from: FileLoader */
    public static class e extends a<InputStream> {
        public e() {
            super(new k());
        }
    }

    public i(d<Data> dVar) {
        this.f9511a = dVar;
    }

    public boolean a(File file) {
        return true;
    }

    public io.intercom.com.bumptech.glide.load.b.u.a<Data> a(File file, int i2, int i3, j jVar) {
        return new io.intercom.com.bumptech.glide.load.b.u.a<>(new io.intercom.com.bumptech.glide.g.b(file), new c(file, this.f9511a));
    }
}
