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
public class Amount extends d {
    @JsonField(name = {"currencyCode"})
    private String currencyCode;
    @JsonField(name = {"sumAmount"})
    private BigDecimal sumAmount;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.sumAmount = (BigDecimal) objectInputStream.readObject();
        this.currencyCode = objectInputStream.readUTF();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.sumAmount);
        objectOutputStream.writeUTF(this.currencyCode);
    }

    public void a(BigDecimal bigDecimal) {
        this.sumAmount = bigDecimal;
    }

    public String b() {
        return this.currencyCode;
    }

    public BigDecimal c() {
        return this.sumAmount;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || Amount.class != obj.getClass()) {
            return false;
        }
        Amount amount = (Amount) obj;
        if (!c.a(this.sumAmount, amount.sumAmount) || !c.a(this.currencyCode, amount.currencyCode)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return c.a(this.sumAmount, this.currencyCode);
    }

    public void a(String str) {
        this.currencyCode = str;
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.sumAmount);
        d.a(this.currencyCode);
    }
}
