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
public class TaxPaymentResponse extends d {
    @JsonField(name = {"smsOperationId"})
    private String smsOperationId;
    @JsonField(name = {"taxPaymentStatus"})
    private TaxPaymentStatus taxPaymentStatus;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.taxPaymentStatus = (TaxPaymentStatus) objectInputStream.readObject();
        this.smsOperationId = (String) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.taxPaymentStatus);
        objectOutputStream.writeObject(this.smsOperationId);
    }

    public void a(TaxPaymentStatus taxPaymentStatus2) {
        this.taxPaymentStatus = taxPaymentStatus2;
    }

    public String b() {
        String str = this.smsOperationId;
        if (str == null) {
            return null;
        }
        return str;
    }

    public TaxPaymentStatus c() {
        return this.taxPaymentStatus;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || TaxPaymentResponse.class != obj.getClass()) {
            return false;
        }
        TaxPaymentResponse taxPaymentResponse = (TaxPaymentResponse) obj;
        if (!c.a(this.taxPaymentStatus, taxPaymentResponse.taxPaymentStatus) || !c.a(this.smsOperationId, taxPaymentResponse.smsOperationId)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return c.a(this.taxPaymentStatus, this.smsOperationId);
    }

    public void a(String str) {
        this.smsOperationId = str;
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.taxPaymentStatus);
    }
}
