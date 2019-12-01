package c.b.a.c.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import b.d.i;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MotionSpec */
public class h {

    /* renamed from: a reason: collision with root package name */
    private final i<String, i> f3104a = new i<>();

    public i a(String str) {
        if (b(str)) {
            return (i) this.f3104a.get(str);
        }
        throw new IllegalArgumentException();
    }

    public boolean b(String str) {
        return this.f3104a.get(str) != null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        return this.f3104a.equals(((h) obj).f3104a);
    }

    public int hashCode() {
        return this.f3104a.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(10);
        sb.append(h.class.getName());
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" timings: ");
        sb.append(this.f3104a);
        sb.append("}\n");
        return sb.toString();
    }

    public void a(String str, i iVar) {
        this.f3104a.put(str, iVar);
    }

    public long a() {
        int size = this.f3104a.size();
        long j2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i iVar = (i) this.f3104a.d(i2);
            j2 = Math.max(j2, iVar.a() + iVar.b());
        }
        return j2;
    }

    public static h a(Context context, TypedArray typedArray, int i2) {
        if (typedArray.hasValue(i2)) {
            int resourceId = typedArray.getResourceId(i2, 0);
            if (resourceId != 0) {
                return a(context, resourceId);
            }
        }
        return null;
    }

    public static h a(Context context, int i2) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i2);
            if (loadAnimator instanceof AnimatorSet) {
                return a((List<Animator>) ((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(loadAnimator);
            return a((List<Animator>) arrayList);
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Can't load animation resource ID #0x");
            sb.append(Integer.toHexString(i2));
            Log.w("MotionSpec", sb.toString(), e2);
            return null;
        }
    }

    private static h a(List<Animator> list) {
        h hVar = new h();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(hVar, (Animator) list.get(i2));
        }
        return hVar;
    }

    private static void a(h hVar, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            hVar.a(objectAnimator.getPropertyName(), i.a((ValueAnimator) objectAnimator));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Animator must be an ObjectAnimator: ");
        sb.append(animator);
        throw new IllegalArgumentException(sb.toString());
    }
}
