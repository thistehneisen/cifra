package b.g.f;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.os.Handler;
import b.d.g;
import b.d.i;
import b.g.b.k;
import io.fabric.sdk.android.a.b.C0730a;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* compiled from: FontsContractCompat */
public class f {

    /* renamed from: a reason: collision with root package name */
    static final g<String, Typeface> f2539a = new g<>(16);

    /* renamed from: b reason: collision with root package name */
    private static final k f2540b = new k("fonts", 10, C0730a.DEFAULT_TIMEOUT);

    /* renamed from: c reason: collision with root package name */
    static final Object f2541c = new Object();

    /* renamed from: d reason: collision with root package name */
    static final i<String, ArrayList<b.g.f.k.a<c>>> f2542d = new i<>();

    /* renamed from: e reason: collision with root package name */
    private static final Comparator<byte[]> f2543e = new e();

    /* compiled from: FontsContractCompat */
    public static class a {

        /* renamed from: a reason: collision with root package name */
        private final int f2544a;

        /* renamed from: b reason: collision with root package name */
        private final b[] f2545b;

        public a(int i2, b[] bVarArr) {
            this.f2544a = i2;
            this.f2545b = bVarArr;
        }

        public b[] a() {
            return this.f2545b;
        }

        public int b() {
            return this.f2544a;
        }
    }

    /* compiled from: FontsContractCompat */
    public static class b {

        /* renamed from: a reason: collision with root package name */
        private final Uri f2546a;

        /* renamed from: b reason: collision with root package name */
        private final int f2547b;

        /* renamed from: c reason: collision with root package name */
        private final int f2548c;

        /* renamed from: d reason: collision with root package name */
        private final boolean f2549d;

        /* renamed from: e reason: collision with root package name */
        private final int f2550e;

        public b(Uri uri, int i2, int i3, boolean z, int i4) {
            b.g.h.g.a(uri);
            this.f2546a = uri;
            this.f2547b = i2;
            this.f2548c = i3;
            this.f2549d = z;
            this.f2550e = i4;
        }

        public int a() {
            return this.f2550e;
        }

        public int b() {
            return this.f2547b;
        }

        public Uri c() {
            return this.f2546a;
        }

        public int d() {
            return this.f2548c;
        }

        public boolean e() {
            return this.f2549d;
        }
    }

    /* compiled from: FontsContractCompat */
    private static final class c {

        /* renamed from: a reason: collision with root package name */
        final Typeface f2551a;

        /* renamed from: b reason: collision with root package name */
        final int f2552b;

        c(Typeface typeface, int i2) {
            this.f2551a = typeface;
            this.f2552b = i2;
        }
    }

    static c a(Context context, a aVar, int i2) {
        try {
            a a2 = a(context, (CancellationSignal) null, aVar);
            int i3 = -3;
            if (a2.b() == 0) {
                Typeface a3 = b.g.b.c.a(context, null, a2.a(), i2);
                if (a3 != null) {
                    i3 = 0;
                }
                return new c(a3, i3);
            }
            if (a2.b() == 1) {
                i3 = -2;
            }
            return new c(null, i3);
        } catch (NameNotFoundException unused) {
            return new c(null, -1);
        }
    }

