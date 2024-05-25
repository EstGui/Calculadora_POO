package org.example.entities;

import java.util.Stack;

public class Historico {
    Stack<Calculo> calculos = new Stack<>();
    private boolean habilitado;

    public Historico(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public void adicionarCalculo(Calculo calculo) {
        calculos.add(calculo);
    }

    public void limpar() {
        while (!calculos.isEmpty())
            calculos.pop();
    }

    public Stack<Calculo> getCalculos() {
        return calculos;
    }

    public void setCalculos(Stack<Calculo> calculos) {
        this.calculos = calculos;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void des_habilita() {
        this.habilitado = !habilitado;
    }

    @Override
    public String toString() {
        StringBuilder saida = new StringBuilder();

        if (!calculos.isEmpty()) {
            for (Calculo calculo : calculos) {
                saida.append(calculo + "\n");
            }
        } else {
            saida.append("Histórico vazio");
        }

        return saida.toString();
    }
}
