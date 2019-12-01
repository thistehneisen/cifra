package io.intercom.android.sdk.homescreen;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.x;
import b.g.a.a;
import b.g.i.B;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.utilities.ColorUtils;

public abstract class BaseConversationCardViewHolder extends x {
    final Provider<AppConfig> appConfigProvider;
    /* access modifiers changed from: private */
    public HomeClickListener clickListener;
    OnClickListener onNewConversationClicked = new OnClickListener() {
        public void onClick(View view) {
            BaseConversationCardViewHolder.this.clickListener.onNewConversationClicked();
        }
    };
    OnClickListener onSeePreviousClicked = new OnClickListener() {
        public void onClick(View view) {
            BaseConversationCardViewHolder.this.clickListener.onSeePreviousClicked();
        }
    };

    BaseConversationCardViewHolder(View view, Provider<AppConfig> provider, HomeClickListener homeClickListener) {
        super(view);
        this.appConfigProvider = provider;
        this.clickListener = homeClickListener;
    }

    /* access modifiers changed from: 0000 */
    public void applyAllConversationButtonStyle(TextView textView) {
        ColorUtils.setTextColorPrimaryOrBlack(textView, (AppConfig) this.appConfigProvider.get());
    }

    /* access modifiers changed from: 0000 */
    public void applyCardBorderStyle(View view) {
        ColorUtils.updateInnerBorderColor((AppConfig) this.appConfigProvider.get(), view);
    }

    /* access modifiers changed from: 0000 */
    public void updateButtonBackgroundColor(TextView textView, int i2) {
        B.a((View) textView, ColorStateList.valueOf(i2));
    }

    /* access modifiers changed from: 0000 */
    public void updateLeftDrawableColor(TextView textView, int i2) {
        Drawable[] compoundDrawables;
        for (Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(i2, Mode.SRC_IN);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void updateOlderConversationUnreadState(TextView textView, boolean z) {
        if (z) {
            textView.setCompoundDrawablesWithIntrinsicBounds(a.c(textView.getContext(), R.drawable.intercom_unread_dot), null, null, null);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        }
    }
}
