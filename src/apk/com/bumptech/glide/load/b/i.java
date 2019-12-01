package com.bumptech.glide.load.b;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.j;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: FileLoader */
public class i<Data> implements u<File, Data> {

    /* renamed from: a reason: collision with root package name */
    private final d<Data> f3641a;

    /* compiled from: FileLoader */
    public static class a<Data> implements v<File, Data> {

        /* renamed from: a reason: collision with root package name */
        private final d<Data> f3642a;

        public a(d<Data> dVar) {
            this.f3642a = dVar;
        }

        public final u<File, Data> a(y yVar) {
            return new i(this.f3642a);
        }

        public final void a() {
        }
    }

    /* compiled from: FileLoader */
    public static class b extends a<ParcelFileDescriptor> {
        public b() {
            super(new j());
        }
    }

    /* compiled from: FileLoader */
    private static final class c<Data> implements com.bumptech.glide.load.a.d<Data> {

        /* renamed from: a reason: collision with root package name */
        private final File f3643a;

        /* renamed from: b reason: collision with root package name */
        private final d<Data> f3644b;

        /* renamed from: c reason: collision with root package name */
        private Data f3645c;

        c(File file, d<Data> dVar) {
            this.f3643a = file;
            this.f3644b = dVar;
        }

        public void a(j jVar, com.bumptech.glide.load.a.d.a<? super Data> aVar) {
            try {
                this.f3645c = this.f3644b.a(this.f3643a);
                aVar.a(this.f3645c);
            } catch (FileNotFoundException e2) {
                String str = "FileLoader";
                if (Log.isLoggable(str, 3)) {
                    Log.d(str, "Failed to open file", e2);
                }
                aVar.a((Exception) e2);
            }
        }

        public void b() {
            Data data = this.f3645c;
            if (data != null) {
                try {
                    this.f3644b.a(data);
                } catch (IOException unused) {
                }
            }
        }

        public com.bumptech.glide.load.a c() {
            return com.bumptech.glide.load.a.LOCAL;
        }

        public void cancel() {
        }

        public Class<Data> a() {
            return this.f3644b.a();
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
        this.f3641a = dVar;
    }

    public boolean a(File file) {
        return true;
    }

    public com.bumptech.glide.load.b.u.a<Data> a(File file, int i2, int i3, com.bumptech.glide.load.i iVar) {
        return new com.bumptech.glide.load.b.u.a<>(new com.bumptech.glide.g.b(file), new c(file, this.f3641a));
    }
}
