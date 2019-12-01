package io.intercom.android.sdk;

import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.twig.Twig;
import io.intercom.android.sdk.utilities.CustomAttributeValidator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Company {
    private static final String COMPANY_ID = "id";
    private static final String CREATED_AT = "created_at";
    private static final String CUSTOM_ATTRIBUTES = "custom_attributes";
    private static final String MONTHLY_SPEND = "monthly_spend";
    private static final String NAME = "name";
    private static final String PLAN = "plan";
    /* access modifiers changed from: private */
    public static final Twig TWIG = LumberMill.getLogger();
    private final Map<String, Object> attributes;
    private final Map<String, Object> customAttributes;

    public static final class Builder {
        final Map<String, Object> attributes = new HashMap();
        final Map<String, Object> customAttributes = new HashMap();

        public Company build() {
            return new Company(this);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Builder.class != obj.getClass()) {
                return false;
            }
            Builder builder = (Builder) obj;
            if (!this.attributes.equals(builder.attributes)) {
                return false;
            }
            return this.customAttributes.equals(builder.customAttributes);
        }

        public int hashCode() {
            return (this.attributes.hashCode() * 31) + this.customAttributes.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Builder{attributes=");
            sb.append(this.attributes);
            sb.append(", customAttributes=");
            sb.append(this.customAttributes);
            sb.append('}');
            return sb.toString();
        }

        public Builder withCompanyId(String str) {
            this.attributes.put(Company.COMPANY_ID, str);
            return this;
        }

        public Builder withCreatedAt(Long l2) {
            this.attributes.put(Company.CREATED_AT, l2);
            return this;
        }

        public Builder withCustomAttribute(String str, Object obj) {
            if (str == null) {
                Twig access$000 = Company.TWIG;
                StringBuilder sb = new StringBuilder();
                sb.append("The key you provided was null for the attribute ");
                sb.append(obj);
                access$000.w(sb.toString(), new Object[0]);
            } else if (CustomAttributeValidator.isValid(obj)) {
                this.customAttributes.put(str, obj);
            } else {
                Twig access$0002 = Company.TWIG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("The custom company attribute ");
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
                Company.TWIG.w("The map of attributes you provided was null.", new Object[0]);
            } else {
                for (Entry entry : map.entrySet()) {
                    if (CustomAttributeValidator.isValid(entry.getValue())) {
                        this.customAttributes.put(entry.getKey(), entry.getValue());
                    } else {
                        Twig access$000 = Company.TWIG;
                        StringBuilder sb = new StringBuilder();
                        sb.append("The custom company attribute ");
                        sb.append((String) entry.getKey());
                        sb.append(" was of type ");
                        sb.append(entry.getClass().getSimpleName());
                        sb.append(" We only accept the following types: ");
                        sb.append(CustomAttributeValidator.getAcceptedTypes());
                        access$000.w(sb.toString(), new Object[0]);
                    }
                }
            }
            return this;
        }

        public Builder withMonthlySpend(Integer num) {
            this.attributes.put(Company.MONTHLY_SPEND, num);
            return this;
        }

        public Builder withName(String str) {
            this.attributes.put(Company.NAME, str);
            return this;
        }

        public Builder withPlan(String str) {
            this.attributes.put(Company.PLAN, str);
            return this;
        }
    }

    Company(Builder builder) {
        this.attributes = builder.attributes;
        this.customAttributes = builder.customAttributes;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Company.class != obj.getClass()) {
            return false;
        }
        Company company = (Company) obj;
        if (!this.attributes.equals(company.attributes)) {
            return false;
        }
        return this.customAttributes.equals(company.customAttributes);
    }

    /* access modifiers changed from: 0000 */
    public Map<String, Object> getAttributes() {
        if (!this.customAttributes.isEmpty()) {
            this.attributes.put(CUSTOM_ATTRIBUTES, this.customAttributes);
        }
        return this.attributes;
    }

    public int hashCode() {
        return (this.attributes.hashCode() * 31) + this.customAttributes.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Company{attributes=");
        sb.append(this.attributes);
        sb.append(", customAttributes=");
        sb.append(this.customAttributes);
        sb.append('}');
        return sb.toString();
    }
}
