package io.intercom.android.sdk.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.OvershootInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.C0195j;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.actions.Actions;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.blocks.BlocksViewHolder;
import io.intercom.android.sdk.blocks.LightboxOpeningImageClickListener;
import io.intercom.android.sdk.blocks.LinkOpeningButtonClickListener;
import io.intercom.android.sdk.blocks.UploadingImageCache;
import io.intercom.android.sdk.blocks.ViewHolderGenerator;
import io.intercom.android.sdk.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.conversation.ReactionInputView;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.metrics.MetricTracker.ReactionLocation;
import io.intercom.android.sdk.models.LastParticipatingAdmin;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.ReactionReply;
import io.intercom.android.sdk.utilities.BlockUtils;
import io.intercom.android.sdk.utilities.Phrase;
import io.intercom.android.sdk.utilities.TimeFormatter;
import io.intercom.android.sdk.views.ActiveStatePresenter;
import io.intercom.android.sdk.views.ContentAwareScrollView;
import io.intercom.android.sdk.views.ContentAwareScrollView.Listener;
import io.intercom.android.sdk.views.IntercomToolbar;
import io.intercom.com.bumptech.glide.c;
import io.intercom.com.bumptech.glide.n;

public class IntercomPostActivity extends IntercomBaseActivity implements OnClickListener {
    private static final String LAST_PARTICIPANT = "last_participant";
    private static final String PARCEL_CONVERSATION_ID = "parcel_conversation_id";
    private static final String PARCEL_PART = "parcel_part";
    private static final String POST_PREVIEW = "is_post_preview";
    View composerLayout;
    String conversationId;
    private boolean isPreview = false;
    private LastParticipatingAdmin lastParticipatingAdmin;
    MetricTracker metricTracker;
    Part part;
    private FrameLayout postContainer;
    ContentAwareScrollView postView;
    private final FullScreenInAppPresenter presenter = new FullScreenInAppPresenter();
    ReactionInputView reactionComposer;
    /* access modifiers changed from: private */
    public n requestManager;
    private EditText textComposer;

    public static Intent buildPostIntent(Context context, Part part2, String str, LastParticipatingAdmin lastParticipatingAdmin2, boolean z) {
        Intent putExtra = new Intent(context, IntercomPostActivity.class).putExtra(PARCEL_PART, part2).putExtra(LAST_PARTICIPANT, lastParticipatingAdmin2).putExtra(POST_PREVIEW, z);
        if (!TextUtils.isEmpty(str)) {
            putExtra.putExtra(PARCEL_CONVERSATION_ID, str);
        }
        putExtra.setExtrasClassLoader(Part.class.getClassLoader());
        return putExtra;
    }

    /* access modifiers changed from: 0000 */
    public void animateComposer() {
        View view = this.composerLayout;
        view.setY(view.getY() + ((float) ScreenUtils.dpToPx(156.0f, this)));
        this.composerLayout.setVisibility(0);
        this.textComposer.setVisibility(0);
        this.composerLayout.animate().setInterpolator(new OvershootInterpolator(0.6f)).translationY(0.0f).setDuration(300).start();
    }

    /* access modifiers changed from: 0000 */
    public void animateContent() {
        FrameLayout frameLayout = this.postContainer;
        frameLayout.setY(frameLayout.getY() + ((float) ScreenUtils.dpToPx(400.0f, this)));
        this.postContainer.setVisibility(0);
        this.postContainer.animate().setInterpolator(new OvershootInterpolator(0.6f)).translationY(0.0f).setDuration(300).start();
    }

    /* access modifiers changed from: 0000 */
    public void animateToolbar(IntercomToolbar intercomToolbar) {
        intercomToolbar.setY(intercomToolbar.getY() + ((float) ScreenUtils.dpToPx(200.0f, this)));
        intercomToolbar.setVisibility(0);
        intercomToolbar.animate().setInterpolator(new OvershootInterpolator(0.6f)).translationY(0.0f).setDuration(300).start();
    }

