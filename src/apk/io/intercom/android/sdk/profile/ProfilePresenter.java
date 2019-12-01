package io.intercom.android.sdk.profile;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout.c;
import com.google.android.material.appbar.CollapsingToolbarLayout.a;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.imageloader.WallpaperLoader;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.LastParticipatingAdmin;
import io.intercom.android.sdk.models.Participant;
import io.intercom.android.sdk.models.TeamPresence;
import io.intercom.android.sdk.twig.Twig;
import io.intercom.android.sdk.utilities.WindowUtils;
import io.intercom.com.bumptech.glide.n;
import java.io.IOException;
import java.util.List;

public class ProfilePresenter {
    final AppBarLayout appBarLayout;
    private final Provider<AppConfig> appConfigProvider;
    private boolean autoOpened = false;
    private String conversationId = "";
    ProfileState currentState = ProfileState.IDLE;
    private boolean didShowUnknown = false;
    boolean isAnimating = false;
    private final MetricTracker metricTracker;
    private final c offsetListener = new c() {
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            if (i2 == 0) {
                ProfilePresenter profilePresenter = ProfilePresenter.this;
                if (profilePresenter.currentState != ProfileState.EXPANDED) {
                    profilePresenter.trackOpenMetric();
                    ((InputMethodManager) appBarLayout.getContext().getSystemService("input_method")).hideSoftInputFromWindow(appBarLayout.getWindowToken(), 0);
                }
                ProfilePresenter profilePresenter2 = ProfilePresenter.this;
                profilePresenter2.isAnimating = false;
                profilePresenter2.currentState = ProfileState.EXPANDED;
            } else if (Math.abs(i2) >= appBarLayout.getTotalScrollRange()) {
                ProfilePresenter profilePresenter3 = ProfilePresenter.this;
                profilePresenter3.isAnimating = false;
                profilePresenter3.currentState = ProfileState.COLLAPSED;
            } else {
                ProfilePresenter.this.currentState = ProfileState.IDLE;
            }
        }
    };
    private final TeamProfilePresenter teamProfilePresenter;
    private final TeammateProfilePresenter teammateProfilePresenter;
    private final ViewGroup titleLayoutCoordinator;
    private final View toolbar;
    private final Twig twig = LumberMill.getLogger();
    private final WallpaperLoader wallpaperLoader;
    private boolean wasClicked = false;

    enum ProfileState {
        COLLAPSED,
        EXPANDED,
        IDLE
    }

    public enum ProfileType {
        TEAMMATE,
        TEAM
    }

    public ProfilePresenter(CoordinatorLayout coordinatorLayout, MetricTracker metricTracker2, Provider<AppConfig> provider, n nVar) {
        this.appConfigProvider = provider;
        this.metricTracker = metricTracker2;
        this.appBarLayout = (AppBarLayout) coordinatorLayout.findViewById(R.id.app_bar_layout);
        this.toolbar = coordinatorLayout.findViewById(R.id.profile_toolbar);
        int dimensionPixelSize = this.toolbar.getResources().getDimensionPixelSize(R.dimen.intercom_toolbar_height);
        View view = this.toolbar;
        view.setLayoutParams(new a(-1, dimensionPixelSize + WindowUtils.getStatusBarHeight(view.getResources())));
        this.titleLayoutCoordinator = (FrameLayout) coordinatorLayout.findViewById(R.id.profile_toolbar_coordinator);
        this.wallpaperLoader = WallpaperLoader.create(coordinatorLayout.getContext(), provider, nVar);
        this.teammateProfilePresenter = new TeammateProfilePresenter(coordinatorLayout, this, provider, nVar);
        this.teamProfilePresenter = new TeamProfilePresenter(coordinatorLayout, this, provider);
    }

    private void openProfile() {
        this.appBarLayout.a(true, true);
    }

    public void addListener(c cVar) {
        this.appBarLayout.a(cVar);
    }

    /* access modifiers changed from: 0000 */
    public void applyOffsetChangedListener(final c cVar) {
        this.appBarLayout.a(cVar);
        this.appBarLayout.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public boolean onPreDraw() {
                ProfilePresenter.this.appBarLayout.getViewTreeObserver().removeOnPreDrawListener(this);
                cVar.onOffsetChanged(ProfilePresenter.this.appBarLayout, 0);
                return false;
            }
        });
    }

    public void cleanup() {
        try {
            this.wallpaperLoader.close();
        } catch (IOException e2) {
            Twig twig2 = this.twig;
            StringBuilder sb = new StringBuilder();
            sb.append("Couldn't close LongTermImageLoader: ");
            sb.append(e2.getMessage());
            twig2.d(sb.toString(), new Object[0]);
        }
    }

    public void closeProfile() {
        this.appBarLayout.a(false, true);
    }

    /* access modifiers changed from: 0000 */
    public boolean isDidShowUnknown() {
        return this.didShowUnknown;
    }

    public boolean isExpanded() {
        return this.currentState == ProfileState.EXPANDED;
    }

    public void loadWallpaperInto(ImageView imageView) {
        this.wallpaperLoader.loadWallpaperInto(imageView);
    }

    public void onStop() {
        this.teammateProfilePresenter.stopUpdatingTime();
    }

    public void profileAutoOpened() {
        this.autoOpened = true;
        openProfile();
    }

    public void profileClicked() {
        this.wasClicked = true;
        openProfile();
    }

    public void setConversationId(String str) {
        this.conversationId = str;
    }

    /* access modifiers changed from: 0000 */
    public void setDidShowUnknown(boolean z) {
        this.didShowUnknown = z;
    }

    public void setTeamPresence(TeamPresence teamPresence, int i2, n nVar) {
        this.teamProfilePresenter.setTeamCollapsingTitle(((AppConfig) this.appConfigProvider.get()).getName());
        if (teamPresence.isEmpty()) {
            this.teammateProfilePresenter.setTeammateSubtitle(null);
            return;
        }
        this.toolbar.setBackgroundColor(0);
        this.appBarLayout.b((c) this.teammateProfilePresenter.getToolbarBehavior());
        this.teamProfilePresenter.setPresence(teamPresence, i2, this.appBarLayout, this.teammateProfilePresenter.getRootLayout(), this.titleLayoutCoordinator, nVar);
    }

    public void setTeammatePresence(LastParticipatingAdmin lastParticipatingAdmin, List<Participant> list, CharSequence charSequence, int i2) {
        this.toolbar.setBackgroundColor(0);
        this.appBarLayout.b((c) this.teamProfilePresenter.getToolbarBehavior());
        this.teammateProfilePresenter.setPresence(lastParticipatingAdmin, list, charSequence, i2, this.appBarLayout, this.currentState, this.teamProfilePresenter.getRootLayout(), this.titleLayoutCoordinator);
    }

    public void setUnknownPresence() {
        this.didShowUnknown = true;
        this.teammateProfilePresenter.getRootLayout().setAlpha(0.0f);
        this.teamProfilePresenter.getRootLayout().setAlpha(0.0f);
        this.toolbar.setBackgroundColor(((AppConfig) this.appConfigProvider.get()).getSecondaryColor());
        this.appBarLayout.b((c) this.teamProfilePresenter.getToolbarBehavior());
        this.appBarLayout.b((c) this.teammateProfilePresenter.getToolbarBehavior());
    }

    public void startOffsetListener() {
        this.appBarLayout.a(this.offsetListener);
    }

    /* access modifiers changed from: 0000 */
    public void trackOpenMetric() {
        ProfileType profileType = this.teamProfilePresenter.getRootLayout().getAlpha() == 0.0f ? ProfileType.TEAMMATE : ProfileType.TEAM;
        if (this.wasClicked) {
            this.metricTracker.profileClickedOpen(this.conversationId, profileType);
        } else if (this.autoOpened) {
            this.metricTracker.profileAutoOpen(this.conversationId, profileType);
        } else {
            this.metricTracker.profileScrolledOpen(this.conversationId, profileType);
        }
        this.wasClicked = false;
        this.autoOpened = false;
    }
}
