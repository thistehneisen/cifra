package org.joda.time.e;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.joda.time.b;

/* compiled from: DateTimeFormat */
public class a {

    /* renamed from: a reason: collision with root package name */
    private static final ConcurrentHashMap<String, b> f10827a = new ConcurrentHashMap<>();

    /* renamed from: b reason: collision with root package name */
    private static final AtomicReferenceArray<b> f10828b = new AtomicReferenceArray<>(25);

    public static b a(String str) {
        return b(str);
    }

    private static b b(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Invalid pattern specification");
        }
        b bVar = (b) f10827a.get(str);
        if (bVar != null) {
            return bVar;
        }
        c cVar = new c();
        a(cVar, str);
        b i2 = cVar.i();
        if (f10827a.size() >= 500) {
            return i2;
        }
        b bVar2 = (b) f10827a.putIfAbsent(str, i2);
        return bVar2 != null ? bVar2 : i2;
    }

    private static boolean c(String str) {
        int length = str.length();
        if (length > 0) {
            switch (str.charAt(0)) {
                case 'C':
                case 'D':
                case 'F':
                case 'H':
                case 'K':
                case 'S':
                case 'W':
                case 'Y':
                case 'c':
                case 'd':
                case 'e':
                case 'h':
                case 'k':
                case 'm':
                case 's':
                case 'w':
                case 'x':
                case 'y':
                    break;
                case 'M':
                    if (length <= 2) {
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    private static void a(c cVar, String str) {
        boolean z;
        int length = str.length();
        int[] iArr = new int[1];
        int i2 = 0;
        while (i2 < length) {
            iArr[0] = i2;
            String a2 = a(str, iArr);
            int i3 = iArr[0];
            int length2 = a2.length();
            if (length2 != 0) {
                char charAt = a2.charAt(0);
                if (charAt == '\'') {
                    String substring = a2.substring(1);
                    if (substring.length() == 1) {
                        cVar.a(substring.charAt(0));
                    } else {
                        cVar.a(new String(substring));
                    }
                } else if (charAt == 'K') {
                    cVar.g(length2);
                } else if (charAt != 'M') {
                    if (charAt == 'S') {
                        cVar.d(length2, length2);
                    } else if (charAt == 'a') {
                        cVar.d();
                    } else if (charAt == 'h') {
                        cVar.b(length2);
                    } else if (charAt == 'k') {
                        cVar.a(length2);
                    } else if (charAt == 'm') {
                        cVar.h(length2);
                    } else if (charAt == 's') {
                        cVar.j(length2);
                    } else if (charAt == 'G') {
                        cVar.c();
                    } else if (charAt != 'H') {
                        if (charAt != 'Y') {
                            if (charAt != 'Z') {
                                if (charAt == 'd') {
                                    cVar.c(length2);
                                } else if (charAt != 'e') {
                                    switch (charAt) {
                                        case 'C':
                                            cVar.a(length2, length2);
                                            continue;
                                        case 'D':
                                            cVar.e(length2);
                                            continue;
                                        case 'E':
                                            if (length2 < 4) {
                                                cVar.a();
                                                break;
                                            } else {
                                                cVar.b();
                                                continue;
                                            }
                                        default:
                                            switch (charAt) {
                                                case 'w':
                                                    cVar.k(length2);
                                                    continue;
                                                case 'x':
                                                case 'y':
                                                    break;
                                                case 'z':
                                                    if (length2 < 4) {
                                                        cVar.a(null);
                                                        break;
                                                    } else {
                                                        cVar.h();
                                                        continue;
                                                        continue;
                                                    }
                                                default:
                                                    StringBuilder sb = new StringBuilder();
                                                    sb.append("Illegal pattern component: ");
                                                    sb.append(a2);
                                                    throw new IllegalArgumentException(sb.toString());
                                            }
                                    }
                                } else {
                                    cVar.d(length2);
                                }
                            } else if (length2 == 1) {
                                cVar.a(null, "Z", false, 2, 2);
                            } else if (length2 == 2) {
                                cVar.a(null, "Z", true, 2, 2);
                            } else {
                                cVar.g();
                            }
                        }
                        if (length2 == 2) {
                            if (i3 + 1 < length) {
                                iArr[0] = iArr[0] + 1;
                                z = !c(a(str, iArr));
                                iArr[0] = iArr[0] - 1;
                            } else {
                                z = true;
                            }
                            if (charAt != 'x') {
                                cVar.b(new b().e() - 30, z);
                            } else {
                                cVar.a(new b().d() - 30, z);
                            }
                        } else {
                            int i4 = 9;
                            if (i3 + 1 < length) {
                                iArr[0] = iArr[0] + 1;
                                if (c(a(str, iArr))) {
                                    i4 = length2;
                                }
                                iArr[0] = iArr[0] - 1;
                            }
                            if (charAt == 'Y') {
                                cVar.g(length2, i4);
                            } else if (charAt == 'x') {
                                cVar.e(length2, i4);
                            } else if (charAt == 'y') {
                                cVar.f(length2, i4);
                            }
                        }
                    } else {
                        cVar.f(length2);
                    }
                } else if (length2 < 3) {
                    cVar.i(length2);
                } else if (length2 >= 4) {
                    cVar.f();
                } else {
                    cVar.e();
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private static String a(String str, int[] iArr) {
        StringBuilder sb = new StringBuilder();
        int i2 = iArr[0];
        int length = str.length();
        char charAt = str.charAt(i2);
        if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
            sb.append(charAt);
            while (true) {
                int i3 = i2 + 1;
                if (i3 >= length || str.charAt(i3) != charAt) {
                    break;
                }
                sb.append(charAt);
                i2 = i3;
            }
        } else {
            sb.append('\'');
            boolean z = false;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                char charAt2 = str.charAt(i2);
                if (charAt2 == '\'') {
                    int i4 = i2 + 1;
                    if (i4 >= length || str.charAt(i4) != '\'') {
                        z = !z;
                    } else {
                        sb.append(charAt2);
                        i2 = i4;
                    }
                } else if (z || ((charAt2 < 'A' || charAt2 > 'Z') && (charAt2 < 'a' || charAt2 > 'z'))) {
                    sb.append(charAt2);
                }
                i2++;
            }
            i2--;
        }
        iArr[0] = i2;
        return sb.toString();
    }
}
