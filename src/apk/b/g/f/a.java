package b.g.f;

import android.util.Base64;
import b.g.h.g;
import java.util.List;

/* compiled from: FontRequest */
public final class a {

    /* renamed from: a reason: collision with root package name */
    private final String f2526a;

    /* renamed from: b reason: collision with root package name */
    private final String f2527b;

    /* renamed from: c reason: collision with root package name */
    private final String f2528c;

    /* renamed from: d reason: collision with root package name */
    private final List<List<byte[]>> f2529d;

    /* renamed from: e reason: collision with root package name */
    private final int f2530e = 0;

    /* renamed from: f reason: collision with root package name */
    private final String f2531f;

    public a(String str, String str2, String str3, List<List<byte[]>> list) {
        g.a(str);
        this.f2526a = str;
        g.a(str2);
        this.f2527b = str2;
        g.a(str3);
        this.f2528c = str3;
        g.a(list);
        this.f2529d = list;
        StringBuilder sb = new StringBuilder(this.f2526a);
        String str4 = "-";
        sb.append(str4);
        sb.append(this.f2527b);
        sb.append(str4);
        sb.append(this.f2528c);
        this.f2531f = sb.toString();
    }

    public List<List<byte[]>> a() {
        return this.f2529d;
    }

    public int b() {
        return this.f2530e;
    }

    public String c() {
        return this.f2531f;
    }

    public String d() {
        return this.f2526a;
    }

    public String e() {
        return this.f2527b;
    }

    public String f() {
        return this.f2528c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("FontRequest {mProviderAuthority: ");
        sb2.append(this.f2526a);
        sb2.append(", mProviderPackage: ");
        sb2.append(this.f2527b);
        sb2.append(", mQuery: ");
        sb2.append(this.f2528c);
        sb2.append(", mCertificates:");
        sb.append(sb2.toString());
        for (int i2 = 0; i2 < this.f2529d.size(); i2++) {
            sb.append(" [");
            List list = (List) this.f2529d.get(i2);
            for (int i3 = 0; i3 < list.size(); i3++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list.get(i3), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        StringBuilder sb3 = new StringBuilder();
        sb3.append("mCertificatesArray: ");
        sb3.append(this.f2530e);
        sb.append(sb3.toString());
        return sb.toString();
    }
}
