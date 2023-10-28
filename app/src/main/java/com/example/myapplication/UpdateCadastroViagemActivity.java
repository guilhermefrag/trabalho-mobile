package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.database.dao.ViagemDAO;
import com.example.myapplication.database.model.ViagemModel;

import java.net.URISyntaxException;
import java.sql.SQLException;

public class UpdateCadastroViagemActivity extends AppCompatActivity {
    private EditText editDescricao,
            editTotalKm,
            editKmPorLitro,
            editCustoMedioLitro,
            editTotalVeiculos,
            editTotalNoites,
            editCustoNoite,
            editTotalQuartos;
    private CheckBox checkAdicionarGasolina, checkAdicionarTarifa, checkAdicionarRefeicao, checkAdicionarHospedagem;
    private Button btnSalvar, btnVoltar;
    private EditText editCustoEstimadoPessoa,
            editAluguelVeiculo,
            editCustoRefeicao,
            editRefeicoesDia;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_viagem);
        SharedPreferences sharedPreferences = getSharedPreferences("MinhasPreferencias", Context.MODE_PRIVATE);

        btnSalvar = findViewById(R.id.btnSalvar);
        btnSalvar.setText("Atualizar");
        btnVoltar = findViewById(R.id.btnVoltar);

        Long viagemId = sharedPreferences.getLong("viagem_data", -1);

        ViagemDAO viagemDAO = new ViagemDAO(getBaseContext());
        ViagemModel viagem;
        try {
            viagem = viagemDAO.retrieve(viagemId.toString()).get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        editDescricao = findViewById(R.id.editDescricao);
        editTotalKm = findViewById(R.id.editTotalKm);
        editKmPorLitro = findViewById(R.id.editKmPorLitro);
        editCustoMedioLitro = findViewById(R.id.editCustoMedioLitro);
        editTotalVeiculos = findViewById(R.id.editTotalVeiculos);
        checkAdicionarGasolina = findViewById(R.id.checkAdicionarGasolina);
        editCustoEstimadoPessoa = findViewById(R.id.editCustoEstimadoPessoa);
        editAluguelVeiculo = findViewById(R.id.editAluguelVeiculo);
        editCustoRefeicao = findViewById(R.id.editCustoRefeicao);
        editRefeicoesDia = findViewById(R.id.editRefeicoesDia);
        editTotalNoites = findViewById(R.id.editTotalNoites);
        editCustoNoite = findViewById(R.id.editCustoPorNoite);
        editTotalQuartos = findViewById(R.id.editTotalQuartos);
        checkAdicionarGasolina = findViewById(R.id.checkAdicionarGasolina);
        checkAdicionarTarifa = findViewById(R.id.checkAdicionarTarifa);
        checkAdicionarRefeicao = findViewById(R.id.checkAdicionarRefeicao);
        checkAdicionarHospedagem = findViewById(R.id.checkAdicionarHospedagem);


        editDescricao.setText(""+viagem.getDescricao());
        editTotalKm.setText("" + viagem.getTotalKm());
        editKmPorLitro.setText("" + viagem.getKmPorLitro());
        editCustoMedioLitro.setText("" + viagem.getCustoMedioLitro());
        editTotalVeiculos.setText("" + viagem.getTotalVeiculos());
        editCustoEstimadoPessoa.setText("" + viagem.getCustoTarifaPessoa());
        editAluguelVeiculo.setText("" + viagem.getAluguelVeiculo());
        editCustoRefeicao.setText("" + viagem.getCustoRefeicao());
        editRefeicoesDia.setText("" + viagem.getRefeicoesDia());
        editTotalNoites.setText("" + viagem.getTotalNoites());
        editCustoNoite.setText("" + viagem.getCustoNoite());
        editTotalQuartos.setText("" + viagem.getTotalQuartos());
        checkAdicionarGasolina.setChecked(viagemDAO.integerToBoolean(viagem.getAdicionarGasolina()));
        checkAdicionarTarifa.setChecked(viagemDAO.integerToBoolean(viagem.getAdicionarTarifaAerea()));
        checkAdicionarRefeicao.setChecked(viagemDAO.integerToBoolean(viagem.getAdicionarRefeicoes()));
        checkAdicionarHospedagem.setChecked(viagemDAO.integerToBoolean(viagem.getAdicionarHospedagem()));

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViagemDAO viagemDAO = new ViagemDAO(UpdateCadastroViagemActivity.this);

                String descricao = editDescricao.getText().toString();
                double totalKm = Double.parseDouble(editTotalKm.getText().toString());
                double kmPorLitro = Double.parseDouble(editKmPorLitro.getText().toString());
                double custoMedioLitro = Double.parseDouble(editCustoMedioLitro.getText().toString());
                int totalVeiculos = Integer.parseInt(editTotalVeiculos.getText().toString());
                double custoEstimadoPessoa = Double.parseDouble(editCustoEstimadoPessoa.getText().toString());
                double aluguelVeiculo = Double.parseDouble(editAluguelVeiculo.getText().toString());
                double custoRefeicao = Double.parseDouble(editCustoRefeicao.getText().toString());

                SharedPreferences sharedPreferences = getSharedPreferences("MinhasPreferencias", Context.MODE_PRIVATE);
                int idUsuario = sharedPreferences.getInt("id_usuario", -1);

                ViagemModel viagemUpdate = new ViagemModel();
                viagemUpdate.setId(viagem.getId());
                viagemUpdate.setDescricao(descricao);
                viagemUpdate.setTotalKm(totalKm);
                viagemUpdate.setKmPorLitro(kmPorLitro);
                viagemUpdate.setCustoMedioLitro(custoMedioLitro);
                viagemUpdate.setTotalVeiculos(totalVeiculos);
                viagemUpdate.setAdicionarGasolina(viagemDAO.booleanToInteger(checkAdicionarGasolina.isChecked()));
                viagemUpdate.setAdicionarTarifaAerea(viagemDAO.booleanToInteger(checkAdicionarTarifa.isChecked()));
                viagemUpdate.setAdicionarRefeicoes(viagemDAO.booleanToInteger(checkAdicionarRefeicao.isChecked()));
                viagemUpdate.setAdicionarHospedagem(viagemDAO.booleanToInteger(checkAdicionarHospedagem.isChecked()));
                viagemUpdate.setCustoTarifaPessoa(custoEstimadoPessoa);
                viagemUpdate.setAluguelVeiculo(aluguelVeiculo);
                viagemUpdate.setCustoRefeicao(custoRefeicao);
                viagemUpdate.setRefeicoesDia(Integer.parseInt(editRefeicoesDia.getText().toString()));
                viagemUpdate.setIdUsuario(idUsuario);

                try {
                    viagemDAO.Update(viagemUpdate);
                    Intent intent = new Intent(UpdateCadastroViagemActivity.this, MinhasViagens.class);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.remove("viagem_data");
                    editor.apply();
                    Toast.makeText(UpdateCadastroViagemActivity.this, "Atualizacao de Viagem realizado com sucesso", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }catch (Exception e) {
                    Toast.makeText(UpdateCadastroViagemActivity.this, "" + e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateCadastroViagemActivity.this, MinhasViagens.class);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.remove("viagem_data");
                editor.apply();
                startActivity(intent);
            }
        });
    }

}