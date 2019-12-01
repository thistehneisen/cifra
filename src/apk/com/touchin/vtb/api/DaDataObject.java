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
public class DaDataObject<TResult> extends d {
    @JsonField(name = {"data"})
    private TResult data;
    @JsonField(name = {"value"})
    private String value;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.value = objectInputStream.readUTF();
        this.data = objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this.value);
        objectOutputStream.writeObject(this.data);
    }

    public void a(String str) {
        this.value = str;
    }

    public TResult b() {
        return this.data;
    }

    public String c() {
        return this.value;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DaDataObject daDataObject = (DaDataObject) obj;
        if (!c.a(this.value, daDataObject.value) || !c.a(this.data, daDataObject.data)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return c.a(this.value, this.data);
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.value);
        d.a(this.data);
        TResult tresult = this.data;
        if (tresult instanceof ApiModel) {
            ((ApiModel) tresult).a();
        }
    }

    public void b(TResult tresult) {
        this.data = tresult;
    }
}
