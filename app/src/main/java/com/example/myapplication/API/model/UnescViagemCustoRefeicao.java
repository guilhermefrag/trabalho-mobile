package com.example.myapplication.API.model;

import java.io.Serializable;
import java.util.Date;

public class UnescViagemCustoRefeicao implements Serializable {
    public static final String TABELA_NOME = "tb_unesc_viagem_custo_refeicao";
    private double custoRefeicao;
    private int refeicoesDia;

    public static final String
            COLUNA_ID = "id",
            COLUNA_ID_CONTA = "id_conta",
            COLUNA_DT_INC = "dt_inc",
            COLUNA_VIAGEM_ID = "viagemId",
            COLUNA_CUSTO_REFEICAO = "custoRefeicao",
            COLUNA_REFEICOES_DIA = "refeicoesDia",
            COLUNA_ID_USUARIO = "id_usuario";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABELA_NOME + " (" +
                    COLUNA_ID + " BIGINT NOT NULL, " +
                    COLUNA_ID_CONTA + " BIGINT NOT NULL, " +
                    COLUNA_DT_INC + " DATETIME NOT NULL, " +
                    COLUNA_VIAGEM_ID + " INTEGER NOT NULL, " +
                    COLUNA_CUSTO_REFEICAO + " DOUBLE NOT NULL, " +
                    COLUNA_REFEICOES_DIA + " INTEGER NOT NULL, " +
                    COLUNA_ID_USUARIO + " INTEGER DEFAULT 0);";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABELA_NOME + ";";

    public double getCustoRefeicao() {
        return custoRefeicao;
    }

    public void setCustoRefeicao(double custoRefeicao) {
        this.custoRefeicao = custoRefeicao;
    }

    public int getRefeicoesDia() {
        return refeicoesDia;
    }

    public void setRefeicoesDia(int refeicoesDia) {
        this.refeicoesDia = refeicoesDia;
    }
}
