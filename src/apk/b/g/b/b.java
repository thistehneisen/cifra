package b.g.b;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

/* compiled from: PathParser */
public class b {

    /* compiled from: PathParser */
    private static class a {

        /* renamed from: a reason: collision with root package name */
        int f2496a;

        /* renamed from: b reason: collision with root package name */
        boolean f2497b;

        a() {
        }
    }

    /* renamed from: b.g.b.b$b reason: collision with other inner class name */
    /* compiled from: PathParser */
    public static class C0022b {

        /* renamed from: a reason: collision with root package name */
        public char f2498a;

        /* renamed from: b reason: collision with root package name */
        public float[] f2499b;

        C0022b(char c2, float[] fArr) {
            this.f2498a = c2;
            this.f2499b = fArr;
        }

        public static void a(C0022b[] bVarArr, Path path) {
            float[] fArr = new float[6];
            char c2 = 'm';
            for (int i2 = 0; i2 < bVarArr.length; i2++) {
                a(path, fArr, c2, bVarArr[i2].f2498a, bVarArr[i2].f2499b);
                c2 = bVarArr[i2].f2498a;
            }
        }

        C0022b(C0022b bVar) {
            this.f2498a = bVar.f2498a;
            float[] fArr = bVar.f2499b;
            this.f2499b = b.a(fArr, 0, fArr.length);
        }

        public void a(C0022b bVar, C0022b bVar2, float f2) {
            this.f2498a = bVar.f2498a;
            int i2 = 0;
            while (true) {
                float[] fArr = bVar.f2499b;
                if (i2 < fArr.length) {
                    this.f2499b[i2] = (fArr[i2] * (1.0f - f2)) + (bVar2.f2499b[i2] * f2);
                    i2++;
                } else {
                    return;
                }
            }
        }

