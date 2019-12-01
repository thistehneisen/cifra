package io.intercom.com.bumptech.glide;

/* compiled from: MemoryCategory */
public enum f {
    LOW(0.5f),
    NORMAL(1.0f),
    HIGH(1.5f);
    
    private final float multiplier;

    private f(float f2) {
        this.multiplier = f2;
    }
}
