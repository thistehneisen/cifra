package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow.OnDismissListener;
import androidx.appcompat.view.menu.v.a;
import b.a.d;
import b.g.i.B;
import b.g.i.C0243d;

/* compiled from: MenuPopupHelper */
public class u implements n {

    /* renamed from: a reason: collision with root package name */
    private final Context f686a;

    /* renamed from: b reason: collision with root package name */
    private final l f687b;

    /* renamed from: c reason: collision with root package name */
    private final boolean f688c;

    /* renamed from: d reason: collision with root package name */
    private final int f689d;

    /* renamed from: e reason: collision with root package name */
    private final int f690e;

    /* renamed from: f reason: collision with root package name */
    private View f691f;

    /* renamed from: g reason: collision with root package name */
    private int f692g;

    /* renamed from: h reason: collision with root package name */
    private boolean f693h;

    /* renamed from: i reason: collision with root package name */
    private a f694i;

    /* renamed from: j reason: collision with root package name */
    private s f695j;

    /* renamed from: k reason: collision with root package name */
    private OnDismissListener f696k;

    /* renamed from: l reason: collision with root package name */
    private final OnDismissListener f697l;

    public u(Context context, l lVar, View view, boolean z, int i2) {
        this(context, lVar, view, z, i2, 0);
    }

    /* JADX WARNING: type inference failed for: r0v7, types: [androidx.appcompat.view.menu.v, androidx.appcompat.view.menu.s] */
    /* JADX WARNING: type inference failed for: r7v0, types: [androidx.appcompat.view.menu.C] */
    /* JADX WARNING: type inference failed for: r1v12, types: [androidx.appcompat.view.menu.i] */
    /* JADX WARNING: type inference failed for: r7v1, types: [androidx.appcompat.view.menu.C] */
    /* JADX WARNING: type inference failed for: r1v13, types: [androidx.appcompat.view.menu.i] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r7v1, types: [androidx.appcompat.view.menu.C]
      assigns: [androidx.appcompat.view.menu.C, androidx.appcompat.view.menu.i]
      uses: [androidx.appcompat.view.menu.C, androidx.appcompat.view.menu.s, androidx.appcompat.view.menu.v, androidx.appcompat.view.menu.i]
      mth insns count: 49
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 3 */
    private s g() {
        ? r0;
        Display defaultDisplay = ((WindowManager) this.f686a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        if (Math.min(point.x, point.y) >= this.f686a.getResources().getDimensionPixelSize(d.abc_cascading_menus_min_smallest_width)) {
            ? iVar = new i(this.f686a, this.f691f, this.f689d, this.f690e, this.f688c);
            r0 = iVar;
        } else {
            ? c2 = new C(this.f686a, this.f687b, this.f691f, this.f689d, this.f690e, this.f688c);
            r0 = c2;
        }
        r0.a(this.f687b);
        r0.a(this.f697l);
        r0.a(this.f691f);
        r0.a(this.f694i);
        r0.b(this.f693h);
        r0.a(this.f692g);
        return r0;
    }

    public void a(OnDismissListener onDismissListener) {
        this.f696k = onDismissListener;
    }

    public s b() {
        if (this.f695j == null) {
            this.f695j = g();
        }
        return this.f695j;
    }

    public boolean c() {
        s sVar = this.f695j;
        return sVar != null && sVar.c();
    }

    /* access modifiers changed from: protected */
    public void d() {
        this.f695j = null;
        OnDismissListener onDismissListener = this.f696k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void e() {
        if (!f()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean f() {
        if (c()) {
            return true;
        }
        if (this.f691f == null) {
            return false;
        }
        a(0, 0, false, false);
        return true;
    }

    public u(Context context, l lVar, View view, boolean z, int i2, int i3) {
        this.f692g = 8388611;
        this.f697l = new t(this);
        this.f686a = context;
        this.f687b = lVar;
        this.f691f = view;
        this.f688c = z;
        this.f689d = i2;
        this.f690e = i3;
    }

    public void a(View view) {
        this.f691f = view;
    }

    public void a(boolean z) {
        this.f693h = z;
        s sVar = this.f695j;
        if (sVar != null) {
            sVar.b(z);
        }
    }

    public void a(int i2) {
        this.f692g = i2;
    }

    public boolean a(int i2, int i3) {
        if (c()) {
            return true;
        }
        if (this.f691f == null) {
            return false;
        }
        a(i2, i3, true, true);
        return true;
    }

    private void a(int i2, int i3, boolean z, boolean z2) {
        s b2 = b();
        b2.c(z2);
        if (z) {
            if ((C0243d.a(this.f692g, B.m(this.f691f)) & 7) == 5) {
                i2 -= this.f691f.getWidth();
            }
            b2.b(i2);
            b2.c(i3);
            int i4 = (int) ((this.f686a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            b2.a(new Rect(i2 - i4, i3 - i4, i2 + i4, i3 + i4));
        }
        b2.b();
    }

    public void a() {
        if (c()) {
            this.f695j.dismiss();
        }
    }

    public void a(a aVar) {
        this.f694i = aVar;
        s sVar = this.f695j;
        if (sVar != null) {
            sVar.a(aVar);
        }
    }
}
