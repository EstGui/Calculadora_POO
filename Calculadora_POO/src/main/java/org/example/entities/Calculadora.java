package org.example.entities;

public class Calculadora {
    private boolean processo, historico;

    public Calculadora(boolean processo, boolean historico) {
        this.processo = processo;
        this.historico = historico;
    }

    public double solucaoEx(){
        double resultado = 0;
        return resultado;
    }

    public double soma(double a, double b) {
        return a + b;
    }

    public double subtracao(double a, double b) {
        return a - b;
    }

    public double divisao(double a, double b) {
        return a / b;
    }

    public double multiplicacao(double a, double b) {
        return a * b;
    }
}
