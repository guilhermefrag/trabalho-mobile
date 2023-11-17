package com.example.myapplication.API.model;

import java.io.Serializable;
import java.util.Date;

public class UnescViagem implements Serializable {
    public static final String TABELA_NOME = "tb_unesc_viagem";

    private long id;
    private long idConta;
    private Date dataInclusao;
    private int totalViajantes;
    private Integer duracaoViagem;
    private double custoTotalViagem;
    private double custoPorPessoa;
    private String local;
    private int idUsuario;

    public static final String
            COLUNA_ID = "id",
            COLUNA_ID_CONTA = "id_conta",
            COLUNA_DT_INC = "dt_inc",
            COLUNA_TOTAL_VIAJANTES = "totalViajantes",
            COLUNA_DURACAO_VIAGEM = "duracaoViagem",
            COLUNA_CUSTO_TOTAL_VIAGEM = "custoTotalViagem",
            COLUNA_CUSTO_POR_PESSOA = "custoPorPessoa",
            COLUNA_LOCAL = "local",
            COLUNA_ID_USUARIO = "id_usuario";


    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABELA_NOME + " (" +
                    COLUNA_ID + " BIGINT NOT NULL, " +
                    COLUNA_ID_CONTA + " BIGINT NOT NULL, " +
                    COLUNA_DT_INC + " DATETIME NOT NULL, " +
                    COLUNA_TOTAL_VIAJANTES + " INTEGER NOT NULL, " +
                    COLUNA_DURACAO_VIAGEM + " INTEGER, " +
                    COLUNA_CUSTO_TOTAL_VIAGEM + " DOUBLE NOT NULL, " +
                    COLUNA_CUSTO_POR_PESSOA + " DOUBLE NOT NULL, " +
                    COLUNA_LOCAL + " TEXT NOT NULL, " +
                    COLUNA_ID_USUARIO + " INTEGER DEFAULT 99);";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABELA_NOME + ";";


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdConta() {
        return idConta;
    }

    public void setIdConta(long idConta) {
        this.idConta = idConta;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public int getTotalViajantes() {
        return totalViajantes;
    }

    public void setTotalViajantes(int totalViajantes) {
        this.totalViajantes = totalViajantes;
    }

    public Integer getDuracaoViagem() {
        return duracaoViagem;
    }

    public void setDuracaoViagem(Integer duracaoViagem) {
        this.duracaoViagem = duracaoViagem;
    }

    public double getCustoTotalViagem() {
        return custoTotalViagem;
    }

    public void setCustoTotalViagem(double custoTotalViagem) {
        this.custoTotalViagem = custoTotalViagem;
    }

    public double getCustoPorPessoa() {
        return custoPorPessoa;
    }

    public void setCustoPorPessoa(double custoPorPessoa) {
        this.custoPorPessoa = custoPorPessoa;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
