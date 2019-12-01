package b.e.b;

import java.util.Arrays;

/* compiled from: SolverVariable */
public class i {

    /* renamed from: a reason: collision with root package name */
    private static int f2457a = 1;

    /* renamed from: b reason: collision with root package name */
    private String f2458b;

    /* renamed from: c reason: collision with root package name */
    public int f2459c = -1;

    /* renamed from: d reason: collision with root package name */
    int f2460d = -1;

    /* renamed from: e reason: collision with root package name */
    public int f2461e = 0;

    /* renamed from: f reason: collision with root package name */
    public float f2462f;

    /* renamed from: g reason: collision with root package name */
    float[] f2463g = new float[7];

    /* renamed from: h reason: collision with root package name */
    a f2464h;

    /* renamed from: i reason: collision with root package name */
    b[] f2465i = new b[8];

    /* renamed from: j reason: collision with root package name */
    int f2466j = 0;

    /* renamed from: k reason: collision with root package name */
    public int f2467k = 0;

    /* compiled from: SolverVariable */
    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public i(a aVar, String str) {
        this.f2464h = aVar;
    }

    static void a() {
        f2457a++;
    }

    public final void b(b bVar) {
        int i2 = this.f2466j;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f2465i[i3] == bVar) {
                for (int i4 = 0; i4 < (i2 - i3) - 1; i4++) {
                    b[] bVarArr = this.f2465i;
                    int i5 = i3 + i4;
                    bVarArr[i5] = bVarArr[i5 + 1];
                }
                this.f2466j--;
                return;
            }
        }
    }

    public final void c(b bVar) {
        int i2 = this.f2466j;
        for (int i3 = 0; i3 < i2; i3++) {
            b[] bVarArr = this.f2465i;
            bVarArr[i3].f2426d.a(bVarArr[i3], bVar, false);
        }
        this.f2466j = 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(this.f2458b);
        return sb.toString();
    }

    public final void a(b bVar) {
        int i2 = 0;
        while (true) {
            int i3 = this.f2466j;
            if (i2 >= i3) {
                b[] bVarArr = this.f2465i;
                if (i3 >= bVarArr.length) {
                    this.f2465i = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f2465i;
                int i4 = this.f2466j;
                bVarArr2[i4] = bVar;
                this.f2466j = i4 + 1;
                return;
            } else if (this.f2465i[i2] != bVar) {
                i2++;
            } else {
                return;
            }
        }
    }

    public void b() {
        this.f2458b = null;
        this.f2464h = a.UNKNOWN;
        this.f2461e = 0;
        this.f2459c = -1;
        this.f2460d = -1;
        this.f2462f = 0.0f;
        this.f2466j = 0;
        this.f2467k = 0;
    }

    public void a(a aVar, String str) {
        this.f2464h = aVar;
    }
}
