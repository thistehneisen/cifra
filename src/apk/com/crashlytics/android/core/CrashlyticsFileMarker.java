package com.crashlytics.android.core;

import io.fabric.sdk.android.a.d.a;
import io.fabric.sdk.android.f;
import io.fabric.sdk.android.o;
import java.io.File;
import java.io.IOException;

class CrashlyticsFileMarker {
    private final a fileStore;
    private final String markerName;

    public CrashlyticsFileMarker(String str, a aVar) {
        this.markerName = str;
        this.fileStore = aVar;
    }

    private File getMarkerFile() {
        return new File(this.fileStore.a(), this.markerName);
    }

    public boolean create() {
        try {
            return getMarkerFile().createNewFile();
        } catch (IOException e2) {
            o e3 = f.e();
            StringBuilder sb = new StringBuilder();
            sb.append("Error creating marker: ");
            sb.append(this.markerName);
            e3.b(CrashlyticsCore.TAG, sb.toString(), e2);
            return false;
        }
    }

    public boolean isPresent() {
        return getMarkerFile().exists();
    }

    public boolean remove() {
        return getMarkerFile().delete();
    }
}
