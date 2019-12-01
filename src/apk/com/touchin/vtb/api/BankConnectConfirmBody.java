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
public class BankConnectConfirmBody extends ConnectedBankIdBody {
    @JsonField(name = {"code"})
    private String code;

    public BankConnectConfirmBody() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.code = objectInputStream.readUTF();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this.code);
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.code);
    }

    public void c(String str) {
        this.code = str;
    }

    public String d() {
        return this.code;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || BankConnectConfirmBody.class != obj.getClass()) {
            return false;
        }
        BankConnectConfirmBody bankConnectConfirmBody = (BankConnectConfirmBody) obj;
        if (!super.equals(bankConnectConfirmBody) || !c.a(this.code, bankConnectConfirmBody.code)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return c.a(Integer.valueOf(super.hashCode()), this.code);
    }

    public BankConnectConfirmBody(String str, String str2, String str3) {
        super(str2, str3);
        this.code = str;
    }
}
