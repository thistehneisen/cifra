package b.e.b.a;

import java.util.Arrays;

/* compiled from: HelperWidget */
public class n extends h implements m {
    protected h[] sa = new h[4];
    protected int ta = 0;

    public void a(h hVar) {
        int i2 = this.ta + 1;
        h[] hVarArr = this.sa;
        if (i2 > hVarArr.length) {
            this.sa = (h[]) Arrays.copyOf(hVarArr, hVarArr.length * 2);
        }
        h[] hVarArr2 = this.sa;
        int i3 = this.ta;
        hVarArr2[i3] = hVar;
        this.ta = i3 + 1;
    }

    public void a() {
        this.ta = 0;
    }
}
