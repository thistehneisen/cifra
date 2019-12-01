package com.touchin.vtb.d;

import android.app.Dialog;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.C;
import com.google.android.material.bottomsheet.i;
import com.touchin.vtb.R;
import com.touchin.vtb.h.c.g;
import com.touchin.vtb.h.c.h.c;
import com.touchin.vtb.h.c.h.d;
import java.util.HashMap;
import kotlin.e.b.h;
import l.a.c.c.q;

/* compiled from: FingerprintBottomSheetDialog.kt */
public class a extends i {

    /* renamed from: l reason: collision with root package name */
    public static final C0074a f7235l = new C0074a(null);
    private com.touchin.vtb.h.c.i m;
    private TextView n;
    private TextView o;
    private TextView p;
    private ImageView q;
    /* access modifiers changed from: private */
    public b r;
    private final Runnable s = new f(this);
    /* access modifiers changed from: private */
    public final Runnable t = new c(this);
    private HashMap u;

    /* renamed from: com.touchin.vtb.d.a$a reason: collision with other inner class name */
    /* compiled from: FingerprintBottomSheetDialog.kt */
    public static final class C0074a {
        private C0074a() {
        }

        public final a a(String str, String str2) {
            h.b(str, "title");
            h.b(str2, "actionText");
            a aVar = new a();
            aVar.r = new b(str, str2);
            aVar.a(false);
            return aVar;
        }

        public /* synthetic */ C0074a(e eVar) {
            this();
        }
    }

    /* compiled from: FingerprintBottomSheetDialog.kt */
    private static final class b implements Parcelable {
        public static final Creator CREATOR = new C0075a();

        /* renamed from: a reason: collision with root package name */
        private final String f7236a;

        /* renamed from: b reason: collision with root package name */
        private final String f7237b;

        /* renamed from: com.touchin.vtb.d.a$b$a reason: collision with other inner class name */
        public static class C0075a implements Creator {
            public final Object createFromParcel(Parcel parcel) {
                h.b(parcel, "in");
                return new b(parcel.readString(), parcel.readString());
            }

            public final Object[] newArray(int i2) {
                return new b[i2];
            }
        }

        public b(String str, String str2) {
            this.f7236a = str;
            this.f7237b = str2;
        }

