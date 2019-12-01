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
public class CompanyTaxesChangeBody extends SessionIdBody {
    @JsonField(name = {"taxSystem"})
    private TaxSystem taxSystem;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.taxSystem = (TaxSystem) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.taxSystem);
    }

    public void a(TaxSystem taxSystem2) {
        this.taxSystem = taxSystem2;
    }

    public TaxSystem c() {
        return this.taxSystem;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || CompanyTaxesChangeBody.class != obj.getClass()) {
            return false;
        }
        CompanyTaxesChangeBody companyTaxesChangeBody = (CompanyTaxesChangeBody) obj;
        if (!super.equals(companyTaxesChangeBody) || !c.a(this.taxSystem, companyTaxesChangeBody.taxSystem)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return c.a(Integer.valueOf(super.hashCode()), this.taxSystem);
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.taxSystem);
    }
}
