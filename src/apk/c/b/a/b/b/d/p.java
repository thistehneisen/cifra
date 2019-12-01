package c.b.a.b.b.d;

final class p extends l {

    /* renamed from: b reason: collision with root package name */
    private final o f3065b = new o();

    p() {
    }

    public final void a(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        } else if (th2 != null) {
            this.f3065b.a(th, true).add(th2);
        } else {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
    }
}
