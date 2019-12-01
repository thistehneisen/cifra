package io.intercom.android.sdk.persistence;

import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.twig.Twig;
import io.intercom.android.sdk.utilities.IoUtils;
import io.intercom.com.google.gson.o;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class JsonStorage {
    private static final Twig TWIG = LumberMill.getLogger();
    private final o gson;

    public interface LoadFailureHandler {
        public static final LoadFailureHandler NONE = new LoadFailureHandler() {
            public void onLoadFailed(File file, Exception exc) {
            }
        };

        void onLoadFailed(File file, Exception exc);
    }

    public interface LoadHandler<T> {
        void onLoad(T t);
    }

    public JsonStorage(o oVar) {
        this.gson = oVar;
    }

    public int getDirectoryFileCount(File file) {
        String[] list = file.list();
        if (list == null) {
            return 0;
        }
        return list.length;
    }

    public <T> void loadFilesInDirectory(File file, Class<T> cls, LoadHandler<List<T>> loadHandler) {
        loadFilesInDirectory(file, cls, loadHandler, LoadFailureHandler.NONE);
    }

    public <T> void loadThenDelete(File file, Class<T> cls, LoadHandler<T> loadHandler) {
        FileReader fileReader;
        try {
            fileReader = new FileReader(file);
            try {
                loadHandler.onLoad(this.gson.a((Reader) fileReader, cls));
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
                IoUtils.safelyDelete(file);
                IoUtils.closeQuietly(fileReader);
                throw th;
            }
        } catch (Exception unused2) {
            fileReader = null;
        } catch (Throwable th2) {
            th = th2;
            fileReader = null;
            IoUtils.safelyDelete(file);
            IoUtils.closeQuietly(fileReader);
            throw th;
        }
        IoUtils.safelyDelete(file);
        IoUtils.closeQuietly(fileReader);
    }

    public void saveToFileAsJson(Object obj, File file) {
        FileWriter fileWriter = null;
        try {
            if (file.exists()) {
                if (!file.delete()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Couldn't delete existing file at ");
                    sb.append(file.getAbsolutePath());
                    throw new RuntimeException(sb.toString());
                }
            }
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                if (!parentFile.mkdirs()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Couldn't create missing parent dir at ");
                    sb2.append(parentFile.getAbsolutePath());
                    throw new RuntimeException(sb2.toString());
                }
            }
            FileWriter fileWriter2 = new FileWriter(file);
            try {
                this.gson.a(obj, (Appendable) fileWriter2);
                IoUtils.closeQuietly(fileWriter2);
            } catch (Exception e2) {
                e = e2;
                fileWriter = fileWriter2;
                try {
                    Twig twig = TWIG;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Couldn't save file to disk: ");
                    sb3.append(e);
                    twig.internal(sb3.toString());
                    IoUtils.closeQuietly(fileWriter);
                } catch (Throwable th) {
                    th = th;
                    IoUtils.closeQuietly(fileWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileWriter = fileWriter2;
                IoUtils.closeQuietly(fileWriter);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            Twig twig2 = TWIG;
            StringBuilder sb32 = new StringBuilder();
            sb32.append("Couldn't save file to disk: ");
            sb32.append(e);
            twig2.internal(sb32.toString());
            IoUtils.closeQuietly(fileWriter);
        }
    }

    public <T> void loadFilesInDirectory(File file, Class<T> cls, LoadHandler<List<T>> loadHandler, LoadFailureHandler loadFailureHandler) {
        FileReader fileReader;
        Exception e2;
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            ArrayList arrayList = new ArrayList(listFiles.length);
            FileReader fileReader2 = null;
            for (File file2 : listFiles) {
                try {
                    fileReader = new FileReader(file2);
                    try {
                        arrayList.add(this.gson.a((Reader) fileReader, cls));
                    } catch (Exception e3) {
                        e2 = e3;
                    }
                } catch (Exception e4) {
                    Exception exc = e4;
                    fileReader = fileReader2;
                    e2 = exc;
                    try {
                        loadFailureHandler.onLoadFailed(file2, e2);
                        IoUtils.closeQuietly(fileReader);
                        fileReader2 = fileReader;
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileReader = fileReader2;
                    IoUtils.closeQuietly(fileReader);
                    throw th;
                }
                IoUtils.closeQuietly(fileReader);
                fileReader2 = fileReader;
            }
            loadHandler.onLoad(arrayList);
        }
    }
}
