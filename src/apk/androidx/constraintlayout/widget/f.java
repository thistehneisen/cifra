package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import io.intercom.android.sdk.metrics.ops.OpsMetricTracker;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ConstraintSet */
public class f {

    /* renamed from: a reason: collision with root package name */
    private static final int[] f1188a = {0, 4, 8};

    /* renamed from: b reason: collision with root package name */
    private static SparseIntArray f1189b = new SparseIntArray();

    /* renamed from: c reason: collision with root package name */
    private HashMap<String, b> f1190c = new HashMap<>();

    /* renamed from: d reason: collision with root package name */
    private HashMap<Integer, a> f1191d = new HashMap<>();

    /* compiled from: ConstraintSet */
    public static class a {
        public int A = -1;
        public float Aa = Float.NaN;
        public int B = -1;
        public boolean Ba = true;
        public int C = -1;
        public HashMap<String, b> Ca = new HashMap<>();
        public int D = -1;
        public int E = -1;
        public int F = -1;
        public int G = -1;
        public int H = -1;
        public int I = -1;
        public int J = 0;
        public int K = -1;
        public int L = -1;
        public int M = -1;
        public int N = -1;
        public int O = -1;
        public int P = -1;
        public float Q = 0.0f;
        public float R = 0.0f;
        public int S = 0;
        public int T = 0;
        public float U = 1.0f;
        public boolean V = false;
        public float W = 0.0f;
        public float X = 0.0f;
        public float Y = 0.0f;
        public float Z = 0.0f;

        /* renamed from: a reason: collision with root package name */
        boolean f1192a = false;
        public float aa = 1.0f;

        /* renamed from: b reason: collision with root package name */
        public int f1193b;
        public float ba = 1.0f;

        /* renamed from: c reason: collision with root package name */
        public int f1194c;
        public float ca = Float.NaN;

        /* renamed from: d reason: collision with root package name */
        int f1195d;
        public float da = Float.NaN;

        /* renamed from: e reason: collision with root package name */
        public int f1196e = -1;
        public float ea = 0.0f;

        /* renamed from: f reason: collision with root package name */
        public int f1197f = -1;
        public float fa = 0.0f;

        /* renamed from: g reason: collision with root package name */
        public float f1198g = -1.0f;
        public float ga = 0.0f;

        /* renamed from: h reason: collision with root package name */
        public int f1199h = -1;
        public boolean ha = false;

        /* renamed from: i reason: collision with root package name */
        public int f1200i = -1;
        public boolean ia = false;

        /* renamed from: j reason: collision with root package name */
        public int f1201j = -1;
        public int ja = 0;

        /* renamed from: k reason: collision with root package name */
        public int f1202k = -1;
        public int ka = 0;

        /* renamed from: l reason: collision with root package name */
        public int f1203l = -1;
        public int la = -1;
        public int m = -1;
        public int ma = -1;
        public int n = -1;
        public int na = -1;
        public int o = -1;
        public int oa = -1;
        public int p = -1;
        public float pa = 1.0f;
        public int q = -1;
        public float qa = 1.0f;
        public int r = -1;
        public int ra = -1;
        public int s = -1;
        public int sa = -1;
        public int t = -1;
        public int[] ta;
        public float u = 0.5f;
        public String ua;
        public float v = 0.5f;
        public int va = -1;
        public String w = null;
        public String wa = null;
        public int x = -1;
        public int xa = -1;
        public int y = 0;
        public int ya = 0;
        public float z = 0.0f;
        public float za = Float.NaN;

        public a clone() {
            a aVar = new a();
            aVar.f1192a = this.f1192a;
            aVar.f1193b = this.f1193b;
            aVar.f1194c = this.f1194c;
            aVar.f1196e = this.f1196e;
            aVar.f1197f = this.f1197f;
            aVar.f1198g = this.f1198g;
            aVar.f1199h = this.f1199h;
            aVar.f1200i = this.f1200i;
            aVar.f1201j = this.f1201j;
            aVar.f1202k = this.f1202k;
            aVar.f1203l = this.f1203l;
            aVar.m = this.m;
            aVar.n = this.n;
            aVar.o = this.o;
            aVar.p = this.p;
            aVar.q = this.q;
            aVar.r = this.r;
            aVar.s = this.s;
            aVar.t = this.t;
            aVar.u = this.u;
            aVar.v = this.v;
            aVar.w = this.w;
            aVar.A = this.A;
            aVar.B = this.B;
            aVar.u = this.u;
            aVar.u = this.u;
            aVar.u = this.u;
            aVar.u = this.u;
            aVar.u = this.u;
            aVar.C = this.C;
            aVar.D = this.D;
            aVar.E = this.E;
            aVar.F = this.F;
            aVar.G = this.G;
            aVar.H = this.H;
            aVar.I = this.I;
            aVar.J = this.J;
            aVar.K = this.K;
            aVar.L = this.L;
            aVar.M = this.M;
            aVar.N = this.N;
            aVar.O = this.O;
            aVar.P = this.P;
            aVar.Q = this.Q;
            aVar.R = this.R;
            aVar.S = this.S;
            aVar.T = this.T;
            aVar.U = this.U;
            aVar.V = this.V;
            aVar.W = this.W;
            aVar.X = this.X;
            aVar.Y = this.Y;
            aVar.Z = this.Z;
            aVar.aa = this.aa;
            aVar.ba = this.ba;
            aVar.ca = this.ca;
            aVar.da = this.da;
            aVar.ea = this.ea;
            aVar.fa = this.fa;
            aVar.ga = this.ga;
            aVar.ha = this.ha;
            aVar.ia = this.ia;
            aVar.ja = this.ja;
            aVar.ka = this.ka;
            aVar.la = this.la;
            aVar.ma = this.ma;
            aVar.na = this.na;
            aVar.oa = this.oa;
            aVar.pa = this.pa;
            aVar.qa = this.qa;
            aVar.ra = this.ra;
            aVar.sa = this.sa;
            int[] iArr = this.ta;
            if (iArr != null) {
                aVar.ta = Arrays.copyOf(iArr, iArr.length);
            }
            aVar.x = this.x;
            aVar.y = this.y;
            aVar.z = this.z;
            aVar.va = this.va;
            aVar.wa = this.wa;
            aVar.xa = this.xa;
            aVar.ya = this.ya;
            aVar.Ba = this.Ba;
            return aVar;
        }

