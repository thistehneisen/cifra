package io.intercom.android.sdk.views;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import b.g.a.a;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.models.Attribute;
import io.intercom.android.sdk.models.CountryAreaCode;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.android.sdk.utilities.PhoneNumberValidator;
import io.intercom.android.sdk.views.holder.AttributeType;
import io.intercom.android.sdk.views.holder.ConversationListener;
import io.intercom.android.sdk.views.holder.SubmitAttributeClickListener;
import java.util.Locale;

public class TextAttributeView extends BaseAttributeView {
    private static final int PHONE_INPUT_INSET_DP = 46;
    private static final String SAMPLE_NUMBER = " 123 456 7890";
    EditText attributeValueInput;
    final TextView flagView;
    final ProgressBar loadingView;
    ImageView submitButton;
    final ImageView verifiedTick;

    public TextAttributeView(Context context) {
        this(context, null);
    }

    private void displayVerifiedState() {
        this.attributeValueInput.setText(getAttribute().getValue());
        this.attributeValueInput.setEnabled(false);
        this.attributeValueInput.setKeyListener(null);
        this.submitButton.setVisibility(8);
        this.verifiedTick.setVisibility(0);
        this.loadingView.setVisibility(8);
        updateTextInputStrokeColor(R.color.intercom_attribute_input_outline);
        hideErrorView();
    }

    private void setUpEmailAttribute() {
        this.attributeValueInput.setInputType(32);
        this.attributeValueInput.setHint("email@domain.com");
    }

    private void setUpFloatAttribute() {
        this.attributeValueInput.setInputType(12290);
    }

    private void setUpNumberAttribute() {
        this.attributeValueInput.setInputType(4098);
    }

    private void setUpPhoneAttribute(Locale locale) {
        this.attributeValueInput.setInputType(3);
        PhoneNumberValidator.loadCountryAreaCodes(getContext());
        CountryAreaCode countryAreaCodeFromLocale = PhoneNumberValidator.getCountryAreaCodeFromLocale(locale.getCountry());
        if (countryAreaCodeFromLocale.equals(CountryAreaCode.UNKNOWN)) {
            this.attributeValueInput.setHint("+1 123 456 7890");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("+");
            sb.append(countryAreaCodeFromLocale.getDialCode());
            String sb2 = sb.toString();
            EditText editText = this.attributeValueInput;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append(SAMPLE_NUMBER);
            editText.setHint(sb3.toString());
            this.attributeValueInput.setText(sb2);
        }
        updateFlag(countryAreaCodeFromLocale);
    }

    private void updateAttributeContent() {
        if (getAttribute().hasValue()) {
            displayVerifiedState();
        } else {
            displayEmptyState();
        }
    }

    private void updateFlag(CountryAreaCode countryAreaCode) {
        this.flagView.setVisibility(0);
        this.flagView.setText(countryAreaCode.getEmoji());
        this.attributeValueInput.setPadding(ScreenUtils.dpToPx(46.0f, getContext()), this.attributeValueInput.getPaddingTop(), this.attributeValueInput.getPaddingRight(), this.attributeValueInput.getPaddingBottom());
        this.attributeValueInput.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                TextAttributeView.this.flagView.setText(PhoneNumberValidator.getCountryAreaCodeFromNumber(PhoneNumberValidator.stripPrefix(PhoneNumberValidator.normalizeNumber(editable.toString()))).getEmoji());
            }

            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
    }

    private void updateTextInputStrokeColor(int i2) {
        Context context = this.attributeValueInput.getContext();
        ((GradientDrawable) this.attributeValueInput.getBackground()).setStroke(ScreenUtils.dpToPx(1.0f, context), a.a(context, i2));
    }

    public void displayEmptyState() {
        updateTextInputStrokeColor(R.color.intercom_attribute_input_outline);
        this.attributeValueInput.setEnabled(true);
        this.submitButton.setImageResource(R.drawable.intercom_attribute_submit_arrow);
        this.submitButton.setVisibility(0);
        this.verifiedTick.setVisibility(8);
        hideErrorView();
    }

    public void displayErrorState(String str) {
        updateTextInputStrokeColor(R.color.intercom_attribute_collector_error);
        setError(str);
        this.submitButton.setImageResource(R.drawable.intercom_attribute_submit_arrow);
        this.loadingView.setVisibility(8);
    }

    public void displayLoadingState() {
        updateTextInputStrokeColor(R.color.intercom_attribute_input_outline);
        this.loadingView.setVisibility(0);
        this.submitButton.setImageDrawable(null);
        hideErrorView();
    }

    public String getInputValue() {
        return this.attributeValueInput.getText().toString().trim();
    }

    public int getLayoutRes() {
        return R.layout.intercom_view_text_attribute;
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.attributeValueInput.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void setOnSubmitClickListener(String str, ConversationListener conversationListener) {
        this.submitButton.setOnClickListener(new SubmitAttributeClickListener(this, str, conversationListener));
    }

    public void setUpAttribute(Attribute attribute, Locale locale) {
        setAttribute(attribute);
        this.attributeValueInput.setInputType(1);
        this.attributeValueInput.setHint(null);
        this.attributeValueInput.setText("");
        if ("email".equals(attribute.getRenderType())) {
            setUpEmailAttribute();
        } else {
            if (AttributeType.PHONE.equals(attribute.getRenderType())) {
                setUpPhoneAttribute(locale);
            } else {
                if (AttributeType.NUMBER.equals(attribute.getRenderType())) {
                    setUpNumberAttribute();
                } else {
                    if (AttributeType.FLOAT.equals(attribute.getRenderType())) {
                        setUpFloatAttribute();
                    }
                }
            }
        }
        updateAttributeContent();
    }

    public void updateSubmitButtonColor(AppConfig appConfig) {
        this.submitButton.getBackground().setColorFilter(appConfig.getPrimaryColor(), Mode.SRC_IN);
        ColorUtils.setImageSrcColorWhiteOrDark(this.submitButton, appConfig.primaryColorRenderDarkText());
    }

    public TextAttributeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.flagView = (TextView) findViewById(R.id.flag_view);
        this.attributeValueInput = (EditText) findViewById(R.id.attribute_input);
        this.submitButton = (ImageView) findViewById(R.id.attribute_submit);
        this.verifiedTick = (ImageView) findViewById(R.id.attribute_verified_tick);
        this.loadingView = (ProgressBar) findViewById(R.id.loading_view);
    }
}
