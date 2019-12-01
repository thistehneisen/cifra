package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.measurement.internal.C0538lc;
import com.google.android.gms.measurement.internal.C0572sc;
import com.google.android.gms.measurement.internal.Mc;
import com.google.android.gms.measurement.internal.Ob;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Deprecated
public class AppMeasurement {

    /* renamed from: a reason: collision with root package name */
    private static volatile AppMeasurement f5486a;

    /* renamed from: b reason: collision with root package name */
    private final Ob f5487b;

    /* renamed from: c reason: collision with root package name */
    private final Mc f5488c;

    /* renamed from: d reason: collision with root package name */
    private final boolean f5489d;

    public static class ConditionalUserProperty {
        @Keep
        public boolean mActive;
        @Keep
        public String mAppId;
        @Keep
        public long mCreationTimestamp;
        @Keep
        public String mExpiredEventName;
        @Keep
        public Bundle mExpiredEventParams;
        @Keep
        public String mName;
        @Keep
        public String mOrigin;
        @Keep
        public long mTimeToLive;
        @Keep
        public String mTimedOutEventName;
        @Keep
        public Bundle mTimedOutEventParams;
        @Keep
        public String mTriggerEventName;
        @Keep
        public long mTriggerTimeout;
        @Keep
        public String mTriggeredEventName;
        @Keep
        public Bundle mTriggeredEventParams;
        @Keep
        public long mTriggeredTimestamp;
        @Keep
        public Object mValue;

        public ConditionalUserProperty() {
        }

        /* access modifiers changed from: private */
        public final Bundle a() {
            Bundle bundle = new Bundle();
            String str = this.mAppId;
            if (str != null) {
                bundle.putString("app_id", str);
            }
            String str2 = this.mOrigin;
            if (str2 != null) {
                bundle.putString("origin", str2);
            }
            String str3 = this.mName;
            if (str3 != null) {
                bundle.putString("name", str3);
            }
            Object obj = this.mValue;
            if (obj != null) {
                C0538lc.a(bundle, obj);
            }
            String str4 = this.mTriggerEventName;
            if (str4 != null) {
                bundle.putString("trigger_event_name", str4);
            }
            bundle.putLong("trigger_timeout", this.mTriggerTimeout);
            String str5 = this.mTimedOutEventName;
            if (str5 != null) {
                bundle.putString("timed_out_event_name", str5);
            }
            Bundle bundle2 = this.mTimedOutEventParams;
            if (bundle2 != null) {
                bundle.putBundle("timed_out_event_params", bundle2);
            }
            String str6 = this.mTriggeredEventName;
            if (str6 != null) {
                bundle.putString("triggered_event_name", str6);
            }
            Bundle bundle3 = this.mTriggeredEventParams;
            if (bundle3 != null) {
                bundle.putBundle("triggered_event_params", bundle3);
            }
            bundle.putLong("time_to_live", this.mTimeToLive);
            String str7 = this.mExpiredEventName;
            if (str7 != null) {
                bundle.putString("expired_event_name", str7);
            }
            Bundle bundle4 = this.mExpiredEventParams;
            if (bundle4 != null) {
                bundle.putBundle("expired_event_params", bundle4);
            }
            bundle.putLong("creation_timestamp", this.mCreationTimestamp);
            bundle.putBoolean("active", this.mActive);
            bundle.putLong("triggered_timestamp", this.mTriggeredTimestamp);
            return bundle;
        }

        private ConditionalUserProperty(Bundle bundle) {
            q.a(bundle);
            this.mAppId = (String) C0538lc.a(bundle, "app_id", String.class, null);
            this.mOrigin = (String) C0538lc.a(bundle, "origin", String.class, null);
            this.mName = (String) C0538lc.a(bundle, "name", String.class, null);
            this.mValue = C0538lc.a(bundle, "value", Object.class, null);
            this.mTriggerEventName = (String) C0538lc.a(bundle, "trigger_event_name", String.class, null);
            Long valueOf = Long.valueOf(0);
            this.mTriggerTimeout = ((Long) C0538lc.a(bundle, "trigger_timeout", Long.class, valueOf)).longValue();
            this.mTimedOutEventName = (String) C0538lc.a(bundle, "timed_out_event_name", String.class, null);
            this.mTimedOutEventParams = (Bundle) C0538lc.a(bundle, "timed_out_event_params", Bundle.class, null);
            this.mTriggeredEventName = (String) C0538lc.a(bundle, "triggered_event_name", String.class, null);
            this.mTriggeredEventParams = (Bundle) C0538lc.a(bundle, "triggered_event_params", Bundle.class, null);
            this.mTimeToLive = ((Long) C0538lc.a(bundle, "time_to_live", Long.class, valueOf)).longValue();
            this.mExpiredEventName = (String) C0538lc.a(bundle, "expired_event_name", String.class, null);
            this.mExpiredEventParams = (Bundle) C0538lc.a(bundle, "expired_event_params", Bundle.class, null);
        }
    }

    public interface OnEventListener extends C0572sc {
        void onEvent(String str, String str2, Bundle bundle, long j2);
    }

    private AppMeasurement(Ob ob) {
        q.a(ob);
        this.f5487b = ob;
        this.f5488c = null;
        this.f5489d = false;
    }

