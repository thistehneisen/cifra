package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.a.b.n;
import io.fabric.sdk.android.a.c.c;
import io.fabric.sdk.android.a.c.d;
import io.fabric.sdk.android.a.e.b;
import java.io.IOException;
import java.util.UUID;

class SessionAnalyticsFilesManager extends c<SessionEvent> {
    private static final String SESSION_ANALYTICS_TO_SEND_FILE_EXTENSION = ".tap";
    private static final String SESSION_ANALYTICS_TO_SEND_FILE_PREFIX = "sa";
    private b analyticsSettingsData;

    SessionAnalyticsFilesManager(Context context, SessionEventTransform sessionEventTransform, n nVar, d dVar) throws IOException {
        super(context, sessionEventTransform, nVar, dVar, 100);
    }

    /* access modifiers changed from: protected */
    public String generateUniqueRollOverFileName() {
        UUID randomUUID = UUID.randomUUID();
        StringBuilder sb = new StringBuilder();
        sb.append(SESSION_ANALYTICS_TO_SEND_FILE_PREFIX);
        String str = c.ROLL_OVER_FILE_NAME_SEPARATOR;
        sb.append(str);
        sb.append(randomUUID.toString());
        sb.append(str);
        sb.append(this.currentTimeProvider.a());
        sb.append(SESSION_ANALYTICS_TO_SEND_FILE_EXTENSION);
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public int getMaxByteSizePerFile() {
        b bVar = this.analyticsSettingsData;
        return bVar == null ? super.getMaxByteSizePerFile() : bVar.f8898c;
    }

    /* access modifiers changed from: protected */
    public int getMaxFilesToKeep() {
        b bVar = this.analyticsSettingsData;
        return bVar == null ? super.getMaxFilesToKeep() : bVar.f8900e;
    }

    /* access modifiers changed from: 0000 */
    public void setAnalyticsSettingsData(b bVar) {
        this.analyticsSettingsData = bVar;
    }
}
