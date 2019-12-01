package com.intercom.composer;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.fragment.app.C0200o;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.x;
import androidx.viewpager.widget.ViewPager;
import b.g.a.a;
import com.intercom.composer.animation.AnimationStatus;
import com.intercom.composer.animation.EditTextLayoutAnimator;
import com.intercom.composer.animation.EditTextLayoutAnimatorInternalListener;
import com.intercom.composer.animation.HideSendButtonAnimatorListener;
import com.intercom.composer.animation.SendButtonAnimator;
import com.intercom.composer.animation.ShowSendButtonAnimatorListener;
import com.intercom.composer.input.Input;
import com.intercom.composer.input.iconbar.InputClickedListener;
import com.intercom.composer.input.iconbar.InputIconRecyclerDecoration;
import com.intercom.composer.input.iconbar.InputIconsRecyclerAdapter;
import com.intercom.composer.input.iconbar.InputSelectedListener;
import com.intercom.composer.input.text.TextInput;
import com.intercom.composer.input.text.listener.OnSendButtonClickedListener;
import com.intercom.composer.input.text.listener.SendButtonClickListener;
import com.intercom.composer.input.text.options.InputOptionImageViewClickListener;
import com.intercom.composer.input.text.options.TextInputOption;
import com.intercom.composer.keyboard.KeyboardHelper;
import com.intercom.composer.keyboard.OrientationProvider;
import com.intercom.composer.pager.ComposerPagerAdapter;
import com.intercom.composer.watcher.OnSendButtonStateChangedListener;
import com.intercom.composer.watcher.SendButtonTextWatcher;
import java.util.ArrayList;
import java.util.List;

public class ComposerView extends LinearLayout implements OnSendButtonStateChangedListener, OnSendButtonClickedListener, InputSelectedListener, InputClickedListener, ComposerAnimationStateListener {
    View composerLowerBorder;
    View composerUpperBorder;
    LinearLayout editTextLayout;
    EditTextLayoutAnimator editTextLayoutAnimator;
    InputIconsRecyclerAdapter inputIconsRecyclerAdapter;
    RecyclerView inputIconsRecyclerView;
    OnInputSelectedListener inputSelectedListener;
    private final List<Input> inputs;
    KeyboardHelper keyboardHelper;
    private final LinearLayoutManager layoutManager;
    private OnSendButtonClickedListener onSendButtonClickListener;
    private final OrientationProvider orientationProvider;
    ImageView sendButton;
    AnimationStatus sendButtonAnimationStatus;
    SendButtonAnimator sendButtonAnimator;
    View sendButtonFadingBackground;
    final SendButtonTextWatcher sendButtonTextWatcher;
    ViewPager viewPager;

    public ComposerView(Context context) {
        this(context, null);
    }

    private boolean editTextNeededBySomeInput() {
        for (Input input : this.inputs) {
            if (input instanceof TextInput) {
                return true;
            }
        }
        return false;
    }

    private void removeViewFromParent(View view) {
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
    }

    private void setupTextInputs() {
        if (editTextNeededBySomeInput()) {
            this.editTextLayout.setVisibility(0);
            this.sendButton.setVisibility(0);
            this.sendButtonFadingBackground.setVisibility(0);
            return;
        }
        this.editTextLayout.setVisibility(8);
        this.sendButton.setVisibility(8);
        this.sendButtonFadingBackground.setVisibility(8);
    }

    private void showKeyboard(EditText editText) {
        editText.requestFocus();
        ((InputMethodManager) editText.getContext().getSystemService("input_method")).showSoftInput(editText, 0);
        if (editText.getContext().getResources().getBoolean(R.bool.intercom_composer_keyboard_takes_full_screen_in_landscape) && this.orientationProvider.getOrientation() == 2) {
            this.keyboardHelper.hideBehindKeyboardView();
        }
    }

    public void animateSendButtonVisibility(boolean z) {
        SendButtonAnimator sendButtonAnimator2 = this.sendButtonAnimator;
        if (sendButtonAnimator2 != null) {
            sendButtonAnimator2.animateButtonVisibility(z, this.sendButtonAnimationStatus);
        }
    }

