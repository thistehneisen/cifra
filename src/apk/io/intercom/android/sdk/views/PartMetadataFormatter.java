package io.intercom.android.sdk.views;

import android.content.res.Resources;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.annotations.SeenState;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.Part.MessageState;
import io.intercom.android.sdk.utilities.TimeFormatter;

public class PartMetadataFormatter {
    private final TimeFormatter timeFormatter;

    /* renamed from: io.intercom.android.sdk.views.PartMetadataFormatter$1 reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$models$Part$MessageState = new int[MessageState.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            $SwitchMap$io$intercom$android$sdk$models$Part$MessageState[MessageState.SENDING.ordinal()] = 1;
            $SwitchMap$io$intercom$android$sdk$models$Part$MessageState[MessageState.FAILED.ordinal()] = 2;
            $SwitchMap$io$intercom$android$sdk$models$Part$MessageState[MessageState.UPLOAD_FAILED.ordinal()] = 3;
            try {
                $SwitchMap$io$intercom$android$sdk$models$Part$MessageState[MessageState.NORMAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public PartMetadataFormatter(TimeFormatter timeFormatter2) {
        this.timeFormatter = timeFormatter2;
    }

    private String formatLastPart(Part part, Resources resources) {
        StringBuilder sb = new StringBuilder();
        if (part.isDisplayDelivered()) {
            sb.append(resources.getString(R.string.intercom_delivered));
        } else {
            sb.append(this.timeFormatter.getFormattedTime(part.getCreatedAt()));
        }
        String str = ". ";
        if (SeenState.SEEN.equalsIgnoreCase(part.getSeenByAdmin())) {
            sb.append(str);
            sb.append(resources.getString(R.string.intercom_message_seen));
        } else {
            if (SeenState.UNSEEN.equalsIgnoreCase(part.getSeenByAdmin())) {
                sb.append(str);
                sb.append(resources.getString(R.string.intercom_message_unseen));
            }
        }
        return sb.toString();
    }

    private String formatPart(Part part) {
        if (part.isDisplayDelivered()) {
            return "";
        }
        return this.timeFormatter.getAbsoluteTime(part.getCreatedAt());
    }

    public String getMetadataString(Part part, boolean z, Resources resources) {
        String str;
        int i2 = AnonymousClass1.$SwitchMap$io$intercom$android$sdk$models$Part$MessageState[part.getMessageState().ordinal()];
        if (i2 == 1) {
            return resources.getString(R.string.intercom_message_state_sending);
        }
        if (i2 == 2 || i2 == 3) {
            return resources.getString(R.string.intercom_message_failed_try_again);
        }
        if (z) {
            str = formatLastPart(part, resources);
        } else {
            str = formatPart(part);
        }
        return str;
    }
}
