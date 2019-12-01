package io.intercom.android.sdk.blocks;

import java.util.Locale;

public enum BlockAlignment {
    LEFT {
        public int getGravity() {
            return 3;
        }
    },
    CENTER {
        public int getGravity() {
            return 1;
        }
    },
    RIGHT {
        public int getGravity() {
            return 5;
        }
    };

    public static BlockAlignment alignValueOf(String str) {
        try {
            return valueOf(str.toUpperCase(Locale.ENGLISH));
        } catch (IllegalArgumentException | NullPointerException unused) {
            return LEFT;
        }
    }

    public abstract int getGravity();
}
