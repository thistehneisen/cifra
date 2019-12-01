package com.intercom.input.gallery;

import java.io.Serializable;

public class ClassUtils {
    public static <T> Class<? extends T> cast(Serializable serializable) {
        return (Class) serializable;
    }

    public static <T> T instantiate(Class<? extends T> cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not instantiate ");
            sb.append(cls);
            throw new RuntimeException(sb.toString(), e2);
        } catch (IllegalAccessException e3) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Could not instantiate");
            sb2.append(cls);
            sb2.append(", make sure the class is public and static");
            throw new RuntimeException(sb2.toString(), e3);
        }
    }
}
