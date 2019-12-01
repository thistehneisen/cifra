package androidx.appcompat.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import b.a.f;
import b.h.a.c;
import com.appsflyer.share.Constants;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* compiled from: SuggestionsAdapter */
class la extends c implements OnClickListener {

    /* renamed from: l reason: collision with root package name */
    private final SearchManager f988l = ((SearchManager) this.f2731d.getSystemService("search"));
    private final SearchView m;
    private final SearchableInfo n;
    private final Context o;
    private final WeakHashMap<String, ConstantState> p;
    private final int q;
    private boolean r = false;
    private int s = 1;
    private ColorStateList t;
    private int u = -1;
    private int v = -1;
    private int w = -1;
    private int x = -1;
    private int y = -1;
    private int z = -1;

    /* compiled from: SuggestionsAdapter */
    private static final class a {

        /* renamed from: a reason: collision with root package name */
        public final TextView f989a;

        /* renamed from: b reason: collision with root package name */
        public final TextView f990b;

        /* renamed from: c reason: collision with root package name */
        public final ImageView f991c;

        /* renamed from: d reason: collision with root package name */
        public final ImageView f992d;

        /* renamed from: e reason: collision with root package name */
        public final ImageView f993e;

        public a(View view) {
            this.f989a = (TextView) view.findViewById(16908308);
            this.f990b = (TextView) view.findViewById(16908309);
            this.f991c = (ImageView) view.findViewById(16908295);
            this.f992d = (ImageView) view.findViewById(16908296);
            this.f993e = (ImageView) view.findViewById(f.edit_query);
        }
    }

    public la(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.m = searchView;
        this.n = searchableInfo;
        this.q = searchView.getSuggestionCommitIconResId();
        this.o = context;
        this.p = weakHashMap;
    }

