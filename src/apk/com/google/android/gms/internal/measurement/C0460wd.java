package com.google.android.gms.internal.measurement;

import io.fabric.sdk.android.a.c.c;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.google.android.gms.internal.measurement.wd reason: case insensitive filesystem */
public final class C0460wd {
    public static <T extends C0466xd> String a(T t) {
        String str = "Error printing proto: ";
        if (t == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            a(null, t, new StringBuffer(), stringBuffer);
            return stringBuffer.toString();
        } catch (IllegalAccessException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            return valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
        } catch (InvocationTargetException e3) {
            String valueOf2 = String.valueOf(e3.getMessage());
            return valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str);
        }
    }

    private static void a(String str, Object obj, StringBuffer stringBuffer, StringBuffer stringBuffer2) throws IllegalAccessException, InvocationTargetException {
        Field[] fields;
        int i2;
        if (obj != null) {
            if (obj instanceof C0466xd) {
                int length = stringBuffer.length();
                if (str != null) {
                    stringBuffer2.append(stringBuffer);
                    stringBuffer2.append(a(str));
                    stringBuffer2.append(" <\n");
                    stringBuffer.append("  ");
                }
                Class cls = obj.getClass();
                for (Field field : cls.getFields()) {
                    int modifiers = field.getModifiers();
                    String name = field.getName();
                    if (!"cachedSize".equals(name) && (modifiers & 1) == 1 && (modifiers & 8) != 8) {
                        String str2 = c.ROLL_OVER_FILE_NAME_SEPARATOR;
                        if (!name.startsWith(str2) && !name.endsWith(str2)) {
                            Class type = field.getType();
                            Object obj2 = field.get(obj);
                            if (!type.isArray() || type.getComponentType() == Byte.TYPE) {
                                a(name, obj2, stringBuffer, stringBuffer2);
                            } else {
                                if (obj2 == null) {
                                    i2 = 0;
                                } else {
                                    i2 = Array.getLength(obj2);
                                }
                                for (int i3 = 0; i3 < i2; i3++) {
                                    a(name, Array.get(obj2, i3), stringBuffer, stringBuffer2);
                                }
                            }
                        }
                    }
                }
                for (Method name2 : cls.getMethods()) {
                    String name3 = name2.getName();
                    if (name3.startsWith("set")) {
                        String substring = name3.substring(3);
                        String str3 = "has";
                        try {
                            String valueOf = String.valueOf(substring);
                            if (((Boolean) cls.getMethod(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3), new Class[0]).invoke(obj, new Object[0])).booleanValue()) {
                                String str4 = "get";
                                String valueOf2 = String.valueOf(substring);
                                a(substring, cls.getMethod(valueOf2.length() != 0 ? str4.concat(valueOf2) : new String(str4), new Class[0]).invoke(obj, new Object[0]), stringBuffer, stringBuffer2);
                            }
                        } catch (NoSuchMethodException unused) {
                        }
                    }
                }
                if (str != null) {
                    stringBuffer.setLength(length);
                    stringBuffer2.append(stringBuffer);
                    stringBuffer2.append(">\n");
                }
                return;
            }
            String a2 = a(str);
            stringBuffer2.append(stringBuffer);
            stringBuffer2.append(a2);
            stringBuffer2.append(": ");
            if (obj instanceof String) {
                String str5 = (String) obj;
                if (!str5.startsWith("http") && str5.length() > 200) {
                    str5 = String.valueOf(str5.substring(0, 200)).concat("[...]");
                }
                int length2 = str5.length();
                StringBuilder sb = new StringBuilder(length2);
                for (int i4 = 0; i4 < length2; i4++) {
                    char charAt = str5.charAt(i4);
                    if (charAt < ' ' || charAt > '~' || charAt == '\"' || charAt == '\'') {
                        sb.append(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
                    } else {
                        sb.append(charAt);
                    }
                }
                String sb2 = sb.toString();
                String str6 = "\"";
                stringBuffer2.append(str6);
                stringBuffer2.append(sb2);
                stringBuffer2.append(str6);
            } else if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                if (bArr == null) {
                    stringBuffer2.append("\"\"");
                } else {
                    stringBuffer2.append('\"');
                    for (byte b2 : bArr) {
                        byte b3 = b2 & 255;
                        if (b3 == 92 || b3 == 34) {
                            stringBuffer2.append('\\');
                            stringBuffer2.append((char) b3);
                        } else if (b3 < 32 || b3 >= Byte.MAX_VALUE) {
                            stringBuffer2.append(String.format("\\%03o", new Object[]{Integer.valueOf(b3)}));
                        } else {
                            stringBuffer2.append((char) b3);
                        }
                    }
                    stringBuffer2.append('\"');
                }
            } else {
                stringBuffer2.append(obj);
            }
            stringBuffer2.append("\n");
        }
    }

    private static String a(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (i2 == 0) {
                stringBuffer.append(Character.toLowerCase(charAt));
            } else if (Character.isUpperCase(charAt)) {
                stringBuffer.append('_');
                stringBuffer.append(Character.toLowerCase(charAt));
            } else {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }
}
