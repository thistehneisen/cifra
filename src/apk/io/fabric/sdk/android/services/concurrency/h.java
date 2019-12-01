package io.fabric.sdk.android.services.concurrency;

import java.util.Collection;

/* compiled from: Dependency */
public interface h<T> {
    void addDependency(T t);

    boolean areDependenciesMet();

    Collection<T> getDependencies();
}
