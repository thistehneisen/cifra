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
public class AccountInfo extends d {
    @JsonField(name = {"accountNumberMask"})
    private String accountNumberMask;
    @JsonField(name = {"amount"})
    private Amount amount;
    @JsonField(name = {"connectedBankId"})
    private String connectedBankId;
    @JsonField(name = {"id"})
    private String id;
    @JsonField(name = {"operationsAvailable"})
    private boolean operationsAvailable;
    @JsonField(name = {"paymentSystem"})
    private PaymentSystem paymentSystem;
    @JsonField(name = {"title"})
    private String title;
    @JsonField(name = {"type"})
    private AccountType type;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.id = objectInputStream.readUTF();
        this.connectedBankId = objectInputStream.readUTF();
        this.title = objectInputStream.readUTF();
        this.amount = (Amount) objectInputStream.readObject();
        this.accountNumberMask = objectInputStream.readUTF();
        this.type = (AccountType) objectInputStream.readObject();
        this.operationsAvailable = objectInputStream.readBoolean();
        this.paymentSystem = (PaymentSystem) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this.id);
        objectOutputStream.writeUTF(this.connectedBankId);
        objectOutputStream.writeUTF(this.title);
        objectOutputStream.writeObject(this.amount);
        objectOutputStream.writeUTF(this.accountNumberMask);
        objectOutputStream.writeObject(this.type);
        objectOutputStream.writeBoolean(this.operationsAvailable);
        objectOutputStream.writeObject(this.paymentSystem);
    }

    public void a(Amount amount2) {
        this.amount = amount2;
    }

    public void b(String str) {
        this.connectedBankId = str;
    }

    public void c(String str) {
        this.id = str;
    }

    public String d() {
        return this.connectedBankId;
    }

    public String e() {
        return this.id;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || AccountInfo.class != obj.getClass()) {
            return false;
        }
        AccountInfo accountInfo = (AccountInfo) obj;
        if (!c.a(this.id, accountInfo.id) || !c.a(this.connectedBankId, accountInfo.connectedBankId) || !c.a(this.title, accountInfo.title) || !c.a(this.amount, accountInfo.amount) || !c.a(this.accountNumberMask, accountInfo.accountNumberMask) || !c.a(this.type, accountInfo.type) || !c.a(Boolean.valueOf(this.operationsAvailable), Boolean.valueOf(accountInfo.operationsAvailable)) || !c.a(this.paymentSystem, accountInfo.paymentSystem)) {
            z = false;
        }
        return z;
    }

    public boolean f() {
        return this.operationsAvailable;
    }

    public PaymentSystem g() {
        PaymentSystem paymentSystem2 = this.paymentSystem;
        if (paymentSystem2 == null) {
            return null;
        }
        return paymentSystem2;
    }

    public String h() {
        return this.title;
    }

    public int hashCode() {
        return c.a(this.id, this.connectedBankId, this.title, this.amount, this.accountNumberMask, this.type, Boolean.valueOf(this.operationsAvailable), this.paymentSystem);
    }

    public AccountType i() {
        return this.type;
    }

    public void a(String str) {
        this.accountNumberMask = str;
    }

    public String b() {
        return this.accountNumberMask;
    }

    public Amount c() {
        return this.amount;
    }

    public void d(String str) {
        this.title = str;
    }

    public void a(AccountType accountType) {
        this.type = accountType;
    }

    public void a(boolean z) {
        this.operationsAvailable = z;
    }

    public void a(PaymentSystem paymentSystem2) {
        this.paymentSystem = paymentSystem2;
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.id);
        d.a(this.connectedBankId);
        d.a(this.title);
        d.a(this.amount);
        Amount amount2 = this.amount;
        if (amount2 instanceof ApiModel) {
            amount2.a();
        }
        d.a(this.accountNumberMask);
        d.a(this.type);
    }
}
