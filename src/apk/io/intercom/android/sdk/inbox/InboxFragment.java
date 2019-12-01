package io.intercom.android.sdk.inbox;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import androidx.fragment.app.C0195j;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.C0233t;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import b.g.a.a;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.actions.Actions;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.imageloader.WallpaperLoader;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.state.InboxState;
import io.intercom.android.sdk.state.InboxState.Status;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Selectors;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.store.Store.Subscriber;
import io.intercom.android.sdk.store.Store.Subscription;
import io.intercom.android.sdk.twig.Twig;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.android.sdk.utilities.Phrase;
import io.intercom.android.sdk.utilities.StoreUtils;
import io.intercom.android.sdk.utilities.TimeFormatter;
import io.intercom.android.sdk.utilities.ViewUtils;
import io.intercom.android.sdk.utilities.WindowUtils;
import io.intercom.android.sdk.views.EndlessRecyclerScrollListener;
import io.intercom.android.sdk.views.EndlessScrollListener;
import io.intercom.android.sdk.views.IntercomErrorView;
import io.intercom.android.sdk.views.IntercomToolbar;
import io.intercom.com.bumptech.glide.c;
import io.intercom.com.bumptech.glide.n;
import java.util.List;

public class InboxFragment extends Fragment implements OnClickListener, ConversationClickListener, EndlessScrollListener, io.intercom.android.sdk.views.IntercomToolbar.Listener, Subscriber<InboxState> {
    private static final String ARG_IS_TWO_PANE = "is_two_pane";
    private static final int FADE_DURATION_MS = 150;
    private InboxAdapter adapter;
    private Provider<AppConfig> appConfigProvider;
    private FloatingActionButton composerButton;
    private EndlessRecyclerScrollListener endlessRecyclerScrollListener;
    private IntercomErrorView inboxErrorView;
    RecyclerView inboxView;
    private IntercomToolbar intercomToolbar;
    private boolean isTwoPane = false;
    private LinearLayoutManager layoutManager;
    Listener listener = Listener.EMPTY;
    private ProgressBar progressBar;
    private n requestManager;
    private View rootView;
    /* access modifiers changed from: private */
    public Store<State> store;
    private Subscription subscription;
    private final Twig twig = LumberMill.getLogger();
    private WallpaperLoader wallpaperLoader;

