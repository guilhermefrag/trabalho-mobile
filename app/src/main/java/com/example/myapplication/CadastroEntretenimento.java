package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.database.dao.EntretenimentoDAO;
import com.example.myapplication.database.model.EntretenimentoModel;

import java.sql.SQLException;

public class CadastroEntretenimento extends AppCompatActivity {

    private Button btnVoltar, btnSalvar;

    private TextView editDescricaoEntretenimento, editCusto, editTotalDeNoites;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_entretenimento);

        SharedPreferences sharedPreferences = getSharedPreferences("MinhasPreferencias", Context.MODE_PRIVATE);
        Long viagemId = sharedPreferences.getLong("viagem_data", -1);

        btnVoltar = findViewById(R.id.btnVoltar);
        btnSalvar = findViewById(R.id.btnSalvar);
        editCusto = findViewById(R.id.editCusto);
        editDescricaoEntretenimento = findViewById(R.id.editDescricaoEntretenimento);
        editTotalDeNoites = findViewById(R.id.editTotalDeNoites);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EntretenimentoDAO entretenimentoDAO = new EntretenimentoDAO(CadastroEntretenimento.this);

                float custo = Float.parseFloat(editCusto.getText().toString());
                String descricao = editDescricaoEntretenimento.getText().toString();
                int totalDeNoites = Integer.parseInt(editTotalDeNoites.getText().toString());

                EntretenimentoModel entretenimentoModel = new EntretenimentoModel();
                entretenimentoModel.setCusto(custo);
                entretenimentoModel.setDescricao(descricao);
                entretenimentoModel.setTotalDeNoites(totalDeNoites);
                entretenimentoModel.setViagemId(Integer.parseInt(viagemId.toString()));

                try {
                    entretenimentoDAO.Insert(entretenimentoModel);
                    Intent intent = new Intent(CadastroEntretenimento.this, ListaEntretenimento.class);
                    Toast.makeText( CadastroEntretenimento.this, "Cadastro de Entretenimento realizado com sucesso", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                } catch (SQLException e) {
                    Toast.makeText( CadastroEntretenimento.this, "Nao foi possivel cadastrar o entretenimento", Toast.LENGTH_LONG).show();
                    throw new RuntimeException(e);
                }
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CadastroEntretenimento.this, ListaEntretenimento.class);
                startActivity(intent);
            }
        });
    }
}
