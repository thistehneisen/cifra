package com.crashlytics.android.core;

import android.os.Process;
import io.fabric.sdk.android.a.b.l;
import io.fabric.sdk.android.a.b.y;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

class CLSUUID {
    private static String _clsId;
    private static final AtomicLong _sequenceNumber = new AtomicLong(0);

    public CLSUUID(y yVar) {
        byte[] bArr = new byte[10];
        populateTime(bArr);
        populateSequenceNumber(bArr);
        populatePID(bArr);
        String c2 = l.c(yVar.d());
        String a2 = l.a(bArr);
        _clsId = String.format(Locale.US, "%s-%s-%s-%s", new Object[]{a2.substring(0, 12), a2.substring(12, 16), a2.subSequence(16, 20), c2.substring(0, 12)}).toUpperCase(Locale.US);
    }

    private static byte[] convertLongToFourByteBuffer(long j2) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt((int) j2);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    private static byte[] convertLongToTwoByteBuffer(long j2) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort((short) ((int) j2));
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    private void populatePID(byte[] bArr) {
        byte[] convertLongToTwoByteBuffer = convertLongToTwoByteBuffer((long) Integer.valueOf(Process.myPid()).shortValue());
        bArr[8] = convertLongToTwoByteBuffer[0];
        bArr[9] = convertLongToTwoByteBuffer[1];
    }

    private void populateSequenceNumber(byte[] bArr) {
        byte[] convertLongToTwoByteBuffer = convertLongToTwoByteBuffer(_sequenceNumber.incrementAndGet());
        bArr[6] = convertLongToTwoByteBuffer[0];
        bArr[7] = convertLongToTwoByteBuffer[1];
    }

    private void populateTime(byte[] bArr) {
        long time = new Date().getTime();
        long j2 = time / 1000;
        long j3 = time % 1000;
        byte[] convertLongToFourByteBuffer = convertLongToFourByteBuffer(j2);
        bArr[0] = convertLongToFourByteBuffer[0];
        bArr[1] = convertLongToFourByteBuffer[1];
        bArr[2] = convertLongToFourByteBuffer[2];
        bArr[3] = convertLongToFourByteBuffer[3];
        byte[] convertLongToTwoByteBuffer = convertLongToTwoByteBuffer(j3);
        bArr[4] = convertLongToTwoByteBuffer[0];
        bArr[5] = convertLongToTwoByteBuffer[1];
    }

    public String toString() {
        return _clsId;
    }
}
