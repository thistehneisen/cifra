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
public class ConnectedBank extends d {
    @JsonField(name = {"bankType"})
    private BankType bankType;
    @JsonField(name = {"connectedBankId"})
    private String connectedBankId;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.connectedBankId = objectInputStream.readUTF();
        this.bankType = (BankType) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this.connectedBankId);
        objectOutputStream.writeObject(this.bankType);
    }

    public void a(String str) {
        this.connectedBankId = str;
    }

    public BankType b() {
        return this.bankType;
    }

    public String c() {
        return this.connectedBankId;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || ConnectedBank.class != obj.getClass()) {
            return false;
        }
        ConnectedBank connectedBank = (ConnectedBank) obj;
        if (!c.a(this.connectedBankId, connectedBank.connectedBankId) || !c.a(this.bankType, connectedBank.bankType)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return c.a(this.connectedBankId, this.bankType);
    }

    public void a(BankType bankType2) {
        this.bankType = bankType2;
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.connectedBankId);
        d.a(this.bankType);
    }
}
