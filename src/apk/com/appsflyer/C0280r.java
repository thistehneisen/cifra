package com.appsflyer;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.security.SecureRandom;
import java.util.UUID;

/* renamed from: com.appsflyer.r reason: case insensitive filesystem */
final class C0280r {

    /* renamed from: ˋ reason: contains not printable characters */
    private static String f215;

    C0280r() {
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r1v13 */
    /* JADX WARNING: type inference failed for: r1v16 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0033 A[SYNTHETIC, Splitter:B:20:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x004a A[SYNTHETIC, Splitter:B:31:0x004a] */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* renamed from: ˊ reason: contains not printable characters */
    private static String m185(File file) {
        RandomAccessFile randomAccessFile;
        byte[] bArr;
        ? r2;
        RandomAccessFile randomAccessFile2;
        ? r1;
        String str = "Exception while trying to close the InstallationFile";
        ? r12 = 0;
        try {
            RandomAccessFile randomAccessFile3 = new RandomAccessFile(file, "r");
            try {
                r1 = r12;
                byte[] bArr2 = new byte[((int) randomAccessFile3.length())];
                randomAccessFile3.readFully(bArr2);
                randomAccessFile3.close();
                r1 = bArr2;
                try {
                    randomAccessFile3.close();
                    bArr = bArr2;
                } catch (IOException e2) {
                    AFLogger.afErrorLog(str, e2);
                    bArr = bArr2;
                }
            } catch (IOException e3) {
                e = e3;
                ? r5 = randomAccessFile3;
                r2 = r1;
                randomAccessFile2 = r5;
                try {
                    AFLogger.afErrorLog("Exception while reading InstallationFile: ", e);
                    if (randomAccessFile2 != 0) {
                    }
                    bArr = r2;
                    if (bArr == 0) {
                    }
                    return new String(bArr);
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != 0) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e4) {
                            AFLogger.afErrorLog(str, e4);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = randomAccessFile3;
                if (randomAccessFile != 0) {
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            r2 = 0;
            randomAccessFile2 = r12;
            AFLogger.afErrorLog("Exception while reading InstallationFile: ", e);
            if (randomAccessFile2 != 0) {
                try {
                    randomAccessFile2.close();
                } catch (IOException e6) {
                    AFLogger.afErrorLog(str, e6);
                }
            }
            bArr = r2;
            if (bArr == 0) {
            }
            return new String(bArr);
        }
        if (bArr == 0) {
            bArr = new byte[0];
        }
        return new String(bArr);
    }

    /* renamed from: ˏ reason: contains not printable characters */
    public static synchronized String m186(WeakReference<Context> weakReference) {
        String str;
        synchronized (C0280r.class) {
            if (weakReference.get() == null) {
                String str2 = f215;
                return str2;
            }
            if (f215 == null) {
                String str3 = null;
                if (weakReference.get() != null) {
                    str3 = AppsFlyerLib.m44((Context) weakReference.get()).getString("AF_INSTALLATION", null);
                }
                if (str3 != null) {
                    f215 = str3;
                } else {
                    try {
                        File file = new File(((Context) weakReference.get()).getFilesDir(), "AF_INSTALLATION");
                        if (!file.exists()) {
                            if (VERSION.SDK_INT >= 9) {
                                long currentTimeMillis = System.currentTimeMillis();
                                StringBuilder sb = new StringBuilder();
                                sb.append(currentTimeMillis);
                                sb.append("-");
                                sb.append(Math.abs(new SecureRandom().nextLong()));
                                str = sb.toString();
                            } else {
                                str = UUID.randomUUID().toString();
                            }
                            f215 = str;
                        } else {
                            f215 = m185(file);
                            file.delete();
                        }
                        String str4 = f215;
                        Editor edit = AppsFlyerLib.m44((Context) weakReference.get()).edit();
                        edit.putString("AF_INSTALLATION", str4);
                        if (VERSION.SDK_INT >= 9) {
                            edit.apply();
                        } else {
                            edit.commit();
                        }
                    } catch (Exception e2) {
                        AFLogger.afErrorLog("Error getting AF unique ID", e2);
                    }
                }
                if (f215 != null) {
                    AppsFlyerProperties.getInstance().set("uid", f215);
                }
            }
            String str5 = f215;
            return str5;
        }
    }
}
