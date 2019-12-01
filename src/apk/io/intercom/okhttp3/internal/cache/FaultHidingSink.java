package io.intercom.okhttp3.internal.cache;

import e.a.b.A;
import e.a.b.g;
import e.a.b.k;
import java.io.IOException;

class FaultHidingSink extends k {
    private boolean hasErrors;

    FaultHidingSink(A a2) {
        super(a2);
    }

    public void close() throws IOException {
        if (!this.hasErrors) {
            try {
                super.close();
            } catch (IOException e2) {
                this.hasErrors = true;
                onException(e2);
            }
        }
    }

    public void flush() throws IOException {
        if (!this.hasErrors) {
            try {
                super.flush();
            } catch (IOException e2) {
                this.hasErrors = true;
                onException(e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onException(IOException iOException) {
    }

    public void write(g gVar, long j2) throws IOException {
        if (this.hasErrors) {
            gVar.skip(j2);
            return;
        }
        try {
            super.write(gVar, j2);
        } catch (IOException e2) {
            this.hasErrors = true;
            onException(e2);
        }
    }
}
