package com.intercom.composer.animation;

import android.animation.Animator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.intercom.composer.ComposerAnimationStateListener;
import com.intercom.composer.input.Input;
import com.intercom.composer.input.empty.EmptyInput;
import com.intercom.composer.pager.ComposerPagerAdapter;
import java.util.List;

public class ShowSendButtonAnimatorListener extends SendButtonAnimatorListener {
    private final LinearLayoutManager layoutManager;

    public ShowSendButtonAnimatorListener(List<Input> list, ComposerPagerAdapter composerPagerAdapter, a aVar, LinearLayoutManager linearLayoutManager, ComposerAnimationStateListener composerAnimationStateListener) {
        super(list, composerPagerAdapter, aVar, composerAnimationStateListener);
        this.layoutManager = linearLayoutManager;
    }

    public /* bridge */ /* synthetic */ void onAnimationCancel(Animator animator) {
        super.onAnimationCancel(animator);
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        if (!this.animationCanceled && !emptyInputAdded()) {
            this.animationStateListener.onAnimationStateChanged(AnimationStatus.SHOWN);
            this.inputs.add(new EmptyInput());
            this.composerPagerAdapter.notifyDataSetChanged();
            int size = this.inputs.size() - 1;
            this.recyclerAdapter.notifyItemInserted(size);
            if (this.layoutManager.H() == size - 1) {
                this.layoutManager.k(size);
            }
        }
    }

    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        this.animationStateListener.onAnimationStateChanged(AnimationStatus.SHOWING);
        this.animationStateListener.setSendButtonVisibility(0);
    }
}
