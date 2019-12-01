package com.touchin.vtb.a;

import com.touchin.vtb.api.OperationInfo;
import kotlin.e.b.h;

/* compiled from: BankOperationsAdapter.kt */
public abstract class q {

    /* compiled from: BankOperationsAdapter.kt */
    public static final class a extends q {

        /* renamed from: a reason: collision with root package name */
        private final OperationInfo f6973a;

        public a(OperationInfo operationInfo) {
            h.b(operationInfo, "operationInfo");
            super(null);
            this.f6973a = operationInfo;
        }

        public final OperationInfo b() {
            return this.f6973a;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
            if (kotlin.e.b.h.a((java.lang.Object) r1.f6973a, (java.lang.Object) ((com.touchin.vtb.a.q.a) r2).f6973a) != false) goto L_0x0015;
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
            OperationInfo operationInfo = this.f6973a;
            if (operationInfo != null) {
                return operationInfo.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("BankOperationItem(operationInfo=");
            sb.append(this.f6973a);
            sb.append(")");
            return sb.toString();
        }
    }

    /* compiled from: BankOperationsAdapter.kt */
    public static final class b extends q {

        /* renamed from: a reason: collision with root package name */
        public static final b f6974a = new b();

        private b() {
            super(null);
        }
    }

    /* compiled from: BankOperationsAdapter.kt */
    public static final class c extends q {

        /* renamed from: a reason: collision with root package name */
        public static final c f6975a = new c();

        private c() {
            super(null);
        }
    }

    private q() {
    }

    public final a a() {
        return (a) this;
    }

    public /* synthetic */ q(e eVar) {
        this();
    }
}
