package io.intercom.android.sdk.identity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.text.TextUtils;
import b.g.a.a;
import e.a.a.a.a.d;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.models.Config;
import io.intercom.android.sdk.models.events.ConfigUpdateEvent;
import io.intercom.android.sdk.nexus.NexusConfig;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.android.sdk.utilities.PreferenceKeys;
import java.util.HashSet;
import java.util.Set;

public class AppConfig {
    private static final String APP_ATTACHMENTS_ENABLED = "app_user_conversation_attachments_enabled";
    private static final String APP_AUDIO_ENABLED = "app_audio_enabled";
    private static final String APP_BACKGROUND_REQUESTS_ENABLED = "app_background_requests_enabled";
    private static final String APP_BATCH_USER_UPDATE_PERIOD_MS = "batch_user_update_period_ms";
    private static final String APP_FEATURES = "features";
    private static final String APP_GIFS_ENABLED = "app_user_conversation_gifs_enabled";
    private static final String APP_HELP_CENTER_COLOR_RENDER_DARK_TEXT = "app_help_center_color_render_dark_text";
    private static final String APP_HELP_CENTER_PRIMARY_COLOR = "app_help_center_primary_color";
    private static final String APP_HELP_CENTER_URL = "help_center_url";
    private static final String APP_HOME_SCREEN_CARD_COUNT = "app_home_screen_card_count";
    private static final String APP_IDENTITY_VERIFICTION_ENABLED = "app_identity_verification_enabled";
    private static final String APP_INBOUND_MESSAGES = "app_inbound_messages";
    private static final String APP_INTERCOM_LINK = "app_intercom_link";
    private static final String APP_LOCALE = "app_locale";
    private static final String APP_MESSENGER_LOGO_URL = "app_messenger_logo_url";
    private static final String APP_METRICS_ENABLED = "app_metrics_enabled";
    private static final String APP_NAME = "app_name";
    private static final String APP_NEW_SESSION_THRESHOLD_MS = "new_session_threshold_ms";
    private static final String APP_PING_DELAY_MS = "ping_delay_ms";
    private static final String APP_PRIMARY_COLOR = "app_primary_color";
    private static final String APP_PRIMARY_COLOR_RENDER_DARK_TEXT = "app_primary_color_render_dark_text";
    private static final String APP_RATE_LIMIT_COUNT = "app_rate_limit_count";
    private static final String APP_RATE_LIMIT_PERIOD_MS = "app_rate_limit_period_ms";
    private static final String APP_RECEIVED_FROM_SERVER = "app_received_from_server";
    private static final String APP_SECONDARY_COLOR = "app_secondary_color";
    private static final String APP_SECONDARY_COLOR_RENDER_DARK_TEXT = "app_secondary_color_render_dark_text";
    private static final String APP_SOFT_RESET_TIMEOUT_MS = "app_soft_reset_timeout_ms";
    private static final String APP_TEAM_BIO = "app_team_bio";
    private static final String APP_TEAM_GREETING = "app_team_greeting";
    private static final String APP_TEAM_INTRO = "app_team_intro";
    private static final String APP_USER_UPDATE_CACHE_MAX_AGE_MS = "app_user_update_cache_max_age_ms";
    private static final String APP_WALLPAPER = "app_wallpaper";
    private boolean attachmentsEnabled;
    private boolean audioEnabled;
    private boolean backgroundRequestsEnabled;
    private long batchUserUpdatePeriodMs;
    private final int defaultColor;
    private Set<String> features;
    private boolean gifsEnabled;
    private int helpCenterBaseColor;
    private boolean helpCenterColorRenderDarkText;
    private String helpCenterUrl;
    private int homeScreenCardCount;
    private boolean identityVerificationEnabled;
    private boolean inboundMessages;
    private String locale;
    private String messengerLogoUrl;
    private boolean metricsEnabled;
    private String name;
    private long newSessionThresholdMs;
    private long pingDelayMs;
    private final SharedPreferences prefs;
    private int primaryColor;
    private int primaryColorDark;
    private boolean primaryColorRenderDarkText;
    private int rateLimitCount;
    private long rateLimitPeriodMs;
    private NexusConfig realTimeConfig = new NexusConfig();
    private boolean receivedFromServer;
    private int secondaryColor;
    private int secondaryColorDark;
    private boolean secondaryColorRenderDarkText;
    private boolean showIntercomLink;
    private long softResetTimeoutMs;
    private String teamGreeting;
    private String teamIntro;
    private String teamProfileBio;
    private long userUpdateCacheMaxAgeMs;
    private String wallpaper;

