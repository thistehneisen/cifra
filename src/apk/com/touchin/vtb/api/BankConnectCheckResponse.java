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
public class BankConnectCheckResponse extends d {
    @JsonField(name = {"bankConnectionStatus"})
    private BankConnectionStatus bankConnectionStatus;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.bankConnectionStatus = (BankConnectionStatus) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.bankConnectionStatus);
    }

    public void a(BankConnectionStatus bankConnectionStatus2) {
        this.bankConnectionStatus = bankConnectionStatus2;
    }

    public BankConnectionStatus b() {
        return this.bankConnectionStatus;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || BankConnectCheckResponse.class != obj.getClass()) {
            return false;
        }
        return c.a(this.bankConnectionStatus, ((BankConnectCheckResponse) obj).bankConnectionStatus);
    }

    public int hashCode() {
        return c.a(this.bankConnectionStatus);
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.bankConnectionStatus);
    }
}
