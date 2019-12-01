package androidx.appcompat.app;

/* compiled from: AppCompatDelegateImpl */
class r implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ y f500a;

    r(y yVar) {
        this.f500a = yVar;
    }

    public void run() {
        y yVar = this.f500a;
        if ((yVar.P & 1) != 0) {
            yVar.e(0);
        }
        y yVar2 = this.f500a;
        if ((yVar2.P & CodedOutputStream.DEFAULT_BUFFER_SIZE) != 0) {
            yVar2.e(108);
        }
        y yVar3 = this.f500a;
        yVar3.O = false;
        yVar3.P = 0;
    }
}
