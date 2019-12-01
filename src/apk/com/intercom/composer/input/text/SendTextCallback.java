package com.intercom.composer.input.text;

import com.intercom.composer.input.Input;

public interface SendTextCallback {
    void textToBeSent(Input input, CharSequence charSequence);
}
