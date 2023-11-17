package com.example.myapplication.API.endpoint;

import com.example.myapplication.API.model.Resposta;
import com.example.myapplication.API.model.UnescViagemEnviar;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ViagemEndpoint {
    @GET("api/listar/viagem/{viagemId}")
    Call<Resposta> getViagemPath(@Path("viagemId") int viagemId);


    @GET("api/listar/viagem/{viagemId}")
    Call<Resposta> getViagemQry(@Query("viagemId") int viagemId);


    @POST("api/cadastro/viagem")
    Call<Resposta> postViagem(@Body UnescViagemEnviar unescViagemEnviar);
}
