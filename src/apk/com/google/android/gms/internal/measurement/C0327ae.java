package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.a;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.ae reason: case insensitive filesystem */
public interface C0327ae extends IInterface {
    void beginAdUnitExposure(String str, long j2) throws RemoteException;

    void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException;

    void endAdUnitExposure(String str, long j2) throws RemoteException;

    void generateEventId(sf sfVar) throws RemoteException;

    void getAppInstanceId(sf sfVar) throws RemoteException;

    void getCachedAppInstanceId(sf sfVar) throws RemoteException;

    void getConditionalUserProperties(String str, String str2, sf sfVar) throws RemoteException;

    void getCurrentScreenClass(sf sfVar) throws RemoteException;

    void getCurrentScreenName(sf sfVar) throws RemoteException;

    void getDeepLink(sf sfVar) throws RemoteException;

    void getGmpAppId(sf sfVar) throws RemoteException;

    void getMaxUserProperties(String str, sf sfVar) throws RemoteException;

    void getTestFlag(sf sfVar, int i2) throws RemoteException;

    void getUserProperties(String str, String str2, boolean z, sf sfVar) throws RemoteException;

    void initForTests(Map map) throws RemoteException;

    void initialize(a aVar, Af af, long j2) throws RemoteException;

    void isDataCollectionEnabled(sf sfVar) throws RemoteException;

    void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j2) throws RemoteException;

    void logEventAndBundle(String str, String str2, Bundle bundle, sf sfVar, long j2) throws RemoteException;

    void logHealthData(int i2, String str, a aVar, a aVar2, a aVar3) throws RemoteException;

    void onActivityCreated(a aVar, Bundle bundle, long j2) throws RemoteException;

    void onActivityDestroyed(a aVar, long j2) throws RemoteException;

    void onActivityPaused(a aVar, long j2) throws RemoteException;

    void onActivityResumed(a aVar, long j2) throws RemoteException;

    void onActivitySaveInstanceState(a aVar, sf sfVar, long j2) throws RemoteException;

    void onActivityStarted(a aVar, long j2) throws RemoteException;

    void onActivityStopped(a aVar, long j2) throws RemoteException;

    void performAction(Bundle bundle, sf sfVar, long j2) throws RemoteException;

    void registerOnMeasurementEventListener(tf tfVar) throws RemoteException;

    void resetAnalyticsData(long j2) throws RemoteException;

    void setConditionalUserProperty(Bundle bundle, long j2) throws RemoteException;

    void setCurrentScreen(a aVar, String str, String str2, long j2) throws RemoteException;

    void setDataCollectionEnabled(boolean z) throws RemoteException;

    void setEventInterceptor(tf tfVar) throws RemoteException;

    void setInstanceIdProvider(yf yfVar) throws RemoteException;

    void setMeasurementEnabled(boolean z, long j2) throws RemoteException;

    void setMinimumSessionDuration(long j2) throws RemoteException;

    void setSessionTimeoutDuration(long j2) throws RemoteException;

    void setUserId(String str, long j2) throws RemoteException;

    void setUserProperty(String str, String str2, a aVar, boolean z, long j2) throws RemoteException;

    void unregisterOnMeasurementEventListener(tf tfVar) throws RemoteException;
}
