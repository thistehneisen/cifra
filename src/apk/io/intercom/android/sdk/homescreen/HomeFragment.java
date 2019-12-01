package io.intercom.android.sdk.homescreen;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnScrollChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import e.a.a.a.a.d;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.actions.Actions;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.api.BaseCallback;
import io.intercom.android.sdk.api.ErrorObject;
import io.intercom.android.sdk.commons.utilities.TimeProvider;
import io.intercom.android.sdk.conversation.IntercomLinkPresenter;
import io.intercom.android.sdk.conversation.IntercomLinkPresenter.IntercomLinkHost;
import io.intercom.android.sdk.homescreen.HomePresenter.Listener;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.imageloader.WallpaperLoader;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.HomeCardsResponse;
import io.intercom.android.sdk.models.HomeCardsResponse.Builder;
import io.intercom.android.sdk.models.TeamPresence;
import io.intercom.android.sdk.state.InboxState;
import io.intercom.android.sdk.state.InboxState.Status;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Selectors;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.store.Store.Subscriber2;
import io.intercom.android.sdk.store.Store.Subscription;
import io.intercom.android.sdk.utilities.BackgroundUtils;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.android.sdk.utilities.FontUtils;
import io.intercom.android.sdk.utilities.StoreUtils;
import io.intercom.android.sdk.utilities.TimeFormatter;
import io.intercom.android.sdk.utilities.WindowUtils;
import io.intercom.android.sdk.views.HomeToolbar;
import io.intercom.android.sdk.views.IntercomErrorView;
import io.intercom.android.sdk.views.IntercomLinkView;
import io.intercom.android.sdk.views.decoration.HomeItemDecoration;
import io.intercom.com.bumptech.glide.c;
import io.intercom.com.bumptech.glide.n;
import io.intercom.com.google.gson.o;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements IntercomLinkHost, Listener, Subscriber2<InboxState, TeamPresence> {
    private static final int OFFSCREEN_ITEM_CACHE = 4;
    private Api api;
    private final BaseCallback<Builder> apiCallback = new BaseCallback<Builder>() {
        /* access modifiers changed from: protected */
        public void onError(ErrorObject errorObject) {
            if (((AppConfig) HomeFragment.this.appConfigProvider.get()).isReceivedFromServer()) {
                HomeFragment.this.homePresenter.clearCards();
                HomeFragment.this.homePresenter.updateConversationCard(((State) HomeFragment.this.store.state()).hasConversations());
                HomeFragment.this.homePresenter.addErrorRow();
            } else {
                HomeFragment.this.homePresenter.clearCards();
                HomeFragment.this.intercomErrorView.setVisibility(0);
            }
            HomeFragment.this.toolbar.updateContent((AppConfig) HomeFragment.this.appConfigProvider.get(), HomeFragment.this.requestManager);
        }

        /* access modifiers changed from: protected */
        public void onSuccess(Builder builder) {
            AppConfig appConfig = (AppConfig) HomeFragment.this.appConfigProvider.get();
            HomeCardsResponse build = builder.build();
            HomeFragment.this.store.dispatch(Actions.fetchHomeCardsSuccess(build));
            if (build.hasConversations() || appConfig.isInboundMessages() || build.getCards().size() != 0) {
                HomeFragment.this.homePresenter.updateConversationCard(build.hasMoreConversations());
                HomeFragment.this.homePresenter.updateCards(build.getCards());
                HomeFragment.this.toolbar.updateContent(appConfig, HomeFragment.this.requestManager);
                return;
            }
            HomeFragment.this.intercomEmptyView.setVisibility(0);
        }
    };
    /* access modifiers changed from: private */
    public Provider<AppConfig> appConfigProvider;
    private d bus;
    private List<Object> cardList = new ArrayList();
    private ViewGroup close;
    /* access modifiers changed from: private */
    public View closeBackground;
    private o gson;
    private HomeCardAdapter homeCardAdapter;
    /* access modifiers changed from: private */
    public HomePresenter homePresenter;
    /* access modifiers changed from: private */
    public IntercomErrorView intercomEmptyView;
    /* access modifiers changed from: private */
    public IntercomErrorView intercomErrorView;
    private View linkContainer;
    private IntercomLinkView linkView;
    /* access modifiers changed from: private */
    public HomeClickListener listener;
    private MetricTracker metricTracker;
    /* access modifiers changed from: private */
    public RecyclerView recyclerView;
    /* access modifiers changed from: private */
    public n requestManager;
    private View rootView;
    /* access modifiers changed from: private */
    public int startLocationY;
    private int statusHeight;
    /* access modifiers changed from: private */
    public Store<State> store;
    private Subscription subscription;
    private TimeProvider timeProvider;
    /* access modifiers changed from: private */
    public HomeToolbar toolbar;
    /* access modifiers changed from: private */
    public View toolbarContent;
    private UserIdentity userIdentity;
    private WallpaperLoader wallpaperLoader;

    private void animateHeaderIn() {
        this.toolbar.animateIn(this.toolbarContent);
    }

    private void applyCloseButtonStyle(TextView textView, AppConfig appConfig) {
        Context context = textView.getContext();
        int primaryOrDarkColor = ColorUtils.primaryOrDarkColor(context, appConfig);
        FontUtils.setRobotoMediumTypeface(textView);
        BackgroundUtils.setRippleButtonStroke(context, textView.getBackground(), R.id.background, primaryOrDarkColor);
        textView.setTextColor(primaryOrDarkColor);
    }

    /* access modifiers changed from: private */
    public void loadHomeScreen() {
        this.homePresenter.clearCards();
        this.homePresenter.addLoadingCards();
        this.api.fetchHomeCards(this.apiCallback);
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    private void setUpCardList(Provider<AppConfig> provider, Store<State> store2, TimeProvider timeProvider2, d dVar, o oVar, MetricTracker metricTracker2, UserIdentity userIdentity2) {
        Provider<AppConfig> provider2 = provider;
        Store<State> store3 = store2;
        this.homePresenter = new HomePresenter(store3, provider2, this.cardList, this);
        d dVar2 = dVar;
        o oVar2 = oVar;
        MetricTracker metricTracker3 = metricTracker2;
        HomeCardAdapter homeCardAdapter2 = new HomeCardAdapter(this.cardList, store3, provider2, dVar2, oVar2, metricTracker3, new TimeFormatter(getContext(), timeProvider2), this.requestManager, this.listener, userIdentity2, getActivity());
        this.homeCardAdapter = homeCardAdapter2;
        this.recyclerView.setAdapter(this.homeCardAdapter);
        this.recyclerView.a((h) new HomeItemDecoration(getContext(), this.cardList));
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.recyclerView.setItemViewCacheSize(4);
        this.recyclerView.setItemAnimator(null);
        loadHomeScreen();
    }

    private void setUpCloseButton(AppConfig appConfig) {
        ColorUtils.setImageColorWhiteOrBlack((ImageView) this.close.findViewById(R.id.intercom_toolbar_close), appConfig.secondaryColorRenderDarkText());
        this.close.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                HomeFragment.this.listener.onCloseClicked();
            }
        });
        ViewGroup viewGroup = this.close;
        viewGroup.setPadding(viewGroup.getPaddingLeft(), this.close.getPaddingTop() + this.statusHeight, this.close.getPaddingRight(), this.close.getPaddingBottom());
        LayoutParams layoutParams = this.close.getLayoutParams();
        layoutParams.height += this.statusHeight;
        this.close.setLayoutParams(layoutParams);
    }

    private void setUpEmptyScreen() {
        TextView textView = (TextView) this.intercomEmptyView.findViewById(R.id.close_button);
        textView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                HomeFragment.this.intercomEmptyView.setVisibility(8);
                HomeFragment.this.listener.onCloseClicked();
            }
        });
        applyCloseButtonStyle(textView, (AppConfig) this.appConfigProvider.get());
    }

    private void setUpErrorScreen() {
        IntercomErrorView intercomErrorView2 = this.intercomErrorView;
        intercomErrorView2.setActionButtonTextColor(ColorUtils.primaryOrDarkColor(intercomErrorView2.getContext(), (AppConfig) this.appConfigProvider.get()));
        this.intercomErrorView.setActionButtonClickListener(new OnClickListener() {
            public void onClick(View view) {
                HomeFragment.this.intercomErrorView.setVisibility(8);
                HomeFragment.this.loadHomeScreen();
            }
        });
    }

    private void setUpLinkView(Provider<AppConfig> provider, Api api2, View view, String str, String str2) {
        this.linkView = (IntercomLinkView) view.findViewById(R.id.intercom_link);
        this.linkContainer = view.findViewById(R.id.intercom_home_link_container);
        IntercomLinkPresenter intercomLinkPresenter = new IntercomLinkPresenter(this.linkView, provider, api2, "", str, str2, true);
        intercomLinkPresenter.setup(this);
        if (((AppConfig) provider.get()).shouldShowIntercomLink()) {
            this.linkContainer.setVisibility(0);
            RecyclerView recyclerView2 = this.recyclerView;
            recyclerView2.setPadding(recyclerView2.getPaddingLeft(), this.recyclerView.getPaddingTop(), this.recyclerView.getPaddingRight(), this.recyclerView.getPaddingBottom() + getResources().getDimensionPixelSize(R.dimen.intercom_link_height));
            return;
        }
        this.linkContainer.setVisibility(8);
    }

    private void setUpScrollListener() {
        if (VERSION.SDK_INT >= 23) {
            this.recyclerView.setOnScrollChangeListener(new OnScrollChangeListener() {
                public void onScrollChange(View view, int i2, int i3, int i4, int i5) {
                    HomeFragment.this.homePresenter.renderHeaderScrollChange(HomeFragment.this.recyclerView, HomeFragment.this.startLocationY, HomeFragment.this.closeBackground, HomeFragment.this.toolbarContent);
                }
            });
        } else {
            this.recyclerView.setOnScrollListener(new RecyclerView.n() {
                public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                    super.onScrolled(recyclerView, i2, i3);
                    HomeFragment.this.homePresenter.renderHeaderScrollChange(recyclerView, HomeFragment.this.startLocationY, HomeFragment.this.closeBackground, HomeFragment.this.toolbarContent);
                }
            });
        }
    }

    private void setUpToolbar(Provider<AppConfig> provider) {
        int secondaryColor = ((AppConfig) provider.get()).getSecondaryColor();
        this.toolbar.setBackgroundColor(secondaryColor);
        this.wallpaperLoader = WallpaperLoader.create(getContext(), provider, c.a((Fragment) this));
        this.toolbar.loadWallpaper(this.wallpaperLoader);
        this.toolbar.setBackgroundColor(secondaryColor);
        this.toolbar.updateToolbarColors((AppConfig) provider.get());
        View view = this.toolbarContent;
        view.setPadding(view.getPaddingLeft(), this.toolbarContent.getPaddingTop() + this.statusHeight, this.toolbarContent.getPaddingRight(), this.toolbarContent.getPaddingBottom());
        this.toolbar.updateContent((AppConfig) provider.get(), this.requestManager);
        animateHeaderIn();
        updateRecyclerViewPosition();
    }

    private void updateRecyclerViewPosition() {
        this.startLocationY = (this.recyclerView.getPaddingTop() + this.toolbar.getContentHeight(this.toolbarContent)) - getResources().getDimensionPixelSize(R.dimen.intercom_home_screen_overlap);
        RecyclerView recyclerView2 = this.recyclerView;
        recyclerView2.setPadding(recyclerView2.getPaddingLeft(), this.startLocationY, this.recyclerView.getPaddingRight(), this.recyclerView.getPaddingBottom());
    }

    public void addBottomPadding(int i2) {
    }

    public boolean isAtBottom() {
        return false;
    }

    public void notifyItemChanged(int i2) {
        this.homeCardAdapter.notifyItemChanged(i2);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.listener = (HomeClickListener) context;
        } catch (ClassCastException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append(context);
            sb.append(" must implement ConversationCardClickListener");
            throw new ClassCastException(sb.toString());
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.rootView;
        if (view == null) {
            Injector injector = Injector.get();
            this.api = injector.getApi();
            this.appConfigProvider = injector.getAppConfigProvider();
            this.store = injector.getStore();
            this.timeProvider = injector.getTimeProvider();
            this.bus = injector.getBus();
            this.gson = injector.getGson();
            this.metricTracker = injector.getMetricTracker();
            this.userIdentity = injector.getUserIdentity();
            this.rootView = layoutInflater.inflate(R.layout.intercom_fragment_home, viewGroup, false);
            this.statusHeight = WindowUtils.getStatusBarHeight(getResources());
            this.requestManager = c.a((Fragment) this);
            this.toolbar = (HomeToolbar) this.rootView.findViewById(R.id.intercom_toolbar);
            this.toolbarContent = this.rootView.findViewById(R.id.toolbar_content_container);
            this.recyclerView = (RecyclerView) this.rootView.findViewById(R.id.card_list);
            this.close = (ViewGroup) this.rootView.findViewById(R.id.intercom_home_close_container);
            this.closeBackground = this.rootView.findViewById(R.id.intercom_close_background);
            this.intercomErrorView = (IntercomErrorView) this.rootView.findViewById(R.id.error_layout_home_screen);
            this.intercomEmptyView = (IntercomErrorView) this.rootView.findViewById(R.id.error_layout_empty_screen);
            setUpErrorScreen();
            setUpEmptyScreen();
            setUpToolbar(this.appConfigProvider);
            setUpScrollListener();
            setUpCloseButton((AppConfig) this.appConfigProvider.get());
            setUpLinkView(this.appConfigProvider, this.api, this.rootView, injector.getAppIdentity().appId(), this.userIdentity.getIntercomId());
            setUpCardList(this.appConfigProvider, this.store, this.timeProvider, this.bus, this.gson, this.metricTracker, this.userIdentity);
        } else {
            ViewGroup viewGroup2 = (ViewGroup) view.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.rootView);
            }
            animateHeaderIn();
            this.recyclerView.scheduleLayoutAnimation();
        }
        return this.rootView;
    }

    public void onDestroyView() {
        this.toolbar.closeWallpaperLoader(this.wallpaperLoader);
        super.onDestroyView();
    }

    public void onResume() {
        this.store.dispatch(Actions.homeOpened());
        super.onResume();
    }

    public void onStart() {
        super.onStart();
        this.subscription = this.store.subscribeToChanges(Selectors.INBOX, Selectors.TEAM_PRESENCE, this);
    }

    public void onStop() {
        StoreUtils.safeUnsubscribe(this.subscription);
        super.onStop();
    }

    public void reload() {
        loadHomeScreen();
    }

    public void onStateChange(InboxState inboxState, TeamPresence teamPresence) {
        if (inboxState.status().equals(Status.SUCCESS) && !teamPresence.isEmpty()) {
            this.homePresenter.updateConversationCard();
        }
    }
}
