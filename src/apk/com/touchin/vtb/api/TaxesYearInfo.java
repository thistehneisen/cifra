package com.touchin.vtb.api;

import b.g.h.c;
import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.List;
import ru.touchin.templates.ApiModel;
import ru.touchin.templates.ApiModel.ValidationException;
import ru.touchin.templates.ApiModel.a;
import ru.touchin.templates.a.d;

@JsonObject(serializeNullObjects = false)
public class TaxesYearInfo extends d {
    @JsonField(name = {"taxPaymentsList"})
    private List<PaymentInfo> taxPaymentsList;
    @JsonField(name = {"totalAmount"})
    private Amount totalAmount;
    @JsonField(name = {"year"})
    private int year;

    public TaxesYearInfo() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.year = objectInputStream.readInt();
        this.totalAmount = (Amount) objectInputStream.readObject();
        this.taxPaymentsList = (List) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.year);
        objectOutputStream.writeObject(this.totalAmount);
        objectOutputStream.writeObject(this.taxPaymentsList);
    }

    public void a(int i2) {
        this.year = i2;
    }

    public List<PaymentInfo> b() {
        return Collections.unmodifiableList(this.taxPaymentsList);
    }

    public Amount c() {
        Amount amount = this.totalAmount;
        if (amount == null) {
            return null;
        }
        return amount;
    }

    public int d() {
        return this.year;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || TaxesYearInfo.class != obj.getClass()) {
            return false;
        }
        TaxesYearInfo taxesYearInfo = (TaxesYearInfo) obj;
        if (!c.a(Integer.valueOf(this.year), Integer.valueOf(taxesYearInfo.year)) || !c.a(this.totalAmount, taxesYearInfo.totalAmount) || !c.a(this.taxPaymentsList, taxesYearInfo.taxPaymentsList)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return c.a(Integer.valueOf(this.year), this.totalAmount, this.taxPaymentsList);
    }

    public TaxesYearInfo(int i2, Amount amount, List<PaymentInfo> list) {
        this.year = i2;
        this.totalAmount = amount;
        this.taxPaymentsList = list;
    }

    public void a(Amount amount) {
        this.totalAmount = amount;
    }

    public void a(List<PaymentInfo> list) {
        this.taxPaymentsList = list;
    }

    public void a() throws ValidationException {
        super.a();
        Amount amount = this.totalAmount;
        if ((amount instanceof ApiModel) && amount != null) {
            amount.a();
        }
        d.a(this.taxPaymentsList);
        ApiModel.a(this.taxPaymentsList, a.EXCEPTION_IF_ANY_INVALID);
    }
}
