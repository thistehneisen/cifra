package com.touchin.vtb.api;

import b.g.h.c;
import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import ru.touchin.templates.ApiModel.ValidationException;
import ru.touchin.templates.a.d;

@JsonObject(serializeNullObjects = false)
public class BankOperationsListBody extends ConnectedBankIdBody {
    @JsonField(name = {"accountId"})
    private String accountId;
    @JsonField(name = {"limit"})
    private int limit;
    @JsonField(name = {"offset"})
    private int offset;
    @JsonField(name = {"ticketId"})
    private String ticketId;

    public BankOperationsListBody() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.accountId = objectInputStream.readUTF();
        this.limit = objectInputStream.readInt();
        this.offset = objectInputStream.readInt();
        this.ticketId = (String) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this.accountId);
        objectOutputStream.writeInt(this.limit);
        objectOutputStream.writeInt(this.offset);
        objectOutputStream.writeObject(this.ticketId);
    }

    public void a(int i2) {
        this.limit = i2;
    }

    public void b(int i2) {
        this.offset = i2;
    }

    public void c(String str) {
        this.accountId = str;
    }

    public String d() {
        return this.accountId;
    }

    public int e() {
        return this.limit;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || BankOperationsListBody.class != obj.getClass()) {
            return false;
        }
        BankOperationsListBody bankOperationsListBody = (BankOperationsListBody) obj;
        if (!super.equals(bankOperationsListBody) || !c.a(this.accountId, bankOperationsListBody.accountId) || !c.a(Integer.valueOf(this.limit), Integer.valueOf(bankOperationsListBody.limit)) || !c.a(Integer.valueOf(this.offset), Integer.valueOf(bankOperationsListBody.offset)) || !c.a(this.ticketId, bankOperationsListBody.ticketId)) {
            z = false;
        }
        return z;
    }

    public int f() {
        return this.offset;
    }

    public String g() {
        String str = this.ticketId;
        if (str == null) {
            return null;
        }
        return str;
    }

    public int hashCode() {
        return c.a(Integer.valueOf(super.hashCode()), this.accountId, Integer.valueOf(this.limit), Integer.valueOf(this.offset), this.ticketId);
    }

    public BankOperationsListBody(String str, int i2, int i3, String str2, String str3, String str4) {
        super(str3, str4);
        this.accountId = str;
        this.limit = i2;
        this.offset = i3;
        this.ticketId = str2;
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.accountId);
    }

    public void d(String str) {
        this.ticketId = str;
    }
}
