package com.appsflyer;

final class l {

    /* renamed from: ˊ reason: contains not printable characters */
    private String f180;

    /* renamed from: ˎ reason: contains not printable characters */
    private e f181;

    /* renamed from: ॱ reason: contains not printable characters */
    private boolean f182;

    enum e {
        GOOGLE(0),
        AMAZON(1);
        

        /* renamed from: ˋ reason: contains not printable characters */
        private int f186;

        private e(int i2) {
            this.f186 = i2;
        }

        public final String toString() {
            return String.valueOf(this.f186);
        }
    }

    l(e eVar, String str, boolean z) {
        this.f181 = eVar;
        this.f180 = str;
        this.f182 = z;
    }

    public final String toString() {
        return String.format("%s,%s", new Object[]{this.f180, Boolean.valueOf(this.f182)});
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˎ reason: contains not printable characters */
    public final String m156() {
        return this.f180;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˏ reason: contains not printable characters */
    public final boolean m157() {
        return this.f182;
    }
}
