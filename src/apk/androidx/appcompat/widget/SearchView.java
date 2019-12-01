package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView.OnEditorActionListener;
import b.a.g;
import b.a.h;
import b.a.j;
import b.g.i.B;
import com.appsflyer.share.Constants;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView extends O implements b.a.d.c {
    static final a p = new a();
    private Rect A;
    private Rect B;
    private int[] C;
    private int[] D;
    private final ImageView E;
    private final Drawable F;
    private final int G;
    private final int H;
    private final Intent I;
    private final Intent J;
    private final CharSequence K;
    private c L;
    private b M;
    OnFocusChangeListener N;
    private d O;
    private OnClickListener P;
    private boolean Q;
    private boolean R;
    b.h.a.a S;
    private boolean T;
    private CharSequence U;
    private boolean V;
    private boolean W;
    private int aa;
    private boolean ba;
    private CharSequence ca;
    private CharSequence da;
    private boolean ea;
    private int fa;
    SearchableInfo ga;
    private Bundle ha;
    private final Runnable ia;
    private Runnable ja;
    private final WeakHashMap<String, ConstantState> ka;
    private final OnClickListener la;
    OnKeyListener ma;
    private final OnEditorActionListener na;
    private final OnItemClickListener oa;
    private final OnItemSelectedListener pa;
    final SearchAutoComplete q;
    private TextWatcher qa;
    private final View r;
    private final View s;
    private final View t;
    final ImageView u;
    final ImageView v;
    final ImageView w;
    final ImageView x;
    private final View y;
    private f z;

    public static class SearchAutoComplete extends C0169i {

        /* renamed from: d reason: collision with root package name */
        private int f871d;

        /* renamed from: e reason: collision with root package name */
        private SearchView f872e;

        /* renamed from: f reason: collision with root package name */
        private boolean f873f;

        /* renamed from: g reason: collision with root package name */
        final Runnable f874g;

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i2 = configuration.screenWidthDp;
            int i3 = configuration.screenHeightDp;
            if (i2 < 960 || i3 < 720 || configuration.orientation != 2) {
                return (i2 >= 600 || (i2 >= 640 && i3 >= 480)) ? 192 : 160;
            }
            return 256;
        }

        /* access modifiers changed from: 0000 */
        public boolean a() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        /* access modifiers changed from: 0000 */
        public void b() {
            if (this.f873f) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f873f = false;
            }
        }

        public boolean enoughToFilter() {
            return this.f871d <= 0 || super.enoughToFilter();
        }

        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f873f) {
                removeCallbacks(this.f874g);
                post(this.f874g);
            }
            return onCreateInputConnection;
        }

        /* access modifiers changed from: protected */
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, (float) getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        /* access modifiers changed from: protected */
        public void onFocusChanged(boolean z, int i2, Rect rect) {
            super.onFocusChanged(z, i2, rect);
            this.f872e.h();
        }

        public boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
            if (i2 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f872e.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i2, keyEvent);
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f872e.hasFocus() && getVisibility() == 0) {
                this.f873f = true;
                if (SearchView.a(getContext())) {
                    SearchView.p.a(this, true);
                }
            }
        }

        public void performCompletion() {
        }

        /* access modifiers changed from: protected */
        public void replaceText(CharSequence charSequence) {
        }

        /* access modifiers changed from: 0000 */
        public void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.f873f = false;
                removeCallbacks(this.f874g);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.f873f = false;
                removeCallbacks(this.f874g);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.f873f = true;
            }
        }

        /* access modifiers changed from: 0000 */
        public void setSearchView(SearchView searchView) {
            this.f872e = searchView;
        }

        public void setThreshold(int i2) {
            super.setThreshold(i2);
            this.f871d = i2;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, b.a.a.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            this.f874g = new ka(this);
            this.f871d = getThreshold();
        }
    }

    private static class a {

        /* renamed from: a reason: collision with root package name */
        private Method f875a;

        /* renamed from: b reason: collision with root package name */
        private Method f876b;

        /* renamed from: c reason: collision with root package name */
        private Method f877c;

        a() {
            try {
                this.f875a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f875a.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                this.f876b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f876b.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                this.f877c = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.f877c.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        /* access modifiers changed from: 0000 */
        public void a(AutoCompleteTextView autoCompleteTextView) {
            Method method = this.f876b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void b(AutoCompleteTextView autoCompleteTextView) {
            Method method = this.f875a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void a(AutoCompleteTextView autoCompleteTextView, boolean z) {
            Method method = this.f877c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[]{Boolean.valueOf(z)});
                } catch (Exception unused) {
                }
            }
        }
    }

    public interface b {
        boolean onClose();
    }

    public interface c {
        boolean onQueryTextChange(String str);

        boolean onQueryTextSubmit(String str);
    }

    public interface d {
        boolean onSuggestionClick(int i2);

        boolean onSuggestionSelect(int i2);
    }

    static class e extends b.i.a.c {
        public static final Creator<e> CREATOR = new ja();

        /* renamed from: c reason: collision with root package name */
        boolean f878c;

        e(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SearchView.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" isIconified=");
            sb.append(this.f878c);
            sb.append("}");
            return sb.toString();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeValue(Boolean.valueOf(this.f878c));
        }

        public e(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f878c = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    private static class f extends TouchDelegate {

        /* renamed from: a reason: collision with root package name */
        private final View f879a;

        /* renamed from: b reason: collision with root package name */
        private final Rect f880b = new Rect();

        /* renamed from: c reason: collision with root package name */
        private final Rect f881c = new Rect();

        /* renamed from: d reason: collision with root package name */
        private final Rect f882d = new Rect();

        /* renamed from: e reason: collision with root package name */
        private final int f883e;

        /* renamed from: f reason: collision with root package name */
        private boolean f884f;

        public f(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f883e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            a(rect, rect2);
            this.f879a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f880b.set(rect);
            this.f882d.set(rect);
            Rect rect3 = this.f882d;
            int i2 = this.f883e;
            rect3.inset(-i2, -i2);
            this.f881c.set(rect2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x003d  */
        /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z2 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z = this.f884f;
                    if (z && !this.f882d.contains(x, y)) {
                        z2 = false;
                    }
                    if (z) {
                        return false;
                    }
                    if (!z2 || this.f881c.contains(x, y)) {
                        Rect rect = this.f881c;
                        motionEvent.setLocation((float) (x - rect.left), (float) (y - rect.top));
                    } else {
                        motionEvent.setLocation((float) (this.f879a.getWidth() / 2), (float) (this.f879a.getHeight() / 2));
                    }
                    return this.f879a.dispatchTouchEvent(motionEvent);
                } else if (action == 3) {
                    z = this.f884f;
                    this.f884f = false;
                    if (z) {
                    }
                }
            } else if (this.f880b.contains(x, y)) {
                this.f884f = true;
                z = true;
                if (z) {
                }
            }
            z = false;
            if (z) {
            }
        }
    }

    public SearchView(Context context) {
        this(context, null);
    }

    private void b(boolean z2) {
        this.R = z2;
        int i2 = 8;
        boolean z3 = false;
        boolean z4 = !TextUtils.isEmpty(this.q.getText());
        this.u.setVisibility(z2 ? 0 : 8);
        a(z4);
        this.r.setVisibility(z2 ? 8 : 0);
        if (this.E.getDrawable() != null && !this.Q) {
            i2 = 0;
        }
        this.E.setVisibility(i2);
        o();
        if (!z4) {
            z3 = true;
        }
        c(z3);
        r();
    }

    private CharSequence c(CharSequence charSequence) {
        if (!this.Q || this.F == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.q.getTextSize()) * 1.25d);
        this.F.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.F), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(b.a.d.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(b.a.d.abc_search_view_preferred_width);
    }

    private void k() {
        this.q.dismissDropDown();
    }

    private boolean l() {
        SearchableInfo searchableInfo = this.ga;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.ga.getVoiceSearchLaunchWebSearch()) {
            intent = this.I;
        } else if (this.ga.getVoiceSearchLaunchRecognizer()) {
            intent = this.J;
        }
        if (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) {
            return false;
        }
        return true;
    }

    private boolean m() {
        return (this.T || this.ba) && !d();
    }

    private void n() {
        post(this.ia);
    }

    private void o() {
        boolean z2 = true;
        boolean z3 = !TextUtils.isEmpty(this.q.getText());
        int i2 = 0;
        if (!z3 && (!this.Q || this.ea)) {
            z2 = false;
        }
        ImageView imageView = this.w;
        if (!z2) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        Drawable drawable = this.w.getDrawable();
        if (drawable != null) {
            drawable.setState(z3 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    private void p() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.q;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(c(queryHint));
    }

    private void q() {
        this.q.setThreshold(this.ga.getSuggestThreshold());
        this.q.setImeOptions(this.ga.getImeOptions());
        int inputType = this.ga.getInputType();
        int i2 = 1;
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.ga.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.q.setInputType(inputType);
        b.h.a.a aVar = this.S;
        if (aVar != null) {
            aVar.a(null);
        }
        if (this.ga.getSuggestAuthority() != null) {
            this.S = new la(getContext(), this, this.ga, this.ka);
            this.q.setAdapter(this.S);
            la laVar = (la) this.S;
            if (this.V) {
                i2 = 2;
            }
            laVar.a(i2);
        }
    }

    private void r() {
        this.t.setVisibility((!m() || !(this.v.getVisibility() == 0 || this.x.getVisibility() == 0)) ? 8 : 0);
    }

    private void setQuery(CharSequence charSequence) {
        this.q.setText(charSequence);
        this.q.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    public void a(CharSequence charSequence, boolean z2) {
        this.q.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.q;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.da = charSequence;
        }
        if (z2 && !TextUtils.isEmpty(charSequence)) {
            g();
        }
    }

    public void clearFocus() {
        this.W = true;
        super.clearFocus();
        this.q.clearFocus();
        this.q.setImeVisibility(false);
        this.W = false;
    }

    public boolean d() {
        return this.R;
    }

    /* access modifiers changed from: 0000 */
    public void e() {
        if (!TextUtils.isEmpty(this.q.getText())) {
            this.q.setText("");
            this.q.requestFocus();
            this.q.setImeVisibility(true);
        } else if (this.Q) {
            b bVar = this.M;
            if (bVar == null || !bVar.onClose()) {
                clearFocus();
                b(true);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void f() {
        b(false);
        this.q.requestFocus();
        this.q.setImeVisibility(true);
        OnClickListener onClickListener = this.P;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    /* access modifiers changed from: 0000 */
    public void g() {
        Editable text = this.q.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            c cVar = this.L;
            if (cVar == null || !cVar.onQueryTextSubmit(text.toString())) {
                if (this.ga != null) {
                    a(0, (String) null, text.toString());
                }
                this.q.setImeVisibility(false);
                k();
            }
        }
    }

    public int getImeOptions() {
        return this.q.getImeOptions();
    }

    public int getInputType() {
        return this.q.getInputType();
    }

    public int getMaxWidth() {
        return this.aa;
    }

    public CharSequence getQuery() {
        return this.q.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.U;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.ga;
        if (searchableInfo == null || searchableInfo.getHintId() == 0) {
            return this.K;
        }
        return getContext().getText(this.ga.getHintId());
    }

    /* access modifiers changed from: 0000 */
    public int getSuggestionCommitIconResId() {
        return this.H;
    }

    /* access modifiers changed from: 0000 */
    public int getSuggestionRowLayout() {
        return this.G;
    }

    public b.h.a.a getSuggestionsAdapter() {
        return this.S;
    }

    /* access modifiers changed from: 0000 */
    public void h() {
        b(d());
        n();
        if (this.q.hasFocus()) {
            c();
        }
    }

    /* access modifiers changed from: 0000 */
    public void i() {
        SearchableInfo searchableInfo = this.ga;
        if (searchableInfo != null) {
            try {
                if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                    getContext().startActivity(b(this.I, searchableInfo));
                } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    getContext().startActivity(a(this.J, searchableInfo));
                }
            } catch (ActivityNotFoundException unused) {
                Log.w("SearchView", "Could not find voice search activity");
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void j() {
        int[] iArr = this.q.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.s.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.t.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public void onActionViewCollapsed() {
        a((CharSequence) "", false);
        clearFocus();
        b(true);
        this.q.setImeOptions(this.fa);
        this.ea = false;
    }

    public void onActionViewExpanded() {
        if (!this.ea) {
            this.ea = true;
            this.fa = this.q.getImeOptions();
            this.q.setImeOptions(this.fa | 33554432);
            this.q.setText("");
            setIconified(false);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.ia);
        post(this.ja);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        if (z2) {
            a((View) this.q, this.A);
            Rect rect = this.B;
            Rect rect2 = this.A;
            rect.set(rect2.left, 0, rect2.right, i5 - i3);
            f fVar = this.z;
            if (fVar == null) {
                this.z = new f(this.B, this.A, this.q);
                setTouchDelegate(this.z);
                return;
            }
            fVar.a(this.B, this.A);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (d()) {
            super.onMeasure(i2, i3);
            return;
        }
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            int i4 = this.aa;
            size = i4 > 0 ? Math.min(i4, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.aa;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824) {
            int i5 = this.aa;
            if (i5 > 0) {
                size = Math.min(i5, size);
            }
        }
        int mode2 = MeasureSpec.getMode(i3);
        int size2 = MeasureSpec.getSize(i3);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof e)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(eVar.n());
        b(eVar.f878c);
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        e eVar = new e(super.onSaveInstanceState());
        eVar.f878c = d();
        return eVar;
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        n();
    }

    public boolean requestFocus(int i2, Rect rect) {
        if (this.W || !isFocusable()) {
            return false;
        }
        if (d()) {
            return super.requestFocus(i2, rect);
        }
        boolean requestFocus = this.q.requestFocus(i2, rect);
        if (requestFocus) {
            b(false);
        }
        return requestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.ha = bundle;
    }

    public void setIconified(boolean z2) {
        if (z2) {
            e();
        } else {
            f();
        }
    }

    public void setIconifiedByDefault(boolean z2) {
        if (this.Q != z2) {
            this.Q = z2;
            b(z2);
            p();
        }
    }

    public void setImeOptions(int i2) {
        this.q.setImeOptions(i2);
    }

    public void setInputType(int i2) {
        this.q.setInputType(i2);
    }

    public void setMaxWidth(int i2) {
        this.aa = i2;
        requestLayout();
    }

    public void setOnCloseListener(b bVar) {
        this.M = bVar;
    }

    public void setOnQueryTextFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.N = onFocusChangeListener;
    }

    public void setOnQueryTextListener(c cVar) {
        this.L = cVar;
    }

    public void setOnSearchClickListener(OnClickListener onClickListener) {
        this.P = onClickListener;
    }

    public void setOnSuggestionListener(d dVar) {
        this.O = dVar;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.U = charSequence;
        p();
    }

    public void setQueryRefinementEnabled(boolean z2) {
        this.V = z2;
        b.h.a.a aVar = this.S;
        if (aVar instanceof la) {
            ((la) aVar).a(z2 ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.ga = searchableInfo;
        if (this.ga != null) {
            q();
            p();
        }
        this.ba = l();
        if (this.ba) {
            this.q.setPrivateImeOptions("nm");
        }
        b(d());
    }

    public void setSubmitButtonEnabled(boolean z2) {
        this.T = z2;
        b(d());
    }

    public void setSuggestionsAdapter(b.h.a.a aVar) {
        this.S = aVar;
        this.q.setAdapter(this.S);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.a.a.searchViewStyle);
    }

    /* access modifiers changed from: 0000 */
    public boolean d(int i2) {
        d dVar = this.O;
        if (dVar != null && dVar.onSuggestionSelect(i2)) {
            return false;
        }
        e(i2);
        return true;
    }

    public SearchView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.A = new Rect();
        this.B = new Rect();
        this.C = new int[2];
        this.D = new int[2];
        this.ia = new C0154aa(this);
        this.ja = new C0156ba(this);
        this.ka = new WeakHashMap<>();
        this.la = new C0162ea(this);
        this.ma = new C0164fa(this);
        this.na = new C0166ga(this);
        this.oa = new C0168ha(this);
        this.pa = new ia(this);
        this.qa = new Z(this);
        sa a2 = sa.a(context, attributeSet, j.SearchView, i2, 0);
        LayoutInflater.from(context).inflate(a2.g(j.SearchView_layout, g.abc_search_view), this, true);
        this.q = (SearchAutoComplete) findViewById(b.a.f.search_src_text);
        this.q.setSearchView(this);
        this.r = findViewById(b.a.f.search_edit_frame);
        this.s = findViewById(b.a.f.search_plate);
        this.t = findViewById(b.a.f.submit_area);
        this.u = (ImageView) findViewById(b.a.f.search_button);
        this.v = (ImageView) findViewById(b.a.f.search_go_btn);
        this.w = (ImageView) findViewById(b.a.f.search_close_btn);
        this.x = (ImageView) findViewById(b.a.f.search_voice_btn);
        this.E = (ImageView) findViewById(b.a.f.search_mag_icon);
        B.a(this.s, a2.b(j.SearchView_queryBackground));
        B.a(this.t, a2.b(j.SearchView_submitBackground));
        this.u.setImageDrawable(a2.b(j.SearchView_searchIcon));
        this.v.setImageDrawable(a2.b(j.SearchView_goIcon));
        this.w.setImageDrawable(a2.b(j.SearchView_closeIcon));
        this.x.setImageDrawable(a2.b(j.SearchView_voiceIcon));
        this.E.setImageDrawable(a2.b(j.SearchView_searchIcon));
        this.F = a2.b(j.SearchView_searchHintIcon);
        Aa.a(this.u, getResources().getString(h.abc_searchview_description_search));
        this.G = a2.g(j.SearchView_suggestionRowLayout, g.abc_search_dropdown_item_icons_2line);
        this.H = a2.g(j.SearchView_commitIcon, 0);
        this.u.setOnClickListener(this.la);
        this.w.setOnClickListener(this.la);
        this.v.setOnClickListener(this.la);
        this.x.setOnClickListener(this.la);
        this.q.setOnClickListener(this.la);
        this.q.addTextChangedListener(this.qa);
        this.q.setOnEditorActionListener(this.na);
        this.q.setOnItemClickListener(this.oa);
        this.q.setOnItemSelectedListener(this.pa);
        this.q.setOnKeyListener(this.ma);
        this.q.setOnFocusChangeListener(new C0158ca(this));
        setIconifiedByDefault(a2.a(j.SearchView_iconifiedByDefault, true));
        int c2 = a2.c(j.SearchView_android_maxWidth, -1);
        if (c2 != -1) {
            setMaxWidth(c2);
        }
        this.K = a2.e(j.SearchView_defaultQueryHint);
        this.U = a2.e(j.SearchView_queryHint);
        int d2 = a2.d(j.SearchView_android_imeOptions, -1);
        if (d2 != -1) {
            setImeOptions(d2);
        }
        int d3 = a2.d(j.SearchView_android_inputType, -1);
        if (d3 != -1) {
            setInputType(d3);
        }
        setFocusable(a2.a(j.SearchView_android_focusable, true));
        a2.a();
        this.I = new Intent("android.speech.action.WEB_SEARCH");
        this.I.addFlags(268435456);
        this.I.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        this.J = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.J.addFlags(268435456);
        this.y = findViewById(this.q.getDropDownAnchor());
        View view = this.y;
        if (view != null) {
            view.addOnLayoutChangeListener(new C0160da(this));
        }
        b(this.Q);
        p();
    }

    private void a(View view, Rect rect) {
        view.getLocationInWindow(this.C);
        getLocationInWindow(this.D);
        int[] iArr = this.C;
        int i2 = iArr[1];
        int[] iArr2 = this.D;
        int i3 = i2 - iArr2[1];
        int i4 = iArr[0] - iArr2[0];
        rect.set(i4, i3, view.getWidth() + i4, view.getHeight() + i3);
    }

    private void c(boolean z2) {
        int i2;
        if (!this.ba || d() || !z2) {
            i2 = 8;
        } else {
            i2 = 0;
            this.v.setVisibility(8);
        }
        this.x.setVisibility(i2);
    }

    private void e(int i2) {
        Editable text = this.q.getText();
        Cursor a2 = this.S.a();
        if (a2 != null) {
            if (a2.moveToPosition(i2)) {
                CharSequence convertToString = this.S.convertToString(a2);
                if (convertToString != null) {
                    setQuery(convertToString);
                } else {
                    setQuery(text);
                }
            } else {
                setQuery(text);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void c() {
        p.b(this.q);
        p.a(this.q);
    }

    private void a(boolean z2) {
        this.v.setVisibility((!this.T || !m() || !hasFocus() || (!z2 && this.ba)) ? 8 : 0);
    }

    /* access modifiers changed from: 0000 */
    public void b(CharSequence charSequence) {
        Editable text = this.q.getText();
        this.da = text;
        boolean z2 = true;
        boolean z3 = !TextUtils.isEmpty(text);
        a(z3);
        if (z3) {
            z2 = false;
        }
        c(z2);
        o();
        r();
        if (this.L != null && !TextUtils.equals(charSequence, this.ca)) {
            this.L.onQueryTextChange(charSequence.toString());
        }
        this.ca = charSequence.toString();
    }

    /* access modifiers changed from: 0000 */
    public void a(CharSequence charSequence) {
        setQuery(charSequence);
    }

    /* access modifiers changed from: 0000 */
    public boolean a(View view, int i2, KeyEvent keyEvent) {
        int i3;
        if (this.ga != null && this.S != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i2 == 66 || i2 == 84 || i2 == 61) {
                return a(this.q.getListSelection(), 0, (String) null);
            }
            if (i2 == 21 || i2 == 22) {
                if (i2 == 21) {
                    i3 = 0;
                } else {
                    i3 = this.q.length();
                }
                this.q.setSelection(i3);
                this.q.setListSelection(0);
                this.q.clearListSelection();
                p.a(this.q, true);
                return true;
            } else if (i2 != 19 || this.q.getListSelection() == 0) {
                return false;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public void b() {
        int i2;
        if (this.y.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.s.getPaddingLeft();
            Rect rect = new Rect();
            boolean a2 = Ga.a(this);
            int dimensionPixelSize = this.Q ? resources.getDimensionPixelSize(b.a.d.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(b.a.d.abc_dropdownitem_text_padding_left) : 0;
            this.q.getDropDownBackground().getPadding(rect);
            if (a2) {
                i2 = -rect.left;
            } else {
                i2 = paddingLeft - (rect.left + dimensionPixelSize);
            }
            this.q.setDropDownHorizontalOffset(i2);
            this.q.setDropDownWidth((((this.y.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean a(int i2, int i3, String str) {
        d dVar = this.O;
        if (dVar != null && dVar.onSuggestionClick(i2)) {
            return false;
        }
        b(i2, 0, null);
        this.q.setImeVisibility(false);
        k();
        return true;
    }

    private void a(Intent intent) {
        if (intent != null) {
            try {
                getContext().startActivity(intent);
            } catch (RuntimeException e2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed launch activity: ");
                sb.append(intent);
                Log.e("SearchView", sb.toString(), e2);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(int i2, String str, String str2) {
        getContext().startActivity(a("android.intent.action.SEARCH", null, null, str2, i2, str));
    }

    private Intent a(String str, Uri uri, String str2, String str3, int i2, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.da);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.ha;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i2 != 0) {
            intent.putExtra("action_key", i2);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.ga.getSearchActivity());
        return intent;
    }

    private boolean b(int i2, int i3, String str) {
        Cursor a2 = this.S.a();
        if (a2 == null || !a2.moveToPosition(i2)) {
            return false;
        }
        a(a(a2, i3, str));
        return true;
    }

    private Intent b(Intent intent, SearchableInfo searchableInfo) {
        String str;
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        if (searchActivity == null) {
            str = null;
        } else {
            str = searchActivity.flattenToShortString();
        }
        intent2.putExtra("calling_package", str);
        return intent2;
    }

    private Intent a(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.ha;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        int i2 = 1;
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String str = null;
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        if (searchableInfo.getVoiceMaxResults() != 0) {
            i2 = searchableInfo.getVoiceMaxResults();
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", i2);
        if (searchActivity != null) {
            str = searchActivity.flattenToShortString();
        }
        intent3.putExtra("calling_package", str);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private Intent a(Cursor cursor, int i2, String str) {
        int i3;
        Uri uri;
        try {
            String a2 = la.a(cursor, "suggest_intent_action");
            if (a2 == null) {
                a2 = this.ga.getSuggestIntentAction();
            }
            if (a2 == null) {
                a2 = "android.intent.action.SEARCH";
            }
            String str2 = a2;
            String a3 = la.a(cursor, "suggest_intent_data");
            if (a3 == null) {
                a3 = this.ga.getSuggestIntentData();
            }
            if (a3 != null) {
                String a4 = la.a(cursor, "suggest_intent_data_id");
                if (a4 != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(a3);
                    sb.append(Constants.URL_PATH_DELIMITER);
                    sb.append(Uri.encode(a4));
                    a3 = sb.toString();
                }
            }
            if (a3 == null) {
                uri = null;
            } else {
                uri = Uri.parse(a3);
            }
            String a5 = la.a(cursor, "suggest_intent_query");
            return a(str2, uri, la.a(cursor, "suggest_intent_extra_data"), a5, i2, str);
        } catch (RuntimeException e2) {
            try {
                i3 = cursor.getPosition();
            } catch (RuntimeException unused) {
                i3 = -1;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Search suggestions cursor at row ");
            sb2.append(i3);
            sb2.append(" returned exception.");
            Log.w("SearchView", sb2.toString(), e2);
            return null;
        }
    }

    static boolean a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }
}
