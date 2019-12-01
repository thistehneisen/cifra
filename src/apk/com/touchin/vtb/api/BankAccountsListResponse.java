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
public class BankAccountsListResponse extends TicketInfoResponse {
    @JsonField(name = {"accountsList"})
    private List<AccountInfo> accountsList;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.accountsList = (List) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.accountsList);
    }

    public void a(List<AccountInfo> list) {
        this.accountsList = list;
    }

    public List<AccountInfo> c() {
        List<AccountInfo> list = this.accountsList;
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
        if (obj == null || BankAccountsListResponse.class != obj.getClass()) {
            return false;
        }
        BankAccountsListResponse bankAccountsListResponse = (BankAccountsListResponse) obj;
        if (!super.equals(bankAccountsListResponse) || !c.a(this.accountsList, bankAccountsListResponse.accountsList)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return c.a(Integer.valueOf(super.hashCode()), this.accountsList);
    }

    public void a() throws ValidationException {
        super.a();
        List<AccountInfo> list = this.accountsList;
        if (list != null) {
            ApiModel.a(list, a.EXCEPTION_IF_ANY_INVALID);
        }
    }
}
