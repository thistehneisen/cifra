package io.intercom.android.sdk.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources.NotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.OvershootInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import b.j.a.a.b;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.conversation.JavascriptRunner;
import io.intercom.android.sdk.experimental.Intercom;
import io.intercom.android.sdk.helpcenter.HelpCenterListener;
import io.intercom.android.sdk.helpcenter.HelpCenterWebViewPresenter;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.views.IntercomToolbar;
import io.intercom.android.sdk.views.IntercomToolbar.Listener;
import io.intercom.com.google.gson.o;

public class IntercomHelpCenterActivity extends IntercomBaseActivity implements Listener, HelpCenterListener {
    private static final int ENTRANCE_ANIMATION_TIME_MS = 300;
    private static final int EXIT_ANIMATION_TIME_MS = 150;
    public static final String LINK_TRANSITION_KEY = "link_background";
    private static final String PARCEL_CONVERSATION_ID = "parcel_conversation_id";
    public static final String PARCEL_DISPLAY_MODE = "parcel_display_mode";
    private static final String PARCEL_HELP_CENTER_URL = "parcel_help_center_url";
    private View containerView;
    String conversationId = "";
    @DisplayMode
    int displayMode = 1;
    private o gson;
    private IntercomToolbar intercomToolbar;
    private JavascriptRunner jsRunner;
    ProgressBar loadingView;
    MetricTracker metricTracker;
    private HelpCenterWebViewPresenter presenter;
    WebView webView;

    public @interface DisplayMode {
        public static final int FULL_SCREEN = 1;
        public static final int POP_UP = 0;
    }

    /* access modifiers changed from: private */
    public void animateWindowIn() {
        this.containerView.setVisibility(0);
        this.containerView.setY((float) findViewById(16908290).getMeasuredHeight());
        this.containerView.animate().y(0.0f).setInterpolator(new OvershootInterpolator(0.6f)).setDuration(350).start();
    }

