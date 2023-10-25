package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.adapter.MinhasViagensList;

import java.util.ArrayList;
import java.util.List;

public class MinhasViagens extends AppCompatActivity {

    private Button btnVoltar;
    private ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minhas_viagens);

        btnVoltar = findViewById(R.id.btnVoltar);
        listView = findViewById(R.id.listViewMinhasViagens);

        List<String> dataList = new ArrayList<>();
        dataList.add("Viagem 1");
        dataList.add("Viagem 2");
        dataList.add("Viagem 3");

        MinhasViagensList adapter = new MinhasViagensList(MinhasViagens.this, dataList);
        listView.setAdapter(adapter);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MinhasViagens.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
