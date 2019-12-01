package io.intercom.okhttp3.internal.http2;

import com.appsflyer.share.Constants;
import e.a.b.B;
import e.a.b.g;
import e.a.b.i;
import e.a.b.j;
import e.a.b.t;
import io.intercom.android.sdk.views.holder.AttributeType;
import io.intercom.okhttp3.internal.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class Hpack {
    static final Map<j, Integer> NAME_TO_FIRST_INDEX = nameToFirstIndex();
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    static final Header[] STATIC_HEADER_TABLE;

    static final class Reader {
        Header[] dynamicTable;
        int dynamicTableByteCount;
        int headerCount;
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        int nextHeaderIndex;
        private final i source;

        Reader(int i2, B b2) {
            this(i2, i2, b2);
        }

        private void adjustDynamicTableByteCount() {
            int i2 = this.maxDynamicTableByteCount;
            int i3 = this.dynamicTableByteCount;
            if (i2 >= i3) {
                return;
            }
            if (i2 == 0) {
                clearDynamicTable();
            } else {
                evictToRecoverBytes(i3 - i2);
            }
        }

        private void clearDynamicTable() {
            Arrays.fill(this.dynamicTable, null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private int dynamicTableIndex(int i2) {
            return this.nextHeaderIndex + 1 + i2;
        }

        private int evictToRecoverBytes(int i2) {
            int i3 = 0;
            if (i2 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    if (length < this.nextHeaderIndex || i2 <= 0) {
                        Header[] headerArr = this.dynamicTable;
                        int i4 = this.nextHeaderIndex;
                        System.arraycopy(headerArr, i4 + 1, headerArr, i4 + 1 + i3, this.headerCount);
                        this.nextHeaderIndex += i3;
                    } else {
                        Header[] headerArr2 = this.dynamicTable;
                        i2 -= headerArr2[length].hpackSize;
                        this.dynamicTableByteCount -= headerArr2[length].hpackSize;
                        this.headerCount--;
                        i3++;
                    }
                }
                Header[] headerArr3 = this.dynamicTable;
                int i42 = this.nextHeaderIndex;
                System.arraycopy(headerArr3, i42 + 1, headerArr3, i42 + 1 + i3, this.headerCount);
                this.nextHeaderIndex += i3;
            }
            return i3;
        }

        private j getName(int i2) throws IOException {
            if (isStaticHeader(i2)) {
                return Hpack.STATIC_HEADER_TABLE[i2].name;
            }
            int dynamicTableIndex = dynamicTableIndex(i2 - Hpack.STATIC_HEADER_TABLE.length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex < headerArr.length) {
                    return headerArr[dynamicTableIndex].name;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Header index too large ");
            sb.append(i2 + 1);
            throw new IOException(sb.toString());
        }

        private void insertIntoDynamicTable(int i2, Header header) {
            this.headerList.add(header);
            int i3 = header.hpackSize;
            if (i2 != -1) {
                i3 -= this.dynamicTable[dynamicTableIndex(i2)].hpackSize;
            }
            int i4 = this.maxDynamicTableByteCount;
            if (i3 > i4) {
                clearDynamicTable();
                return;
            }
            int evictToRecoverBytes = evictToRecoverBytes((this.dynamicTableByteCount + i3) - i4);
            if (i2 == -1) {
                int i5 = this.headerCount + 1;
                Header[] headerArr = this.dynamicTable;
                if (i5 > headerArr.length) {
                    Header[] headerArr2 = new Header[(headerArr.length * 2)];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = headerArr2;
                }
                int i6 = this.nextHeaderIndex;
                this.nextHeaderIndex = i6 - 1;
                this.dynamicTable[i6] = header;
                this.headerCount++;
            } else {
                this.dynamicTable[i2 + dynamicTableIndex(i2) + evictToRecoverBytes] = header;
            }
            this.dynamicTableByteCount += i3;
        }

        private boolean isStaticHeader(int i2) {
            return i2 >= 0 && i2 <= Hpack.STATIC_HEADER_TABLE.length - 1;
        }

        private int readByte() throws IOException {
            return this.source.readByte() & 255;
        }

        private void readIndexedHeader(int i2) throws IOException {
            if (isStaticHeader(i2)) {
                this.headerList.add(Hpack.STATIC_HEADER_TABLE[i2]);
                return;
            }
            int dynamicTableIndex = dynamicTableIndex(i2 - Hpack.STATIC_HEADER_TABLE.length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex < headerArr.length) {
                    this.headerList.add(headerArr[dynamicTableIndex]);
                    return;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Header index too large ");
            sb.append(i2 + 1);
            throw new IOException(sb.toString());
        }

        private void readLiteralHeaderWithIncrementalIndexingIndexedName(int i2) throws IOException {
            insertIntoDynamicTable(-1, new Header(getName(i2), readByteString()));
        }

        private void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            j readByteString = readByteString();
            Hpack.checkLowercase(readByteString);
            insertIntoDynamicTable(-1, new Header(readByteString, readByteString()));
        }

        private void readLiteralHeaderWithoutIndexingIndexedName(int i2) throws IOException {
            this.headerList.add(new Header(getName(i2), readByteString()));
        }

        private void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            j readByteString = readByteString();
            Hpack.checkLowercase(readByteString);
            this.headerList.add(new Header(readByteString, readByteString()));
        }

        public List<Header> getAndResetHeaderList() {
            ArrayList arrayList = new ArrayList(this.headerList);
            this.headerList.clear();
            return arrayList;
        }

        /* access modifiers changed from: 0000 */
        public int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        /* access modifiers changed from: 0000 */
        public j readByteString() throws IOException {
            int readByte = readByte();
            boolean z = (readByte & 128) == 128;
            int readInt = readInt(readByte, Hpack.PREFIX_7_BITS);
            if (z) {
                return j.a(Huffman.get().decode(this.source.d((long) readInt)));
            }
            return this.source.b((long) readInt);
        }

        /* access modifiers changed from: 0000 */
        public void readHeaders() throws IOException {
            while (!this.source.o()) {
                byte readByte = this.source.readByte() & 255;
                if (readByte == 128) {
                    throw new IOException("index == 0");
                } else if ((readByte & 128) == 128) {
                    readIndexedHeader(readInt(readByte, Hpack.PREFIX_7_BITS) - 1);
                } else if (readByte == 64) {
                    readLiteralHeaderWithIncrementalIndexingNewName();
                } else if ((readByte & 64) == 64) {
                    readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(readByte, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    this.maxDynamicTableByteCount = readInt(readByte, 31);
                    int i2 = this.maxDynamicTableByteCount;
                    if (i2 < 0 || i2 > this.headerTableSizeSetting) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Invalid dynamic table size update ");
                        sb.append(this.maxDynamicTableByteCount);
                        throw new IOException(sb.toString());
                    }
                    adjustDynamicTableByteCount();
                } else if (readByte == 16 || readByte == 0) {
                    readLiteralHeaderWithoutIndexingNewName();
                } else {
                    readLiteralHeaderWithoutIndexingIndexedName(readInt(readByte, 15) - 1);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public int readInt(int i2, int i3) throws IOException {
            int i4 = i2 & i3;
            if (i4 < i3) {
                return i4;
            }
            int i5 = 0;
            while (true) {
                int readByte = readByte();
                if ((readByte & 128) == 0) {
                    return i3 + (readByte << i5);
                }
                i3 += (readByte & Hpack.PREFIX_7_BITS) << i5;
                i5 += 7;
            }
        }

        Reader(int i2, int i3, B b2) {
            this.headerList = new ArrayList();
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
            this.headerTableSizeSetting = i2;
            this.maxDynamicTableByteCount = i3;
            this.source = t.a(b2);
        }
    }

    static final class Writer {
        private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
        private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
        Header[] dynamicTable;
        int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;
        int headerCount;
        int headerTableSizeSetting;
        int maxDynamicTableByteCount;
        int nextHeaderIndex;
        private final g out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        Writer(g gVar) {
            this(4096, true, gVar);
        }

        private void adjustDynamicTableByteCount() {
            int i2 = this.maxDynamicTableByteCount;
            int i3 = this.dynamicTableByteCount;
            if (i2 >= i3) {
                return;
            }
            if (i2 == 0) {
                clearDynamicTable();
            } else {
                evictToRecoverBytes(i3 - i2);
            }
        }

        private void clearDynamicTable() {
            Arrays.fill(this.dynamicTable, null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private int evictToRecoverBytes(int i2) {
            int i3 = 0;
            if (i2 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    if (length < this.nextHeaderIndex || i2 <= 0) {
                        Header[] headerArr = this.dynamicTable;
                        int i4 = this.nextHeaderIndex;
                        System.arraycopy(headerArr, i4 + 1, headerArr, i4 + 1 + i3, this.headerCount);
                        Header[] headerArr2 = this.dynamicTable;
                        int i5 = this.nextHeaderIndex;
                        Arrays.fill(headerArr2, i5 + 1, i5 + 1 + i3, null);
                        this.nextHeaderIndex += i3;
                    } else {
                        Header[] headerArr3 = this.dynamicTable;
                        i2 -= headerArr3[length].hpackSize;
                        this.dynamicTableByteCount -= headerArr3[length].hpackSize;
                        this.headerCount--;
                        i3++;
                    }
                }
                Header[] headerArr4 = this.dynamicTable;
                int i42 = this.nextHeaderIndex;
                System.arraycopy(headerArr4, i42 + 1, headerArr4, i42 + 1 + i3, this.headerCount);
                Header[] headerArr22 = this.dynamicTable;
                int i52 = this.nextHeaderIndex;
                Arrays.fill(headerArr22, i52 + 1, i52 + 1 + i3, null);
                this.nextHeaderIndex += i3;
            }
            return i3;
        }

        private void insertIntoDynamicTable(Header header) {
            int i2 = header.hpackSize;
            int i3 = this.maxDynamicTableByteCount;
            if (i2 > i3) {
                clearDynamicTable();
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + i2) - i3);
            int i4 = this.headerCount + 1;
            Header[] headerArr = this.dynamicTable;
            if (i4 > headerArr.length) {
                Header[] headerArr2 = new Header[(headerArr.length * 2)];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr2;
            }
            int i5 = this.nextHeaderIndex;
            this.nextHeaderIndex = i5 - 1;
            this.dynamicTable[i5] = header;
            this.headerCount++;
            this.dynamicTableByteCount += i2;
        }

        /* access modifiers changed from: 0000 */
        public void setHeaderTableSizeSetting(int i2) {
            this.headerTableSizeSetting = i2;
            int min = Math.min(i2, SETTINGS_HEADER_TABLE_SIZE_LIMIT);
            int i3 = this.maxDynamicTableByteCount;
            if (i3 != min) {
                if (min < i3) {
                    this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, min);
                }
                this.emitDynamicTableSizeUpdate = true;
                this.maxDynamicTableByteCount = min;
                adjustDynamicTableByteCount();
            }
        }

        /* access modifiers changed from: 0000 */
        public void writeByteString(j jVar) throws IOException {
            if (!this.useCompression || Huffman.get().encodedLength(jVar) >= jVar.size()) {
                writeInt(jVar.size(), Hpack.PREFIX_7_BITS, 0);
                this.out.a(jVar);
                return;
            }
            g gVar = new g();
            Huffman.get().encode(jVar, gVar);
            j d2 = gVar.d();
            writeInt(d2.size(), Hpack.PREFIX_7_BITS, 128);
            this.out.a(d2);
        }

        /* access modifiers changed from: 0000 */
        public void writeHeaders(List<Header> list) throws IOException {
            int i2;
            int i3;
            if (this.emitDynamicTableSizeUpdate) {
                int i4 = this.smallestHeaderTableSizeSetting;
                if (i4 < this.maxDynamicTableByteCount) {
                    writeInt(i4, 31, 32);
                }
                this.emitDynamicTableSizeUpdate = false;
                this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
                writeInt(this.maxDynamicTableByteCount, 31, 32);
            }
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                Header header = (Header) list.get(i5);
                j f2 = header.name.f();
                j jVar = header.value;
                Integer num = (Integer) Hpack.NAME_TO_FIRST_INDEX.get(f2);
                if (num != null) {
                    i3 = num.intValue() + 1;
                    if (i3 > 1 && i3 < 8) {
                        if (Util.equal(Hpack.STATIC_HEADER_TABLE[i3 - 1].value, jVar)) {
                            i2 = i3;
                        } else if (Util.equal(Hpack.STATIC_HEADER_TABLE[i3].value, jVar)) {
                            i2 = i3;
                            i3++;
                        }
                    }
                    i2 = i3;
                    i3 = -1;
                } else {
                    i3 = -1;
                    i2 = -1;
                }
                if (i3 == -1) {
                    int i6 = this.nextHeaderIndex + 1;
                    int length = this.dynamicTable.length;
                    while (true) {
                        if (i6 >= length) {
                            break;
                        }
                        if (Util.equal(this.dynamicTable[i6].name, f2)) {
                            if (Util.equal(this.dynamicTable[i6].value, jVar)) {
                                i3 = Hpack.STATIC_HEADER_TABLE.length + (i6 - this.nextHeaderIndex);
                                break;
                            } else if (i2 == -1) {
                                i2 = (i6 - this.nextHeaderIndex) + Hpack.STATIC_HEADER_TABLE.length;
                            }
                        }
                        i6++;
                    }
                }
                if (i3 != -1) {
                    writeInt(i3, Hpack.PREFIX_7_BITS, 128);
                } else if (i2 == -1) {
                    this.out.writeByte(64);
                    writeByteString(f2);
                    writeByteString(jVar);
                    insertIntoDynamicTable(header);
                } else if (!f2.b(Header.PSEUDO_PREFIX) || Header.TARGET_AUTHORITY.equals(f2)) {
                    writeInt(i2, 63, 64);
                    writeByteString(jVar);
                    insertIntoDynamicTable(header);
                } else {
                    writeInt(i2, 15, 0);
                    writeByteString(jVar);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void writeInt(int i2, int i3, int i4) {
            if (i2 < i3) {
                this.out.writeByte(i2 | i4);
                return;
            }
            this.out.writeByte(i4 | i3);
            int i5 = i2 - i3;
            while (i5 >= 128) {
                this.out.writeByte(128 | (i5 & Hpack.PREFIX_7_BITS));
                i5 >>>= 7;
            }
            this.out.writeByte(i5);
        }

        Writer(int i2, boolean z, g gVar) {
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
            this.headerTableSizeSetting = i2;
            this.maxDynamicTableByteCount = i2;
            this.useCompression = z;
            this.out = gVar;
        }
    }

    static {
        String str = "";
        STATIC_HEADER_TABLE = new Header[]{new Header(Header.TARGET_AUTHORITY, str), new Header(Header.TARGET_METHOD, "GET"), new Header(Header.TARGET_METHOD, "POST"), new Header(Header.TARGET_PATH, Constants.URL_PATH_DELIMITER), new Header(Header.TARGET_PATH, "/index.html"), new Header(Header.TARGET_SCHEME, "http"), new Header(Header.TARGET_SCHEME, "https"), new Header(Header.RESPONSE_STATUS, "200"), new Header(Header.RESPONSE_STATUS, "204"), new Header(Header.RESPONSE_STATUS, "206"), new Header(Header.RESPONSE_STATUS, "304"), new Header(Header.RESPONSE_STATUS, "400"), new Header(Header.RESPONSE_STATUS, "404"), new Header(Header.RESPONSE_STATUS, "500"), new Header("accept-charset", str), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", str), new Header("accept-ranges", str), new Header("accept", str), new Header("access-control-allow-origin", str), new Header("age", str), new Header("allow", str), new Header("authorization", str), new Header("cache-control", str), new Header("content-disposition", str), new Header("content-encoding", str), new Header("content-language", str), new Header("content-length", str), new Header("content-location", str), new Header("content-range", str), new Header("content-type", str), new Header("cookie", str), new Header(AttributeType.DATE, str), new Header("etag", str), new Header("expect", str), new Header("expires", str), new Header("from", str), new Header("host", str), new Header("if-match", str), new Header("if-modified-since", str), new Header("if-none-match", str), new Header("if-range", str), new Header("if-unmodified-since", str), new Header("last-modified", str), new Header("link", str), new Header("location", str), new Header("max-forwards", str), new Header("proxy-authenticate", str), new Header("proxy-authorization", str), new Header("range", str), new Header("referer", str), new Header("refresh", str), new Header("retry-after", str), new Header("server", str), new Header("set-cookie", str), new Header("strict-transport-security", str), new Header("transfer-encoding", str), new Header("user-agent", str), new Header("vary", str), new Header("via", str), new Header("www-authenticate", str)};
    }

    private Hpack() {
    }

    static j checkLowercase(j jVar) throws IOException {
        int size = jVar.size();
        int i2 = 0;
        while (i2 < size) {
            byte b2 = jVar.b(i2);
            if (b2 < 65 || b2 > 90) {
                i2++;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("PROTOCOL_ERROR response malformed: mixed case name: ");
                sb.append(jVar.h());
                throw new IOException(sb.toString());
            }
        }
        return jVar;
    }

    private static Map<j, Integer> nameToFirstIndex() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(STATIC_HEADER_TABLE.length);
        int i2 = 0;
        while (true) {
            Header[] headerArr = STATIC_HEADER_TABLE;
            if (i2 >= headerArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(headerArr[i2].name)) {
                linkedHashMap.put(STATIC_HEADER_TABLE[i2].name, Integer.valueOf(i2));
            }
            i2++;
        }
    }
}
