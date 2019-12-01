package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import b.a.f;
import b.a.j;
import b.g.i.B;
import java.lang.ref.WeakReference;

class AlertController {
    NestedScrollView A;
    private int B = 0;
    private Drawable C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private View G;
    ListAdapter H;
    int I = -1;
    private int J;
    private int K;
    int L;
    int M;
    int N;
    int O;
    private boolean P;
    private int Q = 0;
    Handler R;
    private final OnClickListener S = new C0137d(this);

    /* renamed from: a reason: collision with root package name */
    private final Context f381a;

    /* renamed from: b reason: collision with root package name */
    final C f382b;

    /* renamed from: c reason: collision with root package name */
    private final Window f383c;

    /* renamed from: d reason: collision with root package name */
    private final int f384d;

    /* renamed from: e reason: collision with root package name */
    private CharSequence f385e;

    /* renamed from: f reason: collision with root package name */
    private CharSequence f386f;

    /* renamed from: g reason: collision with root package name */
    ListView f387g;

    /* renamed from: h reason: collision with root package name */
    private View f388h;

    /* renamed from: i reason: collision with root package name */
    private int f389i;

    /* renamed from: j reason: collision with root package name */
    private int f390j;

    /* renamed from: k reason: collision with root package name */
    private int f391k;

    /* renamed from: l reason: collision with root package name */
    private int f392l;
    private int m;
    private boolean n = false;
    Button o;
    private CharSequence p;
    Message q;
    private Drawable r;
    Button s;
    private CharSequence t;
    Message u;
    private Drawable v;
    Button w;
    private CharSequence x;
    Message y;
    private Drawable z;

    public static class RecycleListView extends ListView {

        /* renamed from: a reason: collision with root package name */
        private final int f393a;

