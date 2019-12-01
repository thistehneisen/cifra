package io.intercom.android.sdk.api;

import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.twig.Twig;
import io.intercom.retrofit2.Response;
import java.io.IOException;

public class ErrorObject {
    private final String errorBody;
    private final int statusCode;
    private final Throwable throwable;
    private final Twig twig = LumberMill.getLogger();

    ErrorObject(Throwable th, Response response) {
        this.throwable = th;
        this.errorBody = parseErrorBody(response);
        this.statusCode = parseStatusCode(response);
    }

    private String parseErrorBody(Response response) {
        if (!(response == null || response.errorBody() == null)) {
            try {
                return response.errorBody().string();
            } catch (IOException e2) {
                Twig twig2 = this.twig;
                StringBuilder sb = new StringBuilder();
                sb.append("Couldn't parse error body: ");
                sb.append(e2.getMessage());
                twig2.internal(sb.toString());
            }
        }
        return null;
    }

    private int parseStatusCode(Response response) {
        if (response != null) {
            return response.code();
        }
        return -1;
    }

    /* access modifiers changed from: 0000 */
    public String getErrorBody() {
        return this.errorBody;
    }

    /* access modifiers changed from: 0000 */
    public int getStatusCode() {
        return this.statusCode;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    /* access modifiers changed from: 0000 */
    public boolean hasErrorBody() {
        return this.errorBody != null;
    }
}
