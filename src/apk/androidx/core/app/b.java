package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.app.SharedElementCallback.OnSharedElementsReadyListener;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import java.util.List;
import java.util.Map;

/* compiled from: ActivityCompat */
public class b extends b.g.a.a {

    /* renamed from: c reason: collision with root package name */
    private static C0009b f1251c;

    /* compiled from: ActivityCompat */
    public interface a {
        void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr);
    }

    /* renamed from: androidx.core.app.b$b reason: collision with other inner class name */
    /* compiled from: ActivityCompat */
    public interface C0009b {
        boolean a(Activity activity, int i2, int i3, Intent intent);

        boolean a(Activity activity, String[] strArr, int i2);
    }

    /* compiled from: ActivityCompat */
    public interface c {
        void validateRequestPermissionsRequestCode(int i2);
    }

    /* compiled from: ActivityCompat */
    private static class d extends SharedElementCallback {

        /* renamed from: a reason: collision with root package name */
        private final n f1252a;

        d(n nVar) {
            this.f1252a = nVar;
        }

        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.f1252a.a(view, matrix, rectF);
        }

        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.f1252a.a(context, parcelable);
        }

        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            this.f1252a.a(list, map);
        }

        public void onRejectSharedElements(List<View> list) {
            this.f1252a.a(list);
        }

        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.f1252a.a(list, list2, list3);
        }

        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.f1252a.b(list, list2, list3);
        }

        public void onSharedElementsArrived(List<String> list, List<View> list2, OnSharedElementsReadyListener onSharedElementsReadyListener) {
            this.f1252a.a(list, list2, (androidx.core.app.n.a) new c(this, onSharedElementsReadyListener));
        }
    }

    public static C0009b a() {
        return f1251c;
    }

    public static void b(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            activity.finishAfterTransition();
        } else {
            activity.finish();
        }
    }

    public static Uri c(Activity activity) {
        if (VERSION.SDK_INT >= 22) {
            return activity.getReferrer();
        }
        Intent intent = activity.getIntent();
        Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.REFERRER");
        if (uri != null) {
            return uri;
        }
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        if (stringExtra != null) {
            return Uri.parse(stringExtra);
        }
        return null;
    }

    public static void d(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            activity.postponeEnterTransition();
        }
    }

    public static void e(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            activity.startPostponedEnterTransition();
        }
    }

    public static void a(Activity activity, Intent intent, int i2, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, i2, bundle);
        } else {
            activity.startActivityForResult(intent, i2);
        }
    }

    public static void b(Activity activity, n nVar) {
        if (VERSION.SDK_INT >= 21) {
            activity.setExitSharedElementCallback(nVar != null ? new d(nVar) : null);
        }
    }

    public static void a(Activity activity, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws SendIntentException {
        if (VERSION.SDK_INT >= 16) {
            activity.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
        } else {
            activity.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
        }
    }

    public static void a(Activity activity) {
        if (VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    public static void a(Activity activity, n nVar) {
        if (VERSION.SDK_INT >= 21) {
            activity.setEnterSharedElementCallback(nVar != null ? new d(nVar) : null);
        }
    }

    public static void a(Activity activity, String[] strArr, int i2) {
        C0009b bVar = f1251c;
        if (bVar == null || !bVar.a(activity, strArr, i2)) {
            if (VERSION.SDK_INT >= 23) {
                if (activity instanceof c) {
                    ((c) activity).validateRequestPermissionsRequestCode(i2);
                }
                activity.requestPermissions(strArr, i2);
            } else if (activity instanceof a) {
                new Handler(Looper.getMainLooper()).post(new a(strArr, activity, i2));
            }
        }
    }

    public static boolean a(Activity activity, String str) {
        if (VERSION.SDK_INT >= 23) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
        return false;
    }
}
