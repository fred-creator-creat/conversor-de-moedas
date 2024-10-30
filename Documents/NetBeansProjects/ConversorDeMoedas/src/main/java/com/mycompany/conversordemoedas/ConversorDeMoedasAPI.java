package com.mycompany.conversordemoedas;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class ConversorDeMoedasAPI {

    // URL base da API
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/f262e19a0e063766751069fb/latest/";

    /**
     * Obtém a taxa de câmbio entre duas moedas.
     * 
     * @param moedaOrigem Código da moeda de origem (ex: "USD").
     * @param moedaDestino Código da moeda de destino (ex: "BRL").
     * @return A taxa de câmbio como um valor de ponto flutuante.
     * @throws Exception Em caso de falha na requisição ou processamento.
     */
    public static double obterTaxaDeCambio(String moedaOrigem, String moedaDestino) throws Exception {
        String urlString = BASE_URL + moedaOrigem;

        // Configura a URL e abre uma conexão HTTP
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        // Verifica o código de resposta HTTP
        if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException("Falha na conexão: " + conn.getResponseCode());
        }

        // Lê a resposta da API
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            response.append(line);
        }
        in.close();

        // Imprimir a resposta JSON bruta (para debug)
        System.out.println("Resposta da API: " + response.toString());

        // Processa a resposta JSON usando Gson
        Gson gson = new Gson();
        ApiResponse apiResponse = gson.fromJson(response.toString(), ApiResponse.class);

        // Verifica se as taxas de câmbio foram retornadas corretamente
        if (apiResponse.conversion_rates == null || !apiResponse.conversion_rates.containsKey(moedaDestino)) {
            throw new RuntimeException("Taxas de câmbio não disponíveis para " + moedaDestino);
        }

        // Retorna a taxa de câmbio da moeda destino
        return apiResponse.conversion_rates.get(moedaDestino);
    }

    // Classe interna para mapear a resposta JSON
    private static class ApiResponse {
        public String result; // Para verificar o resultado
        public String base;   // A moeda base
        public Map<String, Double> conversion_rates; // Mapeia todas as taxas de câmbio
    }
}