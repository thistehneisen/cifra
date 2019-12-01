package io.fabric.sdk.android.a.b;

import android.content.Context;
import io.fabric.sdk.android.a.a.d;

/* compiled from: InstallerPackageNameProvider */
class z implements d<String> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ A f8878a;

    z(A a2) {
        this.f8878a = a2;
    }

    public String load(Context context) throws Exception {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName == null ? "" : installerPackageName;
    }
}
