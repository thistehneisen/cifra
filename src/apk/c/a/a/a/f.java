package c.a.a.a;

import android.os.Bundle;

/* compiled from: ReferrerDetails */
public class f {

    /* renamed from: a reason: collision with root package name */
    private final Bundle f3040a;

    public f(Bundle bundle) {
        this.f3040a = bundle;
    }

    public long a() {
        return this.f3040a.getLong("install_begin_timestamp_seconds");
    }

    public String b() {
        return this.f3040a.getString("install_referrer");
    }

    public long c() {
        return this.f3040a.getLong("referrer_click_timestamp_seconds");
    }
}
