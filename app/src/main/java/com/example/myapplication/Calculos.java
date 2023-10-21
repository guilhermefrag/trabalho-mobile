package com.example.myapplication;

public class Calculos {

    public static float custoTotalGasolina(float totalDeKm, float mediaDeKm, float custoPorLitro, int totalDeVeiculos){
        return ((totalDeKm / mediaDeKm) * custoPorLitro) / totalDeVeiculos;
    }

    public static float custoTotalTarifaAerea(float custoPorPessoa, int totalDeViajantes, float aluguelDeVeiculo){
        return (custoPorPessoa * totalDeViajantes) + aluguelDeVeiculo;
    }

    public static float custoTotalRefeicoes(int refeicoesPorDia, int totalDeViajantes, float custoEstimado, float duracaoDaViagemEmMinutos){
        return ((refeicoesPorDia * totalDeViajantes) + custoEstimado) * duracaoDaViagemEmMinutos;
    }

    public static float custoTotalHospedagem(float custoMedio, int totalDeNoites, int totalDeQuartos){
        return (custoMedio * totalDeNoites) * totalDeQuartos;
    }

}
