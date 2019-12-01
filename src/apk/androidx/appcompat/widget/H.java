package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import b.a.j;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: AppCompatTextViewAutoSizeHelper */
class H {

    /* renamed from: a reason: collision with root package name */
    private static final RectF f799a = new RectF();

    /* renamed from: b reason: collision with root package name */
    private static ConcurrentHashMap<String, Method> f800b = new ConcurrentHashMap<>();

    /* renamed from: c reason: collision with root package name */
    private int f801c = 0;

    /* renamed from: d reason: collision with root package name */
    private boolean f802d = false;

    /* renamed from: e reason: collision with root package name */
    private float f803e = -1.0f;

    /* renamed from: f reason: collision with root package name */
    private float f804f = -1.0f;

    /* renamed from: g reason: collision with root package name */
    private float f805g = -1.0f;

    /* renamed from: h reason: collision with root package name */
    private int[] f806h = new int[0];

    /* renamed from: i reason: collision with root package name */
    private boolean f807i = false;

    /* renamed from: j reason: collision with root package name */
    private TextPaint f808j;

    /* renamed from: k reason: collision with root package name */
    private final TextView f809k;

    /* renamed from: l reason: collision with root package name */
    private final Context f810l;

    H(TextView textView) {
        this.f809k = textView;
        this.f810l = this.f809k.getContext();
    }

    private void h() {
        this.f801c = 0;
        this.f804f = -1.0f;
        this.f805g = -1.0f;
        this.f803e = -1.0f;
        this.f806h = new int[0];
        this.f802d = false;
    }

    private boolean i() {
        if (!k() || this.f801c != 1) {
            this.f802d = false;
        } else {
            if (!this.f807i || this.f806h.length == 0) {
                float round = (float) Math.round(this.f804f);
                int i2 = 1;
                while (Math.round(this.f803e + round) <= Math.round(this.f805g)) {
                    i2++;
                    round += this.f803e;
                }
                int[] iArr = new int[i2];
                float f2 = this.f804f;
                for (int i3 = 0; i3 < i2; i3++) {
                    iArr[i3] = Math.round(f2);
                    f2 += this.f803e;
                }
                this.f806h = a(iArr);
            }
            this.f802d = true;
        }
        return this.f802d;
    }

    private boolean j() {
        int length = this.f806h.length;
        this.f807i = length > 0;
        if (this.f807i) {
            this.f801c = 1;
            int[] iArr = this.f806h;
            this.f804f = (float) iArr[0];
            this.f805g = (float) iArr[length - 1];
            this.f803e = -1.0f;
        }
        return this.f807i;
    }

    private boolean k() {
        return !(this.f809k instanceof C0176p);
    }

