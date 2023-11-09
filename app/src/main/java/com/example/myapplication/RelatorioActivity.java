package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.database.dao.EntretenimentoDAO;
import com.example.myapplication.database.dao.ViagemDAO;
import com.example.myapplication.database.model.EntretenimentoModel;
import com.example.myapplication.database.model.ViagemModel;

import java.sql.SQLException;
import java.util.List;

public class RelatorioActivity extends AppCompatActivity {
    Button btnVoltarDoRel;
    TextView texTotalViajantes,
            textDuracaoViagem,
            textCustoTotal,
            textCustoPorPessoa;

    EditText editTotalGasolina,
            editTotalTarifaAerea,
            editTotalRefeicoes,
            editTotalHospedagem,
            editTotalEntretenimento;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_relatorio);
        SharedPreferences sharedPreferences = getSharedPreferences("MinhasPreferencias", Context.MODE_PRIVATE);

        btnVoltarDoRel = findViewById(R.id.btnVoltarDoRel);

        Long viagemId = sharedPreferences.getLong("viagem_data", -1);

        ViagemDAO viagemDAO = new ViagemDAO(getBaseContext());
        ViagemModel viagem;
        EntretenimentoDAO entretenimentoDAO = new EntretenimentoDAO(this);
        List<EntretenimentoModel> listaEntretenimento;
        try {
            viagem = viagemDAO.retrieve(viagemId.toString()).get(0);
            listaEntretenimento = entretenimentoDAO.selectAllFromViagem(Integer.parseInt(viagemId.toString()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        texTotalViajantes = findViewById(R.id.textTotalViajantes);
        textDuracaoViagem = findViewById(R.id.textDuracaoViagem);
        textCustoTotal = findViewById(R.id.textCustoTotal);
        textCustoPorPessoa = findViewById(R.id.textCustoPorPessoa);
        editTotalGasolina = findViewById(R.id.editTotalGasolina);
        editTotalTarifaAerea = findViewById(R.id.editTotalTarifaAerea);
        editTotalRefeicoes = findViewById(R.id.editTotalRefeicoes);
        editTotalHospedagem = findViewById(R.id.editTotalHospedagem);
        editTotalEntretenimento = findViewById(R.id.editTotalEntretenimento);

        double totalGasolina = viagem.getAdicionarGasolina() > 0
                ? Calculos.custoTotalGasolina(viagem.getTotalKm(), viagem.getKmPorLitro(), viagem.getCustoMedioLitro(), viagem.getTotalVeiculos())
                : 0;

        double totalTarifaAerea = viagem.getAdicionarTarifaAerea() > 0
                ? Calculos.custoTotalTarifaAerea(viagem.getCustoTarifaPessoa(), viagem.getTotalViajantes(), viagem.getAluguelVeiculo())
                : 0;

        double totalRefeicoes = viagem.getAdicionarRefeicoes() > 0
                ? Calculos.custoTotalRefeicoes(viagem.getRefeicoesDia(), viagem.getTotalViajantes(), viagem.getCustoRefeicao(), viagem.getDuracaoDias())
                : 0;

        double totalHospedagem = viagem.getAdicionarHospedagem() > 0
                ? Calculos.custoTotalHospedagem(viagem.getCustoNoite(), viagem.getTotalNoites(), viagem.getTotalQuartos())
                : 0;

        double totalEntretenimento = 0;

        if (!listaEntretenimento.isEmpty()) {
            for (EntretenimentoModel entretenimentoModel : listaEntretenimento) {
                totalEntretenimento += entretenimentoModel.getCusto();
            }
        }

        double custoTotalViagem = totalGasolina + totalTarifaAerea + totalRefeicoes + totalHospedagem + totalEntretenimento;
        double custoPorPessoa = custoTotalViagem / viagem.getTotalViajantes();

        texTotalViajantes.setText("Total de viajantes: " + viagem.getTotalViajantes());
        textDuracaoViagem.setText("Duração: " + viagem.getDuracaoDias() + " dias");
        textCustoTotal.setText("Custo total: " + custoTotalViagem);
        textCustoPorPessoa.setText("Custo por pessoa: " + custoPorPessoa);
        editTotalGasolina.setText("" + totalGasolina);
        editTotalTarifaAerea.setText("" + totalTarifaAerea);
        editTotalRefeicoes.setText("" + totalRefeicoes);
        editTotalHospedagem.setText("" + totalHospedagem);
        editTotalEntretenimento.setText("" + totalEntretenimento);
        btnVoltarDoRel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RelatorioActivity.this, MinhasViagens.class);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.remove("viagem_data");
                editor.apply();
                startActivity(intent);
            }
        });
    }
}
