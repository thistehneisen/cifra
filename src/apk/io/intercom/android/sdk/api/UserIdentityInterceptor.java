package io.intercom.android.sdk.api;

import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.twig.Twig;
import io.intercom.okhttp3.Interceptor;
import io.intercom.okhttp3.Interceptor.Chain;
import io.intercom.okhttp3.Response;
import java.io.IOException;

class UserIdentityInterceptor implements Interceptor {
    private static final String NO_USER_IDENTITY = "A network request was made with no user registered on this device.Please call registerUnidentifiedUser() or registerIdentifiedUser(Registration).";
    private static final String USER_IDENTITY_CHANGED = "registered user changed while this request was in flight";
    private final Twig twig = LumberMill.getLogger();
    private final UserIdentity userIdentity;

    public UserIdentityInterceptor(UserIdentity userIdentity2) {
        this.userIdentity = userIdentity2;
    }

    public Response intercept(Chain chain) throws IOException {
        if (this.userIdentity.identityExists()) {
            String fingerprint = this.userIdentity.getFingerprint();
            Response proceed = chain.proceed(chain.request());
            String str = "interceptor";
            if (fingerprint.equals(this.userIdentity.getFingerprint())) {
                this.twig.internal(str, "proceeding");
                return proceed;
            }
            this.twig.internal(str, "halting: user identity changed");
            if (proceed != null) {
                proceed.body().close();
            }
            throw new IOException(USER_IDENTITY_CHANGED);
        }
        throw new IOException(NO_USER_IDENTITY);
    }
}
