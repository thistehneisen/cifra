package com.intercom.composer.input.text.options;

public class TextInputOption {
    private final int iconResource;
    private final InputOptionClickListener inputOptionClickListener;

    public TextInputOption(int i2, InputOptionClickListener inputOptionClickListener2) {
        this.iconResource = i2;
        this.inputOptionClickListener = inputOptionClickListener2;
    }

    public int getResourceId() {
        return this.iconResource;
    }

    public void inputOptionClicked() {
        this.inputOptionClickListener.onInputOptionClicked();
    }
}
