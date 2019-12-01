package io.intercom.android.sdk.homescreen;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.f;
import b.g.a.a;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.models.Participant;
import io.intercom.android.sdk.models.TeamPresence;
import io.intercom.android.sdk.utilities.AvatarUtils;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.android.sdk.utilities.FontUtils;
import io.intercom.android.sdk.views.OfficeHoursTextView;
import io.intercom.com.bumptech.glide.n;
import java.util.List;

public class NewConversationCardViewHolder extends BaseConversationCardViewHolder {
    private final FrameLayout avatarLayout;
    private final ConstraintLayout constraintLayout;
    private final Context context;
    private int homeScreenWidth = getHomeScreenWidth();
    private final OfficeHoursTextView officeHoursView;
    private final Resources resources = this.context.getResources();
    private final TextView seePreviousButton;

    NewConversationCardViewHolder(View view, Provider<AppConfig> provider, HomeClickListener homeClickListener) {
        super(view, provider, homeClickListener);
        TextView textView = (TextView) view.findViewById(R.id.new_conversation_button);
        this.avatarLayout = (FrameLayout) view.findViewById(R.id.avatar_layout);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.new_conversation_card_layout);
        this.officeHoursView = (OfficeHoursTextView) view.findViewById(R.id.office_hours);
        this.constraintLayout = (ConstraintLayout) view.findViewById(R.id.constraint_layout);
        this.seePreviousButton = (TextView) view.findViewById(R.id.see_previous);
        this.context = linearLayout.getContext();
        textView.setOnClickListener(this.onNewConversationClicked);
        this.seePreviousButton.setOnClickListener(this.onSeePreviousClicked);
        applyCardBorderStyle(linearLayout);
        applyNewConversationButtonStyle(textView);
        applyAllConversationButtonStyle(this.seePreviousButton);
    }

    private void applyNewConversationButtonStyle(TextView textView) {
        FontUtils.setRobotoMediumTypeface(textView);
        updateButtonBackgroundColor(textView, ((AppConfig) this.appConfigProvider.get()).getPrimaryColor());
        int whiteOrDarkColor = ColorUtils.whiteOrDarkColor(this.context, ((AppConfig) this.appConfigProvider.get()).primaryColorRenderDarkText());
        textView.setTextColor(whiteOrDarkColor);
        updateLeftDrawableColor(textView, whiteOrDarkColor);
    }

    private void displayAvatars(List<Participant> list, n nVar) {
        int dimensionPixelOffset = (this.homeScreenWidth - (this.resources.getDimensionPixelOffset(R.dimen.intercom_conversation_card_padding) * 2)) - (this.resources.getDimensionPixelOffset(R.dimen.intercom_home_card_margin) * 2);
        LayoutInflater from = LayoutInflater.from(this.context);
        int i2 = 0;
        while (i2 < list.size()) {
            ImageView imageView = (ImageView) from.inflate(R.layout.intercom_view_conversation_card_avatar, this.avatarLayout, false).findViewById(R.id.avatar_view);
            if (updateLeftMarginForIndex(imageView, i2, dimensionPixelOffset)) {
                AvatarUtils.loadAvatarIntoView(((Participant) list.get(i2)).getAvatar(), imageView, (AppConfig) this.appConfigProvider.get(), nVar);
                this.avatarLayout.addView(imageView);
                i2++;
            } else {
                return;
            }
        }
    }

    private int getHomeScreenWidth() {
        int i2 = this.resources.getDisplayMetrics().widthPixels;
        if (!this.resources.getBoolean(R.bool.intercom_is_two_pane)) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        this.resources.getValue(R.dimen.intercom_two_pane_inbox_percentage, typedValue, true);
        return (int) (((float) i2) * typedValue.getFloat());
    }

    private boolean updateLeftMarginForIndex(ImageView imageView, int i2, int i3) {
        LayoutParams layoutParams = (LayoutParams) imageView.getLayoutParams();
        Resources resources2 = imageView.getContext().getResources();
        int dimensionPixelSize = i2 * resources2.getDimensionPixelSize(R.dimen.intercom_conversation_card_avatar_margin);
        if (resources2.getDimensionPixelSize(R.dimen.intercom_conversation_card_avatar_size) + dimensionPixelSize > i3) {
            return false;
        }
        layoutParams.leftMargin = dimensionPixelSize;
        imageView.setLayoutParams(layoutParams);
        return true;
    }

    private void updateNewConversationButtonPosition(int i2) {
        f fVar = new f();
        fVar.c(this.constraintLayout);
        int i3 = R.id.avatar_layout;
        int i4 = R.id.new_conversation_button;
        int i5 = R.id.see_previous;
        int dimensionPixelSize = this.resources.getDimensionPixelSize(R.dimen.intercom_home_new_conversation_button_margin);
        if (i2 <= 2) {
            f fVar2 = fVar;
            int i6 = i4;
            int i7 = i3;
            fVar2.a(i6, 1, i7, 2, dimensionPixelSize);
            fVar2.a(i6, 3, i7, 3, 0);
            fVar2.a(i6, 4, i7, 4, 0);
            fVar2.a(i5, 3, i7, 4, dimensionPixelSize);
        } else {
            f fVar3 = fVar;
            int i8 = dimensionPixelSize;
            fVar3.a(i4, 3, i3, 4, i8);
            fVar3.a(i5, 1, i4, 2, i8);
            fVar.a(i5, 5, i4, 5);
        }
        fVar.a(this.constraintLayout);
    }

    public void bindTeamPresence(TeamPresence teamPresence, n nVar, ConversationCard conversationCard) {
        int i2 = 8;
        if (teamPresence.isEmpty()) {
            this.officeHoursView.setVisibility(8);
            this.avatarLayout.setVisibility(8);
            this.seePreviousButton.setVisibility(8);
            return;
        }
        TextView textView = this.seePreviousButton;
        if (conversationCard.hasOlderConversations()) {
            i2 = 0;
        }
        textView.setVisibility(i2);
        this.officeHoursView.setVisibility(0);
        this.avatarLayout.setVisibility(0);
        List activeAdmins = teamPresence.getActiveAdmins();
        if (!activeAdmins.isEmpty()) {
            displayAvatars(activeAdmins, nVar);
            updateNewConversationButtonPosition(activeAdmins.size());
        }
        updateOfficeHours(this.officeHoursView, teamPresence);
        updateOlderConversationUnreadState(this.seePreviousButton, conversationCard.hasOlderUnreadConversations());
    }

    /* access modifiers changed from: 0000 */
    public void updateOfficeHours(OfficeHoursTextView officeHoursTextView, TeamPresence teamPresence) {
        String officeHours = teamPresence.getOfficeHours();
        if (TextUtils.isEmpty(officeHours)) {
            officeHoursTextView.setText(teamPresence.getExpectedResponseDelay());
            return;
        }
        officeHoursTextView.setText(officeHours);
        officeHoursTextView.setOfficeHoursDrawable(a.a(this.context, R.color.intercom_conversation_card_summary_text));
    }
}
