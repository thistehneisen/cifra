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
public class DaDataQueryRequest extends d {
    @JsonField(name = {"query"})
    private String query;

    public DaDataQueryRequest() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.query = objectInputStream.readUTF();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this.query);
    }

    public void a(String str) {
        this.query = str;
    }

    public String b() {
        return this.query;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DaDataQueryRequest.class != obj.getClass()) {
            return false;
        }
        return c.a(this.query, ((DaDataQueryRequest) obj).query);
    }

    public int hashCode() {
        return c.a(this.query);
    }

    public DaDataQueryRequest(String str) {
        this.query = str;
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.query);
    }
}
