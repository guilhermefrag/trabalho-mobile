package com.example.myapplication.database.model;

public class EntretenimentoModel {

    public static final String TABELA_NOME = "entretenimento";
    private long id;
    private String descricao;
    private float custo;
    private int totalDeNoites;
    private int viagemId;

    public static final String
            COLUNA_ID = "_id",
            COLUNA_DESCRICAO = "descricao",
            COLUNA_CUSTO = "custo",
            COLUNA_TOTAL_DE_NOITES = "total_de_noites",
            COLUNA_VIAGEM_ID = "viagem_id";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABELA_NOME + " (" +
                    COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUNA_DESCRICAO + " TEXT NOT NULL, " +
                    COLUNA_CUSTO + " REAL NOT NULL, " +
                    COLUNA_TOTAL_DE_NOITES + " INTEGER," +
                    COLUNA_VIAGEM_ID + " INTEGER NOT NULL);";

    public static final String DROP_TABLE = "drop table if exists " + TABELA_NOME + ";";

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getCusto() {
        return custo;
    }

    public void setCusto(float custo) {
        this.custo = custo;
    }

    public int getTotalDeNoites() {
        return totalDeNoites;
    }

    public void setTotalDeNoites(int totalDeNoites) {
        this.totalDeNoites = totalDeNoites;
    }

    public int getViagemId() {
        return viagemId;
    }

    public void setViagemId(int viagemId) {
        this.viagemId = viagemId;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
