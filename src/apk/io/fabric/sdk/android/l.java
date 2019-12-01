package io.fabric.sdk.android;

import android.content.Context;
import io.fabric.sdk.android.a.b.y;
import io.fabric.sdk.android.services.concurrency.j;
import io.fabric.sdk.android.services.concurrency.s;
import java.io.File;
import java.util.Collection;

/* compiled from: Kit */
public abstract class l<Result> implements Comparable<l> {
    Context context;
    final j dependsOnAnnotation = ((j) getClass().getAnnotation(j.class));
    f fabric;
    y idManager;
    j<Result> initializationCallback;
    k<Result> initializationTask = new k<>(this);

    /* access modifiers changed from: 0000 */
    public boolean containsAnnotatedDependency(l lVar) {
        if (hasAnnotatedDependency()) {
            for (Class isAssignableFrom : this.dependsOnAnnotation.value()) {
                if (isAssignableFrom.isAssignableFrom(lVar.getClass())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract Result doInBackground();

    public Context getContext() {
        return this.context;
    }

    /* access modifiers changed from: protected */
    public Collection<s> getDependencies() {
        return this.initializationTask.getDependencies();
    }

    public f getFabric() {
        return this.fabric;
    }

    /* access modifiers changed from: protected */
    public y getIdManager() {
        return this.idManager;
    }

    public abstract String getIdentifier();

    public String getPath() {
        StringBuilder sb = new StringBuilder();
        sb.append(".Fabric");
        sb.append(File.separator);
        sb.append(getIdentifier());
        return sb.toString();
    }

    public abstract String getVersion();

    /* access modifiers changed from: 0000 */
    public boolean hasAnnotatedDependency() {
        return this.dependsOnAnnotation != null;
    }

    /* access modifiers changed from: 0000 */
    public final void initialize() {
        this.initializationTask.a(this.fabric.b(), null);
    }

    /* access modifiers changed from: 0000 */
    public void injectParameters(Context context2, f fVar, j<Result> jVar, y yVar) {
        this.fabric = fVar;
        this.context = new g(context2, getIdentifier(), getPath());
        this.initializationCallback = jVar;
        this.idManager = yVar;
    }

    /* access modifiers changed from: protected */
    public void onCancelled(Result result) {
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Result result) {
    }

    /* access modifiers changed from: protected */
    public boolean onPreExecute() {
        return true;
    }

    public int compareTo(l lVar) {
        if (containsAnnotatedDependency(lVar)) {
            return 1;
        }
        if (lVar.containsAnnotatedDependency(this)) {
            return -1;
        }
        if (hasAnnotatedDependency() && !lVar.hasAnnotatedDependency()) {
            return 1;
        }
        if (hasAnnotatedDependency() || !lVar.hasAnnotatedDependency()) {
            return 0;
        }
        return -1;
    }
}