        /* renamed from: b reason: collision with root package name */
        private final int f394b;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public void a(boolean z, boolean z2) {
            if (!z2 || !z) {
                setPadding(getPaddingLeft(), z ? getPaddingTop() : this.f393a, getPaddingRight(), z2 ? getPaddingBottom() : this.f394b);
            }
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.RecycleListView);
            this.f394b = obtainStyledAttributes.getDimensionPixelOffset(j.RecycleListView_paddingBottomNoButtons, -1);
            this.f393a = obtainStyledAttributes.getDimensionPixelOffset(j.RecycleListView_paddingTopNoTitle, -1);
        }
    }

    public static class a {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean E = false;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public int I = -1;
        public OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public boolean N;
        public OnItemSelectedListener O;
        public C0005a P;
        public boolean Q = true;

        /* renamed from: a reason: collision with root package name */
        public final Context f395a;

        /* renamed from: b reason: collision with root package name */
        public final LayoutInflater f396b;

        /* renamed from: c reason: collision with root package name */
        public int f397c = 0;

        /* renamed from: d reason: collision with root package name */
        public Drawable f398d;

        /* renamed from: e reason: collision with root package name */
        public int f399e = 0;

        /* renamed from: f reason: collision with root package name */
        public CharSequence f400f;

        /* renamed from: g reason: collision with root package name */
        public View f401g;

        /* renamed from: h reason: collision with root package name */
        public CharSequence f402h;

        /* renamed from: i reason: collision with root package name */
        public CharSequence f403i;

        /* renamed from: j reason: collision with root package name */
        public Drawable f404j;

        /* renamed from: k reason: collision with root package name */
        public DialogInterface.OnClickListener f405k;

        /* renamed from: l reason: collision with root package name */
        public CharSequence f406l;
        public Drawable m;
        public DialogInterface.OnClickListener n;
        public CharSequence o;
        public Drawable p;
        public DialogInterface.OnClickListener q;
        public boolean r;
        public OnCancelListener s;
        public OnDismissListener t;
        public OnKeyListener u;
        public CharSequence[] v;
        public ListAdapter w;
        public DialogInterface.OnClickListener x;
        public int y;
        public View z;

        /* renamed from: androidx.appcompat.app.AlertController$a$a reason: collision with other inner class name */
        public interface C0005a {
            void a(ListView listView);
        }

        public a(Context context) {
            this.f395a = context;
            this.r = true;
            this.f396b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        /* JADX WARNING: type inference failed for: r9v0, types: [android.widget.ListAdapter] */
        /* JADX WARNING: type inference failed for: r9v1, types: [android.widget.ListAdapter] */
        /* JADX WARNING: type inference failed for: r9v2, types: [androidx.appcompat.app.AlertController$c] */
        /* JADX WARNING: type inference failed for: r2v3, types: [android.widget.SimpleCursorAdapter] */
        /* JADX WARNING: type inference failed for: r1v17, types: [androidx.appcompat.app.j] */
        /* JADX WARNING: type inference failed for: r1v18, types: [androidx.appcompat.app.i] */
        /* JADX WARNING: type inference failed for: r9v6 */
        /* JADX WARNING: type inference failed for: r2v6, types: [android.widget.SimpleCursorAdapter] */
        /* JADX WARNING: type inference failed for: r1v19, types: [androidx.appcompat.app.j] */
        /* JADX WARNING: type inference failed for: r1v20, types: [androidx.appcompat.app.i] */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r9v1, types: [android.widget.ListAdapter]
          assigns: [android.widget.ListAdapter, android.widget.SimpleCursorAdapter, androidx.appcompat.app.j, androidx.appcompat.app.i]
          uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], android.widget.ListAdapter, android.widget.SimpleCursorAdapter, androidx.appcompat.app.j, androidx.appcompat.app.i]
          mth insns count: 68
        	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
        	at jadx.core.ProcessClass.process(ProcessClass.java:30)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
         */
        /* JADX WARNING: Unknown variable types count: 5 */
        private void b(AlertController alertController) {
            ? r9;
            int i2;
            RecycleListView recycleListView = (RecycleListView) this.f396b.inflate(alertController.L, null);
            if (this.G) {
                Cursor cursor = this.K;
                if (cursor == null) {
                    ? iVar = new C0142i(this, this.f395a, alertController.M, 16908308, this.v, recycleListView);
                    r9 = iVar;
                } else {
                    ? jVar = new C0143j(this, this.f395a, cursor, false, recycleListView, alertController);
                    r9 = jVar;
                }
            } else {
                if (this.H) {
                    i2 = alertController.N;
                } else {
                    i2 = alertController.O;
                }
                int i3 = i2;
                Cursor cursor2 = this.K;
                if (cursor2 != null) {
                    ? simpleCursorAdapter = new SimpleCursorAdapter(this.f395a, i3, cursor2, new String[]{this.L}, new int[]{16908308});
                    r9 = simpleCursorAdapter;
                } else {
                    r9 = this.w;
                    if (r9 == 0) {
                        r9 = new c(this.f395a, i3, 16908308, this.v);
                    }
                }
            }
            C0005a aVar = this.P;
            if (aVar != null) {
                aVar.a(recycleListView);
            }
            alertController.H = r9;
            alertController.I = this.I;
            if (this.x != null) {
                recycleListView.setOnItemClickListener(new C0144k(this, alertController));
            } else if (this.J != null) {
                recycleListView.setOnItemClickListener(new C0145l(this, recycleListView, alertController));
            }
            OnItemSelectedListener onItemSelectedListener = this.O;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.H) {
                recycleListView.setChoiceMode(1);
            } else if (this.G) {
                recycleListView.setChoiceMode(2);
            }
            alertController.f387g = recycleListView;
        }

        public void a(AlertController alertController) {
            View view = this.f401g;
            if (view != null) {
                alertController.b(view);
            } else {
                CharSequence charSequence = this.f400f;
                if (charSequence != null) {
                    alertController.b(charSequence);
                }
                Drawable drawable = this.f398d;
                if (drawable != null) {
                    alertController.a(drawable);
                }
                int i2 = this.f397c;
                if (i2 != 0) {
                    alertController.c(i2);
                }
                int i3 = this.f399e;
                if (i3 != 0) {
                    alertController.c(alertController.b(i3));
                }
            }
            CharSequence charSequence2 = this.f402h;
            if (charSequence2 != null) {
                alertController.a(charSequence2);
            }
            if (!(this.f403i == null && this.f404j == null)) {
                alertController.a(-1, this.f403i, this.f405k, (Message) null, this.f404j);
            }
            if (!(this.f406l == null && this.m == null)) {
                alertController.a(-2, this.f406l, this.n, (Message) null, this.m);
            }
            if (!(this.o == null && this.p == null)) {
                alertController.a(-3, this.o, this.q, (Message) null, this.p);
            }
            if (!(this.v == null && this.K == null && this.w == null)) {
                b(alertController);
            }
            View view2 = this.z;
            if (view2 == null) {
                int i4 = this.y;
                if (i4 != 0) {
                    alertController.d(i4);
                }
            } else if (this.E) {
                alertController.a(view2, this.A, this.B, this.C, this.D);
            } else {
                alertController.c(view2);
            }
        }
    }

    private static final class b extends Handler {

        /* renamed from: a reason: collision with root package name */
        private WeakReference<DialogInterface> f407a;

        public b(DialogInterface dialogInterface) {
            this.f407a = new WeakReference<>(dialogInterface);
        }

        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == -3 || i2 == -2 || i2 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f407a.get(), message.what);
            } else if (i2 == 1) {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    private static class c extends ArrayAdapter<CharSequence> {
        public c(Context context, int i2, int i3, CharSequence[] charSequenceArr) {
            super(context, i2, i3, charSequenceArr);
        }

        public long getItemId(int i2) {
            return (long) i2;
        }

        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, C c2, Window window) {
        this.f381a = context;
        this.f382b = c2;
        this.f383c = window;
        this.R = new b(c2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, j.AlertDialog, b.a.a.alertDialogStyle, 0);
        this.J = obtainStyledAttributes.getResourceId(j.AlertDialog_android_layout, 0);
        this.K = obtainStyledAttributes.getResourceId(j.AlertDialog_buttonPanelSideLayout, 0);
        this.L = obtainStyledAttributes.getResourceId(j.AlertDialog_listLayout, 0);
        this.M = obtainStyledAttributes.getResourceId(j.AlertDialog_multiChoiceItemLayout, 0);
        this.N = obtainStyledAttributes.getResourceId(j.AlertDialog_singleChoiceItemLayout, 0);
        this.O = obtainStyledAttributes.getResourceId(j.AlertDialog_listItemLayout, 0);
        this.P = obtainStyledAttributes.getBoolean(j.AlertDialog_showTitle, true);
        this.f384d = obtainStyledAttributes.getDimensionPixelSize(j.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        c2.a(1);
    }

    private static boolean a(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(b.a.a.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            return true;
        }
        return false;
    }

    private int c() {
        int i2 = this.K;
        if (i2 == 0) {
            return this.J;
        }
        if (this.Q == 1) {
            return i2;
        }
        return this.J;
    }

    public void b() {
        this.f382b.setContentView(c());
        d();
    }

    public void d(int i2) {
        this.f388h = null;
        this.f389i = i2;
        this.n = false;
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private void d() {
        View findViewById = this.f383c.findViewById(f.parentPanel);
        View findViewById2 = findViewById.findViewById(f.topPanel);
        View findViewById3 = findViewById.findViewById(f.contentPanel);
        View findViewById4 = findViewById.findViewById(f.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(f.customPanel);
        c(viewGroup);
        View findViewById5 = viewGroup.findViewById(f.topPanel);
        View findViewById6 = viewGroup.findViewById(f.contentPanel);
        View findViewById7 = viewGroup.findViewById(f.buttonPanel);
        ViewGroup a2 = a(findViewById5, findViewById2);
        ViewGroup a3 = a(findViewById6, findViewById3);
        ViewGroup a4 = a(findViewById7, findViewById4);
        b(a3);
        a(a4);
        d(a2);
        char c2 = 0;
        boolean z2 = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z3 = (a2 == null || a2.getVisibility() == 8) ? false : true;
        boolean z4 = (a4 == null || a4.getVisibility() == 8) ? false : true;
        if (!z4 && a3 != null) {
            View findViewById8 = a3.findViewById(f.textSpacerNoButtons);
            if (findViewById8 != null) {
                findViewById8.setVisibility(0);
            }
        }
        if (z3) {
            NestedScrollView nestedScrollView = this.A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View view = null;
            if (!(this.f386f == null && this.f387g == null)) {
                view = a2.findViewById(f.titleDividerNoCustom);
            }
            if (view != null) {
                view.setVisibility(0);
            }
        } else if (a3 != null) {
            View findViewById9 = a3.findViewById(f.textSpacerNoTitle);
            if (findViewById9 != null) {
                findViewById9.setVisibility(0);
            }
        }
        ListView listView = this.f387g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).a(z3, z4);
        }
        if (!z2) {
            View view2 = this.f387g;
            if (view2 == null) {
                view2 = this.A;
            }
            if (view2 != null) {
                if (z4) {
                    c2 = 2;
                }
                a(a3, view2, z3 | c2 ? 1 : 0, 3);
            }
        }
        ListView listView2 = this.f387g;
        if (listView2 != null) {
            ListAdapter listAdapter = this.H;
            if (listAdapter != null) {
                listView2.setAdapter(listAdapter);
                int i2 = this.I;
                if (i2 > -1) {
                    listView2.setItemChecked(i2, true);
                    listView2.setSelection(i2);
                }
            }
        }
    }

    public void b(CharSequence charSequence) {
        this.f385e = charSequence;
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void c(View view) {
        this.f388h = view;
        this.f389i = 0;
        this.n = false;
    }

    public void b(View view) {
        this.G = view;
    }

    public int b(int i2) {
        TypedValue typedValue = new TypedValue();
        this.f381a.getTheme().resolveAttribute(i2, typedValue, true);
        return typedValue.resourceId;
    }

    public void c(int i2) {
        this.C = null;
        this.B = i2;
        ImageView imageView = this.D;
        if (imageView == null) {
            return;
        }
        if (i2 != 0) {
            imageView.setVisibility(0);
            this.D.setImageResource(this.B);
            return;
        }
        imageView.setVisibility(8);
    }

    public void a(CharSequence charSequence) {
        this.f386f = charSequence;
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public boolean b(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.a(keyEvent);
    }

    private void b(ViewGroup viewGroup) {
        this.A = (NestedScrollView) this.f383c.findViewById(f.scrollView);
        this.A.setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        this.F = (TextView) viewGroup.findViewById(16908299);
        TextView textView = this.F;
        if (textView != null) {
            CharSequence charSequence = this.f386f;
            if (charSequence != null) {
                textView.setText(charSequence);
            } else {
                textView.setVisibility(8);
                this.A.removeView(this.F);
                if (this.f387g != null) {
                    ViewGroup viewGroup2 = (ViewGroup) this.A.getParent();
                    int indexOfChild = viewGroup2.indexOfChild(this.A);
                    viewGroup2.removeViewAt(indexOfChild);
                    viewGroup2.addView(this.f387g, indexOfChild, new LayoutParams(-1, -1));
                } else {
                    viewGroup.setVisibility(8);
                }
            }
        }
    }

    public void a(View view, int i2, int i3, int i4, int i5) {
        this.f388h = view;
        this.f389i = 0;
        this.n = true;
        this.f390j = i2;
        this.f391k = i3;
        this.f392l = i4;
        this.m = i5;
    }

    private void c(ViewGroup viewGroup) {
        View view = this.f388h;
        boolean z2 = false;
        if (view == null) {
            view = this.f389i != 0 ? LayoutInflater.from(this.f381a).inflate(this.f389i, viewGroup, false) : null;
        }
        if (view != null) {
            z2 = true;
        }
        if (!z2 || !a(view)) {
            this.f383c.setFlags(131072, 131072);
        }
        if (z2) {
            FrameLayout frameLayout = (FrameLayout) this.f383c.findViewById(f.custom);
            frameLayout.addView(view, new LayoutParams(-1, -1));
            if (this.n) {
                frameLayout.setPadding(this.f390j, this.f391k, this.f392l, this.m);
            }
            if (this.f387g != null) {
                ((androidx.appcompat.widget.O.a) viewGroup.getLayoutParams()).f850a = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    public void a(int i2, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.R.obtainMessage(i2, onClickListener);
        }
        if (i2 == -3) {
            this.x = charSequence;
            this.y = message;
            this.z = drawable;
        } else if (i2 == -2) {
            this.t = charSequence;
            this.u = message;
            this.v = drawable;
        } else if (i2 == -1) {
            this.p = charSequence;
            this.q = message;
            this.r = drawable;
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void a(Drawable drawable) {
        this.C = drawable;
        this.B = 0;
        ImageView imageView = this.D;
        if (imageView == null) {
            return;
        }
        if (drawable != null) {
            imageView.setVisibility(0);
            this.D.setImageDrawable(drawable);
            return;
        }
        imageView.setVisibility(8);
    }

    public ListView a() {
        return this.f387g;
    }

    public Button a(int i2) {
        if (i2 == -3) {
            return this.w;
        }
        if (i2 == -2) {
            return this.s;
        }
        if (i2 != -1) {
            return null;
        }
        return this.o;
    }

    private void d(ViewGroup viewGroup) {
        if (this.G != null) {
            viewGroup.addView(this.G, 0, new LayoutParams(-1, -2));
            this.f383c.findViewById(f.title_template).setVisibility(8);
            return;
        }
        this.D = (ImageView) this.f383c.findViewById(16908294);
        if (!(!TextUtils.isEmpty(this.f385e)) || !this.P) {
            this.f383c.findViewById(f.title_template).setVisibility(8);
            this.D.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        this.E = (TextView) this.f383c.findViewById(f.alertTitle);
        this.E.setText(this.f385e);
        int i2 = this.B;
        if (i2 != 0) {
            this.D.setImageResource(i2);
            return;
        }
        Drawable drawable = this.C;
        if (drawable != null) {
            this.D.setImageDrawable(drawable);
            return;
        }
        this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
        this.D.setVisibility(8);
    }

    public boolean a(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.a(keyEvent);
    }

    private ViewGroup a(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private void a(ViewGroup viewGroup, View view, int i2, int i3) {
        View findViewById = this.f383c.findViewById(f.scrollIndicatorUp);
        View findViewById2 = this.f383c.findViewById(f.scrollIndicatorDown);
        if (VERSION.SDK_INT >= 23) {
            B.a(view, i2, i3);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        View view2 = null;
        if (findViewById != null && (i2 & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 == null || (i2 & 2) != 0) {
            view2 = findViewById2;
        } else {
            viewGroup.removeView(findViewById2);
        }
        if (findViewById != null || view2 != null) {
            if (this.f386f != null) {
                this.A.setOnScrollChangeListener(new C0138e(this, findViewById, view2));
                this.A.post(new C0139f(this, findViewById, view2));
                return;
            }
            ListView listView = this.f387g;
            if (listView != null) {
                listView.setOnScrollListener(new C0140g(this, findViewById, view2));
                this.f387g.post(new C0141h(this, findViewById, view2));
                return;
            }
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (view2 != null) {
                viewGroup.removeView(view2);
            }
        }
    }

    static void a(View view, View view2, View view3) {
        int i2 = 0;
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!view.canScrollVertically(1)) {
                i2 = 4;
            }
            view3.setVisibility(i2);
        }
    }

    private void a(ViewGroup viewGroup) {
        boolean z2;
        this.o = (Button) viewGroup.findViewById(16908313);
        this.o.setOnClickListener(this.S);
        boolean z3 = true;
        if (!TextUtils.isEmpty(this.p) || this.r != null) {
            this.o.setText(this.p);
            Drawable drawable = this.r;
            if (drawable != null) {
                int i2 = this.f384d;
                drawable.setBounds(0, 0, i2, i2);
                this.o.setCompoundDrawables(this.r, null, null, null);
            }
            this.o.setVisibility(0);
            z2 = true;
        } else {
            this.o.setVisibility(8);
            z2 = false;
        }
        this.s = (Button) viewGroup.findViewById(16908314);
        this.s.setOnClickListener(this.S);
        if (!TextUtils.isEmpty(this.t) || this.v != null) {
            this.s.setText(this.t);
            Drawable drawable2 = this.v;
            if (drawable2 != null) {
                int i3 = this.f384d;
                drawable2.setBounds(0, 0, i3, i3);
                this.s.setCompoundDrawables(this.v, null, null, null);
            }
            this.s.setVisibility(0);
            z2 |= true;
        } else {
            this.s.setVisibility(8);
        }
        this.w = (Button) viewGroup.findViewById(16908315);
        this.w.setOnClickListener(this.S);
        if (!TextUtils.isEmpty(this.x) || this.z != null) {
            this.w.setText(this.x);
            Drawable drawable3 = this.r;
            if (drawable3 != null) {
                int i4 = this.f384d;
                drawable3.setBounds(0, 0, i4, i4);
                this.o.setCompoundDrawables(this.r, null, null, null);
            }
            this.w.setVisibility(0);
            z2 |= true;
        } else {
            this.w.setVisibility(8);
        }
        if (a(this.f381a)) {
            if (z2) {
                a(this.o);
            } else if (z2) {
                a(this.s);
            } else if (z2) {
                a(this.w);
            }
        }
        if (!z2) {
            z3 = false;
        }
        if (!z3) {
            viewGroup.setVisibility(8);
        }
    }

    private void a(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }
}
