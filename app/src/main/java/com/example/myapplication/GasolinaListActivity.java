package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;

public class GasolinaListActivity extends Activity {

    private Button btnSair;

    public static String converteBooleanParaString(boolean valor) {
        if (valor) {
            return "Sim";
        } else {
            return "Não";
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_lista);

        ListView listView = findViewById(R.id.listView);

        double totalEstimadoKm = 1000;
        double mediaKmPorLitro = 15;
        double custoMedioPorLitro = 4.00;
        int totalVeiculos = 3;
        boolean adicionarAViagem = true;



        ArrayList<String> dataList = new ArrayList<>();
        dataList.add("Total Estimado de Quilômetros: " + totalEstimadoKm + " km");
        dataList.add("Média de Quilômetros por Litro: " + mediaKmPorLitro + " km/L");
        dataList.add("Custo Médio por Litro: R$ " + custoMedioPorLitro + "/L");
        dataList.add("Total de Veículos: " + totalVeiculos + " veículos");
        dataList.add("Adicionar a Viagem? " + converteBooleanParaString(adicionarAViagem));

        double total = (totalEstimadoKm / mediaKmPorLitro) * custoMedioPorLitro * totalVeiculos;
        dataList.add("Total: R$ " + total);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(adapter);

        btnSair = findViewById(R.id.btnSair);
        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GasolinaListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
