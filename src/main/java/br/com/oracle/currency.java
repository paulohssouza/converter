package br.com.oracle;

import java.math.BigDecimal;

public class currency {

    private final String name;
    private final BigDecimal bidValue;

    public currency(String name, BigDecimal bidValue) {
        this.name = name;
        this.bidValue = bidValue;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getBidValue() {
        return this.bidValue;
    }
}