    private static AppMeasurement a(Context context, String str, String str2) {
        if (f5486a == null) {
            synchronized (AppMeasurement.class) {
                if (f5486a == null) {
                    Mc b2 = b(context, null);
                    if (b2 != null) {
                        f5486a = new AppMeasurement(b2);
                    } else {
                        f5486a = new AppMeasurement(Ob.a(context, null, null, null));
                    }
                }
            }
        }
        return f5486a;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    private static Mc b(Context context, Bundle bundle) {
        try {
            return (Mc) Class.forName("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod("getScionFrontendApiImplementation", new Class[]{Context.class, Bundle.class}).invoke(null, new Object[]{context, bundle});
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    @Deprecated
    @Keep
    public static AppMeasurement getInstance(Context context) {
        return a(context, (String) null, (String) null);
    }

    @Keep
    public void beginAdUnitExposure(String str) {
        if (this.f5489d) {
            this.f5488c.b(str);
        } else {
            this.f5487b.x().a(str, this.f5487b.c().a());
        }
    }

    @Keep
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        if (this.f5489d) {
            this.f5488c.clearConditionalUserProperty(str, str2, bundle);
        } else {
            this.f5487b.y().a(str, str2, bundle);
        }
    }

    /* access modifiers changed from: protected */
    @Keep
    public void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        if (this.f5489d) {
            throw new IllegalStateException("Unexpected call on client side");
        }
        this.f5487b.y().a(str, str2, str3, bundle);
        throw null;
    }

    @Keep
    public void endAdUnitExposure(String str) {
        if (this.f5489d) {
            this.f5488c.c(str);
        } else {
            this.f5487b.x().b(str, this.f5487b.c().a());
        }
    }

    @Keep
    public long generateEventId() {
        if (this.f5489d) {
            return this.f5488c.b();
        }
        return this.f5487b.G().u();
    }

    @Keep
    public String getAppInstanceId() {
        if (this.f5489d) {
            return this.f5488c.a();
        }
        return this.f5487b.y().E();
    }

    @Keep
    public List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        List<Bundle> list;
        int i2;
        if (this.f5489d) {
            list = this.f5488c.a(str, str2);
        } else {
            list = this.f5487b.y().b(str, str2);
        }
        if (list == null) {
            i2 = 0;
        } else {
            i2 = list.size();
        }
        ArrayList arrayList = new ArrayList(i2);
        for (Bundle conditionalUserProperty : list) {
            arrayList.add(new ConditionalUserProperty(conditionalUserProperty));
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @Keep
    public List<ConditionalUserProperty> getConditionalUserPropertiesAs(String str, String str2, String str3) {
        if (this.f5489d) {
            throw new IllegalStateException("Unexpected call on client side");
        }
        this.f5487b.y().a(str, str2, str3);
        throw null;
    }

    @Keep
    public String getCurrentScreenClass() {
        if (this.f5489d) {
            return this.f5488c.e();
        }
        return this.f5487b.y().B();
    }

    @Keep
    public String getCurrentScreenName() {
        if (this.f5489d) {
            return this.f5488c.c();
        }
        return this.f5487b.y().C();
    }

    @Keep
    public String getGmpAppId() {
        if (this.f5489d) {
            return this.f5488c.d();
        }
        return this.f5487b.y().D();
    }

    @Keep
    public int getMaxUserProperties(String str) {
        if (this.f5489d) {
            return this.f5488c.a(str);
        }
        this.f5487b.y();
        q.b(str);
        return 25;
    }

    /* access modifiers changed from: protected */
    @Keep
    public Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        if (this.f5489d) {
            return this.f5488c.a(str, str2, z);
        }
        return this.f5487b.y().a(str, str2, z);
    }

    /* access modifiers changed from: protected */
    @Keep
    public Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z) {
        if (this.f5489d) {
            throw new IllegalStateException("Unexpected call on client side");
        }
        this.f5487b.y().a(str, str2, str3, z);
        throw null;
    }

    @Keep
    public void logEventInternal(String str, String str2, Bundle bundle) {
        if (this.f5489d) {
            this.f5488c.a(str, str2, bundle);
        } else {
            this.f5487b.y().b(str, str2, bundle);
        }
    }

    public void registerOnMeasurementEventListener(OnEventListener onEventListener) {
        if (this.f5489d) {
            this.f5488c.a((C0572sc) onEventListener);
        } else {
            this.f5487b.y().a((C0572sc) onEventListener);
        }
    }

    @Keep
    public void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        q.a(conditionalUserProperty);
        if (this.f5489d) {
            this.f5488c.a(conditionalUserProperty.a());
        } else {
            this.f5487b.y().a(conditionalUserProperty.a());
        }
    }

    /* access modifiers changed from: protected */
    @Keep
    public void setConditionalUserPropertyAs(ConditionalUserProperty conditionalUserProperty) {
        q.a(conditionalUserProperty);
        if (this.f5489d) {
            throw new IllegalStateException("Unexpected call on client side");
        }
        this.f5487b.y().b(conditionalUserProperty.a());
        throw null;
    }

    private AppMeasurement(Mc mc) {
        q.a(mc);
        this.f5488c = mc;
        this.f5487b = null;
        this.f5489d = true;
    }

    public static AppMeasurement a(Context context, Bundle bundle) {
        if (f5486a == null) {
            synchronized (AppMeasurement.class) {
                if (f5486a == null) {
                    Mc b2 = b(context, bundle);
                    if (b2 != null) {
                        f5486a = new AppMeasurement(b2);
                    } else {
                        f5486a = new AppMeasurement(Ob.a(context, null, null, bundle));
                    }
                }
            }
        }
        return f5486a;
    }

    public final void a(boolean z) {
        if (this.f5489d) {
            this.f5488c.setDataCollectionEnabled(z);
        } else {
            this.f5487b.y().b(z);
        }
    }

    public void a(String str, String str2, Object obj) {
        q.b(str);
        if (this.f5489d) {
            this.f5488c.a(str, str2, obj);
        } else {
            this.f5487b.y().a(str, str2, obj, true);
        }
    }
}
