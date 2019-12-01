package io.intercom.com.bumptech.glide.load.engine.a;

/* compiled from: ByteArrayAdapter */
public final class g implements a<byte[]> {
    public int a() {
        return 1;
    }

    public String getTag() {
        return "ByteArrayPool";
    }

    public int a(byte[] bArr) {
        return bArr.length;
    }

    public byte[] newArray(int i2) {
        return new byte[i2];
    }
}
