package io.intercom.android.sdk.api;

import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.twig.Twig;
import io.intercom.okhttp3.Interceptor;
import io.intercom.okhttp3.Interceptor.Chain;
import io.intercom.okhttp3.Response;
import io.intercom.okhttp3.ResponseBody;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class ShutdownInterceptor implements Interceptor {
    private static final String ERROR = "error";
    private static final String MESSAGE = "message";
    private static final String MESSENGER_SHUTDOWN_RESPONSE = "messenger_shutdown_response";
    private static final String SHUTDOWN_PERIOD = "shutdown_period";
    private static final String TYPE = "type";
    private final ShutdownState shutdownState;
    private final Twig twig = LumberMill.getLogger();

    public ShutdownInterceptor(ShutdownState shutdownState2) {
        this.shutdownState = shutdownState2;
    }

    public Response intercept(Chain chain) throws IOException {
        if (this.shutdownState.canSendNetworkRequests()) {
            Response proceed = chain.proceed(chain.request());
            if (!proceed.isSuccessful()) {
                ResponseBody body = proceed.body();
                String string = body.string();
                proceed = proceed.newBuilder().body(ResponseBody.create(body.contentType(), string)).build();
                body.close();
                try {
                    JSONObject jSONObject = new JSONObject(string).getJSONObject(ERROR);
                    if (jSONObject.getString(TYPE).equals(MESSENGER_SHUTDOWN_RESPONSE)) {
                        long j2 = jSONObject.getLong(SHUTDOWN_PERIOD);
                        this.shutdownState.updateShutdownState(TimeUnit.SECONDS.toMillis(j2), jSONObject.getString("message"));
                    }
                } catch (JSONException unused) {
                    Twig twig2 = this.twig;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to deserialise error response: `");
                    sb.append(string);
                    sb.append("` message: `");
                    sb.append(proceed.message());
                    sb.append("`");
                    twig2.internal(sb.toString());
                }
            }
            return proceed;
        }
        this.twig.e(this.shutdownState.getShutdownReason(), new Object[0]);
        throw new IOException(this.shutdownState.getShutdownReason());
    }
}
