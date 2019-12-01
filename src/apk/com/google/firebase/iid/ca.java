package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import b.g.a.a;
import c.b.a.b.b.d.m;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Properties;

final class ca {
    ca() {
    }

    private final ba c(Context context, String str) throws C0615d {
        try {
            ba d2 = d(context, str);
            if (d2 != null) {
                a(context, str, d2);
                return d2;
            }
            e = null;
            try {
                ba a2 = a(context.getSharedPreferences("com.google.android.gms.appid", 0), str);
                if (a2 != null) {
                    a(context, str, a2, false);
                    return a2;
                }
            } catch (C0615d e2) {
                e = e2;
            }
            if (e == null) {
                return null;
            }
            throw e;
        } catch (C0615d e3) {
            e = e3;
        }
    }

    private final ba d(Context context, String str) throws C0615d {
        File e2 = e(context, str);
        if (!e2.exists()) {
            return null;
        }
        try {
            return a(e2);
        } catch (C0615d | IOException e3) {
            String str2 = "FirebaseInstanceId";
            if (Log.isLoggable(str2, 3)) {
                String valueOf = String.valueOf(e3);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 40);
                sb.append("Failed to read key from file, retrying: ");
                sb.append(valueOf);
                Log.d(str2, sb.toString());
            }
            try {
                return a(e2);
            } catch (IOException e4) {
                String valueOf2 = String.valueOf(e4);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 45);
                sb2.append("IID file exists, but failed to read from it: ");
                sb2.append(valueOf2);
                Log.w(str2, sb2.toString());
                throw new C0615d((Exception) e4);
            }
        }
    }

    private static File e(Context context, String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "com.google.InstanceId.properties";
        } else {
            try {
                String encodeToString = Base64.encodeToString(str.getBytes("UTF-8"), 11);
                StringBuilder sb = new StringBuilder(String.valueOf(encodeToString).length() + 33);
                sb.append("com.google.InstanceId_");
                sb.append(encodeToString);
                sb.append(".properties");
                str2 = sb.toString();
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
        return new File(b(context), str2);
    }

    /* access modifiers changed from: 0000 */
    public final ba a(Context context, String str) throws C0615d {
        ba c2 = c(context, str);
        if (c2 != null) {
            return c2;
        }
        return b(context, str);
    }

    /* access modifiers changed from: 0000 */
    public final ba b(Context context, String str) {
        ba baVar = new ba(C0614c.a(), System.currentTimeMillis());
        ba a2 = a(context, str, baVar, true);
        String str2 = "FirebaseInstanceId";
        if (a2 == null || a2.equals(baVar)) {
            if (Log.isLoggable(str2, 3)) {
                Log.d(str2, "Generated new key");
            }
            a(context, str, baVar);
            return baVar;
        }
        if (Log.isLoggable(str2, 3)) {
            Log.d(str2, "Loaded key after generating new one, using loaded one");
        }
        return a2;
    }

    static void a(Context context) {
        File[] listFiles;
        for (File file : b(context).listFiles()) {
            if (file.getName().startsWith("com.google.InstanceId")) {
                file.delete();
            }
        }
    }

    private static KeyPair a(String str, String str2) throws C0615d {
        try {
            byte[] decode = Base64.decode(str, 8);
            byte[] decode2 = Base64.decode(str2, 8);
            try {
                KeyFactory instance = KeyFactory.getInstance("RSA");
                return new KeyPair(instance.generatePublic(new X509EncodedKeySpec(decode)), instance.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e2) {
                String valueOf = String.valueOf(e2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 19);
                sb.append("Invalid key stored ");
                sb.append(valueOf);
                Log.w("FirebaseInstanceId", sb.toString());
                throw new C0615d((Exception) e2);
            }
        } catch (IllegalArgumentException e3) {
            throw new C0615d((Exception) e3);
        }
    }

    private static File b(Context context) {
        File a2 = a.a(context);
        if (a2 != null && a2.isDirectory()) {
            return a2;
        }
        Log.w("FirebaseInstanceId", "noBackupFilesDir doesn't exist, using regular files directory instead");
        return context.getFilesDir();
    }

    private static long b(SharedPreferences sharedPreferences, String str) {
        String string = sharedPreferences.getString(C0634x.a(str, "cre"), null);
        if (string != null) {
            try {
                return Long.parseLong(string);
            } catch (NumberFormatException unused) {
            }
        }
        return 0;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:19:0x0060=Splitter:B:19:0x0060, B:52:0x00ba=Splitter:B:52:0x00ba, B:31:0x009e=Splitter:B:31:0x009e} */
    private final ba a(Context context, String str, ba baVar, boolean z) {
        Throwable th;
        Throwable th2;
        Throwable th3;
        Throwable th4;
        String str2 = "FirebaseInstanceId";
        if (Log.isLoggable(str2, 3)) {
            Log.d(str2, "Writing key to properties file");
        }
        Properties properties = new Properties();
        properties.setProperty("pub", baVar.b());
        properties.setProperty("pri", baVar.c());
        properties.setProperty("cre", String.valueOf(baVar.f6806b));
        File e2 = e(context, str);
        try {
            e2.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(e2, "rw");
            try {
                FileChannel channel = randomAccessFile.getChannel();
                try {
                    channel.lock();
                    if (z && channel.size() > 0) {
                        try {
                            channel.position(0);
                            ba a2 = a(channel);
                            if (channel != null) {
                                a((Throwable) null, channel);
                            }
                            a((Throwable) null, randomAccessFile);
                            return a2;
                        } catch (C0615d | IOException e3) {
                            if (Log.isLoggable(str2, 3)) {
                                String valueOf = String.valueOf(e3);
                                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 64);
                                sb.append("Tried reading key pair before writing new one, but failed with: ");
                                sb.append(valueOf);
                                Log.d(str2, sb.toString());
                            }
                        }
                    }
                    channel.position(0);
                    properties.store(Channels.newOutputStream(channel), null);
                    if (channel != null) {
                        a((Throwable) null, channel);
                    }
                    a((Throwable) null, randomAccessFile);
                    return baVar;
                } catch (Throwable th5) {
                    Throwable th6 = th5;
                    th3 = r12;
                    th4 = th6;
                }
                a(th, randomAccessFile);
                throw th2;
                if (channel != null) {
                    a(th3, channel);
                }
                throw th4;
            } catch (Throwable th7) {
                Throwable th8 = th7;
                th = r10;
                th2 = th8;
            }
        } catch (IOException e4) {
            String valueOf2 = String.valueOf(e4);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 21);
            sb2.append("Failed to write key: ");
            sb2.append(valueOf2);
            Log.w(str2, sb2.toString());
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0032, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0036, code lost:
        a(r10, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0039, code lost:
        throw r1;
     */
    private final ba a(File file) throws C0615d, IOException {
        Throwable th;
        Throwable th2;
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();
        try {
            channel.lock(0, Long.MAX_VALUE, true);
            ba a2 = a(channel);
            if (channel != null) {
                a((Throwable) null, channel);
            }
            a((Throwable) null, fileInputStream);
            return a2;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            th = r1;
            th2 = th4;
        }
        if (channel != null) {
            a(th, channel);
        }
        throw th2;
    }

    private static ba a(FileChannel fileChannel) throws C0615d, IOException {
        Properties properties = new Properties();
        properties.load(Channels.newInputStream(fileChannel));
        String property = properties.getProperty("pub");
        String property2 = properties.getProperty("pri");
        if (property == null || property2 == null) {
            throw new C0615d("Invalid properties file");
        }
        try {
            return new ba(a(property, property2), Long.parseLong(properties.getProperty("cre")));
        } catch (NumberFormatException e2) {
            throw new C0615d((Exception) e2);
        }
    }

    private static ba a(SharedPreferences sharedPreferences, String str) throws C0615d {
        String string = sharedPreferences.getString(C0634x.a(str, "|P|"), null);
        String string2 = sharedPreferences.getString(C0634x.a(str, "|K|"), null);
        if (string == null || string2 == null) {
            return null;
        }
        return new ba(a(string, string2), b(sharedPreferences, str));
    }

    private final void a(Context context, String str, ba baVar) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        try {
            if (baVar.equals(a(sharedPreferences, str))) {
                return;
            }
        } catch (C0615d unused) {
        }
        String str2 = "FirebaseInstanceId";
        if (Log.isLoggable(str2, 3)) {
            Log.d(str2, "Writing key to shared preferences");
        }
        Editor edit = sharedPreferences.edit();
        edit.putString(C0634x.a(str, "|P|"), baVar.b());
        edit.putString(C0634x.a(str, "|K|"), baVar.c());
        edit.putString(C0634x.a(str, "cre"), String.valueOf(baVar.f6806b));
        edit.commit();
    }

    private static /* synthetic */ void a(Throwable th, FileChannel fileChannel) {
        if (th != null) {
            try {
                fileChannel.close();
            } catch (Throwable th2) {
                m.a(th, th2);
            }
        } else {
            fileChannel.close();
        }
    }

    private static /* synthetic */ void a(Throwable th, RandomAccessFile randomAccessFile) {
        if (th != null) {
            try {
                randomAccessFile.close();
            } catch (Throwable th2) {
                m.a(th, th2);
            }
        } else {
            randomAccessFile.close();
        }
    }

    private static /* synthetic */ void a(Throwable th, FileInputStream fileInputStream) {
        if (th != null) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                m.a(th, th2);
            }
        } else {
            fileInputStream.close();
        }
    }
}
