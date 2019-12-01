package androidx.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout.a;

/* compiled from: Guideline */
public class i extends View {
    public i(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public void draw(Canvas canvas) {
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        setMeasuredDimension(0, 0);
    }

    public void setGuidelineBegin(int i2) {
        a aVar = (a) getLayoutParams();
        aVar.f1134a = i2;
        setLayoutParams(aVar);
    }

    public void setGuidelineEnd(int i2) {
        a aVar = (a) getLayoutParams();
        aVar.f1135b = i2;
        setLayoutParams(aVar);
    }

    public void setGuidelinePercent(float f2) {
        a aVar = (a) getLayoutParams();
        aVar.f1136c = f2;
        setLayoutParams(aVar);
    }

    public void setVisibility(int i2) {
    }
}
