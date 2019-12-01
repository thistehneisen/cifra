package com.bluelinelabs.logansquare;

import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public abstract class JsonMapper<T> {
    public abstract T parse(e eVar) throws IOException;

    public T parse(InputStream inputStream) throws IOException {
        e a2 = LoganSquare.JSON_FACTORY.a(inputStream);
        a2.F();
        return parse(a2);
    }

    public abstract void parseField(T t, String str, e eVar) throws IOException;

    public List<T> parseList(InputStream inputStream) throws IOException {
        e a2 = LoganSquare.JSON_FACTORY.a(inputStream);
        a2.F();
        return parseList(a2);
    }

    public Map<String, T> parseMap(InputStream inputStream) throws IOException {
        e a2 = LoganSquare.JSON_FACTORY.a(inputStream);
        a2.F();
        return parseMap(a2);
    }

    public String serialize(T t) throws IOException {
        StringWriter stringWriter = new StringWriter();
        c a2 = LoganSquare.JSON_FACTORY.a((Writer) stringWriter);
        serialize(t, a2, true);
        a2.close();
        return stringWriter.toString();
    }

    public abstract void serialize(T t, c cVar, boolean z) throws IOException;

    public T parse(byte[] bArr) throws IOException {
        e a2 = LoganSquare.JSON_FACTORY.a(bArr);
        a2.F();
        return parse(a2);
    }

    public List<T> parseList(byte[] bArr) throws IOException {
        e a2 = LoganSquare.JSON_FACTORY.a(bArr);
        a2.F();
        return parseList(a2);
    }

    public Map<String, T> parseMap(byte[] bArr) throws IOException {
        e a2 = LoganSquare.JSON_FACTORY.a(bArr);
        a2.F();
        return parseMap(a2);
    }

    public void serialize(T t, OutputStream outputStream) throws IOException {
        c a2 = LoganSquare.JSON_FACTORY.a(outputStream);
        serialize(t, a2, true);
        a2.close();
    }

    public T parse(char[] cArr) throws IOException {
        e a2 = LoganSquare.JSON_FACTORY.a(cArr);
        a2.F();
        return parse(a2);
    }

    public List<T> parseList(char[] cArr) throws IOException {
        e a2 = LoganSquare.JSON_FACTORY.a(cArr);
        a2.F();
        return parseList(a2);
    }

    public Map<String, T> parseMap(char[] cArr) throws IOException {
        e a2 = LoganSquare.JSON_FACTORY.a(cArr);
        a2.F();
        return parseMap(a2);
    }

    public String serialize(List<T> list) throws IOException {
        StringWriter stringWriter = new StringWriter();
        c a2 = LoganSquare.JSON_FACTORY.a((Writer) stringWriter);
        serialize(list, a2);
        a2.close();
        return stringWriter.toString();
    }

    public T parse(String str) throws IOException {
        e a2 = LoganSquare.JSON_FACTORY.a(str);
        a2.F();
        return parse(a2);
    }

    public List<T> parseList(String str) throws IOException {
        e a2 = LoganSquare.JSON_FACTORY.a(str);
        a2.F();
        return parseList(a2);
    }

    public Map<String, T> parseMap(String str) throws IOException {
        e a2 = LoganSquare.JSON_FACTORY.a(str);
        a2.F();
        return parseMap(a2);
    }

    public List<T> parseList(e eVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (eVar.d() == g.START_ARRAY) {
            while (eVar.F() != g.END_ARRAY) {
                arrayList.add(parse(eVar));
            }
        }
        return arrayList;
    }

    public Map<String, T> parseMap(e eVar) throws IOException {
        HashMap hashMap = new HashMap();
        while (eVar.F() != g.END_OBJECT) {
            String j2 = eVar.j();
            eVar.F();
            if (eVar.d() == g.VALUE_NULL) {
                hashMap.put(j2, null);
            } else {
                hashMap.put(j2, parse(eVar));
            }
        }
        return hashMap;
    }

    public void serialize(List<T> list, OutputStream outputStream) throws IOException {
        c a2 = LoganSquare.JSON_FACTORY.a(outputStream);
        serialize(list, a2);
        a2.close();
    }

    public void serialize(List<T> list, c cVar) throws IOException {
        cVar.e();
        for (Object next : list) {
            if (next != null) {
                serialize(next, cVar, true);
            } else {
                cVar.d();
            }
        }
        cVar.b();
    }

    public String serialize(Map<String, T> map) throws IOException {
        StringWriter stringWriter = new StringWriter();
        c a2 = LoganSquare.JSON_FACTORY.a((Writer) stringWriter);
        serialize(map, a2);
        a2.close();
        return stringWriter.toString();
    }

    public void serialize(Map<String, T> map, OutputStream outputStream) throws IOException {
        c a2 = LoganSquare.JSON_FACTORY.a(outputStream);
        serialize(map, a2);
        a2.close();
    }

    public void serialize(Map<String, T> map, c cVar) throws IOException {
        cVar.f();
        for (Entry entry : map.entrySet()) {
            cVar.c((String) entry.getKey());
            if (entry.getValue() == null) {
                cVar.d();
            } else {
                serialize(entry.getValue(), cVar, true);
            }
        }
        cVar.c();
    }
}
