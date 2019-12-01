package com.appsflyer;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec.Builder;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Calendar;
import java.util.Enumeration;
import javax.security.auth.x500.X500Principal;

class AFKeystoreWrapper {

    /* renamed from: ˊ reason: contains not printable characters */
    private String f17;

    /* renamed from: ˋ reason: contains not printable characters */
    private Context f18;

    /* renamed from: ˎ reason: contains not printable characters */
    private KeyStore f19;

    /* renamed from: ˏ reason: contains not printable characters */
    private final Object f20 = new Object();

    /* renamed from: ॱ reason: contains not printable characters */
    private int f21;

    public AFKeystoreWrapper(Context context) {
        this.f18 = context;
        this.f17 = "";
        this.f21 = 0;
        AFLogger.afInfoLog("Initialising KeyStore..");
        try {
            this.f19 = KeyStore.getInstance("AndroidKeyStore");
            this.f19.load(null);
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e2) {
            AFLogger.afErrorLog("Couldn't load keystore instance of type: AndroidKeyStore", e2);
        }
    }

    /* renamed from: ˏ reason: contains not printable characters */
    private String m8() {
        StringBuilder sb = new StringBuilder();
        sb.append("com.appsflyer,");
        synchronized (this.f20) {
            sb.append("KSAppsFlyerId=");
            sb.append(this.f17);
            sb.append(",");
            sb.append("KSAppsFlyerRICounter=");
            sb.append(this.f21);
        }
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˊ reason: contains not printable characters */
    public final void m9() {
        String r0 = m8();
        synchronized (this.f20) {
            this.f21++;
            AFLogger.afInfoLog("Deleting key with alias: ".concat(String.valueOf(r0)));
            try {
                synchronized (this.f20) {
                    this.f19.deleteEntry(r0);
                }
            } catch (KeyStoreException e2) {
                StringBuilder sb = new StringBuilder("Exception ");
                sb.append(e2.getMessage());
                sb.append(" occurred");
                AFLogger.afErrorLog(sb.toString(), e2);
            }
        }
        m7(m8());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˋ reason: contains not printable characters */
    public final int m10() {
        int i2;
        synchronized (this.f20) {
            i2 = this.f21;
        }
        return i2;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        r1 = r4.split(",");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002d, code lost:
        if (r1.length != 3) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        com.appsflyer.AFLogger.afInfoLog("Found a matching AF key with alias:\n".concat(java.lang.String.valueOf(r4)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r3 = r1[1].trim().split("=");
        r1 = r1[2].trim().split("=");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0056, code lost:
        if (r3.length != 2) goto L_0x008f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0059, code lost:
        if (r1.length != 2) goto L_0x008f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005b, code lost:
        r7.f17 = r3[1].trim();
        r7.f21 = java.lang.Integer.parseInt(r1[1].trim());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0070, code lost:
        r1 = th;
     */
    /* renamed from: ˎ reason: contains not printable characters */
    public final boolean m11() {
        boolean z;
        synchronized (this.f20) {
            z = true;
            if (this.f19 != null) {
                try {
                    Enumeration aliases = this.f19.aliases();
                    while (true) {
                        if (!aliases.hasMoreElements()) {
                            break;
                        }
                        String str = (String) aliases.nextElement();
                        if (str != null && str.startsWith("com.appsflyer")) {
                            break;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    z = false;
                    StringBuilder sb = new StringBuilder("Couldn't list KeyStore Aliases: ");
                    sb.append(th.getClass().getName());
                    AFLogger.afErrorLog(sb.toString(), th);
                    return z;
                }
            }
            z = false;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ॱ reason: contains not printable characters */
    public final void m13(String str) {
        this.f17 = str;
        this.f21 = 0;
        m7(m8());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ॱ reason: contains not printable characters */
    public final String m12() {
        String str;
        synchronized (this.f20) {
            str = this.f17;
        }
        return str;
    }

    /* renamed from: ˎ reason: contains not printable characters */
    private void m7(String str) {
        AFLogger.afInfoLog("Creating a new key with alias: ".concat(String.valueOf(str)));
        try {
            Calendar instance = Calendar.getInstance();
            Calendar instance2 = Calendar.getInstance();
            boolean z = true;
            instance2.add(1, 5);
            AlgorithmParameterSpec algorithmParameterSpec = null;
            synchronized (this.f20) {
                if (!this.f19.containsAlias(str)) {
                    if (VERSION.SDK_INT >= 23) {
                        algorithmParameterSpec = new Builder(str, 3).setCertificateSubject(new X500Principal("CN=AndroidSDK, O=AppsFlyer")).setCertificateSerialNumber(BigInteger.ONE).setCertificateNotBefore(instance.getTime()).setCertificateNotAfter(instance2.getTime()).build();
                    } else if (VERSION.SDK_INT >= 18) {
                        if (!"OPPO".equals(Build.BRAND)) {
                            z = false;
                        }
                        if (!z) {
                            algorithmParameterSpec = new KeyPairGeneratorSpec.Builder(this.f18).setAlias(str).setSubject(new X500Principal("CN=AndroidSDK, O=AppsFlyer")).setSerialNumber(BigInteger.ONE).setStartDate(instance.getTime()).setEndDate(instance2.getTime()).build();
                        }
                    }
                    KeyPairGenerator instance3 = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                    instance3.initialize(algorithmParameterSpec);
                    instance3.generateKeyPair();
                } else {
                    AFLogger.afInfoLog("Alias already exists: ".concat(String.valueOf(str)));
                }
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("Exception ");
            sb.append(th.getMessage());
            sb.append(" occurred");
            AFLogger.afErrorLog(sb.toString(), th);
        }
    }
}
