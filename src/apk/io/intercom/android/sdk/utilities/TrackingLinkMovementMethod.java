package io.intercom.android.sdk.utilities;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.TextView;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.commons.utilities.TimeProvider;

public class TrackingLinkMovementMethod extends LinkMovementMethod {
    private boolean longClickActive = false;
    private boolean longClickPerformed = false;
    private long startClickTime;

    private int getPosition(MotionEvent motionEvent, TextView textView) {
        int x = (int) motionEvent.getX();
        int totalPaddingLeft = (x - textView.getTotalPaddingLeft()) + textView.getScrollX();
        int y = (((int) motionEvent.getY()) - textView.getTotalPaddingTop()) + textView.getScrollY();
        Layout layout = textView.getLayout();
        return layout.getOffsetForHorizontal(layout.getLineForVertical(y), (float) totalPaddingLeft);
    }

    private void performClick(ViewGroup viewGroup) {
        while (!viewGroup.performClick() && (viewGroup.getParent() instanceof ViewGroup)) {
            viewGroup = (ViewGroup) viewGroup.getParent();
        }
    }

    private void performLongClick(ViewGroup viewGroup) {
        while (!viewGroup.performLongClick() && (viewGroup.getParent() instanceof ViewGroup)) {
            viewGroup = (ViewGroup) viewGroup.getParent();
        }
    }

    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int position = getPosition(motionEvent, textView);
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(position, position, URLSpan.class);
        int action = motionEvent.getAction();
        boolean z = true;
        if (action == 0) {
            this.startClickTime = TimeProvider.SYSTEM.currentTimeMillis();
            if (!this.longClickActive) {
                this.longClickActive = true;
            }
            if (uRLSpanArr.length == 0) {
                return false;
            }
            Selection.setSelection(spannable, spannable.getSpanStart(uRLSpanArr[0]), spannable.getSpanEnd(uRLSpanArr[0]));
            return false;
        } else if (action == 1) {
            this.longClickActive = false;
            if (this.longClickPerformed) {
                z = false;
            } else if (uRLSpanArr.length != 0) {
                LinkOpener.handleUrl(uRLSpanArr[0].getURL(), textView.getContext(), Injector.get().getApi());
            } else {
                Selection.removeSelection(spannable);
                performClick((ViewGroup) textView.getParent());
            }
            this.longClickPerformed = false;
            return z;
        } else if (action != 2 || !this.longClickActive || TimeProvider.SYSTEM.currentTimeMillis() - this.startClickTime < ((long) ViewConfiguration.getLongPressTimeout())) {
            return false;
        } else {
            this.longClickActive = false;
            performLongClick((ViewGroup) textView.getParent());
            this.longClickPerformed = true;
            return true;
        }
    }
}
