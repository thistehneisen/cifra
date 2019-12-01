package io.intercom.android.sdk.blocks;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.widget.ImageView;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.views.ResizableImageView;
import io.intercom.com.bumptech.glide.f.g;
import io.intercom.com.bumptech.glide.k;

class Image {
    private final StyleType style;

    /* renamed from: io.intercom.android.sdk.blocks.Image$1 reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$blocks$StyleType = new int[StyleType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|(3:15|16|18)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            $SwitchMap$io$intercom$android$sdk$blocks$StyleType[StyleType.USER.ordinal()] = 1;
            $SwitchMap$io$intercom$android$sdk$blocks$StyleType[StyleType.ADMIN.ordinal()] = 2;
            $SwitchMap$io$intercom$android$sdk$blocks$StyleType[StyleType.PREVIEW.ordinal()] = 3;
            $SwitchMap$io$intercom$android$sdk$blocks$StyleType[StyleType.POST.ordinal()] = 4;
            $SwitchMap$io$intercom$android$sdk$blocks$StyleType[StyleType.ARTICLE.ordinal()] = 5;
            $SwitchMap$io$intercom$android$sdk$blocks$StyleType[StyleType.NOTE.ordinal()] = 6;
            $SwitchMap$io$intercom$android$sdk$blocks$StyleType[StyleType.CONTAINER_CARD.ordinal()] = 7;
            try {
                $SwitchMap$io$intercom$android$sdk$blocks$StyleType[StyleType.CHAT_FULL.ordinal()] = 8;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    Image(StyleType styleType) {
        this.style = styleType;
    }

    private int calculateChatFullPadding(Context context) {
        Resources resources = context.getResources();
        float dimension = resources.getDimension(R.dimen.intercom_chat_overlay_width);
        float dimension2 = resources.getDimension(R.dimen.intercom_chat_overlay_padding_right);
        float dimension3 = resources.getDimension(R.dimen.intercom_chat_overlay_text_margin_left);
        return (int) (((float) ScreenUtils.getScreenDimensions(context).x) - (dimension - (((dimension2 + dimension3) + resources.getDimension(R.dimen.intercom_chat_overlay_text_padding_left)) + resources.getDimension(R.dimen.intercom_chat_overlay_text_padding_right))));
    }

    private int getTotalViewPadding(Context context) {
        Resources resources = context.getResources();
        switch (AnonymousClass1.$SwitchMap$io$intercom$android$sdk$blocks$StyleType[this.style.ordinal()]) {
            case 1:
            case 2:
            case 3:
                float dimension = resources.getDimension(R.dimen.intercom_avatar_size);
                float dimension2 = resources.getDimension(R.dimen.intercom_conversation_row_icon_spacer);
                return (int) (dimension + dimension2 + resources.getDimension(R.dimen.intercom_conversation_row_margin) + (resources.getDimension(R.dimen.intercom_cell_horizontal_padding) * 3.0f));
            case 4:
                return ((int) (resources.getDimension(R.dimen.intercom_cell_content_padding) + resources.getDimension(R.dimen.intercom_post_cell_padding))) * 2;
            case 5:
            case 6:
                return ((int) (resources.getDimension(R.dimen.intercom_cell_content_padding) + resources.getDimension(R.dimen.intercom_note_cell_padding) + resources.getDimension(R.dimen.intercom_note_layout_margin))) * 2;
            case 7:
                return ((int) (resources.getDimension(R.dimen.intercom_cell_content_padding) + resources.getDimension(R.dimen.intercom_note_cell_padding) + resources.getDimension(R.dimen.intercom_note_layout_margin))) * 2;
            case 8:
                return calculateChatFullPadding(context);
            default:
                return 0;
        }
    }

    /* access modifiers changed from: protected */
    public StyleType getStyle() {
        return this.style;
    }

    /* access modifiers changed from: protected */
    public void setBackground(ImageView imageView) {
        imageView.setBackgroundResource(R.drawable.intercom_rounded_image_preview);
    }

    /* access modifiers changed from: protected */
    public void setImageViewBounds(int i2, int i3, ResizableImageView resizableImageView, k kVar) {
        resizableImageView.setTotalViewPadding(getTotalViewPadding(resizableImageView.getContext()));
        resizableImageView.setDisplayImageDimensions(i2, i3);
        Point imageDimens = resizableImageView.getImageDimens();
        if (imageDimens.x > 0 && imageDimens.y > 0) {
            kVar.a(new g().a(imageDimens.x, imageDimens.y));
        }
    }
}
