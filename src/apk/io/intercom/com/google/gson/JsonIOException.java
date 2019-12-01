package io.intercom.com.google.gson;

public final class JsonIOException extends JsonParseException {
    private static final long serialVersionUID = 1;

    public JsonIOException(String str) {
        super(str);
    }

    public JsonIOException(Throwable th) {
        super(th);
    }
}
