package org.example.entities;

import org.example.utils.CalculaExpressao;

import java.util.Scanner;

public class Calculadora {
    private Historico historico;


    public Calculadora(boolean temHistorico) {
        this.historico = new Historico(temHistorico);
    }


    public void calcularExpressao() {
        Scanner in = new Scanner(System.in);

        System.out.print("Digite o cálculo ou expressão: ");
        String expressao = in.nextLine();

        Calculo calculo = CalculaExpressao.validar(expressao);
        System.out.println(calculo);

        if (this.historicoHabilitado()) {
            this.adicionarItemHistorico(calculo);
        }
    }


    public void exibirHistorico() {
        if (historicoHabilitado()) {
            System.out.println(this.historico);
        } else {
            System.out.println("O histórico está desabilitado");
        }
    }

    public void des_habilitarHistorico() {
        this.historico.des_habilita();

        System.out.println("O histórico foi " + ((this.historicoHabilitado()) ? "habilitado" : "desabilitado"));
    }

    public void limparHistorico() {
        this.historico.limpar();

        System.out.println("Historico vazio!");
    }


    public boolean historicoHabilitado() {
        return this.historico.isHabilitado();
    }

    public void adicionarItemHistorico(Calculo calculo) {
        this.historico.adicionarCalculo(calculo);
    }

    public Historico getHistorico() {
        return historico;
    }

    public void setHistorico(Historico historico) {
        this.historico = historico;
    }

    @Override
    public String toString() {
        return "CALCULADORA:\n" + 
               "-----------------------" +
               "\nHistórico: " + (this.historicoHabilitado() ? "Habilitado" : "Desabilitado");
    }
}
