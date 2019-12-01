package org.joda.time.f;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.joda.time.e;

/* compiled from: DefaultNameProvider */
public class c implements e {

    /* renamed from: a reason: collision with root package name */
    private HashMap<Locale, Map<String, Map<String, Object>>> f10928a = a();

    /* renamed from: b reason: collision with root package name */
    private HashMap<Locale, Map<String, Map<Boolean, Object>>> f10929b = a();

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ce, code lost:
        return null;
     */
    private synchronized String[] c(Locale locale, String str, String str2) {
        String[] strArr;
        String[] strArr2 = null;
        if (locale != null && str != null && str2 != null) {
            Map map = (Map) this.f10928a.get(locale);
            if (map == null) {
                HashMap<Locale, Map<String, Map<String, Object>>> hashMap = this.f10928a;
                Map a2 = a();
                hashMap.put(locale, a2);
                map = a2;
            }
            Map map2 = (Map) map.get(str);
            if (map2 == null) {
                map2 = a();
                map.put(str, map2);
                String[][] zoneStrings = e.a(Locale.ENGLISH).getZoneStrings();
                int length = zoneStrings.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        strArr = null;
                        break;
                    }
                    strArr = zoneStrings[i2];
                    if (strArr != null && strArr.length >= 5 && str.equals(strArr[0])) {
                        break;
                    }
                    i2++;
                }
                String[][] zoneStrings2 = e.a(locale).getZoneStrings();
                int length2 = zoneStrings2.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length2) {
                        break;
                    }
                    String[] strArr3 = zoneStrings2[i3];
                    if (strArr3 != null && strArr3.length >= 5 && str.equals(strArr3[0])) {
                        strArr2 = strArr3;
                        break;
                    }
                    i3++;
                }
                if (!(strArr == null || strArr2 == null)) {
                    map2.put(strArr[2], new String[]{strArr2[2], strArr2[1]});
                    if (strArr[2].equals(strArr[4])) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(strArr[4]);
                        sb.append("-Summer");
                        map2.put(sb.toString(), new String[]{strArr2[4], strArr2[3]});
                    } else {
                        map2.put(strArr[4], new String[]{strArr2[4], strArr2[3]});
                    }
                }
            }
            return (String[]) map2.get(str2);
        }
    }

    public String a(Locale locale, String str, String str2) {
        String[] c2 = c(locale, str, str2);
        if (c2 == null) {
            return null;
        }
        return c2[1];
    }

    public String b(Locale locale, String str, String str2) {
        String[] c2 = c(locale, str, str2);
        if (c2 == null) {
            return null;
        }
        return c2[0];
    }

    public String a(Locale locale, String str, String str2, boolean z) {
        String[] c2 = c(locale, str, str2, z);
        if (c2 == null) {
            return null;
        }
        return c2[1];
    }

    public String b(Locale locale, String str, String str2, boolean z) {
        String[] c2 = c(locale, str, str2, z);
        if (c2 == null) {
            return null;
        }
        return c2[0];
    }

    private HashMap a() {
        return new HashMap(7);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00b3, code lost:
        return null;
     */
    private synchronized String[] c(Locale locale, String str, String str2, boolean z) {
        String[] strArr;
        String[] strArr2 = null;
        if (locale != null && str != null && str2 != null) {
            if (str.startsWith("Etc/")) {
                str = str.substring(4);
            }
            Map map = (Map) this.f10929b.get(locale);
            if (map == null) {
                HashMap<Locale, Map<String, Map<Boolean, Object>>> hashMap = this.f10929b;
                Map a2 = a();
                hashMap.put(locale, a2);
                map = a2;
            }
            Map map2 = (Map) map.get(str);
            if (map2 == null) {
                map2 = a();
                map.put(str, map2);
                String[][] zoneStrings = e.a(Locale.ENGLISH).getZoneStrings();
                int length = zoneStrings.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        strArr = null;
                        break;
                    }
                    strArr = zoneStrings[i2];
                    if (strArr != null && strArr.length >= 5 && str.equals(strArr[0])) {
                        break;
                    }
                    i2++;
                }
                String[][] zoneStrings2 = e.a(locale).getZoneStrings();
                int length2 = zoneStrings2.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length2) {
                        break;
                    }
                    String[] strArr3 = zoneStrings2[i3];
                    if (strArr3 != null && strArr3.length >= 5 && str.equals(strArr3[0])) {
                        strArr2 = strArr3;
                        break;
                    }
                    i3++;
                }
                if (!(strArr == null || strArr2 == null)) {
                    map2.put(Boolean.TRUE, new String[]{strArr2[2], strArr2[1]});
                    map2.put(Boolean.FALSE, new String[]{strArr2[4], strArr2[3]});
                }
            }
            return (String[]) map2.get(Boolean.valueOf(z));
        }
    }
}
