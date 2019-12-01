package io.intercom.android.sdk.models;

import io.intercom.android.sdk.nexus.NexusConfig;
import io.intercom.android.sdk.utilities.NullSafety;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public abstract class Config {
    public static final long DEFAULT_BATCH_USER_UPDATE_PERIOD_MS = TimeUnit.SECONDS.toMillis(1);
    public static final long DEFAULT_CACHE_MAX_AGE_MS = TimeUnit.MINUTES.toMillis(5);
    public static final long DEFAULT_PING_DELAY_MS = TimeUnit.SECONDS.toMillis(1);
    public static final int DEFAULT_RATE_LIMIT_COUNT = 100;
    public static final long DEFAULT_RATE_LIMIT_PERIOD_MS = TimeUnit.MINUTES.toMillis(1);
    public static final long DEFAULT_SESSION_TIMEOUT_MS = TimeUnit.SECONDS.toMillis(20);
    public static final long DEFAULT_SOFT_RESET_TIMEOUT_MS = TimeUnit.SECONDS.toMillis(1);
    public static final Config NULL = new Builder().build();

    public static final class Builder {
        Boolean audio_enabled;
        Boolean background_requests_enabled;
        String base_color;
        Float batch_user_update_period;
        Set<String> features;
        String help_center_base_color;
        Boolean help_center_color_render_dark_text;
        String help_center_url;
        Integer home_screen_card_count;
        Boolean identity_verification_enabled;
        Boolean inbound_messages;
        Boolean is_first_request;
        Integer local_rate_limit;
        Long local_rate_limit_period;
        String locale;
        String messenger4_background;
        String messenger_background;
        String messenger_logo_url;
        Boolean metrics_enabled;
        String name;
        Long new_session_threshold;
        Float ping_delay;
        Boolean primary_color_render_dark_text;
        io.intercom.android.sdk.nexus.NexusConfig.Builder real_time_config;
        String secondary_color;
        Boolean secondary_color_render_dark_text;
        Boolean show_powered_by;
        Long soft_reset_timeout;
        String team_greeting;
        String team_intro;
        Boolean user_conversation_attachments_enabled;
        Boolean user_conversation_gifs_enabled;
        Long user_update_dup_cache_max_age;
        String welcome_message_plain_text;

        public Config build() {
            long j2;
            long j3;
            long j4;
            long j5;
            long j6;
            long j7;
            Long l2 = this.local_rate_limit_period;
            if (l2 == null) {
                j2 = Config.DEFAULT_RATE_LIMIT_PERIOD_MS;
            } else {
                j2 = TimeUnit.SECONDS.toMillis(l2.longValue());
            }
            long j8 = j2;
            Integer num = this.local_rate_limit;
            int intValue = num == null ? 100 : num.intValue();
            Float f2 = this.batch_user_update_period;
            if (f2 == null) {
                j3 = Config.DEFAULT_BATCH_USER_UPDATE_PERIOD_MS;
            } else {
                j3 = (long) (f2.floatValue() * 1000.0f);
            }
            long j9 = j3;
            Long l3 = this.user_update_dup_cache_max_age;
            if (l3 == null) {
                j4 = Config.DEFAULT_CACHE_MAX_AGE_MS;
            } else {
                j4 = TimeUnit.SECONDS.toMillis(l3.longValue());
            }
            long j10 = j4;
            Long l4 = this.soft_reset_timeout;
            if (l4 == null) {
                j5 = Config.DEFAULT_SOFT_RESET_TIMEOUT_MS;
            } else {
                j5 = TimeUnit.SECONDS.toMillis(l4.longValue());
            }
            long j11 = j5;
            Long l5 = this.new_session_threshold;
            if (l5 == null) {
                j6 = Config.DEFAULT_SESSION_TIMEOUT_MS;
            } else {
                j6 = TimeUnit.SECONDS.toMillis(l5.longValue());
            }
            long j12 = j6;
            Float f3 = this.ping_delay;
            if (f3 == null) {
                j7 = Config.DEFAULT_PING_DELAY_MS;
            } else {
                j7 = (long) (f3.floatValue() * 1000.0f);
            }
            long j13 = j7;
            Integer num2 = this.home_screen_card_count;
            int intValue2 = num2 == null ? 0 : num2.intValue();
            io.intercom.android.sdk.nexus.NexusConfig.Builder builder = this.real_time_config;
            NexusConfig nexusConfig = builder == null ? new NexusConfig() : builder.build();
            Set<String> set = this.features;
            if (set == null) {
                set = Collections.emptySet();
            }
            AutoValue_Config autoValue_Config = r3;
            AutoValue_Config autoValue_Config2 = new AutoValue_Config(NullSafety.valueOrEmpty(this.name), this.base_color, this.secondary_color, NullSafety.valueOrEmpty(this.welcome_message_plain_text), NullSafety.valueOrEmpty(this.messenger_background), NullSafety.valueOrEmpty(this.messenger4_background), NullSafety.valueOrEmpty(this.locale), NullSafety.valueOrEmpty(this.messenger_logo_url), NullSafety.valueOrEmpty(this.team_intro), NullSafety.valueOrEmpty(this.team_greeting), NullSafety.valueOrDefault(this.is_first_request, false), NullSafety.valueOrDefault(this.inbound_messages, false), NullSafety.valueOrDefault(this.user_conversation_attachments_enabled, true), NullSafety.valueOrDefault(this.user_conversation_gifs_enabled, true), NullSafety.valueOrDefault(this.show_powered_by, true), NullSafety.valueOrDefault(this.audio_enabled, true), NullSafety.valueOrDefault(this.metrics_enabled, true), NullSafety.valueOrDefault(this.background_requests_enabled, true), NullSafety.valueOrDefault(this.primary_color_render_dark_text, false), NullSafety.valueOrDefault(this.secondary_color_render_dark_text, false), NullSafety.valueOrDefault(this.help_center_color_render_dark_text, false), j8, intValue, j9, j10, j11, j12, j13, intValue2, nexusConfig, NullSafety.valueOrEmpty(this.help_center_url), this.help_center_base_color, set, NullSafety.valueOrDefault(this.identity_verification_enabled, false));
            return autoValue_Config;
        }
    }

    public abstract long getBatchUserUpdatePeriod();

    public abstract Set<String> getFeatures();

    public abstract String getHelpCenterBaseColor();

    public abstract String getHelpCenterUrl();

    public abstract int getHomeScreenCardCount();

    public abstract boolean getIdentityVerificationEnabled();

    public abstract String getLocale();

    public abstract String getMessenger4Background();

    public abstract String getMessengerBackground();

    public abstract String getMessengerLogoUrl();

    public abstract String getName();

    public abstract long getNewSessionThreshold();

    public abstract long getPingDelayMs();

    public abstract String getPrimaryColor();

    public abstract int getRateLimitCount();

    public abstract long getRateLimitPeriod();

    public abstract NexusConfig getRealTimeConfig();

    public abstract String getSecondaryColor();

    public abstract long getSoftResetTimeout();

    public abstract String getTeamGreeting();

    public abstract String getTeamIntro();

    public abstract long getUserUpdateCacheMaxAge();

    public abstract String getWelcomeMessage();

    public abstract boolean isAttachmentsEnabled();

    public abstract boolean isAudioEnabled();

    public abstract boolean isBackgroundRequestsEnabled();

    public abstract boolean isFirstRequest();

    public abstract boolean isGifsEnabled();

    public abstract boolean isHelpCenterColorRenderDarkText();

    public abstract boolean isInboundMessages();

    public abstract boolean isMetricsEnabled();

    public abstract boolean isPrimaryColorRenderDarkText();

    public abstract boolean isSecondaryColorRenderDarkText();

    public abstract boolean isShowPoweredBy();
}
