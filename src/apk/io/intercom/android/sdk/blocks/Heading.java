package io.intercom.android.sdk.blocks;

import android.content.Context;
import android.text.Spanned;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import b.g.a.a;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.blocks.blockInterfaces.HeadingBlock;
import io.intercom.android.sdk.blocks.blockInterfaces.SubheadingBlock;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.utilities.BlockUtils;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.android.sdk.utilities.FontUtils;
import io.intercom.android.sdk.utilities.TrackingLinkMovementMethod;

class Heading implements HeadingBlock, SubheadingBlock {
    private static final int LARGE_MARGIN_BOTTOM_DP = 32;
    private static final int LARGE_TEXT_SP = 24;
    private static final int MARGIN_BOTTOM_DP = 16;
    private static final int MEDIUM_TEXT_SP = 20;
    private static final int SMALL_TEXT_SP = 15;
    private final Provider<AppConfig> appConfigProvider;
    private final StyleType style;

    /* renamed from: io.intercom.android.sdk.blocks.Heading$1 reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$blocks$StyleType = new int[StyleType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            $SwitchMap$io$intercom$android$sdk$blocks$StyleType[StyleType.POST.ordinal()] = 1;
            $SwitchMap$io$intercom$android$sdk$blocks$StyleType[StyleType.NOTE.ordinal()] = 2;
            $SwitchMap$io$intercom$android$sdk$blocks$StyleType[StyleType.ARTICLE.ordinal()] = 3;
            $SwitchMap$io$intercom$android$sdk$blocks$StyleType[StyleType.CONTAINER_CARD.ordinal()] = 4;
            $SwitchMap$io$intercom$android$sdk$blocks$StyleType[StyleType.CHAT_FULL.ordinal()] = 5;
        }
    }

    Heading(StyleType styleType, Provider<AppConfig> provider) {
        this.style = styleType;
        this.appConfigProvider = provider;
    }

    private void styleAnnouncementHeading(TextView textView, int i2, int i3, int i4) {
        textView.setTextSize((float) i3);
        textView.setTextColor(i2);
        textView.setLinkTextColor(i2);
        textView.setMovementMethod(new TrackingLinkMovementMethod());
        BlockUtils.setLargeLineSpacing(textView);
        BlockUtils.setMarginBottom(textView, i4);
    }

    private void styleChatHeading(TextView textView, int i2) {
        textView.setTextSize(15.0f);
        textView.setTextColor(i2);
        textView.setLinkTextColor(i2);
        BlockUtils.setSmallLineSpacing(textView);
        BlockUtils.setDefaultMarginBottom(textView);
    }

    public View addHeading(Spanned spanned, BlockAlignment blockAlignment, boolean z, boolean z2, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        TextView textView = new TextView(context);
        BlockUtils.createLayoutParams(textView, -2, -2);
        int primaryColor = ((AppConfig) this.appConfigProvider.get()).getPrimaryColor();
        int i2 = AnonymousClass1.$SwitchMap$io$intercom$android$sdk$blocks$StyleType[this.style.ordinal()];
        if (i2 == 1) {
            styleAnnouncementHeading(textView, ColorUtils.lightenColor(primaryColor), 24, 32);
            FontUtils.setRobotoLightTypeface(textView);
        } else if (i2 == 2) {
            styleAnnouncementHeading(textView, primaryColor, 24, 32);
        } else if (i2 == 3) {
            styleAnnouncementHeading(textView, ColorUtils.primaryOrDarkColor(context, (AppConfig) this.appConfigProvider.get()), 24, 32);
        } else if (i2 == 4) {
            styleAnnouncementHeading(textView, primaryColor, 20, 32);
        } else if (i2 != 5) {
            styleChatHeading(textView, a.a(context, R.color.intercom_grey_800));
            textView.setTypeface(null, 1);
            textView.setMovementMethod(new TrackingLinkMovementMethod());
        } else {
            styleChatHeading(textView, a.a(context, R.color.intercom_grey_800));
            textView.setTypeface(null, 1);
        }
        textView.setText(spanned);
        textView.setGravity(blockAlignment.getGravity());
        BlockUtils.setLayoutMarginsAndGravity(textView, blockAlignment.getGravity(), z2);
        return textView;
    }

    public View addSubheading(Spanned spanned, BlockAlignment blockAlignment, boolean z, boolean z2, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        TextView textView = new TextView(context);
        BlockUtils.createLayoutParams(textView, -2, -2);
        int primaryColor = ((AppConfig) this.appConfigProvider.get()).getPrimaryColor();
        int i2 = AnonymousClass1.$SwitchMap$io$intercom$android$sdk$blocks$StyleType[this.style.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    styleAnnouncementHeading(textView, ColorUtils.primaryOrDarkColor(context, (AppConfig) this.appConfigProvider.get()), 15, 16);
                } else if (i2 != 4) {
                    if (i2 != 5) {
                        styleChatHeading(textView, primaryColor);
                        textView.setMovementMethod(new TrackingLinkMovementMethod());
                    } else {
                        styleChatHeading(textView, a.a(context, R.color.intercom_grey_800));
                    }
                }
            }
            styleAnnouncementHeading(textView, primaryColor, 15, 16);
        } else {
            styleAnnouncementHeading(textView, ColorUtils.lightenColor(primaryColor), 15, 16);
            FontUtils.setRobotoLightTypeface(textView);
        }
        textView.setText(spanned);
        textView.setGravity(blockAlignment.getGravity());
        BlockUtils.setLayoutMarginsAndGravity(textView, blockAlignment.getGravity(), z2);
        return textView;
    }
}
