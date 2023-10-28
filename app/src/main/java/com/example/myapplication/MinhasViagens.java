package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.database.dao.ViagemDAO;
import com.example.myapplication.database.model.ViagemModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MinhasViagens extends AppCompatActivity {

    private Button btnVoltar ;
    private ListView listViewMinhasViagens;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minhas_viagens);

        btnVoltar = findViewById(R.id.btnVoltar);
        listViewMinhasViagens = findViewById(R.id.listViewMinhasViagens);

        ViagemDAO viagemDAO = new ViagemDAO(MinhasViagens.this);
        List<ViagemModel> viagens;
        List<String[]> dataList = new ArrayList<>();
        SharedPreferences sharedPreferences = getSharedPreferences("MinhasPreferencias", Context.MODE_PRIVATE);
        int idUsuario = sharedPreferences.getInt("id_usuario", -1);

        {
            try {
                viagens = viagemDAO.SelectAllFromUsuario(idUsuario);
                for(ViagemModel viagem : viagens){
                    String[] viagemData = new String[]{viagem.getDescricao(), String.valueOf(viagem.getId())};
                    dataList.add(viagemData);
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (listViewMinhasViagens != null) {
            MinhasViagensList adapter = new MinhasViagensList(MinhasViagens.this, dataList);
            listViewMinhasViagens.setAdapter(adapter);
        } else {
            Toast.makeText(MinhasViagens.this, "Voce nao tem viagens cadastradas", Toast.LENGTH_LONG).show();
        }
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MinhasViagens.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
