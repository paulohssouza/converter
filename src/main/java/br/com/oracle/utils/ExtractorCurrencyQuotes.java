package br.com.oracle.utils;

import br.com.oracle.model.CurrencyQuote;
import br.com.oracle.utils.ClientHttp;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtractorCurrencyQuotes {

    public static List<CurrencyQuote> extractorCurrencies() {
        ClientHttp clientHttp = new ClientHttp();
        String json = clientHttp.fetchData("https://economia.awesomeapi.com.br/json/last/");
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, CurrencyQuote>>(){}.getType();
        Map<String, CurrencyQuote> currencyQuotes = gson.fromJson(json, type);
        List<CurrencyQuote> currencyQuotesArrayList = new ArrayList<CurrencyQuote>();
        currencyQuotes.forEach((pair, currency) -> {
            currencyQuotesArrayList.add(currency);
        });
        return currencyQuotesArrayList;
    }

//    public static List<String> extractorCurrenciesToString() {
//        List<String> listToString = new ArrayList<String>();
//        ClientHttp clientHttp = new ClientHttp();
//        String json = clientHttp.fetchData("https://economia.awesomeapi.com.br/json/last/");
//        Gson gson = new Gson();
//        Type type = new TypeToken<Map<String, CurrencyQuote>>(){}.getType();
//        Map<String, CurrencyQuote> currencyQuotes = gson.fromJson(json, type);
//        List<CurrencyQuote> currencyQuotesArrayList = new ArrayList<CurrencyQuote>();
//        currencyQuotes.forEach((pair, currency) -> {
//            currencyQuotesArrayList.add(currency);
//        });
//        currencyQuotesArrayList.forEach(currencyQuote -> {
//            listToString.add(currencyQuote.getCode() + " | Compra: R$ " + currencyQuote.getBid() + " | Venda: R$ " + currencyQuote.getAsk());
//        });
//        return listToString;
//    }

}
