package b.a.d;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.q;
import androidx.appcompat.widget.K;
import b.a.j;
import b.g.i.C0241b;
import b.g.i.C0247h;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: SupportMenuInflater */
public class g extends MenuInflater {

    /* renamed from: a reason: collision with root package name */
    static final Class<?>[] f2206a = {Context.class};

    /* renamed from: b reason: collision with root package name */
    static final Class<?>[] f2207b = f2206a;

    /* renamed from: c reason: collision with root package name */
    final Object[] f2208c;

    /* renamed from: d reason: collision with root package name */
    final Object[] f2209d = this.f2208c;

    /* renamed from: e reason: collision with root package name */
    Context f2210e;

    /* renamed from: f reason: collision with root package name */
    private Object f2211f;

    /* compiled from: SupportMenuInflater */
    private static class a implements OnMenuItemClickListener {

        /* renamed from: a reason: collision with root package name */
        private static final Class<?>[] f2212a = {MenuItem.class};

        /* renamed from: b reason: collision with root package name */
        private Object f2213b;

        /* renamed from: c reason: collision with root package name */
        private Method f2214c;

        public a(Object obj, String str) {
            this.f2213b = obj;
            Class cls = obj.getClass();
            try {
                this.f2214c = cls.getMethod(str, f2212a);
            } catch (Exception e2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Couldn't resolve menu item onClick handler ");
                sb.append(str);
                sb.append(" in class ");
                sb.append(cls.getName());
                InflateException inflateException = new InflateException(sb.toString());
                inflateException.initCause(e2);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f2214c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f2214c.invoke(this.f2213b, new Object[]{menuItem})).booleanValue();
                }
                this.f2214c.invoke(this.f2213b, new Object[]{menuItem});
                return true;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* compiled from: SupportMenuInflater */
    private class b {
        C0241b A;
        private CharSequence B;
        private CharSequence C;
        private ColorStateList D = null;
        private Mode E = null;

        /* renamed from: a reason: collision with root package name */
        private Menu f2215a;

        /* renamed from: b reason: collision with root package name */
        private int f2216b;

        /* renamed from: c reason: collision with root package name */
        private int f2217c;

        /* renamed from: d reason: collision with root package name */
        private int f2218d;

        /* renamed from: e reason: collision with root package name */
        private int f2219e;

        /* renamed from: f reason: collision with root package name */
        private boolean f2220f;

        /* renamed from: g reason: collision with root package name */
        private boolean f2221g;

        /* renamed from: h reason: collision with root package name */
        private boolean f2222h;

        /* renamed from: i reason: collision with root package name */
        private int f2223i;

        /* renamed from: j reason: collision with root package name */
        private int f2224j;

        /* renamed from: k reason: collision with root package name */
        private CharSequence f2225k;

        /* renamed from: l reason: collision with root package name */
        private CharSequence f2226l;
        private int m;
        private char n;
        private int o;
        private char p;
        private int q;
        private int r;
        private boolean s;
        private boolean t;
        private boolean u;
        private int v;
        private int w;
        private String x;
        private String y;
        private String z;

        public b(Menu menu) {
            this.f2215a = menu;
            d();
        }

