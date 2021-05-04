package com.genggam.projekfilm;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoService {
   @GET("/")
    Call<MoResponse> getMo();
}
