package io.intercom.android.sdk.views;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import b.g.a.a;
import io.intercom.android.sdk.R;

public class OfficeHoursTextView extends AppCompatTextView {
    public OfficeHoursTextView(Context context) {
        super(context);
    }

    public void setOfficeHoursDrawable(int i2) {
        Drawable c2 = a.c(getContext(), R.drawable.intercom_snooze);
        c2.setColorFilter(new PorterDuffColorFilter(i2, Mode.SRC_IN));
        setCompoundDrawablesWithIntrinsicBounds(c2, null, null, null);
        setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.intercom_office_hours_drawable_padding));
    }

    public OfficeHoursTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