        private static void a(Path path, float[] fArr, char c2, char c3, float[] fArr2) {
            int i2;
            int i3;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11;
            Path path2 = path;
            char c4 = c3;
            float[] fArr3 = fArr2;
            float f12 = fArr[0];
            float f13 = fArr[1];
            float f14 = fArr[2];
            float f15 = fArr[3];
            float f16 = fArr[4];
            float f17 = fArr[5];
            switch (c4) {
                case 'A':
                case 'a':
                    i2 = 7;
                    break;
                case 'C':
                case 'c':
                    i2 = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i2 = 1;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i2 = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path2.moveTo(f16, f17);
                    f12 = f16;
                    f14 = f12;
                    f13 = f17;
                    f15 = f13;
                    break;
            }
            i2 = 2;
            float f18 = f12;
            float f19 = f13;
            float f20 = f16;
            float f21 = f17;
            int i4 = 0;
            char c5 = c2;
            while (i4 < fArr3.length) {
                if (c4 != 'A') {
                    if (c4 == 'C') {
                        i3 = i4;
                        int i5 = i3 + 2;
                        int i6 = i3 + 3;
                        int i7 = i3 + 4;
                        int i8 = i3 + 5;
                        path.cubicTo(fArr3[i3 + 0], fArr3[i3 + 1], fArr3[i5], fArr3[i6], fArr3[i7], fArr3[i8]);
                        f18 = fArr3[i7];
                        float f22 = fArr3[i8];
                        float f23 = fArr3[i5];
                        float f24 = fArr3[i6];
                        f19 = f22;
                        f15 = f24;
                        f14 = f23;
                    } else if (c4 == 'H') {
                        i3 = i4;
                        int i9 = i3 + 0;
                        path2.lineTo(fArr3[i9], f19);
                        f18 = fArr3[i9];
                    } else if (c4 == 'Q') {
                        i3 = i4;
                        int i10 = i3 + 0;
                        int i11 = i3 + 1;
                        int i12 = i3 + 2;
                        int i13 = i3 + 3;
                        path2.quadTo(fArr3[i10], fArr3[i11], fArr3[i12], fArr3[i13]);
                        float f25 = fArr3[i10];
                        float f26 = fArr3[i11];
                        f18 = fArr3[i12];
                        f19 = fArr3[i13];
                        f14 = f25;
                        f15 = f26;
                    } else if (c4 == 'V') {
                        i3 = i4;
                        int i14 = i3 + 0;
                        path2.lineTo(f18, fArr3[i14]);
                        f19 = fArr3[i14];
                    } else if (c4 != 'a') {
                        if (c4 == 'c') {
                            int i15 = i4 + 2;
                            int i16 = i4 + 3;
                            int i17 = i4 + 4;
                            int i18 = i4 + 5;
                            path.rCubicTo(fArr3[i4 + 0], fArr3[i4 + 1], fArr3[i15], fArr3[i16], fArr3[i17], fArr3[i18]);
                            f5 = fArr3[i15] + f18;
                            f4 = fArr3[i16] + f19;
                            f18 += fArr3[i17];
                            f6 = fArr3[i18];
                            f19 += f6;
                            f14 = f5;
                            f15 = f4;
                        } else if (c4 != 'h') {
                            if (c4 != 'q') {
                                if (c4 == 'v') {
                                    int i19 = i4 + 0;
                                    path2.rLineTo(0.0f, fArr3[i19]);
                                    f7 = fArr3[i19];
                                } else if (c4 != 'L') {
                                    if (c4 == 'M') {
                                        int i20 = i4 + 0;
                                        f18 = fArr3[i20];
                                        int i21 = i4 + 1;
                                        f19 = fArr3[i21];
                                        if (i4 > 0) {
                                            path2.lineTo(fArr3[i20], fArr3[i21]);
                                        } else {
                                            path2.moveTo(fArr3[i20], fArr3[i21]);
                                        }
                                    } else if (c4 == 'S') {
                                        if (c5 == 'c' || c5 == 's' || c5 == 'C' || c5 == 'S') {
                                            f18 = (f18 * 2.0f) - f14;
                                            f19 = (f19 * 2.0f) - f15;
                                        }
                                        float f27 = f19;
                                        int i22 = i4 + 0;
                                        int i23 = i4 + 1;
                                        int i24 = i4 + 2;
                                        int i25 = i4 + 3;
                                        path.cubicTo(f18, f27, fArr3[i22], fArr3[i23], fArr3[i24], fArr3[i25]);
                                        f5 = fArr3[i22];
                                        f4 = fArr3[i23];
                                        f18 = fArr3[i24];
                                        f19 = fArr3[i25];
                                        f14 = f5;
                                        f15 = f4;
                                    } else if (c4 == 'T') {
                                        if (c5 == 'q' || c5 == 't' || c5 == 'Q' || c5 == 'T') {
                                            f18 = (f18 * 2.0f) - f14;
                                            f19 = (f19 * 2.0f) - f15;
                                        }
                                        int i26 = i4 + 0;
                                        int i27 = i4 + 1;
                                        path2.quadTo(f18, f19, fArr3[i26], fArr3[i27]);
                                        float f28 = fArr3[i26];
                                        float f29 = fArr3[i27];
                                        f15 = f19;
                                        f14 = f18;
                                        i3 = i4;
                                        f18 = f28;
                                        f19 = f29;
                                    } else if (c4 == 'l') {
                                        int i28 = i4 + 0;
                                        int i29 = i4 + 1;
                                        path2.rLineTo(fArr3[i28], fArr3[i29]);
                                        f18 += fArr3[i28];
                                        f7 = fArr3[i29];
                                    } else if (c4 == 'm') {
                                        int i30 = i4 + 0;
                                        f18 += fArr3[i30];
                                        int i31 = i4 + 1;
                                        f19 += fArr3[i31];
                                        if (i4 > 0) {
                                            path2.rLineTo(fArr3[i30], fArr3[i31]);
                                        } else {
                                            path2.rMoveTo(fArr3[i30], fArr3[i31]);
                                        }
                                    } else if (c4 == 's') {
                                        if (c5 == 'c' || c5 == 's' || c5 == 'C' || c5 == 'S') {
                                            float f30 = f18 - f14;
                                            f8 = f19 - f15;
                                            f9 = f30;
                                        } else {
                                            f9 = 0.0f;
                                            f8 = 0.0f;
                                        }
                                        int i32 = i4 + 0;
                                        int i33 = i4 + 1;
                                        int i34 = i4 + 2;
                                        int i35 = i4 + 3;
                                        path.rCubicTo(f9, f8, fArr3[i32], fArr3[i33], fArr3[i34], fArr3[i35]);
                                        f5 = fArr3[i32] + f18;
                                        f4 = fArr3[i33] + f19;
                                        f18 += fArr3[i34];
                                        f6 = fArr3[i35];
                                    } else if (c4 == 't') {
                                        if (c5 == 'q' || c5 == 't' || c5 == 'Q' || c5 == 'T') {
                                            f10 = f18 - f14;
                                            f11 = f19 - f15;
                                        } else {
                                            f11 = 0.0f;
                                            f10 = 0.0f;
                                        }
                                        int i36 = i4 + 0;
                                        int i37 = i4 + 1;
                                        path2.rQuadTo(f10, f11, fArr3[i36], fArr3[i37]);
                                        float f31 = f10 + f18;
                                        float f32 = f11 + f19;
                                        f18 += fArr3[i36];
                                        f19 += fArr3[i37];
                                        f15 = f32;
                                        f14 = f31;
                                    }
                                    f21 = f19;
                                    f20 = f18;
                                } else {
                                    int i38 = i4 + 0;
                                    int i39 = i4 + 1;
                                    path2.lineTo(fArr3[i38], fArr3[i39]);
                                    f18 = fArr3[i38];
                                    f19 = fArr3[i39];
                                }
                                f19 += f7;
                            } else {
                                int i40 = i4 + 0;
                                int i41 = i4 + 1;
                                int i42 = i4 + 2;
                                int i43 = i4 + 3;
                                path2.rQuadTo(fArr3[i40], fArr3[i41], fArr3[i42], fArr3[i43]);
                                f5 = fArr3[i40] + f18;
                                f4 = fArr3[i41] + f19;
                                f18 += fArr3[i42];
                                f6 = fArr3[i43];
                            }
                            f19 += f6;
                            f14 = f5;
                            f15 = f4;
                        } else {
                            int i44 = i4 + 0;
                            path2.rLineTo(fArr3[i44], 0.0f);
                            f18 += fArr3[i44];
                        }
                        i3 = i4;
                    } else {
                        int i45 = i4 + 5;
                        float f33 = fArr3[i45] + f18;
                        int i46 = i4 + 6;
                        float f34 = fArr3[i46] + f19;
                        float f35 = fArr3[i4 + 0];
                        float f36 = fArr3[i4 + 1];
                        float f37 = f19;
                        float f38 = f18;
                        i3 = i4;
                        a(path, f18, f19, f33, f34, f35, f36, fArr3[i4 + 2], fArr3[i4 + 3] != 0.0f, fArr3[i4 + 4] != 0.0f);
                        f2 = f38 + fArr3[i45];
                        f3 = f37 + fArr3[i46];
                    }
                    i4 = i3 + i2;
                    c5 = c3;
                    c4 = c5;
                } else {
                    i3 = i4;
                    int i47 = i3 + 5;
                    int i48 = i3 + 6;
                    a(path, f18, f19, fArr3[i47], fArr3[i48], fArr3[i3 + 0], fArr3[i3 + 1], fArr3[i3 + 2], fArr3[i3 + 3] != 0.0f, fArr3[i3 + 4] != 0.0f);
                    f2 = fArr3[i47];
                    f3 = fArr3[i48];
                }
                f15 = f19;
                f14 = f18;
                i4 = i3 + i2;
                c5 = c3;
                c4 = c5;
            }
            float f39 = f19;
            fArr[0] = f18;
            fArr[1] = f39;
            fArr[2] = f14;
            fArr[3] = f15;
            fArr[4] = f20;
            fArr[5] = f21;
        }

