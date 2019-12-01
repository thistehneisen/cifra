package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.a.C0066a;

public abstract class qf extends C0322a implements C0327ae {
    public qf() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static C0327ae asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        if (queryLocalInterface instanceof C0327ae) {
            return (C0327ae) queryLocalInterface;
        }
        return new C0335bf(iBinder);
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v9, types: [com.google.android.gms.internal.measurement.sf] */
    /* JADX WARNING: type inference failed for: r3v11, types: [com.google.android.gms.internal.measurement.uf] */
    /* JADX WARNING: type inference failed for: r3v13, types: [com.google.android.gms.internal.measurement.sf] */
    /* JADX WARNING: type inference failed for: r3v14, types: [com.google.android.gms.internal.measurement.sf] */
    /* JADX WARNING: type inference failed for: r3v16, types: [com.google.android.gms.internal.measurement.uf] */
    /* JADX WARNING: type inference failed for: r3v18, types: [com.google.android.gms.internal.measurement.sf] */
    /* JADX WARNING: type inference failed for: r3v20, types: [com.google.android.gms.internal.measurement.sf] */
    /* JADX WARNING: type inference failed for: r3v22, types: [com.google.android.gms.internal.measurement.uf] */
    /* JADX WARNING: type inference failed for: r3v24, types: [com.google.android.gms.internal.measurement.sf] */
    /* JADX WARNING: type inference failed for: r3v26, types: [com.google.android.gms.internal.measurement.sf] */
    /* JADX WARNING: type inference failed for: r3v27, types: [com.google.android.gms.internal.measurement.uf] */
    /* JADX WARNING: type inference failed for: r3v29, types: [com.google.android.gms.internal.measurement.sf] */
    /* JADX WARNING: type inference failed for: r3v30, types: [com.google.android.gms.internal.measurement.sf] */
    /* JADX WARNING: type inference failed for: r3v31, types: [com.google.android.gms.internal.measurement.uf] */
    /* JADX WARNING: type inference failed for: r3v33, types: [com.google.android.gms.internal.measurement.sf] */
    /* JADX WARNING: type inference failed for: r3v34, types: [com.google.android.gms.internal.measurement.yf] */
    /* JADX WARNING: type inference failed for: r3v35, types: [com.google.android.gms.internal.measurement.xf] */
    /* JADX WARNING: type inference failed for: r3v37, types: [com.google.android.gms.internal.measurement.yf] */
    /* JADX WARNING: type inference failed for: r3v38, types: [com.google.android.gms.internal.measurement.sf] */
    /* JADX WARNING: type inference failed for: r3v39, types: [com.google.android.gms.internal.measurement.uf] */
    /* JADX WARNING: type inference failed for: r3v41, types: [com.google.android.gms.internal.measurement.sf] */
    /* JADX WARNING: type inference failed for: r3v42, types: [com.google.android.gms.internal.measurement.sf] */
    /* JADX WARNING: type inference failed for: r3v43, types: [com.google.android.gms.internal.measurement.uf] */
    /* JADX WARNING: type inference failed for: r3v45, types: [com.google.android.gms.internal.measurement.sf] */
    /* JADX WARNING: type inference failed for: r3v46, types: [com.google.android.gms.internal.measurement.sf] */
    /* JADX WARNING: type inference failed for: r3v47, types: [com.google.android.gms.internal.measurement.uf] */
    /* JADX WARNING: type inference failed for: r3v49, types: [com.google.android.gms.internal.measurement.sf] */
    /* JADX WARNING: type inference failed for: r3v50, types: [com.google.android.gms.internal.measurement.sf] */
    /* JADX WARNING: type inference failed for: r3v51, types: [com.google.android.gms.internal.measurement.uf] */
    /* JADX WARNING: type inference failed for: r3v53, types: [com.google.android.gms.internal.measurement.sf] */
    /* JADX WARNING: type inference failed for: r3v55, types: [com.google.android.gms.internal.measurement.sf] */
    /* JADX WARNING: type inference failed for: r3v57, types: [com.google.android.gms.internal.measurement.uf] */
    /* JADX WARNING: type inference failed for: r3v59, types: [com.google.android.gms.internal.measurement.sf] */
    /* JADX WARNING: type inference failed for: r3v60, types: [com.google.android.gms.internal.measurement.sf] */
    /* JADX WARNING: type inference failed for: r3v62, types: [com.google.android.gms.internal.measurement.uf] */
    /* JADX WARNING: type inference failed for: r3v64, types: [com.google.android.gms.internal.measurement.sf] */
    /* JADX WARNING: type inference failed for: r3v67, types: [com.google.android.gms.internal.measurement.tf] */
    /* JADX WARNING: type inference failed for: r3v68, types: [com.google.android.gms.internal.measurement.vf] */
    /* JADX WARNING: type inference failed for: r3v70, types: [com.google.android.gms.internal.measurement.tf] */
    /* JADX WARNING: type inference failed for: r3v71, types: [com.google.android.gms.internal.measurement.tf] */
    /* JADX WARNING: type inference failed for: r3v72, types: [com.google.android.gms.internal.measurement.vf] */
    /* JADX WARNING: type inference failed for: r3v74, types: [com.google.android.gms.internal.measurement.tf] */
    /* JADX WARNING: type inference failed for: r3v75, types: [com.google.android.gms.internal.measurement.tf] */
    /* JADX WARNING: type inference failed for: r3v76, types: [com.google.android.gms.internal.measurement.vf] */
    /* JADX WARNING: type inference failed for: r3v78, types: [com.google.android.gms.internal.measurement.tf] */
    /* JADX WARNING: type inference failed for: r3v79, types: [com.google.android.gms.internal.measurement.sf] */
    /* JADX WARNING: type inference failed for: r3v81, types: [com.google.android.gms.internal.measurement.uf] */
    /* JADX WARNING: type inference failed for: r3v83, types: [com.google.android.gms.internal.measurement.sf] */
    /* JADX WARNING: type inference failed for: r3v84, types: [com.google.android.gms.internal.measurement.sf] */
    /* JADX WARNING: type inference failed for: r3v85, types: [com.google.android.gms.internal.measurement.uf] */
    /* JADX WARNING: type inference failed for: r3v87, types: [com.google.android.gms.internal.measurement.sf] */
    /* JADX WARNING: type inference failed for: r3v88, types: [com.google.android.gms.internal.measurement.sf] */
    /* JADX WARNING: type inference failed for: r3v89, types: [com.google.android.gms.internal.measurement.uf] */
    /* JADX WARNING: type inference failed for: r3v91, types: [com.google.android.gms.internal.measurement.sf] */
    /* JADX WARNING: type inference failed for: r3v92 */
    /* JADX WARNING: type inference failed for: r3v93 */
    /* JADX WARNING: type inference failed for: r3v94 */
    /* JADX WARNING: type inference failed for: r3v95 */
    /* JADX WARNING: type inference failed for: r3v96 */
    /* JADX WARNING: type inference failed for: r3v97 */
    /* JADX WARNING: type inference failed for: r3v98 */
    /* JADX WARNING: type inference failed for: r3v99 */
    /* JADX WARNING: type inference failed for: r3v100 */
    /* JADX WARNING: type inference failed for: r3v101 */
    /* JADX WARNING: type inference failed for: r3v102 */
    /* JADX WARNING: type inference failed for: r3v103 */
    /* JADX WARNING: type inference failed for: r3v104 */
    /* JADX WARNING: type inference failed for: r3v105 */
    /* JADX WARNING: type inference failed for: r3v106 */
    /* JADX WARNING: type inference failed for: r3v107 */
    /* JADX WARNING: type inference failed for: r3v108 */
    /* JADX WARNING: type inference failed for: r3v109 */
    /* JADX WARNING: type inference failed for: r3v110 */
    /* JADX WARNING: type inference failed for: r3v111 */
    /* JADX WARNING: type inference failed for: r3v112 */
    /* JADX WARNING: type inference failed for: r3v113 */
    /* JADX WARNING: type inference failed for: r3v114 */
    /* JADX WARNING: type inference failed for: r3v115 */
    /* JADX WARNING: type inference failed for: r3v116 */
    /* JADX WARNING: type inference failed for: r3v117 */
    /* JADX WARNING: type inference failed for: r3v118 */
    /* JADX WARNING: type inference failed for: r3v119 */
    /* JADX WARNING: type inference failed for: r3v120 */
    /* JADX WARNING: type inference failed for: r3v121 */
    /* JADX WARNING: type inference failed for: r3v122 */
    /* JADX WARNING: type inference failed for: r3v123 */
    /* JADX WARNING: type inference failed for: r3v124 */
    /* JADX WARNING: type inference failed for: r3v125 */
    /* JADX WARNING: type inference failed for: r3v126 */
    /* JADX WARNING: type inference failed for: r3v127 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v0
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.internal.measurement.uf, com.google.android.gms.internal.measurement.sf, com.google.android.gms.internal.measurement.xf, com.google.android.gms.internal.measurement.yf, com.google.android.gms.internal.measurement.vf, com.google.android.gms.internal.measurement.tf]
      uses: [com.google.android.gms.internal.measurement.sf, com.google.android.gms.internal.measurement.yf, com.google.android.gms.internal.measurement.tf]
      mth insns count: 343
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
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 37 */
    public final boolean a(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        sf sfVar;
        sf sfVar2;
        String str = "com.google.android.gms.measurement.api.internal.IEventHandlerProxy";
        String str2 = "com.google.android.gms.measurement.api.internal.IBundleReceiver";
        ? r3 = 0;
        switch (i2) {
            case 1:
                initialize(C0066a.a(parcel.readStrongBinder()), (Af) Ha.a(parcel, Af.CREATOR), parcel.readLong());
                break;
            case 2:
                logEvent(parcel.readString(), parcel.readString(), (Bundle) Ha.a(parcel, Bundle.CREATOR), Ha.a(parcel), Ha.a(parcel), parcel.readLong());
                break;
            case 3:
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                Bundle bundle = (Bundle) Ha.a(parcel, Bundle.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    sfVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface(str2);
                    if (queryLocalInterface instanceof sf) {
                        sfVar2 = (sf) queryLocalInterface;
                    } else {
                        sfVar2 = new uf(readStrongBinder);
                    }
                    sfVar = sfVar2;
                }
                logEventAndBundle(readString, readString2, bundle, sfVar, parcel.readLong());
                break;
            case 4:
                setUserProperty(parcel.readString(), parcel.readString(), C0066a.a(parcel.readStrongBinder()), Ha.a(parcel), parcel.readLong());
                break;
            case 5:
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                boolean a2 = Ha.a(parcel);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface(str2);
                    if (queryLocalInterface2 instanceof sf) {
                        r3 = (sf) queryLocalInterface2;
                    } else {
                        r3 = new uf(readStrongBinder2);
                    }
                }
                getUserProperties(readString3, readString4, a2, r3);
                break;
            case 6:
                String readString5 = parcel.readString();
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface(str2);
                    if (queryLocalInterface3 instanceof sf) {
                        r3 = (sf) queryLocalInterface3;
                    } else {
                        r3 = new uf(readStrongBinder3);
                    }
                }
                getMaxUserProperties(readString5, r3);
                break;
            case 7:
                setUserId(parcel.readString(), parcel.readLong());
                break;
            case 8:
                setConditionalUserProperty((Bundle) Ha.a(parcel, Bundle.CREATOR), parcel.readLong());
                break;
            case 9:
                clearConditionalUserProperty(parcel.readString(), parcel.readString(), (Bundle) Ha.a(parcel, Bundle.CREATOR));
                break;
            case 10:
                String readString6 = parcel.readString();
                String readString7 = parcel.readString();
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface(str2);
                    if (queryLocalInterface4 instanceof sf) {
                        r3 = (sf) queryLocalInterface4;
                    } else {
                        r3 = new uf(readStrongBinder4);
                    }
                }
                getConditionalUserProperties(readString6, readString7, r3);
                break;
            case 11:
                setMeasurementEnabled(Ha.a(parcel), parcel.readLong());
                break;
            case 12:
                resetAnalyticsData(parcel.readLong());
                break;
            case 13:
                setMinimumSessionDuration(parcel.readLong());
                break;
            case 14:
                setSessionTimeoutDuration(parcel.readLong());
                break;
            case 15:
                setCurrentScreen(C0066a.a(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readLong());
                break;
            case 16:
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface(str2);
                    if (queryLocalInterface5 instanceof sf) {
                        r3 = (sf) queryLocalInterface5;
                    } else {
                        r3 = new uf(readStrongBinder5);
                    }
                }
                getCurrentScreenName(r3);
                break;
            case 17:
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface(str2);
                    if (queryLocalInterface6 instanceof sf) {
                        r3 = (sf) queryLocalInterface6;
                    } else {
                        r3 = new uf(readStrongBinder6);
                    }
                }
                getCurrentScreenClass(r3);
                break;
            case 18:
                IBinder readStrongBinder7 = parcel.readStrongBinder();
                if (readStrongBinder7 != null) {
                    IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    if (queryLocalInterface7 instanceof yf) {
                        r3 = (yf) queryLocalInterface7;
                    } else {
                        r3 = new xf(readStrongBinder7);
                    }
                }
                setInstanceIdProvider(r3);
                break;
            case 19:
                IBinder readStrongBinder8 = parcel.readStrongBinder();
                if (readStrongBinder8 != null) {
                    IInterface queryLocalInterface8 = readStrongBinder8.queryLocalInterface(str2);
                    if (queryLocalInterface8 instanceof sf) {
                        r3 = (sf) queryLocalInterface8;
                    } else {
                        r3 = new uf(readStrongBinder8);
                    }
                }
                getCachedAppInstanceId(r3);
                break;
            case 20:
                IBinder readStrongBinder9 = parcel.readStrongBinder();
                if (readStrongBinder9 != null) {
                    IInterface queryLocalInterface9 = readStrongBinder9.queryLocalInterface(str2);
                    if (queryLocalInterface9 instanceof sf) {
                        r3 = (sf) queryLocalInterface9;
                    } else {
                        r3 = new uf(readStrongBinder9);
                    }
                }
                getAppInstanceId(r3);
                break;
            case 21:
                IBinder readStrongBinder10 = parcel.readStrongBinder();
                if (readStrongBinder10 != null) {
                    IInterface queryLocalInterface10 = readStrongBinder10.queryLocalInterface(str2);
                    if (queryLocalInterface10 instanceof sf) {
                        r3 = (sf) queryLocalInterface10;
                    } else {
                        r3 = new uf(readStrongBinder10);
                    }
                }
                getGmpAppId(r3);
                break;
            case 22:
                IBinder readStrongBinder11 = parcel.readStrongBinder();
                if (readStrongBinder11 != null) {
                    IInterface queryLocalInterface11 = readStrongBinder11.queryLocalInterface(str2);
                    if (queryLocalInterface11 instanceof sf) {
                        r3 = (sf) queryLocalInterface11;
                    } else {
                        r3 = new uf(readStrongBinder11);
                    }
                }
                generateEventId(r3);
                break;
            case 23:
                beginAdUnitExposure(parcel.readString(), parcel.readLong());
                break;
            case 24:
                endAdUnitExposure(parcel.readString(), parcel.readLong());
                break;
            case 25:
                onActivityStarted(C0066a.a(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 26:
                onActivityStopped(C0066a.a(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 27:
                onActivityCreated(C0066a.a(parcel.readStrongBinder()), (Bundle) Ha.a(parcel, Bundle.CREATOR), parcel.readLong());
                break;
            case 28:
                onActivityDestroyed(C0066a.a(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 29:
                onActivityPaused(C0066a.a(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 30:
                onActivityResumed(C0066a.a(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 31:
                a a3 = C0066a.a(parcel.readStrongBinder());
                IBinder readStrongBinder12 = parcel.readStrongBinder();
                if (readStrongBinder12 != null) {
                    IInterface queryLocalInterface12 = readStrongBinder12.queryLocalInterface(str2);
                    if (queryLocalInterface12 instanceof sf) {
                        r3 = (sf) queryLocalInterface12;
                    } else {
                        r3 = new uf(readStrongBinder12);
                    }
                }
                onActivitySaveInstanceState(a3, r3, parcel.readLong());
                break;
            case 32:
                Bundle bundle2 = (Bundle) Ha.a(parcel, Bundle.CREATOR);
                IBinder readStrongBinder13 = parcel.readStrongBinder();
                if (readStrongBinder13 != null) {
                    IInterface queryLocalInterface13 = readStrongBinder13.queryLocalInterface(str2);
                    if (queryLocalInterface13 instanceof sf) {
                        r3 = (sf) queryLocalInterface13;
                    } else {
                        r3 = new uf(readStrongBinder13);
                    }
                }
                performAction(bundle2, r3, parcel.readLong());
                break;
            case 33:
                logHealthData(parcel.readInt(), parcel.readString(), C0066a.a(parcel.readStrongBinder()), C0066a.a(parcel.readStrongBinder()), C0066a.a(parcel.readStrongBinder()));
                break;
            case 34:
                IBinder readStrongBinder14 = parcel.readStrongBinder();
                if (readStrongBinder14 != null) {
                    IInterface queryLocalInterface14 = readStrongBinder14.queryLocalInterface(str);
                    if (queryLocalInterface14 instanceof tf) {
                        r3 = (tf) queryLocalInterface14;
                    } else {
                        r3 = new vf(readStrongBinder14);
                    }
                }
                setEventInterceptor(r3);
                break;
            case 35:
                IBinder readStrongBinder15 = parcel.readStrongBinder();
                if (readStrongBinder15 != null) {
                    IInterface queryLocalInterface15 = readStrongBinder15.queryLocalInterface(str);
                    if (queryLocalInterface15 instanceof tf) {
                        r3 = (tf) queryLocalInterface15;
                    } else {
                        r3 = new vf(readStrongBinder15);
                    }
                }
                registerOnMeasurementEventListener(r3);
                break;
            case 36:
                IBinder readStrongBinder16 = parcel.readStrongBinder();
                if (readStrongBinder16 != null) {
                    IInterface queryLocalInterface16 = readStrongBinder16.queryLocalInterface(str);
                    if (queryLocalInterface16 instanceof tf) {
                        r3 = (tf) queryLocalInterface16;
                    } else {
                        r3 = new vf(readStrongBinder16);
                    }
                }
                unregisterOnMeasurementEventListener(r3);
                break;
            case 37:
                initForTests(Ha.b(parcel));
                break;
            case 38:
                IBinder readStrongBinder17 = parcel.readStrongBinder();
                if (readStrongBinder17 != null) {
                    IInterface queryLocalInterface17 = readStrongBinder17.queryLocalInterface(str2);
                    if (queryLocalInterface17 instanceof sf) {
                        r3 = (sf) queryLocalInterface17;
                    } else {
                        r3 = new uf(readStrongBinder17);
                    }
                }
                getTestFlag(r3, parcel.readInt());
                break;
            case 39:
                setDataCollectionEnabled(Ha.a(parcel));
                break;
            case 40:
                IBinder readStrongBinder18 = parcel.readStrongBinder();
                if (readStrongBinder18 != null) {
                    IInterface queryLocalInterface18 = readStrongBinder18.queryLocalInterface(str2);
                    if (queryLocalInterface18 instanceof sf) {
                        r3 = (sf) queryLocalInterface18;
                    } else {
                        r3 = new uf(readStrongBinder18);
                    }
                }
                isDataCollectionEnabled(r3);
                break;
            case 41:
                IBinder readStrongBinder19 = parcel.readStrongBinder();
                if (readStrongBinder19 != null) {
                    IInterface queryLocalInterface19 = readStrongBinder19.queryLocalInterface(str2);
                    if (queryLocalInterface19 instanceof sf) {
                        r3 = (sf) queryLocalInterface19;
                    } else {
                        r3 = new uf(readStrongBinder19);
                    }
                }
                getDeepLink(r3);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
