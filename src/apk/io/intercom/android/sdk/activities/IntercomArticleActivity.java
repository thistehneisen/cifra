package io.intercom.android.sdk.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.C0195j;
import b.j.a.a.b;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.api.BaseCallback;
import io.intercom.android.sdk.api.ErrorObject;
import io.intercom.android.sdk.blocks.BlocksViewHolder;
import io.intercom.android.sdk.blocks.LightboxOpeningImageClickListener;
import io.intercom.android.sdk.blocks.LinkOpeningButtonClickListener;
import io.intercom.android.sdk.blocks.UploadingImageCache;
import io.intercom.android.sdk.blocks.ViewHolderGenerator;
import io.intercom.android.sdk.conversation.ReactionInputView;
import io.intercom.android.sdk.conversation.ReactionListener;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.metrics.MetricTracker.ReactionLocation;
import io.intercom.android.sdk.models.Avatar;
import io.intercom.android.sdk.models.Link;
import io.intercom.android.sdk.models.LinkResponse.Builder;
import io.intercom.android.sdk.models.Reaction;
import io.intercom.android.sdk.models.ReactionReply;
import io.intercom.android.sdk.utilities.AvatarUtils;
import io.intercom.android.sdk.utilities.BlockUtils;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.android.sdk.utilities.TimeFormatter;
import io.intercom.android.sdk.utilities.ViewUtils;
import io.intercom.android.sdk.views.ContentAwareScrollView;
import io.intercom.android.sdk.views.ContentAwareScrollView.Listener;
import io.intercom.android.sdk.views.IntercomErrorView;
import io.intercom.com.bumptech.glide.c;
import io.intercom.com.bumptech.glide.n;

public class IntercomArticleActivity extends IntercomBaseActivity {
    private static final int ENTRANCE_ANIMATION_TIME_MS = 300;
    private static final int EXIT_ANIMATION_TIME_MS = 150;
    public static final String LINK_TRANSITION_KEY = "link_background";
    private static final String PARCEL_CONVERSATION_ID = "parcel_conversation_id";
    private static final String PARCEL_LINK_ID = "parcel_link_id";
    private static final String PARCEL_PART_ID = "parcel_part_id";
    Api api;
    /* access modifiers changed from: private */
    public final BaseCallback<Builder> apiCallback = new BaseCallback<Builder>() {
        /* access modifiers changed from: protected */
        public void onError(ErrorObject errorObject) {
            IntercomArticleActivity.this.intercomErrorView.setVisibility(0);
            IntercomArticleActivity.this.loadingView.setVisibility(8);
            IntercomArticleActivity.this.scrollView.setVisibility(8);
        }

        /* access modifiers changed from: protected */
        public void onSuccess(Builder builder) {
            IntercomArticleActivity.this.scrollView.setVisibility(0);
            IntercomArticleActivity.this.loadingView.setVisibility(8);
            IntercomArticleActivity.this.intercomErrorView.setVisibility(8);
            IntercomArticleActivity.this.updateContent(builder.build().getLink());
            IntercomArticleActivity intercomArticleActivity = IntercomArticleActivity.this;
            intercomArticleActivity.metricTracker.viewedArticle(intercomArticleActivity.conversationId, intercomArticleActivity.linkId);
        }
    };
    private Provider<AppConfig> appConfigProvider;
    private BlocksViewHolder articleHolder;
    private TextView author;
    private ImageView avatar;
    private int avatarSize;
    private View composerLayout;
    String conversationId;
    private TextView description;
    /* access modifiers changed from: private */
    public IntercomErrorView intercomErrorView;
    private LinearLayout linkContainer;
    String linkId;
    FrameLayout linkView;
    ProgressBar loadingView;
    MetricTracker metricTracker;
    /* access modifiers changed from: private */
    public String partId;
    private ReactionInputView reactionComposer;
    private n requestManager;
    ContentAwareScrollView scrollView;
    private TimeFormatter timeFormatter;
    private TextView title;
    FrameLayout titleBar;
    boolean titleBarEnabled = false;
    TextView titleBarText;
    int titleSize = 0;
    private TextView updated;

    public IntercomArticleActivity() {
        String str = "";
        this.conversationId = str;
        this.partId = str;
        this.linkId = str;
    }

