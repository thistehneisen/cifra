package com.fasterxml.jackson.core;

public class JsonGenerationException extends JsonProcessingException {
    private static final long serialVersionUID = 123;

    public JsonGenerationException(String str) {
        super(str, null);
    }
}
