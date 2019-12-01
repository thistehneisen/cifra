package com.touchin.vtb.api;

import b.g.h.c;
import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import ru.touchin.templates.ApiModel.ValidationException;

@JsonObject(serializeNullObjects = false)
public class UserRegisterConfirmResponse extends BaseUserRegisterResponse {
    @JsonField(name = {"success"})
    private boolean success;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.success = objectInputStream.readBoolean();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeBoolean(this.success);
    }

    public void a(boolean z) {
        this.success = z;
    }

    public boolean c() {
        return this.success;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || UserRegisterConfirmResponse.class != obj.getClass()) {
            return false;
        }
        UserRegisterConfirmResponse userRegisterConfirmResponse = (UserRegisterConfirmResponse) obj;
        if (!super.equals(userRegisterConfirmResponse) || !c.a(Boolean.valueOf(this.success), Boolean.valueOf(userRegisterConfirmResponse.success))) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return c.a(Integer.valueOf(super.hashCode()), Boolean.valueOf(this.success));
    }

    public void a() throws ValidationException {
        super.a();
    }
}
