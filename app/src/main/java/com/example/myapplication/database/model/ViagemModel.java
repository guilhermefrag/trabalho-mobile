package com.example.myapplication.database.model;

public class ViagemModel {
    public static final String TABELA_NOME = "viagem";

    private long id;
    private String descricao;
    private double totalKm;
    private double kmPorLitro;
    private double custoMedioLitro;
    private int totalVeiculos;
    private double totalGasolina;
    private int adicionarGasolina;
    private double custoTarifaPessoa;
    private double aluguelVeiculo;
    private double totalTarifaAerea;
    private int adicionarTarifaAerea;
    private double custoRefeicao;
    private int refeicoesDia;
    private double totalRefeicoes;
    private int adicionarRefeicoes;
    private double custoNoite;
    private int totalNoites;
    private int totalQuartos;
    private double totalHospedagem;
    private int adicionarHospedagem;
    private int idUsuario;
    private int totalViajantes;
    private int duracaoDias;

    public static final String
            COLUNA_ID = "_id",
            COLUNA_DESCRICAO = "descricao",
            COLUNA_TOTALKM = "total_km",
            COLUNA_KMLITRO = "km_por_litro",
            COLUNA_CUSTO_MEDIO_LITRO = "custo_medio_l",
            COLUNA_TOTAL_VEICULOS = "total_veiculos",
            COLUNA_TOAL_GASONLINA = "total_gassolina",
            COLUNA_ADICIONAR_GASOLINA = "adicionar_gasolina",
            COLUNA_CUSTO_TARIFA_PESSOA = "custo_tarifa_pessoa",
            COLUNA_ALUGUEL_VEICULO = "aluguel_veiculo",
            COLUNA_TOTAL_TARIFA_AEREA = "total_tarifa_aerea",
            COLUNA_ADICIONAR_TARIFA = "adicionar_tarifa_aerea",
            COLUNA_CUSTO_REFEICAO = "custo_refeicao",
            COLUNA_REFEICOES_DIA = "refeicoes_dia",
            COLUNA_TOTAL_REFEICOES = "total_refeicoes",
            COLUNA_ADICIONAR_REFEICOES = "adicionar_refeicoes",
            COLUNA_CUSTO_NOITE = "custo_noite",
            COLUNA_TOTAL_NOITES = "total_noites",
            COLUNA_TOTAL_QUARTOS = "total_quartos",
            COLUNA_TOTAL_HOSPEDAGEM = "total_hospedagem",
            COLUNA_ADICIONAR_HOSPEDAGEM = "adicionar_hospedagem",
            COLUNA_ID_USUARIO = "id_usuario",
            COLUNA_TOTAL_VIAJANTES = "total_viajantes",
            COLUNA_DURACAO_DIAS = "duracao_dias";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABELA_NOME + " (" +
                    COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUNA_DESCRICAO + " TEXT NOT NULL, " +
                    COLUNA_TOTALKM + " REAL, " +
                    COLUNA_KMLITRO + " REAL, " +
                    COLUNA_CUSTO_MEDIO_LITRO + " REAL, " +
                    COLUNA_TOTAL_VEICULOS + " INTEGER, " +
                    COLUNA_TOAL_GASONLINA + " REAL, " +
                    COLUNA_ADICIONAR_GASOLINA + " INTEGER, " +
                    COLUNA_CUSTO_TARIFA_PESSOA + " REAL, " +
                    COLUNA_ALUGUEL_VEICULO + " REAL, " +
                    COLUNA_TOTAL_TARIFA_AEREA + " REAL, " +
                    COLUNA_ADICIONAR_TARIFA + " INTEGER, " +
                    COLUNA_CUSTO_REFEICAO + " REAL, " +
                    COLUNA_REFEICOES_DIA + " INTEGER, " +
                    COLUNA_TOTAL_REFEICOES + " REAL, " +
                    COLUNA_ADICIONAR_REFEICOES + " INTEGER, " +
                    COLUNA_CUSTO_NOITE + " REAL, " +
                    COLUNA_TOTAL_NOITES + " INTEGER, " +
                    COLUNA_TOTAL_QUARTOS + " INTEGER, " +
                    COLUNA_ADICIONAR_HOSPEDAGEM + " INTEGER, " +
                    COLUNA_TOTAL_HOSPEDAGEM + " REAL, " +
                    COLUNA_TOTAL_VIAJANTES + " INTEGER, " +
                    COLUNA_DURACAO_DIAS + " INTEGER, " +
                    COLUNA_ID_USUARIO + " INTEGER);";

