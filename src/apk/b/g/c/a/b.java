package b.g.c.a;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.os.Handler;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@Deprecated
/* compiled from: FingerprintManagerCompat */
public final class b {

    /* renamed from: a reason: collision with root package name */
    private final Context f2521a;

    /* compiled from: FingerprintManagerCompat */
    public static abstract class a {
        public abstract void a();

        public abstract void a(int i2, CharSequence charSequence);

        public abstract void a(C0023b bVar);

        public abstract void b(int i2, CharSequence charSequence);
    }

    /* renamed from: b.g.c.a.b$b reason: collision with other inner class name */
    /* compiled from: FingerprintManagerCompat */
    public static final class C0023b {

        /* renamed from: a reason: collision with root package name */
        private final c f2522a;

        public C0023b(c cVar) {
            this.f2522a = cVar;
        }
    }

    /* compiled from: FingerprintManagerCompat */
    public static class c {

        /* renamed from: a reason: collision with root package name */
        private final Signature f2523a;

        /* renamed from: b reason: collision with root package name */
        private final Cipher f2524b;

        /* renamed from: c reason: collision with root package name */
        private final Mac f2525c;

        public c(Signature signature) {
            this.f2523a = signature;
            this.f2524b = null;
            this.f2525c = null;
        }

        public Cipher a() {
            return this.f2524b;
        }

        public Mac b() {
            return this.f2525c;
        }

        public Signature c() {
            return this.f2523a;
        }

        public c(Cipher cipher) {
            this.f2524b = cipher;
            this.f2523a = null;
            this.f2525c = null;
        }

        public c(Mac mac) {
            this.f2525c = mac;
            this.f2524b = null;
            this.f2523a = null;
        }
    }

    private b(Context context) {
        this.f2521a = context;
    }

    public static b a(Context context) {
        return new b(context);
    }

    public boolean b() {
        if (VERSION.SDK_INT < 23) {
            return false;
        }
        FingerprintManager b2 = b(this.f2521a);
        if (b2 == null || !b2.isHardwareDetected()) {
            return false;
        }
        return true;
    }

    public boolean a() {
        if (VERSION.SDK_INT < 23) {
            return false;
        }
        FingerprintManager b2 = b(this.f2521a);
        if (b2 == null || !b2.hasEnrolledFingerprints()) {
            return false;
        }
        return true;
    }

    private static FingerprintManager b(Context context) {
        int i2 = VERSION.SDK_INT;
        if (i2 == 23) {
            return (FingerprintManager) context.getSystemService(FingerprintManager.class);
        }
        if (i2 <= 23 || !context.getPackageManager().hasSystemFeature("android.hardware.fingerprint")) {
            return null;
        }
        return (FingerprintManager) context.getSystemService(FingerprintManager.class);
    }

    public void a(c cVar, int i2, androidx.core.os.a aVar, a aVar2, Handler handler) {
        if (VERSION.SDK_INT >= 23) {
            FingerprintManager b2 = b(this.f2521a);
            if (b2 != null) {
                b2.authenticate(a(cVar), aVar != null ? (CancellationSignal) aVar.b() : null, i2, a(aVar2), handler);
            }
        }
    }

    private static CryptoObject a(c cVar) {
        CryptoObject cryptoObject = null;
        if (cVar == null) {
            return null;
        }
        if (cVar.a() != null) {
            return new CryptoObject(cVar.a());
        }
        if (cVar.c() != null) {
            return new CryptoObject(cVar.c());
        }
        if (cVar.b() != null) {
            cryptoObject = new CryptoObject(cVar.b());
        }
        return cryptoObject;
    }

    static c a(CryptoObject cryptoObject) {
        c cVar = null;
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new c(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new c(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() != null) {
            cVar = new c(cryptoObject.getMac());
        }
        return cVar;
    }

    private static AuthenticationCallback a(a aVar) {
        return new a(aVar);
    }
}
