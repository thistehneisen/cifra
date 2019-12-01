package io.intercom.android.sdk.blocks.messengercard;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.ColorStateList;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.AutoCompleteTextView;
import androidx.appcompat.app.C0146m.a;
import b.g.i.B;
import io.intercom.android.sdk.R;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

class MessengerCardAlertDialogBuilder extends a {
    MessengerCardAlertDialogBuilder(Context context, Map<String, Object> map, int i2, WebView webView) {
        super(context);
        setUp(context, map, i2, webView);
    }

    private void setUp(Context context, final Map<String, Object> map, int i2, final WebView webView) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.intercom_webview_card_input, null, false);
        setTitle((CharSequence) map.get("label"));
        final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) inflate.findViewById(R.id.input);
        autoCompleteTextView.setText((CharSequence) map.get("currentValue"));
        autoCompleteTextView.setHint((CharSequence) map.get("placeholder"));
        B.a((View) autoCompleteTextView, ColorStateList.valueOf(i2));
        setView(inflate);
        setPositiveButton(17039370, (OnClickListener) new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                MessengerCardAlertDialogBuilder.this.sendResultToWebview(webView, autoCompleteTextView.getText().toString(), map);
                ((InputMethodManager) autoCompleteTextView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(autoCompleteTextView.getWindowToken(), 0);
                dialogInterface.dismiss();
            }
        });
        setNegativeButton(17039360, (OnClickListener) new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                ((InputMethodManager) autoCompleteTextView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(autoCompleteTextView.getWindowToken(), 0);
                dialogInterface.cancel();
            }
        });
    }

    /* access modifiers changed from: 0000 */
    public void sendResultToWebview(WebView webView, String str, Map<String, Object> map) {
        String str2;
        try {
            str2 = URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            str2 = "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("window.fallbackApp.bridgeEvent('UPDATE_TEXT', { value:'");
        sb.append(str2);
        sb.append("', id:'");
        sb.append(map.get("id"));
        sb.append("'})");
        String sb2 = sb.toString();
        if (VERSION.SDK_INT >= 19) {
            webView.evaluateJavascript(sb2, null);
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("javascript:");
        sb3.append(sb2);
        webView.loadUrl(sb3.toString());
    }
}
