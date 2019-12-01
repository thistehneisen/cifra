package io.fabric.sdk.android.a.d;

import android.content.Context;
import io.fabric.sdk.android.f;
import io.fabric.sdk.android.l;
import java.io.File;

/* compiled from: FileStoreImpl */
public class b implements a {

    /* renamed from: a reason: collision with root package name */
    private final Context f8890a;

    /* renamed from: b reason: collision with root package name */
    private final String f8891b;

    /* renamed from: c reason: collision with root package name */
    private final String f8892c;

    public b(l lVar) {
        if (lVar.getContext() != null) {
            this.f8890a = lVar.getContext();
            this.f8891b = lVar.getPath();
            StringBuilder sb = new StringBuilder();
            sb.append("Android/");
            sb.append(this.f8890a.getPackageName());
            this.f8892c = sb.toString();
            return;
        }
        throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
    }

    public File a() {
        return a(this.f8890a.getFilesDir());
    }

    /* access modifiers changed from: 0000 */
    public File a(File file) {
        String str = "Fabric";
        if (file == null) {
            f.e().d(str, "Null File");
        } else if (file.exists() || file.mkdirs()) {
            return file;
        } else {
            f.e().a(str, "Couldn't create file");
        }
        return null;
    }
}
