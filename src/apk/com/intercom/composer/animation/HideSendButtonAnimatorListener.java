package com.intercom.composer.animation;

import android.animation.Animator;
import androidx.recyclerview.widget.RecyclerView.a;
import com.intercom.composer.ComposerAnimationStateListener;
import com.intercom.composer.input.Input;
import com.intercom.composer.pager.ComposerPagerAdapter;
import java.util.List;

public class HideSendButtonAnimatorListener extends SendButtonAnimatorListener {
    public HideSendButtonAnimatorListener(List<Input> list, ComposerPagerAdapter composerPagerAdapter, a aVar, ComposerAnimationStateListener composerAnimationStateListener) {
        super(list, composerPagerAdapter, aVar, composerAnimationStateListener);
    }

    public /* bridge */ /* synthetic */ void onAnimationCancel(Animator animator) {
        super.onAnimationCancel(animator);
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.animationStateListener.setSendButtonVisibility(8);
        if (!this.animationCanceled && emptyInputAdded()) {
            this.animationStateListener.onAnimationStateChanged(AnimationStatus.HIDDEN);
            List<Input> list = this.inputs;
            list.remove(list.size() - 1);
            this.composerPagerAdapter.notifyDataSetChanged();
            this.recyclerAdapter.notifyItemRemoved(this.inputs.size());
        }
    }

    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        this.animationStateListener.onAnimationStateChanged(AnimationStatus.HIDING);
    }
}
