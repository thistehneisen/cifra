package b.p;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TransitionValues */
public class M {

    /* renamed from: a reason: collision with root package name */
    public final Map<String, Object> f2839a = new HashMap();

    /* renamed from: b reason: collision with root package name */
    public View f2840b;

    /* renamed from: c reason: collision with root package name */
    final ArrayList<E> f2841c = new ArrayList<>();

    public boolean equals(Object obj) {
        if (obj instanceof M) {
            M m = (M) obj;
            if (this.f2840b == m.f2840b && this.f2839a.equals(m.f2839a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.f2840b.hashCode() * 31) + this.f2839a.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TransitionValues@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(":\n");
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(sb2);
        sb3.append("    view = ");
        sb3.append(this.f2840b);
        String str = "\n";
        sb3.append(str);
        String sb4 = sb3.toString();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(sb4);
        sb5.append("    values:");
        String sb6 = sb5.toString();
        for (String str2 : this.f2839a.keySet()) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append(sb6);
            sb7.append("    ");
            sb7.append(str2);
            sb7.append(": ");
            sb7.append(this.f2839a.get(str2));
            sb7.append(str);
            sb6 = sb7.toString();
        }
        return sb6;
    }
}
