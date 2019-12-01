package com.fasterxml.jackson.core.b;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;

/* compiled from: OutputDecorator */
public abstract class i implements Serializable {
    public abstract OutputStream a(c cVar, OutputStream outputStream) throws IOException;

    public abstract Writer a(c cVar, Writer writer) throws IOException;
}
