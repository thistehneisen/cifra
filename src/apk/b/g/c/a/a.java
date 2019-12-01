package b.g.c.a;

import android.hardware.fingerprint.FingerprintManager.AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager.AuthenticationResult;
import b.g.c.a.b.C0023b;

/* compiled from: FingerprintManagerCompat */
class a extends AuthenticationCallback {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ b.g.c.a.b.a f2520a;

    a(b.g.c.a.b.a aVar) {
        this.f2520a = aVar;
    }

    public void onAuthenticationError(int i2, CharSequence charSequence) {
        this.f2520a.a(i2, charSequence);
    }

    public void onAuthenticationFailed() {
        this.f2520a.a();
    }

    public void onAuthenticationHelp(int i2, CharSequence charSequence) {
        this.f2520a.b(i2, charSequence);
    }

    public void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
        this.f2520a.a(new C0023b(b.a(authenticationResult.getCryptoObject())));
    }
}
