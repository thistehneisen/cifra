package io.intercom.com.bumptech.glide.load.b;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import io.intercom.com.bumptech.glide.load.j;
import java.io.InputStream;

/* compiled from: ResourceLoader */
public class z<Data> implements u<Integer, Data> {

    /* renamed from: a reason: collision with root package name */
    private final u<Uri, Data> f9568a;

    /* renamed from: b reason: collision with root package name */
    private final Resources f9569b;

    /* compiled from: ResourceLoader */
    public static class a implements v<Integer, ParcelFileDescriptor> {

        /* renamed from: a reason: collision with root package name */
        private final Resources f9570a;

        public a(Resources resources) {
            this.f9570a = resources;
        }

        public u<Integer, ParcelFileDescriptor> a(y yVar) {
            return new z(this.f9570a, yVar.a(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* compiled from: ResourceLoader */
    public static class b implements v<Integer, InputStream> {

        /* renamed from: a reason: collision with root package name */
        private final Resources f9571a;

        public b(Resources resources) {
            this.f9571a = resources;
        }

        public u<Integer, InputStream> a(y yVar) {
            return new z(this.f9571a, yVar.a(Uri.class, InputStream.class));
        }
    }

    /* compiled from: ResourceLoader */
    public static class c implements v<Integer, Uri> {

        /* renamed from: a reason: collision with root package name */
        private final Resources f9572a;

        public c(Resources resources) {
            this.f9572a = resources;
        }

        public u<Integer, Uri> a(y yVar) {
            return new z(this.f9572a, C.a());
        }
    }

    public z(Resources resources, u<Uri, Data> uVar) {
        this.f9569b = resources;
        this.f9568a = uVar;
    }

    private Uri b(Integer num) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("android.resource://");
            sb.append(this.f9569b.getResourcePackageName(num.intValue()));
            sb.append('/');
            sb.append(this.f9569b.getResourceTypeName(num.intValue()));
            sb.append('/');
            sb.append(this.f9569b.getResourceEntryName(num.intValue()));
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

    public io.intercom.com.bumptech.glide.load.b.u.a<Data> a(Integer num, int i2, int i3, j jVar) {
        Uri b2 = b(num);
        if (b2 == null) {
            return null;
        }
        return this.f9568a.a(b2, i2, i3, jVar);
    }
}
