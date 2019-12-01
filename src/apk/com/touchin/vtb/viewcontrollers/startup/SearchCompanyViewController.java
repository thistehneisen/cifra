package com.touchin.vtb.viewcontrollers.startup;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.C;
import com.touchin.vtb.R;
import com.touchin.vtb.activities.c;
import com.touchin.vtb.api.DaDataAddress;
import com.touchin.vtb.api.DaDataAddressDescription;
import com.touchin.vtb.api.DaDataOpf;
import com.touchin.vtb.api.DaDataOrganizationDescription;
import com.touchin.vtb.api.DaDataStatus;
import com.touchin.vtb.api.DaDataSuggestion;
import com.touchin.vtb.g.i;
import com.touchin.vtb.h.c.r;
import com.touchin.vtb.viewcontrollers.base.RegistrationWithToolbarViewController;
import com.touchin.vtb.views.ProgressButton;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import kotlin.e.b.h;
import l.a.c.c.q;
import l.a.d.a.a.a.b;
import ru.touchin.roboswag.components.navigation.viewcontrollers.d;

/* compiled from: SearchCompanyViewController.kt */
public final class SearchCompanyViewController extends RegistrationWithToolbarViewController<c, i> {
    public static final a Companion = new a(null);
    private static final String OOO_OKOPF_CODE = "12300";
    private static final int REGISTRATION_PROGRESS = 50;
    private final TextView companyTextView = ((TextView) findViewById(R.id.view_controller_search_company_text));
    private final TextView innTextView = ((TextView) findViewById(R.id.view_controller_search_company_hint_inn));
    private final b onBackPressedListener = new ja(this);
    /* access modifiers changed from: private */
    public final ProgressButton progressButton = ((ProgressButton) findViewById(R.id.view_controller_search_company_progress_button));
    private final TextView searchHintTextView = ((TextView) findViewById(R.id.view_controller_search_company_hint));
    private final View searchImageView = findViewById(R.id.view_controller_search_company_icon);
    /* access modifiers changed from: private */
    public final r viewModel;

    /* compiled from: SearchCompanyViewController.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    public SearchCompanyViewController(ru.touchin.roboswag.components.navigation.viewcontrollers.c.a aVar) {
        h.b(aVar, "creationContext");
        super(aVar, R.layout.view_controller_search_company);
        C a2 = q.a(q.f10391a, this, null, 2, null).a(r.class);
        h.a((Object) a2, "LifecycleViewModelProvid…anyViewModel::class.java)");
        this.viewModel = (r) a2;
        TextView textView = this.searchHintTextView;
        kotlin.e.b.q qVar = kotlin.e.b.q.f10310a;
        Object[] objArr = {getString(R.string.common_registration_name_or_inn)};
        String format = String.format(getString(R.string.common_global_colon_template), Arrays.copyOf(objArr, objArr.length));
        h.a((Object) format, "java.lang.String.format(format, *args)");
        textView.setText(format);
        initToolbar();
        if (!n.a(((i) getState()).p())) {
            setInitDataState();
        }
        getView().setOnApplyWindowInsetsListener(new C0681ca(this));
        initListeners();
        this.viewModel.c().a(this, new C0687fa(this));
    }

    private final void initListeners() {
        this.companyTextView.setOnClickListener(new ga(this));
        this.searchImageView.setOnClickListener(new ha(this));
        this.progressButton.setOnClickListener(new ia(this));
    }

    private final void initToolbar() {
        setProgress(50);
        c.a((c) getActivity(), getToolbar(), getString(R.string.common_registration_add_company), null, true, 0, 20, null);
    }

    /* access modifiers changed from: private */
    public final void navigateToSearchViewController() {
        d.a(((c) getActivity()).c(), SearchViewController.class, ru.touchin.roboswag.components.navigation.viewcontrollers.b.f11113a, getFragment(), 100, null, null, 48, null);
    }

