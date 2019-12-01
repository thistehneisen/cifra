package com.touchin.vtb.api;

import b.g.h.c;
import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.joda.time.b;
import ru.touchin.templates.ApiModel.ValidationException;
import ru.touchin.templates.a.d;

@JsonObject(serializeNullObjects = false)
public class CompanyInfo extends d {
    @JsonField(name = {"address"})
    private String address;
    @JsonField(name = {"companyType"})
    private CompanyType companyType;
    @JsonField(name = {"inn"})
    private String inn;
    @JsonField(name = {"ogrn"})
    private String ogrn;
    @JsonField(name = {"registrationDate"})
    private b registrationDate;
    @JsonField(name = {"taxSystem"})
    private TaxSystem taxSystem;
    @JsonField(name = {"title"})
    private String title;

    public CompanyInfo() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.title = objectInputStream.readUTF();
        this.inn = objectInputStream.readUTF();
        this.ogrn = objectInputStream.readUTF();
        this.registrationDate = (b) objectInputStream.readObject();
        this.taxSystem = (TaxSystem) objectInputStream.readObject();
        this.address = (String) objectInputStream.readObject();
        this.companyType = (CompanyType) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this.title);
        objectOutputStream.writeUTF(this.inn);
        objectOutputStream.writeUTF(this.ogrn);
        objectOutputStream.writeObject(this.registrationDate);
        objectOutputStream.writeObject(this.taxSystem);
        objectOutputStream.writeObject(this.address);
        objectOutputStream.writeObject(this.companyType);
    }

    public void a(b bVar) {
        this.registrationDate = bVar;
    }

    public void b(String str) {
        this.inn = str;
    }

    public void c(String str) {
        this.ogrn = str;
    }

    public void d(String str) {
        this.title = str;
    }

    public String e() {
        return this.ogrn;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || CompanyInfo.class != obj.getClass()) {
            return false;
        }
        CompanyInfo companyInfo = (CompanyInfo) obj;
        if (!c.a(this.title, companyInfo.title) || !c.a(this.inn, companyInfo.inn) || !c.a(this.ogrn, companyInfo.ogrn) || !c.a(this.registrationDate, companyInfo.registrationDate) || !c.a(this.taxSystem, companyInfo.taxSystem) || !c.a(this.address, companyInfo.address) || !c.a(this.companyType, companyInfo.companyType)) {
            z = false;
        }
        return z;
    }

    public b f() {
        b bVar = this.registrationDate;
        if (bVar == null) {
            return null;
        }
        return bVar;
    }

    public TaxSystem g() {
        TaxSystem taxSystem2 = this.taxSystem;
        if (taxSystem2 == null) {
            return null;
        }
        return taxSystem2;
    }

    public String h() {
        return this.title;
    }

    public int hashCode() {
        return c.a(this.title, this.inn, this.ogrn, this.registrationDate, this.taxSystem, this.address, this.companyType);
    }

    public CompanyInfo(String str, String str2, String str3, b bVar, TaxSystem taxSystem2, String str4, CompanyType companyType2) {
        this.title = str;
        this.inn = str2;
        this.ogrn = str3;
        this.registrationDate = bVar;
        this.taxSystem = taxSystem2;
        this.address = str4;
        this.companyType = companyType2;
    }

    public void a(TaxSystem taxSystem2) {
        this.taxSystem = taxSystem2;
    }

    public String b() {
        String str = this.address;
        if (str == null) {
            return null;
        }
        return str;
    }

    public CompanyType c() {
        CompanyType companyType2 = this.companyType;
        if (companyType2 == null) {
            return null;
        }
        return companyType2;
    }

    public String d() {
        return this.inn;
    }

    public void a(String str) {
        this.address = str;
    }

    public void a(CompanyType companyType2) {
        this.companyType = companyType2;
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.title);
        d.a(this.inn);
        d.a(this.ogrn);
    }
}
