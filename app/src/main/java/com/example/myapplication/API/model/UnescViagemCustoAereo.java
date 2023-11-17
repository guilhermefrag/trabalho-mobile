package com.example.myapplication.API.model;

import java.io.Serializable;
import java.util.Date;

public class UnescViagemCustoAereo implements Serializable {

    public static final String TABELA_NOME = "tb_unesc_viagem_custo_aereo";

    private double custoPessoa;
    private double custoAluguelVeiculo;

    public static final String
            COLUNA_ID = "id",
            COLUNA_ID_CONTA = "id_conta",
            COLUNA_DT_INC = "dt_inc",
            COLUNA_VIAGEM_ID = "viagemId",
            COLUNA_CUSTO_PESSOA = "custoPessoa",
            COLUNA_CUSTO_ALUGUEL_VEICULO = "custoAluguelVeiculo",
            COLUNA_ID_USUARIO = "id_usuario";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABELA_NOME + " (" +
                    COLUNA_ID + " BIGINT NOT NULL, " +
                    COLUNA_ID_CONTA + " BIGINT NOT NULL, " +
                    COLUNA_DT_INC + " DATETIME NOT NULL, " +
                    COLUNA_VIAGEM_ID + " INTEGER NOT NULL, " +
                    COLUNA_CUSTO_PESSOA + " DOUBLE NOT NULL, " +
                    COLUNA_CUSTO_ALUGUEL_VEICULO + " DOUBLE NOT NULL, " +
                    COLUNA_ID_USUARIO + " INTEGER DEFAULT 0);";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABELA_NOME + ";";

    public double getCustoPessoa() {
        return custoPessoa;
    }

    public void setCustoPessoa(double custoPessoa) {
        this.custoPessoa = custoPessoa;
    }

    public double getCustoAluguelVeiculo() {
        return custoAluguelVeiculo;
    }

    public void setCustoAluguelVeiculo(double custoAluguelVeiculo) {
        this.custoAluguelVeiculo = custoAluguelVeiculo;
    }
}
