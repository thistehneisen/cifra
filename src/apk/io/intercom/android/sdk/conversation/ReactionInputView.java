package io.intercom.android.sdk.conversation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.commons.utilities.DeviceUtils;
import io.intercom.android.sdk.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.imageloader.LongTermImageLoader;
import io.intercom.android.sdk.imageloader.LongTermImageLoader.OnImageReadyListener;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.models.Reaction;
import io.intercom.android.sdk.models.ReactionReply;
import io.intercom.android.sdk.twig.Twig;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.com.bumptech.glide.n;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReactionInputView extends LinearLayout {
    private static final float REACTION_SCALE = 2.5f;
    private static final int VIBRATION_DURATION_MS = 10;
    private final ColorFilter deselectedFilter;
    Integer highlightedViewIndex;
    private ReactionListener listener;
    private final LongTermImageLoader longTermImageLoader;
    private ReactionReply reactionReply;
    private final List<ImageView> reactionViews;
    int reactionsLoaded;
    private final OnTouchListener touchListener;
    private final Twig twig;
    private final Vibrator vibrator;

    public ReactionInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: 0000 */
    public void deselectViewAtIndex(int i2) {
        ImageView imageView = (ImageView) this.reactionViews.get(i2);
        imageView.animate().setInterpolator(new OvershootInterpolator(0.6f)).scaleX(1.0f).scaleY(1.0f).setDuration(200).start();
        imageView.setColorFilter(this.deselectedFilter);
    }

    /* access modifiers changed from: 0000 */
    public Integer getCurrentSelectedIndex() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            Integer reactionIndex = this.reactionReply.getReactionIndex();
            Reaction reaction = (Reaction) this.reactionReply.getReactionSet().get(i2);
            if (reactionIndex == null || reactionIndex.equals(Integer.valueOf(reaction.getIndex()))) {
                return Integer.valueOf(i2);
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public void handleTouchUp() {
        Integer num = this.highlightedViewIndex;
        if (num != null && num.intValue() >= 0 && this.highlightedViewIndex.intValue() < this.reactionReply.getReactionSet().size()) {
            Reaction reaction = (Reaction) this.reactionReply.getReactionSet().get(this.highlightedViewIndex.intValue());
            if (reaction != null && (this.reactionReply.getReactionIndex() == null || reaction.getIndex() != this.reactionReply.getReactionIndex().intValue())) {
                this.reactionReply.setReactionIndex(reaction.getIndex());
                ReactionListener reactionListener = this.listener;
                if (reactionListener != null) {
                    reactionListener.onReactionSelected(reaction);
                }
            }
        }
        highlightSelectedReaction();
        this.highlightedViewIndex = null;
    }

    /* access modifiers changed from: 0000 */
    public void highlightSelectedReaction() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            Integer reactionIndex = this.reactionReply.getReactionIndex();
            Reaction reaction = (Reaction) this.reactionReply.getReactionSet().get(i2);
            if (reactionIndex == null || reactionIndex.equals(Integer.valueOf(reaction.getIndex()))) {
                selectViewAtIndex(1.0f, i2);
            } else {
                deselectViewAtIndex(i2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setOnTouchListener(this.touchListener);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setOnTouchListener(null);
        if (!isInEditMode()) {
            try {
                this.longTermImageLoader.close();
            } catch (IOException e2) {
                Twig twig2 = this.twig;
                StringBuilder sb = new StringBuilder();
                sb.append("Couldn't close LongTermImageLoader: ");
                sb.append(e2.getMessage());
                twig2.d(sb.toString(), new Object[0]);
            }
        }
    }

    public void preloadReactionImages(ReactionReply reactionReply2, n nVar) {
        for (Reaction imageUrl : reactionReply2.getReactionSet()) {
            this.longTermImageLoader.loadImage(imageUrl.getImageUrl(), null, nVar);
        }
    }

    /* access modifiers changed from: 0000 */
    public void selectViewAtIndex(float f2, int i2) {
        ImageView imageView = (ImageView) this.reactionViews.get(i2);
        imageView.animate().setInterpolator(new OvershootInterpolator(2.0f)).scaleX(f2).scaleY(f2).setDuration(200).start();
        imageView.clearColorFilter();
    }

    public void setUpReactions(ReactionReply reactionReply2, boolean z, ReactionListener reactionListener, n nVar) {
        Context context = getContext();
        this.reactionReply = reactionReply2;
        this.listener = reactionListener;
        List reactionSet = reactionReply2.getReactionSet();
        int size = reactionSet.size();
        boolean z2 = false;
        int i2 = 0;
        while (i2 < reactionSet.size()) {
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setClipChildren(z2);
            frameLayout.setClipToPadding(z2);
            frameLayout.setLayoutParams(new LayoutParams(z2 ? 1 : 0, -1, 1.0f));
            final ImageView imageView = new ImageView(context);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.intercom_reaction_size);
            imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize, 17));
            imageView.setPivotY((float) getResources().getDimensionPixelSize(R.dimen.intercom_reaction_offset));
            imageView.setPivotX((float) (dimensionPixelSize / 2));
            this.reactionViews.add(imageView);
            frameLayout.addView(imageView);
            Reaction reaction = (Reaction) reactionSet.get(i2);
            LongTermImageLoader longTermImageLoader2 = this.longTermImageLoader;
            final int i3 = size;
            AnonymousClass1 r11 = r0;
            final boolean z3 = z;
            String imageUrl = reaction.getImageUrl();
            final Context context2 = context;
            AnonymousClass1 r0 = new OnImageReadyListener() {
                public void onImageReady(Bitmap bitmap) {
                    imageView.setImageBitmap(bitmap);
                    ReactionInputView reactionInputView = ReactionInputView.this;
                    reactionInputView.reactionsLoaded++;
                    if (reactionInputView.reactionsLoaded != i3) {
                        return;
                    }
                    if (z3) {
                        reactionInputView.setVisibility(0);
                        ReactionInputView reactionInputView2 = ReactionInputView.this;
                        reactionInputView2.setY((float) (reactionInputView2.getHeight() + ScreenUtils.dpToPx(60.0f, context2)));
                        ReactionInputView.this.animate().setInterpolator(new OvershootInterpolator(0.6f)).translationY(0.0f).setDuration(300).start();
                        return;
                    }
                    reactionInputView.setVisibility(0);
                }
            };
            longTermImageLoader2.loadImage(imageUrl, r11, nVar);
            Integer reactionIndex = reactionReply2.getReactionIndex();
            if (reactionIndex != null && !reactionIndex.equals(Integer.valueOf(reaction.getIndex()))) {
                deselectViewAtIndex(i2);
            }
            addView(frameLayout);
            i2++;
            ReactionReply reactionReply3 = reactionReply2;
            z2 = false;
        }
    }

    /* access modifiers changed from: 0000 */
    @SuppressLint({"MissingPermission"})
    public void vibrateForSelection() {
        if (DeviceUtils.hasPermission(getContext(), "android.permission.VIBRATE")) {
            this.vibrator.vibrate(10);
        }
    }

    public ReactionInputView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.twig = LumberMill.getLogger();
        this.highlightedViewIndex = null;
        this.reactionsLoaded = 0;
        this.touchListener = new OnTouchListener() {
            private final Rect touchRect = new Rect();

            private void handleTouchMove(MotionEvent motionEvent) {
                ReactionInputView.this.getHitRect(this.touchRect);
                if (this.touchRect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    for (int i2 = 0; i2 < ReactionInputView.this.getChildCount(); i2++) {
                        ReactionInputView.this.getChildAt(i2).getHitRect(this.touchRect);
                        if (this.touchRect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            Integer num = ReactionInputView.this.highlightedViewIndex;
                            if (num == null || num.intValue() != i2) {
                                ReactionInputView.this.vibrateForSelection();
                                ReactionInputView.this.selectViewAtIndex(ReactionInputView.REACTION_SCALE, i2);
                            }
                            ReactionInputView reactionInputView = ReactionInputView.this;
                            Integer num2 = reactionInputView.highlightedViewIndex;
                            if (num2 == null) {
                                Integer currentSelectedIndex = reactionInputView.getCurrentSelectedIndex();
                                if (!(currentSelectedIndex == null || currentSelectedIndex.intValue() == i2)) {
                                    ReactionInputView.this.deselectViewAtIndex(currentSelectedIndex.intValue());
                                }
                            } else if (num2.intValue() != i2) {
                                ReactionInputView reactionInputView2 = ReactionInputView.this;
                                reactionInputView2.deselectViewAtIndex(reactionInputView2.highlightedViewIndex.intValue());
                            }
                            ReactionInputView.this.highlightedViewIndex = Integer.valueOf(i2);
                        }
                    }
                    return;
                }
                ReactionInputView reactionInputView3 = ReactionInputView.this;
                if (reactionInputView3.highlightedViewIndex != null) {
                    reactionInputView3.highlightSelectedReaction();
                }
                ReactionInputView.this.highlightedViewIndex = null;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
                if (r3 != 2) goto L_0x0016;
             */
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked != 0) {
                    if (actionMasked == 1) {
                        ReactionInputView.this.handleTouchUp();
                    }
                    return true;
                }
                handleTouchMove(motionEvent);
                return true;
            }
        };
        this.reactionViews = new ArrayList();
        setVisibility(8);
        if (isInEditMode()) {
            this.longTermImageLoader = null;
            this.vibrator = null;
        } else {
            this.longTermImageLoader = LongTermImageLoader.newInstance(context);
            this.vibrator = (Vibrator) context.getSystemService("vibrator");
        }
        this.deselectedFilter = ColorUtils.newGreyscaleFilter();
    }
}
