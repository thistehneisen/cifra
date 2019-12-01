package io.intercom.android.sdk.conversation;

public interface UploadProgressListener {
    void uploadNotice(byte b2);

    void uploadStarted();

    void uploadStopped();
}
