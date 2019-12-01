package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BankAccountsListResponse;
import com.touchin.vtb.api.BaseResponse;
import kotlin.e.a.b;
import kotlin.e.b.g;
import kotlin.e.b.h;
import kotlin.e.b.o;
import kotlin.g.e;

/* renamed from: com.touchin.vtb.f.b.m reason: case insensitive filesystem */
/* compiled from: BankRepository.kt */
final /* synthetic */ class C0660m extends g implements b<BaseResponse<BankAccountsListResponse>, BankAccountsListResponse> {

    /* renamed from: c reason: collision with root package name */
    public static final C0660m f7346c = new C0660m();

    C0660m() {
        super(1);
    }

    public final String f() {
        return "getResult";
    }

    public final e g() {
        return o.a(BaseResponse.class);
    }

    public final String i() {
        return "getResult()Ljava/lang/Object;";
    }

    public final BankAccountsListResponse a(BaseResponse<BankAccountsListResponse> baseResponse) {
        h.b(baseResponse, "p1");
        return (BankAccountsListResponse) baseResponse.d();
    }
}
