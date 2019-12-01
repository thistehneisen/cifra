package com.intercom.composer.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.recyclerview.widget.RecyclerView.a;
import com.intercom.composer.ComposerAnimationStateListener;
import com.intercom.composer.input.Input;
import com.intercom.composer.input.empty.EmptyInput;
import com.intercom.composer.pager.ComposerPagerAdapter;
import java.util.List;

abstract class SendButtonAnimatorListener extends AnimatorListenerAdapter {
    boolean animationCanceled;
    final ComposerAnimationStateListener animationStateListener;
    final ComposerPagerAdapter composerPagerAdapter;
    protected final List<Input> inputs;
    final a recyclerAdapter;

    SendButtonAnimatorListener(List<Input> list, ComposerPagerAdapter composerPagerAdapter2, a aVar, ComposerAnimationStateListener composerAnimationStateListener) {
        this.inputs = list;
        this.composerPagerAdapter = composerPagerAdapter2;
        this.recyclerAdapter = aVar;
        this.animationStateListener = composerAnimationStateListener;
    }

    /* access modifiers changed from: 0000 */
    public boolean emptyInputAdded() {
        for (Input input : this.inputs) {
            if (input instanceof EmptyInput) {
                return true;
            }
        }
        return false;
    }

    public void onAnimationCancel(Animator animator) {
        super.onAnimationCancel(animator);
        this.animationCanceled = true;
    }
}
