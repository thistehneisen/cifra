package io.intercom.android.sdk.utilities;

public class NameUtils {
    public static String getInitial(String str) {
        String trim = str.trim();
        return trim.isEmpty() ? "" : String.valueOf(trim.charAt(0));
    }
}
