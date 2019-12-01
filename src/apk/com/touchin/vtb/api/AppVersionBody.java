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
public class AppVersionBody extends SessionIdBody {
    @JsonField(name = {"appVersion"})
    private String appVersion;
    @JsonField(name = {"platform"})
    private Platform platform;

    public AppVersionBody() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.platform = (Platform) objectInputStream.readObject();
        this.appVersion = objectInputStream.readUTF();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.platform);
        objectOutputStream.writeUTF(this.appVersion);
    }

    public void a(Platform platform2) {
        this.platform = platform2;
    }

    public void b(String str) {
        this.appVersion = str;
    }

    public String c() {
        return this.appVersion;
    }

    public Platform d() {
        return this.platform;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || AppVersionBody.class != obj.getClass()) {
            return false;
        }
        AppVersionBody appVersionBody = (AppVersionBody) obj;
        if (!super.equals(appVersionBody) || !c.a(this.platform, appVersionBody.platform) || !c.a(this.appVersion, appVersionBody.appVersion)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return c.a(Integer.valueOf(super.hashCode()), this.platform, this.appVersion);
    }

    public AppVersionBody(Platform platform2, String str, String str2) {
        super(str2);
        this.platform = platform2;
        this.appVersion = str;
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.platform);
        d.a(this.appVersion);
    }
}
