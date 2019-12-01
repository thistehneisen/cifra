package l.a.d.a.a.a;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.appcompat.app.C0147n;
import java.util.ArrayList;
import kotlin.e.b.h;
import l.a.d.b.a.c;
import l.a.d.b.a.d;
import ru.touchin.roboswag.components.navigation.viewcontrollers.LifecycleLoggingObserver;

/* compiled from: BaseActivity.kt */
public abstract class a extends C0147n {

    /* renamed from: a reason: collision with root package name */
    private final ArrayList<b> f10400a = new ArrayList<>();

    /* renamed from: b reason: collision with root package name */
    private final ru.touchin.roboswag.components.navigation.keyboard_resizeable.a f10401b;

    public a() {
        getLifecycle().a(new LifecycleLoggingObserver());
    }

    public ru.touchin.roboswag.components.navigation.keyboard_resizeable.a a() {
        return this.f10401b;
    }

    public void b(b bVar) {
        h.b(bVar, "onBackPressedListener");
        this.f10400a.remove(bVar);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        d dVar = d.f10427b;
        StringBuilder sb = new StringBuilder();
        sb.append(c.a((Object) this));
        sb.append(" requestCode: ");
        sb.append(i2);
        sb.append("; resultCode: ");
        sb.append(i3);
        dVar.b(sb.toString(), new Object[0]);
    }

    public void onBackPressed() {
        for (b a2 : q.a((Iterable<? extends T>) this.f10400a)) {
            if (a2.a()) {
                return;
            }
        }
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        super.onCreate(bundle, persistableBundle);
        if (!isTaskRoot() && getIntent().hasCategory("android.intent.category.LAUNCHER")) {
            Intent intent = getIntent();
            h.a((Object) intent, "intent");
            if (h.a((Object) "android.intent.action.MAIN", (Object) intent.getAction())) {
                c.a("Finishing activity as it is launcher but not root", new Object[0]);
                finish();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        h.b(bundle, "stateToSave");
        super.onSaveInstanceState(bundle);
        d.f10427b.b(c.a((Object) this), new Object[0]);
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void a(b bVar) {
        h.b(bVar, "onBackPressedListener");
        this.f10400a.add(bVar);
    }
}
