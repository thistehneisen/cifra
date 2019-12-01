package io.intercom.android.sdk.utilities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class CustomAttributeValidator {
    private static final List<? extends Class<? extends Serializable>> ACCEPTED_CUSTOM_ATTRIBUTE_TYPES = Arrays.asList(new Class[]{String.class, Character.class, Short.class, Long.class, Float.class, Double.class, Integer.class, Byte.class, Boolean.class});

    public static String getAcceptedTypes() {
        StringBuilder sb = new StringBuilder();
        for (Class cls : ACCEPTED_CUSTOM_ATTRIBUTE_TYPES) {
            if (sb.length() != 0) {
                sb.append(", ");
            }
            sb.append(cls.getSimpleName());
        }
        return sb.toString();
    }

    public static boolean isValid(Object obj) {
        return obj == null || ACCEPTED_CUSTOM_ATTRIBUTE_TYPES.contains(obj.getClass());
    }
}
