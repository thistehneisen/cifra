package com.crashlytics.android.core;

interface FileLogStore {
    void closeLogFile();

    void deleteLogFile();

    ByteString getLogAsByteString();

    byte[] getLogAsBytes();

    void writeToLog(long j2, String str);
}
