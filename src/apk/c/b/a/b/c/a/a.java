package c.b.a.b.c.a;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import c.b.a.b.c.e;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.g;
import com.google.android.gms.common.internal.C0307b.c;
import com.google.android.gms.common.internal.C0308c;
import com.google.android.gms.common.internal.C0312g;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.r;

public class a extends C0312g<g> implements e {
    private final boolean G;
    private final C0308c H;
    private final Bundle I;
    private Integer J;

    private a(Context context, Looper looper, boolean z, C0308c cVar, Bundle bundle, d dVar, com.google.android.gms.common.api.e eVar) {
        super(context, looper, 44, cVar, dVar, eVar);
        this.G = true;
        this.H = cVar;
        this.I = bundle;
        this.J = cVar.d();
    }

    public final void a(e eVar) {
        q.a(eVar, (Object) "Expecting a valid ISignInCallbacks");
        try {
            Account b2 = this.H.b();
            GoogleSignInAccount googleSignInAccount = null;
            if ("<<default account>>".equals(b2.name)) {
                googleSignInAccount = com.google.android.gms.auth.api.signin.a.a.a(n()).a();
            }
            ((g) r()).a(new i(new r(b2, this.J.intValue(), googleSignInAccount)), eVar);
        } catch (RemoteException e2) {
            String str = "SignInClientImpl";
            Log.w(str, "Remote service probably died when signIn is called");
            try {
                eVar.a(new k(8));
            } catch (RemoteException unused) {
                Log.wtf(str, "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e2);
            }
        }
    }

    public final void connect() {
        a((c) new d());
    }

    public int e() {
        return g.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    public boolean g() {
        return this.G;
    }

    /* access modifiers changed from: protected */
    public Bundle o() {
        if (!n().getPackageName().equals(this.H.f())) {
            this.I.putString("com.google.android.gms.signin.internal.realClientPackageName", this.H.f());
        }
        return this.I;
    }

    /* access modifiers changed from: protected */
    public String s() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    /* access modifiers changed from: protected */
    public String t() {
        return "com.google.android.gms.signin.service.START";
    }

    public a(Context context, Looper looper, boolean z, C0308c cVar, c.b.a.b.c.a aVar, d dVar, com.google.android.gms.common.api.e eVar) {
        this(context, looper, true, cVar, a(cVar), dVar, eVar);
    }

    public static Bundle a(C0308c cVar) {
        c.b.a.b.c.a h2 = cVar.h();
        Integer d2 = cVar.d();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", cVar.a());
        if (d2 != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", d2.intValue());
        }
        if (h2 != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", h2.g());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", h2.f());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", h2.d());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", h2.e());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", h2.b());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", h2.h());
            if (h2.a() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", h2.a().longValue());
            }
            if (h2.c() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", h2.c().longValue());
            }
        }
        return bundle;
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        if (queryLocalInterface instanceof g) {
            return (g) queryLocalInterface;
        }
        return new h(iBinder);
    }
}
