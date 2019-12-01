package io.intercom.android.sdk.conversation;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.twig.Twig;

public class SoundPlayer {
    static final int NOT_FOUND_ID = -1;
    private static final Twig TWIG = LumberMill.getLogger();
    private final Provider<AppConfig> appConfigProvider;
    final int messageReceivedId;
    boolean messageReceivedLoaded;
    /* access modifiers changed from: private */
    public final int operatorReceivedId;
    /* access modifiers changed from: private */
    public boolean operatorReceivedLoaded;
    final int replyFailedId;
    boolean replyFailedLoaded;
    final int replySentId;
    boolean replySentLoaded;
    private final SoundPool soundPool;

    public SoundPlayer(Context context, Provider<AppConfig> provider) {
        this(context, provider, new SoundPool(1, 5, 0));
    }

    private int loadSound(Context context, int i2) {
        try {
            return this.soundPool.load(context, i2, 1);
        } catch (NotFoundException e2) {
            TWIG.e(e2, "Could not play sound", new Object[0]);
            return -1;
        }
    }

    /* access modifiers changed from: 0000 */
    public void playIfLoaded(boolean z, int i2) {
        if (z && i2 != -1 && ((AppConfig) this.appConfigProvider.get()).isAudioEnabled()) {
            this.soundPool.play(i2, 1.0f, 1.0f, 1, 0, 1.0f);
        }
    }

    public void playMessageReceivedSound() {
        playIfLoaded(this.messageReceivedLoaded, this.messageReceivedId);
    }

    public void playOperatorReceivedSound() {
        playIfLoaded(this.operatorReceivedLoaded, this.operatorReceivedId);
    }

    public void playReplyFailedSound() {
        playIfLoaded(this.replyFailedLoaded, this.replyFailedId);
    }

    public void playReplySentSound() {
        playIfLoaded(this.replySentLoaded, this.replySentId);
    }

    SoundPlayer(Context context, Provider<AppConfig> provider, SoundPool soundPool2) {
        this.appConfigProvider = provider;
        this.soundPool = soundPool2;
        this.soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
            public void onLoadComplete(SoundPool soundPool, int i2, int i3) {
                if (i3 == 0) {
                    SoundPlayer soundPlayer = SoundPlayer.this;
                    if (i2 == soundPlayer.messageReceivedId) {
                        soundPlayer.messageReceivedLoaded = true;
                    } else if (i2 == soundPlayer.replyFailedId) {
                        soundPlayer.replyFailedLoaded = true;
                    } else if (i2 == soundPlayer.replySentId) {
                        soundPlayer.replySentLoaded = true;
                    } else if (i2 == soundPlayer.operatorReceivedId) {
                        SoundPlayer.this.operatorReceivedLoaded = true;
                    }
                }
            }
        });
        this.messageReceivedId = loadSound(context, R.raw.intercom_received);
        this.replyFailedId = loadSound(context, R.raw.intercom_failed);
        this.replySentId = loadSound(context, R.raw.intercom_sent);
        this.operatorReceivedId = loadSound(context, R.raw.intercom_operator);
    }
}
