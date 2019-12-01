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
public class BankConnectResponse extends d {
    @JsonField(name = {"bankConnectionStatus"})
    private BankConnectionStatus bankConnectionStatus;
    @JsonField(name = {"connectedBankId"})
    private String connectedBankId;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.bankConnectionStatus = (BankConnectionStatus) objectInputStream.readObject();
        this.connectedBankId = objectInputStream.readUTF();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.bankConnectionStatus);
        objectOutputStream.writeUTF(this.connectedBankId);
    }

    public void a(BankConnectionStatus bankConnectionStatus2) {
        this.bankConnectionStatus = bankConnectionStatus2;
    }

    public BankConnectionStatus b() {
        return this.bankConnectionStatus;
    }

    public String c() {
        return this.connectedBankId;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || BankConnectResponse.class != obj.getClass()) {
            return false;
        }
        BankConnectResponse bankConnectResponse = (BankConnectResponse) obj;
        if (!c.a(this.bankConnectionStatus, bankConnectResponse.bankConnectionStatus) || !c.a(this.connectedBankId, bankConnectResponse.connectedBankId)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return c.a(this.bankConnectionStatus, this.connectedBankId);
    }

    public void a(String str) {
        this.connectedBankId = str;
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.bankConnectionStatus);
        d.a(this.connectedBankId);
    }
}
