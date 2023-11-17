package com.example.myapplication.API;

import com.example.myapplication.API.endpoint.ViagemEndpoint;
import com.example.myapplication.API.model.Resposta;
import com.example.myapplication.API.model.UnescViagemEnviar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    private static final String URL_ROOT = "http://api.genialsaude.com.br/";
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL_ROOT)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static void getViagem(final Callback<Resposta> callback){
        ViagemEndpoint viagemEndpoint = retrofit.create(ViagemEndpoint.class);
        Call<Resposta> call = viagemEndpoint.getViagemPath(1);
        call.enqueue(callback);
    }

    public static void postViagem(UnescViagemEnviar viagem, final Callback<Resposta> callback){
        ViagemEndpoint viagemEndpoint = retrofit.create(ViagemEndpoint.class);
        Call<Resposta> call = viagemEndpoint.postViagem(viagem);
        call.enqueue(callback);
    }
}