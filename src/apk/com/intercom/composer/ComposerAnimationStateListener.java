package com.intercom.composer;

import com.intercom.composer.animation.AnimationStatus;

public interface ComposerAnimationStateListener {
    void onAnimationStateChanged(AnimationStatus animationStatus);

    void setSendButtonVisibility(int i2);
}
