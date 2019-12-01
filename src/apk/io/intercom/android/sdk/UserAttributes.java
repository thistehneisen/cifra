package io.intercom.android.sdk;

import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.twig.Twig;
import io.intercom.android.sdk.utilities.CustomAttributeValidator;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

public class UserAttributes {
    private static final String COMPANIES = "companies";
    private static final String CUSTOM_ATTRIBUTES = "custom_attributes";
    private static final String EMAIL = "email";
    private static final String LANGUAGE_OVERRIDE = "language_override";
    private static final String NAME = "name";
    private static final String PHONE = "phone";
    private static final String SIGNED_UP_AT = "signed_up_at";
    /* access modifiers changed from: private */
    public static final Twig TWIG = LumberMill.getLogger();
    private static final String UNSUBSCRIBED_FROM_EMAILS = "unsubscribed_from_emails";
    private static final String USER_ID = "user_id";
    private final Map<String, Object> attributes;
    private final List<Map<String, Object>> companies;
    private final Map<String, Object> customAttributes;

    public static final class Builder {
        final Map<String, Object> attributes = new HashMap();
        final List<Map<String, Object>> companies = new ArrayList();
        final Map<String, Object> customAttributes = new HashMap();

        public UserAttributes build() {
            return new UserAttributes(this);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Builder.class != obj.getClass()) {
                return false;
            }
            Builder builder = (Builder) obj;
            if (this.attributes.equals(builder.attributes) && this.customAttributes.equals(builder.customAttributes)) {
                return this.companies.equals(builder.companies);
            }
            return false;
        }

        public int hashCode() {
            return (((this.attributes.hashCode() * 31) + this.customAttributes.hashCode()) * 31) + this.companies.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Builder{attributes=");
            sb.append(this.attributes);
            sb.append(", customAttributes=");
            sb.append(this.customAttributes);
            sb.append(", companies=");
            sb.append(this.companies);
            sb.append('}');
            return sb.toString();
        }

        public Builder withCompany(Company company) {
            if (company == null) {
                UserAttributes.TWIG.w("The company you provided was null", new Object[0]);
            } else {
                this.companies.add(company.getAttributes());
            }
            return this;
        }

        public Builder withCustomAttribute(String str, Object obj) {
            if (str == null) {
                Twig access$000 = UserAttributes.TWIG;
                StringBuilder sb = new StringBuilder();
                sb.append("The key you provided was null for the attribute ");
                sb.append(obj);
                access$000.w(sb.toString(), new Object[0]);
            } else if (CustomAttributeValidator.isValid(obj)) {
                this.customAttributes.put(str, obj);
            } else {
                Twig access$0002 = UserAttributes.TWIG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("The custom user attribute ");
                sb2.append(str);
                sb2.append(" was of type ");
                sb2.append(obj.getClass().getSimpleName());
                sb2.append(" We only accept the following types: ");
                sb2.append(CustomAttributeValidator.getAcceptedTypes());
                access$0002.w(sb2.toString(), new Object[0]);
            }
            return this;
        }

        public Builder withCustomAttributes(Map<String, ?> map) {
            if (map == null) {
                UserAttributes.TWIG.w("The map of attributes you provided was null.", new Object[0]);
            } else {
                for (Entry entry : map.entrySet()) {
                    Object value = entry.getValue();
                    if (CustomAttributeValidator.isValid(value)) {
                        this.customAttributes.put(entry.getKey(), value);
                    } else {
                        Twig access$000 = UserAttributes.TWIG;
                        StringBuilder sb = new StringBuilder();
                        sb.append("The custom user attribute ");
                        sb.append((String) entry.getKey());
                        sb.append(" was of type ");
                        sb.append(value.getClass().getSimpleName());
                        sb.append(" We only accept the following types: ");
                        sb.append(CustomAttributeValidator.getAcceptedTypes());
                        access$000.w(sb.toString(), new Object[0]);
                    }
                }
            }
            return this;
        }

        public Builder withEmail(String str) {
            this.attributes.put("email", str);
            return this;
        }

        public Builder withLanguageOverride(String str) {
            this.attributes.put(UserAttributes.LANGUAGE_OVERRIDE, str);
            return this;
        }

        public Builder withName(String str) {
            this.attributes.put(UserAttributes.NAME, str);
            return this;
        }

        public Builder withPhone(String str) {
            this.attributes.put("phone", str);
            return this;
        }

        public Builder withSignedUpAt(Long l2) {
            this.attributes.put(UserAttributes.SIGNED_UP_AT, l2);
            return this;
        }

        public Builder withUnsubscribedFromEmails(Boolean bool) {
            this.attributes.put(UserAttributes.UNSUBSCRIBED_FROM_EMAILS, bool);
            return this;
        }

        public Builder withUserId(String str) {
            this.attributes.put(UserAttributes.USER_ID, str);
            return this;
        }

        public Builder withSignedUpAt(Date date) {
            return withSignedUpAt(date == null ? null : Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(date.getTime())));
        }
    }

    UserAttributes(Builder builder) {
        this.attributes = builder.attributes;
        this.customAttributes = builder.customAttributes;
        this.companies = builder.companies;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || UserAttributes.class != obj.getClass()) {
            return false;
        }
        UserAttributes userAttributes = (UserAttributes) obj;
        if (this.attributes.equals(userAttributes.attributes) && this.customAttributes.equals(userAttributes.customAttributes)) {
            return this.companies.equals(userAttributes.companies);
        }
        return false;
    }

    public int hashCode() {
        return (((this.attributes.hashCode() * 31) + this.customAttributes.hashCode()) * 31) + this.companies.hashCode();
    }

    public boolean isEmpty() {
        return this.attributes.isEmpty() && this.customAttributes.isEmpty() && this.companies.isEmpty();
    }

    public Map<String, Object> toMap() {
        if (!this.customAttributes.isEmpty()) {
            this.attributes.put(CUSTOM_ATTRIBUTES, this.customAttributes);
        }
        if (!this.companies.isEmpty()) {
            this.attributes.put(COMPANIES, this.companies);
        }
        return this.attributes;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserAttributes{attributes=");
        sb.append(this.attributes);
        sb.append(", customAttributes=");
        sb.append(this.customAttributes);
        sb.append(", companies=");
        sb.append(this.companies);
        sb.append('}');
        return sb.toString();
    }
}
