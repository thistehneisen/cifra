package com.touchin.vtb.api;

import b.g.h.c;
import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import ru.touchin.templates.ApiModel.ValidationException;
import ru.touchin.templates.a.d;

@JsonObject(serializeNullObjects = false)
public class DaDataStatus extends d {
    @JsonField(name = {"registration_date"})
    private BigDecimal registrationDate;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.registrationDate = (BigDecimal) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.registrationDate);
    }

    public void a(BigDecimal bigDecimal) {
        this.registrationDate = bigDecimal;
    }

    public BigDecimal b() {
        return this.registrationDate;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DaDataStatus.class != obj.getClass()) {
            return false;
        }
        return c.a(this.registrationDate, ((DaDataStatus) obj).registrationDate);
    }

    public int hashCode() {
        return c.a(this.registrationDate);
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.registrationDate);
    }
}
