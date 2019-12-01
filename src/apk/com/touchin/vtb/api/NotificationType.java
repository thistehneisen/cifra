package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.annotation.JsonEnum;

@JsonEnum
public enum NotificationType {
    TASKS,
    CONNECTION,
    QUARTER_END,
    DEADLINE,
    ACTIVITY
}