    public AppConfig(Context context) {
        this.defaultColor = a.a(context, R.color.intercom_main_blue);
        this.prefs = context.getSharedPreferences(PreferenceKeys.INTERCOM_PREFS, 0);
        String str = "";
        this.name = this.prefs.getString(APP_NAME, str);
        this.primaryColor = this.prefs.getInt(APP_PRIMARY_COLOR, this.defaultColor);
        this.primaryColorDark = ColorUtils.darkenColor(this.primaryColor);
        this.secondaryColor = this.prefs.getInt(APP_SECONDARY_COLOR, this.primaryColor);
        this.secondaryColorDark = darkSecondaryColor();
        this.primaryColorRenderDarkText = this.prefs.getBoolean(APP_PRIMARY_COLOR_RENDER_DARK_TEXT, false);
        this.secondaryColorRenderDarkText = this.prefs.getBoolean(APP_SECONDARY_COLOR_RENDER_DARK_TEXT, false);
        this.helpCenterColorRenderDarkText = this.prefs.getBoolean(APP_HELP_CENTER_COLOR_RENDER_DARK_TEXT, false);
        this.showIntercomLink = this.prefs.getBoolean(APP_INTERCOM_LINK, true);
        this.inboundMessages = this.prefs.getBoolean(APP_INBOUND_MESSAGES, false);
        this.attachmentsEnabled = this.prefs.getBoolean(APP_ATTACHMENTS_ENABLED, true);
        this.gifsEnabled = this.prefs.getBoolean(APP_GIFS_ENABLED, true);
        this.rateLimitCount = this.prefs.getInt(APP_RATE_LIMIT_COUNT, 100);
        this.rateLimitPeriodMs = this.prefs.getLong(APP_RATE_LIMIT_PERIOD_MS, Config.DEFAULT_RATE_LIMIT_PERIOD_MS);
        this.userUpdateCacheMaxAgeMs = this.prefs.getLong(APP_USER_UPDATE_CACHE_MAX_AGE_MS, Config.DEFAULT_CACHE_MAX_AGE_MS);
        this.newSessionThresholdMs = this.prefs.getLong(APP_NEW_SESSION_THRESHOLD_MS, Config.DEFAULT_SESSION_TIMEOUT_MS);
        this.softResetTimeoutMs = this.prefs.getLong(APP_SOFT_RESET_TIMEOUT_MS, Config.DEFAULT_SOFT_RESET_TIMEOUT_MS);
        this.batchUserUpdatePeriodMs = this.prefs.getLong(APP_BATCH_USER_UPDATE_PERIOD_MS, Config.DEFAULT_BATCH_USER_UPDATE_PERIOD_MS);
        this.pingDelayMs = this.prefs.getLong(APP_PING_DELAY_MS, Config.DEFAULT_PING_DELAY_MS);
        this.homeScreenCardCount = this.prefs.getInt(APP_HOME_SCREEN_CARD_COUNT, 0);
        this.metricsEnabled = this.prefs.getBoolean(APP_METRICS_ENABLED, true);
        this.audioEnabled = this.prefs.getBoolean(APP_AUDIO_ENABLED, true);
        this.teamProfileBio = this.prefs.getString(APP_TEAM_BIO, str);
        this.wallpaper = this.prefs.getString(APP_WALLPAPER, str);
        this.locale = this.prefs.getString(APP_LOCALE, str);
        this.receivedFromServer = this.prefs.getBoolean(APP_RECEIVED_FROM_SERVER, false);
        this.backgroundRequestsEnabled = this.prefs.getBoolean(APP_BACKGROUND_REQUESTS_ENABLED, true);
        this.helpCenterUrl = this.prefs.getString(APP_HELP_CENTER_URL, str);
        this.helpCenterBaseColor = this.prefs.getInt(APP_HELP_CENTER_PRIMARY_COLOR, this.defaultColor);
        this.features = this.prefs.getStringSet(APP_FEATURES, new HashSet());
        this.messengerLogoUrl = this.prefs.getString(APP_MESSENGER_LOGO_URL, str);
        this.teamIntro = this.prefs.getString(APP_TEAM_INTRO, str);
        this.teamGreeting = this.prefs.getString(APP_TEAM_GREETING, str);
        this.identityVerificationEnabled = this.prefs.getBoolean(APP_IDENTITY_VERIFICTION_ENABLED, false);
    }

