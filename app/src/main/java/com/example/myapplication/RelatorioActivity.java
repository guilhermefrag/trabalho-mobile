package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.API.Api;
import com.example.myapplication.API.model.Resposta;
import com.example.myapplication.API.model.UnescViagemCustoAereo;
import com.example.myapplication.API.model.UnescViagemCustoEntretenimento;
import com.example.myapplication.API.model.UnescViagemCustoGasolina;
import com.example.myapplication.API.model.UnescViagemCustoHospedagem;
import com.example.myapplication.API.model.UnescViagemCustoRefeicao;
import com.example.myapplication.API.model.UnescViagemEnviar;
import com.example.myapplication.database.dao.EntretenimentoDAO;
import com.example.myapplication.database.dao.ViagemDAO;
import com.example.myapplication.database.model.EntretenimentoModel;
import com.example.myapplication.database.model.ViagemModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RelatorioActivity extends AppCompatActivity {
    Button btnVoltarDoRel,
            btnSincronizar;
    TextView texTotalViajantes,
            textDuracaoViagem,
            textCustoTotal,
            textCustoPorPessoa;

    EditText editTotalGasolina,
            editTotalTarifaAerea,
            editTotalRefeicoes,
            editTotalHospedagem,
            editTotalEntretenimento;

    ViagemModel viagemModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_relatorio);
        SharedPreferences sharedPreferences = getSharedPreferences("MinhasPreferencias", Context.MODE_PRIVATE);

        btnVoltarDoRel = findViewById(R.id.btnVoltarDoRel);
        btnSincronizar = findViewById(R.id.btnSincronizar);

        Long viagemId = sharedPreferences.getLong("viagem_data", -1);

        ViagemDAO viagemDAO = new ViagemDAO(getBaseContext());
        ViagemModel viagem;
        EntretenimentoDAO entretenimentoDAO = new EntretenimentoDAO(this);
        List<EntretenimentoModel> listaEntretenimentos;
        try {
            viagem = viagemDAO.retrieve(viagemId.toString()).get(0);
            listaEntretenimentos = entretenimentoDAO.selectAllFromViagem(Integer.parseInt(viagemId.toString()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        setViagemModel(viagemModel);

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

        if (!listaEntretenimentos.isEmpty()) {
            for (EntretenimentoModel entretenimentoModel : listaEntretenimentos) {
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
        btnSincronizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UnescViagemEnviar enviarViagem = new UnescViagemEnviar();
                UnescViagemCustoGasolina gasolina = new UnescViagemCustoGasolina();
                UnescViagemCustoRefeicao refeicao = new UnescViagemCustoRefeicao();
                UnescViagemCustoAereo aereo = new UnescViagemCustoAereo();
                UnescViagemCustoHospedagem hospedagem = new UnescViagemCustoHospedagem();
                List<UnescViagemCustoEntretenimento> listaEntretenimento = new ArrayList<UnescViagemCustoEntretenimento>();

                enviarViagem.setIdConta(120958);

                gasolina.setCustoMedioLitro(viagem.getCustoMedioLitro());
                gasolina.setCustoPorPessoa(totalGasolina > 0
                        ? totalGasolina / viagem.getTotalViajantes()
                        : 0);
                gasolina.setTotalEstimadoKM(viagem.getTotalKm());
                gasolina.setMediaKMLitro(viagem.getKmPorLitro());

                refeicao.setCustoRefeicao(viagem.getCustoRefeicao());
                refeicao.setRefeicoesDia(viagem.getRefeicoesDia());

                aereo.setCustoPessoa(viagem.getCustoTarifaPessoa());
                aereo.setCustoAluguelVeiculo(viagem.getAluguelVeiculo());

                hospedagem.setTotalNoite(viagem.getTotalNoites());
                hospedagem.setTotalQuartos(viagem.getTotalQuartos());
                hospedagem.setCustoMedioNoite(viagem.getCustoNoite());

                for (EntretenimentoModel entretenimentoModel : listaEntretenimentos) {
                    UnescViagemCustoEntretenimento entretenimento = new UnescViagemCustoEntretenimento();

                    entretenimento.setEntretenimento(entretenimentoModel.getDescricao());
                    entretenimento.setValor(entretenimentoModel.getCusto());
                    listaEntretenimento.add(entretenimento);
                }

                enviarViagem.setTotalViajantes(viagem.getTotalViajantes());
                enviarViagem.setDuracaoViagem(viagem.getDuracaoDias());
                enviarViagem.setCustoTotalViagem(custoTotalViagem);
                enviarViagem.setCustoPorPessoa(custoPorPessoa);
                enviarViagem.setLocal(viagem.getDescricao());

                enviarViagem.setRefeicao(refeicao);
                enviarViagem.setAereo(aereo);
                enviarViagem.setGasolina(gasolina);
                enviarViagem.setHospedagem(hospedagem);
                enviarViagem.setListaEntretenimento(listaEntretenimento);

                Api.postViagem(enviarViagem, new Callback<Resposta>() {
                    @Override
                    public void onResponse(Call<Resposta> call, Response<Resposta> response) {
                        if(response != null && response.isSuccessful()){
                            Resposta resposta = response.body();

                            if(resposta.isSucesso()){
                                Toast.makeText(RelatorioActivity.this, "Sucesso dos guri", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(RelatorioActivity.this, "O maior fracasso", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Resposta> call, Throwable t) {

                    }
                });
            }
        });
    }

    public void setViagemModel(ViagemModel viagemModel) {
        this.viagemModel = viagemModel;
    }
}