    public void onBackPressed() {
        this.presenter.closeWindow(this);
        if (this.isPreview) {
            this.metricTracker.closedInAppFromFull(this.conversationId, this.part.getId());
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.post_touch_target) {
            this.presenter.closeWindow(this);
            if (this.isPreview) {
                this.metricTracker.openedConversationFromFull(this.conversationId, this.part.getId());
                startActivity(IntercomMessengerActivity.openConversation(this, this.conversationId, this.lastParticipatingAdmin));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.intercom_activity_post);
        this.requestManager = c.a((C0195j) this);
        Injector injector = Injector.get();
        Api api = injector.getApi();
        this.metricTracker = injector.getMetricTracker();
        Provider appConfigProvider = injector.getAppConfigProvider();
        final IntercomToolbar intercomToolbar = (IntercomToolbar) findViewById(R.id.intercom_toolbar);
        intercomToolbar.setListener(new InAppToolbarListener(this));
        this.part = new Part();
        this.lastParticipatingAdmin = LastParticipatingAdmin.NULL;
        TimeFormatter timeFormatter = new TimeFormatter(this, injector.getTimeProvider());
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            extras.setClassLoader(Part.class.getClassLoader());
            String str = PARCEL_PART;
            String str2 = "";
            if (extras.containsKey(str)) {
                this.part = (Part) extras.getParcelable(str);
                Part part2 = this.part;
                intercomToolbar.setTitle(Phrase.from((Context) this, R.string.intercom_teammate_from_company).put("name", (CharSequence) (part2 == null || part2.getParticipant() == null) ? str2 : this.part.getParticipant().getForename()).put("company", (CharSequence) ((AppConfig) appConfigProvider.get()).getName()).format());
            }
            String str3 = PARCEL_CONVERSATION_ID;
            if (extras.containsKey(str3)) {
                this.conversationId = extras.getString(str3, str2);
                injector.getStore().dispatch(Actions.conversationMarkedAsRead(this.conversationId));
                api.markConversationAsRead(this.conversationId);
            }
            String str4 = POST_PREVIEW;
            if (extras.containsKey(str4)) {
                this.isPreview = extras.getBoolean(str4, false);
            }
            String str5 = LAST_PARTICIPANT;
            if (extras.containsKey(str5)) {
                this.lastParticipatingAdmin = (LastParticipatingAdmin) extras.getParcelable(str5);
                if (!LastParticipatingAdmin.isNull(this.lastParticipatingAdmin)) {
                    intercomToolbar.setSubtitle(timeFormatter.getAdminActiveStatus(this.lastParticipatingAdmin, appConfigProvider));
                }
            }
        }
        intercomToolbar.setVisibility(8);
        intercomToolbar.setUpPostToolbar(this.part.getParticipant(), this.lastParticipatingAdmin.isActive(), new ActiveStatePresenter(), (AppConfig) appConfigProvider.get(), this.requestManager);
        int primaryColor = ((AppConfig) appConfigProvider.get()).getPrimaryColor();
        View decorView = getWindow().getDecorView();
        decorView.setBackgroundColor(Color.argb(153, Color.red(primaryColor), Color.green(primaryColor), Color.blue(primaryColor)));
        ViewHolderGenerator viewHolderGenerator = new ViewHolderGenerator(new UploadingImageCache(), api, appConfigProvider, this.conversationId, new LightboxOpeningImageClickListener(api), new LinkOpeningButtonClickListener(api), this.requestManager, injector.getGson(), injector.getBus(), this.metricTracker, this);
        BlocksViewHolder postHolder = viewHolderGenerator.getPostHolder();
        this.postContainer = (FrameLayout) findViewById(R.id.post_container);
        this.composerLayout = findViewById(R.id.conversation_coordinator);
        this.textComposer = (EditText) findViewById(R.id.composer_input_view);
        this.reactionComposer = (ReactionInputView) findViewById(R.id.reaction_input_view);
        this.postView = (ContentAwareScrollView) findViewById(R.id.post_view);
        LinearLayout createPartsLayout = ViewHolderGenerator.createPartsLayout(postHolder, this.part, this);
        ContentAwareScrollView contentAwareScrollView = this.postView;
        contentAwareScrollView.addView(BlockUtils.getBlockView(contentAwareScrollView, createPartsLayout, this));
        if (this.isPreview && !ReactionReply.isNull(this.part.getReactionReply())) {
            final ConversationReactionListener conversationReactionListener = new ConversationReactionListener(ReactionLocation.IN_APP, this.part.getId(), this.conversationId, Injector.get().getApi(), this.metricTracker);
            this.postView.setListener(new Listener() {
                public void onBottomReached() {
                    IntercomPostActivity.this.postView.setListener(null);
                    if (IntercomPostActivity.this.composerLayout.getVisibility() != 0) {
                        IntercomPostActivity.this.composerLayout.setVisibility(0);
                        IntercomPostActivity intercomPostActivity = IntercomPostActivity.this;
                        intercomPostActivity.reactionComposer.setUpReactions(intercomPostActivity.part.getReactionReply(), true, conversationReactionListener, IntercomPostActivity.this.requestManager);
                    }
                }

                public void onScrollChanged(int i2) {
                }
            });
            this.reactionComposer.preloadReactionImages(this.part.getReactionReply(), this.requestManager);
        }
        if (openedFromConversation()) {
            this.metricTracker.viewedInAppFromMessenger(this.part.getMessageStyle(), this.conversationId, this.part.getId());
        }
        decorView.setAlpha(0.0f);
        decorView.animate().alpha(1.0f).setDuration(200).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                IntercomPostActivity.this.animateToolbar(intercomToolbar);
                IntercomPostActivity.this.animateContent();
                if (IntercomPostActivity.this.openedFromConversation()) {
                    IntercomPostActivity.this.composerLayout.setVisibility(8);
                } else if (ReactionReply.isNull(IntercomPostActivity.this.part.getReactionReply())) {
                    IntercomPostActivity.this.findViewById(R.id.post_touch_target).setOnClickListener(IntercomPostActivity.this);
                    IntercomPostActivity.this.animateComposer();
                }
            }
        }).start();
    }

    /* access modifiers changed from: 0000 */
    public boolean openedFromConversation() {
        return !this.isPreview;
    }
}
