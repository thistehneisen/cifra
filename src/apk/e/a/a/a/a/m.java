package e.a.a.a.a;

import android.os.Looper;

/* compiled from: ThreadEnforcer */
class m implements n {
    m() {
    }

    public void a(d dVar) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Event bus ");
            sb.append(dVar);
            sb.append(" accessed from non-main thread ");
            sb.append(Looper.myLooper());
            throw new IllegalStateException(sb.toString());
        }
    }
}
