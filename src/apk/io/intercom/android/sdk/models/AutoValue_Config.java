package io.intercom.android.sdk.models;

import io.intercom.android.sdk.nexus.NexusConfig;
import java.util.Set;

final class AutoValue_Config extends Config {
    private final boolean attachmentsEnabled;
    private final boolean audioEnabled;
    private final boolean backgroundRequestsEnabled;
    private final long batchUserUpdatePeriod;
    private final Set<String> features;
    private final boolean firstRequest;
    private final boolean gifsEnabled;
    private final String helpCenterBaseColor;
    private final boolean helpCenterColorRenderDarkText;
    private final String helpCenterUrl;
    private final int homeScreenCardCount;
    private final boolean identityVerificationEnabled;
    private final boolean inboundMessages;
    private final String locale;
    private final String messenger4Background;
    private final String messengerBackground;
    private final String messengerLogoUrl;
    private final boolean metricsEnabled;
    private final String name;
    private final long newSessionThreshold;
    private final long pingDelayMs;
    private final String primaryColor;
    private final boolean primaryColorRenderDarkText;
    private final int rateLimitCount;
    private final long rateLimitPeriod;
    private final NexusConfig realTimeConfig;
    private final String secondaryColor;
    private final boolean secondaryColorRenderDarkText;
    private final boolean showPoweredBy;
    private final long softResetTimeout;
    private final String teamGreeting;
    private final String teamIntro;
    private final long userUpdateCacheMaxAge;
    private final String welcomeMessage;

