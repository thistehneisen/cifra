package com.bluelinelabs.logansquare;

import com.bluelinelabs.logansquare.internal.objectmappers.BooleanMapper;
import com.bluelinelabs.logansquare.internal.objectmappers.DoubleMapper;
import com.bluelinelabs.logansquare.internal.objectmappers.FloatMapper;
import com.bluelinelabs.logansquare.internal.objectmappers.IntegerMapper;
import com.bluelinelabs.logansquare.internal.objectmappers.ListMapper;
import com.bluelinelabs.logansquare.internal.objectmappers.LongMapper;
import com.bluelinelabs.logansquare.internal.objectmappers.MapMapper;
import com.bluelinelabs.logansquare.internal.objectmappers.ObjectMapper;
import com.bluelinelabs.logansquare.internal.objectmappers.StringMapper;
import com.bluelinelabs.logansquare.typeconverters.DefaultCalendarConverter;
import com.bluelinelabs.logansquare.typeconverters.DefaultDateConverter;
import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.bluelinelabs.logansquare.util.SimpleArrayMap;
import com.fasterxml.jackson.core.b;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LoganSquare {
    private static final Map<Class, TypeConverter> ENUM_CONVERTERS = new ConcurrentHashMap();
    public static final b JSON_FACTORY = new b();
    private static final ListMapper LIST_MAPPER = new ListMapper();
    private static final MapMapper MAP_MAPPER = new MapMapper();
    private static final TypeConverter NULL_CONVERTER = new TypeConverter() {
        public Object parse(e eVar) throws IOException {
            throw new IllegalStateException();
        }

        public void serialize(Object obj, String str, boolean z, c cVar) throws IOException {
            throw new IllegalStateException();
        }
    };
    private static final Map<Class, JsonMapper> OBJECT_MAPPERS = new ConcurrentHashMap();
    private static final ConcurrentHashMap<ParameterizedType, JsonMapper> PARAMETERIZED_OBJECT_MAPPERS = new ConcurrentHashMap<>();
    private static final SimpleArrayMap<Class, TypeConverter> TYPE_CONVERTERS = new SimpleArrayMap<>();

    static {
        OBJECT_MAPPERS.put(String.class, new StringMapper());
        OBJECT_MAPPERS.put(Integer.class, new IntegerMapper());
        OBJECT_MAPPERS.put(Long.class, new LongMapper());
        OBJECT_MAPPERS.put(Float.class, new FloatMapper());
        OBJECT_MAPPERS.put(Double.class, new DoubleMapper());
        OBJECT_MAPPERS.put(Boolean.class, new BooleanMapper());
        OBJECT_MAPPERS.put(Object.class, new ObjectMapper());
        OBJECT_MAPPERS.put(List.class, LIST_MAPPER);
        OBJECT_MAPPERS.put(ArrayList.class, LIST_MAPPER);
        OBJECT_MAPPERS.put(Map.class, MAP_MAPPER);
        OBJECT_MAPPERS.put(HashMap.class, MAP_MAPPER);
        registerTypeConverter(Date.class, new DefaultDateConverter());
        registerTypeConverter(Calendar.class, new DefaultCalendarConverter());
    }

    private static <E> TypeConverter<E> findGeneratedEnumConverterFor(Class<E> cls) {
        if (cls.getSuperclass() != Enum.class) {
            return null;
        }
        if (!ENUM_CONVERTERS.containsKey(cls)) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(cls.getName());
                sb.append(Constants.CONVERTER_CLASS_SUFFIX);
                Class cls2 = Class.forName(sb.toString());
                if (cls2 != null) {
                    ENUM_CONVERTERS.put(cls, (TypeConverter) cls2.newInstance());
                } else {
                    ENUM_CONVERTERS.put(cls, NULL_CONVERTER);
                }
            } catch (Exception unused) {
                ENUM_CONVERTERS.put(cls, NULL_CONVERTER);
            }
        }
        TypeConverter<E> typeConverter = (TypeConverter) ENUM_CONVERTERS.get(cls);
        if (typeConverter == NULL_CONVERTER) {
            typeConverter = null;
        }
        return typeConverter;
    }

    static <E> JsonMapper<E> getMapper(Class<E> cls) {
        JsonMapper<E> jsonMapper = (JsonMapper) OBJECT_MAPPERS.get(cls);
        if (jsonMapper != null) {
            return jsonMapper;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(cls.getName());
            sb.append(Constants.MAPPER_CLASS_SUFFIX);
            JsonMapper jsonMapper2 = (JsonMapper) Class.forName(sb.toString()).newInstance();
            try {
                OBJECT_MAPPERS.put(cls, jsonMapper2);
            } catch (Exception unused) {
            }
            return jsonMapper2;
        } catch (Exception unused2) {
            return jsonMapper;
        }
    }

    public static <E> JsonMapper<E> mapperFor(Class<E> cls) throws NoSuchMapperException {
        JsonMapper<E> mapper = getMapper(cls);
        if (mapper != null) {
            return mapper;
        }
        throw new NoSuchMapperException(cls);
    }

    public static <E> E parse(InputStream inputStream, Class<E> cls) throws IOException {
        return mapperFor(cls).parse(inputStream);
    }

    public static <E> List<E> parseList(InputStream inputStream, Class<E> cls) throws IOException {
        return mapperFor(cls).parseList(inputStream);
    }

    public static <E> Map<String, E> parseMap(InputStream inputStream, Class<E> cls) throws IOException {
        return mapperFor(cls).parseMap(inputStream);
    }

    public static <E> void registerTypeConverter(Class<E> cls, TypeConverter<E> typeConverter) {
        TYPE_CONVERTERS.put(cls, typeConverter);
    }

    public static <E> String serialize(E e2) throws IOException {
        return mapperFor(e2.getClass()).serialize(e2);
    }

    public static boolean supports(Class cls) {
        return getMapper(cls) != null;
    }

    public static <E> TypeConverter<E> typeConverterFor(Class<E> cls) throws NoSuchTypeConverterException {
        TypeConverter<E> typeConverter = (TypeConverter) TYPE_CONVERTERS.get(cls);
        if (typeConverter == null) {
            typeConverter = findGeneratedEnumConverterFor(cls);
        }
        if (typeConverter != null) {
            return typeConverter;
        }
        throw new NoSuchTypeConverterException(cls);
    }

    public static <E> E parse(String str, Class<E> cls) throws IOException {
        return mapperFor(cls).parse(str);
    }

    public static <E> List<E> parseList(String str, Class<E> cls) throws IOException {
        return mapperFor(cls).parseList(str);
    }

    public static <E> Map<String, E> parseMap(String str, Class<E> cls) throws IOException {
        return mapperFor(cls).parseMap(str);
    }

    public static <E> void serialize(E e2, OutputStream outputStream) throws IOException {
        mapperFor(e2.getClass()).serialize(e2, outputStream);
    }

    public static boolean supports(ParameterizedType parameterizedType) {
        return getMapper(parameterizedType, null) != null;
    }

    public static <E> JsonMapper<E> mapperFor(ParameterizedType<E> parameterizedType) throws NoSuchMapperException {
        return mapperFor(parameterizedType, null);
    }

    public static <E> E parse(InputStream inputStream, ParameterizedType<E> parameterizedType) throws IOException {
        return mapperFor(parameterizedType).parse(inputStream);
    }

    public static <E> String serialize(E e2, ParameterizedType<E> parameterizedType) throws IOException {
        return mapperFor(parameterizedType).serialize(e2);
    }

    public static <E> JsonMapper<E> mapperFor(ParameterizedType<E> parameterizedType, SimpleArrayMap<ParameterizedType, JsonMapper> simpleArrayMap) throws NoSuchMapperException {
        JsonMapper<E> mapper = getMapper(parameterizedType, simpleArrayMap);
        if (mapper != null) {
            return mapper;
        }
        throw new NoSuchMapperException(parameterizedType.rawType);
    }

    public static <E> E parse(String str, ParameterizedType<E> parameterizedType) throws IOException {
        return mapperFor(parameterizedType).parse(str);
    }

    public static <E> void serialize(E e2, ParameterizedType<E> parameterizedType, OutputStream outputStream) throws IOException {
        mapperFor(parameterizedType).serialize(e2, outputStream);
    }

    private static <E> JsonMapper<E> getMapper(ParameterizedType<E> parameterizedType, SimpleArrayMap<ParameterizedType, JsonMapper> simpleArrayMap) {
        if (parameterizedType.typeParameters.size() == 0) {
            return getMapper(parameterizedType.rawType);
        }
        if (simpleArrayMap == null) {
            simpleArrayMap = new SimpleArrayMap<>();
        }
        if (simpleArrayMap.containsKey(parameterizedType)) {
            return (JsonMapper) simpleArrayMap.get(parameterizedType);
        }
        if (PARAMETERIZED_OBJECT_MAPPERS.containsKey(parameterizedType)) {
            return (JsonMapper) PARAMETERIZED_OBJECT_MAPPERS.get(parameterizedType);
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(parameterizedType.rawType.getName());
            sb.append(Constants.MAPPER_CLASS_SUFFIX);
            int i2 = 0;
            Constructor constructor = Class.forName(sb.toString()).getDeclaredConstructors()[0];
            Object[] objArr = new Object[(parameterizedType.typeParameters.size() + 2)];
            objArr[0] = parameterizedType;
            objArr[objArr.length - 1] = simpleArrayMap;
            while (i2 < parameterizedType.typeParameters.size()) {
                int i3 = i2 + 1;
                objArr[i3] = parameterizedType.typeParameters.get(i2);
                i2 = i3;
            }
            JsonMapper<E> jsonMapper = (JsonMapper) constructor.newInstance(objArr);
            PARAMETERIZED_OBJECT_MAPPERS.put(parameterizedType, jsonMapper);
            return jsonMapper;
        } catch (Exception unused) {
            return null;
        }
    }

    public static <E> String serialize(List<E> list, Class<E> cls) throws IOException {
        return mapperFor(cls).serialize(list);
    }

    public static <E> void serialize(List<E> list, OutputStream outputStream, Class<E> cls) throws IOException {
        mapperFor(cls).serialize(list, outputStream);
    }

    public static <E> String serialize(Map<String, E> map, Class<E> cls) throws IOException {
        return mapperFor(cls).serialize(map);
    }

    public static <E> void serialize(Map<String, E> map, OutputStream outputStream, Class<E> cls) throws IOException {
        mapperFor(cls).serialize(map, outputStream);
    }
}
