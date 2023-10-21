package com.example.myapplication.database.model;

public class UsuarioModel {

    public static final String TABELA_NOME = "usuario";

    private long id;
    private String nomeCompleto;
    private String email;
    private int idade;
    private String senha;

    public static final String
            COLUNA_ID = "_id",
            COLUNA_NOME_COMPLETO = "nome_completo",
            COLUNA_EMAIL = "email",
            COLUNA_IDADE = "idade",
            COLUNA_SENHA = "senha";



    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABELA_NOME + " (" +
                    COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUNA_NOME_COMPLETO + " TEXT NOT NULL, " +
                    COLUNA_EMAIL + " TEXT NOT NULL, " +
                    COLUNA_IDADE + " INTEGER, " +
                    COLUNA_SENHA + " TEXT NOT NULL);";





    public static final String DROP_TABLE = "drop table if exists " + TABELA_NOME + ";";

    public void setId (long id){
        this.id = id;
    }

    public long getId (){
        return id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
