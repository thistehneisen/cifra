package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.a.b.l;
import io.fabric.sdk.android.a.b.y;
import io.fabric.sdk.android.a.b.y.a;
import java.util.Map;
import java.util.UUID;

class SessionMetadataCollector {
    private final Context context;
    private final y idManager;
    private final String versionCode;
    private final String versionName;

    public SessionMetadataCollector(Context context2, y yVar, String str, String str2) {
        this.context = context2;
        this.idManager = yVar;
        this.versionCode = str;
        this.versionName = str2;
    }

    public SessionEventMetadata getMetadata() {
        Map e2 = this.idManager.e();
        SessionEventMetadata sessionEventMetadata = new SessionEventMetadata(this.idManager.c(), UUID.randomUUID().toString(), this.idManager.d(), this.idManager.k(), (String) e2.get(a.FONT_TOKEN), l.n(this.context), this.idManager.j(), this.idManager.g(), this.versionCode, this.versionName);
        return sessionEventMetadata;
    }
}
