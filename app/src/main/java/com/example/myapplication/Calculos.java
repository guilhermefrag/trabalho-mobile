package com.example.myapplication;

public class Calculos {

    public static double custoTotalGasolina(double totalDeKm, double mediaDeKm, double custoPorLitro, int totalDeVeiculos){
        return ((totalDeKm / mediaDeKm) * custoPorLitro) / totalDeVeiculos;
    }

    public static double custoTotalTarifaAerea(double custoPorPessoa, int totalDeViajantes, double aluguelDeVeiculo){
        return (custoPorPessoa * totalDeViajantes) + aluguelDeVeiculo;
    }

    public static double custoTotalRefeicoes(int refeicoesPorDia, int totalDeViajantes, double custoEstimado, double duracaoViagemDias){
        return ((refeicoesPorDia * totalDeViajantes) + custoEstimado) * duracaoViagemDias;
    }

    public static double custoTotalHospedagem(double custoMedio, int totalDeNoites, int totalDeQuartos){
//        System.out.println("custo"+custoMedio);
//        System.out.println("custo"+totalDeNoites);
//        System.out.println("custo"+totalDeQuartos);
        return (custoMedio * totalDeNoites) * totalDeQuartos;
    }

}
