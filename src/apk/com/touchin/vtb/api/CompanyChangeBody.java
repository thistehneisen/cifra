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
public class CompanyChangeBody extends SessionIdBody {
    @JsonField(name = {"companyInfo"})
    private CompanyInfo companyInfo;

    public CompanyChangeBody() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.companyInfo = (CompanyInfo) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.companyInfo);
    }

    public void a(CompanyInfo companyInfo2) {
        this.companyInfo = companyInfo2;
    }

    public CompanyInfo c() {
        return this.companyInfo;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || CompanyChangeBody.class != obj.getClass()) {
            return false;
        }
        CompanyChangeBody companyChangeBody = (CompanyChangeBody) obj;
        if (!super.equals(companyChangeBody) || !c.a(this.companyInfo, companyChangeBody.companyInfo)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return c.a(Integer.valueOf(super.hashCode()), this.companyInfo);
    }

    public CompanyChangeBody(CompanyInfo companyInfo2, String str) {
        super(str);
        this.companyInfo = companyInfo2;
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.companyInfo);
        CompanyInfo companyInfo2 = this.companyInfo;
        if (companyInfo2 instanceof ApiModel) {
            companyInfo2.a();
        }
    }
}
