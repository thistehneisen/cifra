package c.b.a.c.i;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.util.StateSet;

/* compiled from: RippleUtils */
public class a {

    /* renamed from: a reason: collision with root package name */
    public static final boolean f3163a = (VERSION.SDK_INT >= 21);

    /* renamed from: b reason: collision with root package name */
    private static final int[] f3164b = {16842919};

    /* renamed from: c reason: collision with root package name */
    private static final int[] f3165c = {16843623, 16842908};

    /* renamed from: d reason: collision with root package name */
    private static final int[] f3166d = {16842908};

    /* renamed from: e reason: collision with root package name */
    private static final int[] f3167e = {16843623};

    /* renamed from: f reason: collision with root package name */
    private static final int[] f3168f = {16842913, 16842919};

    /* renamed from: g reason: collision with root package name */
    private static final int[] f3169g = {16842913, 16843623, 16842908};

    /* renamed from: h reason: collision with root package name */
    private static final int[] f3170h = {16842913, 16842908};

    /* renamed from: i reason: collision with root package name */
    private static final int[] f3171i = {16842913, 16843623};

    /* renamed from: j reason: collision with root package name */
    private static final int[] f3172j = {16842913};

    public static ColorStateList a(ColorStateList colorStateList) {
        if (f3163a) {
            return new ColorStateList(new int[][]{f3172j, StateSet.NOTHING}, new int[]{a(colorStateList, f3168f), a(colorStateList, f3164b)});
        }
        int[] iArr = f3168f;
        int[] iArr2 = f3169g;
        int[] iArr3 = f3170h;
        int[] iArr4 = f3171i;
        int[] iArr5 = f3164b;
        int[] iArr6 = f3165c;
        int[] iArr7 = f3166d;
        int[] iArr8 = f3167e;
        return new ColorStateList(new int[][]{iArr, iArr2, iArr3, iArr4, f3172j, iArr5, iArr6, iArr7, iArr8, StateSet.NOTHING}, new int[]{a(colorStateList, iArr), a(colorStateList, iArr2), a(colorStateList, iArr3), a(colorStateList, iArr4), 0, a(colorStateList, iArr5), a(colorStateList, iArr6), a(colorStateList, iArr7), a(colorStateList, iArr8), 0});
    }

    private static int a(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return f3163a ? a(colorForState) : colorForState;
    }

    @TargetApi(21)
    private static int a(int i2) {
        return b.g.b.a.b(i2, Math.min(Color.alpha(i2) * 2, 255));
    }
}