    /* access modifiers changed from: 0000 */
    public void applyTheme(Context context, int i2) {
        Drawable c2 = a.c(context, R.drawable.intercom_composer_send_background);
        c2.setColorFilter(i2, Mode.SRC_ATOP);
        if (VERSION.SDK_INT >= 16) {
            this.sendButton.setBackground(c2);
        } else {
            this.sendButton.setBackgroundDrawable(c2);
        }
    }

    public List<Input> getInputs() {
        return this.inputs;
    }

    public Input getSelectedInput() {
        return this.inputIconsRecyclerAdapter.getSelectedInput();
    }

    public int getTextInputHeight() {
        return this.editTextLayout.getHeight();
    }

    public void hideAllInputsExcept(List<String> list) {
        this.inputIconsRecyclerAdapter.hideAllInputsExcept(list);
    }

    public void onAnimationStateChanged(AnimationStatus animationStatus) {
        this.sendButtonAnimationStatus = animationStatus;
    }

    public boolean onBackPressed() {
        Input selectedInput = getSelectedInput();
        if (selectedInput == null || selectedInput.equals(this.inputs.get(0))) {
            this.inputIconsRecyclerAdapter.deselectAllInputs();
        } else {
            selectInput((Input) this.inputs.get(0), false, false);
        }
        return this.keyboardHelper.hideBehindKeyboardView();
    }

    public void onDestroy() {
        removeTextWatcher();
        this.keyboardHelper.onDestroy();
    }

    public void onInputClicked(x xVar) {
        int adapterPosition = xVar.getAdapterPosition();
        if (adapterPosition >= 0 && adapterPosition < this.inputs.size()) {
            selectInput((Input) this.inputs.get(adapterPosition), true, true);
        }
    }

    public void onInputSelected(Input input, int i2, boolean z, boolean z2) {
        if (input instanceof TextInput) {
            EditText replaceEditText = replaceEditText((TextInput) input);
            this.editTextLayoutAnimator.showEditText(z2);
            if (z) {
                showKeyboard(replaceEditText);
            }
            animateSendButtonVisibility(!TextUtils.isEmpty(replaceEditText.getText()));
        } else {
            this.keyboardHelper.showBehindKeyboardView();
            this.editTextLayout.clearFocus();
            this.editTextLayoutAnimator.hideEditText();
            animateSendButtonVisibility(false);
        }
        updateColors(input.getBackgroundColor(), input.getBorderColor());
        this.viewPager.setCurrentItem(i2, false);
    }

    public void onSendButtonClicked(CharSequence charSequence) {
        OnSendButtonClickedListener onSendButtonClickedListener = this.onSendButtonClickListener;
        if (onSendButtonClickedListener != null) {
            onSendButtonClickedListener.onSendButtonClicked(charSequence);
        }
    }

