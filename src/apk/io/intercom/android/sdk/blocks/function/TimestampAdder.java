package io.intercom.android.sdk.blocks.function;

import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.Part.Builder;
import java.util.Calendar;
import java.util.List;

public class TimestampAdder {
    private final Calendar currentDate;
    private final Calendar nextDate;

    TimestampAdder(Calendar calendar, Calendar calendar2) {
        this.currentDate = calendar;
        this.nextDate = calendar2;
    }

    public static TimestampAdder create() {
        return new TimestampAdder(Calendar.getInstance(), Calendar.getInstance());
    }

    private boolean isDivider(Part part) {
        return Part.DAY_DIVIDER_STYLE.equals(part.getMessageStyle());
    }

    public void addDayDividers(List<Part> list) {
        this.currentDate.setTimeInMillis(0);
        this.nextDate.setTimeInMillis(0);
        int i2 = 0;
        while (i2 < list.size()) {
            if (!isDivider((Part) list.get(i2))) {
                long createdAt = ((Part) list.get(i2)).getCreatedAt();
                this.nextDate.setTimeInMillis(1000 * createdAt);
                if (datesAreFromDifferentDays() && (i2 == 0 || !isDivider((Part) list.get(i2 - 1)))) {
                    list.add(i2, new Builder().withStyle(Part.DAY_DIVIDER_STYLE).withCreatedAt(createdAt).build());
                    i2++;
                }
                this.currentDate.setTimeInMillis(this.nextDate.getTimeInMillis());
            }
            i2++;
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean datesAreFromDifferentDays() {
        if (this.currentDate.get(6) == this.nextDate.get(6) && this.currentDate.get(1) == this.nextDate.get(1)) {
            return false;
        }
        return true;
    }
}
