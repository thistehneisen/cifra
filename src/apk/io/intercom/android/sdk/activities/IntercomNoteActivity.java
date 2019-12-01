package io.intercom.android.sdk.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
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

public class IntercomNoteActivity extends IntercomBaseActivity implements OnClickListener {
    private static final String LAST_PARTICIPANT = "last_participant";
    private static final String PARCEL_CONVERSATION_ID = "parcel_conversation_id";
    private static final String PARCEL_PART = "parcel_part";
    View composerLayout;
    String conversationId;
    private LastParticipatingAdmin lastParticipatingAdmin;
    MetricTracker metricTracker;
    private LinearLayout noteLayout;
    Part part;
    private final FullScreenInAppPresenter presenter = new FullScreenInAppPresenter();
    ReactionInputView reactionComposer;
    /* access modifiers changed from: private */
    public n requestManager;

    public static Intent buildNoteIntent(Context context, Part part2, String str, LastParticipatingAdmin lastParticipatingAdmin2) {
        Intent putExtra = new Intent(context, IntercomNoteActivity.class).putExtra(PARCEL_PART, part2).putExtra(LAST_PARTICIPANT, lastParticipatingAdmin2);
        if (!TextUtils.isEmpty(str)) {
            putExtra.putExtra(PARCEL_CONVERSATION_ID, str);
        }
        putExtra.setExtrasClassLoader(Part.class.getClassLoader());
        return putExtra;
    }

    /* access modifiers changed from: 0000 */
    public void animateContent() {
        this.noteLayout.setScaleX(0.9f);
        this.noteLayout.setScaleY(0.9f);
        this.noteLayout.setAlpha(0.0f);
        this.noteLayout.setVisibility(0);
        this.noteLayout.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200).start();
    }

    public void onBackPressed() {
        this.presenter.closeWindow(this);
        this.metricTracker.closedInAppFromFull(this.conversationId, this.part.getId());
    }

    public void onClick(View view) {
        if (view.getId() == R.id.note_touch_target) {
            this.presenter.closeWindow(this);
            this.metricTracker.closedInAppFromFull(this.conversationId, this.part.getId());
            startActivity(IntercomMessengerActivity.openConversation(this, this.conversationId, this.lastParticipatingAdmin));
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.intercom_activity_note);
        this.requestManager = c.a((C0195j) this);
        this.noteLayout = (LinearLayout) findViewById(R.id.note_layout);
        this.noteLayout.setVisibility(4);
        this.reactionComposer = (ReactionInputView) findViewById(R.id.reaction_input_view);
        IntercomToolbar intercomToolbar = (IntercomToolbar) findViewById(R.id.intercom_toolbar);
        intercomToolbar.setListener(new InAppToolbarListener(this));
        this.part = new Part();
        this.lastParticipatingAdmin = LastParticipatingAdmin.NULL;
        Injector injector = Injector.get();
        Api api = injector.getApi();
        this.metricTracker = injector.getMetricTracker();
        Provider appConfigProvider = injector.getAppConfigProvider();
        TimeFormatter timeFormatter = new TimeFormatter(this, injector.getTimeProvider());
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            extras.setClassLoader(Part.class.getClassLoader());
            String str = PARCEL_PART;
            if (extras.containsKey(str)) {
                this.part = (Part) extras.getParcelable(str);
                Part part2 = this.part;
                intercomToolbar.setTitle(Phrase.from((Context) this, R.string.intercom_teammate_from_company).put("name", (CharSequence) (part2 == null || part2.getParticipant() == null) ? "" : this.part.getParticipant().getForename()).put("company", (CharSequence) ((AppConfig) appConfigProvider.get()).getName()).format());
            }
            String str2 = PARCEL_CONVERSATION_ID;
            if (extras.containsKey(str2)) {
                this.conversationId = extras.getString(str2);
                injector.getStore().dispatch(Actions.conversationMarkedAsRead(this.conversationId));
                api.markConversationAsRead(this.conversationId);
            }
            String str3 = LAST_PARTICIPANT;
            if (extras.containsKey(str3)) {
                this.lastParticipatingAdmin = (LastParticipatingAdmin) extras.getParcelable(str3);
                if (!LastParticipatingAdmin.isNull(this.lastParticipatingAdmin)) {
                    intercomToolbar.setSubtitle(timeFormatter.getAdminActiveStatus(this.lastParticipatingAdmin, appConfigProvider));
                }
            }
        }
        intercomToolbar.setUpNoteToolbar(this.part.getParticipant(), this.lastParticipatingAdmin.isActive(), new ActiveStatePresenter(), (AppConfig) appConfigProvider.get(), this.requestManager);
        ViewHolderGenerator viewHolderGenerator = new ViewHolderGenerator(new UploadingImageCache(), api, appConfigProvider, this.conversationId, new LightboxOpeningImageClickListener(api), new LinkOpeningButtonClickListener(api), this.requestManager, injector.getGson(), injector.getBus(), this.metricTracker, this);
        BlocksViewHolder noteHolder = viewHolderGenerator.getNoteHolder();
        this.composerLayout = findViewById(R.id.note_composer_container);
        final ContentAwareScrollView contentAwareScrollView = (ContentAwareScrollView) findViewById(R.id.note_view);
        contentAwareScrollView.addView(BlockUtils.getBlockView(contentAwareScrollView, ViewHolderGenerator.createPartsLayout(noteHolder, this.part, this), this));
        if (!ReactionReply.isNull(this.part.getReactionReply())) {
            final ConversationReactionListener conversationReactionListener = new ConversationReactionListener(ReactionLocation.IN_APP, this.part.getId(), this.conversationId, Injector.get().getApi(), this.metricTracker);
            contentAwareScrollView.setListener(new Listener() {
                public void onBottomReached() {
                    contentAwareScrollView.setListener(null);
                    IntercomNoteActivity.this.composerLayout.setVisibility(0);
                    IntercomNoteActivity intercomNoteActivity = IntercomNoteActivity.this;
                    intercomNoteActivity.reactionComposer.setUpReactions(intercomNoteActivity.part.getReactionReply(), true, conversationReactionListener, IntercomNoteActivity.this.requestManager);
                }

                public void onScrollChanged(int i2) {
                }
            });
            this.reactionComposer.preloadReactionImages(this.part.getReactionReply(), this.requestManager);
        }
        View decorView = getWindow().getDecorView();
        decorView.setAlpha(0.0f);
        decorView.animate().alpha(1.0f).setDuration(200).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                IntercomNoteActivity.this.animateContent();
                if (ReactionReply.isNull(IntercomNoteActivity.this.part.getReactionReply())) {
                    IntercomNoteActivity.this.composerLayout.setVisibility(0);
                    IntercomNoteActivity.this.findViewById(R.id.note_touch_target).setOnClickListener(IntercomNoteActivity.this);
                    IntercomNoteActivity.this.findViewById(R.id.composer_input_view).setVisibility(0);
                }
            }
        }).start();
    }
}
