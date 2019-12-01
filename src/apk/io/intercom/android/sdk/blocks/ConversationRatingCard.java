package io.intercom.android.sdk.blocks;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.C0146m;
import androidx.appcompat.app.C0146m.a;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.blocks.blockInterfaces.ConversationRatingBlock;
import io.intercom.android.sdk.blocks.models.ConversationRating;
import io.intercom.android.sdk.blocks.models.ConversationRatingOption;
import io.intercom.android.sdk.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.imageloader.LongTermImageLoader;
import io.intercom.android.sdk.imageloader.LongTermImageLoader.OnImageReadyListener;
import io.intercom.android.sdk.utilities.BackgroundUtils;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.android.sdk.utilities.FontUtils;
import io.intercom.android.sdk.views.ButtonSelector;
import io.intercom.com.bumptech.glide.n;
import java.util.ArrayList;
import java.util.List;

public class ConversationRatingCard implements ConversationRatingBlock {
    private static final long ANIMATION_DURATION_MS = 200;
    private static final float DESELECTED_RATING_SCALE = 1.0f;
    private static final float DIALOG_HORIZONTAL_MARGIN = 16.0f;
    private static final float RATING_HORIZONTAL_PADDING = 17.0f;
    private static final float RATING_VERTICAL_PADDING = 14.0f;
    private static final float SELECTED_RATING_SCALE = 1.2f;
    private final Api api;
    private final Provider<AppConfig> appConfigProvider;
    private final String conversationId;
    /* access modifiers changed from: private */
    public ConversationRating conversationRating;
    private final ColorFilter deselectedFilter;
    private LongTermImageLoader longTermImageLoader;
    private final OnClickListener ratingClickListener = new OnClickListener() {
        public void onClick(View view) {
            int indexOf = ConversationRatingCard.this.ratingViews.indexOf(view);
            if (indexOf != -1 && ConversationRatingCard.this.ratingViews.size() == ConversationRatingCard.this.conversationRating.getOptions().size()) {
                ConversationRatingCard conversationRatingCard = ConversationRatingCard.this;
                conversationRatingCard.rateConversation(conversationRatingCard.conversationRating, (ConversationRatingOption) ConversationRatingCard.this.conversationRating.getOptions().get(indexOf));
                ConversationRatingCard.this.updateSelectedRating();
            }
        }
    };
    /* access modifiers changed from: private */
    public final List<ImageView> ratingViews;
    private final n requestManager;
    private LinearLayout rootLayout;

    ConversationRatingCard(Api api2, String str, Provider<AppConfig> provider, n nVar) {
        this.api = api2;
        this.conversationId = str;
        this.appConfigProvider = provider;
        this.requestManager = nVar;
        this.ratingViews = new ArrayList();
        this.deselectedFilter = ColorUtils.newGreyscaleFilter();
    }