    private Drawable c(Cursor cursor) {
        Drawable b2 = b(this.n.getSearchActivity());
        if (b2 != null) {
            return b2;
        }
        return this.f2731d.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable d(Cursor cursor) {
        int i2 = this.x;
        if (i2 == -1) {
            return null;
        }
        Drawable b2 = b(cursor.getString(i2));
        if (b2 != null) {
            return b2;
        }
        return c(cursor);
    }

    private Drawable e(Cursor cursor) {
        int i2 = this.y;
        if (i2 == -1) {
            return null;
        }
        return b(cursor.getString(i2));
    }

    private void f(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    public void a(int i2) {
        this.s = i2;
    }

    public View b(Context context, Cursor cursor, ViewGroup viewGroup) {
        View b2 = super.b(context, cursor, viewGroup);
        b2.setTag(new a(b2));
        ((ImageView) b2.findViewById(f.edit_query)).setImageResource(this.q);
        return b2;
    }

    public CharSequence convertToString(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        String a2 = a(cursor, "suggest_intent_query");
        if (a2 != null) {
            return a2;
        }
        if (this.n.shouldRewriteQueryFromData()) {
            String a3 = a(cursor, "suggest_intent_data");
            if (a3 != null) {
                return a3;
            }
        }
        if (this.n.shouldRewriteQueryFromText()) {
            String a4 = a(cursor, "suggest_text_1");
            if (a4 != null) {
                return a4;
            }
        }
        return null;
    }

    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i2, view, viewGroup);
        } catch (RuntimeException e2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e2);
            View a2 = a(this.f2731d, this.f2730c, viewGroup);
            if (a2 != null) {
                ((a) a2.getTag()).f989a.setText(e2.toString());
            }
            return a2;
        }
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i2, view, viewGroup);
        } catch (RuntimeException e2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e2);
            View b2 = b(this.f2731d, this.f2730c, viewGroup);
            if (b2 != null) {
                ((a) b2.getTag()).f989a.setText(e2.toString());
            }
            return b2;
        }
    }

    public boolean hasStableIds() {
        return false;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        f(a());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        f(a());
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.m.a((CharSequence) tag);
        }
    }

    public Cursor a(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.m.getVisibility() == 0 && this.m.getWindowVisibility() == 0) {
            try {
                Cursor a2 = a(this.n, charSequence2, 50);
                if (a2 != null) {
                    a2.getCount();
                    return a2;
                }
            } catch (RuntimeException e2) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e2);
            }
        }
        return null;
    }

    private CharSequence b(CharSequence charSequence) {
        if (this.t == null) {
            TypedValue typedValue = new TypedValue();
            this.f2731d.getTheme().resolveAttribute(b.a.a.textColorSearchUrl, typedValue, true);
            this.t = this.f2731d.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        TextAppearanceSpan textAppearanceSpan = new TextAppearanceSpan(null, 0, 0, this.t, null);
        spannableString.setSpan(textAppearanceSpan, 0, charSequence.length(), 33);
        return spannableString;
    }

    public void a(Cursor cursor) {
        String str = "SuggestionsAdapter";
        if (this.r) {
            Log.w(str, "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
            }
            return;
        }
        try {
            super.a(cursor);
            if (cursor != null) {
                this.u = cursor.getColumnIndex("suggest_text_1");
                this.v = cursor.getColumnIndex("suggest_text_2");
                this.w = cursor.getColumnIndex("suggest_text_2_url");
                this.x = cursor.getColumnIndex("suggest_icon_1");
                this.y = cursor.getColumnIndex("suggest_icon_2");
                this.z = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e2) {
            Log.e(str, "error changing cursor and caching columns", e2);
        }
    }

    private Drawable b(String str) {
        Drawable drawable = null;
        if (str != null && !str.isEmpty() && !"0".equals(str)) {
            try {
                int parseInt = Integer.parseInt(str);
                StringBuilder sb = new StringBuilder();
                sb.append("android.resource://");
                sb.append(this.o.getPackageName());
                sb.append(Constants.URL_PATH_DELIMITER);
                sb.append(parseInt);
                String sb2 = sb.toString();
                Drawable a2 = a(sb2);
                if (a2 != null) {
                    return a2;
                }
                Drawable c2 = b.g.a.a.c(this.o, parseInt);
                a(sb2, c2);
                return c2;
            } catch (NumberFormatException unused) {
                Drawable a3 = a(str);
                if (a3 != null) {
                    return a3;
                }
                drawable = b(Uri.parse(str));
                a(str, drawable);
            } catch (NotFoundException unused2) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Icon resource not found: ");
                sb3.append(str);
                Log.w("SuggestionsAdapter", sb3.toString());
                return null;
            }
        }
        return drawable;
    }

    public void a(View view, Context context, Cursor cursor) {
        CharSequence charSequence;
        a aVar = (a) view.getTag();
        int i2 = this.z;
        int i3 = i2 != -1 ? cursor.getInt(i2) : 0;
        if (aVar.f989a != null) {
            a(aVar.f989a, (CharSequence) a(cursor, this.u));
        }
        if (aVar.f990b != null) {
            String a2 = a(cursor, this.w);
            if (a2 != null) {
                charSequence = b((CharSequence) a2);
            } else {
                charSequence = a(cursor, this.v);
            }
            if (TextUtils.isEmpty(charSequence)) {
                TextView textView = aVar.f989a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.f989a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.f989a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.f989a.setMaxLines(1);
                }
            }
            a(aVar.f990b, charSequence);
        }
        ImageView imageView = aVar.f991c;
        if (imageView != null) {
            a(imageView, d(cursor), 4);
        }
        ImageView imageView2 = aVar.f992d;
        if (imageView2 != null) {
            a(imageView2, e(cursor), 8);
        }
        int i4 = this.s;
        if (i4 == 2 || (i4 == 1 && (i3 & 1) != 0)) {
            aVar.f993e.setVisibility(0);
            aVar.f993e.setTag(aVar.f989a.getText());
            aVar.f993e.setOnClickListener(this);
            return;
        }
        aVar.f993e.setVisibility(8);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r3 = new java.lang.StringBuilder();
        r3.append("Resource does not exist: ");
        r3.append(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002c, code lost:
        throw new java.io.FileNotFoundException(r3.toString());
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
    private Drawable b(Uri uri) {
        InputStream openInputStream;
        String str = "Error closing icon stream for ";
        String str2 = "SuggestionsAdapter";
        try {
            if ("android.resource".equals(uri.getScheme())) {
                return a(uri);
            }
            openInputStream = this.o.getContentResolver().openInputStream(uri);
            if (openInputStream != null) {
                Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
                try {
                    openInputStream.close();
                } catch (IOException e2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(uri);
                    Log.e(str2, sb.toString(), e2);
                }
                return createFromStream;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to open ");
            sb2.append(uri);
            throw new FileNotFoundException(sb2.toString());
        } catch (FileNotFoundException e3) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Icon not found: ");
            sb3.append(uri);
            sb3.append(", ");
            sb3.append(e3.getMessage());
            Log.w(str2, sb3.toString());
            return null;
        } catch (Throwable th) {
            try {
                openInputStream.close();
            } catch (IOException e4) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str);
                sb4.append(uri);
                Log.e(str2, sb4.toString(), e4);
            }
            throw th;
        }
    }

    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r2v2, types: [android.graphics.drawable.Drawable$ConstantState] */
    /* JADX WARNING: type inference failed for: r2v3, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: type inference failed for: r2v4, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v0
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], android.graphics.drawable.Drawable, android.graphics.drawable.Drawable$ConstantState]
      uses: [java.lang.Object, android.graphics.drawable.Drawable]
      mth insns count: 21
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 3 */
    private Drawable b(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        ? r2 = 0;
        if (this.p.containsKey(flattenToShortString)) {
            ConstantState constantState = (ConstantState) this.p.get(flattenToShortString);
            if (constantState != null) {
                r2 = constantState.newDrawable(this.o.getResources());
            }
            return r2;
        }
        Drawable a2 = a(componentName);
        if (a2 != null) {
            r2 = a2.getConstantState();
        }
        this.p.put(flattenToShortString, r2);
        return a2;
    }

    private void a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private void a(ImageView imageView, Drawable drawable, int i2) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i2);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private Drawable a(String str) {
        ConstantState constantState = (ConstantState) this.p.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private void a(String str, Drawable drawable) {
        if (drawable != null) {
            this.p.put(str, drawable.getConstantState());
        }
    }

    private Drawable a(ComponentName componentName) {
        String str = "SuggestionsAdapter";
        PackageManager packageManager = this.f2731d.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid icon resource ");
            sb.append(iconResource);
            sb.append(" for ");
            sb.append(componentName.flattenToShortString());
            Log.w(str, sb.toString());
            return null;
        } catch (NameNotFoundException e2) {
            Log.w(str, e2.toString());
            return null;
        }
    }

    public static String a(Cursor cursor, String str) {
        return a(cursor, cursor.getColumnIndex(str));
    }

    private static String a(Cursor cursor, int i2) {
        if (i2 == -1) {
            return null;
        }
        try {
            return cursor.getString(i2);
        } catch (Exception e2) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e2);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    public Drawable a(Uri uri) throws FileNotFoundException {
        int i2;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.f2731d.getPackageManager().getResourcesForApplication(authority);
                List pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            i2 = Integer.parseInt((String) pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Single path segment is not a resource ID: ");
                            sb.append(uri);
                            throw new FileNotFoundException(sb.toString());
                        }
                    } else if (size == 2) {
                        i2 = resourcesForApplication.getIdentifier((String) pathSegments.get(1), (String) pathSegments.get(0), authority);
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("More than two path segments: ");
                        sb2.append(uri);
                        throw new FileNotFoundException(sb2.toString());
                    }
                    if (i2 != 0) {
                        return resourcesForApplication.getDrawable(i2);
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("No resource found for: ");
                    sb3.append(uri);
                    throw new FileNotFoundException(sb3.toString());
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append("No path: ");
                sb4.append(uri);
                throw new FileNotFoundException(sb4.toString());
            } catch (NameNotFoundException unused2) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("No package found for authority: ");
                sb5.append(uri);
                throw new FileNotFoundException(sb5.toString());
            }
        } else {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("No authority: ");
            sb6.append(uri);
            throw new FileNotFoundException(sb6.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    public Cursor a(SearchableInfo searchableInfo, String str, int i2) {
        String[] strArr = null;
        if (searchableInfo == null) {
            return null;
        }
        String suggestAuthority = searchableInfo.getSuggestAuthority();
        if (suggestAuthority == null) {
            return null;
        }
        Builder authority = new Builder().scheme("content").authority(suggestAuthority);
        String str2 = "";
        Builder fragment = authority.query(str2).fragment(str2);
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i2 > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i2));
        }
        return this.f2731d.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
    }
}
