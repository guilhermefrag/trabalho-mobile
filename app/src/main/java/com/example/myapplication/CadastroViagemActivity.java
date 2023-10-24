package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.database.model.ViagemModel;

public class CadastroViagemActivity extends AppCompatActivity {
    private EditText editDescricao, editTotalKm, editKmPorLitro, editCustoMedioLitro, editTotalVeiculos, editAdicionarGasolina;
    private Button btnSalvar, btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_viagem);

        editDescricao = findViewById(R.id.editDescricao);
        editTotalKm = findViewById(R.id.editTotalKm);
        editKmPorLitro = findViewById(R.id.editKmPorLitro);
        editCustoMedioLitro = findViewById(R.id.editCustoMedioLitro);
        editTotalVeiculos = findViewById(R.id.editTotalVeiculos);
        editAdicionarGasolina = findViewById(R.id.editAdicionarGasolina);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnVoltar = findViewById(R.id.btnVoltar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String descricao = editDescricao.getText().toString();
                double totalKm = Double.parseDouble(editTotalKm.getText().toString());
                double kmPorLitro = Double.parseDouble(editKmPorLitro.getText().toString());
                double custoMedioLitro = Double.parseDouble(editCustoMedioLitro.getText().toString());
                int totalVeiculos = Integer.parseInt(editTotalVeiculos.getText().toString());
                int adicionarGasolina = Integer.parseInt(editAdicionarGasolina.getText().toString());

                ViagemModel viagem = new ViagemModel();
                viagem.setDescricao(descricao);
                viagem.setTotalKm(totalKm);
                viagem.setKmPorLitro(kmPorLitro);
                viagem.setCustoMedioLitro(custoMedioLitro);
                viagem.setTotalVeiculos(totalVeiculos);
                viagem.setAdicionarGasolina(adicionarGasolina);

                finish();
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CadastroViagemActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