    private View createConversationRatingBlock(ConversationRating conversationRating2, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        this.ratingViews.clear();
        this.conversationRating = conversationRating2;
        this.longTermImageLoader = LongTermImageLoader.newInstance(context);
        this.rootLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.intercom_conversation_rating_block, viewGroup, false);
        updateViewVisibility();
        Button button = (Button) this.rootLayout.findViewById(R.id.intercom_rating_tell_us_more_button);
        BackgroundUtils.setBackground(button, new ButtonSelector(context, R.drawable.intercom_border, ((AppConfig) this.appConfigProvider.get()).getPrimaryColor()));
        FontUtils.setRobotoMediumTypeface(button);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ConversationRatingCard.this.showRemarkDialog(view.getContext());
            }
        });
        setupRatingsLayout();
        updateSelectedRating();
        return this.rootLayout;
    }

    private void deselectView(ImageView imageView) {
        imageView.animate().setInterpolator(new OvershootInterpolator(0.6f)).scaleX(DESELECTED_RATING_SCALE).scaleY(DESELECTED_RATING_SCALE).setDuration(ANIMATION_DURATION_MS).start();
        imageView.setColorFilter(this.deselectedFilter);
    }

    private ConversationRatingOption findSelectedOption() {
        for (ConversationRatingOption conversationRatingOption : this.conversationRating.getOptions()) {
            if (conversationRatingOption.getIndex().equals(this.conversationRating.getRatingIndex())) {
                return conversationRatingOption;
            }
        }
        return null;
    }

    private static String imageUrlForUnicode(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("https://js.intercomcdn.com/images/stickers/");
        sb.append(str);
        sb.append(".png");
        return sb.toString();
    }

    private void selectView(float f2, ImageView imageView) {
        imageView.animate().setInterpolator(new OvershootInterpolator(2.0f)).scaleX(f2).scaleY(f2).setDuration(ANIMATION_DURATION_MS).start();
        imageView.clearColorFilter();
    }

    private void setupRatingsLayout() {
        LinearLayout linearLayout = (LinearLayout) this.rootLayout.findViewById(R.id.intercom_rating_options_layout);
        Context context = this.rootLayout.getContext();
        int dpToPx = ScreenUtils.dpToPx(RATING_VERTICAL_PADDING, context);
        int dpToPx2 = ScreenUtils.dpToPx(RATING_HORIZONTAL_PADDING, context);
        for (int i2 = 0; i2 < this.conversationRating.getOptions().size(); i2++) {
            ConversationRatingOption conversationRatingOption = (ConversationRatingOption) this.conversationRating.getOptions().get(i2);
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setClipChildren(false);
            frameLayout.setClipToPadding(false);
            frameLayout.setLayoutParams(new LayoutParams(0, -1, DESELECTED_RATING_SCALE));
            final ImageView imageView = new ImageView(context);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.intercom_conversation_rating_size);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize, 17);
            layoutParams.setMargins(dpToPx2, dpToPx, dpToPx2, dpToPx);
            imageView.setLayoutParams(layoutParams);
            imageView.setLongClickable(false);
            this.longTermImageLoader.loadImage(imageUrlForUnicode(conversationRatingOption.getUnicode()), new OnImageReadyListener() {
                public void onImageReady(Bitmap bitmap) {
                    imageView.setImageBitmap(bitmap);
                }
            }, this.requestManager);
            imageView.setOnClickListener(this.ratingClickListener);
            frameLayout.addView(imageView);
            linearLayout.addView(frameLayout);
            this.ratingViews.add(imageView);
        }
    }

    /* access modifiers changed from: private */
    public void showRemarkDialog(Context context) {
        a aVar = new a(context);
        aVar.setTitle(R.string.intercom_tell_us_more);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        int dpToPx = ScreenUtils.dpToPx(DIALOG_HORIZONTAL_MARGIN, context);
        layoutParams.setMargins(dpToPx, 0, dpToPx, 0);
        final EditText editText = new EditText(context);
        editText.getBackground().mutate().setColorFilter(((AppConfig) this.appConfigProvider.get()).getPrimaryColor(), Mode.SRC_ATOP);
        editText.setLayoutParams(layoutParams);
        linearLayout.addView(editText);
        aVar.setView((View) linearLayout);
        aVar.setPositiveButton(17039370, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                String obj = editText.getText().toString();
                ConversationRatingCard conversationRatingCard = ConversationRatingCard.this;
                conversationRatingCard.addRemarkToConversation(conversationRatingCard.conversationRating, obj);
            }
        });
        aVar.setNegativeButton(17039360, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
            }
        });
        final C0146m create = aVar.create();
        create.show();
        editText.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (z && create.getWindow() != null) {
                    create.getWindow().setSoftInputMode(5);
                }
            }
        });
        create.b(-1).setTextColor(((AppConfig) this.appConfigProvider.get()).getPrimaryColor());
        create.b(-2).setTextColor(((AppConfig) this.appConfigProvider.get()).getPrimaryColor());
    }

    /* access modifiers changed from: private */
    public void updateSelectedRating() {
        if (this.conversationRating.getOptions().size() == this.ratingViews.size()) {
            for (int i2 = 0; i2 < this.conversationRating.getOptions().size(); i2++) {
                ConversationRatingOption conversationRatingOption = (ConversationRatingOption) this.conversationRating.getOptions().get(i2);
                ImageView imageView = (ImageView) this.ratingViews.get(i2);
                if (this.conversationRating.getRatingIndex().intValue() == -1) {
                    selectView(DESELECTED_RATING_SCALE, imageView);
                } else if (this.conversationRating.getRatingIndex().equals(conversationRatingOption.getIndex())) {
                    selectView(SELECTED_RATING_SCALE, imageView);
                } else {
                    deselectView(imageView);
                }
            }
        }
    }

    private void updateViewVisibility() {
        if (this.rootLayout != null) {
            int i2 = 0;
            boolean z = this.conversationRating.getRatingIndex().intValue() != -1;
            boolean z2 = !TextUtils.isEmpty(this.conversationRating.getRemark());
            ((TextView) this.rootLayout.findViewById(R.id.rate_your_conversation_text_view)).setVisibility(z2 ? 8 : 0);
            ((LinearLayout) this.rootLayout.findViewById(R.id.intercom_rating_options_layout)).setVisibility(z2 ? 8 : 0);
            ((Button) this.rootLayout.findViewById(R.id.intercom_rating_tell_us_more_button)).setVisibility((!z || z2) ? 8 : 0);
            LinearLayout linearLayout = (LinearLayout) this.rootLayout.findViewById(R.id.intercom_you_rated_layout);
            if (!z2) {
                i2 = 8;
            }
            linearLayout.setVisibility(i2);
            ConversationRatingOption findSelectedOption = findSelectedOption();
            if (findSelectedOption != null) {
                final ImageView imageView = (ImageView) this.rootLayout.findViewById(R.id.intercom_you_rated_image_view);
                this.longTermImageLoader.loadImage(imageUrlForUnicode(findSelectedOption.getUnicode()), new OnImageReadyListener() {
                    public void onImageReady(Bitmap bitmap) {
                        imageView.setImageBitmap(bitmap);
                    }
                }, this.requestManager);
            }
        }
    }

    public View addConversationRatingBlock(ConversationRating conversationRating2, boolean z, boolean z2, ViewGroup viewGroup) {
        return createConversationRatingBlock(conversationRating2, viewGroup);
    }

    /* access modifiers changed from: 0000 */
    public void addRemarkToConversation(ConversationRating conversationRating2, String str) {
        if (TextUtils.isEmpty(conversationRating2.getRemark())) {
            conversationRating2.setRemark(str);
            this.api.addConversationRatingRemark(this.conversationId, str);
            updateViewVisibility();
        }
    }

    /* access modifiers changed from: 0000 */
    public void rateConversation(ConversationRating conversationRating2, ConversationRatingOption conversationRatingOption) {
        if (!conversationRating2.getRatingIndex().equals(conversationRatingOption.getIndex())) {
            conversationRating2.setRatingIndex(conversationRatingOption.getIndex().intValue());
            this.api.rateConversation(this.conversationId, conversationRatingOption.getIndex().intValue());
            updateViewVisibility();
        }
    }
}
