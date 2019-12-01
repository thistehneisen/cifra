package io.intercom.android.sdk.views.holder;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.models.Attribute;
import io.intercom.android.sdk.utilities.AttributeValidatorUtils;
import io.intercom.android.sdk.views.TextAttributeView;

public class SubmitAttributeClickListener implements OnClickListener {
    private final ConversationListener conversationListener;
    private final String partId;
    private final TextAttributeView textAttributeView;

    public SubmitAttributeClickListener(TextAttributeView textAttributeView2, String str, ConversationListener conversationListener2) {
        this.textAttributeView = textAttributeView2;
        this.partId = str;
        this.conversationListener = conversationListener2;
    }

    /* access modifiers changed from: 0000 */
    public String getErrorStringFromCode(int i2, Resources resources) {
        switch (i2) {
            case 1:
                return resources.getString(R.string.intercom_string_is_incorrect);
            case 2:
                return resources.getString(R.string.intercom_that_email_address_doesnt_look_quite_right);
            case 3:
                return resources.getString(R.string.intercom_that_number_doesnt_look_quite_right);
            case 4:
                return resources.getString(R.string.intercom_that_number_needs_a_prefix);
            case 5:
                return resources.getString(R.string.intercom_that_number_has_too_many_digits);
            case 6:
                return resources.getString(R.string.intercom_that_country_code_doesnt_look_quite_right);
            case 7:
                return resources.getString(R.string.intercom_that_number_is_missing_a_few_digits);
            default:
                return "";
        }
    }

    public void onClick(View view) {
        String inputValue = this.textAttributeView.getInputValue();
        Attribute attribute = this.textAttributeView.getAttribute();
        if (!TextUtils.isEmpty(inputValue)) {
            int validateAttribute = AttributeValidatorUtils.validateAttribute(inputValue, attribute.getRenderType());
            if (validateAttribute == 0) {
                this.textAttributeView.displayLoadingState();
                this.conversationListener.onSubmitAttribute(this.partId, attribute.getIdentifier(), inputValue, attribute.getType());
            } else {
                this.textAttributeView.displayErrorState(getErrorStringFromCode(validateAttribute, this.textAttributeView.getContext().getResources()));
            }
        }
    }
}
