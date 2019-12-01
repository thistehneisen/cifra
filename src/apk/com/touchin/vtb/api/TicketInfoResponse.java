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
public class TicketInfoResponse extends d {
    @JsonField(name = {"ticketInfo"})
    private TicketInfo ticketInfo;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.ticketInfo = (TicketInfo) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.ticketInfo);
    }

    public void a(TicketInfo ticketInfo2) {
        this.ticketInfo = ticketInfo2;
    }

    public TicketInfo b() {
        TicketInfo ticketInfo2 = this.ticketInfo;
        if (ticketInfo2 == null) {
            return null;
        }
        return ticketInfo2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return c.a(this.ticketInfo, ((TicketInfoResponse) obj).ticketInfo);
    }

    public int hashCode() {
        return c.a(this.ticketInfo);
    }

    public void a() throws ValidationException {
        super.a();
        TicketInfo ticketInfo2 = this.ticketInfo;
        if ((ticketInfo2 instanceof ApiModel) && ticketInfo2 != null) {
            ticketInfo2.a();
        }
    }
}
