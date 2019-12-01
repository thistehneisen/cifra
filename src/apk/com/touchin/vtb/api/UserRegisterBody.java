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
public class UserRegisterBody extends SessionIdBody {
    @JsonField(name = {"phoneNumber"})
    private String phoneNumber;

    public UserRegisterBody() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.phoneNumber = objectInputStream.readUTF();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this.phoneNumber);
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.phoneNumber);
    }

    public void b(String str) {
        this.phoneNumber = str;
    }

    public String c() {
        return this.phoneNumber;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || UserRegisterBody.class != obj.getClass()) {
            return false;
        }
        UserRegisterBody userRegisterBody = (UserRegisterBody) obj;
        if (!super.equals(userRegisterBody) || !c.a(this.phoneNumber, userRegisterBody.phoneNumber)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return c.a(Integer.valueOf(super.hashCode()), this.phoneNumber);
    }

    public UserRegisterBody(String str, String str2) {
        super(str2);
        this.phoneNumber = str;
    }
}
