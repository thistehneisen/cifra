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
public class DaDataError extends d {
    @JsonField(name = {"family"})
    private String family;
    @JsonField(name = {"message"})
    private String message;
    @JsonField(name = {"reason"})
    private String reason;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.family = objectInputStream.readUTF();
        this.reason = objectInputStream.readUTF();
        this.message = objectInputStream.readUTF();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this.family);
        objectOutputStream.writeUTF(this.reason);
        objectOutputStream.writeUTF(this.message);
    }

    public void a(String str) {
        this.family = str;
    }

    public String b() {
        return this.family;
    }

    public void c(String str) {
        this.reason = str;
    }

    public String d() {
        return this.reason;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || DaDataError.class != obj.getClass()) {
            return false;
        }
        DaDataError daDataError = (DaDataError) obj;
        if (!c.a(this.family, daDataError.family) || !c.a(this.reason, daDataError.reason) || !c.a(this.message, daDataError.message)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return c.a(this.family, this.reason, this.message);
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.family);
        d.a(this.reason);
        d.a(this.message);
    }

    public void b(String str) {
        this.message = str;
    }

    public String c() {
        return this.message;
    }
}
