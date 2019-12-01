package androidx.core.app;

import android.app.Notification;
import android.app.Notification.Action;
import android.app.Notification.Builder;
import android.app.RemoteInput;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.app.j.a;
import androidx.core.app.j.d;
import androidx.core.app.j.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: NotificationCompatBuilder */
class k implements i {

    /* renamed from: a reason: collision with root package name */
    private final Builder f1288a;

    /* renamed from: b reason: collision with root package name */
    private final d f1289b;

    /* renamed from: c reason: collision with root package name */
    private RemoteViews f1290c;

    /* renamed from: d reason: collision with root package name */
    private RemoteViews f1291d;

    /* renamed from: e reason: collision with root package name */
    private final List<Bundle> f1292e = new ArrayList();

    /* renamed from: f reason: collision with root package name */
    private final Bundle f1293f = new Bundle();

    /* renamed from: g reason: collision with root package name */
    private int f1294g;

    /* renamed from: h reason: collision with root package name */
    private RemoteViews f1295h;

    k(d dVar) {
        this.f1289b = dVar;
        if (VERSION.SDK_INT >= 26) {
            this.f1288a = new Builder(dVar.f1271a, dVar.I);
        } else {
            this.f1288a = new Builder(dVar.f1271a);
        }
        Notification notification = dVar.N;
        this.f1288a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, dVar.f1278h).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(dVar.f1274d).setContentText(dVar.f1275e).setContentInfo(dVar.f1280j).setContentIntent(dVar.f1276f).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(dVar.f1277g, (notification.flags & 128) != 0).setLargeIcon(dVar.f1279i).setNumber(dVar.f1281k).setProgress(dVar.r, dVar.s, dVar.t);
        if (VERSION.SDK_INT < 21) {
            this.f1288a.setSound(notification.sound, notification.audioStreamType);
        }
        if (VERSION.SDK_INT >= 16) {
            this.f1288a.setSubText(dVar.p).setUsesChronometer(dVar.n).setPriority(dVar.f1282l);
            Iterator it = dVar.f1272b.iterator();
            while (it.hasNext()) {
                a((a) it.next());
            }
            Bundle bundle = dVar.B;
            if (bundle != null) {
                this.f1293f.putAll(bundle);
            }
            if (VERSION.SDK_INT < 20) {
                if (dVar.x) {
                    this.f1293f.putBoolean("android.support.localOnly", true);
                }
                String str = dVar.u;
                if (str != null) {
                    this.f1293f.putString("android.support.groupKey", str);
                    if (dVar.v) {
                        this.f1293f.putBoolean("android.support.isGroupSummary", true);
                    } else {
                        this.f1293f.putBoolean("android.support.useSideChannel", true);
                    }
                }
                String str2 = dVar.w;
                if (str2 != null) {
                    this.f1293f.putString("android.support.sortKey", str2);
                }
            }
            this.f1290c = dVar.F;
            this.f1291d = dVar.G;
        }
        if (VERSION.SDK_INT >= 19) {
            this.f1288a.setShowWhen(dVar.m);
            if (VERSION.SDK_INT < 21) {
                ArrayList<String> arrayList = dVar.O;
                if (arrayList != null && !arrayList.isEmpty()) {
                    Bundle bundle2 = this.f1293f;
                    ArrayList<String> arrayList2 = dVar.O;
                    bundle2.putStringArray("android.people", (String[]) arrayList2.toArray(new String[arrayList2.size()]));
                }
            }
        }
        if (VERSION.SDK_INT >= 20) {
            this.f1288a.setLocalOnly(dVar.x).setGroup(dVar.u).setGroupSummary(dVar.v).setSortKey(dVar.w);
            this.f1294g = dVar.M;
        }
        if (VERSION.SDK_INT >= 21) {
            this.f1288a.setCategory(dVar.A).setColor(dVar.C).setVisibility(dVar.D).setPublicVersion(dVar.E).setSound(notification.sound, notification.audioAttributes);
            Iterator it2 = dVar.O.iterator();
            while (it2.hasNext()) {
                this.f1288a.addPerson((String) it2.next());
            }
            this.f1295h = dVar.H;
            if (dVar.f1273c.size() > 0) {
                String str3 = "android.car.EXTENSIONS";
                Bundle bundle3 = dVar.b().getBundle(str3);
                if (bundle3 == null) {
                    bundle3 = new Bundle();
                }
                Bundle bundle4 = new Bundle();
                for (int i2 = 0; i2 < dVar.f1273c.size(); i2++) {
                    bundle4.putBundle(Integer.toString(i2), l.a((a) dVar.f1273c.get(i2)));
                }
                bundle3.putBundle("invisible_actions", bundle4);
                dVar.b().putBundle(str3, bundle3);
                this.f1293f.putBundle(str3, bundle3);
            }
        }
        if (VERSION.SDK_INT >= 24) {
            this.f1288a.setExtras(dVar.B).setRemoteInputHistory(dVar.q);
            RemoteViews remoteViews = dVar.F;
            if (remoteViews != null) {
                this.f1288a.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = dVar.G;
            if (remoteViews2 != null) {
                this.f1288a.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = dVar.H;
            if (remoteViews3 != null) {
                this.f1288a.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (VERSION.SDK_INT >= 26) {
            this.f1288a.setBadgeIconType(dVar.J).setShortcutId(dVar.K).setTimeoutAfter(dVar.L).setGroupAlertBehavior(dVar.M);
            if (dVar.z) {
                this.f1288a.setColorized(dVar.y);
            }
            if (!TextUtils.isEmpty(dVar.I)) {
                this.f1288a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
    }

    public Builder a() {
        return this.f1288a;
    }

    public Notification b() {
        f fVar = this.f1289b.o;
        if (fVar != null) {
            fVar.a((i) this);
        }
        RemoteViews c2 = fVar != null ? fVar.c(this) : null;
        Notification c3 = c();
        if (c2 != null) {
            c3.contentView = c2;
        } else {
            RemoteViews remoteViews = this.f1289b.F;
            if (remoteViews != null) {
                c3.contentView = remoteViews;
            }
        }
        if (VERSION.SDK_INT >= 16 && fVar != null) {
            RemoteViews b2 = fVar.b(this);
            if (b2 != null) {
                c3.bigContentView = b2;
            }
        }
        if (VERSION.SDK_INT >= 21 && fVar != null) {
            RemoteViews d2 = this.f1289b.o.d(this);
            if (d2 != null) {
                c3.headsUpContentView = d2;
            }
        }
        if (VERSION.SDK_INT >= 16 && fVar != null) {
            Bundle a2 = j.a(c3);
            if (a2 != null) {
                fVar.a(a2);
            }
        }
        return c3;
    }

    /* access modifiers changed from: protected */
    public Notification c() {
        int i2 = VERSION.SDK_INT;
        if (i2 >= 26) {
            return this.f1288a.build();
        }
        if (i2 >= 24) {
            Notification build = this.f1288a.build();
            if (this.f1294g != 0) {
                if (!(build.getGroup() == null || (build.flags & 512) == 0 || this.f1294g != 2)) {
                    a(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.f1294g == 1) {
                    a(build);
                }
            }
            return build;
        } else if (i2 >= 21) {
            this.f1288a.setExtras(this.f1293f);
            Notification build2 = this.f1288a.build();
            RemoteViews remoteViews = this.f1290c;
            if (remoteViews != null) {
                build2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.f1291d;
            if (remoteViews2 != null) {
                build2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.f1295h;
            if (remoteViews3 != null) {
                build2.headsUpContentView = remoteViews3;
            }
            if (this.f1294g != 0) {
                if (!(build2.getGroup() == null || (build2.flags & 512) == 0 || this.f1294g != 2)) {
                    a(build2);
                }
                if (build2.getGroup() != null && (build2.flags & 512) == 0 && this.f1294g == 1) {
                    a(build2);
                }
            }
            return build2;
        } else if (i2 >= 20) {
            this.f1288a.setExtras(this.f1293f);
            Notification build3 = this.f1288a.build();
            RemoteViews remoteViews4 = this.f1290c;
            if (remoteViews4 != null) {
                build3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.f1291d;
            if (remoteViews5 != null) {
                build3.bigContentView = remoteViews5;
            }
            if (this.f1294g != 0) {
                if (!(build3.getGroup() == null || (build3.flags & 512) == 0 || this.f1294g != 2)) {
                    a(build3);
                }
                if (build3.getGroup() != null && (build3.flags & 512) == 0 && this.f1294g == 1) {
                    a(build3);
                }
            }
            return build3;
        } else {
            String str = "android.support.actionExtras";
            if (i2 >= 19) {
                SparseArray a2 = l.a(this.f1292e);
                if (a2 != null) {
                    this.f1293f.putSparseParcelableArray(str, a2);
                }
                this.f1288a.setExtras(this.f1293f);
                Notification build4 = this.f1288a.build();
                RemoteViews remoteViews6 = this.f1290c;
                if (remoteViews6 != null) {
                    build4.contentView = remoteViews6;
                }
                RemoteViews remoteViews7 = this.f1291d;
                if (remoteViews7 != null) {
                    build4.bigContentView = remoteViews7;
                }
                return build4;
            } else if (i2 < 16) {
                return this.f1288a.getNotification();
            } else {
                Notification build5 = this.f1288a.build();
                Bundle a3 = j.a(build5);
                Bundle bundle = new Bundle(this.f1293f);
                for (String str2 : this.f1293f.keySet()) {
                    if (a3.containsKey(str2)) {
                        bundle.remove(str2);
                    }
                }
                a3.putAll(bundle);
                SparseArray a4 = l.a(this.f1292e);
                if (a4 != null) {
                    j.a(build5).putSparseParcelableArray(str, a4);
                }
                RemoteViews remoteViews8 = this.f1290c;
                if (remoteViews8 != null) {
                    build5.contentView = remoteViews8;
                }
                RemoteViews remoteViews9 = this.f1291d;
                if (remoteViews9 != null) {
                    build5.bigContentView = remoteViews9;
                }
                return build5;
            }
        }
    }

    private void a(a aVar) {
        Bundle bundle;
        int i2 = VERSION.SDK_INT;
        if (i2 >= 20) {
            Action.Builder builder = new Action.Builder(aVar.e(), aVar.i(), aVar.a());
            if (aVar.f() != null) {
                for (RemoteInput addRemoteInput : m.a(aVar.f())) {
                    builder.addRemoteInput(addRemoteInput);
                }
            }
            if (aVar.d() != null) {
                bundle = new Bundle(aVar.d());
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
            if (VERSION.SDK_INT >= 24) {
                builder.setAllowGeneratedReplies(aVar.b());
            }
            bundle.putInt("android.support.action.semanticAction", aVar.g());
            if (VERSION.SDK_INT >= 28) {
                builder.setSemanticAction(aVar.g());
            }
            bundle.putBoolean("android.support.action.showsUserInterface", aVar.h());
            builder.addExtras(bundle);
            this.f1288a.addAction(builder.build());
        } else if (i2 >= 16) {
            this.f1292e.add(l.a(this.f1288a, aVar));
        }
    }

    private void a(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -2;
        notification.defaults &= -3;
    }
}
