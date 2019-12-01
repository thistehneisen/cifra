package io.intercom.android.sdk.metrics;

import android.content.Context;
import android.content.pm.Signature;
import android.text.TextUtils;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.twig.Twig;
import io.intercom.android.sdk.views.holder.AttributeType;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;

class AppTypeDetector {
    private static final X500Principal DEBUG_DN = new X500Principal("CN=Android Debug,O=Android,C=US");
    private static final Twig twig = LumberMill.getLogger();

    AppTypeDetector() {
    }

    static String getInstallerPackageName(Context context) {
        String str;
        try {
            str = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        } catch (Exception e2) {
            Twig twig2 = twig;
            StringBuilder sb = new StringBuilder();
            sb.append("Package name is unknown, error: ");
            sb.append(e2.getMessage());
            twig2.internal(sb.toString());
            str = null;
        }
        return TextUtils.isEmpty(str) ? AttributeType.UNKNOWN : str;
    }

    static boolean isDebugBuild(Context context) {
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            if (signatureArr != null && signatureArr.length > 0) {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                for (Signature byteArray : signatureArr) {
                    if (((X509Certificate) instance.generateCertificate(new ByteArrayInputStream(byteArray.toByteArray()))).getSubjectX500Principal().equals(DEBUG_DN)) {
                        return true;
                    }
                }
            }
        } catch (Exception e2) {
            Twig twig2 = twig;
            StringBuilder sb = new StringBuilder();
            sb.append("Debug build status is unknown, error: ");
            sb.append(e2.getMessage());
            twig2.internal(sb.toString());
        }
        return false;
    }
}
