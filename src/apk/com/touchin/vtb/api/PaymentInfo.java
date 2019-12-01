package com.touchin.vtb.api;

import b.g.h.c;
import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.joda.time.b;
import ru.touchin.templates.ApiModel.ValidationException;
import ru.touchin.templates.a.d;

@JsonObject(serializeNullObjects = false)
public class PaymentInfo extends BasePaymentInfo {
    @JsonField(name = {"date"})
    private b date;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.date = (b) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.date);
    }

    public void a(b bVar) {
        this.date = bVar;
    }

    public b d() {
        return this.date;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PaymentInfo paymentInfo = (PaymentInfo) obj;
        if (!super.equals(paymentInfo) || !c.a(this.date, paymentInfo.date)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return c.a(Integer.valueOf(super.hashCode()), this.date);
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.date);
    }
}
