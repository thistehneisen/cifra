package io.intercom.android.sdk.models.events;

import io.intercom.android.sdk.models.Upload;

public class UploadEvent {
    private final long size;
    private final String tempPartId;
    private final int tempPartPosition;
    private final Upload upload;

    public UploadEvent(Upload upload2, long j2, int i2, String str) {
        this.upload = upload2;
        this.size = j2;
        this.tempPartPosition = i2;
        this.tempPartId = str;
    }

    public long getSize() {
        return this.size;
    }

    public String getTempPartId() {
        return this.tempPartId;
    }

    public int getTempPartPosition() {
        return this.tempPartPosition;
    }

    public Upload getUpload() {
        return this.upload;
    }
}
