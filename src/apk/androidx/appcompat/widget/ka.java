package androidx.appcompat.widget;

import androidx.appcompat.widget.SearchView.SearchAutoComplete;

/* compiled from: SearchView */
class ka implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ SearchAutoComplete f985a;

    ka(SearchAutoComplete searchAutoComplete) {
        this.f985a = searchAutoComplete;
    }

    public void run() {
        this.f985a.b();
    }
}
