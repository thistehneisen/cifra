package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.SelectionBoundsAdjuster;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.view.menu.w.a;
import androidx.appcompat.widget.sa;
import b.a.f;
import b.a.g;
import b.a.j;
import b.g.i.B;

public class ListMenuItemView extends LinearLayout implements a, SelectionBoundsAdjuster {

    /* renamed from: a reason: collision with root package name */
    private p f571a;

    /* renamed from: b reason: collision with root package name */
    private ImageView f572b;

    /* renamed from: c reason: collision with root package name */
    private RadioButton f573c;

    /* renamed from: d reason: collision with root package name */
    private TextView f574d;

    /* renamed from: e reason: collision with root package name */
    private CheckBox f575e;

    /* renamed from: f reason: collision with root package name */
    private TextView f576f;

    /* renamed from: g reason: collision with root package name */
    private ImageView f577g;

    /* renamed from: h reason: collision with root package name */
    private ImageView f578h;

    /* renamed from: i reason: collision with root package name */
    private LinearLayout f579i;

    /* renamed from: j reason: collision with root package name */
    private Drawable f580j;

    /* renamed from: k reason: collision with root package name */
    private int f581k;

    /* renamed from: l reason: collision with root package name */
    private Context f582l;
    private boolean m;
    private Drawable n;
    private boolean o;
    private int p;
    private LayoutInflater q;
    private boolean r;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.a.a.listMenuViewStyle);
    }

    private void b() {
        this.f575e = (CheckBox) getInflater().inflate(g.abc_list_menu_item_checkbox, this, false);
        a(this.f575e);
    }

    private void c() {
        this.f572b = (ImageView) getInflater().inflate(g.abc_list_menu_item_icon, this, false);
        a((View) this.f572b, 0);
    }

    private void d() {
        this.f573c = (RadioButton) getInflater().inflate(g.abc_list_menu_item_radio, this, false);
        a(this.f573c);
    }

    private LayoutInflater getInflater() {
        if (this.q == null) {
            this.q = LayoutInflater.from(getContext());
        }
        return this.q;
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.f577g;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public void a(p pVar, int i2) {
        this.f571a = pVar;
        this.p = i2;
        setVisibility(pVar.isVisible() ? 0 : 8);
        setTitle(pVar.a((a) this));
        setCheckable(pVar.isCheckable());
        a(pVar.m(), pVar.d());
        setIcon(pVar.getIcon());
        setEnabled(pVar.isEnabled());
        setSubMenuArrowVisible(pVar.hasSubMenu());
        setContentDescription(pVar.getContentDescription());
    }

    public boolean a() {
        return false;
    }

    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f578h;
        if (imageView != null && imageView.getVisibility() == 0) {
            LayoutParams layoutParams = (LayoutParams) this.f578h.getLayoutParams();
            rect.top += this.f578h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
        }
    }

    public p getItemData() {
        return this.f571a;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        B.a((View) this, this.f580j);
        this.f574d = (TextView) findViewById(f.title);
        int i2 = this.f581k;
        if (i2 != -1) {
            this.f574d.setTextAppearance(this.f582l, i2);
        }
        this.f576f = (TextView) findViewById(f.shortcut);
        this.f577g = (ImageView) findViewById(f.submenuarrow);
        ImageView imageView = this.f577g;
        if (imageView != null) {
            imageView.setImageDrawable(this.n);
        }
        this.f578h = (ImageView) findViewById(f.group_divider);
        this.f579i = (LinearLayout) findViewById(f.content);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.f572b != null && this.m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) this.f572b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i2, i3);
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (z || this.f573c != null || this.f575e != null) {
            if (this.f571a.i()) {
                if (this.f573c == null) {
                    d();
                }
                compoundButton2 = this.f573c;
                compoundButton = this.f575e;
            } else {
                if (this.f575e == null) {
                    b();
                }
                compoundButton2 = this.f575e;
                compoundButton = this.f573c;
            }
            if (z) {
                compoundButton2.setChecked(this.f571a.isChecked());
                if (compoundButton2.getVisibility() != 0) {
                    compoundButton2.setVisibility(0);
                }
                if (!(compoundButton == null || compoundButton.getVisibility() == 8)) {
                    compoundButton.setVisibility(8);
                }
            } else {
                CheckBox checkBox = this.f575e;
                if (checkBox != null) {
                    checkBox.setVisibility(8);
                }
                RadioButton radioButton = this.f573c;
                if (radioButton != null) {
                    radioButton.setVisibility(8);
                }
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f571a.i()) {
            if (this.f573c == null) {
                d();
            }
            compoundButton = this.f573c;
        } else {
            if (this.f575e == null) {
                b();
            }
            compoundButton = this.f575e;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.r = z;
        this.m = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.f578h;
        if (imageView != null) {
            imageView.setVisibility((this.o || !z) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.f571a.l() || this.r;
        if (!z && !this.m) {
            return;
        }
        if (this.f572b != null || drawable != null || this.m) {
            if (this.f572b == null) {
                c();
            }
            if (drawable != null || this.m) {
                ImageView imageView = this.f572b;
                if (!z) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.f572b.getVisibility() != 0) {
                    this.f572b.setVisibility(0);
                }
            } else {
                this.f572b.setVisibility(8);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f574d.setText(charSequence);
            if (this.f574d.getVisibility() != 0) {
                this.f574d.setVisibility(0);
            }
        } else if (this.f574d.getVisibility() != 8) {
            this.f574d.setVisibility(8);
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        sa a2 = sa.a(getContext(), attributeSet, j.MenuView, i2, 0);
        this.f580j = a2.b(j.MenuView_android_itemBackground);
        this.f581k = a2.g(j.MenuView_android_itemTextAppearance, -1);
        this.m = a2.a(j.MenuView_preserveIconSpacing, false);
        this.f582l = context;
        this.n = a2.b(j.MenuView_subMenuArrow);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{16843049}, b.a.a.dropDownListViewStyle, 0);
        this.o = obtainStyledAttributes.hasValue(0);
        a2.a();
        obtainStyledAttributes.recycle();
    }

    private void a(View view) {
        a(view, -1);
    }

    private void a(View view, int i2) {
        LinearLayout linearLayout = this.f579i;
        if (linearLayout != null) {
            linearLayout.addView(view, i2);
        } else {
            addView(view, i2);
        }
    }

    public void a(boolean z, char c2) {
        int i2 = (!z || !this.f571a.m()) ? 8 : 0;
        if (i2 == 0) {
            this.f576f.setText(this.f571a.e());
        }
        if (this.f576f.getVisibility() != i2) {
            this.f576f.setVisibility(i2);
        }
    }
}
