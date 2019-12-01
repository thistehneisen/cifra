package com.touchin.vtb.services;

import com.touchin.vtb.api.NotificationType;

public final /* synthetic */ class a {

    /* renamed from: a reason: collision with root package name */
    public static final /* synthetic */ int[] f7605a = new int[NotificationType.values().length];

    /* renamed from: b reason: collision with root package name */
    public static final /* synthetic */ int[] f7606b = new int[NotificationType.values().length];

    static {
        f7605a[NotificationType.ACTIVITY.ordinal()] = 1;
        f7606b[NotificationType.CONNECTION.ordinal()] = 1;
        f7606b[NotificationType.ACTIVITY.ordinal()] = 2;
        f7606b[NotificationType.QUARTER_END.ordinal()] = 3;
        f7606b[NotificationType.DEADLINE.ordinal()] = 4;
    }
}
