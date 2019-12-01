package io.intercom.android.sdk.views;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import io.intercom.android.sdk.conversation.UploadProgressListener;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.twig.Twig;

public class ProgressLinearLayout extends LinearLayout implements UploadProgressListener {
    ImageView attachmentIcon;
    private final Twig twig;
    UploadProgressBar uploadProgressBar;

    public ProgressLinearLayout(Context context) {
        this(context, null);
    }

    public void setAttachmentIcon(ImageView imageView) {
        this.attachmentIcon = imageView;
    }

    public void setUploadProgressBar(UploadProgressBar uploadProgressBar2) {
        this.uploadProgressBar = uploadProgressBar2;
    }

    public void uploadNotice(final byte b2) {
        Twig twig2 = this.twig;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(b2);
        twig2.internal("progress", sb.toString());
        post(new Runnable() {
            public void run() {
                UploadProgressBar uploadProgressBar = ProgressLinearLayout.this.uploadProgressBar;
                if (uploadProgressBar != null) {
                    uploadProgressBar.setProgress(b2);
                    if (b2 == 90) {
                        ProgressLinearLayout.this.uploadProgressBar.smoothEndAnimation(new AnimatorListener() {
                            public void onAnimationCancel(Animator animator) {
                            }

                            public void onAnimationEnd(Animator animator) {
                                ProgressLinearLayout.this.uploadProgressBar.hideBar();
                                ImageView imageView = ProgressLinearLayout.this.attachmentIcon;
                                if (imageView != null) {
                                    imageView.setVisibility(0);
                                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(ProgressLinearLayout.this.attachmentIcon, "alpha", new float[]{0.0f, 1.0f});
                                    ofFloat.setDuration(300);
                                    ofFloat.setInterpolator(new DecelerateInterpolator());
                                    ofFloat.start();
                                }
                            }

                            public void onAnimationRepeat(Animator animator) {
                            }

                            public void onAnimationStart(Animator animator) {
                            }
                        });
                    }
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

    public ProgressLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.twig = LumberMill.getLogger();
    }
}
