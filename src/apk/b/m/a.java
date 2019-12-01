package b.m;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.util.Log;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.zip.ZipFile;

/* compiled from: MultiDex */
public final class a {

    /* renamed from: a reason: collision with root package name */
    private static final Set<File> f2786a = new HashSet();

    /* renamed from: b reason: collision with root package name */
    private static final boolean f2787b = a(System.getProperty("java.vm.version"));

    /* renamed from: b.m.a$a reason: collision with other inner class name */
    /* compiled from: MultiDex */
    private static final class C0034a {

        /* renamed from: a reason: collision with root package name */
        private static final int f2788a = 4;

        /* renamed from: b reason: collision with root package name */
        private final C0035a f2789b;

        /* renamed from: b.m.a$a$a reason: collision with other inner class name */
        /* compiled from: MultiDex */
        private interface C0035a {
            Object a(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException;
        }

        /* renamed from: b.m.a$a$b */
        /* compiled from: MultiDex */
        private static class b implements C0035a {

            /* renamed from: a reason: collision with root package name */
            private final Constructor<?> f2790a;

            b(Class<?> cls) throws SecurityException, NoSuchMethodException {
                this.f2790a = cls.getConstructor(new Class[]{File.class, ZipFile.class, DexFile.class});
                this.f2790a.setAccessible(true);
            }

            public Object a(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException {
                return this.f2790a.newInstance(new Object[]{file, new ZipFile(file), dexFile});
            }
        }

        /* renamed from: b.m.a$a$c */
        /* compiled from: MultiDex */
        private static class c implements C0035a {

            /* renamed from: a reason: collision with root package name */
            private final Constructor<?> f2791a;

            c(Class<?> cls) throws SecurityException, NoSuchMethodException {
                this.f2791a = cls.getConstructor(new Class[]{File.class, File.class, DexFile.class});
                this.f2791a.setAccessible(true);
            }

            public Object a(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
                return this.f2791a.newInstance(new Object[]{file, file, dexFile});
            }
        }

        /* renamed from: b.m.a$a$d */
        /* compiled from: MultiDex */
        private static class d implements C0035a {

            /* renamed from: a reason: collision with root package name */
            private final Constructor<?> f2792a;

            d(Class<?> cls) throws SecurityException, NoSuchMethodException {
                this.f2792a = cls.getConstructor(new Class[]{File.class, Boolean.TYPE, File.class, DexFile.class});
                this.f2792a.setAccessible(true);
            }

            public Object a(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
                return this.f2792a.newInstance(new Object[]{file, Boolean.FALSE, file, dexFile});
            }
        }

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        private C0034a() throws ClassNotFoundException, SecurityException, NoSuchMethodException {
            Class cls = Class.forName("dalvik.system.DexPathList$Element");
            C0035a aVar = new b(cls);
            try {
                aVar = new c(cls);
            } catch (NoSuchMethodException unused) {
                aVar = new d(cls);
            }
            this.f2789b = aVar;
        }

        static void a(ClassLoader classLoader, List<? extends File> list) throws IOException, SecurityException, IllegalArgumentException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
            Object obj = a.b(classLoader, "pathList").get(classLoader);
            Object[] a2 = new C0034a().a(list);
            try {
                a.b(obj, "dexElements", a2);
            } catch (NoSuchFieldException e2) {
                Log.w("MultiDex", "Failed find field 'dexElements' attempting 'pathElements'", e2);
                a.b(obj, "pathElements", a2);
            }
        }

        private Object[] a(List<? extends File> list) throws IOException, SecurityException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
            Object[] objArr = new Object[list.size()];
            for (int i2 = 0; i2 < objArr.length; i2++) {
                File file = (File) list.get(i2);
                objArr[i2] = this.f2789b.a(file, DexFile.loadDex(file.getPath(), a(file), 0));
            }
            return objArr;
        }

        private static String a(File file) {
            File parentFile = file.getParentFile();
            String name = file.getName();
            StringBuilder sb = new StringBuilder();
            sb.append(name.substring(0, name.length() - f2788a));
            sb.append(".dex");
            return new File(parentFile, sb.toString()).getPath();
        }
    }

    /* compiled from: MultiDex */
    private static final class b {
        static void a(ClassLoader classLoader, List<? extends File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
            IOException[] iOExceptionArr;
            Object obj = a.b(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            a.b(obj, "dexElements", a(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Log.w("MultiDex", "Exception in makeDexElement", (IOException) it.next());
                }
                Field a2 = a.b(obj, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr2 = (IOException[]) a2.get(obj);
                if (iOExceptionArr2 == null) {
                    iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    IOException[] iOExceptionArr3 = new IOException[(arrayList.size() + iOExceptionArr2.length)];
                    arrayList.toArray(iOExceptionArr3);
                    System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList.size(), iOExceptionArr2.length);
                    iOExceptionArr = iOExceptionArr3;
                }
                a2.set(obj, iOExceptionArr);
                IOException iOException = new IOException("I/O exception during makeDexElement");
                iOException.initCause((Throwable) arrayList.get(0));
                throw iOException;
            }
        }

        private static Object[] a(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            return (Object[]) a.b(obj, "makeDexElements", (Class<?>[]) new Class[]{ArrayList.class, File.class, ArrayList.class}).invoke(obj, new Object[]{arrayList, file, arrayList2});
        }
    }

