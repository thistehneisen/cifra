package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.annotation.JsonEnum;

@JsonEnum
public enum TaxPaymentStatus {
    CREATED,
    ERROR,
    SMS_CODE_REQUIRED,
    COMPLETED
}
