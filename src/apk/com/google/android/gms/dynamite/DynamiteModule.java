package com.google.android.gms.dynamite;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.appsflyer.share.Constants;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.util.f;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public final class DynamiteModule {

    /* renamed from: a reason: collision with root package name */
    private static Boolean f4819a = null;

    /* renamed from: b reason: collision with root package name */
    private static i f4820b = null;

    /* renamed from: c reason: collision with root package name */
    private static k f4821c = null;

    /* renamed from: d reason: collision with root package name */
    private static String f4822d = null;

    /* renamed from: e reason: collision with root package name */
    private static int f4823e = -1;

    /* renamed from: f reason: collision with root package name */
    private static final ThreadLocal<b> f4824f = new ThreadLocal<>();

    /* renamed from: g reason: collision with root package name */
    private static final C0068a f4825g = new a();

    /* renamed from: h reason: collision with root package name */
    public static final a f4826h = new b();

    /* renamed from: i reason: collision with root package name */
    public static final a f4827i = new c();

    /* renamed from: j reason: collision with root package name */
    public static final a f4828j = new d();

    /* renamed from: k reason: collision with root package name */
    public static final a f4829k = new e();

    /* renamed from: l reason: collision with root package name */
    public static final a f4830l = new f();
    private static final a m = new g();
    private final Context n;

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    public static class LoadingException extends Exception {
        private LoadingException(String str) {
            super(str);
        }

        private LoadingException(String str, Throwable th) {
            super(str, th);
        }

        /* synthetic */ LoadingException(String str, a aVar) {
            this(str);
        }

        /* synthetic */ LoadingException(String str, Throwable th, a aVar) {
            this(str, th);
        }
    }

    public interface a {

        /* renamed from: com.google.android.gms.dynamite.DynamiteModule$a$a reason: collision with other inner class name */
        public interface C0068a {
            int a(Context context, String str);

            int a(Context context, String str, boolean z) throws LoadingException;
        }

        public static class b {

            /* renamed from: a reason: collision with root package name */
            public int f4831a = 0;

            /* renamed from: b reason: collision with root package name */
            public int f4832b = 0;

            /* renamed from: c reason: collision with root package name */
            public int f4833c = 0;
        }

        b a(Context context, String str, C0068a aVar) throws LoadingException;
    }

    private static class b {

        /* renamed from: a reason: collision with root package name */
        public Cursor f4834a;

        private b() {
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    private static class c implements C0068a {

        /* renamed from: a reason: collision with root package name */
        private final int f4835a;

        /* renamed from: b reason: collision with root package name */
        private final int f4836b = 0;

        public c(int i2, int i3) {
            this.f4835a = i2;
        }

        public final int a(Context context, String str) {
            return this.f4835a;
        }

        public final int a(Context context, String str, boolean z) {
            return 0;
        }
    }

    private DynamiteModule(Context context) {
        q.a(context);
        this.n = context;
    }

    public static DynamiteModule a(Context context, a aVar, String str) throws LoadingException {
        b a2;
        String str2 = ":";
        String str3 = "DynamiteModule";
        b bVar = (b) f4824f.get();
        b bVar2 = new b(null);
        f4824f.set(bVar2);
        try {
            a2 = aVar.a(context, str, f4825g);
            int i2 = a2.f4831a;
            int i3 = a2.f4832b;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str).length());
            sb.append("Considering local module ");
            sb.append(str);
            sb.append(str2);
            sb.append(i2);
            sb.append(" and remote module ");
            sb.append(str);
            sb.append(str2);
            sb.append(i3);
            Log.i(str3, sb.toString());
            if (a2.f4833c == 0 || ((a2.f4833c == -1 && a2.f4831a == 0) || (a2.f4833c == 1 && a2.f4832b == 0))) {
                int i4 = a2.f4831a;
                int i5 = a2.f4832b;
                StringBuilder sb2 = new StringBuilder(91);
                sb2.append("No acceptable module found. Local version is ");
                sb2.append(i4);
                sb2.append(" and remote version is ");
                sb2.append(i5);
                sb2.append(".");
                throw new LoadingException(sb2.toString(), (a) null);
            } else if (a2.f4833c == -1) {
                DynamiteModule c2 = c(context, str);
                Cursor cursor = bVar2.f4834a;
                if (cursor != null) {
                    cursor.close();
                }
                f4824f.set(bVar);
                return c2;
            } else if (a2.f4833c == 1) {
                DynamiteModule a3 = a(context, str, a2.f4832b);
                Cursor cursor2 = bVar2.f4834a;
                if (cursor2 != null) {
                    cursor2.close();
                }
                f4824f.set(bVar);
                return a3;
            } else {
                int i6 = a2.f4833c;
                StringBuilder sb3 = new StringBuilder(47);
                sb3.append("VersionPolicy returned invalid code:");
                sb3.append(i6);
                throw new LoadingException(sb3.toString(), (a) null);
            }
        } catch (LoadingException e2) {
            String str4 = "Failed to load remote module: ";
            String valueOf = String.valueOf(e2.getMessage());
            Log.w(str3, valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4));
            if (a2.f4831a == 0 || aVar.a(context, str, new c(a2.f4831a, 0)).f4833c != -1) {
                throw new LoadingException("Remote load failed. No local fallback found.", e2, null);
            }
            DynamiteModule c3 = c(context, str);
            Cursor cursor3 = bVar2.f4834a;
            if (cursor3 != null) {
                cursor3.close();
            }
            f4824f.set(bVar);
            return c3;
        } catch (Throwable th) {
            Cursor cursor4 = bVar2.f4834a;
            if (cursor4 != null) {
                cursor4.close();
            }
            f4824f.set(bVar);
            throw th;
        }
    }

    private static int b(Context context, String str, boolean z) {
        String str2 = "DynamiteModule";
        i a2 = a(context);
        if (a2 == null) {
            return 0;
        }
        try {
            if (a2.g() >= 2) {
                return a2.a(com.google.android.gms.dynamic.b.a(context), str, z);
            }
            Log.w(str2, "IDynamite loader version < 2, falling back to getModuleVersion2");
            return a2.b(com.google.android.gms.dynamic.b.a(context), str, z);
        } catch (RemoteException e2) {
            String str3 = "Failed to retrieve remote module version: ";
            String valueOf = String.valueOf(e2.getMessage());
            Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b0  */
    private static int c(Context context, String str, boolean z) throws LoadingException {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            ContentResolver contentResolver = context.getContentResolver();
            String str2 = z ? "api_force_staging" : "api";
            StringBuilder sb = new StringBuilder(str2.length() + 42 + String.valueOf(str).length());
            sb.append("content://com.google.android.gms.chimera/");
            sb.append(str2);
            sb.append(Constants.URL_PATH_DELIMITER);
            sb.append(str);
            Cursor query = contentResolver.query(Uri.parse(sb.toString()), null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        int i2 = query.getInt(0);
                        if (i2 > 0) {
                            synchronized (DynamiteModule.class) {
                                f4822d = query.getString(2);
                                int columnIndex = query.getColumnIndex("loaderVersion");
                                if (columnIndex >= 0) {
                                    f4823e = query.getInt(columnIndex);
                                }
                            }
                            b bVar = (b) f4824f.get();
                            if (bVar != null && bVar.f4834a == null) {
                                bVar.f4834a = query;
                                query = null;
                            }
                        }
                        if (query != null) {
                            query.close();
                        }
                        return i2;
                    }
                } catch (Exception e2) {
                    Throwable th = e2;
                    cursor = query;
                    e = th;
                } catch (Throwable th2) {
                    cursor2 = query;
                    th = th2;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
            Log.w("DynamiteModule", "Failed to retrieve remote module version.");
            throw new LoadingException("Failed to connect to dynamite module ContentResolver.", (a) null);
        } catch (Exception e3) {
            e = e3;
            cursor = null;
            try {
                if (e instanceof LoadingException) {
                    throw e;
                }
                throw new LoadingException("V2 version check failed", e, null);
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
                if (cursor2 != null) {
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    public static int b(Context context, String str) {
        return a(context, str, false);
    }

    private static DynamiteModule b(Context context, String str, int i2) throws LoadingException, RemoteException {
        k kVar;
        com.google.android.gms.dynamic.a aVar;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
        sb.append("Selected remote version of ");
        sb.append(str);
        sb.append(", version >= ");
        sb.append(i2);
        Log.i("DynamiteModule", sb.toString());
        synchronized (DynamiteModule.class) {
            kVar = f4821c;
        }
        if (kVar != null) {
            b bVar = (b) f4824f.get();
            if (bVar == null || bVar.f4834a == null) {
                throw new LoadingException("No result cursor", (a) null);
            }
            Context applicationContext = context.getApplicationContext();
            Cursor cursor = bVar.f4834a;
            com.google.android.gms.dynamic.b.a(null);
            if (a().booleanValue()) {
                Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                aVar = kVar.b(com.google.android.gms.dynamic.b.a(applicationContext), str, i2, com.google.android.gms.dynamic.b.a(cursor));
            } else {
                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                aVar = kVar.a(com.google.android.gms.dynamic.b.a(applicationContext), str, i2, com.google.android.gms.dynamic.b.a(cursor));
            }
            Context context2 = (Context) com.google.android.gms.dynamic.b.a(aVar);
            if (context2 != null) {
                return new DynamiteModule(context2);
            }
            throw new LoadingException("Failed to get module context", (a) null);
        }
        throw new LoadingException("DynamiteLoaderV2 was not cached.", (a) null);
    }

    private static DynamiteModule c(Context context, String str) {
        String valueOf = String.valueOf(str);
        String str2 = "Selected local version of ";
        Log.i("DynamiteModule", valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        return new DynamiteModule(context.getApplicationContext());
    }

    public static int a(Context context, String str) {
        String str2 = "DynamiteModule";
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".ModuleDescriptor");
            Class loadClass = classLoader.loadClass(sb.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get(null).equals(str)) {
                return declaredField2.getInt(null);
            }
            String valueOf = String.valueOf(declaredField.get(null));
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 51 + String.valueOf(str).length());
            sb2.append("Module descriptor id '");
            sb2.append(valueOf);
            sb2.append("' didn't match expected id '");
            sb2.append(str);
            sb2.append("'");
            Log.e(str2, sb2.toString());
            return 0;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w(str2, sb3.toString());
            return 0;
        } catch (Exception e2) {
            String str3 = "Failed to load module descriptor class: ";
            String valueOf2 = String.valueOf(e2.getMessage());
            Log.e(str2, valueOf2.length() != 0 ? str3.concat(valueOf2) : new String(str3));
            return 0;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:16|17|18|19) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:40|41|42|43|52|53|54|55|(0)(0)) */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r2.set(null, java.lang.ClassLoader.getSystemClassLoader());
        r2 = java.lang.Boolean.FALSE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0088, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0035 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x007e */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c1 A[SYNTHETIC, Splitter:B:57:0x00c1] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00e8 A[Catch:{ LoadingException -> 0x00c6, Throwable -> 0x00f0 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x0052=Splitter:B:23:0x0052, B:18:0x0035=Splitter:B:18:0x0035, B:35:0x007b=Splitter:B:35:0x007b} */
    public static int a(Context context, String str, boolean z) {
        Boolean bool;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool2 = f4819a;
                if (bool2 == null) {
                    try {
                        Class loadClass = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName());
                        Field declaredField = loadClass.getDeclaredField("sClassLoader");
                        synchronized (loadClass) {
                            ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                            if (classLoader != null) {
                                if (classLoader == ClassLoader.getSystemClassLoader()) {
                                    bool = Boolean.FALSE;
                                } else {
                                    a(classLoader);
                                    bool = Boolean.TRUE;
                                }
                            } else if ("com.google.android.gms".equals(context.getApplicationContext().getPackageName())) {
                                declaredField.set(null, ClassLoader.getSystemClassLoader());
                                bool = Boolean.FALSE;
                            } else {
                                int c2 = c(context, str, z);
                                if (f4822d != null) {
                                    if (!f4822d.isEmpty()) {
                                        h hVar = new h(f4822d, ClassLoader.getSystemClassLoader());
                                        a((ClassLoader) hVar);
                                        declaredField.set(null, hVar);
                                        f4819a = Boolean.TRUE;
                                        return c2;
                                    }
                                }
                                return c2;
                            }
                        }
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e2) {
                        String str2 = "DynamiteModule";
                        String valueOf = String.valueOf(e2);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 30);
                        sb.append("Failed to load module via V2: ");
                        sb.append(valueOf);
                        Log.w(str2, sb.toString());
                        bool2 = Boolean.FALSE;
                        f4819a = bool2;
                        if (bool2.booleanValue()) {
                            return c(context, str, z);
                        }
                        return b(context, str, z);
                    }
                }
            }
        } catch (LoadingException e3) {
            String str3 = "DynamiteModule";
            String str4 = "Failed to retrieve remote module version: ";
            String valueOf2 = String.valueOf(e3.getMessage());
            Log.w(str3, valueOf2.length() != 0 ? str4.concat(valueOf2) : new String(str4));
            return 0;
        } catch (Throwable th) {
            f.a(context, th);
            throw th;
        }
    }

    private static DynamiteModule a(Context context, String str, int i2) throws LoadingException {
        Boolean bool;
        com.google.android.gms.dynamic.a aVar;
        try {
            synchronized (DynamiteModule.class) {
                bool = f4819a;
            }
            if (bool == null) {
                throw new LoadingException("Failed to determine which loading route to use.", (a) null);
            } else if (bool.booleanValue()) {
                return b(context, str, i2);
            } else {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
                sb.append("Selected remote version of ");
                sb.append(str);
                sb.append(", version >= ");
                sb.append(i2);
                Log.i("DynamiteModule", sb.toString());
                i a2 = a(context);
                if (a2 != null) {
                    if (a2.g() >= 2) {
                        aVar = a2.b(com.google.android.gms.dynamic.b.a(context), str, i2);
                    } else {
                        Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                        aVar = a2.a(com.google.android.gms.dynamic.b.a(context), str, i2);
                    }
                    if (com.google.android.gms.dynamic.b.a(aVar) != null) {
                        return new DynamiteModule((Context) com.google.android.gms.dynamic.b.a(aVar));
                    }
                    throw new LoadingException("Failed to load remote module.", (a) null);
                }
                throw new LoadingException("Failed to create IDynamiteLoader.", (a) null);
            }
        } catch (RemoteException e2) {
            throw new LoadingException("Failed to load remote module.", e2, null);
        } catch (LoadingException e3) {
            throw e3;
        } catch (Throwable th) {
            f.a(context, th);
            throw new LoadingException("Failed to load remote module.", th, null);
        }
    }

    private static i a(Context context) {
        i iVar;
        synchronized (DynamiteModule.class) {
            if (f4820b != null) {
                i iVar2 = f4820b;
                return iVar2;
            } else if (com.google.android.gms.common.f.a().b(context) != 0) {
                return null;
            } else {
                try {
                    IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                    if (iBinder == null) {
                        iVar = null;
                    } else {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                        if (queryLocalInterface instanceof i) {
                            iVar = (i) queryLocalInterface;
                        } else {
                            iVar = new j(iBinder);
                        }
                    }
                    if (iVar != null) {
                        f4820b = iVar;
                        return iVar;
                    }
                } catch (Exception e2) {
                    String str = "DynamiteModule";
                    String str2 = "Failed to load IDynamiteLoader from GmsCore: ";
                    String valueOf = String.valueOf(e2.getMessage());
                    Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                }
            }
        }
        return null;
    }

    private static Boolean a() {
        Boolean valueOf;
        synchronized (DynamiteModule.class) {
            valueOf = Boolean.valueOf(f4823e >= 2);
        }
        return valueOf;
    }

    private static void a(ClassLoader classLoader) throws LoadingException {
        k kVar;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                kVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof k) {
                    kVar = (k) queryLocalInterface;
                } else {
                    kVar = new l(iBinder);
                }
            }
            f4821c = kVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new LoadingException("Failed to instantiate dynamite loader", e2, null);
        }
    }

    public final IBinder a(String str) throws LoadingException {
        try {
            return (IBinder) this.n.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            String str2 = "Failed to instantiate module class: ";
            String valueOf = String.valueOf(str);
            throw new LoadingException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), e2, null);
        }
    }
}
