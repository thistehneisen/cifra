package e.b.b;

/* compiled from: RunnableDisposable */
final class e extends d<Runnable> {
    private static final long serialVersionUID = -8219729196779211169L;

    e(Runnable runnable) {
        super(runnable);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RunnableDisposable(disposed=");
        sb.append(a());
        sb.append(", ");
        sb.append(get());
        sb.append(")");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public void a(Runnable runnable) {
        runnable.run();
    }
}
