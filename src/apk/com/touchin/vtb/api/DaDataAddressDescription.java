package com.touchin.vtb.api;

import b.g.h.c;
import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import ru.touchin.templates.ApiModel.ValidationException;
import ru.touchin.templates.a.d;

@JsonObject(serializeNullObjects = false)
public class DaDataAddressDescription extends d {
    @JsonField(name = {"city_with_type"})
    private String cityWithType;
    @JsonField(name = {"street_with_type"})
    private String streetWithType;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.cityWithType = (String) objectInputStream.readObject();
        this.streetWithType = (String) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.cityWithType);
        objectOutputStream.writeObject(this.streetWithType);
    }

    public void a(String str) {
        this.cityWithType = str;
    }

    public String b() {
        String str = this.cityWithType;
        if (str == null) {
            return null;
        }
        return str;
    }

    public String c() {
        String str = this.streetWithType;
        if (str == null) {
            return null;
        }
        return str;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || DaDataAddressDescription.class != obj.getClass()) {
            return false;
        }
        DaDataAddressDescription daDataAddressDescription = (DaDataAddressDescription) obj;
        if (!c.a(this.cityWithType, daDataAddressDescription.cityWithType) || !c.a(this.streetWithType, daDataAddressDescription.streetWithType)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return c.a(this.cityWithType, this.streetWithType);
    }

    public void a() throws ValidationException {
        super.a();
    }

    public void b(String str) {
        this.streetWithType = str;
    }
}
