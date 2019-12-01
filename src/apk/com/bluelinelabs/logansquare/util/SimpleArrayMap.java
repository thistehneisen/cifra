package com.bluelinelabs.logansquare.util;

import java.util.Map;

public class SimpleArrayMap<K, V> {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    static final int[] EMPTY_INTS = new int[0];
    static final Object[] EMPTY_OBJECTS = new Object[0];
    static Object[] mBaseCache;
    static int mBaseCacheSize;
    static Object[] mTwiceBaseCache;
    static int mTwiceBaseCacheSize;
    Object[] mArray;
    int[] mHashes;
    int mSize;

    public SimpleArrayMap() {
        this.mHashes = EMPTY_INTS;
        this.mArray = EMPTY_OBJECTS;
        this.mSize = 0;
    }

    private void allocArrays(int i2) {
        if (i2 == 8) {
            synchronized (SimpleArrayMap.class) {
                if (mTwiceBaseCache != null) {
                    Object[] objArr = mTwiceBaseCache;
                    this.mArray = objArr;
                    mTwiceBaseCache = (Object[]) objArr[0];
                    this.mHashes = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    mTwiceBaseCacheSize--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (SimpleArrayMap.class) {
                if (mBaseCache != null) {
                    Object[] objArr2 = mBaseCache;
                    this.mArray = objArr2;
                    mBaseCache = (Object[]) objArr2[0];
                    this.mHashes = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    mBaseCacheSize--;
                    return;
                }
            }
        }
        this.mHashes = new int[i2];
        this.mArray = new Object[(i2 << 1)];
    }

    static int binarySearch(int[] iArr, int i2, int i3) {
        int i4 = i2 - 1;
        int i5 = 0;
        while (i5 <= i4) {
            int i6 = (i5 + i4) >>> 1;
            int i7 = iArr[i6];
            if (i7 < i3) {
                i5 = i6 + 1;
            } else if (i7 <= i3) {
                return i6;
            } else {
                i4 = i6 - 1;
            }
        }
        return ~i5;
    }

    private static void freeArrays(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (SimpleArrayMap.class) {
                if (mTwiceBaseCacheSize < 10) {
                    objArr[0] = mTwiceBaseCache;
                    objArr[1] = iArr;
                    for (int i3 = (i2 << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    mTwiceBaseCache = objArr;
                    mTwiceBaseCacheSize++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (SimpleArrayMap.class) {
                if (mBaseCacheSize < 10) {
                    objArr[0] = mBaseCache;
                    objArr[1] = iArr;
                    for (int i4 = (i2 << 1) - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    mBaseCache = objArr;
                    mBaseCacheSize++;
                }
            }
        }
    }

    public void clear() {
        int i2 = this.mSize;
        if (i2 != 0) {
            freeArrays(this.mHashes, this.mArray, i2);
            this.mHashes = EMPTY_INTS;
            this.mArray = EMPTY_OBJECTS;
            this.mSize = 0;
        }
    }

    public boolean containsKey(Object obj) {
        return indexOfKey(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return indexOfValue(obj) >= 0;
    }

    public void ensureCapacity(int i2) {
        int[] iArr = this.mHashes;
        if (iArr.length < i2) {
            Object[] objArr = this.mArray;
            allocArrays(i2);
            int i3 = this.mSize;
            if (i3 > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, i3);
                System.arraycopy(objArr, 0, this.mArray, 0, this.mSize << 1);
            }
            freeArrays(iArr, objArr, this.mSize);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            int i2 = 0;
            while (i2 < this.mSize) {
                try {
                    Object keyAt = keyAt(i2);
                    Object valueAt = valueAt(i2);
                    Object obj2 = map.get(keyAt);
                    if (valueAt == null) {
                        if (obj2 != null || !map.containsKey(keyAt)) {
                            return false;
                        }
                    } else if (!valueAt.equals(obj2)) {
                        return false;
                    }
                    i2++;
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public V get(Object obj) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return this.mArray[(indexOfKey << 1) + 1];
        }
        return null;
    }

    public int hashCode() {
        int[] iArr = this.mHashes;
        Object[] objArr = this.mArray;
        int i2 = this.mSize;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        while (i3 < i2) {
            Object obj = objArr[i5];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i5 += 2;
        }
        return i4;
    }

    /* access modifiers changed from: 0000 */
    public int indexOf(Object obj, int i2) {
        int i3 = this.mSize;
        if (i3 == 0) {
            return -1;
        }
        int binarySearch = binarySearch(this.mHashes, i3, i2);
        if (binarySearch < 0 || obj.equals(this.mArray[binarySearch << 1])) {
            return binarySearch;
        }
        int i4 = binarySearch + 1;
        while (i4 < i3 && this.mHashes[i4] == i2) {
            if (obj.equals(this.mArray[i4 << 1])) {
                return i4;
            }
            i4++;
        }
        int i5 = binarySearch - 1;
        while (i5 >= 0 && this.mHashes[i5] == i2) {
            if (obj.equals(this.mArray[i5 << 1])) {
                return i5;
            }
            i5--;
        }
        return ~i4;
    }

    public int indexOfKey(Object obj) {
        return obj == null ? indexOfNull() : indexOf(obj, obj.hashCode());
    }

    /* access modifiers changed from: 0000 */
    public int indexOfNull() {
        int i2 = this.mSize;
        if (i2 == 0) {
            return -1;
        }
        int binarySearch = binarySearch(this.mHashes, i2, 0);
        if (binarySearch < 0 || this.mArray[binarySearch << 1] == null) {
            return binarySearch;
        }
        int i3 = binarySearch + 1;
        while (i3 < i2 && this.mHashes[i3] == 0) {
            if (this.mArray[i3 << 1] == null) {
                return i3;
            }
            i3++;
        }
        int i4 = binarySearch - 1;
        while (i4 >= 0 && this.mHashes[i4] == 0) {
            if (this.mArray[i4 << 1] == null) {
                return i4;
            }
            i4--;
        }
        return ~i3;
    }

    /* access modifiers changed from: 0000 */
    public int indexOfValue(Object obj) {
        int i2 = this.mSize * 2;
        Object[] objArr = this.mArray;
        if (obj == null) {
            for (int i3 = 1; i3 < i2; i3 += 2) {
                if (objArr[i3] == null) {
                    return i3 >> 1;
                }
            }
        } else {
            for (int i4 = 1; i4 < i2; i4 += 2) {
                if (obj.equals(objArr[i4])) {
                    return i4 >> 1;
                }
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.mSize <= 0;
    }

    public K keyAt(int i2) {
        return this.mArray[i2 << 1];
    }

    public V put(K k2, V v) {
        int i2;
        int i3;
        if (k2 == null) {
            i3 = indexOfNull();
            i2 = 0;
        } else {
            int hashCode = k2.hashCode();
            i2 = hashCode;
            i3 = indexOf(k2, hashCode);
        }
        if (i3 >= 0) {
            int i4 = (i3 << 1) + 1;
            V[] vArr = this.mArray;
            V v2 = vArr[i4];
            vArr[i4] = v;
            return v2;
        }
        int i5 = ~i3;
        int i6 = this.mSize;
        if (i6 >= this.mHashes.length) {
            int i7 = 4;
            if (i6 >= 8) {
                i7 = (i6 >> 1) + i6;
            } else if (i6 >= 4) {
                i7 = 8;
            }
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            allocArrays(i7);
            int[] iArr2 = this.mHashes;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.mArray, 0, objArr.length);
            }
            freeArrays(iArr, objArr, this.mSize);
        }
        int i8 = this.mSize;
        if (i5 < i8) {
            int[] iArr3 = this.mHashes;
            int i9 = i5 + 1;
            System.arraycopy(iArr3, i5, iArr3, i9, i8 - i5);
            Object[] objArr2 = this.mArray;
            System.arraycopy(objArr2, i5 << 1, objArr2, i9 << 1, (this.mSize - i5) << 1);
        }
        this.mHashes[i5] = i2;
        Object[] objArr3 = this.mArray;
        int i10 = i5 << 1;
        objArr3[i10] = k2;
        objArr3[i10 + 1] = v;
        this.mSize++;
        return null;
    }

    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        int i2 = simpleArrayMap.mSize;
        ensureCapacity(this.mSize + i2);
        if (this.mSize != 0) {
            for (int i3 = 0; i3 < i2; i3++) {
                put(simpleArrayMap.keyAt(i3), simpleArrayMap.valueAt(i3));
            }
        } else if (i2 > 0) {
            System.arraycopy(simpleArrayMap.mHashes, 0, this.mHashes, 0, i2);
            System.arraycopy(simpleArrayMap.mArray, 0, this.mArray, 0, i2 << 1);
            this.mSize = i2;
        }
    }

    public V remove(Object obj) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return removeAt(indexOfKey);
        }
        return null;
    }

    public V removeAt(int i2) {
        V[] vArr = this.mArray;
        int i3 = i2 << 1;
        V v = vArr[i3 + 1];
        int i4 = this.mSize;
        if (i4 <= 1) {
            freeArrays(this.mHashes, vArr, i4);
            this.mHashes = EMPTY_INTS;
            this.mArray = EMPTY_OBJECTS;
            this.mSize = 0;
        } else {
            int[] iArr = this.mHashes;
            int i5 = 8;
            if (iArr.length <= 8 || i4 >= iArr.length / 3) {
                this.mSize--;
                int i6 = this.mSize;
                if (i2 < i6) {
                    int[] iArr2 = this.mHashes;
                    int i7 = i2 + 1;
                    System.arraycopy(iArr2, i7, iArr2, i2, i6 - i2);
                    Object[] objArr = this.mArray;
                    System.arraycopy(objArr, i7 << 1, objArr, i3, (this.mSize - i2) << 1);
                }
                Object[] objArr2 = this.mArray;
                int i8 = this.mSize;
                objArr2[i8 << 1] = null;
                objArr2[(i8 << 1) + 1] = null;
            } else {
                if (i4 > 8) {
                    i5 = i4 + (i4 >> 1);
                }
                int[] iArr3 = this.mHashes;
                Object[] objArr3 = this.mArray;
                allocArrays(i5);
                this.mSize--;
                if (i2 > 0) {
                    System.arraycopy(iArr3, 0, this.mHashes, 0, i2);
                    System.arraycopy(objArr3, 0, this.mArray, 0, i3);
                }
                int i9 = this.mSize;
                if (i2 < i9) {
                    int i10 = i2 + 1;
                    System.arraycopy(iArr3, i10, this.mHashes, i2, i9 - i2);
                    System.arraycopy(objArr3, i10 << 1, this.mArray, i3, (this.mSize - i2) << 1);
                }
            }
        }
        return v;
    }

    public V setValueAt(int i2, V v) {
        int i3 = (i2 << 1) + 1;
        V[] vArr = this.mArray;
        V v2 = vArr[i3];
        vArr[i3] = v;
        return v2;
    }

    public int size() {
        return this.mSize;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.mSize * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.mSize; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object keyAt = keyAt(i2);
            String str = "(this Map)";
            if (keyAt != this) {
                sb.append(keyAt);
            } else {
                sb.append(str);
            }
            sb.append('=');
            Object valueAt = valueAt(i2);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append(str);
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public V valueAt(int i2) {
        return this.mArray[(i2 << 1) + 1];
    }

    public SimpleArrayMap(int i2) {
        if (i2 == 0) {
            this.mHashes = EMPTY_INTS;
            this.mArray = EMPTY_OBJECTS;
        } else {
            allocArrays(i2);
        }
        this.mSize = 0;
    }

    public SimpleArrayMap(SimpleArrayMap simpleArrayMap) {
        this();
        if (simpleArrayMap != null) {
            putAll(simpleArrayMap);
        }
    }
}
