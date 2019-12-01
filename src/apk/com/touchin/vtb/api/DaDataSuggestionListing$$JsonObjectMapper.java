package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class DaDataSuggestionListing$$JsonObjectMapper extends JsonMapper<DaDataSuggestionListing> {
    private static final JsonMapper<DaDataSuggestion> COM_TOUCHIN_VTB_API_DADATASUGGESTION__JSONOBJECTMAPPER = LoganSquare.mapperFor(DaDataSuggestion.class);

    public DaDataSuggestionListing parse(e eVar) throws IOException {
        DaDataSuggestionListing daDataSuggestionListing = new DaDataSuggestionListing();
        if (eVar.d() == null) {
            eVar.F();
        }
        if (eVar.d() != g.START_OBJECT) {
            eVar.G();
            return null;
        }
        while (eVar.F() != g.END_OBJECT) {
            String c2 = eVar.c();
            eVar.F();
            parseField(daDataSuggestionListing, c2, eVar);
            eVar.G();
        }
        return daDataSuggestionListing;
    }

    public void parseField(DaDataSuggestionListing daDataSuggestionListing, String str, e eVar) throws IOException {
        if (!"suggestions".equals(str)) {
            return;
        }
        if (eVar.d() == g.START_ARRAY) {
            ArrayList arrayList = new ArrayList();
            while (eVar.F() != g.END_ARRAY) {
                arrayList.add((DaDataSuggestion) COM_TOUCHIN_VTB_API_DADATASUGGESTION__JSONOBJECTMAPPER.parse(eVar));
            }
            daDataSuggestionListing.a(arrayList);
            return;
        }
        daDataSuggestionListing.a(null);
    }

    public void serialize(DaDataSuggestionListing daDataSuggestionListing, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        List<DaDataSuggestion> b2 = daDataSuggestionListing.b();
        if (b2 != null) {
            cVar.c("suggestions");
            cVar.e();
            for (DaDataSuggestion daDataSuggestion : b2) {
                if (daDataSuggestion != null) {
                    COM_TOUCHIN_VTB_API_DADATASUGGESTION__JSONOBJECTMAPPER.serialize(daDataSuggestion, cVar, true);
                }
            }
            cVar.b();
        }
        if (z) {
            cVar.c();
        }
    }
}
