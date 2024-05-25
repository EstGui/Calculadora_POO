package org.example.entities;

public class Calculo {
    private String expressao;
    private double resultado;

    public Calculo(String expressao, double resultado) {
        this.expressao = expressao;
        this.resultado = resultado;
    }

    public String getExpressao() {
        return expressao;
    }

    public void setExpressao(String expressao) {
        this.expressao = expressao;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return expressao + " = " + resultado;
    }
}
