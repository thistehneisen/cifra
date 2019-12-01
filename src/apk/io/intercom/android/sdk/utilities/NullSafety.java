package io.intercom.android.sdk.utilities;

public class NullSafety {
    public static boolean valueOrDefault(Boolean bool, boolean z) {
        return bool == null ? z : bool.booleanValue();
    }

    public static String valueOrEmpty(String str) {
        return str == null ? "" : str;
    }
}
