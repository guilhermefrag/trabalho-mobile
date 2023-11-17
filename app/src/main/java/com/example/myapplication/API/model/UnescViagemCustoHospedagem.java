package com.example.myapplication.API.model;

import java.io.Serializable;
import java.util.Date;

public class UnescViagemCustoHospedagem implements Serializable {

    public static final String TABELA_NOME = "tb_unesc_viagem_custo_hospedagem";
    private double custoMedioNoite;
    private int totalNoite;
    private int totalQuartos;

    public static final String
            COLUNA_ID = "id",
            COLUNA_ID_CONTA = "id_conta",
            COLUNA_DT_INC = "dt_inc",
            COLUNA_VIAGEM_ID = "viagemId",
            COLUNA_CUSTO_MEDIO_NOITE = "custoMedioNoite",
            COLUNA_TOTAL_NOITE = "totalNoite",
            COLUNA_TOTAL_QUARTOS = "totalQuartos",
            COLUNA_ID_USUARIO = "id_usuario";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABELA_NOME + " (" +
                    COLUNA_ID + " BIGINT NOT NULL, " +
                    COLUNA_ID_CONTA + " BIGINT NOT NULL, " +
                    COLUNA_DT_INC + " DATETIME NOT NULL, " +
                    COLUNA_VIAGEM_ID + " INTEGER NOT NULL, " +
                    COLUNA_CUSTO_MEDIO_NOITE + " DOUBLE NOT NULL, " +
                    COLUNA_TOTAL_NOITE + " INTEGER NOT NULL, " +
                    COLUNA_TOTAL_QUARTOS + " INTEGER NOT NULL, " +
                    COLUNA_ID_USUARIO + " INTEGER DEFAULT 0);";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABELA_NOME + ";";
    public double getCustoMedioNoite() {
        return custoMedioNoite;
    }

    public void setCustoMedioNoite(double custoMedioNoite) {
        this.custoMedioNoite = custoMedioNoite;
    }

    public int getTotalNoite() {
        return totalNoite;
    }

    public void setTotalNoite(int totalNoite) {
        this.totalNoite = totalNoite;
    }

    public int getTotalQuartos() {
        return totalQuartos;
    }

    public void setTotalQuartos(int totalQuartos) {
        this.totalQuartos = totalQuartos;
    }
}
