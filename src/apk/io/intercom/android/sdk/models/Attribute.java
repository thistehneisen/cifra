package io.intercom.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import io.intercom.android.sdk.commons.utilities.CollectionUtils;
import io.intercom.android.sdk.utilities.NullSafety;
import io.intercom.android.sdk.views.holder.AttributeType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Attribute implements Parcelable {
    private static final String BOOLEAN_TYPE = "boolean";
    public static final Creator<Attribute> CREATOR = new Creator<Attribute>() {
        public Attribute createFromParcel(Parcel parcel) {
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, String.class.getClassLoader());
            return Attribute.create(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), arrayList);
        }

        public Attribute[] newArray(int i2) {
            return new Attribute[i2];
        }
    };
    private static final String DATE_TYPE = "date";
    private static final String FLOAT_TYPE = "float";
    private static final String INTEGER_TYPE = "integer";
    public static final Attribute NULL;
    private static final String STRING_TYPE = "string";

    public static final class Builder {
        String custom_bot_control_id;
        String identifier;
        String name;
        List<String> options;
        String type;
        String value;

        public Attribute build() {
            ArrayList arrayList = new ArrayList(CollectionUtils.capacityFor(this.options));
            List<String> list = this.options;
            if (list != null) {
                for (String str : list) {
                    if (str != null) {
                        arrayList.add(str);
                    }
                }
            }
            return Attribute.create(NullSafety.valueOrEmpty(this.custom_bot_control_id), NullSafety.valueOrEmpty(this.identifier), NullSafety.valueOrEmpty(this.name), NullSafety.valueOrEmpty(this.type), NullSafety.valueOrEmpty(this.value), arrayList);
        }

        public Builder withCustomBotControlId(String str) {
            this.custom_bot_control_id = str;
            return this;
        }

        public Builder withIdentifier(String str) {
            this.identifier = str;
            return this;
        }

        public Builder withName(String str) {
            this.name = str;
            return this;
        }

        public Builder withOptions(List<String> list) {
            this.options = list;
            return this;
        }

        public Builder withType(String str) {
            this.type = str;
            return this;
        }

        public Builder withValue(String str) {
            this.value = str;
            return this;
        }
    }

    static {
        String str = "";
        NULL = create(str, str, str, str, str);
    }

    static Attribute create(String str, String str2, String str3, String str4, String str5) {
        AutoValue_Attribute autoValue_Attribute = new AutoValue_Attribute(str, str2, str3, str4, str5, Collections.emptyList());
        return autoValue_Attribute;
    }

    public int describeContents() {
        return 0;
    }

    public abstract String getCustomBotControlId();

    public abstract String getIdentifier();

    public abstract String getName();

    public abstract List<String> getOptions();

    public String getRenderType() {
        char c2;
        String type = getType();
        String str = "float";
        String str2 = "boolean";
        String str3 = "date";
        switch (type.hashCode()) {
            case -891985903:
                if (type.equals(STRING_TYPE)) {
                    c2 = 0;
                    break;
                }
            case 3076014:
                if (type.equals(str3)) {
                    c2 = 4;
                    break;
                }
            case 64711720:
                if (type.equals(str2)) {
                    c2 = 3;
                    break;
                }
            case 97526364:
                if (type.equals(str)) {
                    c2 = 2;
                    break;
                }
            case 1958052158:
                if (type.equals(INTEGER_TYPE)) {
                    c2 = 1;
                    break;
                }
            default:
                c2 = 65535;
                break;
        }
        if (c2 != 0) {
            if (c2 == 1) {
                return AttributeType.NUMBER;
            }
            if (c2 == 2) {
                return str;
            }
            if (c2 != 3) {
                return c2 != 4 ? AttributeType.UNKNOWN : str3;
            }
            return str2;
        } else if (!getOptions().isEmpty()) {
            return AttributeType.LIST;
        } else {
            String str4 = "email";
            if (str4.equals(getIdentifier())) {
                return str4;
            }
            String identifier = getIdentifier();
            String str5 = AttributeType.PHONE;
            if (str5.equals(identifier)) {
                return str5;
            }
            String identifier2 = getIdentifier();
            String str6 = AttributeType.WEBSITE;
            return str6.equals(identifier2) ? str6 : AttributeType.TEXT;
        }
    }

    public abstract String getType();

    public abstract String getValue();

    public boolean hasValue() {
        return !TextUtils.isEmpty(getValue());
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeList(getOptions());
        parcel.writeString(getCustomBotControlId());
        parcel.writeString(getIdentifier());
        parcel.writeString(getName());
        parcel.writeString(getType());
        parcel.writeString(getValue());
    }

    static Attribute create(String str, String str2, String str3, String str4, String str5, List<String> list) {
        AutoValue_Attribute autoValue_Attribute = new AutoValue_Attribute(str, str2, str3, str4, str5, list);
        return autoValue_Attribute;
    }
}
