package io.intercom.android.sdk.logger;

import io.intercom.android.sdk.Intercom.LogLevel;
import io.intercom.android.sdk.twig.Twig;

public class LumberMill {
    private static final Twig BLOCK_TWIG;
    private static final Twig MESSENGER_TWIG;
    private static final Twig NEXUS_TWIG = new Twig(5, "Intercom realtime", false);

    static {
        String str = "Intercom";
        MESSENGER_TWIG = new Twig(5, str, false);
        BLOCK_TWIG = new Twig(5, str, false);
    }

    public static Twig getBlocksTwig() {
        return BLOCK_TWIG;
    }

    public static Twig getLogger() {
        return MESSENGER_TWIG;
    }

    public static Twig getNexusTwig() {
        return NEXUS_TWIG;
    }

    public static void setLogLevel(@LogLevel int i2) {
        MESSENGER_TWIG.setLogLevel(i2);
        NEXUS_TWIG.setLogLevel(i2);
        BLOCK_TWIG.setLogLevel(i2);
    }
}
