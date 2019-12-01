package com.bumptech.glide.load.b;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.i;
import java.io.InputStream;

/* compiled from: ResourceLoader */
public class z<Data> implements u<Integer, Data> {

    /* renamed from: a reason: collision with root package name */
    private final u<Uri, Data> f3699a;

    /* renamed from: b reason: collision with root package name */
    private final Resources f3700b;

    /* compiled from: ResourceLoader */
    public static final class a implements v<Integer, AssetFileDescriptor> {

        /* renamed from: a reason: collision with root package name */
        private final Resources f3701a;

        public a(Resources resources) {
            this.f3701a = resources;
        }

        public u<Integer, AssetFileDescriptor> a(y yVar) {
            return new z(this.f3701a, yVar.a(Uri.class, AssetFileDescriptor.class));
        }

        public void a() {
        }
    }

    /* compiled from: ResourceLoader */
    public static class b implements v<Integer, ParcelFileDescriptor> {

        /* renamed from: a reason: collision with root package name */
        private final Resources f3702a;

        public b(Resources resources) {
            this.f3702a = resources;
        }

        public u<Integer, ParcelFileDescriptor> a(y yVar) {
            return new z(this.f3702a, yVar.a(Uri.class, ParcelFileDescriptor.class));
        }

        public void a() {
        }
    }

    /* compiled from: ResourceLoader */
    public static class c implements v<Integer, InputStream> {

        /* renamed from: a reason: collision with root package name */
        private final Resources f3703a;

        public c(Resources resources) {
            this.f3703a = resources;
        }

        public u<Integer, InputStream> a(y yVar) {
            return new z(this.f3703a, yVar.a(Uri.class, InputStream.class));
        }

        public void a() {
        }
    }

    /* compiled from: ResourceLoader */
    public static class d implements v<Integer, Uri> {

        /* renamed from: a reason: collision with root package name */
        private final Resources f3704a;

        public d(Resources resources) {
            this.f3704a = resources;
        }

        public u<Integer, Uri> a(y yVar) {
            return new z(this.f3704a, C.a());
        }

        public void a() {
        }
    }

    public z(Resources resources, u<Uri, Data> uVar) {
        this.f3700b = resources;
        this.f3699a = uVar;
    }

    private Uri b(Integer num) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("android.resource://");
            sb.append(this.f3700b.getResourcePackageName(num.intValue()));
            sb.append('/');
            sb.append(this.f3700b.getResourceTypeName(num.intValue()));
            sb.append('/');
            sb.append(this.f3700b.getResourceEntryName(num.intValue()));
            return Uri.parse(sb.toString());
        } catch (NotFoundException e2) {
            String str = "ResourceLoader";
            if (Log.isLoggable(str, 5)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Received invalid resource id: ");
                sb2.append(num);
                Log.w(str, sb2.toString(), e2);
            }
            return null;
        }
    }

    public boolean a(Integer num) {
        return true;
    }

    public com.bumptech.glide.load.b.u.a<Data> a(Integer num, int i2, int i3, i iVar) {
        Uri b2 = b(num);
        if (b2 == null) {
            return null;
        }
        return this.f3699a.a(b2, i2, i3, iVar);
    }
}
