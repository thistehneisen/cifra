package com.touchin.vtb.b;

import android.os.Bundle;
import com.touchin.vtb.api.BankType;
import com.touchin.vtb.api.TaskType;
import com.touchin.vtb.utils.k;
import java.util.List;
import kotlin.e.b.h;

/* compiled from: VTBAnalytics.kt */
public abstract class g {

    /* renamed from: a reason: collision with root package name */
    private final String f7162a;

    /* compiled from: VTBAnalytics.kt */
    public static final class a extends g {

        /* renamed from: b reason: collision with root package name */
        private final long f7163b;

        /* renamed from: c reason: collision with root package name */
        private final long f7164c;

        public a(long j2, long j3) {
            super(c.BANK_TIME_USAGE.a(), null);
            this.f7163b = j2;
            this.f7164c = j3;
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putLong(d.BANK_TIME_USAGE.a(), this.f7163b);
            bundle.putLong(d.APPLICATION_TIME_USAGE.a(), this.f7164c);
            return bundle;
        }
    }

    /* compiled from: VTBAnalytics.kt */
    public static final class b extends g {

        /* renamed from: b reason: collision with root package name */
        private final BankType f7165b;

        public b(BankType bankType) {
            h.b(bankType, "bankType");
            super(c.CONFIRM_SELECT_BANK.a(), null);
            this.f7165b = bankType;
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putString(d.BANK_TYPE.a(), this.f7165b.name());
            return bundle;
        }
    }

    /* compiled from: VTBAnalytics.kt */
    public static final class c extends g {

        /* renamed from: b reason: collision with root package name */
        private final List<BankType> f7166b;

        public c(List<? extends BankType> list) {
            h.b(list, "bankTypesList");
            super(c.CONNECTED_BANKS.a(), null);
            this.f7166b = list;
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putString(d.CONNECTED_BANKS.a(), this.f7166b.toString());
            return bundle;
        }
    }

    /* compiled from: VTBAnalytics.kt */
    public static final class d extends g {
        public d() {
            super(c.LOGIN_DATE.a(), null);
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            String a2 = d.LOGIN_DATE.a();
            com.touchin.vtb.utils.b bVar = com.touchin.vtb.utils.b.f7611a;
            org.joda.time.b g2 = org.joda.time.b.g();
            h.a((Object) g2, "DateTime.now()");
            bundle.putString(a2, bVar.a(g2, k.DAY_DIGIT_MONTH_YEAR));
            return bundle;
        }
    }

    /* compiled from: VTBAnalytics.kt */
    public static final class e extends g {
        public e() {
            super(c.LOGIN_TIME.a(), null);
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            String a2 = d.LOGIN_TIME.a();
            com.touchin.vtb.utils.b bVar = com.touchin.vtb.utils.b.f7611a;
            org.joda.time.b g2 = org.joda.time.b.g();
            h.a((Object) g2, "DateTime.now()");
            bundle.putString(a2, bVar.a(g2, k.HOURS_MINUTES_SECONDS));
            return bundle;
        }
    }

    /* compiled from: VTBAnalytics.kt */
    public static final class f extends g {

        /* renamed from: b reason: collision with root package name */
        private final TaskType f7167b;

        public f(TaskType taskType) {
            h.b(taskType, "taskType");
            super(c.SELECTED_TASK.a(), null);
            this.f7167b = taskType;
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putString(d.TASK_TYPE.a(), this.f7167b.name());
            return bundle;
        }
    }

    /* renamed from: com.touchin.vtb.b.g$g reason: collision with other inner class name */
    /* compiled from: VTBAnalytics.kt */
    public static final class C0073g extends g {

        /* renamed from: b reason: collision with root package name */
        private final BankType f7168b;

        public C0073g(BankType bankType) {
            h.b(bankType, "bankType");
            super(c.SETTINGS_CONFIRM_SELECT_BANK.a(), null);
            this.f7168b = bankType;
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putString(d.BANK_TYPE.a(), this.f7168b.name());
            return bundle;
        }
    }

    private g(String str) {
        this.f7162a = str;
    }

    public abstract Bundle a();

    public final String b() {
        return this.f7162a;
    }

    public /* synthetic */ g(String str, e eVar) {
        this(str);
    }
}
