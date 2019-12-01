package org.joda.time;

import org.joda.time.e.a;

public class IllegalInstantException extends IllegalArgumentException {
    private static final long serialVersionUID = 2858712538216L;

    public IllegalInstantException(String str) {
        super(str);
    }

    private static String a(long j2, String str) {
        String str2;
        String a2 = a.a("yyyy-MM-dd'T'HH:mm:ss.SSS").a((r) new j(j2));
        if (str != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(" (");
            sb.append(str);
            sb.append(")");
            str2 = sb.toString();
        } else {
            str2 = "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Illegal instant due to time zone offset transition (daylight savings time 'gap'): ");
        sb2.append(a2);
        sb2.append(str2);
        return sb2.toString();
    }

    public IllegalInstantException(long j2, String str) {
        super(a(j2, str));
    }
}
