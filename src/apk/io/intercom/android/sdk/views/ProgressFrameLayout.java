package io.intercom.android.sdk.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import io.intercom.android.sdk.conversation.UploadProgressListener;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.twig.Twig;

public class ProgressFrameLayout extends FrameLayout implements UploadProgressListener {
    private final Twig twig;
    final UploadProgressBar uploadProgressBar;

    public ProgressFrameLayout(Context context) {
        this(context, null);
    }

    public void uploadNotice(final byte b2) {
        Twig twig2 = this.twig;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(b2);
        twig2.internal("progress", sb.toString());
        post(new Runnable() {
            public void run() {
                ProgressFrameLayout.this.uploadProgressBar.setProgress(b2);
                if (b2 == 90) {
                    ProgressFrameLayout.this.uploadProgressBar.smoothEndAnimation();
                }
            }
        });
    }

    public void uploadStarted() {
        this.uploadProgressBar.smoothStartAnimation();
    }

    public void uploadStopped() {
        this.uploadProgressBar.hideBar();
    }

    public ProgressFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.twig = LumberMill.getLogger();
        this.uploadProgressBar = new UploadProgressBar(context, attributeSet);
        addView(this.uploadProgressBar);
    }
}
