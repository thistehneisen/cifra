package io.intercom.android.sdk.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.twig.Twig;
import io.intercom.android.sdk.utilities.LinkOpener;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class IntercomLinkView extends AppCompatTextView {
    private static final int INTERCOM_LINK_ANIMATION_TIME_MS = 100;
    private final int conversationBottomPaddingPx = ScreenUtils.dpToPx(8.0f, getContext());
    private final int[] intercomLinkPosition = new int[2];
    private int lastBottomPosition = 0;
    private final int[] lastChildPosition = new int[2];
    private final Twig twig = LumberMill.getLogger();

    public IntercomLinkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private String getCompanyForUrl(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            this.twig.i("Could not url encode the app name", new Object[0]);
            return "";
        }
    }

    /* access modifiers changed from: 0000 */
    public String createIntercomLinkUrl(Provider<AppConfig> provider, boolean z, String str, String str2, String str3) {
        String str4 = z ? "4+home-screen+we-run-on-intercom" : "4+conversation+we-run-on-intercom";
        StringBuilder sb = new StringBuilder();
        sb.append("https://www.intercom.io/intercom-link?user_id=");
        sb.append(str2);
        sb.append("&powered_by_app_id=");
        sb.append(str);
        sb.append("&company=");
        sb.append(getCompanyForUrl(((AppConfig) provider.get()).getName()));
        sb.append("&solution=");
        sb.append(str3);
        sb.append("&utm_source=android-sdk&utm_campaign=intercom-link&utm_content=");
        sb.append(str4);
        sb.append("&utm_medium=messenger");
        return sb.toString();
    }

    public void followIntercomLink(Provider<AppConfig> provider, Api api, boolean z, String str, String str2, String str3) {
        LinkOpener.handleUrl(createIntercomLinkUrl(provider, z, str, str2, str3), getContext(), api);
    }

    public void hide() {
        animate().alpha(0.0f).setDuration(100);
        setClickable(false);
    }

    public void hideIfIntersectedOrShow(View view) {
        view.getLocationOnScreen(this.lastChildPosition);
        int height = this.lastChildPosition[1] + view.getHeight() + this.conversationBottomPaddingPx;
        getLocationOnScreen(this.intercomLinkPosition);
        int[] iArr = this.intercomLinkPosition;
        if (height < iArr[1] || this.lastBottomPosition >= iArr[1]) {
            int[] iArr2 = this.intercomLinkPosition;
            if (height < iArr2[1] && this.lastBottomPosition >= iArr2[1]) {
                show();
            }
        } else {
            hide();
        }
        this.lastBottomPosition = height;
    }

    public void show() {
        animate().alpha(1.0f).setDuration(100);
        setClickable(true);
    }
}
