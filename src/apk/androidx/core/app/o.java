package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TaskStackBuilder */
public final class o implements Iterable<Intent> {

    /* renamed from: a reason: collision with root package name */
    private final ArrayList<Intent> f1300a = new ArrayList<>();

    /* renamed from: b reason: collision with root package name */
    private final Context f1301b;

    /* compiled from: TaskStackBuilder */
    public interface a {
        Intent getSupportParentActivityIntent();
    }

    private o(Context context) {
        this.f1301b = context;
    }

    public static o a(Context context) {
        return new o(context);
    }

    public void e() {
        a((Bundle) null);
    }

    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f1300a.iterator();
    }

    public o a(Intent intent) {
        this.f1300a.add(intent);
        return this;
    }

    public o a(Activity activity) {
        Intent supportParentActivityIntent = activity instanceof a ? ((a) activity).getSupportParentActivityIntent() : null;
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = h.a(activity);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(this.f1301b.getPackageManager());
            }
            a(component);
            a(supportParentActivityIntent);
        }
        return this;
    }

    public o a(ComponentName componentName) {
        int size = this.f1300a.size();
        try {
            Intent a2 = h.a(this.f1301b, componentName);
            while (a2 != null) {
                this.f1300a.add(size, a2);
                a2 = h.a(this.f1301b, a2.getComponent());
            }
            return this;
        } catch (NameNotFoundException e2) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e2);
        }
    }

    public void a(Bundle bundle) {
        if (!this.f1300a.isEmpty()) {
            ArrayList<Intent> arrayList = this.f1300a;
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            if (!b.g.a.a.a(this.f1301b, intentArr, bundle)) {
                Intent intent = new Intent(intentArr[intentArr.length - 1]);
                intent.addFlags(268435456);
                this.f1301b.startActivity(intent);
                return;
            }
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }
}
