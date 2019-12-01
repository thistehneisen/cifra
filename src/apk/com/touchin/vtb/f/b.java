package com.touchin.vtb.f;

import com.touchin.vtb.api.AccountType;
import kotlin.e.b.h;

/* compiled from: BankCardModel.kt */
public final class b {

    /* renamed from: a reason: collision with root package name */
    private final String f7263a;

    /* renamed from: b reason: collision with root package name */
    private final String f7264b;

    /* renamed from: c reason: collision with root package name */
    private final String f7265c;

    /* renamed from: d reason: collision with root package name */
    private final Integer f7266d;

    /* renamed from: e reason: collision with root package name */
    private final Integer f7267e;

    /* renamed from: f reason: collision with root package name */
    private final Integer f7268f;

    /* renamed from: g reason: collision with root package name */
    private final String f7269g;

    /* renamed from: h reason: collision with root package name */
    private final String f7270h;

    /* renamed from: i reason: collision with root package name */
    private final Integer f7271i;

    /* renamed from: j reason: collision with root package name */
    private final Integer f7272j;

    /* renamed from: k reason: collision with root package name */
    private final AccountType f7273k;

    public b(String str, String str2, String str3, Integer num, Integer num2, Integer num3, String str4, String str5, Integer num4, Integer num5, AccountType accountType) {
        h.b(str, "id");
        h.b(str2, "connectedBankId");
        h.b(str3, "title");
        h.b(str4, "amountWithCurrency");
        h.b(str5, "cardNumber");
        h.b(accountType, "accountType");
        this.f7263a = str;
        this.f7264b = str2;
        this.f7265c = str3;
        this.f7266d = num;
        this.f7267e = num2;
        this.f7268f = num3;
        this.f7269g = str4;
        this.f7270h = str5;
        this.f7271i = num4;
        this.f7272j = num5;
        this.f7273k = accountType;
    }

    public final AccountType a() {
        return this.f7273k;
    }

    public final String b() {
        return this.f7269g;
    }

    public final Integer c() {
        return this.f7268f;
    }

    public final Integer d() {
        return this.f7267e;
    }

    public final String e() {
        return this.f7270h;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0074, code lost:
        if (kotlin.e.b.h.a((java.lang.Object) r2.f7273k, (java.lang.Object) r3.f7273k) != false) goto L_0x0079;
     */
    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (h.a((Object) this.f7263a, (Object) bVar.f7263a)) {
                    if (h.a((Object) this.f7264b, (Object) bVar.f7264b)) {
                        if (h.a((Object) this.f7265c, (Object) bVar.f7265c)) {
                            if (h.a((Object) this.f7266d, (Object) bVar.f7266d)) {
                                if (h.a((Object) this.f7267e, (Object) bVar.f7267e)) {
                                    if (h.a((Object) this.f7268f, (Object) bVar.f7268f)) {
                                        if (h.a((Object) this.f7269g, (Object) bVar.f7269g)) {
                                            if (h.a((Object) this.f7270h, (Object) bVar.f7270h)) {
                                                if (h.a((Object) this.f7271i, (Object) bVar.f7271i)) {
                                                    if (h.a((Object) this.f7272j, (Object) bVar.f7272j)) {
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final Integer f() {
        return this.f7271i;
    }

    public final String g() {
        return this.f7264b;
    }

    public final String h() {
        return this.f7263a;
    }

    public int hashCode() {
        String str = this.f7263a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f7264b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f7265c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Integer num = this.f7266d;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.f7267e;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.f7268f;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 31;
        String str4 = this.f7269g;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f7270h;
        int hashCode8 = (hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Integer num4 = this.f7271i;
        int hashCode9 = (hashCode8 + (num4 != null ? num4.hashCode() : 0)) * 31;
        Integer num5 = this.f7272j;
        int hashCode10 = (hashCode9 + (num5 != null ? num5.hashCode() : 0)) * 31;
        AccountType accountType = this.f7273k;
        if (accountType != null) {
            i2 = accountType.hashCode();
        }
        return hashCode10 + i2;
    }

    public final Integer i() {
        return this.f7272j;
    }

    public final String j() {
        return this.f7265c;
    }

    public final Integer k() {
        return this.f7266d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BankCardModel(id=");
        sb.append(this.f7263a);
        sb.append(", connectedBankId=");
        sb.append(this.f7264b);
        sb.append(", title=");
        sb.append(this.f7265c);
        sb.append(", titleColorResId=");
        sb.append(this.f7266d);
        sb.append(", cardColorResId=");
        sb.append(this.f7267e);
        sb.append(", bankLogoResId=");
        sb.append(this.f7268f);
        sb.append(", amountWithCurrency=");
        sb.append(this.f7269g);
        sb.append(", cardNumber=");
        sb.append(this.f7270h);
        sb.append(", cardNumberColorResId=");
        sb.append(this.f7271i);
        sb.append(", paymentSystemLogoResId=");
        sb.append(this.f7272j);
        sb.append(", accountType=");
        sb.append(this.f7273k);
        sb.append(")");
        return sb.toString();
    }
}
