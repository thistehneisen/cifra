package io.intercom.android.sdk.conversation.composer.textinput;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import io.intercom.android.sdk.actions.Actions;
import io.intercom.android.sdk.nexus.NexusClient;
import io.intercom.android.sdk.nexus.NexusEvent;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Store;

class TextInputWatcher implements TextWatcher {
    private static final long IS_TYPING_DELAY = 1000;
    private String conversationId = "";
    private final Handler handler;
    private final NexusClient nexusClient;
    boolean shouldSendIsTyping = true;
    private final Store<State> store;
    private final String userId;

    TextInputWatcher(String str, NexusClient nexusClient2, Store<State> store2, Handler handler2) {
        this.userId = str;
        this.nexusClient = nexusClient2;
        this.store = store2;
        this.handler = handler2;
    }

    public void afterTextChanged(Editable editable) {
        if (this.shouldSendIsTyping) {
            this.shouldSendIsTyping = false;
            this.handler.postDelayed(new Runnable() {
                public void run() {
                    TextInputWatcher.this.shouldSendIsTyping = true;
                }
            }, 1000);
            if (!this.conversationId.isEmpty()) {
                this.nexusClient.fire(NexusEvent.getUserIsTypingEvent(this.conversationId, this.userId));
            }
            if (editable.length() == 0) {
                this.store.dispatch(Actions.composerCleared(this.conversationId));
            } else {
                this.store.dispatch(Actions.composerTypedIn(this.conversationId));
            }
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    /* access modifiers changed from: protected */
    public void setConversationId(String str) {
        this.conversationId = str;
    }
}
