package io.intercom.android.sdk.profile;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.google.android.material.appbar.AppBarLayout;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.utilities.ViewUtils;

class TeammateProfileToolbarBehavior extends ProfileToolbarBehavior {
    private static final float CHANGE_IN_ACTIVE_STATE_SCALE = 0.6f;
    private static final float CHANGE_IN_AVATAR_SCALE = 0.85f;
    private View activeStateCircle;
    private View avatar1;
    private View avatar2;
    private View avatar3;
    private View bio;
    private final float headerTextAlpha;
    private View location;
    private final float profileTranslationY;
    private View role;
    private final ViewGroup rootLayout;
    private LinearLayout socialLayout;
    private View subtitle;
    private View title;
    private View titleNameOnly;
    private final float translate16dp;
    private final float translate28dp;
    private final float translate8dp;

    TeammateProfileToolbarBehavior(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        this.rootLayout = viewGroup;
        Context context = viewGroup.getContext();
        this.translate8dp = (float) ScreenUtils.dpToPx(8.0f, context);
        this.profileTranslationY = (float) context.getResources().getDimensionPixelSize(R.dimen.intercom_team_profile_translation_y);
        this.translate28dp = (float) ScreenUtils.dpToPx(28.0f, context);
        this.translate16dp = (float) ScreenUtils.dpToPx(16.0f, context);
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(R.dimen.intercom_header_text_alpha, typedValue, true);
        this.headerTextAlpha = typedValue.getFloat();
    }

    private void translateY(View view, View view2, float f2) {
        view.setTranslationY((float) ((int) Math.max(0.0f, (f2 / 100.0f) * getScrollPercentage(view2))));
    }

    private void updateAvatar(ViewGroup viewGroup, View view, float f2) {
        if (this.avatar1 == null) {
            this.avatar1 = viewGroup.findViewById(R.id.intercom_collapsing_teammate_avatar1);
        }
        if (this.avatar2 == null) {
            this.avatar2 = viewGroup.findViewById(R.id.intercom_collapsing_teammate_avatar2);
        }
        if (this.avatar3 == null) {
            this.avatar3 = viewGroup.findViewById(R.id.intercom_collapsing_teammate_avatar3);
        }
        if (this.activeStateCircle == null) {
            this.activeStateCircle = viewGroup.findViewById(R.id.intercom_collapsing_teammate_active_state);
        }
        Resources resources = viewGroup.getContext().getResources();
        float dimensionPixelSize = ((float) resources.getDimensionPixelSize(R.dimen.intercom_teammate_active_state_size)) / ((float) resources.getDimensionPixelSize(R.dimen.intercom_teammate_avatar_size));
        float f3 = ((1.0f - dimensionPixelSize) * 1.4166666f) + 1.0f;
        float f4 = (dimensionPixelSize * 1.4166666f) + 1.0f;
        float f5 = (this.translate8dp / 100.0f) * f2;
        this.avatar1.setTranslationX((float) ((int) Math.max(f5, 0.0f)));
        this.activeStateCircle.setTranslationX((float) ((int) Math.max(f5 * f3, 0.0f)));
        float f6 = (this.profileTranslationY / 100.0f) * f2;
        this.avatar1.setTranslationY((float) ((int) Math.max(0.0f, f6)));
        this.activeStateCircle.setTranslationY((float) ((int) Math.max(0.0f, f6 * f4)));
        float f7 = (0.0085f * f2) + 1.0f;
        float f8 = (f2 * 0.006f) + 1.0f;
        this.avatar1.setScaleX(f7);
        this.avatar1.setScaleY(f7);
        this.activeStateCircle.setScaleX(f8);
        this.activeStateCircle.setScaleY(f8);
        setAlphaAsPercentageOfScroll(this.avatar2, view, 1.0f, true);
        setAlphaAsPercentageOfScroll(this.avatar3, view, 1.0f, true);
    }

    private void updateBio(ViewGroup viewGroup, View view) {
        if (this.bio == null) {
            this.bio = viewGroup.findViewById(R.id.intercom_collapsing_bio_layout);
        }
        translateY(this.bio, view, this.profileTranslationY);
        setAlphaAsPercentageOfScroll(this.bio, view, 1.0f, false);
    }

    private void updateLocation(ViewGroup viewGroup, View view) {
        if (this.location == null) {
            this.location = viewGroup.findViewById(R.id.intercom_collapsing_location_layout);
        }
        translateY(this.location, view, this.profileTranslationY);
        setAlphaAsPercentageOfScroll(this.location, view, 1.0f, false);
    }

    private void updateRole(ViewGroup viewGroup, View view) {
        if (this.role == null) {
            this.role = viewGroup.findViewById(R.id.intercom_collapsing_role_layout);
        }
        translateY(this.role, view, this.profileTranslationY);
        setAlphaAsPercentageOfScroll(this.role, view, 1.0f, false);
    }

    private void updateSocialButtons(ViewGroup viewGroup, View view) {
        if (this.socialLayout == null) {
            this.socialLayout = (LinearLayout) viewGroup.findViewById(R.id.social_button_layout);
        }
        translateY(this.socialLayout, view, this.profileTranslationY);
        setAlphaAsPercentageOfScroll(this.socialLayout, view, this.headerTextAlpha, false);
    }

    private void updateTitle(ViewGroup viewGroup, View view, float f2) {
        if (this.title == null) {
            this.title = viewGroup.findViewById(R.id.intercom_collapsing_title);
        }
        if (this.titleNameOnly == null) {
            this.titleNameOnly = viewGroup.findViewById(R.id.intercom_collapsing_title_name_only);
        }
        if (this.subtitle == null) {
            this.subtitle = viewGroup.findViewById(R.id.intercom_collapsing_subtitle);
        }
        setAlphaAsPercentageOfScroll(this.subtitle, view, this.headerTextAlpha, false);
        float max = (float) ((int) Math.max(0.0f, (this.translate28dp / 100.0f) * f2));
        if (max > 0.0f) {
            this.subtitle.setTranslationY(max);
        }
        float max2 = (float) ((int) Math.max(0.0f, (this.translate16dp / 100.0f) * f2));
        if (max2 > 0.0f) {
            this.titleNameOnly.setTranslationY(max2);
            this.title.setTranslationY(max2);
        }
        setAlphaAsPercentageOfScroll(this.title, view, 1.0f, true);
        setAlphaAsPercentageOfScroll(this.titleNameOnly, view, 1.0f, false);
    }

    public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
        if (((float) appBarLayout.getHeight()) > this.toolbarHeight) {
            float scrollPercentage = getScrollPercentage(appBarLayout);
            this.rootLayout.getLayoutParams().height = appBarLayout.getBottom();
            updateAvatar(this.rootLayout, appBarLayout, scrollPercentage);
            updateTitle(this.rootLayout, appBarLayout, scrollPercentage);
            updateRole(this.rootLayout, appBarLayout);
            updateLocation(this.rootLayout, appBarLayout);
            updateBio(this.rootLayout, appBarLayout);
            updateSocialButtons(this.rootLayout, appBarLayout);
            ViewUtils.requestLayoutIfPossible(this.rootLayout);
        }
    }
}