    private final void setInitDataState() {
        this.searchHintTextView.setVisibility(0);
        this.innTextView.setVisibility(0);
        this.innTextView.setText(getString(R.string.common_registration_inn_address_mask, ((i) getState()).q(), ((i) getState()).o()));
        this.companyTextView.setText(((i) getState()).p());
        this.progressButton.setVisibility(0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009b  */
    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        String str2;
        String str3;
        BigDecimal bigDecimal;
        if (i2 == 100) {
            String str4 = null;
            Serializable serializableExtra = intent != null ? intent.getSerializableExtra("SEARCH_COMPANY_EXTRA") : null;
            if (!(serializableExtra instanceof DaDataSuggestion)) {
                serializableExtra = null;
            }
            DaDataSuggestion daDataSuggestion = (DaDataSuggestion) serializableExtra;
            i iVar = (i) getState();
            String c2 = daDataSuggestion != null ? daDataSuggestion.c() : null;
            String str5 = "";
            if (c2 == null) {
                c2 = str5;
            }
            iVar.c(c2);
            if (daDataSuggestion != null) {
                DaDataOrganizationDescription daDataOrganizationDescription = (DaDataOrganizationDescription) daDataSuggestion.b();
                if (daDataOrganizationDescription != null) {
                    str = daDataOrganizationDescription.c();
                    if (str == null) {
                        str = str5;
                    }
                    iVar.d(str);
                    if (daDataSuggestion != null) {
                        DaDataOrganizationDescription daDataOrganizationDescription2 = (DaDataOrganizationDescription) daDataSuggestion.b();
                        if (daDataOrganizationDescription2 != null) {
                            DaDataAddress b2 = daDataOrganizationDescription2.b();
                            if (b2 != null) {
                                DaDataAddressDescription daDataAddressDescription = (DaDataAddressDescription) b2.b();
                                if (daDataAddressDescription != null) {
                                    str2 = daDataAddressDescription.b();
                                    if (str2 == null) {
                                        str2 = str5;
                                    }
                                    iVar.b(str2);
                                    if (daDataSuggestion != null) {
                                        DaDataOrganizationDescription daDataOrganizationDescription3 = (DaDataOrganizationDescription) daDataSuggestion.b();
                                        if (daDataOrganizationDescription3 != null) {
                                            str3 = daDataOrganizationDescription3.e();
                                            if (str3 == null) {
                                                str3 = str5;
                                            }
                                            iVar.e(str3);
                                            if (daDataSuggestion != null) {
                                                DaDataOrganizationDescription daDataOrganizationDescription4 = (DaDataOrganizationDescription) daDataSuggestion.b();
                                                if (daDataOrganizationDescription4 != null) {
                                                    DaDataStatus f2 = daDataOrganizationDescription4.f();
                                                    if (f2 != null) {
                                                        bigDecimal = f2.b();
                                                        iVar.a(bigDecimal);
                                                        if (daDataSuggestion != null) {
                                                            DaDataOrganizationDescription daDataOrganizationDescription5 = (DaDataOrganizationDescription) daDataSuggestion.b();
                                                            if (daDataOrganizationDescription5 != null) {
                                                                DaDataAddress b3 = daDataOrganizationDescription5.b();
                                                                if (b3 != null) {
                                                                    String c3 = b3.c();
                                                                    if (c3 != null) {
                                                                        DaDataOrganizationDescription daDataOrganizationDescription6 = (DaDataOrganizationDescription) daDataSuggestion.b();
                                                                        h.a((Object) daDataOrganizationDescription6, "serializedData.data");
                                                                        DaDataOpf d2 = daDataOrganizationDescription6.d();
                                                                        if (h.a(d2 != null ? d2.c() : null, (Object) OOO_OKOPF_CODE)) {
                                                                            str4 = c3;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        iVar.a(str4);
                                                        setInitDataState();
                                                        return;
                                                    }
                                                }
                                            }
                                            bigDecimal = null;
                                            iVar.a(bigDecimal);
                                            if (daDataSuggestion != null) {
                                            }
                                            iVar.a(str4);
                                            setInitDataState();
                                            return;
                                        }
                                    }
                                    str3 = null;
                                    if (str3 == null) {
                                    }
                                    iVar.e(str3);
                                    if (daDataSuggestion != null) {
                                    }
                                    bigDecimal = null;
                                    iVar.a(bigDecimal);
                                    if (daDataSuggestion != null) {
                                    }
                                    iVar.a(str4);
                                    setInitDataState();
                                    return;
                                }
                            }
                        }
                    }
                    str2 = null;
                    if (str2 == null) {
                    }
                    iVar.b(str2);
                    if (daDataSuggestion != null) {
                    }
                    str3 = null;
                    if (str3 == null) {
                    }
                    iVar.e(str3);
                    if (daDataSuggestion != null) {
                    }
                    bigDecimal = null;
                    iVar.a(bigDecimal);
                    if (daDataSuggestion != null) {
                    }
                    iVar.a(str4);
                    setInitDataState();
                    return;
                }
            }
            str = null;
            if (str == null) {
            }
            iVar.d(str);
            if (daDataSuggestion != null) {
            }
            str2 = null;
            if (str2 == null) {
            }
            iVar.b(str2);
            if (daDataSuggestion != null) {
            }
            str3 = null;
            if (str3 == null) {
            }
            iVar.e(str3);
            if (daDataSuggestion != null) {
            }
            bigDecimal = null;
            iVar.a(bigDecimal);
            if (daDataSuggestion != null) {
            }
            iVar.a(str4);
            setInitDataState();
            return;
        }
        super.onActivityResult(i2, i3, intent);
    }

    public void onStart() {
        super.onStart();
        ((c) getActivity()).a(this.onBackPressedListener);
    }

    public void onStop() {
        super.onStop();
        ((c) getActivity()).b(this.onBackPressedListener);
    }
}
