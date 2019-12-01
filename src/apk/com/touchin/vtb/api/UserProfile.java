package com.touchin.vtb.api;

import b.g.h.c;
import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.List;
import ru.touchin.templates.ApiModel;
import ru.touchin.templates.ApiModel.ValidationException;
import ru.touchin.templates.ApiModel.a;
import ru.touchin.templates.a.d;

@JsonObject(serializeNullObjects = false)
public class UserProfile extends d {
    @JsonField(name = {"companyInfo"})
    private CompanyInfo companyInfo;
    @JsonField(name = {"connectedBanksList"})
    private List<ConnectedBank> connectedBanksList;
    @JsonField(name = {"id"})
    private String id;
    @JsonField(name = {"phoneNumber"})
    private String phoneNumber;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.id = objectInputStream.readUTF();
        this.phoneNumber = objectInputStream.readUTF();
        this.companyInfo = (CompanyInfo) objectInputStream.readObject();
        this.connectedBanksList = (List) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this.id);
        objectOutputStream.writeUTF(this.phoneNumber);
        objectOutputStream.writeObject(this.companyInfo);
        objectOutputStream.writeObject(this.connectedBanksList);
    }

    public void a(String str) {
        this.id = str;
    }

    public void b(String str) {
        this.phoneNumber = str;
    }

    public List<ConnectedBank> c() {
        return Collections.unmodifiableList(this.connectedBanksList);
    }

    public String d() {
        return this.id;
    }

    public String e() {
        return this.phoneNumber;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || UserProfile.class != obj.getClass()) {
            return false;
        }
        UserProfile userProfile = (UserProfile) obj;
        if (!c.a(this.id, userProfile.id) || !c.a(this.phoneNumber, userProfile.phoneNumber) || !c.a(this.companyInfo, userProfile.companyInfo) || !c.a(this.connectedBanksList, userProfile.connectedBanksList)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return c.a(this.id, this.phoneNumber, this.companyInfo, this.connectedBanksList);
    }

    public void a(CompanyInfo companyInfo2) {
        this.companyInfo = companyInfo2;
    }

    public CompanyInfo b() {
        CompanyInfo companyInfo2 = this.companyInfo;
        if (companyInfo2 == null) {
            return null;
        }
        return companyInfo2;
    }

    public void a(List<ConnectedBank> list) {
        this.connectedBanksList = list;
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.id);
        d.a(this.phoneNumber);
        CompanyInfo companyInfo2 = this.companyInfo;
        if ((companyInfo2 instanceof ApiModel) && companyInfo2 != null) {
            companyInfo2.a();
        }
        d.a(this.connectedBanksList);
        ApiModel.a(this.connectedBanksList, a.EXCEPTION_IF_ANY_INVALID);
    }
}
