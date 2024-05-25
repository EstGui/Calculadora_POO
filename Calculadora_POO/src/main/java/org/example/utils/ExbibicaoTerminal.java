package org.example.utils;

import java.util.Scanner;

public class ExbibicaoTerminal {
    public static void limparTerminal() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void esperaEntrada() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nTecle Enter para voltar ao menu...");
        in.nextLine();
    }
}
