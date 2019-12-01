package io.fabric.sdk.android.a.b;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import io.fabric.sdk.android.f;
import io.fabric.sdk.android.o;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

/* compiled from: CommonUtils */
public class l {

    /* renamed from: a reason: collision with root package name */
    private static Boolean f8818a;

    /* renamed from: b reason: collision with root package name */
    private static final char[] f8819b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: c reason: collision with root package name */
    private static long f8820c = -1;

    /* renamed from: d reason: collision with root package name */
    public static final Comparator<File> f8821d = new k();

    /* compiled from: CommonUtils */
    enum a {
        X86_32,
        X86_64,
        ARM_UNKNOWN,
        PPC,
        PPC64,
        ARMV6,
        ARMV7,
        UNKNOWN,
        ARMV7S,
        ARM64;
        

        /* renamed from: k reason: collision with root package name */
        private static final Map<String, a> f8832k = null;

        static {
            f8832k = new HashMap(4);
            f8832k.put("armeabi-v7a", ARMV7);
            f8832k.put("armeabi", ARMV6);
            f8832k.put("arm64-v8a", ARM64);
            f8832k.put("x86", X86_32);
        }

        static a a() {
            String str = Build.CPU_ABI;
            if (TextUtils.isEmpty(str)) {
                f.e().d("Fabric", "Architecture#getValue()::Build.CPU_ABI returned null or empty");
                return UNKNOWN;
            }
            a aVar = (a) f8832k.get(str.toLowerCase(Locale.US));
            if (aVar == null) {
                aVar = UNKNOWN;
            }
            return aVar;
        }
    }

    public static String a(int i2) {
        switch (i2) {
            case 2:
                return "V";
            case 3:
                return "D";
            case 4:
                return "I";
            case 5:
                return "W";
            case 6:
                return "E";
            case 7:
                return "A";
            default:
                return "?";
        }
    }

