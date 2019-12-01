package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.util.d;
import com.google.android.gms.common.util.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInAccount extends a implements ReflectedParcelable {
    public static final Creator<GoogleSignInAccount> CREATOR = new a();

    /* renamed from: a reason: collision with root package name */
    private static d f4491a = g.c();

    /* renamed from: b reason: collision with root package name */
    private final int f4492b;

    /* renamed from: c reason: collision with root package name */
    private String f4493c;

    /* renamed from: d reason: collision with root package name */
    private String f4494d;

    /* renamed from: e reason: collision with root package name */
    private String f4495e;

    /* renamed from: f reason: collision with root package name */
    private String f4496f;

    /* renamed from: g reason: collision with root package name */
    private Uri f4497g;

    /* renamed from: h reason: collision with root package name */
    private String f4498h;

    /* renamed from: i reason: collision with root package name */
    private long f4499i;

    /* renamed from: j reason: collision with root package name */
    private String f4500j;

    /* renamed from: k reason: collision with root package name */
    private List<Scope> f4501k;

    /* renamed from: l reason: collision with root package name */
    private String f4502l;
    private String m;
    private Set<Scope> n = new HashSet();

    GoogleSignInAccount(int i2, String str, String str2, String str3, String str4, Uri uri, String str5, long j2, String str6, List<Scope> list, String str7, String str8) {
        this.f4492b = i2;
        this.f4493c = str;
        this.f4494d = str2;
        this.f4495e = str3;
        this.f4496f = str4;
        this.f4497g = uri;
        this.f4498h = str5;
        this.f4499i = j2;
        this.f4500j = str6;
        this.f4501k = list;
        this.f4502l = str7;
        this.m = str8;
    }

    public static GoogleSignInAccount a(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl", null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            hashSet.add(new Scope(jSONArray.getString(i2)));
        }
        GoogleSignInAccount a2 = a(jSONObject.optString("id"), jSONObject.optString("tokenId", null), jSONObject.optString("email", null), jSONObject.optString("displayName", null), jSONObject.optString("givenName", null), jSONObject.optString("familyName", null), parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        a2.f4498h = jSONObject.optString("serverAuthCode", null);
        return a2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.f4500j.equals(this.f4500j) && googleSignInAccount.n().equals(n());
    }

    public Account f() {
        String str = this.f4495e;
        if (str == null) {
            return null;
        }
        return new Account(str, "com.google");
    }

    public String g() {
        return this.f4496f;
    }

    public String h() {
        return this.f4495e;
    }

    public int hashCode() {
        return ((this.f4500j.hashCode() + 527) * 31) + n().hashCode();
    }

    public String i() {
        return this.m;
    }

    public String j() {
        return this.f4502l;
    }

    public String k() {
        return this.f4493c;
    }

    public String l() {
        return this.f4494d;
    }

    public Uri m() {
        return this.f4497g;
    }

    public Set<Scope> n() {
        HashSet hashSet = new HashSet(this.f4501k);
        hashSet.addAll(this.n);
        return hashSet;
    }

    public String o() {
        return this.f4498h;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f4492b);
        b.a(parcel, 2, k(), false);
        b.a(parcel, 3, l(), false);
        b.a(parcel, 4, h(), false);
        b.a(parcel, 5, g(), false);
        b.a(parcel, 6, (Parcelable) m(), i2, false);
        b.a(parcel, 7, o(), false);
        b.a(parcel, 8, this.f4499i);
        b.a(parcel, 9, this.f4500j, false);
        b.b(parcel, 10, this.f4501k, false);
        b.a(parcel, 11, j(), false);
        b.a(parcel, 12, i(), false);
        b.a(parcel, a2);
    }

    private static GoogleSignInAccount a(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l2, String str7, Set<Scope> set) {
        long longValue = (l2 == null ? Long.valueOf(f4491a.currentTimeMillis() / 1000) : l2).longValue();
        q.b(str7);
        q.a(set);
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, longValue, str7, new ArrayList(set), str5, str6);
        return googleSignInAccount;
    }
}
