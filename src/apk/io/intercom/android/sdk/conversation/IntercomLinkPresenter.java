package io.intercom.android.sdk.conversation;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.views.IntercomLinkView;

public class IntercomLinkPresenter {
    private static final String SOLUTION_LIVE_CHAT = "live_chat";
    /* access modifiers changed from: private */
    public final Api api;
    /* access modifiers changed from: private */
    public final Provider<AppConfig> appConfigProvider;
    /* access modifiers changed from: private */
    public final String appId;
    private final String conversationId;
    /* access modifiers changed from: private */
    public final boolean fromHomeScreen;
    final IntercomLinkView intercomLinkView;
    /* access modifiers changed from: private */
    public String solution = SOLUTION_LIVE_CHAT;
    /* access modifiers changed from: private */
    public final String userId;
    private boolean wasAtBottom = false;

    public interface IntercomLinkHost {
        void addBottomPadding(int i2);

        boolean isAtBottom();
    }

    public IntercomLinkPresenter(IntercomLinkView intercomLinkView2, Provider<AppConfig> provider, Api api2, String str, String str2, String str3, boolean z) {
        this.intercomLinkView = intercomLinkView2;
        this.appConfigProvider = provider;
        this.api = api2;
        this.conversationId = str;
        this.appId = str2;
        this.userId = str3;
        this.fromHomeScreen = z;
    }

    /* access modifiers changed from: 0000 */
    public void onProfileScrolled(View view) {
        if (shouldShowIntercomLink() && view != null) {
            this.intercomLinkView.hideIfIntersectedOrShow(view);
        }
    }

    public void setSolution(String str) {
        this.solution = str;
    }

    public void setup(IntercomLinkHost intercomLinkHost) {
        this.intercomLinkView.setAlpha(0.0f);
        if (shouldShowIntercomLink()) {
            Resources resources = this.intercomLinkView.getResources();
            intercomLinkHost.addBottomPadding(resources.getDimensionPixelSize(R.dimen.intercom_link_height) + (resources.getDimensionPixelSize(R.dimen.intercom_link_text_padding) * 2));
            this.intercomLinkView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (IntercomLinkPresenter.this.intercomLinkView.getAlpha() == 1.0f) {
                        IntercomLinkPresenter intercomLinkPresenter = IntercomLinkPresenter.this;
                        intercomLinkPresenter.intercomLinkView.followIntercomLink(intercomLinkPresenter.appConfigProvider, IntercomLinkPresenter.this.api, IntercomLinkPresenter.this.fromHomeScreen, IntercomLinkPresenter.this.appId, IntercomLinkPresenter.this.userId, IntercomLinkPresenter.this.solution);
                    }
                }
            });
            if (this.conversationId.isEmpty()) {
                this.intercomLinkView.show();
            }
        }
    }

    public boolean shouldShowIntercomLink() {
        return ((AppConfig) this.appConfigProvider.get()).shouldShowIntercomLink();
    }

    /* access modifiers changed from: 0000 */
    public void updateIntercomLink(IntercomLinkHost intercomLinkHost) {
        if (shouldShowIntercomLink()) {
            boolean isAtBottom = intercomLinkHost.isAtBottom();
            if (isAtBottom && !this.wasAtBottom) {
                this.intercomLinkView.show();
            } else if (this.wasAtBottom && !isAtBottom) {
                this.intercomLinkView.hide();
            }
            this.wasAtBottom = intercomLinkHost.isAtBottom();
        }
    }
}
