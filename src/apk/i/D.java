package i;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: MediaType */
public final class D {

    /* renamed from: a reason: collision with root package name */
    private static final Pattern f8440a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: b reason: collision with root package name */
    private static final Pattern f8441b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: c reason: collision with root package name */
    private final String f8442c;

    /* renamed from: d reason: collision with root package name */
    private final String f8443d;

    /* renamed from: e reason: collision with root package name */
    private final String f8444e;

    /* renamed from: f reason: collision with root package name */
    private final String f8445f;

    private D(String str, String str2, String str3, String str4) {
        this.f8442c = str;
        this.f8443d = str2;
        this.f8444e = str3;
        this.f8445f = str4;
    }

    public static D a(String str) {
        Matcher matcher = f8440a.matcher(str);
        if (matcher.lookingAt()) {
            String lowerCase = matcher.group(1).toLowerCase(Locale.US);
            String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
            String str2 = null;
            Matcher matcher2 = f8441b.matcher(str);
            int end = matcher.end();
            while (end < str.length()) {
                matcher2.region(end, str.length());
                String str3 = "\" for: \"";
                if (matcher2.lookingAt()) {
                    String group = matcher2.group(1);
                    if (group != null && group.equalsIgnoreCase("charset")) {
                        String group2 = matcher2.group(2);
                        if (group2 != null) {
                            String str4 = "'";
                            if (group2.startsWith(str4) && group2.endsWith(str4) && group2.length() > 2) {
                                group2 = group2.substring(1, group2.length() - 1);
                            }
                        } else {
                            group2 = matcher2.group(3);
                        }
                        if (str2 == null || group2.equalsIgnoreCase(str2)) {
                            str2 = group2;
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Multiple charsets defined: \"");
                            sb.append(str2);
                            sb.append("\" and: \"");
                            sb.append(group2);
                            sb.append(str3);
                            sb.append(str);
                            sb.append('\"');
                            throw new IllegalArgumentException(sb.toString());
                        }
                    }
                    end = matcher2.end();
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Parameter is not formatted correctly: \"");
                    sb2.append(str.substring(end));
                    sb2.append(str3);
                    sb2.append(str);
                    sb2.append('\"');
                    throw new IllegalArgumentException(sb2.toString());
                }
            }
            return new D(str, lowerCase, lowerCase2, str2);
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("No subtype found for: \"");
        sb3.append(str);
        sb3.append('\"');
        throw new IllegalArgumentException(sb3.toString());
    }

    public static D b(String str) {
        try {
            return a(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof D) && ((D) obj).f8442c.equals(this.f8442c);
    }

    public int hashCode() {
        return this.f8442c.hashCode();
    }

    public String toString() {
        return this.f8442c;
    }

    public String a() {
        return this.f8443d;
    }
}
