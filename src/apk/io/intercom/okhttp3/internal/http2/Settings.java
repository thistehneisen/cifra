package io.intercom.okhttp3.internal.http2;

import java.util.Arrays;

public final class Settings {
    static final int COUNT = 10;
    static final int DEFAULT_INITIAL_WINDOW_SIZE = 65535;
    static final int ENABLE_PUSH = 2;
    static final int HEADER_TABLE_SIZE = 1;
    static final int INITIAL_WINDOW_SIZE = 7;
    static final int MAX_CONCURRENT_STREAMS = 4;
    static final int MAX_FRAME_SIZE = 5;
    static final int MAX_HEADER_LIST_SIZE = 6;
    private int set;
    private final int[] values = new int[10];

    /* access modifiers changed from: 0000 */
    public void clear() {
        this.set = 0;
        Arrays.fill(this.values, 0);
    }

    /* access modifiers changed from: 0000 */
    public int get(int i2) {
        return this.values[i2];
    }

    /* access modifiers changed from: 0000 */
    public boolean getEnablePush(boolean z) {
        int i2 = (this.set & 4) != 0 ? this.values[2] : z ? 1 : 0;
        return i2 == 1;
    }

    /* access modifiers changed from: 0000 */
    public int getHeaderTableSize() {
        if ((this.set & 2) != 0) {
            return this.values[1];
        }
        return -1;
    }

    /* access modifiers changed from: 0000 */
    public int getInitialWindowSize() {
        return (this.set & 128) != 0 ? this.values[7] : DEFAULT_INITIAL_WINDOW_SIZE;
    }

    /* access modifiers changed from: 0000 */
    public int getMaxConcurrentStreams(int i2) {
        return (this.set & 16) != 0 ? this.values[4] : i2;
    }

    /* access modifiers changed from: 0000 */
    public int getMaxFrameSize(int i2) {
        return (this.set & 32) != 0 ? this.values[5] : i2;
    }

    /* access modifiers changed from: 0000 */
    public int getMaxHeaderListSize(int i2) {
        return (this.set & 64) != 0 ? this.values[6] : i2;
    }

    /* access modifiers changed from: 0000 */
    public boolean isSet(int i2) {
        return ((1 << i2) & this.set) != 0;
    }

    /* access modifiers changed from: 0000 */
    public void merge(Settings settings) {
        for (int i2 = 0; i2 < 10; i2++) {
            if (settings.isSet(i2)) {
                set(i2, settings.get(i2));
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public Settings set(int i2, int i3) {
        if (i2 >= 0) {
            int[] iArr = this.values;
            if (i2 < iArr.length) {
                this.set = (1 << i2) | this.set;
                iArr[i2] = i3;
            }
        }
        return this;
    }

    /* access modifiers changed from: 0000 */
    public int size() {
        return Integer.bitCount(this.set);
    }
}
