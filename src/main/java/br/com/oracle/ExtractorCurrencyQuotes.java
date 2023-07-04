package br.com.oracle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtractorCurrencyQuotes {

    public static List<CurrencyQuote> extractorCurrencies() {
        ClientHttp clientHttp = new ClientHttp();
        String json = clientHttp.fetchData("https://economia.awesomeapi.com.br/json/last/");
//        System.out.println(json);
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, CurrencyQuote>>(){}.getType();
        Map<String, CurrencyQuote> currencyQuotes = gson.fromJson(json, type);
        List<CurrencyQuote> currencyQuotesArrayList = new ArrayList<CurrencyQuote>();
        currencyQuotes.forEach((pair, currency) -> {
            currencyQuotesArrayList.add(currency);
        });
        return currencyQuotesArrayList;
    }

}