    public static final String DROP_TABLE = "drop table if exists " + TABELA_NOME + ";";

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getTotalKm() {
        return totalKm;
    }

    public void setTotalKm(double totalKm) {
        this.totalKm = totalKm;
    }

    public double getKmPorLitro() {
        return kmPorLitro;
    }

    public void setKmPorLitro(double kmPorLitro) {
        this.kmPorLitro = kmPorLitro;
    }

    public double getCustoMedioLitro() {
        return custoMedioLitro;
    }

    public void setCustoMedioLitro(double custoMedioLitro) {
        this.custoMedioLitro = custoMedioLitro;
    }

    public int getTotalVeiculos() {
        return totalVeiculos;
    }

    public void setTotalVeiculos(int totalVeiculos) {
        this.totalVeiculos = totalVeiculos;
    }

    public double getTotalGasolina() {
        return totalGasolina;
    }

    public void setTotalGasolina(double totalGasolina) {
        this.totalGasolina = totalGasolina;
    }

    public int getAdicionarGasolina() {
        return adicionarGasolina;
    }

    public void setAdicionarGasolina(int adicionarGasolina) {
        this.adicionarGasolina = adicionarGasolina;
    }

    public double getCustoTarifaPessoa() {
        return custoTarifaPessoa;
    }

    public void setCustoTarifaPessoa(double custoTarifaPessoa) {
        this.custoTarifaPessoa = custoTarifaPessoa;
    }

    public double getAluguelVeiculo() {
        return aluguelVeiculo;
    }

    public void setAluguelVeiculo(double aluguelVeiculo) {
        this.aluguelVeiculo = aluguelVeiculo;
    }

    public double getTotalTarifaAerea() {
        return totalTarifaAerea;
    }

    public void setTotalTarifaAerea(double totalTarifaAerea) {
        this.totalTarifaAerea = totalTarifaAerea;
    }

    public int getAdicionarTarifaAerea() {
        return adicionarTarifaAerea;
    }

    public void setAdicionarTarifaAerea(int adicionarTarifaAerea) {
        this.adicionarTarifaAerea = adicionarTarifaAerea;
    }

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

    public double getTotalRefeicoes() {
        return totalRefeicoes;
    }

    public void setTotalRefeicoes(double totalRefeicoes) {
        this.totalRefeicoes = totalRefeicoes;
    }

    public int getAdicionarRefeicoes() {
        return adicionarRefeicoes;
    }

    public void setAdicionarRefeicoes(int adicionarRefeicoes) {
        this.adicionarRefeicoes = adicionarRefeicoes;
    }

    public double getCustoNoite() {
        return custoNoite;
    }

    public void setCustoNoite(double custoNoite) {
        this.custoNoite = custoNoite;
    }

    public int getTotalNoites() {
        return totalNoites;
    }

    public void setTotalNoites(int totalNoites) {
        this.totalNoites = totalNoites;
    }

    public int getTotalQuartos() {
        return totalQuartos;
    }

    public void setTotalQuartos(int totalQuartos) {
        this.totalQuartos = totalQuartos;
    }

    public double getTotalHospedagem() {
        return totalHospedagem;
    }

    public void setTotalHospedagem(double totalHospedagem) {
        this.totalHospedagem = totalHospedagem;
    }

    public int getAdicionarHospedagem() {
        return adicionarHospedagem;
    }

    public void setAdicionarHospedagem(int adicionarHospedagem) {
        this.adicionarHospedagem = adicionarHospedagem;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getTotalViajantes() {
        return totalViajantes;
    }

    public void setTotalViajantes(int totalViajantes) {
        this.totalViajantes = totalViajantes;
    }

    public int getDuracaoDias() {
        return duracaoDias;
    }

    public void setDuracaoDias(int duracaoDias) {
        this.duracaoDias = duracaoDias;
    }
}
