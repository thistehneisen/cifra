package io.intercom.android.sdk.blocks.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.appcompat.widget.AppCompatTextView;
import b.g.a.a;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.blocks.BlockAlignment;
import io.intercom.android.sdk.blocks.StyleType;
import io.intercom.android.sdk.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.utilities.BlockUtils;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.android.sdk.utilities.TrackingLinkMovementMethod;

@SuppressLint({"ViewConstructor"})
public class ParagraphView extends AppCompatTextView {
    private static final int DEFAULT_LINE_SPACING_DP = 2;
    private static final int POST_BOTTOM_MARGIN_DP = 24;
    private static final int POST_LINE_SPACING_DP = 4;

    /* renamed from: io.intercom.android.sdk.blocks.views.ParagraphView$1 reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$blocks$StyleType = new int[StyleType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            $SwitchMap$io$intercom$android$sdk$blocks$StyleType[StyleType.ADMIN.ordinal()] = 1;
            $SwitchMap$io$intercom$android$sdk$blocks$StyleType[StyleType.ARTICLE.ordinal()] = 2;
            $SwitchMap$io$intercom$android$sdk$blocks$StyleType[StyleType.NOTE.ordinal()] = 3;
            $SwitchMap$io$intercom$android$sdk$blocks$StyleType[StyleType.CONTAINER_CARD.ordinal()] = 4;
            $SwitchMap$io$intercom$android$sdk$blocks$StyleType[StyleType.POST.ordinal()] = 5;
            $SwitchMap$io$intercom$android$sdk$blocks$StyleType[StyleType.CHAT_FULL.ordinal()] = 6;
            try {
                $SwitchMap$io$intercom$android$sdk$blocks$StyleType[StyleType.USER.ordinal()] = 7;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public ParagraphView(Context context, StyleType styleType, BlockAlignment blockAlignment, AppConfig appConfig) {
        super(context);
        BlockUtils.createLayoutParams(this, -2, -2);
        BlockUtils.setDefaultMarginBottom(this);
        setLineSpacing((float) ScreenUtils.dpToPx(2.0f, context), 1.0f);
        setTextSize(16.0f);
        setTextIsSelectable(false);
        setEllipsize(TruncateAt.END);
        setScrollContainer(false);
        setFocusable(false);
        setClickable(false);
        setLongClickable(false);
        setGravity(blockAlignment.getGravity());
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) getLayoutParams();
        int primaryColor = appConfig.getPrimaryColor();
        switch (AnonymousClass1.$SwitchMap$io$intercom$android$sdk$blocks$StyleType[styleType.ordinal()]) {
            case 1:
                setMovementMethod(new TrackingLinkMovementMethod());
                setTextColor(a.a(context, R.color.intercom_grey_800));
                setLinkTextColor(primaryColor);
                return;
            case 2:
                setMovementMethod(new TrackingLinkMovementMethod());
                setTextColor(a.a(context, R.color.intercom_grey_700));
                setLinkTextColor(ColorUtils.primaryOrDarkColor(context, appConfig));
                return;
            case 3:
            case 4:
                setMovementMethod(new TrackingLinkMovementMethod());
                setTextColor(a.a(context, R.color.intercom_grey_700));
                setLinkTextColor(primaryColor);
                return;
            case 5:
                marginLayoutParams.bottomMargin = ScreenUtils.dpToPx(24.0f, context);
                setMovementMethod(new TrackingLinkMovementMethod());
                setLineSpacing((float) ScreenUtils.dpToPx(4.0f, context), 1.0f);
                setTextColor(a.a(context, R.color.intercom_white));
                setLinkTextColor(ColorUtils.lightenColor(primaryColor));
                return;
            case 6:
                setTextSize(14.0f);
                setTextColor(a.a(context, R.color.intercom_grey_600));
                setLinkTextColor(primaryColor);
                return;
            default:
                setMovementMethod(new TrackingLinkMovementMethod());
                setIncludeFontPadding(false);
                ColorUtils.setTextColorWhiteOrDark(this, appConfig.primaryColorRenderDarkText());
                return;
        }
    }
}
