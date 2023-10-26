package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.database.dao.ViagemDAO;
import com.example.myapplication.database.model.ViagemModel;

public class CadastroViagemActivity extends AppCompatActivity {
    private EditText editDescricao,
            editTotalKm,
            editKmPorLitro,
            editCustoMedioLitro,
            editTotalVeiculos,
            editAdicionarGasolina,
            editCustoEstimadoPessoa,
            editAluguelVeiculo,
            editCustoRefeicao,
            editRefeicoesDia;
    private Button btnSalvar, btnSair;

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
        btnSair = findViewById(R.id.btnSair);
        editCustoEstimadoPessoa = findViewById(R.id.editCustoEstimadoPessoa);
        editAluguelVeiculo = findViewById(R.id.editAluguelVeiculo);
        editCustoRefeicao = findViewById(R.id.editCustoRefeicao);
        editRefeicoesDia = findViewById(R.id.editRefeicoesDia);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String descricao = editDescricao.getText().toString();
                double totalKm = Double.parseDouble(editTotalKm.getText().toString());
                double kmPorLitro = Double.parseDouble(editKmPorLitro.getText().toString());
                double custoMedioLitro = Double.parseDouble(editCustoMedioLitro.getText().toString());
                int totalVeiculos = Integer.parseInt(editTotalVeiculos.getText().toString());

                //adicionar os novos campos
                double custoEstimadoPessoa = Double.parseDouble(editCustoEstimadoPessoa.getText().toString());
                double aluguelVeiculo = Double.parseDouble(editAluguelVeiculo.getText().toString());
                double custoRefeicao = Double.parseDouble(editCustoRefeicao.getText().toString());

                ViagemModel viagem = new ViagemModel();

                viagem.setDescricao(descricao);
                viagem.setTotalKm(totalKm);
                viagem.setKmPorLitro(kmPorLitro);
                viagem.setCustoMedioLitro(custoMedioLitro);
                viagem.setTotalVeiculos(totalVeiculos);
                viagem.setAdicionarGasolina(1);
                viagem.setCustoTarifaPessoa(custoEstimadoPessoa);
                viagem.setAluguelVeiculo(aluguelVeiculo);
                viagem.setCustoRefeicao(custoRefeicao);
                viagem.setRefeicoesDia(1);

                //pegar da view depois
                viagem.setAdicionarGasolina(1);
                viagem.setAdicionarHospedagem(1);
                viagem.setAdicionarRefeicoes(1);
                viagem.setAdicionarTarifaAerea(1);

                ViagemDAO viagemDAO = new ViagemDAO(CadastroViagemActivity.this);

                try {
                    viagemDAO.Insert(viagem);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CadastroViagemActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
