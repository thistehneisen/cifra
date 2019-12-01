package com.appsflyer.cache;

import android.content.Context;
import android.util.Log;
import com.appsflyer.AppsFlyerLib;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class CacheManager {
    public static final String AF_CACHE_DIR = "AFRequestCache";
    public static final int CACHE_MAX_SIZE = 40;

    /* renamed from: ˋ reason: contains not printable characters */
    private static CacheManager f126 = new CacheManager();

    private CacheManager() {
    }

    public static CacheManager getInstance() {
        return f126;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0026 A[SYNTHETIC, Splitter:B:13:0x0026] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002d A[SYNTHETIC, Splitter:B:21:0x002d] */
    /* renamed from: ˏ reason: contains not printable characters */
    private static RequestCacheData m123(File file) {
        InputStreamReader inputStreamReader;
        try {
            inputStreamReader = new FileReader(file);
            try {
                char[] cArr = new char[((int) file.length())];
                inputStreamReader.read(cArr);
                RequestCacheData requestCacheData = new RequestCacheData(cArr);
                requestCacheData.setCacheKey(file.getName());
                try {
                    inputStreamReader.close();
                } catch (IOException unused) {
                }
                return requestCacheData;
            } catch (Exception unused2) {
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (IOException unused3) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
            inputStreamReader = null;
            if (inputStreamReader != null) {
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStreamReader = null;
            if (inputStreamReader != null) {
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x009a A[SYNTHETIC, Splitter:B:30:0x009a] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a1 A[SYNTHETIC, Splitter:B:35:0x00a1] */
    public void cacheRequest(RequestCacheData requestCacheData, Context context) {
        String str = AF_CACHE_DIR;
        String str2 = AppsFlyerLib.LOG_TAG;
        OutputStreamWriter outputStreamWriter = null;
        try {
            File file = new File(context.getFilesDir(), str);
            if (!file.exists()) {
                file.mkdir();
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length <= 40) {
                Log.i(str2, "caching request...");
                File file2 = new File(new File(context.getFilesDir(), str), Long.toString(System.currentTimeMillis()));
                file2.createNewFile();
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(file2.getPath(), true));
                try {
                    outputStreamWriter2.write("version=");
                    outputStreamWriter2.write(requestCacheData.getVersion());
                    outputStreamWriter2.write(10);
                    outputStreamWriter2.write("url=");
                    outputStreamWriter2.write(requestCacheData.getRequestURL());
                    outputStreamWriter2.write(10);
                    outputStreamWriter2.write("data=");
                    outputStreamWriter2.write(requestCacheData.getPostData());
                    outputStreamWriter2.write(10);
                    outputStreamWriter2.flush();
                    try {
                        outputStreamWriter2.close();
                    } catch (IOException unused) {
                    }
                } catch (Exception unused2) {
                    outputStreamWriter = outputStreamWriter2;
                    try {
                        Log.i(str2, "Could not cache request");
                        if (outputStreamWriter != null) {
                            try {
                                outputStreamWriter.close();
                            } catch (IOException unused3) {
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (outputStreamWriter != null) {
                            try {
                                outputStreamWriter.close();
                            } catch (IOException unused4) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    outputStreamWriter = outputStreamWriter2;
                    if (outputStreamWriter != null) {
                    }
                    throw th;
                }
            } else {
                Log.i(str2, "reached cache limit, not caching request");
            }
        } catch (Exception unused5) {
            Log.i(str2, "Could not cache request");
            if (outputStreamWriter != null) {
            }
        }
    }

    public void clearCache(Context context) {
        File[] listFiles;
        String str = AppsFlyerLib.LOG_TAG;
        try {
            File file = new File(context.getFilesDir(), AF_CACHE_DIR);
            if (!file.exists()) {
                file.mkdir();
                return;
            }
            for (File file2 : file.listFiles()) {
                StringBuilder sb = new StringBuilder("Found cached request");
                sb.append(file2.getName());
                Log.i(str, sb.toString());
                deleteRequest(m123(file2).getCacheKey(), context);
            }
        } catch (Exception unused) {
            Log.i(str, "Could not cache request");
        }
    }

    public void deleteRequest(String str, Context context) {
        File file = new File(new File(context.getFilesDir(), AF_CACHE_DIR), str);
        StringBuilder sb = new StringBuilder("Deleting ");
        sb.append(str);
        String str2 = " from cache";
        sb.append(str2);
        String sb2 = sb.toString();
        String str3 = AppsFlyerLib.LOG_TAG;
        Log.i(str3, sb2);
        if (file.exists()) {
            try {
                file.delete();
            } catch (Exception e2) {
                StringBuilder sb3 = new StringBuilder("Could not delete ");
                sb3.append(str);
                sb3.append(str2);
                Log.i(str3, sb3.toString(), e2);
            }
        }
    }

    public List<RequestCacheData> getCachedRequests(Context context) {
        File[] listFiles;
        String str = AppsFlyerLib.LOG_TAG;
        ArrayList arrayList = new ArrayList();
        try {
            File file = new File(context.getFilesDir(), AF_CACHE_DIR);
            if (!file.exists()) {
                file.mkdir();
            } else {
                for (File file2 : file.listFiles()) {
                    StringBuilder sb = new StringBuilder("Found cached request");
                    sb.append(file2.getName());
                    Log.i(str, sb.toString());
                    arrayList.add(m123(file2));
                }
            }
        } catch (Exception unused) {
            Log.i(str, "Could not cache request");
        }
        return arrayList;
    }

    public void init(Context context) {
        String str = AF_CACHE_DIR;
        try {
            if (!new File(context.getFilesDir(), str).exists()) {
                new File(context.getFilesDir(), str).mkdir();
            }
        } catch (Exception unused) {
            Log.i(AppsFlyerLib.LOG_TAG, "Could not create cache directory");
        }
    }
}