    /* compiled from: MultiDex */
    private static final class c {
        static void a(ClassLoader classLoader, List<? extends File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException {
            int size = list.size();
            Field a2 = a.b(classLoader, "path");
            StringBuilder sb = new StringBuilder((String) a2.get(classLoader));
            String[] strArr = new String[size];
            File[] fileArr = new File[size];
            ZipFile[] zipFileArr = new ZipFile[size];
            DexFile[] dexFileArr = new DexFile[size];
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                File file = (File) listIterator.next();
                String absolutePath = file.getAbsolutePath();
                sb.append(':');
                sb.append(absolutePath);
                int previousIndex = listIterator.previousIndex();
                strArr[previousIndex] = absolutePath;
                fileArr[previousIndex] = file;
                zipFileArr[previousIndex] = new ZipFile(file);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(absolutePath);
                sb2.append(".dex");
                dexFileArr[previousIndex] = DexFile.loadDex(absolutePath, sb2.toString(), 0);
            }
            a2.set(classLoader, sb.toString());
            a.b((Object) classLoader, "mPaths", (Object[]) strArr);
            a.b((Object) classLoader, "mFiles", (Object[]) fileArr);
            a.b((Object) classLoader, "mZips", (Object[]) zipFileArr);
            a.b((Object) classLoader, "mDexs", (Object[]) dexFileArr);
        }
    }

    /* access modifiers changed from: private */
    public static Field b(Object obj, String str) throws NoSuchFieldException {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Field ");
        sb.append(str);
        sb.append(" not found in ");
        sb.append(obj.getClass());
        throw new NoSuchFieldException(sb.toString());
    }

    private static ApplicationInfo c(Context context) {
        try {
            return context.getApplicationInfo();
        } catch (RuntimeException e2) {
            Log.w("MultiDex", "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", e2);
            return null;
        }
    }

    private static ClassLoader d(Context context) {
        String str = "MultiDex";
        try {
            ClassLoader classLoader = context.getClassLoader();
            if (VERSION.SDK_INT >= 14) {
                if (classLoader instanceof BaseDexClassLoader) {
                    return classLoader;
                }
            } else if ((classLoader instanceof DexClassLoader) || (classLoader instanceof PathClassLoader)) {
                return classLoader;
            }
            Log.e(str, "Context class loader is null or not dex-capable. Must be running in test mode. Skip patching.");
            return null;
        } catch (RuntimeException e2) {
            Log.w(str, "Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching.", e2);
            return null;
        }
    }

    public static void a(Context context) {
        String str = "MultiDex";
        Log.i(str, "Installing application");
        if (f2787b) {
            Log.i(str, "VM has multidex support, MultiDex support library is disabled.");
        } else if (VERSION.SDK_INT >= 4) {
            try {
                ApplicationInfo c2 = c(context);
                if (c2 == null) {
                    Log.i(str, "No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
                    return;
                }
                a(context, new File(c2.sourceDir), new File(c2.dataDir), "secondary-dexes", "", true);
                Log.i(str, "install done");
            } catch (Exception e2) {
                Log.e(str, "MultiDex installation failure", e2);
                StringBuilder sb = new StringBuilder();
                sb.append("MultiDex installation failed (");
                sb.append(e2.getMessage());
                sb.append(").");
                throw new RuntimeException(sb.toString());
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("MultiDex installation failed. SDK ");
            sb2.append(VERSION.SDK_INT);
            sb2.append(" is unsupported. Min SDK version is ");
            sb2.append(4);
            sb2.append(".");
            throw new RuntimeException(sb2.toString());
        }
    }

    /* access modifiers changed from: private */
    public static Method b(Object obj, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
                cls = cls.getSuperclass();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Method ");
        sb.append(str);
        sb.append(" with parameters ");
        sb.append(Arrays.asList(clsArr));
        sb.append(" not found in ");
        sb.append(obj.getClass());
        throw new NoSuchMethodException(sb.toString());
    }

    /* access modifiers changed from: private */
    public static void b(Object obj, String str, Object[] objArr) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field b2 = b(obj, str);
        Object[] objArr2 = (Object[]) b2.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        b2.set(obj, objArr3);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:41|42|43|44|45) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x009d */
    private static void a(Context context, File file, File file2, String str, String str2, boolean z) throws IOException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException {
        synchronized (f2786a) {
            if (!f2786a.contains(file)) {
                f2786a.add(file);
                if (VERSION.SDK_INT > 20) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("MultiDex is not guaranteed to work in SDK version ");
                    sb.append(VERSION.SDK_INT);
                    sb.append(": SDK version higher than ");
                    sb.append(20);
                    sb.append(" should be backed by ");
                    sb.append("runtime with built-in multidex capabilty but it's not the ");
                    sb.append("case here: java.vm.version=\"");
                    sb.append(System.getProperty("java.vm.version"));
                    sb.append("\"");
                    Log.w("MultiDex", sb.toString());
                }
                ClassLoader d2 = d(context);
                if (d2 != null) {
                    try {
                        b(context);
                    } catch (Throwable th) {
                        Log.w("MultiDex", "Something went wrong when trying to clear old MultiDex extraction, continuing without cleaning.", th);
                    }
                    File a2 = a(context, file2, str);
                    c cVar = new c(file, a2);
                    IOException e2 = null;
                    try {
                        a(d2, a2, cVar.a(context, str2, false));
                    } catch (IOException e3) {
                        if (z) {
                            Log.w("MultiDex", "Failed to install extracted secondary dex files, retrying with forced extraction", e3);
                            a(d2, a2, cVar.a(context, str2, true));
                        } else {
                            throw e3;
                        }
                    } catch (Throwable th2) {
                        cVar.close();
                        throw th2;
                    }
                    try {
                        cVar.close();
                    } catch (IOException e4) {
                        e2 = e4;
                    }
                    if (e2 != null) {
                        throw e2;
                    }
                }
            }
        }
    }

