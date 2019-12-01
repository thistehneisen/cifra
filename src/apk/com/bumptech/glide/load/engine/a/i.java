package com.bumptech.glide.load.engine.a;

/* compiled from: IntegerArrayAdapter */
public final class i implements a<int[]> {
    public int a() {
        return 4;
    }

    public String getTag() {
        return "IntegerArrayPool";
    }

    public int a(int[] iArr) {
        return iArr.length;
    }

    public int[] newArray(int i2) {
        return new int[i2];
    }
}
