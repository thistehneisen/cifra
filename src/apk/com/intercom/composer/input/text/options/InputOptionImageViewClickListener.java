package com.intercom.composer.input.text.options;

import android.view.View;
import android.view.View.OnClickListener;

public class InputOptionImageViewClickListener implements OnClickListener {
    private TextInputOption option;

    public InputOptionImageViewClickListener(TextInputOption textInputOption) {
        this.option = textInputOption;
    }

    public void onClick(View view) {
        this.option.inputOptionClicked();
    }
}
