package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import b.e.b.a.b;

public class Barrier extends c {

    /* renamed from: h reason: collision with root package name */
    private int f1119h;

    /* renamed from: i reason: collision with root package name */
    private int f1120i;

    /* renamed from: j reason: collision with root package name */
    private b f1121j;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void a(AttributeSet attributeSet) {
        super.a(attributeSet);
        this.f1121j = new b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, l.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == l.ConstraintLayout_Layout_barrierDirection) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == l.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.f1121j.c(obtainStyledAttributes.getBoolean(index, true));
                }
            }
        }
        this.f1166d = this.f1121j;
        a();
    }

    public boolean b() {
        return this.f1121j.K();
    }

    public int getType() {
        return this.f1119h;
    }

    public void setAllowsGoneWidget(boolean z) {
        this.f1121j.c(z);
    }

    public void setType(int i2) {
        this.f1119h = i2;
        this.f1120i = i2;
        if (VERSION.SDK_INT < 17) {
            int i3 = this.f1119h;
            if (i3 == 5) {
                this.f1120i = 0;
            } else if (i3 == 6) {
                this.f1120i = 1;
            }
        } else {
            if (1 == getResources().getConfiguration().getLayoutDirection()) {
                int i4 = this.f1119h;
                if (i4 == 5) {
                    this.f1120i = 1;
                } else if (i4 == 6) {
                    this.f1120i = 0;
                }
            } else {
                int i5 = this.f1119h;
                if (i5 == 5) {
                    this.f1120i = 0;
                } else if (i5 == 6) {
                    this.f1120i = 1;
                }
            }
        }
        this.f1121j.p(this.f1120i);
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        super.setVisibility(8);
    }
}
