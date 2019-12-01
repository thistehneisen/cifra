package androidx.core.app;

import android.app.Notification;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.InboxStyle;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioAttributes.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: NotificationCompat */
public class j {

    /* compiled from: NotificationCompat */
    public static class a {

        /* renamed from: a reason: collision with root package name */
        final Bundle f1258a;

        /* renamed from: b reason: collision with root package name */
        private final m[] f1259b;

        /* renamed from: c reason: collision with root package name */
        private final m[] f1260c;

        /* renamed from: d reason: collision with root package name */
        private boolean f1261d;

        /* renamed from: e reason: collision with root package name */
        boolean f1262e;

        /* renamed from: f reason: collision with root package name */
        private final int f1263f;

        /* renamed from: g reason: collision with root package name */
        public int f1264g;

        /* renamed from: h reason: collision with root package name */
        public CharSequence f1265h;

        /* renamed from: i reason: collision with root package name */
        public PendingIntent f1266i;

        public a(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i2, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true);
        }

        public PendingIntent a() {
            return this.f1266i;
        }

        public boolean b() {
            return this.f1261d;
        }

        public m[] c() {
            return this.f1260c;
        }

        public Bundle d() {
            return this.f1258a;
        }

        public int e() {
            return this.f1264g;
        }

        public m[] f() {
            return this.f1259b;
        }

        public int g() {
            return this.f1263f;
        }

        public boolean h() {
            return this.f1262e;
        }

        public CharSequence i() {
            return this.f1265h;
        }

