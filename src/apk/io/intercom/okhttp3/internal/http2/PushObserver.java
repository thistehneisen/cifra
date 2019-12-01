package io.intercom.okhttp3.internal.http2;

import e.a.b.i;
import java.io.IOException;
import java.util.List;

public interface PushObserver {
    public static final PushObserver CANCEL = new PushObserver() {
        public boolean onData(int i2, i iVar, int i3, boolean z) throws IOException {
            iVar.skip((long) i3);
            return true;
        }

        public boolean onHeaders(int i2, List<Header> list, boolean z) {
            return true;
        }

        public boolean onRequest(int i2, List<Header> list) {
            return true;
        }

        public void onReset(int i2, ErrorCode errorCode) {
        }
    };

    boolean onData(int i2, i iVar, int i3, boolean z) throws IOException;

    boolean onHeaders(int i2, List<Header> list, boolean z);

    boolean onRequest(int i2, List<Header> list);

    void onReset(int i2, ErrorCode errorCode);
}
