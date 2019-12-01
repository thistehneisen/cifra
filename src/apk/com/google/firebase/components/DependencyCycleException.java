package com.google.firebase.components;

import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.firebase:firebase-common@@17.0.0 */
public class DependencyCycleException extends DependencyException {
    private final List<e<?>> componentsInCycle;

    public DependencyCycleException(List<e<?>> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("Dependency cycle detected: ");
        sb.append(Arrays.toString(list.toArray()));
        super(sb.toString());
        this.componentsInCycle = list;
    }
}
