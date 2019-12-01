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
public class BaseRequisites extends d {
    @JsonField(name = {"title"})
    private String title;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.title = objectInputStream.readUTF();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this.title);
    }

    public void a(String str) {
        this.title = str;
    }

    public String b() {
        return this.title;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return c.a(this.title, ((BaseRequisites) obj).title);
    }

    public int hashCode() {
        return c.a(this.title);
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.title);
    }
}
