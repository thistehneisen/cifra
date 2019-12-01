package com.touchin.vtb.api;

import b.g.h.c;
import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import ru.touchin.templates.ApiModel.ValidationException;

@JsonObject(serializeNullObjects = false)
public class TicketIdBody extends SessionIdBody {
    @JsonField(name = {"ticketId"})
    private String ticketId;

    public TicketIdBody() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.ticketId = (String) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.ticketId);
    }

    public void a() throws ValidationException {
        super.a();
    }

    public void b(String str) {
        this.ticketId = str;
    }

    public String c() {
        String str = this.ticketId;
        if (str == null) {
            return null;
        }
        return str;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || TicketIdBody.class != obj.getClass()) {
            return false;
        }
        TicketIdBody ticketIdBody = (TicketIdBody) obj;
        if (!super.equals(ticketIdBody) || !c.a(this.ticketId, ticketIdBody.ticketId)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return c.a(Integer.valueOf(super.hashCode()), this.ticketId);
    }

    public TicketIdBody(String str, String str2) {
        super(str2);
        this.ticketId = str;
    }
}
