package com.bluelinelabs.logansquare;

public class NoSuchTypeConverterException extends RuntimeException {
    public NoSuchTypeConverterException(Class cls) {
        StringBuilder sb = new StringBuilder();
        sb.append("Class ");
        sb.append(cls.getCanonicalName());
        sb.append(" does not having a TypeConverter defined. TypeConverters can be added using LoganSquare.registerTypeConverter().");
        super(sb.toString());
    }
}
