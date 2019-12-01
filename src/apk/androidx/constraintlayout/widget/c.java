package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout.a;
import b.e.b.a.h;
import b.e.b.a.m;
import java.util.Arrays;

/* compiled from: ConstraintHelper */
public abstract class c extends View {

    /* renamed from: a reason: collision with root package name */
    protected int[] f1163a = new int[32];

    /* renamed from: b reason: collision with root package name */
    protected int f1164b;

    /* renamed from: c reason: collision with root package name */
    protected Context f1165c;

    /* renamed from: d reason: collision with root package name */
    protected m f1166d;

    /* renamed from: e reason: collision with root package name */
    protected boolean f1167e = false;

    /* renamed from: f reason: collision with root package name */
    private String f1168f;

    /* renamed from: g reason: collision with root package name */
    private View[] f1169g = null;

    public c(Context context) {
        super(context);
        this.f1165c = context;
        a((AttributeSet) null);
    }

    private void setIds(String str) {
        if (str != null) {
            int i2 = 0;
            while (true) {
                int indexOf = str.indexOf(44, i2);
                if (indexOf == -1) {
                    a(str.substring(i2));
                    return;
                } else {
                    a(str.substring(i2, indexOf));
                    i2 = indexOf + 1;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, l.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == l.ConstraintLayout_Layout_constraint_referenced_ids) {
                    this.f1168f = obtainStyledAttributes.getString(index);
                    setIds(this.f1168f);
                }
            }
        }
    }

    public void a(ConstraintLayout constraintLayout) {
    }

    public void b(ConstraintLayout constraintLayout) {
    }

    public void c(ConstraintLayout constraintLayout) {
        if (isInEditMode()) {
            setIds(this.f1168f);
        }
        m mVar = this.f1166d;
        if (mVar != null) {
            mVar.a();
            for (int i2 = 0; i2 < this.f1164b; i2++) {
                View findViewById = constraintLayout.findViewById(this.f1163a[i2]);
                if (findViewById != null) {
                    this.f1166d.a(constraintLayout.a(findViewById));
                }
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f1163a, this.f1164b);
    }

    public void onDraw(Canvas canvas) {
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.f1167e) {
            super.onMeasure(i2, i3);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f1164b = 0;
        for (int tag : iArr) {
            setTag(tag, null);
        }
    }

    public void setTag(int i2, Object obj) {
        int i3 = this.f1164b + 1;
        int[] iArr = this.f1163a;
        if (i3 > iArr.length) {
            this.f1163a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f1163a;
        int i4 = this.f1164b;
        iArr2[i4] = i2;
        this.f1164b = i4 + 1;
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1165c = context;
        a(attributeSet);
    }

    public void a() {
        if (this.f1166d != null) {
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof a) {
                ((a) layoutParams).ma = (h) this.f1166d;
            }
        }
    }

    private void a(String str) {
        int i2;
        if (str != null && this.f1165c != null) {
            String trim = str.trim();
            try {
                i2 = k.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i2 = 0;
            }
            if (i2 == 0) {
                i2 = this.f1165c.getResources().getIdentifier(trim, "id", this.f1165c.getPackageName());
            }
            if (i2 == 0 && isInEditMode() && (getParent() instanceof ConstraintLayout)) {
                Object a2 = ((ConstraintLayout) getParent()).a(0, (Object) trim);
                if (a2 != null && (a2 instanceof Integer)) {
                    i2 = ((Integer) a2).intValue();
                }
            }
            if (i2 != 0) {
                setTag(i2, null);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Could not find id of \"");
                sb.append(trim);
                sb.append("\"");
                Log.w("ConstraintHelper", sb.toString());
            }
        }
    }

    public c(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1165c = context;
        a(attributeSet);
    }
}
