package io.intercom.android.sdk.conversation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.app.C0146m.a;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.C0195j;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.snackbar.Snackbar;
import com.intercom.input.gallery.GalleryImage;
import e.a.a.a.a.d;
import e.a.a.a.a.k;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.actions.Actions;
import io.intercom.android.sdk.activities.ConversationReactionListener;
import io.intercom.android.sdk.activities.IntercomPostActivity;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.blocks.BlockFactory;
import io.intercom.android.sdk.blocks.BlockType;
import io.intercom.android.sdk.blocks.Blocks;
import io.intercom.android.sdk.blocks.logic.TextSplittingStrategy;
import io.intercom.android.sdk.blocks.models.Block.Builder;
import io.intercom.android.sdk.blocks.models.BlockAttachment;
import io.intercom.android.sdk.conversation.composer.ComposerPresenter;
import io.intercom.android.sdk.conversation.events.AdminIsTypingEvent;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.metrics.MetricTracker.ReactionLocation;
import io.intercom.android.sdk.metrics.ops.OpsMetricTracker;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.LastParticipatingAdmin;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.Participant;
import io.intercom.android.sdk.models.ReactionReply;
import io.intercom.android.sdk.models.TeamPresence;
import io.intercom.android.sdk.models.events.ConversationEvent;
import io.intercom.android.sdk.models.events.ReplyEvent;
import io.intercom.android.sdk.models.events.failure.ConversationFailedEvent;
import io.intercom.android.sdk.nexus.NexusClient;
import io.intercom.android.sdk.nexus.NexusEvent;
import io.intercom.android.sdk.profile.ProfilePresenter;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Selectors;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.store.Store.Subscriber2;
import io.intercom.android.sdk.store.Store.Subscription;
import io.intercom.android.sdk.utilities.ContextLocaliser;
import io.intercom.android.sdk.utilities.StoreUtils;
import io.intercom.android.sdk.utilities.TimeFormatter;
import io.intercom.android.sdk.utilities.ViewUtils;
import io.intercom.android.sdk.utilities.connectivity.NetworkConnectivityMonitor;
import io.intercom.android.sdk.utilities.connectivity.NetworkConnectivityMonitor.ConnectivityEventListener;
import io.intercom.android.sdk.views.IntercomErrorView;
import io.intercom.android.sdk.views.IntercomLinkView;
import io.intercom.android.sdk.views.IntercomToolbar;
import io.intercom.com.bumptech.glide.c;
import io.intercom.com.bumptech.glide.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class ConversationFragment extends Fragment implements Listener, io.intercom.android.sdk.views.IntercomToolbar.Listener, Subscriber2<Integer, TeamPresence>, Host {
    private static final String ARG_CONVERSATION_ID = "conversationId";
    private static final String ARG_GROUP_PARTICIPANTS = "group_participants";
    private static final String ARG_INITIAL_MESSAGE = "initial_message";
    private static final String ARG_IS_READ = "intercomsdk-isRead";
    private static final String ARG_IS_TWO_PANE = "is_two_pane";
    private static final String ARG_LAST_PARTICIPANT = "last_participant";
    private static final int COMPOSER_LIGHTBOX_REQUEST_CODE = 25;
    private static final String EXTRA_GALLERY_IMAGE = "gallery_image";
    private static final String IMAGE_MIME_TYPE = "image";
    private static final int MAX_FILE_SIZE_BYTES = 41943040;
    Provider<AppConfig> appConfigProvider;
    private d bus;
    private boolean canOpenProfile = true;
    private RelativeLayout composerHolder;
    private final io.intercom.android.sdk.conversation.composer.ComposerPresenter.Listener composerListener = new io.intercom.android.sdk.conversation.composer.ComposerPresenter.Listener() {
        private final BlockFactory blockFactory = new BlockFactory(new TextSplittingStrategy());

        private List<Builder> createBlocks(GalleryImage galleryImage) {
            ArrayList arrayList = new ArrayList();
            if (galleryImage.getMimeType().contains(ConversationFragment.IMAGE_MIME_TYPE)) {
                arrayList.add(new Builder().withUrl(galleryImage.getPath()).withType(BlockType.LOCALIMAGE.name()).withWidth(galleryImage.getImageWidth()).withHeight(galleryImage.getImageHeight()));
            } else {
                arrayList.add(new Builder().withAttachments(Collections.singletonList(new BlockAttachment.Builder().withName(galleryImage.getFileName()).withUrl(galleryImage.getPath()).withContentType(galleryImage.getMimeType()).build())).withType(BlockType.LOCAL_ATTACHMENT.name()));
            }
            return arrayList;
        }

        private void showUploadError() {
            new a(ConversationFragment.this.getActivity()).setTitle(R.string.intercom_failed_to_send).setMessage(R.string.intercom_file_too_big).setPositiveButton(17039370, (OnClickListener) new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                }
            }).show();
        }

        public void onRemoteImageSelected(GalleryImage galleryImage) {
            ConversationFragment.this.contentPresenter.sendPart(Collections.singletonList(new Builder().withType(ConversationFragment.IMAGE_MIME_TYPE).withUrl(galleryImage.getPath()).withAttribution(galleryImage.getAttribution()).withHeight(galleryImage.getImageHeight()).withWidth(galleryImage.getImageWidth())));
            ConversationFragment.this.composerPresenter.returnToDefaultInput();
        }

        public void onSendButtonPressed(CharSequence charSequence) {
            String trim = charSequence.toString().trim();
            if (!trim.isEmpty()) {
                ConversationFragment.this.opsMetricTracker.trackEvent(OpsMetricTracker.START, OpsMetricTracker.SEND_PART_TIME_TO_PROCESS_ACTION);
                ConversationFragment.this.contentPresenter.sendPart(this.blockFactory.getBlocksForText(trim));
                if (TextUtils.isEmpty(ConversationFragment.this.conversationId)) {
                    ConversationFragment.this.rootView.findViewById(R.id.disabled_view).setVisibility(0);
                }
            }
        }

        public void onUploadImageSelected(GalleryImage galleryImage) {
            if (galleryImage.getFileSize() > ConversationFragment.MAX_FILE_SIZE_BYTES) {
                showUploadError();
            } else {
                ConversationFragment.this.contentPresenter.uploadImage(createBlocks(galleryImage), galleryImage);
            }
        }
    };
    ComposerPresenter composerPresenter;
    private final ConnectivityEventListener connectivityEventListener = new ConnectivityEventListener() {
        public void onDisconnect() {
            Snackbar.a(ConversationFragment.this.rootView, R.string.intercom_no_network_connection, -2).l();
        }

        public void onReconnect() {
            Snackbar a2 = Snackbar.a(ConversationFragment.this.rootView, R.string.intercom_connected, 0);
            a2.e(((AppConfig) ConversationFragment.this.appConfigProvider.get()).getPrimaryColor());
            a2.a(R.string.intercom_dismiss, (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                }
            });
            a2.l();
        }
    };
    ConversationContentPresenter contentPresenter;
    Conversation conversation;
    String conversationId;
    private int currentOrientation;
    private final OnGlobalLayoutListener globalLayoutListener = new OnGlobalLayoutListener() {
        private int previousHeight;

        public void onGlobalLayout() {
            int height = ConversationFragment.this.rootView.getHeight();
            int i2 = this.previousHeight;
            if (i2 != 0) {
                ConversationFragment conversationFragment = ConversationFragment.this;
                if (!conversationFragment.orientationChanged && i2 > height) {
                    conversationFragment.profilePresenter.closeProfile();
                    ConversationFragment conversationFragment2 = ConversationFragment.this;
                    if (conversationFragment2.shouldStayAtBottom) {
                        conversationFragment2.contentPresenter.scrollToBottom();
                        ConversationFragment.this.shouldStayAtBottom = false;
                    }
                }
            }
            ConversationFragment conversationFragment3 = ConversationFragment.this;
            if (conversationFragment3.orientationChanged && this.previousHeight != height) {
                conversationFragment3.orientationChanged = false;
            }
            this.previousHeight = height;
            ConversationFragment.this.contentPresenter.onGlobalLayout();
        }
    };
    private List<Participant> groupParticipants;
    private boolean hasLoadedConversation = false;
    private String initialMessage = "";
    private IntercomErrorView intercomErrorView;
    private IntercomLinkView intercomLinkView;
    private IntercomToolbar intercomToolbar;
    private boolean isTwoPane = false;
    private CharSequence lastActiveTime;
    private LastParticipatingAdmin lastParticipant;
    private Listener listener;
    private MetricTracker metricTracker;
    final NetworkConnectivityMonitor networkConnectivityMonitor = new NetworkConnectivityMonitor();
    private NexusClient nexusClient;
    /* access modifiers changed from: private */
    public OpsMetricTracker opsMetricTracker;
    boolean orientationChanged = false;
    private final ProfileExpansionLogic profileExpansionLogic = new ProfileExpansionLogic();
    ProfilePresenter profilePresenter;
    private ReactionInputView reactionComposer;
    private n requestManager;
    View rootView;
    boolean shouldStayAtBottom = false;
    Store<State> store;
    private Subscription subscription;
    private UserIdentity userIdentity;

    public interface Listener {
        void onBackClicked();

        void onToolbarCloseClicked();
    }

    private void animateComposerIn() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.intercom_composer_slide_up);
        this.composerHolder.setVisibility(0);
        this.intercomLinkView.startAnimation(loadAnimation);
        this.composerHolder.startAnimation(loadAnimation);
    }

    private void configureInputView(Conversation conversation2) {
        Part lastPart = conversation2.getLastPart();
        if (!ReactionReply.isNull(lastPart.getReactionReply()) || !conversation2.getComposerState().isVisible()) {
            ConversationReactionListener conversationReactionListener = new ConversationReactionListener(ReactionLocation.CONVERSATION, lastPart.getId(), conversation2.getId(), Injector.get().getApi(), this.metricTracker);
            this.reactionComposer.setUpReactions(lastPart.getReactionReply(), true, conversationReactionListener, this.requestManager);
            this.composerPresenter.hideComposer();
            return;
        }
        this.composerPresenter.showComposer();
        this.composerPresenter.requestFocus();
        this.reactionComposer.setVisibility(8);
    }

    private ConversationContentPresenter createContentPresenter(View view) {
        Injector injector = Injector.get();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.conversation_list);
        Blocks blocks = new Blocks(getActivity(), LumberMill.getBlocksTwig());
        Api api = injector.getApi();
        ArrayList arrayList = new ArrayList();
        ContextLocaliser contextLocaliser = new ContextLocaliser(this.appConfigProvider);
        Locale locale = getActivity().getApplication().getResources().getConfiguration().locale;
        ConversationPartAdapter create = ConversationPartAdapter.create(getActivity(), arrayList, this, api, this.conversationId, this.appConfigProvider, this.userIdentity, injector.getTimeProvider(), contextLocaliser, this.requestManager, this.metricTracker, locale);
        SoundPlayer soundPlayer = new SoundPlayer(getActivity(), this.appConfigProvider);
        return ConversationContentPresenter.create(this, recyclerView, create, this.intercomLinkView, this.appConfigProvider, api, arrayList, this.conversationId, soundPlayer, blocks, this.userIdentity, this.opsMetricTracker, this.requestManager, getActivity());
    }

    private void displayErrorView() {
        this.intercomErrorView.setVisibility(0);
        this.composerHolder.setVisibility(8);
        this.contentPresenter.showErrorView();
    }

    private void expandProfileIfNeeded() {
        if (this.canOpenProfile) {
            View view = getView();
            if (view != null) {
                final boolean shouldExpandProfile = this.profileExpansionLogic.shouldExpandProfile(this.conversation);
                view.postDelayed(new Runnable() {
                    public void run() {
                        if (ConversationFragment.this.getContext() != null) {
                            if (shouldExpandProfile) {
                                ConversationFragment.this.profilePresenter.profileAutoOpened();
                                ConversationFragment.this.profilePresenter.startOffsetListener();
                                ConversationFragment.this.contentPresenter.smoothScrollToTop();
                            } else {
                                ConversationFragment.this.profilePresenter.startOffsetListener();
                            }
                        }
                    }
                }, 50);
                if (shouldExpandProfile) {
                    this.contentPresenter.scrollToTop();
                } else {
                    this.contentPresenter.scrollToBottom();
                }
                this.canOpenProfile = false;
            }
        }
    }

    private void markConversationAsRead() {
        Injector.get().getApi().markConversationAsRead(this.conversationId);
        this.store.dispatch(Actions.conversationMarkedAsRead(this.conversationId));
        this.nexusClient.fire(NexusEvent.getConversationSeenEvent(this.conversationId, this.userIdentity.getIntercomId()));
    }

    public static ConversationFragment newInstance(String str, LastParticipatingAdmin lastParticipatingAdmin, boolean z, boolean z2, String str2, List<Participant> list) {
        ConversationFragment conversationFragment = new ConversationFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_CONVERSATION_ID, str);
        bundle.putString(ARG_INITIAL_MESSAGE, str2);
        bundle.putParcelable(ARG_LAST_PARTICIPANT, lastParticipatingAdmin);
        bundle.putParcelableArrayList(ARG_GROUP_PARTICIPANTS, new ArrayList(list));
        bundle.putBoolean(ARG_IS_READ, z);
        bundle.putBoolean(ARG_IS_TWO_PANE, z2);
        bundle.setClassLoader(Part.class.getClassLoader());
        conversationFragment.setArguments(bundle);
        return conversationFragment;
    }

    private void toggleProfile() {
        if (this.profilePresenter.isExpanded()) {
            this.profilePresenter.closeProfile();
            return;
        }
        this.profilePresenter.profileClicked();
        this.contentPresenter.smoothScrollToTop();
    }

    private void trackLastPart(Part part) {
        if (part.isLinkList()) {
            this.metricTracker.receivedOperatorReply(this.conversationId);
        } else {
            this.metricTracker.receivedReply(part.hasAttachments(), part.isLinkCard(), part.getId(), this.conversationId);
        }
    }

    private void updateLastActiveTime() {
        if (this.conversation.getLastParticipatingAdmin() != null && getActivity() != null) {
            this.lastActiveTime = new TimeFormatter(getActivity(), Injector.get().getTimeProvider()).getAdminActiveStatus(this.lastParticipant, this.appConfigProvider);
        }
    }

    private void updateProfileToolbar(TeamPresence teamPresence) {
        C0195j activity = getActivity();
        if (activity != null) {
            if (LastParticipatingAdmin.isNull(this.lastParticipant) || this.lastParticipant == LastParticipatingAdmin.NONE) {
                this.profilePresenter.setTeamPresence(teamPresence, activity.getWindow().getDecorView().getMeasuredWidth(), this.requestManager);
            } else {
                updateLastActiveTime();
                this.profilePresenter.setTeammatePresence(this.lastParticipant, this.groupParticipants, this.lastActiveTime, this.rootView.getWidth());
            }
        }
    }

    @k
    public void adminIsTyping(AdminIsTypingEvent adminIsTypingEvent) {
        if (this.conversationId.equals(adminIsTypingEvent.getConversationId())) {
            this.contentPresenter.onAdminStartedTyping(adminIsTypingEvent);
        }
    }

    @k
    public void conversationFailure(ConversationFailedEvent conversationFailedEvent) {
        if (isAdded()) {
            displayErrorView();
        }
    }

    @k
    public void conversationSuccess(ConversationEvent conversationEvent) {
        int size = this.conversation.getParts().size();
        boolean z = false;
        boolean z2 = size == 0;
        List parts = conversationEvent.getResponse().getParts();
        if (parts.size() > size) {
            z = true;
        }
        if (conversationEvent.getResponse().getId().equals(this.conversationId)) {
            this.conversation = conversationEvent.getResponse();
            if (isAdded()) {
                this.contentPresenter.onConversationFetched(conversationEvent, z2);
                displayConversation();
            }
            boolean z3 = !this.conversation.isRead();
            if (z3) {
                markConversationAsRead();
            }
            if (z2) {
                animateComposerIn();
                Part part = (Part) parts.get(parts.size() - 1);
                if (part.isReply() && z3) {
                    trackLastPart(part);
                }
                expandProfileIfNeeded();
            } else if (z) {
                List subList = parts.subList(size, parts.size());
                this.contentPresenter.playSoundForNewAdminPart(subList);
                this.contentPresenter.onNewPartReceived();
                trackLastPart((Part) subList.get(subList.size() - 1));
            }
        }
        this.lastParticipant = this.conversation.getLastParticipatingAdmin();
        this.groupParticipants = this.conversation.getGroupConversationParticipants();
        if (this.lastParticipant != null) {
            updateLastActiveTime();
        }
        updateProfileToolbar((TeamPresence) this.store.select(Selectors.TEAM_PRESENCE));
        this.hasLoadedConversation = true;
    }

    /* access modifiers changed from: 0000 */
    public void displayConversation() {
        if (isAdded()) {
            this.intercomErrorView.setVisibility(8);
            this.contentPresenter.showContentView();
            configureInputView(this.conversation);
        }
    }

    /* access modifiers changed from: 0000 */
    public void displayLoadingView() {
        if (isAdded()) {
            this.intercomErrorView.setVisibility(8);
            this.composerPresenter.hideComposer();
            this.contentPresenter.showLoadingView();
        }
    }

    public Conversation getConversation() {
        return this.conversation;
    }

    public String getConversationId() {
        return this.conversationId;
    }

    public void handleOnBackPressed() {
        this.composerPresenter.onBackPressed();
    }

    /* access modifiers changed from: 0000 */
    public boolean hasNotLoadedLastAdminForExistingConversation() {
        return !this.hasLoadedConversation && !this.conversationId.isEmpty() && LastParticipatingAdmin.isNull(this.lastParticipant);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 25 && intent != null) {
            String str = "gallery_image";
            if (intent.hasExtra(str)) {
                this.composerListener.onUploadImageSelected((GalleryImage) intent.getParcelableExtra(str));
            }
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.listener = (Listener) context;
        } catch (ClassCastException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append(context);
            sb.append(" must implement ConversationFragment.Listener");
            throw new ClassCastException(sb.toString());
        }
    }

    public void onCloseClicked() {
        this.listener.onToolbarCloseClicked();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation != this.currentOrientation) {
            this.orientationChanged = true;
            this.composerPresenter.updateMaxLines();
        }
        this.currentOrientation = configuration.orientation;
    }

    public void onConversationCreated(Conversation conversation2) {
        this.rootView.findViewById(R.id.disabled_view).setVisibility(8);
        this.conversation = conversation2;
        this.conversationId = conversation2.getId();
        this.profilePresenter.setConversationId(this.conversationId);
        this.composerPresenter.setConversationId(this.conversationId);
        this.composerPresenter.setHint(R.string.intercom_reply_to_conversation);
        this.nexusClient.fire(NexusEvent.getNewCommentEvent(this.conversationId, this.userIdentity.getIntercomId()));
        Part part = (Part) conversation2.getParts().get(0);
        this.metricTracker.sentInNewConversation(part.hasAttachments(), part.isGifOnlyPart(), part.getId(), this.conversationId, ((TeamPresence) this.store.select(Selectors.TEAM_PRESENCE)).getOfficeHours().isEmpty());
        this.metricTracker.startConversation(this.conversationId);
        this.hasLoadedConversation = true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.requestManager = c.a((Fragment) this);
        Injector injector = Injector.get();
        this.bus = injector.getBus();
        this.nexusClient = injector.getNexusClient();
        this.appConfigProvider = injector.getAppConfigProvider();
        this.userIdentity = injector.getUserIdentity();
        this.store = injector.getStore();
        this.metricTracker = injector.getMetricTracker();
        this.opsMetricTracker = injector.getOpsMetricTracker();
        this.opsMetricTracker.trackEvent(OpsMetricTracker.START, OpsMetricTracker.LOAD_CONVERSATION_TIME_TO_PROCESS_ACTION);
        Bundle arguments = getArguments();
        if (arguments != null) {
            arguments.setClassLoader(Part.class.getClassLoader());
            String str = "";
            this.conversationId = arguments.getString(ARG_CONVERSATION_ID, str);
            this.initialMessage = arguments.getString(ARG_INITIAL_MESSAGE, str);
            this.lastParticipant = (LastParticipatingAdmin) arguments.getParcelable(ARG_LAST_PARTICIPANT);
            if (this.lastParticipant == null) {
                this.lastParticipant = LastParticipatingAdmin.NULL;
            }
            this.groupParticipants = arguments.getParcelableArrayList(ARG_GROUP_PARTICIPANTS);
            if (this.groupParticipants == null) {
                this.groupParticipants = new ArrayList();
            }
            if (!arguments.getBoolean(ARG_IS_READ, false)) {
                this.store.dispatch(Actions.conversationMarkedAsRead(this.conversationId));
            }
            this.isTwoPane = arguments.getBoolean(ARG_IS_TWO_PANE, false);
            if (TextUtils.isEmpty(this.conversationId)) {
                this.store.dispatch(Actions.composerOpened());
            } else {
                this.store.dispatch(Actions.conversationOpened(this.conversationId));
            }
        }
        this.conversation = new Conversation();
        this.currentOrientation = getResources().getConfiguration().orientation;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.rootView;
        int i2 = 0;
        if (view == null) {
            this.rootView = layoutInflater.inflate(R.layout.intercom_fragment_conversation, viewGroup, false);
        } else {
            ViewGroup viewGroup2 = (ViewGroup) view.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.rootView);
            }
        }
        this.intercomLinkView = (IntercomLinkView) this.rootView.findViewById(R.id.intercom_link);
        this.composerHolder = (RelativeLayout) this.rootView.findViewById(R.id.composer_holder);
        this.profilePresenter = new ProfilePresenter((CoordinatorLayout) this.rootView.findViewById(R.id.conversation_coordinator_layout), this.metricTracker, this.appConfigProvider, this.requestManager);
        this.profilePresenter.setConversationId(this.conversationId);
        this.intercomErrorView = (IntercomErrorView) this.rootView.findViewById(R.id.error_layout_conversation);
        this.intercomErrorView.setActionButtonTextColor(((AppConfig) this.appConfigProvider.get()).getPrimaryColor());
        this.intercomErrorView.setActionButtonClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ConversationFragment.this.displayLoadingView();
                ConversationFragment conversationFragment = ConversationFragment.this;
                conversationFragment.contentPresenter.fetchConversation(conversationFragment.conversationId);
            }
        });
        this.profilePresenter.addListener(new AppBarLayout.c() {
            public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
                ConversationFragment.this.contentPresenter.onProfileScrolled();
            }
        });
        this.reactionComposer = (ReactionInputView) this.rootView.findViewById(R.id.reaction_input_view);
        this.intercomToolbar = (IntercomToolbar) this.rootView.findViewById(R.id.intercom_toolbar);
        this.intercomToolbar.updateToolbarColors((AppConfig) this.appConfigProvider.get());
        this.intercomToolbar.updateToolbarSize();
        this.intercomToolbar.setListener(this);
        IntercomToolbar intercomToolbar2 = this.intercomToolbar;
        if (this.isTwoPane) {
            i2 = 8;
        }
        intercomToolbar2.setLeftNavigationItemVisibility(i2);
        this.intercomToolbar.animateBackButton();
        this.rootView.getViewTreeObserver().addOnGlobalLayoutListener(this.globalLayoutListener);
        return this.rootView;
    }

    public void onDestroy() {
        this.store.dispatch(Actions.conversationClosed());
        super.onDestroy();
    }

    public void onDestroyView() {
        ViewUtils.removeGlobalLayoutListener(this.rootView, this.globalLayoutListener);
        this.composerPresenter.cleanup();
        this.contentPresenter.cleanup();
        this.profilePresenter.cleanup();
        super.onDestroyView();
    }

    public void onInboxClicked() {
        this.composerPresenter.cleanup();
        this.listener.onBackClicked();
    }

    public void onPartClicked(Part part) {
        this.contentPresenter.onPartClicked(part);
    }

    public void onPostCardClicked(Part part) {
        startActivity(IntercomPostActivity.buildPostIntent(getContext(), part, "", this.lastParticipant, false));
    }

    public void onStart() {
        super.onStart();
        this.networkConnectivityMonitor.startListening(getActivity());
        this.networkConnectivityMonitor.setListener(this.connectivityEventListener);
        this.subscription = this.store.subscribeToChanges(Selectors.UNREAD_COUNT, Selectors.TEAM_PRESENCE, this);
        this.bus.register(this);
        this.bus.register(this.contentPresenter);
        this.contentPresenter.fetchConversation(this.conversationId);
    }

    public void onStop() {
        StoreUtils.safeUnsubscribe(this.subscription);
        this.bus.unregister(this);
        this.bus.unregister(this.contentPresenter);
        this.networkConnectivityMonitor.setListener(null);
        this.networkConnectivityMonitor.stopListening(getActivity());
        this.opsMetricTracker.clear();
        this.profilePresenter.onStop();
        super.onStop();
    }

    public void onToolbarClicked() {
        toggleProfile();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.contentPresenter = createContentPresenter(view);
        FrameLayout frameLayout = (FrameLayout) this.rootView.findViewById(R.id.composer_container);
        frameLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ConversationFragment.this.contentPresenter.isAtBottom()) {
                    ConversationFragment.this.shouldStayAtBottom = true;
                }
            }
        });
        ComposerPresenter composerPresenter2 = new ComposerPresenter(this.composerListener, frameLayout, getChildFragmentManager(), LayoutInflater.from(view.getContext()), this.nexusClient, this.userIdentity, this.appConfigProvider, this.metricTracker, this.conversationId, this.initialMessage, this.store, getActivity(), ((AppConfig) this.appConfigProvider.get()).getPrimaryColor());
        this.composerPresenter = composerPresenter2;
        this.contentPresenter.setup();
        this.composerPresenter.requestFocus();
        configureInputView(this.conversation);
        if (this.conversationId.isEmpty()) {
            animateComposerIn();
            displayConversation();
        } else {
            this.composerPresenter.setConversationId(this.conversationId);
            displayLoadingView();
        }
        if (this.conversationId.isEmpty()) {
            this.canOpenProfile = false;
            view.postDelayed(new Runnable() {
                public void run() {
                    if (ConversationFragment.this.getActivity() != null) {
                        ConversationFragment.this.profilePresenter.profileAutoOpened();
                        ConversationFragment.this.profilePresenter.startOffsetListener();
                        ConversationFragment.this.contentPresenter.smoothScrollToTop();
                    }
                }
            }, 50);
        }
    }

    @k
    public void replySuccess(ReplyEvent replyEvent) {
        if (replyEvent.getConversationId().equals(this.conversationId)) {
            this.nexusClient.fire(NexusEvent.getNewCommentEvent(this.conversationId, this.userIdentity.getIntercomId()));
            Part response = replyEvent.getResponse();
            Participant participant = this.conversation.getParticipant(response.getParticipantId());
            if (participant == Participant.NULL) {
                participant = new Participant.Builder().withId(response.getParticipantId()).build();
                this.conversation.getParticipants().put(response.getParticipantId(), participant);
            }
            response.setParticipant(participant);
            this.contentPresenter.onReplyDelivered(replyEvent);
            this.metricTracker.sentInConversation(response.hasAttachments(), response.isGifOnlyPart(), response.getId(), this.conversationId, ((TeamPresence) this.store.select(Selectors.TEAM_PRESENCE)).getOfficeHours().isEmpty(), this.lastParticipant.isActive(), new TimeFormatter(getActivity(), Injector.get().getTimeProvider()).getLastActiveMinutes(this.lastParticipant.getLastActiveAt()));
        }
    }

    public void sdkWindowFinishedAnimating() {
        if (getView() != null && this.profileExpansionLogic.shouldExpandProfile(this.conversation)) {
            this.profilePresenter.profileAutoOpened();
            this.contentPresenter.smoothScrollToTop();
        }
    }

    public boolean shouldHandleOnBackPressed() {
        ComposerPresenter composerPresenter2 = this.composerPresenter;
        return composerPresenter2 != null && composerPresenter2.isOpen();
    }

    public void onStateChange(Integer num, TeamPresence teamPresence) {
        this.intercomToolbar.setUnreadCount(num);
        if (hasNotLoadedLastAdminForExistingConversation()) {
            this.profilePresenter.setUnknownPresence();
        } else {
            updateProfileToolbar(teamPresence);
        }
    }
}
