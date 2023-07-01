package br.com.oracle;

import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ClientHttp clientHttp = new ClientHttp();
        String json = clientHttp.fetchData("https://economia.awesomeapi.com.br/json/last/");
        System.out.println(json);
    }
}