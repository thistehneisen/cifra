package com.appsflyer;

import java.security.MessageDigest;
import java.util.Formatter;

final class p {
    p() {
    }

    /* renamed from: ˊ reason: contains not printable characters */
    public static String m175(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.reset();
            instance.update(str.getBytes("UTF-8"));
            return m176(instance.digest());
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder("Error turning ");
            sb.append(str.substring(0, 6));
            sb.append(".. to SHA1");
            AFLogger.afErrorLog(sb.toString(), e2);
            return null;
        }
    }

    /* renamed from: ˎ reason: contains not printable characters */
    private static String m176(byte[] bArr) {
        Formatter formatter = new Formatter();
        for (byte valueOf : bArr) {
            formatter.format("%02x", new Object[]{Byte.valueOf(valueOf)});
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }

    /* renamed from: ˏ reason: contains not printable characters */
    public static String m177(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : digest) {
                stringBuffer.append(Integer.toString((b2 & 255) + 256, 16).substring(1));
            }
            return stringBuffer.toString();
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder("Error turning ");
            sb.append(str.substring(0, 6));
            sb.append(".. to SHA-256");
            AFLogger.afErrorLog(sb.toString(), e2);
            return null;
        }
    }

    /* renamed from: ॱ reason: contains not printable characters */
    public static String m178(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(str.getBytes("UTF-8"));
            return m176(instance.digest());
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder("Error turning ");
            sb.append(str.substring(0, 6));
            sb.append(".. to MD5");
            AFLogger.afErrorLog(sb.toString(), e2);
            return null;
        }
    }
}
