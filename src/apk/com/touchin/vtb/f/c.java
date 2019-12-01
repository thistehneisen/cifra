package com.touchin.vtb.f;

import com.touchin.vtb.api.BankConnectCheckResponse;
import kotlin.e.b.h;

/* compiled from: CheckBankModel.kt */
public final class c {

    /* renamed from: a reason: collision with root package name */
    private final BankConnectCheckResponse f7388a;

    /* renamed from: b reason: collision with root package name */
    private final String f7389b;

    public c(BankConnectCheckResponse bankConnectCheckResponse, String str) {
        h.b(bankConnectCheckResponse, "bankConnectCheckResponse");
        h.b(str, "connectedBankId");
        this.f7388a = bankConnectCheckResponse;
        this.f7389b = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (kotlin.e.b.h.a((java.lang.Object) r2.f7389b, (java.lang.Object) r3.f7389b) != false) goto L_0x001f;
     */
    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (h.a((Object) this.f7388a, (Object) cVar.f7388a)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        BankConnectCheckResponse bankConnectCheckResponse = this.f7388a;
        int i2 = 0;
        int hashCode = (bankConnectCheckResponse != null ? bankConnectCheckResponse.hashCode() : 0) * 31;
        String str = this.f7389b;
        if (str != null) {
            i2 = str.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CheckBankModel(bankConnectCheckResponse=");
        sb.append(this.f7388a);
        sb.append(", connectedBankId=");
        sb.append(this.f7389b);
        sb.append(")");
        return sb.toString();
    }
}
