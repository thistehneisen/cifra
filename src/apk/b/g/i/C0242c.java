package b.g.i;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* renamed from: b.g.i.c reason: case insensitive filesystem */
/* compiled from: GestureDetectorCompat */
public final class C0242c {

    /* renamed from: a reason: collision with root package name */
    private final a f2695a;

    /* renamed from: b.g.i.c$a */
    /* compiled from: GestureDetectorCompat */
    interface a {
        boolean a(MotionEvent motionEvent);
    }

    /* renamed from: b.g.i.c$b */
    /* compiled from: GestureDetectorCompat */
    static class b implements a {

        /* renamed from: a reason: collision with root package name */
        private static final int f2696a = ViewConfiguration.getLongPressTimeout();

        /* renamed from: b reason: collision with root package name */
        private static final int f2697b = ViewConfiguration.getTapTimeout();

        /* renamed from: c reason: collision with root package name */
        private static final int f2698c = ViewConfiguration.getDoubleTapTimeout();

        /* renamed from: d reason: collision with root package name */
        private int f2699d;

        /* renamed from: e reason: collision with root package name */
        private int f2700e;

        /* renamed from: f reason: collision with root package name */
        private int f2701f;

        /* renamed from: g reason: collision with root package name */
        private int f2702g;

        /* renamed from: h reason: collision with root package name */
        private final Handler f2703h;

        /* renamed from: i reason: collision with root package name */
        final OnGestureListener f2704i;

        /* renamed from: j reason: collision with root package name */
        OnDoubleTapListener f2705j;

        /* renamed from: k reason: collision with root package name */
        boolean f2706k;

        /* renamed from: l reason: collision with root package name */
        boolean f2707l;
        private boolean m;
        private boolean n;
        private boolean o;
        MotionEvent p;
        private MotionEvent q;
        private boolean r;
        private float s;
        private float t;
        private float u;
        private float v;
        private boolean w;
        private VelocityTracker x;

        /* renamed from: b.g.i.c$b$a */
        /* compiled from: GestureDetectorCompat */
        private class a extends Handler {
            a() {
            }

            public void handleMessage(Message message) {
                int i2 = message.what;
                if (i2 == 1) {
                    b bVar = b.this;
                    bVar.f2704i.onShowPress(bVar.p);
                } else if (i2 == 2) {
                    b.this.a();
                } else if (i2 == 3) {
                    b bVar2 = b.this;
                    OnDoubleTapListener onDoubleTapListener = bVar2.f2705j;
                    if (onDoubleTapListener == null) {
                        return;
                    }
                    if (!bVar2.f2706k) {
                        onDoubleTapListener.onSingleTapConfirmed(bVar2.p);
                    } else {
                        bVar2.f2707l = true;
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unknown message ");
                    sb.append(message);
                    throw new RuntimeException(sb.toString());
                }
            }

            a(Handler handler) {
                super(handler.getLooper());
            }
        }

        b(Context context, OnGestureListener onGestureListener, Handler handler) {
            if (handler != null) {
                this.f2703h = new a(handler);
            } else {
                this.f2703h = new a();
            }
            this.f2704i = onGestureListener;
            if (onGestureListener instanceof OnDoubleTapListener) {
                a((OnDoubleTapListener) onGestureListener);
            }
            a(context);
        }

        private void a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            } else if (this.f2704i != null) {
                this.w = true;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
                this.f2701f = viewConfiguration.getScaledMinimumFlingVelocity();
                this.f2702g = viewConfiguration.getScaledMaximumFlingVelocity();
                this.f2699d = scaledTouchSlop * scaledTouchSlop;
                this.f2700e = scaledDoubleTapSlop * scaledDoubleTapSlop;
            } else {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            }
        }

        private void b() {
            this.f2703h.removeMessages(1);
            this.f2703h.removeMessages(2);
            this.f2703h.removeMessages(3);
            this.x.recycle();
            this.x = null;
            this.r = false;
            this.f2706k = false;
            this.n = false;
            this.o = false;
            this.f2707l = false;
            if (this.m) {
                this.m = false;
            }
        }

        private void c() {
            this.f2703h.removeMessages(1);
            this.f2703h.removeMessages(2);
            this.f2703h.removeMessages(3);
            this.r = false;
            this.n = false;
            this.o = false;
            this.f2707l = false;
            if (this.m) {
                this.m = false;
            }
        }

        public void a(OnDoubleTapListener onDoubleTapListener) {
            this.f2705j = onDoubleTapListener;
        }