    private int darkSecondaryColor() {
        return ColorUtils.darkenColor(this.secondaryColor);
    }

    private int getConfigColor(String str) {
        return str == null ? this.defaultColor : Color.parseColor(str);
    }

    private String getWallpaperFromConfig(Config config) {
        String messenger4Background = config.getMessenger4Background();
        return TextUtils.isEmpty(messenger4Background) ? config.getMessengerBackground() : messenger4Background;
    }

    private boolean isNewConfig(Config config) {
        return (config.getWelcomeMessage().equals(this.teamProfileBio) && getWallpaperFromConfig(config).equals(this.wallpaper) && config.getName().equals(this.name) && config.getLocale().equals(this.locale) && getConfigColor(config.getPrimaryColor()) == this.primaryColor && getConfigColor(config.getSecondaryColor()) == this.secondaryColor && config.isPrimaryColorRenderDarkText() == this.primaryColorRenderDarkText && config.isSecondaryColorRenderDarkText() == this.secondaryColorRenderDarkText && config.isHelpCenterColorRenderDarkText() == this.helpCenterColorRenderDarkText && config.getUserUpdateCacheMaxAge() == this.userUpdateCacheMaxAgeMs && config.isMetricsEnabled() == this.metricsEnabled && config.isAudioEnabled() == this.audioEnabled && config.isShowPoweredBy() == this.showIntercomLink && config.isInboundMessages() == this.inboundMessages && config.isAttachmentsEnabled() == this.attachmentsEnabled && config.isGifsEnabled() == this.gifsEnabled && config.getRateLimitCount() == this.rateLimitCount && config.getRateLimitPeriod() == this.rateLimitPeriodMs && config.getNewSessionThreshold() == this.newSessionThresholdMs && config.getSoftResetTimeout() == this.softResetTimeoutMs && config.getBatchUserUpdatePeriod() == this.batchUserUpdatePeriodMs && config.getPingDelayMs() == this.pingDelayMs && config.getHomeScreenCardCount() == this.homeScreenCardCount && config.isBackgroundRequestsEnabled() == this.backgroundRequestsEnabled && config.getHelpCenterUrl().equals(this.helpCenterUrl) && getConfigColor(config.getHelpCenterBaseColor()) == this.helpCenterBaseColor && config.getFeatures().equals(this.features) && config.getMessengerLogoUrl().equals(this.messengerLogoUrl) && config.getTeamIntro().equals(this.teamIntro) && config.getTeamGreeting().equals(this.teamGreeting) && config.getTeamGreeting().equals(this.teamGreeting) && config.getIdentityVerificationEnabled() == this.identityVerificationEnabled) ? false : true;
    }

    private String removeLineSeparator(String str) {
        return str.replaceAll(System.getProperty("line.separator"), "");
    }

    public boolean backgroundRequestsDisabled() {
        return !this.backgroundRequestsEnabled;
    }

    public long getBatchUserUpdatePeriodMs() {
        return this.batchUserUpdatePeriodMs;
    }

    public int getHelpCenterBaseColor() {
        return this.helpCenterBaseColor;
    }

