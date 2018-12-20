package com.maho.upi.pam.Apis;

import com.maho.upi.pam.Model.ModelData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

@SuppressWarnings("ALL")
public interface ApiInterface {


    @GET("bins/fp494")
    Call<List<ModelData>> getPemain(/*@Path("id") String id*/);

}
