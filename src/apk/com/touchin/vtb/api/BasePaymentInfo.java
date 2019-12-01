package com.touchin.vtb.api;

import b.g.h.c;
import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import ru.touchin.templates.ApiModel;
import ru.touchin.templates.ApiModel.ValidationException;
import ru.touchin.templates.a.d;

@JsonObject(serializeNullObjects = false)
public class BasePaymentInfo extends d {
    @JsonField(name = {"amount"})
    private Amount amount;
    @JsonField(name = {"description"})
    private String description;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.amount = (Amount) objectInputStream.readObject();
        this.description = objectInputStream.readUTF();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.amount);
        objectOutputStream.writeUTF(this.description);
    }

    public void a(Amount amount2) {
        this.amount = amount2;
    }

    public Amount b() {
        return this.amount;
    }

    public String c() {
        return this.description;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BasePaymentInfo basePaymentInfo = (BasePaymentInfo) obj;
        if (!c.a(this.amount, basePaymentInfo.amount) || !c.a(this.description, basePaymentInfo.description)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return c.a(this.amount, this.description);
    }

    public void a(String str) {
        this.description = str;
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.amount);
        Amount amount2 = this.amount;
        if (amount2 instanceof ApiModel) {
            amount2.a();
        }
        d.a(this.description);
    }
}
