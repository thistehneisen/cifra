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
public class UserSessionCreateBody extends d {
    @JsonField(name = {"appVersion"})
    private String appVersion;
    @JsonField(name = {"model"})
    private String model;
    @JsonField(name = {"osVersion"})
    private String osVersion;
    @JsonField(name = {"platform"})
    private Platform platform;

    public UserSessionCreateBody() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.platform = (Platform) objectInputStream.readObject();
        this.osVersion = objectInputStream.readUTF();
        this.appVersion = objectInputStream.readUTF();
        this.model = (String) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.platform);
        objectOutputStream.writeUTF(this.osVersion);
        objectOutputStream.writeUTF(this.appVersion);
        objectOutputStream.writeObject(this.model);
    }

    public void a(Platform platform2) {
        this.platform = platform2;
    }

    public String b() {
        return this.appVersion;
    }

    public void c(String str) {
        this.osVersion = str;
    }

    public String d() {
        return this.osVersion;
    }

    public Platform e() {
        return this.platform;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || UserSessionCreateBody.class != obj.getClass()) {
            return false;
        }
        UserSessionCreateBody userSessionCreateBody = (UserSessionCreateBody) obj;
        if (!c.a(this.platform, userSessionCreateBody.platform) || !c.a(this.osVersion, userSessionCreateBody.osVersion) || !c.a(this.appVersion, userSessionCreateBody.appVersion) || !c.a(this.model, userSessionCreateBody.model)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return c.a(this.platform, this.osVersion, this.appVersion, this.model);
    }

    public UserSessionCreateBody(Platform platform2, String str, String str2, String str3) {
        this.platform = platform2;
        this.osVersion = str;
        this.appVersion = str2;
        this.model = str3;
    }

    public void a(String str) {
        this.appVersion = str;
    }

    public void b(String str) {
        this.model = str;
    }

    public String c() {
        String str = this.model;
        if (str == null) {
            return null;
        }
        return str;
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.platform);
        d.a(this.osVersion);
        d.a(this.appVersion);
    }
}
