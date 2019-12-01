package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import b.a.d;
import b.a.f;
import b.a.g;
import b.a.i;
import io.fabric.sdk.android.a.b.C0730a;

/* compiled from: TooltipPopup */
class Ea {

    /* renamed from: a reason: collision with root package name */
    private final Context f774a;

    /* renamed from: b reason: collision with root package name */
    private final View f775b;

    /* renamed from: c reason: collision with root package name */
    private final TextView f776c;

    /* renamed from: d reason: collision with root package name */
    private final LayoutParams f777d = new LayoutParams();

    /* renamed from: e reason: collision with root package name */
    private final Rect f778e = new Rect();

    /* renamed from: f reason: collision with root package name */
    private final int[] f779f = new int[2];

    /* renamed from: g reason: collision with root package name */
    private final int[] f780g = new int[2];

    Ea(Context context) {
        this.f774a = context;
        this.f775b = LayoutInflater.from(this.f774a).inflate(g.abc_tooltip, null);
        this.f776c = (TextView) this.f775b.findViewById(f.message);
        this.f777d.setTitle(Ea.class.getSimpleName());
        this.f777d.packageName = this.f774a.getPackageName();
        LayoutParams layoutParams = this.f777d;
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = i.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    /* access modifiers changed from: 0000 */
    public void a(View view, int i2, int i3, boolean z, CharSequence charSequence) {
        if (b()) {
            a();
        }
        this.f776c.setText(charSequence);
        a(view, i2, i3, z, this.f777d);
        ((WindowManager) this.f774a.getSystemService("window")).addView(this.f775b, this.f777d);
    }

    /* access modifiers changed from: 0000 */
    public boolean b() {
        return this.f775b.getParent() != null;
    }

    /* access modifiers changed from: 0000 */
    public void a() {
        if (b()) {
            ((WindowManager) this.f774a.getSystemService("window")).removeView(this.f775b);
        }
    }

    private void a(View view, int i2, int i3, boolean z, LayoutParams layoutParams) {
        int i4;
        int i5;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f774a.getResources().getDimensionPixelOffset(d.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i2 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f774a.getResources().getDimensionPixelOffset(d.tooltip_precise_anchor_extra_offset);
            i5 = i3 + dimensionPixelOffset2;
            i4 = i3 - dimensionPixelOffset2;
        } else {
            i5 = view.getHeight();
            i4 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f774a.getResources().getDimensionPixelOffset(z ? d.tooltip_y_offset_touch : d.tooltip_y_offset_non_touch);
        View a2 = a(view);
        if (a2 == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        a2.getWindowVisibleDisplayFrame(this.f778e);
        Rect rect = this.f778e;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources = this.f774a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", C0730a.ANDROID_CLIENT_TYPE);
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f778e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        a2.getLocationOnScreen(this.f780g);
        view.getLocationOnScreen(this.f779f);
        int[] iArr = this.f779f;
        int i6 = iArr[0];
        int[] iArr2 = this.f780g;
        iArr[0] = i6 - iArr2[0];
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (iArr[0] + i2) - (a2.getWidth() / 2);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        this.f775b.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.f775b.getMeasuredHeight();
        int[] iArr3 = this.f779f;
        int i7 = ((iArr3[1] + i4) - dimensionPixelOffset3) - measuredHeight;
        int i8 = iArr3[1] + i5 + dimensionPixelOffset3;
        if (z) {
            if (i7 >= 0) {
                layoutParams.y = i7;
            } else {
                layoutParams.y = i8;
            }
        } else if (measuredHeight + i8 <= this.f778e.height()) {
            layoutParams.y = i8;
        } else {
            layoutParams.y = i7;
        }
    }

    private static View a(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof LayoutParams) && ((LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }
}
