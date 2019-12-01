package androidx.appcompat.widget;

/* compiled from: RtlSpacingHelper */
class W {

    /* renamed from: a reason: collision with root package name */
    private int f909a = 0;

    /* renamed from: b reason: collision with root package name */
    private int f910b = 0;

    /* renamed from: c reason: collision with root package name */
    private int f911c = Integer.MIN_VALUE;

    /* renamed from: d reason: collision with root package name */
    private int f912d = Integer.MIN_VALUE;

    /* renamed from: e reason: collision with root package name */
    private int f913e = 0;

    /* renamed from: f reason: collision with root package name */
    private int f914f = 0;

    /* renamed from: g reason: collision with root package name */
    private boolean f915g = false;

    /* renamed from: h reason: collision with root package name */
    private boolean f916h = false;

    W() {
    }

    public int a() {
        return this.f915g ? this.f909a : this.f910b;
    }

    public int b() {
        return this.f909a;
    }

    public int c() {
        return this.f910b;
    }

    public int d() {
        return this.f915g ? this.f910b : this.f909a;
    }

    public void a(int i2, int i3) {
        this.f916h = false;
        if (i2 != Integer.MIN_VALUE) {
            this.f913e = i2;
            this.f909a = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f914f = i3;
            this.f910b = i3;
        }
    }

    public void b(int i2, int i3) {
        this.f911c = i2;
        this.f912d = i3;
        this.f916h = true;
        if (this.f915g) {
            if (i3 != Integer.MIN_VALUE) {
                this.f909a = i3;
            }
            if (i2 != Integer.MIN_VALUE) {
                this.f910b = i2;
                return;
            }
            return;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f909a = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f910b = i3;
        }
    }

    public void a(boolean z) {
        if (z != this.f915g) {
            this.f915g = z;
            if (!this.f916h) {
                this.f909a = this.f913e;
                this.f910b = this.f914f;
            } else if (z) {
                int i2 = this.f912d;
                if (i2 == Integer.MIN_VALUE) {
                    i2 = this.f913e;
                }
                this.f909a = i2;
                int i3 = this.f911c;
                if (i3 == Integer.MIN_VALUE) {
                    i3 = this.f914f;
                }
                this.f910b = i3;
            } else {
                int i4 = this.f911c;
                if (i4 == Integer.MIN_VALUE) {
                    i4 = this.f913e;
                }
                this.f909a = i4;
                int i5 = this.f912d;
                if (i5 == Integer.MIN_VALUE) {
                    i5 = this.f914f;
                }
                this.f910b = i5;
            }
        }
    }
}
