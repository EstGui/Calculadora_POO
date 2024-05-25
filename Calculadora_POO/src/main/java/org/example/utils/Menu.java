package org.example.utils;

import java.util.Scanner;

import org.example.entities.Calculadora;

public class Menu {
    public static void iniciar() {
        ExbibicaoTerminal.limparTerminal();
        Scanner in = new Scanner(System.in);
        
        System.out.print("Deseja armazenar os cálculos no histórico?\n" + 
                         "[0] - Não\n[1] - Sim\n" +
                         "\nIndique a opção: ");
        boolean historico = (in.nextLine().equals("1")) ? true : false;

        Calculadora calculadora = new Calculadora(historico);

        ExbibicaoTerminal.limparTerminal();
        
        obterEntradas(calculadora);
    }

    public static void obterEntradas(Calculadora calculadora) {
        while (true) {
            Scanner in = new Scanner(System.in);
            String opcao = mostrarMenuPrincipal();

            switch (opcao) {
                case "1":
                    calculadora.calcularExpressao();
                    break;

                case "2":
                    calculadora.exibirHistorico();
                    break;

                case "3":
                    calculadora.des_habilitarHistorico();
                    break;

                case "4":
                    calculadora.limparHistorico();
                    break;

                case "5":
                    System.out.println(calculadora);
                    break;
            
                case "0":
                    break;

                default:
                    mostrarMenuPrincipal();
            }

            ExbibicaoTerminal.esperaEntrada();
            ExbibicaoTerminal.limparTerminal();
        }
    }

    public static String mostrarMenuPrincipal() {
        Scanner in = new Scanner(System.in);
        System.out.print("[1] - Realizar cálculo de expressão\n" +
                        "[2] - Exibir histórico\n" +
                        "[3] - Habilitar/Desabilitar histórico\n" +
                        "[4] - Limpar histórico\n" +
                        "[5] - Exibir informações da calculadora\n" +
                        "\n[0] - Sair\n" +
                        "\nSelecione a opção: ");
        String opcao = in.nextLine();

        ExbibicaoTerminal.limparTerminal();

        return opcao;
    }
}
