package io.intercom.com.bumptech.glide;

import android.annotation.TargetApi;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.fragment.app.C0195j;
import androidx.fragment.app.Fragment;
import io.intercom.com.bumptech.glide.c.d;
import io.intercom.com.bumptech.glide.c.n;
import io.intercom.com.bumptech.glide.f.g;
import io.intercom.com.bumptech.glide.load.b.A;
import io.intercom.com.bumptech.glide.load.b.B;
import io.intercom.com.bumptech.glide.load.b.C;
import io.intercom.com.bumptech.glide.load.b.C0737a;
import io.intercom.com.bumptech.glide.load.b.C0739c;
import io.intercom.com.bumptech.glide.load.b.C0741e;
import io.intercom.com.bumptech.glide.load.b.D;
import io.intercom.com.bumptech.glide.load.b.E;
import io.intercom.com.bumptech.glide.load.b.a.a.C0107a;
import io.intercom.com.bumptech.glide.load.b.q;
import io.intercom.com.bumptech.glide.load.b.v;
import io.intercom.com.bumptech.glide.load.c.a.f;
import io.intercom.com.bumptech.glide.load.c.a.l;
import io.intercom.com.bumptech.glide.load.c.a.t;
import io.intercom.com.bumptech.glide.load.c.a.u;
import io.intercom.com.bumptech.glide.load.c.a.w;
import io.intercom.com.bumptech.glide.load.c.a.z;
import io.intercom.com.bumptech.glide.load.c.b.a.C0110a;
import io.intercom.com.bumptech.glide.load.c.e.h;
import io.intercom.com.bumptech.glide.load.c.e.j;
import io.intercom.com.bumptech.glide.load.engine.a.b;
import io.intercom.com.bumptech.glide.load.engine.a.e;
import io.intercom.com.bumptech.glide.load.engine.b.i;
import io.intercom.com.bumptech.glide.load.engine.d.a;
import io.intercom.com.bumptech.glide.load.engine.s;
import io.intercom.com.bumptech.glide.load.k;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TargetApi(14)
/* compiled from: Glide */
public class c implements ComponentCallbacks2 {

    /* renamed from: a reason: collision with root package name */
    private static volatile c f9209a;

    /* renamed from: b reason: collision with root package name */
    private static volatile boolean f9210b;

    /* renamed from: c reason: collision with root package name */
    private final s f9211c;

    /* renamed from: d reason: collision with root package name */
    private final e f9212d;

    /* renamed from: e reason: collision with root package name */
    private final i f9213e;

    /* renamed from: f reason: collision with root package name */
    private final a f9214f;

    /* renamed from: g reason: collision with root package name */
    private final e f9215g;

    /* renamed from: h reason: collision with root package name */
    private final Registry f9216h;

    /* renamed from: i reason: collision with root package name */
    private final b f9217i;

    /* renamed from: j reason: collision with root package name */
    private final n f9218j;

    /* renamed from: k reason: collision with root package name */
    private final d f9219k;

    /* renamed from: l reason: collision with root package name */
    private final List<n> f9220l = new ArrayList();
    private f m = f.NORMAL;

