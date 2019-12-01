package androidx.constraintlayout.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import b.e.b.a.f.b;
import b.e.b.a.f.c;
import b.e.b.a.h;
import b.e.b.a.i;
import b.e.b.a.l;
import b.e.b.a.q;
import b.e.b.f;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintLayout extends ViewGroup {

    /* renamed from: a reason: collision with root package name */
    SparseArray<View> f1122a = new SparseArray<>();

    /* renamed from: b reason: collision with root package name */
    private ArrayList<c> f1123b = new ArrayList<>(4);

    /* renamed from: c reason: collision with root package name */
    private final ArrayList<h> f1124c = new ArrayList<>(100);

    /* renamed from: d reason: collision with root package name */
    i f1125d = new i();

    /* renamed from: e reason: collision with root package name */
    private int f1126e = 0;

    /* renamed from: f reason: collision with root package name */
    private int f1127f = 0;

    /* renamed from: g reason: collision with root package name */
    private int f1128g = Integer.MAX_VALUE;

    /* renamed from: h reason: collision with root package name */
    private int f1129h = Integer.MAX_VALUE;

    /* renamed from: i reason: collision with root package name */
    private boolean f1130i = true;

    /* renamed from: j reason: collision with root package name */
    private int f1131j = 3;

    /* renamed from: k reason: collision with root package name */
    private f f1132k = null;

    /* renamed from: l reason: collision with root package name */
    protected e f1133l = null;
    /* access modifiers changed from: private */
    public int m = -1;
    private HashMap<String, Integer> n = new HashMap<>();
    private int o = -1;
    private int p = -1;
    int q = -1;
    int r = -1;
    int s = 0;
    int t = 0;
    private h u;
    private f v;
    Handler w = new d(this, Looper.getMainLooper());

    public static class a extends MarginLayoutParams {
        public float A = 0.5f;
        public String B = null;
        float C = 0.0f;
        int D = 1;
        public float E = -1.0f;
        public float F = -1.0f;
        public int G = 0;
        public int H = 0;
        public int I = 0;
        public int J = 0;
        public int K = 0;
        public int L = 0;
        public int M = 0;
        public int N = 0;
        public float O = 1.0f;
        public float P = 1.0f;
        public int Q = -1;
        public int R = -1;
        public int S = -1;
        public boolean T = false;
        public boolean U = false;
        boolean V = true;
        boolean W = true;
        boolean X = false;
        boolean Y = false;
        boolean Z = false;

        /* renamed from: a reason: collision with root package name */
        public int f1134a = -1;
        boolean aa = false;

        /* renamed from: b reason: collision with root package name */
        public int f1135b = -1;
        boolean ba = false;

        /* renamed from: c reason: collision with root package name */
        public float f1136c = -1.0f;
        int ca = -1;

        /* renamed from: d reason: collision with root package name */
        public int f1137d = -1;
        int da = -1;

        /* renamed from: e reason: collision with root package name */
        public int f1138e = -1;
        int ea = -1;

        /* renamed from: f reason: collision with root package name */
        public int f1139f = -1;
        int fa = -1;

        /* renamed from: g reason: collision with root package name */
        public int f1140g = -1;
        int ga = -1;

        /* renamed from: h reason: collision with root package name */
        public int f1141h = -1;
        int ha = -1;

        /* renamed from: i reason: collision with root package name */
        public int f1142i = -1;
        float ia = 0.5f;

        /* renamed from: j reason: collision with root package name */
        public int f1143j = -1;
        int ja;

        /* renamed from: k reason: collision with root package name */
        public int f1144k = -1;
        int ka;

        /* renamed from: l reason: collision with root package name */
        public int f1145l = -1;
        float la;
        public int m = -1;
        h ma = new h();
        public int n = 0;
        public boolean na = false;
        public float o = 0.0f;
        public int p = -1;
        public int q = -1;
        public int r = -1;
        public int s = -1;
        public int t = -1;
        public int u = -1;
        public int v = -1;
        public int w = -1;
        public int x = -1;
        public int y = -1;
        public float z = 0.5f;

        /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$a$a reason: collision with other inner class name */
        private static class C0008a {

            /* renamed from: a reason: collision with root package name */
            public static final SparseIntArray f1146a = new SparseIntArray();

            static {
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintCircle, 2);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                f1146a.append(l.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                f1146a.append(l.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                f1146a.append(l.ConstraintLayout_Layout_android_orientation, 1);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                f1146a.append(l.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                f1146a.append(l.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                f1146a.append(l.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                f1146a.append(l.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                f1146a.append(l.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                f1146a.append(l.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                f1146a.append(l.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                f1146a.append(l.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                f1146a.append(l.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
            }
        }

        public a(Context context, AttributeSet attributeSet) {
            int i2;
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                String str = "ConstraintLayout";
                switch (C0008a.f1146a.get(index)) {
                    case 1:
                        this.S = obtainStyledAttributes.getInt(index, this.S);
                        break;
                    case 2:
                        this.m = obtainStyledAttributes.getResourceId(index, this.m);
                        if (this.m != -1) {
                            break;
                        } else {
                            this.m = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 3:
                        this.n = obtainStyledAttributes.getDimensionPixelSize(index, this.n);
                        break;
                    case 4:
                        this.o = obtainStyledAttributes.getFloat(index, this.o) % 360.0f;
                        float f2 = this.o;
                        if (f2 >= 0.0f) {
                            break;
                        } else {
                            this.o = (360.0f - f2) % 360.0f;
                            break;
                        }
                    case 5:
                        this.f1134a = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1134a);
                        break;
                    case 6:
                        this.f1135b = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1135b);
                        break;
                    case 7:
                        this.f1136c = obtainStyledAttributes.getFloat(index, this.f1136c);
                        break;
                    case 8:
                        this.f1137d = obtainStyledAttributes.getResourceId(index, this.f1137d);
                        if (this.f1137d != -1) {
                            break;
                        } else {
                            this.f1137d = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 9:
                        this.f1138e = obtainStyledAttributes.getResourceId(index, this.f1138e);
                        if (this.f1138e != -1) {
                            break;
                        } else {
                            this.f1138e = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 10:
                        this.f1139f = obtainStyledAttributes.getResourceId(index, this.f1139f);
                        if (this.f1139f != -1) {
                            break;
                        } else {
                            this.f1139f = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 11:
                        this.f1140g = obtainStyledAttributes.getResourceId(index, this.f1140g);
                        if (this.f1140g != -1) {
                            break;
                        } else {
                            this.f1140g = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 12:
                        this.f1141h = obtainStyledAttributes.getResourceId(index, this.f1141h);
                        if (this.f1141h != -1) {
                            break;
                        } else {
                            this.f1141h = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 13:
                        this.f1142i = obtainStyledAttributes.getResourceId(index, this.f1142i);
                        if (this.f1142i != -1) {
                            break;
                        } else {
                            this.f1142i = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 14:
                        this.f1143j = obtainStyledAttributes.getResourceId(index, this.f1143j);
                        if (this.f1143j != -1) {
                            break;
                        } else {
                            this.f1143j = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 15:
                        this.f1144k = obtainStyledAttributes.getResourceId(index, this.f1144k);
                        if (this.f1144k != -1) {
                            break;
                        } else {
                            this.f1144k = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 16:
                        this.f1145l = obtainStyledAttributes.getResourceId(index, this.f1145l);
                        if (this.f1145l != -1) {
                            break;
                        } else {
                            this.f1145l = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 17:
                        this.p = obtainStyledAttributes.getResourceId(index, this.p);
                        if (this.p != -1) {
                            break;
                        } else {
                            this.p = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 18:
                        this.q = obtainStyledAttributes.getResourceId(index, this.q);
                        if (this.q != -1) {
                            break;
                        } else {
                            this.q = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 19:
                        this.r = obtainStyledAttributes.getResourceId(index, this.r);
                        if (this.r != -1) {
                            break;
                        } else {
                            this.r = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 20:
                        this.s = obtainStyledAttributes.getResourceId(index, this.s);
                        if (this.s != -1) {
                            break;
                        } else {
                            this.s = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 21:
                        this.t = obtainStyledAttributes.getDimensionPixelSize(index, this.t);
                        break;
                    case 22:
                        this.u = obtainStyledAttributes.getDimensionPixelSize(index, this.u);
                        break;
                    case 23:
                        this.v = obtainStyledAttributes.getDimensionPixelSize(index, this.v);
                        break;
                    case 24:
                        this.w = obtainStyledAttributes.getDimensionPixelSize(index, this.w);
                        break;
                    case 25:
                        this.x = obtainStyledAttributes.getDimensionPixelSize(index, this.x);
                        break;
                    case 26:
                        this.y = obtainStyledAttributes.getDimensionPixelSize(index, this.y);
                        break;
                    case 27:
                        this.T = obtainStyledAttributes.getBoolean(index, this.T);
                        break;
                    case 28:
                        this.U = obtainStyledAttributes.getBoolean(index, this.U);
                        break;
                    case 29:
                        this.z = obtainStyledAttributes.getFloat(index, this.z);
                        break;
                    case 30:
                        this.A = obtainStyledAttributes.getFloat(index, this.A);
                        break;
                    case 31:
                        this.I = obtainStyledAttributes.getInt(index, 0);
                        if (this.I != 1) {
                            break;
                        } else {
                            Log.e(str, "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        }
                    case 32:
                        this.J = obtainStyledAttributes.getInt(index, 0);
                        if (this.J != 1) {
                            break;
                        } else {
                            Log.e(str, "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        }
                    case 33:
                        try {
                            this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.K) != -2) {
                                break;
                            } else {
                                this.K = -2;
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.M) != -2) {
                                break;
                            } else {
                                this.M = -2;
                                break;
                            }
                        }
                    case 35:
                        this.O = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.O));
                        break;
                    case 36:
                        try {
                            this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.L) != -2) {
                                break;
                            } else {
                                this.L = -2;
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.N) != -2) {
                                break;
                            } else {
                                this.N = -2;
                                break;
                            }
                        }
                    case 38:
                        this.P = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.P));
                        break;
                    case 44:
                        this.B = obtainStyledAttributes.getString(index);
                        this.C = Float.NaN;
                        this.D = -1;
                        String str2 = this.B;
                        if (str2 == null) {
                            break;
                        } else {
                            int length = str2.length();
                            int indexOf = this.B.indexOf(44);
                            if (indexOf <= 0 || indexOf >= length - 1) {
                                i2 = 0;
                            } else {
                                String substring = this.B.substring(0, indexOf);
                                if (substring.equalsIgnoreCase("W")) {
                                    this.D = 0;
                                } else if (substring.equalsIgnoreCase("H")) {
                                    this.D = 1;
                                }
                                i2 = indexOf + 1;
                            }
                            int indexOf2 = this.B.indexOf(58);
                            if (indexOf2 >= 0 && indexOf2 < length - 1) {
                                String substring2 = this.B.substring(i2, indexOf2);
                                String substring3 = this.B.substring(indexOf2 + 1);
                                if (substring2.length() > 0 && substring3.length() > 0) {
                                    try {
                                        float parseFloat = Float.parseFloat(substring2);
                                        float parseFloat2 = Float.parseFloat(substring3);
                                        if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                            if (this.D != 1) {
                                                this.C = Math.abs(parseFloat / parseFloat2);
                                                break;
                                            } else {
                                                this.C = Math.abs(parseFloat2 / parseFloat);
                                                break;
                                            }
                                        }
                                    } catch (NumberFormatException unused5) {
                                        break;
                                    }
                                }
                            } else {
                                String substring4 = this.B.substring(i2);
                                if (substring4.length() <= 0) {
                                    break;
                                } else {
                                    this.C = Float.parseFloat(substring4);
                                    break;
                                }
                            }
                        }
                        break;
                    case 45:
                        this.E = obtainStyledAttributes.getFloat(index, this.E);
                        break;
                    case 46:
                        this.F = obtainStyledAttributes.getFloat(index, this.F);
                        break;
                    case 47:
                        this.G = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 48:
                        this.H = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 49:
                        this.Q = obtainStyledAttributes.getDimensionPixelOffset(index, this.Q);
                        break;
                    case 50:
                        this.R = obtainStyledAttributes.getDimensionPixelOffset(index, this.R);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
            a();
        }

        public void a() {
            this.Y = false;
            this.V = true;
            this.W = true;
            if (this.width == -2 && this.T) {
                this.V = false;
                this.I = 1;
            }
            if (this.height == -2 && this.U) {
                this.W = false;
                this.J = 1;
            }
            if (this.width == 0 || this.width == -1) {
                this.V = false;
                if (this.width == 0 && this.I == 1) {
                    this.width = -2;
                    this.T = true;
                }
            }
            if (this.height == 0 || this.height == -1) {
                this.W = false;
                if (this.height == 0 && this.J == 1) {
                    this.height = -2;
                    this.U = true;
                }
            }
            if (this.f1136c != -1.0f || this.f1134a != -1 || this.f1135b != -1) {
                this.Y = true;
                this.V = true;
                this.W = true;
                if (!(this.ma instanceof l)) {
                    this.ma = new l();
                }
                ((l) this.ma).r(this.S);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x004c  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0053  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x005a  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0060  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0066  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x007c  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0084  */
        @TargetApi(17)
        public void resolveLayoutDirection(int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            float f2;
            int i7 = this.leftMargin;
            int i8 = this.rightMargin;
            super.resolveLayoutDirection(i2);
            this.ea = -1;
            this.fa = -1;
            this.ca = -1;
            this.da = -1;
            this.ga = -1;
            this.ha = -1;
            this.ga = this.t;
            this.ha = this.v;
            this.ia = this.z;
            this.ja = this.f1134a;
            this.ka = this.f1135b;
            this.la = this.f1136c;
            boolean z2 = false;
            if (1 == getLayoutDirection()) {
                int i9 = this.p;
                if (i9 != -1) {
                    this.ea = i9;
                } else {
                    int i10 = this.q;
                    if (i10 != -1) {
                        this.fa = i10;
                    }
                    i3 = this.r;
                    if (i3 != -1) {
                        this.da = i3;
                        z2 = true;
                    }
                    i4 = this.s;
                    if (i4 != -1) {
                        this.ca = i4;
                        z2 = true;
                    }
                    i5 = this.x;
                    if (i5 != -1) {
                        this.ha = i5;
                    }
                    i6 = this.y;
                    if (i6 != -1) {
                        this.ga = i6;
                    }
                    if (z2) {
                        this.ia = 1.0f - this.z;
                    }
                    if (this.Y && this.S == 1) {
                        f2 = this.f1136c;
                        if (f2 == -1.0f) {
                            this.la = 1.0f - f2;
                            this.ja = -1;
                            this.ka = -1;
                        } else {
                            int i11 = this.f1134a;
                            if (i11 != -1) {
                                this.ka = i11;
                                this.ja = -1;
                                this.la = -1.0f;
                            } else {
                                int i12 = this.f1135b;
                                if (i12 != -1) {
                                    this.ja = i12;
                                    this.ka = -1;
                                    this.la = -1.0f;
                                }
                            }
                        }
                    }
                }
                z2 = true;
                i3 = this.r;
                if (i3 != -1) {
                }
                i4 = this.s;
                if (i4 != -1) {
                }
                i5 = this.x;
                if (i5 != -1) {
                }
                i6 = this.y;
                if (i6 != -1) {
                }
                if (z2) {
                }
                f2 = this.f1136c;
                if (f2 == -1.0f) {
                }
            } else {
                int i13 = this.p;
                if (i13 != -1) {
                    this.da = i13;
                }
                int i14 = this.q;
                if (i14 != -1) {
                    this.ca = i14;
                }
                int i15 = this.r;
                if (i15 != -1) {
                    this.ea = i15;
                }
                int i16 = this.s;
                if (i16 != -1) {
                    this.fa = i16;
                }
                int i17 = this.x;
                if (i17 != -1) {
                    this.ga = i17;
                }
                int i18 = this.y;
                if (i18 != -1) {
                    this.ha = i18;
                }
            }
            if (this.r == -1 && this.s == -1 && this.q == -1 && this.p == -1) {
                int i19 = this.f1139f;
                if (i19 != -1) {
                    this.ea = i19;
                    if (this.rightMargin <= 0 && i8 > 0) {
                        this.rightMargin = i8;
                    }
                } else {
                    int i20 = this.f1140g;
                    if (i20 != -1) {
                        this.fa = i20;
                        if (this.rightMargin <= 0 && i8 > 0) {
                            this.rightMargin = i8;
                        }
                    }
                }
                int i21 = this.f1137d;
                if (i21 != -1) {
                    this.ca = i21;
                    if (this.leftMargin <= 0 && i7 > 0) {
                        this.leftMargin = i7;
                        return;
                    }
                    return;
                }
                int i22 = this.f1138e;
                if (i22 != -1) {
                    this.da = i22;
                    if (this.leftMargin <= 0 && i7 > 0) {
                        this.leftMargin = i7;
                    }
                }
            }
        }

        public a(int i2, int i3) {
            super(i2, i3);
        }

        public a(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ConstraintLayout(Context context) {
        super(context);
        a((AttributeSet) null);
    }

    private void b() {
        int childCount = getChildCount();
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            } else if (getChildAt(i2).isLayoutRequested()) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            this.f1124c.clear();
            a();
        }
    }

    private void c() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof j) {
                ((j) childAt).a(this);
            }
        }
        int size = this.f1123b.size();
        if (size > 0) {
            for (int i3 = 0; i3 < size; i3++) {
                ((c) this.f1123b.get(i3)).b(this);
            }
        }
    }

    public void addView(View view, int i2, LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        if (VERSION.SDK_INT < 14) {
            onViewAdded(view);
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = (float) getWidth();
            float height = (float) getHeight();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() != 8) {
                    Object tag = childAt.getTag();
                    if (tag != null && (tag instanceof String)) {
                        String[] split = ((String) tag).split(",");
                        if (split.length == 4) {
                            int parseInt = Integer.parseInt(split[0]);
                            int parseInt2 = Integer.parseInt(split[1]);
                            int i3 = (int) ((((float) parseInt) / 1080.0f) * width);
                            int i4 = (int) ((((float) parseInt2) / 1920.0f) * height);
                            int parseInt3 = (int) ((((float) Integer.parseInt(split[2])) / 1080.0f) * width);
                            int parseInt4 = (int) ((((float) Integer.parseInt(split[3])) / 1920.0f) * height);
                            Paint paint = new Paint();
                            paint.setColor(-65536);
                            float f2 = (float) i3;
                            float f3 = (float) (i3 + parseInt3);
                            Canvas canvas2 = canvas;
                            float f4 = (float) i4;
                            float f5 = f2;
                            float f6 = f2;
                            float f7 = f4;
                            Paint paint2 = paint;
                            float f8 = f3;
                            Paint paint3 = paint2;
                            canvas2.drawLine(f5, f7, f8, f4, paint3);
                            float f9 = (float) (i4 + parseInt4);
                            float f10 = f3;
                            float f11 = f9;
                            canvas2.drawLine(f10, f7, f8, f11, paint3);
                            float f12 = f9;
                            float f13 = f6;
                            canvas2.drawLine(f10, f12, f13, f11, paint3);
                            float f14 = f6;
                            canvas2.drawLine(f14, f12, f13, f4, paint3);
                            Paint paint4 = paint2;
                            paint4.setColor(-16711936);
                            Paint paint5 = paint4;
                            float f15 = f3;
                            Paint paint6 = paint5;
                            canvas2.drawLine(f14, f4, f15, f9, paint6);
                            canvas2.drawLine(f14, f9, f15, f4, paint6);
                        }
                    }
                }
            }
        }
    }

    public int getMaxHeight() {
        return this.f1129h;
    }

    public int getMaxWidth() {
        return this.f1128g;
    }

    public int getMinHeight() {
        return this.f1127f;
    }

    public int getMinWidth() {
        return this.f1126e;
    }

    public int getOptimizationLevel() {
        return this.f1125d.N();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            a aVar = (a) childAt.getLayoutParams();
            h hVar = aVar.ma;
            if ((childAt.getVisibility() != 8 || aVar.Y || aVar.Z || aVar.ba || isInEditMode) && !aVar.aa) {
                int h2 = hVar.h();
                int i7 = hVar.i();
                int u2 = hVar.u() + h2;
                int j2 = hVar.j() + i7;
                childAt.layout(h2, i7, u2, j2);
                if (childAt instanceof j) {
                    View content = ((j) childAt).getContent();
                    if (content != null) {
                        content.setVisibility(0);
                        content.layout(h2, i7, u2, j2);
                    }
                }
            }
        }
        int size = this.f1123b.size();
        if (size > 0) {
            for (int i8 = 0; i8 < size; i8++) {
                ((c) this.f1123b.get(i8)).a(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x034b  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0360  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0399  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0129  */
    public void onMeasure(int i2, int i3) {
        boolean z;
        int size;
        int i4;
        boolean z2;
        boolean z3;
        boolean z4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = i2;
        int i10 = i3;
        System.currentTimeMillis();
        int mode = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        int mode2 = MeasureSpec.getMode(i3);
        int size3 = MeasureSpec.getSize(i3);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        this.f1125d.n(paddingLeft);
        this.f1125d.o(paddingTop);
        this.f1125d.f(this.f1128g);
        this.f1125d.e(this.f1129h);
        if (VERSION.SDK_INT >= 17) {
            this.f1125d.c(getLayoutDirection() == 1);
        }
        c(i2, i3);
        int u2 = this.f1125d.u();
        int j2 = this.f1125d.j();
        if (this.f1130i) {
            this.f1130i = false;
            b();
            z = true;
        } else {
            z = false;
        }
        boolean z5 = (this.f1131j & 8) == 8;
        if (z5) {
            this.f1125d.U();
            this.f1125d.e(u2, j2);
            b(i2, i3);
        } else {
            a(i2, i3);
        }
        c();
        if (getChildCount() > 0 && z) {
            b.e.b.a.a.a(this.f1125d);
        }
        i iVar = this.f1125d;
        if (iVar.Fa) {
            if (iVar.Ga && mode == Integer.MIN_VALUE) {
                int i11 = iVar.Ia;
                if (i11 < size2) {
                    iVar.k(i11);
                }
                this.f1125d.a(b.e.b.a.h.a.FIXED);
            }
            i iVar2 = this.f1125d;
            if (iVar2.Ha && mode2 == Integer.MIN_VALUE) {
                int i12 = iVar2.Ja;
                if (i12 < size3) {
                    iVar2.c(i12);
                }
                this.f1125d.b(b.e.b.a.h.a.FIXED);
            }
        }
        i iVar3 = this.f1125d;
        if (iVar3.La) {
            if (mode == 1073741824 && mode2 == 1073741824) {
                if (this.o != size2) {
                    b.e.b.a.a.a(iVar3.Ea, 0, size2);
                }
                if (this.p != size3) {
                    b.e.b.a.a.a(this.f1125d.Ea, 1, size3);
                    if (getChildCount() > 0) {
                    }
                    size = this.f1124c.size();
                    int paddingBottom = paddingTop + getPaddingBottom();
                    int paddingRight = paddingLeft + getPaddingRight();
                    if (size > 0) {
                    }
                    int u3 = this.f1125d.u() + paddingRight;
                    int j3 = this.f1125d.j() + paddingBottom;
                    if (VERSION.SDK_INT >= 11) {
                    }
                }
            } else {
                i iVar4 = this.f1125d;
                if (iVar4.Ga && iVar4.Ha) {
                    if (iVar4.Ia > size2) {
                        b.e.b.a.a.a(iVar4.Ea, 0, size2);
                    }
                    i iVar5 = this.f1125d;
                    if (iVar5.Ja > size3) {
                        b.e.b.a.a.a(iVar5.Ea, 1, size3);
                        if (getChildCount() > 0) {
                            a("First pass");
                        }
                        size = this.f1124c.size();
                        int paddingBottom2 = paddingTop + getPaddingBottom();
                        int paddingRight2 = paddingLeft + getPaddingRight();
                        if (size > 0) {
                            boolean z6 = this.f1125d.l() == b.e.b.a.h.a.WRAP_CONTENT;
                            boolean z7 = this.f1125d.s() == b.e.b.a.h.a.WRAP_CONTENT;
                            int max = Math.max(this.f1125d.u(), this.f1126e);
                            int max2 = Math.max(this.f1125d.j(), this.f1127f);
                            int i13 = 0;
                            boolean z8 = false;
                            int i14 = 0;
                            while (i13 < size) {
                                h hVar = (h) this.f1124c.get(i13);
                                int i15 = size;
                                View view = (View) hVar.f();
                                if (view == null) {
                                    i6 = u2;
                                    z4 = z8;
                                    i5 = j2;
                                } else {
                                    i5 = j2;
                                    a aVar = (a) view.getLayoutParams();
                                    i6 = u2;
                                    if ((!aVar.Z || aVar.ba) && !aVar.Y) {
                                        z4 = z8;
                                        if (view.getVisibility() != 8 && (!z5 || !hVar.o().c() || !hVar.n().c())) {
                                            if (aVar.width != -2 || !aVar.V) {
                                                i7 = MeasureSpec.makeMeasureSpec(hVar.u(), 1073741824);
                                            } else {
                                                i7 = ViewGroup.getChildMeasureSpec(i9, paddingRight2, aVar.width);
                                            }
                                            if (aVar.height != -2 || !aVar.W) {
                                                i8 = MeasureSpec.makeMeasureSpec(hVar.j(), 1073741824);
                                            } else {
                                                i8 = ViewGroup.getChildMeasureSpec(i10, paddingBottom2, aVar.height);
                                            }
                                            view.measure(i7, i8);
                                            f fVar = this.v;
                                            if (fVar != null) {
                                                fVar.f2444b++;
                                            }
                                            int measuredWidth = view.getMeasuredWidth();
                                            int measuredHeight = view.getMeasuredHeight();
                                            if (measuredWidth != hVar.u()) {
                                                hVar.k(measuredWidth);
                                                if (z5) {
                                                    hVar.o().a(measuredWidth);
                                                }
                                                if (z6 && hVar.p() > max) {
                                                    max = Math.max(max, hVar.p() + hVar.a(c.RIGHT).b());
                                                }
                                                z4 = true;
                                            }
                                            if (measuredHeight != hVar.j()) {
                                                hVar.c(measuredHeight);
                                                if (z5) {
                                                    hVar.n().a(measuredHeight);
                                                }
                                                if (z7 && hVar.e() > max2) {
                                                    max2 = Math.max(max2, hVar.e() + hVar.a(c.BOTTOM).b());
                                                }
                                                z4 = true;
                                            }
                                            if (aVar.X) {
                                                int baseline = view.getBaseline();
                                                if (!(baseline == -1 || baseline == hVar.d())) {
                                                    hVar.b(baseline);
                                                    z4 = true;
                                                }
                                            }
                                            if (VERSION.SDK_INT >= 11) {
                                                i14 = ViewGroup.combineMeasuredStates(i14, view.getMeasuredState());
                                            } else {
                                                int i16 = i14;
                                            }
                                        }
                                    } else {
                                        z4 = z8;
                                    }
                                }
                                z8 = z4;
                                i13++;
                                i9 = i2;
                                u2 = i6;
                                size = i15;
                                j2 = i5;
                            }
                            int i17 = size;
                            int i18 = u2;
                            int i19 = j2;
                            i4 = i14;
                            if (z8) {
                                this.f1125d.k(i18);
                                this.f1125d.c(i19);
                                if (z5) {
                                    this.f1125d.V();
                                }
                                a("2nd pass");
                                if (this.f1125d.u() < max) {
                                    this.f1125d.k(max);
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (this.f1125d.j() < max2) {
                                    this.f1125d.c(max2);
                                    z3 = true;
                                } else {
                                    z3 = z2;
                                }
                                if (z3) {
                                    a("3rd pass");
                                }
                            }
                            int i20 = i17;
                            for (int i21 = 0; i21 < i20; i21++) {
                                h hVar2 = (h) this.f1124c.get(i21);
                                View view2 = (View) hVar2.f();
                                if (view2 != null && (view2.getMeasuredWidth() != hVar2.u() || view2.getMeasuredHeight() != hVar2.j())) {
                                    if (hVar2.t() != 8) {
                                        view2.measure(MeasureSpec.makeMeasureSpec(hVar2.u(), 1073741824), MeasureSpec.makeMeasureSpec(hVar2.j(), 1073741824));
                                        f fVar2 = this.v;
                                        if (fVar2 != null) {
                                            fVar2.f2444b++;
                                        }
                                    }
                                }
                            }
                        } else {
                            i4 = 0;
                        }
                        int u32 = this.f1125d.u() + paddingRight2;
                        int j32 = this.f1125d.j() + paddingBottom2;
                        if (VERSION.SDK_INT >= 11) {
                            int resolveSizeAndState = ViewGroup.resolveSizeAndState(j32, i10, i4 << 16) & 16777215;
                            int min = Math.min(this.f1128g, ViewGroup.resolveSizeAndState(u32, i2, i4) & 16777215);
                            int min2 = Math.min(this.f1129h, resolveSizeAndState);
                            if (this.f1125d.R()) {
                                min |= 16777216;
                            }
                            if (this.f1125d.P()) {
                                min2 |= 16777216;
                            }
                            setMeasuredDimension(min, min2);
                            this.o = min;
                            this.p = min2;
                            return;
                        }
                        setMeasuredDimension(u32, j32);
                        this.o = u32;
                        this.p = j32;
                        return;
                    }
                }
            }
        }
        if (getChildCount() > 0) {
        }
        size = this.f1124c.size();
        int paddingBottom22 = paddingTop + getPaddingBottom();
        int paddingRight22 = paddingLeft + getPaddingRight();
        if (size > 0) {
        }
        int u322 = this.f1125d.u() + paddingRight22;
        int j322 = this.f1125d.j() + paddingBottom22;
        if (VERSION.SDK_INT >= 11) {
        }
    }

    public void onViewAdded(View view) {
        if (VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        h a2 = a(view);
        if ((view instanceof i) && !(a2 instanceof l)) {
            a aVar = (a) view.getLayoutParams();
            aVar.ma = new l();
            aVar.Y = true;
            ((l) aVar.ma).r(aVar.S);
        }
        if (view instanceof c) {
            c cVar = (c) view;
            cVar.a();
            ((a) view.getLayoutParams()).Z = true;
            if (!this.f1123b.contains(cVar)) {
                this.f1123b.add(cVar);
            }
        }
        this.f1122a.put(view.getId(), view);
        this.f1130i = true;
    }

    public void onViewRemoved(View view) {
        if (VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.f1122a.remove(view.getId());
        h a2 = a(view);
        this.f1125d.c(a2);
        this.f1123b.remove(view);
        this.f1124c.remove(a2);
        this.f1130i = true;
    }

    public void removeView(View view) {
        super.removeView(view);
        if (VERSION.SDK_INT < 14) {
            onViewRemoved(view);
        }
    }

    public void requestLayout() {
        super.requestLayout();
        this.f1130i = true;
        this.o = -1;
        this.p = -1;
        this.q = -1;
        this.r = -1;
        this.s = 0;
        this.t = 0;
    }

    public void setConstraintSet(f fVar) {
        this.f1132k = fVar;
    }

    public void setId(int i2) {
        this.f1122a.remove(getId());
        super.setId(i2);
        this.f1122a.put(getId(), this);
    }

    public void setMaxHeight(int i2) {
        if (i2 != this.f1129h) {
            this.f1129h = i2;
            requestLayout();
        }
    }

    public void setMaxWidth(int i2) {
        if (i2 != this.f1128g) {
            this.f1128g = i2;
            requestLayout();
        }
    }

    public void setMinHeight(int i2) {
        if (i2 != this.f1127f) {
            this.f1127f = i2;
            requestLayout();
        }
    }

    public void setMinWidth(int i2) {
        if (i2 != this.f1126e) {
            this.f1126e = i2;
            requestLayout();
        }
    }

    public void setOnConstraintsChanged(h hVar) {
        this.u = hVar;
        e eVar = this.f1133l;
        if (eVar != null) {
            eVar.a(hVar);
        }
    }

    public void setOptimizationLevel(int i2) {
        this.f1125d.q(i2);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public Object a(int i2, Object obj) {
        if (i2 == 0 && (obj instanceof String)) {
            String str = (String) obj;
            HashMap<String, Integer> hashMap = this.n;
            if (hashMap != null && hashMap.containsKey(str)) {
                return this.n.get(str);
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    private void a(AttributeSet attributeSet) {
        this.f1125d.a((Object) this);
        this.f1122a.put(getId(), this);
        this.f1132k = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, l.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == l.ConstraintLayout_Layout_android_minWidth) {
                    this.f1126e = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1126e);
                } else if (index == l.ConstraintLayout_Layout_android_minHeight) {
                    this.f1127f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1127f);
                } else if (index == l.ConstraintLayout_Layout_android_maxWidth) {
                    this.f1128g = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1128g);
                } else if (index == l.ConstraintLayout_Layout_android_maxHeight) {
                    this.f1129h = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1129h);
                } else if (index == l.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.f1131j = obtainStyledAttributes.getInt(index, this.f1131j);
                } else if (index == l.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            a(resourceId);
                        } catch (NotFoundException unused) {
                            this.f1133l = null;
                        }
                    }
                } else if (index == l.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        this.f1132k = new f();
                        this.f1132k.b(getContext(), resourceId2);
                    } catch (NotFoundException unused2) {
                        this.f1132k = null;
                    }
                    this.m = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f1125d.q(this.f1131j);
    }

    private final h b(int i2) {
        h hVar;
        if (i2 == 0) {
            return this.f1125d;
        }
        View view = (View) this.f1122a.get(i2);
        if (view == this) {
            return this.f1125d;
        }
        if (view == null) {
            hVar = null;
        } else {
            hVar = ((a) view.getLayoutParams()).ma;
        }
        return hVar;
    }

    private void c(int i2, int i3) {
        b.e.b.a.h.a aVar;
        int i4;
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        int mode2 = MeasureSpec.getMode(i3);
        int size2 = MeasureSpec.getSize(i3);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        b.e.b.a.h.a aVar2 = b.e.b.a.h.a.FIXED;
        getLayoutParams();
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                aVar = b.e.b.a.h.a.WRAP_CONTENT;
            } else if (mode != 1073741824) {
                aVar = aVar2;
            } else {
                i4 = Math.min(this.f1128g, size) - paddingLeft;
                aVar = aVar2;
            }
            i4 = 0;
        } else {
            i4 = size;
            aVar = b.e.b.a.h.a.WRAP_CONTENT;
        }
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                aVar2 = b.e.b.a.h.a.WRAP_CONTENT;
            } else if (mode2 == 1073741824) {
                size2 = Math.min(this.f1129h, size2) - paddingTop;
            }
            size2 = 0;
        } else {
            aVar2 = b.e.b.a.h.a.WRAP_CONTENT;
        }
        this.f1125d.h(0);
        this.f1125d.g(0);
        this.f1125d.a(aVar);
        this.f1125d.k(i4);
        this.f1125d.b(aVar2);
        this.f1125d.c(size2);
        this.f1125d.h((this.f1126e - getPaddingLeft()) - getPaddingRight());
        this.f1125d.g((this.f1127f - getPaddingTop()) - getPaddingBottom());
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0265  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x026e  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0273  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0275  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x027d  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0291  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0296  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x029b  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x02a3  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x02ac  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x02b4  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02c1  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02cc  */
    private void b(int i2, int i3) {
        long j2;
        int i4;
        int i5;
        long j3;
        int i6;
        int i7;
        boolean z;
        boolean z2;
        boolean z3;
        int i8;
        f fVar;
        int i9;
        ConstraintLayout constraintLayout = this;
        int i10 = i2;
        int i11 = i3;
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        int i12 = 0;
        while (true) {
            j2 = 1;
            i4 = 8;
            if (i12 >= childCount) {
                break;
            }
            View childAt = constraintLayout.getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                a aVar = (a) childAt.getLayoutParams();
                h hVar = aVar.ma;
                if (!aVar.Y && !aVar.Z) {
                    hVar.j(childAt.getVisibility());
                    int i13 = aVar.width;
                    int i14 = aVar.height;
                    if (i13 == 0 || i14 == 0) {
                        i9 = paddingTop;
                        hVar.o().b();
                        hVar.n().b();
                        i12++;
                        i11 = i3;
                        paddingTop = i9;
                    } else {
                        boolean z4 = i13 == -2;
                        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, paddingLeft, i13);
                        boolean z5 = i14 == -2;
                        childAt.measure(childMeasureSpec, ViewGroup.getChildMeasureSpec(i11, paddingTop, i14));
                        f fVar2 = constraintLayout.v;
                        if (fVar2 != null) {
                            i9 = paddingTop;
                            fVar2.f2443a++;
                        } else {
                            i9 = paddingTop;
                        }
                        hVar.b(i13 == -2);
                        hVar.a(i14 == -2);
                        int measuredWidth = childAt.getMeasuredWidth();
                        int measuredHeight = childAt.getMeasuredHeight();
                        hVar.k(measuredWidth);
                        hVar.c(measuredHeight);
                        if (z4) {
                            hVar.m(measuredWidth);
                        }
                        if (z5) {
                            hVar.l(measuredHeight);
                        }
                        if (aVar.X) {
                            int baseline = childAt.getBaseline();
                            if (baseline != -1) {
                                hVar.b(baseline);
                            }
                        }
                        if (aVar.V && aVar.W) {
                            hVar.o().a(measuredWidth);
                            hVar.n().a(measuredHeight);
                        }
                        i12++;
                        i11 = i3;
                        paddingTop = i9;
                    }
                }
            }
            i9 = paddingTop;
            i12++;
            i11 = i3;
            paddingTop = i9;
        }
        int i15 = paddingTop;
        constraintLayout.f1125d.V();
        int i16 = 0;
        while (i16 < childCount) {
            View childAt2 = constraintLayout.getChildAt(i16);
            if (childAt2.getVisibility() != i4) {
                a aVar2 = (a) childAt2.getLayoutParams();
                h hVar2 = aVar2.ma;
                if (!aVar2.Y && !aVar2.Z) {
                    hVar2.j(childAt2.getVisibility());
                    int i17 = aVar2.width;
                    int i18 = aVar2.height;
                    if (i17 == 0 || i18 == 0) {
                        q d2 = hVar2.a(c.LEFT).d();
                        q d3 = hVar2.a(c.RIGHT).d();
                        boolean z6 = (hVar2.a(c.LEFT).g() == null || hVar2.a(c.RIGHT).g() == null) ? false : true;
                        q d4 = hVar2.a(c.TOP).d();
                        q d5 = hVar2.a(c.BOTTOM).d();
                        i6 = childCount;
                        boolean z7 = (hVar2.a(c.TOP).g() == null || hVar2.a(c.BOTTOM).g() == null) ? false : true;
                        if (i17 != 0 || i18 != 0 || !z6 || !z7) {
                            i5 = i16;
                            a aVar3 = aVar2;
                            boolean z8 = constraintLayout.f1125d.l() != b.e.b.a.h.a.WRAP_CONTENT;
                            boolean z9 = constraintLayout.f1125d.s() != b.e.b.a.h.a.WRAP_CONTENT;
                            if (!z8) {
                                hVar2.o().b();
                            }
                            if (!z9) {
                                hVar2.n().b();
                            }
                            if (i17 == 0) {
                                if (!z8 || !hVar2.D() || !z6 || !d2.c() || !d3.c()) {
                                    i7 = ViewGroup.getChildMeasureSpec(i10, paddingLeft, -2);
                                    z = true;
                                    z8 = false;
                                    if (i18 != 0) {
                                        int i19 = i3;
                                        if (i18 == -1) {
                                            z2 = z9;
                                            i8 = ViewGroup.getChildMeasureSpec(i19, i15, -1);
                                        } else {
                                            z3 = i18 == -2;
                                            z2 = z9;
                                            i8 = ViewGroup.getChildMeasureSpec(i19, i15, i18);
                                            childAt2.measure(i7, i8);
                                            constraintLayout = this;
                                            fVar = constraintLayout.v;
                                            if (fVar != null) {
                                            }
                                            hVar2.b(i17 == -2);
                                            hVar2.a(i18 == -2);
                                            int measuredWidth2 = childAt2.getMeasuredWidth();
                                            int measuredHeight2 = childAt2.getMeasuredHeight();
                                            hVar2.k(measuredWidth2);
                                            hVar2.c(measuredHeight2);
                                            if (z) {
                                            }
                                            if (z3) {
                                            }
                                            if (z8) {
                                            }
                                            if (z2) {
                                            }
                                            if (aVar3.X) {
                                            }
                                            i16 = i5 + 1;
                                            childCount = i6;
                                            j2 = j3;
                                            i4 = 8;
                                        }
                                    } else if (!z9 || !hVar2.C() || !z7 || !d4.c() || !d5.c()) {
                                        i8 = ViewGroup.getChildMeasureSpec(i3, i15, -2);
                                        z3 = true;
                                        z2 = false;
                                        childAt2.measure(i7, i8);
                                        constraintLayout = this;
                                        fVar = constraintLayout.v;
                                        if (fVar != null) {
                                            j3 = 1;
                                            fVar.f2443a++;
                                        } else {
                                            j3 = 1;
                                        }
                                        hVar2.b(i17 == -2);
                                        hVar2.a(i18 == -2);
                                        int measuredWidth22 = childAt2.getMeasuredWidth();
                                        int measuredHeight22 = childAt2.getMeasuredHeight();
                                        hVar2.k(measuredWidth22);
                                        hVar2.c(measuredHeight22);
                                        if (z) {
                                            hVar2.m(measuredWidth22);
                                        }
                                        if (z3) {
                                            hVar2.l(measuredHeight22);
                                        }
                                        if (z8) {
                                            hVar2.o().a(measuredWidth22);
                                        } else {
                                            hVar2.o().f();
                                        }
                                        if (z2) {
                                            hVar2.n().a(measuredHeight22);
                                        } else {
                                            hVar2.n().f();
                                        }
                                        if (aVar3.X) {
                                            int baseline2 = childAt2.getBaseline();
                                            if (baseline2 != -1) {
                                                hVar2.b(baseline2);
                                            }
                                        }
                                        i16 = i5 + 1;
                                        childCount = i6;
                                        j2 = j3;
                                        i4 = 8;
                                    } else {
                                        i18 = (int) (d5.f() - d4.f());
                                        hVar2.n().a(i18);
                                        z2 = z9;
                                        i8 = ViewGroup.getChildMeasureSpec(i3, i15, i18);
                                    }
                                    z3 = false;
                                    childAt2.measure(i7, i8);
                                    constraintLayout = this;
                                    fVar = constraintLayout.v;
                                    if (fVar != null) {
                                    }
                                    hVar2.b(i17 == -2);
                                    hVar2.a(i18 == -2);
                                    int measuredWidth222 = childAt2.getMeasuredWidth();
                                    int measuredHeight222 = childAt2.getMeasuredHeight();
                                    hVar2.k(measuredWidth222);
                                    hVar2.c(measuredHeight222);
                                    if (z) {
                                    }
                                    if (z3) {
                                    }
                                    if (z8) {
                                    }
                                    if (z2) {
                                    }
                                    if (aVar3.X) {
                                    }
                                    i16 = i5 + 1;
                                    childCount = i6;
                                    j2 = j3;
                                    i4 = 8;
                                } else {
                                    i17 = (int) (d3.f() - d2.f());
                                    hVar2.o().a(i17);
                                    i7 = ViewGroup.getChildMeasureSpec(i10, paddingLeft, i17);
                                }
                            } else if (i17 == -1) {
                                i7 = ViewGroup.getChildMeasureSpec(i10, paddingLeft, -1);
                            } else {
                                z = i17 == -2;
                                i7 = ViewGroup.getChildMeasureSpec(i10, paddingLeft, i17);
                                if (i18 != 0) {
                                }
                                z3 = false;
                                childAt2.measure(i7, i8);
                                constraintLayout = this;
                                fVar = constraintLayout.v;
                                if (fVar != null) {
                                }
                                hVar2.b(i17 == -2);
                                hVar2.a(i18 == -2);
                                int measuredWidth2222 = childAt2.getMeasuredWidth();
                                int measuredHeight2222 = childAt2.getMeasuredHeight();
                                hVar2.k(measuredWidth2222);
                                hVar2.c(measuredHeight2222);
                                if (z) {
                                }
                                if (z3) {
                                }
                                if (z8) {
                                }
                                if (z2) {
                                }
                                if (aVar3.X) {
                                }
                                i16 = i5 + 1;
                                childCount = i6;
                                j2 = j3;
                                i4 = 8;
                            }
                            z = false;
                            if (i18 != 0) {
                            }
                            z3 = false;
                            childAt2.measure(i7, i8);
                            constraintLayout = this;
                            fVar = constraintLayout.v;
                            if (fVar != null) {
                            }
                            hVar2.b(i17 == -2);
                            hVar2.a(i18 == -2);
                            int measuredWidth22222 = childAt2.getMeasuredWidth();
                            int measuredHeight22222 = childAt2.getMeasuredHeight();
                            hVar2.k(measuredWidth22222);
                            hVar2.c(measuredHeight22222);
                            if (z) {
                            }
                            if (z3) {
                            }
                            if (z8) {
                            }
                            if (z2) {
                            }
                            if (aVar3.X) {
                            }
                            i16 = i5 + 1;
                            childCount = i6;
                            j2 = j3;
                            i4 = 8;
                        } else {
                            int i20 = i3;
                            i5 = i16;
                            j3 = 1;
                            i16 = i5 + 1;
                            childCount = i6;
                            j2 = j3;
                            i4 = 8;
                        }
                    }
                }
            }
            i5 = i16;
            i6 = childCount;
            j3 = j2;
            int i21 = i3;
            i16 = i5 + 1;
            childCount = i6;
            j2 = j3;
            i4 = 8;
        }
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    /* access modifiers changed from: protected */
    public void a(int i2) {
        this.f1133l = new e(getContext(), this, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0167, code lost:
        if (r11 != -1) goto L_0x016b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x02d7  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x02ff  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x030d  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0336  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0345  */
    private void a() {
        int i2;
        int i3;
        int i4;
        int i5;
        float f2;
        int i6;
        int i7;
        String str;
        float f3;
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        boolean z = false;
        for (int i8 = 0; i8 < childCount; i8++) {
            h a2 = a(getChildAt(i8));
            if (a2 != null) {
                a2.E();
            }
        }
        if (this.m != -1) {
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = getChildAt(i9);
                if (childAt.getId() == this.m && (childAt instanceof g)) {
                    this.f1132k = ((g) childAt).getConstraintSet();
                }
            }
        }
        f fVar = this.f1132k;
        if (fVar != null) {
            fVar.b(this);
        }
        this.f1125d.M();
        int size = this.f1123b.size();
        if (size > 0) {
            for (int i10 = 0; i10 < size; i10++) {
                ((c) this.f1123b.get(i10)).c(this);
            }
        }
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt2 = getChildAt(i11);
            if (childAt2 instanceof j) {
                ((j) childAt2).b(this);
            }
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt3 = getChildAt(i12);
            h a3 = a(childAt3);
            if (a3 != null) {
                a aVar = (a) childAt3.getLayoutParams();
                aVar.a();
                if (aVar.na) {
                    aVar.na = z;
                }
                a3.j(childAt3.getVisibility());
                if (aVar.aa) {
                    a3.j(8);
                }
                a3.a((Object) childAt3);
                this.f1125d.a(a3);
                if (!aVar.W || !aVar.V) {
                    this.f1124c.add(a3);
                }
                if (aVar.Y) {
                    l lVar = (l) a3;
                    int i13 = aVar.ja;
                    int i14 = aVar.ka;
                    float f4 = aVar.la;
                    if (VERSION.SDK_INT < 17) {
                        i13 = aVar.f1134a;
                        i14 = aVar.f1135b;
                        f4 = aVar.f1136c;
                    }
                    if (f4 != -1.0f) {
                        lVar.e(f4);
                    } else if (i13 != -1) {
                        lVar.p(i13);
                    } else if (i14 != -1) {
                        lVar.q(i14);
                    }
                } else if (aVar.f1137d != -1 || aVar.f1138e != -1 || aVar.f1139f != -1 || aVar.f1140g != -1 || aVar.q != -1 || aVar.p != -1 || aVar.r != -1 || aVar.s != -1 || aVar.f1141h != -1 || aVar.f1142i != -1 || aVar.f1143j != -1 || aVar.f1144k != -1 || aVar.f1145l != -1 || aVar.Q != -1 || aVar.R != -1 || aVar.m != -1 || aVar.width == -1 || aVar.height == -1) {
                    int i15 = aVar.ca;
                    int i16 = aVar.da;
                    int i17 = aVar.ea;
                    int i18 = aVar.fa;
                    int i19 = aVar.ga;
                    int i20 = aVar.ha;
                    float f5 = aVar.ia;
                    if (VERSION.SDK_INT < 17) {
                        int i21 = aVar.f1137d;
                        int i22 = aVar.f1138e;
                        int i23 = aVar.f1139f;
                        i18 = aVar.f1140g;
                        int i24 = aVar.t;
                        int i25 = aVar.v;
                        f5 = aVar.z;
                        if (i21 == -1 && i22 == -1) {
                            int i26 = aVar.q;
                            if (i26 != -1) {
                                int i27 = i26;
                                i5 = i22;
                                i15 = i27;
                                if (i23 == -1 && i18 == -1) {
                                    i6 = aVar.r;
                                    if (i6 == -1) {
                                        i4 = i24;
                                        i2 = i25;
                                    } else {
                                        int i28 = aVar.s;
                                        if (i28 != -1) {
                                            i4 = i24;
                                            i2 = i25;
                                            f2 = f5;
                                            i3 = i28;
                                            i6 = i23;
                                            i7 = aVar.m;
                                            if (i7 == -1) {
                                                h b2 = b(i7);
                                                if (b2 != null) {
                                                    a3.a(b2, aVar.o, aVar.n);
                                                }
                                            } else {
                                                if (i15 != -1) {
                                                    h b3 = b(i15);
                                                    if (b3 != null) {
                                                        c cVar = c.LEFT;
                                                        f3 = f2;
                                                        a3.a(cVar, b3, cVar, aVar.leftMargin, i4);
                                                    } else {
                                                        f3 = f2;
                                                    }
                                                } else {
                                                    f3 = f2;
                                                    if (i5 != -1) {
                                                        h b4 = b(i5);
                                                        if (b4 != null) {
                                                            a3.a(c.LEFT, b4, c.RIGHT, aVar.leftMargin, i4);
                                                        }
                                                    }
                                                }
                                                if (i6 != -1) {
                                                    h b5 = b(i6);
                                                    if (b5 != null) {
                                                        a3.a(c.RIGHT, b5, c.LEFT, aVar.rightMargin, i2);
                                                    }
                                                } else if (i3 != -1) {
                                                    h b6 = b(i3);
                                                    if (b6 != null) {
                                                        c cVar2 = c.RIGHT;
                                                        a3.a(cVar2, b6, cVar2, aVar.rightMargin, i2);
                                                    }
                                                }
                                                int i29 = aVar.f1141h;
                                                if (i29 != -1) {
                                                    h b7 = b(i29);
                                                    if (b7 != null) {
                                                        c cVar3 = c.TOP;
                                                        a3.a(cVar3, b7, cVar3, aVar.topMargin, aVar.u);
                                                    }
                                                } else {
                                                    int i30 = aVar.f1142i;
                                                    if (i30 != -1) {
                                                        h b8 = b(i30);
                                                        if (b8 != null) {
                                                            a3.a(c.TOP, b8, c.BOTTOM, aVar.topMargin, aVar.u);
                                                        }
                                                    }
                                                }
                                                int i31 = aVar.f1143j;
                                                if (i31 != -1) {
                                                    h b9 = b(i31);
                                                    if (b9 != null) {
                                                        a3.a(c.BOTTOM, b9, c.TOP, aVar.bottomMargin, aVar.w);
                                                    }
                                                } else {
                                                    int i32 = aVar.f1144k;
                                                    if (i32 != -1) {
                                                        h b10 = b(i32);
                                                        if (b10 != null) {
                                                            c cVar4 = c.BOTTOM;
                                                            a3.a(cVar4, b10, cVar4, aVar.bottomMargin, aVar.w);
                                                        }
                                                    }
                                                }
                                                int i33 = aVar.f1145l;
                                                if (i33 != -1) {
                                                    View view = (View) this.f1122a.get(i33);
                                                    h b11 = b(aVar.f1145l);
                                                    if (!(b11 == null || view == null || !(view.getLayoutParams() instanceof a))) {
                                                        a aVar2 = (a) view.getLayoutParams();
                                                        aVar.X = true;
                                                        aVar2.X = true;
                                                        a3.a(c.BASELINE).a(b11.a(c.BASELINE), 0, -1, b.STRONG, 0, true);
                                                        a3.a(c.TOP).j();
                                                        a3.a(c.BOTTOM).j();
                                                    }
                                                }
                                                float f6 = f3;
                                                if (f6 >= 0.0f && f6 != 0.5f) {
                                                    a3.a(f6);
                                                }
                                                float f7 = aVar.A;
                                                if (f7 >= 0.0f && f7 != 0.5f) {
                                                    a3.c(f7);
                                                }
                                            }
                                            if (isInEditMode && !(aVar.Q == -1 && aVar.R == -1)) {
                                                a3.c(aVar.Q, aVar.R);
                                            }
                                            if (!aVar.V) {
                                                a3.a(b.e.b.a.h.a.FIXED);
                                                a3.k(aVar.width);
                                            } else if (aVar.width == -1) {
                                                a3.a(b.e.b.a.h.a.MATCH_PARENT);
                                                a3.a(c.LEFT).f2348e = aVar.leftMargin;
                                                a3.a(c.RIGHT).f2348e = aVar.rightMargin;
                                            } else {
                                                a3.a(b.e.b.a.h.a.MATCH_CONSTRAINT);
                                                a3.k(0);
                                            }
                                            if (!aVar.W) {
                                                z = false;
                                                a3.b(b.e.b.a.h.a.FIXED);
                                                a3.c(aVar.height);
                                            } else if (aVar.height == -1) {
                                                a3.b(b.e.b.a.h.a.MATCH_PARENT);
                                                a3.a(c.TOP).f2348e = aVar.topMargin;
                                                a3.a(c.BOTTOM).f2348e = aVar.bottomMargin;
                                                z = false;
                                            } else {
                                                a3.b(b.e.b.a.h.a.MATCH_CONSTRAINT);
                                                z = false;
                                                a3.c(0);
                                            }
                                            str = aVar.B;
                                            if (str != null) {
                                                a3.a(str);
                                            }
                                            a3.b(aVar.E);
                                            a3.d(aVar.F);
                                            a3.d(aVar.G);
                                            a3.i(aVar.H);
                                            a3.a(aVar.I, aVar.K, aVar.M, aVar.O);
                                            a3.b(aVar.J, aVar.L, aVar.N, aVar.P);
                                        }
                                    }
                                }
                                i4 = i24;
                                i2 = i25;
                                i6 = i23;
                            } else {
                                i5 = aVar.p;
                            }
                        }
                        i5 = i22;
                        i15 = i21;
                        i6 = aVar.r;
                        if (i6 == -1) {
                        }
                    } else {
                        i6 = i17;
                        i2 = i20;
                        i4 = i19;
                        i5 = i16;
                    }
                    float f8 = f5;
                    i3 = i18;
                    f2 = f8;
                    i7 = aVar.m;
                    if (i7 == -1) {
                    }
                    a3.c(aVar.Q, aVar.R);
                    if (!aVar.V) {
                    }
                    if (!aVar.W) {
                    }
                    str = aVar.B;
                    if (str != null) {
                    }
                    a3.b(aVar.E);
                    a3.d(aVar.F);
                    a3.d(aVar.G);
                    a3.i(aVar.H);
                    a3.a(aVar.I, aVar.K, aVar.M, aVar.O);
                    a3.b(aVar.J, aVar.L, aVar.N, aVar.P);
                }
            }
        }
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet);
    }

    public final h a(View view) {
        h hVar;
        if (view == this) {
            return this.f1125d;
        }
        if (view == null) {
            hVar = null;
        } else {
            hVar = ((a) view.getLayoutParams()).ma;
        }
        return hVar;
    }

    private void a(int i2, int i3) {
        boolean z;
        boolean z2;
        int i4;
        int i5;
        int i6 = i2;
        int i7 = i3;
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        int i8 = 0;
        int i9 = 0;
        while (i9 < childCount) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                a aVar = (a) childAt.getLayoutParams();
                h hVar = aVar.ma;
                if (!aVar.Y && (!aVar.Z || aVar.ba)) {
                    hVar.j(childAt.getVisibility());
                    if (aVar.ba) {
                        hVar.j(i8);
                    }
                    int i10 = aVar.width;
                    int i11 = aVar.height;
                    boolean z3 = aVar.V;
                    if (z3 || aVar.W || (!z3 && aVar.I == 1) || aVar.width == -1 || (!aVar.W && (aVar.J == 1 || aVar.height == -1))) {
                        if (i10 == 0) {
                            i4 = ViewGroup.getChildMeasureSpec(i6, paddingLeft, -2);
                            z2 = true;
                        } else if (i10 == -1) {
                            i4 = ViewGroup.getChildMeasureSpec(i6, paddingLeft, -1);
                            z2 = false;
                        } else {
                            z2 = i10 == -2;
                            i4 = ViewGroup.getChildMeasureSpec(i6, paddingLeft, i10);
                        }
                        if (i11 == 0) {
                            i5 = ViewGroup.getChildMeasureSpec(i7, paddingTop, -2);
                            z = true;
                        } else if (i11 == -1) {
                            i5 = ViewGroup.getChildMeasureSpec(i7, paddingTop, -1);
                            z = false;
                        } else {
                            z = i11 == -2;
                            i5 = ViewGroup.getChildMeasureSpec(i7, paddingTop, i11);
                        }
                        childAt.measure(i4, i5);
                        f fVar = this.v;
                        if (fVar != null) {
                            fVar.f2443a++;
                        }
                        hVar.b(i10 == -2);
                        hVar.a(i11 == -2);
                        i10 = childAt.getMeasuredWidth();
                        i11 = childAt.getMeasuredHeight();
                    } else {
                        z2 = false;
                        z = false;
                    }
                    hVar.k(i10);
                    hVar.c(i11);
                    if (z2) {
                        hVar.m(i10);
                    }
                    if (z) {
                        hVar.l(i11);
                    }
                    if (aVar.X) {
                        int baseline = childAt.getBaseline();
                        if (baseline != -1) {
                            hVar.b(baseline);
                        }
                    }
                }
            }
            i9++;
            i8 = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void a(String str) {
        f fVar = this.v;
        if (fVar != null) {
            fVar.f2445c++;
        }
        this.f1125d.L();
    }

    public void a(int i2, int i3, int i4) {
        e eVar = this.f1133l;
        if (eVar != null) {
            eVar.a(i2, (float) i3, (float) i4);
        }
    }
}
