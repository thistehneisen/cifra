package io.fabric.sdk.android.a.b;

import java.io.File;
import java.util.Comparator;

/* compiled from: CommonUtils */
class k implements Comparator<File> {
    k() {
    }

    /* renamed from: a */
    public int compare(File file, File file2) {
        return (int) (file.lastModified() - file2.lastModified());
    }
}
