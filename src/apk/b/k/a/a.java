package b.k.a;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import android.util.SparseArray;

@Deprecated
/* compiled from: WakefulBroadcastReceiver */
public abstract class a extends BroadcastReceiver {

    /* renamed from: a reason: collision with root package name */
    private static final SparseArray<WakeLock> f2776a = new SparseArray<>();

    /* renamed from: b reason: collision with root package name */
    private static int f2777b = 1;

    public static boolean a(Intent intent) {
        int intExtra = intent.getIntExtra("androidx.contentpager.content.wakelockid", 0);
        if (intExtra == 0) {
            return false;
        }
        synchronized (f2776a) {
            WakeLock wakeLock = (WakeLock) f2776a.get(intExtra);
            if (wakeLock != null) {
                wakeLock.release();
                f2776a.remove(intExtra);
                return true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("No active wake lock id #");
            sb.append(intExtra);
            Log.w("WakefulBroadcastReceiv.", sb.toString());
            return true;
        }
    }

    public static ComponentName b(Context context, Intent intent) {
        synchronized (f2776a) {
            int i2 = f2777b;
            f2777b++;
            if (f2777b <= 0) {
                f2777b = 1;
            }
            intent.putExtra("androidx.contentpager.content.wakelockid", i2);
            ComponentName startService = context.startService(intent);
            if (startService == null) {
                return null;
            }
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            StringBuilder sb = new StringBuilder();
            sb.append("androidx.core:wake:");
            sb.append(startService.flattenToShortString());
            WakeLock newWakeLock = powerManager.newWakeLock(1, sb.toString());
            newWakeLock.setReferenceCounted(false);
            newWakeLock.acquire(60000);
            f2776a.put(i2, newWakeLock);
            return startService;
        }
    }
}
