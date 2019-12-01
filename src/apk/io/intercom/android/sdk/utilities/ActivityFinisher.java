package io.intercom.android.sdk.utilities;

import android.app.Activity;
import b.d.d;
import java.util.Set;

public class ActivityFinisher {
    private final Set<Activity> activities = new d();

    public void finishActivities() {
        for (Activity finish : this.activities) {
            finish.finish();
        }
        this.activities.clear();
    }

    public void register(Activity activity) {
        this.activities.add(activity);
    }

    public void unregister(Activity activity) {
        this.activities.remove(activity);
    }
}