        /* access modifiers changed from: private */
        public void a(c cVar, int i2, androidx.constraintlayout.widget.g.a aVar) {
            a(i2, aVar);
            if (cVar instanceof Barrier) {
                this.sa = 1;
                Barrier barrier = (Barrier) cVar;
                this.ra = barrier.getType();
                this.ta = barrier.getReferencedIds();
            }
        }

        /* access modifiers changed from: private */
        public void a(int i2, androidx.constraintlayout.widget.g.a aVar) {
            a(i2, (androidx.constraintlayout.widget.ConstraintLayout.a) aVar);
            this.U = aVar.oa;
            this.X = aVar.ra;
            this.Y = aVar.sa;
            this.Z = aVar.ta;
            this.aa = aVar.ua;
            this.ba = aVar.va;
            this.ca = aVar.wa;
            this.da = aVar.xa;
            this.ea = aVar.ya;
            this.fa = aVar.za;
            this.ga = aVar.Aa;
            this.W = aVar.qa;
            this.V = aVar.pa;
        }

        /* access modifiers changed from: private */
        public void a(int i2, androidx.constraintlayout.widget.ConstraintLayout.a aVar) {
            this.f1195d = i2;
            this.f1199h = aVar.f1137d;
            this.f1200i = aVar.f1138e;
            this.f1201j = aVar.f1139f;
            this.f1202k = aVar.f1140g;
            this.f1203l = aVar.f1141h;
            this.m = aVar.f1142i;
            this.n = aVar.f1143j;
            this.o = aVar.f1144k;
            this.p = aVar.f1145l;
            this.q = aVar.p;
            this.r = aVar.q;
            this.s = aVar.r;
            this.t = aVar.s;
            this.u = aVar.z;
            this.v = aVar.A;
            this.w = aVar.B;
            this.x = aVar.m;
            this.y = aVar.n;
            this.z = aVar.o;
            this.A = aVar.Q;
            this.B = aVar.R;
            this.C = aVar.S;
            this.f1198g = aVar.f1136c;
            this.f1196e = aVar.f1134a;
            this.f1197f = aVar.f1135b;
            this.f1193b = aVar.width;
            this.f1194c = aVar.height;
            this.D = aVar.leftMargin;
            this.E = aVar.rightMargin;
            this.F = aVar.topMargin;
            this.G = aVar.bottomMargin;
            this.Q = aVar.F;
            this.R = aVar.E;
            this.T = aVar.H;
            this.S = aVar.G;
            boolean z2 = aVar.T;
            this.ha = z2;
            this.ia = aVar.U;
            this.ja = aVar.I;
            this.ka = aVar.J;
            this.ha = z2;
            this.la = aVar.M;
            this.ma = aVar.N;
            this.na = aVar.K;
            this.oa = aVar.L;
            this.pa = aVar.O;
            this.qa = aVar.P;
            if (VERSION.SDK_INT >= 17) {
                this.H = aVar.getMarginEnd();
                this.I = aVar.getMarginStart();
            }
        }

        public void a(androidx.constraintlayout.widget.ConstraintLayout.a aVar) {
            aVar.f1137d = this.f1199h;
            aVar.f1138e = this.f1200i;
            aVar.f1139f = this.f1201j;
            aVar.f1140g = this.f1202k;
            aVar.f1141h = this.f1203l;
            aVar.f1142i = this.m;
            aVar.f1143j = this.n;
            aVar.f1144k = this.o;
            aVar.f1145l = this.p;
            aVar.p = this.q;
            aVar.q = this.r;
            aVar.r = this.s;
            aVar.s = this.t;
            aVar.leftMargin = this.D;
            aVar.rightMargin = this.E;
            aVar.topMargin = this.F;
            aVar.bottomMargin = this.G;
            aVar.x = this.P;
            aVar.y = this.O;
            aVar.z = this.u;
            aVar.A = this.v;
            aVar.m = this.x;
            aVar.n = this.y;
            aVar.o = this.z;
            aVar.B = this.w;
            aVar.Q = this.A;
            aVar.R = this.B;
            aVar.F = this.Q;
            aVar.E = this.R;
            aVar.H = this.T;
            aVar.G = this.S;
            aVar.T = this.ha;
            aVar.U = this.ia;
            aVar.I = this.ja;
            aVar.J = this.ka;
            aVar.M = this.la;
            aVar.N = this.ma;
            aVar.K = this.na;
            aVar.L = this.oa;
            aVar.O = this.pa;
            aVar.P = this.qa;
            aVar.S = this.C;
            aVar.f1136c = this.f1198g;
            aVar.f1134a = this.f1196e;
            aVar.f1135b = this.f1197f;
            aVar.width = this.f1193b;
            aVar.height = this.f1194c;
            if (VERSION.SDK_INT >= 17) {
                aVar.setMarginStart(this.I);
                aVar.setMarginEnd(this.H);
            }
            aVar.a();
        }
    }

