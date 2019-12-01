package h.a.a.a;

import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ResUtils */
public class c {

    /* renamed from: a reason: collision with root package name */
    private static Map<Class<?>, Map<String, Integer>> f8417a = new ConcurrentHashMap();

    public static String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("joda_");
        sb.append(b(str));
        return sb.toString();
    }

    private static String b(String str) {
        File file = new File(str);
        ArrayList arrayList = new ArrayList();
        do {
            arrayList.add(file.getName());
            file = file.getParentFile();
        } while (file != null);
        StringBuffer stringBuffer = new StringBuffer();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (stringBuffer.length() > 0) {
                stringBuffer.append(io.fabric.sdk.android.a.c.c.ROLL_OVER_FILE_NAME_SEPARATOR);
            }
            stringBuffer.append((String) arrayList.get(size));
        }
        return stringBuffer.toString().replace('-', '_').replace("+", "plus").toLowerCase(Locale.US);
    }

    public static int a(Class<?> cls, String str) {
        Map map;
        if (!f8417a.containsKey(cls)) {
            map = new ConcurrentHashMap();
            f8417a.put(cls, map);
        } else {
            map = (Map) f8417a.get(cls);
        }
        if (map.containsKey(str)) {
            return ((Integer) map.get(str)).intValue();
        }
        try {
            int i2 = cls.getField(str).getInt(null);
            if (i2 != 0) {
                map.put(str, Integer.valueOf(i2));
            }
            return i2;
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to retrieve identifier: type=");
            sb.append(cls);
            sb.append(" name=");
            sb.append(str);
            Log.e("JodaTimeAndroid", sb.toString(), e2);
            return 0;
        }
    }
}
