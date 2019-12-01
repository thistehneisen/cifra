package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;

/* renamed from: com.google.android.gms.internal.measurement.bd reason: case insensitive filesystem */
abstract class C0333bd {
    C0333bd() {
    }

    static void b(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i2;
        int length = charSequence.length();
        int position = byteBuffer.position();
        int i3 = 0;
        while (i3 < length) {
            try {
                char charAt = charSequence.charAt(i3);
                if (charAt >= 128) {
                    break;
                }
                byteBuffer.put(position + i3, (byte) charAt);
                i3++;
            } catch (IndexOutOfBoundsException unused) {
                int position2 = byteBuffer.position() + Math.max(i3, (position - byteBuffer.position()) + 1);
                char charAt2 = charSequence.charAt(i3);
                StringBuilder sb = new StringBuilder(37);
                sb.append("Failed writing ");
                sb.append(charAt2);
                sb.append(" at index ");
                sb.append(position2);
                throw new ArrayIndexOutOfBoundsException(sb.toString());
            }
        }
        if (i3 == length) {
            byteBuffer.position(position + i3);
            return;
        }
        position += i3;
        while (i3 < length) {
            char charAt3 = charSequence.charAt(i3);
            if (charAt3 < 128) {
                byteBuffer.put(position, (byte) charAt3);
            } else if (charAt3 < 2048) {
                i2 = position + 1;
                try {
                    byteBuffer.put(position, (byte) ((charAt3 >>> 6) | 192));
                    byteBuffer.put(i2, (byte) ((charAt3 & '?') | 128));
                    position = i2;
                } catch (IndexOutOfBoundsException unused2) {
                    position = i2;
                    int position22 = byteBuffer.position() + Math.max(i3, (position - byteBuffer.position()) + 1);
                    char charAt22 = charSequence.charAt(i3);
                    StringBuilder sb2 = new StringBuilder(37);
                    sb2.append("Failed writing ");
                    sb2.append(charAt22);
                    sb2.append(" at index ");
                    sb2.append(position22);
                    throw new ArrayIndexOutOfBoundsException(sb2.toString());
                }
            } else if (charAt3 < 55296 || 57343 < charAt3) {
                i2 = position + 1;
                byteBuffer.put(position, (byte) ((charAt3 >>> 12) | 224));
                position = i2 + 1;
                byteBuffer.put(i2, (byte) (((charAt3 >>> 6) & 63) | 128));
                byteBuffer.put(position, (byte) ((charAt3 & '?') | 128));
            } else {
                int i4 = i3 + 1;
                if (i4 != length) {
                    try {
                        char charAt4 = charSequence.charAt(i4);
                        if (Character.isSurrogatePair(charAt3, charAt4)) {
                            int codePoint = Character.toCodePoint(charAt3, charAt4);
                            int i5 = position + 1;
                            try {
                                byteBuffer.put(position, (byte) ((codePoint >>> 18) | 240));
                                position = i5 + 1;
                                byteBuffer.put(i5, (byte) (((codePoint >>> 12) & 63) | 128));
                                i5 = position + 1;
                                byteBuffer.put(position, (byte) (((codePoint >>> 6) & 63) | 128));
                                byteBuffer.put(i5, (byte) ((codePoint & 63) | 128));
                                position = i5;
                                i3 = i4;
                            } catch (IndexOutOfBoundsException unused3) {
                                position = i5;
                                i3 = i4;
                                int position222 = byteBuffer.position() + Math.max(i3, (position - byteBuffer.position()) + 1);
                                char charAt222 = charSequence.charAt(i3);
                                StringBuilder sb22 = new StringBuilder(37);
                                sb22.append("Failed writing ");
                                sb22.append(charAt222);
                                sb22.append(" at index ");
                                sb22.append(position222);
                                throw new ArrayIndexOutOfBoundsException(sb22.toString());
                            }
                        } else {
                            i3 = i4;
                        }
                    } catch (IndexOutOfBoundsException unused4) {
                        i3 = i4;
                        int position2222 = byteBuffer.position() + Math.max(i3, (position - byteBuffer.position()) + 1);
                        char charAt2222 = charSequence.charAt(i3);
                        StringBuilder sb222 = new StringBuilder(37);
                        sb222.append("Failed writing ");
                        sb222.append(charAt2222);
                        sb222.append(" at index ");
                        sb222.append(position2222);
                        throw new ArrayIndexOutOfBoundsException(sb222.toString());
                    }
                }
                throw new C0353ed(i3, length);
            }
            i3++;
            position++;
        }
        byteBuffer.position(position);
    }

    /* access modifiers changed from: 0000 */
    public abstract int a(int i2, byte[] bArr, int i3, int i4);

    /* access modifiers changed from: 0000 */
    public abstract int a(CharSequence charSequence, byte[] bArr, int i2, int i3);

    /* access modifiers changed from: 0000 */
    public abstract void a(CharSequence charSequence, ByteBuffer byteBuffer);

    /* access modifiers changed from: 0000 */
    public final boolean a(byte[] bArr, int i2, int i3) {
        return a(0, bArr, i2, i3) == 0;
    }

    /* access modifiers changed from: 0000 */
    public abstract String b(byte[] bArr, int i2, int i3) throws zzfi;
}
