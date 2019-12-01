package io.intercom.android.sdk.blocks;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Spanned;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import b.g.a.a;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.blocks.blockInterfaces.CodeBlock;
import io.intercom.android.sdk.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.utilities.BlockUtils;

class Code implements CodeBlock {
    Code() {
    }

    private TextView getCodeBlockView(Spanned spanned, Context context) {
        TextView textView = new TextView(context);
        textView.setTextColor(a.a(context, R.color.intercom_white));
        textView.setTextSize(14.0f);
        textView.setText(spanned);
        textView.setPadding(ScreenUtils.dpToPx(14.0f, context), ScreenUtils.dpToPx(12.0f, context), ScreenUtils.dpToPx(14.0f, context), ScreenUtils.dpToPx(14.0f, context));
        textView.setBackgroundResource(R.color.intercom_slate_grey_two);
        textView.setTypeface(Typeface.MONOSPACE);
        BlockUtils.createLayoutParams(textView, -2, -2);
        BlockUtils.setDefaultMarginBottom(textView);
        return textView;
    }

    public View addCode(Spanned spanned, boolean z, boolean z2, ViewGroup viewGroup) {
        TextView codeBlockView = getCodeBlockView(spanned, viewGroup.getContext());
        BlockUtils.setLayoutMarginsAndGravity(codeBlockView, 3, z2);
        return codeBlockView;
    }
}