    public static Intent buildIntent(Context context, String str, String str2) {
        return buildIntent(context, str, null, str2);
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

    @TargetApi(19)
    private Transition returnTransition() {
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setInterpolator(new b());
        changeBounds.setDuration(150);
        return changeBounds;
    }

    private void setAuthorSpannable(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("Written by ");
        sb.append(str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(sb.toString());
        int length = spannableStringBuilder.length();
        spannableStringBuilder.setSpan(new StyleSpan(1), length - str.length(), length, 33);
        this.author.setText(spannableStringBuilder);
    }

    /* access modifiers changed from: private */
    public void updateContent(final Link link) {
        AvatarUtils.createAvatar(Avatar.create(link.getAuthor().getAvatar(), ""), this.avatar, this.avatarSize, (AppConfig) this.appConfigProvider.get(), this.requestManager);
        String description2 = link.getDescription();
        if (TextUtils.isEmpty(description2)) {
            this.description.setVisibility(8);
        } else {
            this.description.setVisibility(0);
            this.description.setText(description2);
        }
        String title2 = link.getTitle();
        this.title.setText(title2);
        this.titleBarText.setText(title2);
        setAuthorSpannable(link.getAuthor().getFirstName());
        this.updated.setText(this.timeFormatter.getUpdated(link.getUpdatedAt()));
        LinearLayout createLayoutFromBlocks = ViewHolderGenerator.createLayoutFromBlocks(this.articleHolder, link.getBlocks(), this);
        LinearLayout linearLayout = this.linkContainer;
        linearLayout.addView(BlockUtils.getBlockView(linearLayout, createLayoutFromBlocks, this));
        this.titleSize = this.title.getMeasuredHeight();
        this.scrollView.setListener(new Listener() {
            public void onBottomReached() {
            }

            public void onScrollChanged(int i2) {
                IntercomArticleActivity intercomArticleActivity = IntercomArticleActivity.this;
                if (intercomArticleActivity.titleBarEnabled) {
                    int i3 = i2 - intercomArticleActivity.titleSize;
                    intercomArticleActivity.titleBar.setAlpha(((float) i3) / 100.0f);
                    IntercomArticleActivity intercomArticleActivity2 = IntercomArticleActivity.this;
                    intercomArticleActivity2.titleBarText.setAlpha(((float) (i3 - intercomArticleActivity2.titleBar.getHeight())) / 100.0f);
                }
            }
        });
        this.scrollView.setAlpha(0.0f);
        this.scrollView.animate().alpha(1.0f).setDuration(300).start();
        if (!ReactionReply.isNull(link.getReactionReply())) {
            ReactionReply reactionReply = link.getReactionReply();
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.intercom_link_reaction_height);
            ContentAwareScrollView contentAwareScrollView = this.scrollView;
            contentAwareScrollView.setPadding(contentAwareScrollView.getPaddingLeft(), this.scrollView.getPaddingTop(), this.scrollView.getPaddingRight(), dimensionPixelSize);
            this.reactionComposer.preloadReactionImages(reactionReply, this.requestManager);
            this.reactionComposer.setUpReactions(reactionReply, false, new ReactionListener() {
                public void onReactionSelected(Reaction reaction) {
                    Injector.get().getApi().reactToLink(link.getId(), reaction.getIndex(), false);
                    IntercomArticleActivity intercomArticleActivity = IntercomArticleActivity.this;
                    intercomArticleActivity.metricTracker.sentReaction(intercomArticleActivity.conversationId, intercomArticleActivity.partId, reaction.getIndex(), ReactionLocation.LINK);
                    ((TextView) IntercomArticleActivity.this.findViewById(R.id.reaction_text)).setText(R.string.intercom_article_response);
                }
            }, this.requestManager);
            this.composerLayout.setVisibility(0);
            View view = this.composerLayout;
            view.setY(view.getY() + ((float) dimensionPixelSize));
            this.composerLayout.animate().setInterpolator(new OvershootInterpolator(1.0f)).translationY(0.0f).setDuration(300).setListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    IntercomArticleActivity.this.linkView.setClipChildren(false);
                }
            }).start();
            if (reactionReply.getReactionIndex() != null) {
                ((TextView) findViewById(R.id.reaction_text)).setText(R.string.intercom_article_response);
            }
        }
        this.scrollView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                ViewUtils.removeGlobalLayoutListener(IntercomArticleActivity.this.scrollView, this);
                if (((float) IntercomArticleActivity.this.scrollView.getChildAt(0).getMeasuredHeight()) > ((float) IntercomArticleActivity.this.linkView.getMeasuredHeight()) * 1.5f) {
                    IntercomArticleActivity.this.titleBarEnabled = true;
                }
            }
        });
    }

    /* access modifiers changed from: 0000 */
    public void closeLink() {
        this.titleBarEnabled = false;
        fadeOutView(this.scrollView);
        fadeOutView(this.composerLayout);
        fadeOutView(this.titleBar);
        supportFinishAfterTransition();
    }

    public void onBackPressed() {
        this.metricTracker.closedArticle(this.conversationId, this.linkId, 1);
        closeLink();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.intercom_activity_article);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String str = "";
            this.conversationId = extras.getString(PARCEL_CONVERSATION_ID, str);
            this.partId = extras.getString(PARCEL_PART_ID, str);
            this.linkId = extras.getString(PARCEL_LINK_ID, str);
        }
        this.requestManager = c.a((C0195j) this);
        Injector injector = Injector.get();
        this.appConfigProvider = injector.getAppConfigProvider();
        this.api = injector.getApi();
        this.api.getLink(this.linkId, this.apiCallback);
        this.metricTracker = injector.getMetricTracker();
        int primaryOrDarkColor = ColorUtils.primaryOrDarkColor(this, (AppConfig) this.appConfigProvider.get());
        this.timeFormatter = new TimeFormatter(this, injector.getTimeProvider());
        this.linkView = (FrameLayout) findViewById(R.id.link_view);
        this.titleBar = (FrameLayout) findViewById(R.id.link_title_bar);
        this.titleBarText = (TextView) findViewById(R.id.title_bar_text);
        this.titleBarText.setTextColor(primaryOrDarkColor);
        this.loadingView = (ProgressBar) findViewById(R.id.loading_view);
        this.title = (TextView) findViewById(R.id.title);
        this.title.setTextColor(primaryOrDarkColor);
        this.description = (TextView) findViewById(R.id.description);
        this.reactionComposer = (ReactionInputView) findViewById(R.id.reaction_input_view);
        this.composerLayout = findViewById(R.id.link_composer_container);
        this.author = (TextView) findViewById(R.id.author);
        this.updated = (TextView) findViewById(R.id.updated);
        this.avatarSize = getResources().getDimensionPixelSize(R.dimen.intercom_avatar_size);
        this.avatar = (ImageView) findViewById(R.id.avatar_view);
        UploadingImageCache uploadingImageCache = new UploadingImageCache();
        Api api2 = this.api;
        ViewHolderGenerator viewHolderGenerator = new ViewHolderGenerator(uploadingImageCache, api2, this.appConfigProvider, this.conversationId, new LightboxOpeningImageClickListener(api2), new LinkOpeningButtonClickListener(this.api), this.requestManager, injector.getGson(), injector.getBus(), this.metricTracker, this);
        this.articleHolder = viewHolderGenerator.getArticleHolder();
        this.intercomErrorView = (IntercomErrorView) findViewById(R.id.error_layout_article);
        this.intercomErrorView.setActionButtonTextColor(primaryOrDarkColor);
        this.intercomErrorView.setActionButtonClickListener(new OnClickListener() {
            public void onClick(View view) {
                IntercomArticleActivity.this.loadingView.setVisibility(0);
                IntercomArticleActivity intercomArticleActivity = IntercomArticleActivity.this;
                intercomArticleActivity.api.getLink(intercomArticleActivity.linkId, intercomArticleActivity.apiCallback);
            }
        });
        this.linkContainer = (LinearLayout) findViewById(R.id.link_container);
        this.scrollView = (ContentAwareScrollView) findViewById(R.id.scroll_view);
        findViewById(R.id.dismiss).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                IntercomArticleActivity intercomArticleActivity = IntercomArticleActivity.this;
                intercomArticleActivity.metricTracker.closedArticle(intercomArticleActivity.conversationId, intercomArticleActivity.linkId, 0);
                IntercomArticleActivity.this.closeLink();
            }
        });
        if (VERSION.SDK_INT >= 21) {
            getWindow().setSharedElementEnterTransition(enterTransition());
            getWindow().setSharedElementReturnTransition(returnTransition());
            findViewById(R.id.link_view).setTransitionName("link_background");
        }
    }

    public static Intent buildIntent(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, IntercomArticleActivity.class);
        intent.putExtra(PARCEL_LINK_ID, str);
        if (str2 != null) {
            intent.putExtra(PARCEL_PART_ID, str2);
        }
        intent.putExtra(PARCEL_CONVERSATION_ID, str3);
        intent.setFlags(268435456);
        return intent;
    }
}
