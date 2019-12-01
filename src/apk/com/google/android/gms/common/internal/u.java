package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.i;

public class u {

    /* renamed from: a reason: collision with root package name */
    private final Resources f4767a;

    /* renamed from: b reason: collision with root package name */
    private final String f4768b = this.f4767a.getResourcePackageName(i.common_google_play_services_unknown_issue);

    public u(Context context) {
        q.a(context);
        this.f4767a = context.getResources();
    }

    public String a(String str) {
        int identifier = this.f4767a.getIdentifier(str, "string", this.f4768b);
        if (identifier == 0) {
            return null;
        }
        return this.f4767a.getString(identifier);
    }
}
