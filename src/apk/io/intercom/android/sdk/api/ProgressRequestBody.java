package io.intercom.android.sdk.api;

import e.a.b.B;
import e.a.b.h;
import e.a.b.t;
import io.intercom.android.sdk.conversation.UploadProgressListener;
import io.intercom.okhttp3.MediaType;
import io.intercom.okhttp3.RequestBody;
import io.intercom.okhttp3.internal.Util;
import java.io.File;
import java.io.IOException;

class ProgressRequestBody extends RequestBody {
    private static final int SEGMENT_SIZE = 2048;
    private final MediaType contentType;
    private final File file;
    private final UploadProgressListener listener;

    public ProgressRequestBody(MediaType mediaType, File file2, UploadProgressListener uploadProgressListener) {
        this.contentType = mediaType;
        this.file = file2;
        this.listener = uploadProgressListener;
    }

    public long contentLength() {
        return this.file.length();
    }

    public MediaType contentType() {
        return this.contentType;
    }

    public void writeTo(h hVar) throws IOException {
        B b2 = null;
        try {
            b2 = t.c(this.file);
            long j2 = 0;
            while (true) {
                long read = b2.read(hVar.n(), 2048);
                if (read != -1) {
                    j2 += read;
                    hVar.flush();
                    this.listener.uploadNotice((byte) ((int) ((((double) ((100 * j2) / this.file.length())) * 0.8d) + 10.0d)));
                } else {
                    return;
                }
            }
        } finally {
            Util.closeQuietly(b2);
        }
    }
}
