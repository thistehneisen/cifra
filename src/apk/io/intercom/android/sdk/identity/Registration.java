package io.intercom.android.sdk.identity;

import android.text.TextUtils;
import io.intercom.android.sdk.UserAttributes;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.twig.Twig;

public class Registration {
    private UserAttributes attributes;
    private String email;
    private final Twig twig = LumberMill.getLogger();
    private String userId;
    private Validity validity;

    private enum Validity {
        NOT_SET,
        INVALID,
        VALID
    }

    public Registration() {
        String str = "";
        this.email = str;
        this.userId = str;
        this.validity = Validity.NOT_SET;
    }

    public static Registration create() {
        return new Registration();
    }

    private void updateState(boolean z) {
        Validity validity2 = this.validity;
        if (validity2 == Validity.NOT_SET || validity2 == Validity.VALID) {
            this.validity = z ? Validity.VALID : Validity.INVALID;
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || Registration.class != obj.getClass()) {
            return false;
        }
        Registration registration = (Registration) obj;
        if (!this.email.equals(registration.email) || !this.userId.equals(registration.userId)) {
            return false;
        }
        UserAttributes userAttributes = this.attributes;
        if (userAttributes != null) {
            z = userAttributes.equals(registration.attributes);
        } else if (registration.attributes != null) {
            z = false;
        }
        return z;
    }

    public UserAttributes getAttributes() {
        return this.attributes;
    }

    public String getEmail() {
        return this.email;
    }

    public String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int hashCode = ((this.email.hashCode() * 31) + this.userId.hashCode()) * 31;
        UserAttributes userAttributes = this.attributes;
        return hashCode + (userAttributes != null ? userAttributes.hashCode() : 0);
    }

    /* access modifiers changed from: 0000 */
    public boolean isValidRegistration() {
        return Validity.VALID.equals(this.validity);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Registration{email='");
        sb.append(this.email);
        sb.append('\'');
        sb.append(", userId='");
        sb.append(this.userId);
        sb.append('\'');
        sb.append(", attributes=");
        sb.append(this.attributes);
        sb.append('}');
        return sb.toString();
    }

    public Registration withEmail(String str) {
        boolean z = !TextUtils.isEmpty(str);
        if (z) {
            this.email = str;
        } else {
            this.twig.e("Email cannot be null or empty", new Object[0]);
        }
        updateState(z);
        return this;
    }

    public Registration withUserAttributes(UserAttributes userAttributes) {
        if (userAttributes == null) {
            this.validity = Validity.INVALID;
            this.twig.e("Registration.withUserAttributes method failed: the attributes Map provided is null", new Object[0]);
        } else if (userAttributes.isEmpty()) {
            this.validity = Validity.INVALID;
            this.twig.e("Registration.withUserAttributes method failed: the attributes Map provided is empty", new Object[0]);
        } else {
            this.attributes = userAttributes;
        }
        return this;
    }

    public Registration withUserId(String str) {
        boolean z = !TextUtils.isEmpty(str);
        if (z) {
            this.userId = str;
        } else {
            this.twig.e("UserId cannot be null or empty", new Object[0]);
        }
        updateState(z);
        return this;
    }
}
