package com.bluelinelabs.logansquare;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;

public abstract class ParameterizedType<T> {
    public final Class rawType;
    public final List<ParameterizedType> typeParameters;

    static class ConcreteParameterizedType<T> extends ParameterizedType<T> {
        public ConcreteParameterizedType(Type type) {
            super(type);
        }
    }

    private void addTypeParameters(Type type) {
        if (type instanceof java.lang.reflect.ParameterizedType) {
            Type[] actualTypeArguments = ((java.lang.reflect.ParameterizedType) type).getActualTypeArguments();
            if (actualTypeArguments != null) {
                for (Type concreteParameterizedType : actualTypeArguments) {
                    this.typeParameters.add(new ConcreteParameterizedType(concreteParameterizedType));
                }
            }
        }
    }

    private Class getRawType(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof java.lang.reflect.ParameterizedType) {
            return (Class) ((java.lang.reflect.ParameterizedType) type).getRawType();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return getRawType(((WildcardType) type).getUpperBounds()[0]);
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(getRawType(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid type passed: ");
        sb.append(type);
        throw new RuntimeException(sb.toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ParameterizedType parameterizedType = (ParameterizedType) obj;
        if (!this.rawType.equals(parameterizedType.rawType)) {
            return false;
        }
        return this.typeParameters.equals(parameterizedType.typeParameters);
    }

    public int hashCode() {
        return (this.rawType.hashCode() * 31) + this.typeParameters.hashCode();
    }

    public ParameterizedType() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (!(genericSuperclass instanceof Class)) {
            Type type = ((java.lang.reflect.ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
            this.rawType = getRawType(type);
            this.typeParameters = new ArrayList();
            addTypeParameters(type);
            return;
        }
        throw new RuntimeException("ParameterizedType objects must be instantiated with a type parameter. Ex: new ParameterizedType<MyModel<MyOtherModel>>() { }");
    }

    private ParameterizedType(Type type) {
        this.rawType = getRawType(type);
        this.typeParameters = new ArrayList();
        addTypeParameters(type);
    }
}
