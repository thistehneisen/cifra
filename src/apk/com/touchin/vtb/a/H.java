package com.touchin.vtb.a;

import com.touchin.vtb.api.TaskInfo;
import kotlin.e.b.h;

/* compiled from: TasksAdapter.kt */
public abstract class H {

    /* renamed from: a reason: collision with root package name */
    private final TaskInfo f6888a;

    /* compiled from: TasksAdapter.kt */
    public static final class a extends H {

        /* renamed from: b reason: collision with root package name */
        private final TaskInfo f6889b;

        public a(TaskInfo taskInfo) {
            h.b(taskInfo, "taskInfo");
            super(taskInfo, null);
            this.f6889b = taskInfo;
        }

        public TaskInfo a() {
            return this.f6889b;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
            if (kotlin.e.b.h.a((java.lang.Object) a(), (java.lang.Object) ((com.touchin.vtb.a.H.a) r2).a()) != false) goto L_0x0019;
         */
        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof a) {
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            TaskInfo a2 = a();
            if (a2 != null) {
                return a2.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("TaskBankConnectionItem(taskInfo=");
            sb.append(a());
            sb.append(")");
            return sb.toString();
        }
    }

    /* compiled from: TasksAdapter.kt */
    public static final class b extends H {

        /* renamed from: b reason: collision with root package name */
        private final TaskInfo f6890b;

        public b(TaskInfo taskInfo) {
            h.b(taskInfo, "taskInfo");
            super(taskInfo, null);
            this.f6890b = taskInfo;
        }

        public TaskInfo a() {
            return this.f6890b;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
            if (kotlin.e.b.h.a((java.lang.Object) a(), (java.lang.Object) ((com.touchin.vtb.a.H.b) r2).a()) != false) goto L_0x0019;
         */
        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof b) {
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            TaskInfo a2 = a();
            if (a2 != null) {
                return a2.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("TaskInfoItem(taskInfo=");
            sb.append(a());
            sb.append(")");
            return sb.toString();
        }
    }

    /* compiled from: TasksAdapter.kt */
    public static final class c extends H {

        /* renamed from: b reason: collision with root package name */
        private final TaskInfo f6891b;

        public TaskInfo a() {
            return this.f6891b;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
            if (kotlin.e.b.h.a((java.lang.Object) a(), (java.lang.Object) ((com.touchin.vtb.a.H.c) r2).a()) != false) goto L_0x0019;
         */
        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof c) {
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            TaskInfo a2 = a();
            if (a2 != null) {
                return a2.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("TaskRegistrationItem(taskInfo=");
            sb.append(a());
            sb.append(")");
            return sb.toString();
        }
    }

    /* compiled from: TasksAdapter.kt */
    public static final class d extends H {

        /* renamed from: b reason: collision with root package name */
        private final TaskInfo f6892b;

        public d(TaskInfo taskInfo) {
            h.b(taskInfo, "taskInfo");
            super(taskInfo, null);
            this.f6892b = taskInfo;
        }

        public TaskInfo a() {
            return this.f6892b;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
            if (kotlin.e.b.h.a((java.lang.Object) a(), (java.lang.Object) ((com.touchin.vtb.a.H.d) r2).a()) != false) goto L_0x0019;
         */
        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof d) {
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            TaskInfo a2 = a();
            if (a2 != null) {
                return a2.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("TaskTaxesItem(taskInfo=");
            sb.append(a());
            sb.append(")");
            return sb.toString();
        }
    }

    private H(TaskInfo taskInfo) {
        this.f6888a = taskInfo;
    }

    public TaskInfo a() {
        return this.f6888a;
    }

    public /* synthetic */ H(TaskInfo taskInfo, e eVar) {
        this(taskInfo);
    }
}
