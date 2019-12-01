package io.intercom.okhttp3;

import io.intercom.okhttp3.internal.Util;
import io.intercom.okhttp3.internal.http.HttpDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public final class Headers {
    private final String[] namesAndValues;

    public static final class Builder {
        final List<String> namesAndValues = new ArrayList(20);

        private void checkNameAndValue(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (!str.isEmpty()) {
                int length = str.length();
                for (int i2 = 0; i2 < length; i2++) {
                    char charAt = str.charAt(i2);
                    if (charAt <= ' ' || charAt >= 127) {
                        throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i2), str));
                    }
                }
                if (str2 != null) {
                    int length2 = str2.length();
                    int i3 = 0;
                    while (i3 < length2) {
                        char charAt2 = str2.charAt(i3);
                        if ((charAt2 > 31 || charAt2 == 9) && charAt2 < 127) {
                            i3++;
                        } else {
                            throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt2), Integer.valueOf(i3), str, str2));
                        }
                    }
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("value for name ");
                sb.append(str);
                sb.append(" == null");
                throw new NullPointerException(sb.toString());
            } else {
                throw new IllegalArgumentException("name is empty");
            }
        }

        public Builder add(String str) {
            int indexOf = str.indexOf(":");
            if (indexOf != -1) {
                return add(str.substring(0, indexOf).trim(), str.substring(indexOf + 1));
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected header: ");
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        }

        public Builder addAll(Headers headers) {
            int size = headers.size();
            for (int i2 = 0; i2 < size; i2++) {
                addLenient(headers.name(i2), headers.value(i2));
            }
            return this;
        }

        /* access modifiers changed from: 0000 */
        public Builder addLenient(String str) {
            String str2 = ":";
            int indexOf = str.indexOf(str2, 1);
            if (indexOf != -1) {
                return addLenient(str.substring(0, indexOf), str.substring(indexOf + 1));
            }
            String str3 = "";
            if (str.startsWith(str2)) {
                return addLenient(str3, str.substring(1));
            }
            return addLenient(str3, str);
        }

        public Headers build() {
            return new Headers(this);
        }

        public String get(String str) {
            for (int size = this.namesAndValues.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase((String) this.namesAndValues.get(size))) {
                    return (String) this.namesAndValues.get(size + 1);
                }
            }
            return null;
        }

        public Builder removeAll(String str) {
            int i2 = 0;
            while (i2 < this.namesAndValues.size()) {
                if (str.equalsIgnoreCase((String) this.namesAndValues.get(i2))) {
                    this.namesAndValues.remove(i2);
                    this.namesAndValues.remove(i2);
                    i2 -= 2;
                }
                i2 += 2;
            }
            return this;
        }

        public Builder set(String str, String str2) {
            checkNameAndValue(str, str2);
            removeAll(str);
            addLenient(str, str2);
            return this;
        }

        public Builder add(String str, String str2) {
            checkNameAndValue(str, str2);
            return addLenient(str, str2);
        }

        /* access modifiers changed from: 0000 */
        public Builder addLenient(String str, String str2) {
            this.namesAndValues.add(str);
            this.namesAndValues.add(str2.trim());
            return this;
        }
    }

    Headers(Builder builder) {
        List<String> list = builder.namesAndValues;
        this.namesAndValues = (String[]) list.toArray(new String[list.size()]);
    }

    public static Headers of(String... strArr) {
        if (strArr == null) {
            throw new NullPointerException("namesAndValues == null");
        } else if (strArr.length % 2 == 0) {
            String[] strArr2 = (String[]) strArr.clone();
            int i2 = 0;
            while (i2 < strArr2.length) {
                if (strArr2[i2] != null) {
                    strArr2[i2] = strArr2[i2].trim();
                    i2++;
                } else {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
            }
            int i3 = 0;
            while (i3 < strArr2.length) {
                String str = strArr2[i3];
                String str2 = strArr2[i3 + 1];
                if (str.length() != 0 && str.indexOf(0) == -1 && str2.indexOf(0) == -1) {
                    i3 += 2;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unexpected header: ");
                    sb.append(str);
                    sb.append(": ");
                    sb.append(str2);
                    throw new IllegalArgumentException(sb.toString());
                }
            }
            return new Headers(strArr2);
        } else {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
    }

    public long byteCount() {
        String[] strArr = this.namesAndValues;
        long length = (long) (strArr.length * 2);
        for (int i2 = 0; i2 < strArr.length; i2++) {
            length += (long) this.namesAndValues[i2].length();
        }
        return length;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Headers) && Arrays.equals(((Headers) obj).namesAndValues, this.namesAndValues);
    }

    public String get(String str) {
        return get(this.namesAndValues, str);
    }

    public Date getDate(String str) {
        String str2 = get(str);
        if (str2 != null) {
            return HttpDate.parse(str2);
        }
        return null;
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    public String name(int i2) {
        return this.namesAndValues[i2 * 2];
    }

    public Set<String> names() {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            treeSet.add(name(i2));
        }
        return Collections.unmodifiableSet(treeSet);
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        Collections.addAll(builder.namesAndValues, this.namesAndValues);
        return builder;
    }

    public int size() {
        return this.namesAndValues.length / 2;
    }

    public Map<String, List<String>> toMultimap() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            String lowerCase = name(i2).toLowerCase(Locale.US);
            List list = (List) treeMap.get(lowerCase);
            if (list == null) {
                list = new ArrayList(2);
                treeMap.put(lowerCase, list);
            }
            list.add(value(i2));
        }
        return treeMap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append(name(i2));
            sb.append(": ");
            sb.append(value(i2));
            sb.append("\n");
        }
        return sb.toString();
    }

    public String value(int i2) {
        return this.namesAndValues[(i2 * 2) + 1];
    }

    public List<String> values(String str) {
        int size = size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            if (str.equalsIgnoreCase(name(i2))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(value(i2));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    private static String get(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    private Headers(String[] strArr) {
        this.namesAndValues = strArr;
    }

    public static Headers of(Map<String, String> map) {
        if (map != null) {
            String[] strArr = new String[(map.size() * 2)];
            int i2 = 0;
            for (Entry entry : map.entrySet()) {
                if (entry.getKey() == null || entry.getValue() == null) {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
                String trim = ((String) entry.getKey()).trim();
                String trim2 = ((String) entry.getValue()).trim();
                if (trim.length() != 0 && trim.indexOf(0) == -1 && trim2.indexOf(0) == -1) {
                    strArr[i2] = trim;
                    strArr[i2 + 1] = trim2;
                    i2 += 2;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unexpected header: ");
                    sb.append(trim);
                    sb.append(": ");
                    sb.append(trim2);
                    throw new IllegalArgumentException(sb.toString());
                }
            }
            return new Headers(strArr);
        }
        throw new NullPointerException("headers == null");
    }
}
