package com.example.myapplication.API.model;

import java.io.Serializable;
import java.util.Date;

public class UnescViagemCustoEntretenimento  implements Serializable {

    public static final String TABELA_NOME = "tb_unesc_viagem_custo_entretenimento";
    private String entretenimento;
    private double valor;
    public static final String
            COLUNA_ID = "id",
            COLUNA_ID_CONTA = "id_conta",
            COLUNA_DT_INC = "dt_inc",
            COLUNA_VIAGEM_ID = "viagemId",
            COLUNA_ENTRETENIMENTO = "entretenimento",
            COLUNA_VALOR = "valor",
            COLUNA_ID_USUARIO = "id_usuario";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABELA_NOME + " (" +
                    COLUNA_ID + " BIGINT NOT NULL, " +
                    COLUNA_ID_CONTA + " BIGINT NOT NULL, " +
                    COLUNA_DT_INC + " DATETIME NOT NULL, " +
                    COLUNA_VIAGEM_ID + " INTEGER NOT NULL, " +
                    COLUNA_ENTRETENIMENTO + " TEXT NOT NULL, " +
                    COLUNA_VALOR + " INTEGER NOT NULL, " +
                    COLUNA_ID_USUARIO + " INTEGER DEFAULT 0);";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABELA_NOME + ";";

    public String getEntretenimento() {
        return entretenimento;
    }

    public void setEntretenimento(String entretenimento) {
        this.entretenimento = entretenimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