        private static void a(Path path, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean z, boolean z2) {
            double d2;
            double d3;
            float f9 = f2;
            float f10 = f4;
            float f11 = f6;
            float f12 = f7;
            boolean z3 = z2;
            double radians = Math.toRadians((double) f8);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d4 = (double) f9;
            double d5 = d4 * cos;
            double d6 = d4;
            double d7 = (double) f3;
            double d8 = (double) f11;
            double d9 = (d5 + (d7 * sin)) / d8;
            double d10 = (((double) (-f9)) * sin) + (d7 * cos);
            double d11 = d7;
            double d12 = (double) f12;
            double d13 = d10 / d12;
            double d14 = (double) f5;
            double d15 = ((((double) f10) * cos) + (d14 * sin)) / d8;
            double d16 = d8;
            double d17 = ((((double) (-f10)) * sin) + (d14 * cos)) / d12;
            double d18 = d9 - d15;
            double d19 = d13 - d17;
            double d20 = (d9 + d15) / 2.0d;
            double d21 = (d13 + d17) / 2.0d;
            double d22 = sin;
            double d23 = (d18 * d18) + (d19 * d19);
            String str = "PathParser";
            if (d23 == 0.0d) {
                Log.w(str, " Points are coincident");
                return;
            }
            double d24 = (1.0d / d23) - 0.25d;
            if (d24 < 0.0d) {
                StringBuilder sb = new StringBuilder();
                sb.append("Points are too far apart ");
                sb.append(d23);
                Log.w(str, sb.toString());
                float sqrt = (float) (Math.sqrt(d23) / 1.99999d);
                a(path, f2, f3, f4, f5, f11 * sqrt, f7 * sqrt, f8, z, z2);
                return;
            }
            double sqrt2 = Math.sqrt(d24);
            double d25 = d18 * sqrt2;
            double d26 = sqrt2 * d19;
            boolean z4 = z2;
            if (z == z4) {
                d3 = d20 - d26;
                d2 = d21 + d25;
            } else {
                d3 = d20 + d26;
                d2 = d21 - d25;
            }
            double atan2 = Math.atan2(d13 - d2, d9 - d3);
            double atan22 = Math.atan2(d17 - d2, d15 - d3) - atan2;
            int i2 = (atan22 > 0.0d ? 1 : (atan22 == 0.0d ? 0 : -1));
            if (z4 != (i2 >= 0)) {
                atan22 = i2 > 0 ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            double d27 = d3 * d16;
            double d28 = d2 * d12;
            a(path, (d27 * cos) - (d28 * d22), (d27 * d22) + (d28 * cos), d16, d12, d6, d11, radians, atan2, atan22);
        }

        private static void a(Path path, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
            double d11 = d4;
            int ceil = (int) Math.ceil(Math.abs((d10 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d8);
            double sin = Math.sin(d8);
            double cos2 = Math.cos(d9);
            double sin2 = Math.sin(d9);
            double d12 = -d11;
            double d13 = d12 * cos;
            double d14 = d5 * sin;
            double d15 = (d13 * sin2) - (d14 * cos2);
            double d16 = d12 * sin;
            double d17 = d5 * cos;
            double d18 = (sin2 * d16) + (cos2 * d17);
            double d19 = d10 / ((double) ceil);
            double d20 = d6;
            double d21 = d7;
            double d22 = d18;
            double d23 = d15;
            int i2 = 0;
            double d24 = d9;
            while (i2 < ceil) {
                double d25 = d24 + d19;
                double sin3 = Math.sin(d25);
                double cos3 = Math.cos(d25);
                double d26 = (d2 + ((d11 * cos) * cos3)) - (d14 * sin3);
                double d27 = d3 + (d11 * sin * cos3) + (d17 * sin3);
                double d28 = (d13 * sin3) - (d14 * cos3);
                double d29 = (sin3 * d16) + (cos3 * d17);
                double d30 = d25 - d24;
                double tan = Math.tan(d30 / 2.0d);
                double sin4 = (Math.sin(d30) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                int i3 = ceil;
                double d31 = cos;
                double d32 = d20 + (d23 * sin4);
                double d33 = sin;
                double d34 = d21 + (d22 * sin4);
                double d35 = d19;
                double d36 = d26 - (sin4 * d28);
                int i4 = i3;
                double d37 = d16;
                double d38 = d27 - (sin4 * d29);
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) d32, (float) d34, (float) d36, (float) d38, (float) d26, (float) d27);
                i2++;
                d19 = d35;
                ceil = i4;
                sin = d33;
                d21 = d27;
                d16 = d37;
                d24 = d25;
                d22 = d29;
                d23 = d28;
                cos = d31;
                d11 = d4;
                d20 = d26;
            }
        }
    }

    static float[] a(float[] fArr, int i2, int i3) {
        if (i2 <= i3) {
            int length = fArr.length;
            if (i2 < 0 || i2 > length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i4 = i3 - i2;
            int min = Math.min(i4, length - i2);
            float[] fArr2 = new float[i4];
            System.arraycopy(fArr, i2, fArr2, 0, min);
            return fArr2;
        }
        throw new IllegalArgumentException();
    }

    public static Path b(String str) {
        Path path = new Path();
        C0022b[] a2 = a(str);
        if (a2 == null) {
            return null;
        }
        try {
            C0022b.a(a2, path);
            return path;
        } catch (RuntimeException e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error in parsing ");
            sb.append(str);
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    private static float[] c(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            a aVar = new a();
            int length = str.length();
            int i2 = 1;
            int i3 = 0;
            while (i2 < length) {
                a(str, i2, aVar);
                int i4 = aVar.f2496a;
                if (i2 < i4) {
                    int i5 = i3 + 1;
                    fArr[i3] = Float.parseFloat(str.substring(i2, i4));
                    i3 = i5;
                }
                i2 = aVar.f2497b ? i4 : i4 + 1;
            }
            return a(fArr, 0, i3);
        } catch (NumberFormatException e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("error in parsing \"");
            sb.append(str);
            sb.append("\"");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    public static void b(C0022b[] bVarArr, C0022b[] bVarArr2) {
        for (int i2 = 0; i2 < bVarArr2.length; i2++) {
            bVarArr[i2].f2498a = bVarArr2[i2].f2498a;
            for (int i3 = 0; i3 < bVarArr2[i2].f2499b.length; i3++) {
                bVarArr[i2].f2499b[i3] = bVarArr2[i2].f2499b[i3];
            }
        }
    }

    public static C0022b[] a(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        int i3 = 0;
        while (i2 < str.length()) {
            int a2 = a(str, i2);
            String trim = str.substring(i3, a2).trim();
            if (trim.length() > 0) {
                a(arrayList, trim.charAt(0), c(trim));
            }
            i3 = a2;
            i2 = a2 + 1;
        }
        if (i2 - i3 == 1 && i3 < str.length()) {
            a(arrayList, str.charAt(i3), new float[0]);
        }
        return (C0022b[]) arrayList.toArray(new C0022b[arrayList.size()]);
    }

    public static C0022b[] a(C0022b[] bVarArr) {
        if (bVarArr == null) {
            return null;
        }
        C0022b[] bVarArr2 = new C0022b[bVarArr.length];
        for (int i2 = 0; i2 < bVarArr.length; i2++) {
            bVarArr2[i2] = new C0022b(bVarArr[i2]);
        }
        return bVarArr2;
    }

    public static boolean a(C0022b[] bVarArr, C0022b[] bVarArr2) {
        if (bVarArr == null || bVarArr2 == null || bVarArr.length != bVarArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < bVarArr.length; i2++) {
            if (bVarArr[i2].f2498a != bVarArr2[i2].f2498a || bVarArr[i2].f2499b.length != bVarArr2[i2].f2499b.length) {
                return false;
            }
        }
        return true;
    }

    private static int a(String str, int i2) {
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i2;
            }
            i2++;
        }
        return i2;
    }

    private static void a(ArrayList<C0022b> arrayList, char c2, float[] fArr) {
        arrayList.add(new C0022b(c2, fArr));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
        r2 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003a A[LOOP:0: B:1:0x0007->B:20:0x003a, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003d A[SYNTHETIC] */
    private static void a(String str, int i2, a aVar) {
        aVar.f2497b = false;
        int i3 = i2;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (i3 < str.length()) {
            char charAt = str.charAt(i3);
            if (charAt != ' ') {
                if (charAt == 'E' || charAt == 'e') {
                    z = true;
                    if (!z3) {
                        aVar.f2496a = i3;
                    }
                    i3++;
                } else {
                    switch (charAt) {
                        case ',':
                            break;
                        case '-':
                            if (i3 != i2 && !z) {
                                aVar.f2497b = true;
                            }
                        case '.':
                            if (!z2) {
                                z = false;
                                z2 = true;
                                break;
                            } else {
                                aVar.f2497b = true;
                            }
                    }
                }
            }
            z = false;
            z3 = true;
            if (!z3) {
            }
        }
        aVar.f2496a = i3;
    }
}