    public String getHelpCenterUrl() {
        return this.helpCenterUrl;
    }

    public int getHomeScreenCardCount() {
        return this.homeScreenCardCount;
    }

    public String getLocale() {
        return this.locale;
    }

    public String getMessengerLogoUrl() {
        return this.messengerLogoUrl;
    }

    public String getName() {
        return this.name;
    }

    public long getNewSessionThresholdMs() {
        return this.newSessionThresholdMs;
    }

    public long getPingDelayMs() {
        return this.pingDelayMs;
    }

    public int getPrimaryColor() {
        return this.primaryColor;
    }

    public int getPrimaryColorDark() {
        return this.primaryColorDark;
    }

    public int getRateLimitCount() {
        return this.rateLimitCount;
    }

    public long getRateLimitPeriodMs() {
        return this.rateLimitPeriodMs;
    }

    public NexusConfig getRealTimeConfig() {
        return this.realTimeConfig;
    }

    public int getSecondaryColor() {
        return this.secondaryColor;
    }

    public int getSecondaryColorDark() {
        return this.secondaryColorDark;
    }

    public long getSoftResetTimeoutMs() {
        return this.softResetTimeoutMs;
    }

    public String getTeamGreeting() {
        return this.teamGreeting;
    }

    public String getTeamIntro() {
        return removeLineSeparator(this.teamIntro);
    }

    public String getTeamProfileBio() {
        return removeLineSeparator(this.teamProfileBio);
    }

    public long getUserUpdateCacheMaxAgeMs() {
        return this.userUpdateCacheMaxAgeMs;
    }

    public String getWallpaper() {
        return this.wallpaper;
    }

    public boolean hasFeature(String str) {
        return this.features.contains(str);
    }

    public boolean helpCenterColorRenderDarkText() {
        return this.helpCenterColorRenderDarkText;
    }

    public boolean isAttachmentsEnabled() {
        return this.attachmentsEnabled;
    }

    public boolean isAudioEnabled() {
        return this.audioEnabled;
    }

    public boolean isGifsEnabled() {
        return this.gifsEnabled;
    }

    public boolean isIdentityVerificationEnabled() {
        return this.identityVerificationEnabled;
    }

    public boolean isInboundMessages() {
        return this.inboundMessages;
    }

    public boolean isMetricsEnabled() {
        return this.metricsEnabled;
    }

    public boolean isReceivedFromServer() {
        return this.receivedFromServer;
    }

    public boolean primaryColorRenderDarkText() {
        return this.primaryColorRenderDarkText;
    }

    public void resetRealTimeConfig() {
        this.realTimeConfig = new NexusConfig();
    }

    public boolean secondaryColorRenderDarkText() {
        return this.secondaryColorRenderDarkText;
    }

    public boolean shouldShowIntercomLink() {
        return this.showIntercomLink;
    }