    @TargetApi(14)
    c(Context context, s sVar, i iVar, e eVar, b bVar, n nVar, d dVar, int i2, g gVar, Map<Class<?>, o<?, ?>> map) {
        Context context2 = context;
        i iVar2 = iVar;
        e eVar2 = eVar;
        b bVar2 = bVar;
        this.f9211c = sVar;
        this.f9212d = eVar2;
        this.f9217i = bVar2;
        this.f9213e = iVar2;
        this.f9218j = nVar;
        this.f9219k = dVar;
        this.f9214f = new a(iVar2, eVar2, (io.intercom.com.bumptech.glide.load.b) gVar.i().a(l.f9603a));
        Resources resources = context.getResources();
        this.f9216h = new Registry();
        this.f9216h.a((io.intercom.com.bumptech.glide.load.e) new io.intercom.com.bumptech.glide.load.c.a.i());
        l lVar = new l(this.f9216h.a(), resources.getDisplayMetrics(), eVar2, bVar2);
        io.intercom.com.bumptech.glide.load.c.e.a aVar = new io.intercom.com.bumptech.glide.load.c.e.a(context2, this.f9216h.a(), eVar2, bVar2);
        z zVar = new z(eVar2);
        f fVar = new f(lVar);
        u uVar = new u(lVar, bVar2);
        io.intercom.com.bumptech.glide.load.c.c.e eVar3 = new io.intercom.com.bumptech.glide.load.c.c.e(context2);
        io.intercom.com.bumptech.glide.load.b.z.b bVar3 = new io.intercom.com.bumptech.glide.load.b.z.b(resources);
        io.intercom.com.bumptech.glide.load.b.z.c cVar = new io.intercom.com.bumptech.glide.load.b.z.c(resources);
        io.intercom.com.bumptech.glide.load.b.z.a aVar2 = new io.intercom.com.bumptech.glide.load.b.z.a(resources);
        io.intercom.com.bumptech.glide.load.c.a.c cVar2 = new io.intercom.com.bumptech.glide.load.c.a.c();
        Registry registry = this.f9216h;
        registry.a(ByteBuffer.class, (io.intercom.com.bumptech.glide.load.d<Data>) new C0741e<Data>());
        registry.a(InputStream.class, (io.intercom.com.bumptech.glide.load.d<Data>) new A<Data>(bVar2));
        io.intercom.com.bumptech.glide.load.b.z.c cVar3 = cVar;
        String str = "Bitmap";
        registry.a(str, ByteBuffer.class, Bitmap.class, fVar);
        registry.a(str, InputStream.class, Bitmap.class, uVar);
        registry.a(str, ParcelFileDescriptor.class, Bitmap.class, zVar);
        io.intercom.com.bumptech.glide.load.b.z.a aVar3 = aVar2;
        registry.a(str, Bitmap.class, Bitmap.class, new w());
        registry.a(Bitmap.class, Bitmap.class, (v<Model, Data>) C.a.a());
        registry.a(Bitmap.class, (io.intercom.com.bumptech.glide.load.l<TResource>) cVar2);
        io.intercom.com.bumptech.glide.load.c.a.a aVar4 = new io.intercom.com.bumptech.glide.load.c.a.a(resources, fVar);
        String str2 = "BitmapDrawable";
        registry.a(str2, ByteBuffer.class, BitmapDrawable.class, aVar4);
        registry.a(str2, InputStream.class, BitmapDrawable.class, new io.intercom.com.bumptech.glide.load.c.a.a(resources, uVar));
        registry.a(str2, ParcelFileDescriptor.class, BitmapDrawable.class, new io.intercom.com.bumptech.glide.load.c.a.a(resources, zVar));
        registry.a(BitmapDrawable.class, (io.intercom.com.bumptech.glide.load.l<TResource>) new io.intercom.com.bumptech.glide.load.c.a.b<TResource>(eVar2, cVar2));
        String str3 = "Gif";
        registry.a(str3, InputStream.class, io.intercom.com.bumptech.glide.load.c.e.c.class, new j(this.f9216h.a(), aVar, bVar2));
        registry.a(str3, ByteBuffer.class, io.intercom.com.bumptech.glide.load.c.e.c.class, aVar);
        registry.a(io.intercom.com.bumptech.glide.load.c.e.c.class, (io.intercom.com.bumptech.glide.load.l<TResource>) new io.intercom.com.bumptech.glide.load.c.e.d<TResource>());
        registry.a(io.intercom.com.bumptech.glide.b.a.class, io.intercom.com.bumptech.glide.b.a.class, (v<Model, Data>) C.a.a());
        registry.a(str, io.intercom.com.bumptech.glide.b.a.class, Bitmap.class, new h(eVar2));
        registry.a(Uri.class, Drawable.class, (k<Data, TResource>) eVar3);
        registry.a(Uri.class, Bitmap.class, (k<Data, TResource>) new t<Data,TResource>(eVar3, eVar2));
        registry.a((io.intercom.com.bumptech.glide.load.a.c.a<?>) new C0110a<Object>());
        registry.a(File.class, ByteBuffer.class, (v<Model, Data>) new io.intercom.com.bumptech.glide.load.b.f.b<Model,Data>());
        registry.a(File.class, InputStream.class, (v<Model, Data>) new io.intercom.com.bumptech.glide.load.b.i.e<Model,Data>());
        registry.a(File.class, File.class, (k<Data, TResource>) new io.intercom.com.bumptech.glide.load.c.d.a<Data,TResource>());
        registry.a(File.class, ParcelFileDescriptor.class, (v<Model, Data>) new io.intercom.com.bumptech.glide.load.b.i.b<Model,Data>());
        registry.a(File.class, File.class, (v<Model, Data>) C.a.a());
        registry.a((io.intercom.com.bumptech.glide.load.a.c.a<?>) new io.intercom.com.bumptech.glide.load.a.j.a<Object>(bVar2));
        registry.a(Integer.TYPE, InputStream.class, (v<Model, Data>) bVar3);
        io.intercom.com.bumptech.glide.load.b.z.a aVar5 = aVar3;
        registry.a(Integer.TYPE, ParcelFileDescriptor.class, (v<Model, Data>) aVar5);
        registry.a(Integer.class, InputStream.class, (v<Model, Data>) bVar3);
        registry.a(Integer.class, ParcelFileDescriptor.class, (v<Model, Data>) aVar5);
        io.intercom.com.bumptech.glide.load.b.z.c cVar4 = cVar3;
        registry.a(Integer.class, Uri.class, (v<Model, Data>) cVar4);
        registry.a(Integer.TYPE, Uri.class, (v<Model, Data>) cVar4);
        registry.a(String.class, InputStream.class, (v<Model, Data>) new io.intercom.com.bumptech.glide.load.b.g.c<Model,Data>());
        registry.a(String.class, InputStream.class, (v<Model, Data>) new B.b<Model,Data>());
        registry.a(String.class, ParcelFileDescriptor.class, (v<Model, Data>) new B.a<Model,Data>());
        registry.a(Uri.class, InputStream.class, (v<Model, Data>) new io.intercom.com.bumptech.glide.load.b.a.b.a<Model,Data>());
        registry.a(Uri.class, InputStream.class, (v<Model, Data>) new io.intercom.com.bumptech.glide.load.b.C0737a.c<Model,Data>(context.getAssets()));
        registry.a(Uri.class, ParcelFileDescriptor.class, (v<Model, Data>) new C0737a.b<Model,Data>(context.getAssets()));
        Context context3 = context;
        registry.a(Uri.class, InputStream.class, (v<Model, Data>) new io.intercom.com.bumptech.glide.load.b.a.c.a<Model,Data>(context3));
        registry.a(Uri.class, InputStream.class, (v<Model, Data>) new io.intercom.com.bumptech.glide.load.b.a.d.a<Model,Data>(context3));
        registry.a(Uri.class, InputStream.class, (v<Model, Data>) new io.intercom.com.bumptech.glide.load.b.D.c<Model,Data>(context.getContentResolver()));
        registry.a(Uri.class, ParcelFileDescriptor.class, (v<Model, Data>) new D.a<Model,Data>(context.getContentResolver()));
        registry.a(Uri.class, InputStream.class, (v<Model, Data>) new E.a<Model,Data>());
        registry.a(URL.class, InputStream.class, (v<Model, Data>) new io.intercom.com.bumptech.glide.load.b.a.e.a<Model,Data>());
        registry.a(Uri.class, File.class, (v<Model, Data>) new q.a<Model,Data>(context3));
        registry.a(io.intercom.com.bumptech.glide.load.b.l.class, InputStream.class, (v<Model, Data>) new C0107a<Model,Data>());
        registry.a(byte[].class, ByteBuffer.class, (v<Model, Data>) new C0739c.a<Model,Data>());
        registry.a(byte[].class, InputStream.class, (v<Model, Data>) new C0739c.d<Model,Data>());
        registry.a(Uri.class, Uri.class, (v<Model, Data>) C.a.a());
        registry.a(Drawable.class, Drawable.class, (v<Model, Data>) C.a.a());
        registry.a(Drawable.class, Drawable.class, (k<Data, TResource>) new io.intercom.com.bumptech.glide.load.c.c.f<Data,TResource>());
        registry.a(Bitmap.class, BitmapDrawable.class, (io.intercom.com.bumptech.glide.load.c.f.d<TResource, Transcode>) new io.intercom.com.bumptech.glide.load.c.f.b<TResource,Transcode>(resources));
        registry.a(Bitmap.class, byte[].class, (io.intercom.com.bumptech.glide.load.c.f.d<TResource, Transcode>) new io.intercom.com.bumptech.glide.load.c.f.a<TResource,Transcode>());
        registry.a(io.intercom.com.bumptech.glide.load.c.e.c.class, byte[].class, (io.intercom.com.bumptech.glide.load.c.f.d<TResource, Transcode>) new io.intercom.com.bumptech.glide.load.c.f.c<TResource,Transcode>());
        e eVar4 = new e(context, bVar, this.f9216h, new io.intercom.com.bumptech.glide.f.a.e(), gVar, map, sVar, i2);
        this.f9215g = eVar4;
    }

