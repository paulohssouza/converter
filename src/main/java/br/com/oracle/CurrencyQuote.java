package br.com.oracle;

import com.google.gson.annotations.SerializedName;

public class CurrencyQuote {

    @SerializedName("name")
    private String name;
    @SerializedName("bid")
    private Double bid;

    @SerializedName("ask")
    private Double ask;

    public CurrencyQuote() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setBid(Double bid) {
        this.bid = bid;
    }

    public Double getBid() {
        return this.bid;
    }

    public Double getAsk() {
        return this.ask;
    }
}
