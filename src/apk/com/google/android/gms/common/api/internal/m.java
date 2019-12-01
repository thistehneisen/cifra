package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.C0298a.C0062a;

final class m implements C0062a {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ C0299b f4614a;

    m(C0299b bVar) {
        this.f4614a = bVar;
    }

    public final void a(boolean z) {
        this.f4614a.q.sendMessage(this.f4614a.q.obtainMessage(1, Boolean.valueOf(z)));
    }
}
