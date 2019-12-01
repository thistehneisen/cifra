package io.intercom.okhttp3;

import com.appsflyer.share.Constants;
import io.intercom.okhttp3.internal.Util;
import io.intercom.okhttp3.internal.http.HttpDate;
import io.intercom.okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Cookie {
    private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    private final String value;

    public static final class Builder {
        String domain;
        long expiresAt = HttpDate.MAX_DATE;
        boolean hostOnly;
        boolean httpOnly;
        String name;
        String path = Constants.URL_PATH_DELIMITER;
        boolean persistent;
        boolean secure;
        String value;

        public Cookie build() {
            return new Cookie(this);
        }

        public Builder domain(String str) {
            domain(str, false);
            return this;
        }

        public Builder expiresAt(long j2) {
            if (j2 <= 0) {
                j2 = Long.MIN_VALUE;
            }
            if (j2 > HttpDate.MAX_DATE) {
                j2 = 253402300799999L;
            }
            this.expiresAt = j2;
            this.persistent = true;
            return this;
        }

        public Builder hostOnlyDomain(String str) {
            domain(str, true);
            return this;
        }

        public Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        public Builder name(String str) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str.trim().equals(str)) {
                this.name = str;
                return this;
            } else {
                throw new IllegalArgumentException("name is not trimmed");
            }
        }

        public Builder path(String str) {
            if (str.startsWith(Constants.URL_PATH_DELIMITER)) {
                this.path = str;
                return this;
            }
            throw new IllegalArgumentException("path must start with '/'");
        }

        public Builder secure() {
            this.secure = true;
            return this;
        }

        public Builder value(String str) {
            if (str == null) {
                throw new NullPointerException("value == null");
            } else if (str.trim().equals(str)) {
                this.value = str;
                return this;
            } else {
                throw new IllegalArgumentException("value is not trimmed");
            }
        }

        private Builder domain(String str, boolean z) {
            if (str != null) {
                String canonicalizeHost = Util.canonicalizeHost(str);
                if (canonicalizeHost != null) {
                    this.domain = canonicalizeHost;
                    this.hostOnly = z;
                    return this;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("unexpected domain: ");
                sb.append(str);
                throw new IllegalArgumentException(sb.toString());
            }
            throw new NullPointerException("domain == null");
        }
    }

    private Cookie(String str, String str2, long j2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j2;
        this.domain = str3;
        this.path = str4;
        this.secure = z;
        this.httpOnly = z2;
        this.hostOnly = z3;
        this.persistent = z4;
    }

    private static int dateCharacterOffset(String str, int i2, int i3, boolean z) {
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (((charAt < ' ' && charAt != 9) || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    private static boolean domainMatch(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        if (!str.endsWith(str2) || str.charAt((str.length() - str2.length()) - 1) != '.' || Util.verifyAsIpAddress(str)) {
            return false;
        }
        return true;
    }

    public static Cookie parse(HttpUrl httpUrl, String str) {
        return parse(System.currentTimeMillis(), httpUrl, str);
    }

    public static List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        List values = headers.values("Set-Cookie");
        int size = values.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            Cookie parse = parse(httpUrl, (String) values.get(i2));
            if (parse != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(parse);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    private static String parseDomain(String str) {
        String str2 = ".";
        if (!str.endsWith(str2)) {
            if (str.startsWith(str2)) {
                str = str.substring(1);
            }
            String canonicalizeHost = Util.canonicalizeHost(str);
            if (canonicalizeHost != null) {
                return canonicalizeHost;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    private static long parseExpires(String str, int i2, int i3) {
        int dateCharacterOffset = dateCharacterOffset(str, i2, i3, false);
        Matcher matcher = TIME_PATTERN.matcher(str);
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        int i9 = -1;
        while (dateCharacterOffset < i3) {
            int dateCharacterOffset2 = dateCharacterOffset(str, dateCharacterOffset + 1, i3, true);
            matcher.region(dateCharacterOffset, dateCharacterOffset2);
            if (i5 == -1 && matcher.usePattern(TIME_PATTERN).matches()) {
                int parseInt = Integer.parseInt(matcher.group(1));
                int parseInt2 = Integer.parseInt(matcher.group(2));
                i9 = Integer.parseInt(matcher.group(3));
                i8 = parseInt2;
                i5 = parseInt;
            } else if (i6 == -1 && matcher.usePattern(DAY_OF_MONTH_PATTERN).matches()) {
                i6 = Integer.parseInt(matcher.group(1));
            } else if (i7 == -1 && matcher.usePattern(MONTH_PATTERN).matches()) {
                i7 = MONTH_PATTERN.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
            } else if (i4 == -1 && matcher.usePattern(YEAR_PATTERN).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
            }
            dateCharacterOffset = dateCharacterOffset(str, dateCharacterOffset2 + 1, i3, false);
        }
        if (i4 >= 70 && i4 <= 99) {
            i4 += 1900;
        }
        if (i4 >= 0 && i4 <= 69) {
            i4 += 2000;
        }
        if (i4 < 1601) {
            throw new IllegalArgumentException();
        } else if (i7 == -1) {
            throw new IllegalArgumentException();
        } else if (i6 < 1 || i6 > 31) {
            throw new IllegalArgumentException();
        } else if (i5 < 0 || i5 > 23) {
            throw new IllegalArgumentException();
        } else if (i8 < 0 || i8 > 59) {
            throw new IllegalArgumentException();
        } else if (i9 < 0 || i9 > 59) {
            throw new IllegalArgumentException();
        } else {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i4);
            gregorianCalendar.set(2, i7 - 1);
            gregorianCalendar.set(5, i6);
            gregorianCalendar.set(11, i5);
            gregorianCalendar.set(12, i8);
            gregorianCalendar.set(13, i9);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
    }

    private static long parseMaxAge(String str) {
        long j2 = Long.MIN_VALUE;
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 0) {
                j2 = parseLong;
            }
            return j2;
        } catch (NumberFormatException e2) {
            if (str.matches("-?\\d+")) {
                if (!str.startsWith("-")) {
                    j2 = Long.MAX_VALUE;
                }
                return j2;
            }
            throw e2;
        }
    }

    private static boolean pathMatch(HttpUrl httpUrl, String str) {
        String encodedPath = httpUrl.encodedPath();
        if (encodedPath.equals(str)) {
            return true;
        }
        if (!encodedPath.startsWith(str) || (!str.endsWith(Constants.URL_PATH_DELIMITER) && encodedPath.charAt(str.length()) != '/')) {
            return false;
        }
        return true;
    }

    public String domain() {
        return this.domain;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        if (cookie.name.equals(this.name) && cookie.value.equals(this.value) && cookie.domain.equals(this.domain) && cookie.path.equals(this.path) && cookie.expiresAt == this.expiresAt && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly) {
            z = true;
        }
        return z;
    }

    public long expiresAt() {
        return this.expiresAt;
    }

    public int hashCode() {
        int hashCode = (((((((527 + this.name.hashCode()) * 31) + this.value.hashCode()) * 31) + this.domain.hashCode()) * 31) + this.path.hashCode()) * 31;
        long j2 = this.expiresAt;
        return ((((((((hashCode + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (this.secure ^ true ? 1 : 0)) * 31) + (this.httpOnly ^ true ? 1 : 0)) * 31) + (this.persistent ^ true ? 1 : 0)) * 31) + (this.hostOnly ^ true ? 1 : 0);
    }

    public boolean hostOnly() {
        return this.hostOnly;
    }

    public boolean httpOnly() {
        return this.httpOnly;
    }

    public boolean matches(HttpUrl httpUrl) {
        boolean z;
        if (this.hostOnly) {
            z = httpUrl.host().equals(this.domain);
        } else {
            z = domainMatch(httpUrl.host(), this.domain);
        }
        if (!z || !pathMatch(httpUrl, this.path)) {
            return false;
        }
        if (!this.secure || httpUrl.isHttps()) {
            return true;
        }
        return false;
    }

    public String name() {
        return this.name;
    }

    public String path() {
        return this.path;
    }

    public boolean persistent() {
        return this.persistent;
    }

    public boolean secure() {
        return this.secure;
    }

    public String toString() {
        return toString(false);
    }

    public String value() {
        return this.value;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0131  */
    static Cookie parse(long j2, HttpUrl httpUrl, String str) {
        long j3;
        String host;
        String str2;
        Cookie cookie;
        String str3;
        String str4;
        String str5;
        int lastIndexOf;
        String str6 = str;
        int length = str.length();
        char c2 = ';';
        int delimiterOffset = Util.delimiterOffset(str6, 0, length, ';');
        char c3 = '=';
        int delimiterOffset2 = Util.delimiterOffset(str6, 0, delimiterOffset, '=');
        if (delimiterOffset2 == delimiterOffset) {
            return null;
        }
        String trimSubstring = Util.trimSubstring(str6, 0, delimiterOffset2);
        if (trimSubstring.isEmpty() || Util.indexOfControlOrNonAscii(trimSubstring) != -1) {
            return null;
        }
        String trimSubstring2 = Util.trimSubstring(str6, delimiterOffset2 + 1, delimiterOffset);
        if (Util.indexOfControlOrNonAscii(trimSubstring2) != -1) {
            return null;
        }
        int i2 = delimiterOffset + 1;
        String str7 = null;
        String str8 = null;
        long j4 = -1;
        long j5 = 253402300799999L;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = true;
        boolean z4 = false;
        while (i2 < length) {
            int delimiterOffset3 = Util.delimiterOffset(str6, i2, length, c2);
            int delimiterOffset4 = Util.delimiterOffset(str6, i2, delimiterOffset3, c3);
            String trimSubstring3 = Util.trimSubstring(str6, i2, delimiterOffset4);
            String trimSubstring4 = delimiterOffset4 < delimiterOffset3 ? Util.trimSubstring(str6, delimiterOffset4 + 1, delimiterOffset3) : "";
            if (trimSubstring3.equalsIgnoreCase("expires")) {
                try {
                    j5 = parseExpires(trimSubstring4, 0, trimSubstring4.length());
                } catch (IllegalArgumentException unused) {
                }
            } else if (trimSubstring3.equalsIgnoreCase("max-age")) {
                j4 = parseMaxAge(trimSubstring4);
            } else {
                if (trimSubstring3.equalsIgnoreCase("domain")) {
                    str7 = parseDomain(trimSubstring4);
                    z3 = false;
                } else if (trimSubstring3.equalsIgnoreCase("path")) {
                    str8 = trimSubstring4;
                } else if (trimSubstring3.equalsIgnoreCase("secure")) {
                    z = true;
                } else if (trimSubstring3.equalsIgnoreCase("httponly")) {
                    z2 = true;
                }
                i2 = delimiterOffset3 + 1;
                c2 = ';';
                c3 = '=';
            }
            z4 = true;
            i2 = delimiterOffset3 + 1;
            c2 = ';';
            c3 = '=';
        }
        long j6 = Long.MIN_VALUE;
        if (j4 != Long.MIN_VALUE) {
            if (j4 != -1) {
                j6 = j2 + (j4 <= 9223372036854775L ? j4 * 1000 : Long.MAX_VALUE);
                if (j6 < j2 || j6 > HttpDate.MAX_DATE) {
                    j3 = 253402300799999L;
                }
            } else {
                j3 = j5;
            }
            host = httpUrl.host();
            if (str7 != null) {
                str2 = host;
                cookie = null;
            } else if (!domainMatch(host, str7)) {
                return null;
            } else {
                cookie = null;
                str2 = str7;
            }
            if (host.length() == str2.length() && PublicSuffixDatabase.get().getEffectiveTldPlusOne(str2) == null) {
                return cookie;
            }
            str3 = Constants.URL_PATH_DELIMITER;
            str4 = str8;
            if (str4 != null || !str4.startsWith(str3)) {
                String encodedPath = httpUrl.encodedPath();
                lastIndexOf = encodedPath.lastIndexOf(47);
                if (lastIndexOf != 0) {
                    str3 = encodedPath.substring(0, lastIndexOf);
                }
                str5 = str3;
            } else {
                str5 = str4;
            }
            Cookie cookie2 = new Cookie(trimSubstring, trimSubstring2, j3, str2, str5, z, z2, z3, z4);
            return cookie2;
        }
        j3 = j6;
        host = httpUrl.host();
        if (str7 != null) {
        }
        if (host.length() == str2.length()) {
        }
        str3 = Constants.URL_PATH_DELIMITER;
        str4 = str8;
        if (str4 != null) {
        }
        String encodedPath2 = httpUrl.encodedPath();
        lastIndexOf = encodedPath2.lastIndexOf(47);
        if (lastIndexOf != 0) {
        }
        str5 = str3;
        Cookie cookie22 = new Cookie(trimSubstring, trimSubstring2, j3, str2, str5, z, z2, z3, z4);
        return cookie22;
    }

    /* access modifiers changed from: 0000 */
    public String toString(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append('=');
        sb.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(HttpDate.format(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.domain);
        }
        sb.append("; path=");
        sb.append(this.path);
        if (this.secure) {
            sb.append("; secure");
        }
        if (this.httpOnly) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    Cookie(Builder builder) {
        String str = builder.name;
        if (str != null) {
            String str2 = builder.value;
            if (str2 != null) {
                String str3 = builder.domain;
                if (str3 != null) {
                    this.name = str;
                    this.value = str2;
                    this.expiresAt = builder.expiresAt;
                    this.domain = str3;
                    this.path = builder.path;
                    this.secure = builder.secure;
                    this.httpOnly = builder.httpOnly;
                    this.persistent = builder.persistent;
                    this.hostOnly = builder.hostOnly;
                    return;
                }
                throw new NullPointerException("builder.domain == null");
            }
            throw new NullPointerException("builder.value == null");
        }
        throw new NullPointerException("builder.name == null");
    }
}
