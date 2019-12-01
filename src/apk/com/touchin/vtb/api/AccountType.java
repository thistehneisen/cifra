package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.annotation.JsonEnum;

@JsonEnum
public enum AccountType {
    ACCOUNT,
    CARD,
    CREDIT,
    DEPOSIT,
    CELL,
    WALLET
}
