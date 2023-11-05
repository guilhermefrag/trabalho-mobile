package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.database.dao.EntretenimentoDAO;
import com.example.myapplication.database.model.EntretenimentoModel;

import java.sql.SQLException;
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
        System.out.print("TESTE RAPA");

        SharedPreferences sharedPreferences = getSharedPreferences("MinhasPreferencias", Context.MODE_PRIVATE);
        Long viagemId = sharedPreferences.getLong("viagem_data", -1);

        btnVoltar = findViewById(R.id.btnVoltar);
        idAdicionar = findViewById(R.id.idAdicionar);
        listView = findViewById(R.id.listViewEntretenimento);

        EntretenimentoDAO entretenimentoDAO = new EntretenimentoDAO(this);
        List<EntretenimentoModel> listaEntretenimento;
        try {
            listaEntretenimento = entretenimentoDAO.selectAllFromViagem(Integer.parseInt(viagemId.toString()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        List<String> dataList = new ArrayList<>();

        if(listaEntretenimento.isEmpty()){
            dataList.add("Nenhum entretenimento cadastrado");
        }
        for (EntretenimentoModel entretenimento : listaEntretenimento) {
            dataList.add(entretenimento.getDescricao());
        }


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
