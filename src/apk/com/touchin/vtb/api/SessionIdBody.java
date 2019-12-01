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
public class SessionIdBody extends d {
    @JsonField(name = {"sessionId"})
    private String sessionId;

    public SessionIdBody() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.sessionId = objectInputStream.readUTF();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this.sessionId);
    }

    public void a(String str) {
        this.sessionId = str;
    }

    public String b() {
        return this.sessionId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return c.a(this.sessionId, ((SessionIdBody) obj).sessionId);
    }

    public int hashCode() {
        return c.a(this.sessionId);
    }

    public SessionIdBody(String str) {
        this.sessionId = str;
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.sessionId);
    }
}
