package io.intercom.android.sdk.overlay;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.overlay.DefaultLauncher.Listener;

public class DefaultLauncherPresenter implements Listener {
    private int bottomPadding = 0;
    DefaultLauncher defaultLauncher;
    private final LayoutInflater inflater;
    private final MetricTracker metricTracker;
    private final LauncherOpenBehaviour openBehaviour;
    private int previousUnreadCount = 0;

    public DefaultLauncherPresenter(LayoutInflater layoutInflater, LauncherOpenBehaviour launcherOpenBehaviour, MetricTracker metricTracker2) {
        this.inflater = layoutInflater;
        this.openBehaviour = launcherOpenBehaviour;
        this.metricTracker = metricTracker2;
        this.bottomPadding = getDefaultPadding(layoutInflater.getContext().getResources());
    }

    private int getDefaultPadding(Resources resources) {
        return resources.getDimensionPixelSize(R.dimen.intercom_launcher_padding_bottom) + resources.getDimensionPixelSize(R.dimen.intercom_bottom_padding);
    }

    public void displayLauncherOnAttachedRoot(ViewGroup viewGroup, int i2, AppConfig appConfig) {
        DefaultLauncher defaultLauncher2 = this.defaultLauncher;
        if (defaultLauncher2 != null && !defaultLauncher2.isAttachedToRoot(viewGroup)) {
            this.defaultLauncher.removeView();
            this.defaultLauncher = null;
        }
        if (this.defaultLauncher == null) {
            this.defaultLauncher = new DefaultLauncher(viewGroup, this.inflater, this, this.bottomPadding);
            this.defaultLauncher.fadeOnScreen();
        }
        setLauncherBackgroundColor(appConfig, i2);
        setUnreadCount(this.previousUnreadCount);
    }

    /* access modifiers changed from: 0000 */
    public DefaultLauncher getAndUnsetLauncher() {
        DefaultLauncher defaultLauncher2 = this.defaultLauncher;
        this.defaultLauncher = null;
        return defaultLauncher2;
    }

    public boolean isDisplaying() {
        return this.defaultLauncher != null;
    }

    public void onLauncherClicked(Context context) {
        this.openBehaviour.openMessenger(context);
    }

    /* access modifiers changed from: 0000 */
    public void removeLauncher() {
        DefaultLauncher defaultLauncher2 = this.defaultLauncher;
        if (defaultLauncher2 != null) {
            defaultLauncher2.fadeOffScreen(null);
            this.defaultLauncher = null;
        }
    }

    public void setBottomPadding(int i2) {
        this.bottomPadding = getDefaultPadding(this.inflater.getContext().getResources()) + i2;
        if (isDisplaying()) {
            this.defaultLauncher.updateBottomPadding(this.bottomPadding);
        }
    }

    /* access modifiers changed from: 0000 */
    public void setLauncherBackgroundColor(AppConfig appConfig, int i2) {
        DefaultLauncher defaultLauncher2 = this.defaultLauncher;
        if (defaultLauncher2 != null) {
            defaultLauncher2.setLauncherColor(appConfig, i2);
        }
    }

    public void setUnreadCount(int i2) {
        if (isDisplaying()) {
            String valueOf = String.valueOf(i2);
            if (i2 > this.previousUnreadCount) {
                this.metricTracker.receivedNotificationFromBadgeWhenMessengerClosed(valueOf);
            }
            if (i2 > 0) {
                this.defaultLauncher.setBadgeCount(valueOf);
            } else {
                this.defaultLauncher.hideBadgeCount();
            }
        }
        this.previousUnreadCount = i2;
    }
}