    private static void b(Context context) throws Exception {
        File file = new File(context.getFilesDir(), "secondary-dexes");
        if (file.isDirectory()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Clearing old secondary dex dir (");
            sb.append(file.getPath());
            String str = ").";
            sb.append(str);
            String str2 = "MultiDex";
            Log.i(str2, sb.toString());
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to list secondary dex dir content (");
                sb2.append(file.getPath());
                sb2.append(str);
                Log.w(str2, sb2.toString());
                return;
            }
            for (File file2 : listFiles) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Trying to delete old file ");
                sb3.append(file2.getPath());
                sb3.append(" of size ");
                sb3.append(file2.length());
                Log.i(str2, sb3.toString());
                if (!file2.delete()) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Failed to delete old file ");
                    sb4.append(file2.getPath());
                    Log.w(str2, sb4.toString());
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Deleted old file ");
                    sb5.append(file2.getPath());
                    Log.i(str2, sb5.toString());
                }
            }
            if (!file.delete()) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("Failed to delete secondary dex dir ");
                sb6.append(file.getPath());
                Log.w(str2, sb6.toString());
            } else {
                StringBuilder sb7 = new StringBuilder();
                sb7.append("Deleted old secondary dex dir ");
                sb7.append(file.getPath());
                Log.i(str2, sb7.toString());
            }
        }
    }

    static boolean a(String str) {
        boolean z = false;
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
            String str2 = null;
            String nextToken = stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : null;
            if (stringTokenizer.hasMoreTokens()) {
                str2 = stringTokenizer.nextToken();
            }
            if (!(nextToken == null || str2 == null)) {
                try {
                    int parseInt = Integer.parseInt(nextToken);
                    int parseInt2 = Integer.parseInt(str2);
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 >= 1)) {
                        z = true;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("VM with version ");
        sb.append(str);
        sb.append(z ? " has multidex support" : " does not have multidex support");
        Log.i("MultiDex", sb.toString());
        return z;
    }

    private static void a(ClassLoader classLoader, File file, List<? extends File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException, SecurityException, ClassNotFoundException, InstantiationException {
        if (!list.isEmpty()) {
            int i2 = VERSION.SDK_INT;
            if (i2 >= 19) {
                b.a(classLoader, list, file);
            } else if (i2 >= 14) {
                C0034a.a(classLoader, list);
            } else {
                c.a(classLoader, list);
            }
        }
    }

    private static File a(Context context, File file, String str) throws IOException {
        String str2 = "code_cache";
        File file2 = new File(file, str2);
        try {
            a(file2);
        } catch (IOException unused) {
            file2 = new File(context.getFilesDir(), str2);
            a(file2);
        }
        File file3 = new File(file2, str);
        a(file3);
        return file3;
    }

    private static void a(File file) throws IOException {
        file.mkdir();
        if (!file.isDirectory()) {
            File parentFile = file.getParentFile();
            String str = "Failed to create dir ";
            String str2 = "MultiDex";
            if (parentFile == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(file.getPath());
                sb.append(". Parent file is null.");
                Log.e(str2, sb.toString());
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(file.getPath());
                sb2.append(". parent file is a dir ");
                sb2.append(parentFile.isDirectory());
                sb2.append(", a file ");
                sb2.append(parentFile.isFile());
                sb2.append(", exists ");
                sb2.append(parentFile.exists());
                sb2.append(", readable ");
                sb2.append(parentFile.canRead());
                sb2.append(", writable ");
                sb2.append(parentFile.canWrite());
                Log.e(str2, sb2.toString());
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Failed to create directory ");
            sb3.append(file.getPath());
            throw new IOException(sb3.toString());
        }
    }
}
