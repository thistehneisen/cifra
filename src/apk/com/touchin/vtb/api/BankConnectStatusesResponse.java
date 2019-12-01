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
public class BankConnectStatusesResponse extends d {
    @JsonField(name = {"banksList"})
    private List<BankConnectResponse> banksList;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.banksList = (List) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.banksList);
    }

    public void a(List<BankConnectResponse> list) {
        this.banksList = list;
    }

    public List<BankConnectResponse> b() {
        return Collections.unmodifiableList(this.banksList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || BankConnectStatusesResponse.class != obj.getClass()) {
            return false;
        }
        return c.a(this.banksList, ((BankConnectStatusesResponse) obj).banksList);
    }

    public int hashCode() {
        return c.a(this.banksList);
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.banksList);
        ApiModel.a(this.banksList, a.EXCEPTION_IF_ANY_INVALID);
    }
}
