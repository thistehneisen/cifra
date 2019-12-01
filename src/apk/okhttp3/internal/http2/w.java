package okhttp3.internal.http2;

import java.util.Arrays;

/* compiled from: Settings */
public final class w {

    /* renamed from: a reason: collision with root package name */
    private int f10685a;

    /* renamed from: b reason: collision with root package name */
    private final int[] f10686b = new int[10];

    /* access modifiers changed from: 0000 */
    public void a() {
        this.f10685a = 0;
        Arrays.fill(this.f10686b, 0);
    }

    /* access modifiers changed from: 0000 */
    public int b() {
        if ((this.f10685a & 2) != 0) {
            return this.f10686b[1];
        }
        return -1;
    }

    /* access modifiers changed from: 0000 */
    public int c(int i2) {
        return (this.f10685a & 32) != 0 ? this.f10686b[5] : i2;
    }

    /* access modifiers changed from: 0000 */
    public boolean d(int i2) {
        return ((1 << i2) & this.f10685a) != 0;
    }

    /* access modifiers changed from: 0000 */
    public int b(int i2) {
        return (this.f10685a & 16) != 0 ? this.f10686b[4] : i2;
    }

    /* access modifiers changed from: 0000 */
    public int c() {
        if ((this.f10685a & 128) != 0) {
            return this.f10686b[7];
        }
        return 65535;
    }

    /* access modifiers changed from: 0000 */
    public int d() {
        return Integer.bitCount(this.f10685a);
    }

    /* access modifiers changed from: 0000 */
    public w a(int i2, int i3) {
        if (i2 >= 0) {
            int[] iArr = this.f10686b;
            if (i2 < iArr.length) {
                this.f10685a = (1 << i2) | this.f10685a;
                iArr[i2] = i3;
            }
        }
        return this;
    }

    /* access modifiers changed from: 0000 */
    public int a(int i2) {
        return this.f10686b[i2];
    }

    /* access modifiers changed from: 0000 */
    public void a(w wVar) {
        for (int i2 = 0; i2 < 10; i2++) {
            if (wVar.d(i2)) {
                a(i2, wVar.a(i2));
            }
        }
    }
}
