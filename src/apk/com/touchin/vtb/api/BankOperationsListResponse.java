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

@JsonObject(serializeNullObjects = false)
public class BankOperationsListResponse extends TicketInfoResponse {
    @JsonField(name = {"operations"})
    private List<OperationInfo> operations;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.operations = (List) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.operations);
    }

    public void a(List<OperationInfo> list) {
        this.operations = list;
    }

    public List<OperationInfo> c() {
        List<OperationInfo> list = this.operations;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || BankOperationsListResponse.class != obj.getClass()) {
            return false;
        }
        BankOperationsListResponse bankOperationsListResponse = (BankOperationsListResponse) obj;
        if (!super.equals(bankOperationsListResponse) || !c.a(this.operations, bankOperationsListResponse.operations)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return c.a(Integer.valueOf(super.hashCode()), this.operations);
    }

    public void a() throws ValidationException {
        super.a();
        List<OperationInfo> list = this.operations;
        if (list != null) {
            ApiModel.a(list, a.EXCEPTION_IF_ANY_INVALID);
        }
    }
}
