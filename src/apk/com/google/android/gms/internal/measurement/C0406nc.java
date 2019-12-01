package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.Eb.b;
import io.fabric.sdk.android.a.c.c;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;

/* renamed from: com.google.android.gms.internal.measurement.nc reason: case insensitive filesystem */
final class C0406nc {
    static String a(C0400mc mcVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        a(mcVar, sb, 0);
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01f2, code lost:
        if (((java.lang.Boolean) r11).booleanValue() == false) goto L_0x01f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0204, code lost:
        if (((java.lang.Integer) r11).intValue() == 0) goto L_0x01f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0215, code lost:
        if (((java.lang.Float) r11).floatValue() == 0.0f) goto L_0x01f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0227, code lost:
        if (((java.lang.Double) r11).doubleValue() == 0.0d) goto L_0x01f4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x025d  */
    private static void a(C0400mc mcVar, StringBuilder sb, int i2) {
        String str;
        boolean z;
        C0400mc mcVar2 = mcVar;
        StringBuilder sb2 = sb;
        int i3 = i2;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet<>();
        Method[] declaredMethods = mcVar.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i4 = 0;
        while (true) {
            str = "get";
            if (i4 >= length) {
                break;
            }
            Method method = declaredMethods[i4];
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith(str)) {
                    treeSet.add(method.getName());
                }
            }
            i4++;
        }
        for (String str2 : treeSet) {
            String str3 = "";
            String replaceFirst = str2.replaceFirst(str, str3);
            String str4 = "List";
            boolean z2 = true;
            if (replaceFirst.endsWith(str4) && !replaceFirst.endsWith("OrBuilderList") && !replaceFirst.equals(str4)) {
                String valueOf = String.valueOf(replaceFirst.substring(0, 1).toLowerCase());
                String valueOf2 = String.valueOf(replaceFirst.substring(1, replaceFirst.length() - 4));
                String concat = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                Method method2 = (Method) hashMap.get(str2);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    a(sb2, i3, a(concat), Eb.a(method2, (Object) mcVar2, new Object[0]));
                }
            }
            String str5 = "Map";
            if (replaceFirst.endsWith(str5) && !replaceFirst.equals(str5)) {
                String valueOf3 = String.valueOf(replaceFirst.substring(0, 1).toLowerCase());
                String valueOf4 = String.valueOf(replaceFirst.substring(1, replaceFirst.length() - 3));
                String concat2 = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
                Method method3 = (Method) hashMap.get(str2);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    a(sb2, i3, a(concat2), Eb.a(method3, (Object) mcVar2, new Object[0]));
                }
            }
            String str6 = "set";
            String valueOf5 = String.valueOf(replaceFirst);
            if (((Method) hashMap2.get(valueOf5.length() != 0 ? str6.concat(valueOf5) : new String(str6))) != null) {
                if (replaceFirst.endsWith("Bytes")) {
                    String valueOf6 = String.valueOf(replaceFirst.substring(0, replaceFirst.length() - 5));
                    if (hashMap.containsKey(valueOf6.length() != 0 ? str.concat(valueOf6) : new String(str))) {
                    }
                }
                String valueOf7 = String.valueOf(replaceFirst.substring(0, 1).toLowerCase());
                String valueOf8 = String.valueOf(replaceFirst.substring(1));
                String concat3 = valueOf8.length() != 0 ? valueOf7.concat(valueOf8) : new String(valueOf7);
                String valueOf9 = String.valueOf(replaceFirst);
                Method method4 = (Method) hashMap.get(valueOf9.length() != 0 ? str.concat(valueOf9) : new String(str));
                String str7 = "has";
                String valueOf10 = String.valueOf(replaceFirst);
                Method method5 = (Method) hashMap.get(valueOf10.length() != 0 ? str7.concat(valueOf10) : new String(str7));
                if (method4 != null) {
                    Object a2 = Eb.a(method4, (Object) mcVar2, new Object[0]);
                    if (method5 == null) {
                        if (!(a2 instanceof Boolean)) {
                            if (!(a2 instanceof Integer)) {
                                if (!(a2 instanceof Float)) {
                                    if (!(a2 instanceof Double)) {
                                        z = a2 instanceof String ? a2.equals(str3) : a2 instanceof Xa ? a2.equals(Xa.f5082a) : !(a2 instanceof C0400mc) ? false : false;
                                        if (z) {
                                            z2 = false;
                                        }
                                    }
                                }
                            }
                        }
                        z = true;
                        if (z) {
                        }
                    } else {
                        z2 = ((Boolean) Eb.a(method5, (Object) mcVar2, new Object[0])).booleanValue();
                    }
                    if (z2) {
                        a(sb2, i3, a(concat3), a2);
                    }
                }
            }
        }
        if (mcVar2 instanceof b) {
            Iterator d2 = ((b) mcVar2).zzaic.d();
            if (d2.hasNext()) {
                ((Entry) d2.next()).getKey();
                throw new NoSuchMethodError();
            }
        }
        Vc vc = ((Eb) mcVar2).zzahz;
        if (vc != null) {
            vc.a(sb2, i3);
        }
    }

    static final void a(StringBuilder sb, int i2, String str, Object obj) {
        if (obj instanceof List) {
            for (Object a2 : (List) obj) {
                a(sb, i2, str, a2);
            }
        } else if (obj instanceof Map) {
            for (Entry a3 : ((Map) obj).entrySet()) {
                a(sb, i2, str, a3);
            }
        } else {
            sb.append(10);
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                sb.append(' ');
            }
            sb.append(str);
            String str2 = ": \"";
            if (obj instanceof String) {
                sb.append(str2);
                sb.append(Pc.a(Xa.a((String) obj)));
                sb.append('\"');
            } else if (obj instanceof Xa) {
                sb.append(str2);
                sb.append(Pc.a((Xa) obj));
                sb.append('\"');
            } else {
                String str3 = "}";
                String str4 = "\n";
                String str5 = " {";
                if (obj instanceof Eb) {
                    sb.append(str5);
                    a((Eb) obj, sb, i2 + 2);
                    sb.append(str4);
                    while (i3 < i2) {
                        sb.append(' ');
                        i3++;
                    }
                    sb.append(str3);
                } else if (obj instanceof Entry) {
                    sb.append(str5);
                    Entry entry = (Entry) obj;
                    int i5 = i2 + 2;
                    a(sb, i5, "key", entry.getKey());
                    a(sb, i5, "value", entry.getValue());
                    sb.append(str4);
                    while (i3 < i2) {
                        sb.append(' ');
                        i3++;
                    }
                    sb.append(str3);
                } else {
                    sb.append(": ");
                    sb.append(obj.toString());
                }
            }
        }
    }

    private static final String a(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (Character.isUpperCase(charAt)) {
                sb.append(c.ROLL_OVER_FILE_NAME_SEPARATOR);
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }
}
