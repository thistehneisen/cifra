package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BankType;
import com.touchin.vtb.api.CompanyInfo;
import com.touchin.vtb.api.ConnectedBank;
import com.touchin.vtb.api.UserProfile;
import e.b.j.a;
import java.util.Iterator;
import java.util.List;
import kotlin.e.b.h;
import ru.touchin.roboswag.core.utils.b;

/* compiled from: UserProfileRepository.kt */
public final class sa {

    /* renamed from: a reason: collision with root package name */
    private final a<b<UserProfile>> f7373a;

    public sa() {
        a<b<UserProfile>> j2 = a.j();
        h.a((Object) j2, "BehaviorSubject.create<Optional<UserProfile>>()");
        this.f7373a = j2;
    }

    public final void a(b<UserProfile> bVar) {
        h.b(bVar, "userProfile");
        this.f7373a.a(bVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0021  */
    public final String b() {
        String str;
        b bVar = (b) this.f7373a.k();
        if (bVar != null) {
            UserProfile userProfile = (UserProfile) bVar.a();
            if (userProfile != null) {
                CompanyInfo b2 = userProfile.b();
                if (b2 != null) {
                    str = b2.h();
                    return str == null ? str : "";
                }
            }
        }
        str = null;
        if (str == null) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARNING: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    public final String c() {
        String str;
        b bVar = (b) this.f7373a.k();
        if (bVar != null) {
            UserProfile userProfile = (UserProfile) bVar.a();
            if (userProfile != null) {
                str = userProfile.d();
                return str == null ? str : "";
            }
        }
        str = null;
        if (str == null) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0021  */
    public final String d() {
        String str;
        b bVar = (b) this.f7373a.k();
        if (bVar != null) {
            UserProfile userProfile = (UserProfile) bVar.a();
            if (userProfile != null) {
                CompanyInfo b2 = userProfile.b();
                if (b2 != null) {
                    str = b2.d();
                    return str == null ? str : "";
                }
            }
        }
        str = null;
        if (str == null) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARNING: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    public final String e() {
        String str;
        b bVar = (b) this.f7373a.k();
        if (bVar != null) {
            UserProfile userProfile = (UserProfile) bVar.a();
            if (userProfile != null) {
                str = userProfile.e();
                return str == null ? str : "";
            }
        }
        str = null;
        if (str == null) {
        }
    }

    public final a<b<UserProfile>> f() {
        return this.f7373a;
    }

    public final BankType a(String str) {
        Object obj;
        h.b(str, "connectedBankId");
        b bVar = (b) this.f7373a.k();
        if (bVar == null) {
            return null;
        }
        UserProfile userProfile = (UserProfile) bVar.a();
        if (userProfile == null) {
            return null;
        }
        List c2 = userProfile.c();
        if (c2 == null) {
            return null;
        }
        Iterator it = c2.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            ConnectedBank connectedBank = (ConnectedBank) obj;
            h.a((Object) connectedBank, "connectedBank");
            if (h.a((Object) connectedBank.c(), (Object) str)) {
                break;
            }
        }
        ConnectedBank connectedBank2 = (ConnectedBank) obj;
        if (connectedBank2 != null) {
            return connectedBank2.b();
        }
        return null;
    }

    public final void a() {
        this.f7373a.a(new b(null));
    }
}
