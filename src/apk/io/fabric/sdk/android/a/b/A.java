package io.fabric.sdk.android.a.b;

import android.content.Context;
import io.fabric.sdk.android.a.a.b;
import io.fabric.sdk.android.a.a.d;
import io.fabric.sdk.android.f;

/* compiled from: InstallerPackageNameProvider */
public class A {

    /* renamed from: a reason: collision with root package name */
    private final d<String> f8784a = new z(this);

    /* renamed from: b reason: collision with root package name */
    private final b<String> f8785b = new b<>();

    public String a(Context context) {
        try {
            String str = (String) this.f8785b.a(context, this.f8784a);
            if ("".equals(str)) {
                str = null;
            }
            return str;
        } catch (Exception e2) {
            f.e().b("Fabric", "Failed to determine installer package name", e2);
            return null;
        }
    }
}
