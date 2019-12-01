package com.crashlytics.android;

import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.beta.Beta;
import com.crashlytics.android.core.CrashlyticsCore;
import com.crashlytics.android.core.CrashlyticsListener;
import com.crashlytics.android.core.PinningInfoProvider;
import io.fabric.sdk.android.a.b.o;
import io.fabric.sdk.android.f;
import io.fabric.sdk.android.l;
import io.fabric.sdk.android.m;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Crashlytics extends l<Void> implements m {
    public static final String TAG = "Crashlytics";
    public final Answers answers;
    public final Beta beta;
    public final CrashlyticsCore core;
    public final Collection<? extends l> kits;

    public static class Builder {
        private Answers answers;
        private Beta beta;
        private CrashlyticsCore core;
        private com.crashlytics.android.core.CrashlyticsCore.Builder coreBuilder;

        private synchronized com.crashlytics.android.core.CrashlyticsCore.Builder getCoreBuilder() {
            if (this.coreBuilder == null) {
                this.coreBuilder = new com.crashlytics.android.core.CrashlyticsCore.Builder();
            }
            return this.coreBuilder;
        }

        public Builder answers(Answers answers2) {
            if (answers2 == null) {
                throw new NullPointerException("Answers Kit must not be null.");
            } else if (this.answers == null) {
                this.answers = answers2;
                return this;
            } else {
                throw new IllegalStateException("Answers Kit already set.");
            }
        }

        public Builder beta(Beta beta2) {
            if (beta2 == null) {
                throw new NullPointerException("Beta Kit must not be null.");
            } else if (this.beta == null) {
                this.beta = beta2;
                return this;
            } else {
                throw new IllegalStateException("Beta Kit already set.");
            }
        }

        public Crashlytics build() {
            com.crashlytics.android.core.CrashlyticsCore.Builder builder = this.coreBuilder;
            if (builder != null) {
                if (this.core == null) {
                    this.core = builder.build();
                } else {
                    throw new IllegalStateException("Must not use Deprecated methods delay(), disabled(), listener(), pinningInfoProvider() with core()");
                }
            }
            if (this.answers == null) {
                this.answers = new Answers();
            }
            if (this.beta == null) {
                this.beta = new Beta();
            }
            if (this.core == null) {
                this.core = new CrashlyticsCore();
            }
            return new Crashlytics(this.answers, this.beta, this.core);
        }

        public Builder core(CrashlyticsCore crashlyticsCore) {
            if (crashlyticsCore == null) {
                throw new NullPointerException("CrashlyticsCore Kit must not be null.");
            } else if (this.core == null) {
                this.core = crashlyticsCore;
                return this;
            } else {
                throw new IllegalStateException("CrashlyticsCore Kit already set.");
            }
        }

        @Deprecated
        public Builder delay(float f2) {
            getCoreBuilder().delay(f2);
            return this;
        }

        @Deprecated
        public Builder disabled(boolean z) {
            getCoreBuilder().disabled(z);
            return this;
        }

        @Deprecated
        public Builder listener(CrashlyticsListener crashlyticsListener) {
            getCoreBuilder().listener(crashlyticsListener);
            return this;
        }

        @Deprecated
        public Builder pinningInfo(PinningInfoProvider pinningInfoProvider) {
            getCoreBuilder().pinningInfo(pinningInfoProvider);
            return this;
        }
    }

    public Crashlytics() {
        this(new Answers(), new Beta(), new CrashlyticsCore());
    }

    private static void checkInitialized() {
        if (getInstance() == null) {
            throw new IllegalStateException("Crashlytics must be initialized by calling Fabric.with(Context) prior to calling Crashlytics.getInstance()");
        }
    }

    public static Crashlytics getInstance() {
        return (Crashlytics) f.a(Crashlytics.class);
    }

    public static PinningInfoProvider getPinningInfoProvider() {
        checkInitialized();
        return getInstance().core.getPinningInfoProvider();
    }

    private static boolean isCrashlyticsCollectionEnabled() {
        checkInitialized();
        return o.a(getInstance().getContext()).a();
    }

    public static void log(String str) {
        checkInitialized();
        getInstance().core.log(str);
    }

    public static void logException(Throwable th) {
        checkInitialized();
        getInstance().core.logException(th);
    }

    public static void setBool(String str, boolean z) {
        checkInitialized();
        getInstance().core.setBool(str, z);
    }

    private static void setCrashlyticsCollectionEnabled(boolean z) {
        checkInitialized();
        o.a(getInstance().getContext()).a(z);
    }

    public static void setDouble(String str, double d2) {
        checkInitialized();
        getInstance().core.setDouble(str, d2);
    }

    public static void setFloat(String str, float f2) {
        checkInitialized();
        getInstance().core.setFloat(str, f2);
    }

    public static void setInt(String str, int i2) {
        checkInitialized();
        getInstance().core.setInt(str, i2);
    }

    public static void setLong(String str, long j2) {
        checkInitialized();
        getInstance().core.setLong(str, j2);
    }

    @Deprecated
    public static void setPinningInfoProvider(PinningInfoProvider pinningInfoProvider) {
        f.e().a(TAG, "Use of Crashlytics.setPinningInfoProvider is deprecated");
    }

    public static void setString(String str, String str2) {
        checkInitialized();
        getInstance().core.setString(str, str2);
    }

    public static void setUserEmail(String str) {
        checkInitialized();
        getInstance().core.setUserEmail(str);
    }

    public static void setUserIdentifier(String str) {
        checkInitialized();
        getInstance().core.setUserIdentifier(str);
    }

    public static void setUserName(String str) {
        checkInitialized();
        getInstance().core.setUserName(str);
    }

    public void crash() {
        this.core.crash();
    }

    /* access modifiers changed from: protected */
    public Void doInBackground() {
        return null;
    }

    @Deprecated
    public boolean getDebugMode() {
        f.e().a(TAG, "Use of Crashlytics.getDebugMode is deprecated.");
        getFabric();
        return f.g();
    }

    public String getIdentifier() {
        return "com.crashlytics.sdk.android:crashlytics";
    }

    public Collection<? extends l> getKits() {
        return this.kits;
    }

    public String getVersion() {
        return "2.9.9.32";
    }

    @Deprecated
    public void setDebugMode(boolean z) {
        f.e().a(TAG, "Use of Crashlytics.setDebugMode is deprecated.");
    }

    @Deprecated
    public synchronized void setListener(CrashlyticsListener crashlyticsListener) {
        this.core.setListener(crashlyticsListener);
    }

    public boolean verifyPinning(URL url) {
        return this.core.verifyPinning(url);
    }

    Crashlytics(Answers answers2, Beta beta2, CrashlyticsCore crashlyticsCore) {
        this.answers = answers2;
        this.beta = beta2;
        this.core = crashlyticsCore;
        this.kits = Collections.unmodifiableCollection(Arrays.asList(new l[]{answers2, beta2, crashlyticsCore}));
    }

    public static void log(int i2, String str, String str2) {
        checkInitialized();
        getInstance().core.log(i2, str, str2);
    }
}