    AutoValue_Config(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, long j2, int i2, long j3, long j4, long j5, long j6, long j7, int i3, NexusConfig nexusConfig, String str11, String str12, Set<String> set, boolean z12) {
        String str13 = str;
        String str14 = str4;
        String str15 = str5;
        String str16 = str6;
        String str17 = str7;
        String str18 = str8;
        String str19 = str9;
        String str20 = str10;
        NexusConfig nexusConfig2 = nexusConfig;
        String str21 = str11;
        Set<String> set2 = set;
        if (str13 != null) {
            this.name = str13;
            this.primaryColor = str2;
            this.secondaryColor = str3;
            if (str14 != null) {
                this.welcomeMessage = str14;
                if (str15 != null) {
                    this.messengerBackground = str15;
                    if (str16 != null) {
                        this.messenger4Background = str16;
                        if (str17 != null) {
                            this.locale = str17;
                            if (str18 != null) {
                                this.messengerLogoUrl = str18;
                                if (str19 != null) {
                                    this.teamIntro = str19;
                                    if (str20 != null) {
                                        this.teamGreeting = str20;
                                        this.firstRequest = z;
                                        this.inboundMessages = z2;
                                        this.attachmentsEnabled = z3;
                                        this.gifsEnabled = z4;
                                        this.showPoweredBy = z5;
                                        this.audioEnabled = z6;
                                        this.metricsEnabled = z7;
                                        this.backgroundRequestsEnabled = z8;
                                        this.primaryColorRenderDarkText = z9;
                                        this.secondaryColorRenderDarkText = z10;
                                        this.helpCenterColorRenderDarkText = z11;
                                        this.rateLimitPeriod = j2;
                                        this.rateLimitCount = i2;
                                        this.batchUserUpdatePeriod = j3;
                                        this.userUpdateCacheMaxAge = j4;
                                        this.softResetTimeout = j5;
                                        this.newSessionThreshold = j6;
                                        this.pingDelayMs = j7;
                                        this.homeScreenCardCount = i3;
                                        if (nexusConfig2 != null) {
                                            this.realTimeConfig = nexusConfig2;
                                            if (str21 != null) {
                                                this.helpCenterUrl = str21;
                                                this.helpCenterBaseColor = str12;
                                                if (set2 != null) {
                                                    this.features = set2;
                                                    this.identityVerificationEnabled = z12;
                                                    return;
                                                }
                                                throw new NullPointerException("Null features");
                                            }
                                            throw new NullPointerException("Null helpCenterUrl");
                                        }
                                        throw new NullPointerException("Null realTimeConfig");
                                    }
                                    throw new NullPointerException("Null teamGreeting");
                                }
                                throw new NullPointerException("Null teamIntro");
                            }
                            throw new NullPointerException("Null messengerLogoUrl");
                        }
                        throw new NullPointerException("Null locale");
                    }
                    throw new NullPointerException("Null messenger4Background");
                }
                throw new NullPointerException("Null messengerBackground");
            }
            throw new NullPointerException("Null welcomeMessage");
        }
        throw new NullPointerException("Null name");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0178, code lost:
        if (r7.identityVerificationEnabled == r8.getIdentityVerificationEnabled()) goto L_0x017c;
     */
    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Config)) {
            return false;
        }
        Config config = (Config) obj;
        if (this.name.equals(config.getName())) {
            String str = this.primaryColor;
            if (str != null ? str.equals(config.getPrimaryColor()) : config.getPrimaryColor() == null) {
                String str2 = this.secondaryColor;
                if (str2 != null ? str2.equals(config.getSecondaryColor()) : config.getSecondaryColor() == null) {
                    if (this.welcomeMessage.equals(config.getWelcomeMessage()) && this.messengerBackground.equals(config.getMessengerBackground()) && this.messenger4Background.equals(config.getMessenger4Background()) && this.locale.equals(config.getLocale()) && this.messengerLogoUrl.equals(config.getMessengerLogoUrl()) && this.teamIntro.equals(config.getTeamIntro()) && this.teamGreeting.equals(config.getTeamGreeting()) && this.firstRequest == config.isFirstRequest() && this.inboundMessages == config.isInboundMessages() && this.attachmentsEnabled == config.isAttachmentsEnabled() && this.gifsEnabled == config.isGifsEnabled() && this.showPoweredBy == config.isShowPoweredBy() && this.audioEnabled == config.isAudioEnabled() && this.metricsEnabled == config.isMetricsEnabled() && this.backgroundRequestsEnabled == config.isBackgroundRequestsEnabled() && this.primaryColorRenderDarkText == config.isPrimaryColorRenderDarkText() && this.secondaryColorRenderDarkText == config.isSecondaryColorRenderDarkText() && this.helpCenterColorRenderDarkText == config.isHelpCenterColorRenderDarkText() && this.rateLimitPeriod == config.getRateLimitPeriod() && this.rateLimitCount == config.getRateLimitCount() && this.batchUserUpdatePeriod == config.getBatchUserUpdatePeriod() && this.userUpdateCacheMaxAge == config.getUserUpdateCacheMaxAge() && this.softResetTimeout == config.getSoftResetTimeout() && this.newSessionThreshold == config.getNewSessionThreshold() && this.pingDelayMs == config.getPingDelayMs() && this.homeScreenCardCount == config.getHomeScreenCardCount() && this.realTimeConfig.equals(config.getRealTimeConfig()) && this.helpCenterUrl.equals(config.getHelpCenterUrl())) {
                        String str3 = this.helpCenterBaseColor;
                        if (str3 != null ? str3.equals(config.getHelpCenterBaseColor()) : config.getHelpCenterBaseColor() == null) {
                            if (this.features.equals(config.getFeatures())) {
                            }
                        }
                    }
                }
            }
        }
        z = false;
        return z;
    }

    public long getBatchUserUpdatePeriod() {
        return this.batchUserUpdatePeriod;
    }

    public Set<String> getFeatures() {
        return this.features;
    }

    public String getHelpCenterBaseColor() {
        return this.helpCenterBaseColor;
    }

    public String getHelpCenterUrl() {
        return this.helpCenterUrl;
    }

    public int getHomeScreenCardCount() {
        return this.homeScreenCardCount;
    }

    public boolean getIdentityVerificationEnabled() {
        return this.identityVerificationEnabled;
    }

    public String getLocale() {
        return this.locale;
    }

    public String getMessenger4Background() {
        return this.messenger4Background;
    }

    public String getMessengerBackground() {
        return this.messengerBackground;
    }

    public String getMessengerLogoUrl() {
        return this.messengerLogoUrl;
    }

    public String getName() {
        return this.name;
    }

    public long getNewSessionThreshold() {
        return this.newSessionThreshold;
    }

    public long getPingDelayMs() {
        return this.pingDelayMs;
    }

    public String getPrimaryColor() {
        return this.primaryColor;
    }

    public int getRateLimitCount() {
        return this.rateLimitCount;
    }

    public long getRateLimitPeriod() {
        return this.rateLimitPeriod;
    }

    public NexusConfig getRealTimeConfig() {
        return this.realTimeConfig;
    }

    public String getSecondaryColor() {
        return this.secondaryColor;
    }

    public long getSoftResetTimeout() {
        return this.softResetTimeout;
    }

    public String getTeamGreeting() {
        return this.teamGreeting;
    }

    public String getTeamIntro() {
        return this.teamIntro;
    }

    public long getUserUpdateCacheMaxAge() {
        return this.userUpdateCacheMaxAge;
    }

    public String getWelcomeMessage() {
        return this.welcomeMessage;
    }

    public int hashCode() {
        int hashCode = (this.name.hashCode() ^ 1000003) * 1000003;
        String str = this.primaryColor;
        int i2 = 0;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.secondaryColor;
        int i3 = 1231;
        int hashCode3 = (((((((((((((((((((((((((((((((((((((hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003) ^ this.welcomeMessage.hashCode()) * 1000003) ^ this.messengerBackground.hashCode()) * 1000003) ^ this.messenger4Background.hashCode()) * 1000003) ^ this.locale.hashCode()) * 1000003) ^ this.messengerLogoUrl.hashCode()) * 1000003) ^ this.teamIntro.hashCode()) * 1000003) ^ this.teamGreeting.hashCode()) * 1000003) ^ (this.firstRequest ? 1231 : 1237)) * 1000003) ^ (this.inboundMessages ? 1231 : 1237)) * 1000003) ^ (this.attachmentsEnabled ? 1231 : 1237)) * 1000003) ^ (this.gifsEnabled ? 1231 : 1237)) * 1000003) ^ (this.showPoweredBy ? 1231 : 1237)) * 1000003) ^ (this.audioEnabled ? 1231 : 1237)) * 1000003) ^ (this.metricsEnabled ? 1231 : 1237)) * 1000003) ^ (this.backgroundRequestsEnabled ? 1231 : 1237)) * 1000003) ^ (this.primaryColorRenderDarkText ? 1231 : 1237)) * 1000003) ^ (this.secondaryColorRenderDarkText ? 1231 : 1237)) * 1000003) ^ (this.helpCenterColorRenderDarkText ? 1231 : 1237)) * 1000003;
        long j2 = this.rateLimitPeriod;
        int i4 = (((hashCode3 ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.rateLimitCount) * 1000003;
        long j3 = this.batchUserUpdatePeriod;
        int i5 = (i4 ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        long j4 = this.userUpdateCacheMaxAge;
        int i6 = (i5 ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003;
        long j5 = this.softResetTimeout;
        int i7 = (i6 ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003;
        long j6 = this.newSessionThreshold;
        int i8 = (i7 ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003;
        long j7 = this.pingDelayMs;
        int hashCode4 = (((((((i8 ^ ((int) (j7 ^ (j7 >>> 32)))) * 1000003) ^ this.homeScreenCardCount) * 1000003) ^ this.realTimeConfig.hashCode()) * 1000003) ^ this.helpCenterUrl.hashCode()) * 1000003;
        String str3 = this.helpCenterBaseColor;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int hashCode5 = (((hashCode4 ^ i2) * 1000003) ^ this.features.hashCode()) * 1000003;
        if (!this.identityVerificationEnabled) {
            i3 = 1237;
        }
        return hashCode5 ^ i3;
    }

    public boolean isAttachmentsEnabled() {
        return this.attachmentsEnabled;
    }

    public boolean isAudioEnabled() {
        return this.audioEnabled;
    }

    public boolean isBackgroundRequestsEnabled() {
        return this.backgroundRequestsEnabled;
    }

    public boolean isFirstRequest() {
        return this.firstRequest;
    }

    public boolean isGifsEnabled() {
        return this.gifsEnabled;
    }

    public boolean isHelpCenterColorRenderDarkText() {
        return this.helpCenterColorRenderDarkText;
    }

    public boolean isInboundMessages() {
        return this.inboundMessages;
    }

    public boolean isMetricsEnabled() {
        return this.metricsEnabled;
    }

    public boolean isPrimaryColorRenderDarkText() {
        return this.primaryColorRenderDarkText;
    }

    public boolean isSecondaryColorRenderDarkText() {
        return this.secondaryColorRenderDarkText;
    }

    public boolean isShowPoweredBy() {
        return this.showPoweredBy;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Config{name=");
        sb.append(this.name);
        sb.append(", primaryColor=");
        sb.append(this.primaryColor);
        sb.append(", secondaryColor=");
        sb.append(this.secondaryColor);
        sb.append(", welcomeMessage=");
        sb.append(this.welcomeMessage);
        sb.append(", messengerBackground=");
        sb.append(this.messengerBackground);
        sb.append(", messenger4Background=");
        sb.append(this.messenger4Background);
        sb.append(", locale=");
        sb.append(this.locale);
        sb.append(", messengerLogoUrl=");
        sb.append(this.messengerLogoUrl);
        sb.append(", teamIntro=");
        sb.append(this.teamIntro);
        sb.append(", teamGreeting=");
        sb.append(this.teamGreeting);
        sb.append(", firstRequest=");
        sb.append(this.firstRequest);
        sb.append(", inboundMessages=");
        sb.append(this.inboundMessages);
        sb.append(", attachmentsEnabled=");
        sb.append(this.attachmentsEnabled);
        sb.append(", gifsEnabled=");
        sb.append(this.gifsEnabled);
        sb.append(", showPoweredBy=");
        sb.append(this.showPoweredBy);
        sb.append(", audioEnabled=");
        sb.append(this.audioEnabled);
        sb.append(", metricsEnabled=");
        sb.append(this.metricsEnabled);
        sb.append(", backgroundRequestsEnabled=");
        sb.append(this.backgroundRequestsEnabled);
        sb.append(", primaryColorRenderDarkText=");
        sb.append(this.primaryColorRenderDarkText);
        sb.append(", secondaryColorRenderDarkText=");
        sb.append(this.secondaryColorRenderDarkText);
        sb.append(", helpCenterColorRenderDarkText=");
        sb.append(this.helpCenterColorRenderDarkText);
        sb.append(", rateLimitPeriod=");
        sb.append(this.rateLimitPeriod);
        sb.append(", rateLimitCount=");
        sb.append(this.rateLimitCount);
        sb.append(", batchUserUpdatePeriod=");
        sb.append(this.batchUserUpdatePeriod);
        sb.append(", userUpdateCacheMaxAge=");
        sb.append(this.userUpdateCacheMaxAge);
        sb.append(", softResetTimeout=");
        sb.append(this.softResetTimeout);
        sb.append(", newSessionThreshold=");
        sb.append(this.newSessionThreshold);
        sb.append(", pingDelayMs=");
        sb.append(this.pingDelayMs);
        sb.append(", homeScreenCardCount=");
        sb.append(this.homeScreenCardCount);
        sb.append(", realTimeConfig=");
        sb.append(this.realTimeConfig);
        sb.append(", helpCenterUrl=");
        sb.append(this.helpCenterUrl);
        sb.append(", helpCenterBaseColor=");
        sb.append(this.helpCenterBaseColor);
        sb.append(", features=");
        sb.append(this.features);
        sb.append(", identityVerificationEnabled=");
        sb.append(this.identityVerificationEnabled);
        sb.append("}");
        return sb.toString();
    }
}
