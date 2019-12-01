package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import com.bumptech.glide.c.d;
import com.bumptech.glide.c.n;
import com.bumptech.glide.f.f;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.b.B;
import com.bumptech.glide.load.b.C;
import com.bumptech.glide.load.b.C0281a;
import com.bumptech.glide.load.b.C0283c;
import com.bumptech.glide.load.b.C0285e;
import com.bumptech.glide.load.b.D;
import com.bumptech.glide.load.b.E;
import com.bumptech.glide.load.b.a.a.C0051a;
import com.bumptech.glide.load.b.g;
import com.bumptech.glide.load.b.q;
import com.bumptech.glide.load.b.z;
import com.bumptech.glide.load.b.z.c;
import com.bumptech.glide.load.c.a.A;
import com.bumptech.glide.load.c.a.C0286a;
import com.bumptech.glide.load.c.a.l;
import com.bumptech.glide.load.c.a.p;
import com.bumptech.glide.load.c.a.v;
import com.bumptech.glide.load.c.a.x;
import com.bumptech.glide.load.c.b.a.C0054a;
import com.bumptech.glide.load.c.e.h;
import com.bumptech.glide.load.engine.a.b;
import com.bumptech.glide.load.engine.b.i;
import com.bumptech.glide.load.engine.d.a;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.k;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: Glide */
public class e implements ComponentCallbacks2 {

    /* renamed from: a reason: collision with root package name */
    private static volatile e f3389a;

    /* renamed from: b reason: collision with root package name */
    private static volatile boolean f3390b;

    /* renamed from: c reason: collision with root package name */
    private final u f3391c;

    /* renamed from: d reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.e f3392d;

    /* renamed from: e reason: collision with root package name */
    private final i f3393e;

    /* renamed from: f reason: collision with root package name */
    private final a f3394f;

    /* renamed from: g reason: collision with root package name */
    private final g f3395g;

    /* renamed from: h reason: collision with root package name */
    private final Registry f3396h;

    /* renamed from: i reason: collision with root package name */
    private final b f3397i;

    /* renamed from: j reason: collision with root package name */
    private final n f3398j;

    /* renamed from: k reason: collision with root package name */
    private final d f3399k;

    /* renamed from: l reason: collision with root package name */
    private final List<n> f3400l = new ArrayList();
    private h m = h.NORMAL;

