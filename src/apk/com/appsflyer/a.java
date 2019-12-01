package com.appsflyer;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import io.intercom.okhttp3.internal.http.StatusLine;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class a {

    /* renamed from: ˊ reason: contains not printable characters */
    private static long f108 = 3950183758939332917L;

    /* renamed from: ˋ reason: contains not printable characters */
    private static int f109 = 1;

    /* renamed from: ˎ reason: contains not printable characters */
    private static int f110;

    /* renamed from: ˏ reason: contains not printable characters */
    private static char[] f111 = {5961, 46707, 21798, 62661, 37779, 12616, 53362, 32629, 7924, 48528, 23382, 64010, 39204, 14577, 51105, 25949, 1025, 41859, 17094, 57762, 36704, 11796, 52694, 27779, 3007, 43371, 18483, 6130, 46725, 21575, 62335, 37412, 12781, 53391, '1', 54731, 'y', 41292, 16915, 58342, 34041, 9796, 51059, 26718, 2508, 43705, 19533, 60687, 36404, 12252, 53387, 29288, 4899, 46303, 'b', 41300, 16904, 58362, 33973, 9836, 50958, 26694, 2449, 43705, 19495, 60788, 36381, 12243, 53471, 29224, 4964, 46307, 21902, 63114, 38928, 14652, 55994, 31731, 7324, 48660, 24403, 241, 41470, 17201, 58375, 34138, 11125, 35407, 26906, 51449, 44975, 3444, 60494, 17225, 8915, 33210, 26408, 50705, 42249, 1233, 64390, 22890, 14390, 40936, 32483, 56730, 45918, 4652, 61949, 20658, 14238, 56093, 31271, 39282, 14481, 24519, 64796, 7206, 45857, 53948, 29120, 38684, 13919, 21879, 62636, 3048, 43266, 51202, 28586, 36515, 11773, 17195, 57930, 384, 47412, 6158, 64347, 23224, 15854, 40757, 32271, 53512, 45202, 5115, 62825, 21587, 14170, 38557, 27101, 52013, 43601, 3505, 60572, 20433, 'a', 41307, 16910, 58349, 33979, 9824, 51034, 26717, 2502, 43704, 19558, 60777, 36393, 12227, 53391, '.', '\\', 41243, 63425, 22271, 46519, 5205, 29521, 53707, 12538, 40950, 65143, 23835, 48073, 6792, 31166, 55400, '/', 41302, 16907, 58364, 33980, 9836, '.', 41247, 16965, 58307, 33959, 9763, 50966, 26717, 2434, 43764, 'C', 41309, 16911, 58364, 33983, 9850, 51019, 26654, 2541, 43685, 19569, 60706, 36364, 12229, 53391, 29300, 4926, 'F', 41300, 16899, 58355, 33969, 9837, 50974, 26631, 2503, 43773, 19573, 60706, 36360, 12177, 53381, 29306, 4915, 46317, 21983, 63183, 38996, 14648, 56058, 31659, 7384, 48730, 24331, 227, 41380, 17185, 58451, 34067, 9923, 51120, 27002, 2635, 43805, 19654, 60848, 36649, 12392, 4469, 45122, 21260, 62148, 38312, 14184, 54872, 30976, 6358, 48035, 23909, 64561, 40751, 16083, 49540, 25445, 555, 42484, 17609, 59273, 35167, 10276, 52210, 27298, 'C', 41309, 16911, 58364, 33983, 9850, 51019, 26654, 2554, 43704, 19572, 60715, 36377, 12242, 53394, 29278, 4904, 46310, 21983, 63135, 38992, 14640, 56033, 31661, 'F', 41300, 16899, 58355, 33969, 9837, 50974, 26650, 2502, 43691, 19581, 60716, 36377, 12177, 53396, 29310, 4918, 46313, 21983, 63116, 38992, 14652, 56042, 31715, 7317, 48712, 24342, 255, 41379, 17253, 58390, 34076, 9929, 51105, 26978, 2591, 43793, 19665, 60861, 36726, 12344, 53513, 29403, 5000, 46450, 22123, 63398};

    static class e extends HashMap<String, Object> {

        /* renamed from: ˎ reason: contains not printable characters */
        private static int f112 = 0;

        /* renamed from: ˏ reason: contains not printable characters */
        private static long f113 = -7481529154018449095L;

        /* renamed from: ॱ reason: contains not printable characters */
        private static char[] f114 = {'a', 26975, 53805, 15327, 42125, 3696, 30515, 57596, 18876, 45920, 7255, 34051, 18161, 12248, 38016, 32086, 57875, 24432, 13896, 36115, 25815, 64392, 20834, 10278, 49141, 'k', 26972, 53780, 33572, 59930, 20825, 47237, 10179, 36155, 62516, 25514, 51951, 12333, 40733, 1603, 28047, 54483, 16949, 43387, 4277, 32683, 58667, 19484, 47952, 8911, 35279, 63288, 24163, 50675, 11519, 39464, 266, 26719, 55244, 16064, 42010, 4984, 31413, 57849, 20274, 46614, 7515, 33923, 62352, 22851, 'k', 26972, 53780, 15250, 42205, 3620, 30575, 'f', 26960, 53760, 15320, 42128, 3665, 30519, 57594, 18854, 45922, 7250, 34103, 61133, 22417, 49531, '4', 26903, 53835, 15237, 42196, '-', 26955, 53777, 15237, 42190, 'f', 26968, 53787, 15303, 42113, 3705, 30582, 57576, 18861, 45935, 7263, 34049, 61133, 22417, 49527, 10809, 37879, 64745, 26217, 53086, 14354, 41357, 2704, 29822, 56628, 18148, 44975, 6435, 33355, 60188, 21722, 48527, 9984, 36924, 63978, 25256, 52321, 13645, 40450, 1990, 28807, 55887, 17248, 44211, 'b', 26968, 53776, 15310, 42117, 3704, 30566, 57530, 18940, 45873, 7262, 34122, 61085, 22403, 49452, 10855, 37793, 64753, 10529, 16407, 64342, 4761, 36299, 10036, 24178, 51681, 24801, 39471, 13582, 44118, 51074, 32465, 59504, 886, 47795, 54781, 20267, 58900, 4442, 35011, 9188, 23838, 62540, 28549, 34511, 12305, 43813, 49770, 32173, 38127, 3617, 47447, 53397, 19406, 58624, 't', 26972, 53791, 15323, 42113, 3695, 30519, 57595, 18877, 45939, 7263, 'x', 26881, 53828, 33253, 59594, 21386, 47694, 9501, 36857, 10693, '&', 26945, 7278, 29954, '&', 26953, 17019, 11028, 36894, 31110, 59016, 19505, 13627, 41635, 2981, 61742, 24085, 50957, 44249, 5516, 33634, 26663};

        /* renamed from: ॱॱ reason: contains not printable characters */
        private static int f115 = 1;

        /* renamed from: ˊ reason: contains not printable characters */
        private final Context f116;

        /* renamed from: ˋ reason: contains not printable characters */
        private final Map<String, Object> f117;

        static class b {

            /* renamed from: ˋ reason: contains not printable characters */
            private String f118;

            /* renamed from: ˎ reason: contains not printable characters */
            private final Object f119;

            /* renamed from: ॱ reason: contains not printable characters */
            private long f120;

            b() {
            }

            /* JADX WARNING: Code restructure failed: missing block: B:19:0x0028, code lost:
                return false;
             */
            /* renamed from: ˎ reason: contains not printable characters */
            private boolean m113(long j2, String str) {
                synchronized (this.f119) {
                    if (str != null) {
                        if (!str.equals(this.f118)) {
                            if (j2 - this.f120 > 2000) {
                                this.f120 = j2;
                                this.f118 = str;
                                return true;
                            }
                        }
                    }
                }
            }

            /* renamed from: ˏ reason: contains not printable characters */
            static b m114(String str) {
                String str2 = "";
                if (str == null) {
                    return new b(0, str2);
                }
                String[] split = str.split(",");
                if (split.length < 2) {
                    return new b(0, str2);
                }
                return new b(Long.parseLong(split[0]), split[1]);
            }

            /* renamed from: ॱ reason: contains not printable characters */
            static String m115(String str) throws Exception {
                byte[] bytes = str.getBytes();
                for (int i2 = 0; i2 < bytes.length; i2++) {
                    bytes[i2] = (byte) (bytes[i2] ^ ((i2 % 2) + 42));
                }
                StringBuilder sb = new StringBuilder();
                for (byte hexString : bytes) {
                    String hexString2 = Integer.toHexString(hexString);
                    if (hexString2.length() == 1) {
                        hexString2 = "0".concat(String.valueOf(hexString2));
                    }
                    sb.append(hexString2);
                }
                return sb.toString();
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f120);
                sb.append(",");
                sb.append(this.f118);
                return sb.toString();
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: ˋ reason: contains not printable characters */
            public final String m116() {
                return this.f118;
            }

            b(long j2, String str) {
                this.f119 = new Object();
                this.f120 = 0;
                this.f118 = "";
                this.f120 = j2;
                this.f118 = str;
            }

            b(String str) {
                this(System.currentTimeMillis(), str);
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: ॱ reason: contains not printable characters */
            public final boolean m117(b bVar) {
                return m113(bVar.f120, bVar.f118);
            }
        }

        e(Map<String, Object> map, Context context) {
            this.f117 = map;
            this.f116 = context;
            put(m110(), m109());
        }

        /* renamed from: ˊ reason: contains not printable characters */
        private String m109() {
            String str;
            int i2;
            String str2 = "";
            try {
                String obj = this.f117.get(m112(0, 12, 0).intern()).toString();
                String obj2 = this.f117.get(m112(77, 15, 0).intern()).toString();
                String replaceAll = m112(92, 5, 0).intern().replaceAll(m112(97, 5, 0).intern(), str2);
                StringBuilder sb = new StringBuilder();
                sb.append(obj);
                sb.append(obj2);
                sb.append(replaceAll);
                String r5 = p.m177(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str2);
                sb2.append(r5.substring(0, 16));
                str = sb2.toString();
            } catch (Exception e2) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(m112(102, 44, 0).intern());
                sb3.append(e2);
                AFLogger.afRDLog(sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str2);
                sb4.append(m112(146, 18, 0).intern());
                str = sb4.toString();
            }
            try {
                Intent registerReceiver = this.f116.registerReceiver(null, new IntentFilter(m112(164, 37, 10560).intern()));
                int i3 = -2700;
                if (registerReceiver != null) {
                    i3 = registerReceiver.getIntExtra(m112(201, 11, 0).intern(), -2700);
                }
                if (!(this.f116.getApplicationInfo().nativeLibraryDir.contains(m112(212, 3, 0).intern()))) {
                    int i4 = f115 + 53;
                    f112 = i4 % 128;
                    int i5 = i4 % 2;
                } else {
                    int i6 = f115 + 75;
                    f112 = i6 % 128;
                    if ((i6 % 2 != 0 ? 'N' : 29) != 'N') {
                        i2 = 1;
                        int size = ((SensorManager) this.f116.getSystemService(m112(215, 6, 33174).intern())).getSensorList(-1).size();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(m112(221, 1, 10663).intern());
                        sb5.append(i3);
                        sb5.append(m112(222, 2, 0).intern());
                        sb5.append(i2);
                        sb5.append(m112(224, 2, 7240).intern());
                        sb5.append(size);
                        sb5.append(m112(226, 2, 0).intern());
                        sb5.append(this.f117.size());
                        String sb6 = sb5.toString();
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append(str);
                        sb7.append(b.m115(sb6));
                        return sb7.toString();
                    }
                }
                i2 = 0;
                int size2 = ((SensorManager) this.f116.getSystemService(m112(215, 6, 33174).intern())).getSensorList(-1).size();
                StringBuilder sb52 = new StringBuilder();
                sb52.append(m112(221, 1, 10663).intern());
                sb52.append(i3);
                sb52.append(m112(222, 2, 0).intern());
                sb52.append(i2);
                sb52.append(m112(224, 2, 7240).intern());
                sb52.append(size2);
                sb52.append(m112(226, 2, 0).intern());
                sb52.append(this.f117.size());
                String sb62 = sb52.toString();
                StringBuilder sb72 = new StringBuilder();
                sb72.append(str);
                sb72.append(b.m115(sb62));
                return sb72.toString();
            } catch (Exception e3) {
                StringBuilder sb8 = new StringBuilder();
                sb8.append(m112(102, 44, 0).intern());
                sb8.append(e3);
                AFLogger.afRDLog(sb8.toString());
                StringBuilder sb9 = new StringBuilder();
                sb9.append(str);
                sb9.append(m112(228, 16, 16925).intern());
                return sb9.toString();
            }
        }

        /* renamed from: ˋ reason: contains not printable characters */
        private static StringBuilder m111(String... strArr) throws Exception {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                if ((i2 < 3 ? 18 : '^') == '^') {
                    break;
                }
                arrayList.add(Integer.valueOf(strArr[i2].length()));
                i2++;
            }
            Collections.sort(arrayList);
            int intValue = ((Integer) arrayList.get(0)).intValue();
            StringBuilder sb = new StringBuilder();
            int i3 = f112 + 15;
            f115 = i3 % 128;
            int i4 = i3 % 2;
            int i5 = 0;
            while (true) {
                if ((i5 < intValue ? 'E' : '9') != 'E') {
                    return sb;
                }
                Integer num = null;
                Integer num2 = num;
                for (int i6 = 0; i6 < 3; i6++) {
                    char charAt = strArr[i6].charAt(i5);
                    if (num2 == null) {
                        int i7 = f115 + 15;
                        f112 = i7 % 128;
                        if (i7 % 2 != 0) {
                            super.hashCode();
                        }
                    } else {
                        charAt ^= num2.intValue();
                    }
                    num2 = Integer.valueOf(charAt);
                }
                sb.append(Integer.toHexString(num2.intValue()));
                i5++;
                int i8 = f115 + 67;
                f112 = i8 % 128;
                int i9 = i8 % 2;
            }
        }

        /* renamed from: ॱ reason: contains not printable characters */
        private static String m112(int i2, int i3, char c2) {
            char[] cArr = new char[i3];
            int i4 = 0;
            int i5 = f112 + 95;
            f115 = i5 % 128;
            int i6 = i5 % 2;
            while (true) {
                if ((i4 < i3 ? '2' : 11) == 11) {
                    return new String(cArr);
                }
                int i7 = f115 + 95;
                f112 = i7 % 128;
                int i8 = i7 % 2;
                cArr[i4] = (char) ((int) ((((long) f114[i2 + i4]) ^ (((long) i4) * f113)) ^ ((long) c2)));
                i4++;
            }
        }

        /* renamed from: ˋ reason: contains not printable characters */
        private String m110() {
            int i2 = f115 + 89;
            f112 = i2 % 128;
            int i3 = i2 % 2;
            try {
                String num = Integer.toString(VERSION.SDK_INT);
                String obj = this.f117.get(m112(0, 12, 0).intern()).toString();
                String obj2 = this.f117.get(m112(12, 5, 18067).intern()).toString();
                if ((obj2 == null ? '6' : 21) != 21) {
                    int i4 = f112 + 17;
                    f115 = i4 % 128;
                    obj2 = (!(i4 % 2 == 0) ? m112(17, 8, 24382) : m112(40, 36, 24382)).intern();
                }
                StringBuilder sb = new StringBuilder(obj);
                sb.reverse();
                StringBuilder r2 = m111(num, obj2, sb.toString());
                int length = r2.length();
                if (!(length <= 4)) {
                    r2.delete(4, length);
                } else {
                    while (length < 4) {
                        int i5 = f115 + 13;
                        f112 = i5 % 128;
                        int i6 = i5 % 2;
                        length++;
                        r2.append('1');
                    }
                }
                r2.insert(0, m112(25, 3, 0).intern());
                return r2.toString();
            } catch (Exception e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(m112(28, 42, 33602).intern());
                sb2.append(e2);
                AFLogger.afRDLog(sb2.toString());
                return m112(70, 7, 0).intern();
            }
        }
    }

    a() {
    }

    /* renamed from: ˊ reason: contains not printable characters */
    private static String m101(Context context, String str) {
        boolean z;
        try {
            Iterator it = ((List) PackageManager.class.getDeclaredMethod(m105(260, 24, 4370).intern(), new Class[]{Integer.TYPE}).invoke(context.getPackageManager(), new Object[]{Integer.valueOf(0)})).iterator();
            do {
                if (!(it.hasNext())) {
                    return Boolean.FALSE.toString();
                }
                int i2 = f110 + 93;
                f109 = i2 % 128;
                int i3 = i2 % 2;
                if (((ApplicationInfo) it.next()).packageName.equals(str)) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
            } while (!z);
            int i4 = f109 + 85;
            f110 = i4 % 128;
            int i5 = i4 % 2;
            return Boolean.TRUE.toString();
        } catch (IllegalAccessException e2) {
            s r11 = s.m191();
            String intern = m105(284, 24, 0).intern();
            StringBuilder sb = new StringBuilder();
            sb.append(m105(StatusLine.HTTP_PERM_REDIRECT, 47, 0).intern());
            sb.append(e2);
            r11.m201(intern, sb.toString());
        } catch (NoSuchMethodException e3) {
            s r112 = s.m191();
            String intern2 = m105(284, 24, 0).intern();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(m105(StatusLine.HTTP_PERM_REDIRECT, 47, 0).intern());
            sb2.append(e3);
            r112.m201(intern2, sb2.toString());
        } catch (InvocationTargetException e4) {
            s r113 = s.m191();
            String intern3 = m105(284, 24, 0).intern();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(m105(StatusLine.HTTP_PERM_REDIRECT, 47, 0).intern());
            sb3.append(e4);
            r113.m201(intern3, sb3.toString());
        }
    }

    /* renamed from: ˎ reason: contains not printable characters */
    private static String m102(String str) {
        int i2 = f110 + 9;
        f109 = i2 % 128;
        if (i2 % 2 != 0) {
            if ((!str.contains(m105(169, 1, 0).intern()) ? '#' : 'J') == '#') {
                return str;
            }
        } else if (!str.contains(m105(8832, 1, 0).intern())) {
            return str;
        }
        String[] split = str.split(m105(170, 2, 0).intern());
        int length = split.length;
        StringBuilder sb = new StringBuilder();
        int i3 = length - 1;
        sb.append(split[i3]);
        sb.append(m105(169, 1, 0).intern());
        int i4 = 1;
        while (true) {
            if ((i4 < i3 ? ',' : '_') != '_') {
                int i5 = f109 + 87;
                f110 = i5 % 128;
                int i6 = i5 % 2;
                sb.append(split[i4]);
                sb.append(m105(169, 1, 0).intern());
                i4++;
            } else {
                sb.append(split[0]);
                return sb.toString();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0111, code lost:
        if ((m108(m105(87, 65, 11028).intern()) ? 24 : 'E') != 'E') goto L_0x0129;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0127, code lost:
        if (m108(m105(86, 25, 11028).intern()) != false) goto L_0x0129;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x012e, code lost:
        r12 = m105(35, 1, 54779);
     */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01d9  */
    /* renamed from: ˏ reason: contains not printable characters */
    static String m104(Context context, long j2) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        sb2.append((m108(m105(0, 34, 5928).intern()) ? m105(34, 1, 0) : m105(35, 1, 54779)).intern());
        StringBuilder sb4 = new StringBuilder();
        String packageName = context.getPackageName();
        String r10 = m102(packageName);
        sb2.append(m105(34, 1, 0).intern());
        sb4.append(r10);
        if (m106(context) == null) {
            sb2.append(m105(35, 1, 54779).intern());
            sb4.append(packageName);
        } else {
            sb2.append(m105(34, 1, 0).intern());
            sb4.append(packageName);
        }
        String r102 = m103(context);
        if (r102 == null) {
            sb2.append(m105(35, 1, 54779).intern());
            sb4.append(packageName);
        } else {
            sb2.append(m105(34, 1, 0).intern());
            sb4.append(r102);
        }
        sb4.append(m101(context, packageName));
        sb.append(sb4.toString());
        try {
            long j3 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(m105(36, 18, 0).intern(), Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            sb.append(simpleDateFormat.format(new Date(j3)));
            int i2 = f109 + 61;
            f110 = i2 % 128;
            char c2 = 'W';
            if ((i2 % 2 != 0 ? 13 : 'U') != 'U') {
                sb.append(j2);
            } else {
                sb.append(j2);
            }
            String str6 = m105(34, 1, 0);
            sb3.append(str6.intern());
            if (m108(m105(111, 23, 56188).intern())) {
                str = m105(34, 1, 0).intern();
            } else {
                str = m105(35, 1, 54779).intern();
                int i3 = f109 + 87;
                f110 = i3 % 128;
                int i4 = i3 % 2;
            }
            sb3.append(str);
            if (m108(m105(134, 20, 47445).intern())) {
                int i5 = f109 + 107;
                f110 = i5 % 128;
                if (i5 % 2 != 0) {
                    str2 = m105(72, 0, 0).intern();
                    sb3.append(str2);
                    if (!m108(m105(154, 15, 0).intern())) {
                        int i6 = f109 + 107;
                        f110 = i6 % 128;
                        if (i6 % 2 == 0) {
                            c2 = 29;
                        }
                        if (c2 != 29) {
                            str3 = m105(122, 1, 0).intern();
                            sb3.append(str3);
                            String r12 = p.m178(p.m177(sb.toString()));
                            String sb5 = sb2.toString();
                            StringBuilder sb6 = new StringBuilder(r12);
                            sb6.setCharAt(17, Integer.toString(Integer.parseInt(sb5, 2), 16).charAt(0));
                            String sb7 = sb6.toString();
                            String sb8 = sb3.toString();
                            StringBuilder sb9 = new StringBuilder(sb7);
                            sb9.setCharAt(27, Integer.toString(Integer.parseInt(sb8, 2), 16).charAt(0));
                            return m107(sb9.toString(), Long.valueOf(j2));
                        }
                        str4 = m105(34, 1, 0);
                    } else {
                        str4 = m105(35, 1, 54779);
                    }
                    str3 = str4.intern();
                    sb3.append(str3);
                    String r122 = p.m178(p.m177(sb.toString()));
                    String sb52 = sb2.toString();
                    StringBuilder sb62 = new StringBuilder(r122);
                    sb62.setCharAt(17, Integer.toString(Integer.parseInt(sb52, 2), 16).charAt(0));
                    String sb72 = sb62.toString();
                    String sb82 = sb3.toString();
                    StringBuilder sb92 = new StringBuilder(sb72);
                    sb92.setCharAt(27, Integer.toString(Integer.parseInt(sb82, 2), 16).charAt(0));
                    return m107(sb92.toString(), Long.valueOf(j2));
                }
                str5 = m105(34, 1, 0);
            } else {
                str5 = m105(35, 1, 54779);
            }
            str2 = str5.intern();
            sb3.append(str2);
            if (!m108(m105(154, 15, 0).intern())) {
            }
            str3 = str4.intern();
            sb3.append(str3);
            String r1222 = p.m178(p.m177(sb.toString()));
            String sb522 = sb2.toString();
            StringBuilder sb622 = new StringBuilder(r1222);
            sb622.setCharAt(17, Integer.toString(Integer.parseInt(sb522, 2), 16).charAt(0));
            String sb722 = sb622.toString();
            String sb822 = sb3.toString();
            StringBuilder sb922 = new StringBuilder(sb722);
            sb922.setCharAt(27, Integer.toString(Integer.parseInt(sb822, 2), 16).charAt(0));
            return m107(sb922.toString(), Long.valueOf(j2));
        } catch (NameNotFoundException unused) {
            return m105(54, 32, 0).intern();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        if ((r8 != null ? '3' : '<') != '3') goto L_0x00ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        if (r8 != null) goto L_0x002a;
     */
    /* renamed from: ॱ reason: contains not printable characters */
    private static String m107(String str, Long l2) {
        long j2;
        int i2 = 0;
        if (!(str == null)) {
            int i3 = f110 + 45;
            f109 = i3 % 128;
            if (i3 % 2 == 0) {
                Object[] objArr = null;
                int length = objArr.length;
            }
            if (str.length() == 32) {
                StringBuilder sb = new StringBuilder(str);
                String l3 = l2.toString();
                long j3 = 0;
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    if (i4 >= l3.length()) {
                        break;
                    }
                    i5 += Character.getNumericValue(l3.charAt(i4));
                    i4++;
                }
                String hexString = Integer.toHexString(i5);
                sb.replace(7, hexString.length() + 7, hexString);
                int i6 = f110 + 77;
                f109 = i6 % 128;
                int i7 = i6 % 2;
                while (i2 < sb.length()) {
                    int i8 = f109 + 35;
                    f110 = i8 % 128;
                    if (i8 % 2 != 0) {
                        j3 -= (long) Character.getNumericValue(sb.charAt(i2));
                        i2 += 29;
                    } else {
                        j3 += (long) Character.getNumericValue(sb.charAt(i2));
                        i2++;
                    }
                }
                while (j3 > 100) {
                    int i9 = f109 + 89;
                    f110 = i9 % 128;
                    if (i9 % 2 != 0) {
                        j2 = j3 * 100;
                    } else {
                        j2 = j3 % 100;
                    }
                }
                sb.insert(23, (int) j3);
                if (j3 < 10) {
                    int i10 = f109 + 15;
                    f110 = i10 % 128;
                    if (i10 % 2 != 0) {
                        sb.insert(101, m105(36, 1, 54779).intern());
                    } else {
                        sb.insert(23, m105(35, 1, 54779).intern());
                    }
                }
                return sb.toString();
            }
        }
        return m105(54, 32, 0).intern();
    }

    /* renamed from: ॱ reason: contains not printable characters */
    private static boolean m108(String str) {
        int i2 = f110 + 121;
        f109 = i2 % 128;
        if (i2 % 2 == 0) {
        }
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: ॱ reason: contains not printable characters */
    private static String m106(Context context) {
        int i2 = f109 + 23;
        f110 = i2 % 128;
        int i3 = i2 % 2;
        if (!System.getProperties().containsKey(m105(172, 14, 63403).intern())) {
            return null;
        }
        int i4 = f109 + 89;
        f110 = i4 % 128;
        int i5 = i4 % 2;
        try {
            Matcher matcher = Pattern.compile(m105(192, 10, 0).intern()).matcher(context.getCacheDir().getPath().replace(m105(186, 6, 0).intern(), ""));
            if (!matcher.find()) {
                return null;
            }
            int i6 = f110 + 15;
            f109 = i6 % 128;
            return i6 % 2 == 0 ? matcher.group(0) : matcher.group(1);
        } catch (Exception e2) {
            s r0 = s.m191();
            String intern = m105(202, 17, 0).intern();
            StringBuilder sb = new StringBuilder();
            sb.append(m105(219, 41, 0).intern());
            sb.append(e2);
            r0.m201(intern, sb.toString());
            return null;
        }
    }

    /* renamed from: ॱ reason: contains not printable characters */
    private static String m105(int i2, int i3, char c2) {
        int i4 = f110 + 103;
        f109 = i4 % 128;
        int i5 = i4 % 2;
        char[] cArr = new char[i3];
        int i6 = 0;
        while (true) {
            if (!(i6 < i3)) {
                return new String(cArr);
            }
            int i7 = f110 + 61;
            f109 = i7 % 128;
            int i8 = i7 % 2;
            cArr[i6] = (char) ((int) ((((long) f111[i2 + i6]) ^ (((long) i6) * f108)) ^ ((long) c2)));
            i6++;
        }
    }

    /* renamed from: ˏ reason: contains not printable characters */
    private static String m103(Context context) {
        PackageManager packageManager;
        String packageName;
        int i2 = f110 + 37;
        f109 = i2 % 128;
        if ((i2 % 2 == 0 ? (char) 0 : 29) != 29) {
            try {
                packageManager = context.getPackageManager();
                packageName = context.getPackageName();
            } catch (NameNotFoundException unused) {
                return null;
            }
        } else {
            packageManager = context.getPackageManager();
            packageName = context.getPackageName();
        }
        String str = packageManager.getPackageInfo(packageName, 0).packageName;
        int i3 = f109 + 77;
        f110 = i3 % 128;
        if ((i3 % 2 != 0 ? '-' : 'X') != '-') {
            return str;
        }
        int i4 = 0 / 0;
        return str;
    }
}