    public void update(Config config, d dVar) {
        if (config != Config.NULL) {
            this.realTimeConfig = config.getRealTimeConfig();
            this.receivedFromServer = true;
            if (isNewConfig(config)) {
                this.name = config.getName();
                this.teamProfileBio = config.getWelcomeMessage();
                this.wallpaper = getWallpaperFromConfig(config);
                this.primaryColor = getConfigColor(config.getPrimaryColor());
                this.primaryColorDark = ColorUtils.darkenColor(this.primaryColor);
                this.secondaryColor = getConfigColor(config.getSecondaryColor());
                this.primaryColorRenderDarkText = config.isPrimaryColorRenderDarkText();
                this.secondaryColorRenderDarkText = config.isSecondaryColorRenderDarkText();
                this.helpCenterColorRenderDarkText = config.isHelpCenterColorRenderDarkText();
                this.inboundMessages = config.isInboundMessages();
                this.attachmentsEnabled = config.isAttachmentsEnabled();
                this.gifsEnabled = config.isGifsEnabled();
                this.secondaryColorDark = darkSecondaryColor();
                this.showIntercomLink = config.isShowPoweredBy();
                this.audioEnabled = config.isAudioEnabled();
                this.metricsEnabled = config.isMetricsEnabled();
                this.userUpdateCacheMaxAgeMs = config.getUserUpdateCacheMaxAge();
                this.rateLimitPeriodMs = config.getRateLimitPeriod();
                this.rateLimitCount = config.getRateLimitCount();
                this.newSessionThresholdMs = config.getNewSessionThreshold();
                this.softResetTimeoutMs = config.getSoftResetTimeout();
                this.batchUserUpdatePeriodMs = config.getBatchUserUpdatePeriod();
                this.pingDelayMs = config.getPingDelayMs();
                this.homeScreenCardCount = config.getHomeScreenCardCount();
                this.backgroundRequestsEnabled = config.isBackgroundRequestsEnabled();
                this.locale = config.getLocale();
                this.helpCenterUrl = config.getHelpCenterUrl();
                this.helpCenterBaseColor = getConfigColor(config.getHelpCenterBaseColor());
                this.features = config.getFeatures();
                this.messengerLogoUrl = config.getMessengerLogoUrl();
                this.teamIntro = config.getTeamIntro();
                this.teamGreeting = config.getTeamGreeting();
                this.identityVerificationEnabled = config.getIdentityVerificationEnabled();
                this.prefs.edit().putString(APP_NAME, this.name).putString(APP_TEAM_BIO, this.teamProfileBio).putString(APP_WALLPAPER, this.wallpaper).putString(APP_LOCALE, this.locale).putString(APP_MESSENGER_LOGO_URL, this.messengerLogoUrl).putString(APP_TEAM_INTRO, this.teamIntro).putString(APP_TEAM_GREETING, this.teamGreeting).putInt(APP_PRIMARY_COLOR, this.primaryColor).putInt(APP_SECONDARY_COLOR, this.secondaryColor).putInt(APP_HELP_CENTER_PRIMARY_COLOR, this.helpCenterBaseColor).putInt(APP_RATE_LIMIT_COUNT, this.rateLimitCount).putLong(APP_USER_UPDATE_CACHE_MAX_AGE_MS, this.userUpdateCacheMaxAgeMs).putLong(APP_RATE_LIMIT_PERIOD_MS, this.rateLimitPeriodMs).putLong(APP_NEW_SESSION_THRESHOLD_MS, this.newSessionThresholdMs).putLong(APP_BATCH_USER_UPDATE_PERIOD_MS, this.batchUserUpdatePeriodMs).putLong(APP_PING_DELAY_MS, this.pingDelayMs).putInt(APP_HOME_SCREEN_CARD_COUNT, this.homeScreenCardCount).putLong(APP_SOFT_RESET_TIMEOUT_MS, this.softResetTimeoutMs).putBoolean(APP_INTERCOM_LINK, this.showIntercomLink).putBoolean(APP_INBOUND_MESSAGES, this.inboundMessages).putBoolean(APP_ATTACHMENTS_ENABLED, this.attachmentsEnabled).putBoolean(APP_GIFS_ENABLED, this.gifsEnabled).putBoolean(APP_AUDIO_ENABLED, this.audioEnabled).putBoolean(APP_METRICS_ENABLED, this.metricsEnabled).putBoolean(APP_RECEIVED_FROM_SERVER, true).putBoolean(APP_BACKGROUND_REQUESTS_ENABLED, this.backgroundRequestsEnabled).putBoolean(APP_PRIMARY_COLOR_RENDER_DARK_TEXT, this.primaryColorRenderDarkText).putBoolean(APP_SECONDARY_COLOR_RENDER_DARK_TEXT, this.secondaryColorRenderDarkText).putBoolean(APP_HELP_CENTER_COLOR_RENDER_DARK_TEXT, this.helpCenterColorRenderDarkText).putString(APP_HELP_CENTER_URL, this.helpCenterUrl).putStringSet(APP_FEATURES, this.features).apply();
                dVar.post(new ConfigUpdateEvent());
            }
        }
    }
}
