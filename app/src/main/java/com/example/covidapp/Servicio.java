package com.example.covidapp;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface Servicio {
    @POST("api/regiones")
    Call<RespuestaRegionWS> regiones();

    @POST("api/data/nacional")
    Call<RespuestaNacionalWS> nacional();

    @POST("api/data/all")
    Call<RespuestaRegionesWS> regionesTotal();

    @POST
    Call<RespuestaNacionalWS> porRegion(@Url String url );


}
