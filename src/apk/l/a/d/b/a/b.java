package l.a.d.b.a;

import android.util.Log;

/* compiled from: ConsoleLogProcessor */
public class b extends f {
    public b(e eVar) {
        super(eVar);
    }

    private String a(String str) {
        return str.replace("\r\n", "\n").replace("\u0000", "");
    }

    public void a(d dVar, e eVar, String str, String str2, Throwable th) {
        String str3;
        int min;
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        if (th != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(10);
            sb2.append(Log.getStackTraceString(th));
            str3 = sb2.toString();
        } else {
            str3 = "";
        }
        sb.append(str3);
        String a2 = a(sb.toString());
        int length = a2.length();
        int i2 = 0;
        while (i2 < length) {
            int indexOf = a2.indexOf(10, i2);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i2 + 4000);
                Log.println(eVar.getPriority(), str, a2.substring(i2, min));
                if (min >= indexOf) {
                    break;
                }
                i2 = min;
            }
            i2 = min + 1;
        }
    }
}
