package org.example;

import org.example.entities.Calculadora;
import org.example.utils.Menu;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Calculadora calculadora = new Calculadora(true, true);

        menu.exibir();

    }
}