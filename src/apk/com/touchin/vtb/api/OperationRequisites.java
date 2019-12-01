package com.touchin.vtb.api;

import b.g.h.c;
import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import ru.touchin.templates.ApiModel.ValidationException;

@JsonObject(serializeNullObjects = false)
public class OperationRequisites extends BaseRequisites {
    @JsonField(name = {"accountNumber"})
    private String accountNumber;
    @JsonField(name = {"bankBic"})
    private String bankBic;
    @JsonField(name = {"bankName"})
    private String bankName;
    @JsonField(name = {"inn"})
    private String inn;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.inn = (String) objectInputStream.readObject();
        this.accountNumber = (String) objectInputStream.readObject();
        this.bankName = (String) objectInputStream.readObject();
        this.bankBic = (String) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.inn);
        objectOutputStream.writeObject(this.accountNumber);
        objectOutputStream.writeObject(this.bankName);
        objectOutputStream.writeObject(this.bankBic);
    }

    public void a() throws ValidationException {
        super.a();
    }

    public void b(String str) {
        this.accountNumber = str;
    }

    public String c() {
        String str = this.accountNumber;
        if (str == null) {
            return null;
        }
        return str;
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
        if (obj == null || OperationRequisites.class != obj.getClass()) {
            return false;
        }
        OperationRequisites operationRequisites = (OperationRequisites) obj;
        if (!super.equals(operationRequisites) || !c.a(this.inn, operationRequisites.inn) || !c.a(this.accountNumber, operationRequisites.accountNumber) || !c.a(this.bankName, operationRequisites.bankName) || !c.a(this.bankBic, operationRequisites.bankBic)) {
            z = false;
        }
        return z;
    }

    public String f() {
        String str = this.inn;
        if (str == null) {
            return null;
        }
        return str;
    }

    public int hashCode() {
        return c.a(Integer.valueOf(super.hashCode()), this.inn, this.accountNumber, this.bankName, this.bankBic);
    }

    public void c(String str) {
        this.bankBic = str;
    }

    public String d() {
        String str = this.bankBic;
        if (str == null) {
            return null;
        }
        return str;
    }

    public String e() {
        String str = this.bankName;
        if (str == null) {
            return null;
        }
        return str;
    }
}
