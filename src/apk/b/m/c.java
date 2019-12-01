package b.m;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.util.Log;
import io.intercom.android.sdk.metrics.MetricTracker.Action;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* compiled from: MultiDexExtractor */
final class c implements Closeable {

    /* renamed from: a reason: collision with root package name */
    private final File f2794a;

    /* renamed from: b reason: collision with root package name */
    private final long f2795b;

    /* renamed from: c reason: collision with root package name */
    private final File f2796c;

    /* renamed from: d reason: collision with root package name */
    private final RandomAccessFile f2797d;

    /* renamed from: e reason: collision with root package name */
    private final FileChannel f2798e;

    /* renamed from: f reason: collision with root package name */
    private final FileLock f2799f;

    /* compiled from: MultiDexExtractor */
    private static class a extends File {
        public long crc = -1;

        public a(File file, String str) {
            super(file, str);
        }
    }

    c(File file, File file2) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("MultiDexExtractor(");
        sb.append(file.getPath());
        sb.append(", ");
        sb.append(file2.getPath());
        sb.append(")");
        String str = "MultiDex";
        Log.i(str, sb.toString());
        this.f2794a = file;
        this.f2796c = file2;
        this.f2795b = b(file);
        File file3 = new File(file2, "MultiDex.lock");
        this.f2797d = new RandomAccessFile(file3, "rw");
        try {
            this.f2798e = this.f2797d.getChannel();
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Blocking on lock ");
                sb2.append(file3.getPath());
                Log.i(str, sb2.toString());
                this.f2799f = this.f2798e.lock();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(file3.getPath());
                sb3.append(" locked");
                Log.i(str, sb3.toString());
            } catch (IOException e2) {
                e = e2;
                a((Closeable) this.f2798e);
                throw e;
            } catch (RuntimeException e3) {
                e = e3;
                a((Closeable) this.f2798e);
                throw e;
            } catch (Error e4) {
                e = e4;
                a((Closeable) this.f2798e);
                throw e;
            }
        } catch (IOException | Error | RuntimeException e5) {
            a((Closeable) this.f2797d);
            throw e5;
        }
    }

    private static long b(File file) throws IOException {
        long a2 = d.a(file);
        return a2 == -1 ? a2 - 1 : a2;
    }

    /* access modifiers changed from: 0000 */
    public List<? extends File> a(Context context, String str, boolean z) throws IOException {
        List<? extends File> list;
        StringBuilder sb = new StringBuilder();
        sb.append("MultiDexExtractor.load(");
        sb.append(this.f2794a.getPath());
        String str2 = ", ";
        sb.append(str2);
        sb.append(z);
        sb.append(str2);
        sb.append(str);
        sb.append(")");
        String str3 = "MultiDex";
        Log.i(str3, sb.toString());
        if (this.f2799f.isValid()) {
            if (z || a(context, this.f2794a, this.f2795b, str)) {
                if (z) {
                    Log.i(str3, "Forced extraction must be performed.");
                } else {
                    Log.i(str3, "Detected that extraction must be performed.");
                }
                list = b();
                a(context, str, a(this.f2794a), this.f2795b, list);
            } else {
                try {
                    list = a(context, str);
                } catch (IOException e2) {
                    Log.w(str3, "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e2);
                    list = b();
                    a(context, str, a(this.f2794a), this.f2795b, list);
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("load found ");
            sb2.append(list.size());
            sb2.append(" secondary dex files");
            Log.i(str3, sb2.toString());
            return list;
        }
        throw new IllegalStateException("MultiDexExtractor was closed");
    }

    public void close() throws IOException {
        this.f2799f.release();
        this.f2798e.close();
        this.f2797d.close();
    }

    private List<a> b() throws IOException {
        a aVar;
        boolean z;
        String str = ".dex";
        String str2 = "Failed to close resource";
        String str3 = "classes";
        String str4 = "MultiDex";
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2794a.getName());
        sb.append(".classes");
        String sb2 = sb.toString();
        a();
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.f2794a);
        try {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str3);
            sb3.append(2);
            sb3.append(str);
            ZipEntry entry = zipFile.getEntry(sb3.toString());
            int i2 = 2;
            while (entry != null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(sb2);
                sb4.append(i2);
                sb4.append(".zip");
                aVar = new a(this.f2796c, sb4.toString());
                arrayList.add(aVar);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Extraction is needed for file ");
                sb5.append(aVar);
                Log.i(str4, sb5.toString());
                int i3 = 0;
                boolean z2 = false;
                while (i3 < 3 && !z2) {
                    int i4 = i3 + 1;
                    a(zipFile, entry, (File) aVar, sb2);
                    aVar.crc = b(aVar);
                    z = true;
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("Extraction ");
                    sb6.append(z ? "succeeded" : Action.FAILED);
                    sb6.append(" '");
                    sb6.append(aVar.getAbsolutePath());
                    sb6.append("': length ");
                    int i5 = i4;
                    sb6.append(aVar.length());
                    sb6.append(" - crc: ");
                    sb6.append(aVar.crc);
                    Log.i(str4, sb6.toString());
                    if (!z) {
                        aVar.delete();
                        if (aVar.exists()) {
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append("Failed to delete corrupted secondary dex '");
                            sb7.append(aVar.getPath());
                            sb7.append("'");
                            Log.w(str4, sb7.toString());
                        }
                    }
                    z2 = z;
                    i3 = i5;
                }
                if (z2) {
                    i2++;
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(str3);
                    sb8.append(i2);
                    sb8.append(str);
                    entry = zipFile.getEntry(sb8.toString());
                } else {
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append("Could not create zip file ");
                    sb9.append(aVar.getAbsolutePath());
                    sb9.append(" for secondary dex (");
                    sb9.append(i2);
                    sb9.append(")");
                    throw new IOException(sb9.toString());
                }
            }
            try {
                zipFile.close();
            } catch (IOException e2) {
                Log.w(str4, str2, e2);
            }
            return arrayList;
        } catch (IOException e3) {
            StringBuilder sb10 = new StringBuilder();
            sb10.append("Failed to read crc from ");
            sb10.append(aVar.getAbsolutePath());
            Log.w(str4, sb10.toString(), e3);
            z = false;
        } catch (Throwable th) {
            Throwable th2 = th;
            try {
                zipFile.close();
            } catch (IOException e4) {
                Log.w(str4, str2, e4);
            }
            throw th2;
        }
    }

    private List<a> a(Context context, String str) throws IOException {
        String str2 = str;
        Log.i("MultiDex", "loading existing secondary dex files");
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2794a.getName());
        sb.append(".classes");
        String sb2 = sb.toString();
        SharedPreferences a2 = a(context);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str2);
        sb3.append("dex.number");
        int i2 = a2.getInt(sb3.toString(), 1);
        ArrayList arrayList = new ArrayList(i2 - 1);
        int i3 = 2;
        while (i3 <= i2) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(sb2);
            sb4.append(i3);
            sb4.append(".zip");
            a aVar = new a(this.f2796c, sb4.toString());
            if (aVar.isFile()) {
                aVar.crc = b(aVar);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str2);
                sb5.append("dex.crc.");
                sb5.append(i3);
                long j2 = a2.getLong(sb5.toString(), -1);
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str2);
                sb6.append("dex.time.");
                sb6.append(i3);
                long j3 = a2.getLong(sb6.toString(), -1);
                long lastModified = aVar.lastModified();
                if (j3 == lastModified) {
                    String str3 = sb2;
                    SharedPreferences sharedPreferences = a2;
                    if (j2 == aVar.crc) {
                        arrayList.add(aVar);
                        i3++;
                        a2 = sharedPreferences;
                        sb2 = str3;
                    }
                }
                StringBuilder sb7 = new StringBuilder();
                sb7.append("Invalid extracted dex: ");
                sb7.append(aVar);
                sb7.append(" (key \"");
                sb7.append(str2);
                sb7.append("\"), expected modification time: ");
                sb7.append(j3);
                sb7.append(", modification time: ");
                sb7.append(lastModified);
                sb7.append(", expected crc: ");
                sb7.append(j2);
                sb7.append(", file crc: ");
                sb7.append(aVar.crc);
                throw new IOException(sb7.toString());
            }
            StringBuilder sb8 = new StringBuilder();
            sb8.append("Missing extracted secondary dex file '");
            sb8.append(aVar.getPath());
            sb8.append("'");
            throw new IOException(sb8.toString());
        }
        return arrayList;
    }

    private static boolean a(Context context, File file, long j2, String str) {
        SharedPreferences a2 = a(context);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("timestamp");
        if (a2.getLong(sb.toString(), -1) == a(file)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("crc");
            if (a2.getLong(sb2.toString(), -1) == j2) {
                return false;
            }
        }
        return true;
    }

    private static long a(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    private static void a(Context context, String str, long j2, long j3, List<a> list) {
        Editor edit = a(context).edit();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("timestamp");
        edit.putLong(sb.toString(), j2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("crc");
        edit.putLong(sb2.toString(), j3);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append("dex.number");
        edit.putInt(sb3.toString(), list.size() + 1);
        int i2 = 2;
        for (a aVar : list) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append("dex.crc.");
            sb4.append(i2);
            edit.putLong(sb4.toString(), aVar.crc);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            sb5.append("dex.time.");
            sb5.append(i2);
            edit.putLong(sb5.toString(), aVar.lastModified());
            i2++;
        }
        edit.commit();
    }

    private static SharedPreferences a(Context context) {
        return context.getSharedPreferences("multidex.version", VERSION.SDK_INT < 11 ? 0 : 4);
    }

    private void a() {
        File[] listFiles = this.f2796c.listFiles(new b(this));
        String str = "MultiDex";
        if (listFiles == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to list secondary dex dir content (");
            sb.append(this.f2796c.getPath());
            sb.append(").");
            Log.w(str, sb.toString());
            return;
        }
        for (File file : listFiles) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Trying to delete old file ");
            sb2.append(file.getPath());
            sb2.append(" of size ");
            sb2.append(file.length());
            Log.i(str, sb2.toString());
            if (!file.delete()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Failed to delete old file ");
                sb3.append(file.getPath());
                Log.w(str, sb3.toString());
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Deleted old file ");
                sb4.append(file.getPath());
                Log.i(str, sb4.toString());
            }
        }
    }

    private static void a(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException, FileNotFoundException {
        ZipOutputStream zipOutputStream;
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        StringBuilder sb = new StringBuilder();
        sb.append("tmp-");
        sb.append(str);
        File createTempFile = File.createTempFile(sb.toString(), ".zip", file.getParentFile());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Extracting ");
        sb2.append(createTempFile.getPath());
        String str2 = "MultiDex";
        Log.i(str2, sb2.toString());
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[16384];
            for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            if (createTempFile.setReadOnly()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Renaming to ");
                sb3.append(file.getPath());
                Log.i(str2, sb3.toString());
                if (createTempFile.renameTo(file)) {
                    a((Closeable) inputStream);
                    createTempFile.delete();
                    return;
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Failed to rename \"");
                sb4.append(createTempFile.getAbsolutePath());
                sb4.append("\" to \"");
                sb4.append(file.getAbsolutePath());
                sb4.append("\"");
                throw new IOException(sb4.toString());
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Failed to mark readonly \"");
            sb5.append(createTempFile.getAbsolutePath());
            sb5.append("\" (tmp of \"");
            sb5.append(file.getAbsolutePath());
            sb5.append("\")");
            throw new IOException(sb5.toString());
        } catch (Throwable th) {
            a((Closeable) inputStream);
            createTempFile.delete();
            throw th;
        }
    }

    private static void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e2) {
            Log.w("MultiDex", "Failed to close resource", e2);
        }
    }
}
