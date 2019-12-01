package b.m;

import java.io.File;
import java.io.FileFilter;

/* compiled from: MultiDexExtractor */
class b implements FileFilter {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ c f2793a;

    b(c cVar) {
        this.f2793a = cVar;
    }

    public boolean accept(File file) {
        return !file.getName().equals("MultiDex.lock");
    }
}
