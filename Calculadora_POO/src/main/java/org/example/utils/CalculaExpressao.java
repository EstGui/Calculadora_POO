package org.example.utils;

import java.util.*;

import org.example.entities.Calculo;

public class CalculaExpressao {

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    private static boolean isNumber(char c) {
        return Character.isDigit(c) || c == '.';
    }

    private static int precedencia(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    private static List<String> gerarRPN(String expressao) {
        List<String> rpn = new ArrayList<>();
        Stack<Character> operadores = new Stack<>();
        int i = 0;
        while (i < expressao.length()) {
            char c = expressao.charAt(i);

            if (isNumber(c)) {
                StringBuilder number = new StringBuilder();
                while (i < expressao.length() && (isNumber(expressao.charAt(i)))) {
                    number.append(expressao.charAt(i));
                    i++;
                }
                rpn.add(number.toString());
                continue;
            }

            if (c == '(') {
                operadores.push(c);
            } else if (c == ')') {
                while (!operadores.isEmpty() && operadores.peek() != '(') {
                    rpn.add(String.valueOf(operadores.pop()));
                }
                operadores.pop();
            } else if (isOperator(c)) {
                while (!operadores.isEmpty() && precedencia(operadores.peek()) >= precedencia(c)) {
                    rpn.add(String.valueOf(operadores.pop()));
                }
                operadores.push(c);
            }

            i++;
        }

        while (!operadores.isEmpty()) {
            rpn.add(String.valueOf(operadores.pop()));
        }

        return rpn;
    }

    private static double calcularRPN(List<String> rpn) {
        Stack<Double> pilha = new Stack<>();
        for (String token : rpn) {
            if (token.matches("-?\\d+(\\.\\d+)?")) {
                pilha.push(Double.parseDouble(token));
            } else {
                double b = pilha.pop();
                double a = pilha.pop();
                switch (token) {
                    case "+":
                        pilha.push(a + b);
                        break;
                    case "-":
                        pilha.push(a - b);
                        break;
                    case "*":
                        pilha.push(a * b);
                        break;
                    case "/":
                        pilha.push(a / b);
                        break;
                    case "^":
                        pilha.push(Math.pow(a, b));
                        break;
                }
            }
        }
        return pilha.pop();
    }

    public static Calculo validar(String expressao) {
        List<String> rpn = gerarRPN(expressao);
        Calculo calculo = new Calculo(expressao, calcularRPN(rpn));
        
        return calculo;
    }
}
