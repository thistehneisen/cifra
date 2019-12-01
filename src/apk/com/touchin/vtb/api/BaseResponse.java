package com.touchin.vtb.api;

import b.g.h.c;
import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import ru.touchin.templates.ApiModel;
import ru.touchin.templates.ApiModel.ValidationException;
import ru.touchin.templates.a.d;

@JsonObject(serializeNullObjects = false)
public class BaseResponse<T> extends d {
    @JsonField(name = {"errorCode"})
    private ApiError errorCode;
    @JsonField(name = {"errorMessage"})
    private String errorMessage;
    @JsonField(name = {"result"})
    private T result;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.result = objectInputStream.readObject();
        this.errorCode = (ApiError) objectInputStream.readObject();
        this.errorMessage = (String) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.result);
        objectOutputStream.writeObject(this.errorCode);
        objectOutputStream.writeObject(this.errorMessage);
    }

    public void a(ApiError apiError) {
        this.errorCode = apiError;
    }

    public void b(T t) {
        this.result = t;
    }

    public String c() {
        String str = this.errorMessage;
        if (str == null) {
            return null;
        }
        return str;
    }

    public T d() {
        T t = this.result;
        if (t == null) {
            return null;
        }
        return t;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || BaseResponse.class != obj.getClass()) {
            return false;
        }
        BaseResponse baseResponse = (BaseResponse) obj;
        if (!c.a(this.result, baseResponse.result) || !c.a(this.errorCode, baseResponse.errorCode) || !c.a(this.errorMessage, baseResponse.errorMessage)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return c.a(this.result, this.errorCode, this.errorMessage);
    }

    public void a(String str) {
        this.errorMessage = str;
    }

    public ApiError b() {
        return this.errorCode;
    }

    public void a() throws ValidationException {
        super.a();
        T t = this.result;
        if ((t instanceof ApiModel) && t != null) {
            ((ApiModel) t).a();
        }
        d.a(this.errorCode);
    }
}