    static {
        f1189b.append(l.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
        f1189b.append(l.ConstraintSet_layout_constraintLeft_toRightOf, 26);
        f1189b.append(l.ConstraintSet_layout_constraintRight_toLeftOf, 29);
        f1189b.append(l.ConstraintSet_layout_constraintRight_toRightOf, 30);
        f1189b.append(l.ConstraintSet_layout_constraintTop_toTopOf, 36);
        f1189b.append(l.ConstraintSet_layout_constraintTop_toBottomOf, 35);
        f1189b.append(l.ConstraintSet_layout_constraintBottom_toTopOf, 4);
        f1189b.append(l.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
        f1189b.append(l.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
        f1189b.append(l.ConstraintSet_layout_editor_absoluteX, 6);
        f1189b.append(l.ConstraintSet_layout_editor_absoluteY, 7);
        f1189b.append(l.ConstraintSet_layout_constraintGuide_begin, 17);
        f1189b.append(l.ConstraintSet_layout_constraintGuide_end, 18);
        f1189b.append(l.ConstraintSet_layout_constraintGuide_percent, 19);
        f1189b.append(l.ConstraintSet_android_orientation, 27);
        f1189b.append(l.ConstraintSet_layout_constraintStart_toEndOf, 32);
        f1189b.append(l.ConstraintSet_layout_constraintStart_toStartOf, 33);
        f1189b.append(l.ConstraintSet_layout_constraintEnd_toStartOf, 10);
        f1189b.append(l.ConstraintSet_layout_constraintEnd_toEndOf, 9);
        f1189b.append(l.ConstraintSet_layout_goneMarginLeft, 13);
        f1189b.append(l.ConstraintSet_layout_goneMarginTop, 16);
        f1189b.append(l.ConstraintSet_layout_goneMarginRight, 14);
        f1189b.append(l.ConstraintSet_layout_goneMarginBottom, 11);
        f1189b.append(l.ConstraintSet_layout_goneMarginStart, 15);
        f1189b.append(l.ConstraintSet_layout_goneMarginEnd, 12);
        f1189b.append(l.ConstraintSet_layout_constraintVertical_weight, 40);
        f1189b.append(l.ConstraintSet_layout_constraintHorizontal_weight, 39);
        f1189b.append(l.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
        f1189b.append(l.ConstraintSet_layout_constraintVertical_chainStyle, 42);
        f1189b.append(l.ConstraintSet_layout_constraintHorizontal_bias, 20);
        f1189b.append(l.ConstraintSet_layout_constraintVertical_bias, 37);
        f1189b.append(l.ConstraintSet_layout_constraintDimensionRatio, 5);
        f1189b.append(l.ConstraintSet_layout_constraintLeft_creator, 76);
        f1189b.append(l.ConstraintSet_layout_constraintTop_creator, 76);
        f1189b.append(l.ConstraintSet_layout_constraintRight_creator, 76);
        f1189b.append(l.ConstraintSet_layout_constraintBottom_creator, 76);
        f1189b.append(l.ConstraintSet_layout_constraintBaseline_creator, 76);
        f1189b.append(l.ConstraintSet_android_layout_marginLeft, 24);
        f1189b.append(l.ConstraintSet_android_layout_marginRight, 28);
        f1189b.append(l.ConstraintSet_android_layout_marginStart, 31);
        f1189b.append(l.ConstraintSet_android_layout_marginEnd, 8);
        f1189b.append(l.ConstraintSet_android_layout_marginTop, 34);
        f1189b.append(l.ConstraintSet_android_layout_marginBottom, 2);
        f1189b.append(l.ConstraintSet_android_layout_width, 23);
        f1189b.append(l.ConstraintSet_android_layout_height, 21);
        f1189b.append(l.ConstraintSet_android_visibility, 22);
        f1189b.append(l.ConstraintSet_android_alpha, 43);
        f1189b.append(l.ConstraintSet_android_elevation, 44);
        f1189b.append(l.ConstraintSet_android_rotationX, 45);
        f1189b.append(l.ConstraintSet_android_rotationY, 46);
        f1189b.append(l.ConstraintSet_android_rotation, 60);
        f1189b.append(l.ConstraintSet_android_scaleX, 47);
        f1189b.append(l.ConstraintSet_android_scaleY, 48);
        f1189b.append(l.ConstraintSet_android_transformPivotX, 49);
        f1189b.append(l.ConstraintSet_android_transformPivotY, 50);
        f1189b.append(l.ConstraintSet_android_translationX, 51);
        f1189b.append(l.ConstraintSet_android_translationY, 52);
        f1189b.append(l.ConstraintSet_android_translationZ, 53);
        f1189b.append(l.ConstraintSet_layout_constraintWidth_default, 54);
        f1189b.append(l.ConstraintSet_layout_constraintHeight_default, 55);
        f1189b.append(l.ConstraintSet_layout_constraintWidth_max, 56);
        f1189b.append(l.ConstraintSet_layout_constraintHeight_max, 57);
        f1189b.append(l.ConstraintSet_layout_constraintWidth_min, 58);
        f1189b.append(l.ConstraintSet_layout_constraintHeight_min, 59);
        f1189b.append(l.ConstraintSet_layout_constraintCircle, 61);
        f1189b.append(l.ConstraintSet_layout_constraintCircleRadius, 62);
        f1189b.append(l.ConstraintSet_layout_constraintCircleAngle, 63);
        f1189b.append(l.ConstraintSet_animate_relativeTo, 64);
        f1189b.append(l.ConstraintSet_transitionEasing, 65);
        f1189b.append(l.ConstraintSet_drawPath, 66);
        f1189b.append(l.ConstraintSet_transitionPathRotate, 67);
        f1189b.append(l.ConstraintSet_android_id, 38);
        f1189b.append(l.ConstraintSet_progress, 68);
        f1189b.append(l.ConstraintSet_layout_constraintWidth_percent, 69);
        f1189b.append(l.ConstraintSet_layout_constraintHeight_percent, 70);
        f1189b.append(l.ConstraintSet_chainUseRtl, 71);
        f1189b.append(l.ConstraintSet_barrierDirection, 72);
        f1189b.append(l.ConstraintSet_constraint_referenced_ids, 73);
        f1189b.append(l.ConstraintSet_barrierAllowsGoneWidgets, 74);
        f1189b.append(l.ConstraintSet_pathMotionArc, 75);
    }

    private String a(int i2) {
        switch (i2) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return OpsMetricTracker.START;
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    public void a(Context context, int i2) {
        c((ConstraintLayout) LayoutInflater.from(context).inflate(i2, null));
    }

    /* access modifiers changed from: 0000 */
    public void b(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f1191d.keySet());
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            int id = childAt.getId();
            String str = "ConstraintSet";
            if (!this.f1191d.containsKey(Integer.valueOf(id))) {
                StringBuilder sb = new StringBuilder();
                sb.append("id unknown ");
                sb.append(b.e.a.b.a.a(childAt));
                Log.v(str, sb.toString());
            } else if (id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (this.f1191d.containsKey(Integer.valueOf(id))) {
                hashSet.remove(Integer.valueOf(id));
                a aVar = (a) this.f1191d.get(Integer.valueOf(id));
                if (childAt instanceof Barrier) {
                    aVar.sa = 1;
                }
                int i3 = aVar.sa;
                if (i3 != -1 && i3 == 1) {
                    Barrier barrier = (Barrier) childAt;
                    barrier.setId(id);
                    barrier.setType(aVar.ra);
                    barrier.setAllowsGoneWidget(aVar.Ba);
                    int[] iArr = aVar.ta;
                    if (iArr != null) {
                        barrier.setReferencedIds(iArr);
                    } else {
                        String str2 = aVar.ua;
                        if (str2 != null) {
                            aVar.ta = a((View) barrier, str2);
                            barrier.setReferencedIds(aVar.ta);
                        }
                    }
                }
                androidx.constraintlayout.widget.ConstraintLayout.a aVar2 = (androidx.constraintlayout.widget.ConstraintLayout.a) childAt.getLayoutParams();
                aVar.a(aVar2);
                b.a(childAt, aVar.Ca);
                childAt.setLayoutParams(aVar2);
                childAt.setVisibility(aVar.J);
                if (VERSION.SDK_INT >= 17) {
                    childAt.setAlpha(aVar.U);
                    childAt.setRotation(aVar.X);
                    childAt.setRotationX(aVar.Y);
                    childAt.setRotationY(aVar.Z);
                    childAt.setScaleX(aVar.aa);
                    childAt.setScaleY(aVar.ba);
                    if (!Float.isNaN(aVar.ca)) {
                        childAt.setPivotX(aVar.ca);
                    }
                    if (!Float.isNaN(aVar.da)) {
                        childAt.setPivotY(aVar.da);
                    }
                    childAt.setTranslationX(aVar.ea);
                    childAt.setTranslationY(aVar.fa);
                    if (VERSION.SDK_INT >= 21) {
                        childAt.setTranslationZ(aVar.ga);
                        if (aVar.V) {
                            childAt.setElevation(aVar.W);
                        }
                    }
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("WARNING NO CONSTRAINTS for view ");
                sb2.append(id);
                Log.v(str, sb2.toString());
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            a aVar3 = (a) this.f1191d.get(num);
            int i4 = aVar3.sa;
            if (i4 != -1 && i4 == 1) {
                Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                int[] iArr2 = aVar3.ta;
                if (iArr2 != null) {
                    barrier2.setReferencedIds(iArr2);
                } else {
                    String str3 = aVar3.ua;
                    if (str3 != null) {
                        aVar3.ta = a((View) barrier2, str3);
                        barrier2.setReferencedIds(aVar3.ta);
                    }
                }
                barrier2.setType(aVar3.ra);
                androidx.constraintlayout.widget.ConstraintLayout.a generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                barrier2.a();
                aVar3.a(generateDefaultLayoutParams);
                constraintLayout.addView(barrier2, generateDefaultLayoutParams);
            }
            if (aVar3.f1192a) {
                i iVar = new i(constraintLayout.getContext());
                iVar.setId(num.intValue());
                androidx.constraintlayout.widget.ConstraintLayout.a generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                aVar3.a(generateDefaultLayoutParams2);
                constraintLayout.addView(iVar, generateDefaultLayoutParams2);
            }
        }
    }

    public void c(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f1191d.clear();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = constraintLayout.getChildAt(i2);
            androidx.constraintlayout.widget.ConstraintLayout.a aVar = (androidx.constraintlayout.widget.ConstraintLayout.a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (id != -1) {
                if (!this.f1191d.containsKey(Integer.valueOf(id))) {
                    this.f1191d.put(Integer.valueOf(id), new a());
                }
                a aVar2 = (a) this.f1191d.get(Integer.valueOf(id));
                aVar2.Ca = b.a(this.f1190c, childAt);
                aVar2.a(id, aVar);
                aVar2.J = childAt.getVisibility();
                if (VERSION.SDK_INT >= 17) {
                    aVar2.U = childAt.getAlpha();
                    aVar2.X = childAt.getRotation();
                    aVar2.Y = childAt.getRotationX();
                    aVar2.Z = childAt.getRotationY();
                    aVar2.aa = childAt.getScaleX();
                    aVar2.ba = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (!(((double) pivotX) == 0.0d && ((double) pivotY) == 0.0d)) {
                        aVar2.ca = pivotX;
                        aVar2.da = pivotY;
                    }
                    aVar2.ea = childAt.getTranslationX();
                    aVar2.fa = childAt.getTranslationY();
                    if (VERSION.SDK_INT >= 21) {
                        aVar2.ga = childAt.getTranslationZ();
                        if (aVar2.V) {
                            aVar2.W = childAt.getElevation();
                        }
                    }
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    aVar2.Ba = barrier.b();
                    aVar2.ta = barrier.getReferencedIds();
                    aVar2.ra = barrier.getType();
                }
                i2++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public void a(g gVar) {
        int childCount = gVar.getChildCount();
        this.f1191d.clear();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = gVar.getChildAt(i2);
            androidx.constraintlayout.widget.g.a aVar = (androidx.constraintlayout.widget.g.a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (id != -1) {
                if (!this.f1191d.containsKey(Integer.valueOf(id))) {
                    this.f1191d.put(Integer.valueOf(id), new a());
                }
                a aVar2 = (a) this.f1191d.get(Integer.valueOf(id));
                if (childAt instanceof c) {
                    aVar2.a((c) childAt, id, aVar);
                }
                aVar2.a(id, aVar);
                i2++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public void a(ConstraintLayout constraintLayout) {
        b(constraintLayout);
        constraintLayout.setConstraintSet(null);
    }

    public void a(int i2, int i3, int i4, int i5, int i6) {
        if (!this.f1191d.containsKey(Integer.valueOf(i2))) {
            this.f1191d.put(Integer.valueOf(i2), new a());
        }
        a aVar = (a) this.f1191d.get(Integer.valueOf(i2));
        String str = "right to ";
        String str2 = " undefined";
        switch (i3) {
            case 1:
                if (i5 == 1) {
                    aVar.f1199h = i4;
                    aVar.f1200i = -1;
                } else if (i5 == 2) {
                    aVar.f1200i = i4;
                    aVar.f1199h = -1;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Left to ");
                    sb.append(a(i5));
                    sb.append(str2);
                    throw new IllegalArgumentException(sb.toString());
                }
                aVar.D = i6;
                return;
            case 2:
                if (i5 == 1) {
                    aVar.f1201j = i4;
                    aVar.f1202k = -1;
                } else if (i5 == 2) {
                    aVar.f1202k = i4;
                    aVar.f1201j = -1;
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(a(i5));
                    sb2.append(str2);
                    throw new IllegalArgumentException(sb2.toString());
                }
                aVar.E = i6;
                return;
            case 3:
                if (i5 == 3) {
                    aVar.f1203l = i4;
                    aVar.m = -1;
                    aVar.p = -1;
                } else if (i5 == 4) {
                    aVar.m = i4;
                    aVar.f1203l = -1;
                    aVar.p = -1;
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str);
                    sb3.append(a(i5));
                    sb3.append(str2);
                    throw new IllegalArgumentException(sb3.toString());
                }
                aVar.F = i6;
                return;
            case 4:
                if (i5 == 4) {
                    aVar.o = i4;
                    aVar.n = -1;
                    aVar.p = -1;
                } else if (i5 == 3) {
                    aVar.n = i4;
                    aVar.o = -1;
                    aVar.p = -1;
                } else {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(str);
                    sb4.append(a(i5));
                    sb4.append(str2);
                    throw new IllegalArgumentException(sb4.toString());
                }
                aVar.G = i6;
                return;
            case 5:
                if (i5 == 5) {
                    aVar.p = i4;
                    aVar.o = -1;
                    aVar.n = -1;
                    aVar.f1203l = -1;
                    aVar.m = -1;
                    return;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str);
                sb5.append(a(i5));
                sb5.append(str2);
                throw new IllegalArgumentException(sb5.toString());
            case 6:
                if (i5 == 6) {
                    aVar.r = i4;
                    aVar.q = -1;
                } else if (i5 == 7) {
                    aVar.q = i4;
                    aVar.r = -1;
                } else {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(str);
                    sb6.append(a(i5));
                    sb6.append(str2);
                    throw new IllegalArgumentException(sb6.toString());
                }
                aVar.I = i6;
                return;
            case 7:
                if (i5 == 7) {
                    aVar.t = i4;
                    aVar.s = -1;
                } else if (i5 == 6) {
                    aVar.s = i4;
                    aVar.t = -1;
                } else {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(str);
                    sb7.append(a(i5));
                    sb7.append(str2);
                    throw new IllegalArgumentException(sb7.toString());
                }
                aVar.H = i6;
                return;
            default:
                StringBuilder sb8 = new StringBuilder();
                sb8.append(a(i3));
                sb8.append(" to ");
                sb8.append(a(i5));
                sb8.append(" unknown");
                throw new IllegalArgumentException(sb8.toString());
        }
    }

    public void b(Context context, int i2) {
        XmlResourceParser xml = context.getResources().getXml(i2);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    a a2 = a(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        a2.f1192a = true;
                    }
                    this.f1191d.put(Integer.valueOf(a2.f1195d), a2);
                }
            }
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public void a(int i2, int i3, int i4, int i5) {
        if (!this.f1191d.containsKey(Integer.valueOf(i2))) {
            this.f1191d.put(Integer.valueOf(i2), new a());
        }
        a aVar = (a) this.f1191d.get(Integer.valueOf(i2));
        String str = "right to ";
        String str2 = " undefined";
        switch (i3) {
            case 1:
                if (i5 == 1) {
                    aVar.f1199h = i4;
                    aVar.f1200i = -1;
                    return;
                } else if (i5 == 2) {
                    aVar.f1200i = i4;
                    aVar.f1199h = -1;
                    return;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("left to ");
                    sb.append(a(i5));
                    sb.append(str2);
                    throw new IllegalArgumentException(sb.toString());
                }
            case 2:
                if (i5 == 1) {
                    aVar.f1201j = i4;
                    aVar.f1202k = -1;
                    return;
                } else if (i5 == 2) {
                    aVar.f1202k = i4;
                    aVar.f1201j = -1;
                    return;
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(a(i5));
                    sb2.append(str2);
                    throw new IllegalArgumentException(sb2.toString());
                }
            case 3:
                if (i5 == 3) {
                    aVar.f1203l = i4;
                    aVar.m = -1;
                    aVar.p = -1;
                    return;
                } else if (i5 == 4) {
                    aVar.m = i4;
                    aVar.f1203l = -1;
                    aVar.p = -1;
                    return;
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str);
                    sb3.append(a(i5));
                    sb3.append(str2);
                    throw new IllegalArgumentException(sb3.toString());
                }
            case 4:
                if (i5 == 4) {
                    aVar.o = i4;
                    aVar.n = -1;
                    aVar.p = -1;
                    return;
                } else if (i5 == 3) {
                    aVar.n = i4;
                    aVar.o = -1;
                    aVar.p = -1;
                    return;
                } else {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(str);
                    sb4.append(a(i5));
                    sb4.append(str2);
                    throw new IllegalArgumentException(sb4.toString());
                }
            case 5:
                if (i5 == 5) {
                    aVar.p = i4;
                    aVar.o = -1;
                    aVar.n = -1;
                    aVar.f1203l = -1;
                    aVar.m = -1;
                    return;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str);
                sb5.append(a(i5));
                sb5.append(str2);
                throw new IllegalArgumentException(sb5.toString());
            case 6:
                if (i5 == 6) {
                    aVar.r = i4;
                    aVar.q = -1;
                    return;
                } else if (i5 == 7) {
                    aVar.q = i4;
                    aVar.r = -1;
                    return;
                } else {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(str);
                    sb6.append(a(i5));
                    sb6.append(str2);
                    throw new IllegalArgumentException(sb6.toString());
                }
            case 7:
                if (i5 == 7) {
                    aVar.t = i4;
                    aVar.s = -1;
                    return;
                } else if (i5 == 6) {
                    aVar.s = i4;
                    aVar.t = -1;
                    return;
                } else {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(str);
                    sb7.append(a(i5));
                    sb7.append(str2);
                    throw new IllegalArgumentException(sb7.toString());
                }
            default:
                StringBuilder sb8 = new StringBuilder();
                sb8.append(a(i3));
                sb8.append(" to ");
                sb8.append(a(i5));
                sb8.append(" unknown");
                throw new IllegalArgumentException(sb8.toString());
        }
    }

    public void a(Context context, XmlPullParser xmlPullParser) {
        a a2;
        try {
            int eventType = xmlPullParser.getEventType();
            a aVar = null;
            while (eventType != 1) {
                if (eventType != 0) {
                    String str = "Constraint";
                    if (eventType == 2) {
                        String name = xmlPullParser.getName();
                        if (name.equalsIgnoreCase(str)) {
                            a2 = a(context, Xml.asAttributeSet(xmlPullParser));
                        } else if (name.equalsIgnoreCase("Guideline")) {
                            a2 = a(context, Xml.asAttributeSet(xmlPullParser));
                            a2.f1192a = true;
                        } else if (name.equalsIgnoreCase("CustomAttribute")) {
                            b.a(context, xmlPullParser, aVar.Ca);
                        }
                        aVar = a2;
                    } else if (eventType != 3) {
                        continue;
                    } else {
                        String name2 = xmlPullParser.getName();
                        if (!"ConstraintSet".equals(name2)) {
                            if (name2.equalsIgnoreCase(str)) {
                                this.f1191d.put(Integer.valueOf(aVar.f1195d), aVar);
                                aVar = null;
                            }
                        } else {
                            return;
                        }
                    }
                } else {
                    xmlPullParser.getName();
                }
                eventType = xmlPullParser.next();
            }
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    private static int a(TypedArray typedArray, int i2, int i3) {
        int resourceId = typedArray.getResourceId(i2, i3);
        return resourceId == -1 ? typedArray.getInt(i2, -1) : resourceId;
    }

    private a a(Context context, AttributeSet attributeSet) {
        a aVar = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.ConstraintSet);
        a(aVar, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return aVar;
    }

    private void a(a aVar, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArray.getIndex(i2);
            int i3 = f1189b.get(index);
            switch (i3) {
                case 1:
                    aVar.p = a(typedArray, index, aVar.p);
                    break;
                case 2:
                    aVar.G = typedArray.getDimensionPixelSize(index, aVar.G);
                    break;
                case 3:
                    aVar.o = a(typedArray, index, aVar.o);
                    break;
                case 4:
                    aVar.n = a(typedArray, index, aVar.n);
                    break;
                case 5:
                    aVar.w = typedArray.getString(index);
                    break;
                case 6:
                    aVar.A = typedArray.getDimensionPixelOffset(index, aVar.A);
                    break;
                case 7:
                    aVar.B = typedArray.getDimensionPixelOffset(index, aVar.B);
                    break;
                case 8:
                    aVar.H = typedArray.getDimensionPixelSize(index, aVar.H);
                    break;
                case 9:
                    aVar.t = a(typedArray, index, aVar.t);
                    break;
                case 10:
                    aVar.s = a(typedArray, index, aVar.s);
                    break;
                case 11:
                    aVar.N = typedArray.getDimensionPixelSize(index, aVar.N);
                    break;
                case 12:
                    aVar.O = typedArray.getDimensionPixelSize(index, aVar.O);
                    break;
                case 13:
                    aVar.K = typedArray.getDimensionPixelSize(index, aVar.K);
                    break;
                case 14:
                    aVar.M = typedArray.getDimensionPixelSize(index, aVar.M);
                    break;
                case 15:
                    aVar.P = typedArray.getDimensionPixelSize(index, aVar.P);
                    break;
                case 16:
                    aVar.L = typedArray.getDimensionPixelSize(index, aVar.L);
                    break;
                case 17:
                    aVar.f1196e = typedArray.getDimensionPixelOffset(index, aVar.f1196e);
                    break;
                case 18:
                    aVar.f1197f = typedArray.getDimensionPixelOffset(index, aVar.f1197f);
                    break;
                case 19:
                    aVar.f1198g = typedArray.getFloat(index, aVar.f1198g);
                    break;
                case 20:
                    aVar.u = typedArray.getFloat(index, aVar.u);
                    break;
                case 21:
                    aVar.f1194c = typedArray.getLayoutDimension(index, aVar.f1194c);
                    break;
                case 22:
                    aVar.J = typedArray.getInt(index, aVar.J);
                    aVar.J = f1188a[aVar.J];
                    break;
                case 23:
                    aVar.f1193b = typedArray.getLayoutDimension(index, aVar.f1193b);
                    break;
                case 24:
                    aVar.D = typedArray.getDimensionPixelSize(index, aVar.D);
                    break;
                case 25:
                    aVar.f1199h = a(typedArray, index, aVar.f1199h);
                    break;
                case 26:
                    aVar.f1200i = a(typedArray, index, aVar.f1200i);
                    break;
                case 27:
                    aVar.C = typedArray.getInt(index, aVar.C);
                    break;
                case 28:
                    aVar.E = typedArray.getDimensionPixelSize(index, aVar.E);
                    break;
                case 29:
                    aVar.f1201j = a(typedArray, index, aVar.f1201j);
                    break;
                case 30:
                    aVar.f1202k = a(typedArray, index, aVar.f1202k);
                    break;
                case 31:
                    aVar.I = typedArray.getDimensionPixelSize(index, aVar.I);
                    break;
                case 32:
                    aVar.q = a(typedArray, index, aVar.q);
                    break;
                case 33:
                    aVar.r = a(typedArray, index, aVar.r);
                    break;
                case 34:
                    aVar.F = typedArray.getDimensionPixelSize(index, aVar.F);
                    break;
                case 35:
                    aVar.m = a(typedArray, index, aVar.m);
                    break;
                case 36:
                    aVar.f1203l = a(typedArray, index, aVar.f1203l);
                    break;
                case 37:
                    aVar.v = typedArray.getFloat(index, aVar.v);
                    break;
                case 38:
                    aVar.f1195d = typedArray.getResourceId(index, aVar.f1195d);
                    break;
                case 39:
                    aVar.R = typedArray.getFloat(index, aVar.R);
                    break;
                case 40:
                    aVar.Q = typedArray.getFloat(index, aVar.Q);
                    break;
                case 41:
                    aVar.S = typedArray.getInt(index, aVar.S);
                    break;
                case 42:
                    aVar.T = typedArray.getInt(index, aVar.T);
                    break;
                case 43:
                    aVar.U = typedArray.getFloat(index, aVar.U);
                    break;
                case 44:
                    aVar.V = true;
                    aVar.W = typedArray.getDimension(index, aVar.W);
                    break;
                case 45:
                    aVar.Y = typedArray.getFloat(index, aVar.Y);
                    break;
                case 46:
                    aVar.Z = typedArray.getFloat(index, aVar.Z);
                    break;
                case 47:
                    aVar.aa = typedArray.getFloat(index, aVar.aa);
                    break;
                case 48:
                    aVar.ba = typedArray.getFloat(index, aVar.ba);
                    break;
                case 49:
                    aVar.ca = typedArray.getFloat(index, aVar.ca);
                    break;
                case 50:
                    aVar.da = typedArray.getFloat(index, aVar.da);
                    break;
                case 51:
                    aVar.ea = typedArray.getDimension(index, aVar.ea);
                    break;
                case 52:
                    aVar.fa = typedArray.getDimension(index, aVar.fa);
                    break;
                case 53:
                    if (VERSION.SDK_INT < 21) {
                        break;
                    } else {
                        aVar.ga = typedArray.getDimension(index, aVar.ga);
                        break;
                    }
                default:
                    String str = "   ";
                    String str2 = "ConstraintSet";
                    switch (i3) {
                        case 60:
                            aVar.X = typedArray.getFloat(index, aVar.X);
                            break;
                        case 61:
                            aVar.x = a(typedArray, index, aVar.x);
                            break;
                        case 62:
                            aVar.y = typedArray.getDimensionPixelSize(index, aVar.y);
                            break;
                        case 63:
                            aVar.z = typedArray.getFloat(index, aVar.z);
                            break;
                        case 64:
                            aVar.va = a(typedArray, index, aVar.va);
                            break;
                        case 65:
                            if (typedArray.peekValue(index).type != 3) {
                                aVar.wa = b.e.a.a.a.f2318b[typedArray.getInteger(index, 0)];
                                break;
                            } else {
                                aVar.wa = typedArray.getString(index);
                                break;
                            }
                        case 66:
                            aVar.ya = typedArray.getInt(index, 0);
                            break;
                        case 67:
                            aVar.za = typedArray.getFloat(index, aVar.za);
                            break;
                        case 68:
                            aVar.Aa = typedArray.getFloat(index, aVar.Aa);
                            break;
                        case 69:
                            aVar.pa = typedArray.getFloat(index, 1.0f);
                            break;
                        case 70:
                            aVar.qa = typedArray.getFloat(index, 1.0f);
                            break;
                        case 71:
                            Log.e(str2, "CURRENTLY UNSUPPORTED");
                            break;
                        case 72:
                            aVar.ra = typedArray.getInt(index, aVar.ra);
                            break;
                        case 73:
                            aVar.ua = typedArray.getString(index);
                            break;
                        case 74:
                            aVar.Ba = typedArray.getBoolean(index, aVar.Ba);
                            break;
                        case 75:
                            aVar.xa = typedArray.getInt(index, aVar.xa);
                            break;
                        case 76:
                            StringBuilder sb = new StringBuilder();
                            sb.append("unused attribute 0x");
                            sb.append(Integer.toHexString(index));
                            sb.append(str);
                            sb.append(f1189b.get(index));
                            Log.w(str2, sb.toString());
                            break;
                        default:
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Unknown attribute 0x");
                            sb2.append(Integer.toHexString(index));
                            sb2.append(str);
                            sb2.append(f1189b.get(index));
                            Log.w(str2, sb2.toString());
                            break;
                    }
            }
        }
    }

    private int[] a(View view, String str) {
        int i2;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i3 = 0;
        int i4 = 0;
        while (i3 < split.length) {
            String trim = split[i3].trim();
            try {
                i2 = k.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i2 = 0;
            }
            if (i2 == 0) {
                i2 = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i2 == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout)) {
                Object a2 = ((ConstraintLayout) view.getParent()).a(0, (Object) trim);
                if (a2 != null && (a2 instanceof Integer)) {
                    i2 = ((Integer) a2).intValue();
                }
            }
            int i5 = i4 + 1;
            iArr[i4] = i2;
            i3++;
            i4 = i5;
        }
        return i4 != split.length ? Arrays.copyOf(iArr, i4) : iArr;
    }
}
