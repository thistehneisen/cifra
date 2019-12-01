package io.intercom.android.sdk.homescreen;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.x;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.utilities.BackgroundUtils;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.android.sdk.utilities.FontUtils;

public class ErrorViewHolder extends x {
    ErrorViewHolder(View view, Provider<AppConfig> provider, final HomeClickListener homeClickListener) {
        super(view);
        TextView textView = (TextView) view.findViewById(R.id.reload_button);
        textView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                homeClickListener.onReloadClicked();
            }
        });
        applyRetryButtonStyle(textView, (AppConfig) provider.get());
    }

    private void applyRetryButtonStyle(TextView textView, AppConfig appConfig) {
        Context context = textView.getContext();
        int primaryOrDarkColor = ColorUtils.primaryOrDarkColor(context, appConfig);
        FontUtils.setRobotoMediumTypeface(textView);
        BackgroundUtils.setRippleButtonStroke(context, textView.getBackground(), R.id.background, primaryOrDarkColor);
        textView.setTextColor(primaryOrDarkColor);
    }
}
