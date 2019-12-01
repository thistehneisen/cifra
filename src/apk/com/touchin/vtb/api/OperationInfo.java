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
public class OperationInfo extends PaymentInfo {
    @JsonField(name = {"id"})
    private String id;
    @JsonField(name = {"imageUrl"})
    private String imageUrl;
    @JsonField(name = {"payerRequisites"})
    private OperationRequisites payerRequisites;
    @JsonField(name = {"receiverRequisites"})
    private OperationRequisites receiverRequisites;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.id = objectInputStream.readUTF();
        this.payerRequisites = (OperationRequisites) objectInputStream.readObject();
        this.receiverRequisites = (OperationRequisites) objectInputStream.readObject();
        this.imageUrl = (String) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this.id);
        objectOutputStream.writeObject(this.payerRequisites);
        objectOutputStream.writeObject(this.receiverRequisites);
        objectOutputStream.writeObject(this.imageUrl);
    }

    public void a(OperationRequisites operationRequisites) {
        this.payerRequisites = operationRequisites;
    }

    public void b(String str) {
        this.id = str;
    }

    public void c(String str) {
        this.imageUrl = str;
    }

    public String e() {
        return this.id;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || OperationInfo.class != obj.getClass()) {
            return false;
        }
        OperationInfo operationInfo = (OperationInfo) obj;
        if (!super.equals(operationInfo) || !c.a(this.id, operationInfo.id) || !c.a(this.payerRequisites, operationInfo.payerRequisites) || !c.a(this.receiverRequisites, operationInfo.receiverRequisites) || !c.a(this.imageUrl, operationInfo.imageUrl)) {
            z = false;
        }
        return z;
    }

    public String f() {
        String str = this.imageUrl;
        if (str == null) {
            return null;
        }
        return str;
    }

    public OperationRequisites g() {
        OperationRequisites operationRequisites = this.payerRequisites;
        if (operationRequisites == null) {
            return null;
        }
        return operationRequisites;
    }

    public OperationRequisites h() {
        OperationRequisites operationRequisites = this.receiverRequisites;
        if (operationRequisites == null) {
            return null;
        }
        return operationRequisites;
    }

    public int hashCode() {
        return c.a(Integer.valueOf(super.hashCode()), this.id, this.payerRequisites, this.receiverRequisites, this.imageUrl);
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.id);
        OperationRequisites operationRequisites = this.payerRequisites;
        if ((operationRequisites instanceof ApiModel) && operationRequisites != null) {
            operationRequisites.a();
        }
        OperationRequisites operationRequisites2 = this.receiverRequisites;
        if ((operationRequisites2 instanceof ApiModel) && operationRequisites2 != null) {
            operationRequisites2.a();
        }
    }

    public void b(OperationRequisites operationRequisites) {
        this.receiverRequisites = operationRequisites;
    }
}
