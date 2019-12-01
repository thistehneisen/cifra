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
public class ConnectedBankIdBody extends SessionIdBody {
    @JsonField(name = {"connectedBankId"})
    private String connectedBankId;

    public ConnectedBankIdBody() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.connectedBankId = objectInputStream.readUTF();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this.connectedBankId);
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.connectedBankId);
    }

    public void b(String str) {
        this.connectedBankId = str;
    }

    public String c() {
        return this.connectedBankId;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ConnectedBankIdBody connectedBankIdBody = (ConnectedBankIdBody) obj;
        if (!super.equals(connectedBankIdBody) || !c.a(this.connectedBankId, connectedBankIdBody.connectedBankId)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return c.a(Integer.valueOf(super.hashCode()), this.connectedBankId);
    }

    public ConnectedBankIdBody(String str, String str2) {
        super(str2);
        this.connectedBankId = str;
    }
}
