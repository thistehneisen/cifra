package io.intercom.android.sdk.blocks.messengercard;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import e.a.a.a.a.d;
import e.a.a.a.a.k;
import io.intercom.android.sdk.models.events.CardUpdatedEvent;

public class CardWebView extends WebView {
    private d bus;

    public CardWebView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d dVar = this.bus;
        if (dVar != null) {
            dVar.register(this);
        }
    }

    @k
    public void onCardUpdated(CardUpdatedEvent cardUpdatedEvent) {
        reload();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d dVar = this.bus;
        if (dVar != null) {
            dVar.unregister(this);
        }
    }

    public void setUp(d dVar) {
        this.bus = dVar;
    }

    public CardWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CardWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
