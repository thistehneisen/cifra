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
public class TaxesListResponse extends d {
    @JsonField(name = {"amount"})
    private Amount amount;
    @JsonField(name = {"taxesList"})
    private List<TaxesYearInfo> taxesList;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.taxesList = (List) objectInputStream.readObject();
        this.amount = (Amount) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.taxesList);
        objectOutputStream.writeObject(this.amount);
    }

    public void a(List<TaxesYearInfo> list) {
        this.taxesList = list;
    }

    public Amount b() {
        Amount amount2 = this.amount;
        if (amount2 == null) {
            return null;
        }
        return amount2;
    }

    public List<TaxesYearInfo> c() {
        return Collections.unmodifiableList(this.taxesList);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || TaxesListResponse.class != obj.getClass()) {
            return false;
        }
        TaxesListResponse taxesListResponse = (TaxesListResponse) obj;
        if (!c.a(this.taxesList, taxesListResponse.taxesList) || !c.a(this.amount, taxesListResponse.amount)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return c.a(this.taxesList, this.amount);
    }

    public void a(Amount amount2) {
        this.amount = amount2;
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.taxesList);
        ApiModel.a(this.taxesList, a.EXCEPTION_IF_ANY_INVALID);
        Amount amount2 = this.amount;
        if ((amount2 instanceof ApiModel) && amount2 != null) {
            amount2.a();
        }
    }
}
