package kotlin.f;

import java.util.NoSuchElementException;
import kotlin.a.t;

/* compiled from: ProgressionIterators.kt */
public final class c extends t {

    /* renamed from: a reason: collision with root package name */
    private final int f10315a;

    /* renamed from: b reason: collision with root package name */
    private boolean f10316b;

    /* renamed from: c reason: collision with root package name */
    private int f10317c;

    /* renamed from: d reason: collision with root package name */
    private final int f10318d;

    public c(int i2, int i3, int i4) {
        this.f10318d = i4;
        this.f10315a = i3;
        boolean z = true;
        if (this.f10318d <= 0 ? i2 < i3 : i2 > i3) {
            z = false;
        }
        this.f10316b = z;
        if (!this.f10316b) {
            i2 = this.f10315a;
        }
        this.f10317c = i2;
    }

    public boolean hasNext() {
        return this.f10316b;
    }

    public int nextInt() {
        int i2 = this.f10317c;
        if (i2 != this.f10315a) {
            this.f10317c = this.f10318d + i2;
        } else if (this.f10316b) {
            this.f10316b = false;
        } else {
            throw new NoSuchElementException();
        }
        return i2;
    }
}
