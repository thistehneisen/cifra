package io.intercom.android.sdk.utilities;

import java.io.Closeable;
import java.io.File;

public class IoUtils {
    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void safelyDelete(File file) {
        try {
            if (!file.delete()) {
                file.deleteOnExit();
            }
        } catch (Exception unused) {
        }
    }
}
