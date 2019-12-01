package io.intercom.android.sdk.models;

import java.util.List;

final class AutoValue_Form extends Form {
    private final List<Attribute> attributes;
    private final String type;

    AutoValue_Form(List<Attribute> list, String str) {
        if (list != null) {
            this.attributes = list;
            if (str != null) {
                this.type = str;
                return;
            }
            throw new NullPointerException("Null type");
        }
        throw new NullPointerException("Null attributes");
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Form)) {
            return false;
        }
        Form form = (Form) obj;
        if (!this.attributes.equals(form.getAttributes()) || !this.type.equals(form.getType())) {
            z = false;
        }
        return z;
    }

    public List<Attribute> getAttributes() {
        return this.attributes;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        return ((this.attributes.hashCode() ^ 1000003) * 1000003) ^ this.type.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Form{attributes=");
        sb.append(this.attributes);
        sb.append(", type=");
        sb.append(this.type);
        sb.append("}");
        return sb.toString();
    }
}
