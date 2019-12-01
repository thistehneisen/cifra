package io.intercom.android.sdk.blocks;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import b.g.a.a;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.blocks.blockInterfaces.OrderedListBlock;
import io.intercom.android.sdk.blocks.blockInterfaces.UnorderedListBlock;
import io.intercom.android.sdk.commons.utilities.HtmlCompat;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.spans.OrderedListSpan;
import io.intercom.android.sdk.spans.UnorderedListSpan;
import io.intercom.android.sdk.utilities.BlockUtils;
import io.intercom.android.sdk.utilities.TrackingLinkMovementMethod;
import java.util.List;

class ListBlock implements OrderedListBlock, UnorderedListBlock {
    private static final int LARGE_TEXT_SIZE_SP = 16;
    private static final int SMALL_TEXT_SIZE_SP = 14;
    private final Provider<AppConfig> appConfigProvider;
    private final StyleType style;

    /* renamed from: io.intercom.android.sdk.blocks.ListBlock$1 reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$blocks$StyleType = new int[StyleType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|(3:11|12|14)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            $SwitchMap$io$intercom$android$sdk$blocks$StyleType[StyleType.ADMIN.ordinal()] = 1;
            $SwitchMap$io$intercom$android$sdk$blocks$StyleType[StyleType.ARTICLE.ordinal()] = 2;
            $SwitchMap$io$intercom$android$sdk$blocks$StyleType[StyleType.NOTE.ordinal()] = 3;
            $SwitchMap$io$intercom$android$sdk$blocks$StyleType[StyleType.CONTAINER_CARD.ordinal()] = 4;
            $SwitchMap$io$intercom$android$sdk$blocks$StyleType[StyleType.POST.ordinal()] = 5;
            try {
                $SwitchMap$io$intercom$android$sdk$blocks$StyleType[StyleType.CHAT_FULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    ListBlock(StyleType styleType, Provider<AppConfig> provider) {
        this.style = styleType;
        this.appConfigProvider = provider;
    }

    private TextView getListStyledTextView(Context context) {
        TextView textView = new TextView(context);
        textView.setLinkTextColor(((AppConfig) this.appConfigProvider.get()).getPrimaryColor());
        BlockUtils.createLayoutParams(textView, -2, -2);
        BlockUtils.setMarginLeft(textView, 4);
        switch (AnonymousClass1.$SwitchMap$io$intercom$android$sdk$blocks$StyleType[this.style.ordinal()]) {
            case 1:
                styleAsChatList(textView, a.a(context, R.color.intercom_grey_800));
                textView.setMovementMethod(new TrackingLinkMovementMethod());
                break;
            case 2:
            case 3:
            case 4:
                styleAsAnnouncementList(textView, a.a(context, R.color.intercom_grey_700));
                textView.setMovementMethod(new TrackingLinkMovementMethod());
                break;
            case 5:
                styleAsAnnouncementList(textView, a.a(context, R.color.intercom_white));
                textView.setMovementMethod(new TrackingLinkMovementMethod());
                break;
            case 6:
                styleAsChatList(textView, a.a(context, R.color.intercom_grey_800));
                break;
            default:
                styleAsChatList(textView, a.a(context, R.color.intercom_white));
                textView.setMovementMethod(new TrackingLinkMovementMethod());
                break;
        }
        return textView;
    }

    private void styleAsAnnouncementList(TextView textView, int i2) {
        textView.setTextSize(16.0f);
        textView.setTextColor(i2);
        BlockUtils.setMarginBottom(textView, 16);
        BlockUtils.setLargeLineSpacing(textView);
    }

    private void styleAsChatList(TextView textView, int i2) {
        textView.setTextSize(14.0f);
        textView.setTextColor(i2);
        BlockUtils.setDefaultMarginBottom(textView);
        BlockUtils.setSmallLineSpacing(textView);
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v1, types: [java.lang.CharSequence] */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: type inference failed for: r6v2, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r5v6, types: [java.lang.CharSequence[]] */
    /* JADX WARNING: type inference failed for: r4v4, types: [java.lang.CharSequence] */
    /* JADX WARNING: type inference failed for: r6v4 */
    /* JADX WARNING: type inference failed for: r6v5, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r6v6 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r4v2
      assigns: []
      uses: []
      mth insns count: 46
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
    /* JADX WARNING: Unknown variable types count: 7 */
    public View addOrderedList(List<String> list, boolean z, boolean z2, ViewGroup viewGroup) {
        ? r4;
        TextView listStyledTextView = getListStyledTextView(viewGroup.getContext());
        int dimension = (int) viewGroup.getResources().getDimension(R.dimen.intercom_list_indentation);
        int size = list.size();
        ? r1 = "";
        ? r42 = r1;
        int i2 = 0;
        while (i2 < size) {
            String str = (String) list.get(i2);
            if (str.isEmpty()) {
                r4 = r42;
            } else {
                ? r6 = i2 < size + -1 ? "<br />" : r1;
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(r6);
                Spanned fromHtml = HtmlCompat.fromHtml(sb.toString());
                SpannableString spannableString = new SpannableString(fromHtml);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i2 + 1);
                sb2.append(".");
                spannableString.setSpan(new OrderedListSpan(dimension, sb2.toString()), 0, fromHtml.length(), 0);
                r4 = TextUtils.concat(new CharSequence[]{r42, spannableString});
            }
            i2++;
            r42 = r4;
        }
        listStyledTextView.setText(r42);
        BlockUtils.setLayoutMarginsAndGravity(listStyledTextView, 3, z2);
        return listStyledTextView;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r5v1, types: [java.lang.CharSequence] */
    /* JADX WARNING: type inference failed for: r5v2 */
    /* JADX WARNING: type inference failed for: r7v2, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r6v6, types: [java.lang.CharSequence[]] */
    /* JADX WARNING: type inference failed for: r5v4, types: [java.lang.CharSequence] */
    /* JADX WARNING: type inference failed for: r7v4 */
    /* JADX WARNING: type inference failed for: r7v5, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r5v5 */
    /* JADX WARNING: type inference failed for: r5v6 */
    /* JADX WARNING: type inference failed for: r5v7 */
    /* JADX WARNING: type inference failed for: r7v6 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r5v2
      assigns: []
      uses: []
      mth insns count: 40
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
    /* JADX WARNING: Unknown variable types count: 7 */
    public View addUnorderedList(List<String> list, boolean z, boolean z2, ViewGroup viewGroup) {
        ? r5;
        Context context = viewGroup.getContext();
        TextView listStyledTextView = getListStyledTextView(context);
        int dimension = (int) viewGroup.getResources().getDimension(R.dimen.intercom_list_indentation);
        int size = list.size();
        ? r2 = "";
        ? r52 = r2;
        int i2 = 0;
        while (i2 < size) {
            String str = (String) list.get(i2);
            if (str.isEmpty()) {
                r5 = r52;
            } else {
                ? r7 = i2 < size + -1 ? "<br />" : r2;
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(r7);
                Spanned fromHtml = HtmlCompat.fromHtml(sb.toString());
                SpannableString spannableString = new SpannableString(fromHtml);
                spannableString.setSpan(new UnorderedListSpan(dimension, context), 0, fromHtml.length(), 0);
                r5 = TextUtils.concat(new CharSequence[]{r52, spannableString});
            }
            i2++;
            r52 = r5;
        }
        listStyledTextView.setText(r52);
        BlockUtils.setLayoutMarginsAndGravity(listStyledTextView, 3, z2);
        return listStyledTextView;
    }
}