    private void animateWindowOut() {
        this.containerView.animate().y((float) getWindow().getDecorView().getHeight()).setInterpolator(new OvershootInterpolator()).setDuration(600).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                IntercomHelpCenterActivity.this.finish();
                IntercomHelpCenterActivity.this.overridePendingTransition(0, 0);
            }
        }).start();
    }

    public static Intent buildIntent(Context context, String str, @DisplayMode int i2, String str2) {
        Intent intent = new Intent(context, IntercomHelpCenterActivity.class);
        intent.putExtra(PARCEL_HELP_CENTER_URL, str);
        intent.putExtra(PARCEL_DISPLAY_MODE, i2);
        intent.putExtra(PARCEL_CONVERSATION_ID, str2);
        intent.setFlags(268435456);
        return intent;
    }

    @TargetApi(19)
    private Transition enterTransition() {
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setInterpolator(new b());
        changeBounds.setDuration(300);
        return changeBounds;
    }

    private void fadeOutView(View view) {
        view.animate().alpha(0.0f).setDuration(150).start();
    }

    private void hideKeyboard() {
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    private void insertWebView() {
        try {
            this.webView = new WebView(this);
        } catch (NotFoundException unused) {
            this.webView = new WebView(getApplicationContext());
        }
        this.webView.setAlpha(0.0f);
        this.webView.setId(R.id.intercom_help_center_webview);
        this.webView.setLayoutParams(new LayoutParams(-1, -1));
        ((FrameLayout) findViewById(R.id.link_view)).addView(this.webView, 0);
    }

    private boolean isFullScreenWithExperimentalMessenger() {
        return this.displayMode == 1 && Intercom.isBooted();
    }

    @TargetApi(19)
    private Transition returnTransition() {
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setInterpolator(new b());
        changeBounds.setDuration(150);
        return changeBounds;
    }

    /* access modifiers changed from: 0000 */
    public void closeHelpCenter() {
        hideKeyboard();
        if (isFullScreenWithExperimentalMessenger()) {
            this.presenter.resetMessengerToHostState(Intercom.client());
            animateWindowOut();
            return;
        }
        fadeOutView(this.webView);
        supportFinishAfterTransition();
    }

    public void onBackPressed() {
        if (this.webView.canGoBack()) {
            this.webView.goBack();
            return;
        }
        this.metricTracker.closedHelpCenter(this.conversationId, 1);
        closeHelpCenter();
    }

    public void onCloseClicked() {
        this.metricTracker.closedHelpCenter(this.conversationId, 0);
        closeHelpCenter();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        Injector injector = Injector.get();
        this.metricTracker = injector.getMetricTracker();
        AppConfig appConfig = (AppConfig) injector.getAppConfigProvider().get();
        int helpCenterBaseColor = appConfig.getHelpCenterBaseColor();
        Bundle extras = getIntent().getExtras();
        String str2 = "";
        if (extras != null) {
            String string = extras.getString(PARCEL_HELP_CENTER_URL, str2);
            this.conversationId = extras.getString(PARCEL_CONVERSATION_ID, str2);
            this.displayMode = extras.getInt(PARCEL_DISPLAY_MODE, 1);
            str = string;
        } else {
            str = str2;
        }
        if (this.displayMode == 1) {
            setContentView(R.layout.intercom_activity_help_center_fullscreen);
            insertWebView();
            this.intercomToolbar = (IntercomToolbar) findViewById(R.id.intercom_toolbar);
            this.intercomToolbar.setTitle(R.string.intercom_help_center);
            this.intercomToolbar.setUpHelpCenterToolbar(appConfig);
            this.intercomToolbar.setListener(this);
            this.intercomToolbar.setSubtitleVisibility(8);
            this.intercomToolbar.setBackgroundColor(helpCenterBaseColor);
            this.intercomToolbar.setBackgroundColor(helpCenterBaseColor);
            this.intercomToolbar.updateToolbarSize();
            this.containerView = findViewById(R.id.link_root);
            this.containerView.setVisibility(8);
            this.containerView.post(new Runnable() {
                public void run() {
                    IntercomHelpCenterActivity.this.animateWindowIn();
                }
            });
        } else {
            setContentView(R.layout.intercom_activity_help_center);
            insertWebView();
            this.webView.setBackgroundResource(R.drawable.intercom_conversation_card_background);
            findViewById(R.id.dismiss).setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    IntercomHelpCenterActivity intercomHelpCenterActivity = IntercomHelpCenterActivity.this;
                    intercomHelpCenterActivity.metricTracker.closedHelpCenter(intercomHelpCenterActivity.conversationId, 0);
                    IntercomHelpCenterActivity.this.closeHelpCenter();
                }
            });
        }
        if (TextUtils.isEmpty(str)) {
            closeHelpCenter();
        }
        this.loadingView = (ProgressBar) findViewById(R.id.loading_view);
        this.jsRunner = new JavascriptRunner(this.webView);
        this.gson = injector.getGson();
        HelpCenterWebViewPresenter helpCenterWebViewPresenter = new HelpCenterWebViewPresenter(this.webView, this.jsRunner, str, this.gson, this.metricTracker, injector.getAppConfigProvider(), injector.getStore(), injector.getApiProvider(), injector.getUserIdentity(), injector.getAppIdentity(), CookieManager.getInstance(), this);
        this.presenter = helpCenterWebViewPresenter;
        if (isFullScreenWithExperimentalMessenger()) {
            this.presenter.setUpMessenger(Intercom.client());
        }
        this.presenter.setUpWebView();
        if (VERSION.SDK_INT >= 21) {
            getWindow().setSharedElementEnterTransition(enterTransition());
            getWindow().setSharedElementReturnTransition(returnTransition());
            findViewById(R.id.link_view).setTransitionName("link_background");
        }
        this.presenter.loadBundle();
    }

    public void onInboxClicked() {
    }

    public void onToolbarClicked() {
    }

    public void onWebViewFinishedLoad() {
        this.jsRunner.runPendingScripts();
        this.webView.animate().alpha(1.0f).setDuration(300).start();
        this.loadingView.setVisibility(8);
        this.metricTracker.viewedHelpCenter(this.conversationId);
    }
}