    /* access modifiers changed from: 0000 */
    public void removeTextWatcher() {
        int childCount = this.editTextLayout.getChildCount();
        if (childCount > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.editTextLayout.getChildAt(i2);
                if (childAt instanceof EditText) {
                    ((EditText) childAt).removeTextChangedListener(this.sendButtonTextWatcher);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public EditText replaceEditText(TextInput textInput) {
        EditText editText = textInput.getEditText();
        List<TextInputOption> options = textInput.getOptions();
        this.editTextLayout.removeAllViews();
        removeViewFromParent(editText);
        this.editTextLayout.addView(editText, new LayoutParams(0, -2, 1.0f));
        this.sendButton.setOnClickListener(new SendButtonClickListener(this, editText));
        editText.addTextChangedListener(this.sendButtonTextWatcher);
        animateSendButtonVisibility(!TextUtils.isEmpty(editText.getText()));
        if (options != null) {
            for (TextInputOption textInputOption : options) {
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.intercom_composer_editable_text_input_option_padding);
                int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.intercom_composer_editable_text_input_option_padding_bottom);
                ImageView imageView = new ImageView(getContext());
                imageView.setImageResource(textInputOption.getResourceId());
                imageView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
                imageView.setOnClickListener(new InputOptionImageViewClickListener(textInputOption));
                this.editTextLayout.addView(imageView);
            }
        }
        return editText;
    }

    public boolean selectInput(Input input, boolean z, boolean z2) {
        OnInputSelectedListener onInputSelectedListener = this.inputSelectedListener;
        if (onInputSelectedListener != null) {
            onInputSelectedListener.onInputSelected(input);
        }
        return this.inputIconsRecyclerAdapter.selectInput(input, z, z2);
    }

    public void setComposerPagerAdapter(ComposerPagerAdapter composerPagerAdapter) {
        this.viewPager.setAdapter(composerPagerAdapter);
        this.viewPager.setOffscreenPageLimit(this.inputs.size());
        ShowSendButtonAnimatorListener showSendButtonAnimatorListener = new ShowSendButtonAnimatorListener(this.inputs, composerPagerAdapter, this.inputIconsRecyclerAdapter, this.layoutManager, this);
        this.sendButtonAnimator = new SendButtonAnimator(this.sendButtonFadingBackground, this.sendButton, showSendButtonAnimatorListener, new HideSendButtonAnimatorListener(this.inputs, composerPagerAdapter, this.inputIconsRecyclerAdapter, this));
    }

    public void setEditTextLayoutAnimationListener(EditTextLayoutAnimatorInternalListener editTextLayoutAnimatorInternalListener) {
        this.editTextLayoutAnimator.setEditTextLayoutAnimatorListener(editTextLayoutAnimatorInternalListener);
    }

    public void setFragmentManager(C0200o oVar) {
        InputIconsRecyclerAdapter inputIconsRecyclerAdapter2 = new InputIconsRecyclerAdapter(LayoutInflater.from(getContext()), this.inputs, this, this, oVar);
        this.inputIconsRecyclerAdapter = inputIconsRecyclerAdapter2;
        this.inputIconsRecyclerView.setAdapter(this.inputIconsRecyclerAdapter);
    }

    public void setInputSelectedListener(OnInputSelectedListener onInputSelectedListener) {
        this.inputSelectedListener = onInputSelectedListener;
    }

    public void setInputs(List<? extends Input> list) {
        if (this.inputIconsRecyclerAdapter != null) {
            this.inputs.clear();
            this.inputs.addAll(list);
            setupTextInputs();
            this.inputIconsRecyclerAdapter.notifyDataSetChanged();
            return;
        }
        throw new IllegalStateException("Fragment manager should be set!");
    }

    public void setOnSendButtonClickListener(OnSendButtonClickedListener onSendButtonClickedListener) {
        this.onSendButtonClickListener = onSendButtonClickedListener;
    }

    public void setSendButtonVisibility(int i2) {
        this.sendButton.setVisibility(i2);
    }

    public void showAllInputs() {
        this.inputIconsRecyclerAdapter.showAllInputs();
    }

    public void updateColors(int i2, int i3) {
        this.editTextLayout.setBackgroundResource(i2);
        this.inputIconsRecyclerView.setBackgroundResource(i2);
        this.sendButtonFadingBackground.setBackgroundResource(i2);
        this.composerUpperBorder.setBackgroundResource(i3);
        this.composerLowerBorder.setBackgroundResource(i3);
    }

    public ComposerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ComposerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.inputs = new ArrayList();
        this.sendButtonAnimationStatus = AnimationStatus.UNKNOWN;
        setOrientation(1);
        LinearLayout.inflate(context, R.layout.intercom_composer_view_layout, this);
        this.composerUpperBorder = findViewById(R.id.composer_upper_border);
        this.composerLowerBorder = findViewById(R.id.composer_lower_border);
        this.editTextLayout = (LinearLayout) findViewById(R.id.composer_edit_text_layout);
        this.inputIconsRecyclerView = (RecyclerView) findViewById(R.id.composer_input_icons_recycler_view);
        this.viewPager = (ViewPager) findViewById(R.id.composer_view_pager);
        this.sendButton = (ImageView) findViewById(R.id.send_button);
        this.sendButtonFadingBackground = findViewById(R.id.send_button_fading_background);
        this.orientationProvider = new OrientationProvider(context);
        this.keyboardHelper = new KeyboardHelper((Activity) context, this.orientationProvider, this.editTextLayout, this.viewPager);
        this.editTextLayoutAnimator = new EditTextLayoutAnimator(this.editTextLayout);
        this.layoutManager = new LinearLayoutManager(context, 0, false);
        this.inputIconsRecyclerView.setLayoutManager(this.layoutManager);
        this.inputIconsRecyclerView.a((h) new InputIconRecyclerDecoration(context));
        this.sendButtonTextWatcher = new SendButtonTextWatcher(this);
    }
}
