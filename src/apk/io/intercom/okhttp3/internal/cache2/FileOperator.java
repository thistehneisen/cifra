package io.intercom.okhttp3.internal.cache2;

import e.a.b.g;
import java.io.IOException;
import java.nio.channels.FileChannel;

final class FileOperator {
    private final FileChannel fileChannel;

    FileOperator(FileChannel fileChannel2) {
        this.fileChannel = fileChannel2;
    }

    public void read(long j2, g gVar, long j3) throws IOException {
        if (j3 >= 0) {
            while (j3 > 0) {
                long transferTo = this.fileChannel.transferTo(j2, j3, gVar);
                j2 += transferTo;
                j3 -= transferTo;
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    public void write(long j2, g gVar, long j3) throws IOException {
        if (j3 < 0 || j3 > gVar.size()) {
            throw new IndexOutOfBoundsException();
        }
        long j4 = j2;
        long j5 = j3;
        while (j5 > 0) {
            long transferFrom = this.fileChannel.transferFrom(gVar, j4, j5);
            j4 += transferFrom;
            j5 -= transferFrom;
        }
    }
}
