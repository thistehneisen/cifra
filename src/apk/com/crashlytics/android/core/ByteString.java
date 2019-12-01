package com.crashlytics.android.core;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.List;

final class ByteString {
    public static final ByteString EMPTY = new ByteString(new byte[0]);
    private final byte[] bytes;
    private volatile int hash;

    static final class CodedBuilder {
        private final byte[] buffer;
        private final CodedOutputStream output;

        public ByteString build() {
            this.output.checkNoSpaceLeft();
            return new ByteString(this.buffer);
        }

        public CodedOutputStream getCodedOutput() {
            return this.output;
        }

        private CodedBuilder(int i2) {
            this.buffer = new byte[i2];
            this.output = CodedOutputStream.newInstance(this.buffer);
        }
    }

    static final class Output extends FilterOutputStream {
        private final ByteArrayOutputStream bout;

        public ByteString toByteString() {
            return new ByteString(this.bout.toByteArray());
        }

        private Output(ByteArrayOutputStream byteArrayOutputStream) {
            super(byteArrayOutputStream);
            this.bout = byteArrayOutputStream;
        }
    }

    public static ByteString copyFrom(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        return new ByteString(bArr2);
    }

    public static ByteString copyFromUtf8(String str) {
        try {
            return new ByteString(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("UTF-8 not supported.", e2);
        }
    }

    static CodedBuilder newCodedBuilder(int i2) {
        return new CodedBuilder(i2);
    }

    public static Output newOutput(int i2) {
        return new Output(new ByteArrayOutputStream(i2));
    }

    public ByteBuffer asReadOnlyByteBuffer() {
        return ByteBuffer.wrap(this.bytes).asReadOnlyBuffer();
    }

    public byte byteAt(int i2) {
        return this.bytes[i2];
    }

    public void copyTo(byte[] bArr, int i2) {
        byte[] bArr2 = this.bytes;
        System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        byte[] bArr = this.bytes;
        int length = bArr.length;
        byte[] bArr2 = byteString.bytes;
        if (length != bArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i2 = this.hash;
        if (i2 == 0) {
            int i3 = r1;
            for (byte b2 : this.bytes) {
                i3 = (i3 * 31) + b2;
            }
            i2 = i3 == 0 ? 1 : i3;
            this.hash = i2;
        }
        return i2;
    }

    public boolean isEmpty() {
        return this.bytes.length == 0;
    }

    public InputStream newInput() {
        return new ByteArrayInputStream(this.bytes);
    }

    public int size() {
        return this.bytes.length;
    }

    public byte[] toByteArray() {
        byte[] bArr = this.bytes;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public String toString(String str) throws UnsupportedEncodingException {
        return new String(this.bytes, str);
    }

    public String toStringUtf8() {
        try {
            return new String(this.bytes, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("UTF-8 not supported?", e2);
        }
    }

    private ByteString(byte[] bArr) {
        this.hash = 0;
        this.bytes = bArr;
    }

    public static Output newOutput() {
        return newOutput(32);
    }

    public void copyTo(byte[] bArr, int i2, int i3, int i4) {
        System.arraycopy(this.bytes, i2, bArr, i3, i4);
    }

    public void copyTo(ByteBuffer byteBuffer) {
        byte[] bArr = this.bytes;
        byteBuffer.put(bArr, 0, bArr.length);
    }

    public static ByteString copyFrom(byte[] bArr) {
        return copyFrom(bArr, 0, bArr.length);
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer, int i2) {
        byte[] bArr = new byte[i2];
        byteBuffer.get(bArr);
        return new ByteString(bArr);
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer) {
        return copyFrom(byteBuffer, byteBuffer.remaining());
    }

    public static ByteString copyFrom(String str, String str2) throws UnsupportedEncodingException {
        return new ByteString(str.getBytes(str2));
    }

    public static ByteString copyFrom(List<ByteString> list) {
        if (list.size() == 0) {
            return EMPTY;
        }
        if (list.size() == 1) {
            return (ByteString) list.get(0);
        }
        int i2 = 0;
        for (ByteString size : list) {
            i2 += size.size();
        }
        byte[] bArr = new byte[i2];
        int i3 = 0;
        for (ByteString byteString : list) {
            System.arraycopy(byteString.bytes, 0, bArr, i3, byteString.size());
            i3 += byteString.size();
        }
        return new ByteString(bArr);
    }
}
