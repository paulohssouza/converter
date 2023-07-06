package br.com.oracle.model;

import com.google.gson.annotations.SerializedName;

public class CurrencyQuote {

    @SerializedName("code")
    private String code;

    @SerializedName("name")
    private String name;
    @SerializedName("bid")
    private Double bid;

    @SerializedName("ask")
    private Double ask;

    public CurrencyQuote() {
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return this.name;
    }

    public Double getBid() {
        return this.bid;
    }

    public Double getAsk() {
        return this.ask;
    }

    @Override
    public String toString() {
        return (this.name + "   |   Compra: R$ " + this.bid +
                "   |   Venda: R$ " + this.ask);
    }
}
