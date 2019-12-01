package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* compiled from: AppCompatSpinner */
class C implements OnItemClickListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ B f749a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ b f750b;

    C(b bVar, B b2) {
        this.f750b = bVar;
        this.f749a = b2;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        B.this.setSelection(i2);
        if (B.this.getOnItemClickListener() != null) {
            b bVar = this.f750b;
            B.this.performItemClick(view, i2, bVar.L.getItemId(i2));
        }
        this.f750b.dismiss();
    }
}
