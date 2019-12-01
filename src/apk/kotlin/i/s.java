package kotlin.i;

import java.util.Collection;
import java.util.Iterator;
import kotlin.e.b.h;
import kotlin.f.b;
import kotlin.f.d;
import kotlin.g;
import kotlin.h.c;
import kotlin.k;

/* compiled from: Strings.kt */
class s extends n {
    public static final d b(CharSequence charSequence) {
        h.b(charSequence, "$this$indices");
        return new d(0, charSequence.length() - 1);
    }

    public static final int c(CharSequence charSequence) {
        h.b(charSequence, "$this$lastIndex");
        return charSequence.length() - 1;
    }

    public static String a(String str, d dVar) {
        h.b(str, "$this$substring");
        h.b(dVar, "range");
        String substring = str.substring(dVar.h().intValue(), dVar.g().intValue() + 1);
        h.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final int b(CharSequence charSequence, char[] cArr, int i2, boolean z) {
        h.b(charSequence, "$this$lastIndexOfAny");
        h.b(cArr, "chars");
        if (z || cArr.length != 1 || !(charSequence instanceof String)) {
            for (int b2 = h.b(i2, c(charSequence)); b2 >= 0; b2--) {
                char charAt = charSequence.charAt(b2);
                int length = cArr.length;
                boolean z2 = false;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (b.a(cArr[i3], charAt, z)) {
                        z2 = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (z2) {
                    return b2;
                }
            }
            return -1;
        }
        return ((String) charSequence).lastIndexOf(e.a(cArr), i2);
    }

    public static final String a(CharSequence charSequence, d dVar) {
        h.b(charSequence, "$this$substring");
        h.b(dVar, "range");
        return charSequence.subSequence(dVar.h().intValue(), dVar.g().intValue() + 1).toString();
    }

    public static final boolean a(CharSequence charSequence, int i2, CharSequence charSequence2, int i3, int i4, boolean z) {
        h.b(charSequence, "$this$regionMatchesImpl");
        h.b(charSequence2, "other");
        if (i3 < 0 || i2 < 0 || i2 > charSequence.length() - i4 || i3 > charSequence2.length() - i4) {
            return false;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            if (!b.a(charSequence.charAt(i2 + i5), charSequence2.charAt(i3 + i5), z)) {
                return false;
            }
        }
        return true;
    }

    public static final int a(CharSequence charSequence, char[] cArr, int i2, boolean z) {
        boolean z2;
        h.b(charSequence, "$this$indexOfAny");
        h.b(cArr, "chars");
        if (z || cArr.length != 1 || !(charSequence instanceof String)) {
            int a2 = h.a(i2, 0);
            int c2 = c(charSequence);
            if (a2 <= c2) {
                while (true) {
                    char charAt = charSequence.charAt(a2);
                    int length = cArr.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            z2 = false;
                            break;
                        } else if (b.a(cArr[i3], charAt, z)) {
                            z2 = true;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (!z2) {
                        if (a2 == c2) {
                            break;
                        }
                        a2++;
                    } else {
                        return a2;
                    }
                }
            }
            return -1;
        }
        return ((String) charSequence).indexOf(e.a(cArr), i2);
    }

    /* access modifiers changed from: private */
    public static final g<Integer, String> b(CharSequence charSequence, Collection<String> collection, int i2, boolean z, boolean z2) {
        Object obj;
        Object obj2;
        g<Integer, String> gVar = null;
        if (z || collection.size() != 1) {
            b dVar = !z2 ? new d(h.a(i2, 0), charSequence.length()) : h.c(h.b(i2, c(charSequence)), 0);
            if (charSequence instanceof String) {
                int first = dVar.getFirst();
                int last = dVar.getLast();
                int e2 = dVar.e();
                if (e2 < 0 ? first >= last : first <= last) {
                    while (true) {
                        Iterator it = collection.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj2 = null;
                                break;
                            }
                            obj2 = it.next();
                            String str = (String) obj2;
                            if (n.a(str, 0, (String) charSequence, first, str.length(), z)) {
                                break;
                            }
                        }
                        String str2 = (String) obj2;
                        if (str2 == null) {
                            if (first == last) {
                                break;
                            }
                            first += e2;
                        } else {
                            return k.a(Integer.valueOf(first), str2);
                        }
                    }
                }
            } else {
                int first2 = dVar.getFirst();
                int last2 = dVar.getLast();
                int e3 = dVar.e();
                if (e3 < 0 ? first2 >= last2 : first2 <= last2) {
                    while (true) {
                        Iterator it2 = collection.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it2.next();
                            String str3 = (String) obj;
                            if (a((CharSequence) str3, 0, charSequence, first2, str3.length(), z)) {
                                break;
                            }
                        }
                        String str4 = (String) obj;
                        if (str4 == null) {
                            if (first2 == last2) {
                                break;
                            }
                            first2 += e3;
                        } else {
                            return k.a(Integer.valueOf(first2), str4);
                        }
                    }
                }
            }
            return null;
        }
        String str5 = (String) q.b(collection);
        int a2 = !z2 ? a(charSequence, str5, i2, false, 4, (Object) null) : b(charSequence, str5, i2, false, 4, null);
        if (a2 >= 0) {
            gVar = k.a(Integer.valueOf(a2), str5);
        }
        return gVar;
    }

    static /* synthetic */ int a(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z, boolean z2, int i4, Object obj) {
        return a(charSequence, charSequence2, i2, i3, z, (i4 & 16) != 0 ? false : z2);
    }

    private static final int a(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z, boolean z2) {
        b bVar;
        if (!z2) {
            bVar = new d(h.a(i2, 0), h.b(i3, charSequence.length()));
        } else {
            bVar = h.c(h.b(i2, c(charSequence)), h.a(i3, 0));
        }
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int first = bVar.getFirst();
            int last = bVar.getLast();
            int e2 = bVar.e();
            if (e2 < 0 ? first >= last : first <= last) {
                while (true) {
                    if (!a(charSequence2, 0, charSequence, first, charSequence2.length(), z)) {
                        if (first == last) {
                            break;
                        }
                        first += e2;
                    } else {
                        return first;
                    }
                }
            }
        } else {
            int first2 = bVar.getFirst();
            int last2 = bVar.getLast();
            int e3 = bVar.e();
            if (e3 < 0 ? first2 >= last2 : first2 <= last2) {
                while (true) {
                    if (!n.a((String) charSequence2, 0, (String) charSequence, first2, charSequence2.length(), z)) {
                        if (first2 == last2) {
                            break;
                        }
                        first2 += e3;
                    } else {
                        return first2;
                    }
                }
            }
        }
        return -1;
    }

    public static /* synthetic */ int a(CharSequence charSequence, String str, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return a(charSequence, str, i2, z);
    }

    public static final int a(CharSequence charSequence, String str, int i2, boolean z) {
        h.b(charSequence, "$this$indexOf");
        h.b(str, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i2);
        }
        return a(charSequence, str, i2, charSequence.length(), z, false, 16, null);
    }

    public static /* synthetic */ int b(CharSequence charSequence, String str, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = c(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return b(charSequence, str, i2, z);
    }

    public static final int b(CharSequence charSequence, String str, int i2, boolean z) {
        h.b(charSequence, "$this$lastIndexOf");
        h.b(str, "string");
        if (z || !(charSequence instanceof String)) {
            return a(charSequence, (CharSequence) str, i2, 0, z, true);
        }
        return ((String) charSequence).lastIndexOf(str, i2);
    }

    public static /* synthetic */ int a(CharSequence charSequence, char c2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = c(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return a(charSequence, c2, i2, z);
    }

    public static final int a(CharSequence charSequence, char c2, int i2, boolean z) {
        h.b(charSequence, "$this$lastIndexOf");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c2, i2);
        }
        return b(charSequence, new char[]{c2}, i2, z);
    }

    public static /* synthetic */ boolean a(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return a(charSequence, charSequence2, z);
    }

    public static final boolean a(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        h.b(charSequence, "$this$contains");
        h.b(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (a(charSequence, (String) charSequence2, 0, z, 2, (Object) null) >= 0) {
                return true;
            }
        } else {
            if (a(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, null) >= 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ c a(CharSequence charSequence, char[] cArr, int i2, boolean z, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        return a(charSequence, cArr, i2, z, i3);
    }

    private static final c<d> a(CharSequence charSequence, char[] cArr, int i2, boolean z, int i3) {
        if (i3 >= 0) {
            return new d(charSequence, i2, i3, new o(cArr, z));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Limit must be non-negative, but was ");
        sb.append(i3);
        sb.append('.');
        throw new IllegalArgumentException(sb.toString().toString());
    }

    static /* synthetic */ c a(CharSequence charSequence, String[] strArr, int i2, boolean z, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        return a(charSequence, strArr, i2, z, i3);
    }

    private static final c<d> a(CharSequence charSequence, String[] strArr, int i2, boolean z, int i3) {
        if (i3 >= 0) {
            return new d(charSequence, i2, i3, new p(d.a(strArr), z));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Limit must be non-negative, but was ");
        sb.append(i3);
        sb.append('.');
        throw new IllegalArgumentException(sb.toString().toString());
    }

    public static /* synthetic */ c a(CharSequence charSequence, String[] strArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return a(charSequence, strArr, z, i2);
    }

    public static final c<String> a(CharSequence charSequence, String[] strArr, boolean z, int i2) {
        h.b(charSequence, "$this$splitToSequence");
        h.b(strArr, "delimiters");
        return j.b(a(charSequence, strArr, 0, z, i2, 2, (Object) null), new q(charSequence));
    }

    public static /* synthetic */ c a(CharSequence charSequence, char[] cArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return a(charSequence, cArr, z, i2);
    }

    public static final c<String> a(CharSequence charSequence, char[] cArr, boolean z, int i2) {
        h.b(charSequence, "$this$splitToSequence");
        h.b(cArr, "delimiters");
        return j.b(a(charSequence, cArr, 0, z, i2, 2, (Object) null), new r(charSequence));
    }
}
