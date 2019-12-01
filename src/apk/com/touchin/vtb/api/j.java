package com.touchin.vtb.api;

import e.b.o;
import retrofit2.a.a;
import retrofit2.a.i;
import retrofit2.a.l;

/* compiled from: DaDataApi.kt */
public interface j {
    @i({"Authorization: Token 59280c8e66ebe388014902c0f6dd7c2f70c1c066"})
    @l("suggestions/api/4_1/rs/suggest/party")
    o<DaDataSuggestionListing> a(@a DaDataQueryRequest daDataQueryRequest);
}