        public void a(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.f2210e.obtainStyledAttributes(attributeSet, j.MenuGroup);
            this.f2216b = obtainStyledAttributes.getResourceId(j.MenuGroup_android_id, 0);
            this.f2217c = obtainStyledAttributes.getInt(j.MenuGroup_android_menuCategory, 0);
            this.f2218d = obtainStyledAttributes.getInt(j.MenuGroup_android_orderInCategory, 0);
            this.f2219e = obtainStyledAttributes.getInt(j.MenuGroup_android_checkableBehavior, 0);
            this.f2220f = obtainStyledAttributes.getBoolean(j.MenuGroup_android_visible, true);
            this.f2221g = obtainStyledAttributes.getBoolean(j.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void b(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.f2210e.obtainStyledAttributes(attributeSet, j.MenuItem);
            this.f2223i = obtainStyledAttributes.getResourceId(j.MenuItem_android_id, 0);
            this.f2224j = (obtainStyledAttributes.getInt(j.MenuItem_android_menuCategory, this.f2217c) & -65536) | (obtainStyledAttributes.getInt(j.MenuItem_android_orderInCategory, this.f2218d) & 65535);
            this.f2225k = obtainStyledAttributes.getText(j.MenuItem_android_title);
            this.f2226l = obtainStyledAttributes.getText(j.MenuItem_android_titleCondensed);
            this.m = obtainStyledAttributes.getResourceId(j.MenuItem_android_icon, 0);
            this.n = a(obtainStyledAttributes.getString(j.MenuItem_android_alphabeticShortcut));
            this.o = obtainStyledAttributes.getInt(j.MenuItem_alphabeticModifiers, CodedOutputStream.DEFAULT_BUFFER_SIZE);
            this.p = a(obtainStyledAttributes.getString(j.MenuItem_android_numericShortcut));
            this.q = obtainStyledAttributes.getInt(j.MenuItem_numericModifiers, CodedOutputStream.DEFAULT_BUFFER_SIZE);
            if (obtainStyledAttributes.hasValue(j.MenuItem_android_checkable)) {
                this.r = obtainStyledAttributes.getBoolean(j.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.r = this.f2219e;
            }
            this.s = obtainStyledAttributes.getBoolean(j.MenuItem_android_checked, false);
            this.t = obtainStyledAttributes.getBoolean(j.MenuItem_android_visible, this.f2220f);
            this.u = obtainStyledAttributes.getBoolean(j.MenuItem_android_enabled, this.f2221g);
            this.v = obtainStyledAttributes.getInt(j.MenuItem_showAsAction, -1);
            this.z = obtainStyledAttributes.getString(j.MenuItem_android_onClick);
            this.w = obtainStyledAttributes.getResourceId(j.MenuItem_actionLayout, 0);
            this.x = obtainStyledAttributes.getString(j.MenuItem_actionViewClass);
            this.y = obtainStyledAttributes.getString(j.MenuItem_actionProviderClass);
            boolean z2 = this.y != null;
            if (z2 && this.w == 0 && this.x == null) {
                this.A = (C0241b) a(this.y, g.f2207b, g.this.f2209d);
            } else {
                if (z2) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = obtainStyledAttributes.getText(j.MenuItem_contentDescription);
            this.C = obtainStyledAttributes.getText(j.MenuItem_tooltipText);
            if (obtainStyledAttributes.hasValue(j.MenuItem_iconTintMode)) {
                this.E = K.a(obtainStyledAttributes.getInt(j.MenuItem_iconTintMode, -1), this.E);
            } else {
                this.E = null;
            }
            if (obtainStyledAttributes.hasValue(j.MenuItem_iconTint)) {
                this.D = obtainStyledAttributes.getColorStateList(j.MenuItem_iconTint);
            } else {
                this.D = null;
            }
            obtainStyledAttributes.recycle();
            this.f2222h = false;
        }

        public boolean c() {
            return this.f2222h;
        }

        public void d() {
            this.f2216b = 0;
            this.f2217c = 0;
            this.f2218d = 0;
            this.f2219e = 0;
            this.f2220f = true;
            this.f2221g = true;
        }

        private char a(String str) {
            if (str == null) {
                return 0;
            }
            return str.charAt(0);
        }

        private void a(MenuItem menuItem) {
            boolean z2 = false;
            menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.f2226l).setIcon(this.m);
            int i2 = this.v;
            if (i2 >= 0) {
                menuItem.setShowAsAction(i2);
            }
            if (this.z != null) {
                if (!g.this.f2210e.isRestricted()) {
                    menuItem.setOnMenuItemClickListener(new a(g.this.a(), this.z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            boolean z3 = menuItem instanceof p;
            if (z3) {
                p pVar = (p) menuItem;
            }
            if (this.r >= 2) {
                if (z3) {
                    ((p) menuItem).c(true);
                } else if (menuItem instanceof q) {
                    ((q) menuItem).a(true);
                }
            }
            String str = this.x;
            if (str != null) {
                menuItem.setActionView((View) a(str, g.f2206a, g.this.f2208c));
                z2 = true;
            }
            int i3 = this.w;
            if (i3 > 0) {
                if (!z2) {
                    menuItem.setActionView(i3);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            C0241b bVar = this.A;
            if (bVar != null) {
                C0247h.a(menuItem, bVar);
            }
            C0247h.a(menuItem, this.B);
            C0247h.b(menuItem, this.C);
            C0247h.a(menuItem, this.n, this.o);
            C0247h.b(menuItem, this.p, this.q);
            Mode mode = this.E;
            if (mode != null) {
                C0247h.a(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                C0247h.a(menuItem, colorStateList);
            }
        }

        public SubMenu b() {
            this.f2222h = true;
            SubMenu addSubMenu = this.f2215a.addSubMenu(this.f2216b, this.f2223i, this.f2224j, this.f2225k);
            a(addSubMenu.getItem());
            return addSubMenu;
        }

        public void a() {
            this.f2222h = true;
            a(this.f2215a.add(this.f2216b, this.f2223i, this.f2224j, this.f2225k));
        }

        private <T> T a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor constructor = g.this.f2210e.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot instantiate class: ");
                sb.append(str);
                Log.w("SupportMenuInflater", sb.toString(), e2);
                return null;
            }
        }
    }

    public g(Context context) {
        super(context);
        this.f2210e = context;
        this.f2208c = new Object[]{context};
    }

    private void a(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        String str;
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            str = "menu";
            if (eventType != 2) {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            } else {
                String name = xmlPullParser.getName();
                if (name.equals(str)) {
                    eventType = xmlPullParser.next();
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Expecting menu, got ");
                    sb.append(name);
                    throw new RuntimeException(sb.toString());
                }
            }
        }
        int i2 = eventType;
        String str2 = null;
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            if (i2 != 1) {
                String str3 = "item";
                String str4 = "group";
                if (i2 != 2) {
                    if (i2 == 3) {
                        String name2 = xmlPullParser.getName();
                        if (z2 && name2.equals(str2)) {
                            str2 = null;
                            z2 = false;
                        } else if (name2.equals(str4)) {
                            bVar.d();
                        } else if (name2.equals(str3)) {
                            if (!bVar.c()) {
                                C0241b bVar2 = bVar.A;
                                if (bVar2 == null || !bVar2.a()) {
                                    bVar.a();
                                } else {
                                    bVar.b();
                                }
                            }
                        } else if (name2.equals(str)) {
                            z = true;
                        }
                    }
                } else if (!z2) {
                    String name3 = xmlPullParser.getName();
                    if (name3.equals(str4)) {
                        bVar.a(attributeSet);
                    } else if (name3.equals(str3)) {
                        bVar.b(attributeSet);
                    } else if (name3.equals(str)) {
                        a(xmlPullParser, attributeSet, bVar.b());
                    } else {
                        str2 = name3;
                        z2 = true;
                    }
                }
                i2 = xmlPullParser.next();
            } else {
                throw new RuntimeException("Unexpected end of document");
            }
        }
    }

    public void inflate(int i2, Menu menu) {
        String str = "Error inflating menu XML";
        if (!(menu instanceof b.g.d.a.a)) {
            super.inflate(i2, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = this.f2210e.getResources().getLayout(i2);
            a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        } catch (XmlPullParserException e2) {
            throw new InflateException(str, e2);
        } catch (IOException e3) {
            throw new InflateException(str, e3);
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: 0000 */
    public Object a() {
        if (this.f2211f == null) {
            this.f2211f = a(this.f2210e);
        }
        return this.f2211f;
    }

    private Object a(Object obj) {
        if (obj instanceof Activity) {
            return obj;
        }
        if (obj instanceof ContextWrapper) {
            obj = a(((ContextWrapper) obj).getBaseContext());
        }
        return obj;
    }
}
