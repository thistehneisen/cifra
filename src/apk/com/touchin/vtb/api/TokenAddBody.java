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
public class TokenAddBody extends SessionIdBody {
    @JsonField(name = {"token"})
    private String token;

    public TokenAddBody() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.token = objectInputStream.readUTF();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this.token);
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.token);
    }

    public void b(String str) {
        this.token = str;
    }

    public String c() {
        return this.token;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || TokenAddBody.class != obj.getClass()) {
            return false;
        }
        TokenAddBody tokenAddBody = (TokenAddBody) obj;
        if (!super.equals(tokenAddBody) || !c.a(this.token, tokenAddBody.token)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return c.a(Integer.valueOf(super.hashCode()), this.token);
    }

    public TokenAddBody(String str, String str2) {
        super(str2);
        this.token = str;
    }
}
