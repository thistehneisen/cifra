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
public class TasksTaxInfo extends BasePaymentInfo {
    @JsonField(name = {"id"})
    private String id;
    @JsonField(name = {"payerRequisites"})
    private TaxRequisites payerRequisites;
    @JsonField(name = {"receiverRequisites"})
    private TaxRequisites receiverRequisites;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.id = objectInputStream.readUTF();
        this.payerRequisites = (TaxRequisites) objectInputStream.readObject();
        this.receiverRequisites = (TaxRequisites) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this.id);
        objectOutputStream.writeObject(this.payerRequisites);
        objectOutputStream.writeObject(this.receiverRequisites);
    }

    public void a(TaxRequisites taxRequisites) {
        this.payerRequisites = taxRequisites;
    }

    public void b(String str) {
        this.id = str;
    }

    public String d() {
        return this.id;
    }

    public TaxRequisites e() {
        return this.payerRequisites;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || TasksTaxInfo.class != obj.getClass()) {
            return false;
        }
        TasksTaxInfo tasksTaxInfo = (TasksTaxInfo) obj;
        if (!super.equals(tasksTaxInfo) || !c.a(this.id, tasksTaxInfo.id) || !c.a(this.payerRequisites, tasksTaxInfo.payerRequisites) || !c.a(this.receiverRequisites, tasksTaxInfo.receiverRequisites)) {
            z = false;
        }
        return z;
    }

    public TaxRequisites f() {
        return this.receiverRequisites;
    }

    public int hashCode() {
        return c.a(Integer.valueOf(super.hashCode()), this.id, this.payerRequisites, this.receiverRequisites);
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.id);
        d.a(this.payerRequisites);
        TaxRequisites taxRequisites = this.payerRequisites;
        if (taxRequisites instanceof ApiModel) {
            taxRequisites.a();
        }
        d.a(this.receiverRequisites);
        TaxRequisites taxRequisites2 = this.receiverRequisites;
        if (taxRequisites2 instanceof ApiModel) {
            taxRequisites2.a();
        }
    }

    public void b(TaxRequisites taxRequisites) {
        this.receiverRequisites = taxRequisites;
    }
}
