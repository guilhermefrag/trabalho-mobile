package com.example.myapplication.API.model;

import java.io.Serializable;
import java.util.Date;

public class UnescViagemCustoGasolina implements Serializable {
    public static final String TABELA_NOME = "tb_unesc_viagem_custo_gasolina";
    private double totalEstimadoKM;
    private double mediaKMLitro;
    private double custoMedioLitro;
    private double custoPorPessoa;

    public static final String
            COLUNA_ID = "id",
            COLUNA_ID_CONTA = "id_conta",
            COLUNA_DT_INC = "dt_inc",
            COLUNA_VIAGEM_ID = "viagemId",
            COLUNA_TOTAL_ESTIMADO_KM = "totalEstimadoKM",
            COLUNA_MEDIA_KM_LITRO = "mediaKMLitro",
            COLUNA_CUSTO_MEDIO_LITRO = "custoMedioLitro",
            COLUNA_TOTAL_VEICULOS = "totalVeiculos",
            COLUNA_ID_USUARIO = "id_usuario";

    // ... (other constants, if needed)

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABELA_NOME + " (" +
                    COLUNA_ID + " BIGINT NOT NULL, " +
                    COLUNA_ID_CONTA + " BIGINT NOT NULL, " +
                    COLUNA_DT_INC + " DATETIME NOT NULL, " +
                    COLUNA_VIAGEM_ID + " INTEGER NOT NULL, " +
                    COLUNA_TOTAL_ESTIMADO_KM + " INTEGER NOT NULL, " +
                    COLUNA_MEDIA_KM_LITRO + " DOUBLE NOT NULL, " +
                    COLUNA_CUSTO_MEDIO_LITRO + " DOUBLE NOT NULL, " +
                    COLUNA_TOTAL_VEICULOS + " INTEGER NOT NULL, " +
                    COLUNA_ID_USUARIO + " INTEGER DEFAULT 0);";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABELA_NOME + ";";


    public double getTotalEstimadoKM() {
        return totalEstimadoKM;
    }

    public void setTotalEstimadoKM(double totalEstimadoKM) {
        this.totalEstimadoKM = totalEstimadoKM;
    }

    public double getMediaKMLitro() {
        return mediaKMLitro;
    }

    public void setMediaKMLitro(double mediaKMLitro) {
        this.mediaKMLitro = mediaKMLitro;
    }

    public double getCustoMedioLitro() {
        return custoMedioLitro;
    }

    public void setCustoMedioLitro(double custoMedioLitro) {
        this.custoMedioLitro = custoMedioLitro;
    }

    public void setCustoPorPessoa(double custoPorPessoa) {
        this.custoPorPessoa = custoPorPessoa;
    }

    public double getCustoPorPessoa() {
        return custoPorPessoa;
    }
}
