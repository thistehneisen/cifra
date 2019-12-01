package com.crashlytics.android.core;

class ProcMapEntry {
    public final long address;
    public final String path;
    public final String perms;
    public final long size;

    public ProcMapEntry(long j2, long j3, String str, String str2) {
        this.address = j2;
        this.size = j3;
        this.perms = str;
        this.path = str2;
    }
}
