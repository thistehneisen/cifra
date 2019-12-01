package io.intercom.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import io.intercom.android.sdk.commons.utilities.CollectionUtils;
import io.intercom.android.sdk.utilities.NullSafety;
import java.util.ArrayList;
import java.util.List;

public abstract class Form implements Parcelable {
    public static final Creator<Form> CREATOR = new Creator<Form>() {
        public Form createFromParcel(Parcel parcel) {
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, Attribute.class.getClassLoader());
            return Form.create(arrayList, parcel.readString());
        }

        public Form[] newArray(int i2) {
            return new Form[i2];
        }
    };
    public static final Form NULL = create(new ArrayList(), "");

    public static final class Builder {
        List<io.intercom.android.sdk.models.Attribute.Builder> attributes;
        String type;

        public Form build() {
            ArrayList arrayList = new ArrayList(CollectionUtils.capacityFor(this.attributes));
            List<io.intercom.android.sdk.models.Attribute.Builder> list = this.attributes;
            if (list != null) {
                for (io.intercom.android.sdk.models.Attribute.Builder builder : list) {
                    if (builder != null) {
                        arrayList.add(builder.build());
                    }
                }
            }
            return Form.create(arrayList, NullSafety.valueOrEmpty(this.type));
        }

        public Builder withAttributes(List<io.intercom.android.sdk.models.Attribute.Builder> list) {
            this.attributes = list;
            return this;
        }

        public Builder withType(String str) {
            this.type = str;
            return this;
        }
    }

    static Form create(List<Attribute> list, String str) {
        return new AutoValue_Form(list, str);
    }

    public int describeContents() {
        return 0;
    }

    public abstract List<Attribute> getAttributes();

    public abstract String getType();

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeList(getAttributes());
        parcel.writeString(getType());
    }
}
