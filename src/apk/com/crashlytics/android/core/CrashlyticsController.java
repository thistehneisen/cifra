package com.crashlytics.android.core;

import android.app.Activity;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.EventLogger;
import com.crashlytics.android.core.LogFileManager.DirectoryProvider;
import io.fabric.sdk.android.a.b.m;
import io.fabric.sdk.android.a.b.m.b;
import io.fabric.sdk.android.a.b.y;
import io.fabric.sdk.android.a.d.a;
import io.fabric.sdk.android.a.e.e;
import io.fabric.sdk.android.a.e.n;
import io.fabric.sdk.android.a.e.p;
import io.fabric.sdk.android.a.e.q;
import io.fabric.sdk.android.a.e.s;
import io.fabric.sdk.android.a.e.v;
import io.fabric.sdk.android.f;
import io.fabric.sdk.android.l;
import io.fabric.sdk.android.o;
import io.fabric.sdk.android.services.network.g;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

class CrashlyticsController {
    private static final int ANALYZER_VERSION = 1;
    private static final String COLLECT_CUSTOM_KEYS = "com.crashlytics.CollectCustomKeys";
    private static final String CRASHLYTICS_API_ENDPOINT = "com.crashlytics.ApiEndpoint";
    private static final String EVENT_TYPE_CRASH = "crash";
    private static final String EVENT_TYPE_LOGGED = "error";
    static final String FATAL_SESSION_DIR = "fatal-sessions";
    static final String FIREBASE_ANALYTICS_ORIGIN_CRASHLYTICS = "clx";
    static final String FIREBASE_APPLICATION_EXCEPTION = "_ae";
    static final String FIREBASE_CRASH_TYPE = "fatal";
    static final int FIREBASE_CRASH_TYPE_FATAL = 1;
    static final String FIREBASE_REALTIME = "_r";
    static final String FIREBASE_TIMESTAMP = "timestamp";
    private static final String GENERATOR_FORMAT = "Crashlytics Android SDK/%s";
    private static final String[] INITIAL_SESSION_PART_TAGS = {SESSION_USER_TAG, SESSION_APP_TAG, SESSION_OS_TAG, SESSION_DEVICE_TAG};
    static final String INVALID_CLS_CACHE_DIR = "invalidClsFiles";
    static final Comparator<File> LARGEST_FILE_NAME_FIRST = new Comparator<File>() {
        public int compare(File file, File file2) {
            return file2.getName().compareTo(file.getName());
        }
    };
    static final int MAX_INVALID_SESSIONS = 4;
    private static final int MAX_LOCAL_LOGGED_EXCEPTIONS = 64;
    static final int MAX_OPEN_SESSIONS = 8;
    static final int MAX_STACK_SIZE = 1024;
    static final String NONFATAL_SESSION_DIR = "nonfatal-sessions";
    static final int NUM_STACK_REPETITIONS_ALLOWED = 10;
    private static final Map<String, String> SEND_AT_CRASHTIME_HEADER = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");
    static final String SESSION_APP_TAG = "SessionApp";
    static final FilenameFilter SESSION_BEGIN_FILE_FILTER = new FileNameContainsFilter(SESSION_BEGIN_TAG) {
        public boolean accept(File file, String str) {
            return super.accept(file, str) && str.endsWith(ClsFileOutputStream.SESSION_FILE_EXTENSION);
        }
    };
    static final String SESSION_BEGIN_TAG = "BeginSession";
    static final String SESSION_DEVICE_TAG = "SessionDevice";
    static final FileFilter SESSION_DIRECTORY_FILTER = new FileFilter() {
        public boolean accept(File file) {
            return file.isDirectory() && file.getName().length() == 35;
        }
    };
    static final String SESSION_EVENT_MISSING_BINARY_IMGS_TAG = "SessionMissingBinaryImages";
    static final String SESSION_FATAL_TAG = "SessionCrash";
    static final FilenameFilter SESSION_FILE_FILTER = new FilenameFilter() {
        public boolean accept(File file, String str) {
            return str.length() == 39 && str.endsWith(ClsFileOutputStream.SESSION_FILE_EXTENSION);
        }
    };
    /* access modifiers changed from: private */
    public static final Pattern SESSION_FILE_PATTERN = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
    private static final int SESSION_ID_LENGTH = 35;
    static final String SESSION_JSON_SUFFIX = ".json";
    static final String SESSION_NON_FATAL_TAG = "SessionEvent";
    static final String SESSION_OS_TAG = "SessionOS";
    static final String SESSION_USER_TAG = "SessionUser";
    private static final boolean SHOULD_PROMPT_BEFORE_SENDING_REPORTS_DEFAULT = false;
    static final Comparator<File> SMALLEST_FILE_NAME_FIRST = new Comparator<File>() {
        public int compare(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    };
    /* access modifiers changed from: private */
    public final AppData appData;
    private final AppMeasurementEventListenerRegistrar appMeasurementEventListenerRegistrar;
    private final CrashlyticsBackgroundWorker backgroundWorker;
    private CrashlyticsUncaughtExceptionHandler crashHandler;
    /* access modifiers changed from: private */
    public final CrashlyticsCore crashlyticsCore;
    private final DevicePowerStateListener devicePowerStateListener;
    private final AtomicInteger eventCounter = new AtomicInteger(0);
    private final a fileStore;
    private final EventLogger firebaseAnalyticsLogger;
    private final HandlingExceptionCheck handlingExceptionCheck;
    private final g httpRequestFactory;
    private final y idManager;
    private final LogFileDirectoryProvider logFileDirectoryProvider;
    /* access modifiers changed from: private */
    public final LogFileManager logFileManager;
    private final PreferenceManager preferenceManager;
    private final ReportFilesProvider reportFilesProvider;
    private final StackTraceTrimmingStrategy stackTraceTrimmingStrategy;
    /* access modifiers changed from: private */
    public final String unityVersion;

    private static class AnySessionPartFileFilter implements FilenameFilter {
        private AnySessionPartFileFilter() {
        }

        public boolean accept(File file, String str) {
            return !CrashlyticsController.SESSION_FILE_FILTER.accept(file, str) && CrashlyticsController.SESSION_FILE_PATTERN.matcher(str).matches();
        }
    }

    private interface CodedOutputStreamWriteAction {
        void writeTo(CodedOutputStream codedOutputStream) throws Exception;
    }

    private static final class DefaultSettingsDataProvider implements SettingsDataProvider {
        private DefaultSettingsDataProvider() {
        }

        public v getSettingsData() {
            return s.b().a();
        }
    }

    static class FileNameContainsFilter implements FilenameFilter {
        private final String string;

        public FileNameContainsFilter(String str) {
            this.string = str;
        }

        public boolean accept(File file, String str) {
            return str.contains(this.string) && !str.endsWith(ClsFileOutputStream.IN_PROGRESS_SESSION_FILE_EXTENSION);
        }
    }

    private interface FileOutputStreamWriteAction {
        void writeTo(FileOutputStream fileOutputStream) throws Exception;
    }

    static class InvalidPartFileFilter implements FilenameFilter {
        InvalidPartFileFilter() {
        }

        public boolean accept(File file, String str) {
            return ClsFileOutputStream.TEMP_FILENAME_FILTER.accept(file, str) || str.contains(CrashlyticsController.SESSION_EVENT_MISSING_BINARY_IMGS_TAG);
        }
    }

    private static final class LogFileDirectoryProvider implements DirectoryProvider {
        private static final String LOG_FILES_DIR = "log-files";
        private final a rootFileStore;

        public LogFileDirectoryProvider(a aVar) {
            this.rootFileStore = aVar;
        }

        public File getLogFileDir() {
            File file = new File(this.rootFileStore.a(), LOG_FILES_DIR);
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    private static final class PrivacyDialogCheck implements SendCheck {
        private final l kit;
        /* access modifiers changed from: private */
        public final PreferenceManager preferenceManager;
        private final p promptData;

        public PrivacyDialogCheck(l lVar, PreferenceManager preferenceManager2, p pVar) {
            this.kit = lVar;
            this.preferenceManager = preferenceManager2;
            this.promptData = pVar;
        }

        public boolean canSendReports() {
            Activity a2 = this.kit.getFabric().a();
            if (a2 == null || a2.isFinishing()) {
                return true;
            }
            final CrashPromptDialog create = CrashPromptDialog.create(a2, this.promptData, new AlwaysSendCallback() {
                public void sendUserReportsWithoutPrompting(boolean z) {
                    PrivacyDialogCheck.this.preferenceManager.setShouldAlwaysSendReports(z);
                }
            });
            a2.runOnUiThread(new Runnable() {
                public void run() {
                    create.show();
                }
            });
            f.e().d(CrashlyticsCore.TAG, "Waiting for user opt-in.");
            create.await();
            return create.getOptIn();
        }
    }

    private final class ReportUploaderFilesProvider implements ReportFilesProvider {
        private ReportUploaderFilesProvider() {
        }

        public File[] getCompleteSessionFiles() {
            return CrashlyticsController.this.listCompleteSessionFiles();
        }

        public File[] getInvalidSessionFiles() {
            return CrashlyticsController.this.getInvalidFilesDir().listFiles();
        }

        public File[] getNativeReportFiles() {
            return CrashlyticsController.this.listNativeSessionFileDirectories();
        }
    }

    private final class ReportUploaderHandlingExceptionCheck implements HandlingExceptionCheck {
        private ReportUploaderHandlingExceptionCheck() {
        }

        public boolean isHandlingException() {
            return CrashlyticsController.this.isHandlingException();
        }
    }

    private static final class SendReportRunnable implements Runnable {
        private final Context context;
        private final Report report;
        private final ReportUploader reportUploader;

        public SendReportRunnable(Context context2, Report report2, ReportUploader reportUploader2) {
            this.context = context2;
            this.report = report2;
            this.reportUploader = reportUploader2;
        }

        public void run() {
            if (io.fabric.sdk.android.a.b.l.b(this.context)) {
                f.e().d(CrashlyticsCore.TAG, "Attempting to send crash report at time of crash...");
                this.reportUploader.forceUpload(this.report);
            }
        }
    }

    static class SessionPartFileFilter implements FilenameFilter {
        private final String sessionId;

        public SessionPartFileFilter(String str) {
            this.sessionId = str;
        }

        public boolean accept(File file, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.sessionId);
            sb.append(ClsFileOutputStream.SESSION_FILE_EXTENSION);
            boolean z = false;
            if (str.equals(sb.toString())) {
                return false;
            }
            if (str.contains(this.sessionId) && !str.endsWith(ClsFileOutputStream.IN_PROGRESS_SESSION_FILE_EXTENSION)) {
                z = true;
            }
            return z;
        }
    }

    CrashlyticsController(CrashlyticsCore crashlyticsCore2, CrashlyticsBackgroundWorker crashlyticsBackgroundWorker, g gVar, y yVar, PreferenceManager preferenceManager2, a aVar, AppData appData2, UnityVersionProvider unityVersionProvider, AppMeasurementEventListenerRegistrar appMeasurementEventListenerRegistrar2, EventLogger eventLogger) {
        this.crashlyticsCore = crashlyticsCore2;
        this.backgroundWorker = crashlyticsBackgroundWorker;
        this.httpRequestFactory = gVar;
        this.idManager = yVar;
        this.preferenceManager = preferenceManager2;
        this.fileStore = aVar;
        this.appData = appData2;
        this.unityVersion = unityVersionProvider.getUnityVersion();
        this.appMeasurementEventListenerRegistrar = appMeasurementEventListenerRegistrar2;
        this.firebaseAnalyticsLogger = eventLogger;
        Context context = crashlyticsCore2.getContext();
        this.logFileDirectoryProvider = new LogFileDirectoryProvider(aVar);
        this.logFileManager = new LogFileManager(context, this.logFileDirectoryProvider);
        this.reportFilesProvider = new ReportUploaderFilesProvider();
        this.handlingExceptionCheck = new ReportUploaderHandlingExceptionCheck();
        this.devicePowerStateListener = new DevicePowerStateListener(context);
        this.stackTraceTrimmingStrategy = new MiddleOutFallbackStrategy(MAX_STACK_SIZE, new RemoveRepeatsStrategy(10));
    }

    private void closeOpenSessions(File[] fileArr, int i2, int i3) {
        o e2 = f.e();
        String str = CrashlyticsCore.TAG;
        e2.d(str, "Closing open sessions.");
        while (i2 < fileArr.length) {
            File file = fileArr[i2];
            String sessionIdFromSessionFile = getSessionIdFromSessionFile(file);
            o e3 = f.e();
            StringBuilder sb = new StringBuilder();
            sb.append("Closing session: ");
            sb.append(sessionIdFromSessionFile);
            e3.d(str, sb.toString());
            writeSessionPartsToSessionFile(file, sessionIdFromSessionFile, i3);
            i2++;
        }
    }

    private void closeWithoutRenamingOrLog(ClsFileOutputStream clsFileOutputStream) {
        if (clsFileOutputStream != null) {
            try {
                clsFileOutputStream.closeInProgressStream();
            } catch (IOException e2) {
                f.e().b(CrashlyticsCore.TAG, "Error closing session file stream in the presence of an exception", e2);
            }
        }
    }

    private static void copyToCodedOutputStream(InputStream inputStream, CodedOutputStream codedOutputStream, int i2) throws IOException {
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (i3 < bArr.length) {
            int read = inputStream.read(bArr, i3, bArr.length - i3);
            if (read < 0) {
                break;
            }
            i3 += read;
        }
        codedOutputStream.writeRawBytes(bArr);
    }

    private void deleteSessionPartFilesFor(String str) {
        for (File delete : listSessionPartFilesFor(str)) {
            delete.delete();
        }
    }

    /* access modifiers changed from: private */
    public void doOpenSession() throws Exception {
        Date date = new Date();
        String clsuuid = new CLSUUID(this.idManager).toString();
        o e2 = f.e();
        StringBuilder sb = new StringBuilder();
        sb.append("Opening a new session with ID ");
        sb.append(clsuuid);
        e2.d(CrashlyticsCore.TAG, sb.toString());
        writeBeginSession(clsuuid, date);
        writeSessionApp(clsuuid);
        writeSessionOS(clsuuid);
        writeSessionDevice(clsuuid);
        this.logFileManager.setCurrentSession(clsuuid);
    }

    /* access modifiers changed from: private */
    public void doWriteNonFatal(Date date, Thread thread, Throwable th) {
        ClsFileOutputStream clsFileOutputStream;
        String str = "Failed to close non-fatal file output stream.";
        String str2 = "Failed to flush to non-fatal file.";
        String currentSessionId = getCurrentSessionId();
        CodedOutputStream codedOutputStream = null;
        String str3 = CrashlyticsCore.TAG;
        if (currentSessionId == null) {
            f.e().b(str3, "Tried to write a non-fatal exception while no session was open.", null);
            return;
        }
        recordLoggedExceptionAnswersEvent(currentSessionId, th.getClass().getName());
        try {
            o e2 = f.e();
            StringBuilder sb = new StringBuilder();
            sb.append("Crashlytics is logging non-fatal exception \"");
            sb.append(th);
            sb.append("\" from thread ");
            sb.append(thread.getName());
            e2.d(str3, sb.toString());
            String b2 = io.fabric.sdk.android.a.b.l.b(this.eventCounter.getAndIncrement());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(currentSessionId);
            sb2.append(SESSION_NON_FATAL_TAG);
            sb2.append(b2);
            clsFileOutputStream = new ClsFileOutputStream(getFilesDir(), sb2.toString());
            try {
                CodedOutputStream newInstance = CodedOutputStream.newInstance((OutputStream) clsFileOutputStream);
                try {
                    writeSessionEvent(newInstance, date, thread, th, EVENT_TYPE_LOGGED, false);
                    io.fabric.sdk.android.a.b.l.a((Flushable) newInstance, str2);
                } catch (Exception e3) {
                    e = e3;
                    codedOutputStream = newInstance;
                    try {
                        f.e().b(str3, "An error occurred in the non-fatal exception logger", e);
                        io.fabric.sdk.android.a.b.l.a((Flushable) codedOutputStream, str2);
                        io.fabric.sdk.android.a.b.l.a((Closeable) clsFileOutputStream, str);
                        trimSessionEventFiles(currentSessionId, 64);
                    } catch (Throwable th2) {
                        th = th2;
                        io.fabric.sdk.android.a.b.l.a((Flushable) codedOutputStream, str2);
                        io.fabric.sdk.android.a.b.l.a((Closeable) clsFileOutputStream, str);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    codedOutputStream = newInstance;
                    io.fabric.sdk.android.a.b.l.a((Flushable) codedOutputStream, str2);
                    io.fabric.sdk.android.a.b.l.a((Closeable) clsFileOutputStream, str);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                f.e().b(str3, "An error occurred in the non-fatal exception logger", e);
                io.fabric.sdk.android.a.b.l.a((Flushable) codedOutputStream, str2);
                io.fabric.sdk.android.a.b.l.a((Closeable) clsFileOutputStream, str);
                trimSessionEventFiles(currentSessionId, 64);
            }
        } catch (Exception e5) {
            e = e5;
            clsFileOutputStream = null;
            f.e().b(str3, "An error occurred in the non-fatal exception logger", e);
            io.fabric.sdk.android.a.b.l.a((Flushable) codedOutputStream, str2);
            io.fabric.sdk.android.a.b.l.a((Closeable) clsFileOutputStream, str);
            trimSessionEventFiles(currentSessionId, 64);
        } catch (Throwable th4) {
            th = th4;
            clsFileOutputStream = null;
            io.fabric.sdk.android.a.b.l.a((Flushable) codedOutputStream, str2);
            io.fabric.sdk.android.a.b.l.a((Closeable) clsFileOutputStream, str);
            throw th;
        }
        io.fabric.sdk.android.a.b.l.a((Closeable) clsFileOutputStream, str);
        try {
            trimSessionEventFiles(currentSessionId, 64);
        } catch (Exception e6) {
            f.e().b(str3, "An error occurred when trimming non-fatal files.", e6);
        }
    }

    private File[] ensureFileArrayNotNull(File[] fileArr) {
        return fileArr == null ? new File[0] : fileArr;
    }

    /* access modifiers changed from: private */
    public void finalizeMostRecentNativeCrash(Context context, File file, String str) throws IOException {
        byte[] minidumpFromDirectory = NativeFileUtils.minidumpFromDirectory(file);
        byte[] metadataJsonFromDirectory = NativeFileUtils.metadataJsonFromDirectory(file);
        byte[] binaryImagesJsonFromDirectory = NativeFileUtils.binaryImagesJsonFromDirectory(file, context);
        String str2 = CrashlyticsCore.TAG;
        if (minidumpFromDirectory == null || minidumpFromDirectory.length == 0) {
            o e2 = f.e();
            StringBuilder sb = new StringBuilder();
            sb.append("No minidump data found in directory ");
            sb.append(file);
            e2.a(str2, sb.toString());
            return;
        }
        recordFatalExceptionAnswersEvent(str, "<native-crash: minidump>");
        byte[] readFile = readFile(str, "BeginSession.json");
        byte[] readFile2 = readFile(str, "SessionApp.json");
        byte[] readFile3 = readFile(str, "SessionDevice.json");
        byte[] readFile4 = readFile(str, "SessionOS.json");
        byte[] readFile5 = NativeFileUtils.readFile(new MetaDataStore(getFilesDir()).getUserDataFileForSession(str));
        LogFileManager logFileManager2 = new LogFileManager(this.crashlyticsCore.getContext(), this.logFileDirectoryProvider, str);
        byte[] bytesForLog = logFileManager2.getBytesForLog();
        logFileManager2.clearLog();
        byte[] readFile6 = NativeFileUtils.readFile(new MetaDataStore(getFilesDir()).getKeysFileForSession(str));
        File file2 = new File(this.fileStore.a(), str);
        if (!file2.mkdir()) {
            f.e().d(str2, "Couldn't create native sessions directory");
            return;
        }
        gzipIfNotEmpty(minidumpFromDirectory, new File(file2, "minidump"));
        gzipIfNotEmpty(metadataJsonFromDirectory, new File(file2, "metadata"));
        gzipIfNotEmpty(binaryImagesJsonFromDirectory, new File(file2, "binaryImages"));
        gzipIfNotEmpty(readFile, new File(file2, "session"));
        gzipIfNotEmpty(readFile2, new File(file2, "app"));
        gzipIfNotEmpty(readFile3, new File(file2, "device"));
        gzipIfNotEmpty(readFile4, new File(file2, "os"));
        gzipIfNotEmpty(readFile5, new File(file2, "user"));
        gzipIfNotEmpty(bytesForLog, new File(file2, "logs"));
        gzipIfNotEmpty(readFile6, new File(file2, "keys"));
    }

    private boolean firebaseCrashExists() {
        try {
            Class.forName("com.google.firebase.crash.FirebaseCrash");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private CreateReportSpiCall getCreateReportSpiCall(String str, String str2) {
        String b2 = io.fabric.sdk.android.a.b.l.b(this.crashlyticsCore.getContext(), CRASHLYTICS_API_ENDPOINT);
        return new CompositeCreateReportSpiCall(new DefaultCreateReportSpiCall(this.crashlyticsCore, b2, str, this.httpRequestFactory), new NativeCreateReportSpiCall(this.crashlyticsCore, b2, str2, this.httpRequestFactory));
    }

    /* access modifiers changed from: private */
    public String getCurrentSessionId() {
        File[] listSortedSessionBeginFiles = listSortedSessionBeginFiles();
        if (listSortedSessionBeginFiles.length > 0) {
            return getSessionIdFromSessionFile(listSortedSessionBeginFiles[0]);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public String getPreviousSessionId() {
        File[] listSortedSessionBeginFiles = listSortedSessionBeginFiles();
        if (listSortedSessionBeginFiles.length > 1) {
            return getSessionIdFromSessionFile(listSortedSessionBeginFiles[1]);
        }
        return null;
    }

    static String getSessionIdFromSessionFile(File file) {
        return file.getName().substring(0, 35);
    }

    private File[] getTrimmedNonFatalFiles(String str, File[] fileArr, int i2) {
        if (fileArr.length <= i2) {
            return fileArr;
        }
        f.e().d(CrashlyticsCore.TAG, String.format(Locale.US, "Trimming down to %d logged exceptions.", new Object[]{Integer.valueOf(i2)}));
        trimSessionEventFiles(str, i2);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(SESSION_NON_FATAL_TAG);
        return listFilesMatching((FilenameFilter) new FileNameContainsFilter(sb.toString()));
    }

    private UserMetaData getUserMetaData(String str) {
        if (isHandlingException()) {
            return new UserMetaData(this.crashlyticsCore.getUserIdentifier(), this.crashlyticsCore.getUserName(), this.crashlyticsCore.getUserEmail());
        }
        return new MetaDataStore(getFilesDir()).readUserData(str);
    }

    private void gzip(byte[] bArr, File file) throws IOException {
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(new FileOutputStream(file));
            try {
                gZIPOutputStream2.write(bArr);
                gZIPOutputStream2.finish();
                io.fabric.sdk.android.a.b.l.a((Closeable) gZIPOutputStream2);
            } catch (Throwable th) {
                th = th;
                gZIPOutputStream = gZIPOutputStream2;
                io.fabric.sdk.android.a.b.l.a((Closeable) gZIPOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            io.fabric.sdk.android.a.b.l.a((Closeable) gZIPOutputStream);
            throw th;
        }
    }

    private void gzipIfNotEmpty(byte[] bArr, File file) throws IOException {
        if (bArr != null && bArr.length > 0) {
            gzip(bArr, file);
        }
    }

    private File[] listFiles(File file) {
        return ensureFileArrayNotNull(file.listFiles());
    }

    private File[] listFilesMatching(FileFilter fileFilter) {
        return ensureFileArrayNotNull(getFilesDir().listFiles(fileFilter));
    }

    private File[] listSessionPartFilesFor(String str) {
        return listFilesMatching((FilenameFilter) new SessionPartFileFilter(str));
    }

    private File[] listSortedSessionBeginFiles() {
        File[] listSessionBeginFiles = listSessionBeginFiles();
        Arrays.sort(listSessionBeginFiles, LARGEST_FILE_NAME_FIRST);
        return listSessionBeginFiles;
    }

    private byte[] readFile(String str, String str2) {
        File filesDir = getFilesDir();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return NativeFileUtils.readFile(new File(filesDir, sb.toString()));
    }

    private static void recordFatalExceptionAnswersEvent(String str, String str2) {
        Answers answers = (Answers) f.a(Answers.class);
        if (answers == null) {
            f.e().d(CrashlyticsCore.TAG, "Answers is not available");
        } else {
            answers.onException(new m.a(str, str2));
        }
    }

    /* access modifiers changed from: private */
    public void recordFatalFirebaseEvent(long j2) {
        boolean firebaseCrashExists = firebaseCrashExists();
        String str = CrashlyticsCore.TAG;
        if (firebaseCrashExists) {
            f.e().d(str, "Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
            return;
        }
        if (this.firebaseAnalyticsLogger != null) {
            f.e().d(str, "Logging Crashlytics event to Firebase");
            Bundle bundle = new Bundle();
            bundle.putInt(FIREBASE_REALTIME, 1);
            bundle.putInt(FIREBASE_CRASH_TYPE, 1);
            bundle.putLong(FIREBASE_TIMESTAMP, j2);
            this.firebaseAnalyticsLogger.logEvent(FIREBASE_ANALYTICS_ORIGIN_CRASHLYTICS, FIREBASE_APPLICATION_EXCEPTION, bundle);
        } else {
            f.e().d(str, "Skipping logging Crashlytics event to Firebase, no Firebase Analytics");
        }
    }

    private static void recordLoggedExceptionAnswersEvent(String str, String str2) {
        Answers answers = (Answers) f.a(Answers.class);
        if (answers == null) {
            f.e().d(CrashlyticsCore.TAG, "Answers is not available");
        } else {
            answers.onException(new b(str, str2));
        }
    }

    /* access modifiers changed from: private */
    public void recursiveDelete(Set<File> set) {
        for (File recursiveDelete : set) {
            recursiveDelete(recursiveDelete);
        }
    }

    private void retainSessions(File[] fileArr, Set<String> set) {
        for (File file : fileArr) {
            String name = file.getName();
            Matcher matcher = SESSION_FILE_PATTERN.matcher(name);
            boolean matches = matcher.matches();
            String str = CrashlyticsCore.TAG;
            if (!matches) {
                o e2 = f.e();
                StringBuilder sb = new StringBuilder();
                sb.append("Deleting unknown file: ");
                sb.append(name);
                e2.d(str, sb.toString());
                file.delete();
            } else if (!set.contains(matcher.group(1))) {
                o e3 = f.e();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Trimming session file: ");
                sb2.append(name);
                e3.d(str, sb2.toString());
                file.delete();
            }
        }
    }

    /* access modifiers changed from: private */
    public void sendSessionReports(v vVar) {
        if (vVar == null) {
            f.e().a(CrashlyticsCore.TAG, "Cannot send reports. Settings are unavailable.");
            return;
        }
        Context context = this.crashlyticsCore.getContext();
        e eVar = vVar.f8971a;
        ReportUploader reportUploader = new ReportUploader(this.appData.apiKey, getCreateReportSpiCall(eVar.f8924d, eVar.f8925e), this.reportFilesProvider, this.handlingExceptionCheck);
        for (File sessionReport : listCompleteSessionFiles()) {
            this.backgroundWorker.submit((Runnable) new SendReportRunnable(context, new SessionReport(sessionReport, SEND_AT_CRASHTIME_HEADER), reportUploader));
        }
    }

    /* access modifiers changed from: private */
    public boolean shouldPromptUserBeforeSendingCrashReports(v vVar) {
        boolean z = false;
        if (vVar == null) {
            return false;
        }
        if (vVar.f8974d.f8939a && !this.preferenceManager.shouldAlwaysSendReports()) {
            z = true;
        }
        return z;
    }

    private void synthesizeSessionFile(File file, String str, File[] fileArr, File file2) {
        ClsFileOutputStream clsFileOutputStream;
        String str2 = str;
        File file3 = file2;
        String str3 = "Failed to close CLS file";
        String str4 = CrashlyticsCore.TAG;
        String str5 = "Error flushing session file stream";
        boolean z = file3 != null;
        File fatalSessionFilesDir = z ? getFatalSessionFilesDir() : getNonFatalSessionFilesDir();
        if (!fatalSessionFilesDir.exists()) {
            fatalSessionFilesDir.mkdirs();
        }
        try {
            clsFileOutputStream = new ClsFileOutputStream(fatalSessionFilesDir, str2);
            try {
                CodedOutputStream newInstance = CodedOutputStream.newInstance((OutputStream) clsFileOutputStream);
                o e2 = f.e();
                StringBuilder sb = new StringBuilder();
                sb.append("Collecting SessionStart data for session ID ");
                sb.append(str2);
                e2.d(str4, sb.toString());
                writeToCosFromFile(newInstance, file);
                newInstance.writeUInt64(4, new Date().getTime() / 1000);
                newInstance.writeBool(5, z);
                newInstance.writeUInt32(11, 1);
                newInstance.writeEnum(12, 3);
                writeInitialPartsTo(newInstance, str2);
                writeNonFatalEventsTo(newInstance, fileArr, str2);
                if (z) {
                    writeToCosFromFile(newInstance, file3);
                }
                io.fabric.sdk.android.a.b.l.a((Flushable) newInstance, str5);
                io.fabric.sdk.android.a.b.l.a((Closeable) clsFileOutputStream, str3);
            } catch (Exception e3) {
                e = e3;
                try {
                    o e4 = f.e();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to write session file for session ID: ");
                    sb2.append(str2);
                    e4.b(str4, sb2.toString(), e);
                    io.fabric.sdk.android.a.b.l.a((Flushable) null, str5);
                    closeWithoutRenamingOrLog(clsFileOutputStream);
                } catch (Throwable th) {
                    th = th;
                    io.fabric.sdk.android.a.b.l.a((Flushable) null, str5);
                    io.fabric.sdk.android.a.b.l.a((Closeable) clsFileOutputStream, str3);
                    throw th;
                }
            }
        } catch (Exception e5) {
            e = e5;
            clsFileOutputStream = null;
            o e42 = f.e();
            StringBuilder sb22 = new StringBuilder();
            sb22.append("Failed to write session file for session ID: ");
            sb22.append(str2);
            e42.b(str4, sb22.toString(), e);
            io.fabric.sdk.android.a.b.l.a((Flushable) null, str5);
            closeWithoutRenamingOrLog(clsFileOutputStream);
        } catch (Throwable th2) {
            th = th2;
            clsFileOutputStream = null;
            io.fabric.sdk.android.a.b.l.a((Flushable) null, str5);
            io.fabric.sdk.android.a.b.l.a((Closeable) clsFileOutputStream, str3);
            throw th;
        }
    }

    private void trimInvalidSessionFiles() {
        File invalidFilesDir = getInvalidFilesDir();
        if (invalidFilesDir.exists()) {
            File[] listFilesMatching = listFilesMatching(invalidFilesDir, new InvalidPartFileFilter());
            Arrays.sort(listFilesMatching, Collections.reverseOrder());
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < listFilesMatching.length && hashSet.size() < 4; i2++) {
                hashSet.add(getSessionIdFromSessionFile(listFilesMatching[i2]));
            }
            retainSessions(listFiles(invalidFilesDir), hashSet);
        }
    }

    private void trimOpenSessions(int i2) {
        HashSet hashSet = new HashSet();
        File[] listSortedSessionBeginFiles = listSortedSessionBeginFiles();
        int min = Math.min(i2, listSortedSessionBeginFiles.length);
        for (int i3 = 0; i3 < min; i3++) {
            hashSet.add(getSessionIdFromSessionFile(listSortedSessionBeginFiles[i3]));
        }
        this.logFileManager.discardOldLogFiles(hashSet);
        retainSessions(listFilesMatching((FilenameFilter) new AnySessionPartFileFilter()), hashSet);
    }

    private void trimSessionEventFiles(String str, int i2) {
        File filesDir = getFilesDir();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(SESSION_NON_FATAL_TAG);
        Utils.capFileCount(filesDir, new FileNameContainsFilter(sb.toString()), i2, SMALLEST_FILE_NAME_FIRST);
    }

    private void writeBeginSession(String str, Date date) throws Exception {
        final String str2 = str;
        final String format = String.format(Locale.US, GENERATOR_FORMAT, new Object[]{this.crashlyticsCore.getVersion()});
        final long time = date.getTime() / 1000;
        AnonymousClass17 r3 = new CodedOutputStreamWriteAction() {
            public void writeTo(CodedOutputStream codedOutputStream) throws Exception {
                SessionProtobufHelper.writeBeginSession(codedOutputStream, str2, format, time);
            }
        };
        writeSessionPartFile(str, SESSION_BEGIN_TAG, r3);
        AnonymousClass18 r32 = new FileOutputStreamWriteAction() {
            public void writeTo(FileOutputStream fileOutputStream) throws Exception {
                fileOutputStream.write(new JSONObject(new HashMap<String, Object>() {
                    {
                        put("session_id", str2);
                        put("generator", format);
                        put("started_at_seconds", Long.valueOf(time));
                    }
                }).toString().getBytes());
            }
        };
        writeFile(str, "BeginSession.json", r32);
    }

    /* access modifiers changed from: private */
    public void writeFatal(Date date, Thread thread, Throwable th) {
        ClsFileOutputStream clsFileOutputStream;
        String str = CrashlyticsCore.TAG;
        String str2 = "Failed to close fatal exception file output stream.";
        String str3 = "Failed to flush to session begin file.";
        CodedOutputStream codedOutputStream = null;
        try {
            String currentSessionId = getCurrentSessionId();
            if (currentSessionId == null) {
                f.e().b(str, "Tried to write a fatal exception while no session was open.", null);
                io.fabric.sdk.android.a.b.l.a((Flushable) null, str3);
                io.fabric.sdk.android.a.b.l.a((Closeable) null, str2);
                return;
            }
            recordFatalExceptionAnswersEvent(currentSessionId, th.getClass().getName());
            File filesDir = getFilesDir();
            StringBuilder sb = new StringBuilder();
            sb.append(currentSessionId);
            sb.append(SESSION_FATAL_TAG);
            clsFileOutputStream = new ClsFileOutputStream(filesDir, sb.toString());
            try {
                codedOutputStream = CodedOutputStream.newInstance((OutputStream) clsFileOutputStream);
                writeSessionEvent(codedOutputStream, date, thread, th, EVENT_TYPE_CRASH, true);
            } catch (Exception e2) {
                e = e2;
            }
            io.fabric.sdk.android.a.b.l.a((Flushable) codedOutputStream, str3);
            io.fabric.sdk.android.a.b.l.a((Closeable) clsFileOutputStream, str2);
        } catch (Exception e3) {
            e = e3;
            clsFileOutputStream = null;
            try {
                f.e().b(str, "An error occurred in the fatal exception logger", e);
                io.fabric.sdk.android.a.b.l.a((Flushable) codedOutputStream, str3);
                io.fabric.sdk.android.a.b.l.a((Closeable) clsFileOutputStream, str2);
            } catch (Throwable th2) {
                th = th2;
                io.fabric.sdk.android.a.b.l.a((Flushable) codedOutputStream, str3);
                io.fabric.sdk.android.a.b.l.a((Closeable) clsFileOutputStream, str2);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            clsFileOutputStream = null;
            io.fabric.sdk.android.a.b.l.a((Flushable) codedOutputStream, str3);
            io.fabric.sdk.android.a.b.l.a((Closeable) clsFileOutputStream, str2);
            throw th;
        }
    }

    private void writeFile(String str, String str2, FileOutputStreamWriteAction fileOutputStreamWriteAction) throws Exception {
        String str3 = " file.";
        String str4 = "Failed to close ";
        FileOutputStream fileOutputStream = null;
        try {
            File filesDir = getFilesDir();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str2);
            FileOutputStream fileOutputStream2 = new FileOutputStream(new File(filesDir, sb.toString()));
            try {
                fileOutputStreamWriteAction.writeTo(fileOutputStream2);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str4);
                sb2.append(str2);
                sb2.append(str3);
                io.fabric.sdk.android.a.b.l.a((Closeable) fileOutputStream2, sb2.toString());
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str4);
                sb3.append(str2);
                sb3.append(str3);
                io.fabric.sdk.android.a.b.l.a((Closeable) fileOutputStream, sb3.toString());
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            StringBuilder sb32 = new StringBuilder();
            sb32.append(str4);
            sb32.append(str2);
            sb32.append(str3);
            io.fabric.sdk.android.a.b.l.a((Closeable) fileOutputStream, sb32.toString());
            throw th;
        }
    }

    private void writeInitialPartsTo(CodedOutputStream codedOutputStream, String str) throws IOException {
        String[] strArr;
        for (String str2 : INITIAL_SESSION_PART_TAGS) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str2);
            sb.append(ClsFileOutputStream.SESSION_FILE_EXTENSION);
            File[] listFilesMatching = listFilesMatching((FilenameFilter) new FileNameContainsFilter(sb.toString()));
            int length = listFilesMatching.length;
            String str3 = " data for session ID ";
            String str4 = CrashlyticsCore.TAG;
            if (length == 0) {
                o e2 = f.e();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Can't find ");
                sb2.append(str2);
                sb2.append(str3);
                sb2.append(str);
                e2.b(str4, sb2.toString(), null);
            } else {
                o e3 = f.e();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Collecting ");
                sb3.append(str2);
                sb3.append(str3);
                sb3.append(str);
                e3.d(str4, sb3.toString());
                writeToCosFromFile(codedOutputStream, listFilesMatching[0]);
            }
        }
    }

    private static void writeNonFatalEventsTo(CodedOutputStream codedOutputStream, File[] fileArr, String str) {
        String str2 = CrashlyticsCore.TAG;
        Arrays.sort(fileArr, io.fabric.sdk.android.a.b.l.f8821d);
        for (File file : fileArr) {
            try {
                f.e().d(str2, String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", new Object[]{str, file.getName()}));
                writeToCosFromFile(codedOutputStream, file);
            } catch (Exception e2) {
                f.e().b(str2, "Error writting non-fatal to session.", e2);
            }
        }
    }

    private void writeSessionApp(String str) throws Exception {
        String c2 = this.idManager.c();
        AppData appData2 = this.appData;
        String str2 = appData2.versionCode;
        String str3 = appData2.versionName;
        final String str4 = c2;
        final String str5 = str2;
        final String str6 = str3;
        final String d2 = this.idManager.d();
        final int id = io.fabric.sdk.android.a.b.p.a(this.appData.installerPackageName).getId();
        AnonymousClass19 r1 = new CodedOutputStreamWriteAction() {
            public void writeTo(CodedOutputStream codedOutputStream) throws Exception {
                SessionProtobufHelper.writeSessionApp(codedOutputStream, str4, CrashlyticsController.this.appData.apiKey, str5, str6, d2, id, CrashlyticsController.this.unityVersion);
            }
        };
        writeSessionPartFile(str, SESSION_APP_TAG, r1);
        AnonymousClass20 r12 = new FileOutputStreamWriteAction() {
            public void writeTo(FileOutputStream fileOutputStream) throws Exception {
                fileOutputStream.write(new JSONObject(new HashMap<String, Object>() {
                    {
                        put("app_identifier", str4);
                        put("api_key", CrashlyticsController.this.appData.apiKey);
                        put("version_code", str5);
                        put("version_name", str6);
                        put("install_uuid", d2);
                        put("delivery_mechanism", Integer.valueOf(id));
                        put("unity_version", TextUtils.isEmpty(CrashlyticsController.this.unityVersion) ? "" : CrashlyticsController.this.unityVersion);
                    }
                }).toString().getBytes());
            }
        };
        writeFile(str, "SessionApp.json", r12);
    }

    private void writeSessionDevice(String str) throws Exception {
        String str2 = str;
        Context context = this.crashlyticsCore.getContext();
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int a2 = io.fabric.sdk.android.a.b.l.a();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        long b2 = io.fabric.sdk.android.a.b.l.b();
        long blockCount = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        boolean l2 = io.fabric.sdk.android.a.b.l.l(context);
        final int i2 = a2;
        final int i3 = availableProcessors;
        final long j2 = b2;
        final long j3 = blockCount;
        final boolean z = l2;
        final Map e2 = this.idManager.e();
        long j4 = b2;
        AnonymousClass23 r15 = r0;
        final int f2 = io.fabric.sdk.android.a.b.l.f(context);
        AnonymousClass23 r0 = new CodedOutputStreamWriteAction() {
            public void writeTo(CodedOutputStream codedOutputStream) throws Exception {
                SessionProtobufHelper.writeSessionDevice(codedOutputStream, i2, Build.MODEL, i3, j2, j3, z, e2, f2, Build.MANUFACTURER, Build.PRODUCT);
            }
        };
        writeSessionPartFile(str2, SESSION_DEVICE_TAG, r15);
        final long j5 = j4;
        AnonymousClass24 r02 = new FileOutputStreamWriteAction() {
            public void writeTo(FileOutputStream fileOutputStream) throws Exception {
                fileOutputStream.write(new JSONObject(new HashMap<String, Object>() {
                    {
                        put("arch", Integer.valueOf(i2));
                        put("build_model", Build.MODEL);
                        put("available_processors", Integer.valueOf(i3));
                        put("total_ram", Long.valueOf(j5));
                        put("disk_space", Long.valueOf(j3));
                        put("is_emulator", Boolean.valueOf(z));
                        put("ids", e2);
                        put("state", Integer.valueOf(f2));
                        put("build_manufacturer", Build.MANUFACTURER);
                        put("build_product", Build.PRODUCT);
                    }
                }).toString().getBytes());
            }
        };
        writeFile(str2, "SessionDevice.json", r02);
    }

    /* JADX WARNING: type inference failed for: r6v2, types: [boolean] */
    /* JADX WARNING: type inference failed for: r6v4 */
    /* JADX WARNING: type inference failed for: r6v5 */
    /* JADX WARNING: type inference failed for: r6v8 */
    /* JADX WARNING: type inference failed for: r6v9 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r6v2, types: [boolean]
      assigns: []
      uses: [boolean, ?[int, byte, short, char]]
      mth insns count: 75
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 3 */
    private void writeSessionEvent(CodedOutputStream codedOutputStream, Date date, Thread thread, Throwable th, String str, boolean z) throws Exception {
        Thread[] threadArr;
        ? r6;
        Map map;
        Map map2;
        TrimmedThrowableData trimmedThrowableData = new TrimmedThrowableData(th, this.stackTraceTrimmingStrategy);
        Context context = this.crashlyticsCore.getContext();
        long time = date.getTime() / 1000;
        Float e2 = io.fabric.sdk.android.a.b.l.e(context);
        int a2 = io.fabric.sdk.android.a.b.l.a(context, this.devicePowerStateListener.isPowerConnected());
        boolean g2 = io.fabric.sdk.android.a.b.l.g(context);
        int i2 = context.getResources().getConfiguration().orientation;
        long b2 = io.fabric.sdk.android.a.b.l.b() - io.fabric.sdk.android.a.b.l.a(context);
        long a3 = io.fabric.sdk.android.a.b.l.a(Environment.getDataDirectory().getPath());
        RunningAppProcessInfo a4 = io.fabric.sdk.android.a.b.l.a(context.getPackageName(), context);
        LinkedList linkedList = new LinkedList();
        StackTraceElement[] stackTraceElementArr = trimmedThrowableData.stacktrace;
        String str2 = this.appData.buildId;
        String c2 = this.idManager.c();
        int i3 = 0;
        if (z) {
            Map allStackTraces = Thread.getAllStackTraces();
            Thread[] threadArr2 = new Thread[allStackTraces.size()];
            for (Entry entry : allStackTraces.entrySet()) {
                threadArr2[i3] = (Thread) entry.getKey();
                linkedList.add(this.stackTraceTrimmingStrategy.getTrimmedStackTrace((StackTraceElement[]) entry.getValue()));
                i3++;
            }
            threadArr = threadArr2;
            r6 = 1;
        } else {
            threadArr = new Thread[0];
            r6 = 1;
        }
        if (!io.fabric.sdk.android.a.b.l.a(context, COLLECT_CUSTOM_KEYS, (boolean) r6)) {
            map2 = new TreeMap();
        } else {
            map2 = this.crashlyticsCore.getAttributes();
            if (map2 != null && map2.size() > r6) {
                map = new TreeMap(map2);
                SessionProtobufHelper.writeSessionEvent(codedOutputStream, time, str, trimmedThrowableData, thread, stackTraceElementArr, threadArr, linkedList, map, this.logFileManager, a4, i2, c2, str2, e2, a2, g2, b2, a3);
            }
        }
        map = map2;
        SessionProtobufHelper.writeSessionEvent(codedOutputStream, time, str, trimmedThrowableData, thread, stackTraceElementArr, threadArr, linkedList, map, this.logFileManager, a4, i2, c2, str2, e2, a2, g2, b2, a3);
    }

    private void writeSessionOS(String str) throws Exception {
        final boolean m = io.fabric.sdk.android.a.b.l.m(this.crashlyticsCore.getContext());
        writeSessionPartFile(str, SESSION_OS_TAG, new CodedOutputStreamWriteAction() {
            public void writeTo(CodedOutputStream codedOutputStream) throws Exception {
                SessionProtobufHelper.writeSessionOS(codedOutputStream, VERSION.RELEASE, VERSION.CODENAME, m);
            }
        });
        writeFile(str, "SessionOS.json", new FileOutputStreamWriteAction() {
            public void writeTo(FileOutputStream fileOutputStream) throws Exception {
                fileOutputStream.write(new JSONObject(new HashMap<String, Object>() {
                    {
                        put("version", VERSION.RELEASE);
                        put("build_version", VERSION.CODENAME);
                        put("is_rooted", Boolean.valueOf(m));
                    }
                }).toString().getBytes());
            }
        });
    }

    private void writeSessionPartFile(String str, String str2, CodedOutputStreamWriteAction codedOutputStreamWriteAction) throws Exception {
        ClsFileOutputStream clsFileOutputStream;
        String str3 = "Failed to close session ";
        String str4 = "Failed to flush to session ";
        String str5 = " file.";
        CodedOutputStream codedOutputStream = null;
        try {
            File filesDir = getFilesDir();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str2);
            clsFileOutputStream = new ClsFileOutputStream(filesDir, sb.toString());
            try {
                codedOutputStream = CodedOutputStream.newInstance((OutputStream) clsFileOutputStream);
                codedOutputStreamWriteAction.writeTo(codedOutputStream);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str4);
                sb2.append(str2);
                sb2.append(str5);
                io.fabric.sdk.android.a.b.l.a((Flushable) codedOutputStream, sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str3);
                sb3.append(str2);
                sb3.append(str5);
                io.fabric.sdk.android.a.b.l.a((Closeable) clsFileOutputStream, sb3.toString());
            } catch (Throwable th) {
                th = th;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str4);
                sb4.append(str2);
                sb4.append(str5);
                io.fabric.sdk.android.a.b.l.a((Flushable) codedOutputStream, sb4.toString());
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str3);
                sb5.append(str2);
                sb5.append(str5);
                io.fabric.sdk.android.a.b.l.a((Closeable) clsFileOutputStream, sb5.toString());
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            clsFileOutputStream = null;
            StringBuilder sb42 = new StringBuilder();
            sb42.append(str4);
            sb42.append(str2);
            sb42.append(str5);
            io.fabric.sdk.android.a.b.l.a((Flushable) codedOutputStream, sb42.toString());
            StringBuilder sb52 = new StringBuilder();
            sb52.append(str3);
            sb52.append(str2);
            sb52.append(str5);
            io.fabric.sdk.android.a.b.l.a((Closeable) clsFileOutputStream, sb52.toString());
            throw th;
        }
    }

    private void writeSessionPartsToSessionFile(File file, String str, int i2) {
        o e2 = f.e();
        StringBuilder sb = new StringBuilder();
        sb.append("Collecting session parts for ID ");
        sb.append(str);
        String sb2 = sb.toString();
        String str2 = CrashlyticsCore.TAG;
        e2.d(str2, sb2);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(SESSION_FATAL_TAG);
        File[] listFilesMatching = listFilesMatching((FilenameFilter) new FileNameContainsFilter(sb3.toString()));
        boolean z = listFilesMatching != null && listFilesMatching.length > 0;
        f.e().d(str2, String.format(Locale.US, "Session %s has fatal exception: %s", new Object[]{str, Boolean.valueOf(z)}));
        StringBuilder sb4 = new StringBuilder();
        sb4.append(str);
        sb4.append(SESSION_NON_FATAL_TAG);
        File[] listFilesMatching2 = listFilesMatching((FilenameFilter) new FileNameContainsFilter(sb4.toString()));
        boolean z2 = listFilesMatching2 != null && listFilesMatching2.length > 0;
        f.e().d(str2, String.format(Locale.US, "Session %s has non-fatal exceptions: %s", new Object[]{str, Boolean.valueOf(z2)}));
        if (z || z2) {
            synthesizeSessionFile(file, str, getTrimmedNonFatalFiles(str, listFilesMatching2, i2), z ? listFilesMatching[0] : null);
        } else {
            o e3 = f.e();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("No events present for session ID ");
            sb5.append(str);
            e3.d(str2, sb5.toString());
        }
        o e4 = f.e();
        StringBuilder sb6 = new StringBuilder();
        sb6.append("Removing session part files for ID ");
        sb6.append(str);
        e4.d(str2, sb6.toString());
        deleteSessionPartFilesFor(str);
    }

    private void writeSessionUser(String str) throws Exception {
        final UserMetaData userMetaData = getUserMetaData(str);
        writeSessionPartFile(str, SESSION_USER_TAG, new CodedOutputStreamWriteAction() {
            public void writeTo(CodedOutputStream codedOutputStream) throws Exception {
                UserMetaData userMetaData = userMetaData;
                SessionProtobufHelper.writeSessionUser(codedOutputStream, userMetaData.id, userMetaData.name, userMetaData.email);
            }
        });
    }

    private static void writeToCosFromFile(CodedOutputStream codedOutputStream, File file) throws IOException {
        FileInputStream fileInputStream;
        String str = "Failed to close file input stream.";
        if (!file.exists()) {
            o e2 = f.e();
            StringBuilder sb = new StringBuilder();
            sb.append("Tried to include a file that doesn't exist: ");
            sb.append(file.getName());
            e2.b(CrashlyticsCore.TAG, sb.toString(), null);
            return;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                copyToCodedOutputStream(fileInputStream, codedOutputStream, (int) file.length());
                io.fabric.sdk.android.a.b.l.a((Closeable) fileInputStream, str);
            } catch (Throwable th) {
                th = th;
                io.fabric.sdk.android.a.b.l.a((Closeable) fileInputStream, str);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            io.fabric.sdk.android.a.b.l.a((Closeable) fileInputStream, str);
            throw th;
        }
    }

    /* access modifiers changed from: 0000 */
    public void cacheKeyData(final Map<String, String> map) {
        this.backgroundWorker.submit((Callable<T>) new Callable<Void>() {
            public Void call() throws Exception {
                new MetaDataStore(CrashlyticsController.this.getFilesDir()).writeKeyData(CrashlyticsController.this.getCurrentSessionId(), map);
                return null;
            }
        });
    }

    /* access modifiers changed from: 0000 */
    public void cacheUserData(final String str, final String str2, final String str3) {
        this.backgroundWorker.submit((Callable<T>) new Callable<Void>() {
            public Void call() throws Exception {
                new MetaDataStore(CrashlyticsController.this.getFilesDir()).writeUserData(CrashlyticsController.this.getCurrentSessionId(), new UserMetaData(str, str2, str3));
                return null;
            }
        });
    }

    /* access modifiers changed from: 0000 */
    public void cleanInvalidTempFiles() {
        this.backgroundWorker.submit((Runnable) new Runnable() {
            public void run() {
                CrashlyticsController crashlyticsController = CrashlyticsController.this;
                crashlyticsController.doCleanInvalidTempFiles(crashlyticsController.listFilesMatching((FilenameFilter) new InvalidPartFileFilter()));
            }
        });
    }

    /* access modifiers changed from: 0000 */
    public void doCleanInvalidTempFiles(File[] fileArr) {
        String str;
        File[] listFilesMatching;
        final HashSet hashSet = new HashSet();
        int length = fileArr.length;
        int i2 = 0;
        while (true) {
            str = CrashlyticsCore.TAG;
            if (i2 >= length) {
                break;
            }
            File file = fileArr[i2];
            o e2 = f.e();
            StringBuilder sb = new StringBuilder();
            sb.append("Found invalid session part file: ");
            sb.append(file);
            e2.d(str, sb.toString());
            hashSet.add(getSessionIdFromSessionFile(file));
            i2++;
        }
        if (!hashSet.isEmpty()) {
            File invalidFilesDir = getInvalidFilesDir();
            if (!invalidFilesDir.exists()) {
                invalidFilesDir.mkdir();
            }
            for (File file2 : listFilesMatching((FilenameFilter) new FilenameFilter() {
                public boolean accept(File file, String str) {
                    if (str.length() < 35) {
                        return false;
                    }
                    return hashSet.contains(str.substring(0, 35));
                }
            })) {
                o e3 = f.e();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Moving session file: ");
                sb2.append(file2);
                e3.d(str, sb2.toString());
                if (!file2.renameTo(new File(invalidFilesDir, file2.getName()))) {
                    o e4 = f.e();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Could not move session file. Deleting ");
                    sb3.append(file2);
                    e4.d(str, sb3.toString());
                    file2.delete();
                }
            }
            trimInvalidSessionFiles();
        }
    }

    /* access modifiers changed from: 0000 */
    public void doCloseSessions(q qVar) throws Exception {
        doCloseSessions(qVar, false);
    }

    /* access modifiers changed from: 0000 */
    public void enableExceptionHandling(UncaughtExceptionHandler uncaughtExceptionHandler, boolean z) {
        openSession();
        this.crashHandler = new CrashlyticsUncaughtExceptionHandler(new CrashListener() {
            public void onUncaughtException(SettingsDataProvider settingsDataProvider, Thread thread, Throwable th, boolean z) {
                CrashlyticsController.this.handleUncaughtException(settingsDataProvider, thread, th, z);
            }
        }, new DefaultSettingsDataProvider(), z, uncaughtExceptionHandler);
        Thread.setDefaultUncaughtExceptionHandler(this.crashHandler);
    }

    /* access modifiers changed from: 0000 */
    public boolean finalizeNativeReport(final CrashlyticsNdkData crashlyticsNdkData) {
        if (crashlyticsNdkData == null) {
            return true;
        }
        return ((Boolean) this.backgroundWorker.submitAndWait(new Callable<Boolean>() {
            public Boolean call() throws Exception {
                TreeSet<File> treeSet = crashlyticsNdkData.timestampedDirectories;
                String access$1600 = CrashlyticsController.this.getPreviousSessionId();
                if (access$1600 != null && !treeSet.isEmpty()) {
                    File file = (File) treeSet.first();
                    if (file != null) {
                        CrashlyticsController crashlyticsController = CrashlyticsController.this;
                        crashlyticsController.finalizeMostRecentNativeCrash(crashlyticsController.crashlyticsCore.getContext(), file, access$1600);
                    }
                }
                CrashlyticsController.this.recursiveDelete((Set<File>) treeSet);
                return Boolean.TRUE;
            }
        })).booleanValue();
    }

    /* access modifiers changed from: 0000 */
    public boolean finalizeSessions(final q qVar) {
        return ((Boolean) this.backgroundWorker.submitAndWait(new Callable<Boolean>() {
            public Boolean call() throws Exception {
                boolean isHandlingException = CrashlyticsController.this.isHandlingException();
                String str = CrashlyticsCore.TAG;
                if (isHandlingException) {
                    f.e().d(str, "Skipping session finalization because a crash has already occurred.");
                    return Boolean.FALSE;
                }
                f.e().d(str, "Finalizing previously open sessions.");
                CrashlyticsController.this.doCloseSessions(qVar, true);
                f.e().d(str, "Closed all previously open sessions");
                return Boolean.TRUE;
            }
        })).booleanValue();
    }

    /* access modifiers changed from: 0000 */
    public File getFatalSessionFilesDir() {
        return new File(getFilesDir(), FATAL_SESSION_DIR);
    }

    /* access modifiers changed from: 0000 */
    public File getFilesDir() {
        return this.fileStore.a();
    }

    /* access modifiers changed from: 0000 */
    public File getInvalidFilesDir() {
        return new File(getFilesDir(), INVALID_CLS_CACHE_DIR);
    }

    /* access modifiers changed from: 0000 */
    public File getNonFatalSessionFilesDir() {
        return new File(getFilesDir(), NONFATAL_SESSION_DIR);
    }

    /* access modifiers changed from: 0000 */
    public synchronized void handleUncaughtException(SettingsDataProvider settingsDataProvider, Thread thread, Throwable th, boolean z) {
        o e2 = f.e();
        String str = CrashlyticsCore.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Crashlytics is handling uncaught exception \"");
        sb.append(th);
        sb.append("\" from thread ");
        sb.append(thread.getName());
        e2.d(str, sb.toString());
        this.devicePowerStateListener.dispose();
        final Date date = new Date();
        CrashlyticsBackgroundWorker crashlyticsBackgroundWorker = this.backgroundWorker;
        final Thread thread2 = thread;
        final Throwable th2 = th;
        final SettingsDataProvider settingsDataProvider2 = settingsDataProvider;
        final boolean z2 = z;
        AnonymousClass7 r1 = new Callable<Void>() {
            public Void call() throws Exception {
                n nVar;
                q qVar;
                CrashlyticsController.this.crashlyticsCore.createCrashMarker();
                CrashlyticsController.this.writeFatal(date, thread2, th2);
                v settingsData = settingsDataProvider2.getSettingsData();
                if (settingsData != null) {
                    qVar = settingsData.f8972b;
                    nVar = settingsData.f8974d;
                } else {
                    qVar = null;
                    nVar = null;
                }
                boolean z = false;
                if ((nVar == null || nVar.f8943e) || z2) {
                    CrashlyticsController.this.recordFatalFirebaseEvent(date.getTime());
                }
                CrashlyticsController.this.doCloseSessions(qVar);
                CrashlyticsController.this.doOpenSession();
                if (qVar != null) {
                    CrashlyticsController.this.trimSessionFiles(qVar.f8961g);
                }
                if (io.fabric.sdk.android.a.b.o.a(CrashlyticsController.this.crashlyticsCore.getContext()).a() && !CrashlyticsController.this.shouldPromptUserBeforeSendingCrashReports(settingsData)) {
                    z = true;
                }
                if (z) {
                    CrashlyticsController.this.sendSessionReports(settingsData);
                }
                return null;
            }
        };
        crashlyticsBackgroundWorker.submitAndWait(r1);
    }

    /* access modifiers changed from: 0000 */
    public boolean hasOpenSession() {
        return listSessionBeginFiles().length > 0;
    }

    /* access modifiers changed from: 0000 */
    public boolean isHandlingException() {
        CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = this.crashHandler;
        return crashlyticsUncaughtExceptionHandler != null && crashlyticsUncaughtExceptionHandler.isHandlingException();
    }

    /* access modifiers changed from: 0000 */
    public File[] listCompleteSessionFiles() {
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, listFilesMatching(getFatalSessionFilesDir(), SESSION_FILE_FILTER));
        Collections.addAll(linkedList, listFilesMatching(getNonFatalSessionFilesDir(), SESSION_FILE_FILTER));
        Collections.addAll(linkedList, listFilesMatching(getFilesDir(), SESSION_FILE_FILTER));
        return (File[]) linkedList.toArray(new File[linkedList.size()]);
    }

    /* access modifiers changed from: 0000 */
    public File[] listNativeSessionFileDirectories() {
        return listFilesMatching(SESSION_DIRECTORY_FILTER);
    }

    /* access modifiers changed from: 0000 */
    public File[] listSessionBeginFiles() {
        return listFilesMatching(SESSION_BEGIN_FILE_FILTER);
    }

    /* access modifiers changed from: 0000 */
    public void openSession() {
        this.backgroundWorker.submit((Callable<T>) new Callable<Void>() {
            public Void call() throws Exception {
                CrashlyticsController.this.doOpenSession();
                return null;
            }
        });
    }

    /* access modifiers changed from: 0000 */
    public void registerAnalyticsEventListener(v vVar) {
        if (vVar.f8974d.f8943e) {
            boolean register = this.appMeasurementEventListenerRegistrar.register();
            o e2 = f.e();
            StringBuilder sb = new StringBuilder();
            sb.append("Registered Firebase Analytics event listener for breadcrumbs: ");
            sb.append(register);
            e2.d(CrashlyticsCore.TAG, sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    public void registerDevicePowerStateListener() {
        this.devicePowerStateListener.initialize();
    }

    /* access modifiers changed from: 0000 */
    public void submitAllReports(float f2, v vVar) {
        if (vVar == null) {
            f.e().a(CrashlyticsCore.TAG, "Could not send reports. Settings are not available.");
            return;
        }
        e eVar = vVar.f8971a;
        new ReportUploader(this.appData.apiKey, getCreateReportSpiCall(eVar.f8924d, eVar.f8925e), this.reportFilesProvider, this.handlingExceptionCheck).uploadReports(f2, shouldPromptUserBeforeSendingCrashReports(vVar) ? new PrivacyDialogCheck(this.crashlyticsCore, this.preferenceManager, vVar.f8973c) : new AlwaysSendCheck());
    }

    /* access modifiers changed from: 0000 */
    public void trimSessionFiles(int i2) {
        int capFileCount = i2 - Utils.capFileCount(getFatalSessionFilesDir(), i2, SMALLEST_FILE_NAME_FIRST);
        Utils.capFileCount(getFilesDir(), SESSION_FILE_FILTER, capFileCount - Utils.capFileCount(getNonFatalSessionFilesDir(), capFileCount, SMALLEST_FILE_NAME_FIRST), SMALLEST_FILE_NAME_FIRST);
    }

    /* access modifiers changed from: 0000 */
    public void writeNonFatalException(final Thread thread, final Throwable th) {
        final Date date = new Date();
        this.backgroundWorker.submit((Runnable) new Runnable() {
            public void run() {
                if (!CrashlyticsController.this.isHandlingException()) {
                    CrashlyticsController.this.doWriteNonFatal(date, thread, th);
                }
            }
        });
    }

    /* access modifiers changed from: 0000 */
    public void writeToLog(final long j2, final String str) {
        this.backgroundWorker.submit((Callable<T>) new Callable<Void>() {
            public Void call() throws Exception {
                if (!CrashlyticsController.this.isHandlingException()) {
                    CrashlyticsController.this.logFileManager.writeToLog(j2, str);
                }
                return null;
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Incorrect type for immutable var: ssa=boolean, code=int, for r5v0, types: [boolean, int] */
    public void doCloseSessions(q qVar, int i2) throws Exception {
        trimOpenSessions(i2 + 8);
        File[] listSortedSessionBeginFiles = listSortedSessionBeginFiles();
        int length = listSortedSessionBeginFiles.length;
        String str = CrashlyticsCore.TAG;
        if (length <= i2) {
            f.e().d(str, "No open sessions to be closed.");
            return;
        }
        writeSessionUser(getSessionIdFromSessionFile(listSortedSessionBeginFiles[i2]));
        if (qVar == null) {
            f.e().d(str, "Unable to close session. Settings are not loaded.");
        } else {
            closeOpenSessions(listSortedSessionBeginFiles, i2, qVar.f8957c);
        }
    }

    /* access modifiers changed from: private */
    public File[] listFilesMatching(FilenameFilter filenameFilter) {
        return listFilesMatching(getFilesDir(), filenameFilter);
    }

    private File[] listFilesMatching(File file, FilenameFilter filenameFilter) {
        return ensureFileArrayNotNull(file.listFiles(filenameFilter));
    }

    private void recursiveDelete(File file) {
        if (file.isDirectory()) {
            for (File recursiveDelete : file.listFiles()) {
                recursiveDelete(recursiveDelete);
            }
        }
        file.delete();
    }
}