    /* renamed from: io.intercom.android.sdk.inbox.InboxFragment$5 reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$state$InboxState$Status = new int[Status.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            $SwitchMap$io$intercom$android$sdk$state$InboxState$Status[Status.INITIAL.ordinal()] = 1;
            $SwitchMap$io$intercom$android$sdk$state$InboxState$Status[Status.LOADING.ordinal()] = 2;
            $SwitchMap$io$intercom$android$sdk$state$InboxState$Status[Status.SUCCESS.ordinal()] = 3;
            try {
                $SwitchMap$io$intercom$android$sdk$state$InboxState$Status[Status.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public interface Listener {
        public static final Listener EMPTY = new Listener() {
            public void onBackClicked() {
            }

            public void onComposerSelected() {
            }

            public void onConversationSelected(Conversation conversation) {
            }

            public void onConversationsLoaded(List<Conversation> list, Status status) {
            }

            public void onToolbarCloseClicked() {
            }
        };

        void onBackClicked();

        void onComposerSelected();

        void onConversationSelected(Conversation conversation);

        void onConversationsLoaded(List<Conversation> list, Status status);

        void onToolbarCloseClicked();
    }

    private void animateHeaderIn() {
        this.intercomToolbar.findViewById(R.id.intercom_toolbar_title).startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.intercom_profile_slide_in));
    }

    private void displayEmptyView() {
        this.inboxErrorView.setTitle(R.string.intercom_no_conversations);
        this.inboxErrorView.setSubtitle(Phrase.from(getContext(), R.string.intercom_empty_conversations).put("name", (CharSequence) ((AppConfig) this.appConfigProvider.get()).getName()).format());
        this.inboxErrorView.setActionButtonVisibility(8);
        this.inboxErrorView.setVisibility(0);
        showComposerButtonIfEnabled();
        this.inboxView.setVisibility(8);
        this.progressBar.setVisibility(8);
    }

    private void displayErrorView() {
        this.inboxErrorView.setTitle(R.string.intercom_inbox_error_state_title);
        this.inboxErrorView.setSubtitle(R.string.intercom_failed_to_load_conversation);
        this.inboxErrorView.setActionButtonText(R.string.intercom_retry);
        this.inboxErrorView.setActionButtonVisibility(0);
        this.inboxErrorView.setVisibility(0);
        this.inboxView.setVisibility(8);
        this.progressBar.setVisibility(8);
        this.composerButton.b();
    }

    private void displayInbox() {
        this.inboxView.setVisibility(0);
        showComposerButtonIfEnabled();
        this.inboxErrorView.setVisibility(8);
        this.progressBar.setVisibility(8);
    }

    private void displayLoadingView() {
        this.inboxErrorView.setVisibility(8);
        this.inboxView.setVisibility(8);
        this.composerButton.b();
        this.progressBar.setVisibility(0);
    }

    private void fadeOutInbox(AnimatorListener animatorListener) {
        this.intercomToolbar.fadeOutTitle(FADE_DURATION_MS);
        this.inboxView.animate().alpha(0.0f).setDuration(150).setListener(animatorListener).start();
    }

    private boolean isInboundMessageEnabled() {
        return ((AppConfig) this.appConfigProvider.get()).isInboundMessages();
    }

    public static InboxFragment newInstance(boolean z) {
        InboxFragment inboxFragment = new InboxFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean(ARG_IS_TWO_PANE, z);
        inboxFragment.setArguments(bundle);
        return inboxFragment;
    }

    private void setColorScheme() {
        AppConfig appConfig = (AppConfig) this.appConfigProvider.get();
        int primaryColor = appConfig.getPrimaryColor();
        int secondaryColor = appConfig.getSecondaryColor();
        this.composerButton.setBackgroundTintList(ColorStateList.valueOf(primaryColor));
        ColorUtils.setImageSrcColorWhiteOrDark(this.composerButton, appConfig.primaryColorRenderDarkText());
        this.intercomToolbar.setBackgroundColor(secondaryColor);
    }

    private void setToolbarTitle() {
        this.intercomToolbar.setTitle(getString(R.string.intercom_conversations));
        animateHeaderIn();
    }

    private void setUpRecyclerView() {
        this.inboxView = (RecyclerView) this.rootView.findViewById(R.id.inbox_recycler_view);
        this.inboxView.setLayoutManager(this.layoutManager);
        this.inboxView.a((RecyclerView.n) this.endlessRecyclerScrollListener);
        this.inboxView.setAdapter(this.adapter);
        C0233t tVar = new C0233t(getContext(), 1);
        tVar.a(a.c(getContext(), R.drawable.intercom_list_divider));
        this.inboxView.a((h) tVar);
    }

    private void setUpToolbar() {
        this.intercomToolbar = (IntercomToolbar) this.rootView.findViewById(R.id.intercom_toolbar);
        this.intercomToolbar.updateToolbarSize();
        this.intercomToolbar.updateToolbarColors((AppConfig) this.appConfigProvider.get());
        this.intercomToolbar.setListener(this);
        this.intercomToolbar.setSubtitleVisibility(8);
        this.intercomToolbar.setLeftNavigationItemVisibility(0);
        setToolbarTitle();
        View findViewById = this.rootView.findViewById(R.id.intercom_inbox_content);
        findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop() + WindowUtils.getStatusBarHeight(getResources()), findViewById.getPaddingRight(), findViewById.getPaddingBottom());
        this.wallpaperLoader = WallpaperLoader.create(getContext(), this.appConfigProvider, this.requestManager);
        this.intercomToolbar.loadWallpaper(this.wallpaperLoader);
        if (this.isTwoPane) {
            this.intercomToolbar.setCloseButtonVisibility(8);
        }
    }

    private void showComposerButtonIfEnabled() {
        if (isInboundMessageEnabled()) {
            this.composerButton.d();
        } else {
            this.composerButton.b();
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.listener = (Listener) context;
        } catch (ClassCastException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append(context);
            sb.append(" must implement InboxFragment.Listener");
            throw new ClassCastException(sb.toString());
        }
    }

    public void onClick(View view) {
        if (view.getId() != R.id.compose_action_button) {
            return;
        }
        if (this.isTwoPane) {
            this.listener.onComposerSelected();
        } else {
            fadeOutInbox(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    InboxFragment.this.listener.onComposerSelected();
                }
            });
        }
    }

    public void onCloseClicked() {
        this.listener.onToolbarCloseClicked();
    }

    public void onConversationClicked(int i2) {
        final Conversation conversation = (Conversation) ((State) this.store.state()).inboxState().conversations().get(i2);
        if (this.isTwoPane) {
            this.listener.onConversationSelected(conversation);
        } else {
            fadeOutInbox(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    InboxFragment.this.listener.onConversationSelected(conversation);
                }
            });
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Injector injector = Injector.get();
        this.requestManager = c.a((Fragment) this);
        this.store = injector.getStore();
        this.appConfigProvider = injector.getAppConfigProvider();
        C0195j activity = getActivity();
        InboxAdapter inboxAdapter = new InboxAdapter(LayoutInflater.from(activity), this, this.store, new TimeFormatter(activity, injector.getTimeProvider()), this.appConfigProvider, injector.getUserIdentity(), this.requestManager);
        this.adapter = inboxAdapter;
        this.layoutManager = new LinearLayoutManager(activity);
        this.endlessRecyclerScrollListener = new EndlessRecyclerScrollListener(this.layoutManager, this);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.isTwoPane = arguments.getBoolean(ARG_IS_TWO_PANE, false);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.twig.internal("inbox frag", "creating view for fragment");
        View view = this.rootView;
        if (view == null) {
            this.rootView = layoutInflater.inflate(R.layout.intercom_fragment_inbox, viewGroup, false);
            this.progressBar = (ProgressBar) this.rootView.findViewById(R.id.progress_bar);
            setUpRecyclerView();
            this.composerButton = (FloatingActionButton) this.rootView.findViewById(R.id.compose_action_button);
            this.composerButton.setOnClickListener(this);
            this.inboxErrorView = (IntercomErrorView) this.rootView.findViewById(R.id.error_layout_inbox);
            this.inboxErrorView.setActionButtonTextColor(((AppConfig) this.appConfigProvider.get()).getPrimaryColor());
            this.inboxErrorView.setActionButtonClickListener(new OnClickListener() {
                public void onClick(View view) {
                    InboxFragment.this.store.dispatch(Actions.fetchInboxRequest());
                }
            });
            setUpToolbar();
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
                public void run() {
                    InboxFragment.this.store.dispatch(Actions.fetchInboxRequest());
                }
            });
        } else {
            ViewGroup viewGroup2 = (ViewGroup) view.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.rootView);
            }
            setToolbarTitle();
            this.inboxView.setAdapter(this.adapter);
            this.inboxView.scheduleLayoutAnimation();
        }
        return this.rootView;
    }

    public void onDestroyView() {
        this.intercomToolbar.closeWallpaperLoader(this.wallpaperLoader);
        super.onDestroyView();
    }

    public void onDetach() {
        super.onDetach();
        this.listener = Listener.EMPTY;
    }

    public void onInboxClicked() {
        this.listener.onBackClicked();
    }

    public void onLoadMore() {
        InboxState inboxState = ((State) this.store.state()).inboxState();
        List conversations = inboxState.conversations();
        boolean z = conversations.size() <= 3;
        if (inboxState.status() != Status.LOADING && !z) {
            this.store.dispatch(Actions.fetchInboxBeforeDateRequest(((Conversation) conversations.get(conversations.size() - 1)).getLastPart().getCreatedAt()));
        }
    }

    public void onResume() {
        this.store.dispatch(Actions.inboxOpened());
        if (!this.isTwoPane) {
            this.inboxView.setAlpha(1.0f);
        }
        setColorScheme();
        super.onResume();
    }

    public void onStart() {
        super.onStart();
        this.subscription = this.store.subscribeToChanges(Selectors.INBOX, this);
    }

    public void onStop() {
        StoreUtils.safeUnsubscribe(this.subscription);
        super.onStop();
    }

    public void onToolbarClicked() {
    }

    public void setOverScrollColour() {
        ViewUtils.setOverScrollColour(this.inboxView, ((AppConfig) this.appConfigProvider.get()).getPrimaryColor());
    }

    public void onStateChange(InboxState inboxState) {
        this.adapter.setInboxState(inboxState);
        this.adapter.notifyDataSetChanged();
        this.endlessRecyclerScrollListener.setMorePagesAvailable(inboxState.hasMorePages());
        if (isAdded() && getView() != null) {
            int i2 = AnonymousClass5.$SwitchMap$io$intercom$android$sdk$state$InboxState$Status[inboxState.status().ordinal()];
            if (i2 == 1) {
                displayLoadingView();
            } else if (i2 != 2) {
                if (i2 != 3) {
                    displayErrorView();
                    return;
                }
                if (this.layoutManager.F() == 0) {
                    this.layoutManager.k(0);
                }
                if (inboxState.conversations().isEmpty()) {
                    displayEmptyView();
                } else {
                    displayInbox();
                }
                this.listener.onConversationsLoaded(inboxState.conversations(), inboxState.status());
            } else if (inboxState.conversations().isEmpty()) {
                displayLoadingView();
            } else {
                displayInbox();
            }
        }
    }
}
