package c.c.a;

import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.m;
import androidx.recyclerview.widget.RecyclerView.x;
import b.g.i.C0248i;

/* compiled from: ItemTouchHelperExtension */
class c implements m {

    /* renamed from: a reason: collision with root package name */
    boolean f3186a = false;

    /* renamed from: b reason: collision with root package name */
    float f3187b = 0.0f;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ k f3188c;

    c(k kVar) {
        this.f3188c = kVar;
    }

    public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.f3188c.B.a(motionEvent);
        if (this.f3188c.v != null) {
            this.f3188c.v.addMovement(motionEvent);
        }
        if (this.f3188c.n != -1) {
            int b2 = C0248i.b(motionEvent);
            int a2 = C0248i.a(motionEvent, this.f3188c.n);
            if (a2 >= 0) {
                this.f3188c.a(b2, motionEvent, a2);
            }
            k kVar = this.f3188c;
            x xVar = kVar.f3198d;
            if (xVar != null) {
                int i2 = 1;
                if (b2 != 1) {
                    if (b2 != 2) {
                        if (b2 != 3) {
                            if (b2 != 6) {
                                this.f3186a = false;
                            } else {
                                this.f3186a = false;
                                int a3 = C0248i.a(motionEvent);
                                if (C0248i.b(motionEvent, a3) == this.f3188c.n) {
                                    if (a3 != 0) {
                                        i2 = 0;
                                    }
                                    this.f3188c.n = C0248i.b(motionEvent, i2);
                                    k kVar2 = this.f3188c;
                                    kVar2.a(motionEvent, kVar2.q, a3);
                                }
                            }
                        } else if (kVar.v != null) {
                            this.f3188c.v.clear();
                        }
                    } else if (a2 >= 0) {
                        kVar.a(motionEvent, kVar.q, a2);
                        if (Math.abs(motionEvent.getX() - this.f3187b) > ((float) this.f3188c.s)) {
                            this.f3186a = false;
                        }
                        this.f3187b = motionEvent.getX();
                        this.f3188c.b(xVar);
                        this.f3188c.t.removeCallbacks(this.f3188c.u);
                        this.f3188c.u.run();
                        this.f3188c.t.invalidate();
                    }
                }
                if (this.f3186a) {
                    this.f3188c.a(motionEvent.getRawX(), motionEvent.getRawY());
                }
                this.f3186a = false;
                this.f3188c.c(null, 0);
                this.f3188c.n = -1;
            }
        }
    }

    public boolean b(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.f3188c.B.a(motionEvent);
        int b2 = C0248i.b(motionEvent);
        if (b2 == 0) {
            this.f3188c.n = C0248i.b(motionEvent, 0);
            this.f3188c.f3200f = motionEvent.getX();
            this.f3188c.f3201g = motionEvent.getY();
            this.f3186a = true;
            this.f3187b = motionEvent.getX();
            this.f3188c.h();
            k kVar = this.f3188c;
            if (kVar.f3198d == null) {
                c b3 = kVar.a(motionEvent);
                if (b3 != null) {
                    k kVar2 = this.f3188c;
                    kVar2.f3200f -= b3.f3221j;
                    kVar2.f3201g -= b3.f3222k;
                    kVar2.a(b3.f3216e, true);
                    if (this.f3188c.f3196b.remove(b3.f3216e.itemView)) {
                        k kVar3 = this.f3188c;
                        kVar3.o.a(kVar3.t, b3.f3216e);
                    }
                    this.f3188c.c(b3.f3216e, b3.f3217f);
                    k kVar4 = this.f3188c;
                    kVar4.a(motionEvent, kVar4.q, 0);
                }
            }
        } else if (b2 == 3 || b2 == 1) {
            k kVar5 = this.f3188c;
            kVar5.n = -1;
            if (this.f3186a && b2 == 1) {
                kVar5.a(motionEvent.getRawX(), motionEvent.getRawY());
            }
            this.f3188c.c(null, 0);
        } else {
            int i2 = this.f3188c.n;
            if (i2 != -1) {
                int a2 = C0248i.a(motionEvent, i2);
                if (a2 >= 0) {
                    this.f3188c.a(b2, motionEvent, a2);
                }
            }
        }
        if (this.f3188c.v != null) {
            this.f3188c.v.addMovement(motionEvent);
        }
        if (this.f3188c.f3198d != null) {
            return true;
        }
        return false;
    }

    public void a(boolean z) {
        if (z) {
            this.f3188c.c(null, 0);
        }
    }
}
