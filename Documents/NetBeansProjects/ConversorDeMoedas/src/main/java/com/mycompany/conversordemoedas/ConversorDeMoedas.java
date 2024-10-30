package com.mycompany.conversordemoedas;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;

public class ConversorDeMoedas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        boolean continuar = true;

        while (continuar) {
            System.out.print("Digite o valor em USD que deseja converter: ");
            double valorUSD = scanner.nextDouble();
            
            // Moedas de destino
            String[] moedasDestino = {"BRL", "EUR", "GBP", "CHF", "JPY", "AUD"};
            
            System.out.println("Escolha a moeda de destino:");
            for (int i = 0; i < moedasDestino.length; i++) {
                System.out.printf("%d: %s%n", i + 1, moedasDestino[i]);
            }
            
            System.out.print("Digite o número correspondente à moeda de destino: ");
            int opcao = scanner.nextInt();
            
            if (opcao < 1 || opcao > moedasDestino.length) {
                System.out.println("Opção inválida!");
                continue; // Retorna ao início do loop
            }
            
            String moedaDestino = moedasDestino[opcao - 1];
            
            try {
                double taxa = ConversorDeMoedasAPI.obterTaxaDeCambio("USD", moedaDestino);
                double valorConvertido = valorUSD * taxa;

                // Imprimir taxa e valor convertido
                System.out.printf("Taxa de câmbio USD para %s: %.4f%n", moedaDestino, taxa);
                System.out.printf("Valor em %s: %.2f%n", moedaDestino, valorConvertido);
            } catch (Exception e) {
                System.err.printf("Erro ao obter a taxa de câmbio: %s%n", e.getMessage());
            }

            // Pergunta se o usuário deseja continuar
            System.out.print("Deseja continuar? (s/n): ");
            char resposta = scanner.next().charAt(0);
            continuar = (resposta == 's' || resposta == 'S');
        }

        System.out.println("Obrigado por usar o conversor de moedas!");
        scanner.close();
    }
}