package com.appsflyer.share;

import android.content.Context;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.CreateOneLinkHttpTask.ResponseListener;
import com.appsflyer.ServerConfigHandler;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LinkGenerator {

    /* renamed from: ʻ reason: contains not printable characters */
    private String f251;

    /* renamed from: ʼ reason: contains not printable characters */
    private String f252;

    /* renamed from: ʽ reason: contains not printable characters */
    private String f253;

    /* renamed from: ˊ reason: contains not printable characters */
    private String f254;

    /* renamed from: ˋ reason: contains not printable characters */
    private String f255;

    /* renamed from: ˋॱ reason: contains not printable characters */
    private Map<String, String> f256 = new HashMap();

    /* renamed from: ˎ reason: contains not printable characters */
    private String f257;

    /* renamed from: ˏ reason: contains not printable characters */
    private String f258;

    /* renamed from: ˏॱ reason: contains not printable characters */
    private String f259;

    /* renamed from: ॱ reason: contains not printable characters */
    private String f260;

    /* renamed from: ॱˊ reason: contains not printable characters */
    private Map<String, String> f261 = new HashMap();

    /* renamed from: ॱॱ reason: contains not printable characters */
    private String f262;

    /* renamed from: ᐝ reason: contains not printable characters */
    private String f263;

    public LinkGenerator(String str) {
        this.f254 = str;
    }

    /* renamed from: ˋ reason: contains not printable characters */
    private static String m210(String str, String str2) {
        String str3 = "";
        try {
            return URLEncoder.encode(str, "utf8");
        } catch (UnsupportedEncodingException unused) {
            StringBuilder sb = new StringBuilder("Illegal ");
            sb.append(str2);
            sb.append(": ");
            sb.append(str);
            AFLogger.afInfoLog(sb.toString());
            return str3;
        } catch (Throwable unused2) {
            return str3;
        }
    }

    public LinkGenerator addParameter(String str, String str2) {
        this.f256.put(str, str2);
        return this;
    }

    public LinkGenerator addParameters(Map<String, String> map) {
        if (map != null) {
            this.f256.putAll(map);
        }
        return this;
    }

    public String generateLink() {
        return m211().toString();
    }

    public String getCampaign() {
        return this.f258;
    }

    public String getChannel() {
        return this.f257;
    }

    public String getMediaSource() {
        return this.f254;
    }

    public Map<String, String> getParameters() {
        return this.f256;
    }

    public LinkGenerator setBaseDeeplink(String str) {
        this.f259 = str;
        return this;
    }

    public LinkGenerator setBaseURL(String str, String str2, String str3) {
        String str4 = Constants.AF_BASE_URL_FORMAT;
        if (str == null || str.length() <= 0) {
            this.f263 = String.format(str4, new Object[]{ServerConfigHandler.getUrl(Constants.APPSFLYER_DEFAULT_APP_DOMAIN), str3});
        } else {
            if (str2 == null || str2.length() < 5) {
                str2 = Constants.ONELINK_DEFAULT_DOMAIN;
            }
            this.f263 = String.format(str4, new Object[]{str2, str});
        }
        return this;
    }

    public LinkGenerator setCampaign(String str) {
        this.f258 = str;
        return this;
    }

    public LinkGenerator setChannel(String str) {
        this.f257 = str;
        return this;
    }

    public LinkGenerator setDeeplinkPath(String str) {
        this.f252 = str;
        return this;
    }

    public LinkGenerator setReferrerCustomerId(String str) {
        this.f260 = str;
        return this;
    }

    public LinkGenerator setReferrerImageURL(String str) {
        this.f253 = str;
        return this;
    }

    public LinkGenerator setReferrerName(String str) {
        this.f262 = str;
        return this;
    }

    public LinkGenerator setReferrerUID(String str) {
        this.f255 = str;
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˊ reason: contains not printable characters */
    public final LinkGenerator m212(String str) {
        this.f263 = str;
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˏ reason: contains not printable characters */
    public final LinkGenerator m213(String str) {
        this.f251 = str;
        return this;
    }

    /* renamed from: ˏ reason: contains not printable characters */
    private StringBuilder m211() {
        StringBuilder sb = new StringBuilder();
        String str = this.f263;
        if (str == null || !str.startsWith("http")) {
            sb.append(ServerConfigHandler.getUrl(Constants.BASE_URL_APP_APPSFLYER_COM));
        } else {
            sb.append(this.f263);
        }
        if (this.f251 != null) {
            sb.append('/');
            sb.append(this.f251);
        }
        this.f261.put(Constants.URL_MEDIA_SOURCE, this.f254);
        sb.append('?');
        sb.append("pid=");
        sb.append(m210(this.f254, "media source"));
        String str2 = this.f255;
        if (str2 != null) {
            this.f261.put(Constants.URL_REFERRER_UID, str2);
            sb.append('&');
            sb.append("af_referrer_uid=");
            sb.append(m210(this.f255, "referrerUID"));
        }
        String str3 = this.f257;
        if (str3 != null) {
            this.f261.put("af_channel", str3);
            sb.append('&');
            sb.append("af_channel=");
            sb.append(m210(this.f257, AppsFlyerProperties.CHANNEL));
        }
        String str4 = this.f260;
        if (str4 != null) {
            this.f261.put(Constants.URL_REFERRER_CUSTOMER_ID, str4);
            sb.append('&');
            sb.append("af_referrer_customer_id=");
            sb.append(m210(this.f260, "referrerCustomerId"));
        }
        String str5 = this.f258;
        if (str5 != null) {
            this.f261.put(Constants.URL_CAMPAIGN, str5);
            sb.append('&');
            sb.append("c=");
            sb.append(m210(this.f258, "campaign"));
        }
        String str6 = this.f262;
        if (str6 != null) {
            this.f261.put(Constants.URL_REFERRER_NAME, str6);
            sb.append('&');
            sb.append("af_referrer_name=");
            sb.append(m210(this.f262, "referrerName"));
        }
        String str7 = this.f253;
        if (str7 != null) {
            this.f261.put(Constants.URL_REFERRER_IMAGE_URL, str7);
            sb.append('&');
            sb.append("af_referrer_image_url=");
            sb.append(m210(this.f253, "referrerImageURL"));
        }
        if (this.f259 != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f259);
            String str8 = this.f259;
            String str9 = Constants.URL_PATH_DELIMITER;
            String str10 = "";
            sb2.append(str8.endsWith(str9) ? str10 : str9);
            String str11 = this.f252;
            if (str11 != null) {
                sb2.append(str11);
            }
            this.f261.put(Constants.URL_BASE_DEEPLINK, sb2.toString());
            sb.append('&');
            sb.append("af_dp=");
            sb.append(m210(this.f259, "baseDeeplink"));
            if (this.f252 != null) {
                if (!this.f259.endsWith(str9)) {
                    str10 = "%2F";
                }
                sb.append(str10);
                sb.append(m210(this.f252, "deeplinkPath"));
            }
        }
        for (String str12 : this.f256.keySet()) {
            String sb3 = sb.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str12);
            sb4.append("=");
            sb4.append(m210((String) this.f256.get(str12), str12));
            if (!sb3.contains(sb4.toString())) {
                sb.append('&');
                sb.append(str12);
                sb.append('=');
                sb.append(m210((String) this.f256.get(str12), str12));
            }
        }
        return sb;
    }

    public void generateLink(Context context, ResponseListener responseListener) {
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_ID);
        if (!this.f256.isEmpty()) {
            for (Entry entry : this.f256.entrySet()) {
                this.f261.put(entry.getKey(), entry.getValue());
            }
        }
        m211();
        ShareInviteHelper.generateUserInviteLink(context, string, this.f261, responseListener);
    }
}
