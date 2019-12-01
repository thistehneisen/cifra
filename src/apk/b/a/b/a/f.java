package b.a.b.a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;

/* compiled from: StateListDrawable */
class f extends d {
    private a n;
    private boolean o;

    /* compiled from: StateListDrawable */
    static class a extends b {
        int[][] J;

        a(a aVar, f fVar, Resources resources) {
            super(aVar, fVar, resources);
            if (aVar != null) {
                this.J = aVar.J;
            } else {
                this.J = new int[c()][];
            }
        }

        /* access modifiers changed from: 0000 */
        public int a(int[] iArr, Drawable drawable) {
            int a2 = a(drawable);
            this.J[a2] = iArr;
            return a2;
        }

        /* access modifiers changed from: 0000 */
        public void m() {
            int[][] iArr = this.J;
            int[][] iArr2 = new int[iArr.length][];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[][] iArr3 = this.J;
                iArr2[length] = iArr3[length] != null ? (int[]) iArr3[length].clone() : null;
            }
            this.J = iArr2;
        }

        public Drawable newDrawable() {
            return new f(this, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new f(this, resources);
        }

        /* access modifiers changed from: 0000 */
        public int a(int[] iArr) {
            int[][] iArr2 = this.J;
            int d2 = d();
            for (int i2 = 0; i2 < d2; i2++) {
                if (StateSet.stateSetMatches(iArr2[i2], iArr)) {
                    return i2;
                }
            }
            return -1;
        }

        public void a(int i2, int i3) {
            super.a(i2, i3);
            int[][] iArr = new int[i3][];
            System.arraycopy(this.J, 0, iArr, 0, i2);
            this.J = iArr;
        }
    }

    f(a aVar, Resources resources) {
        a((b) new a(aVar, this, resources));
        onStateChange(getState());
    }

    public void applyTheme(Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    public boolean isStateful() {
        return true;
    }

    public Drawable mutate() {
        if (!this.o) {
            super.mutate();
            if (this == this) {
                this.n.m();
                this.o = true;
            }
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int a2 = this.n.a(iArr);
        if (a2 < 0) {
            a2 = this.n.a(StateSet.WILD_CARD);
        }
        return a(a2) || onStateChange;
    }

    /* access modifiers changed from: 0000 */
    public int[] a(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i2 = 0;
        for (int i3 = 0; i3 < attributeCount; i3++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i3);
            if (!(attributeNameResource == 0 || attributeNameResource == 16842960 || attributeNameResource == 16843161)) {
                int i4 = i2 + 1;
                if (!attributeSet.getAttributeBooleanValue(i3, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i2] = attributeNameResource;
                i2 = i4;
            }
        }
        return StateSet.trimStateSet(iArr, i2);
    }

    f(a aVar) {
        if (aVar != null) {
            a((b) aVar);
        }
    }

    /* access modifiers changed from: 0000 */
    public a a() {
        return new a(this.n, this, null);
    }

    /* access modifiers changed from: protected */
    public void a(b bVar) {
        super.a(bVar);
        if (bVar instanceof a) {
            this.n = (a) bVar;
        }
    }
}
