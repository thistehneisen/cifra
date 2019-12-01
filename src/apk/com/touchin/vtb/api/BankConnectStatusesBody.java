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
public class BankConnectStatusesBody extends SessionIdBody {
    @JsonField(name = {"bankIdsList"})
    private List<String> bankIdsList;

    public BankConnectStatusesBody() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.bankIdsList = (List) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.bankIdsList);
    }

    public void a(List<String> list) {
        this.bankIdsList = list;
    }

    public List<String> c() {
        List<String> list = this.bankIdsList;
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
        if (obj == null || BankConnectStatusesBody.class != obj.getClass()) {
            return false;
        }
        BankConnectStatusesBody bankConnectStatusesBody = (BankConnectStatusesBody) obj;
        if (!super.equals(bankConnectStatusesBody) || !c.a(this.bankIdsList, bankConnectStatusesBody.bankIdsList)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return c.a(Integer.valueOf(super.hashCode()), this.bankIdsList);
    }

    public BankConnectStatusesBody(List<String> list, String str) {
        super(str);
        this.bankIdsList = list;
    }

    public void a() throws ValidationException {
        super.a();
        List<String> list = this.bankIdsList;
        if (list != null) {
            ApiModel.a(list, a.EXCEPTION_IF_ANY_INVALID);
        }
    }
}
