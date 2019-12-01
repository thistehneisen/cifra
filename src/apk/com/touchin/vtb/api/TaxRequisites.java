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
public class TaxRequisites extends BaseRequisites {
    @JsonField(name = {"accountNumber"})
    private String accountNumber;
    @JsonField(name = {"bankBic"})
    private String bankBic;
    @JsonField(name = {"bankName"})
    private String bankName;
    @JsonField(name = {"inn"})
    private String inn;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.inn = objectInputStream.readUTF();
        this.accountNumber = objectInputStream.readUTF();
        this.bankName = objectInputStream.readUTF();
        this.bankBic = objectInputStream.readUTF();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this.inn);
        objectOutputStream.writeUTF(this.accountNumber);
        objectOutputStream.writeUTF(this.bankName);
        objectOutputStream.writeUTF(this.bankBic);
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.inn);
        d.a(this.accountNumber);
        d.a(this.bankName);
        d.a(this.bankBic);
    }

    public void b(String str) {
        this.accountNumber = str;
    }

    public String c() {
        return this.accountNumber;
    }

    public void d(String str) {
        this.bankName = str;
    }

    public void e(String str) {
        this.inn = str;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || TaxRequisites.class != obj.getClass()) {
            return false;
        }
        TaxRequisites taxRequisites = (TaxRequisites) obj;
        if (!super.equals(taxRequisites) || !c.a(this.inn, taxRequisites.inn) || !c.a(this.accountNumber, taxRequisites.accountNumber) || !c.a(this.bankName, taxRequisites.bankName) || !c.a(this.bankBic, taxRequisites.bankBic)) {
            z = false;
        }
        return z;
    }

    public String f() {
        return this.inn;
    }

    public int hashCode() {
        return c.a(Integer.valueOf(super.hashCode()), this.inn, this.accountNumber, this.bankName, this.bankBic);
    }

    public void c(String str) {
        this.bankBic = str;
    }

    public String d() {
        return this.bankBic;
    }

    public String e() {
        return this.bankName;
    }
}
