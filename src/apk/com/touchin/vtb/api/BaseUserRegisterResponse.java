package com.touchin.vtb.api;

import b.g.h.c;
import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import ru.touchin.templates.ApiModel;
import ru.touchin.templates.ApiModel.ValidationException;
import ru.touchin.templates.a.d;

@JsonObject(serializeNullObjects = false)
public class BaseUserRegisterResponse extends d {
    @JsonField(name = {"userProfile"})
    private UserProfile userProfile;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.userProfile = (UserProfile) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.userProfile);
    }

    public void a(UserProfile userProfile2) {
        this.userProfile = userProfile2;
    }

    public UserProfile b() {
        return this.userProfile;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return c.a(this.userProfile, ((BaseUserRegisterResponse) obj).userProfile);
    }

    public int hashCode() {
        return c.a(this.userProfile);
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.userProfile);
        UserProfile userProfile2 = this.userProfile;
        if (userProfile2 instanceof ApiModel) {
            userProfile2.a();
        }
    }
}
