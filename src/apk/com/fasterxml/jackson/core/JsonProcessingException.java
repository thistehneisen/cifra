package com.fasterxml.jackson.core;

import java.io.IOException;

public class JsonProcessingException extends IOException {
    static final long serialVersionUID = 123;
    protected d _location;

    protected JsonProcessingException(String str, d dVar, Throwable th) {
        super(str);
        if (th != null) {
            initCause(th);
        }
        this._location = dVar;
    }

    public d a() {
        return this._location;
    }

    /* access modifiers changed from: protected */
    public String b() {
        return null;
    }

    public String getMessage() {
        String message = super.getMessage();
        if (message == null) {
            message = "N/A";
        }
        d a2 = a();
        String b2 = b();
        if (a2 == null && b2 == null) {
            return message;
        }
        StringBuilder sb = new StringBuilder(100);
        sb.append(message);
        if (b2 != null) {
            sb.append(b2);
        }
        if (a2 != null) {
            sb.append(10);
            sb.append(" at ");
            sb.append(a2.toString());
        }
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append(": ");
        sb.append(getMessage());
        return sb.toString();
    }

    protected JsonProcessingException(String str, d dVar) {
        this(str, dVar, null);
    }
}
