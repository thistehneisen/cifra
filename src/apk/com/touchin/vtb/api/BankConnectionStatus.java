package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.annotation.JsonEnum;

@JsonEnum
public enum BankConnectionStatus {
    CONNECTED,
    PASSWORD_REQUIRED,
    SMS_CODE_REQUIRED
}