        public int describeContents() {
            return 0;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
            if (kotlin.e.b.h.a((java.lang.Object) r2.f7237b, (java.lang.Object) r3.f7237b) != false) goto L_0x001f;
         */
        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof b) {
                    b bVar = (b) obj;
                    if (h.a((Object) this.f7236a, (Object) bVar.f7236a)) {
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            String str = this.f7236a;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.f7237b;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            return hashCode + i2;
        }

        public final String n() {
            return this.f7237b;
        }

        public final String o() {
            return this.f7236a;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SavedState(title=");
            sb.append(this.f7236a);
            sb.append(", actionText=");
            sb.append(this.f7237b);
            sb.append(")");
            return sb.toString();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            h.b(parcel, "parcel");
            parcel.writeString(this.f7236a);
            parcel.writeString(this.f7237b);
        }
    }

    public static final /* synthetic */ TextView a(a aVar) {
        TextView textView = aVar.p;
        if (textView != null) {
            return textView;
        }
        h.b("cancelButton");
        throw null;
    }

    public static final /* synthetic */ com.touchin.vtb.h.c.i b(a aVar) {
        com.touchin.vtb.h.c.i iVar = aVar.m;
        if (iVar != null) {
            return iVar;
        }
        h.b("fingerprintViewModel");
        throw null;
    }

    public void c() {
        HashMap hashMap = this.u;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        q qVar = q.f10391a;
        Fragment targetFragment = getTargetFragment();
        if (targetFragment != null) {
            h.a((Object) targetFragment, "targetFragment!!");
            C a2 = q.a(qVar, targetFragment, null, 2, null).a(com.touchin.vtb.h.c.i.class);
            h.a((Object) a2, "LifecycleViewModelProvid…intViewModel::class.java)");
            this.m = (com.touchin.vtb.h.c.i) a2;
            com.touchin.vtb.h.c.i iVar = this.m;
            String str = "fingerprintViewModel";
            if (iVar != null) {
                iVar.d().a(this, new g(new d(this)));
                com.touchin.vtb.h.c.i iVar2 = this.m;
                if (iVar2 != null) {
                    iVar2.g();
                    com.touchin.vtb.h.c.i iVar3 = this.m;
                    if (iVar3 != null) {
                        iVar3.c().a(this, new e(this));
                    } else {
                        h.b(str);
                        throw null;
                    }
                } else {
                    h.b(str);
                    throw null;
                }
            } else {
                h.b(str);
                throw null;
            }
        } else {
            h.a();
            throw null;
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        c();
    }

    public void a(Dialog dialog, int i2) {
        h.b(dialog, "dialog");
        dialog.setContentView(R.layout.dialog_fingerprint);
        View findViewById = dialog.findViewById(R.id.fingerprint_bottom_sheet_dialog_title);
        h.a((Object) findViewById, "dialog.findViewById(R.id…ottom_sheet_dialog_title)");
        this.n = (TextView) findViewById;
        TextView textView = this.n;
        if (textView != null) {
            b bVar = this.r;
            String str = "state";
            if (bVar != null) {
                textView.setText(bVar.o());
                View findViewById2 = dialog.findViewById(R.id.fingerprint_bottom_sheet_dialog_status);
                h.a((Object) findViewById2, "dialog.findViewById(R.id…ttom_sheet_dialog_status)");
                this.o = (TextView) findViewById2;
                TextView textView2 = this.o;
                if (textView2 != null) {
                    b bVar2 = this.r;
                    if (bVar2 != null) {
                        textView2.setText(bVar2.n());
                        View findViewById3 = dialog.findViewById(R.id.fingerprint_bottom_sheet_icon);
                        h.a((Object) findViewById3, "dialog.findViewById(R.id…rprint_bottom_sheet_icon)");
                        this.q = (ImageView) findViewById3;
                        View findViewById4 = dialog.findViewById(R.id.fingerprint_bottom_sheet_dialog_cancel);
                        h.a((Object) findViewById4, "dialog.findViewById(R.id…ttom_sheet_dialog_cancel)");
                        this.p = (TextView) findViewById4;
                        TextView textView3 = this.p;
                        if (textView3 != null) {
                            textView3.setOnClickListener(new h(this));
                        } else {
                            h.b("cancelButton");
                            throw null;
                        }
                    } else {
                        h.b(str);
                        throw null;
                    }
                } else {
                    h.b("statusText");
                    throw null;
                }
            } else {
                h.b(str);
                throw null;
            }
        } else {
            h.b("titleText");
            throw null;
        }
    }

    /* access modifiers changed from: private */
    public final void a(com.touchin.vtb.h.c.h hVar) {
        ColorStateList b2 = b.g.a.a.b(requireContext(), R.color.common_error_color);
        String str = "fingerprintImageView";
        String str2 = "statusText";
        if (hVar instanceof d) {
            TextView textView = this.o;
            if (textView != null) {
                textView.setText(getString(R.string.android_fingerprint_success));
                ImageView imageView = this.q;
                if (imageView != null) {
                    imageView.setImageResource(R.drawable.common_fingerprint_icon);
                    TextView textView2 = this.o;
                    if (textView2 != null) {
                        textView2.setTextColor(b.g.a.a.b(requireContext(), R.color.common_success_color));
                        TextView textView3 = this.p;
                        if (textView3 != null) {
                            textView3.postDelayed(this.s, 700);
                        } else {
                            h.b("cancelButton");
                            throw null;
                        }
                    } else {
                        h.b(str2);
                        throw null;
                    }
                } else {
                    h.b(str);
                    throw null;
                }
            } else {
                h.b(str2);
                throw null;
            }
        } else if (hVar instanceof com.touchin.vtb.h.c.h.b) {
            ImageView imageView2 = this.q;
            if (imageView2 != null) {
                imageView2.setImageResource(R.drawable.common_fingerprint_error_icon);
                TextView textView4 = this.o;
                if (textView4 != null) {
                    textView4.setText(getString(R.string.android_fingerprint_fail));
                    TextView textView5 = this.o;
                    if (textView5 != null) {
                        textView5.setTextColor(b2);
                    } else {
                        h.b(str2);
                        throw null;
                    }
                } else {
                    h.b(str2);
                    throw null;
                }
            } else {
                h.b(str);
                throw null;
            }
        } else if (hVar instanceof c) {
            ImageView imageView3 = this.q;
            if (imageView3 != null) {
                imageView3.setImageResource(R.drawable.common_fingerprint_icon);
                TextView textView6 = this.o;
                if (textView6 != null) {
                    textView6.setText(((c) hVar).a());
                    TextView textView7 = this.o;
                    if (textView7 != null) {
                        textView7.setTextColor(b2);
                    } else {
                        h.b(str2);
                        throw null;
                    }
                } else {
                    h.b(str2);
                    throw null;
                }
            } else {
                h.b(str);
                throw null;
            }
        } else if (hVar instanceof com.touchin.vtb.h.c.h.a) {
            ImageView imageView4 = this.q;
            if (imageView4 != null) {
                imageView4.setImageResource(R.drawable.common_fingerprint_error_icon);
                TextView textView8 = this.o;
                if (textView8 != null) {
                    textView8.setTextColor(b2);
                    a(((com.touchin.vtb.h.c.h.a) hVar).a());
                    return;
                }
                h.b(str2);
                throw null;
            }
            h.b(str);
            throw null;
        }
    }

    private final void a(g gVar) {
        int i2 = b.f7238a[gVar.ordinal()];
        String str = "statusText";
        if (i2 != 1) {
            String str2 = "fingerprintViewModel";
            if (i2 == 2) {
                TextView textView = this.o;
                if (textView != null) {
                    textView.setText(getString(R.string.android_fingerprint_lockout_permanent));
                    com.touchin.vtb.h.c.i iVar = this.m;
                    if (iVar != null) {
                        iVar.a(false, new j(this));
                    } else {
                        h.b(str2);
                        throw null;
                    }
                } else {
                    h.b(str);
                    throw null;
                }
            } else if (i2 == 3) {
                TextView textView2 = this.o;
                if (textView2 != null) {
                    textView2.setText(getString(R.string.android_fingerprint_error));
                    com.touchin.vtb.h.c.i iVar2 = this.m;
                    if (iVar2 != null) {
                        iVar2.a(false, new k(this));
                    } else {
                        h.b(str2);
                        throw null;
                    }
                } else {
                    h.b(str);
                    throw null;
                }
            }
        } else {
            TextView textView3 = this.o;
            if (textView3 != null) {
                textView3.setText(getString(R.string.android_fingerprint_lockout));
                TextView textView4 = this.o;
                if (textView4 != null) {
                    textView4.postDelayed(new i(this), 30000);
                } else {
                    h.b(str);
                    throw null;
                }
            } else {
                h.b(str);
                throw null;
            }
        }
    }
}
