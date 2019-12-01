package io.intercom.android.sdk.models;

import java.util.List;

final class AutoValue_Attribute extends Attribute {
    private final String customBotControlId;
    private final String identifier;
    private final String name;
    private final List<String> options;
    private final String type;
    private final String value;

    AutoValue_Attribute(String str, String str2, String str3, String str4, String str5, List<String> list) {
        if (str != null) {
            this.customBotControlId = str;
            if (str2 != null) {
                this.identifier = str2;
                if (str3 != null) {
                    this.name = str3;
                    if (str4 != null) {
                        this.type = str4;
                        if (str5 != null) {
                            this.value = str5;
                            if (list != null) {
                                this.options = list;
                                return;
                            }
                            throw new NullPointerException("Null options");
                        }
                        throw new NullPointerException("Null value");
                    }
                    throw new NullPointerException("Null type");
                }
                throw new NullPointerException("Null name");
            }
            throw new NullPointerException("Null identifier");
        }
        throw new NullPointerException("Null customBotControlId");
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Attribute)) {
            return false;
        }
        Attribute attribute = (Attribute) obj;
        if (!this.customBotControlId.equals(attribute.getCustomBotControlId()) || !this.identifier.equals(attribute.getIdentifier()) || !this.name.equals(attribute.getName()) || !this.type.equals(attribute.getType()) || !this.value.equals(attribute.getValue()) || !this.options.equals(attribute.getOptions())) {
            z = false;
        }
        return z;
    }

    public String getCustomBotControlId() {
        return this.customBotControlId;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getOptions() {
        return this.options;
    }

    public String getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        return ((((((((((this.customBotControlId.hashCode() ^ 1000003) * 1000003) ^ this.identifier.hashCode()) * 1000003) ^ this.name.hashCode()) * 1000003) ^ this.type.hashCode()) * 1000003) ^ this.value.hashCode()) * 1000003) ^ this.options.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Attribute{customBotControlId=");
        sb.append(this.customBotControlId);
        sb.append(", identifier=");
        sb.append(this.identifier);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", value=");
        sb.append(this.value);
        sb.append(", options=");
        sb.append(this.options);
        sb.append("}");
        return sb.toString();
    }
}
