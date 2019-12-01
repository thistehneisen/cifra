package l.a.d.b.a;

/* compiled from: LcLevel */
public enum e {
    VERBOSE(2),
    DEBUG(3),
    INFO(4),
    WARN(5),
    ERROR(6),
    ASSERT(7);
    
    private final int priority;

    private e(int i2) {
        this.priority = i2;
    }

    public boolean a(e eVar) {
        return this.priority < eVar.priority;
    }

    public int getPriority() {
        return this.priority;
    }
}
