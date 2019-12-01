package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.annotation.JsonEnum;

@JsonEnum
public enum PaymentSystem {
    AMERICAN_EXPRESS,
    MAESTRO,
    MASTERCARD,
    VISA,
    DINERS_CLUB,
    JCB_INTERNATIONAL,
    DISCOVER,
    CHINA_UNIONPAY
}
