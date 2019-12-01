package com.intercom.composer.watcher;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

public class SendButtonTextWatcher implements TextWatcher {
    private final OnSendButtonStateChangedListener listener;

    public SendButtonTextWatcher(OnSendButtonStateChangedListener onSendButtonStateChangedListener) {
        this.listener = onSendButtonStateChangedListener;
    }

    public void afterTextChanged(Editable editable) {
        this.listener.animateSendButtonVisibility(!TextUtils.isEmpty(editable.toString().trim()));
    }

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }
}