    e(Context context, u uVar, i iVar, com.bumptech.glide.load.engine.a.e eVar, b bVar, n nVar, d dVar, int i2, f fVar, Map<Class<?>, o<?, ?>> map, List<com.bumptech.glide.f.e<Object>> list, boolean z) {
        Context context2 = context;
        i iVar2 = iVar;
        com.bumptech.glide.load.engine.a.e eVar2 = eVar;
        b bVar2 = bVar;
        this.f3391c = uVar;
        this.f3392d = eVar2;
        this.f3397i = bVar2;
        this.f3393e = iVar2;
        this.f3398j = nVar;
        this.f3399k = dVar;
        this.f3394f = new a(iVar2, eVar2, (com.bumptech.glide.load.b) fVar.h().a(l.f3744a));
        Resources resources = context.getResources();
        this.f3396h = new Registry();
        this.f3396h.a((ImageHeaderParser) new com.bumptech.glide.load.c.a.i());
        if (VERSION.SDK_INT >= 27) {
            this.f3396h.a((ImageHeaderParser) new p());
        }
        List a2 = this.f3396h.a();
        l lVar = new l(a2, resources.getDisplayMetrics(), eVar2, bVar2);
        com.bumptech.glide.load.c.e.a aVar = new com.bumptech.glide.load.c.e.a(context2, a2, eVar2, bVar2);
        j b2 = A.b(eVar);
        com.bumptech.glide.load.c.a.f fVar2 = new com.bumptech.glide.load.c.a.f(lVar);
        v vVar = new v(lVar, bVar2);
        com.bumptech.glide.load.c.c.d dVar2 = new com.bumptech.glide.load.c.c.d(context2);
        c cVar = new c(resources);
        z.d dVar3 = new z.d(resources);
        z.b bVar3 = new z.b(resources);
        z.a aVar2 = new z.a(resources);
        com.bumptech.glide.load.c.a.c cVar2 = new com.bumptech.glide.load.c.a.c(bVar2);
        com.bumptech.glide.load.c.f.a aVar3 = new com.bumptech.glide.load.c.f.a();
        com.bumptech.glide.load.c.f.d dVar4 = new com.bumptech.glide.load.c.f.d();
        ContentResolver contentResolver = context.getContentResolver();
        Registry registry = this.f3396h;
        z.a aVar4 = aVar2;
        registry.a(ByteBuffer.class, (com.bumptech.glide.load.d<Data>) new C0285e<Data>());
        registry.a(InputStream.class, (com.bumptech.glide.load.d<Data>) new com.bumptech.glide.load.b.A<Data>(bVar2));
        z.d dVar5 = dVar3;
        String str = "Bitmap";
        registry.a(str, ByteBuffer.class, Bitmap.class, fVar2);
        registry.a(str, InputStream.class, Bitmap.class, vVar);
        registry.a(str, ParcelFileDescriptor.class, Bitmap.class, b2);
        z.b bVar4 = bVar3;
        registry.a(str, AssetFileDescriptor.class, Bitmap.class, A.a(eVar));
        registry.a(Bitmap.class, Bitmap.class, (com.bumptech.glide.load.b.v<Model, Data>) C.a.b());
        registry.a(str, Bitmap.class, Bitmap.class, new x());
        registry.a(Bitmap.class, (k<TResource>) cVar2);
        C0286a aVar5 = new C0286a(resources, fVar2);
        String str2 = "BitmapDrawable";
        registry.a(str2, ByteBuffer.class, BitmapDrawable.class, aVar5);
        registry.a(str2, InputStream.class, BitmapDrawable.class, new C0286a(resources, vVar));
        registry.a(str2, ParcelFileDescriptor.class, BitmapDrawable.class, new C0286a(resources, b2));
        registry.a(BitmapDrawable.class, (k<TResource>) new com.bumptech.glide.load.c.a.b<TResource>(eVar2, cVar2));
        com.bumptech.glide.load.c.e.j jVar = new com.bumptech.glide.load.c.e.j(a2, aVar, bVar2);
        String str3 = "Gif";
        registry.a(str3, InputStream.class, com.bumptech.glide.load.c.e.c.class, jVar);
        registry.a(str3, ByteBuffer.class, com.bumptech.glide.load.c.e.c.class, aVar);
        registry.a(com.bumptech.glide.load.c.e.c.class, (k<TResource>) new com.bumptech.glide.load.c.e.d<TResource>());
        registry.a(com.bumptech.glide.b.a.class, com.bumptech.glide.b.a.class, (com.bumptech.glide.load.b.v<Model, Data>) C.a.b());
        registry.a(str, com.bumptech.glide.b.a.class, Bitmap.class, new h(eVar2));
        registry.a(Uri.class, Drawable.class, (j<Data, TResource>) dVar2);
        registry.a(Uri.class, Bitmap.class, (j<Data, TResource>) new com.bumptech.glide.load.c.a.u<Data,TResource>(dVar2, eVar2));
        registry.a((com.bumptech.glide.load.a.e.a<?>) new C0054a<Object>());
        registry.a(File.class, ByteBuffer.class, (com.bumptech.glide.load.b.v<Model, Data>) new com.bumptech.glide.load.b.f.b<Model,Data>());
        registry.a(File.class, InputStream.class, (com.bumptech.glide.load.b.v<Model, Data>) new com.bumptech.glide.load.b.i.e<Model,Data>());
        registry.a(File.class, File.class, (j<Data, TResource>) new com.bumptech.glide.load.c.d.a<Data,TResource>());
        registry.a(File.class, ParcelFileDescriptor.class, (com.bumptech.glide.load.b.v<Model, Data>) new com.bumptech.glide.load.b.i.b<Model,Data>());
        registry.a(File.class, File.class, (com.bumptech.glide.load.b.v<Model, Data>) C.a.b());
        registry.a((com.bumptech.glide.load.a.e.a<?>) new com.bumptech.glide.load.a.l.a<Object>(bVar2));
        registry.a(Integer.TYPE, InputStream.class, (com.bumptech.glide.load.b.v<Model, Data>) cVar);
        z.b bVar5 = bVar4;
        registry.a(Integer.TYPE, ParcelFileDescriptor.class, (com.bumptech.glide.load.b.v<Model, Data>) bVar5);
        registry.a(Integer.class, InputStream.class, (com.bumptech.glide.load.b.v<Model, Data>) cVar);
        registry.a(Integer.class, ParcelFileDescriptor.class, (com.bumptech.glide.load.b.v<Model, Data>) bVar5);
        z.d dVar6 = dVar5;
        registry.a(Integer.class, Uri.class, (com.bumptech.glide.load.b.v<Model, Data>) dVar6);
        z.a aVar6 = aVar4;
        registry.a(Integer.TYPE, AssetFileDescriptor.class, (com.bumptech.glide.load.b.v<Model, Data>) aVar6);
        registry.a(Integer.class, AssetFileDescriptor.class, (com.bumptech.glide.load.b.v<Model, Data>) aVar6);
        registry.a(Integer.TYPE, Uri.class, (com.bumptech.glide.load.b.v<Model, Data>) dVar6);
        registry.a(String.class, InputStream.class, (com.bumptech.glide.load.b.v<Model, Data>) new g.c<Model,Data>());
        registry.a(Uri.class, InputStream.class, (com.bumptech.glide.load.b.v<Model, Data>) new g.c<Model,Data>());
        registry.a(String.class, InputStream.class, (com.bumptech.glide.load.b.v<Model, Data>) new B.c<Model,Data>());
        registry.a(String.class, ParcelFileDescriptor.class, (com.bumptech.glide.load.b.v<Model, Data>) new B.b<Model,Data>());
        registry.a(String.class, AssetFileDescriptor.class, (com.bumptech.glide.load.b.v<Model, Data>) new B.a<Model,Data>());
        registry.a(Uri.class, InputStream.class, (com.bumptech.glide.load.b.v<Model, Data>) new com.bumptech.glide.load.b.a.b.a<Model,Data>());
        registry.a(Uri.class, InputStream.class, (com.bumptech.glide.load.b.v<Model, Data>) new C0281a.c<Model,Data>(context.getAssets()));
        registry.a(Uri.class, ParcelFileDescriptor.class, (com.bumptech.glide.load.b.v<Model, Data>) new C0281a.b<Model,Data>(context.getAssets()));
        Context context3 = context;
        com.bumptech.glide.load.c.f.a aVar7 = aVar3;
        registry.a(Uri.class, InputStream.class, (com.bumptech.glide.load.b.v<Model, Data>) new com.bumptech.glide.load.b.a.c.a<Model,Data>(context3));
        registry.a(Uri.class, InputStream.class, (com.bumptech.glide.load.b.v<Model, Data>) new com.bumptech.glide.load.b.a.d.a<Model,Data>(context3));
        ContentResolver contentResolver2 = contentResolver;
        registry.a(Uri.class, InputStream.class, (com.bumptech.glide.load.b.v<Model, Data>) new D.d<Model,Data>(contentResolver2));
        registry.a(Uri.class, ParcelFileDescriptor.class, (com.bumptech.glide.load.b.v<Model, Data>) new D.b<Model,Data>(contentResolver2));
        registry.a(Uri.class, AssetFileDescriptor.class, (com.bumptech.glide.load.b.v<Model, Data>) new D.a<Model,Data>(contentResolver2));
        registry.a(Uri.class, InputStream.class, (com.bumptech.glide.load.b.v<Model, Data>) new E.a<Model,Data>());
        registry.a(URL.class, InputStream.class, (com.bumptech.glide.load.b.v<Model, Data>) new com.bumptech.glide.load.b.a.e.a<Model,Data>());
        registry.a(Uri.class, File.class, (com.bumptech.glide.load.b.v<Model, Data>) new q.a<Model,Data>(context3));
        registry.a(com.bumptech.glide.load.b.l.class, InputStream.class, (com.bumptech.glide.load.b.v<Model, Data>) new C0051a<Model,Data>());
        registry.a(byte[].class, ByteBuffer.class, (com.bumptech.glide.load.b.v<Model, Data>) new C0283c.a<Model,Data>());
        registry.a(byte[].class, InputStream.class, (com.bumptech.glide.load.b.v<Model, Data>) new C0283c.d<Model,Data>());
        registry.a(Uri.class, Uri.class, (com.bumptech.glide.load.b.v<Model, Data>) C.a.b());
        registry.a(Drawable.class, Drawable.class, (com.bumptech.glide.load.b.v<Model, Data>) C.a.b());
        registry.a(Drawable.class, Drawable.class, (j<Data, TResource>) new com.bumptech.glide.load.c.c.e<Data,TResource>());
        registry.a(Bitmap.class, BitmapDrawable.class, (com.bumptech.glide.load.c.f.e<TResource, Transcode>) new com.bumptech.glide.load.c.f.b<TResource,Transcode>(resources));
        registry.a(Bitmap.class, byte[].class, (com.bumptech.glide.load.c.f.e<TResource, Transcode>) aVar7);
        com.bumptech.glide.load.c.f.d dVar7 = dVar4;
        registry.a(Drawable.class, byte[].class, (com.bumptech.glide.load.c.f.e<TResource, Transcode>) new com.bumptech.glide.load.c.f.c<TResource,Transcode>(eVar2, aVar7, dVar7));
        registry.a(com.bumptech.glide.load.c.e.c.class, byte[].class, (com.bumptech.glide.load.c.f.e<TResource, Transcode>) dVar7);
        g gVar = new g(context, bVar, this.f3396h, new com.bumptech.glide.f.a.e(), fVar, map, list, uVar, z, i2);
        this.f3395g = gVar;
    }

