package io.intercom.android.sdk.conversation.composer.textinput;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.EditText;
import com.intercom.composer.input.IconProvider;
import com.intercom.composer.input.Input;
import com.intercom.composer.input.text.SendTextCallback;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.actions.Actions;
import io.intercom.android.sdk.conversation.composer.ComposerInputIndentifier;
import io.intercom.android.sdk.conversation.composer.ComposerPresenter.Listener;
import io.intercom.android.sdk.conversation.composer.InputDrawableManager;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.metrics.MetricsComposerTextWatcher;
import io.intercom.android.sdk.nexus.NexusClient;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Store;

public class TextInputManager {
    private final EditText composerText;
    private final Context context;
    private String conversationId;
    private String initialMessage;
    /* access modifiers changed from: private */
    public final Listener listener;
    private final MetricsComposerTextWatcher metricsTextWatcher;
    /* access modifiers changed from: private */
    public final Store<State> store;
    /* access modifiers changed from: private */
    public final Drawable textIcon;
    private final TextInputWatcher textWatcher;

    public TextInputManager(Context context2, LayoutInflater layoutInflater, UserIdentity userIdentity, NexusClient nexusClient, MetricTracker metricTracker, String str, String str2, InputDrawableManager inputDrawableManager, Store<State> store2, Listener listener2) {
        this.context = context2;
        this.listener = listener2;
        this.conversationId = str;
        this.initialMessage = str2;
        this.store = store2;
        this.textIcon = inputDrawableManager.createDrawable(context2, R.drawable.intercom_input_text);
        this.composerText = (EditText) layoutInflater.inflate(R.layout.intercom_composer_edit_text, null);
        this.textWatcher = new TextInputWatcher(userIdentity.getIntercomId(), nexusClient, store2, new Handler(Looper.getMainLooper()));
        this.metricsTextWatcher = new MetricsComposerTextWatcher(metricTracker);
        this.metricsTextWatcher.setConversationId(str);
        this.composerText.addTextChangedListener(this.textWatcher);
        this.composerText.addTextChangedListener(this.metricsTextWatcher);
    }

    public void cleanup() {
        this.store.dispatch(Actions.composerCleared(this.conversationId));
        this.composerText.removeTextChangedListener(this.textWatcher);
        this.composerText.removeTextChangedListener(this.metricsTextWatcher);
        this.composerText.clearFocus();
        this.metricsTextWatcher.reset();
    }

    public Input createInput() {
        String str;
        if (TextUtils.isEmpty(this.conversationId)) {
            str = this.context.getResources().getString(R.string.intercom_start_conversation);
        } else {
            str = this.context.getResources().getString(R.string.intercom_reply_to_conversation);
        }
        CharSequence charSequence = str;
        MessengerTextInput messengerTextInput = new MessengerTextInput(ComposerInputIndentifier.TEXT, new IconProvider() {
            public Drawable getIconDrawable(String str, Context context) {
                return TextInputManager.this.textIcon;
            }
        }, charSequence, this.initialMessage, new SendTextCallback() {
            public void textToBeSent(Input input, CharSequence charSequence) {
                TextInputManager.this.listener.onSendButtonPressed(charSequence);
                TextInputManager.this.store.dispatch(Actions.composerSendButtonPressed());
            }
        }, this.composerText);
        return messengerTextInput;
    }

    public void requestFocus() {
        this.composerText.requestFocus();
    }

    public void setConversationId(String str) {
        this.textWatcher.setConversationId(str);
        this.metricsTextWatcher.setConversationId(str);
    }

    public void setHint(int i2) {
        this.composerText.setHint(i2);
    }

    public void updateMaxLines() {
        this.composerText.setMaxLines(this.context.getResources().getInteger(R.integer.intercom_max_composer_lines));
    }
}
