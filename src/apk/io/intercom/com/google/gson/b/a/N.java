package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;
import java.util.Currency;

/* compiled from: TypeAdapters */
class N extends D<Currency> {
    N() {
    }

    public Currency a(b bVar) throws IOException {
        return Currency.getInstance(bVar.F());
    }

    public void a(d dVar, Currency currency) throws IOException {
        dVar.d(currency.getCurrencyCode());
    }
}