    public static String a(File file, String str) {
        BufferedReader bufferedReader;
        String str2 = "Failed to close system file reader.";
        String str3 = null;
        if (file.exists()) {
            try {
                bufferedReader = new BufferedReader(new FileReader(file), 1024);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String[] split = Pattern.compile("\\s*:\\s*").split(readLine, 2);
                        if (split.length > 1 && split[0].equals(str)) {
                            str3 = split[1];
                            break;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Error parsing ");
                            sb.append(file);
                            f.e().b("Fabric", sb.toString(), e);
                            a((Closeable) bufferedReader, str2);
                            return str3;
                        } catch (Throwable th) {
                            th = th;
                        }
                    }
                }
            } catch (Exception e3) {
                e = e3;
                bufferedReader = null;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error parsing ");
                sb2.append(file);
                f.e().b("Fabric", sb2.toString(), e);
                a((Closeable) bufferedReader, str2);
                return str3;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
                a((Closeable) bufferedReader, str2);
                throw th;
            }
            a((Closeable) bufferedReader, str2);
        }
        return str3;
    }

    public static synchronized long b() {
        long j2;
        synchronized (l.class) {
            if (f8820c == -1) {
                long j3 = 0;
                String a2 = a(new File("/proc/meminfo"), "MemTotal");
                if (!TextUtils.isEmpty(a2)) {
                    String upperCase = a2.toUpperCase(Locale.US);
                    try {
                        if (upperCase.endsWith("KB")) {
                            j3 = a(upperCase, "KB", 1024);
                        } else if (upperCase.endsWith("MB")) {
                            j3 = a(upperCase, "MB", 1048576);
                        } else if (upperCase.endsWith("GB")) {
                            j3 = a(upperCase, "GB", 1073741824);
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Unexpected meminfo format while computing RAM: ");
                            sb.append(upperCase);
                            f.e().d("Fabric", sb.toString());
                        }
                    } catch (NumberFormatException e2) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Unexpected meminfo format while computing RAM: ");
                        sb2.append(upperCase);
                        f.e().b("Fabric", sb2.toString(), e2);
                    }
                }
                f8820c = j3;
            }
            j2 = f8820c;
        }
        return j2;
    }

    public static String c(String str) {
        return a(str, "SHA-1");
    }

    public static String d(String str) {
        return a(str, "SHA-256");
    }

    public static Float e(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        return Float.valueOf(((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
    }

    public static int f(Context context) {
        int i2 = l(context) ? 1 : 0;
        if (m(context)) {
            i2 |= 2;
        }
        return c() ? i2 | 4 : i2;
    }

    public static boolean g(Context context) {
        boolean z = false;
        if (l(context)) {
            return false;
        }
        if (((SensorManager) context.getSystemService("sensor")).getDefaultSensor(8) != null) {
            z = true;
        }
        return z;
    }

    public static String h(Context context) {
        int i2 = context.getApplicationContext().getApplicationInfo().icon;
        if (i2 <= 0) {
            return context.getPackageName();
        }
        try {
            return context.getResources().getResourcePackageName(i2);
        } catch (NotFoundException unused) {
            return context.getPackageName();
        }
    }

    public static SharedPreferences i(Context context) {
        return context.getSharedPreferences("com.crashlytics.prefs", 0);
    }

    public static boolean j(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static boolean k(Context context) {
        if (f8818a == null) {
            f8818a = Boolean.valueOf(a(context, "com.crashlytics.Trace", false));
        }
        return f8818a.booleanValue();
    }

    public static boolean l(Context context) {
        String string = Secure.getString(context.getContentResolver(), "android_id");
        if (!"sdk".equals(Build.PRODUCT)) {
            if (!"google_sdk".equals(Build.PRODUCT) && string != null) {
                return false;
            }
        }
        return true;
    }

    public static boolean m(Context context) {
        boolean l2 = l(context);
        String str = Build.TAGS;
        if ((!l2 && str != null && str.contains("test-keys")) || new File("/system/app/Superuser.apk").exists()) {
            return true;
        }
        File file = new File("/system/xbin/su");
        if (l2 || !file.exists()) {
            return false;
        }
        return true;
    }

    public static String n(Context context) {
        String str = "string";
        int a2 = a(context, "io.fabric.android.build_id", str);
        if (a2 == 0) {
            a2 = a(context, "com.crashlytics.android.build_id", str);
        }
        if (a2 == 0) {
            return null;
        }
        String string = context.getResources().getString(a2);
        o e2 = f.e();
        StringBuilder sb = new StringBuilder();
        sb.append("Build ID is: ");
        sb.append(string);
        e2.d("Fabric", sb.toString());
        return string;
    }

    public static String o(Context context) {
        int a2 = a(context, "com.google.firebase.crashlytics.unity_version", "string");
        if (a2 == 0) {
            return null;
        }
        String string = context.getResources().getString(a2);
        o e2 = f.e();
        StringBuilder sb = new StringBuilder();
        sb.append("Unity Editor version is: ");
        sb.append(string);
        e2.d("Fabric", sb.toString());
        return string;
    }

    public static void c(Context context, String str) {
        if (k(context)) {
            f.e().d("Fabric", str);
        }
    }

    public static int d(Context context) {
        return context.getApplicationContext().getApplicationInfo().icon;
    }

    public static boolean c() {
        return Debug.isDebuggerConnected() || Debug.waitingForDebugger();
    }

    public static String c(Context context) {
        InputStream inputStream;
        String str = "Failed to close icon input stream.";
        String str2 = null;
        try {
            inputStream = context.getResources().openRawResource(d(context));
            try {
                String a2 = a(inputStream);
                if (!b(a2)) {
                    str2 = a2;
                }
                a((Closeable) inputStream, str);
                return str2;
            } catch (Exception e2) {
                e = e2;
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Could not calculate hash for app icon:");
                    sb.append(e.getMessage());
                    f.e().a("Fabric", sb.toString());
                    a((Closeable) inputStream, str);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    a((Closeable) inputStream, str);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            inputStream = null;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Could not calculate hash for app icon:");
            sb2.append(e.getMessage());
            f.e().a("Fabric", sb2.toString());
            a((Closeable) inputStream, str);
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            a((Closeable) inputStream, str);
            throw th;
        }
    }

    public static int a() {
        return a.a().ordinal();
    }

    static long a(String str, String str2, int i2) {
        return Long.parseLong(str.split(str2)[0].trim()) * ((long) i2);
    }

    public static RunningAppProcessInfo a(String str, Context context) {
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    return runningAppProcessInfo;
                }
            }
        }
        return null;
    }

    public static String b(InputStream inputStream) throws IOException {
        Scanner useDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        return useDelimiter.hasNext() ? useDelimiter.next() : "";
    }

    public static String b(Context context, String str) {
        int a2 = a(context, str, "string");
        return a2 > 0 ? context.getString(a2) : "";
    }

    public static String a(InputStream inputStream) {
        return a(inputStream, "SHA-1");
    }

    private static String a(String str, String str2) {
        return a(str.getBytes(), str2);
    }

    public static boolean b(String str) {
        return str == null || str.length() == 0;
    }

    private static String a(InputStream inputStream, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return a(instance.digest());
                }
                instance.update(bArr, 0, read);
            }
        } catch (Exception e2) {
            f.e().b("Fabric", "Could not calculate hash for app icon.", e2);
            return "";
        }
    }

    public static String b(int i2) {
        if (i2 >= 0) {
            return String.format(Locale.US, "%1$10s", new Object[]{Integer.valueOf(i2)}).replace(' ', '0');
        }
        throw new IllegalArgumentException("value must be zero or greater");
    }

    @SuppressLint({"MissingPermission"})
    public static boolean b(Context context) {
        if (!a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            return false;
        }
        return true;
    }

    private static String a(byte[] bArr, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            return a(instance.digest());
        } catch (NoSuchAlgorithmException e2) {
            o e3 = f.e();
            StringBuilder sb = new StringBuilder();
            sb.append("Could not create hashing algorithm: ");
            sb.append(str);
            sb.append(", returning empty string.");
            e3.b("Fabric", sb.toString(), e2);
            return "";
        }
    }

    public static String a(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : strArr) {
            if (str != null) {
                arrayList.add(str.replace("-", "").toLowerCase(Locale.US));
            }
        }
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (String append : arrayList) {
            sb.append(append);
        }
        String sb2 = sb.toString();
        if (sb2.length() > 0) {
            return c(sb2);
        }
        return null;
    }

    public static long a(Context context) {
        MemoryInfo memoryInfo = new MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static long a(String str) {
        StatFs statFs = new StatFs(str);
        long blockSize = (long) statFs.getBlockSize();
        return (((long) statFs.getBlockCount()) * blockSize) - (blockSize * ((long) statFs.getAvailableBlocks()));
    }

    public static void a(Context context, String str, Throwable th) {
        if (k(context)) {
            f.e().b("Fabric", str);
        }
    }

    public static void a(Context context, int i2, String str, String str2) {
        if (k(context)) {
            f.e().a(i2, "Fabric", str2);
        }
    }

    public static boolean a(Context context, String str, boolean z) {
        if (context != null) {
            Resources resources = context.getResources();
            if (resources != null) {
                int a2 = a(context, str, "bool");
                if (a2 > 0) {
                    return resources.getBoolean(a2);
                }
                int a3 = a(context, str, "string");
                if (a3 > 0) {
                    return Boolean.parseBoolean(context.getString(a3));
                }
            }
        }
        return z;
    }

    public static int a(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, h(context));
    }

    public static int a(Context context, boolean z) {
        Float e2 = e(context);
        if (!z || e2 == null) {
            return 1;
        }
        if (((double) e2.floatValue()) >= 99.0d) {
            return 3;
        }
        return ((double) e2.floatValue()) < 99.0d ? 2 : 0;
    }

    public static String a(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b2 = bArr[i2] & 255;
            int i3 = i2 * 2;
            char[] cArr2 = f8819b;
            cArr[i3] = cArr2[b2 >>> 4];
            cArr[i3 + 1] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public static void a(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                f.e().b("Fabric", str, e2);
            }
        }
    }

    public static void a(Flushable flushable, String str) {
        if (flushable != null) {
            try {
                flushable.flush();
            } catch (IOException e2) {
                f.e().b("Fabric", str, e2);
            }
        }
    }

    public static void a(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }
}