        /* JADX WARNING: Removed duplicated region for block: B:100:0x0208  */
        /* JADX WARNING: Removed duplicated region for block: B:103:0x021f  */
        public boolean a(MotionEvent motionEvent) {
            boolean z;
            MotionEvent motionEvent2;
            boolean z2;
            boolean z3;
            int action = motionEvent.getAction();
            if (this.x == null) {
                this.x = VelocityTracker.obtain();
            }
            this.x.addMovement(motionEvent);
            int i2 = action & 255;
            boolean z4 = i2 == 6;
            int actionIndex = z4 ? motionEvent.getActionIndex() : -1;
            int pointerCount = motionEvent.getPointerCount();
            float f2 = 0.0f;
            float f3 = 0.0f;
            for (int i3 = 0; i3 < pointerCount; i3++) {
                if (actionIndex != i3) {
                    f2 += motionEvent.getX(i3);
                    f3 += motionEvent.getY(i3);
                }
            }
            float f4 = (float) (z4 ? pointerCount - 1 : pointerCount);
            float f5 = f2 / f4;
            float f6 = f3 / f4;
            if (i2 != 0) {
                if (i2 == 1) {
                    this.f2706k = false;
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    if (this.r) {
                        z3 = this.f2705j.onDoubleTapEvent(motionEvent) | false;
                    } else {
                        if (this.m) {
                            this.f2703h.removeMessages(3);
                            this.m = false;
                        } else if (this.n) {
                            boolean onSingleTapUp = this.f2704i.onSingleTapUp(motionEvent);
                            if (this.f2707l) {
                                OnDoubleTapListener onDoubleTapListener = this.f2705j;
                                if (onDoubleTapListener != null) {
                                    onDoubleTapListener.onSingleTapConfirmed(motionEvent);
                                }
                            }
                            z3 = onSingleTapUp;
                        } else {
                            VelocityTracker velocityTracker = this.x;
                            int pointerId = motionEvent.getPointerId(0);
                            velocityTracker.computeCurrentVelocity(1000, (float) this.f2702g);
                            float yVelocity = velocityTracker.getYVelocity(pointerId);
                            float xVelocity = velocityTracker.getXVelocity(pointerId);
                            if (Math.abs(yVelocity) > ((float) this.f2701f) || Math.abs(xVelocity) > ((float) this.f2701f)) {
                                z3 = this.f2704i.onFling(this.p, motionEvent, xVelocity, yVelocity);
                            }
                        }
                        z3 = false;
                    }
                    MotionEvent motionEvent3 = this.q;
                    if (motionEvent3 != null) {
                        motionEvent3.recycle();
                    }
                    this.q = obtain;
                    VelocityTracker velocityTracker2 = this.x;
                    if (velocityTracker2 != null) {
                        velocityTracker2.recycle();
                        this.x = null;
                    }
                    this.r = false;
                    this.f2707l = false;
                    this.f2703h.removeMessages(1);
                    this.f2703h.removeMessages(2);
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        b();
                        return false;
                    } else if (i2 == 5) {
                        this.s = f5;
                        this.u = f5;
                        this.t = f6;
                        this.v = f6;
                        c();
                        return false;
                    } else if (i2 != 6) {
                        return false;
                    } else {
                        this.s = f5;
                        this.u = f5;
                        this.t = f6;
                        this.v = f6;
                        this.x.computeCurrentVelocity(1000, (float) this.f2702g);
                        int actionIndex2 = motionEvent.getActionIndex();
                        int pointerId2 = motionEvent.getPointerId(actionIndex2);
                        float xVelocity2 = this.x.getXVelocity(pointerId2);
                        float yVelocity2 = this.x.getYVelocity(pointerId2);
                        for (int i4 = 0; i4 < pointerCount; i4++) {
                            if (i4 != actionIndex2) {
                                int pointerId3 = motionEvent.getPointerId(i4);
                                if ((this.x.getXVelocity(pointerId3) * xVelocity2) + (this.x.getYVelocity(pointerId3) * yVelocity2) < 0.0f) {
                                    this.x.clear();
                                    return false;
                                }
                            }
                        }
                        return false;
                    }
                } else if (this.m) {
                    return false;
                } else {
                    float f7 = this.s - f5;
                    float f8 = this.t - f6;
                    if (this.r) {
                        return false | this.f2705j.onDoubleTapEvent(motionEvent);
                    }
                    if (this.n) {
                        int i5 = (int) (f5 - this.u);
                        int i6 = (int) (f6 - this.v);
                        int i7 = (i5 * i5) + (i6 * i6);
                        if (i7 > this.f2699d) {
                            z2 = this.f2704i.onScroll(this.p, motionEvent, f7, f8);
                            this.s = f5;
                            this.t = f6;
                            this.n = false;
                            this.f2703h.removeMessages(3);
                            this.f2703h.removeMessages(1);
                            this.f2703h.removeMessages(2);
                        } else {
                            z2 = false;
                        }
                        if (i7 > this.f2699d) {
                            this.o = false;
                        }
                    } else if (Math.abs(f7) < 1.0f && Math.abs(f8) < 1.0f) {
                        return false;
                    } else {
                        boolean onScroll = this.f2704i.onScroll(this.p, motionEvent, f7, f8);
                        this.s = f5;
                        this.t = f6;
                        return onScroll;
                    }
                }
                return z2;
            }
            if (this.f2705j != null) {
                boolean hasMessages = this.f2703h.hasMessages(3);
                if (hasMessages) {
                    this.f2703h.removeMessages(3);
                }
                MotionEvent motionEvent4 = this.p;
                if (motionEvent4 != null) {
                    MotionEvent motionEvent5 = this.q;
                    if (motionEvent5 != null && hasMessages && a(motionEvent4, motionEvent5, motionEvent)) {
                        this.r = true;
                        z = this.f2705j.onDoubleTap(this.p) | false | this.f2705j.onDoubleTapEvent(motionEvent);
                        this.s = f5;
                        this.u = f5;
                        this.t = f6;
                        this.v = f6;
                        motionEvent2 = this.p;
                        if (motionEvent2 != null) {
                            motionEvent2.recycle();
                        }
                        this.p = MotionEvent.obtain(motionEvent);
                        this.n = true;
                        this.o = true;
                        this.f2706k = true;
                        this.m = false;
                        this.f2707l = false;
                        if (this.w) {
                            this.f2703h.removeMessages(2);
                            this.f2703h.sendEmptyMessageAtTime(2, this.p.getDownTime() + ((long) f2697b) + ((long) f2696a));
                        }
                        this.f2703h.sendEmptyMessageAtTime(1, this.p.getDownTime() + ((long) f2697b));
                        return z | this.f2704i.onDown(motionEvent);
                    }
                }
                this.f2703h.sendEmptyMessageDelayed(3, (long) f2698c);
            }
            z = false;
            this.s = f5;
            this.u = f5;
            this.t = f6;
            this.v = f6;
            motionEvent2 = this.p;
            if (motionEvent2 != null) {
            }
            this.p = MotionEvent.obtain(motionEvent);
            this.n = true;
            this.o = true;
            this.f2706k = true;
            this.m = false;
            this.f2707l = false;
            if (this.w) {
            }
            this.f2703h.sendEmptyMessageAtTime(1, this.p.getDownTime() + ((long) f2697b));
            return z | this.f2704i.onDown(motionEvent);
        }

        private boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            boolean z = false;
            if (!this.o || motionEvent3.getEventTime() - motionEvent2.getEventTime() > ((long) f2698c)) {
                return false;
            }
            int x2 = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            if ((x2 * x2) + (y * y) < this.f2700e) {
                z = true;
            }
            return z;
        }

        /* access modifiers changed from: 0000 */
        public void a() {
            this.f2703h.removeMessages(3);
            this.f2707l = false;
            this.m = true;
            this.f2704i.onLongPress(this.p);
        }
    }

    /* renamed from: b.g.i.c$c reason: collision with other inner class name */
    /* compiled from: GestureDetectorCompat */
    static class C0030c implements a {

        /* renamed from: a reason: collision with root package name */
        private final GestureDetector f2709a;

        C0030c(Context context, OnGestureListener onGestureListener, Handler handler) {
            this.f2709a = new GestureDetector(context, onGestureListener, handler);
        }

        public boolean a(MotionEvent motionEvent) {
            return this.f2709a.onTouchEvent(motionEvent);
        }
    }

    public C0242c(Context context, OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public boolean a(MotionEvent motionEvent) {
        return this.f2695a.a(motionEvent);
    }

    public C0242c(Context context, OnGestureListener onGestureListener, Handler handler) {
        if (VERSION.SDK_INT > 17) {
            this.f2695a = new C0030c(context, onGestureListener, handler);
        } else {
            this.f2695a = new b(context, onGestureListener, handler);
        }
    }
}
