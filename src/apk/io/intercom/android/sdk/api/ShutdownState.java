package io.intercom.android.sdk.api;

import android.content.Context;
import android.content.SharedPreferences;
import io.intercom.android.sdk.commons.utilities.DeviceUtils;
import io.intercom.android.sdk.commons.utilities.TimeProvider;
import io.intercom.android.sdk.identity.AppIdentity;
import io.intercom.android.sdk.utilities.PreferenceKeys;

public class ShutdownState {
    private static final String PREFS_SHUTDOWN_EXPIRY = "ShutdownExpiry";
    private static final String PREFS_SHUTDOWN_FINGERPRINT = "ShutdownFingerprint";
    private static final String PREFS_SHUTDOWN_REASON = "ShutdownReason";
    private final AppIdentity appIdentity;
    private final Context context;
    private final SharedPreferences prefs;
    long shutdownExpiry;
    String shutdownFingerprint;
    private String shutdownReason = this.prefs.getString(PREFS_SHUTDOWN_REASON, "");
    private final TimeProvider timeProvider;

    public ShutdownState(Context context2, AppIdentity appIdentity2, TimeProvider timeProvider2) {
        this.context = context2;
        this.appIdentity = appIdentity2;
        this.prefs = context2.getSharedPreferences(PreferenceKeys.INTERCOM_SHUTDOWN_PREFS, 0);
        this.timeProvider = timeProvider2;
        this.shutdownExpiry = this.prefs.getLong(PREFS_SHUTDOWN_EXPIRY, timeProvider2.currentTimeMillis());
        this.shutdownFingerprint = this.prefs.getString(PREFS_SHUTDOWN_FINGERPRINT, generateAppFingerprint(context2, appIdentity2));
    }

    private static String generateAppFingerprint(Context context2, AppIdentity appIdentity2) {
        StringBuilder sb = new StringBuilder();
        sb.append(context2.getPackageName());
        String str = "-";
        sb.append(str);
        sb.append(DeviceUtils.getAppVersion(context2));
        sb.append(str);
        sb.append(appIdentity2.appId());
        sb.append(str);
        sb.append("5.3.2");
        return sb.toString();
    }

    private void persistCachedAttributes() {
        this.prefs.edit().putString(PREFS_SHUTDOWN_FINGERPRINT, this.shutdownFingerprint).putString(PREFS_SHUTDOWN_REASON, this.shutdownReason).putLong(PREFS_SHUTDOWN_EXPIRY, this.shutdownExpiry).apply();
    }

    public boolean canSendNetworkRequests() {
        boolean z = this.shutdownExpiry <= this.timeProvider.currentTimeMillis();
        boolean equals = this.shutdownFingerprint.equals(generateAppFingerprint(this.context, this.appIdentity));
        if (z || !equals) {
            return true;
        }
        return false;
    }

    public String getShutdownReason() {
        return this.shutdownReason;
    }

    public void updateShutdownState(long j2, String str) {
        this.shutdownExpiry = this.timeProvider.currentTimeMillis() + j2;
        this.shutdownReason = str;
        this.shutdownFingerprint = generateAppFingerprint(this.context, this.appIdentity);
        persistCachedAttributes();
    }
}
