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
public class DaDataOpf extends d {
    @JsonField(name = {"full"})
    private String fullName;
    @JsonField(name = {"code"})
    private String name;
    @JsonField(name = {"short"})
    private String shortName;
    @JsonField(name = {"type"})
    private String type;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.type = objectInputStream.readUTF();
        this.name = (String) objectInputStream.readObject();
        this.fullName = objectInputStream.readUTF();
        this.shortName = objectInputStream.readUTF();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this.type);
        objectOutputStream.writeObject(this.name);
        objectOutputStream.writeUTF(this.fullName);
        objectOutputStream.writeUTF(this.shortName);
    }

    public void a(String str) {
        this.fullName = str;
    }

    public void b(String str) {
        this.name = str;
    }

    public String c() {
        String str = this.name;
        if (str == null) {
            return null;
        }
        return str;
    }

    public void d(String str) {
        this.type = str;
    }

    public String e() {
        return this.type;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || DaDataOpf.class != obj.getClass()) {
            return false;
        }
        DaDataOpf daDataOpf = (DaDataOpf) obj;
        if (!c.a(this.type, daDataOpf.type) || !c.a(this.name, daDataOpf.name) || !c.a(this.fullName, daDataOpf.fullName) || !c.a(this.shortName, daDataOpf.shortName)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return c.a(this.type, this.name, this.fullName, this.shortName);
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.type);
        d.a(this.fullName);
        d.a(this.shortName);
    }

    public String b() {
        return this.fullName;
    }

    public void c(String str) {
        this.shortName = str;
    }

    public String d() {
        return this.shortName;
    }
}
