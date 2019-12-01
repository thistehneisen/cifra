package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
import b.a.a;

/* renamed from: androidx.appcompat.widget.y reason: case insensitive filesystem */
/* compiled from: AppCompatSeekBar */
public class C0184y extends SeekBar {

    /* renamed from: a reason: collision with root package name */
    private final C0185z f1060a;

    public C0184y(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.seekBarStyle);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.f1060a.b();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f1060a.c();
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f1060a.a(canvas);
    }

    public C0184y(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1060a = new C0185z(this);
        this.f1060a.a(attributeSet, i2);
    }
}
