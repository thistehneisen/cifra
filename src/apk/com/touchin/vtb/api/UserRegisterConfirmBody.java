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
public class UserRegisterConfirmBody extends SessionIdBody {
    @JsonField(name = {"code"})
    private String code;
    @JsonField(name = {"smsOperationId"})
    private String smsOperationId;

    public UserRegisterConfirmBody() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.smsOperationId = objectInputStream.readUTF();
        this.code = objectInputStream.readUTF();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this.smsOperationId);
        objectOutputStream.writeUTF(this.code);
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.smsOperationId);
        d.a(this.code);
    }

    public void b(String str) {
        this.code = str;
    }

    public void c(String str) {
        this.smsOperationId = str;
    }

    public String d() {
        return this.smsOperationId;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UserRegisterConfirmBody userRegisterConfirmBody = (UserRegisterConfirmBody) obj;
        if (!super.equals(userRegisterConfirmBody) || !c.a(this.smsOperationId, userRegisterConfirmBody.smsOperationId) || !c.a(this.code, userRegisterConfirmBody.code)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return c.a(Integer.valueOf(super.hashCode()), this.smsOperationId, this.code);
    }

    public UserRegisterConfirmBody(String str, String str2, String str3) {
        super(str3);
        this.smsOperationId = str;
        this.code = str2;
    }

    public String c() {
        return this.code;
    }
}
