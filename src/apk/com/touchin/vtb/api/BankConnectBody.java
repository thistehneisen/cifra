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
public class BankConnectBody extends SessionIdBody {
    @JsonField(name = {"bankType"})
    private BankType bankType;
    @JsonField(name = {"connectedBankId"})
    private String connectedBankId;
    @JsonField(name = {"login"})
    private String login;
    @JsonField(name = {"password"})
    private String password;

    public BankConnectBody() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.connectedBankId = (String) objectInputStream.readObject();
        this.bankType = (BankType) objectInputStream.readObject();
        this.login = objectInputStream.readUTF();
        this.password = objectInputStream.readUTF();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.connectedBankId);
        objectOutputStream.writeObject(this.bankType);
        objectOutputStream.writeUTF(this.login);
        objectOutputStream.writeUTF(this.password);
    }

    public void a(BankType bankType2) {
        this.bankType = bankType2;
    }

    public void b(String str) {
        this.connectedBankId = str;
    }

    public BankType c() {
        return this.bankType;
    }

    public String d() {
        String str = this.connectedBankId;
        if (str == null) {
            return null;
        }
        return str;
    }

    public String e() {
        return this.login;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || BankConnectBody.class != obj.getClass()) {
            return false;
        }
        BankConnectBody bankConnectBody = (BankConnectBody) obj;
        if (!super.equals(bankConnectBody) || !c.a(this.connectedBankId, bankConnectBody.connectedBankId) || !c.a(this.bankType, bankConnectBody.bankType) || !c.a(this.login, bankConnectBody.login) || !c.a(this.password, bankConnectBody.password)) {
            z = false;
        }
        return z;
    }

    public String getPassword() {
        return this.password;
    }

    public int hashCode() {
        return c.a(Integer.valueOf(super.hashCode()), this.connectedBankId, this.bankType, this.login, this.password);
    }

    public BankConnectBody(String str, BankType bankType2, String str2, String str3, String str4) {
        super(str4);
        this.connectedBankId = str;
        this.bankType = bankType2;
        this.login = str2;
        this.password = str3;
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.bankType);
        d.a(this.login);
        d.a(this.password);
    }

    public void c(String str) {
        this.login = str;
    }

    public void d(String str) {
        this.password = str;
    }
}
