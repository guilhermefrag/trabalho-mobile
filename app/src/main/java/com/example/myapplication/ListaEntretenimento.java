package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ListaEntretenimento extends AppCompatActivity {

    private Button btnVoltar;
    private LinearLayout idAdicionar;
    private ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_entretenimento);

        btnVoltar = findViewById(R.id.btnVoltar);
        idAdicionar = findViewById(R.id.idAdicionar);
        listView = findViewById(R.id.listViewEntretenimento);

        List<String> dataList = new ArrayList<>();
        dataList.add("Entretenimento 1");
        dataList.add("Entretenimento 2");
        dataList.add("Entretenimento 3");
        dataList.add("Entretenimento 4");
        dataList.add("Entretenimento 5");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(adapter);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaEntretenimento.this, MinhasViagens.class);
                startActivity(intent);
            }
        });

        idAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaEntretenimento.this, CadastroEntretenimento.class);
                startActivity(intent);
            }
        });


    }
}
