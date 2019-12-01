package io.intercom.android.sdk.lightbox;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.transition.Transition;
import android.transition.Transition.TransitionListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.app.C0147n;
import androidx.fragment.app.C0195j;
import b.g.a.a;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.transforms.RoundedCornersTransform;
import io.intercom.android.sdk.utilities.ImageUtils;
import io.intercom.com.bumptech.glide.c;
import io.intercom.com.bumptech.glide.f.g;
import io.intercom.com.bumptech.glide.k;
import io.intercom.com.bumptech.glide.load.m;
import io.intercom.com.bumptech.glide.o;

public class LightBoxActivity extends C0147n implements LightBoxListener {
    private static final int ANIMATION_TIME_MS = 300;
    private static final String EXTRA_ACTIVITY_FULLSCREEN = "extra_activity_fullscreen";
    private static final String EXTRA_IMAGE_URL = "extra_image_url";
    public static final String TRANSITION_KEY = "lightbox_image";
    private String imageUrl = "";
    ViewGroup rootView;

    private void fadeIn() {
        int a2 = a.a((Context) this, R.color.intercom_full_transparent_full_black);
        int a3 = a.a((Context) this, R.color.intercom_transparent_black_lightbox);
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(a2), Integer.valueOf(a3)});
        ofObject.setDuration(300);
        ofObject.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LightBoxActivity.this.rootView.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofObject.start();
    }

    private void fadeOut() {
        int a2 = a.a((Context) this, R.color.intercom_transparent_black_lightbox);
        int a3 = a.a((Context) this, R.color.intercom_full_transparent_full_black);
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(a2), Integer.valueOf(a3)});
        ofObject.setDuration(300);
        ofObject.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LightBoxActivity.this.rootView.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofObject.start();
    }

    public static Intent imageIntent(Context context, String str, boolean z) {
        return new Intent(context, LightBoxActivity.class).putExtra(EXTRA_IMAGE_URL, str).putExtra(EXTRA_ACTIVITY_FULLSCREEN, z);
    }

    /* access modifiers changed from: private */
    public void loadImage(g gVar, ImageView imageView) {
        k a2 = c.a((C0195j) this).a(this.imageUrl);
        a2.a((o<?, ? super TranscodeType>) io.intercom.com.bumptech.glide.load.c.c.c.c());
        a2.a(gVar);
        a2.a(imageView);
    }

    private void reloadAfterTransition(final g gVar, final LightBoxImageView lightBoxImageView) {
        if (VERSION.SDK_INT >= 21) {
            getWindow().getSharedElementEnterTransition().addListener(new TransitionListener() {
                public void onTransitionCancel(Transition transition) {
                }

                public void onTransitionEnd(Transition transition) {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            AnonymousClass1 r0 = AnonymousClass1.this;
                            LightBoxActivity.this.loadImage(gVar, lightBoxImageView);
                        }
                    }, 10);
                }

                public void onTransitionPause(Transition transition) {
                }

                public void onTransitionResume(Transition transition) {
                }

                public void onTransitionStart(Transition transition) {
                }
            });
        }
    }

    public void closeLightBox() {
        fadeOut();
        supportFinishAfterTransition();
    }

    public void onBackPressed() {
        super.onBackPressed();
        closeLightBox();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.imageUrl = extras.getString(EXTRA_IMAGE_URL, "");
            if (extras.getBoolean(EXTRA_ACTIVITY_FULLSCREEN, false)) {
                requestWindowFeature(1);
                getWindow().setFlags(1024, 1024);
            }
        }
        super.onCreate(bundle);
        setContentView(R.layout.intercom_activity_lightbox);
        this.rootView = (ViewGroup) findViewById(R.id.root_view);
        LightBoxImageView lightBoxImageView = (LightBoxImageView) findViewById(R.id.full_image);
        if (VERSION.SDK_INT >= 21) {
            lightBoxImageView.setTransitionName(TRANSITION_KEY);
        }
        g a2 = new g().a((m<Bitmap>) new RoundedCornersTransform<Bitmap>(getResources().getDimensionPixelSize(R.dimen.intercom_image_rounded_corners))).a(R.drawable.intercom_error).a(ImageUtils.getDiskCacheStrategy(this.imageUrl));
        loadImage(a2, lightBoxImageView);
        reloadAfterTransition(a2, lightBoxImageView);
        lightBoxImageView.setLightBoxListener(this);
        fadeIn();
    }
}