        a(int i2, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, m[] mVarArr, m[] mVarArr2, boolean z, int i3, boolean z2) {
            this.f1262e = true;
            this.f1264g = i2;
            this.f1265h = d.a(charSequence);
            this.f1266i = pendingIntent;
            if (bundle == null) {
                bundle = new Bundle();
            }
            this.f1258a = bundle;
            this.f1259b = mVarArr;
            this.f1260c = mVarArr2;
            this.f1261d = z;
            this.f1263f = i3;
            this.f1262e = z2;
        }
    }

    /* compiled from: NotificationCompat */
    public static class b extends f {

        /* renamed from: e reason: collision with root package name */
        private Bitmap f1267e;

        /* renamed from: f reason: collision with root package name */
        private Bitmap f1268f;

        /* renamed from: g reason: collision with root package name */
        private boolean f1269g;

        public b a(Bitmap bitmap) {
            this.f1268f = bitmap;
            this.f1269g = true;
            return this;
        }

        public b b(Bitmap bitmap) {
            this.f1267e = bitmap;
            return this;
        }

        public void a(i iVar) {
            if (VERSION.SDK_INT >= 16) {
                BigPictureStyle bigPicture = new BigPictureStyle(iVar.a()).setBigContentTitle(this.f1285b).bigPicture(this.f1267e);
                if (this.f1269g) {
                    bigPicture.bigLargeIcon(this.f1268f);
                }
                if (this.f1287d) {
                    bigPicture.setSummaryText(this.f1286c);
                }
            }
        }
    }

    /* compiled from: NotificationCompat */
    public static class c extends f {

        /* renamed from: e reason: collision with root package name */
        private CharSequence f1270e;

        public c a(CharSequence charSequence) {
            this.f1270e = d.a(charSequence);
            return this;
        }

        public void a(i iVar) {
            if (VERSION.SDK_INT >= 16) {
                BigTextStyle bigText = new BigTextStyle(iVar.a()).setBigContentTitle(this.f1285b).bigText(this.f1270e);
                if (this.f1287d) {
                    bigText.setSummaryText(this.f1286c);
                }
            }
        }
    }

    /* compiled from: NotificationCompat */
    public static class d {
        String A;
        Bundle B;
        int C;
        int D;
        Notification E;
        RemoteViews F;
        RemoteViews G;
        RemoteViews H;
        String I;
        int J;
        String K;
        long L;
        int M;
        Notification N;
        @Deprecated
        public ArrayList<String> O;

        /* renamed from: a reason: collision with root package name */
        public Context f1271a;

        /* renamed from: b reason: collision with root package name */
        public ArrayList<a> f1272b;

        /* renamed from: c reason: collision with root package name */
        ArrayList<a> f1273c;

        /* renamed from: d reason: collision with root package name */
        CharSequence f1274d;

        /* renamed from: e reason: collision with root package name */
        CharSequence f1275e;

        /* renamed from: f reason: collision with root package name */
        PendingIntent f1276f;

        /* renamed from: g reason: collision with root package name */
        PendingIntent f1277g;

        /* renamed from: h reason: collision with root package name */
        RemoteViews f1278h;

        /* renamed from: i reason: collision with root package name */
        Bitmap f1279i;

        /* renamed from: j reason: collision with root package name */
        CharSequence f1280j;

        /* renamed from: k reason: collision with root package name */
        int f1281k;

        /* renamed from: l reason: collision with root package name */
        int f1282l;
        boolean m;
        boolean n;
        f o;
        CharSequence p;
        CharSequence[] q;
        int r;
        int s;
        boolean t;
        String u;
        boolean v;
        String w;
        boolean x;
        boolean y;
        boolean z;

        public d(Context context, String str) {
            this.f1272b = new ArrayList<>();
            this.f1273c = new ArrayList<>();
            this.m = true;
            this.x = false;
            this.C = 0;
            this.D = 0;
            this.J = 0;
            this.M = 0;
            this.N = new Notification();
            this.f1271a = context;
            this.I = str;
            this.N.when = System.currentTimeMillis();
            this.N.audioStreamType = -1;
            this.f1282l = 0;
            this.O = new ArrayList<>();
        }

        public d a(long j2) {
            this.N.when = j2;
            return this;
        }

        public d b(CharSequence charSequence) {
            this.f1275e = a(charSequence);
            return this;
        }

        public d c(CharSequence charSequence) {
            this.f1274d = a(charSequence);
            return this;
        }

        public d d(int i2) {
            this.N.icon = i2;
            return this;
        }

        public d a(PendingIntent pendingIntent) {
            this.f1276f = pendingIntent;
            return this;
        }

        public d b(PendingIntent pendingIntent) {
            this.N.deleteIntent = pendingIntent;
            return this;
        }

        public d c(int i2) {
            this.f1282l = i2;
            return this;
        }

        public d d(CharSequence charSequence) {
            this.N.tickerText = a(charSequence);
            return this;
        }

        private Bitmap b(Bitmap bitmap) {
            if (bitmap != null && VERSION.SDK_INT < 27) {
                Resources resources = this.f1271a.getResources();
                int dimensionPixelSize = resources.getDimensionPixelSize(b.g.b.compat_notification_large_icon_max_width);
                int dimensionPixelSize2 = resources.getDimensionPixelSize(b.g.b.compat_notification_large_icon_max_height);
                if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
                    return bitmap;
                }
                double min = Math.min(((double) dimensionPixelSize) / ((double) Math.max(1, bitmap.getWidth())), ((double) dimensionPixelSize2) / ((double) Math.max(1, bitmap.getHeight())));
                bitmap = Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * min), (int) Math.ceil(((double) bitmap.getHeight()) * min), true);
            }
            return bitmap;
        }

        public d a(Bitmap bitmap) {
            this.f1279i = b(bitmap);
            return this;
        }

        public d a(Uri uri) {
            Notification notification = this.N;
            notification.sound = uri;
            notification.audioStreamType = -1;
            if (VERSION.SDK_INT >= 21) {
                notification.audioAttributes = new Builder().setContentType(4).setUsage(5).build();
            }
            return this;
        }

        public d a(int i2, int i3, int i4) {
            Notification notification = this.N;
            notification.ledARGB = i2;
            notification.ledOnMS = i3;
            notification.ledOffMS = i4;
            int i5 = (notification.ledOnMS == 0 || notification.ledOffMS == 0) ? 0 : 1;
            Notification notification2 = this.N;
            notification2.flags = i5 | (notification2.flags & -2);
            return this;
        }

        public d a(boolean z2) {
            a(16, z2);
            return this;
        }

        public d b(boolean z2) {
            this.x = z2;
            return this;
        }

        @Deprecated
        public d(Context context) {
            this(context, null);
        }

        public d a(String str) {
            this.A = str;
            return this;
        }

        public d b(int i2) {
            Notification notification = this.N;
            notification.defaults = i2;
            if ((i2 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        private void a(int i2, boolean z2) {
            if (z2) {
                Notification notification = this.N;
                notification.flags = i2 | notification.flags;
                return;
            }
            Notification notification2 = this.N;
            notification2.flags = (~i2) & notification2.flags;
        }

        public Bundle b() {
            if (this.B == null) {
                this.B = new Bundle();
            }
            return this.B;
        }

        public d a(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f1272b.add(new a(i2, charSequence, pendingIntent));
            return this;
        }

        public d a(f fVar) {
            if (this.o != fVar) {
                this.o = fVar;
                f fVar2 = this.o;
                if (fVar2 != null) {
                    fVar2.a(this);
                }
            }
            return this;
        }

        public d b(String str) {
            this.I = str;
            return this;
        }

        public d a(int i2) {
            this.C = i2;
            return this;
        }

        public Notification a() {
            return new k(this).b();
        }

        protected static CharSequence a(CharSequence charSequence) {
            if (charSequence == null) {
                return charSequence;
            }
            if (charSequence.length() > 5120) {
                charSequence = charSequence.subSequence(0, 5120);
            }
            return charSequence;
        }
    }

    /* compiled from: NotificationCompat */
    public static class e extends f {

        /* renamed from: e reason: collision with root package name */
        private ArrayList<CharSequence> f1283e = new ArrayList<>();

        public e a(CharSequence charSequence) {
            this.f1283e.add(d.a(charSequence));
            return this;
        }

        public e b(CharSequence charSequence) {
            this.f1285b = d.a(charSequence);
            return this;
        }

        public void a(i iVar) {
            if (VERSION.SDK_INT >= 16) {
                InboxStyle bigContentTitle = new InboxStyle(iVar.a()).setBigContentTitle(this.f1285b);
                if (this.f1287d) {
                    bigContentTitle.setSummaryText(this.f1286c);
                }
                Iterator it = this.f1283e.iterator();
                while (it.hasNext()) {
                    bigContentTitle.addLine((CharSequence) it.next());
                }
            }
        }
    }

    /* compiled from: NotificationCompat */
    public static abstract class f {

        /* renamed from: a reason: collision with root package name */
        protected d f1284a;

        /* renamed from: b reason: collision with root package name */
        CharSequence f1285b;

        /* renamed from: c reason: collision with root package name */
        CharSequence f1286c;

        /* renamed from: d reason: collision with root package name */
        boolean f1287d = false;

        public void a(Bundle bundle) {
        }

        public abstract void a(i iVar);

        public void a(d dVar) {
            if (this.f1284a != dVar) {
                this.f1284a = dVar;
                d dVar2 = this.f1284a;
                if (dVar2 != null) {
                    dVar2.a(this);
                }
            }
        }

        public RemoteViews b(i iVar) {
            return null;
        }

        public RemoteViews c(i iVar) {
            return null;
        }

        public RemoteViews d(i iVar) {
            return null;
        }
    }

    public static Bundle a(Notification notification) {
        int i2 = VERSION.SDK_INT;
        if (i2 >= 19) {
            return notification.extras;
        }
        if (i2 >= 16) {
            return l.a(notification);
        }
        return null;
    }
}
