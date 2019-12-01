package io.intercom.android.sdk.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class ContentAwareScrollView extends ScrollView {
    private Listener listener;

    public interface Listener {
        void onBottomReached();

        void onScrollChanged(int i2);
    }

    public ContentAwareScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    private boolean isAtBottom() {
        boolean z = false;
        int bottom = getChildAt(0).getBottom();
        if (bottom == 0) {
            return false;
        }
        if (getBottom() + getScrollY() >= bottom) {
            z = true;
        }
        return z;
    }

    public Listener getListener() {
        return this.listener;
    }

    /* access modifiers changed from: protected */
    public void notifyListenerIfAtBottom() {
        if (this.listener != null && isAtBottom()) {
            this.listener.onBottomReached();
        }
    }

    /* access modifiers changed from: protected */
    public void notifyListenerScrollChanged(int i2) {
        Listener listener2 = this.listener;
        if (listener2 != null) {
            listener2.onScrollChanged(i2);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        notifyListenerIfAtBottom();
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        notifyListenerIfAtBottom();
        notifyListenerScrollChanged(i3);
    }

    public void setListener(Listener listener2) {
        this.listener = listener2;
        notifyListenerIfAtBottom();
    }

    public ContentAwareScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ContentAwareScrollView(Context context) {
        super(context);
    }
}
