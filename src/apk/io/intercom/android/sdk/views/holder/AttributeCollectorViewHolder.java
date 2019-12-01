package io.intercom.android.sdk.views.holder;

import android.content.Context;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import b.g.i.C0246g;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.conversation.attribute.AttributeMetadata;
import io.intercom.android.sdk.conversation.attribute.AttributeMetadata.Builder;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.models.Attribute;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.android.sdk.views.AttributeCollectorCardView;
import io.intercom.android.sdk.views.BaseAttributeView;
import io.intercom.android.sdk.views.BooleanAttributeView;
import io.intercom.android.sdk.views.DateAttributeView;
import io.intercom.android.sdk.views.ListAttributeView;
import io.intercom.android.sdk.views.TextAttributeView;
import io.intercom.com.bumptech.glide.n;
import java.util.List;
import java.util.Locale;

public class AttributeCollectorViewHolder extends BlocksPartViewHolder implements ConversationPartViewHolder {
    private final Provider<AppConfig> appConfigProvider;
    private final ConversationListener conversationListener;
    private final OnFocusChangeListener inputFocusChangeListener = new OnFocusChangeListener() {
        public void onFocusChange(View view, boolean z) {
            if (z) {
                AttributeCollectorViewHolder.this.expandAttributeCard();
            }
        }
    };
    private final Locale locale;
    private final n requestManager;

    public AttributeCollectorViewHolder(View view, Provider<AppConfig> provider, ConversationListener conversationListener2, n nVar, Locale locale2) {
        super(view, conversationListener2);
        this.conversationListener = conversationListener2;
        this.appConfigProvider = provider;
        this.requestManager = nVar;
        this.locale = locale2;
        applyCardBorderStyle(this.cellLayout);
        C0246g.b((LayoutParams) this.cellLayout.getLayoutParams(), this.cellLayout.getContext().getResources().getDimensionPixelSize(R.dimen.intercom_attribute_part_left_margin));
    }

    private void addAttributeView(ViewGroup viewGroup, Attribute attribute, AttributeMetadata attributeMetadata, String str) {
        char c2;
        Context context = viewGroup.getContext();
        String renderType = attribute.getRenderType();
        switch (renderType.hashCode()) {
            case -1034364087:
                if (renderType.equals(AttributeType.NUMBER)) {
                    c2 = 3;
                    break;
                }
            case 3076014:
                if (renderType.equals(AttributeType.DATE)) {
                    c2 = 8;
                    break;
                }
            case 3322014:
                if (renderType.equals(AttributeType.LIST)) {
                    c2 = 7;
                    break;
                }
            case 3556653:
                if (renderType.equals(AttributeType.TEXT)) {
                    c2 = 0;
                    break;
                }
            case 64711720:
                if (renderType.equals(AttributeType.BOOLEAN)) {
                    c2 = 6;
                    break;
                }
            case 75849770:
                if (renderType.equals(AttributeType.WEBSITE)) {
                    c2 = 2;
                    break;
                }
            case 96619420:
                if (renderType.equals("email")) {
                    c2 = 1;
                    break;
                }
            case 97526364:
                if (renderType.equals(AttributeType.FLOAT)) {
                    c2 = 4;
                    break;
                }
            case 106642798:
                if (renderType.equals(AttributeType.PHONE)) {
                    c2 = 5;
                    break;
                }
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                TextAttributeView textAttributeView = new TextAttributeView(context);
                textAttributeView.setMetadata(attributeMetadata);
                textAttributeView.updateSubmitButtonColor((AppConfig) this.appConfigProvider.get());
                textAttributeView.setOnSubmitClickListener(str, this.conversationListener);
                textAttributeView.setUpAttribute(attribute, this.locale);
                textAttributeView.setOnFocusChangeListener(this.inputFocusChangeListener);
                viewGroup.addView(textAttributeView);
                return;
            case 6:
                BooleanAttributeView booleanAttributeView = new BooleanAttributeView(context);
                booleanAttributeView.setMetadata(attributeMetadata);
                booleanAttributeView.updateAttributeContent(attribute);
                booleanAttributeView.setOnSubmitClickListener(str, this.conversationListener);
                viewGroup.addView(booleanAttributeView);
                return;
            case 7:
                ListAttributeView listAttributeView = new ListAttributeView(context);
                listAttributeView.setMetadata(attributeMetadata);
                listAttributeView.updateAttributeContent(attribute);
                listAttributeView.setOnClickListener(str, this.conversationListener);
                viewGroup.addView(listAttributeView);
                return;
            case 8:
                DateAttributeView dateAttributeView = new DateAttributeView(context);
                dateAttributeView.setMetadata(attributeMetadata);
                dateAttributeView.updateAttributeContent(attribute);
                dateAttributeView.setOnClickListener(str, this.conversationListener);
                viewGroup.addView(dateAttributeView);
                return;
            default:
                return;
        }
    }

    private void applyCardBorderStyle(View view) {
        ColorUtils.updateInnerBorderColor((AppConfig) this.appConfigProvider.get(), view);
    }

    public void bind(Part part, ViewGroup viewGroup) {
        if (this.networkAvatar != null) {
            showAvatar(part.getParticipant(), this.networkAvatar, (AppConfig) this.appConfigProvider.get(), this.requestManager);
            updateAvatarMarginForCard(part);
        }
        renderAttributes(viewGroup, part.getForm().getAttributes(), part.getId());
        if (this.cellLayout.getChildCount() > 0) {
            this.cellLayout.removeAllViews();
        }
        if (viewGroup.getParent() != null) {
            ((ViewGroup) viewGroup.getParent()).removeView(viewGroup);
        }
        this.cellLayout.addView(viewGroup);
    }

    /* access modifiers changed from: 0000 */
    public void expandAttributeCard() {
        ViewGroup viewGroup = this.cellLayout;
        if (viewGroup instanceof AttributeCollectorCardView) {
            ((AttributeCollectorCardView) viewGroup).animateToExpand();
            this.networkAvatar.setVisibility(8);
        }
    }

    public void onClick(View view) {
    }

    public /* bridge */ /* synthetic */ boolean onLongClick(View view) {
        return super.onLongClick(view);
    }

    /* access modifiers changed from: 0000 */
    public void renderAttributes(ViewGroup viewGroup, List<Attribute> list, String str) {
        if (viewGroup.getChildCount() > 0) {
            viewGroup.removeAllViews();
        }
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            Attribute attribute = (Attribute) list.get(i2);
            addAttributeView(viewGroup, attribute, new Builder().withPosition(i2).withTotalCount(size).build(), str);
            if (size <= 1 || attribute.hasValue()) {
                i2++;
            } else {
                updateMultiAttributesLabel(viewGroup);
                return;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void updateMultiAttributesLabel(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        if (childCount > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof BaseAttributeView) {
                ((BaseAttributeView) childAt).showLabel(childCount);
            }
        }
    }
}
