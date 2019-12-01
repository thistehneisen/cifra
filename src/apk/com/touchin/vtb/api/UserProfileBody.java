package com.touchin.vtb.api;

import b.g.h.c;
import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import ru.touchin.templates.ApiModel.ValidationException;

@JsonObject(serializeNullObjects = false)
public class UserProfileBody extends SessionIdBody {
    @JsonField(name = {"phoneNumber"})
    private String phoneNumber;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.phoneNumber = (String) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.phoneNumber);
    }

    public void a() throws ValidationException {
        super.a();
    }

    public void b(String str) {
        this.phoneNumber = str;
    }

    public String c() {
        String str = this.phoneNumber;
        if (str == null) {
            return null;
        }
        return str;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || UserProfileBody.class != obj.getClass()) {
            return false;
        }
        UserProfileBody userProfileBody = (UserProfileBody) obj;
        if (!super.equals(userProfileBody) || !c.a(this.phoneNumber, userProfileBody.phoneNumber)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return c.a(Integer.valueOf(super.hashCode()), this.phoneNumber);
    }
}
