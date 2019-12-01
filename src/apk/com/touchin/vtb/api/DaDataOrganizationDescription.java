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
public class DaDataOrganizationDescription extends d {
    @JsonField(name = {"address"})
    private DaDataAddress address;
    @JsonField(name = {"inn"})
    private String inn;
    @JsonField(name = {"opf"})
    private DaDataOpf name;
    @JsonField(name = {"ogrn"})
    private String ogrn;
    @JsonField(name = {"state"})
    private DaDataStatus state;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.inn = objectInputStream.readUTF();
        this.ogrn = objectInputStream.readUTF();
        this.name = (DaDataOpf) objectInputStream.readObject();
        this.address = (DaDataAddress) objectInputStream.readObject();
        this.state = (DaDataStatus) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this.inn);
        objectOutputStream.writeUTF(this.ogrn);
        objectOutputStream.writeObject(this.name);
        objectOutputStream.writeObject(this.address);
        objectOutputStream.writeObject(this.state);
    }

    public void a(String str) {
        this.inn = str;
    }

    public void b(String str) {
        this.ogrn = str;
    }

    public String c() {
        return this.inn;
    }

    public DaDataOpf d() {
        DaDataOpf daDataOpf = this.name;
        if (daDataOpf == null) {
            return null;
        }
        return daDataOpf;
    }

    public String e() {
        return this.ogrn;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || DaDataOrganizationDescription.class != obj.getClass()) {
            return false;
        }
        DaDataOrganizationDescription daDataOrganizationDescription = (DaDataOrganizationDescription) obj;
        if (!c.a(this.inn, daDataOrganizationDescription.inn) || !c.a(this.ogrn, daDataOrganizationDescription.ogrn) || !c.a(this.name, daDataOrganizationDescription.name) || !c.a(this.address, daDataOrganizationDescription.address) || !c.a(this.state, daDataOrganizationDescription.state)) {
            z = false;
        }
        return z;
    }

    public DaDataStatus f() {
        return this.state;
    }

    public int hashCode() {
        return c.a(this.inn, this.ogrn, this.name, this.address, this.state);
    }

    public void a(DaDataOpf daDataOpf) {
        this.name = daDataOpf;
    }

    public DaDataAddress b() {
        return this.address;
    }

    public void a(DaDataAddress daDataAddress) {
        this.address = daDataAddress;
    }

    public void a(DaDataStatus daDataStatus) {
        this.state = daDataStatus;
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.inn);
        d.a(this.ogrn);
        DaDataOpf daDataOpf = this.name;
        if ((daDataOpf instanceof ApiModel) && daDataOpf != null) {
            daDataOpf.a();
        }
        d.a(this.address);
        DaDataAddress daDataAddress = this.address;
        if (daDataAddress instanceof ApiModel) {
            daDataAddress.a();
        }
        d.a(this.state);
        DaDataStatus daDataStatus = this.state;
        if (daDataStatus instanceof ApiModel) {
            daDataStatus.a();
        }
    }
}
