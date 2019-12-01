package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.jb reason: case insensitive filesystem */
final class C0527jb implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ int f5958a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ String f5959b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ Object f5960c;

    /* renamed from: d reason: collision with root package name */
    private final /* synthetic */ Object f5961d;

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ Object f5962e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ C0532kb f5963f;

    C0527jb(C0532kb kbVar, int i2, String str, Object obj, Object obj2, Object obj3) {
        this.f5963f = kbVar;
        this.f5958a = i2;
        this.f5959b = str;
        this.f5960c = obj;
        this.f5961d = obj2;
        this.f5962e = obj3;
    }

    public final void run() {
        C0576tb h2 = this.f5963f.f5987a.h();
        if (h2.o()) {
            if (this.f5963f.f5977c == 0) {
                if (this.f5963f.g().p()) {
                    C0532kb kbVar = this.f5963f;
                    kbVar.b();
                    kbVar.f5977c = 'C';
                } else {
                    C0532kb kbVar2 = this.f5963f;
                    kbVar2.b();
                    kbVar2.f5977c = 'c';
                }
            }
            if (this.f5963f.f5978d < 0) {
                C0532kb kbVar3 = this.f5963f;
                kbVar3.f5978d = kbVar3.g().n();
            }
            char charAt = "01VDIWEA?".charAt(this.f5958a);
            char a2 = this.f5963f.f5977c;
            long b2 = this.f5963f.f5978d;
            String a3 = C0532kb.a(true, this.f5959b, this.f5960c, this.f5961d, this.f5962e);
            StringBuilder sb = new StringBuilder(String.valueOf(a3).length() + 24);
            sb.append("2");
            sb.append(charAt);
            sb.append(a2);
            sb.append(b2);
            sb.append(":");
            sb.append(a3);
            String sb2 = sb.toString();
            if (sb2.length() > 1024) {
                sb2 = this.f5959b.substring(0, 1024);
            }
            h2.f6102e.a(sb2, 1);
            return;
        }
        this.f5963f.a(6, "Persisted config not initialized. Not logging error/warn");
    }
}
