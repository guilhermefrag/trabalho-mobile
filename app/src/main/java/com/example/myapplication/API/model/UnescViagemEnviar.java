package com.example.myapplication.API.model;

import java.io.Serializable;
import java.util.List;

public class UnescViagemEnviar implements Serializable {
    private int totalViajantes;

    private int duracaoViagem;

    private double custoTotalViagem;

    private double custoPorPessoa;

    private String local;

    private int idConta;
    private UnescViagemCustoRefeicao refeicao;
    private UnescViagemCustoAereo aereo;
    private UnescViagemCustoGasolina gasolina;
    private UnescViagemCustoHospedagem hospedagem;
    private List<UnescViagemCustoEntretenimento> listaEntretenimento;

    public UnescViagemCustoRefeicao getRefeicao() {
        return refeicao;
    }

    public void setRefeicao(UnescViagemCustoRefeicao refeicao) {
        this.refeicao = refeicao;
    }

    public UnescViagemCustoAereo getAereo() {
        return aereo;
    }

    public void setAereo(UnescViagemCustoAereo aereo) {
        this.aereo = aereo;
    }

    public UnescViagemCustoGasolina getGasolina() {
        return gasolina;
    }

    public void setGasolina(UnescViagemCustoGasolina gasolina) {
        this.gasolina = gasolina;
    }

    public UnescViagemCustoHospedagem getHospedagem() {
        return hospedagem;
    }

    public void setHospedagem(UnescViagemCustoHospedagem hospedagem) {
        this.hospedagem = hospedagem;
    }

    public List<UnescViagemCustoEntretenimento> getListaEntretenimento() {
        return listaEntretenimento;
    }

    public void setListaEntretenimento(List<UnescViagemCustoEntretenimento> listaEntretenimento) {
        this.listaEntretenimento = listaEntretenimento;
    }

    public int getTotalViajantes() {
        return totalViajantes;
    }

    public void setTotalViajantes(int totalViajantes) {
        this.totalViajantes = totalViajantes;
    }

    public int getDuracaoViagem() {
        return duracaoViagem;
    }

    public void setDuracaoViagem(int duracaoViagem) {
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

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }
}
