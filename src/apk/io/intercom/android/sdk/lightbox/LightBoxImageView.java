package io.intercom.android.sdk.lightbox;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import androidx.appcompat.widget.AppCompatImageView;

public class LightBoxImageView extends AppCompatImageView {
    GestureDetector gestureDetector;
    LightBoxListener lightBoxListener;

    private class GestureListener extends SimpleOnGestureListener {
        GestureListener() {
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            LightBoxListener lightBoxListener = LightBoxImageView.this.lightBoxListener;
            if (lightBoxListener != null) {
                lightBoxListener.closeLightBox();
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    public LightBoxImageView(Context context) {
        super(context);
        init();
    }

    private void init() {
        this.gestureDetector = new GestureDetector(getContext(), new GestureListener());
        setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return LightBoxImageView.this.gestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

    /* access modifiers changed from: 0000 */
    public void setLightBoxListener(LightBoxListener lightBoxListener2) {
        this.lightBoxListener = lightBoxListener2;
    }

    public LightBoxImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }
}
