package com.fasterxml.jackson.core.b;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Serializable;

/* compiled from: InputDecorator */
public abstract class d implements Serializable {
    private static final long serialVersionUID = 1;

    public abstract InputStream a(c cVar, InputStream inputStream) throws IOException;

    public abstract InputStream a(c cVar, byte[] bArr, int i2, int i3) throws IOException;

    public abstract Reader a(c cVar, Reader reader) throws IOException;
}
