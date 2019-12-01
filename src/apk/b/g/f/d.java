package b.g.f;

import b.g.f.k.a;
import java.util.ArrayList;

/* compiled from: FontsContractCompat */
class d implements a<c> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ String f2538a;

    d(String str) {
        this.f2538a = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        if (r0 >= r1.size()) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        ((b.g.f.k.a) r1.get(r0)).a(r5);
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
        r0 = 0;
     */
    public void a(c cVar) {
        synchronized (f.f2541c) {
            ArrayList arrayList = (ArrayList) f.f2542d.get(this.f2538a);
            if (arrayList != null) {
                f.f2542d.remove(this.f2538a);
            }
        }
    }
}