    public static c a(Context context) {
        if (f9209a == null) {
            synchronized (c.class) {
                if (f9209a == null) {
                    c(context);
                }
            }
        }
        return f9209a;
    }

    private static void c(Context context) {
        if (!f9210b) {
            f9210b = true;
            e(context);
            f9210b = false;
            return;
        }
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    private static void e(Context context) {
        a(context, new d());
    }

    private static a i() {
        String str = "GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.";
        try {
            return (a) Class.forName("io.intercom.com.bumptech.glide.GeneratedAppGlideModuleImpl").newInstance();
        } catch (ClassNotFoundException unused) {
            String str2 = "Glide";
            if (Log.isLoggable(str2, 5)) {
                Log.w(str2, "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
            return null;
        } catch (InstantiationException e2) {
            throw new IllegalStateException(str, e2);
        } catch (IllegalAccessException e3) {
            throw new IllegalStateException(str, e3);
        }
    }

    public b b() {
        return this.f9217i;
    }

    /* access modifiers changed from: 0000 */
    public d d() {
        return this.f9219k;
    }

    /* access modifiers changed from: 0000 */
    public e f() {
        return this.f9215g;
    }

    public Registry g() {
        return this.f9216h;
    }

    public n h() {
        return this.f9218j;
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
        a();
    }

    public void onTrimMemory(int i2) {
        a(i2);
    }

    public static n b(Context context) {
        return d(context).a(context);
    }

    private static n d(Context context) {
        io.intercom.com.bumptech.glide.h.h.a(context, "You cannot start a load on a not yet attached View or a  Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return a(context).h();
    }

    public Context e() {
        return this.f9215g.getBaseContext();
    }

    /* access modifiers changed from: 0000 */
    public void b(n nVar) {
        synchronized (this.f9220l) {
            if (this.f9220l.contains(nVar)) {
                this.f9220l.remove(nVar);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }

    public e c() {
        return this.f9212d;
    }

    private static void a(Context context, d dVar) {
        Context applicationContext = context.getApplicationContext();
        a i2 = i();
        List<io.intercom.com.bumptech.glide.d.c> emptyList = Collections.emptyList();
        if (i2 == null || i2.a()) {
            emptyList = new io.intercom.com.bumptech.glide.d.e(applicationContext).a();
        }
        String str = "Glide";
        if (i2 != null && !i2.b().isEmpty()) {
            Set b2 = i2.b();
            Iterator it = emptyList.iterator();
            while (it.hasNext()) {
                io.intercom.com.bumptech.glide.d.c cVar = (io.intercom.com.bumptech.glide.d.c) it.next();
                if (b2.contains(cVar.getClass())) {
                    if (Log.isLoggable(str, 3)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("AppGlideModule excludes manifest GlideModule: ");
                        sb.append(cVar);
                        Log.d(str, sb.toString());
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable(str, 3)) {
            for (io.intercom.com.bumptech.glide.d.c cVar2 : emptyList) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Discovered GlideModule from manifest: ");
                sb2.append(cVar2.getClass());
                Log.d(str, sb2.toString());
            }
        }
        dVar.a(i2 != null ? i2.c() : null);
        for (io.intercom.com.bumptech.glide.d.c a2 : emptyList) {
            a2.a(applicationContext, dVar);
        }
        if (i2 != null) {
            i2.a(applicationContext, dVar);
        }
        c a3 = dVar.a(applicationContext);
        for (io.intercom.com.bumptech.glide.d.c a4 : emptyList) {
            a4.a(applicationContext, a3, a3.f9216h);
        }
        if (i2 != null) {
            i2.a(applicationContext, a3, a3.f9216h);
        }
        applicationContext.registerComponentCallbacks(a3);
        f9209a = a3;
    }

    public void a() {
        io.intercom.com.bumptech.glide.h.j.b();
        this.f9213e.a();
        this.f9212d.a();
        this.f9217i.a();
    }

    public void a(int i2) {
        io.intercom.com.bumptech.glide.h.j.b();
        this.f9213e.a(i2);
        this.f9212d.a(i2);
        this.f9217i.a(i2);
    }

    public static n a(C0195j jVar) {
        return d(jVar).a(jVar);
    }

    public static n a(Fragment fragment) {
        return d(fragment.getActivity()).a(fragment);
    }

    /* access modifiers changed from: 0000 */
    public boolean a(io.intercom.com.bumptech.glide.f.a.h<?> hVar) {
        synchronized (this.f9220l) {
            for (n b2 : this.f9220l) {
                if (b2.b(hVar)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(n nVar) {
        synchronized (this.f9220l) {
            if (!this.f9220l.contains(nVar)) {
                this.f9220l.add(nVar);
            } else {
                throw new IllegalStateException("Cannot register already registered manager");
            }
        }
    }
}
