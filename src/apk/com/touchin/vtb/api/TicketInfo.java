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
public class TicketInfo extends d {
    @JsonField(name = {"ticketId"})
    private String ticketId;
    @JsonField(name = {"ticketStatus"})
    private TicketStatus ticketStatus;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.ticketId = objectInputStream.readUTF();
        this.ticketStatus = (TicketStatus) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this.ticketId);
        objectOutputStream.writeObject(this.ticketStatus);
    }

    public void a(String str) {
        this.ticketId = str;
    }

    public String b() {
        return this.ticketId;
    }

    public TicketStatus c() {
        return this.ticketStatus;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || TicketInfo.class != obj.getClass()) {
            return false;
        }
        TicketInfo ticketInfo = (TicketInfo) obj;
        if (!c.a(this.ticketId, ticketInfo.ticketId) || !c.a(this.ticketStatus, ticketInfo.ticketStatus)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return c.a(this.ticketId, this.ticketStatus);
    }

    public void a(TicketStatus ticketStatus2) {
        this.ticketStatus = ticketStatus2;
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.ticketId);
        d.a(this.ticketStatus);
    }
}
