package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.database.dao.ViagemDAO;
import com.example.myapplication.database.model.ViagemModel;

public class CadastroViagemActivity extends AppCompatActivity {

    private EditText editDescricao,
            editTotalKm,
            editKmPorLitro,
            editCustoMedioLitro,
            editTotalVeiculos,
            editTotalNoites,
            editCustoNoite,
            editTotalQuartos;
    private CheckBox checkAdicionarGasolina,
            checkAdicionarTarifa,
            checkAdicionarRefeicao,
            checkAdicionarHospedagem;
    private Button btnSalvar,
            btnVoltar;
    private EditText editCustoEstimadoPessoa,
            editAluguelVeiculo,
            editCustoRefeicao,
            editRefeicoesDia,
            editTotalViajantes,
            editDuracaoDias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_viagem);

        editDescricao = findViewById(R.id.editDescricao);
        editTotalKm = findViewById(R.id.editTotalKm);
        editKmPorLitro = findViewById(R.id.editKmPorLitro);
        editCustoMedioLitro = findViewById(R.id.editCustoMedioLitro);
        editTotalVeiculos = findViewById(R.id.editTotalVeiculos);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnVoltar = findViewById(R.id.btnVoltar);
        editCustoEstimadoPessoa = findViewById(R.id.editCustoEstimadoPessoa);
        editAluguelVeiculo = findViewById(R.id.editAluguelVeiculo);
        editCustoRefeicao = findViewById(R.id.editCustoRefeicao);
        editRefeicoesDia = findViewById(R.id.editRefeicoesDia);
        checkAdicionarGasolina = findViewById(R.id.checkAdicionarGasolina);
        checkAdicionarTarifa = findViewById(R.id.checkAdicionarTarifa);
        checkAdicionarRefeicao = findViewById(R.id.checkAdicionarRefeicao);
        checkAdicionarHospedagem = findViewById(R.id.checkAdicionarHospedagem);
        editCustoNoite = findViewById(R.id.editCustoPorNoite);
        editTotalNoites = findViewById(R.id.editTotalNoites);
        editTotalQuartos = findViewById(R.id.editTotalQuartos);
        editTotalViajantes = findViewById(R.id.editTotalViajantes);
        editDuracaoDias = findViewById(R.id.editDuracaoDias);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViagemDAO viagemDAO = new ViagemDAO(CadastroViagemActivity.this);

                String descricao = editDescricao.getText().toString();
                double totalKm = Double.parseDouble(editTotalKm.getText().toString());
                double kmPorLitro = Double.parseDouble(editKmPorLitro.getText().toString());
                double custoMedioLitro = Double.parseDouble(editCustoMedioLitro.getText().toString());
                int totalVeiculos = Integer.parseInt(editTotalVeiculos.getText().toString());
                int totalViajantes = Integer.parseInt(editTotalViajantes.getText().toString());
                int duracaoDias = Integer.parseInt(editDuracaoDias.getText().toString());

                //adicionar os novos campos
                double custoEstimadoPessoa = Double.parseDouble(editCustoEstimadoPessoa.getText().toString());
                double aluguelVeiculo = Double.parseDouble(editAluguelVeiculo.getText().toString());
                double custoRefeicao = Double.parseDouble(editCustoRefeicao.getText().toString());

                SharedPreferences sharedPreferences = getSharedPreferences("MinhasPreferencias", Context.MODE_PRIVATE);
                int idUsuario = sharedPreferences.getInt("id_usuario", -1);

                ViagemModel viagem = new ViagemModel();

                viagem.setDescricao(descricao);
                viagem.setTotalKm(totalKm);
                viagem.setKmPorLitro(kmPorLitro);
                viagem.setCustoMedioLitro(custoMedioLitro);
                viagem.setTotalVeiculos(totalVeiculos);
                viagem.setAdicionarGasolina(viagemDAO.booleanToInteger(checkAdicionarGasolina.isChecked()));
                viagem.setAdicionarTarifaAerea(viagemDAO.booleanToInteger(checkAdicionarTarifa.isChecked()));
                viagem.setAdicionarRefeicoes(viagemDAO.booleanToInteger(checkAdicionarRefeicao.isChecked()));
                viagem.setAdicionarHospedagem(viagemDAO.booleanToInteger(checkAdicionarHospedagem.isChecked()));
                viagem.setCustoTarifaPessoa(custoEstimadoPessoa);
                viagem.setAluguelVeiculo(aluguelVeiculo);
                viagem.setCustoRefeicao(custoRefeicao);
                viagem.setRefeicoesDia(Integer.parseInt(editRefeicoesDia.getText().toString()));
                viagem.setCustoNoite(Double.parseDouble(editCustoNoite.getText().toString()));
                viagem.setTotalNoites(Integer.parseInt(editTotalNoites.getText().toString()));
                viagem.setTotalQuartos(Integer.parseInt(editTotalQuartos.getText().toString()));
                viagem.setTotalViajantes(totalViajantes);
                viagem.setDuracaoDias(duracaoDias);

                //pegar da view depois
                viagem.setIdUsuario(idUsuario);

                try {
                    viagemDAO.Insert(viagem);
                    Intent intent = new Intent(CadastroViagemActivity.this, MainActivity.class);
                    Toast.makeText(CadastroViagemActivity.this, "Cadastro de Viagem realizado com sucesso", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(CadastroViagemActivity.this, "" + e.toString(), Toast.LENGTH_LONG).show();
                }
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