    /* JADX INFO: used method not loaded: b.g.f.k.a(java.util.concurrent.Callable, b.g.f.k$a):null, types can be incorrect */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0072, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0083, code lost:
        f2540b.a((java.util.concurrent.Callable) r1, (b.g.f.k.a) new b.g.f.d(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x008d, code lost:
        return r2;
     */
    public static Typeface a(Context context, a aVar, b.g.a.a.h.a aVar2, Handler handler, boolean z, int i2, int i3) {
        Object obj;
        Typeface typeface;
        StringBuilder sb = new StringBuilder();
        sb.append(aVar.c());
        sb.append("-");
        sb.append(i3);
        String sb2 = sb.toString();
        Typeface typeface2 = (Typeface) f2539a.b(sb2);
        if (typeface2 != null) {
            if (aVar2 != null) {
                aVar2.a(typeface2);
            }
            return typeface2;
        } else if (!z || i2 != -1) {
            b bVar = new b(context, aVar, i3, sb2);
            Typeface typeface3 = 0;
            if (z) {
                try {
                    typeface = ((c) f2540b.a((Callable<T>) bVar, i2)).f2551a;
                } catch (InterruptedException unused) {
                    typeface = typeface3;
                }
                return typeface;
            }
            if (aVar2 == null) {
                obj = typeface3;
            } else {
                obj = new c(aVar2, handler);
            }
            synchronized (f2541c) {
                ArrayList arrayList = (ArrayList) f2542d.get(sb2);
                if (arrayList != null) {
                    if (obj != 0) {
                        arrayList.add(obj);
                    }
                } else if (obj != 0) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(obj);
                    f2542d.put(sb2, arrayList2);
                }
            }
        } else {
            c a2 = a(context, aVar, i3);
            if (aVar2 != null) {
                int i4 = a2.f2552b;
                if (i4 == 0) {
                    aVar2.a(a2.f2551a, handler);
                } else {
                    aVar2.a(i4, handler);
                }
            }
            return a2.f2551a;
        }
    }

    public static Map<Uri, ByteBuffer> a(Context context, b[] bVarArr, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (b bVar : bVarArr) {
            if (bVar.a() == 0) {
                Uri c2 = bVar.c();
                if (!hashMap.containsKey(c2)) {
                    hashMap.put(c2, k.a(context, cancellationSignal, c2));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public static a a(Context context, CancellationSignal cancellationSignal, a aVar) throws NameNotFoundException {
        ProviderInfo a2 = a(context.getPackageManager(), aVar, context.getResources());
        if (a2 == null) {
            return new a(1, null);
        }
        return new a(0, a(context, aVar, a2.authority, cancellationSignal));
    }

    public static ProviderInfo a(PackageManager packageManager, a aVar, Resources resources) throws NameNotFoundException {
        String d2 = aVar.d();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(d2, 0);
        if (resolveContentProvider == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("No package found for authority: ");
            sb.append(d2);
            throw new NameNotFoundException(sb.toString());
        } else if (resolveContentProvider.packageName.equals(aVar.e())) {
            List a2 = a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
            Collections.sort(a2, f2543e);
            List a3 = a(aVar, resources);
            for (int i2 = 0; i2 < a3.size(); i2++) {
                ArrayList arrayList = new ArrayList((Collection) a3.get(i2));
                Collections.sort(arrayList, f2543e);
                if (a(a2, (List<byte[]>) arrayList)) {
                    return resolveContentProvider;
                }
            }
            return null;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Found content provider ");
            sb2.append(d2);
            sb2.append(", but package was not ");
            sb2.append(aVar.e());
            throw new NameNotFoundException(sb2.toString());
        }
    }

    private static List<List<byte[]>> a(a aVar, Resources resources) {
        if (aVar.a() != null) {
            return aVar.a();
        }
        return b.g.a.a.c.a(resources, aVar.b());
    }

    private static boolean a(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (!Arrays.equals((byte[]) list.get(i2), (byte[]) list2.get(i2))) {
                return false;
            }
        }
        return true;
    }

    private static List<byte[]> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature byteArray : signatureArr) {
            arrayList.add(byteArray.toByteArray());
        }
        return arrayList;
    }

    /* JADX INFO: finally extract failed */
    static b[] a(Context context, a aVar, String str, CancellationSignal cancellationSignal) {
        Cursor cursor;
        Uri uri;
        String str2 = str;
        ArrayList arrayList = new ArrayList();
        String str3 = "content";
        Uri build = new Builder().scheme(str3).authority(str2).build();
        Uri build2 = new Builder().scheme(str3).authority(str2).appendPath("file").build();
        Cursor cursor2 = null;
        try {
            if (VERSION.SDK_INT > 16) {
                cursor = context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.f()}, null, cancellationSignal);
            } else {
                cursor = context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.f()}, null);
            }
            if (cursor != null && cursor.getCount() > 0) {
                int columnIndex = cursor.getColumnIndex("result_code");
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursor.getColumnIndex("_id");
                int columnIndex3 = cursor.getColumnIndex("file_id");
                int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursor.getColumnIndex("font_weight");
                int columnIndex6 = cursor.getColumnIndex("font_italic");
                while (cursor.moveToNext()) {
                    int i2 = columnIndex != -1 ? cursor.getInt(columnIndex) : 0;
                    int i3 = columnIndex4 != -1 ? cursor.getInt(columnIndex4) : 0;
                    if (columnIndex3 == -1) {
                        uri = ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                    } else {
                        uri = ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                    }
                    b bVar = new b(uri, i3, columnIndex5 != -1 ? cursor.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursor.getInt(columnIndex6) == 1, i2);
                    arrayList2.add(bVar);
                }
                arrayList = arrayList2;
            }
            if (cursor != null) {
                cursor.close();
            }
            return (b[]) arrayList.toArray(new b[0]);
        } catch (Throwable th) {
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }
}
