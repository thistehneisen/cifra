package io.intercom.android.sdk.views;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.appbar.AppBarLayout.b;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.imageloader.WallpaperLoader;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.android.sdk.utilities.ImageUtils;
import io.intercom.android.sdk.utilities.WindowUtils;
import io.intercom.com.bumptech.glide.f.g;
import io.intercom.com.bumptech.glide.k;
import io.intercom.com.bumptech.glide.load.c.c.c;
import io.intercom.com.bumptech.glide.n;
import io.intercom.com.bumptech.glide.o;
import java.io.IOException;

public class HomeToolbar extends Toolbar {
    private final ImageView backgroundImage;
    private final TextView greeting;
    private final TextView intro;
    private final ImageView logo;

    public HomeToolbar(Context context) {
        this(context, null);
    }

    public void animateIn(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(view.getContext(), R.anim.intercom_home_header_slide_in));
    }

    public void closeWallpaperLoader(WallpaperLoader wallpaperLoader) {
        try {
            wallpaperLoader.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public int getContentHeight(View view) {
        view.measure(MeasureSpec.makeMeasureSpec(ScreenUtils.getScreenDimensions(getContext()).x, 1073741824), 0);
        return view.getMeasuredHeight();
    }

    public int getDefaultToolbarHeight(Resources resources) {
        return resources.getDimensionPixelSize(R.dimen.intercom_toolbar_height) + WindowUtils.getStatusBarHeight(resources);
    }

    public void loadWallpaper(WallpaperLoader wallpaperLoader) {
        wallpaperLoader.loadWallpaperInto(this.backgroundImage);
    }

    public void updateContent(AppConfig appConfig, n nVar) {
        View findViewById = findViewById(R.id.toolbar_content_container);
        findViewById.setVisibility(appConfig.isReceivedFromServer() ? 0 : 8);
        String teamGreeting = appConfig.getTeamGreeting();
        String teamIntro = appConfig.getTeamIntro();
        String messengerLogoUrl = appConfig.getMessengerLogoUrl();
        if (TextUtils.isEmpty(teamGreeting)) {
            this.greeting.setVisibility(8);
        } else {
            this.greeting.setVisibility(0);
            if (!this.greeting.getText().toString().equals(teamGreeting)) {
                this.greeting.setText(teamGreeting);
            }
        }
        if (TextUtils.isEmpty(teamIntro)) {
            this.intro.setVisibility(8);
        } else {
            this.intro.setVisibility(0);
            this.intro.setText(teamIntro);
        }
        if (TextUtils.isEmpty(messengerLogoUrl)) {
            this.logo.setVisibility(8);
        } else {
            this.logo.setVisibility(0);
            g a2 = new g().a(ImageUtils.getDiskCacheStrategy(messengerLogoUrl));
            k a3 = nVar.a(messengerLogoUrl);
            a3.a((o<?, ? super TranscodeType>) c.c());
            a3.a(a2);
            a3.a(this.logo);
        }
        setLayoutParams(new b(-1, appConfig.isReceivedFromServer() ? getContentHeight(findViewById) : getDefaultToolbarHeight(findViewById.getResources())));
        requestLayout();
    }

    public void updateToolbarColors(AppConfig appConfig) {
        boolean secondaryColorRenderDarkText = appConfig.secondaryColorRenderDarkText();
        ColorUtils.setTextColorWhiteOrBlack(this.intro, secondaryColorRenderDarkText);
        ColorUtils.setTextColorWhiteOrBlack(this.greeting, secondaryColorRenderDarkText);
    }

    public HomeToolbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = ViewGroup.inflate(context, R.layout.intercom_home_toolbar, this);
        this.greeting = (TextView) inflate.findViewById(R.id.intercom_toolbar_greeting);
        this.intro = (TextView) inflate.findViewById(R.id.intercom_toolbar_intro);
        this.logo = (ImageView) inflate.findViewById(R.id.intercom_toolbar_logo);
        this.backgroundImage = (ImageView) inflate.findViewById(R.id.wallpaper_image);
    }
}