    public static e a(Context context) {
        if (f3389a == null) {
            synchronized (e.class) {
                if (f3389a == null) {
                    c(context);
                }
            }
        }
        return f3389a;
    }

    private static void c(Context context) {
        if (!f3390b) {
            f3390b = true;
            e(context);
            f3390b = false;
            return;
        }
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    private static void e(Context context) {
        a(context, new f());
    }

    private static a i() {
        try {
            return (a) Class.forName("com.bumptech.glide.b").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException unused) {
            String str = "Glide";
            if (Log.isLoggable(str, 5)) {
                Log.w(str, "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
            return null;
        } catch (InstantiationException e2) {
            a((Exception) e2);
            throw null;
        } catch (IllegalAccessException e3) {
            a((Exception) e3);
            throw null;
        } catch (NoSuchMethodException e4) {
            a((Exception) e4);
            throw null;
        } catch (InvocationTargetException e5) {
            a((Exception) e5);
            throw null;
        }
    }

    public b b() {
        return this.f3397i;
    }

    /* access modifiers changed from: 0000 */
    public d d() {
        return this.f3399k;
    }

    /* access modifiers changed from: 0000 */
    public g f() {
        return this.f3395g;
    }

    public Registry g() {
        return this.f3396h;
    }

    public n h() {
        return this.f3398j;
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
        com.bumptech.glide.h.l.a(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return a(context).h();
    }

    public Context e() {
        return this.f3395g.getBaseContext();
    }

    /* access modifiers changed from: 0000 */
    public void b(n nVar) {
        synchronized (this.f3400l) {
            if (this.f3400l.contains(nVar)) {
                this.f3400l.remove(nVar);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }

    public com.bumptech.glide.load.engine.a.e c() {
        return this.f3392d;
    }

    private static void a(Context context, f fVar) {
        Context applicationContext = context.getApplicationContext();
        a i2 = i();
        List<com.bumptech.glide.d.c> emptyList = Collections.emptyList();
        if (i2 == null || i2.a()) {
            emptyList = new com.bumptech.glide.d.e(applicationContext).a();
        }
        String str = "Glide";
        if (i2 != null && !i2.b().isEmpty()) {
            Set b2 = i2.b();
            Iterator it = emptyList.iterator();
            while (it.hasNext()) {
                com.bumptech.glide.d.c cVar = (com.bumptech.glide.d.c) it.next();
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
            for (com.bumptech.glide.d.c cVar2 : emptyList) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Discovered GlideModule from manifest: ");
                sb2.append(cVar2.getClass());
                Log.d(str, sb2.toString());
            }
        }
        fVar.a(i2 != null ? i2.c() : null);
        for (com.bumptech.glide.d.c a2 : emptyList) {
            a2.a(applicationContext, fVar);
        }
        if (i2 != null) {
            i2.a(applicationContext, fVar);
        }
        e a3 = fVar.a(applicationContext);
        for (com.bumptech.glide.d.c a4 : emptyList) {
            a4.a(applicationContext, a3, a3.f3396h);
        }
        if (i2 != null) {
            i2.a(applicationContext, a3, a3.f3396h);
        }
        applicationContext.registerComponentCallbacks(a3);
        f3389a = a3;
    }

    private static void a(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    public void a() {
        com.bumptech.glide.h.n.a();
        this.f3393e.a();
        this.f3392d.a();
        this.f3397i.a();
    }

    public void a(int i2) {
        com.bumptech.glide.h.n.a();
        this.f3393e.a(i2);
        this.f3392d.a(i2);
        this.f3397i.a(i2);
    }

    public static n a(View view) {
        return d(view.getContext()).a(view);
    }

    /* access modifiers changed from: 0000 */
    public boolean a(com.bumptech.glide.f.a.h<?> hVar) {
        synchronized (this.f3400l) {
            for (n b2 : this.f3400l) {
                if (b2.b(hVar)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(n nVar) {
        synchronized (this.f3400l) {
            if (!this.f3400l.contains(nVar)) {
                this.f3400l.add(nVar);
            } else {
                throw new IllegalStateException("Cannot register already registered manager");
            }
        }
    }
}
