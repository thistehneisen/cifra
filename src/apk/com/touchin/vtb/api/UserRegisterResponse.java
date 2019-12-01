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
public class UserRegisterResponse extends d {
    @JsonField(name = {"smsOperationId"})
    private String smsOperationId;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.smsOperationId = objectInputStream.readUTF();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this.smsOperationId);
    }

    public void a(String str) {
        this.smsOperationId = str;
    }

    public String b() {
        return this.smsOperationId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || UserRegisterResponse.class != obj.getClass()) {
            return false;
        }
        return c.a(this.smsOperationId, ((UserRegisterResponse) obj).smsOperationId);
    }

    public int hashCode() {
        return c.a(this.smsOperationId);
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.smsOperationId);
    }
}
