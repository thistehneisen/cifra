package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.annotation.JsonEnum;

@JsonEnum
public enum TaskStatus {
    ACTIVE,
    IN_PROGRESS,
    COMPLETED,
    DELETED
}
