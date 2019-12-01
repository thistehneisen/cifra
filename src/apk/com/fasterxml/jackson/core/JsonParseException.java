package com.fasterxml.jackson.core;

public class JsonParseException extends JsonProcessingException {
    private static final long serialVersionUID = 1;

    public JsonParseException(String str, d dVar) {
        super(str, dVar);
    }

    public JsonParseException(String str, d dVar, Throwable th) {
        super(str, dVar, th);
    }
}
