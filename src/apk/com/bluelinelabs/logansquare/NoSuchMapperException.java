package com.bluelinelabs.logansquare;

public class NoSuchMapperException extends RuntimeException {
    public NoSuchMapperException(Class cls) {
        StringBuilder sb = new StringBuilder();
        sb.append("Class ");
        sb.append(cls.getCanonicalName());
        sb.append(" could not be mapped to a JSON object. Perhaps it hasn't been annotated with @JsonObject?");
        super(sb.toString());
    }
}
