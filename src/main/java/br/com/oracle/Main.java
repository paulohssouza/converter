package br.com.oracle;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<CurrencyQuote> currencyQuotes = ExtractorCurrencyQuotes.extractorCurrencies();
        currencyQuotes.forEach(currencyQuote -> {
            System.out.println(currencyQuote.getName());
            System.out.println(currencyQuote.getBid());
        });
    }
}