package ru.touchin.roboswag.core.observables.storable;

import java.lang.reflect.Type;

public interface Converter<TObject, TStoreObject> {

    public static class ConversionException extends Exception {
    }

    TObject a(Type type, Type type2, TStoreObject tstoreobject) throws ConversionException;

    TStoreObject b(Type type, Type type2, TObject tobject) throws ConversionException;
}
