package b.m;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

/* compiled from: ZipUtil */
final class d {

    /* compiled from: ZipUtil */
    static class a {

        /* renamed from: a reason: collision with root package name */
        long f2800a;

        /* renamed from: b reason: collision with root package name */
        long f2801b;

        a() {
        }
    }

    static long a(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            return a(randomAccessFile, a(randomAccessFile));
        } finally {
            randomAccessFile.close();
        }
    }

    static a a(RandomAccessFile randomAccessFile) throws IOException, ZipException {
        long length = randomAccessFile.length() - 22;
        long j2 = 0;
        if (length >= 0) {
            long j3 = length - 65536;
            if (j3 >= 0) {
                j2 = j3;
            }
            int reverseBytes = Integer.reverseBytes(101010256);
            do {
                randomAccessFile.seek(length);
                if (randomAccessFile.readInt() == reverseBytes) {
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    a aVar = new a();
                    aVar.f2801b = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                    aVar.f2800a = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                    return aVar;
                }
                length--;
            } while (length >= j2);
            throw new ZipException("End Of Central Directory signature not found");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("File too short to be a zip file: ");
        sb.append(randomAccessFile.length());
        throw new ZipException(sb.toString());
    }

    static long a(RandomAccessFile randomAccessFile, a aVar) throws IOException {
        CRC32 crc32 = new CRC32();
        long j2 = aVar.f2801b;
        randomAccessFile.seek(aVar.f2800a);
        byte[] bArr = new byte[16384];
        int read = randomAccessFile.read(bArr, 0, (int) Math.min(16384, j2));
        while (read != -1) {
            crc32.update(bArr, 0, read);
            j2 -= (long) read;
            if (j2 == 0) {
                break;
            }
            read = randomAccessFile.read(bArr, 0, (int) Math.min(16384, j2));
        }
        return crc32.getValue();
    }
}
