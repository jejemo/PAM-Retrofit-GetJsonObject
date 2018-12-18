package com.maho.upi.pam.Apis;

import com.maho.upi.pam.Model.ModelData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

@SuppressWarnings("ALL")
public interface ApiInterface {


    @GET("bins/vpmvs")
    Call<ModelData> getPemain(/*@Path("id") String id*/);

}
