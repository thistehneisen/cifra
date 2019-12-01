package com.intercom.composer.input.text.listener;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class SendButtonClickListener implements OnClickListener {
    private final EditText editText;
    private final OnSendButtonClickedListener listener;

    public SendButtonClickListener(OnSendButtonClickedListener onSendButtonClickedListener, EditText editText2) {
        this.listener = onSendButtonClickedListener;
        this.editText = editText2;
    }

    /* access modifiers changed from: 0000 */
    public void clearEditText() {
        this.editText.setText("");
    }

    public void onClick(View view) {
        this.listener.onSendButtonClicked(this.editText.getText());
        clearEditText();
    }
}