    /* access modifiers changed from: 0000 */
    public void a(AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = this.f810l.obtainStyledAttributes(attributeSet, j.AppCompatTextView, i2, 0);
        if (obtainStyledAttributes.hasValue(j.AppCompatTextView_autoSizeTextType)) {
            this.f801c = obtainStyledAttributes.getInt(j.AppCompatTextView_autoSizeTextType, 0);
        }
        float dimension = obtainStyledAttributes.hasValue(j.AppCompatTextView_autoSizeStepGranularity) ? obtainStyledAttributes.getDimension(j.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
        float dimension2 = obtainStyledAttributes.hasValue(j.AppCompatTextView_autoSizeMinTextSize) ? obtainStyledAttributes.getDimension(j.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float dimension3 = obtainStyledAttributes.hasValue(j.AppCompatTextView_autoSizeMaxTextSize) ? obtainStyledAttributes.getDimension(j.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (obtainStyledAttributes.hasValue(j.AppCompatTextView_autoSizePresetSizes)) {
            int resourceId = obtainStyledAttributes.getResourceId(j.AppCompatTextView_autoSizePresetSizes, 0);
            if (resourceId > 0) {
                TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
                a(obtainTypedArray);
                obtainTypedArray.recycle();
            }
        }
        obtainStyledAttributes.recycle();
        if (!k()) {
            this.f801c = 0;
        } else if (this.f801c == 1) {
            if (!this.f807i) {
                DisplayMetrics displayMetrics = this.f810l.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                a(dimension2, dimension3, dimension);
            }
            i();
        }
    }

    /* access modifiers changed from: 0000 */
    public int b() {
        return Math.round(this.f805g);
    }

    /* access modifiers changed from: 0000 */
    public int c() {
        return Math.round(this.f804f);
    }

    /* access modifiers changed from: 0000 */
    public int d() {
        return Math.round(this.f803e);
    }

    /* access modifiers changed from: 0000 */
    public int[] e() {
        return this.f806h;
    }

    /* access modifiers changed from: 0000 */
    public int f() {
        return this.f801c;
    }

    /* access modifiers changed from: 0000 */
    public boolean g() {
        return k() && this.f801c != 0;
    }

    /* access modifiers changed from: 0000 */
    public void a(int i2) {
        if (!k()) {
            return;
        }
        if (i2 == 0) {
            h();
        } else if (i2 == 1) {
            DisplayMetrics displayMetrics = this.f810l.getResources().getDisplayMetrics();
            a(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (i()) {
                a();
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unknown auto-size text type: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        if (k()) {
            DisplayMetrics displayMetrics = this.f810l.getResources().getDisplayMetrics();
            a(TypedValue.applyDimension(i5, (float) i2, displayMetrics), TypedValue.applyDimension(i5, (float) i3, displayMetrics), TypedValue.applyDimension(i5, (float) i4, displayMetrics));
            if (i()) {
                a();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(int[] iArr, int i2) throws IllegalArgumentException {
        if (k()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i2 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f810l.getResources().getDisplayMetrics();
                    for (int i3 = 0; i3 < length; i3++) {
                        iArr2[i3] = Math.round(TypedValue.applyDimension(i2, (float) iArr[i3], displayMetrics));
                    }
                }
                this.f806h = a(iArr2);
                if (!j()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("None of the preset sizes is valid: ");
                    sb.append(Arrays.toString(iArr));
                    throw new IllegalArgumentException(sb.toString());
                }
            } else {
                this.f807i = false;
            }
            if (i()) {
                a();
            }
        }
    }

    private void a(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = typedArray.getDimensionPixelSize(i2, -1);
            }
            this.f806h = a(iArr);
            j();
        }
    }

    private int[] a(int[] iArr) {
        if (r0 == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            if (i2 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i2)) < 0) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        if (r0 == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
        }
        return iArr2;
    }

    private void a(float f2, float f3, float f4) throws IllegalArgumentException {
        String str = "px) is less or equal to (0px)";
        if (f2 <= 0.0f) {
            StringBuilder sb = new StringBuilder();
            sb.append("Minimum auto-size text size (");
            sb.append(f2);
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        } else if (f3 <= f2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Maximum auto-size text size (");
            sb2.append(f3);
            sb2.append("px) is less or equal to minimum auto-size ");
            sb2.append("text size (");
            sb2.append(f2);
            sb2.append("px)");
            throw new IllegalArgumentException(sb2.toString());
        } else if (f4 > 0.0f) {
            this.f801c = 1;
            this.f804f = f2;
            this.f805g = f3;
            this.f803e = f4;
            this.f807i = false;
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("The auto-size step granularity (");
            sb3.append(f4);
            sb3.append(str);
            throw new IllegalArgumentException(sb3.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    public void a() {
        int i2;
        if (g()) {
            if (this.f802d) {
                if (this.f809k.getMeasuredHeight() > 0 && this.f809k.getMeasuredWidth() > 0) {
                    if (((Boolean) a((Object) this.f809k, "getHorizontallyScrolling", (T) Boolean.valueOf(false))).booleanValue()) {
                        i2 = 1048576;
                    } else {
                        i2 = (this.f809k.getMeasuredWidth() - this.f809k.getTotalPaddingLeft()) - this.f809k.getTotalPaddingRight();
                    }
                    int height = (this.f809k.getHeight() - this.f809k.getCompoundPaddingBottom()) - this.f809k.getCompoundPaddingTop();
                    if (i2 > 0 && height > 0) {
                        synchronized (f799a) {
                            f799a.setEmpty();
                            f799a.right = (float) i2;
                            f799a.bottom = (float) height;
                            float a2 = (float) a(f799a);
                            if (a2 != this.f809k.getTextSize()) {
                                a(0, a2);
                            }
                        }
                    }
                }
                return;
            }
            this.f802d = true;
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(int i2, float f2) {
        Resources resources;
        Context context = this.f810l;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        a(TypedValue.applyDimension(i2, f2, resources.getDisplayMetrics()));
    }

    private void a(float f2) {
        if (f2 != this.f809k.getPaint().getTextSize()) {
            this.f809k.getPaint().setTextSize(f2);
            boolean isInLayout = VERSION.SDK_INT >= 18 ? this.f809k.isInLayout() : false;
            if (this.f809k.getLayout() != null) {
                this.f802d = false;
                try {
                    Method a2 = a("nullLayouts");
                    if (a2 != null) {
                        a2.invoke(this.f809k, new Object[0]);
                    }
                } catch (Exception e2) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e2);
                }
                if (!isInLayout) {
                    this.f809k.requestLayout();
                } else {
                    this.f809k.forceLayout();
                }
                this.f809k.invalidate();
            }
        }
    }

    private int a(RectF rectF) {
        int length = this.f806h.length;
        if (length != 0) {
            int i2 = length - 1;
            int i3 = 1;
            int i4 = 0;
            while (i3 <= i2) {
                int i5 = (i3 + i2) / 2;
                if (a(this.f806h[i5], rectF)) {
                    int i6 = i5 + 1;
                    i4 = i3;
                    i3 = i6;
                } else {
                    i4 = i5 - 1;
                    i2 = i4;
                }
            }
            return this.f806h[i4];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    private boolean a(int i2, RectF rectF) {
        StaticLayout staticLayout;
        CharSequence text = this.f809k.getText();
        TransformationMethod transformationMethod = this.f809k.getTransformationMethod();
        if (transformationMethod != null) {
            CharSequence transformation = transformationMethod.getTransformation(text, this.f809k);
            if (transformation != null) {
                text = transformation;
            }
        }
        int maxLines = VERSION.SDK_INT >= 16 ? this.f809k.getMaxLines() : -1;
        TextPaint textPaint = this.f808j;
        if (textPaint == null) {
            this.f808j = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f808j.set(this.f809k.getPaint());
        this.f808j.setTextSize((float) i2);
        Alignment alignment = (Alignment) a((Object) this.f809k, "getLayoutAlignment", (T) Alignment.ALIGN_NORMAL);
        if (VERSION.SDK_INT >= 23) {
            staticLayout = a(text, alignment, Math.round(rectF.right), maxLines);
        } else {
            staticLayout = a(text, alignment, Math.round(rectF.right));
        }
        return (maxLines == -1 || (staticLayout.getLineCount() <= maxLines && staticLayout.getLineEnd(staticLayout.getLineCount() - 1) == text.length())) && ((float) staticLayout.getHeight()) <= rectF.bottom;
    }

    private StaticLayout a(CharSequence charSequence, Alignment alignment, int i2, int i3) {
        TextDirectionHeuristic textDirectionHeuristic = (TextDirectionHeuristic) a((Object) this.f809k, "getTextDirectionHeuristic", (T) TextDirectionHeuristics.FIRSTSTRONG_LTR);
        Builder hyphenationFrequency = Builder.obtain(charSequence, 0, charSequence.length(), this.f808j, i2).setAlignment(alignment).setLineSpacing(this.f809k.getLineSpacingExtra(), this.f809k.getLineSpacingMultiplier()).setIncludePad(this.f809k.getIncludeFontPadding()).setBreakStrategy(this.f809k.getBreakStrategy()).setHyphenationFrequency(this.f809k.getHyphenationFrequency());
        if (i3 == -1) {
            i3 = Integer.MAX_VALUE;
        }
        return hyphenationFrequency.setMaxLines(i3).setTextDirection(textDirectionHeuristic).build();
    }

    private StaticLayout a(CharSequence charSequence, Alignment alignment, int i2) {
        boolean z;
        float f2;
        float f3;
        if (VERSION.SDK_INT >= 16) {
            f3 = this.f809k.getLineSpacingMultiplier();
            f2 = this.f809k.getLineSpacingExtra();
            z = this.f809k.getIncludeFontPadding();
        } else {
            f3 = ((Float) a((Object) this.f809k, "getLineSpacingMultiplier", (T) Float.valueOf(1.0f))).floatValue();
            f2 = ((Float) a((Object) this.f809k, "getLineSpacingExtra", (T) Float.valueOf(0.0f))).floatValue();
            z = ((Boolean) a((Object) this.f809k, "getIncludeFontPadding", (T) Boolean.valueOf(true))).booleanValue();
        }
        CharSequence charSequence2 = charSequence;
        StaticLayout staticLayout = new StaticLayout(charSequence2, this.f808j, i2, alignment, f3, f2, z);
        return staticLayout;
    }

    private <T> T a(Object obj, String str, T t) {
        try {
            return a(str).invoke(obj, new Object[0]);
        } catch (Exception e2) {
            String str2 = "ACTVAutoSizeHelper";
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to invoke TextView#");
            sb.append(str);
            sb.append("() method");
            Log.w(str2, sb.toString(), e2);
            return t;
        }
    }

    private Method a(String str) {
        try {
            Method method = (Method) f800b.get(str);
            if (method == null) {
                method = TextView.class.getDeclaredMethod(str, new Class[0]);
                if (method != null) {
                    method.setAccessible(true);
                    f800b.put(str, method);
                }
            }
            return method;
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to retrieve TextView#");
            sb.append(str);
            sb.append("() method");
            Log.w("ACTVAutoSizeHelper", sb.toString(), e2);
            return null;
        }
    }
}
