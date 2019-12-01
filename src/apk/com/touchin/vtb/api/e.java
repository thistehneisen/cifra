package com.touchin.vtb.api;

import e.b.o;
import retrofit2.a.a;
import retrofit2.a.l;

/* compiled from: BankApi.kt */
public interface e {
    @l("bank/connect")
    o<BaseResponse<BankConnectResponse>> a(@a BankConnectBody bankConnectBody);

    @l("bank/connect/confirm")
    o<BaseResponse<Boolean>> a(@a BankConnectConfirmBody bankConnectConfirmBody);

    @l("bank/connect/statuses")
    o<BaseResponse<BankConnectStatusesResponse>> a(@a BankConnectStatusesBody bankConnectStatusesBody);

    @l("bank/account/operation/list")
    o<BaseResponse<BankOperationsListResponse>> a(@a BankOperationsListBody bankOperationsListBody);

    @l("bank/connect/check")
    o<BaseResponse<BankConnectCheckResponse>> a(@a ConnectedBankIdBody connectedBankIdBody);

    @l("bank/account/list")
    o<BaseResponse<BankAccountsListResponse>> a(@a TicketIdBody ticketIdBody);

    @l("bank/delete")
    o<BaseResponse<Boolean>> b(@a ConnectedBankIdBody connectedBankIdBody);
}
